package com.learning.ecommerce_spring.dto;

import lombok.Data;

@Data
public class Product{
	private String color;
	private String discount;
	private String model;
	private String id;
	private String title;
	private String category;
	private String brand;
}