package ba.etf.unsa.si.pos_kasa.controller;

import java.util.Date;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

import Tools.HibernateUtil;
import ba.etf.unsa.si.pos_kasa.model.Uposlenik;

public class UposlenikKontroler {

	public  Session session;
	
	public  boolean dodajNovogKorisnika(String imePrezime, Date datumRodjenja, String jmbg, String brojTelefona, String username, String password,String uloga) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Uposlenik u = new Uposlenik();
		u.setImePrezime(imePrezime);
		u.setDatumRodjenja(datumRodjenja);
		u.setJmbg(jmbg);
		u.setBrojTelefona(brojTelefona);
		u.setUsername(username);
		u.setUloga(uloga);
		Long id = (Long) session.save(u);
		System.out.println(id);
		t.commit();
		session.close();
		return true;
		}
		
	
}
