package ba.etf.unsa.si.pos_kasa.controller;

import java.awt.EventQueue;

import ba.etf.unsa.si.pos_kasa.view.BrisanjeArtikla;
import ba.etf.unsa.si.pos_kasa.view.BrisanjeKorisnika;
import ba.etf.unsa.si.pos_kasa.view.DodavanjeNovogArtikla;
import ba.etf.unsa.si.pos_kasa.view.DodavanjeNovogKorisnika;
import ba.etf.unsa.si.pos_kasa.view.KreiranjeRacuna;
import ba.etf.unsa.si.pos_kasa.view.OpcijeSefa;
import ba.etf.unsa.si.pos_kasa.view.Popust;
import ba.etf.unsa.si.pos_kasa.view.PretragaArtikla;
import ba.etf.unsa.si.pos_kasa.view.PretragaKorisnika;

public class SefKontroler {

	OpcijeSefa formaZaSefa;
	//instance formi za korisnike
	DodavanjeNovogKorisnika dodavanjeNovogKorisnika;
	BrisanjeKorisnika brisanjeKorisnika;
	PretragaKorisnika pretragaKorisnika;
	//instance formi za artikle
    DodavanjeNovogArtikla dodavanjeNovogArtikla;
    BrisanjeArtikla brisanjeArtikla;
    PretragaArtikla pretragaArtikla;
    //instance formi za fiskalni racun
    KreiranjeRacuna kreiranjeRacuna;
    Popust popust;
    //instance formi za odjavu i kraj smjene
    
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

public void prikaziFormuZaBrisanjeArtikla() {
	
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				brisanjeArtikla  = new BrisanjeArtikla(SefKontroler.this);
				brisanjeArtikla.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

public void prikaziFormuZaPretraguArtikla() {
	
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				pretragaArtikla  = new PretragaArtikla(SefKontroler.this);
				pretragaArtikla.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

public void prikaziFormuZaDodavanjeNovogArtikla() {
	
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				dodavanjeNovogArtikla  = new DodavanjeNovogArtikla(SefKontroler.this);
				dodavanjeNovogArtikla.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

public void prikaziFormuZaKreiranjeRacuna() {
	
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				kreiranjeRacuna = new KreiranjeRacuna(SefKontroler.this);
				kreiranjeRacuna.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

public void prikaziFormuZaDefinisanjePopusta() {
	
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				popust = new Popust(SefKontroler.this);
				popust.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}
	
	
	
	
	
}
