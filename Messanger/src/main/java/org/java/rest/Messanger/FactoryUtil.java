package org.java.rest.Messanger;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FactoryUtil {

	private static final SessionFactory factory = new Configuration().configure().buildSessionFactory(); 
	    
	public static SessionFactory getSessionFactory() {
		return factory;
	}
}
