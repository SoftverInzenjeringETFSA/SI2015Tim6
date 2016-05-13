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
	     
	     
		Uposlenik u = new Uposlenik("imePrezime",rodjenje,"jmbg", "brojTelefona","username", "password","uloga");
		
		SefKontroler sk = new SefKontroler();
		boolean b = sk.dodajNovogKorisnika(u);
		
		assertEquals("true",b);
	}

}
