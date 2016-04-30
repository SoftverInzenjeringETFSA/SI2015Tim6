package ba.etf.unsa.si.pos_kasa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FormaZaKasira {

	private JFrame frmKasa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormaZaKasira window = new FormaZaKasira();
					window.frmKasa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormaZaKasira() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKasa = new JFrame();
		frmKasa.setTitle("Kasa");
		frmKasa.setBounds(100, 100, 435, 409);
		frmKasa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnKreiranjeRacuna = new JButton("Kreiranje Računa");
		
		JButton btnKreiranjeIzvjestaja = new JButton("Kreiranje izvještaja po završetku smjene");
		
		JButton btnProvjeraStanjaArtikala = new JButton("Provjera stanja artikala");
		GroupLayout groupLayout = new GroupLayout(frmKasa.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(97)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnProvjeraStanjaArtikala, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnKreiranjeIzvjestaja, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnKreiranjeRacuna, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
					.addGap(110))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(57)
					.addComponent(btnKreiranjeRacuna, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(btnKreiranjeIzvjestaja, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(btnProvjeraStanjaArtikala, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(164, Short.MAX_VALUE))
		);
		frmKasa.getContentPane().setLayout(groupLayout);
	}

}
