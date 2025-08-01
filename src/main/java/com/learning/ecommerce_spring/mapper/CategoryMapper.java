package com.learning.ecommerce_spring.mapper;

import com.learning.ecommerce_spring.dto.CategoryDTO;
import com.learning.ecommerce_spring.dto.FakeStoreCategoryResponseDTO;

import java.util.List;

//using Adapter Design Pattern here
public class CategoryMapper {

    private CategoryMapper(){
        throw new UnsupportedOperationException("This is just a utility Class");
    }

    public static FakeStoreCategoryResponseDTO toFakeStoreCategoryResponseDTO(){
        return null;
    }

    public static List<CategoryDTO> toCategoryDto(FakeStoreCategoryResponseDTO dto) {
        return dto.getCategories().stream()
                .map(category -> (CategoryDTO.builder().name(category)
                        .build()))
                .toList();
    }
}
