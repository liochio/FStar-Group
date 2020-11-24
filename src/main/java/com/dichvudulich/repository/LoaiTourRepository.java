package com.dichvudulich.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dichvudulich.entity.LoaitourEntity;

public interface LoaiTourRepository extends JpaRepository<LoaitourEntity, Long> {


	Boolean existsByMaloaitour(String maloaitour);

	Boolean existsByTenloaitour(String tenloaitour);
	
	
	
}
