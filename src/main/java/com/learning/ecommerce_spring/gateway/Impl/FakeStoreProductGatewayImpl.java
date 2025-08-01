package com.learning.ecommerce_spring.gateway.Impl;

import com.learning.ecommerce_spring.dto.ProductResponseDto;
import com.learning.ecommerce_spring.gateway.FakeStoreProductGateway;
import com.learning.ecommerce_spring.gateway.retrofit.FakeStoreProductApi;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FakeStoreProductGatewayImpl implements FakeStoreProductGateway {

    public final FakeStoreProductApi fakeStoreProductApi;

    public FakeStoreProductGatewayImpl(FakeStoreProductApi fakeStoreProductApi){
        this.fakeStoreProductApi = fakeStoreProductApi;
    }
    @Override
    public ProductResponseDto getProductById(Long id) throws IOException {
        return fakeStoreProductApi.getProductDetailsById(id).execute().body();
    }
}
