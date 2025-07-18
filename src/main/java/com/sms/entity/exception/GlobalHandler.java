package com.sms.entity.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorResponse> studentNotFoundException(StudentNotFoundException ex, WebRequest request) {
		ErrorResponse response = new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(StudentRollNoAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> stundentRollNoAlreadyExistsException(StudentRollNoAlreadyExistsException ex,
			WebRequest request) {
		ErrorResponse response = new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.CONFLICT);

	}

}
