package ba.etf.unsa.si.pos_kasa.controller;

import Tools.HibernateUtil;
import ba.etf.unsa.si.pos_kasa.model.*;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import org.hibernate.Transaction;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.apache.log4j.Logger;

@SuppressWarnings("unused")
public class KategorijaControler {

	private static Session session;

	public static void main(String[] args){
		
	}

	public static Long dodajKategoriju(String ime, String opis) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Kategorija kat = new Kategorija();
		kat.setNaziv(ime);
		kat.setOpis(opis);
		Long id = (Long) session.save(kat);
		t.commit();
		session.close();
		return id;

	}

	public static boolean obrisiKategoriju(Long id)
	{   Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t= session.beginTransaction();
    	Kategorija kat=(Kategorija)session.get(Kategorija.class,id);
		if(kat==null)
		{
			session.close();
			return false;
		}
		else {
			session.delete(kat);
			t.commit();
			session.close();
			return true;
		}
		
	}

	public static boolean modificirajKategoriju(Long id, String ime, String opis)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t= session.beginTransaction();
		Kategorija kat=(Kategorija)session.get(Kategorija.class,id);
		if(kat==null)
		{
			session.close();
			return false;
		}
		else {
			kat.setNaziv(ime);
			kat.setOpis(opis);
			session.update(kat);
			t.commit();
			session.close();
			return true;
		}
		

	}	
	public static boolean modificirajImeKategorije(Long id, String ime)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t= session.beginTransaction();
		Kategorija kat=(Kategorija)session.get(Kategorija.class,id);
		if(kat==null)
		{
			session.close();
			return false;
		}
		else {
			
			kat.setNaziv(ime);
			session.update(kat);
			t.commit();
			session.close();
			return true;
		}
		

	}	
	public static boolean modificirajOpisKategorije(Long id, String opis)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t= session.beginTransaction();
		Kategorija kat=(Kategorija)session.get(Kategorija.class,id);
		if(kat==null)
		{
			session.close();
			return false;
		}
		else {
			
			kat.setOpis(opis);
			session.update(kat);
			t.commit();
			session.close();
			return true;
		}
		

	}
	public static Kategorija pronadjiKategorijuPoID(Long id) throws Exception
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Kategorija kat=new Kategorija();
		Transaction t=session.beginTransaction();
		kat=(Kategorija)session.get(Kategorija.class,id);
		if(kat==null)
		{
			session.close();
			throw new Exception("Trazena kategorija ne postoji!");
		}
		else{
			session.close();
			return kat;
		}
		

	}
	public static List<?> vratiSveKategorije()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql = "select * from tim6.kategorija";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Kategorija.class);	
		List<?> results = query.list();
		session.close();
		return results;
		
	}
	public static List<String> vratiSvaImenaKategorije()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql = "select * from tim6.kategorija";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Kategorija.class);	
		List<Kategorija> results = query.list();
		List<String> rezultati=new Vector<String>();
		for (int i=0;i<results.size();i++)
		{
			rezultati.add(results.get(i).getId()+";;"+results.get(i).getNaziv());
		}
		session.close();
		return rezultati;
	}
	//UPIT
	public static List<String> vratiId(String id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql = "select id from tim6.kategorija";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Kategorija.class);	
		List<Kategorija> results = query.list();
		
		List<String> rezultati=new Vector<String>();
		for (int i=0;i<results.size();i++)
		{
			rezultati.add(results.get(i).getId()+";;"+results.get(i).getNaziv());
		}
		session.close();
		return rezultati;
	}
	
	public String[] vratiRazdovojeno(String str)
	{
		String[] novo=str.split(";;");
		return novo;
	}
	public String[] vrati(String str)
	{
		String[] novo=str.split(" ");
		return novo;
	}
	
	public static boolean provjeriDaLiImaIme(String ime)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql = "select * from tim6.kategorija where naziv= "+ "\"" +ime+"\"";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Kategorija.class);	
		List<Kategorija> results = query.list();
		if(results.size()==0)
		{
			session.close();
			return true;
		}
		else{
			session.close();
			return false;
		}
		
	}
	
}
