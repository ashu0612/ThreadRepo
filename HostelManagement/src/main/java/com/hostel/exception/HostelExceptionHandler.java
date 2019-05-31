package com.hostel.exception;

import org.hibernate.engine.spi.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HostelExceptionHandler {

	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<ExceptionResponseSyntax> getNoDataFoundErrorResponse(NoDataFoundException exception) {
		ExceptionResponseSyntax ex = new ExceptionResponseSyntax(HttpStatus.NO_CONTENT.value(), exception.getMessage(),
				"no data found for certain id");
		return new ResponseEntity<ExceptionResponseSyntax>(ex, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ExceptionResponseSyntax> getBadRequest(BadRequestException ex){
		ExceptionResponseSyntax e = new ExceptionResponseSyntax(HttpStatus.BAD_REQUEST.value(),ex.getMessage(),"bad request occurs kinly change it");
		return new ResponseEntity<ExceptionResponseSyntax>(e,HttpStatus.BAD_REQUEST);
	}
	
}
