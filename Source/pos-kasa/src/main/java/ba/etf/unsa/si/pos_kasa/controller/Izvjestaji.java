package ba.etf.unsa.si.pos_kasa.controller;

import ba.etf.unsa.si.pos_kasa.model.*;

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
        System.out.println("Hello World!"); // Display the string.
        for(StavkaRacuna srac : dajRacuneOdDo(java.sql.Date.valueOf("2016-01-12") , java.sql.Date.valueOf("2016-01-22") ))
        {
        	System.out.println(srac.getUkupna_cijena());
        }
    }
    
    private static List<StavkaRacuna> dajRacuneOdDo(Date date1, Date date2){
        Session session = HibernateUtil.getSessionFactory().openSession(); //otvaranje sesije, obavezno na pocetku metodeu
        

		String hql = "Select new ba.etf.unsa.si.pos_kasa.model.StavkaRacuna(sr.id, sr.kolicina, sr.ukupna_cijena, sr.artikal_id) "
				+ "FROM Racun r, StavkaRacuna sr "
				+ "WHERE r.datum_i_vrijeme BETWEEN STR_TO_DATE(:datum1, \'%Y-%m-%d\') AND STR_TO_DATE(:datum2, \'%Y-%m-%d\') AND sr.racun_id = r.id";
		Query q = session.createQuery(hql);
		q.setString("datum1", date1.toString());
		q.setString("datum2", date2.toString());
		List redovi = q.list();
        session.close(); //zatvaranje konekcije, obavezno na kraju metode
        return redovi;
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
