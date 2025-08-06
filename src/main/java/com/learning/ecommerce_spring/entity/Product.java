package com.learning.ecommerce_spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseEntity {
    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
//    private int id;
    private String title;
//    private String category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="column_id", nullable = false)
    private Category category;

    private String brand;
    private boolean popular;
}
