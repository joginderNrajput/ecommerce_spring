package com.learning.ecommerce_spring.mapper;

import com.learning.ecommerce_spring.dto.ProductDTO;
import com.learning.ecommerce_spring.dto.ProductWithCategoryDTO;
import com.learning.ecommerce_spring.entity.Category;
import com.learning.ecommerce_spring.entity.Product;

public class ProductMapper {
    public static ProductDTO toDto(Product product){
        return ProductDTO.builder()
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .categoryId(product.getCategory().getId())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .build();
    }

    public static Product toEntity(ProductDTO product, Category category){
        return Product.builder()
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .category(category)
                .brand(product.getBrand())
                .popular(product.isPopular())
                .build();
    }

    public static ProductWithCategoryDTO toProductWithCategoryDTO(Product product){
        return ProductWithCategoryDTO.builder()
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .categoryId(product.getCategory().getId())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .categoryDTO(CategoryMapper.toDto(product.getCategory()))
                .build();
    }
}

