package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;
import org.apache.log4j.Logger;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;

import ba.etf.unsa.si.pos_kasa.controller.ArtikalKontroler;
import ba.etf.unsa.si.pos_kasa.controller.KategorijaControler;
import ba.etf.unsa.si.pos_kasa.controller.PopustControler;
import ba.etf.unsa.si.pos_kasa.controller.SefKontroler;
import ba.etf.unsa.si.pos_kasa.model.AkcijaPopust;
import ba.etf.unsa.si.pos_kasa.model.Artikal;
import ba.etf.unsa.si.pos_kasa.model.Kategorija;
import ba.etf.unsa.si.pos_kasa.validator.KolicinaValidator;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class PopustPromjenaIBrisanje {

	private JFrame frame;
	private JTextField textField;
	private DefaultListModel dlm = new DefaultListModel();
	private JTable table;
	Object[] kolone = { "Id popusta", "Pocetak akcije", "Kraj akcije", "Iznos popusta" };
	DefaultTableModel dtm = new DefaultTableModel();
	private SefKontroler sefKontroler;
	/**
	 * Launch the application.
	 */
	final static Logger logger = Logger.getLogger(PopustPromjenaIBrisanje.class.toString());
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopustPromjenaIBrisanje window = new PopustPromjenaIBrisanje();
					window.frame.setVisible(true);
				} catch (Exception e) {
					//Logger.getLogger(PopustPromjenaIBrisanje.class).error(e.getMessage());
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
	public PopustPromjenaIBrisanje() {
		initialize();
	}
	public PopustPromjenaIBrisanje(SefKontroler sefKontroler) {
		this.sefKontroler=sefKontroler;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent arg0) {
				
				setVisible(false);
			}
		});
		frame.setBounds(100, 100, 607, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 408, 110);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { {}, {}, {}, }, new String[] {}));
		dtm.setColumnIdentifiers(kolone);
		table.setModel(dtm);
		Object[] redovi = new Object[4];
		List<String> str = new Vector<String>();
		PopustControler ac = new PopustControler();
		List<AkcijaPopust> lista = new Vector<AkcijaPopust>();
		lista = (List<AkcijaPopust>) ac.vratiSveAkcijaPopust();
		
		for (int i = 0; i < lista.size(); i++) {
			redovi[0] = lista.get(i).getId();
			redovi[1] = ac.vratiFormatDatuma(lista.get(i).getDatum_pocetka());
			redovi[2] = ac.vratiFormatDatuma(lista.get(i).getDatum_kraja());
			redovi[3] = lista.get(i).getIznos_popusta();
			dtm.addRow(redovi);
		}
		scrollPane.setViewportView(table);

		final JDateChooser dateChooser = new JDateChooser();
		JButton btnObrisi = new JButton("Obrisi popust");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() != -1) {
					PopustControler ac = new PopustControler();
					ac.obrisiAkcijuPopust((Long)table.getValueAt(table.getSelectedRow(), 0));
					dtm.removeRow(table.getSelectedRow());

				}
			}
		});
		btnObrisi.setBounds(428, 67, 129, 34);
		frame.getContentPane().add(btnObrisi);
		
		final JDateChooser dateChooser_1 = new JDateChooser();

		JButton btnPromijeniPopust = new JButton("Promijeni Popust");
		btnPromijeniPopust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PopustControler pc=new PopustControler();
				
				
					try {
						pc.modificirajAkcijuPopust((Long)table.getValueAt(table.getSelectedRow(), 0), dateChooser.getDate(), dateChooser_1.getDate(), "",Integer.parseInt(textField.getText()));
					
						while(dtm.getRowCount()>0)
						{
							dtm.removeRow(0);
						}
						
						Object[] redovi = new Object[4];
						List<String> str = new Vector<String>();
						PopustControler ac = new PopustControler();
						List<AkcijaPopust> lista = new Vector<AkcijaPopust>();
						lista = (List<AkcijaPopust>) ac.vratiSveAkcijaPopust();
				
						for (int i = 0; i < lista.size(); i++) {
							redovi[0] = lista.get(i).getId();
							redovi[1] = ac.vratiFormatDatuma(lista.get(i).getDatum_pocetka());
							redovi[2] = ac.vratiFormatDatuma(lista.get(i).getDatum_kraja());
							redovi[3] = lista.get(i).getIznos_popusta();
							dtm.addRow(redovi);
						}
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						String poruka=e.getMessage();
						logger.info(poruka);
						return;
						//throw new RuntimeException(e); NEMOJ BACATI EXCEPTION BEZ DA GA HENDLAS ODE APLIKACIJA U NEISPRAVNO STANJE
					} catch (Exception e) {
						// TODO Auto-generated catch block
						String poruka=e.getMessage();
						logger.info(poruka);
						return;
						//hrow new RuntimeException(e); NEMOJ BACATI EXCEPTION NE HENDLAS GA NIGDJE APLIKACIJA NE RADI DALJE
					}
				
			}
		});
		btnPromijeniPopust.setBounds(406, 194, 151, 34);
		frame.getContentPane().add(btnPromijeniPopust);

		JLabel lblNewLabel = new JLabel("Datum pocetka");
		lblNewLabel.setBounds(10, 151, 98, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Datum kraja");
		lblNewLabel_1.setBounds(127, 151, 71, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Iznos popusta");
		lblNewLabel_3.setBounds(238, 151, 92, 14);
		frame.getContentPane().add(lblNewLabel_3);

		
		dateChooser.setBounds(10, 175, 98, 20);
		frame.getContentPane().add(dateChooser);
		
		dateChooser_1.setBounds(127, 176, 98, 20);
		frame.getContentPane().add(dateChooser_1);
		

		textField = new JTextField();
		textField.setBounds(238, 176, 92, 20);
		textField.setInputVerifier(new KolicinaValidator(textField,"Morate unijeti ispravan broj!"));
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}

	public void setVisible(boolean b) {
		this.frame.setVisible(true);
		
	}

}
