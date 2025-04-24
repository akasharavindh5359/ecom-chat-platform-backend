package com.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CategoryData")
public class CategoryEntity {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cat_tran_id")
	private long catTranId;
	@Column(name = "category_name")
	private String categoryName;
	@Column(name = "category_img_source",columnDefinition = "LONGBLOB")
	private String categoryImg;
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
	
	

}
