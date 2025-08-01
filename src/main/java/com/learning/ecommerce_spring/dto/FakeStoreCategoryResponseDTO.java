package com.learning.ecommerce_spring.dto;

import java.util.List;
import lombok.Data;

@Data
public class FakeStoreCategoryResponseDTO{
	private List<String> categories;
	private String message;
	private String status;
}