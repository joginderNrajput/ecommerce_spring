package com.learning.ecommerce_spring.repository;

import com.learning.ecommerce_spring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    Optional<Product> findByCategoryId(@Param("categoryId") Long categoryId);

    @Query(value = "SELECT * from product p where price > : price", nativeQuery = true)
    Optional<Product> findProductWithPriceGreaterThan(@Param("price") Long price);
}
