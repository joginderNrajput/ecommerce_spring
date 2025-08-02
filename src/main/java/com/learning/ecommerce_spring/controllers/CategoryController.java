package com.learning.ecommerce_spring.controllers;

import com.learning.ecommerce_spring.dto.CategoryDTO;
import com.learning.ecommerce_spring.dto.CategoryRequestDTO;
import com.learning.ecommerce_spring.dto.request.CreateCategoryRequest;
import com.learning.ecommerce_spring.dto.response.CreateCategoryResponse;
import com.learning.ecommerce_spring.gateway.FakeStoreCategoryGateway;
import com.learning.ecommerce_spring.repository.CategoryRepository;
import com.learning.ecommerce_spring.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/categories")
public class CategoryController {

    public final FakeStoreCategoryGateway fakeStoreCategoryGateway;
    public final CategoryService categoryService;

    public CategoryController(@Qualifier("fakeStoreCategoryGatewayImpl") FakeStoreCategoryGateway fakeStoreCategoryGateway,
                              CategoryService categoryService) {

        this.fakeStoreCategoryGateway = fakeStoreCategoryGateway;
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getCategories() throws IOException {
        return new ResponseEntity<>(fakeStoreCategoryGateway.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/count")
    public Integer getCategoriesCount() {
        return 5;
    }

    @PostMapping("/createCategory")
    public ResponseEntity<CreateCategoryResponse> createCategory(@RequestBody CreateCategoryRequest request) {
        CreateCategoryResponse response = new CreateCategoryResponse();
        try {
            CategoryDTO categoryDTO = categoryService.createCategory(CategoryDTO.builder().name(request.getName()).build());
            response.setCategory(categoryDTO);
            response.setMessage("Successfully created the Category.");
            log.info("Successfully created the Category");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (Exception exception){
            response.setMessage("Failed to create Category.");
            log.error("Failed to retrieve the Category : {}", exception.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
