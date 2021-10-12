package com.geekbrains.webapp.springapp.services;

import com.geekbrains.webapp.springapp.models.Category;
import com.geekbrains.webapp.springapp.models.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.security.Principal;
import java.util.Optional;

@SpringBootTest
public class CartServiceTest {
    @Autowired
    private CartService cartService;

    @MockBean
    private ProductService productService;

    @MockBean
    private Principal principal;

    @BeforeEach
    public void initCart() {
        cartService.clearCart(principal, "test_cart");
    }

    @Test
    public  void addToTestCart() {
        Product product = new Product();
        product.setId(999L);
        product.setTitle("Test");
        product.setPrice(999);

        Category category = new Category();
        category.setId(3L);
        category.setTitle("TestTitle");
        product.setCategory(category);


        Mockito.doReturn(Optional.of(product)).when(productService).findById(999L);
        cartService.addItem(principal, "test_cart", product.getId());
        cartService.addItem(principal, "test_cart", product.getId());
        cartService.addItem(principal, "test_cart", product.getId());
    }

    @Test
    public void testDecrementProductIntoCart() {
        Product product = new Product();
        product.setId(999L);
        product.setTitle("Test");
        product.setPrice(999);

        Category category = new Category();
        category.setId(3L);
        category.setTitle("TestTitle");
        product.setCategory(category);

        Mockito.doReturn(Optional.of(product)).when(productService).findById(999L);

        for (int i = 0; i < 50; i++) {
            cartService.addItem(principal, "test_cart", product.getId());
        }


        for (int i = 0; i < 100; i++) {
            cartService.decrementItem(principal, "test_cart", product.getId());
        }

    }

}
