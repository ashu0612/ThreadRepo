package com.java.innerbean;

public class PersonDetails {

	private Person personA;
	private Person personB;
	public Person getPersonA() {
		return personA;
	}
	public void setPersonA(Person personA) {
		this.personA = personA;
	}
	public Person getPersonB() {
		return personB;
	}
	public void setPersonB(Person personB) {
		this.personB = personB;
	}
	public void getDetails() {
		System.out.println("person name is :" +personA.getName()+ " and address is :"+personA.getAddress());
		System.out.println("person name is :" +personB.getName()+ " and address is :"+personB.getAddress());
	}
}
