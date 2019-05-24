package org.java.rest.Messanger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.java.rest.Messanger.controller.ErrorMessage;

//this will map our exception class to custom response
//this will tell jersey where to find the exception mapper 
//when we throw exception for data not found.
//we need to give provider anotation so that jersey will 
//know where to find this class.
@Provider
public class NoDataFoundExceptionMapper implements ExceptionMapper<NoDataFoundException>{

	@Override
	public Response toResponse(NoDataFoundException exception) {
		//need to provide our own custom response using the 
		//Json response class or model.
		ErrorMessage message = new ErrorMessage(exception.getMessage(), Status.NO_CONTENT.getStatusCode(), "This id doesnot have any data ");
		return Response.status(Status.NOT_FOUND).entity(message).build();
	}

}
