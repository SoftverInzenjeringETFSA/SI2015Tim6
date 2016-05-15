package ba.etf.unsa.si.pos_kasa.controller;

import junit.framework.TestCase;

import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

import ba.etf.unsa.si.pos_kasa.model.*;

public class KategorijaControlerTest extends TestCase {

	public void testDodajKategoriju() {
		
		String ime="Ime";
		String opis="Opis";
		KategorijaControler kc=new KategorijaControler();
		Long a=kc.dodajKategoriju(ime, opis);
		try {
			assertEquals("Ime", kc.pronadjiKategorijuPoID(a).getNaziv());
		} catch (Exception e) {
			assertEquals(e.getMessage(),"Trazena kategorija ne postoji!");
			Logger.getLogger(KategorijaControler.class).error(e.getMessage());
		}
		
	}

	public void testObrisiKategoriju() {
		
		String ime="Ime";
		String opis="Opis";
		KategorijaControler kc=new KategorijaControler();
		Long l;
		l=kc.dodajKategoriju(ime, opis);
		kc.obrisiKategoriju(l);
		try {
			assertEquals("Ime", kc.pronadjiKategorijuPoID(l).getNaziv());
		} catch (Exception e) {
			assertEquals(e.getMessage(),"Trazena kategorija ne postoji!");
			Logger.getLogger(KategorijaControler.class).error(e.getMessage());
		}	
		
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
			Logger.getLogger(KategorijaControler.class).error(e.getMessage());
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
				Logger.getLogger(KategorijaControler.class).error(e.getMessage());
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
				Logger.getLogger(KategorijaControler.class).error(e.getMessage());
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
			Logger.getLogger(KategorijaControler.class).error(e.getMessage());
		}
	}
	
	public void testVrati(){
		KategorijaControler ac=new KategorijaControler();
		String s="ADO ADO";
		String[] niz=ac.vrati(s);
		assertEquals(niz.length,2);
		
	}
	public void testVratiRazdovojeno(){
		KategorijaControler ac=new KategorijaControler();
		String s="ADO;;ADO";
		String[] niz=ac.vratiRazdovojeno(s);
		assertEquals(niz.length,2);
	}

}
