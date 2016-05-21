package ba.etf.unsa.si.pos_kasa.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ba.etf.unsa.si.pos_kasa.controller.KasirKontroler;
import ba.etf.unsa.si.pos_kasa.controller.LoginKontroler;
import ba.etf.unsa.si.pos_kasa.controller.SefKontroler;

import javax.swing.LayoutStyle.ComponentPlacement;

public class FormaZaKasira  {

	private JFrame frmKasa;
	private KasirKontroler kasirKontroler;
	private PotvrdaOdjaveKasira potvrdaOdjaveKasira;
	private LoginKontroler loginKontroler;
	private SefKontroler sefKontroler;
	
	
	public void setVisible(boolean visible) {
		this.frmKasa.setVisible(visible);
	}
	
	
	/**
	 * Create the application.
	 */
	public FormaZaKasira(KasirKontroler kasirKontroler) {
		this.kasirKontroler = kasirKontroler;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKasa = new JFrame();
		frmKasa.setTitle("Kasa");
		frmKasa.setBounds(100, 100, 371, 419);
		frmKasa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frmKasa.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frmKasa.getHeight()) / 2);
		frmKasa.setLocation(x, y);
		
		JButton btnKreiranjeRacuna = new JButton("Kreiranje Računa");
		btnKreiranjeRacuna.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				kasirKontroler.prikaziFormuZaKreiranjeRacuna();
				
			}
		});
		
		JButton btnKreiranjeIzvjestaja = new JButton("Kreiranje izvještaja po završetku smjene");
		
		JButton btnProvjeraStanjaArtikala = new JButton("Provjera stanja artikala");
		
		final JButton btnNewButton = new JButton("Zaključi \r\nsmjenu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(btnNewButton,"Da li ste sigurni da se želite zaključiti smjenu?");
						if(dialogResult == 0) {
							  System.out.println("Yes option");
							  frmKasa.setVisible(false);
							  kasirKontroler.zaključiSmjenu();
							  loginKontroler = new LoginKontroler();
							  
						    } else {
							  //System.out.println("No Option");
							} 
			}
		});
		
		final JButton btnNewButton_1 = new JButton("Odjava      ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(btnNewButton_1,"Da li ste sigurni da se želite odjaviti?");
						
				if(dialogResult == 0) {
				  System.out.println("Yes option");
				  frmKasa.setVisible(false);
				  loginKontroler = new LoginKontroler();
				  
				  
				} else {
				  System.out.println("No Option");
				} 
				//potvrdaOdjaveKasira = new PotvrdaOdjaveKasira();
				//potvrdaOdjaveKasira.setVisible(true);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmKasa.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnProvjeraStanjaArtikala, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
						.addComponent(btnKreiranjeIzvjestaja, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
						.addComponent(btnKreiranjeRacuna, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))
					.addGap(170))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addComponent(btnKreiranjeRacuna, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnKreiranjeIzvjestaja, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnProvjeraStanjaArtikala, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
					.addGap(49))
		);
		frmKasa.getContentPane().setLayout(groupLayout);
	}
}
