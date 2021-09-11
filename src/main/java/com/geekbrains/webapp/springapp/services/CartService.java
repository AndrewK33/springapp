package com.geekbrains.webapp.springapp.services;

import com.geekbrains.webapp.springapp.exceptions.ResourceNotFoundException;
import com.geekbrains.webapp.springapp.models.Cart;
import com.geekbrains.webapp.springapp.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductService productService;
    private Cart cart;


    @PostConstruct
    public  void  init() {
        this.cart = new Cart();
    }

    public Cart getCartForCurrentUser() {
        return cart;
    }


    public void addItem(Long productId) {
        if (cart.add(productId)){
            return;
        }
        Product product = productService.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Невозможно добавить продукт в корзину по данному id:" + productId));
        cart.add(product);
    }

    public void removeItem (Long productId) {
        cart.remove(productId);
    }

    public void decrementItem (Long productId) {
        cart.decrement(productId);
    }


}
