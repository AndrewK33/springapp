package com.geekbrains.webapp.springapp.controllers;

import com.geekbrains.webapp.springapp.models.Product;
import com.geekbrains.webapp.springapp.repositories.ProductRepository;
import com.geekbrains.webapp.springapp.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id).get();
    }

    @GetMapping (value = "/products/filter")
    public List<Product> findAllByPrice(@RequestParam(name = "min_price") int minPrice, @RequestParam(name = "max_price") int maxPrice) {
        return productService.findAllByPrice(minPrice, maxPrice);
    }

    @GetMapping(value = "/products/filter", params = "!max_price")
    public List<Product> findAllByMoreThanMinPrice(@RequestParam(name = "min_price") int minPrice) {
        return productService.findAllByMoreThanMinPrice(minPrice);
    }

    @GetMapping(value = "/products/filter", params = "!min_price")
    public List<Product> findAllByLessThanMaxPrice(@RequestParam(name = "max_price")int maxPrice) {
        return productService.findAllByLessThanMaxPrice(maxPrice);
    }

    @PostMapping(value = "/products")
    public Product save(@RequestBody Product product) {
        Product newProduct = new Product();
        newProduct.setTitle(product.getTitle());
        newProduct.setPrice(product.getPrice());
        productService.save(newProduct);
        return newProduct;
    }

    @GetMapping("/products/delete/{id}")
    public Optional<Product> deleteById(@PathVariable Long id) {
       productService.delete(id);
       return productService.findById(id);
    }



}
