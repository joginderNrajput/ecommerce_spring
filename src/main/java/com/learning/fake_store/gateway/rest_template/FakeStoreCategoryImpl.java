package com.learning.fake_store.gateway.rest_template;

import com.learning.fake_store.dto.CategoryDTO;
import com.learning.fake_store.dto.FakeStoreCategoryResponseDTO;
import com.learning.fake_store.gateway.FakeStoreCategoryGateway;
import com.learning.fake_store.mapper.CategoryMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreCategoryImpl")
public class FakeStoreCategoryImpl implements FakeStoreCategoryGateway {
    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreCategoryImpl(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        RestTemplate restTemplate = restTemplateBuilder.build();

        String url = "https://fakestoreapi.in/api/products/category";

        ResponseEntity<FakeStoreCategoryResponseDTO> response = restTemplate.getForEntity(url, FakeStoreCategoryResponseDTO.class);

        if (response.getBody() != null) {
            return CategoryMapper.toCategoryDto(response.getBody());
        }else{
            return List.of();
        }
    }
}
