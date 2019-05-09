package com.data.loosecoupling;
//showing loose coupling and DI using setter injection.

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Helper {
	Loose helpMen;
	public void getMsg() {
		helpMen.printMsg();
	}
	public void setHelpMen(Loose helpMen) {
		this.helpMen = helpMen; 
	}
	
}
public class LooseCoupling {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-configuration.xml");
		Helper help = (Helper) context.getBean("Helper");
		help.getMsg();
	}
}
