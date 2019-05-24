package com.java.loose;

public class CybageResource implements ResourceDetail {

	private Resource resource;

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public void getResourceDetails() {
		// TODO Auto-generated method stub
		System.out.println("resourec details are :"+resource.getName()+" age :"+resource.getAge()+" and company is :"+resource.getCompanyName());
	}
	
}
