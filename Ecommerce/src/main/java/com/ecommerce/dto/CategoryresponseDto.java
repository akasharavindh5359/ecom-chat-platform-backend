package com.ecommerce.dto;

import java.util.List;

import com.ecommerce.entity.CategoryEntity;

public class CategoryresponseDto {

	private String status;
	private String responseMes;
	private CategoryEntity categoryData;
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
	public CategoryEntity getCategoryData() {
		return categoryData;
	}
	public void setCategoryData(CategoryEntity categoryData) {
		this.categoryData = categoryData;
	}
	public List<ErrorDescription> getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(List<ErrorDescription> errorDetails) {
		this.errorDetails = errorDetails;
	}
	
	
	
	
	
	
	
	
	
	
	
}
