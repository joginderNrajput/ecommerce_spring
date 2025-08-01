package com.learning.ecommerce_spring.config;

import com.learning.ecommerce_spring.gateway.retrofit.FakeStoreCategoryApi;
import com.learning.ecommerce_spring.gateway.retrofit.FakeStoreProductApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {


    @Bean
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://fakestoreapi.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public FakeStoreCategoryApi fakeStoreCategoryApi(Retrofit retrofit){
        return retrofit.create(FakeStoreCategoryApi.class);
    }

    @Bean
    public FakeStoreProductApi getProductDetailsById(Retrofit retrofit){
        return retrofit.create(FakeStoreProductApi.class);
    }
}
