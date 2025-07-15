package com.learning.fake_store.controllers;

import com.learning.fake_store.dto.ProductDTO;
import com.learning.fake_store.gateway.FakeStoreProductGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("api/product")
public class ProductController {

    public final FakeStoreProductGateway fakeStoreProductGateway;

    public ProductController(FakeStoreProductGateway fakeStoreProductGateway){
        this.fakeStoreProductGateway = fakeStoreProductGateway;
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<ProductDTO> getProductDetailsById(@PathVariable Long id) throws IOException {
        return new ResponseEntity<>(fakeStoreProductGateway.getProductById(id).getProduct(), HttpStatus.OK);
    }
}
