package com.learning.fake_store.gateway.retrofit;

import com.learning.fake_store.dto.ProductResponseDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeStoreProductApi {

    @GET("products/{id}")
    Call<ProductResponseDto> getProductDetailsById(@Path("id") Long id);
}
