package com.map.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MapRun {

	public static void main(String args[]) {
		ApplicationContext con = new ClassPathXmlApplicationContext("spring-config.xml");
		MapExample me = (MapExample) con.getBean("MapExample");
		System.out.println(me.getMapObj());
	}
}
