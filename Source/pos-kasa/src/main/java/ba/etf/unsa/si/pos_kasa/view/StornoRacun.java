package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTextField;

import ba.etf.unsa.si.pos_kasa.controller.RacunKontroler;
import ba.etf.unsa.si.pos_kasa.controller.SefKontroler;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StornoRacun {

	public JFrame frame;
	private JTextField textField;
	final static Logger logger = Logger.getLogger(SefKontroler.class.toString());
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StornoRacun window = new StornoRacun();
					window.frame.setVisible(true);
				} catch (Exception e) {
					String poruka=e.getMessage();
					logger.info(poruka);
					throw new RuntimeException(e);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StornoRacun() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 313, 187);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
		
		JLabel lblBrojOriginalnogRauna = new JLabel("Broj originalnog računa:");
		lblBrojOriginalnogRauna.setBounds(12, 13, 176, 16);
		frame.getContentPane().add(lblBrojOriginalnogRauna);
		
		textField = new JTextField();
		textField.setBounds(12, 42, 252, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Izvrši povrat");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RacunKontroler rk = new RacunKontroler();
				String poruka = rk.kreirajStornoRacun(Long.parseLong(textField.getText()));
				JOptionPane.showMessageDialog(null, poruka);
			}
		});
		btnNewButton.setBounds(86, 88, 124, 25);
		frame.getContentPane().add(btnNewButton);
	}
}
