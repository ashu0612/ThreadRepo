package com.java.loose;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResourceLive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext con = new ClassPathXmlApplicationContext("config.xml");
		ResourceDetail detailCyabge = (ResourceDetail) con.getBean("CybageResource");
		detailCyabge.getResourceDetails();
		ResourceDetail detailInfy = (ResourceDetail) con.getBean("InfyResource");
		detailInfy.getResourceDetails();
	}

}

/*
 * Exception encountered during context initialization - cancelling refresh
 * attempt: org.springframework.beans.factory.BeanCreationException: Error
 * creating bean with name 'InfyResource' defined in class path resource
 * [config.xml]: Cannot resolve reference to bean 'resourceInfy' while setting
 * bean property 'resourceInfy'; nested exception is
 * org.springframework.beans.factory.BeanCreationException: Error creating bean
 * with name 'resourceInfy' defined in class path resource [config.xml]:
 * Initialization of bean failed; nested exception is
 * org.springframework.beans.factory.BeanInitializationException: Properties
 * 'age' , 'companyName' and 'name' are required for bean 'resourceInfy' The
 * above exception occurs when dependency not found according to the required
 * annotation. This will not throw runtime exception as spring will automatically
 * handle this this.
 */