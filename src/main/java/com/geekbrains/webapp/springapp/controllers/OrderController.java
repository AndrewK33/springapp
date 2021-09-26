package com.geekbrains.webapp.springapp.controllers;

import com.geekbrains.webapp.springapp.dtos.OrderDetailsDto;
import com.geekbrains.webapp.springapp.dtos.OrderDto;
import com.geekbrains.webapp.springapp.exceptions.ResourceNotFoundException;
import com.geekbrains.webapp.springapp.models.Order;
import com.geekbrains.webapp.springapp.models.User;
import com.geekbrains.webapp.springapp.services.CartService;
import com.geekbrains.webapp.springapp.services.OrderService;
import com.geekbrains.webapp.springapp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderDetailsDto orderDetailsDto, Principal principal) {
        orderService.createOrder(principal, orderDetailsDto);

    }

    @GetMapping
    public List<OrderDto> getOrdersForCurrentUser(Principal principal){
        return orderService.findAllByUsername(principal.getName()).stream().map(OrderDto::new).collect(Collectors.toList());
    }
}


