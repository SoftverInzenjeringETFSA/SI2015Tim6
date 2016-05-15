package ba.etf.unsa.si.pos_kasa.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import ba.etf.unsa.si.pos_kasa.model.AkcijaPopust;
import ba.etf.unsa.si.pos_kasa.model.Kategorija;
import junit.framework.TestCase;

public class PopustKontrolerTest extends TestCase {

	public void testDodajAkciju() throws Exception {
		String date_s = "2016-05-12";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		Date datum1 = dt.parse(date_s);

		String date_d = "2016-05-13";
		SimpleDateFormat dtd = new SimpleDateFormat("yyyy-MM-dd");
		Date datum2 = dtd.parse(date_d);

		Date datum_pocetka = datum1;
		Date datum_kraja = datum2;
		String opis = "opis";
		int iznos_popusta = 1;

		PopustControler pc = new PopustControler();
		Long a = pc.dodajAkcijaPopust(datum_pocetka, datum_kraja, opis, iznos_popusta);
		try {
			assertEquals("opis", pc.pronadjiAkcijuPopustPoID(a).getOpis());
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Trazeni popust ne postoji!");
		}
	}

	public void testobrisiAkcijuPopust() throws Exception {
		String date_s = "2016-05-12";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		Date datum1 = dt.parse(date_s);

		String date_d = "2016-05-13";
		SimpleDateFormat dtd = new SimpleDateFormat("yyyy-MM-dd");
		Date datum2 = dtd.parse(date_d);
		//

		Date datum_pocetka = datum1;
		Date datum_kraja = datum2;
		String opis = "opis";
		int iznos_popusta = 1;

		PopustControler pk = new PopustControler();
		Long l;

		l = pk.dodajAkcijaPopust(datum_pocetka, datum_kraja, opis, iznos_popusta);
		try {
			assertEquals(true, pk.obrisiAkcijuPopust(l));
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Trazeni popust ne postoji!");
		}
	}

	public void testModificirajAkcijuPopustPocetak() {
		PopustControler pc = new PopustControler();

		AkcijaPopust a = new AkcijaPopust();

		try {
			String date_s = "2016-05-12";
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
			Date datum1 = dt.parse(date_s);

			String date_d = "2016-05-13";
			SimpleDateFormat dtd = new SimpleDateFormat("yyyy-MM-dd");
			Date datum2 = dtd.parse(date_d);

			Date datum_pocetka = datum1;
			Date datum_kraja = datum2;
			String opis = "opis";
			int iznos_popusta = 1;

			
			Long l = pc.dodajAkcijaPopust(datum_pocetka, datum_kraja, opis, iznos_popusta);
			a = pc.pronadjiAkcijuPopustPoID(l);
			
			String date_a = "2016-05-11";
			SimpleDateFormat dta = new SimpleDateFormat("yyyy-MM-dd");
			Date datumaa = dta.parse(date_a);
			
			pc.modificirajAkcijuPopustPocetak(l, datumaa);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			AkcijaPopust ap = new AkcijaPopust();
			ap=pc.pronadjiAkcijuPopustPoID(l);
			
			Date d=ap.getDatum_pocetka();
			String str=df.format(d);
		
			assertEquals(str,date_a);
			
			
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Datum pocetka je nakon datuma kraja!");
		}
	}

	public void testModificirajAkcijuPopustKraj() {
		String date_s = "2016-05-12";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");

		String date_d = "2016-05-13";
		SimpleDateFormat dtd = new SimpleDateFormat("yyyy-MM-dd");

		String opis = "opis";
		int iznos_popusta = 1;

		PopustControler pc = new PopustControler();

		// noviDatum

		AkcijaPopust a = new AkcijaPopust();

		try {
			Date datum1 = dt.parse(date_s);
			Date datum2 = dtd.parse(date_d);
			Date datum_pocetka = datum1;
			Date datum_kraja = datum2;
			Long l = pc.dodajAkcijaPopust(datum_pocetka, datum_kraja, opis, iznos_popusta);
			String date_a = "2016-05-04";
			SimpleDateFormat dta = new SimpleDateFormat("yyyy-MM-dd");
			Date datumaa = dta.parse(date_a);
			pc.modificirajAkcijuPopustKraj(l, datumaa);
			a = pc.pronadjiAkcijuPopustPoID(l);
			// assertEquals(a.getDatum_kraja(),datumaa);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Datum kraja je prije datuma pocetka!");
		}
	}

	public void testModificirajAkcijuPopustOpis() throws Exception {
		String date_s = "2016-05-12";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		Date datum1 = dt.parse(date_s);

		String date_d = "2016-05-13";
		SimpleDateFormat dtd = new SimpleDateFormat("yyyy-MM-dd");
		Date datum2 = dtd.parse(date_d);

		Date datum_pocetka = datum1;
		Date datum_kraja = datum2;
		String opis = "opis";
		int iznos_popusta = 1;

		PopustControler pc = new PopustControler();
		Long l = pc.dodajAkcijaPopust(datum_pocetka, datum_kraja, opis, iznos_popusta);

		pc.modificirajAkcijuPopustOpis(l, "Novo");

		AkcijaPopust a = new AkcijaPopust();

		try {
			a = pc.pronadjiAkcijuPopustPoID(l);
			assertEquals(a.getOpis(), "Novo");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Trazeni popust ne postoji!");
		}
	}

	public void testModificirajAkcijuPopustIznos() throws Exception {
		String date_s = "2016-05-12";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		Date datum1 = dt.parse(date_s);

		String date_d = "2016-05-13";
		SimpleDateFormat dtd = new SimpleDateFormat("yyyy-MM-dd");
		Date datum2 = dtd.parse(date_d);

		Date datum_pocetka = datum1;
		Date datum_kraja = datum2;
		String opis = "opis";
		int iznos_popusta = 1;

		PopustControler pc = new PopustControler();
		Long l = pc.dodajAkcijaPopust(datum_pocetka, datum_kraja, opis, iznos_popusta);

		pc.modificirajAkcijuPopustIznos(l, 2);

		AkcijaPopust a = new AkcijaPopust();

		try {
			a = pc.pronadjiAkcijuPopustPoID(l);
			assertEquals(a.getIznos_popusta(), 2);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Trazeni popust ne postoji!");
		}
	}

	public void testPronadjiAkcijuPoId() throws Exception {
		String date_s = "2016-05-12";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		Date datum1 = dt.parse(date_s);

		String date_d = "2016-05-13";
		SimpleDateFormat dtd = new SimpleDateFormat("yyyy-MM-dd");
		Date datum2 = dtd.parse(date_d);

		Date datum_pocetka = datum1;
		Date datum_kraja = datum2;
		String opis = "opis";
		int iznos_popusta = 1;

		PopustControler pc = new PopustControler();
		Long l = pc.dodajAkcijaPopust(datum_pocetka, datum_kraja, opis, iznos_popusta);

		AkcijaPopust a = new AkcijaPopust();
		try {
			a = pc.pronadjiAkcijuPopustPoID(l);
			assertEquals(a.getOpis(), "opis");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Trazeni popust ne postoji!");
		}
	}

	public void testProvjeriIspravnost() throws ParseException {
		String date_s = "2016-05-12";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		Date datum1 = dt.parse(date_s);

		String date_d = "2016-05-13";
		SimpleDateFormat dtd = new SimpleDateFormat("yyyy-MM-dd");
		Date datum2 = dtd.parse(date_d);

		Date datum_pocetka = datum1;
		Date datum_kraja = datum2;
		String opis = "opis";
		int iznos_popusta = 1;

		PopustControler pc = new PopustControler();
		assertEquals(true, pc.provjeriIspravnost(datum_pocetka, datum_kraja));
	}
}
