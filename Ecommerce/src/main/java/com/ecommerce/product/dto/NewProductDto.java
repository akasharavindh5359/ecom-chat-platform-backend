package com.ecommerce.product.dto;


public class NewProductDto {

	
    private String category;
	private String brandName;
	private String modelName;
	private String os;
	private long popularity;
	private long bestPrice;
    private long sellersAmount;
    private double screenSize;;
    private long memorySize;
    private long batterySize;
    private String releaseDate;
    private String imageSource;
	private String prodStatus;
	private long highestPrice;
	private long lowestPrice;
	
	public long getHighestPrice() {
		return highestPrice;
	}
	public void setHighestPrice(long highestPrice) {
		this.highestPrice = highestPrice;
	}
	public long getLowestPrice() {
		return lowestPrice;
	}
	public void setLowestPrice(long lowestPrice) {
		this.lowestPrice = lowestPrice;
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
