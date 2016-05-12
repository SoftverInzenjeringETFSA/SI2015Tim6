package ba.etf.unsa.si.pos_kasa.view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import ba.etf.unsa.si.pos_kasa.controller.LoginKontroler;
import javax.swing.JButton;

public class PrikazForma {

	private JFrame PrikazForma;
	private JTextField KorisnickoIme;
	private JTextField Password;
	private LoginKontroler loginKontroler;
	

	/**
	 * Create the application.
	 */
	public PrikazForma(LoginKontroler loginKontroler) {
		this.loginKontroler = loginKontroler;
		initialize();
	}
	
	public void setVisible(boolean visible) {
		this.PrikazForma.setVisible(visible);
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
		Password.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		Password.setBounds(153, 53, 183, 20);
		PrikazForma.getContentPane().add(Password);
		Password.setColumns(10);
		
		JButton btnPrijava = new JButton("Prijava");
		btnPrijava.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnPrijava.setBounds(267, 84, 69, 19);
		PrikazForma.getContentPane().add(btnPrijava);
		
		
		btnPrijava.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				loginKontroler.login(KorisnickoIme.getText(), Password.getText());
			}
		});
	}
}
