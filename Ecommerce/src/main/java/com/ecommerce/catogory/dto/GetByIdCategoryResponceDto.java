package com.ecommerce.catogory.dto;

import java.util.List;

import com.ecommerce.dto.ErrorDescription;
import com.ecommerce.entity.CategoryEntity;

public class GetByIdCategoryResponceDto {
	
	private String status;
	private String responseMes;
	private CategorySubDto catList;
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
	public CategorySubDto getCatList() {
		return catList;
	}
	public void setCatList(CategorySubDto catList) {
		this.catList = catList;
	}
	public List<ErrorDescription> getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(List<ErrorDescription> errorDetails) {
		this.errorDetails = errorDetails;
	}
	
	
	
}
