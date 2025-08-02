package com.learning.ecommerce_spring.mapper;

import com.learning.ecommerce_spring.dto.CategoryDTO;
import com.learning.ecommerce_spring.dto.FakeStoreCategoryResponseDTO;
import com.learning.ecommerce_spring.entity.Category;

import java.util.List;

//using Adapter Design Pattern here
public class CategoryMapper {

    private CategoryMapper(){
        throw new UnsupportedOperationException("This is just a utility Class");
    }

    public static FakeStoreCategoryResponseDTO toFakeStoreCategoryResponseDTO(){
        return null;
    }

    public static List<CategoryDTO> toCategoryDto(FakeStoreCategoryResponseDTO fakeStoreCategoryResponseDTO) {
        return fakeStoreCategoryResponseDTO.getCategories().stream()
                .map(category -> (CategoryDTO.builder().name(category)
                        .build()))
                .toList();
    }

    public static CategoryDTO toDto(Category category){
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
