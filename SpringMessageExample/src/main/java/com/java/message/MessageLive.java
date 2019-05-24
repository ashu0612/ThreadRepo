package com.java.message;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageLive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext con = new ClassPathXmlApplicationContext("config.xml");
		MessageDetails details = (MessageDetails) con.getBean("messageInfo");
		details.getMessageDetails();
		//System.out.println(con.getMessage("greeting", null, "default message", null));
	}

}
