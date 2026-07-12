package com.e_comm.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_comm.productservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	

}
