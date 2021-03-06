package ba.etf.unsa.si.pos_kasa.view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import ba.etf.unsa.si.pos_kasa.controller.Izvjestaji;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

public class IzvjUkupanPrometPoUposleniku {

	JFrame frame;
	JDateChooser pocDatum;
	JDateChooser krajDatum;
	JPanel panelIzvjestaj;
	JLabel lblIzvjestajZa;
	JLabel lblPromet;
	JLabel lblProdato;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	final static Logger logger = Logger.getLogger(IzvjUkupanPrometPoUposleniku.class.toString());
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvjUkupanPrometPoUposleniku window = new IzvjUkupanPrometPoUposleniku();
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
	public IzvjUkupanPrometPoUposleniku() {
		initialize();
		panelIzvjestaj.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 452, 335);
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
				Date d1 = pocDatum.getDate();
				Date d2 = krajDatum.getDate();
				if(d1 != null && d2 != null){
					if(d1.after(d2)) { JOptionPane.showMessageDialog(null, "Krajnji datum mora biti veći od početnog."); return;}
				}
				Izvjestaji izvjCtrl = new Izvjestaji();
				double[] vrijednosti;
				try {
					vrijednosti = Izvjestaji.dajUkupanPrometPoUposlenikuOdDo(textField.getText(), pocDatum.getDate(), krajDatum.getDate());
					lblProdato.setText(Double.toString(vrijednosti[0]));
					lblPromet.setText(Double.toString(vrijednosti[1]));
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					lblIzvjestajZa.setText("Izvjestaj o prometu za period " + sdf.format(pocDatum.getDate()) + " - " + sdf.format(krajDatum.getDate()) + " za: " + Izvjestaji.dajImePrezimeUposlenika(textField.getText()) + " .");
					panelIzvjestaj.setVisible(true);
				} catch (Exception e) {
					//Logger.getLogger(Izvjestaji.class).error(e.getMessage());
			        JOptionPane.showMessageDialog(null, e.getMessage(), "Izuzetak", JOptionPane.INFORMATION_MESSAGE);
			        String poruka=e.getMessage();
					logger.info(poruka);
					throw new RuntimeException(e);
				}
			}
		});
		btnPrikaiIzvjetaj.setBounds(12, 95, 129, 25);
		frame.getContentPane().add(btnPrikaiIzvjetaj);
		
		panelIzvjestaj = new JPanel();
		panelIzvjestaj.setBounds(12, 155, 395, 112);
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
		
		JLabel lblJmbgUposlenika = new JLabel("JMBG Uposlenika");
		lblJmbgUposlenika.setBounds(12, 49, 113, 16);
		frame.getContentPane().add(lblJmbgUposlenika);
		
		textField = new JTextField();
		textField.setBounds(115, 46, 193, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
