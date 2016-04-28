package ba.etf.unsa.si.pos_kasa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpcijeSefa {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpcijeSefa window = new OpcijeSefa();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OpcijeSefa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 765, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setToolTipText("Korisnici");
		panel.setBorder(new LineBorder(new Color(0, 128, 128)));
		panel.setBounds(27, 27, 190, 307);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblKorisnici = DefaultComponentFactory.getInstance().createTitle("Korisnici");
		lblKorisnici.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblKorisnici.setForeground(Color.BLACK);
		lblKorisnici.setBounds(10, 11, 77, 20);
		panel.add(lblKorisnici);
		
		JButton btnDodavanjeKorisnika = new JButton("Dodavanje korisnika");
		btnDodavanjeKorisnika.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnDodavanjeKorisnika.setBounds(10, 52, 155, 57);
		panel.add(btnDodavanjeKorisnika);
		
		JButton btnBrisanjeKorisnika = new JButton("Brisanje korisnika");
		btnBrisanjeKorisnika.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnBrisanjeKorisnika.setBounds(10, 129, 155, 57);
		panel.add(btnBrisanjeKorisnika);
		
		JButton btnPretragaKorisnika = new JButton("Pretraga korisnika");
		btnPretragaKorisnika.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnPretragaKorisnika.setBounds(10, 204, 155, 57);
		panel.add(btnPretragaKorisnika);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 128, 128)));
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(249, 27, 177, 307);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblArtikli = new JLabel("Artikli");
		lblArtikli.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblArtikli.setBounds(21, 11, 57, 16);
		panel_1.add(lblArtikli);
		
		JButton btnDodavanjeArtikla = new JButton("Dodavanje artikla");
		btnDodavanjeArtikla.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnDodavanjeArtikla.setBounds(10, 53, 155, 59);
		panel_1.add(btnDodavanjeArtikla);
		
		JButton btnBrisanjeArtikla = new JButton("Brisanje artikla");
		btnBrisanjeArtikla.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnBrisanjeArtikla.setBounds(10, 130, 155, 59);
		panel_1.add(btnBrisanjeArtikla);
		
		JButton btnPretragaArtikla = new JButton("Pretraga artikla");
		btnPretragaArtikla.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnPretragaArtikla.setBounds(10, 206, 155, 59);
		panel_1.add(btnPretragaArtikla);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 128, 128), 2));
		panel_2.setBackground(new Color(0, 128, 128));
		panel_2.setBounds(478, 27, 233, 142);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fiksalni račun");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 107, 19);
		panel_2.add(lblNewLabel);
		
		JButton btnKreiranjeRauna = new JButton("Kreiranje računa");
		btnKreiranjeRauna.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnKreiranjeRauna.setBounds(32, 41, 162, 47);
		panel_2.add(btnKreiranjeRauna);
		
		JButton btnPopust = new JButton("Popust");
		btnPopust.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnPopust.setBounds(64, 99, 94, 23);
		panel_2.add(btnPopust);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 128, 128));
		panel_3.setBounds(478, 219, 233, 115);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("Odjava");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		
		btnNewButton.setBounds(10, 33, 99, 53);
		panel_3.add(btnNewButton);
		
		JButton btnKrajSmjene = new JButton("Kraj smjene");
		btnKrajSmjene.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnKrajSmjene.setBounds(119, 33, 104, 53);
		panel_3.add(btnKrajSmjene);
	}
}
