package com.hostel.exception;

public class ExceptionResponseSyntax {

	private int status;
	private String message;
	private String description;
	public ExceptionResponseSyntax(int status, String message, String description) {
		super();
		this.status = status;
		this.message = message;
		this.description = description;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public ExceptionResponseSyntax() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
