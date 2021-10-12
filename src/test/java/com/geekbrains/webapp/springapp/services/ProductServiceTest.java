package com.geekbrains.webapp.springapp.services;

import com.geekbrains.webapp.springapp.models.Category;
import com.geekbrains.webapp.springapp.models.Product;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class ProductServiceTest {
    @MockBean
    private ProductService productService;

    @MockBean
    private CategoryService categoryService;


    @Test
    public void getTestProduct() throws Exception {
        Product product = new Product();
        product.setId(999L);
        product.setTitle("Test");
        product.setPrice(999);

        Category category = new Category();
        category.setId(3L);
        category.setTitle("TestTitle");
        product.setCategory(category);

        Mockito.doReturn(Optional.of(product)).when(productService).findById(999L);
        productService.findById(product.getId());
    }

    @Test
    public void deleteTestProduct() throws Exception {
        Product product = new Product();
        product.setId(999L);
        product.setTitle("Test");
        product.setPrice(999);

        Category category = new Category();
        category.setId(3L);
        category.setTitle("TestTitle");
        product.setCategory(category);

        Mockito.doReturn(Optional.of(product)).when(productService).findById(999L);

        for (int i = 0; i < 5; i++) {
            productService.delete(product.getId());
        }

    }


}
