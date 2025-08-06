package com.learning.ecommerce_spring.controllers;

import com.learning.ecommerce_spring.dto.ProductDTO;
import com.learning.ecommerce_spring.dto.ProductWithCategoryDTO;
import com.learning.ecommerce_spring.gateway.FakeStoreProductGateway;
import com.learning.ecommerce_spring.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("api/product")
public class ProductController {

    public final FakeStoreProductGateway fakeStoreProductGateway;
    public final ProductService productService;

    public ProductController(FakeStoreProductGateway fakeStoreProductGateway,
                             ProductService productService){
        this.fakeStoreProductGateway = fakeStoreProductGateway;
        this.productService = productService;
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<ProductDTO> getProductDetailsById(@PathVariable Long id) throws IOException {
        return new ResponseEntity<>(fakeStoreProductGateway.getProductById(id).getProduct(), HttpStatus.OK);
    }

    @PostMapping("/createProduct")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
         return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.OK);
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping("/getProductById/{id}/detail")
    public ResponseEntity<ProductWithCategoryDTO> getProductWithCategory(@PathVariable Long id){
        return new ResponseEntity<>(productService.getProductWithCategoryById(id), HttpStatus.OK);
    }
}
