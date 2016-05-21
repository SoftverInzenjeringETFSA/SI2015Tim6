package ba.etf.unsa.si.pos_kasa.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import ba.etf.unsa.si.pos_kasa.controller.KasirKontroler;

public class FormaZaKasira  {

	private JFrame frmKasa;
	private KasirKontroler kasirKontroler;
	
	
	
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
		frmKasa.setBounds(100, 100, 435, 409);
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
		GroupLayout groupLayout = new GroupLayout(frmKasa.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(97)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnProvjeraStanjaArtikala, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnKreiranjeIzvjestaja, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnKreiranjeRacuna, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
					.addGap(110))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(57)
					.addComponent(btnKreiranjeRacuna, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(btnKreiranjeIzvjestaja, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(btnProvjeraStanjaArtikala, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(164, Short.MAX_VALUE))
		);
		frmKasa.getContentPane().setLayout(groupLayout);
	}

}
