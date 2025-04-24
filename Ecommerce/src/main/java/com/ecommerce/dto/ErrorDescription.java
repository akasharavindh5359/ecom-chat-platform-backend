package com.ecommerce.dto;

public class ErrorDescription {
	   private String errorCode;
	   private String errorDescription;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public ErrorDescription(String errorCode, String errorDescription) {
		
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}
	   
	   
}