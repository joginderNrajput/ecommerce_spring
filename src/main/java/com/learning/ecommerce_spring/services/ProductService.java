package com.learning.ecommerce_spring.services;

import com.learning.ecommerce_spring.dto.ProductDTO;
import com.learning.ecommerce_spring.dto.ProductWithCategoryDTO;
import com.learning.ecommerce_spring.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO getProductById(Long id) throws ProductNotFoundException;

    ProductWithCategoryDTO getProductWithCategoryById(Long id) throws ProductNotFoundException;

}
