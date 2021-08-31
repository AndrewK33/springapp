package com.geekbrains.webapp.springapp.controllers;

import com.geekbrains.webapp.springapp.dtos.ProductDto;
import com.geekbrains.webapp.springapp.exceptions.ResourceNotFoundException;
import com.geekbrains.webapp.springapp.models.Category;
import com.geekbrains.webapp.springapp.models.Product;
import com.geekbrains.webapp.springapp.models.ProductCart;
import com.geekbrains.webapp.springapp.services.CategoryService;
import com.geekbrains.webapp.springapp.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final ProductCart productCart;

    @GetMapping("/productCart")
    public List<Optional<Product>> getCart() {
        return productCart.printCart();
    }

    @PostMapping("/productCart")
    public void addProductInCart(@RequestParam Long id) {
        Optional<Product> product = productService.findById(id);
        productCart.addProduct(product);
    }

    @GetMapping("/productCart/clearCart")
    public void clearCart() {
        productCart.clearCart();
    }

    @PostMapping("/productCart/deleteProductInCart}")
    public void deleteProductInCart(@RequestParam Long id) {
        productCart.deleteProduct(id);
    }



    @GetMapping
    public Page<ProductDto> findAll(@RequestParam(defaultValue = "1", name = "p") int pageIndex) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        return productService.findAll(pageIndex - 1, 10).map(ProductDto::new);
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        Product product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product id = " + id + " not found"));
        return new ProductDto(product);
    }

    @GetMapping(value = "/filter")
    public List<ProductDto> findAllByPrice(@RequestParam(name = "min_price") int minPrice, @RequestParam(name = "max_price") int maxPrice) {
        List<Product> productList = productService.findAllByPrice(minPrice, maxPrice);
        return ProductDto.mapperDto(productList);
    }

    @GetMapping(value = "/filter", params = "!max_price")
    public List<ProductDto> findAllByMoreThanMinPrice(@RequestParam(name = "min_price") int minPrice) {
        List<Product> productList = productService.findAllByMoreThanMinPrice(minPrice);
        return ProductDto.mapperDto(productList);
    }

    @GetMapping(value = "/filter", params = "!min_price")
    public List<ProductDto> findAllByLessThanMaxPrice(@RequestParam(name = "max_price") int maxPrice) {
        List<Product> productList = productService.findAllByLessThanMaxPrice(maxPrice);
        return ProductDto.mapperDto(productList);
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto productDto) {
        Product newProduct = new Product();
        newProduct.setTitle(productDto.getTitle());
        newProduct.setPrice(productDto.getPrice());
        Category category = categoryService.findByTitle(productDto.getCategoryTitle()).orElseThrow(() -> new ResourceNotFoundException("Category title = " + productDto.getCategoryTitle() + " not found"));
        newProduct.setCategory(category);
        productService.save(newProduct);
        return new ProductDto(newProduct);
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductDto productDto) {
        productService.updateProductFromDto(productDto);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteById(@PathVariable Long id) {
        productService.delete(id);
        return true;
    }


}
