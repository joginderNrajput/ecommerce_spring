package com.learning.fake_store.dto;

import lombok.Data;

@Data
public class ProductResponseDto{
	private ProductDTO product;
	private String message;
	private String status;
}