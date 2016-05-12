package ba.etf.unsa.si.pos_kasa.controller;

import junit.framework.TestCase;

import java.util.List;
import java.util.Vector;

import ba.etf.unsa.si.pos_kasa.model.*;

public class KategorijaControlerTest extends TestCase {

	public void testDodajKategoriju() {
		
		String ime="Ime";
		String opis="Opis";
		KategorijaControler kc=new KategorijaControler();
		List<Kategorija> lista1=new Vector<Kategorija>();
		lista1=(List<Kategorija>)kc.vratiSveKategorije();
		kc.dodajKategoriju(ime, opis);
		
		List<Kategorija> lista2=new Vector<Kategorija>();
		lista2=(List<Kategorija>)kc.vratiSveKategorije();
		assertEquals(lista2.size(), lista1.size()+1);
		
	}

	public void testObrisiKategoriju() {
		
		String ime="Ime";
		String opis="Opis";
		KategorijaControler kc=new KategorijaControler();
		List<Kategorija> lista1=new Vector<Kategorija>();
		lista1=(List<Kategorija>)kc.vratiSveKategorije();
		Long l;
		
		l=kc.dodajKategoriju(ime, opis);
		kc.obrisiKategoriju(l);
		List<Kategorija> lista2=new Vector<Kategorija>();
		lista2=(List<Kategorija>)kc.vratiSveKategorije();
		assertEquals(lista2.size(), lista1.size());
		
		
	}

	public void testModificirajKategoriju() {
		String ime="Ime";
		String opis="Opis";
		KategorijaControler kc=new KategorijaControler();
		List<Kategorija> lista1=new Vector<Kategorija>();
		Long l=kc.dodajKategoriju(ime, opis);
		kc.modificirajKategoriju(l, "Nesto", "Neki");
		Kategorija kat=new Kategorija();
		try {
			kat=kc.pronadjiKategorijuPoID(l);
			assertEquals(kat.getNaziv(),"Nesto");
		} catch (Exception e) {
			assertEquals(e.getMessage(),"Trazena kategorija ne postoji!");
		}
		
	}

	public void testModificirajImeKategorije() {
		String ime="Ime";
		String opis="Opis";
		KategorijaControler kc=new KategorijaControler();
		List<Kategorija> lista1=new Vector<Kategorija>();
		Long l=kc.dodajKategoriju(ime, opis);
		kc.modificirajImeKategorije(l, "Nesto");
		Kategorija kat=new Kategorija();
		try {
				kat=kc.pronadjiKategorijuPoID(l);
				assertEquals(kat.getNaziv(),"Nesto");
			} catch (Exception e) {
				assertEquals(e.getMessage(),"Trazena kategorija ne postoji!");
			}
			
		
	}

	public void testModificirajOpisKategorije() {
		String ime="Ime";
		String opis="Opis";
		KategorijaControler kc=new KategorijaControler();
		List<Kategorija> lista1=new Vector<Kategorija>();
		Long l=kc.dodajKategoriju(ime, opis);
		kc.modificirajOpisKategorije(l, "Nesto");
		Kategorija kat=new Kategorija();
		try {
				kat=kc.pronadjiKategorijuPoID(l);
				assertEquals(kat.getOpis(),"Nesto");
			} catch (Exception e) {
				assertEquals(e.getMessage(),"Trazena kategorija ne postoji!");
			}
			
	}

	public void testPronadjiKategorijuPoID() {
		String ime="Ime";
		String opis="Opis";
		KategorijaControler kc=new KategorijaControler();
		List<Kategorija> lista1=new Vector<Kategorija>();
		Long l=kc.dodajKategoriju(ime, opis);
		Kategorija kat=new Kategorija();
		try {
			kat=kc.pronadjiKategorijuPoID(l);
			assertEquals(kat.getNaziv(),"Ime");
		} catch (Exception e) {
			assertEquals(e.getMessage(),"Trazena kategorija ne postoji!");
		}
	}


}
