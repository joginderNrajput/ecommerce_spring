package com.learning.ecommerce_spring.services.impl;

import com.learning.ecommerce_spring.dto.CategoryDTO;
import com.learning.ecommerce_spring.gateway.FakeStoreCategoryGateway;
import com.learning.ecommerce_spring.services.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    public final FakeStoreCategoryGateway fakeStoreCategoryGateway;

    public CategoryServiceImpl(@Qualifier("fakeStoreCategoryImpl") FakeStoreCategoryGateway fakeStoreCategoryGateway){
        this.fakeStoreCategoryGateway = fakeStoreCategoryGateway;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return fakeStoreCategoryGateway.getAllCategories();
    }
}
