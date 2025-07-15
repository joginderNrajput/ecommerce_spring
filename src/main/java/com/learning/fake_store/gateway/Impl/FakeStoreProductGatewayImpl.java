package com.learning.fake_store.gateway.Impl;

import com.learning.fake_store.dto.ProductResponseDto;
import com.learning.fake_store.gateway.FakeStoreProductGateway;
import com.learning.fake_store.gateway.retrofit.FakeStoreProductApi;
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
