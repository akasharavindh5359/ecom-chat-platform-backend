package com.ecommerce.catogory.dto;

import java.util.List;

public class UpdateCatogoryDto {
	
	private long catogoryId;
	private String catogoryName;
	private String catogoryImg;
	private List<Subcatogory> subCatogory;
	public long getCatogoryId() {
		return catogoryId;
	}
	public void setCatogoryId(long catogoryId) {
		this.catogoryId = catogoryId;
	}
	public String getCatogoryName() {
		return catogoryName;
	}
	public void setCatogoryName(String catogoryName) {
		this.catogoryName = catogoryName;
	}
	public String getCatogoryImg() {
		return catogoryImg;
	}
	public void setCatogoryImg(String catogoryImg) {
		this.catogoryImg = catogoryImg;
	}
	public List<Subcatogory> getSubCatogory() {
		return subCatogory;
	}
	public void setSubCatogory(List<Subcatogory> subCatogory) {
		this.subCatogory = subCatogory;
	}
	
	
	
	

}
