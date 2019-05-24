package com.java.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//This class is an aspect which refers to the cross cutting 
//objects and their concerns.
//this will determine whether we want to get the message 
//before calling all the getters() method present in the 
//spring container object.
@Aspect
public class EmployeeAdvice {
	//It will execute for all the getter methods of type void.
	@Before("getAllEmployee() || getEmployeeGetters() ")
	public void getMessageLog() {
		System.out.println("this message is for the company of cybage");
	}
	
	@Pointcut("execution(public void getEmployee*())")
	public void getEmployeeGetters() {}
	@Pointcut("within(com.java.service.EmployeeService)")
	public void getAllEmployee() {}
}
