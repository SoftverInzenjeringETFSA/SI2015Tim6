package ba.etf.unsa.si.pos_kasa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import ba.etf.unsa.si.pos_kasa.model.Artikal;
import ba.etf.unsa.si.pos_kasa.model.Uposlenik;
import junit.framework.TestCase;

public class UposlenikKontrolerTest extends TestCase {
	
	public void testDodajUposlenika() throws ParseException
	{
		String date_s = "2016-05-12";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		Date datumZap = dt.parse(date_s);
		
		String _ime_prezime = "ImePrezime";
		String _datum_rodjenja = "DatumRodjenja";
		Date _datum_zaposlenja = datumZap;
		String _jmbg = "JMBG"; 
		String _broj_telefona = "telefon";
		String _username = "username";
		String _password = "password";
		String _uloga = "uloga";
		
		UposlenikKontroler uk = new UposlenikKontroler();
		long id = uk.dodajUposlenika(_ime_prezime, _datum_rodjenja, _datum_zaposlenja, _jmbg, _broj_telefona, _username, _password, _uloga);
	
		Uposlenik u = new Uposlenik();
        try {
			
			u = uk.pronadjiUposlenikaPoID(id);
		
		} catch (Exception e) {
			Logger.getLogger(UposlenikKontroler.class).error(e.getMessage());
		}
		
		assertEquals(u.getImePrezime(),"ImePrezime");
	}
	
	public void testObrisiUposlenika() throws ParseException
	{
		String date_s = "2016-05-12";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		Date datumZap = dt.parse(date_s);
		
		String _ime_prezime = "ImePrezime";
		String _datum_rodjenja = "DatumRodjenja";
		Date _datum_zaposlenja = datumZap;
		String _jmbg = "JMBG"; 
		String _broj_telefona = "telefon";
		String _username = "username";
		String _password = "password";
		String _uloga = "uloga";
		UposlenikKontroler uk = new UposlenikKontroler();
		long id = uk.dodajUposlenika(_ime_prezime, _datum_rodjenja, _datum_zaposlenja, _jmbg, _broj_telefona, _username, _password, _uloga);
		
		try 
		{
			assertEquals(true, uk.obrisiUposlenika(id));
		}
		catch (Exception e)
		{
			Logger.getLogger(UposlenikKontroler.class).error(e.getMessage());
		}
	}
	
	public void testModificirajUposlenika() throws ParseException
	{
		String date_s = "2016-05-12";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		Date datumZap = dt.parse(date_s);
		
		String _ime_prezime = "ImePrezime";
		String _datum_rodjenja = "DatumRodjenja";
		Date _datum_zaposlenja = datumZap;
		String _jmbg = "JMBG"; 
		String _broj_telefona = "telefon";
		String _username = "username";
		String _password = "password";
		String _uloga = "uloga";
		UposlenikKontroler uk = new UposlenikKontroler();
		long id = uk.dodajUposlenika(_ime_prezime, _datum_rodjenja, _datum_zaposlenja, _jmbg, _broj_telefona, _username, _password, _uloga);
		
		//NoviDatum
		String date_a = "2016-05-11";
		SimpleDateFormat dta = new SimpleDateFormat("yyyy-MM-dd");
		Date datumaa = dta.parse(date_a);
		
		try
		{		
		
			assertEquals(true, uk.modificirajUposlenika("Novo","Novo", datumaa, "Novo", "Novo", "Novo", "Novo", "Novo"));
        }
		
		catch (Exception e) 
		{
			
			Logger.getLogger(UposlenikKontroler.class).error(e.getMessage());
		}
	}
	public void testModificirajImePrezimeUposlenika() throws ParseException
	{
		String date_s = "2016-05-12";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		Date datumZap = dt.parse(date_s);
		
		String _ime_prezime = "ImePrezime";
		String _datum_rodjenja = "DatumRodjenja";
		Date _datum_zaposlenja = datumZap;
		String _jmbg = "JMBG"; 
		String _broj_telefona = "telefon";
		String _username = "username";
		String _password = "password";
		String _uloga = "uloga";
		UposlenikKontroler uk = new UposlenikKontroler();
		long id = uk.dodajUposlenika(_ime_prezime, _datum_rodjenja, _datum_zaposlenja, _jmbg, _broj_telefona, _username, _password, _uloga);
		
		
		try
		{		
		
			assertEquals(true,uk.modificirajImePrezimeUposlenika(id, "Novo"));
        }
		
		catch (Exception e) 
		{
			
			Logger.getLogger(UposlenikKontroler.class).error(e.getMessage());
		}
	}
	
	public void testModificirajDatumZaposlenjaUposlenika() throws ParseException
	{
		String date_s = "2016-05-12";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		Date datumZap = dt.parse(date_s);
		
		String _ime_prezime = "ImePrezime";
		String _datum_rodjenja = "DatumRodjenja";
		Date _datum_zaposlenja = datumZap;
		String _jmbg = "JMBG"; 
		String _broj_telefona = "telefon";
		String _username = "username";
		String _password = "password";
		String _uloga = "uloga";
		UposlenikKontroler uk = new UposlenikKontroler();
		long id = uk.dodajUposlenika(_ime_prezime, _datum_rodjenja, _datum_zaposlenja, _jmbg, _broj_telefona, _username, _password, _uloga);
		
		//NoviDatum
		String date_a = "2016-05-11";
		SimpleDateFormat dta = new SimpleDateFormat("yyyy-MM-dd");
		Date datumaa = dta.parse(date_a);
		
		try
		{		
		
			assertEquals(true, uk.modificirajDatumZaposlenjaUposlenika(id, datumaa));
        }
		
		catch (Exception e) 
		{
			
			Logger.getLogger(UposlenikKontroler.class).error(e.getMessage());
		}
	}
	public void testModificirajDatumRodjenjaUposlenika() throws ParseException
	{
		String date_s = "2016-05-12";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		Date datumZap = dt.parse(date_s);
		
		String _ime_prezime = "ImePrezime";
		String _datum_rodjenja = "DatumRodjenja";
		Date _datum_zaposlenja = datumZap;
		String _jmbg = "JMBG"; 
		String _broj_telefona = "telefon";
		String _username = "username";
		String _password = "password";
		String _uloga = "uloga";
		UposlenikKontroler uk = new UposlenikKontroler();
		long id = uk.dodajUposlenika(_ime_prezime, _datum_rodjenja, _datum_zaposlenja, _jmbg, _broj_telefona, _username, _password, _uloga);
		
		try
		{		
		
			assertEquals(true, uk.modificirajDatumRodjenjaUposlenika(id,"Novo"));
        }
		
		catch (Exception e) 
		{
			
			Logger.getLogger(UposlenikKontroler.class).error(e.getMessage());
		}
	}
	public void testModificirajBrojTelefonaUposlenika() throws ParseException
	{
		String date_s = "2016-05-12";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		Date datumZap = dt.parse(date_s);
		
		String _ime_prezime = "ImePrezime";
		String _datum_rodjenja = "DatumRodjenja";
		Date _datum_zaposlenja = datumZap;
		String _jmbg = "JMBG"; 
		String _broj_telefona = "telefon";
		String _username = "username";
		String _password = "password";
		String _uloga = "uloga";
		UposlenikKontroler uk = new UposlenikKontroler();
		long id = uk.dodajUposlenika(_ime_prezime, _datum_rodjenja, _datum_zaposlenja, _jmbg, _broj_telefona, _username, _password, _uloga);
		
		try
		{		
		
			assertEquals(true, uk.modificirajBrojTelefonaUposlenika(id, "Novo"));
        }
		
		catch (Exception e) 
		{
		
			Logger.getLogger(UposlenikKontroler.class).error(e.getMessage());
		}
	}
	public void testModificirajJMBGUposlenika() throws ParseException
	{
		String date_s = "2016-05-12";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		Date datumZap = dt.parse(date_s);
		
		String _ime_prezime = "ImePrezime";
		String _datum_rodjenja = "DatumRodjenja";
		Date _datum_zaposlenja = datumZap;
		String _jmbg = "JMBG"; 
		String _broj_telefona = "telefon";
		String _username = "username";
		String _password = "password";
		String _uloga = "uloga";
		UposlenikKontroler uk = new UposlenikKontroler();
		long id = uk.dodajUposlenika(_ime_prezime, _datum_rodjenja, _datum_zaposlenja, _jmbg, _broj_telefona, _username, _password, _uloga);
		
		try
		{		
		
			assertEquals(true, uk.modificirajJMBGUposlenika(id, "Novo"));
        }
		
		catch (Exception e) 
		{
			
			Logger.getLogger(UposlenikKontroler.class).error(e.getMessage());
		}
	}
	public void testModificirajUsernameUposlenika() throws ParseException
	{
		String date_s = "2016-05-12";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		Date datumZap = dt.parse(date_s);
		
		String _ime_prezime = "ImePrezime";
		String _datum_rodjenja = "DatumRodjenja";
		Date _datum_zaposlenja = datumZap;
		String _jmbg = "JMBG"; 
		String _broj_telefona = "telefon";
		String _username = "username";
		String _password = "password";
		String _uloga = "uloga";
		UposlenikKontroler uk = new UposlenikKontroler();
		long id = uk.dodajUposlenika(_ime_prezime, _datum_rodjenja, _datum_zaposlenja, _jmbg, _broj_telefona, _username, _password, _uloga);
		
		try
		{		
		
			assertEquals(true, uk.modificirajUsernameUposlenika(id, "Novo"));
        }
		
		catch (Exception e) 
		{
			
			Logger.getLogger(UposlenikKontroler.class).error(e.getMessage());
		}
	}
	public void testModificirajPasswordUposlenika() throws ParseException
	{
		String date_s = "2016-05-12";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		Date datumZap = dt.parse(date_s);
		
		String _ime_prezime = "ImePrezime";
		String _datum_rodjenja = "DatumRodjenja";
		Date _datum_zaposlenja = datumZap;
		String _jmbg = "JMBG"; 
		String _broj_telefona = "telefon";
		String _username = "username";
		String _password = "password";
		String _uloga = "uloga";
		UposlenikKontroler uk = new UposlenikKontroler();
		long id = uk.dodajUposlenika(_ime_prezime, _datum_rodjenja, _datum_zaposlenja, _jmbg, _broj_telefona, _username, _password, _uloga);
		
		try
		{		
		
			assertEquals(true, uk.modificirajPasswordUposlenika(id, "Novo"));
        }
		
		catch (Exception e) 
		{
			
			Logger.getLogger(UposlenikKontroler.class).error(e.getMessage());
		}
	}
	public void testModificirajUloguUposlenika() throws ParseException
	{
		String date_s = "2016-05-12";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		Date datumZap = dt.parse(date_s);
		
		String _ime_prezime = "ImePrezime";
		String _datum_rodjenja = "DatumRodjenja";
		Date _datum_zaposlenja = datumZap;
		String _jmbg = "JMBG"; 
		String _broj_telefona = "telefon";
		String _username = "username";
		String _password = "password";
		String _uloga = "uloga";
		UposlenikKontroler uk = new UposlenikKontroler();
		long id = uk.dodajUposlenika(_ime_prezime, _datum_rodjenja, _datum_zaposlenja, _jmbg, _broj_telefona, _username, _password, _uloga);
		
		try
		{		
		
			assertEquals(true, uk.modificirajUloguUposlenika(id, "Novo"));
        }
		
		catch (Exception e) 
		{
			
			Logger.getLogger(UposlenikKontroler.class).error(e.getMessage());
		}
	}
}
