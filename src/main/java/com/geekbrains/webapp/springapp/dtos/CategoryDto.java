package com.geekbrains.webapp.springapp.dtos;

import com.geekbrains.webapp.springapp.models.Category;
import com.geekbrains.webapp.springapp.models.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String title;
    private List<ProductDto> product;

    public CategoryDto(Category category) {
        this.id = category.getId();;
        this.title = category.getTitle();;
        this.product = category.getProducts().stream().map(ProductDto::new).collect(Collectors.toList());
    }
}
