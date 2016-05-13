package ba.etf.unsa.si.pos_kasa.controller;

import java.awt.EventQueue;

import ba.etf.unsa.si.pos_kasa.view.FormaZaKasira;
import ba.etf.unsa.si.pos_kasa.view.KreiranjeRacuna;

public class KasirKontroler {

	FormaZaKasira formaZaKasira;
	KreiranjeRacuna formaZaKreiranjeRacuna;

	public KasirKontroler() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formaZaKasira = new FormaZaKasira(KasirKontroler.this);
					formaZaKasira.setVisible(true);
				} catch (Exception e) {
					}
			}
		});
	}

	public void prikaziFormuZaKreiranjeRacuna() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formaZaKasira.setVisible(false);
					formaZaKreiranjeRacuna = new KreiranjeRacuna(KasirKontroler.this);
					formaZaKreiranjeRacuna.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
