package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.toedter.calendar.JDateChooser;

import ba.etf.unsa.si.pos_kasa.validator.KolicinaValidator;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class IzvjestajOBrojuProdatih {

	private JFrame frame;
	private JTextField textFieldTop;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvjestajOBrojuProdatih window = new IzvjestajOBrojuProdatih();
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
	public IzvjestajOBrojuProdatih() {
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
		
		JDateChooser dateChooserOd = new JDateChooser();
		dateChooserOd.setBounds(44, 24, 91, 20);
		frame.getContentPane().add(dateChooserOd);
		
		JDateChooser dateChooserDo = new JDateChooser();
		dateChooserDo.setBounds(178, 24, 91, 20);
		frame.getContentPane().add(dateChooserDo);
		
		textFieldTop = new JTextField();
		textFieldTop.setBounds(338, 24, 86, 20);
		frame.getContentPane().add(textFieldTop);
		textFieldTop.setColumns(10);
		textFieldTop.setInputVerifier(new KolicinaValidator(textFieldTop,"Morate unijeti broj!"));
		
		JLabel lblNewLabel = new JLabel("Od:");
		lblNewLabel.setBounds(10, 30, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Do:");
		lblNewLabel_1.setBounds(155, 30, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Top:");
		lblNewLabel_2.setBounds(303, 30, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 97, 351, 132);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Naziv artikla", "Barkod", "Cijena", "Broj prodatih"
			}
		));
		scrollPane.setRowHeaderView(table);
	}
}
