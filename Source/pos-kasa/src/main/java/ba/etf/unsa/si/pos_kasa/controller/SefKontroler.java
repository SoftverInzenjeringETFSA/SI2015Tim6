package ba.etf.unsa.si.pos_kasa.controller;

import java.awt.EventQueue;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Tools.HibernateUtil;
import ba.etf.unsa.si.pos_kasa.model.Smjena;
import ba.etf.unsa.si.pos_kasa.model.Uposlenik;
import ba.etf.unsa.si.pos_kasa.view.BrisanjeArtikla;
import ba.etf.unsa.si.pos_kasa.view.BrisanjeKorisnika;
import ba.etf.unsa.si.pos_kasa.view.BrisanjeKorisnika_PrikazRezultata;
import ba.etf.unsa.si.pos_kasa.view.DodavanjeNovogArtikla;
import ba.etf.unsa.si.pos_kasa.view.DodavanjeNovogKorisnika;
import ba.etf.unsa.si.pos_kasa.view.KreiranjeRacuna;
import ba.etf.unsa.si.pos_kasa.view.OpcijeSefa;
import ba.etf.unsa.si.pos_kasa.view.Popust;
import ba.etf.unsa.si.pos_kasa.view.PretragaArtikla;
import ba.etf.unsa.si.pos_kasa.view.PretragaKorisnika;
import ba.etf.unsa.si.pos_kasa.view.PretragaKorisnika_prikaz;
import ba.etf.unsa.si.pos_kasa.view.messageBox;

public class SefKontroler {

	OpcijeSefa formaZaSefa;
	// instance formi za korisnike
	DodavanjeNovogKorisnika dodavanjeNovogKorisnika;
	BrisanjeKorisnika brisanjeKorisnika;
	PretragaKorisnika pretragaKorisnika;
	PretragaKorisnika_prikaz pretragaKorisnikaPrikaz;
	BrisanjeKorisnika_PrikazRezultata brisanjeKorisnikaPrikazRezultata;
	// instance formi za artikle
	DodavanjeNovogArtikla dodavanjeNovogArtikla;
	BrisanjeArtikla brisanjeArtikla;
	PretragaArtikla pretragaArtikla;
	// instance formi za fiskalni racun
	KreiranjeRacuna kreiranjeRacuna;
	Popust popust;
	// instance formi za odjavu i kraj smjene

	public SefKontroler() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formaZaSefa = new OpcijeSefa(SefKontroler.this);
					formaZaSefa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void prikaziFormuZaUnosKorisnika() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dodavanjeNovogKorisnika = new DodavanjeNovogKorisnika(SefKontroler.this);
					dodavanjeNovogKorisnika.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public boolean dodajNovogKorisnika(Uposlenik uposlenik) {
		Session session = null;
		boolean success = true;
		try {
			// System.out.println("DAJ VISE UNESI try block");
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			session.save(uposlenik);
			t.commit();
		} catch (HibernateException e) {
			// System.out.println("DAJ VISE UNESI cath");
			Logger.getLogger(SefKontroler.class).error(e.getMessage());
			success = false;
		} finally {
			// System.out.println("DAJ VISE UNESI finally");
			if (session != null) {
				session.close();
			}
		}
		return success;
	}

	// pretrazuje bazu i vraca uposlenika ukoliko je pronadjen
	public Uposlenik pronadjiKorisnikaPoJMBG(String JMBG) {

		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("FROM Uposlenik where jmbg= :jmbg");
			query.setParameter("jmbg", JMBG);
			@SuppressWarnings("unchecked")
			List<Uposlenik> uposlenici = query.list();
			if (uposlenici != null && uposlenici.size() == 1) {
				Uposlenik uposlenik = uposlenici.get(0);
				return uposlenik;

			} else {

				messageBox.infoBox("Uposlenik nije pronađen!", "Info o pretragi");
			}
		} catch (HibernateException e) {
			Logger.getLogger(SefKontroler.class).error(e.getMessage());
			messageBox.infoBox("GREŠKA!", "Info o pretragi za brisanje");
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	// za brisanje uposlenika metoda prima uposlenika kao parametar
	public void obrisiKorisnikaPoJMBG(Uposlenik uposlenik) {

		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();

			if (uposlenik.getUloga().equals("Kasir")) {
				messageBox.infoBox("brisemo kasira", "Brisanje uposlenika!!!");
				brisanjeKorisnikaPrikazRezultata.setVisible(false);
				session.delete(uposlenik);
				t.commit();

			} else if (uposlenik.getUloga().equals("Sef")) {
				messageBox.infoBox("brisemo sefa", "Brisanje uposlenika!!!");
				brisanjeKorisnikaPrikazRezultata.setVisible(false);
				brisanjeKorisnika.prikaziButtonZaPrikazRezultataPretrage(false);
				session.delete(uposlenik);
				t.commit();
			}

			else {

				messageBox.infoBox("Greška brisanja!", "Brisanje uposlenika!!!");
			}
		} catch (

		HibernateException e) {
			messageBox.infoBox("GREŠKA exception", "Brisanje uposlenika!!!");
			Logger.getLogger(SefKontroler.class).error(e.getMessage());
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	public void prikaziFormuZaPretraguKorisnika() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pretragaKorisnika = new PretragaKorisnika(SefKontroler.this);
					pretragaKorisnika.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void prikaziFormuZaBrisanjeKorisnika() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					brisanjeKorisnika = new BrisanjeKorisnika(SefKontroler.this);
					brisanjeKorisnika.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void prikaziFormuZaBrisanjeArtikla() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					brisanjeArtikla = new BrisanjeArtikla(SefKontroler.this);
					brisanjeArtikla.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void prikaziFormuZaPretraguArtikla() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pretragaArtikla = new PretragaArtikla(SefKontroler.this);
					pretragaArtikla.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void prikaziFormuZaDodavanjeNovogArtikla() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dodavanjeNovogArtikla = new DodavanjeNovogArtikla(SefKontroler.this);
					dodavanjeNovogArtikla.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void prikaziFormuZaKreiranjeRacuna() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kreiranjeRacuna = new KreiranjeRacuna(SefKontroler.this);
					kreiranjeRacuna.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void prikaziFormuZaDefinisanjePopusta() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					popust = new Popust(SefKontroler.this);
					popust.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// moguca greska u zbog final
	public void prikaziFormuZaPrikazBrisanjaKorisnika(SefKontroler sefKontroler, final Uposlenik uposlenik) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					brisanjeKorisnikaPrikazRezultata = new BrisanjeKorisnika_PrikazRezultata(SefKontroler.this,
							uposlenik);
					brisanjeKorisnikaPrikazRezultata.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void prikaziFormuPretragaKorisnikaPrikaz(SefKontroler sefKontroler, final Uposlenik uposlenik) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pretragaKorisnikaPrikaz = new PretragaKorisnika_prikaz(SefKontroler.this,
							uposlenik);
					pretragaKorisnikaPrikaz.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
