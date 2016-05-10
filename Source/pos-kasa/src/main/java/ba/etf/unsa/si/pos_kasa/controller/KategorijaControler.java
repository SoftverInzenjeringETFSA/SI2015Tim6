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

@SuppressWarnings("unused")
public class KategorijaControler {

	private static Session session;

	public static void main(String[] args){
		session = HibernateUtil.getSessionFactory().openSession();
		session.close();
	}

	public static void dodajKategoriju(String ime, String opis) {
		Transaction t = session.beginTransaction();
		Kategorija kat = new Kategorija();
		kat.setNaziv(ime);
		kat.setOpis(opis);
		Long id = (Long) session.save(kat);
		t.commit();

	}

	public static boolean obrisiKategoriju(Long id)
	{   
		Transaction t= session.beginTransaction();
    	Kategorija kat=(Kategorija)session.get(Kategorija.class,id);
		if(kat==null)
		{
			return false;
		}
		else {
			session.delete(kat);
			t.commit();
			return true;
		}
	}

	public static boolean modificirajKategoriju(Long id, String ime, String opis)
	{
		Transaction t= session.beginTransaction();
		Kategorija kat=(Kategorija)session.get(Kategorija.class,id);
		if(kat==null)
		{
			return false;
		}
		else {
			kat.setNaziv(ime);
			kat.setOpis(opis);
			session.update(kat);
			t.commit();
			return true;
		}		
	}	
	public static boolean modificirajImeKategorije(Long id, String ime)
	{
		Transaction t= session.beginTransaction();
		Kategorija kat=(Kategorija)session.get(Kategorija.class,id);
		if(kat==null)
		{
			return false;
		}
		else {
			
			kat.setNaziv(ime);
			session.update(kat);
			t.commit();
			return true;
		}		
	}	
	public static boolean modificirajOpisKategorije(Long id, String opis)
	{
		Transaction t= session.beginTransaction();
		Kategorija kat=(Kategorija)session.get(Kategorija.class,id);
		if(kat==null)
		{
			return false;
		}
		else {
			kat.setOpis(opis);
			session.update(kat);
			t.commit();
			return true;
		}		
	}
	public static Kategorija pronadjiKategorijuPoID(Long id) throws Exception
	{
		Kategorija kat=new Kategorija();
		Transaction t=session.beginTransaction();
		kat=(Kategorija)session.get(Kategorija.class,id);
		if(kat==null)
		{
			throw new Exception("Trazena kategorija ne postoji!");
		}
		else{
			return kat;
		}
	}
	public static List<?> vratiSveKategorije()
	{
		String sql = "select * from tim6.kategorija";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Kategorija.class);
		
		List<?> results = query.list();
		System.out.println(results.size());
		return results;
		
	}
}
