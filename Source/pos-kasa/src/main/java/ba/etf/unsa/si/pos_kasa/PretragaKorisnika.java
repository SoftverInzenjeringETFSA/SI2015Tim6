package ba.etf.unsa.si.pos_kasa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PretragaKorisnika {

	private JFrame frmPretragaKorisnika;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PretragaKorisnika window = new PretragaKorisnika();
					window.frmPretragaKorisnika.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PretragaKorisnika() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPretragaKorisnika = new JFrame();
		frmPretragaKorisnika.setTitle("Pretraga korisnika");
		frmPretragaKorisnika.setBounds(100, 100, 455, 196);
		frmPretragaKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPretragaKorisnika.getContentPane().setLayout(null);
		
		JLabel lblUnesiteJmbgKorisnika = new JLabel("Unesite JMBG korisnika:");
		lblUnesiteJmbgKorisnika.setBounds(31, 32, 157, 29);
		frmPretragaKorisnika.getContentPane().add(lblUnesiteJmbgKorisnika);
		
		textField = new JTextField();
		textField.setBounds(161, 36, 204, 25);
		frmPretragaKorisnika.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnPronai = new JButton("Pronađi");
		btnPronai.setBounds(217, 73, 96, 29);
		frmPretragaKorisnika.getContentPane().add(btnPronai);
	}
}
