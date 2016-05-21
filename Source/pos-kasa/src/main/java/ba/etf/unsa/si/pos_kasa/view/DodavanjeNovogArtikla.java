package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.DropMode;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import ba.etf.unsa.si.pos_kasa.controller.ArtikalKontroler;
import ba.etf.unsa.si.pos_kasa.controller.IzvjestajArtikliControler;
import ba.etf.unsa.si.pos_kasa.controller.KategorijaControler;
import ba.etf.unsa.si.pos_kasa.controller.SefKontroler;
import ba.etf.unsa.si.pos_kasa.validator.CijenaValidator;
import ba.etf.unsa.si.pos_kasa.validator.KolicinaValidator;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import org.apache.log4j.Logger;

public class DodavanjeNovogArtikla {

	private JFrame DodavanjeNovogArtikla;
	private JTextField NazivArtikla;
	private JTextField CijenaArtikla;
	private JTextField Kolicina;
	private JTextField textField;
	private SefKontroler sefKontroler;
	private JTextField textJedinica;
	private JTextField textOpis;
	final static Logger logger = Logger.getLogger(DodavanjeNovogArtikla.class.toString());
	private List<String> kategorijaId;

	/**
	 * Create the application.
	 */
	public void setVisible(boolean visible) {
		this.DodavanjeNovogArtikla.setVisible(visible);
	}

	public DodavanjeNovogArtikla(SefKontroler sefKontroler) {
		this.sefKontroler = sefKontroler;
		initialize();
	}

	public DodavanjeNovogArtikla() {
		initialize();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeNovogArtikla window = new DodavanjeNovogArtikla();
					window.DodavanjeNovogArtikla.setVisible(true);
				} catch (Exception e) {
					String poruka = e.getMessage();
					logger.info(poruka);
					throw new RuntimeException(e);
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DodavanjeNovogArtikla = new JFrame();
		DodavanjeNovogArtikla.setTitle("Dodavanje Novog Artikla");
		DodavanjeNovogArtikla.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		DodavanjeNovogArtikla.setBackground(Color.DARK_GRAY);
		DodavanjeNovogArtikla.setForeground(Color.BLACK);
		DodavanjeNovogArtikla.setBounds(100, 100, 491, 485);
		DodavanjeNovogArtikla.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - DodavanjeNovogArtikla.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - DodavanjeNovogArtikla.getHeight()) / 2);
		DodavanjeNovogArtikla.setLocation(x, y);

		JLabel lblUnesitePodatkeO = new JLabel("Unesite podatke o artiklu:");
		lblUnesitePodatkeO.setBounds(21, 11, 225, 20);
		lblUnesitePodatkeO.setFont(new Font("Times New Roman", Font.BOLD, 17));

		JLabel lblNazivArtikla = new JLabel("Naziv artikla:");
		lblNazivArtikla.setBounds(46, 49, 79, 19);
		lblNazivArtikla.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		JLabel lblCijenaArtikla = new JLabel("Cijena artikla:");
		lblCijenaArtikla.setBounds(50, 132, 75, 17);
		lblCijenaArtikla.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		JLabel lblKoliina = new JLabel("Količina:");
		lblKoliina.setBounds(77, 174, 48, 17);
		lblKoliina.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		JLabel lblifraArtikla = new JLabel("Šifra artikla:");
		lblifraArtikla.setBounds(56, 89, 72, 19);
		lblifraArtikla.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		NazivArtikla = new JTextField();
		NazivArtikla.setBounds(170, 50, 196, 20);
		NazivArtikla.setColumns(10);

		
		CijenaArtikla = new JTextField();
		CijenaArtikla.setBounds(170, 131, 196, 20);
		CijenaArtikla.setColumns(10);
		CijenaArtikla.setInputVerifier(new CijenaValidator(CijenaArtikla, "Cijena artikla mora biti pozitivan broj!"));

		Kolicina = new JTextField();
		Kolicina.setBounds(170, 173, 196, 20);
		Kolicina.setColumns(10);
		Kolicina.setInputVerifier(new KolicinaValidator(Kolicina, "Kolicina mora biti cijeli broj!"));

		textField = new JTextField();
		textField.setBounds(170, 90, 196, 20);
		textField.setColumns(10);

		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(170, 358, 196, 20);
		DodavanjeNovogArtikla.getContentPane().add(comboBox);

		KategorijaControler kc = new KategorijaControler();
		List<String> str = new Vector<String>();
		str = kc.vratiSvaImenaKategorije();
		for (int i = 0; i < str.size(); i++) {
			String[] rijec = kc.vratiRazdovojeno(str.get(i));
			comboBox.addItem(rijec[0] + " " + rijec[1]);
		}
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				KategorijaControler kc = new KategorijaControler();
				ArtikalKontroler ak = new ArtikalKontroler();
				String[] str = kc.vrati((String) comboBox.getSelectedItem());
				Long l;
				if (Kolicina.getText().isEmpty() == false || CijenaArtikla.getText().isEmpty() == false) {
					if(Integer.parseInt(Kolicina.getText())>0 && Double.parseDouble(CijenaArtikla.getText())>0)
					{
						System.out.println(Integer.parseInt(Kolicina.getText()));
					try {

						l = ak.dodajArtikal(NazivArtikla.getText(), Double.parseDouble(CijenaArtikla.getText()),
								textJedinica.getText(), textField.getText(), Integer.parseInt(Kolicina.getText()),
								textOpis.getText(), Long.parseLong(str[0]));

						if (l == -1) {
							JOptionPane.showMessageDialog(null, "BARKOD mora biti u standardnom obliku 1-13!",
									"InfoBox", JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "BARKOD vec postoji!", "InfoBox",
								JOptionPane.INFORMATION_MESSAGE);
						String poruka = e.getMessage();
						logger.info(poruka);

						// throw new RuntimeException(e);
					}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Cijena i kolicina moraju biti pozitivni!", "InfoBox",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Morate popuniti formu!", "InfoBox",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}

		});
		btnDodaj.setBounds(181, 409, 90, 27);
		btnDodaj.setBackground(SystemColor.textHighlight);
		btnDodaj.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		DodavanjeNovogArtikla.getContentPane().setLayout(null);
		DodavanjeNovogArtikla.getContentPane().add(lblUnesitePodatkeO);
		DodavanjeNovogArtikla.getContentPane().add(lblCijenaArtikla);
		DodavanjeNovogArtikla.getContentPane().add(lblNazivArtikla);
		DodavanjeNovogArtikla.getContentPane().add(lblKoliina);
		DodavanjeNovogArtikla.getContentPane().add(lblifraArtikla);
		DodavanjeNovogArtikla.getContentPane().add(textField);
		DodavanjeNovogArtikla.getContentPane().add(CijenaArtikla);
		DodavanjeNovogArtikla.getContentPane().add(Kolicina);
		DodavanjeNovogArtikla.getContentPane().add(NazivArtikla);
		DodavanjeNovogArtikla.getContentPane().add(btnDodaj);

		JLabel lblNewLabel = new JLabel("Jedinica mjere:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(46, 223, 94, 14);
		DodavanjeNovogArtikla.getContentPane().add(lblNewLabel);

		textJedinica = new JTextField();
		textJedinica.setBounds(170, 220, 196, 20);
		DodavanjeNovogArtikla.getContentPane().add(textJedinica);
		textJedinica.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Opis:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(89, 285, 36, 14);
		DodavanjeNovogArtikla.getContentPane().add(lblNewLabel_1);

		textOpis = new JTextField();
		textOpis.setBounds(170, 265, 196, 56);
		DodavanjeNovogArtikla.getContentPane().add(textOpis);
		textOpis.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Kategorija:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(66, 357, 59, 20);
		DodavanjeNovogArtikla.getContentPane().add(lblNewLabel_2);

	}
}
