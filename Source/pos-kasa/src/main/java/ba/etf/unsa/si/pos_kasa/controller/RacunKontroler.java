package ba.etf.unsa.si.pos_kasa.controller;

import ba.etf.unsa.si.pos_kasa.model.*;
import ba.etf.unsa.si.pos_kasa.model.StornoRacun;
import ba.etf.unsa.si.pos_kasa.view.*;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import Tools.HibernateUtil;

@SuppressWarnings("unused")

public class RacunKontroler {
 
	//private static Session session;
	private Session session;
	private Transaction t;
	public static void main(String[] args)
	{
	}
	
	
	public Long dodajStavku(StavkaRacuna stavkaRac, long racun_id)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		stavkaRac.setRacun_id(racun_id);
		Long id = (Long) session.save(stavkaRac);
		t.commit();
		session.close();
		return id;
	}
	
	public RacunKontroler() {
	}


	public void ukloniStavku(long _id)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		StavkaRacuna sr = new StavkaRacuna();
		
		  if(sr.getId() == _id)
			
		  {
			session.delete(sr);
			t.commit();
		  }
		
		else
		{
			System.out.println("Ne postoji ta stavka");
		}
	
		session.close();
	}
	
	public Long dodajNacinPlacanja(NacinPlacanja np, long racun_id)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		np.setRacun_id(racun_id);
		 Long id = (Long) session.save(np);
		 return id;
	}
	
	public List<?> vratiSveRacune()
	{
		session = HibernateUtil.getSessionFactory().openSession();
		String sql = "select * from tim6.racun";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Racun.class);	
		List<?> results = query.list();
		session.close();
		return results;	
	}
	
	public Racun pretraziRacunePoDatumu(Date _datum)throws Exception
	{
	     session = HibernateUtil.getSessionFactory().openSession();
	     Transaction t=session.beginTransaction(); 
    	 Racun _racun = new Racun();
    	     
    	     if( _racun.getDatum_i_vrijeme() == _datum)
     	    	 return _racun;
    	     else 
    	    	 throw new Exception("Pretraživanje nije uspjelo.");
    	    
	}
	
	public long kreirajRacun(long smjena_id, String nacinPlacanja, DefaultTableModel model) throws Exception
	{
		AkcijaPopust ap = this.dajAktivniPopust();
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Racun racun = new Racun();
		racun.setDatum_i_vrijeme(new Date());
		racun.setSmjena_id(smjena_id);
		racun.setBroj_racuna((int) (new Date().getTime()/1000));
		if(ap != null) racun.setAkcijapopust_id(ap.getId());
		Long id = (Long) session.save(racun);
		t.commit();
		session.close();
		double ukupno = kreirajStavkeRacuna(model, id);
		this.kreirajXMLRacun(racun, model, ap.getIznos_popusta(), ukupno);
		if(ap != null)
			kreirajNacinPlacanja(nacinPlacanja, ukupno -ap.getIznos_popusta()*ukupno, id);
		else
			kreirajNacinPlacanja(nacinPlacanja, ukupno , id);
		return id;
	}
	
	public String kreirajStornoRacun(long brojRacuna) //broj a ne ID!!
	{
		Criteria crit = session.createCriteria(Racun.class);
		crit.add(Restrictions.eq("broj_racuna", brojRacuna));
		List list = crit.list();
		Racun rac = (Racun) list.get(0);
		
		crit = session.createCriteria(NacinPlacanja.class);
		crit.add(Restrictions.eq("racun_id", rac.getId()));
		list = crit.list();
		NacinPlacanja np = (NacinPlacanja) list.get(0);
		
		crit = session.createCriteria(StornoRacun.class);
		crit.add(Restrictions.eq("racun_id", rac.getId()));
		list = crit.list();
		
		this.povecajZalihe(rac.getId());
		
		String poruka = "";
		if(rac != null && list.size() > 0) 
		{
			StornoRacun sracun = new StornoRacun();
			sracun.setDatum_i_vrijeme(new Date());
			sracun.setIznos(np.getIznos());
			sracun.setRacun_id(rac.getId());
			Long id = (Long) session.save(sracun);
			poruka = "Uspješno ste kreirali storno račun za račun br: " + rac.getBroj_racuna() +" na iznos od: "+np.getIznos();
		}
		else 
			poruka = "Ne postoji račun sa datim brojem ili je storno račun već kreiran. Neuspješno kreiranje storno računa!";
		t.commit();
		session.close();
		return poruka;
	}
	
	private void kreirajXMLRacun(Racun racun, DefaultTableModel model, double iznosPopusta, double konacnaCijena) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		StringBuilder xmlStringBuilder = new StringBuilder();
		xmlStringBuilder.append("<?xml version=\"1.0\"?> <Racun>");
		xmlStringBuilder.append("<DatumVrijeme>" + racun.getDatum_i_vrijeme().toString() + "</DatumVrijeme>");
		xmlStringBuilder.append("<BrojRacuna>" + racun.getBroj_racuna() + "</BrojRacuna>");
		xmlStringBuilder.append("<Kasir>"+ System.getProperty("imeIprezime") + "</Kasir>");
		xmlStringBuilder.append("<Popust>" + iznosPopusta + "</Popust>");
		xmlStringBuilder.append("<IznosSaPopustom>" + konacnaCijena + "</IznosSaPopustom>");
		xmlStringBuilder.append("<StavkeRacuna>");
		for(int i = 0; i < model.getRowCount(); i++){
			xmlStringBuilder.append("<StavkaRacuna>");
			xmlStringBuilder.append("<BarKod>" + model.getValueAt(i, 0) + "</BarKod>");
			xmlStringBuilder.append("<NazivArtikla>" + model.getValueAt(i, 1) + "</NazivArtikla>");
			xmlStringBuilder.append("<JedinicnaCijena>" + model.getValueAt(i, 3) + "</JedinicnaCijena>");
			xmlStringBuilder.append("<Kolicina>" + model.getValueAt(i, 2) + "</Kolicina>");
			xmlStringBuilder.append("<Iznos>" + model.getValueAt(i, 4)+ "</Iznos>");
			xmlStringBuilder.append("</StavkaRacuna>");
		}
		xmlStringBuilder.append("</StavkeRacuna> </Racun>");
		ByteArrayInputStream input = null;

		try {
			input = new ByteArrayInputStream(
			   xmlStringBuilder.toString().getBytes("UTF-8"));			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}

		try {
			Document doc = builder.parse(input);
			TransformerFactory transformerFactory =
			         TransformerFactory.newInstance();
			Transformer transformer =
			         transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result =
			         new StreamResult(new File("C:\\racun-"+racun.getBroj_racuna()+".xml"));
			transformer.transform(source, result);

		} catch (SAXException e) {
			// TODO Auto-generated catch block
			throw e;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
	
	private void povecajZalihe(long racun_id){
		Criteria crit = session.createCriteria(StavkaRacuna.class);
		crit.add(Restrictions.eq("racun_id", racun_id));
		List<StavkaRacuna> list = crit.list();
		for(StavkaRacuna sr: list){
            Artikal art =  session.get(Artikal.class, sr.getArtikal_id());
            art.setZalihe_stanje(art.getZalihe_stanje() + sr.getKolicina());
            session.update(art);
		}
	}
		
	private AkcijaPopust dajAktivniPopust(){
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		String hql = "Select new ba.etf.unsa.si.pos_kasa.model.AkcijaPopust(a.id, a.datum_pocetka, a.datum_kraja, a.opis, a.iznos_popusta) "
				+ "FROM AkcijaPopust a "
				+ "WHERE a.datum_kraja > STR_TO_DATE(:datum1, \'%Y-%m-%d\')";
		Query q = session.createQuery(hql);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		q.setString("datum1",		df.format(new Date()));
		List redovi = q.list();
		t.commit();
		session.close();
		if(redovi.size() > 0) return (AkcijaPopust) redovi.get(0);
		return null;
	}
	
	
	public double kreirajStavkeRacuna(DefaultTableModel model, long racun_id){
		double iznos = 0.0;
		for (int count = 0; count < model.getRowCount(); count++){
			iznos += this.kreirajStavkuRacuna(model.getValueAt(count, 0).toString(), Integer.parseInt(model.getValueAt(count, 2).toString()), racun_id);
		} 
		return iznos;
	}
	
	private double kreirajStavkuRacuna(String barKod, int kolicina, long racun_id){
		Artikal art = this.dajArtikal(barKod);
		this.umanjiStanjeArtikla(art, kolicina);
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		StavkaRacuna sr = new StavkaRacuna();
		sr.setArtikal_id(art.getId());
		sr.setKolicina(kolicina);
		sr.setRacun_id(racun_id);
		sr.setUkupna_cijena(kolicina * art.getCijena());
		Long id = (Long) session.save(sr);
		t.commit();
		session.close();
		return sr.getUkupna_cijena();
	}
	
	private void kreirajNacinPlacanja(String nacinPlacanja, double iznos, long racun_id){
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		NacinPlacanja np = new NacinPlacanja();
		np.setIznos(iznos);
		np.setRacun_id(racun_id);
		np.setVrstaplacanja_id(nacinPlacanja);
		Long id = (Long) session.save(np);
		t.commit();
		session.close();
	}
	
	private void umanjiStanjeArtikla(Artikal artikal, int kolicina){
		artikal.setZalihe_stanje((int) (artikal.getZalihe_stanje() - kolicina));
		session.update(artikal);
	}
	
	public Artikal dajArtikal(String barKod) {
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Criteria crit = session.createCriteria(Artikal.class);
		crit.add(Restrictions.eq("barkod", barKod));
		List list = crit.list();
		Iterator itr = list.iterator();
		Artikal art = null;
		while (itr.hasNext()) {
		art = (Artikal) itr.next();}
		t.commit();
		session.close();
		return art;
	}
	
	public Artikal dajArtikalBezOtvaranjaSesije(String barKod) {
		Criteria crit = session.createCriteria(Artikal.class);
		crit.add(Restrictions.eq("barkod", barKod));
		List list = crit.list();
		Iterator itr = list.iterator();
		Artikal art = null;
		while (itr.hasNext()) {
		art = (Artikal) itr.next();}
		return art;
	}
	
}

