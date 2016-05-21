package ba.etf.unsa.si.pos_kasa.view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;

import ba.etf.unsa.si.pos_kasa.controller.Izvjestaji;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class IzvjUkupanPromet {

	private JFrame frame;
	JDateChooser pocDatum;
	JDateChooser krajDatum;
	JPanel panelIzvjestaj;
	JLabel lblIzvjestajZa;
	JLabel lblPromet;
	JLabel lblProdato;
	final static Logger logger = Logger.getLogger(IzvjUkupanPromet.class.toString());
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvjUkupanPromet window = new IzvjUkupanPromet();
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
	public IzvjUkupanPromet() {
		initialize();
		panelIzvjestaj.setVisible(false);
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
		
		JLabel lblNewLabel = new JLabel("Početni datum");
		lblNewLabel.setBounds(12, 13, 101, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblKrajnjiDatum = new JLabel("Krajnji datum");
		lblKrajnjiDatum.setBounds(217, 16, 101, 16);
		frame.getContentPane().add(lblKrajnjiDatum);
		
		pocDatum = new JDateChooser();
		pocDatum.setBounds(105, 14, 100, 22);
		frame.getContentPane().add(pocDatum);
		
		krajDatum = new JDateChooser();
		krajDatum.setBounds(307, 14, 100, 22);
		frame.getContentPane().add(krajDatum);
		
		JButton btnPrikaiIzvjetaj = new JButton("Prikaži izvještaj");
		btnPrikaiIzvjetaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Izvjestaji izvjCtrl = new Izvjestaji();
				double[] vrijednosti =  Izvjestaji.dajUkupanPrometIprodateArtikleOdDo(pocDatum.getDate(), krajDatum.getDate());
				lblProdato.setText(Double.toString(vrijednosti[0]));
				lblPromet.setText(Double.toString(vrijednosti[1]));
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				lblIzvjestajZa.setText("Izvjestaj o prometu za period " + sdf.format(pocDatum.getDate()) + " - " + sdf.format(krajDatum.getDate()) + ".");
				panelIzvjestaj.setVisible(true);
			}
		});
		btnPrikaiIzvjetaj.setBounds(12, 49, 129, 25);
		frame.getContentPane().add(btnPrikaiIzvjetaj);
		
		panelIzvjestaj = new JPanel();
		panelIzvjestaj.setBounds(12, 101, 395, 112);
		frame.getContentPane().add(panelIzvjestaj);
		panelIzvjestaj.setLayout(null);
		
		JLabel lblUkupanOstvprmttext = new JLabel("Ukupan ostvaren promet:");
		lblUkupanOstvprmttext.setBounds(10, 42, 156, 16);
		panelIzvjestaj.add(lblUkupanOstvprmttext);
		
		lblIzvjestajZa = new JLabel("Izvjestaj za");
		lblIzvjestajZa.setBounds(10, 13, 373, 16);
		panelIzvjestaj.add(lblIzvjestajZa);
		
		JLabel lblUkupanBrojProdatih = new JLabel("Ukupan broj prodatih artikala:");
		lblUkupanBrojProdatih.setBounds(10, 72, 180, 16);
		panelIzvjestaj.add(lblUkupanBrojProdatih);
		
		lblPromet = new JLabel("New label");
		lblPromet.setBounds(256, 42, 79, 16);
		panelIzvjestaj.add(lblPromet);
		
		lblProdato = new JLabel("New label");
		lblProdato.setBounds(256, 72, 56, 16);
		panelIzvjestaj.add(lblProdato);
	}
}
