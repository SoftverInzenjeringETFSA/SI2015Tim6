package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ba.etf.unsa.si.pos_kasa.controller.SefKontroler;

import javax.swing.JButton;

public class PretragaKorisnika {

	private JFrame frmPretragaKorisnika;
	private JTextField textField;
    private SefKontroler sefKontroler;

	

	/**
	 * Create the application.
	 */
	public PretragaKorisnika(SefKontroler sefKontroler) {
		this.sefKontroler = sefKontroler;
		initialize();
	}
	
	public void setVisible(boolean visible) {
		this.frmPretragaKorisnika.setVisible(visible);
	}
 
	
	private void initialize() {
		frmPretragaKorisnika = new JFrame();
		frmPretragaKorisnika.setTitle("Pretraga korisnika");
		frmPretragaKorisnika.setBounds(100, 100, 455, 196);
		frmPretragaKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPretragaKorisnika.getContentPane().setLayout(null);
		
		JLabel lblUnesiteJmbgKorisnika = new JLabel("Unesite JMBG korisnika:");
		lblUnesiteJmbgKorisnika.setBounds(31, 32, 157, 29);
		frmPretragaKorisnika.getContentPane().add(lblUnesiteJmbgKorisnika);
		
		textField = new JTextField();
		textField.setBounds(161, 36, 204, 25);
		frmPretragaKorisnika.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnPronai = new JButton("Pronađi");
		btnPronai.setBounds(207, 72, 117, 29);
		frmPretragaKorisnika.getContentPane().add(btnPronai);
	}
}
