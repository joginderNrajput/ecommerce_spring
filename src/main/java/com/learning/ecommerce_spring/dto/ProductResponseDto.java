package com.learning.ecommerce_spring.dto;

import lombok.Data;

@Data
public class ProductResponseDto{
	private ProductDTO product;
	private String message;
	private String status;
}