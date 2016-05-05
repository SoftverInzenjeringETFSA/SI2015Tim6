package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class BrisanjeKorisnika {

	private JFrame frmBrisanjeKorisnika;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrisanjeKorisnika window = new BrisanjeKorisnika();
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
	public BrisanjeKorisnika() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBrisanjeKorisnika = new JFrame();
		frmBrisanjeKorisnika.setTitle("Brisanje korisnika");
		frmBrisanjeKorisnika.setBounds(100, 100, 407, 208);
		frmBrisanjeKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBrisanjeKorisnika.getContentPane().setLayout(null);
		
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setBounds(68, 32, 30, 40);
		frmBrisanjeKorisnika.getContentPane().add(lblJmbg);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(120, 38, 162, 23);
		frmBrisanjeKorisnika.getContentPane().add(textArea);
		
		JButton btnPronai = new JButton("Pronađi");
		btnPronai.setBounds(148, 72, 113, 29);
		frmBrisanjeKorisnika.getContentPane().add(btnPronai);
	}
}
