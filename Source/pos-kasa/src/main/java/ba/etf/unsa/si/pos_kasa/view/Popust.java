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
	private JLabel lblIznosRaunaS;
	private JTextField txtIznosPopusta;
	private JButton btnKreirajPopust;
	private JLabel label;

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
		frmPopust.setBounds(100, 100, 310, 234);
		frmPopust.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblIznosRaunaS = new JLabel("Iznos popusta:");
		
		txtIznosPopusta = new JTextField();
		txtIznosPopusta.setColumns(10);
		
		btnKreirajPopust = new JButton("Kreiraj Popust");
		
		JDateChooser dateChooser = new JDateChooser();
		
		JLabel lblOdaberiteDatum = new JLabel("Odaberite Datum:");
		
		label = new JLabel("%");
		GroupLayout groupLayout = new GroupLayout(frmPopust.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblOdaberiteDatum)
								.addComponent(lblIznosRaunaS))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtIznosPopusta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label))
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(65)
							.addComponent(btnKreirajPopust, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblOdaberiteDatum)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIznosRaunaS)
						.addComponent(txtIznosPopusta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(18)
					.addComponent(btnKreirajPopust)
					.addContainerGap(70, Short.MAX_VALUE))
		);
		frmPopust.getContentPane().setLayout(groupLayout);
	}
}
