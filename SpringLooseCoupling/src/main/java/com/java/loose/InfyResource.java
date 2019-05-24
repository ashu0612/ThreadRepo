package com.java.loose;

import org.springframework.beans.factory.annotation.Required;

public class InfyResource implements ResourceDetail  {
 private Resource resourceInfy;

public Resource getResourceInfy() {
	return resourceInfy;
}
public void setResourceInfy(Resource resourceInfy) {
	this.resourceInfy = resourceInfy;
}

public void getResourceDetails() {
	// TODO Auto-generated method stub
	System.out.println("resource details are :"+resourceInfy.getName()+" age :"+resourceInfy.getAge()+" and company is :"+resourceInfy.getCompanyName());
}
 
}
