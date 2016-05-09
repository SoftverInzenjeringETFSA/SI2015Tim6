package ba.etf.unsa.si.pos_kasa.controller;

import Tools.HibernateUtil;
import ba.etf.unsa.si.pos_kasa.model.*;

import java.util.Date;
import java.util.Scanner;
import org.hibernate.Transaction;
import org.hibernate.Session;

public class Izvjestaji {

    public static void main( String[] args )
    {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println( "Hello World! Bake " );
        dodajKategoriju(session);
        session.close();
    }
    
    private static void dodajKategoriju(Session session) {
    	Transaction t = session.beginTransaction();
    	Kategorija s = new Kategorija();
    	s.setNaziv("fina kategorija");
    	s.setOpis("jos ljepsi opis");
    	Long id = (Long) session.save(s);
    	System.out.println("Dodan racun sa IDom "+id);
    	t.commit();
    	}
}
