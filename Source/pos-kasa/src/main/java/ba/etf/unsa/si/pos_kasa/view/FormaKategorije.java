package ba.etf.unsa.si.pos_kasa.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTextField;

import org.apache.log4j.Logger;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

import ba.etf.unsa.si.pos_kasa.controller.ArtikalKontroler;
import ba.etf.unsa.si.pos_kasa.controller.KategorijaControler;
import ba.etf.unsa.si.pos_kasa.controller.SefKontroler;
import ba.etf.unsa.si.pos_kasa.model.Kategorija;

public class FormaKategorije {
	private JFrame frame;
	private JTextField imeKategorijeText;
	private JTextField opisKategorijeText;
	private JList listKategorije;
	private DefaultListModel dlm=new DefaultListModel();
	private SefKontroler sefKontroler;
	final static Logger logger = Logger.getLogger(FormaKategorije.class.toString());
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormaKategorije window = new FormaKategorije();
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
	public FormaKategorije() {
		initialize();
	}
	public FormaKategorije(SefKontroler sefKontroler) {
		this.sefKontroler=sefKontroler;
		initialize();
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
		
		imeKategorijeText = new JTextField();
		imeKategorijeText.setBounds(104, 24, 143, 20);
		frame.getContentPane().add(imeKategorijeText);
		imeKategorijeText.setColumns(10);
		
		opisKategorijeText = new JTextField();
		opisKategorijeText.setBounds(104, 55, 143, 20);
		frame.getContentPane().add(opisKategorijeText);
		opisKategorijeText.setColumns(10);
		
		Label label = new Label("   Ime kategorije");
		label.setBounds(10, 24, 88, 22);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label(" Opis kategorije");
		label_1.setBounds(10, 55, 88, 22);
		frame.getContentPane().add(label_1);
		
		JButton dodajKategorijuButton = new JButton("Dodaj");
		dodajKategorijuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ime=imeKategorijeText.getText();
				String opis=opisKategorijeText.getText();
				KategorijaControler kc =new KategorijaControler();
				kc.dodajKategoriju(ime, opis);
				prikazi();
							
			}
		});
		dodajKategorijuButton.setBounds(296, 47, 89, 37);
		frame.getContentPane().add(dodajKategorijuButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 299, 153);
		frame.getContentPane().add(scrollPane);
		
		final JList listKategorije = new JList(dlm);
		scrollPane.setViewportView(listKategorije);
		
		JButton btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KategorijaControler kc =new KategorijaControler();
				String selected=(String) listKategorije.getSelectedValue();
				int n=listKategorije.getSelectedIndex();
				dlm.removeElementAt(n);
				String[] novo=selected.split(" ");
				kc.obrisiKategoriju(Long.parseLong(novo[0]));
				
				
			}
		});
		btnObrisi.setBounds(335, 219, 89, 32);
		frame.getContentPane().add(btnObrisi);
		
		JButton btnPrikazi = new JButton("Prikazi");
		btnPrikazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				prikazi();
			}
		});
		btnPrikazi.setBounds(336, 156, 88, 37);
		frame.getContentPane().add(btnPrikazi);
		
	}
	public void prikazi(){
		KategorijaControler kc =new KategorijaControler();
		List<Kategorija>kat=new Vector<Kategorija>();
		kat=(List<Kategorija>)kc.vratiSveKategorije();
		dlm.removeAllElements();
		imeKategorijeText.setText("");
		opisKategorijeText.setText("");
		List<String> lista=new Vector<String>();
		for(int i=0;i<kat.size();i++)
		{
			String str=kat.get(i).getId()+" "+kat.get(i).getNaziv()+"  "+kat.get(i).getOpis();
			lista.add(str);
		}
		for(String dio:lista)
		{
			dlm.addElement(dio);
		}
		
	}

	public void setVisible(boolean b) {
		this.frame.setVisible(true);
		
	}
}
