package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import ba.etf.unsa.si.pos_kasa.controller.SefKontroler;
import ba.etf.unsa.si.pos_kasa.model.Uposlenik;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BrisanjeKorisnika_PrikazRezultata {

	private JFrame frmBrisanjeKorisnika;

	private SefKontroler sefKontroler;
	private Uposlenik uposlenikParam;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public BrisanjeKorisnika_PrikazRezultata(SefKontroler sefKontroler, Uposlenik u) {
		this.sefKontroler=sefKontroler;
		this.uposlenikParam=u;
		initialize();
	}
	public void setVisible(boolean visible) {
		this.frmBrisanjeKorisnika.setVisible(visible);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBrisanjeKorisnika = new JFrame();
		frmBrisanjeKorisnika.setTitle("Brisanje korisnika");
		frmBrisanjeKorisnika.setBounds(100, 100, 407, 269);
		frmBrisanjeKorisnika.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBrisanjeKorisnika.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Podaci o korisniku:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 25, 123, 19);
		frmBrisanjeKorisnika.getContentPane().add(lblNewLabel);
		
		JLabel lblImeKorisnika = new JLabel(uposlenikParam.getImePrezime());
		lblImeKorisnika.setBounds(148, 53, 225, 19);
		frmBrisanjeKorisnika.getContentPane().add(lblImeKorisnika);
		
		JLabel lblJmbgKorisnika = new JLabel(uposlenikParam.getJmbg());
		lblJmbgKorisnika.setBounds(148, 89, 233, 19);
		frmBrisanjeKorisnika.getContentPane().add(lblJmbgKorisnika);
		
		JButton btnNewButton = new JButton("Izbriši");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sefKontroler.obrisiKorisnikaPoJMBG(uposlenikParam);
				
			}
		});
		btnNewButton.setBounds(148, 197, 89, 23);
		frmBrisanjeKorisnika.getContentPane().add(btnNewButton);
		
		JLabel lblImeIPrezime = new JLabel("Ime i Prezime:");
		lblImeIPrezime.setBounds(10, 61, 100, 14);
		frmBrisanjeKorisnika.getContentPane().add(lblImeIPrezime);
		
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setBounds(10, 91, 46, 14);
		frmBrisanjeKorisnika.getContentPane().add(lblJmbg);
		
		JLabel lblDatumRoenja = new JLabel("Datum Rođenja:");
		lblDatumRoenja.setBounds(10, 123, 100, 14);
		frmBrisanjeKorisnika.getContentPane().add(lblDatumRoenja);
		
		JLabel lblDatumRodjenja = new JLabel(uposlenikParam.getDatumRodjenja());
		lblDatumRodjenja.setBounds(148, 123, 225, 14);
		frmBrisanjeKorisnika.getContentPane().add(lblDatumRodjenja);
		
		JLabel lblBrojTel = new JLabel("Broj Tel:");
		lblBrojTel.setBounds(10, 153, 100, 14);
		frmBrisanjeKorisnika.getContentPane().add(lblBrojTel);
		
		JLabel lblTel = new JLabel(uposlenikParam.getBrojTelefona());
		lblTel.setBounds(148, 153, 225, 14);
		frmBrisanjeKorisnika.getContentPane().add(lblTel);
	}
}
