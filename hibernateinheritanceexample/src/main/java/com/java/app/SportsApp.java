package com.java.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;

import com.java.Sports.IndoorSportsDTO;
import com.java.Sports.OutdoorSportsDTO;
import com.java.Sports.Person;
import com.java.Sports.SportsDTO;

public class SportsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Person person = new Person();
		SportsDTO sports = new SportsDTO();
		sports.setType("outdoor");
		IndoorSportsDTO indoor = new IndoorSportsDTO();
		indoor.setType("indoor");
		indoor.setName("TT");
		indoor.setPlayers(2);
		OutdoorSportsDTO outdoor = new OutdoorSportsDTO();
		outdoor.setType("outdoor");
		outdoor.setName("Football");
		outdoor.setPlayers(11);
		person.setName("Ashu");
		person.setSports(sports);
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(indoor);
		session.save(outdoor);
		session.save(person);
		session.getTransaction().commit();
		session.close();
		System.out.println("done");
		
	}

}
