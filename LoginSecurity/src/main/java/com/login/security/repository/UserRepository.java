package com.login.security.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.login.security.entity.RolesEntity;
import com.login.security.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

//	@Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM Login.users WHERE email_id = ?1", nativeQuery = true)
//	boolean existsByUsername(String userName);
	@Query(value = "SELECT COUNT(*) FROM Login.users WHERE email_id = ?1", nativeQuery = true)
	Long existsByUsername(String emailId);
	
	@Query(value = "SELECT * FROM Login.users WHERE email_id = ?1", nativeQuery = true)
	Optional<UserEntity> findByEmail(String username);
	

}
