package ba.etf.unsa.si.pos_kasa.controller;

import java.awt.EventQueue;

import ba.etf.unsa.si.pos_kasa.view.BrisanjeKorisnika;
import ba.etf.unsa.si.pos_kasa.view.DodavanjeNovogKorisnika;
import ba.etf.unsa.si.pos_kasa.view.OpcijeSefa;
import ba.etf.unsa.si.pos_kasa.view.PretragaKorisnika;

public class SefKontroler {

	OpcijeSefa formaZaSefa;
	DodavanjeNovogKorisnika dodavanjeNovogKorisnika;
	BrisanjeKorisnika brisanjeKorisnika;
	PretragaKorisnika pretragaKorisnika;

	public SefKontroler() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formaZaSefa = new OpcijeSefa(SefKontroler.this);
					formaZaSefa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void prikaziFormuZaUnosKorisnika() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dodavanjeNovogKorisnika  = new DodavanjeNovogKorisnika(SefKontroler.this);
					dodavanjeNovogKorisnika.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
public void prikaziFormuZaPretraguKorisnika() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pretragaKorisnika  = new PretragaKorisnika(SefKontroler.this);
					pretragaKorisnika.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

public void prikaziFormuZaBrisanjeKorisnika() {
	
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				brisanjeKorisnika  = new BrisanjeKorisnika(SefKontroler.this);
				brisanjeKorisnika.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}
	
	
	
	
	
	
}
