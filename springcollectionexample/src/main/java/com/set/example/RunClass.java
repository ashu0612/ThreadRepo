package com.set.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunClass {

	public static void main(String args[]) {
		ApplicationContext con = new AnnotationConfigApplicationContext(SetExample.class);
		SetExample se = (SetExample) con.getBean("setExample");
		
		se.printSet();
	}
}
