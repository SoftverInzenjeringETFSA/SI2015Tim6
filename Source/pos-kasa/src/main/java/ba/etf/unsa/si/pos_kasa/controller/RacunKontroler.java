package ba.etf.unsa.si.pos_kasa.controller;

import ba.etf.unsa.si.pos_kasa.model.*;
import java.util.Date;

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
	
	public static void ispisiSveRacune()
	{
		
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
	
	//Dodaje racun u listu racuna
	public static void dodajRacun()
	{
	  
	}
}

