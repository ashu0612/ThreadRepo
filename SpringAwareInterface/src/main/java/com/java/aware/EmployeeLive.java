package com.java.aware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeLive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext con = new ClassPathXmlApplicationContext("spring-config.xml");
		EmployeeDetails details = (EmployeeDetails)con.getBean("employeeDetails");
		details.getEmployeeDetails();
	}

}
