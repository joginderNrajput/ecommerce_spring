package com.learning.fake_store.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    @GetMapping
    public String getCategories(){
        return "Electronics";
    }

    @GetMapping("/count")
    public Integer getCategoriesCount(){
        return 5;
    }
}
