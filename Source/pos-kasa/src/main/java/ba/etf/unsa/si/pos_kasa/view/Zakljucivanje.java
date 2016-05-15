package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import ba.etf.unsa.si.pos_kasa.controller.SmjenaKontroler;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Timestamp;
import java.awt.event.ActionEvent;

public class Zakljucivanje {

	private JFrame Zakljucivanje;
	private JTextField text_datumSmjene;
	private JTextField text_VrijemeZavrsetkaSmjene;
	private SmjenaKontroler smjenaKontroler;

	/**
	 * Launch the application.
	 */
	
	public Zakljucivanje(SmjenaKontroler smjenaKontroler) {
		this.smjenaKontroler = smjenaKontroler;
		initialize();
	}
	
	public void setVisible(boolean visible) {
		this.Zakljucivanje.setVisible(visible);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zakljucivanje window = new Zakljucivanje();
					window.Zakljucivanje.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					Logger.getLogger(Zakljucivanje.class).error(e.getMessage());
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public Zakljucivanje() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Zakljucivanje = new JFrame();
		Zakljucivanje.setBounds(100, 100, 450, 300);
		Zakljucivanje.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Zakljucivanje.getContentPane().setLayout(null);
		
		JLabel lblDa = new JLabel("Datum:");
		lblDa.setBounds(128, 49, 35, 21);
		Zakljucivanje.getContentPane().add(lblDa);
		
		JLabel lblNewLabel = new JLabel("Vrijeme zavrsetka smjene:");
		lblNewLabel.setBounds(37, 95, 126, 21);
		Zakljucivanje.getContentPane().add(lblNewLabel);
		
		text_datumSmjene = new JTextField();
		text_datumSmjene.setBounds(185, 49, 119, 20);
		Zakljucivanje.getContentPane().add(text_datumSmjene);
		text_datumSmjene.setColumns(10);
		
		text_VrijemeZavrsetkaSmjene = new JTextField();
		text_VrijemeZavrsetkaSmjene.setColumns(10);
		text_VrijemeZavrsetkaSmjene.setBounds(185, 95, 119, 20);
		Zakljucivanje.getContentPane().add(text_VrijemeZavrsetkaSmjene);
		
		JButton btnZakljuciSmjenu = new JButton("Zakljuci smjenu");
		btnZakljuciSmjenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String datum_smjene=(text_datumSmjene).getText();
				String vrijeme_zavrsetka_smjene=(text_VrijemeZavrsetkaSmjene).getText();
				
			}
		});
		btnZakljuciSmjenu.setBounds(135, 201, 113, 23);
		Zakljucivanje.getContentPane().add(btnZakljuciSmjenu);
	}
}

