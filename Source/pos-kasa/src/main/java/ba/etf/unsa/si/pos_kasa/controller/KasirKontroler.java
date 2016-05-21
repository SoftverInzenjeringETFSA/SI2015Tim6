package ba.etf.unsa.si.pos_kasa.controller;

import java.awt.EventQueue;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import ba.etf.unsa.si.pos_kasa.model.Smjena;
import ba.etf.unsa.si.pos_kasa.view.FormaKategorije;
import ba.etf.unsa.si.pos_kasa.view.FormaZaKasira;
import ba.etf.unsa.si.pos_kasa.view.KreiranjeRacuna;
import ba.etf.unsa.si.pos_kasa.view.messageBox;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Tools.HibernateUtil;

public class KasirKontroler {

	FormaZaKasira formaZaKasira;
	KreiranjeRacuna formaZaKreiranjeRacuna;
	LoginKontroler loginKontroler;
	final static Logger logger = Logger.getLogger(KasirKontroler.class.toString());
	public KasirKontroler() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formaZaKasira = new FormaZaKasira(KasirKontroler.this);
					formaZaKasira.setVisible(true);
				} catch (Exception e)
				{
					String poruka=e.getMessage();
					logger.info(poruka);
					throw new RuntimeException(e);
					
				}					}
			});
		};
	

	public void prikaziFormuZaKreiranjeRacuna() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formaZaKasira.setVisible(false);
					formaZaKreiranjeRacuna = new KreiranjeRacuna(KasirKontroler.this);
					formaZaKreiranjeRacuna.setVisible(true);
				} 
					catch (Exception e)
					{
						String poruka=e.getMessage();
						logger.info(poruka);
						throw new RuntimeException(e);
						
					}
				}
			
		});
	}
	
	public void odjaviKasira() {
		
      //OVO NE RADI NISTA
	}


	public void zaključiSmjenu() {
		 Properties p = System.getProperties();
		 //System.out.println(p.getProperty("uloga"));
		 //System.out.println(p.getProperty("zaposlenik_id"));
		 Session session = null;
		 try 
		 {
			 long uposlenik_id=Long.parseLong(p.getProperty("zaposlenik_id"));
			    session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();
		        Query query = session.createQuery("FROM Smjena where uposlenik_id= :uposlenik_id and pocetak_smjene = kraj_smjene");
		        query.setParameter("uposlenik_id", uposlenik_id);
		        @SuppressWarnings("unchecked")
				List<Smjena> smjenaLista = query.list();
				Smjena s = smjenaLista.get(0);
				//System.out.println("ovo je prije ifa");
				
				if(smjenaLista.size()==1) {
					//messageBox.infoBox("Unutar if-a", "");
					s.setKraj_smjene(new Date());
				    session.save(s);
					t.commit();
				    messageBox.infoBox("Uspješno ste zaključili smjenu.", "Info o zaključivanju smjene");
				    formaZaKasira.setVisible(false);
				   // formaZakljucivanjeSmjene.setVisible(false);
				     loginKontroler = new LoginKontroler();
				    
				}
				
		 }
		 catch(Exception e)
		 {
			logger.info(e);
			messageBox.infoBox(e.getMessage(), "exception");
			 
		 }
		 finally 
		 {
			 if(session!=null)
			 {
				 session.clear();
			 session.close();
			 
			 }
		 }
		
	 }

}
