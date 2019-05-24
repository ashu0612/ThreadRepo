package com.java.Sports;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "INDOORSPORTS")
//@DiscriminatorValue("indoor")
public class IndoorSportsDTO extends SportsDTO{
	/*@Id
	@Column(name = "OUTDOOR_ID")
	private int id;*/
	private String name;
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPlayers() {
		return players;
	}
	public void setPlayers(int players) {
		this.players = players;
	}
	private int players;
}
