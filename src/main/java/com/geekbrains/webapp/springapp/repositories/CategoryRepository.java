package com.geekbrains.webapp.springapp.repositories;

import com.geekbrains.webapp.springapp.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByTitle (String title);

    @Query("select c from Category c join fetch c.products where c.id = :id")
    Optional<Category> findByIdWithProducts(Long id);
}
