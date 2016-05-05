package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

public class Popust {

	private JFrame frmPopust;
	private JTextField txtIznosRacuna;
	private JTextField txtKasir;
	private JLabel lblPopust;
	private JLabel lblIznosRaunaS;
	private JTextField txtIznosRacunaSPopustom;
	private JTextField txtIznosPopusta;
	private JButton btnKreirajPopust;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Popust window = new Popust();
					window.frmPopust.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Popust() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frmPopust = new JFrame();
		frmPopust.setTitle("Popust");
		frmPopust.setBounds(100, 100, 652, 234);
		frmPopust.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtIznosRacuna = new JTextField();
		txtIznosRacuna.setColumns(10);
		
		txtKasir = new JTextField();
		txtKasir.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Iznos računa:");
		
		JLabel lblNazivNekogArtikla = new JLabel("Naziv nekog artikla");
		
		JLabel lblBarkodArtikla = new JLabel("Barkod artikla");
		
		JLabel lblKasir = new JLabel("Kasir:");
		
		lblPopust = new JLabel("Popust:");
		
		lblIznosRaunaS = new JLabel("Iznos računa s popustom:");
		
		txtIznosRacunaSPopustom = new JTextField();
		txtIznosRacunaSPopustom.setColumns(10);
		
		txtIznosPopusta = new JTextField();
		txtIznosPopusta.setColumns(10);
		
		btnKreirajPopust = new JButton("Kreiraj Popust");
		
		JDateChooser dateChooser = new JDateChooser();
		GroupLayout groupLayout = new GroupLayout(frmPopust.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBarkodArtikla)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNazivNekogArtikla)
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(83)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnKreirajPopust)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblKasir)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(txtKasir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(1)
											.addComponent(lblNewLabel)
											.addGap(18)
											.addComponent(txtIznosRacuna, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblIznosRaunaS)
										.addComponent(lblPopust))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtIznosPopusta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtIznosRacunaSPopustom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblKasir)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNazivNekogArtikla)
								.addGap(18)
								.addComponent(lblBarkodArtikla))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(txtIznosRacuna, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel)
									.addComponent(lblPopust)
									.addComponent(txtIznosPopusta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(txtKasir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblIznosRaunaS)
									.addComponent(txtIznosRacunaSPopustom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnKreirajPopust))
					.addContainerGap(169, Short.MAX_VALUE))
		);
		frmPopust.getContentPane().setLayout(groupLayout);
	}
}
