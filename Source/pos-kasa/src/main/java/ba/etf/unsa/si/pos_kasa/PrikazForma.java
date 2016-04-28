package ba.etf.unsa.si.pos_kasa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PrikazForma {

	private JFrame PrikazForma;
	private JTextField KorisnickoIme;
	private JTextField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrikazForma window = new PrikazForma();
					window.PrikazForma.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrikazForma() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		PrikazForma = new JFrame();
		PrikazForma.setBounds(100, 100, 433, 183);
		PrikazForma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PrikazForma.getContentPane().setLayout(null);
		
		JLabel lblKorisnikoIme = new JLabel("Korisničko ime:");
		lblKorisnikoIme.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblKorisnikoIme.setBounds(61, 23, 87, 19);
		PrikazForma.getContentPane().add(lblKorisnikoIme);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblPassword.setBounds(87, 54, 61, 19);
		PrikazForma.getContentPane().add(lblPassword);
		
		KorisnickoIme = new JTextField();
		KorisnickoIme.setBounds(153, 22, 183, 20);
		PrikazForma.getContentPane().add(KorisnickoIme);
		KorisnickoIme.setColumns(10);
		
		Password = new JTextField();
		Password.setBounds(153, 53, 183, 20);
		PrikazForma.getContentPane().add(Password);
		Password.setColumns(10);
		
		JButton btnPrijava = new JButton("Prijava");
		btnPrijava.setBounds(267, 84, 69, 19);
		PrikazForma.getContentPane().add(btnPrijava);
	}
}
