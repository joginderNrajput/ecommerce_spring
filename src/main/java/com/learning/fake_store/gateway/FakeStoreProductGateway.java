package com.learning.fake_store.gateway;

import com.learning.fake_store.dto.ProductDTO;
import com.learning.fake_store.dto.ProductResponseDto;

import java.io.IOException;

public interface FakeStoreProductGateway {
    ProductResponseDto getProductById(Long id) throws IOException;
}
