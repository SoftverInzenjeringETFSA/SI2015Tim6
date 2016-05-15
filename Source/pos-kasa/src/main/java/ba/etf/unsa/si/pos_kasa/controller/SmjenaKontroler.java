package ba.etf.unsa.si.pos_kasa.controller;



import java.awt.EventQueue;

<<<<<<< HEAD
import org.hibernate.Session;

import Tools.HibernateUtil;
import ba.etf.unsa.si.pos_kasa.model.Smjena;
import ba.etf.unsa.si.pos_kasa.model.Uposlenik;
=======
import org.apache.log4j.Logger;

>>>>>>> branch 'master' of https://github.com/SoftverInzenjeringETFSA/SI2015Tim6.git
import ba.etf.unsa.si.pos_kasa.view.DodavanjeNovogKorisnika;
import ba.etf.unsa.si.pos_kasa.view.FormaZaKasira;
import ba.etf.unsa.si.pos_kasa.view.OpcijeSefa;
import ba.etf.unsa.si.pos_kasa.view.Zakljucivanje;


public class SmjenaKontroler {
	
	OpcijeSefa formaZaSefa;
	Zakljucivanje formaKrajSmjene;
	protected Zakljucivanje Zakljucivanje;
	
	public SmjenaKontroler() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formaZaSefa = new OpcijeSefa(SmjenaKontroler.this);
					formaZaSefa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					Logger.getLogger(OpcijeSefa.class).error(e.getMessage());
				}
			}
		});
	}
	
	
	
	public void prikaziFormuZaZakljucivanje() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zakljucivanje  = new Zakljucivanje(SmjenaKontroler.this);
					Zakljucivanje.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					Logger.getLogger(Zakljucivanje.class).error(e.getMessage());
				}
			}
		});
	}
	
	public static Smjena dajTrenutnoAktivnuSmjenu(long uposlenik_id)
	{
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	Uposlenik uposlenik = (Uposlenik) session.get(Uposlenik.class, uposlenik_id);
    	return new Smjena();
	}
	
	
	
	
}



