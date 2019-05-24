package com.java.loose;

import org.springframework.beans.factory.annotation.Required;

public class Resource {

	private String name;
	private int age;
	private String companyName;
	public String getName() {
		return name;
	}
	@Required
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	@Required
	public void setAge(int age) {
		this.age = age;
	}
	public String getCompanyName() {
		return companyName;
	}
	@Required
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
