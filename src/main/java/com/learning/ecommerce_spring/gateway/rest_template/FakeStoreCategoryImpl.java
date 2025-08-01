package com.learning.ecommerce_spring.gateway.rest_template;

import com.learning.ecommerce_spring.dto.CategoryDTO;
import com.learning.ecommerce_spring.dto.FakeStoreCategoryResponseDTO;
import com.learning.ecommerce_spring.gateway.FakeStoreCategoryGateway;
import com.learning.ecommerce_spring.mapper.CategoryMapper;
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
