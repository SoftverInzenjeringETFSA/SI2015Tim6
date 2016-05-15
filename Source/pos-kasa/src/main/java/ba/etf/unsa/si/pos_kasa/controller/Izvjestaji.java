package ba.etf.unsa.si.pos_kasa.controller;

import ba.etf.unsa.si.pos_kasa.model.*;
import viewmodel.ArtikalProdatoStatistika;

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
    
    private static double[] obracunajPoNacinuPlacanjaUkupanIznos(List<NacinPlacanja> records)
    {
    	double[] ukupno = new double[]{0,0,0,0}; // gotovina, kartica, ček, virman
    	for(NacinPlacanja np : records)
    	{
    		ukupno[(int)np.getVrstaplacanja_id()-1] += np.getIznos();
    	}
    	return ukupno;
    }
    
    public static double[] dajUkupanPrometPoVrstiPlacanjaOdDo(Date date1, Date date2)
    {
        Session session = HibernateUtil.getSessionFactory().openSession(); //otvaranje sesije, obavezno na pocetku metodeu
		String hql = "Select new ba.etf.unsa.si.pos_kasa.model.NacinPlacanja(np.id, np.iznos, np.vrstaplacanja_id, np.racun_id) "
				+ "FROM Racun r, NacinPlacanja np "
				+ "WHERE r.datum_i_vrijeme BETWEEN STR_TO_DATE(:datum1, \'%Y-%m-%d\') AND STR_TO_DATE(:datum2, \'%Y-%m-%d\') AND np.racun_id = r.id";
		Query q = session.createQuery(hql);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		q.setString("datum1",		df.format(date1));
		q.setString("datum2", 		df.format(date2));
		List<NacinPlacanja> redovi = q.list();
        session.close(); //zatvaranje konekcije, obavezno na kraju metode
    	return obracunajPoNacinuPlacanjaUkupanIznos(redovi);    	
    }
    
    public static String dajImePrezimeUposlenika(String jmbg) throws Exception
    {
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        String hq = "Select new ba.etf.unsa.si.pos_kasa.model.Uposlenik(id, imePrezime, datumRodjenja, jmbg, brojTelefona) "
        		+ "FROM Uposlenik "
        		+ "WHERE jmbg = :jmbg";
        Query q = session.createQuery(hq);
        q.setString("jmbg", jmbg);
        List<Uposlenik> up = q.list();
        if(up.size() == 0) throw new Exception("Ne postoji korisnik sa datim JMBG.");
        session.close();
        return up.get(0).getImePrezime();
    }
    
    public static double[] dajUkupanPrometPoUposlenikuOdDo(String jmbg, Date date1, Date date2) throws Exception
    {
        Session session = HibernateUtil.getSessionFactory().openSession(); //otvaranje sesije, obavezno na pocetku metodeu
		String hql_ = "Select new ba.etf.unsa.si.pos_kasa.model.StavkaRacuna(sr.id, sr.kolicina, sr.ukupna_cijena, sr.artikal_id) "
				+ "FROM Uposlenik u, Racun r, StavkaRacuna sr, Smjena s"
				+ " WHERE u.jmbg = :jmbg AND s.uposlenik_id = u.id AND r.smjena_id = s.id AND sr.racun_id = r.id AND r.datum_i_vrijeme BETWEEN STR_TO_DATE(:datum1, \'%Y-%m-%d\') AND STR_TO_DATE(:datum2, \'%Y-%m-%d\')";
		Query q2 = session.createQuery(hql_);
		q2.setString("jmbg", jmbg);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		q2.setString("datum1",		df.format(date1));
		q2.setString("datum2", 		df.format(date2));
		List<StavkaRacuna> stavke = q2.list();
		if(stavke.isEmpty()) throw new Exception("Ne postoje registrovani podaci u skladu sa traženim kriterijem.");
		double ukupanPromet = 0;
		double ukupnoProdato = 0;
		for( StavkaRacuna sr : stavke)
		{
			ukupanPromet += sr.getUkupna_cijena();
			ukupnoProdato += sr.getKolicina();
		}
        session.close(); //zatvaranje konekcije, obavezno na kraju metode
		return new double[]{ ukupanPromet, ukupnoProdato };
    }
    
    public static ArtikalProdatoStatistika dajUkupnoProdatoPoArtikluOdDo(String barKod, Date date1, Date date2) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	String hq0 = "Select new ba.etf.unsa.si.pos_kasa.model.Artikal(id,naziv, barkod, jedinica_mjere, cijena, zalihe_stanje, opis, kategorija_id) "
    			+ "FROM Artikal WHERE barkod = :bkod";
    	Query q0 = session.createQuery(hq0);
    	q0.setString("bkod", barKod);
    	q0.setMaxResults(1);
    	List<Artikal> artikal = q0.list();
    	ArtikalProdatoStatistika aps = new ArtikalProdatoStatistika();
    	aps.jedinicnaCijena = artikal.get(0).getCijena();
    	aps.sifraArtikla = barKod;
    	aps.nazivArtikla = artikal.get(0).getNaziv();
       	String hql = "Select new ba.etf.unsa.si.pos_kasa.model.StavkaRacuna(sr.id, sr.kolicina, sr.ukupna_cijena, sr.artikal_id) "
    	+ "FROM Racun r, StavkaRacuna sr "
    	+ "WHERE r.id = sr.racun_id AND r.datum_i_vrijeme BETWEEN STR_TO_DATE(:datum1, \'%Y-%m-%d\') AND STR_TO_DATE(:datum2, \'%Y-%m-%d\') AND artikal_id = :aid";
       	q0 = session.createQuery(hql);
       	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
       	q0.setString("datum1",		df.format(date1));
       	q0.setString("datum2", 		df.format(date2));
       	q0.setLong("aid", artikal.get(0).getId());
       	List<StavkaRacuna> stavke = q0.list();
       	double ukupnoKm = 0;
       	int ukupnoProdato = 0;
       	for(StavkaRacuna sr : stavke)
       	{
       		ukupnoKm += sr.getUkupna_cijena();
       		ukupnoProdato += sr.getKolicina();
       	}
       	aps.ukupnaVrijednost = ukupnoKm;
       	aps.ukupnoProdato = ukupnoProdato;
    	session.close();
    	return aps;
    }
}
