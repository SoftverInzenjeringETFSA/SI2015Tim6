package ba.etf.unsa.si.pos_kasa.controller;

import ba.etf.unsa.si.pos_kasa.model.*;
import ba.etf.unsa.si.pos_kasa.view.*;

import java.util.*;

import javax.swing.table.DefaultTableModel;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import Tools.HibernateUtil;

@SuppressWarnings("unused")

public class RacunKontroler {
 
	//private static Session session;
  
	public static void main(String[] args)
	{
	}
	
	
	public static Long dodajStavku(StavkaRacuna stavkaRac, long racun_id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		stavkaRac.setRacun_id(racun_id);
		Long id = (Long) session.save(stavkaRac);
		t.commit();
		session.close();
		return id;
	}
	
	public static void ukloniStavku(long _id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
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
	
	public static Long dodajNacinPlacanja(NacinPlacanja np, long racun_id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		np.setRacun_id(racun_id);
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
	     Session session = HibernateUtil.getSessionFactory().openSession();
	     Transaction t=session.beginTransaction(); 
    	 Racun _racun = new Racun();
    	     
    	     if( _racun.getDatum_i_vrijeme() == _datum)
     	    	 return _racun;
    	     else 
    	    	 throw new Exception("Pretraživanje nije uspjelo.");
    	    
	}
	
	public long kreirajRacun(long smjena_id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Racun racun = new Racun();
		racun.setDatum_i_vrijeme(new Date());
		Long id = (Long) session.save(racun);
		t.commit();
		session.close();
		return id;
	}
	
	public void kreirajStavkeRacuna(DefaultTableModel model, long racun_id){
	for (int count = 0; count < model.getRowCount(); count++){
			  this.kreirajStavkuRacuna(model.getValueAt(count, 0).toString(), Integer.parseInt(model.getValueAt(count, 2).toString()), racun_id);
			} 
	}
	
	private long kreirajStavkuRacuna(String barKod, int kolicina, long racun_id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		StavkaRacuna sr = new StavkaRacuna();
		Artikal art = this.dajArtikal(barKod);
		this.umanjiStanjeArtikla(art, kolicina);
		sr.setArtikal_id(art.getId());
		sr.setKolicina(kolicina);
		sr.setRacun_id(racun_id);
		sr.setUkupna_cijena(kolicina * art.getCijena());
		Long id = (Long) session.save(sr);
		t.commit();
		session.close();
		return id;
	}
	
	private void umanjiStanjeArtikla(Artikal artikal, int kolicina){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		artikal.setZalihe_stanje((int) (artikal.getZalihe_stanje() - kolicina));
		session.update(artikal);
		t.commit();
		session.close();
	}
	
	public Artikal dajArtikal(String barKod) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria crit = session.createCriteria(Artikal.class);
		crit.add(Restrictions.eq("barkod", barKod));
		List list = crit.list();
		Iterator itr = list.iterator();
		Artikal art = null;
		while (itr.hasNext()) {
		art = (Artikal) itr.next();}
		session.close();
		return art;
	}
	
}

