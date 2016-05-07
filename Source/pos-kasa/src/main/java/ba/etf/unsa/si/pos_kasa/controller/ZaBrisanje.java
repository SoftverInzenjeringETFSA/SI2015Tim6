package ba.etf.unsa.si.pos_kasa.controller;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import ba.etf.unsa.si.pos_kasa.model.Racun;

public class ZaBrisanje {

	  private static final SessionFactory sessionFactory = buildSessionFactory();

	    private static SessionFactory buildSessionFactory() {
	        try {
	            // Create the SessionFactory from hibernate.cfg.xml
	            return new Configuration().configure().buildSessionFactory();
	        }
	        catch (Throwable ex) {
	            // Make sure you log the exception, as it might be swallowed
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }

	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
	    private static Scanner sc = new Scanner(System.in);
	    public static void main(String[] args) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    dodajStudenta(session);
	    session.close();
	    }
	    private static void dodajStudenta(Session session) {
	    Transaction t = session.beginTransaction();
	    Racun s = new Racun();
	    s.setBroj_racuna(3123);
	    System.out.println("Dodan student sa IDom "+id);
	    t.commit();
	    }

}
