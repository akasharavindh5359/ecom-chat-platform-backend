package com.ecommerce.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.ImageEntity;



@Repository
public interface ImageRepo extends JpaRepository<ImageEntity, Long> {

	@Modifying
	@Transactional
	@Query(value = "insert into product_image (image_track_id,image_name,image_type,image_data) values (?2, ?1, ?3, ?4)", nativeQuery = true)
//	@Query(value = "insert into product_image () values (?1,?2,?3,?4)",nativeQuery = true)
	void saveImageData(String imageName, long imageTrackId, String imageType, byte[] imagedata);
	
	@Modifying
	@Transactional
	@Query(value = "insert into image_data (mas_tran_id,image_name,image_source) values (?1, ?2, ?3)", nativeQuery = true)
	void ImageDataSave(long masTranId, String imageName, String imageSource);

	
	@Query(value = "SELECT * FROM ecom_one.image_data where mas_tran_id=?1", nativeQuery = true)
	ArrayList<ImageEntity> getImageData(long masTranId);

//	@Query(value = "SELECT image_name, image_source FROM ecom_two.image_data WHERE mas_tran_id = ?1", nativeQuery = true)
//	ArrayList<ImageNameDto> getimgdata(long masTranId);

}
