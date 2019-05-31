package com.hostel.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HOSTEL")
public class Hostel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hostelId;
	private String name;
	private String address;
	public String getAddress() {
		return address;
	}
	@Override
	public String toString() {
		return "Hostel [hostelId=" + hostelId + ", name=" + name + ", address=" + address + "]";
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getHostelId() {
		return hostelId;
	}
	public void setHostelId(int hostelId) {
		this.hostelId = hostelId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
