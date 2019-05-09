package com.java.scopes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunScope {

	public static void main(String args[]) {
		ApplicationContext con = new ClassPathXmlApplicationContext("spring-config.xml");
		SingletonScope scA= (SingletonScope) con.getBean("SingletonScope"); 
		scA.setMsg("hi all for singleton");
		SingletonScope scB= (SingletonScope) con.getBean("SingletonScope");
		System.out.println("first object::" +scA.getMsg());
		//when scope is singleton then the bean has been shared and 
		//we can get the instance
		//in case of prototype:new instance has been created and for 
		//scB will give you null as we haven't set any msg for that object.
		System.out.println("second object::" +scB.getMsg());
	}
}
