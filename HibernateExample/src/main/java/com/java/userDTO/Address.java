package com.java.userDTO;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String street;
	private String city;
	private int flatno;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getFlatno() {
		return flatno;
	}
	public void setFlatno(int flatno) {
		this.flatno = flatno;
	}
}
