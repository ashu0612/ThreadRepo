package com.java.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//Implements application context aware interface as
//scope of child bean Employee is of type prototype
//and aprent bean is singleton.
//so need to create new object of Employee every time when
//Employee detials gets called.
//Bean name gets loaded first as it gets called when container
//initializes the beans.
public class EmployeeDetails implements ApplicationContextAware,BeanNameAware{

	private Employee employeeOne;
	private Employee employeeTwo;
	private ApplicationContext con;
	public Employee getEmployeeOne() {
		return employeeOne;
	}
	public void setEmployeeOne(Employee employeeOne) {
		this.employeeOne = employeeOne;
	}
	public Employee getEmployeeTwo() {
		return employeeTwo;
	}
	public void setEmployeeTwo(Employee employeeTwo) {
		this.employeeTwo = employeeTwo;
	}
	public void getEmployeeDetails() {
		System.out.println("employee name: "+employeeOne.getName()+" and Post is "+employeeOne.getPost() );
		System.out.println("employee name: "+employeeTwo.getName()+" and Post is "+employeeTwo.getPost() );
	}
	public void setApplicationContext(ApplicationContext con) throws BeansException {
		// TODO Auto-generated method stub
		this.con = con;
	}
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("bean name is :"+name);
	}
}
