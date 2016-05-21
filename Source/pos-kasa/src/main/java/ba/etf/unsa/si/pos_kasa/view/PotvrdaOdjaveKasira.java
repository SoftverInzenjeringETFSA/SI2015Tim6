package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.apache.log4j.Logger;

import ba.etf.unsa.si.pos_kasa.controller.KasirKontroler;
import ba.etf.unsa.si.pos_kasa.controller.LoginKontroler;

public class PotvrdaOdjaveKasira {

	private JFrame frmPovrdaOdjave;
	private KasirKontroler kasirKontroler;
	LoginKontroler loginKontroler;
	 final static Logger logger = Logger.getLogger(Zakljucivanje.class.toString());
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PotvrdaOdjaveKasira window = new PotvrdaOdjaveKasira();
					window.frmPovrdaOdjave.setVisible(true);
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
	public PotvrdaOdjaveKasira() {
		initialize();
	}
	public void setVisible(boolean visible) {
		this.frmPovrdaOdjave.setVisible(visible);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPovrdaOdjave = new JFrame();
		frmPovrdaOdjave.setTitle("Povrda Odjave");
		frmPovrdaOdjave.setBounds(100, 100, 289, 140);
		frmPovrdaOdjave.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Da");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPovrdaOdjave.setVisible(false);
			    kasirKontroler.odjaviKasira();
			    messageBox.infoBox("Uspješno ste odjavljeni sa kase", "Info o odjavi");
				loginKontroler = new LoginKontroler();
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Ne");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPovrdaOdjave.setVisible(false);
			}
		});
		
		JLabel lblDaLiSte = new JLabel("Da li ste sigurni da se želite odjaviti?");
		GroupLayout groupLayout = new GroupLayout(frmPovrdaOdjave.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(btnNewButton)
							.addGap(41)
							.addComponent(btnNewButton_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addComponent(lblDaLiSte, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(lblDaLiSte)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(75, Short.MAX_VALUE))
		);
		frmPovrdaOdjave.getContentPane().setLayout(groupLayout);
	}
}
