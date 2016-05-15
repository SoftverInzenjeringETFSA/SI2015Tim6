package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
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
import java.awt.Font;

public class IzvjUkupanPrometPoNP {

	private JFrame frame;
	JDateChooser pocDatum;
	JDateChooser krajDatum;
	JPanel panelIzvjestaj;
	JLabel lblIzvjestajZa;
	JLabel lblPromet;
	JLabel lblProdato;
	JLabel lblGotovina;
	JLabel lblKartica;
	JLabel lblCek;
	JLabel lblVirman;

	/**
	 * Launch the application.
	 */
	final static Logger logger = Logger.getLogger(IzvjUkupanPrometPoNP.class.toString());
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvjUkupanPrometPoNP window = new IzvjUkupanPrometPoNP();
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
	public IzvjUkupanPrometPoNP() {
		initialize();
		panelIzvjestaj.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
				double[] ukupnoPoNacinimaPl = Izvjestaji.dajUkupanPrometPoVrstiPlacanjaOdDo(pocDatum.getDate(), krajDatum.getDate());
				lblProdato.setText(Double.toString(vrijednosti[0]));
				lblPromet.setText(Double.toString(vrijednosti[1]));
				lblGotovina.setText(Double.toString(ukupnoPoNacinimaPl[0]));
				lblKartica.setText(Double.toString(ukupnoPoNacinimaPl[1]));
				lblCek.setText(Double.toString(ukupnoPoNacinimaPl[2]));
				lblVirman.setText(Double.toString(ukupnoPoNacinimaPl[3]));
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				lblIzvjestajZa.setText("Izvjestaj o prometu za period " + sdf.format(pocDatum.getDate()) + " - " + sdf.format(krajDatum.getDate()) + ".");
				panelIzvjestaj.setVisible(true);
			}
		});
		btnPrikaiIzvjetaj.setBounds(12, 49, 129, 25);
		frame.getContentPane().add(btnPrikaiIzvjetaj);
		
		panelIzvjestaj = new JPanel();
		panelIzvjestaj.setBounds(12, 101, 395, 199);
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
		
		JLabel lblGotovinaxt = new JLabel("Gotovina");
		lblGotovinaxt.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGotovinaxt.setBounds(10, 123, 56, 16);
		panelIzvjestaj.add(lblGotovinaxt);
		
		JLabel lblKarticaxt = new JLabel("Kartica");
		lblKarticaxt.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblKarticaxt.setBounds(110, 123, 56, 16);
		panelIzvjestaj.add(lblKarticaxt);
		
		JLabel lblCekxt = new JLabel("Cek");
		lblCekxt.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCekxt.setBounds(212, 123, 56, 16);
		panelIzvjestaj.add(lblCekxt);
		
		JLabel lblVirmanxt = new JLabel("Virman");
		lblVirmanxt.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVirmanxt.setBounds(311, 123, 56, 16);
		panelIzvjestaj.add(lblVirmanxt);
		
		lblGotovina = new JLabel("Gotovina");
		lblGotovina.setBounds(10, 152, 56, 16);
		panelIzvjestaj.add(lblGotovina);
		
		lblKartica = new JLabel("Kartica");
		lblKartica.setBounds(110, 152, 56, 16);
		panelIzvjestaj.add(lblKartica);
		
		lblCek = new JLabel("Cek");
		lblCek.setBounds(212, 152, 56, 16);
		panelIzvjestaj.add(lblCek);
		
		lblVirman = new JLabel("Virman");
		lblVirman.setBounds(311, 152, 56, 16);
		panelIzvjestaj.add(lblVirman);
	}
}
