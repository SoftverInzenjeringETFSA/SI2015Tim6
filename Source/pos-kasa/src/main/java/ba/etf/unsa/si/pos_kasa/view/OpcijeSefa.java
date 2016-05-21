package ba.etf.unsa.si.pos_kasa.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import ba.etf.unsa.si.pos_kasa.controller.LoginKontroler;
import ba.etf.unsa.si.pos_kasa.controller.SefKontroler;
import ba.etf.unsa.si.pos_kasa.controller.SmjenaKontroler;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OpcijeSefa {

	private JFrame frmOpcijeefa;
	private JFrame frame;
	private SefKontroler sefKontroler;
	private SmjenaKontroler smjenaKontroler;
	private PopustPromjenaIBrisanje popusti;

	/**
	 * Create the application.
	 */
	/**
	  * @wbp.parser.entryPoint
	  */
	public OpcijeSefa(SefKontroler sefKontroler) {
		this.sefKontroler = sefKontroler;
		initialize();
	}
	public OpcijeSefa(SmjenaKontroler smjenaKontroler) {
		this.smjenaKontroler = smjenaKontroler;
		initialize();
	}

	public void setVisible(boolean visible) {
		this.frmOpcijeefa.setVisible(visible);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public OpcijeSefa(){}

	private void initialize() {
		frmOpcijeefa = new JFrame();
		frmOpcijeefa.setTitle("Opcije Šefa");
		frmOpcijeefa.setBounds(100, 100, 871, 405);
		frmOpcijeefa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOpcijeefa.getContentPane().setLayout(null);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frmOpcijeefa.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frmOpcijeefa.getHeight()) / 2);
		frmOpcijeefa.setLocation(x, y);

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
		panel_1.setBounds(425, 27, 177, 307);
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
		panel_2.setBounds(612, 27, 233, 181);
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
		btnPopust.setBounds(32, 99, 162, 23);
		panel_2.add(btnPopust);
		
		JButton btnPromjenaPopusta = new JButton("Promjena popusta");
		btnPromjenaPopusta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sefKontroler.prikaziFormuZaModifikacijuPopusta();
			}
		});
		btnPromjenaPopusta.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnPromjenaPopusta.setBounds(32, 133, 162, 23);
		panel_2.add(btnPromjenaPopusta);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 128, 128));
		panel_3.setBounds(612, 219, 233, 115);
		frmOpcijeefa.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		final JButton btnNewButton = new JButton("Odjava");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(btnNewButton,"Da li ste sigurni da se želite zaključiti smjenu?");
						if(dialogResult == 0) {
							 // System.out.println("Yes option");
							sefKontroler.odjaviSefa();
							  
						    } else {
							  //System.out.println("No Option");
							} 
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 13));

		btnNewButton.setBounds(10, 11, 99, 35);
		panel_3.add(btnNewButton);

		JButton btnKrajSmjene = new JButton("Kraj smjene");
		btnKrajSmjene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sefKontroler.prikaziFormuZaZakljucivanjeSmjene();
			}
		});

		btnKrajSmjene.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnKrajSmjene.setBounds(119, 11, 104, 35);
		panel_3.add(btnKrajSmjene);
		
		JButton btnPomoc = new JButton("Pomoć");
		btnPomoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String help = "<html><body>" + 
			                  "<h1>Pomoc</h1>" + 
						      "<p>Forma je podijeljena na 6 panela radi lakše preglednosti funkcionalnosti koje se nude</p><br>" +
			                  "<p>Prikazane su sve mogućnosti koje se stavljaju na raspolaganje šefu</p>";
			
			JOptionPane.showMessageDialog(null,help);
			}
		});
		btnPomoc.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnPomoc.setBounds(117, 57, 106, 29);
		panel_3.add(btnPomoc);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(237, 27, 169, 121);
		frmOpcijeefa.getContentPane().add(panel_4);
		panel_4.setBackground(new Color(0, 128, 128));
		panel_4.setLayout(null);
		
		JLabel Kategorije = new JLabel("Kategorije");
		Kategorije.setBounds(10, 11, 58, 16);
		panel_4.add(Kategorije);
		Kategorije.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		JButton btnNewButton_1 = new JButton("Kategorije");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sefKontroler.prikaziFormuKategorije();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_1.setBounds(10, 54, 149, 53);
		panel_4.add(btnNewButton_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(128, 128, 128));
		panel_5.setBounds(237, 169, 169, 165);
		frmOpcijeefa.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Izvjestaji");
		lblNewLabel_1.setBounds(10, 11, 49, 16);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		panel_5.add(lblNewLabel_1);
		
		JButton btnIzvjestaji = new JButton("Izvjestaji");
		btnIzvjestaji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IzvjestajiList window = new IzvjestajiList();
				window.frame.setVisible(true);
			}
		});
		btnIzvjestaji.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnIzvjestaji.setBounds(10, 62, 149, 60);
		panel_5.add(btnIzvjestaji);
	}
}
