package com.geekbrains.webapp.springapp.services;

import com.geekbrains.webapp.springapp.dtos.OrderDetailsDto;
import com.geekbrains.webapp.springapp.dtos.OrderItemDto;
import com.geekbrains.webapp.springapp.exceptions.ResourceNotFoundException;
import com.geekbrains.webapp.springapp.models.*;
import com.geekbrains.webapp.springapp.repositories.OrderRepository;
import com.geekbrains.webapp.springapp.utils.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final CartService cartService;
    private final ProductService productService;



    @Transactional
    public void createOrder (Principal principal, OrderDetailsDto orderDetailsDto) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new ResourceNotFoundException("Не удалось найти пользователя с username: " + principal.getName()));
        Cart cart = cartService.getCartForCurrentUser(principal, null);
        Order order = new Order();
        order.setUser(user);
        order.setPrice(cart.getTotalPrice());
        order.setAddress(orderDetailsDto.getAddress());
        order.setPhone(orderDetailsDto.getPhone());
        List<OrderItem> items = new ArrayList<>();
        for (OrderItemDto i : cart.getItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setPrice(i.getPrice());
            orderItem.setPricePerProduct(i.getPricePerProduct());
            orderItem.setQuantity(i.getQuantity());
            orderItem.setProduct(productService.findById(i.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Не удалось найти продукт с productId: " + i.getProductId())));
            items.add(orderItem);
        }
        order.setItems(items);
        orderRepository.save(order);
        cartService.clearCart(principal, null);
    }

    public List<Order> findAllByUsername(String username) {
        return orderRepository.findAllByUsername(username);
    }


}
