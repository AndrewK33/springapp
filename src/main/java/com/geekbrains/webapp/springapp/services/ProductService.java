package com.geekbrains.webapp.springapp.services;

import com.geekbrains.webapp.springapp.models.Product;
import com.geekbrains.webapp.springapp.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public List<Product> findAll() {
        return productRepository.findAll();
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


}
