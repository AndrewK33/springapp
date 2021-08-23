package com.geekbrains.webapp.springapp.controllers;

import com.geekbrains.webapp.springapp.dtos.ProductDto;
import com.geekbrains.webapp.springapp.models.Category;
import com.geekbrains.webapp.springapp.models.Product;
import com.geekbrains.webapp.springapp.repositories.ProductRepository;
import com.geekbrains.webapp.springapp.services.CategoryService;
import com.geekbrains.webapp.springapp.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;


    @GetMapping("/products")
    public Page<ProductDto> findAll(@RequestParam(defaultValue = "1", name = "p") int pageIndex) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        return productService.findAll(pageIndex - 1, 20).map(ProductDto::new);
    }

    @GetMapping("/products/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return new ProductDto(productService.findById(id).get());
    }

    @GetMapping(value = "/products/filter")
    public List<ProductDto> findAllByPrice(@RequestParam(name = "min_price") int minPrice, @RequestParam(name = "max_price") int maxPrice) {
        List<Product> productList = productService.findAllByPrice(minPrice, maxPrice);
        return ProductDto.mapperDto(productList);
    }

    @GetMapping(value = "/products/filter", params = "!max_price")
    public List<ProductDto> findAllByMoreThanMinPrice(@RequestParam(name = "min_price") int minPrice) {
        List<Product> productList = productService.findAllByMoreThanMinPrice(minPrice);
        return ProductDto.mapperDto(productList);
    }

    @GetMapping(value = "/products/filter", params = "!min_price")
    public List<ProductDto> findAllByLessThanMaxPrice(@RequestParam(name = "max_price") int maxPrice) {
        List<Product> productList = productService.findAllByLessThanMaxPrice(maxPrice);
        return ProductDto.mapperDto(productList);
    }

    @PostMapping(value = "/products")
    public ProductDto save(@RequestBody ProductDto productDto) {
        Product newProduct = new Product();
        newProduct.setTitle(productDto.getTitle());
        newProduct.setPrice(productDto.getPrice());
        Category category = categoryService.findByTitle(productDto.getCategoryTitle()).get();
        newProduct.setCategory(category);
        productService.save(newProduct);
        return new ProductDto(newProduct);
    }

    @DeleteMapping("/products/delete/{id}")
    public boolean deleteById(@PathVariable Long id) {
        productService.delete(id);
        return true;
    }


}
