package ba.etf.unsa.si.pos_kasa.controller;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Tools.HibernateUtil;
import ba.etf.unsa.si.pos_kasa.model.Artikal;
import ba.etf.unsa.si.pos_kasa.model.Uposlenik;

@SuppressWarnings("unused")
public class UposlenikKontroler
{
	private static Session session;

	public static void main(String[] args)
	{
	}
		public static Long dodajUposlenika(String _ime_prezime, String _datum_rodjenja, Date _datum_zaposlenja, String _jmbg, String _broj_telefona, String _username, String _password, String _uloga)
		{
		
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Uposlenik u = new Uposlenik();
			
			u.setImePrezime(_ime_prezime);
			u.setDatumRodjenja(_datum_rodjenja);
			u.setJmbg(_jmbg);
			u.setBrojTelefona(_broj_telefona);
			u.setUsername(_username);
			u.setPassword(_password);
			u.setUloga(_uloga);
			u.setDatum_zaposlenja(_datum_zaposlenja);
			
			
			Long id = (Long) session.save(u);
			System.out.println(id);
			t.commit();
			session.close();
			return u.getId();

		} 
		public static boolean obrisiUposlenika(Long id)
		{   
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t= session.beginTransaction();
	    	
			Uposlenik u = (Uposlenik)session.get(Uposlenik.class,id);
			
			if(u == null)
			{
				session.close();
				return false;
			}
			else 
			{
				session.delete(u);
				t.commit();
				session.close();
				return true;
			}
		}
			public static boolean modificirajUposlenika(String _ime_prezime, String _datum_rodjenja, Date _datum_zaposlenja, String _jmbg, String _broj_telefona, String _username, String _password, String _uloga)
			{
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t= session.beginTransaction();
				Uposlenik u = (Uposlenik)session.get(Uposlenik.class,_ime_prezime);
				
				if(u == null)
				{
					session.close();
					return false;
				}
				else
				{
					u.setImePrezime(_ime_prezime);
					u.setDatumRodjenja(_datum_rodjenja);
					u.setJmbg(_jmbg);
					u.setBrojTelefona(_broj_telefona);
					u.setUsername(_username);
					u.setPassword(_password);
					u.setUloga(_uloga);
					u.setDatum_zaposlenja(_datum_zaposlenja);
				 
					session.update(u);
					t.commit();
					session.close();
					return true;
				}
		   }
			public static boolean modificirajImePrezimeUposlenika (Long _id, String _ime_prezime)
			{
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t= session.beginTransaction();
				Uposlenik u = (Uposlenik)session.get(Uposlenik.class,_id);
				
				if(u == null)
				{
					session.close();
					return false;
				}
				else {
					
					u.setImePrezime(_ime_prezime);
					session.update(u);
					t.commit();
					session.close();
					return true;
				}
			}	
			
			public static boolean modificirajDatumRodjenjaUposlenika (Long _id, String _datum_rodjenja)
			{
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t= session.beginTransaction();
				Uposlenik u = (Uposlenik)session.get(Uposlenik.class,_id);
				
				if(u == null)
				{
					session.close();
					return false;
				}
				else {
					
					u.setDatumRodjenja(_datum_rodjenja);
					session.update(u);
					t.commit();
					session.close();
					return true;
				}
			}
			
			public static boolean modificirajDatumZaposlenjaUposlenika (Long _id, Date _datum_zaposlenja)
			{
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t= session.beginTransaction();
				Uposlenik u = (Uposlenik)session.get(Uposlenik.class,_id);
				
				if(u == null)
				{
					session.close();
					return false;
				}
				else {
					
					u.setDatum_zaposlenja(_datum_zaposlenja);
					session.update(u);
					t.commit();
					session.close();
					return true;
				}
			}
			public static boolean modificirajBrojTelefonaUposlenika (Long _id, String _broj_telefona)
			{
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t= session.beginTransaction();
				Uposlenik u = (Uposlenik)session.get(Uposlenik.class,_id);
				
				if(u == null)
				{
					session.close();
					return false;
				}
				else {
					
					u.setBrojTelefona(_broj_telefona);
					session.update(u);
					t.commit();
					session.close();
					return true;
				}
			}
			public static boolean modificirajJMBGUposlenika (Long _id, String _jmbg)
			{
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t= session.beginTransaction();
				Uposlenik u = (Uposlenik)session.get(Uposlenik.class,_id);
				
				if(u == null)
				{
					session.close();
					return false;
				}
				else {
					
					u.setJmbg(_jmbg);
					session.update(u);
					t.commit();
					session.close();
					return true;
				}
			}
			public static boolean modificirajUsernameUposlenika (Long _id, String _username)
			{
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t= session.beginTransaction();
				Uposlenik u = (Uposlenik)session.get(Uposlenik.class,_id);
				
				if(u == null)
				{
					session.close();
					return false;
				}
				else {
					
					u.setUsername(_username);
					session.update(u);
					t.commit();
					session.close();
					return true;
				}
			}
			
			public static boolean modificirajPasswordUposlenika (Long _id, String _password)
			{
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t= session.beginTransaction();
				Uposlenik u = (Uposlenik)session.get(Uposlenik.class,_id);
				
				if(u == null)
				{
					session.close();
					return false;
				}
				else {
					
					u.setPassword(_password);
					session.update(u);
					t.commit();
					session.close();
					return true;
				}
			}
			public static boolean modificirajUloguUposlenika (Long _id, String _uloga)
			{
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t= session.beginTransaction();
				Uposlenik u = (Uposlenik)session.get(Uposlenik.class,_id);
				
				if(u == null)
				{
					session.close();
					return false;
				}
				else {
					
					u.setUloga(_uloga);
					session.update(u);
					t.commit();
					session.close();
					return true;
				}
			}
			
			public static Uposlenik pronadjiUposlenikaPoJmbg (String _jmbg) throws Exception
			{
				Session session = HibernateUtil.getSessionFactory().openSession();
				Uposlenik u = new Uposlenik();
				Transaction t=session.beginTransaction();
				
				u = (Uposlenik)session.get(Uposlenik.class,_jmbg);
				if(u == null)
				{
					session.close();
					throw new Exception("Trazeni uposlenik ne postoji!");
				}
				else
				{
					session.close();
					return u;
				}
			}
			
			public static List<?> vratiSveUposlenike()
			{
				Session session = HibernateUtil.getSessionFactory().openSession();
				String sql = "select * from tim6.uposlenik";
				SQLQuery query = session.createSQLQuery(sql);
				
				query.addEntity(Uposlenik.class);	
				List<?> results = query.list();
				session.close();
				return results;	
			}
	}
	