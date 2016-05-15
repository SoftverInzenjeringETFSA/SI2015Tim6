package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.List;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import antlr.collections.impl.Vector;
import ba.etf.unsa.si.pos_kasa.controller.KasirKontroler;
import ba.etf.unsa.si.pos_kasa.controller.RacunKontroler;
import ba.etf.unsa.si.pos_kasa.controller.SefKontroler;
import ba.etf.unsa.si.pos_kasa.model.Artikal;

import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class KreiranjeRacuna {

	private JFrame KreiranjeRacuna;
	private JTextField Barkod;
	private JTextField UkupniIznos;
	private JTable Stavke;
	private KasirKontroler kasirKontroler;
	private SefKontroler sefKontroler;
	double ukupniIznos = 0;
	JComboBox NacinPlacanja;
	JLabel lblDatum;
	JLabel lblKasir;
	JLabel lblRacun;
	JLabel lblIznos;
	JLabel lblCijena;
	JLabel lblNaziv;
	JSpinner spinner;
	Artikal artikal;
	final static Logger logger = Logger.getLogger(KreiranjeRacuna.class.toString());
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KreiranjeRacuna window = new KreiranjeRacuna();
					window.KreiranjeRacuna.setVisible(true);
				} catch (Exception e) {
					String poruka=e.getMessage();
					logger.info(poruka);
					throw new RuntimeException(e);
				}
			}
		});
	}
	
	//NEMOJ DIRAT INACE NE MOZES POZVAT SA FORME ZA SEFA NEKO JE POKVARIO SVE U VEZI ARTIKALA
	public KreiranjeRacuna(SefKontroler sefKontroler) {
		this.sefKontroler=sefKontroler;
		initialize();
		
	}
	
	public KreiranjeRacuna(KasirKontroler kasirKontroler) {
		this.kasirKontroler = kasirKontroler;
		initialize();
		lblDatum.setText(new Date().toString());
		lblKasir.setText(System.getProperty("imePrezime"));
	}
	
	public KreiranjeRacuna()
	{
		/*Properties p = System.getProperties();
		p.put("logged", "true");
		p.put("uloga", "kasir");
		p.put("username", "Hamdo");
		p.put("id", "1");
		System.setProperties(p);
		if(System.getProperty("logged") == "true") // logovan korisnik */
		artikal = new Artikal(); artikal.setCijena(0.0);
		initialize();
		
	}
	
	
	public void setVisible(boolean visible) {
		this.KreiranjeRacuna.setVisible(visible);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		KreiranjeRacuna = new JFrame();
		KreiranjeRacuna.setBounds(100, 100, 816, 411);
		KreiranjeRacuna.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel ElementiRacuna = new JPanel();

		JPanel StavkeRacuna = new JPanel();

		UkupniIznos = new JTextField();
		UkupniIznos.setFont(new Font("Times New Roman", Font.BOLD, 70));
		UkupniIznos.setText("0,00");
		UkupniIznos.setColumns(10);

		JButton btnReklamniRacun = new JButton("Reklamni račun");
		btnReklamniRacun.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
				JButton btntStampajRacun = new JButton("Štampaj račun");
				btntStampajRacun.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				btntStampajRacun.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		GroupLayout groupLayout = new GroupLayout(KreiranjeRacuna.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(ElementiRacuna, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
						.addComponent(StavkeRacuna, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(UkupniIznos, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
						.addComponent(btnReklamniRacun, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
						.addComponent(btntStampajRacun, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(UkupniIznos, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ElementiRacuna, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(StavkeRacuna, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnReklamniRacun)
							.addPreferredGap(ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
							.addComponent(btntStampajRacun)))
					.addContainerGap())
		);

		JLabel lblStavkeRauna = new JLabel("Stavke računa:");
		lblStavkeRauna.setBounds(10, 11, 115, 18);
		lblStavkeRauna.setFont(new Font("Times New Roman", Font.BOLD, 15));

		JLabel lblBarkod = new JLabel("Barkod:");
		lblBarkod.setBounds(10, 35, 41, 16);
		lblBarkod.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		JLabel lblNazivArtikla = new JLabel("Naziv artikla:");
		lblNazivArtikla.setBounds(230, 35, 68, 16);
		lblNazivArtikla.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		JLabel lblKoliina = new JLabel("Količina:");
		lblKoliina.setBounds(153, 35, 47, 16);
		lblKoliina.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		JLabel lblCijenate = new JLabel("Cijena:");
		lblCijenate.setBounds(321, 35, 36, 16);
		lblCijenate.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		JLabel lblIznost = new JLabel("Iznos:");
		lblIznost.setBounds(405, 35, 32, 16);
		lblIznost.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		Barkod = new JTextField();
		Barkod.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					RacunKontroler rk = new RacunKontroler();
					artikal = rk.dajArtikal(Barkod.getText());
					lblNaziv.setText(artikal.getNaziv());
					lblCijena.setText(Double.toString(artikal.getCijena()));
					lblIznos.setText(Double.toString(artikal.getCijena()*(Integer)(spinner.getValue())));
				}
			}
		});
		Barkod.setBounds(10, 57, 132, 20);
		Barkod.setColumns(10);
		StavkeRacuna.setLayout(null);
		StavkeRacuna.add(lblStavkeRauna);
		StavkeRacuna.add(Barkod);
		StavkeRacuna.add(lblBarkod);
		StavkeRacuna.add(lblNazivArtikla);
		StavkeRacuna.add(lblKoliina);
		StavkeRacuna.add(lblCijenate);
		StavkeRacuna.add(lblIznost);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 404, 74);
		StavkeRacuna.add(scrollPane);

		Stavke = new JTable();
		Stavke.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Barkod", "Naziv artikla", "Kolicina", "Cijena", "Iznos"
			}
		));
		scrollPane.setViewportView(Stavke);
		JButton btnObrisiStavku = new JButton("Obriši stavku");
		btnObrisiStavku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selRow = Stavke.getSelectedRow();
				if(selRow != -1){
					DefaultTableModel model = (DefaultTableModel) Stavke.getModel();
					model.removeRow(selRow);
				}
			}
		});
		btnObrisiStavku.setBounds(274, 188, 140, 23);
		StavkeRacuna.add(btnObrisiStavku);
		
		JButton btnDodajStavku = new JButton("Dodaj stavku");
		btnDodajStavku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) Stavke.getModel();
				model.addRow(new Object[]{artikal.getBarkod(), artikal.getNaziv(), spinner.getValue(), artikal.getCijena(), lblIznos.getText()});
				ukupniIznos += Double.parseDouble(lblIznos.getText());
				UkupniIznos.setText(Double.toString(ukupniIznos));
			}
		});
/*		btnDodajStavku.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0)
			{
				RacunKontroler rk = new RacunKontroler();
	
			}
		});*/
		
		btnDodajStavku.setBounds(135, 188, 132, 23);
		StavkeRacuna.add(btnDodajStavku);
		
		JLabel label = new JLabel("");
		label.setBounds(20, 161, 46, 14);
		StavkeRacuna.add(label);
		
		spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblIznos.setText(Double.toString(artikal.getCijena()*(Integer)(spinner.getValue())));
			}
		});
		spinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spinner.setBounds(154, 56, 30, 22);
		StavkeRacuna.add(spinner);
		
		lblNaziv = new JLabel("");
		lblNaziv.setBounds(230, 59, 56, 16);
		StavkeRacuna.add(lblNaziv);
		
		lblCijena = new JLabel("");
		lblCijena.setBounds(321, 59, 56, 16);
		StavkeRacuna.add(lblCijena);
		
		lblIznos = new JLabel("");
		lblIznos.setBounds(402, 59, 56, 16);
		StavkeRacuna.add(lblIznos);

		JLabel lblElementiRauna = new JLabel("Elementi računa:");
		lblElementiRauna.setFont(new Font("Times New Roman", Font.BOLD, 15));

		JLabel lblDatuminf = new JLabel("Datum:");
		lblDatuminf.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		JLabel lblProdavac = new JLabel("Kasir:");
		lblProdavac.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		JLabel lblNainPlaanja = new JLabel("Način plaćanja:");
		lblNainPlaanja.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		NacinPlacanja = new JComboBox();
		NacinPlacanja.setModel(new DefaultComboBoxModel(new String[] {"Gotovina", "Kartica", "Cek", "Virman"}));
		NacinPlacanja.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lblDatum = new JLabel("");
		
		lblKasir = new JLabel("");
		
		lblRacun = new JLabel("");
		GroupLayout gl_ElementiRacuna = new GroupLayout(ElementiRacuna);
		gl_ElementiRacuna.setHorizontalGroup(
			gl_ElementiRacuna.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ElementiRacuna.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ElementiRacuna.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ElementiRacuna.createSequentialGroup()
							.addGroup(gl_ElementiRacuna.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRacun)
								.addGroup(gl_ElementiRacuna.createSequentialGroup()
									.addGap(21)
									.addGroup(gl_ElementiRacuna.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDatum)
										.addComponent(lblDatuminf))))
							.addGap(169)
							.addGroup(gl_ElementiRacuna.createParallelGroup(Alignment.LEADING)
								.addComponent(lblKasir)
								.addComponent(lblProdavac))
							.addGap(67)
							.addGroup(gl_ElementiRacuna.createParallelGroup(Alignment.LEADING)
								.addComponent(NacinPlacanja, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNainPlaanja)))
						.addComponent(lblElementiRauna))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		gl_ElementiRacuna.setVerticalGroup(
			gl_ElementiRacuna.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ElementiRacuna.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblElementiRauna)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ElementiRacuna.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNainPlaanja)
						.addComponent(lblProdavac)
						.addComponent(lblDatuminf))
					.addGap(4)
					.addGroup(gl_ElementiRacuna.createParallelGroup(Alignment.BASELINE)
						.addComponent(NacinPlacanja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblKasir)
						.addComponent(lblRacun)
						.addComponent(lblDatum))
					.addContainerGap())
		);
		ElementiRacuna.setLayout(gl_ElementiRacuna);
		KreiranjeRacuna.getContentPane().setLayout(groupLayout);
	}
}
