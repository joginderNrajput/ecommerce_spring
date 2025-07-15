package com.learning.fake_store.gateway.rest_template;

import com.learning.fake_store.dto.CategoryDTO;
import com.learning.fake_store.gateway.FakeStoreCategoryGateway;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreCategoryImpl")
public class FakeStoreCategoryImpl implements FakeStoreCategoryGateway {
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return List.of();
    }
}
