package com.geekbrains.webapp.springapp.controllers;

import com.geekbrains.webapp.springapp.dtos.CategoryDto;
import com.geekbrains.webapp.springapp.exceptions.ResourseNotFoundException;
import com.geekbrains.webapp.springapp.models.Category;
import com.geekbrains.webapp.springapp.models.Product;
import com.geekbrains.webapp.springapp.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable Long id){
        Category category = categoryService.findById(id).orElseThrow(() -> new ResourseNotFoundException("Category id = " + id + " not found"));
        return new CategoryDto(category);
    }

}
