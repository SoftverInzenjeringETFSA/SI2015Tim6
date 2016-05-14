package ba.etf.unsa.si.pos_kasa.controller;
import Tools.HibernateUtil;
import ba.etf.unsa.si.pos_kasa.model.*;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Vector;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

	@SuppressWarnings("unused")
	public class ArtikalKontroler {

		private static Session session;

		public static void main(String[] args){
			
		}

		public static Long dodajArtikal(String naziv, double cijena, String jedinica_mjere, String barkod,int zalihe_stanje,String opis,long kategorija_id)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Artikal a = new Artikal();
			a.setNaziv(naziv);
			a.setCijena(cijena);
			a.setJedinica_mjere(jedinica_mjere);
			a.setBarkod(barkod);
			a.setZalihe_stanje(zalihe_stanje);
			a.setKategorija_id(kategorija_id);
			Long id = (Long) session.save(a);
			System.out.println(id);
			t.commit();
			session.close();
			return a.getId();

		}

		public static boolean obrisiArtikal(Long id)
		{   Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t= session.beginTransaction();
	    	Artikal a=(Artikal)session.get(Artikal.class,id);
			if(a==null)
			{
				session.close();
				return false;
			}
			else {
				session.delete(a);
				t.commit();
				session.close();
				return true;
			}
			
		}

		public static boolean modificirajArtikal(Long id,String naziv, double cijena, String jedinica_mjere, String barkod,int zalihe_stanje,String opis,long kategorija_id)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t= session.beginTransaction();
			Artikal a=(Artikal)session.get(Artikal.class,id);
			if(a==null)
			{
				session.close();
				return false;
			}
			else {
				a.setNaziv(naziv);
				a.setCijena(cijena);
				a.setJedinica_mjere(jedinica_mjere);
				a.setBarkod(barkod);
				
				session.update(a);
				t.commit();
				session.close();
				return true;
			}
			

		}	
		public static boolean modificirajNazivArtikla(Long id, String naziv)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t= session.beginTransaction();
			Artikal a=(Artikal)session.get(Artikal.class,id);
			if(a==null)
			{
				session.close();
				return false;
			}
			else {
				
				a.setNaziv(naziv);
				session.update(a);
				t.commit();
				session.close();
				return true;
			}
			

		}	
		
		public static boolean modificirajCijenuArtikla(Long id, double cijena)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t= session.beginTransaction();
			Artikal a=(Artikal)session.get(Artikal.class,id);
			if(a==null)
			{
				session.close();
				return false;
			}
			else {
				
				a.setCijena(cijena);
				session.update(a);
				t.commit();
				session.close();
				return true;
			}

	}
		
		public static boolean modificirajJedinicuMjere(Long id, String jedinica_mjere)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t= session.beginTransaction();
			Artikal a=(Artikal)session.get(Artikal.class,id);
			if(a==null)
			{
				session.close();
				return false;
			}
			else {
				
				a.setJedinica_mjere(jedinica_mjere);
				session.update(a);
				t.commit();
				session.close();
				return true;
			}
		}	
		
		public static boolean modificirajBarkod(Long id, String barkod)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t= session.beginTransaction();
			Artikal a=(Artikal)session.get(Artikal.class,id);
			if(a==null)
			{
				session.close();
				return false;
			}
			else {
				
				a.setBarkod(barkod);
				session.update(a);
				t.commit();
				session.close();
				return true;
			}

	}
			
		public static Artikal pronadjiArtikalPoID(Long id) throws Exception
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Artikal a=new Artikal();
			Transaction t=session.beginTransaction();
			a=(Artikal)session.get(Artikal.class,id);
			if(a==null)
			{
				session.close();
				throw new Exception("Trazeni artikal ne postoji!");
			}
			else{
				session.close();
				return a;
			}
			

		}
		public static Artikal pronadjiArtikalPoBarkodu(String bk) throws Exception
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Artikal a=new Artikal();
			Transaction t=session.beginTransaction();
			a=(Artikal)session.get(Artikal.class,bk);
			if(a==null)
			{
				session.close();
				throw new Exception("Trazeni artikal ne postoji!");
			}
			else{
				session.close();
				return a;
			}
			

		}
		public static List<?> vratiSveArtikle()
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			String sql = "select * from tim6.artikal";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Artikal.class);	
			List<?> results = query.list();
			session.close();
			return results;	
		}
		
		public String vratiArtikleZaBrisanje(String bk){
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			//Artikal a=new Artikal();
			Transaction t=session.beginTransaction();
			String sql = "select * from tim6.artikal where barkod ="+ bk;
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Artikal.class);	
			List<Artikal> results = query.list();			
			String s=new String();			
			s=(results.get(0).getNaziv()+";;"+results.get(0).getCijena()+";;"+results.get(0).getZalihe_stanje()+";;"+results.get(0).getBarkod()+";;"+results.get(0).getId());	
			session.close();
			return s;
			
		}
		
		public String[] vratiRazdovojeno(String str)
		{
			String[] novo=str.split(";;");
			return novo;
		}
}
