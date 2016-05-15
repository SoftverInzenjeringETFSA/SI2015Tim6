package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import ba.etf.unsa.si.pos_kasa.controller.SefKontroler;
import ba.etf.unsa.si.pos_kasa.model.Uposlenik;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PretragaKorisnika_prikaz {

	private JFrame PretragaKorisnika_prikaz;
    private SefKontroler sefKontroler;
    private Uposlenik uposlenik;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public PretragaKorisnika_prikaz(SefKontroler sefKontroler, Uposlenik uposlenik) {
		this.sefKontroler=sefKontroler;
		this.uposlenik=uposlenik;
		initialize();
	}
	
	public void setVisible(boolean visible) {
		this.PretragaKorisnika_prikaz.setVisible(visible);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		PretragaKorisnika_prikaz = new JFrame();
		PretragaKorisnika_prikaz.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 13));
		PretragaKorisnika_prikaz.setBounds(100, 100, 450, 300);
		PretragaKorisnika_prikaz.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblPodaciOKorisniku = new JLabel("Podaci o korisniku:");
		lblPodaciOKorisniku.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		JLabel lblImePrezimeKorisnika = new JLabel(uposlenik.getImePrezime());
		lblImePrezimeKorisnika.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
		JLabel lblJmbgKorisnika = new JLabel(uposlenik.getJmbg());
		lblJmbgKorisnika.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
		JButton btnClose = new JButton("Zatvori");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PretragaKorisnika_prikaz.setVisible(false);
			}
		});
		btnClose.setForeground(SystemColor.controlText);
		btnClose.setBackground(SystemColor.textHighlight);
		btnClose.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblDatumrodjenja = new JLabel(uposlenik.getDatumRodjenja());
		
		JLabel lblBrojtelefona = new JLabel(uposlenik.getBrojTelefona());
		GroupLayout groupLayout = new GroupLayout(PretragaKorisnika_prikaz.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(lblPodaciOKorisniku, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(153)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblImePrezimeKorisnika, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
								.addComponent(lblJmbgKorisnika, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblDatumrodjenja, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblBrojtelefona, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnClose))))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(lblPodaciOKorisniku)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblImePrezimeKorisnika, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblJmbgKorisnika)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDatumrodjenja)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblBrojtelefona)
					.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
					.addComponent(btnClose)
					.addGap(31))
		);
		PretragaKorisnika_prikaz.getContentPane().setLayout(groupLayout);
	}
}
