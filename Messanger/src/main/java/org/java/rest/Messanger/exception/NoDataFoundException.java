package org.java.rest.Messanger.exception;

//handling null when no data found for certain value.
public class NoDataFoundException extends RuntimeException{

	private static final long serialVersionUID = 4L;
	public NoDataFoundException(String message) {
		super(message);
	}
}
