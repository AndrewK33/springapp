package com.geekbrains.webapp.springapp.services;

import com.geekbrains.webapp.springapp.dtos.ProductDto;
import com.geekbrains.webapp.springapp.exceptions.ResourceNotFoundException;
import com.geekbrains.webapp.springapp.models.Category;
import com.geekbrains.webapp.springapp.models.Product;
import com.geekbrains.webapp.springapp.repositories.ProductRepository;
import com.geekbrains.webapp.springapp.soap.entities.product.ProductWs;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;



    public Page<Product> findAll(int pageIndex, int pageSize) {
        return productRepository.findAll(PageRequest.of(pageIndex, pageSize));
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findAllByPrice(@RequestParam(name = "min_price") int minPrice, int maxPrice) {
        return productRepository.findAllByPrice(minPrice, maxPrice);
    }

    public List<Product> findAllByMoreThanMinPrice(@RequestParam(name = "min_price") int minPrice) {
        return productRepository.findAllByMoreThanMinPrice(minPrice);
    }

    public List<Product> findAllByLessThanMaxPrice(@RequestParam(name = "max_price")int maxPrice) {
        return productRepository.findAllByLessThanMaxPrice(maxPrice);
    }


    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public void updateProductFromDto(ProductDto productDto) {
        Product product = findById(productDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Product id = " + productDto.getId() + " not found"));
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        if (!product.getCategory().getTitle().equals(productDto.getCategoryTitle())) {
            Category category = categoryService.findByTitle(productDto.getCategoryTitle()).orElseThrow(() -> new ResourceNotFoundException("Category title = " + productDto.getCategoryTitle() + " not found"));
            product.setCategory(category);
        }
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> findByTitle(String title) {
        return productRepository.findByTitle(title);
    }


    public static final Function<Product, ProductWs> functionEntityToSoap = product -> {
        ProductWs productWs = new ProductWs();
        productWs.setId(product.getId());
        productWs.setTitle(product.getTitle());
        productWs.setPrice(product.getPrice());
        productWs.setCategoryTitle(product.getCategory().getTitle());
        return productWs;
    };

    public List<ProductWs> getAllProductsForSoap() {
        return productRepository.findAll().stream().map(functionEntityToSoap).collect(Collectors.toList());
    }

}
