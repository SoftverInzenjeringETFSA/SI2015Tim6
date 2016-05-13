package ba.etf.unsa.si.pos_kasa.controller;



import java.awt.EventQueue;

import ba.etf.unsa.si.pos_kasa.view.DodavanjeNovogKorisnika;
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
				}
			}
		});
	}
	
	
	
	
	
	
	
	
}



