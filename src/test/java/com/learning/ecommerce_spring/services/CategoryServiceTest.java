package com.learning.ecommerce_spring.services;

import com.learning.ecommerce_spring.dto.CategoryDTO;
import com.learning.ecommerce_spring.entity.Category;
import com.learning.ecommerce_spring.repository.CategoryRepository;
import com.learning.ecommerce_spring.services.impl.CategoryServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    private Category category1;
    private Category category2;
    private List<Category> categoryList;

    @BeforeEach
    void setUp() {
        category1 = Category.builder().name("Electronics").build();
        category1.setId(1L);

        category2 = Category.builder().name("Books").build();
        category2.setId(2L);

        categoryList = new ArrayList<>();
        categoryList.add(category1);
        categoryList.add(category2);
    }

    @Nested
    @DisplayName("Tests for getCategoryById")
    class GetCategoryByIdTests {

        private Category category;

        @BeforeEach
        void setupCategoryForIdTests() {
            category = Category.builder().name("Toys").build();
            category.setId(1L);
        }

        @Test
        @DisplayName("Should return category by ID if found")
        void getCategoryById_shouldReturnCategoryIfExists() throws Exception {
            when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));

            CategoryDTO result = categoryService.getCategoryById(1L);

            assertNotNull(result);
            assertEquals(1L, result.getId());
            assertEquals("Toys", result.getName());
            verify(categoryRepository, times(1)).findById(1L);
        }

        @Test
        @DisplayName("Should throw IOException if category not found")
        void getCategoryById_shouldThrowExceptionIfNotFound() {
            when(categoryRepository.findById(99L)).thenReturn(Optional.empty());

            assertThrows(IOException.class, () -> categoryService.getCategoryById(99L));
            verify(categoryRepository, times(1)).findById(99L);
        }
    }

    @Test
    @DisplayName("Should return all the Categories Successfully")
    void getAllCategories_shouldReturnAllCategories() {
        when(categoryRepository.findAll()).thenReturn(categoryList);

        List<CategoryDTO> result = categoryService.getAllCategories();

        assertEquals(2, result.size());
        assertEquals("Electronics", result.get(0).getName());
        assertEquals("Books", result.get(1).getName());

        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should return empty list if no categories exist")
    void getAllCategories_shouldReturnEmptyList() {
        when(categoryRepository.findAll()).thenReturn(Collections.emptyList());

        List<CategoryDTO> result = categoryService.getAllCategories();

        assertTrue(result.isEmpty());
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should create a new Category and return it")
    void createCategory_shouldCreateAndReturnCategory() {
        CategoryDTO inputDto = CategoryDTO.builder().name("Clothing").build();
        Category savedCategory = Category.builder().name("Clothing").build();
        savedCategory.setId(1L);

        when(categoryRepository.save(any(Category.class))).thenReturn(savedCategory);

        CategoryDTO result = categoryService.createCategory(inputDto);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Clothing", result.getName());
        verify(categoryRepository, times(1)).save(any(Category.class));
    }
}
