package com.ecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ecommerce.entity.SubCatogoryEntity;
import jakarta.transaction.Transactional;
@Repository
public interface SubCatogoryRepo extends JpaRepository<SubCatogoryEntity, Long> {

//	@Transactional
//	@Query(value = "insert into sub_catogory_data (cat_tran_id,sub_cat_name,status) value (?1,?2,?3,?4)", nativeQuery = true)
//	SubCatogoryEntity create(long catTranId, String subCatName, String status);

	@Transactional
    @Modifying
	@Query(value = "DELETE FROM sub_catogory_data WHERE cat_tran_id=1; insert into ecommerceo2.sub_catogory_data (cat_tran_id,sub_cat_name,status) value (?1,?2,?3)",nativeQuery = true)
	int newagin(long catTranId, String subCatName, String status);

	@Query(value = "SELECT * FROM ecommerceo2.sub_catogory_data where cat_tran_id=?1;",nativeQuery = true)
	List<SubCatogoryEntity> getSubCatData(long id);

	@Modifying
    @Transactional
    @Query(value = "DELETE FROM sub_catogory_data WHERE cat_tran_id = ?1", nativeQuery = true)
    void deleteSubCategory(long catogoryId);


//	@Query(value = "insert into sub_catogory_data (tran_id,cat_tran_id,sub_cat_name,status) values (100,1000,'axkdsdakj','AAcitve')",nativeQuery = true)
//	SubCatogoryEntity SavesubCatogory(long l,long catTranId, String subCatName, String status);	
}
