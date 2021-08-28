package com.geekbrains.webapp.springapp.controllers;

import com.geekbrains.webapp.springapp.dtos.CategoryDto;
import com.geekbrains.webapp.springapp.models.Category;
import com.geekbrains.webapp.springapp.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/categories/{id}")
    public CategoryDto findById(@PathVariable Long id){
        return new CategoryDto(categoryService.findByIdWithProducts(id).get());
    }

}
