package com.ecommerce.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.ImageEntity;
import com.ecommerce.entity.NewProductEntity;
import com.ecommerce.entity.ProductEntity;





@Repository
public interface ProductRepo extends JpaRepository<NewProductEntity, Long>{

	

	

//	@Query(value = "select * from ecom_one.product_data a inner join ecom_one.image_data b on b.mas_tran_id = a.mas_tran_id where a.prod_status = 1;", nativeQuery = true)
	
	@Query(value = "select * from ecommerceo2.product_data where prod_status='1';", nativeQuery = true)
	ArrayList<ProductEntity> getallData();

	@Query(value = "SELECT * FROM ecommerceo2.image_data;", nativeQuery = true)
	ArrayList<ImageEntity> getallImgData();

	
	

}
