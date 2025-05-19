package com.login.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.login.security.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value = "select * from login_security.users where username =?1",nativeQuery = true)
	Optional<User> findByUsername(String username);
	
	@Query(value = "SELECT COUNT(*) > 0 FROM login_security.users WHERE username = ?1", nativeQuery = true)
	int exisexistsByUserNameData(String username);

}
