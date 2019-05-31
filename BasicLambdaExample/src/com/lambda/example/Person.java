package com.lambda.example;

import java.util.Comparator;

public class Person implements Comparator<Person>{

	
	private String firstName;
	private String lastName;
	private String address;
	private int phoneNumber;
	public Person() {
		super();
	}
	public Person(String firstName, String lastName, String address, int phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", phoneNumber="
				+ phoneNumber + "]";
	}
	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		return o1.lastName.compareTo(o2.getLastName());
	}
	
}
