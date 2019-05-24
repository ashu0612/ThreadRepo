package com.java.Sports;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//inheritance showing single table mapping strategy. 
@Entity
@Table(name = "PERSON")
public class Person {
	@Id
	@GeneratedValue
	@Column(name = "PERSON_ID")
	private int id;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToOne(cascade = CascadeType.ALL)
	private SportsDTO sports;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}*/
	public SportsDTO getSports() {
		return sports;
	}
	public void setSports(SportsDTO sports) {
		this.sports = sports;
	}
}
