package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import ba.etf.unsa.si.pos_kasa.controller.ArtikalKontroler;
import ba.etf.unsa.si.pos_kasa.controller.KategorijaControler;
import ba.etf.unsa.si.pos_kasa.controller.SefKontroler;
import ba.etf.unsa.si.pos_kasa.model.Artikal;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import org.apache.log4j.Logger;

public class PretragaArtikla {

	private JFrame frmPretragaArtikala;
	private JTextField txtPretrazi;
	private JTable tblRezultatiPretrage;
	private SefKontroler sefKontroler;
	
	Object[] kolone = { "Naziv artikla", "Cijena", "Zalihe", "Barkod" };
	DefaultTableModel dtm = new DefaultTableModel();

	
	/**
	 * Create the application.
	 */
	public PretragaArtikla(SefKontroler sefKontroler) {
		this.sefKontroler = sefKontroler;
		initialize();
	}
	public PretragaArtikla() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */

	public void setVisible(boolean visible) {
		this.frmPretragaArtikala.setVisible(visible);
	}

	private void initialize() {
		frmPretragaArtikala = new JFrame();
		frmPretragaArtikala.setTitle("Pretraga Artikala");
		frmPretragaArtikala.setBounds(100, 100, 516, 344);
		frmPretragaArtikala.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frmPretragaArtikala.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frmPretragaArtikala.getHeight()) / 2);
		frmPretragaArtikala.setLocation(x, y);
		
		JLabel lblNewLabel = new JLabel("Način pretrage artikla:");

		final JComboBox cboOdabirNacinaPretrage = new JComboBox();
		cboOdabirNacinaPretrage.setModel(new DefaultComboBoxModel(new String[] { "Naziv", "Barkod", "Kategorija" }));

		txtPretrazi = new JTextField();
		txtPretrazi.setColumns(10);

		tblRezultatiPretrage = new JTable();
		tblRezultatiPretrage
				.setModel(new DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, },
						new String[] { "Naziv artikla", "Cijena", "Zalihe", "Barkod" }));
		dtm.setColumnIdentifiers(kolone);
		tblRezultatiPretrage.setModel(dtm);

		JButton btnPretrazi = new JButton("Pretraži");
		btnPretrazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Object[] redovi = new Object[4];
				List<String> str = new Vector<String>();
				ArtikalKontroler ac = new ArtikalKontroler();
				List<Artikal> lista = new Vector<Artikal>();
				int rowCount = dtm.getRowCount();
				for (int i = rowCount - 1; i >= 0; i--) {
				    dtm.removeRow(i);
				}
				if ((String) cboOdabirNacinaPretrage.getSelectedItem() == "Naziv") {
					lista = ac.vratiSveArtiklePoNazivu((String)txtPretrazi.getText());
					str = ac.vratiRijeci(lista);
				} else if ((String) cboOdabirNacinaPretrage.getSelectedItem() == "Kategorija") {
					lista = ac.vratiSveArtiklePoKategoriji(txtPretrazi.getText());
					str = ac.vratiRijeci(lista);
					
				} else {
					lista = ac.vratiSveArtiklePoBarkodu((String)txtPretrazi.getText());
					str = ac.vratiRijeci(lista);
				}
				
				for (int i = 0; i < str.size(); i++) {
					String[] rijec = ac.vratiRazdovojeno(str.get(i));
					redovi[0] = rijec[0];
					redovi[1] = rijec[1];
					redovi[2] = rijec[2];
					redovi[3] = rijec[3];
					dtm.addRow(redovi);
				}
			}

		});

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblUnesite = new JLabel("Unesite naziv ili šifru u ovisnosti od odabira načina pretrage:");

		JLabel lblRezultatiPretrage = new JLabel("Rezultati pretrage:");
		GroupLayout groupLayout = new GroupLayout(frmPretragaArtikala.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(56).addGroup(groupLayout
						.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
								.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(txtPretrazi).addGap(18).addComponent(btnPretrazi,
														GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblUnesite, Alignment.LEADING))
								.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 400,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblRezultatiPretrage)
										.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel)
												.addGap(18).addComponent(cboOdabirNacinaPretrage,
														GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
								.addGap(25)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(25)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(
						cboOdabirNacinaPretrage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(25).addComponent(lblUnesite).addGap(3)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPretrazi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPretrazi))
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblRezultatiPretrage)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(20, Short.MAX_VALUE)));

		scrollPane.setViewportView(tblRezultatiPretrage);

		frmPretragaArtikala.getContentPane().setLayout(groupLayout);
	}
}
