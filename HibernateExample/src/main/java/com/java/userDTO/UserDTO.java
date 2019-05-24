package com.java.userDTO;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "USER_DETAILS")
public class UserDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	private String name;
	private int age;
	@AttributeOverrides({
	@AttributeOverride(name = "city",column = @Column(name = "HOME_CITY")),
	@AttributeOverride(name = "street",column = @Column(name = "HOME_STREET")),
	@AttributeOverride(name = "flatno",column = @Column(name = "HOME_FLAT"))
	})
	//this will create one separate table and uses the 
	//primary key of main table as foreign key of second table.
	@ElementCollection
	@JoinTable(name="USER_ADDRESS",joinColumns= @JoinColumn(name = "ID"))
	//to generate a primary key we are using
	//collection id annotation that will generate 
	//a primary key by using auto generation 
	//strategy that is 'hilo'
	//they all are hibernate annotations not JPA
	@GenericGenerator(name = "hilo_gen" ,strategy = "increment")
	@CollectionId(columns = @Column(name = "ADDRESS_ID"),generator = "hilo_gen",type = @Type(type = "long"))
	private List<Address> address;
	public VehicleDTO getVehicle() {
		return vehicle;
	}
	public void setVehicle(VehicleDTO vehicle) {
		this.vehicle = vehicle;
	}
	@OneToOne(cascade = CascadeType.ALL)
	//@JoinTable(name = "VEHICLE")
	@JoinColumn(name = "VEHICLE_ID")
	private VehicleDTO vehicle;
	@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name = "PHONE_ID")
	private List<PhoneDTO> phones;
	public List<PhoneDTO> getPhones() {
		return phones;
	}
	public void setPhones(List<PhoneDTO> phones) {
		this.phones = phones;
	}
}
