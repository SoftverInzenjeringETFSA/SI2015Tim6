package ba.etf.unsa.si.pos_kasa.controller;

import ba.etf.unsa.si.pos_kasa.model.*;
import ba.etf.unsa.si.pos_kasa.view.*;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Tools.HibernateUtil;


public class RacunKontroler {
 
	private static Session session;
  
	public static void main(String[] args)
	{
	}
	
	public static void dodajStavku (StavkaRacuna stavka)
	{
	
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		StavkaRacuna sr = new StavkaRacuna();
		
		//Fali jos stavki, bice dodano kada se dodaju sve klase
		sr.setId(stavka.getId());
		sr.setKolicina(stavka.getKolicina());
		sr.setUkupna_cijena(stavka.getUkupna_cijena());
		Long id = (Long) session.save(sr);
		t.commit();
		session.close();
	}
	public static void ukloniStavku(StavkaRacuna stavka)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		StavkaRacuna sr = new StavkaRacuna();
		
		  if(sr.getId() == stavka.getId())
			
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
	
	public static void dodajNacinPlacanja(NacinPlacanja nacin)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		 NacinPlacanja np = new NacinPlacanja();
		 
		 np.setVrstaplacanja_id(nacin.getId());
		 Long id = (Long) session.save(np);
		 t.commit(); 
		 session.close();
	}
	
/*	public static Racun ispisiSveRacune(long id)throws Exception
	{
	//
		session = HibernateUtil.getSessionFactory().openSession();
	     Transaction t=session.beginTransaction(); 
	     
	     String hql = "Select new ba.etf.unsa.si.pos_kasa.model.StavkaRacuna(r.id, r.datum_i_vrijeme, r.akcijaPopust_id, r.broj_racuna) "
					+ "FROM Racun r";
					
			Query q = session.createQuery(hql);
			q.setLong("id", id);
			List l = q.list();
			t.commit();
			if(l.isEmpty())
			{
				throw new Exception("Racun nije pronađen");
			}
			Racun _racun = (Racun) l.get(0);
			return _racun;
	
	}
	*/
	
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

