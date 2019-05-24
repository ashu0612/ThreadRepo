package com.java.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.userDTO.Address;
import com.java.userDTO.PhoneDTO;
import com.java.userDTO.UserDTO;
import com.java.userDTO.VehicleDTO;
//save an object in data base	
public class RunTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//UserDTO user = new UserDTO();
		List<Address> list = new LinkedList<>();
		List<VehicleDTO> vehicleList = new LinkedList<>();
		VehicleDTO vehicleAshu = new VehicleDTO();
		vehicleAshu.setName("Mustang");
		vehicleAshu.setPrice(50000000);
		VehicleDTO vehicleVishu = new VehicleDTO();
		vehicleVishu.setName("Lambhorgini");
		vehicleVishu.setPrice(500000000);
		VehicleDTO vehicleSha = new VehicleDTO();
		vehicleSha.setName("Thar");
		vehicleSha.setPrice(50000000);
		VehicleDTO vehicleTest = new VehicleDTO();
		vehicleTest.setName("cycle");
		vehicleTest.setPrice(5000);
		vehicleList.add(vehicleAshu);
		vehicleList.add(vehicleVishu);
		vehicleList.add(vehicleSha);
		vehicleList.add(vehicleTest);
		Address addressAshu = new Address();
		addressAshu.setCity("Pune");
		addressAshu.setStreet("kalyani nagar");
		addressAshu.setFlatno(18);
		Address addressVishu = new Address();
		addressVishu.setCity("Tirupati");
		addressVishu.setStreet("Tirumala");
		addressVishu.setFlatno(7);
		Address addressSha = new Address();
		addressSha.setCity("Pune");
		addressSha.setStreet("Sehkar Nagar");
		addressSha.setFlatno(10);
		Address addressTest = new Address();
		addressTest.setCity("Test");
		addressTest.setStreet("Test");
		addressTest.setFlatno(1);
		Map <Integer,String> userMap = new LinkedHashMap<>();
		userMap.put(27, "ashu");
		userMap.put(21, "vishu");
		userMap.put(25, "shrawani");
		userMap.put(30, "testuser");
		list.add(addressAshu);
		list.add(addressVishu);
		list.add(addressSha);
		list.add(addressTest);
		//user.setId(2);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		int count = 0;
		for(int value:userMap.keySet()) {
			session.beginTransaction();
			//this is in loop becuase every time the 
			//sequence is generated while creating the 
			//list of object otherwise it will throw 
			//unique constraint voilation exception.
			List<PhoneDTO> phones = new LinkedList<>();
			PhoneDTO phoneOnePlus = new PhoneDTO();
			//phoneOnePlus.setId(200);
			phoneOnePlus.setPhoneName("OnePlus");
			PhoneDTO phoneApple = new PhoneDTO();
			//phoneApple.setId(100);
			phoneApple.setPhoneName("Apple");
			phones.add(phoneApple);
			phones.add(phoneOnePlus);
			UserDTO user = new UserDTO();
			user.setAge(value);
			user.setName(userMap.get(value));
			user.setAddress(list);
			user.setVehicle(vehicleList.get(count));
			user.setPhones(phones);
			count++;
			//user.setAddress(address);
			session.save(user);
			
			session.getTransaction().commit();
			//user = null;
			//list.add(user);
			
		}
		
		/*for(UserDTO u:list ) {
			session.save(u);
		}*/
		System.out.println("object saved in database");
		
		session.close();
		
		//to get the object using session.get() method using primary key.
		 UserDTO fetchLazyUser = new UserDTO();
		 //to check the default strategy we can check how 
		 //lazy fetching works.Hibernate is using proxy class
		 //which will fetch the data oonly when we call get method 
		 //from the class.we can check this by closing the session
		 //and test that whether getter works.
		/* session = factory.openSession();
		 session.beginTransaction();
		 fetchLazyUser = session.get(UserDTO.class, 2);
		 
		 // could not initialize proxy - no Session error occurs.
		 System.out.println("user list of address is :::"+fetchLazyUser.getAddress().size());
		 session.getTransaction().commit();
		 session.close();*/
	}

}
