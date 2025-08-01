package com.learning.ecommerce_spring.gateway.retrofit;

import com.learning.ecommerce_spring.dto.ProductResponseDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeStoreProductApi {

    @GET("products/{id}")
    Call<ProductResponseDto> getProductDetailsById(@Path("id") Long id);
}
