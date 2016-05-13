package ba.etf.unsa.si.pos_kasa.controller;

import junit.framework.TestCase;

import java.util.List;
import java.util.Vector;

import ba.etf.unsa.si.pos_kasa.model.*;

public class ArtikalKontrolerTest extends TestCase 
{
	
	public void testDodajArtikal()
	{
		Kategorija k = new Kategorija();
				
		k.setId(1);
		k.setNaziv("kategorija");
		k.setOpis("opis");
				
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "Barkod";
		int _zalihe_stanje = 2;
		String _opis = "Opis";
		long _kategorija_id = k.getId();
		
		ArtikalKontroler ak = new ArtikalKontroler();
		List<Artikal> _artikli =new Vector<Artikal>();
		_artikli = (List<Artikal>)ak.vratiSveArtikle();
		
		ak.dodajArtikal(_naziv, _cijena, _jedinica_mjere, _barkod, _zalihe_stanje, _opis, _kategorija_id);
		
		List<Artikal> _rezultat = new Vector<Artikal>();
		_rezultat = (List<Artikal>)ak.vratiSveArtikle();
		
		assertEquals(_rezultat.size(), _artikli.size()+1);
	}
	
	
     public void testObrisiArtikal()
	{
    	 Kategorija k = new Kategorija();
			
 		k.setId(1);
 		k.setNaziv("kategorija");
 		k.setOpis("opis");
 		
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "Barkod";
		int _zalihe_stanje = 2;
		String _opis = "Opis";
		long _kategorija_id = k.getId();
		
		ArtikalKontroler ak = new ArtikalKontroler();
		List<Artikal> _artikli = new Vector<Artikal>();
		_artikli = (List<Artikal>)ak.vratiSveArtikle();
		Long l;
		
		l = ak.dodajArtikal(_naziv, _cijena, _jedinica_mjere, _barkod, _zalihe_stanje, _opis, _kategorija_id);
		ak.obrisiArtikal(l);
		
		List<Artikal> _rezultat = new Vector<Artikal>();
		_rezultat = (List<Artikal>)ak.vratiSveArtikle();
		
		assertEquals(_rezultat.size(), _artikli.size());
		
	}
	
	
	public void testModificirajArtikal()
	{
		Kategorija k = new Kategorija();
		
		k.setId(1);
		k.setNaziv("kategorija");
		k.setOpis("opis");
		
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "Barkod";
		int _zalihe_stanje = 2;
		String _opis = "Opis";
		long _kategorija_id = k.getId();
		
		
		ArtikalKontroler ak = new ArtikalKontroler();
		
		Long l = ak.dodajArtikal(_naziv, _cijena, _jedinica_mjere, _barkod, _zalihe_stanje, _opis, _kategorija_id);
		
		ak.modificirajArtikal(l, "NekiNazivNovi", 2, "jedinicaMjereNovi", "BarkodNovi", 3, "OpisNovi", 1);
		
		Artikal a = new Artikal();
		try
		{		
			a = ak.pronadjiArtikalPoID(l);
			assertEquals(a.getNaziv(),"NekiNazivNovi");
        }
		
		catch (Exception e) 
		{
			assertEquals(e.getMessage(),"Trazeni artikal ne postoji!");
		}
	}
	
	
	public void testModificirajNazivArtikla()
	{
		Kategorija k = new Kategorija();
		
		k.setId(1);
		k.setNaziv("kategorija");
		k.setOpis("opis");
		
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "Barkod";
		int _zalihe_stanje = 2;
		String _opis = "Opis";
		long _kategorija_id = k.getId();
		
		ArtikalKontroler ak = new ArtikalKontroler();
		
		Long l = ak.dodajArtikal(_naziv, _cijena, _jedinica_mjere, _barkod, _zalihe_stanje, _opis, _kategorija_id);
		ak.modificirajNazivArtikla(l, "NoviNaziv");
		
		Artikal a = new Artikal();
		try {
				a = ak.pronadjiArtikalPoID(l);
				assertEquals(a.getNaziv(),"NoviNaziv");
			} 
		catch (Exception e)
		{
				assertEquals(e.getMessage(),"Trazeni artikal ne postoji!");
		}
	}
	
	
	public void testModificirajCijenuArtikla()
	{
		Kategorija k = new Kategorija();
		
		k.setId(1);
		k.setNaziv("kategorija");
		k.setOpis("opis");
		
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "Barkod";
		int _zalihe_stanje = 2;
		String _opis = "Opis";
		long _kategorija_id = k.getId();
		
		ArtikalKontroler ak = new ArtikalKontroler();
		
		Long l = ak.dodajArtikal(_naziv, _cijena, _jedinica_mjere, _barkod, _zalihe_stanje, _opis, _kategorija_id);
		ak.modificirajCijenuArtikla(l,3);
		
		Artikal a = new Artikal();
		try {
				a = ak.pronadjiArtikalPoID(l);
				assertEquals(a.getCijena(), "3");
			} 
		catch (Exception e)
		{
				assertEquals(e.getMessage(),"Trazeni artikal ne postoji!");
		}
	}
	
	
	public void testModificirajJedinicuMjere()
	{
		Kategorija k = new Kategorija();
		
		k.setId(1);
		k.setNaziv("kategorija");
		k.setOpis("opis");
		
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "Barkod";
		int _zalihe_stanje = 2;
		String _opis = "Opis";
		long _kategorija_id = k.getId();
		
		ArtikalKontroler ak = new ArtikalKontroler();
		
		Long l = ak.dodajArtikal(_naziv, _cijena, _jedinica_mjere, _barkod, _zalihe_stanje, _opis, _kategorija_id);
		ak.modificirajJedinicuMjere(l, "JedinicaNovo");
		
		Artikal a = new Artikal();
		try {
				a = ak.pronadjiArtikalPoID(l);
				assertEquals(a.getJedinica_mjere(),"JedinicaNovo");
			} 
		catch (Exception e)
		{
				assertEquals(e.getMessage(),"Trazeni artikal ne postoji!");
		}
	}

	public void testModificirajBarkod()
	{
		Kategorija k = new Kategorija();
		
		k.setId(1);
		k.setNaziv("kategorija");
		k.setOpis("opis");
		
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "Barkod";
		int _zalihe_stanje = 2;
		String _opis = "Opis";
		long _kategorija_id = k.getId();
		
		ArtikalKontroler ak = new ArtikalKontroler();
		
		Long l = ak.dodajArtikal(_naziv, _cijena, _jedinica_mjere, _barkod, _zalihe_stanje, _opis, _kategorija_id);
		
		ak.modificirajBarkod(l, "Novoo");
		
		Artikal a = new Artikal();
		try {
				a = ak.pronadjiArtikalPoID(l);
				assertEquals(a.getNaziv(),"Novoo");
			} 
		catch (Exception e)
		{
				assertEquals(e.getMessage(),"Trazeni artikal ne postoji!");
		}
	}
	
	
	public void testPronadjiArtikalPoID()
	{
		Kategorija k = new Kategorija();
		
		k.setId(1);
		k.setNaziv("kategorija");
		k.setOpis("opis");
		
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "Barkod";
		int _zalihe_stanje = 2;
		String _opis = "Opis";
		long _kategorija_id = k.getId();
		
		ArtikalKontroler ak = new ArtikalKontroler();
		
		Long l = ak.dodajArtikal(_naziv, _cijena, _jedinica_mjere, _barkod, _zalihe_stanje, _opis, _kategorija_id);
		
		Artikal a = new Artikal();
		try 
		{
			a = ak.pronadjiArtikalPoID(l);
			assertEquals(a.getNaziv(),"NekiNaziv");
			
		} 
		catch (Exception e) 
		{
			assertEquals(e.getMessage(),"Trazeni artikal ne postoji!");
		}
	}

}
