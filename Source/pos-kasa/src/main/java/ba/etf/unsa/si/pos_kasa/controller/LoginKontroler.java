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

	private KasirKontroler kasirKontroler;
	private static LoginKontroler loginKontroler;
	private SefKontroler sefKontroler;
	private Smjena smjena;
	final static Logger logger = Logger.getLogger(LoginKontroler.class.toString());
	private PrikazForma loginForma;
	public String userName,password;

	public static void main(String[] args) {
		loginKontroler = new LoginKontroler();
	}

	public LoginKontroler() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginForma = new PrikazForma(LoginKontroler.this);
					loginForma.setVisible(true);
				} catch (Exception e)
				{
					String poruka=e.getMessage();
					logger.info(poruka);
					throw new RuntimeException(e);
					
				}
			}
		});

		// login view prikazati, login metodu pozvati sa viewa
	}

	public void login(String korisnickoIme, String password)
	{
        
		Session session = null;
		try 
		{
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("FROM Uposlenik where username= :korisnickoIme and password= :password");
			query.setParameter("korisnickoIme", korisnickoIme);
			query.setParameter("password", password);
			@SuppressWarnings("unchecked")
			List<Uposlenik> uposlenici = query.list();
			if (uposlenici != null && uposlenici.size() == 1) 
			{
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
				if (uposlenik.getUloga().equals("Kasir")) 
				{
					kasirKontroler = new KasirKontroler();
					messageBox.infoBox("Kasir: " +imePrezime+" je uspješno logovan na kasu.", "Info Login");
					loginForma.setVisible(false);
					
				} else if (uposlenik.getUloga().equals("Sef"))
				{
					sefKontroler = new SefKontroler();
					messageBox.infoBox("Šef: " +imePrezime+" je uspješno logovan na kasu.", "Info Login");
					loginForma.setVisible(false);
					//privremeni fix kako ne bi obrisao sam sebe
					userName=korisnickoIme;
					this.password=password;
					
				} else 
				{
					//messageBox.infoBox("Neuspješan Login", "Info Login");
				}

			} else 
			{
				// Prikazi poruku pogresno korisnicko ime ili password
				messageBox.infoBox("Korisnik sa unijetim podacima ne postoji. Provjerite unos!!!", "Info Login");
			}
		} catch (Exception e)
		{
			String poruka=e.getMessage();
			logger.info(poruka);
			throw new RuntimeException(e);
			
		} finally 
		{
			if (session != null) 
			{
				session.close();				
			}
		}//finally end
	}

}
