package com.geekbrains.webapp.core.services;

import com.geekbrains.webapp.core.models.Category;
import com.geekbrains.webapp.core.models.Product;
import com.geekbrains.webapp.core.repositories.CategoryRepository;
import com.geekbrains.webapp.core.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Optional<Category> findByTitle (String title) {
        return categoryRepository.findByTitle(title);
    }

    public Optional<Category> findById (Long id) {
        return categoryRepository.findById(id);
    }

    public Optional<Category> findByIdWithProducts (Long id) {
        return categoryRepository.findById(id);
    }
}
