package com.ecommerce.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sub_catogory_data")
public class SubCatogoryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tran_id")
	private Long id;
	@Column(name = "cat_tran_id")
	private long CatTranId;
	@Column(name = "sub_cat_name")
	private String SubCatName;
	@Column(name = "status")
	private String Status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getCatTranId() {
		return CatTranId;
	}
	public void setCatTranId(long catTranId) {
		CatTranId = catTranId;
	}
	public String getSubCatName() {
		return SubCatName;
	}
	public void setSubCatName(String subCatName) {
		SubCatName = subCatName;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	
	
	

}
