package com.learning.ecommerce_spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.ecommerce_spring.controllers.CategoryController;
import com.learning.ecommerce_spring.dto.CategoryDTO;
import com.learning.ecommerce_spring.dto.request.CreateCategoryRequest;
import com.learning.ecommerce_spring.exception.GlobalExceptionHandler;
import com.learning.ecommerce_spring.gateway.FakeStoreCategoryGateway;
import com.learning.ecommerce_spring.services.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CategoryControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CategoryService categoryService;

    @Mock
    private FakeStoreCategoryGateway fakeStoreCategoryGateway;

    @InjectMocks
    private CategoryController categoryController;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(categoryController)
                .setControllerAdvice(new GlobalExceptionHandler())  // Attach exception handler
                .build();
    }

    @Test
    @DisplayName("GET /api/categories - Should return list of categories from fake store")
    void getCategories_shouldReturnListOfCategories() throws Exception {
        // Arrange
        List<CategoryDTO> mockCategories = List.of(
                CategoryDTO.builder().id(1L).name("Electronics").build(),
                CategoryDTO.builder().id(2L).name("Books").build()
        );
        when(fakeStoreCategoryGateway.getAllCategories()).thenReturn(mockCategories);

        // Act & Assert
        mockMvc.perform(get("/api/categories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("Electronics"))
                .andExpect(jsonPath("$[1].name").value("Books"));
    }

    @Test
    @DisplayName("GET /api/categories/count - Should return fixed category count")
    void getCategoriesCount_shouldReturnFixedCount() throws Exception {
        // Arrange
        // No mocking required because this is hardcoded in controller

        // Act & Assert
        mockMvc.perform(get("/api/categories/count"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }

    @Test
    @DisplayName("POST /api/categories/createCategory - Should create a new category successfully")
    void createCategory_shouldReturnSuccessResponse() throws Exception {
        // Arrange
        CreateCategoryRequest request = new CreateCategoryRequest();
        request.setName("Clothing");

        CategoryDTO createdCategory = CategoryDTO.builder()
                .id(1L)
                .name("Clothing")
                .build();
        when(categoryService.createCategory(any())).thenReturn(createdCategory);

        // Act & Assert
        mockMvc.perform(post("/api/categories/createCategory")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value("Successfully created the Category."))
                .andExpect(jsonPath("$.category.name").value("Clothing"));
    }

    @Test
    @DisplayName("POST /api/categories/createCategory - Should return 500 and error message when service fails")
    void createCategory_shouldReturnInternalServerErrorOnException() throws Exception {
        // Arrange
        CreateCategoryRequest request = new CreateCategoryRequest();
        request.setName("Invalid");

        when(categoryService.createCategory(any()))
                .thenThrow(new RuntimeException("Something went wrong"));

        // Act & Assert
        mockMvc.perform(post("/api/categories/createCategory")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.message").value("Failed to create Category."));
    }
}
