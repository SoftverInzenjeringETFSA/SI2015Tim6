package ba.etf.unsa.si.pos_kasa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Panel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.DropMode;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DodavanjeNovogArtikla {

	private JFrame DodavanjeNovogArtikla;
	private JTextField NazivArtikla;
	private JTextField CijenaArtikla;
	private JTextField Kolicina;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeNovogArtikla window = new DodavanjeNovogArtikla();
					window.DodavanjeNovogArtikla.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DodavanjeNovogArtikla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DodavanjeNovogArtikla = new JFrame();
		DodavanjeNovogArtikla.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		DodavanjeNovogArtikla.setBackground(Color.DARK_GRAY);
		DodavanjeNovogArtikla.setForeground(Color.BLACK);
		DodavanjeNovogArtikla.setBounds(100, 100, 516, 329);
		DodavanjeNovogArtikla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUnesitePodatkeO = new JLabel("Unesite podatke o artiklu:");
		lblUnesitePodatkeO.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		
		JLabel lblNazivArtikla = new JLabel("Naziv artikla:");
		lblNazivArtikla.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblCijenaArtikla = new JLabel("Cijena artikla:");
		lblCijenaArtikla.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel lblKoliina = new JLabel("Količina:");
		lblKoliina.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel lblifraArtikla = new JLabel("Šifra artikla:");
		lblifraArtikla.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		NazivArtikla = new JTextField();
		NazivArtikla.setColumns(10);
		
		CijenaArtikla = new JTextField();
		CijenaArtikla.setColumns(10);
		
		Kolicina = new JTextField();
		Kolicina.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(DodavanjeNovogArtikla.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnDodaj, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(21)
								.addComponent(lblUnesitePodatkeO, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(112)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblCijenaArtikla)
									.addComponent(lblNazivArtikla)
									.addComponent(lblKoliina)
									.addComponent(lblifraArtikla))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
									.addComponent(CijenaArtikla)
									.addComponent(Kolicina)
									.addComponent(NazivArtikla, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)))))
					.addGap(109))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUnesitePodatkeO)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNazivArtikla)
						.addComponent(NazivArtikla, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCijenaArtikla)
						.addComponent(CijenaArtikla, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKoliina)
						.addComponent(Kolicina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblifraArtikla)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(btnDodaj)
					.addContainerGap(57, Short.MAX_VALUE))
		);
		DodavanjeNovogArtikla.getContentPane().setLayout(groupLayout);
	}

}
