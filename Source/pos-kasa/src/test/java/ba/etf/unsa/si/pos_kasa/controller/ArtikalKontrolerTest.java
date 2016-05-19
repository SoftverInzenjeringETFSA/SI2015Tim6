package ba.etf.unsa.si.pos_kasa.controller;

import junit.framework.TestCase;

import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

import ba.etf.unsa.si.pos_kasa.model.*;

public class ArtikalKontrolerTest extends TestCase 
{
	Long a;
	Long aTest;
	protected void setUp(){
		Kategorija k = new Kategorija();
		KategorijaControler kc=new KategorijaControler();	
	    a=kc.dodajKategoriju("Kategorija","Opis");
	    Kategorija kTest = new Kategorija();	
	    aTest=kc.dodajKategoriju("Kategorija","Opis");
	       	    
	}
	public void testDodajArtikal()
	{			
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "3871234567890";
		int _zalihe_stanje = 2;
		String _opis = "Opis";
		ArtikalKontroler ak = new ArtikalKontroler();
		
		Long art;
		art=ak.dodajArtikal(_naziv, _cijena, _jedinica_mjere, _barkod, _zalihe_stanje, _opis, a);
		
		Artikal artikal=new Artikal();
		try {
			
			artikal=ak.pronadjiArtikalPoID(art);
		
		} catch (Exception e) {
			Logger.getLogger(ArtikalKontroler.class).error(e.getMessage());
		}
		
		assertEquals(artikal.getNaziv(),"NekiNaziv");
	}
	
	
     public void testObrisiArtikal()
	{
    	 
 		
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "3871234567891";
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
			Logger.getLogger(ArtikalKontroler.class).error(e.getMessage());
		}	
		
	}
	
	
	public void testModificirajArtikal()
	{
		
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "3871234567892";
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
			Logger.getLogger(ArtikalKontroler.class).error(e.getMessage());
		}
	}
	
	
	public void testModificirajNazivArtikla()
	{
		
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "3871234567893";
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
				Logger.getLogger(ArtikalKontroler.class).error(e.getMessage());
		}
	}
	
	
	public void testModificirajCijenuArtikla()
	{	
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "3871234567894";
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
				Logger.getLogger(ArtikalKontroler.class).error(e.getMessage());
		}
	}
	
	
	public void testModificirajJedinicuMjere()
	{
		
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "3871234567895";
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
				Logger.getLogger(ArtikalKontroler.class).error(e.getMessage());
		}
	}

	public void testModificirajBarkod()
	{		
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "3871234567896";
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
				Logger.getLogger(ArtikalKontroler.class).error(e.getMessage());
		}
	}
	
	
	public void testPronadjiArtikalPoID()
	{
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "3871234567897";
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
			Logger.getLogger(ArtikalKontroler.class).error(e.getMessage());
		}
	}
	public void testVratiRijeci(){
		
		List<String>rijeci=new Vector<String>();
		String _naziv = "NekiNaziv";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "3871234567898";
		int _zalihe_stanje = 2;
		String _opis = "Opis";
		ArtikalKontroler ak = new ArtikalKontroler();
		
		Long art;
		art=ak.dodajArtikal(_naziv, _cijena, _jedinica_mjere, _barkod, _zalihe_stanje, _opis, a);
		
		try {
			Artikal ar;
			ar = ak.pronadjiArtikalPoID(art);
			List<Artikal> lista=new Vector<Artikal>();
			lista.add(ar);
			List<String>str=new Vector<String>();
			str=ak.vratiRijeci(lista);
			assertEquals(str.size(),1);
		} catch (Exception e) {
			Logger.getLogger(ArtikalKontroler.class).error(e.getMessage());
			e.printStackTrace();
		}
		
		
		
		
	}
	public void testVratiRazdovojeno(){
		ArtikalKontroler ac=new ArtikalKontroler();
		String s="ADO;;ADO";
		String[] niz=ac.vratiRazdovojeno(s);
		assertEquals(niz.length,2);
	}
	public void testVratiSveArtiklePoNazivu(){
		
		List<String>rijeci=new Vector<String>();
		String _naziv = "Neki12345";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "3871234567899";
		int _zalihe_stanje = 2;
		String _opis = "Opis";
		ArtikalKontroler ak = new ArtikalKontroler();
		
		Long art;
		art=ak.dodajArtikal(_naziv, _cijena, _jedinica_mjere, _barkod, _zalihe_stanje, _opis, a);
		List<Artikal> list=ak.vratiSveArtiklePoNazivu("Neki12345");
		assertTrue(list.size()>0);
		
	}
	public void testVratiSveArtiklePoBarkodu(){
		List<String>rijeci=new Vector<String>();
		String _naziv = "Neki";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "3871234567888";
		int _zalihe_stanje = 2;
		String _opis = "Opis";
		ArtikalKontroler ak = new ArtikalKontroler();
		
		Long art;
		art=ak.dodajArtikal(_naziv, _cijena, _jedinica_mjere, _barkod, _zalihe_stanje, _opis, a);
		List<Artikal> list=ak.vratiSveArtiklePoBarkodu("3871234567888");
		assertTrue(list.size()>0);
	}
	public void testVratiSveArtiklePoKategoriji(){
		List<String>rijeci=new Vector<String>();
		String _naziv = "Neki";
		double _cijena = 2.2;
		String _jedinica_mjere = "jedinicaMjere"; 
		String _barkod = "3871234567886";
		int _zalihe_stanje = 2;
		String _opis = "Opis";
		ArtikalKontroler ak = new ArtikalKontroler();
		
		Long art;
		art=ak.dodajArtikal(_naziv, _cijena, _jedinica_mjere, _barkod, _zalihe_stanje, _opis, aTest);
		List<Artikal> list=ak.vratiSveArtiklePoKategoriji(aTest);
		assertEquals(list.size(),1);
		
		
	}
		public void testVratiSveArtikle(){
			List<Artikal>lista1=new Vector<Artikal>();
			List<Artikal>lista2=new Vector<Artikal>();
			ArtikalKontroler ak = new ArtikalKontroler();
			lista1=(List<Artikal>)ak.vratiSveArtikle();
			ak.dodajArtikal("Proba", 2.2,"Komad", "1231231231232", 4,"Test", aTest);
			lista2=(List<Artikal>)ak.vratiSveArtikle();
			assertEquals(lista2.size(),lista1.size()+1);
			
		}
	
	

}
