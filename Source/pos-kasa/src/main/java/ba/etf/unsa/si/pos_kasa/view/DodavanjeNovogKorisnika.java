package ba.etf.unsa.si.pos_kasa.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import ba.etf.unsa.si.pos_kasa.controller.UposlenikKontroler;

public class DodavanjeNovogKorisnika {

	private JFrame DodavnjeNovogKorisnika;
	private JTextField textIme;
	private JTextField textPrezime;
	private JTextField textJMBG;
	private JTextField textKorIme;
	private JLabel lblBrojTel;
	private JTextField textBrojTel;
	private JPasswordField textPassword;
	private JPasswordField textPasswordConfirm;
	
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
		DodavnjeNovogKorisnika.setBounds(100, 100, 404, 520);
		DodavnjeNovogKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DodavnjeNovogKorisnika.getContentPane().setLayout(null);
		
		JButton btnSpremiNovogKorisnika = new JButton("Spremi novog korisnika");
		btnSpremiNovogKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pIme=textIme.getText();
				String pPrezime=textPrezime.getText();
				String pJMBG=textJMBG.getText();
				String pKorisnickoIme=textKorIme.getText();
				String pPassword=new String(textPassword.getPassword());
				String pPasswordConfirm=new String(textPasswordConfirm.getPassword());
				String pBrojTel=textBrojTel.getText();
				
				//System.out.println(pIme+" "+pPrezime+" "+pJMBG+" "+pKorisnickoIme+" "+pPassword+" "+pPasswordConfirm+" "+pBrojTel);
				//TODO Uraditi validacije sve
				//Umjesto datuma rodjenja je new date 
				/*Kasir kasir = new Kasir(pIme+" "+pPrezime, new Date(),pJMBG,pBrojTel);
		        if(new UposlenikKontroler().dodajNovogKorisnika(kasir)) {
		        	//uspjesno spasen novi korisnik
		        	//odradi nesto
		        }else {
		        	//korisnik nije spasen odradi nesto
		        }*/
				
			}
		});
		btnSpremiNovogKorisnika.setForeground(Color.BLACK);
		btnSpremiNovogKorisnika.setBackground(new Color(128, 128, 128));
		btnSpremiNovogKorisnika.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnSpremiNovogKorisnika.setBounds(120, 359, 167, 23);
		DodavnjeNovogKorisnika.getContentPane().add(btnSpremiNovogKorisnika);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblIme.setBounds(10, 47, 33, 14);
		DodavnjeNovogKorisnika.getContentPane().add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblPrezime.setBounds(10, 72, 57, 14);
		DodavnjeNovogKorisnika.getContentPane().add(lblPrezime);
		
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setBackground(new Color(255, 255, 255));
		lblJmbg.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblJmbg.setBounds(10, 97, 47, 14);
		DodavnjeNovogKorisnika.getContentPane().add(lblJmbg);
		
		JLabel lblKorisnickoIme = new JLabel("Korisničko ime:");
		lblKorisnickoIme.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblKorisnickoIme.setBounds(10, 125, 90, 14);
		DodavnjeNovogKorisnika.getContentPane().add(lblKorisnickoIme);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblPassword.setBounds(10, 224, 66, 20);
		DodavnjeNovogKorisnika.getContentPane().add(lblPassword);
		
		textIme = new JTextField();
		textIme.setBounds(120, 49, 167, 20);
		DodavnjeNovogKorisnika.getContentPane().add(textIme);
		textIme.setColumns(10);
		
		textPrezime = new JTextField();
		textPrezime.setBounds(120, 74, 167, 20);
		DodavnjeNovogKorisnika.getContentPane().add(textPrezime);
		textPrezime.setColumns(10);
		
		textJMBG = new JTextField();
		textJMBG.setColumns(10);
		textJMBG.setBounds(120, 99, 167, 20);
		DodavnjeNovogKorisnika.getContentPane().add(textJMBG);
		
		textKorIme = new JTextField();
		textKorIme.setColumns(10);
		textKorIme.setBounds(120, 124, 167, 20);
		DodavnjeNovogKorisnika.getContentPane().add(textKorIme);
		
		JLabel lblPasswordConfirm_1 = new JLabel("Password Confirm:");
		lblPasswordConfirm_1.setBounds(10, 257, 90, 23);
		DodavnjeNovogKorisnika.getContentPane().add(lblPasswordConfirm_1);
		
		lblBrojTel = new JLabel("Broj tel:");
		lblBrojTel.setBounds(10, 158, 46, 14);
		DodavnjeNovogKorisnika.getContentPane().add(lblBrojTel);
		
		textBrojTel = new JTextField();
		textBrojTel.setBounds(120, 155, 167, 20);
		DodavnjeNovogKorisnika.getContentPane().add(textBrojTel);
		textBrojTel.setColumns(10);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(120, 224, 167, 20);
		DodavnjeNovogKorisnika.getContentPane().add(textPassword);
		
		textPasswordConfirm = new JPasswordField();
		textPasswordConfirm.setBounds(120, 258, 167, 20);
		DodavnjeNovogKorisnika.getContentPane().add(textPasswordConfirm);
		
		
	}
}
