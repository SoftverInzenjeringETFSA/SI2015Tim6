package ba.etf.unsa.si.pos_kasa.controller;

import ba.etf.unsa.si.pos_kasa.model.*;
import ba.etf.unsa.si.pos_kasa.view.*;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Tools.HibernateUtil;

@SuppressWarnings("unused")

public class RacunKontroler {
 
	private static Session session;
  
	public static void main(String[] args)
	{
	}
	
	public static Long dodajStavku(long _id, int _kolicina, double _ukupna_cijena, long _artikal_id)
	{
	 
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		StavkaRacuna sr = new StavkaRacuna();
		
		sr.setId(_id);
		sr.setKolicina(_kolicina);
		sr.setUkupna_cijena(_ukupna_cijena);
		sr.setArtikal_id(_artikal_id);
		
		Long id = (Long) session.save(sr);
		t.commit();
		session.close();
		return id;
	}
	public static void ukloniStavku(long _id)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		StavkaRacuna sr = new StavkaRacuna();
		
		  if(sr.getId() == _id)
			
		  {
			session.delete(sr);
			t.commit();
		  }
		
		else
		{
			System.out.println("Ne postoji ta stavka");
		}
		
		session.close();
	}
	
	public static Long dodajNacinPlacanja(long _id, double _iznos, long _vrsteplacanja_id, long _racun_id)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		 NacinPlacanja np = new NacinPlacanja();
		 
		 np.setId(_id);
		 np.setIznos(_iznos);
		 np.setVrstaplacanja_id(_vrsteplacanja_id);
		 np.setRacun_id(_racun_id);
		 
		 Long id = (Long) session.save(np);
		 t.commit(); 
		 session.close();
		 return id;
	}
	
	public static List<?> vratiSveRacune()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql = "select * from tim6.racun";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Racun.class);	
		List<?> results = query.list();
		session.close();
		return results;	
	}
	
	public static Racun pretraziRacunePoDatumu(Date _datum)throws Exception
	{
	     session = HibernateUtil.getSessionFactory().openSession();
	     Transaction t=session.beginTransaction(); 
    	 Racun _racun = new Racun();
    	     
    	     if( _racun.getDatum_i_vrijeme() == _datum)
    		 
    	    	 return _racun;
    	     
    	     else 
    	    	 
    	    	 throw new Exception("Pretraživanje nije uspjelo.");
    	    
	}
	
}

