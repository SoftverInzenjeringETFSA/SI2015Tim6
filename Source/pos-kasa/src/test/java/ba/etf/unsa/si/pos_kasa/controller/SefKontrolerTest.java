package ba.etf.unsa.si.pos_kasa.controller;

import junit.framework.TestCase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ba.etf.unsa.si.pos_kasa.model.*;
public class SefKontrolerTest extends TestCase {
	
	public void testDodajNovogKorisnika() throws ParseException
	{
		 String date_s = "1993-04-08";  
	     SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
	     Date rodjenje = dt.parse(date_s);
	     
	     String date_z = "1993-04-08";  
	     SimpleDateFormat dtz = new SimpleDateFormat("yyyy-MM-dd");
	     Date zaposlenje = dtz.parse(date_z);
	     
		Uposlenik u = new Uposlenik();
		u.setImePrezime("ImePrezime");
		u.setBrojTelefona("BrojTelefona");
		u.setDatum_zaposlenja(zaposlenje);
		u.setDatumRodjenja(rodjenje);
		u.setId(1);
		u.setJmbg("jmbg");
		u.setPassword("password");
		u.setUloga("uloga");
		u.setUsername("username");
		
		SefKontroler sk = new SefKontroler();
		
		assertTrue(sk.dodajNovogKorisnika(u));
	}

}
