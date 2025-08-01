package com.learning.ecommerce_spring.gateway.retrofit;

import com.learning.ecommerce_spring.dto.FakeStoreCategoryResponseDTO;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.http.GET;

@Service
public interface FakeStoreCategoryApi {
    @GET("products/category")
    Call<FakeStoreCategoryResponseDTO>  getAllFakeStoreApi();
}
