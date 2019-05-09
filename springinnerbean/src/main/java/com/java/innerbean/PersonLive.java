package com.java.innerbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//innerbean example using setter injection and XML file
public class PersonLive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext con = new ClassPathXmlApplicationContext("spring-config.xml");
		PersonDetails personDetails = (PersonDetails) con.getBean("personDetails");
	    personDetails.getDetails();
	}

}
