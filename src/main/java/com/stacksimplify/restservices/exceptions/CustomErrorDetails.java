package com.stacksimplify.restservices.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class CustomErrorDetails {
	
	@Getter
	private Date timeStamp;
	
	@Getter
	private String message;
	
	@Getter
	private String errorDetails;
	
	

}
