package ba.etf.unsa.si.pos_kasa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class DodavanjeNovogKorisnika {

	private JFrame DodavnjeNovogKorisnika;
	private JTextField textIme;
	private JTextField textPrezime;
	private JTextField textJMBG;
	private JTextField textKorIme;
	private JTextField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeNovogKorisnika window = new DodavanjeNovogKorisnika();
					window.DodavnjeNovogKorisnika.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DodavanjeNovogKorisnika() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DodavnjeNovogKorisnika = new JFrame();
		DodavnjeNovogKorisnika.setBounds(100, 100, 377, 300);
		DodavnjeNovogKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DodavnjeNovogKorisnika.getContentPane().setLayout(null);
		
		JButton btnSpremiNovogKorisnika = new JButton("Spremi novog korisnika");
		btnSpremiNovogKorisnika.setForeground(Color.BLACK);
		btnSpremiNovogKorisnika.setBackground(Color.GRAY);
		btnSpremiNovogKorisnika.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnSpremiNovogKorisnika.setBounds(120, 193, 167, 23);
		DodavnjeNovogKorisnika.getContentPane().add(btnSpremiNovogKorisnika);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblIme.setBounds(78, 49, 22, 14);
		DodavnjeNovogKorisnika.getContentPane().add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblPrezime.setBounds(54, 74, 46, 14);
		DodavnjeNovogKorisnika.getContentPane().add(lblPrezime);
		
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblJmbg.setBounds(64, 99, 36, 14);
		DodavnjeNovogKorisnika.getContentPane().add(lblJmbg);
		
		JLabel lblKorisnickoIme = new JLabel("Korisničko ime:");
		lblKorisnickoIme.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblKorisnickoIme.setBounds(21, 124, 82, 14);
		DodavnjeNovogKorisnika.getContentPane().add(lblKorisnickoIme);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblPassword.setBounds(45, 149, 55, 20);
		DodavnjeNovogKorisnika.getContentPane().add(lblPassword);
		
		textIme = new JTextField();
		textIme.setBounds(120, 46, 167, 20);
		DodavnjeNovogKorisnika.getContentPane().add(textIme);
		textIme.setColumns(10);
		
		textPrezime = new JTextField();
		textPrezime.setBounds(120, 71, 167, 20);
		DodavnjeNovogKorisnika.getContentPane().add(textPrezime);
		textPrezime.setColumns(10);
		
		textJMBG = new JTextField();
		textJMBG.setColumns(10);
		textJMBG.setBounds(120, 96, 167, 20);
		DodavnjeNovogKorisnika.getContentPane().add(textJMBG);
		
		textKorIme = new JTextField();
		textKorIme.setColumns(10);
		textKorIme.setBounds(120, 121, 167, 20);
		DodavnjeNovogKorisnika.getContentPane().add(textKorIme);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(120, 149, 167, 20);
		DodavnjeNovogKorisnika.getContentPane().add(textPassword);
	}
}
