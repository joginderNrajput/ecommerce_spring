package com.learning.fake_store.gateway.retrofit;

import com.learning.fake_store.dto.FakeStoreCategoryResponseDTO;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.http.GET;

@Service
public interface FakeStoreCategoryApi {
    @GET("products/category")
    Call<FakeStoreCategoryResponseDTO>  getAllFakeStoreApi();
}
