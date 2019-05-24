package com.java.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.EmployeeInterface.EmployeeDetails;
import com.java.service.EmployeeService;

public class EmployeeLive {

	public static void main(String args[]) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		EmployeeDetails service = (EmployeeDetails) ctx.getBean("employeeService");
		service.getEmployeeDetals();
		service.getEmployeeName();
		service.getCompanyName();
	}
}
