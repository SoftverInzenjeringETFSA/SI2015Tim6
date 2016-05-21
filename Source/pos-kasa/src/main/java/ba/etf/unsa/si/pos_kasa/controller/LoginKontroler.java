package ba.etf.unsa.si.pos_kasa.controller;

import java.awt.EventQueue;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.transaction.SystemException;

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
		Properties p= System.getProperties();
		try 
		{
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session.createQuery("FROM Uposlenik where username= :korisnickoIme and password= :password");
			query.setParameter("korisnickoIme", korisnickoIme);
			query.setParameter("password", password);
			@SuppressWarnings("unchecked")
			List<Uposlenik> uposlenici = query.list();
			if (uposlenici != null && uposlenici.size() == 1) 
			{
				
				
				Uposlenik uposlenik = uposlenici.get(0);
				
				
				
				//trazenje da li je vec logovan na sistem
				long uposlenik_id=uposlenik.getId();
				
			    Query query2 = session.createQuery("FROM Smjena where uposlenik_id= :uposlenik_id and pocetak_smjene = kraj_smjene");
				query2.setParameter("uposlenik_id", uposlenik_id);
				
				@SuppressWarnings("unchecked")
				List<Smjena> smjenaLista = query2.list();
				if(smjenaLista.isEmpty())

				
				if(smjenaLista.isEmpty())//ako ne postoji uposlenik unesen u smjenu gdje je datum pocetka i kraja isti radi
				{
			
					
	
			    //u suprotnom kreiraj smjenu i unesi
					messageBox.infoBox("Smjena Vam pocinje od ovog trenutka.", "Info o pocetku smjene");
				smjena = new Smjena();
				smjena.setPocetak_smjene(new Date());
				smjena.setKraj_smjene(new Date());
				smjena.setUposlenik_id(uposlenik.getId());
                //setovat sve osim kraja smjenen
				//unijet u bazu
				//System.out.println(uposlenik.getId());
				
				
		   //razlog odjava i zakljucivanje smjene, odjavit se moze al da nije zakljucio smjenu
		//vrsi se update entrija samo kada odabere zakljucivanje smjene
				 //messageBox.infoBox("ALmir smjena spremanje", "");
					session.save(smjena);
					t.commit();
				}	
			
				//po kraju smjene izvrsiti session.update(smjena)
				//prije toga dodat kraj smjene u objekat smjena koji nedostaje
				
				//asdfas
				
				//TODO napravit zapis u bazu za smjenu pocetak 
				p.put("uloga", uposlenik.getUloga());
				p.put("username", uposlenik.getUsername());
				p.put("zaposlenik_id", Long.toString(uposlenik.getId()));
				
				
				String imePrezime=uposlenik.getImePrezime();
				if (uposlenik.getUloga().equals("Kasir")) 
				{
					p.put("logged", "true");
					kasirKontroler = new KasirKontroler();
					messageBox.infoBox("Kasir: " +imePrezime+" je uspješno logovan na kasu.", "Info Login");
					loginForma.setVisible(false);
					
				} else if (uposlenik.getUloga().equals("Sef"))
				{
					p.put("logged", "true");
					sefKontroler = new SefKontroler();
					messageBox.infoBox("Šef: " +imePrezime+" je uspješno logovan na kasu.", "Info Login");
					loginForma.setVisible(false);
					
					
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
				System.setProperties(p);
				session.close();				
			}
		}//finally end
	}

}
