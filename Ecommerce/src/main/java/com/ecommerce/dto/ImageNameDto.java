package com.ecommerce.dto;

public class ImageNameDto {

	 private String imageName;
	 private String imageSource;

	    // Constructor with exactly 2 parameters for native query mapping
	    public ImageNameDto(String imageName, String imageSource) {
	        this.imageName = imageName;
	        this.imageSource = imageSource;
	    }

	    // Getters and setters
	    public String getImageName() {
	        return imageName;
	    }

	    public void setImageName(String imageName) {
	        this.imageName = imageName;
	    }

	    public String getImageSource() {
	        return imageSource;
	    }

	    public void setImageSource(String imageSource) {
	        this.imageSource = imageSource;
	    }
	
	
	
	
	
	
}
