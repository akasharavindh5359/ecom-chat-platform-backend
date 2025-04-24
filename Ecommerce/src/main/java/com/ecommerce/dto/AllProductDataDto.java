package com.ecommerce.dto;

import java.util.ArrayList;

public class AllProductDataDto {
	
	private ArrayList<GetProductDto>productData;
//	private ArrayList<ImageEntity>imageData;
	private String message;
	private boolean Status;
	public ArrayList<GetProductDto> getProductData() {
		return productData;
	}
	public void setProductData(ArrayList<GetProductDto> productData) {
		this.productData = productData;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	
}
