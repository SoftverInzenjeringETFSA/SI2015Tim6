package ba.etf.unsa.si.pos_kasa.controller;

import junit.framework.TestCase;

import java.util.List;
import java.util.Vector;

import ba.etf.unsa.si.pos_kasa.model.*;

public class RacunKontrolerTest extends TestCase {
	
	public void testDodajStavku()
	{
		Artikal a = new Artikal();

		a.setId(1);
		a.setNaziv("ArtikalNaziv");
		a.setBarkod("barkod");
		a.setJedinica_mjere("JedinicaMjere");
		a.setCijena(2.2);
		a.setZalihe_stanje(3);
		a.setOpis("Opis");
		
		long id = 11;
		int kolicina = 2;
		double ukupna_cijena = 22;
		long artikal_id = a.getId();
		
		RacunKontroler rk = new RacunKontroler();
		List<StavkaRacuna> _stavke = new Vector<StavkaRacuna>();
		_stavke = (List<StavkaRacuna>)rk.vratiSveRacune();
		
		rk.dodajStavku(id, kolicina, ukupna_cijena, artikal_id);
		
		List<StavkaRacuna> _rezultat = new Vector<StavkaRacuna>();
		_rezultat = (List<StavkaRacuna>) rk.vratiSveRacune();
		
		assertEquals(_rezultat.size(), _stavke.size()+1);
	}

}
