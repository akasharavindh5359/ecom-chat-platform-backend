package com.login.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.security.entity.RolesEntity;


@Repository
public interface RoleRepo extends JpaRepository<RolesEntity, Long> {
//Optional<RoleEntity>findByName(ERole name);
}
