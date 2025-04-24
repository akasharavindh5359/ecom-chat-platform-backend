package com.ecommerce.catogory.dto;

import java.util.List;

import jakarta.persistence.Column;

public class CategorySubDto {
	
	private long catTranId;
	private String categoryName;
	private String categoryImg;
	private List<Subcatogory> subCatogory;
	public long getCatTranId() {
		return catTranId;
	}
	public void setCatTranId(long catTranId) {
		this.catTranId = catTranId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryImg() {
		return categoryImg;
	}
	public void setCategoryImg(String categoryImg) {
		this.categoryImg = categoryImg;
	}
	public List<Subcatogory> getSubCatogory() {
		return subCatogory;
	}
	public void setSubCatogory(List<Subcatogory> subCatogory) {
		this.subCatogory = subCatogory;
	}
	
	

}
