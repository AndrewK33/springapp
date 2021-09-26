package com.geekbrains.webapp.springapp.repositories;

import com.geekbrains.webapp.springapp.models.Category;
import com.geekbrains.webapp.springapp.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByTitle(String title);

    @Query("select p from Product p where p.price >= :minPrice and p.price <= :maxPrice")
    List<Product> findAllByPrice(int minPrice, int maxPrice);

    @Query("select p from Product p where p.price >= :minPrice")
    List<Product> findAllByMoreThanMinPrice(int minPrice);

    @Query("select p from Product p where p.price <= :maxPrice")
    List<Product> findAllByLessThanMaxPrice(int maxPrice);

    @Query()
    void deleteById(Long id);

    List<Product> findAllByCategory(Category category);
}
