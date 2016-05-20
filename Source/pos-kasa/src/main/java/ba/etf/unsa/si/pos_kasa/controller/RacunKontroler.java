package ba.etf.unsa.si.pos_kasa.controller;

import ba.etf.unsa.si.pos_kasa.model.*;
import ba.etf.unsa.si.pos_kasa.view.*;

import java.text.SimpleDateFormat;
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
	
	public long kreirajRacun(long smjena_id, String nacinPlacanja, DefaultTableModel model)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Racun racun = new Racun();
		racun.setDatum_i_vrijeme(new Date());
		racun.setSmjena_id(smjena_id);
		racun.setBroj_racuna((int) (new Date().getTime()/1000));
		AkcijaPopust ap = this.dajAktivniPopust();
		if(ap != null) racun.setAkcijapopust_id(ap.getId());
		Long id = (Long) session.save(racun);
		t.commit();
		session.close();
		double ukupno = kreirajStavkeRacuna(model, id);
		if(ap != null)
			kreirajNacinPlacanja(nacinPlacanja, ukupno -ap.getIznos_popusta()*ukupno, id);
		else
			kreirajNacinPlacanja(nacinPlacanja, ukupno , id);
		return id;
	}
	
		
	private AkcijaPopust dajAktivniPopust(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		String hql = "Select new ba.etf.unsa.si.pos_kasa.model.AkcijaPopust(a.id, a.datum_pocetka, a.datum_kraja, a.opis, a.iznos_popusta) "
				+ "FROM AkcijaPopust a "
				+ "WHERE a.datum_kraja > STR_TO_DATE(:datum1, \'%Y-%m-%d\')";
		Query q = session.createQuery(hql);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		q.setString("datum1",		df.format(new Date()));
		List redovi = q.list();
		if(redovi.size() > 0) return (AkcijaPopust) redovi.get(0);
		return null;
	}
	
	
	public double kreirajStavkeRacuna(DefaultTableModel model, long racun_id){
		double iznos = 0.0;
		for (int count = 0; count < model.getRowCount(); count++){
				  iznos += this.kreirajStavkuRacuna(model.getValueAt(count, 0).toString(), Integer.parseInt(model.getValueAt(count, 2).toString()), racun_id);
				} 
		return iznos;
	}
	
	private double kreirajStavkuRacuna(String barKod, int kolicina, long racun_id){
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
		return sr.getUkupna_cijena();
	}
	
	private void kreirajNacinPlacanja(String nacinPlacanja, double iznos, long racun_id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		NacinPlacanja np = new NacinPlacanja();
		np.setIznos(iznos);
		np.setRacun_id(racun_id);
		np.setVrstaplacanja_id(nacinPlacanja);
		Long id = (Long) session.save(np);
		t.commit();
		session.close();
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

