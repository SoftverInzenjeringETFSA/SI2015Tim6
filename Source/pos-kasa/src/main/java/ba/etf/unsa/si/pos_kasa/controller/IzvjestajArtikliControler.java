package ba.etf.unsa.si.pos_kasa.controller;

import ba.etf.unsa.si.pos_kasa.model.Artikal;
import ba.etf.unsa.si.pos_kasa.model.Kategorija;
import viewmodel.ArtikalZaIzvjestajProdato;

import java.util.Vector;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import org.hibernate.Transaction;
import org.hibernate.Session;
import java.util.List; 
import java.util.Iterator; 
 
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.toedter.calendar.JDateChooser;

import Tools.HibernateUtil;

import org.hibernate.criterion.Projections;
import org.hibernate.cfg.Configuration;

public class IzvjestajArtikliControler {
	
	
	public static void main(String[] args) throws ParseException{
		//String date_s = "2016-08-08";
		//SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		//Date datum1 = dt.parse(date_s);
		//String date_s1 = "2016-11-21";
		//SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
		//Date datum2 = dt.parse(date_s1);
		//List<ArtikalZaIzvjestajProdato>lista=vratiArtikleZaIzvjestajOProdatima(datum1,datum2);
		//System.out.println(lista.size());
		
	}
	public static List<String> vratiArtikleZaIzvjestaj()
	{	
		Session session = HibernateUtil.getSessionFactory().openSession();		
		String sql = "select * from tim6.artikal a where a.zalihe_stanje < 6";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Artikal.class);	
		List<Artikal> results = query.list();
		
		List<String> rezultati=new Vector<String>();
		for (int i=0;i<results.size();i++)
		{
			rezultati.add(results.get(i).getNaziv()+";;"+results.get(i).getBarkod()+";;"+results.get(i).getZalihe_stanje());
		}
		
		session.close();
		return rezultati;
		
	}
	public static List<ArtikalZaIzvjestajProdato> vratiArtikleZaIzvjestajOProdatima(Date date1, Date date2)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql ="select new viewmodel.ArtikalZaIzvjestajProdato(sum(sr.kolicina) as tab,a.naziv,a.barkod,a.cijena) from  Racun r, StavkaRacuna sr, Artikal a where r.id=sr.racun_id and sr.artikal_id=a.id and r.datum_i_vrijeme BETWEEN STR_TO_DATE(:datum1, \'%Y-%m-%d\') AND STR_TO_DATE(:datum2, \'%Y-%m-%d\') group by a.id order by tab desc";
		Query q = session.createQuery(hql);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		q.setString("datum1",		df.format(date1));
		q.setString("datum2", 		df.format(date2));
	    List<ArtikalZaIzvjestajProdato> rez=q.list();
		
		session.close();
		return rez;
	}
	public String[] vratiRazdovojeno(String str)
	{
		String[] novo=str.split(";;");
		return novo;
	}
	
	public List<ArtikalZaIzvjestajProdato> vratiSortirano(List<ArtikalZaIzvjestajProdato> lista)
	{
		long max=0;
		List<ArtikalZaIzvjestajProdato> lisic=new Vector<ArtikalZaIzvjestajProdato>();
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).kolicinaP>=0)
			{
				max=lista.get(i).kolicinaP;
				lisic.add(lista.get(i));
			}
		}
		return lisic;
	}
	public boolean provjeriDatume(Date date1)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		System.out.println(date);
		if(date1.before(date))
		{
			return false;
		}
		else {
			return true;
		}
	}

}
