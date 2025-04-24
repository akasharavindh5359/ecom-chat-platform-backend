package com.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "image_data")
public class ImageEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "track_id")
	private long trackId;
	@Column(name = "masTran_id")
	private long masTranId;
	@Column(name = "image_name")
	private String imageName;
	@Lob
	@Column(name = "image_source" , columnDefinition = "LONGBLOB")
	private String imageSource;
	public long getTrackId() {
		return trackId;
	}
	public void setTrackId(long trackId) {
		this.trackId = trackId;
	}
	public long getMasTranId() {
		return masTranId;
	}
	public void setMasTranId(long masTranId) {
		this.masTranId = masTranId;
	}
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
