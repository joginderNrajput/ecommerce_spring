package com.learning.ecommerce_spring.gateway.Impl;

import com.learning.ecommerce_spring.dto.CategoryDTO;
import com.learning.ecommerce_spring.dto.FakeStoreCategoryResponseDTO;
import com.learning.ecommerce_spring.gateway.FakeStoreCategoryGateway;
import com.learning.ecommerce_spring.gateway.retrofit.FakeStoreCategoryApi;
import com.learning.ecommerce_spring.mapper.CategoryMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreCategoryGatewayImpl")
public class FakeStoreCategoryGatewayImpl implements FakeStoreCategoryGateway {

    public final FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStoreCategoryGatewayImpl(FakeStoreCategoryApi fakeStoreCategoryApi){
        this.fakeStoreCategoryApi = fakeStoreCategoryApi;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        FakeStoreCategoryResponseDTO response = fakeStoreCategoryApi.getAllFakeStoreApi().execute().body();

        if (response == null) {
            throw new IOException("No Category found!");
        }
        return CategoryMapper.toCategoryDto(response);
    }
}
