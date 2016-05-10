package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Label;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class FormaKategorije {

	private JFrame frame;
	private JTextField imeKategorijeText;
	private JTextField opisKategorijeText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormaKategorije window = new FormaKategorije();
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
	public FormaKategorije() {
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
		
		imeKategorijeText = new JTextField();
		imeKategorijeText.setBounds(104, 24, 143, 20);
		frame.getContentPane().add(imeKategorijeText);
		imeKategorijeText.setColumns(10);
		
		opisKategorijeText = new JTextField();
		opisKategorijeText.setBounds(104, 55, 143, 20);
		frame.getContentPane().add(opisKategorijeText);
		opisKategorijeText.setColumns(10);
		
		Label label = new Label("   Ime kategorije");
		label.setBounds(10, 24, 88, 22);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label(" Opis kategorije");
		label_1.setBounds(10, 55, 88, 22);
		frame.getContentPane().add(label_1);
		
		JButton dodajKategorijuButton = new JButton("Dodaj");
		dodajKategorijuButton.setBounds(296, 47, 89, 37);
		frame.getContentPane().add(dodajKategorijuButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 299, 153);
		frame.getContentPane().add(scrollPane);
		
		JList listKategorije = new JList();
		scrollPane.setViewportView(listKategorije);
		
		JButton btnObrisi = new JButton("Obrisi");
		btnObrisi.setBounds(335, 219, 89, 32);
		frame.getContentPane().add(btnObrisi);
	}
}
