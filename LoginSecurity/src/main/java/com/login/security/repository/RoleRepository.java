package com.login.security.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.security.entity.ERole;
import com.login.security.entity.RolesEntity;


@Repository
public interface RoleRepository extends JpaRepository<RolesEntity, Long> {


Optional<RolesEntity> findByName(ERole name);
}
