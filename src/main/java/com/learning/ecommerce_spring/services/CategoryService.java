package com.learning.ecommerce_spring.services;

import com.learning.ecommerce_spring.dto.CategoryDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface CategoryService {
    List<CategoryDTO> getAllCategoriesFakeStore() throws IOException;

    CategoryDTO createCategory(CategoryDTO category);

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryById(Long id) throws IOException;
}
