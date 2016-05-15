package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import org.apache.log4j.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.toedter.calendar.JDateChooser;

import ba.etf.unsa.si.pos_kasa.controller.SmjenaKontroler;

public class Zakljucivanje {

	private JFrame Zakljucivanje;
	private SmjenaKontroler smjenaKontroler;

	/**
	 * Launch the application.
	 */
	final static Logger logger = Logger.getLogger(Zakljucivanje.class.toString());
	public Zakljucivanje(SmjenaKontroler smjenaKontroler) {
		this.smjenaKontroler = smjenaKontroler;
		initialize();
	}
	
	public void setVisible(boolean visible) {
		this.Zakljucivanje.setVisible(visible);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zakljucivanje window = new Zakljucivanje();
					window.Zakljucivanje.setVisible(true);
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
	public Zakljucivanje() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Zakljucivanje = new JFrame();
		Zakljucivanje.setBounds(100, 100, 450, 300);
		Zakljucivanje.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Zakljucivanje.getContentPane().setLayout(null);
		
		JLabel lblDa = new JLabel("Datum:");
		lblDa.setBounds(128, 49, 35, 21);
		Zakljucivanje.getContentPane().add(lblDa);
		
		JLabel lblNewLabel = new JLabel("Vrijeme zavrsetka smjene:");
		lblNewLabel.setBounds(37, 95, 126, 21);
		Zakljucivanje.getContentPane().add(lblNewLabel);
		
		final JDateChooser datumSmjene = new JDateChooser();
		datumSmjene.setDateFormatString("yyyy-MM-dd");
		datumSmjene.setBounds(185, 49, 91, 20);
		Zakljucivanje.getContentPane().add(datumSmjene);
		
		final JDateChooser vrijemeKrajaSmjene = new JDateChooser();
		vrijemeKrajaSmjene.setBounds(185, 95, 91, 20);
		Zakljucivanje.getContentPane().add(vrijemeKrajaSmjene);
		
		JButton btnZakljuciSmjenu = new JButton("Zakljuci smjenu");
		btnZakljuciSmjenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Date datum_smjene=(Date) datumSmjene.getDate();
				Date vrijeme_kraja_smjene=(Date) vrijemeKrajaSmjene.getDate();
				
				
			}
		});
		btnZakljuciSmjenu.setBounds(135, 201, 113, 23);
		Zakljucivanje.getContentPane().add(btnZakljuciSmjenu);
		
		}
	}


