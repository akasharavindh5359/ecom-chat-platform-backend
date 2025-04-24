package com.ecommerce.catogory.dto;

import java.util.List;

public class CatNameDto {
	
	 private Long catId;
	 private String catName;
	 private List<Subcatogory> subCatName;
	public Long getCatId() {
		return catId;
	}
	public void setCatId(Long catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public List<Subcatogory> getSubCatName() {
		return subCatName;
	}
	public void setSubCatName(List<Subcatogory> subCatName) {
		this.subCatName = subCatName;
	}
	 
	
	
	

}
