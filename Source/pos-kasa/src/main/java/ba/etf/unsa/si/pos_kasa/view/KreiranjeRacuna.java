package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ba.etf.unsa.si.pos_kasa.controller.KasirKontroler;
import ba.etf.unsa.si.pos_kasa.controller.RacunKontroler;
import ba.etf.unsa.si.pos_kasa.controller.SefKontroler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KreiranjeRacuna {

	private JFrame KreiranjeRacuna;
	private JTextField Racun;
	private JTextField Datum;
	private JTextField Kasir;
	private JTextField Barkod;
	private JTextField NazivArtikla;
	private JTextField Kolicina;
	private JTextField Cijena;
	private JTextField Iznos;
	private JTextField UkupniIznos;
	private JTable Stavke;
	private KasirKontroler kasirKontroler;
	private SefKontroler sefKontroler;
	
	/**
	  * @wbp.parser.entryPoint
	  */
	public KreiranjeRacuna()
	{
		initialize();
		setVisible(true);
	}

	public KreiranjeRacuna(KasirKontroler kasirKontroler) {
		this.kasirKontroler = kasirKontroler;
		initialize();
	}
	
	public KreiranjeRacuna(SefKontroler sefKontroler) {
		this.sefKontroler=sefKontroler;
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
		KreiranjeRacuna.setBounds(100, 100, 726, 411);
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
		lblNazivArtikla.setBounds(94, 35, 68, 16);
		lblNazivArtikla.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		JLabel lblKoliina = new JLabel("Količina:");
		lblKoliina.setBounds(178, 35, 47, 16);
		lblKoliina.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		JLabel lblCijena = new JLabel("Cijena:");
		lblCijena.setBounds(262, 35, 36, 16);
		lblCijena.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		JLabel lblIznos = new JLabel("Iznos:");
		lblIznos.setBounds(346, 35, 32, 16);
		lblIznos.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		Barkod = new JTextField();
		Barkod.setBounds(10, 57, 78, 20);
		Barkod.setColumns(10);

		NazivArtikla = new JTextField();
		NazivArtikla.setBounds(94, 57, 78, 20);
		NazivArtikla.setColumns(10);

		Kolicina = new JTextField();
		Kolicina.setBounds(178, 57, 78, 20);
		Kolicina.setColumns(10);

		Cijena = new JTextField();
		Cijena.setBounds(262, 57, 78, 20);
		Cijena.setColumns(10);

		Iznos = new JTextField();
		Iznos.setBounds(346, 57, 78, 20);
		Iznos.setColumns(10);
		StavkeRacuna.setLayout(null);
		StavkeRacuna.add(lblStavkeRauna);
		StavkeRacuna.add(Barkod);
		StavkeRacuna.add(lblBarkod);
		StavkeRacuna.add(NazivArtikla);
		StavkeRacuna.add(lblNazivArtikla);
		StavkeRacuna.add(Kolicina);
		StavkeRacuna.add(lblKoliina);
		StavkeRacuna.add(lblCijena);
		StavkeRacuna.add(Cijena);
		StavkeRacuna.add(lblIznos);
		StavkeRacuna.add(Iznos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 404, 74);
		StavkeRacuna.add(scrollPane);

		Stavke = new JTable();
		Stavke.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Barkod", "Naziv artikla", "Kolicina", "Cijena", "Iznos"
			}
		));
		scrollPane.setViewportView(Stavke);
		
		JButton btnObrisiStavku = new JButton("Obriši stavku");
		btnObrisiStavku.setBounds(308, 188, 106, 23);
		StavkeRacuna.add(btnObrisiStavku);
		
		JButton btnDodajStavku = new JButton("Dodaj stavku");
/*		btnDodajStavku.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0)
			{
				RacunKontroler rk = new RacunKontroler();
	
			}
		});*/
		
		btnDodajStavku.setBounds(192, 188, 106, 23);
		StavkeRacuna.add(btnDodajStavku);
		
		JLabel label = new JLabel("");
		label.setBounds(20, 161, 46, 14);
		StavkeRacuna.add(label);

		JLabel lblElementiRauna = new JLabel("Elementi računa:");
		lblElementiRauna.setFont(new Font("Times New Roman", Font.BOLD, 15));

		JLabel lblRaun = new JLabel("Račun:");
		lblRaun.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		JLabel lblDatum = new JLabel("Datum:");
		lblDatum.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		JLabel lblProdavac = new JLabel("Kasir:");
		lblProdavac.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		JLabel lblNainPlaanja = new JLabel("Način plaćanja:");
		lblNainPlaanja.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		JComboBox NacinPlacanja = new JComboBox();
		NacinPlacanja.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		Racun = new JTextField();
		Racun.setColumns(10);

		Datum = new JTextField();
		Datum.setColumns(10);

		Kasir = new JTextField();
		Kasir.setColumns(10);
		GroupLayout gl_ElementiRacuna = new GroupLayout(ElementiRacuna);
		gl_ElementiRacuna.setHorizontalGroup(
			gl_ElementiRacuna.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ElementiRacuna.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ElementiRacuna.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ElementiRacuna.createSequentialGroup()
							.addGroup(gl_ElementiRacuna.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRaun)
								.addComponent(Racun, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(5)
							.addGroup(gl_ElementiRacuna.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDatum)
								.addComponent(Datum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_ElementiRacuna.createParallelGroup(Alignment.LEADING)
								.addComponent(Kasir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProdavac))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_ElementiRacuna.createParallelGroup(Alignment.LEADING)
								.addComponent(NacinPlacanja, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNainPlaanja)))
						.addComponent(lblElementiRauna))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_ElementiRacuna.setVerticalGroup(
			gl_ElementiRacuna.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ElementiRacuna.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblElementiRauna)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ElementiRacuna.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRaun)
						.addComponent(lblNainPlaanja)
						.addComponent(lblDatum)
						.addComponent(lblProdavac))
					.addGap(4)
					.addGroup(gl_ElementiRacuna.createParallelGroup(Alignment.BASELINE)
						.addComponent(Racun, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Datum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Kasir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(NacinPlacanja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		ElementiRacuna.setLayout(gl_ElementiRacuna);
		KreiranjeRacuna.getContentPane().setLayout(groupLayout);
	}
}
