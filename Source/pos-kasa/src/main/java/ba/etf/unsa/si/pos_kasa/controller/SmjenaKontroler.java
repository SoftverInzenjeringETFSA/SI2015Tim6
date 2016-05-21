package ba.etf.unsa.si.pos_kasa.controller;



import java.awt.EventQueue;
import java.util.Date;
import java.util.Properties;

//<<<<<<< HEAD
import org.hibernate.Session;

import Tools.HibernateUtil;
import ba.etf.unsa.si.pos_kasa.model.Smjena;
import ba.etf.unsa.si.pos_kasa.model.Uposlenik;
//=======
import org.apache.log4j.Logger;

//>>>>>>> branch 'master' of https://github.com/SoftverInzenjeringETFSA/SI2015Tim6.git
import ba.etf.unsa.si.pos_kasa.view.DodavanjeNovogKorisnika;
import ba.etf.unsa.si.pos_kasa.view.FormaZaKasira;
import ba.etf.unsa.si.pos_kasa.view.OpcijeSefa;
import ba.etf.unsa.si.pos_kasa.view.Zakljucivanje;
import ba.etf.unsa.si.pos_kasa.view.messageBox;


public class SmjenaKontroler {
	
	OpcijeSefa formaZaSefa;
	//Zakljucivanje formaKrajSmjene;
	private Zakljucivanje Zakljucivanje;
	final static Logger logger = Logger.getLogger(SmjenaKontroler.class.toString());
	

	/*
	public void prikaziFormuZaZakljucivanje() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zakljucivanje  = new Zakljucivanje(SmjenaKontroler.this);
					Zakljucivanje.setVisible(true);
				} catch (Exception e) {
					String poruka=e.getMessage();
					logger.info(poruka);
					throw new RuntimeException(e);
				}
			}
		});
	}
	*/
	/*
	public static Smjena dajTrenutnoAktivnuSmjenu(long uposlenik_id)
	{
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	Uposlenik uposlenik = (Uposlenik) session.get(Uposlenik.class, uposlenik_id);
    	return new Smjena();
	}
	*/
	
/*
	public static String VrijemeSmjene(Date datumSmjene,Date VrijemeSmjene)
	{
		Smjena.setPocetak_smjene(datumSmjene);
		Smjena.setKraj_smjene(VrijemeSmjene);
		return datumSmjene.toString() + " " + VrijemeSmjene.toString();
		
	}
	*/

	 
	
	
}



