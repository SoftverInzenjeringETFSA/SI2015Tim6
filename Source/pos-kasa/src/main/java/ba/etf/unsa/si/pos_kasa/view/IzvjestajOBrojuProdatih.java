package ba.etf.unsa.si.pos_kasa.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import com.toedter.calendar.JDateChooser;

import ba.etf.unsa.si.pos_kasa.controller.IzvjestajArtikliControler;
import ba.etf.unsa.si.pos_kasa.model.Artikal;
import ba.etf.unsa.si.pos_kasa.validator.KolicinaValidator;
import viewmodel.ArtikalZaIzvjestajProdato;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import org.apache.log4j.Logger;

public class IzvjestajOBrojuProdatih {

	private JFrame frame;
	private JTextField textFieldTop;
	private JTable table;
	Object[] kolone = { "Naziv artikla", "Barkod", "Cijena", "Kolicina" };
	DefaultTableModel dtm = new DefaultTableModel();
	
	/**
	 * Launch the application.
	 */
	final static Logger logger = Logger.getLogger(IzvjestajOBrojuProdatih.class.toString());
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvjestajOBrojuProdatih window = new IzvjestajOBrojuProdatih();
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
	public IzvjestajOBrojuProdatih() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
		
		final JDateChooser dateChooserOd = new JDateChooser();
		dateChooserOd.setBounds(30, 24, 105, 20);
		frame.getContentPane().add(dateChooserOd);
		
		final JDateChooser dateChooserDo = new JDateChooser();
		dateChooserDo.setBounds(178, 24, 112, 20);
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
		dtm.setColumnIdentifiers(kolone);
		table.setModel(dtm);
		
		scrollPane.setRowHeaderView(table);
		
		JButton btnNewButton = new JButton("Prikazi izvjestaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] redovi = new Object[4];
				IzvjestajArtikliControler iac=new IzvjestajArtikliControler();
				List<ArtikalZaIzvjestajProdato> lista = new Vector<ArtikalZaIzvjestajProdato>();
				List<ArtikalZaIzvjestajProdato> listic = new Vector<ArtikalZaIzvjestajProdato>();
				listic=iac.vratiArtikleZaIzvjestajOProdatima(dateChooserOd.getDate(), dateChooserDo.getDate());
				lista=iac.vratiSortirano(listic);
				int broj=Integer.parseInt(textFieldTop.getText());
				if(broj>lista.size())broj=lista.size();
				for (int i = 0; i < broj; i++) {
					redovi[0] =lista.get(i).naziv;
					redovi[1] = lista.get(i).barkod;
					redovi[2] = lista.get(i).cijena;
					redovi[3] = lista.get(i).kolicinaP;
					dtm.addRow(redovi);
				}
			}
		});
		btnNewButton.setBounds(140, 63, 150, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
