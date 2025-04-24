package com.ecommerce.entity;

import java.sql.Blob;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class NewProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "masTranId")
	private long masTranId;
	@Column(name = "category")
    private String category;
	@Column(name = "brand_name")
	private String brandName;
	@Column(name = "model_name")
	private String modelName;
	@Column(name = "os")
	private String os;
	@Column(name = "popularity")
	private long popularity;
	@Column(name = "best_price")
	private long bestPrice;
	@Column(name = "lowest_price")
	private long lowestPrice;
    @Column(name = "highest_price")
    private long highestPrice;
    @Column(name = "sellers_amount")
    private long sellersAmount;
    @Column(name = "screen_size")
    private double screenSize;;
    @Column(name = "memory_size")
    private long memorySize;
    @Column(name = "battery_size")
    private long batterySize;
    @Column(name = "release_date")
    private String releaseDate;
    @Column(name = "image_source", columnDefinition = "LONGBLOB")
    private String imageSource;
    @Column(name = "prod_status")
	private String prodStatus;
	public long getMasTranId() {
		return masTranId;
	}
	public void setMasTranId(long masTranId) {
		this.masTranId = masTranId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public long getPopularity() {
		return popularity;
	}
	public void setPopularity(long popularity) {
		this.popularity = popularity;
	}
	public long getBestPrice() {
		return bestPrice;
	}
	public void setBestPrice(long bestPrice) {
		this.bestPrice = bestPrice;
	}
	public long getLowestPrice() {
		return lowestPrice;
	}
	public void setLowestPrice(long lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	public long getHighestPrice() {
		return highestPrice;
	}
	public void setHighestPrice(long highestPrice) {
		this.highestPrice = highestPrice;
	}
	public long getSellersAmount() {
		return sellersAmount;
	}
	public void setSellersAmount(long sellersAmount) {
		this.sellersAmount = sellersAmount;
	}
	public double getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}
	public long getMemorySize() {
		return memorySize;
	}
	public void setMemorySize(long memorySize) {
		this.memorySize = memorySize;
	}
	public long getBatterySize() {
		return batterySize;
	}
	public void setBatterySize(long batterySize) {
		this.batterySize = batterySize;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getImageSource() {
		return imageSource;
	}
	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}
	public String getProdStatus() {
		return prodStatus;
	}
	public void setProdStatus(String prodStatus) {
		this.prodStatus = prodStatus;
	}

	
    
    
    
	
	
}
