package com.ecommerce.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productData")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "masTranId")
	private long masTranId;
	@Column(name = "brand_name")
	private String 	brandName;
	@Column(name = "model_name")
	private String modelName;
	@Column(name = "product_desc")
	private String productdesc;
	@Column(name = "category")
    private String category;
	@Column(name = "os")
	private String os;
	@Column(name = "screen_size")
	private long screenSize;
	@Column(name = "memory_size")
	private long memorySize;
	@Column(name = "battery_size")
	private long batterySize;
	@Column(name = "best_price")
	private long bestPrice;
	@Column(name = "lowest_price")
	private long lowestPrice;
	@Column(name = "highest_price")
	private long highestPrice;
	@Column(name = "ratings")
	private float ratings;
	@Column(name = "popularity")
	private long popularity;
	@Column(name = "release_date")
	private String releaseDate;
	@Column(name = "prod_status")
	private boolean prodStatus;
	@Column(name = "prod_quantity")
    private int prodQuantity;
	@Column(name = "image_file" , columnDefinition = "LONGBLOB")
	private String imageFile;
	@Column(name = "img_name")
	private String imgName;
	public long getMasTranId() {
		return masTranId;
	}
	public void setMasTranId(long masTranId) {
		this.masTranId = masTranId;
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
	public String getProductdesc() {
		return productdesc;
	}
	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public long getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(long screenSize) {
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
	public float getRatings() {
		return ratings;
	}
	public void setRatings(float ratings) {
		this.ratings = ratings;
	}
	public long getPopularity() {
		return popularity;
	}
	public void setPopularity(long popularity) {
		this.popularity = popularity;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getProdQuantity() {
		return prodQuantity;
	}
	public void setProdQuantity(int prodQuantity) {
		this.prodQuantity = prodQuantity;
	}
	public boolean getProdStatus() {
		return prodStatus;
	}
	public void setProdStatus(boolean prodStatus) {
		this.prodStatus = prodStatus;
	}
	public String getImageFile() {
		return imageFile;
	}
	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	

}

