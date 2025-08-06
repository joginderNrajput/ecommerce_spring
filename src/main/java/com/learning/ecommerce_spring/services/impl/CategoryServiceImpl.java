package com.learning.ecommerce_spring.services.impl;

import com.learning.ecommerce_spring.dto.CategoryDTO;
import com.learning.ecommerce_spring.dto.response.CreateCategoryResponse;
import com.learning.ecommerce_spring.entity.Category;
import com.learning.ecommerce_spring.gateway.FakeStoreCategoryGateway;
import com.learning.ecommerce_spring.repository.CategoryRepository;
import com.learning.ecommerce_spring.services.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    public final FakeStoreCategoryGateway fakeStoreCategoryGateway;
    public final CategoryRepository categoryRepository;

    public CategoryServiceImpl(@Qualifier("fakeStoreCategoryImpl") FakeStoreCategoryGateway fakeStoreCategoryGateway,
                               CategoryRepository categoryRepository){
        this.fakeStoreCategoryGateway = fakeStoreCategoryGateway;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<CategoryDTO> getAllCategoriesFakeStore() throws IOException {
        return fakeStoreCategoryGateway.getAllCategories();
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category= categoryRepository.save(Category.builder()
                .name(categoryDTO.getName())
                .build());

        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> CategoryDTO
                        .builder()
                        .id(category.getId())
                        .name(category.getName())
                        .build())
                .toList();
    }

    @Override
    public CategoryDTO getCategoryById(Long id) throws IOException {
        return categoryRepository.findById(id)
                .map(category -> CategoryDTO.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .build())
                .orElseThrow(() -> new IOException("Failed to retrieve Category"));
    }

}
