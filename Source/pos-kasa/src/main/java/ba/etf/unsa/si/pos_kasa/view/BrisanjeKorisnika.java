package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTextArea;

import ba.etf.unsa.si.pos_kasa.controller.SefKontroler;
import ba.etf.unsa.si.pos_kasa.model.Uposlenik;
import ba.etf.unsa.si.pos_kasa.validator.JMBGVerifier;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BrisanjeKorisnika {

	private JFrame frmBrisanjeKorisnika;
	private SefKontroler sefKontroler;
	private JTextField textJMBGBrisanje;
	private JButton btnPrikaziRezultatePretrage;
	private Uposlenik u=null;
	/**
	 * Create the application.
	 */
	public BrisanjeKorisnika(SefKontroler sefKontroler) {
		this.sefKontroler = sefKontroler;
		initialize();
	}
	
	public void setVisible(boolean visible) {
		this.frmBrisanjeKorisnika.setVisible(visible);
	  //this.btnPrikaziRezultatePretrage.setEnabled(true);
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBrisanjeKorisnika = new JFrame();
		frmBrisanjeKorisnika.setTitle("Brisanje korisnika");
		frmBrisanjeKorisnika.setBounds(100, 100, 407, 208);
		frmBrisanjeKorisnika.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBrisanjeKorisnika.getContentPane().setLayout(null);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frmBrisanjeKorisnika.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frmBrisanjeKorisnika.getHeight()) / 2);
		frmBrisanjeKorisnika.setLocation(x, y);
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setBounds(77, 32, 47, 23);
		frmBrisanjeKorisnika.getContentPane().add(lblJmbg);
		
		JButton btnPronai = new JButton("Pronađi");
		btnPronai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ovdje se poziva forma za prikaz korisnika za brisanje
			 u= sefKontroler.pronadjiKorisnikaPoJMBG(textJMBGBrisanje.getText());
				if(u!=null) {
					prikaziButtonZaPrikazRezultataPretrage(true);
				}
			}
		});
		btnPronai.setBounds(134, 66, 138, 23);
		frmBrisanjeKorisnika.getContentPane().add(btnPronai);
		
		textJMBGBrisanje = new JTextField();
		textJMBGBrisanje.setBounds(134, 33, 138, 20);
		frmBrisanjeKorisnika.getContentPane().add(textJMBGBrisanje);
		textJMBGBrisanje.setColumns(10);
		textJMBGBrisanje.setInputVerifier(new JMBGVerifier(textJMBGBrisanje, "Unesite validan JMBG!"));
		
		//button koji treba ili ne treba da se prikaze
		btnPrikaziRezultatePretrage = new JButton("Prikaži rezultate pretrage");
		btnPrikaziRezultatePretrage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sefKontroler.prikaziFormuZaPrikazBrisanjaKorisnika(sefKontroler,u);
			}
		});
		btnPrikaziRezultatePretrage.setEnabled(false);
		btnPrikaziRezultatePretrage.setBounds(10, 136, 182, 23);
		//prikaziButtonZaPrikazRezultataPretrage();
		frmBrisanjeKorisnika.getContentPane().add(btnPrikaziRezultatePretrage);
		

		
	}

	public void prikaziButtonZaPrikazRezultataPretrage(boolean postavi) {
		this.btnPrikaziRezultatePretrage.setEnabled(postavi);
		
	}

	
}
