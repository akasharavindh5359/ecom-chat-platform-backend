package com.ecommerce.dto;

import org.springframework.http.HttpStatus;

public class StatusDto {
	
	private String Message;
	private HttpStatus StatusCode;
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public HttpStatus getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(HttpStatus statusCode) {
		StatusCode = statusCode;
	}
	
	

	
	

}
