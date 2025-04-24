package com.ecommerce.dto;

import java.util.List;

import com.ecommerce.entity.NewProductEntity;
import com.ecommerce.entity.ProductEntity;

public class ProductresponseDto {
	
	private String status;
	private String responseMes;
	private NewProductEntity productData;
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
	
	public NewProductEntity getProductData() {
		return productData;
	}
	public void setProductData(NewProductEntity productData) {
		this.productData = productData;
	}
	public List<ErrorDescription> getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(List<ErrorDescription> errorDetails) {
		this.errorDetails = errorDetails;
	}
	
	

}
