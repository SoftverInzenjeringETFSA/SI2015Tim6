package ba.etf.unsa.si.pos_kasa.view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import ba.etf.unsa.si.pos_kasa.controller.*;
import javax.swing.ListSelectionModel;

public class BrisanjeArtikala {

	private JFrame frame;
	private JTextField textField;
	
	Object[] kolone = { "Naziv artikla", "Cijena","Kolicina","Barkod"};
	DefaultTableModel dtm = new DefaultTableModel();
	private JTable table;
	private String id;
    private SefKontroler sefKontroler;
    final static Logger logger = Logger.getLogger(BrisanjeArtikala.class.toString());
	/**
	 * Launch the application.
	 */
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrisanjeArtikala window = new BrisanjeArtikala();
					window.frame.setVisible(true);
				} catch (Exception e) {
					String poruka=e.getMessage();
					logger.info(poruka);
					throw new RuntimeException(e);
				}
			}
		});
	}
	public BrisanjeArtikala(SefKontroler sefKontroler) {
		this.sefKontroler=sefKontroler;
		initialize();
	}

	/**
	 * Create the application.
	 */
	public BrisanjeArtikala() {
		initialize();
	}
	public void setVisible(boolean visible) {
		this.frame.setVisible(visible);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
		
		JLabel lblNewLabel = new JLabel("Barkod artikla:");
		lblNewLabel.setBounds(76, 36, 93, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(162, 34, 135, 17);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JButton btnPretrazi = new JButton("Pretrazi");
		btnPretrazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Object[] redovi = new Object[4];
				String s=new String();
				ArtikalKontroler ac = new ArtikalKontroler();
				s=ac.vratiArtikleZaBrisanje(textField.getText());
				String[] rijec = ac.vratiRazdovojeno(s);			
				redovi[0] = rijec[0];
				redovi[1] = rijec[1];
				redovi[2] = rijec[2];
				redovi[3] = rijec[3];
				id=rijec[4];
				dtm.addRow(redovi);
			}
		});
		btnPretrazi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnPretrazi.setBounds(322, 32, 89, 23);
		frame.getContentPane().add(btnPretrazi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 83, 368, 43);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Naziv artikla", "Cijena", "Kolicina", "Barkod"
			}
		));
		scrollPane.setViewportView(table);
		
		dtm.setColumnIdentifiers(kolone);
		table.setModel(dtm);
		
		JButton btnObrisi = new JButton("Obrisi artikal");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() != -1) {	           
		           dtm.removeRow(table.getSelectedRow());
		           ArtikalKontroler ac = new ArtikalKontroler();
		           ac.obrisiArtikal(Long.parseLong(id));
		     
		           
		        }
			}
		});
		btnObrisi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnObrisi.setBounds(175, 194, 113, 23);
		frame.getContentPane().add(btnObrisi);
	}
}
