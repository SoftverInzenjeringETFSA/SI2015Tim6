package ba.etf.unsa.si.pos_kasa.controller;

import java.awt.EventQueue;
import ba.etf.unsa.si.pos_kasa.view.PrikazForma;

public class LoginKontroler {
	
	static KasirKontroler kasirKontroler;
	static LoginKontroler loginKontroler;
	static SefKontroler sefKontroler;
	
	PrikazForma loginForma;
	
	
	public static void main(String[] args) {
		loginKontroler = new LoginKontroler();
	}
	
	
	public LoginKontroler() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginForma = new PrikazForma(LoginKontroler.this);
					loginForma.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		//login view prikazati, login metodu pozvati sa viewa
	}
	
	public static  void login(String korisnickoIme, String password) {
		
		//povuci iz baze uposlenika, ako je kasir instancirati kasir kontroler ako je gazda onda sef kontroler
		if(korisnickoIme.equals("kasir") && password.equals("kasir")) {
			kasirKontroler = new KasirKontroler();
		}else if(korisnickoIme.equals("sef") && password.equals("sef")) {
			sefKontroler = new SefKontroler();
		}
	}

}
