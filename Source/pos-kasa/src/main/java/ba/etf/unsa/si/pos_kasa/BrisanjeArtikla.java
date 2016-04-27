package ba.etf.unsa.si.pos_kasa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
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

public class BrisanjeArtikla {

	private JFrame BrisanjeArtikla;
	private JLabel lblUnesiteifruArtikla;
	private JTextField SifraArtikla;
	private JButton btnPretraga;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrisanjeArtikla window = new BrisanjeArtikla();
					window.BrisanjeArtikla.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BrisanjeArtikla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		BrisanjeArtikla = new JFrame();
		BrisanjeArtikla.setBounds(100, 100, 578, 369);
		BrisanjeArtikla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblUnesiteifruArtikla = new JLabel("Unesite šifru artikla:");
		lblUnesiteifruArtikla.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		SifraArtikla = new JTextField();
		SifraArtikla.setColumns(10);
		
		btnPretraga = new JButton("Pretraga");
		btnPretraga.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JButton btnObrisiArtikal = new JButton("Obriši Artikal");
		btnObrisiArtikal.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(BrisanjeArtikla.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(lblUnesiteifruArtikla, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(SifraArtikla, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnPretraga, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnObrisiArtikal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(SifraArtikla, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnPretraga))
						.addComponent(lblUnesiteifruArtikla))
					.addPreferredGap(ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
					.addComponent(btnObrisiArtikal)
					.addGap(22))
		);
		BrisanjeArtikla.getContentPane().setLayout(groupLayout);
	}
}
