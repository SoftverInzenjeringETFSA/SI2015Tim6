package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import ba.etf.unsa.si.pos_kasa.controller.*;

public class IzvjStanjeZalihaAlarm {

	private JFrame frame;
	private JTable table;
	Object[] kolone = { "Artikal", "Sifra", "Zalihe" };
	DefaultTableModel dtm = new DefaultTableModel();
	final static Logger logger = Logger.getLogger(IzvjStanjeZalihaAlarm.class.toString());
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvjStanjeZalihaAlarm window = new IzvjStanjeZalihaAlarm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
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
	public IzvjStanjeZalihaAlarm() {
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
		scrollPane.setBounds(10, 11, 414, 161);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		dtm.setColumnIdentifiers(kolone);

		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Artikal", "Sifra", "Zalihe" }));
		table.setModel(dtm);
		scrollPane.setViewportView(table);

		JButton btnIzvjestajZalihe = new JButton("Prikazi izvjestaj");
		btnIzvjestajZalihe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] redovi = new Object[3];
				IzvjestajArtikliControler iac = new IzvjestajArtikliControler();
				List<String> str = new Vector<String>(); 
				str=iac.vratiArtikleZaIzvjestaj();
				for (int i = 0; i < str.size(); i++) {
					String[] rijec = iac.vratiRazdovojeno(str.get(i));
					redovi[0] = rijec[0];
					redovi[1] = rijec[1];
					redovi[2] = rijec[2];
					dtm.addRow(redovi);
				}
			}
		});
		btnIzvjestajZalihe.setBounds(149, 205, 131, 46);
		frame.getContentPane().add(btnIzvjestajZalihe);
	}
}
