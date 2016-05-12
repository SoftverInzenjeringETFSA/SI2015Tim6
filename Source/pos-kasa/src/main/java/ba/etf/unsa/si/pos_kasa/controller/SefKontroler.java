package ba.etf.unsa.si.pos_kasa.controller;

import java.awt.EventQueue;

import ba.etf.unsa.si.pos_kasa.view.FormaZaKasira;
import ba.etf.unsa.si.pos_kasa.view.KreiranjeRacuna;
import ba.etf.unsa.si.pos_kasa.view.OpcijeSefa;

public class SefKontroler {

	OpcijeSefa formaZaSefa;

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
	
	
	
	
}
