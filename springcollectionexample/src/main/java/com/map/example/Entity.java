package com.map.example;

public class Entity {

	
	private String name;
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Entity [name=" + name + ", address=" + address + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String address;
}
