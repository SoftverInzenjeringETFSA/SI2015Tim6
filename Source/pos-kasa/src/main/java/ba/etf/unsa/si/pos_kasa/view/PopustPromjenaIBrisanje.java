package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;
import org.apache.log4j.Logger;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;

public class PopustPromjenaIBrisanje {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopustPromjenaIBrisanje window = new PopustPromjenaIBrisanje();
					window.frame.setVisible(true);
				} catch (Exception e) {
					Logger.getLogger(PopustPromjenaIBrisanje.class).error(e.getMessage());
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PopustPromjenaIBrisanje() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 215, 110);
		frame.getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JButton btnObrisi = new JButton("Obrisi popust");
		btnObrisi.setBounds(273, 69, 98, 34);
		frame.getContentPane().add(btnObrisi);
		
		JButton btnPromijeniPopust = new JButton("Promijeni Popust");
		btnPromijeniPopust.setBounds(295, 217, 129, 34);
		frame.getContentPane().add(btnPromijeniPopust);
		
		JLabel lblNewLabel = new JLabel("Datum pocetka");
		lblNewLabel.setBounds(10, 151, 79, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Datum kraja");
		lblNewLabel_1.setBounds(127, 151, 71, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Iznos popusta");
		lblNewLabel_3.setBounds(238, 151, 68, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 175, 71, 20);
		frame.getContentPane().add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(127, 176, 68, 20);
		frame.getContentPane().add(dateChooser_1);
		
		textField = new JTextField();
		textField.setBounds(238, 176, 71, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
