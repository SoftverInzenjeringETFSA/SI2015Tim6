package ba.etf.unsa.si.pos_kasa.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.jboss.logging.Message;

import com.sun.javafx.iio.common.PushbroomScaler;

import ba.etf.unsa.si.pos_kasa.controller.SefKontroler;
import ba.etf.unsa.si.pos_kasa.controller.UposlenikKontroler;
import ba.etf.unsa.si.pos_kasa.model.Uposlenik;

import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPanel;

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
	private SefKontroler sefKontroler;
	private JTextField textDatumRodjenja;
	
	/**
	 * Create the application.
	 */
	public DodavanjeNovogKorisnika(SefKontroler sefKontroler) {
		this.sefKontroler = sefKontroler;
		initialize();
		//groupButton();
	}
	
	public void setVisible(boolean visible) {
		this.DodavnjeNovogKorisnika.setVisible(visible);
	}
	
	
	
	private void initialize() {
		DodavnjeNovogKorisnika = new JFrame();
		DodavnjeNovogKorisnika.setTitle("Dodavanje Novog Korisnika");
		DodavnjeNovogKorisnika.setBounds(100, 100, 391, 431);
		DodavnjeNovogKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DodavnjeNovogKorisnika.getContentPane().setLayout(null);
		

		
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
		
		JLabel lblDatumRoenja = new JLabel("Datum Rođenja:");
		lblDatumRoenja.setBounds(10, 194, 78, 14);
		DodavnjeNovogKorisnika.getContentPane().add(lblDatumRoenja);
		
		textDatumRodjenja = new JTextField();
		textDatumRodjenja.setBounds(120, 186, 167, 20);
		DodavnjeNovogKorisnika.getContentPane().add(textDatumRodjenja);
		textDatumRodjenja.setColumns(10);
		
		JLabel lblUloga = new JLabel("Uloga:");
		lblUloga.setBounds(10, 290, 46, 14);
		DodavnjeNovogKorisnika.getContentPane().add(lblUloga);
		
		JPanel panel = new JPanel();
		panel.setBounds(43, 291, 71, 69);
		DodavnjeNovogKorisnika.getContentPane().add(panel);
		//radio buttons location
		final JRadioButton rdbtnKasir = new JRadioButton("Kasir");
		panel.add(rdbtnKasir);
		
		final JRadioButton rdbtnSef = new JRadioButton("Sef");
		panel.add(rdbtnSef);
		//end of radio button location
		
		//gropuping radio buttons
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnSef);
		group.add(rdbtnKasir);
		
		//adding action listeners to radiobuttons
		//rdbtnSef.addActionListener( rdbtnSef.this);
		//rdbtnKasir.addActionListener((ActionListener) this);
		
		
		JButton btnDodajNovogKorisnika = new JButton("Dodaj Novog Korisnika");
		//action listener za dodavanje novog korisnika 
		btnDodajNovogKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pIme="";
				String pPrezime="";
				String pJMBG="";
				String pKorisnickoIme=textKorIme.getText();
				String pPassword=new String(textPassword.getPassword());
				String pPasswordConfirm=new String(textPasswordConfirm.getPassword());
				String pBrojTel=textBrojTel.getText();
				String pDatumRodjenja= textDatumRodjenja.getText();
				String pUloga="";
				
				//validacije polja ne rade
				if(textIme.equals("")) {
					
					JOptionPane.showMessageDialog(textIme, "Niste unijeli Ime!!");
				}
				else {
					pIme=textIme.getText();
				}
				
				if(textPrezime.equals("")) {
					JOptionPane.showMessageDialog(textPrezime, "Niste unijeli Prezime!!");
				}
				else {
					pPrezime=textPrezime.getText();
				}
				
				if(textJMBG.equals("")) {
					JOptionPane.showMessageDialog(textJMBG, "Niste unijeli JMBG!!");
				}
				else {
					pJMBG=textJMBG.getText();
				}
				
				if(rdbtnKasir.isSelected()) 
				{
					pUloga=rdbtnKasir.getText();
				}
		
				else if(rdbtnSef.isSelected())
					{
						pUloga=rdbtnSef.getText();
						
					}
				else {
					//TODO obavjesti korisnika da nije odabran radio button
					System.out.println("niste odabrali ulogu!!!!");
					
				}
				
				
				System.out.println(pIme+" "+pPrezime+" "+pJMBG+" "+pKorisnickoIme+" "+pPassword+" "+pPasswordConfirm+" "+pBrojTel+" "+pDatumRodjenja+" "+pUloga);
				//TODO Uraditi validacije sve
				//Umjesto datuma rodjenja je new date 
				Uposlenik uposlenik = new Uposlenik(1,pIme+" "+pPrezime, new Date(),pJMBG,pBrojTel,pKorisnickoIme,pPassword,pUloga);
		        if(new UposlenikKontroler().dodajNovogKorisnika(pIme+" "+pPrezime, new Date(),pJMBG,pBrojTel,pKorisnickoIme,pPassword,pUloga)) {
		          System.out.println("Uspjesan unos.");
		        	//odradi nesto
		        }else {
		        	System.out.println("NE VALJA IMPORT korisnika");
		        }
			}
		});
		btnDodajNovogKorisnika.setBounds(120, 302, 167, 23);
		DodavnjeNovogKorisnika.getContentPane().add(btnDodajNovogKorisnika);
		
		
		
		
		
	}
}
