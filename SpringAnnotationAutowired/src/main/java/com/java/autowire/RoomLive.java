package com.java.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RoomLive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext con = new ClassPathXmlApplicationContext("config.xml");
		con.registerShutdownHook();
		RoomDetails details = (RoomDetails) con.getBean("DrawingRoom");
		details.getRoomDetails();
	}

}
