package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.List;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import ba.etf.unsa.si.pos_kasa.controller.SefKontroler;

import java.awt.SystemColor;

public class BrisanjeArtikla {

	private JFrame BrisanjeArtikla;
	private JLabel lblUnesiteifruArtikla;
	private JTextField SifraArtikla;
	private JButton btnPretraga;
	private JScrollPane scrollPane;
	private JTable Artikli;
    private SefKontroler sefKontroler;

	
	public void setVisible(boolean visible) {
		this.BrisanjeArtikla.setVisible(visible);
	}

	/**
	 * Create the application.
	 */
	public BrisanjeArtikla(SefKontroler sefKontroler) {
		this.sefKontroler=sefKontroler;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		BrisanjeArtikla = new JFrame();
		BrisanjeArtikla.setTitle("Brisanje Artikla");
		BrisanjeArtikla.setBounds(100, 100, 578, 324);
		BrisanjeArtikla.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		lblUnesiteifruArtikla = new JLabel("Unesite šifru artikla:");
		lblUnesiteifruArtikla.setBounds(42, 35, 116, 17);
		lblUnesiteifruArtikla.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		SifraArtikla = new JTextField();
		SifraArtikla.setBounds(162, 30, 254, 20);
		SifraArtikla.setColumns(10);
		
		btnPretraga = new JButton("Pretraži");
		btnPretraga.setBounds(434, 27, 107, 25);
		btnPretraga.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JButton btnObrisiArtikal = new JButton("Obriši Artikal");
		btnObrisiArtikal.setBackground(SystemColor.text);
		btnObrisiArtikal.setBounds(217, 229, 107, 25);
		btnObrisiArtikal.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		BrisanjeArtikla.getContentPane().setLayout(null);
		BrisanjeArtikla.getContentPane().add(lblUnesiteifruArtikla);
		BrisanjeArtikla.getContentPane().add(SifraArtikla);
		BrisanjeArtikla.getContentPane().add(btnPretraga);
		BrisanjeArtikla.getContentPane().add(btnObrisiArtikal);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 63, 459, 138);
		BrisanjeArtikla.getContentPane().add(scrollPane);
		
		Artikli = new JTable();
		Artikli.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Naziv artikla", "Cijena artikla", "Koli\u010Dina", "\u0160ifra artikla"
			}
		));
		scrollPane.setViewportView(Artikli);
	}
}
