package com.learning.ecommerce_spring.gateway;

import com.learning.ecommerce_spring.dto.ProductResponseDto;

import java.io.IOException;

public interface FakeStoreProductGateway {
    ProductResponseDto getProductById(Long id) throws IOException;
}
