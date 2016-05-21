package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Dimension;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import ba.etf.unsa.si.pos_kasa.controller.SefKontroler;
import ba.etf.unsa.si.pos_kasa.validator.KolicinaValidator;
import ba.etf.unsa.si.pos_kasa.controller.*;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.apache.log4j.Logger;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Popust {

	private JFrame frmPopust;
	private JLabel lblIznosRaunaS;
	private JTextField txtIznosPopusta;
	private JButton btnKreirajPopust;
	private JLabel label;
	private SefKontroler sefKontroler;
	final static Logger logger = Logger.getLogger(Popust.class.toString());

	/**
	 * Create the application.
	 */
	public void setVisible(boolean visible) {
		this.frmPopust.setVisible(visible);
	}

	public Popust(SefKontroler sefKontroler) {
		this.sefKontroler = sefKontroler;
		initialize();
	}

	public Popust() {

		initialize();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Popust window = new Popust();
					window.frmPopust.setVisible(true);
				} catch (Exception e) {
					String poruka = e.getMessage();
					logger.info(poruka);
					throw new RuntimeException(e);
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frmPopust = new JFrame();
		frmPopust.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				
				
			}
		});
		frmPopust.setTitle("Popust");
		frmPopust.setBounds(100, 100, 310, 281);
		frmPopust.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frmPopust.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frmPopust.getHeight()) / 2);
		frmPopust.setLocation(x, y);
		
		lblIznosRaunaS = new JLabel("Iznos popusta:");
		
		txtIznosPopusta = new JTextField();
		txtIznosPopusta.setColumns(10);
		txtIznosPopusta.setInputVerifier(new KolicinaValidator(txtIznosPopusta,"Iznos popusta mora biti broj!"));
		
		
		
		final JDateChooser datePocetak = new JDateChooser();
		
		JLabel lblOdaberiteDatum = new JLabel("Datum pocetka:");
		
		label = new JLabel("%");
		
		final JDateChooser dateKraj = new JDateChooser();
		
		JLabel lblDatumKraja = new JLabel("Datum kraja:");
		
		JLabel lblOpis = new JLabel("Opis:");
		
		final JTextArea textAreaOpis = new JTextArea();
		btnKreirajPopust = new JButton("Kreiraj Popust");
		btnKreirajPopust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PopustControler pc=new PopustControler();
				IzvjestajArtikliControler iac=new IzvjestajArtikliControler();
				if(iac.provjeriDatume(datePocetak.getDate()) && iac.provjeriDatume(dateKraj.getDate())){
				if(pc.provjeriIspravnost(datePocetak.getDate(), dateKraj.getDate()))
						{
				try {
					try {
						pc.dodajAkcijaPopust(datePocetak.getDate(),dateKraj.getDate(), textAreaOpis.getText(), Integer.parseInt(txtIznosPopusta.getText()));
					} catch (Exception e) {
						//JOptionPane.showMessageDialog(null, e.getMessage(), "InfoBox", JOptionPane.INFORMATION_MESSAGE);
						messageBox.infoBox("Prije klika na dugme odaberite datume u ispravnom poretku i unesite iznos popusta!", "Info Popust");
						String poruka=e.getMessage();
						logger.info(poruka);
						//throw new RuntimeException(e);
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "InfoBox", JOptionPane.INFORMATION_MESSAGE);
					String poruka=e.getMessage();
					logger.info(poruka);
					throw new RuntimeException(e);
				} 
						}
				else{
					messageBox.infoBox("Datumi moraju biti u ispravnom poretku!", "Info Popust");
				}
				}
				else{
					messageBox.infoBox("Datumi ne smiju biti zadani u proslosti!", "Info Popust");
				}
				}
			
		});
		GroupLayout groupLayout = new GroupLayout(frmPopust.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblOdaberiteDatum)
								.addComponent(lblIznosRaunaS)
								.addComponent(lblDatumKraja)
								.addComponent(lblOpis))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textAreaOpis)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(datePocetak, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(txtIznosPopusta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(label))
									.addComponent(dateKraj, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(72)
							.addComponent(btnKreirajPopust, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblOdaberiteDatum)
						.addComponent(datePocetak, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(dateKraj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDatumKraja))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(lblOpis))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(textAreaOpis, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(lblIznosRaunaS)
						.addComponent(txtIznosPopusta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addComponent(btnKreirajPopust)
					.addContainerGap())
		);
		frmPopust.getContentPane().setLayout(groupLayout);
	}
}
