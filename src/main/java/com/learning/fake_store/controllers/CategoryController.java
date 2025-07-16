package com.learning.fake_store.controllers;

import com.learning.fake_store.dto.CategoryDTO;
import com.learning.fake_store.dto.CategoryRequestDTO;
import com.learning.fake_store.gateway.FakeStoreCategoryGateway;
import com.learning.fake_store.services.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    public final FakeStoreCategoryGateway fakeStoreCategoryGateway;
    public final CategoryService categoryService;

    public CategoryController(@Qualifier("fakeStoreCategoryGatewayImpl")FakeStoreCategoryGateway fakeStoreCategoryGateway,
                            CategoryService categoryService){
        this.fakeStoreCategoryGateway = fakeStoreCategoryGateway;
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getCategories() throws IOException {
        return new ResponseEntity<>(fakeStoreCategoryGateway.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/count")
    public Integer getCategoriesCount(){
        return 5;
    }

    @PostMapping("/createCategory")
    public ResponseEntity<String> createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO){
        throw new UnsupportedOperationException("method not supported");
    }
}
