package com.e_comm.productservice.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Locale.Category;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Products")
@Getter
@Setter
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String productName;
	
	@Column(nullable = false)
	private String description;
	
	private BigDecimal price;
	
	private Integer stockQuantity;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Category category;
	@Column(nullable = false)
	private String brand;
	@Column(nullable = false)
	private String sku;
	@Column(nullable = false)
	private String imageUrl;
	
	private Boolean active;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt;
	@UpdateTimestamp
	@Column(updatable = true)
	private LocalDateTime updatedAt;
	
	

}
