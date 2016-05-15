package ba.etf.unsa.si.pos_kasa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;

public class IzvjestajiTest extends TestCase {
//Treba se dopuniti kad se zavrsi Racun
	public void test() throws ParseException
	{
		String date_s = "2016-05-12";  
	     SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
	     Date datum1 = dt.parse(date_s);
	     
	     String date_d = "2016-05-13";  
	     SimpleDateFormat dtd = new SimpleDateFormat("yyyy-MM-dd");
	     Date datum2 = dtd.parse(date_d);
	     
	     Izvjestaji i = new Izvjestaji();
	     //
	     double [] _rezultat = i.dajUkupanPrometIprodateArtikleOdDo(datum1, datum2);
	 
	   assertEquals(0.0,_rezultat[0]);  
	}
}
