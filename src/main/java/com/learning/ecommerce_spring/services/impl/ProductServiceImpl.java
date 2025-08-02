package com.learning.ecommerce_spring.services.impl;

import com.learning.ecommerce_spring.dto.ProductDTO;
import com.learning.ecommerce_spring.dto.ProductWithCategoryDTO;
import com.learning.ecommerce_spring.entity.Category;
import com.learning.ecommerce_spring.entity.Product;
import com.learning.ecommerce_spring.exception.CustomException;
import com.learning.ecommerce_spring.exception.ProductNotFoundException;
import com.learning.ecommerce_spring.mapper.ProductMapper;
import com.learning.ecommerce_spring.repository.CategoryRepository;
import com.learning.ecommerce_spring.repository.ProductRepository;
import com.learning.ecommerce_spring.services.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    private ProductServiceImpl(ProductRepository productRepository,
                               CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new CustomException("Category Not found"));
        Product savedProduct =  productRepository.save(ProductMapper.toEntity(productDTO, category));
        return ProductMapper.toDto(savedProduct);
    }

    @Override
    public ProductDTO getProductById(Long id) throws ProductNotFoundException {
        return productRepository.findById(id)
                .map(ProductMapper::toDto).
                orElseThrow(() -> new ProductNotFoundException("Product Not found"));
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategoryById(Long id) throws ProductNotFoundException {
        return productRepository.findById(id)
                .map(ProductMapper::toProductWithCategoryDTO)
                .orElseThrow(() -> new ProductNotFoundException("Product Now found"));
    }
}
