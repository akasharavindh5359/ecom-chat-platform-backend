package com.ecommerce.dto;

import java.util.List;

import com.ecommerce.entity.CategoryEntity;

public class GetCategoryResponceDto {
	
	private String status;
	private String responseMes;
	private List<CategoryEntity> catList;
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
	public List<CategoryEntity> getCatList() {
		return catList;
	}
	public void setCatList(List<CategoryEntity> catList) {
		this.catList = catList;
	}
	public List<ErrorDescription> getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(List<ErrorDescription> errorDetails) {
		this.errorDetails = errorDetails;
	}
	
	
	
	
}
