package ba.etf.unsa.si.pos_kasa.controller;

import ba.etf.unsa.si.pos_kasa.model.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import org.hibernate.Transaction;
import org.hibernate.Session;
import java.util.List; 
import java.util.Iterator; 
 
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import Tools.HibernateUtil;

import org.hibernate.criterion.Projections;
import org.hibernate.cfg.Configuration;
public class Izvjestaji {

	public static void main(String[] args) {
    }
    
    private static List<StavkaRacuna> dajStavkeRacunaOdDo(Date date1, Date date2){
        Session session = HibernateUtil.getSessionFactory().openSession(); //otvaranje sesije, obavezno na pocetku metodeu
        

		String hql = "Select new ba.etf.unsa.si.pos_kasa.model.StavkaRacuna(sr.id, sr.kolicina, sr.ukupna_cijena, sr.artikal_id) "
				+ "FROM Racun r, StavkaRacuna sr "
				+ "WHERE r.datum_i_vrijeme BETWEEN STR_TO_DATE(:datum1, \'%Y-%m-%d\') AND STR_TO_DATE(:datum2, \'%Y-%m-%d\') AND sr.racun_id = r.id";
		Query q = session.createQuery(hql);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		q.setString("datum1",		df.format(date1));
		q.setString("datum2", 		df.format(date2));
		List redovi = q.list();
        session.close(); //zatvaranje konekcije, obavezno na kraju metode
        return redovi;
    }
    
    public static double[] dajUkupanPrometIprodateArtikleOdDo(Date date1, Date date2){
    	double[] returnValues = new double[2]; // 0-ukupno artikala, 1-ukupan promet u KM
    	double ukupnoKm = 0;
    	int ukupnoProdato = 0;
    	for(StavkaRacuna sr : dajStavkeRacunaOdDo(date1 , date2))
    	{
    		ukupnoKm += sr.getUkupna_cijena();
    		ukupnoProdato += sr.getKolicina();
    	}
    	returnValues[0] = ukupnoProdato;
    	returnValues[1] = ukupnoKm;
		return returnValues;
    }
    
    private static void dodajKategoriju(Session session) {
    	Transaction t = session.beginTransaction();
    	Kategorija s = new Kategorija();
    	s.setNaziv("fina kategorija");
    	s.setOpis("jos ljepsi opis");
    	Long id = (Long) session.save(s);
    	System.out.println("Dodan racun sa IDom "+id);
    	t.commit();
    	}
}
