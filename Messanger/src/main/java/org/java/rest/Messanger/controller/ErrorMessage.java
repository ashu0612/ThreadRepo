package org.java.rest.Messanger.controller;

import javax.ws.rs.ext.Provider;
import javax.xml.bind.annotation.XmlRootElement;

//we are creating the json response for our custom exception
@XmlRootElement
public class ErrorMessage {

	private String message;
	private int statusCode;
	private String description;
	public ErrorMessage(String message, int statusCode, String description) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.description = description;
	}
	//this is needed to serialize and deserialize the object as
	//we need json response
	public ErrorMessage() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
