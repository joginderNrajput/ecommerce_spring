package com.learning.fake_store.gateway.Impl;

import com.learning.fake_store.dto.CategoryDTO;
import com.learning.fake_store.dto.FakeStoreCategoryResponseDTO;
import com.learning.fake_store.gateway.FakeStoreCategoryGateway;
import com.learning.fake_store.gateway.retrofit.FakeStoreCategoryApi;
import com.learning.fake_store.mapper.CategoryMapper;
import jdk.jfr.Category;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
