package com.dichvudulich.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dichvudulich.entity.UsersEntity;



public interface UsersRepository extends JpaRepository<UsersEntity, Long> {

	Optional<UsersEntity> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
