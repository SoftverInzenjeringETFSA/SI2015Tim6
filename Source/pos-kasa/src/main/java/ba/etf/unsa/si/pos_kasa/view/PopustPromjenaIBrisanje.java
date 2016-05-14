package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;
import org.apache.log4j.Logger;

import javax.swing.JFrame;

public class PopustPromjenaIBrisanje {

	private JFrame frame;

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
	}

}
