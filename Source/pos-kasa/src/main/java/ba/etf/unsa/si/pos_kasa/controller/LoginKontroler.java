package ba.etf.unsa.si.pos_kasa.controller;

import java.awt.EventQueue;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Tools.HibernateUtil;
import ba.etf.unsa.si.pos_kasa.model.Smjena;
import ba.etf.unsa.si.pos_kasa.model.Uposlenik;
import ba.etf.unsa.si.pos_kasa.view.FormaZaKasira;
import ba.etf.unsa.si.pos_kasa.view.PrikazForma;
import ba.etf.unsa.si.pos_kasa.view.messageBox;

public class LoginKontroler {

	static KasirKontroler kasirKontroler;
	static LoginKontroler loginKontroler;
	static SefKontroler sefKontroler;
	static Smjena smjena;

	PrikazForma loginForma;

	public static void main(String[] args) {
		loginKontroler = new LoginKontroler();
	}

	public LoginKontroler() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginForma = new PrikazForma(LoginKontroler.this);
					loginForma.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					Logger.getLogger(PrikazForma.class).error(e.getMessage());
				}
			}
		});

		// login view prikazati, login metodu pozvati sa viewa
	}

	public void login(String korisnickoIme, String password) {

		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("FROM Uposlenik where username= :korisnickoIme and password= :password");
			query.setParameter("korisnickoIme", korisnickoIme);
			query.setParameter("password", password);
			@SuppressWarnings("unchecked")
			List<Uposlenik> uposlenici = query.list();
			if (uposlenici != null && uposlenici.size() == 1) {
				Uposlenik uposlenik = uposlenici.get(0);
				smjena = new Smjena();
                //setovat sve osim kraja smjenen
				//unijet u bazu
				//session.save(smjena);
				//po kraju smjene izvrsiti session.update(smjena)
				//prije toga dodat kraj smjene u objekat smjena koji nedostaje
				
				//asdfas
				
				//TODO napravit zapis u bazu za smjenu pocetak 
				
				String imePrezime=uposlenik.getImePrezime();
				if (uposlenik.getUloga().equals("Kasir")) {
					kasirKontroler = new KasirKontroler();
					loginForma.setVisible(false);
					messageBox.infoBox("Kasir: " +imePrezime+" je uspješno logovan na kasu.", "Info Login");
				} else if (uposlenik.getUloga().equals("Sef")) {
					sefKontroler = new SefKontroler();
					loginForma.setVisible(false);
					messageBox.infoBox("Šef: " +imePrezime+" je uspješno logovan na kasu.", "Info Login");
				} else {
					//messageBox.infoBox("Neuspješan Login", "Info Login");
				}

			} else {
				// Prikazi poruku pogresno korisnicko ime ili password
				messageBox.infoBox("Login Podaci Nisu Validni. Provjerite unos!!!", "Info Login");
			}
		} catch (HibernateException e) {
			Logger.getLogger(SefKontroler.class).error(e.getMessage());
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
