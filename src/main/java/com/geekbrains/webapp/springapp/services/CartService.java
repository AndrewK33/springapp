package com.geekbrains.webapp.springapp.services;

import com.geekbrains.webapp.springapp.dtos.OrderDetailsDto;
import com.geekbrains.webapp.springapp.exceptions.ResourceNotFoundException;
/*import com.geekbrains.webapp.springapp.mappers.OrderMapper;*/
import com.geekbrains.webapp.springapp.mappers.OrderMapper;
import com.geekbrains.webapp.springapp.models.Cart;
import com.geekbrains.webapp.springapp.models.Order;
import com.geekbrains.webapp.springapp.models.Product;
import com.geekbrains.webapp.springapp.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductService productService;
    private Cart cart;
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    @PostConstruct
    public  void  init() {
        this.cart = new Cart();
    }

    public void saveOrder(OrderDetailsDto orderDetailsDto) {
        Order newOrder = orderMapper.map(orderDetailsDto);
        orderRepository.save(newOrder);
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


    public void clearCart() {
        cart.clear();
    }
}
