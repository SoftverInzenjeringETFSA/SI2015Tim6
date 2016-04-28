package ba.etf.unsa.si.pos_kasa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class BrisanjeKorisnika_PrikazRezultata {

	private JFrame frmBrisanjeKorisnika;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrisanjeKorisnika_PrikazRezultata window = new BrisanjeKorisnika_PrikazRezultata();
					window.frmBrisanjeKorisnika.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BrisanjeKorisnika_PrikazRezultata() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBrisanjeKorisnika = new JFrame();
		frmBrisanjeKorisnika.setTitle("Brisanje korisnika");
		frmBrisanjeKorisnika.setBounds(100, 100, 298, 250);
		frmBrisanjeKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBrisanjeKorisnika.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Podaci o korisniku:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(26, 23, 123, 19);
		frmBrisanjeKorisnika.getContentPane().add(lblNewLabel);
		
		JLabel lblImeKorisnika = new JLabel("Ime korisnika");
		lblImeKorisnika.setBounds(92, 53, 101, 19);
		frmBrisanjeKorisnika.getContentPane().add(lblImeKorisnika);
		
		JLabel lblPrezimeKorisnika = new JLabel("Prezime korisnika");
		lblPrezimeKorisnika.setBounds(92, 79, 101, 19);
		frmBrisanjeKorisnika.getContentPane().add(lblPrezimeKorisnika);
		
		JLabel lblJmbgKorisnika = new JLabel("JMBG korisnika");
		lblJmbgKorisnika.setBounds(92, 107, 101, 19);
		frmBrisanjeKorisnika.getContentPane().add(lblJmbgKorisnika);
		
		JButton btnNewButton = new JButton("Izbriši");
		btnNewButton.setBounds(87, 137, 89, 23);
		frmBrisanjeKorisnika.getContentPane().add(btnNewButton);
	}
}
