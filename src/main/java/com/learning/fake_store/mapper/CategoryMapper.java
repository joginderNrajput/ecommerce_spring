package com.learning.fake_store.mapper;

import com.learning.fake_store.dto.CategoryDTO;
import com.learning.fake_store.dto.FakeStoreCategoryResponseDTO;

import java.util.List;

//using Adapter Design Pattern here
public class CategoryMapper {
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
