package com.java.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJava {

	public static void main(String args[]) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);	
		Config config = (Config) context.getBean("javaBean");
		config.printMsg();
	}
}
