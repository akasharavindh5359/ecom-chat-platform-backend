package com.ecommerce.catogory.dto;

import java.util.List;

import com.ecommerce.dto.ErrorDescription;
import com.ecommerce.entity.CategoryEntity;

public class SubCatogoryResponceDto {

	private String status;
	private String responseMes;
	private long subCatogoryId;
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
	public long getSubCatogoryId() {
		return subCatogoryId;
	}
	public void setSubCatogoryId(long subCatogoryId) {
		this.subCatogoryId = subCatogoryId;
	}
	public List<ErrorDescription> getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(List<ErrorDescription> errorDetails) {
		this.errorDetails = errorDetails;
	}
	
	
	
	
	
}
