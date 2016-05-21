package ba.etf.unsa.si.pos_kasa.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import ba.etf.unsa.si.pos_kasa.controller.SefKontroler;
import ba.etf.unsa.si.pos_kasa.model.Uposlenik;
import ba.etf.unsa.si.pos_kasa.validator.BrojTelVerifier;
import ba.etf.unsa.si.pos_kasa.validator.DatumRodjenjaVerifier;
import ba.etf.unsa.si.pos_kasa.validator.ImeVerifier;
import ba.etf.unsa.si.pos_kasa.validator.JMBGVerifier;
import ba.etf.unsa.si.pos_kasa.validator.PasswordConfirmVerifier;
import ba.etf.unsa.si.pos_kasa.validator.PasswordVerifier;
import ba.etf.unsa.si.pos_kasa.validator.PrezimeVerifier;
import ba.etf.unsa.si.pos_kasa.validator.userNameVerifier;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class DodavanjeNovogKorisnika {

	private JFrame DodavnjeNovogKorisnika;
	private JTextField textIme;
	private JTextField textPrezime;
	private JTextField textJMBG;
	private JTextField textKorIme;
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
		// groupButton();
	}

	public void setVisible(boolean visible) {
		this.DodavnjeNovogKorisnika.setVisible(visible);
	}

	private void initialize() {
		DodavnjeNovogKorisnika = new JFrame();
		DodavnjeNovogKorisnika.setTitle("Dodavanje Novog Korisnika");
		DodavnjeNovogKorisnika.setBounds(100, 100, 436, 431);
		DodavnjeNovogKorisnika.getContentPane().setLayout(null);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - DodavnjeNovogKorisnika.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - DodavnjeNovogKorisnika.getHeight()) / 2);
		DodavnjeNovogKorisnika.setLocation(x, y);
		
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

		JLabel lblPassword = new JLabel("Lozinka:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblPassword.setBounds(10, 224, 66, 20);
		DodavnjeNovogKorisnika.getContentPane().add(lblPassword);

		textIme = new JTextField();
		textIme.setBounds(120, 49, 167, 20);
		DodavnjeNovogKorisnika.getContentPane().add(textIme);
		textIme.setColumns(10);
		textIme.setInputVerifier(new ImeVerifier(textIme,"Ime mora biti duze od 2 a krace od 20 slova!"));
		
		textPrezime = new JTextField();
		textPrezime.setBounds(120, 74, 167, 20);
		DodavnjeNovogKorisnika.getContentPane().add(textPrezime);
		textPrezime.setColumns(10);
		textPrezime.setInputVerifier(new PrezimeVerifier(textPrezime,"Prezime mora biti duze od 2 a kraće od 25 slova!"));

		textJMBG = new JTextField();
		textJMBG.setColumns(10);
		textJMBG.setBounds(120, 99, 167, 20);
		textJMBG.setInputVerifier(new JMBGVerifier(textJMBG,"JMBG mora imati tačno 13 brojeva i biti validan JMBG!"));
		DodavnjeNovogKorisnika.getContentPane().add(textJMBG);

		textKorIme = new JTextField();
		textKorIme.setColumns(10);
		textKorIme.setBounds(120, 124, 167, 20);
		textKorIme.setInputVerifier(new userNameVerifier(textKorIme,"Korisničko ime mora biti duže od 3 i ne veće od 20 slova!"));
		DodavnjeNovogKorisnika.getContentPane().add(textKorIme);

		JLabel lblPasswordConfirm_1 = new JLabel("Potvrda lozinke:");
		lblPasswordConfirm_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblPasswordConfirm_1.setBounds(10, 257, 100, 23);
		DodavnjeNovogKorisnika.getContentPane().add(lblPasswordConfirm_1);

		JLabel lblBrojTel = new JLabel("Broj tel:");
		lblBrojTel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblBrojTel.setBounds(10, 158, 46, 14);
		
		DodavnjeNovogKorisnika.getContentPane().add(lblBrojTel);

		textBrojTel = new JTextField();
		textBrojTel.setBounds(120, 155, 167, 20);
		DodavnjeNovogKorisnika.getContentPane().add(textBrojTel);
		textBrojTel.setColumns(10);
		textBrojTel.setInputVerifier(new BrojTelVerifier(textBrojTel,"Broj tel mora biti u formatu +xxxxx-xxx-xxx"));

		textPassword = new JPasswordField();
		textPassword.setBounds(120, 224, 167, 20);
		DodavnjeNovogKorisnika.getContentPane().add(textPassword);

		textPasswordConfirm = new JPasswordField();
		textPasswordConfirm.setBounds(120, 258, 167, 20);
		textPassword.setInputVerifier(new PasswordVerifier(textPassword,"Password ne smije biti kraći od 8 znakova, mora sadrzavati malo, veliko slovo i broj!"));
		textPasswordConfirm.setInputVerifier(new PasswordConfirmVerifier(textPasswordConfirm,"Potvrda Lozinke nije uredu. Unesite ispravnu lozinku ili unesite 'promijeni' ukoliko želite izvršiti promijenu lozinke!",textPassword));
		DodavnjeNovogKorisnika.getContentPane().add(textPasswordConfirm);

		JLabel lblDatumRoenja = new JLabel("Datum Rođenja:");
		lblDatumRoenja.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDatumRoenja.setBounds(10, 194, 90, 14);
		DodavnjeNovogKorisnika.getContentPane().add(lblDatumRoenja);

		textDatumRodjenja = new JTextField();
		textDatumRodjenja.setBounds(120, 186, 167, 20);
		DodavnjeNovogKorisnika.getContentPane().add(textDatumRodjenja);
		textDatumRodjenja.setColumns(10);
		textDatumRodjenja.setInputVerifier(new DatumRodjenjaVerifier(textDatumRodjenja,"Datum mora biti u formatu YYYY-MM-DD",textJMBG));

		JLabel lblUloga = new JLabel("Uloga:");
		lblUloga.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblUloga.setBounds(10, 291, 47, 14);
		DodavnjeNovogKorisnika.getContentPane().add(lblUloga);

		JPanel panel = new JPanel();
		panel.setBounds(44, 281, 66, 69);
		DodavnjeNovogKorisnika.getContentPane().add(panel);
		// radio buttons location
		final JRadioButton rdbtnKasir = new JRadioButton("Kasir");
		
		rdbtnKasir.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		panel.add(rdbtnKasir);

		final JRadioButton rdbtnSef = new JRadioButton("Sef");
		
		
		
		
		rdbtnSef.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		panel.add(rdbtnSef);
		// end of radio button location

		// gropuping radio buttons
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnSef);
		group.add(rdbtnKasir);

		final JButton btnDodajNovogKorisnika = new JButton("Dodaj Novog Korisnika");
		btnDodajNovogKorisnika.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnDodajNovogKorisnika.setBounds(120, 302, 167, 23);
		DodavnjeNovogKorisnika.getContentPane().add(btnDodajNovogKorisnika);
		
		
		// action listener za dodavanje novog korisnika
		btnDodajNovogKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(((textIme.getText().equals(""))||(textPrezime.getText().equals(""))||(textJMBG.getText().equals(""))||(textBrojTel.getText().equals(""))||(textDatumRodjenja.getText().equals(""))||(textKorIme.getText().equals(""))|| (new String(textPassword.getPassword()).equals(""))|| (new String(textPasswordConfirm.getPassword()).equals(""))))
				{
					messageBox.infoBox("Niste unijeli sva polja prije klika na dugme Dodaj Novog Korisnika!", "Info o unosu");
					return;
				}
				
                 
				String pIme = "";
				String pPrezime = "";
				String pJMBG = "";
				String pKorisnickoIme = textKorIme.getText();
				String pPassword = new String(textPassword.getPassword());
				String pPasswordConfirm = new String(textPasswordConfirm.getPassword());
				String pBrojTel = textBrojTel.getText();
				String pDatumRodjenja = textDatumRodjenja.getText();
				String pUloga = "";
				
				if(!pPassword.equals(pPasswordConfirm))
				{
					messageBox.infoBox("Potvrda lozinke vam se ne slaže.Unesite potvrdu ponovno.", "Greška");
				}

				pIme = textIme.getText();
				pPrezime = textPrezime.getText();
				pJMBG = textJMBG.getText();

				if (rdbtnKasir.isSelected()) {
					pUloga = rdbtnKasir.getText();
					
					
					
				} else if (rdbtnSef.isSelected()) {
					pUloga = rdbtnSef.getText();
				}
				else {
					messageBox.infoBox("Niste odabrali ulogu prije klika na dugme Dodaj novog korisnika!", "Info o unosu");
					return;
				}
				Uposlenik uposlenik = new Uposlenik(pIme + " " + pPrezime, pDatumRodjenja, pJMBG, pBrojTel, pKorisnickoIme,
						pPassword, pUloga);
				boolean uspjehUnosa=sefKontroler.dodajNovogKorisnika(uposlenik);	
				if (uspjehUnosa==true) {
						//System.out.println("Uspjesan unos.");
						messageBox.infoBox("Uspješan unos korisnika u bazu!", "Info o unosu novog korisnika");
						setVisible(false);
						// odradi nesto
					} else if(uspjehUnosa==false) {
						//System.out.println("NE VALJA IMPORT korisnika");
						messageBox.infoBox("Neuspješan unos korisnika u bazu!", "Info o unosu novog korisnika");
						
					}
					
				
			}

		});
		

	}
}
