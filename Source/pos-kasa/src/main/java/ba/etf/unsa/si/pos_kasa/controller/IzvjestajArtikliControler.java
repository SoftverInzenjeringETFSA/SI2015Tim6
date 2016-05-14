package ba.etf.unsa.si.pos_kasa.controller;

import ba.etf.unsa.si.pos_kasa.model.Artikal;
import ba.etf.unsa.si.pos_kasa.model.Kategorija;

import java.util.Vector;
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

import Tools.HibernateUtil;

import org.hibernate.criterion.Projections;
import org.hibernate.cfg.Configuration;

public class IzvjestajArtikliControler {
	
	
	public static void main(String[] args){
		
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
	public String[] vratiRazdovojeno(String str)
	{
		String[] novo=str.split(";;");
		return novo;
	}
	
	
	

}
