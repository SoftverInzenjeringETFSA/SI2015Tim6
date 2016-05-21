package ba.etf.unsa.si.pos_kasa.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ba.etf.unsa.si.pos_kasa.controller.SefKontroler;
import ba.etf.unsa.si.pos_kasa.model.Uposlenik;
import ba.etf.unsa.si.pos_kasa.validator.JMBGVerifier;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PretragaKorisnika {

	private JFrame frmPretragaKorisnika;
	private JTextField textFieldJMBG;
    private SefKontroler sefKontroler;
    private Uposlenik uposlenik=null;

	

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
		frmPretragaKorisnika.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPretragaKorisnika.getContentPane().setLayout(null);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frmPretragaKorisnika.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frmPretragaKorisnika.getHeight()) / 2);
		frmPretragaKorisnika.setLocation(x, y);
		
		JLabel lblUnesiteJmbgKorisnika = new JLabel("Unesite JMBG korisnika:");
		lblUnesiteJmbgKorisnika.setBounds(10, 32, 143, 29);
		frmPretragaKorisnika.getContentPane().add(lblUnesiteJmbgKorisnika);
		
		textFieldJMBG = new JTextField();
		textFieldJMBG.setBounds(184, 34, 204, 25);
		frmPretragaKorisnika.getContentPane().add(textFieldJMBG);
		textFieldJMBG.setColumns(10);
		textFieldJMBG.setInputVerifier(new JMBGVerifier(textFieldJMBG, "Unesite Validan JMBG!"));
		
		JButton btnPronai = new JButton("Pronađi");
		btnPronai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uposlenik=sefKontroler.pronadjiKorisnikaPoJMBG(textFieldJMBG.getText());
				if(uposlenik!=null)
				{
				sefKontroler.prikaziFormuPretragaKorisnikaPrikaz(sefKontroler, uposlenik);
				}
			}
		});
		btnPronai.setBounds(217, 72, 117, 29);
		frmPretragaKorisnika.getContentPane().add(btnPronai);
	}
}
