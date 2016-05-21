package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IzvjestajiList {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvjestajiList window = new IzvjestajiList();
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
	public IzvjestajiList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 252, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnPrometPoUposleniku = new JButton("Promet po uposleniku");
		btnPrometPoUposleniku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IzvjUkupanPrometPoUposleniku window = new IzvjUkupanPrometPoUposleniku();
				window.frame.setVisible(true);
			}
		});
		btnPrometPoUposleniku.setBounds(12, 38, 199, 25);
		frame.getContentPane().add(btnPrometPoUposleniku);
		
		JButton btnNewButton = new JButton("Promet po nacinu placanja");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IzvjUkupanPrometPoNP window = new IzvjUkupanPrometPoNP();
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(12, 102, 199, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ukupan promet");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IzvjUkupanPromet window = new IzvjUkupanPromet();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(12, 158, 199, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Stanje zaliha");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IzvjStanjeZalihaAlarm window = new IzvjStanjeZalihaAlarm();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(12, 217, 199, 25);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Broj prodatih artikala");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IzvjestajOBrojuProdatih window = new IzvjestajOBrojuProdatih();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(12, 280, 199, 25);
		frame.getContentPane().add(btnNewButton_3);
	}
}
