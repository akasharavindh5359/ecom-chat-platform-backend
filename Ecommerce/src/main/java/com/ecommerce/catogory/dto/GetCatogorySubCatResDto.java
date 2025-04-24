package com.ecommerce.catogory.dto;

import java.util.List;

import com.ecommerce.dto.ErrorDescription;

public class GetCatogorySubCatResDto {
	
	private String status;
	private String responseMes;
	private List<CatNameDto> CatName;
	private List<ErrorDescription> errorDetails;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResponseMes() {
		return responseMes;
	}
	public void setResponseMes(String responseMes) {
		this.responseMes = responseMes;
	}
	
	public List<ErrorDescription> getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(List<ErrorDescription> errorDetails) {
		this.errorDetails = errorDetails;
	}
	public List<CatNameDto> getCatName() {
		return CatName;
	}
	public void setCatName(List<CatNameDto> catName) {
		CatName = catName;
	}
	
	
	
	
}
