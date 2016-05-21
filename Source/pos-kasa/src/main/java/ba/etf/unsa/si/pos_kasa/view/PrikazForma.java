package ba.etf.unsa.si.pos_kasa.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

import org.apache.log4j.Logger;
import org.omg.CORBA.INITIALIZE;

import ba.etf.unsa.si.pos_kasa.controller.LoginKontroler;
import ba.etf.unsa.si.pos_kasa.validator.ImeVerifier;
import ba.etf.unsa.si.pos_kasa.validator.PasswordVerifier;
import ba.etf.unsa.si.pos_kasa.validator.userNameVerifier;

import javax.swing.JButton;

public class PrikazForma {

	private JFrame prikazForma;
	private JTextField korisnickoIme;
	private JTextField password;
	private LoginKontroler loginKontroler;
	JButton btnPrijava;
	PasswordVerifier passwordVer;
	 final static Logger logger = Logger.getLogger(Zakljucivanje.class.toString());
	/**
	 * Create the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrikazForma window = new PrikazForma();
					window.prikazForma.setVisible(true);
				} catch (Exception e) {
					String poruka=e.getMessage();
					logger.info(poruka);
					throw new RuntimeException(e);
				}
			}
		});
	}
	
	public PrikazForma() {
		initialize();
	}

	public PrikazForma(LoginKontroler loginKontroler) {
		this.loginKontroler = loginKontroler;
		initialize();
	}

	public void setVisible(boolean visible) {
		this.prikazForma.setVisible(visible);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		prikazForma = new JFrame();
		prikazForma.setTitle("POS KASA LOGIN");
		prikazForma.setBounds(100, 100, 433, 183);
		prikazForma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		prikazForma.getContentPane().setLayout(null);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - prikazForma.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - prikazForma.getHeight()) / 2);
		prikazForma.setLocation(x, y);
		

		JLabel lblKorisnikoIme = new JLabel("Korisničko ime:");
		lblKorisnikoIme.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblKorisnikoIme.setBounds(61, 23, 87, 19);
		prikazForma.getContentPane().add(lblKorisnikoIme);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblPassword.setBounds(87, 54, 61, 19);
		prikazForma.getContentPane().add(lblPassword);

		korisnickoIme = new JTextField();
		korisnickoIme.setBounds(153, 22, 183, 20);
		prikazForma.getContentPane().add(korisnickoIme);
		korisnickoIme.setColumns(10);
		korisnickoIme.setInputVerifier(new userNameVerifier(korisnickoIme,
				"Polje za unos Username mora biti dužine minimalno 4 i maksimalno 20 slova. "));

		password = new JPasswordField();
		password.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		password.setBounds(153, 53, 183, 20);
		prikazForma.getContentPane().add(password);
		password.setColumns(10);
		password.setInputVerifier(new PasswordVerifier(password,
				"Password mora biti minimalno 8 znakova, imati barem 1 malo, veliko slovo i broj!"));

		btnPrijava = new JButton("Prijava");
		btnPrijava.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnPrijava.setBounds(178, 84, 122, 25);
		prikazForma.getContentPane().add(btnPrijava);

		passwordVer = new PasswordVerifier(password, "");

		btnPrijava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (password.getText().equals("") || !passwordVer.ispravnostLozinke(password))
					return;
				loginKontroler.login(korisnickoIme.getText(), password.getText());
			}
		});
	}

	public void prikaziLoginButton(boolean postavi) {
		btnPrijava.setEnabled(postavi);
	}
}
