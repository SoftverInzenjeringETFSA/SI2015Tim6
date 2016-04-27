package ba.etf.unsa.si.pos_kasa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class PretragaKorisnika_prikaz {

	private JFrame PretragaKorisnika_prikaz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PretragaKorisnika_prikaz window = new PretragaKorisnika_prikaz();
					window.PretragaKorisnika_prikaz.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PretragaKorisnika_prikaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		PretragaKorisnika_prikaz = new JFrame();
		PretragaKorisnika_prikaz.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 13));
		PretragaKorisnika_prikaz.setBounds(100, 100, 450, 300);
		PretragaKorisnika_prikaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblPodaciOKorisniku = new JLabel("Podaci o korisniku:");
		lblPodaciOKorisniku.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		
		JLabel lblImeKorisnika = new JLabel("Ime korisnika");
		lblImeKorisnika.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblPrezimeKorisnika = new JLabel("Prezime korisnika");
		lblPrezimeKorisnika.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblJmbgKorisnika = new JLabel("JMBG korisnika");
		lblJmbgKorisnika.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JButton btnZatvrori = new JButton("Zatvrori");
		btnZatvrori.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(PretragaKorisnika_prikaz.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(153)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblImeKorisnika, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrezimeKorisnika)
								.addComponent(lblJmbgKorisnika)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(lblPodaciOKorisniku, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(169)
							.addComponent(btnZatvrori)))
					.addContainerGap(174, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(lblPodaciOKorisniku)
					.addGap(18)
					.addComponent(lblImeKorisnika, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPrezimeKorisnika)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblJmbgKorisnika)
					.addGap(30)
					.addComponent(btnZatvrori)
					.addContainerGap(66, Short.MAX_VALUE))
		);
		PretragaKorisnika_prikaz.getContentPane().setLayout(groupLayout);
	}
}
