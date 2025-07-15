package com.learning.fake_store.dto;

import java.util.List;
import lombok.Data;

@Data
public class FakeStoreCategoryResponseDTO{
	private List<String> categories;
	private String message;
	private String status;
}