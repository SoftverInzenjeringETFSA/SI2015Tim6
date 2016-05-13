package ba.etf.unsa.si.pos_kasa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ba.etf.unsa.si.pos_kasa.model.*;

import junit.framework.TestCase;

public class UposlenikKontrolerTest extends TestCase {

	 public void testDodajUposlenika() throws ParseException
	 {
	     String date_s = "1993-04-08";  
	     SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
	     Date date = dt.parse(date_s);
		 
		 String _imePrezime = "ImePrezime"; 
		 Date _datumRodjenja = date;
		 String _jmbg = "JMBG";
		 String _brojTelefona = "BrojTelefona";
		 String _username = "UserName";
		 String _password = "Password";
		 String _uloga = "Uloga";
		 
		 UposlenikKontroler uk = new UposlenikKontroler ();
		 
		 assertTrue(uk.dodajNovogKorisnika(_imePrezime, _datumRodjenja, _jmbg, _brojTelefona, _username, _password, _uloga));
	 }
}
