package com.dichvudulich.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dichvudulich.entity.ERole;
import com.dichvudulich.entity.RolesEntity;



public interface RolesRepository extends JpaRepository<RolesEntity, Long> {
	Optional<RolesEntity> findByName(ERole name);
}
