package ba.etf.unsa.si.pos_kasa.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.apache.log4j.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ba.etf.unsa.si.pos_kasa.controller.SefKontroler;
import ba.etf.unsa.si.pos_kasa.controller.SmjenaKontroler;

public class Zakljucivanje {

	private JFrame Zakljucivanje;
	private SmjenaKontroler smjenaKontroler;
	private SefKontroler sefKontroler;
    final static Logger logger = Logger.getLogger(Zakljucivanje.class.toString());
	
    /**
	 * Create the application.
	 */
    /**
	  * @wbp.parser.entryPoint
	  */
    public Zakljucivanje(SefKontroler sefKontroler) {
		this.sefKontroler = sefKontroler;
		initialize();
	}
    /*
    public Zakljucivanje(SmjenaKontroler smjenaKontroler) {
		this.smjenaKontroler = smjenaKontroler;
		initialize();
	}
	*/
	
	public void setVisible(boolean visible) {
		this.Zakljucivanje.setVisible(visible);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Zakljucivanje = new JFrame();
		Zakljucivanje.setTitle("Zaključivanje smjene");
		Zakljucivanje.setBounds(100, 100, 388, 137);
		Zakljucivanje.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Zakljucivanje.getContentPane().setLayout(null);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - Zakljucivanje.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - Zakljucivanje.getHeight()) / 2);
		Zakljucivanje.setLocation(x, y);
		
		JButton btnZakljuciSmjenu = new JButton("Potvrdi");
		btnZakljuciSmjenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				sefKontroler.zaključiSmjenu();
			}
		});
		btnZakljuciSmjenu.setBounds(56, 46, 113, 23);
		Zakljucivanje.getContentPane().add(btnZakljuciSmjenu);
		
		JButton btnNewButton = new JButton("Odustani");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(202, 46, 113, 23);
		Zakljucivanje.getContentPane().add(btnNewButton);
		
		JLabel lblPotvrditeZakljuivanjeSmjene = new JLabel("Potvrdite zaključivanje smjene.");
		lblPotvrditeZakljuivanjeSmjene.setBounds(56, 11, 189, 14);
		Zakljucivanje.getContentPane().add(lblPotvrditeZakljuivanjeSmjene);
		
		}
	
	
	}


