package ba.etf.unsa.si.pos_kasa.view;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Tools.HibernateUtil;
import ba.etf.unsa.si.pos_kasa.view.Zakljucivanje;
import ba.etf.unsa.si.pos_kasa.view.IzvjUkupanPromet;
import ba.etf.unsa.si.pos_kasa.controller.ArtikalKontroler;
import ba.etf.unsa.si.pos_kasa.controller.Izvjestaji;
import ba.etf.unsa.si.pos_kasa.controller.SmjenaKontroler;
import ba.etf.unsa.si.pos_kasa.model.Artikal;
import ba.etf.unsa.si.pos_kasa.model.Smjena;
import ba.etf.unsa.si.pos_kasa.model.StavkaRacuna;
import ba.etf.unsa.si.pos_kasa.model.NacinPlacanja;
import ba.etf.unsa.si.pos_kasa.model.Racun;


public class IzvjestajNaKrajuSmjene {

	final static Logger logger = Logger.getLogger(IzvjestajNaKrajuSmjene.class);
	
	public static void prodanoUSmjeni(List<Artikal> artikli, Date pocetakSmjene, Date krajSmjene,List<NacinPlacanja>nacinplacanja) throws DocumentException, IOException
	{
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("ISmjena.pdf"));
		document.open();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		document.add(new Paragraph("Izvještaj o prodanim artiklima između " + df.format(pocetakSmjene) + " i " + df.format(krajSmjene), 
				FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD,	new CMYKColor(89, 78, 0, 100))));
		PdfPTable t = new PdfPTable(5);
		t.setSpacingBefore(25);
		t.setSpacingAfter(25);
		PdfPCell c1 = new PdfPCell(new Phrase("Artikal"));  
		t.addCell(c1);
		PdfPCell c2 = new PdfPCell(new Phrase("Vrijeme"));  
		t.addCell(c2);
		PdfPCell c3 = new PdfPCell(new Phrase("Datum"));  
		t.addCell(c3);
		PdfPCell c4 = new PdfPCell(new Phrase("Nacin placanja"));  
		t.addCell(c4);
		PdfPCell c5 = new PdfPCell(new Phrase("Cijena"));  
		t.addCell(c5);
		int brojac = 0;
		
		for (Artikal artikal : artikli){
			
			Calendar cal = Calendar.getInstance();
			Date g= new Date();//Smjena.getPocetakSmjene(); ovo je zbog errora zakomentarisano
			cal.setTime(g);
			Date poc = cal.getTime();
			if (poc.getTime() < pocetakSmjene.getTime() || poc.getTime() > krajSmjene.getTime()) {
				continue;
			}
			brojac++;
			t.addCell(artikal.getNaziv());
			
			//metoda je bila static i pravi probleme pa sam je zakomentarisao onda zbog 3 errora sam ovo zakomentarisao
			String s= new String();//SmjenaKontroler.VrijemeSmjene(pocetakSmjene, krajSmjene).toString();
			t.addCell(s);
			
			try {
				t.addCell(Izvjestaji.dajArtiklePoNacinuPlacanjaOdDo(pocetakSmjene, krajSmjene).toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				String poruka=e.getMessage();
				logger.info(poruka);
				throw new RuntimeException(e);
			}
			t.addCell(String.valueOf(artikal.getCijena()));
		
		document.add(new Paragraph("Ukupno prodano u tom periodu: "+ brojac+ " artikala"));
		document.add(t);
		document.close();
		if (Desktop.isDesktopSupported()) {
			File myFile = new File("ISmjena.pdf");
			Desktop.getDesktop().open(myFile);
		}
	}

	}
}
