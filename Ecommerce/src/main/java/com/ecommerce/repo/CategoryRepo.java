package com.ecommerce.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;import org.springframework.transaction.annotation.Propagation;

import com.ecommerce.entity.CategoryEntity;

import jakarta.transaction.Transactional;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity, Long> {

	@Query(value = "SELECT * FROM ecommerceo2.category_data?1 ;",nativeQuery = true)
	CategoryEntity findByCategoryName(String categoryName);

	@Query(value = "SELECT * FROM ecommerceo2.category_data where cat_tran_id=?1;",nativeQuery = true)
	CategoryEntity GetCatogorybyId(long id);

	
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE category_data SET category_name = ?2,category_img_source=?3 WHERE cat_tran_id = ?1;",nativeQuery = true)
	int updateCatogory(long catogoryId, String catogoryName, String catogoryImg);
	
//	void addSubCatogory();

}
