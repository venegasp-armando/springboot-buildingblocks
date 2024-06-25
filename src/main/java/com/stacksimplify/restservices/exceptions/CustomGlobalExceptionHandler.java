package com.stacksimplify.restservices.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.validation.ConstraintViolationException;

//@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler{

	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, 
			HttpHeaders headers,
			HttpStatus status,
			WebRequest request){
		
		CustomErrorDetails custom = new CustomErrorDetails(new Date(), "From MethodArgumentNotValid exception in GEH", ex.getMessage());
		return new ResponseEntity<Object>(custom, HttpStatus.BAD_REQUEST);
	}
	
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			MethodArgumentNotValidException ex, 
			HttpHeaders headers,
			HttpStatus status,
			WebRequest request){
		
		CustomErrorDetails custom = new CustomErrorDetails(new Date(), "From handleHttpRequestMethodNotSupported exception in GEH - Method not allowed", ex.getMessage());
		return new ResponseEntity<Object>(custom, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	public final ResponseEntity<Object> handleUserNameNotFoundException(
			UserNameNotFoundException ex, 
			HttpHeaders headers,
			HttpStatus status,
			WebRequest request){
		
		CustomErrorDetails custom = new CustomErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(custom, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<Object> handleConstraintViolationException(
			ConstraintViolationException ex, 
			HttpHeaders headers,
			HttpStatus status,
			WebRequest request){
		
		CustomErrorDetails custom = new CustomErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(custom, HttpStatus.NOT_FOUND);
	}
}
