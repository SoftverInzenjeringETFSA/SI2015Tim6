package ba.etf.unsa.si.pos_kasa.controller;

import Tools.HibernateUtil;
import ba.etf.unsa.si.pos_kasa.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import org.hibernate.Transaction;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@SuppressWarnings("unused")
public class PopustControler {

	public static void main(String[] args){
	}

	public static Long dodajAkcijaPopust(Date pocetak, Date kraj, String opis, int iznos) throws Exception {

		Long id;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		if (provjeriIspravnost(pocetak, kraj) == true) {
			AkcijaPopust ap = new AkcijaPopust();
			ap.setDatum_pocetka(pocetak);
			ap.setDatum_kraja(kraj);
			ap.setOpis(opis);
			ap.setIznos_popusta(iznos);
			id = (Long) session.save(ap);
			t.commit();
			session.close();
			return id;
		} else {
			throw new Exception("Datum poceta je nakon datuma kraja!");
		}
	}

	public static boolean obrisiAkcijuPopust(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		AkcijaPopust ap = (AkcijaPopust) session.get(AkcijaPopust.class, id);
		if (ap == null) {
			session.close();
			return false;
		} else {
			session.delete(ap);
			t.commit();
			session.close();
			return true;
		}

	}
	public static boolean modificirajAkcijuPopust(Long id, Date pocetak,Date kraj, String opis, int iznos) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		AkcijaPopust ap = (AkcijaPopust) session.get(AkcijaPopust.class, id);
		if (ap == null) {
			session.close();
			return false;
		} else {

			if (provjeriIspravnost(pocetak, kraj) == true) {

				ap.setDatum_pocetka(pocetak);
				ap.setDatum_kraja(kraj);
				ap.setOpis(opis);
				ap.setIznos_popusta(iznos);
				session.update(ap);
				t.commit();
				session.close();
				return true;
			} else {
				throw new Exception("Datum poceta je nakon datuma kraja!");
			}

		}
	}

	public static boolean modificirajAkcijuPopustPocetak(Long id, Date pocetak) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		AkcijaPopust ap = (AkcijaPopust) session.get(AkcijaPopust.class, id);
		if (ap == null) {
			session.close();
			return false;
		} else {

			if (provjeriIspravnost(pocetak, ap.getDatum_kraja()) == true) {

				ap.setDatum_pocetka(pocetak);
				session.update(ap);
				t.commit();
				session.close();
				return true;
			} else {
				throw new Exception("Datum poceta je nakon datuma kraja!");
			}

		}
	}

	public static boolean modificirajAkcijuPopustKraj(Long id, Date kraj) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		AkcijaPopust ap = (AkcijaPopust) session.get(AkcijaPopust.class, id);
		if (ap == null) {
			session.close();
			return false;
		} else {
			if (provjeriIspravnost(ap.getDatum_pocetka(), kraj) == true) {
				ap.setDatum_kraja(kraj);
				session.update(ap);
				t.commit();
				session.close();
				return true;
			} else {
				throw new Exception("Datum kraja je prije datuma pocetka!");
			}

		}
	}

	public static boolean modificirajAkcijuPopustOpis(Long id, String opis) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		AkcijaPopust ap = (AkcijaPopust) session.get(AkcijaPopust.class, id);
		if (ap == null) {
			session.close();
			return false;
		} else {
			ap.setOpis(opis);
			session.update(ap);
			t.commit();
			session.close();
			return true;
		}
	}

	public static boolean modificirajAkcijuPopustIznos(Long id, int iznos) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		AkcijaPopust ap = (AkcijaPopust) session.get(AkcijaPopust.class, id);
		if (ap == null) {
			session.close();
			return false;
		} else {
			ap.setIznos_popusta(iznos);
			session.update(ap);
			t.commit();
			session.close();
			return true;
		}
	}

	public static AkcijaPopust pronadjiAkcijuPopustPoID(Long id) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		AkcijaPopust ap = (AkcijaPopust) session.get(AkcijaPopust.class, id);
		if (ap == null) {
			session.close();
			throw new Exception("Trazena akcija ne postoji!");
		} else {
			session.close();
			return ap;
		}
	}

	public static List<?> vratiSveAkcijaPopust() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		String sql = "select * from tim6.akcijapopust";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(AkcijaPopust.class);
		List<?> results = query.list();
		session.close();
		return results;

	}

	public static boolean provjeriIspravnost(Date pocetak, Date kraj) {
		if (pocetak.after(kraj)) {
			return false;
		} else {
			
			return true;
		}
	}

}
