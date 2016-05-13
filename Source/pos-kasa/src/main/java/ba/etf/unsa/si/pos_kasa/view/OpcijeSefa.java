package ba.etf.unsa.si.pos_kasa.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import ba.etf.unsa.si.pos_kasa.controller.SefKontroler;
import ba.etf.unsa.si.pos_kasa.controller.UposlenikKontroler;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpcijeSefa {

	private JFrame frmOpcijeefa;
	private SefKontroler sefKontroler;
	
	

	/**
	 * Create the application.
	 */
	public OpcijeSefa(SefKontroler sefKontroler) {
		this.sefKontroler = sefKontroler;
		initialize();
	}

	public void setVisible(boolean visible) {
		this.frmOpcijeefa.setVisible(visible);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOpcijeefa = new JFrame();
		frmOpcijeefa.setTitle("Opcije Šefa");
		frmOpcijeefa.setBounds(100, 100, 765, 405);
		frmOpcijeefa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOpcijeefa.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setToolTipText("Korisnici");
		panel.setBorder(new LineBorder(new Color(0, 128, 128)));
		panel.setBounds(27, 27, 190, 307);
		frmOpcijeefa.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblKorisnici = DefaultComponentFactory.getInstance().createTitle("Korisnici");
		lblKorisnici.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblKorisnici.setForeground(new Color(0, 0, 0));
		lblKorisnici.setBounds(10, 11, 77, 20);
		panel.add(lblKorisnici);

		JButton btnDodavanjeKorisnika = new JButton("Dodavanje korisnika");
		btnDodavanjeKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sefKontroler.prikaziFormuZaUnosKorisnika();
				
			}
		});
		btnDodavanjeKorisnika.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnDodavanjeKorisnika.setBounds(10, 52, 155, 57);
		panel.add(btnDodavanjeKorisnika);

		JButton btnBrisanjeKorisnika = new JButton("Brisanje korisnika");
		btnBrisanjeKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sefKontroler.prikaziFormuZaBrisanjeKorisnika();
			}
		});
		btnBrisanjeKorisnika.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnBrisanjeKorisnika.setBounds(10, 129, 155, 57);
		panel.add(btnBrisanjeKorisnika);

		JButton btnPretragaKorisnika = new JButton("Pretraga korisnika");
		btnPretragaKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sefKontroler.prikaziFormuZaPretraguKorisnika();
			}
		});
		btnPretragaKorisnika.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnPretragaKorisnika.setBounds(10, 204, 155, 57);
		panel.add(btnPretragaKorisnika);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 128, 128)));
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(249, 27, 177, 307);
		frmOpcijeefa.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblArtikli = new JLabel("Artikli");
		lblArtikli.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblArtikli.setBounds(21, 11, 57, 16);
		panel_1.add(lblArtikli);

		JButton btnDodavanjeArtikla = new JButton("Dodavanje artikla");
		btnDodavanjeArtikla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sefKontroler.prikaziFormuZaDodavanjeNovogArtikla();
			}
		});
		btnDodavanjeArtikla.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnDodavanjeArtikla.setBounds(10, 53, 155, 59);
		panel_1.add(btnDodavanjeArtikla);

		JButton btnBrisanjeArtikla = new JButton("Brisanje artikla");
		btnBrisanjeArtikla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			sefKontroler.prikaziFormuZaBrisanjeArtikla();
			}
		});
		btnBrisanjeArtikla.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnBrisanjeArtikla.setBounds(10, 130, 155, 59);
		panel_1.add(btnBrisanjeArtikla);

		JButton btnPretragaArtikla = new JButton("Pretraga artikla");
		btnPretragaArtikla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sefKontroler.prikaziFormuZaPretraguArtikla();
			}
		});
		btnPretragaArtikla.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnPretragaArtikla.setBounds(10, 206, 155, 59);
		panel_1.add(btnPretragaArtikla);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 128, 128), 2));
		panel_2.setBackground(new Color(0, 128, 128));
		panel_2.setBounds(478, 27, 233, 142);
		frmOpcijeefa.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Fiksalni račun");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 107, 19);
		panel_2.add(lblNewLabel);

		JButton btnKreiranjeRauna = new JButton("Kreiranje računa");
		btnKreiranjeRauna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sefKontroler.prikaziFormuZaKreiranjeRacuna();
			}
		});
		btnKreiranjeRauna.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnKreiranjeRauna.setBounds(32, 41, 162, 47);
		panel_2.add(btnKreiranjeRauna);

		JButton btnPopust = new JButton("Popust");
		btnPopust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sefKontroler.prikaziFormuZaDefinisanjePopusta();
			}
		});
		btnPopust.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnPopust.setBounds(64, 99, 94, 23);
		panel_2.add(btnPopust);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 128, 128));
		panel_3.setBounds(478, 219, 233, 115);
		frmOpcijeefa.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JButton btnNewButton = new JButton("Odjava");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 13));

		btnNewButton.setBounds(10, 33, 99, 53);
		panel_3.add(btnNewButton);

		JButton btnKrajSmjene = new JButton("Kraj smjene");
		btnKrajSmjene.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnKrajSmjene.setBounds(119, 33, 104, 53);
		panel_3.add(btnKrajSmjene);
	}
}
