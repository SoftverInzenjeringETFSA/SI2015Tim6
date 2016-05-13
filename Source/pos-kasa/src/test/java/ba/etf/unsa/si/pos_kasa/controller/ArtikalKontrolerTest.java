package ba.etf.unsa.si.pos_kasa.controller;

import junit.framework.TestCase;

import java.util.List;
import java.util.Vector;

import ba.etf.unsa.si.pos_kasa.model.*;

public class ArtikalKontrolerTest extends TestCase 
{
	Long a;
	protected void setUp(){
		Kategorija k = new Kategorija();
		KategorijaControler kc=new KategorijaControler();	
	    a=kc.dodajKategoriju("Kategorija","Opis");
	}
	public void testDodajArtikal()
	{			
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "Barkod";
		int _zalihe_stanje = 2;
		String _opis = "Opis";
		//long _kategorija_id = k.getId();
		ArtikalKontroler ak = new ArtikalKontroler();
		
		Long art;
		art=ak.dodajArtikal(_naziv, _cijena, _jedinica_mjere, _barkod, _zalihe_stanje, _opis, a);
		
		Artikal artikal=new Artikal();
		try {
			
			artikal=ak.pronadjiArtikalPoID(art);
		
		} catch (Exception e) {
			
		}
		
		assertEquals(artikal.getNaziv(),"NekiNaziv");
	}
	
	
     public void testObrisiArtikal()
	{
    	 
 		
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "Barkod";
		int _zalihe_stanje = 2;
		String _opis = "Opis";
		
		ArtikalKontroler ak = new ArtikalKontroler();
		Long l;
		
		l = ak.dodajArtikal(_naziv, _cijena, _jedinica_mjere, _barkod, _zalihe_stanje, _opis, a);
		ak.obrisiArtikal(l);
		
		try 
		{
			assertEquals("NekiNaziv", ak.pronadjiArtikalPoID(l).getNaziv());
		} 
		catch (Exception e)
		{
			assertEquals(e.getMessage(),"Trazeni artikal ne postoji!");
		}	
		
	}
	
	
	public void testModificirajArtikal()
	{
		
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "Barkod";
		int _zalihe_stanje = 2;
		String _opis = "Opis";
				
		ArtikalKontroler ak = new ArtikalKontroler();
		
		Long l = ak.dodajArtikal(_naziv, _cijena, _jedinica_mjere, _barkod, _zalihe_stanje, _opis, a);
		
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
		
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "Barkod";
		int _zalihe_stanje = 2;
		String _opis = "Opis";
		
		ArtikalKontroler ak = new ArtikalKontroler();
		
		Long l = ak.dodajArtikal(_naziv, _cijena, _jedinica_mjere, _barkod, _zalihe_stanje, _opis,a);
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
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "Barkod";
		int _zalihe_stanje = 2;
		String _opis = "Opis";
		
		ArtikalKontroler ak = new ArtikalKontroler();
		
		Long l = ak.dodajArtikal(_naziv, _cijena, _jedinica_mjere, _barkod, _zalihe_stanje, _opis, a);
		ak.modificirajCijenuArtikla(l,3);
		
		Artikal a = new Artikal();
		try {
				a = ak.pronadjiArtikalPoID(l);
				assertTrue(a.getCijena()-3<=0.0000001);
			} 
		catch (Exception e)
		{
				assertEquals(e.getMessage(),"Trazeni artikal ne postoji!");
		}
	}
	
	
	public void testModificirajJedinicuMjere()
	{
		
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "Barkod";
		int _zalihe_stanje = 2;
		String _opis = "Opis";
		
		ArtikalKontroler ak = new ArtikalKontroler();
		
		Long l = ak.dodajArtikal(_naziv, _cijena, _jedinica_mjere, _barkod, _zalihe_stanje, _opis, a);
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
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "Barkod";
		int _zalihe_stanje = 2;
		String _opis = "Opis";
		
		ArtikalKontroler ak = new ArtikalKontroler();
		
		Long l = ak.dodajArtikal(_naziv, _cijena, _jedinica_mjere, _barkod, _zalihe_stanje, _opis,a);
		
		ak.modificirajBarkod(l, "Novoo");
		
		Artikal a = new Artikal();
		try {
				a = ak.pronadjiArtikalPoID(l);
				assertEquals(a.getBarkod(),"Novoo");
			} 
		catch (Exception e)
		{
				assertEquals(e.getMessage(),"Trazeni artikal ne postoji!");
		}
	}
	
	
	public void testPronadjiArtikalPoID()
	{
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "Barkod";
		int _zalihe_stanje = 2;
		String _opis = "Opis";
		
		ArtikalKontroler ak = new ArtikalKontroler();
		
		Long l = ak.dodajArtikal(_naziv, _cijena, _jedinica_mjere, _barkod, _zalihe_stanje, _opis, a);
		
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
