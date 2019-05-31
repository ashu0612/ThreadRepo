package com.hostel.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import com.hostel.dao.HostelDAO;
import com.hostel.pojo.Hostel;

@Aspect
@Configuration
public class HostelAspect {

	@Before("forAllDao()")
	public void getLogsForAllGetters(JoinPoint jointPoint) {
		HostelDAO dao = (HostelDAO) jointPoint.getTarget();
		dao.getLogsForTargetObjects();
		System.out.println(jointPoint.toString());
	}

	@Before("args(name) && forAllDao()")
	public void getMethodArgumentForPreProcessing(Hostel name) {
		System.out.println("the argument value is :" + name.getName());
	}

	// it acts as a final advice it will run everytime
	// whether method successfully executes or not.
	@After("forAllDao()")
	public void getAdviceAfter() {
		System.out.println("advice after method calls");
	}

	// this will run only when method executes successfully.
	@AfterReturning("forAllDao()")
	public void getAdviceOnSuccessFulCompletion() {
		System.out.println("method successfully executes");
	}

	// this will occur when we throw any exception
	@AfterThrowing("forAllDao()")
	public void getAdviceAfterException() {
		System.out.println("exception occurs");
	}
	
	@AfterReturning(pointcut="args(name) && forAllDao()",returning = "mainObject")
	public void getSuccessfullObject(Hostel name,Hostel mainObject) {
		System.out.println("the values of objectInput :"+name.toString());
		System.out.println("the values of objectOutput :"+mainObject.toString());
	}
	@Pointcut("within(com.hostel.dao.HostelDAO)")
	public void forAllDao() {
	}
}
