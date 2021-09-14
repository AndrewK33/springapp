package com.geekbrains.webapp.springapp.controllers;

import com.geekbrains.webapp.springapp.dtos.OrderDetailsDto;
import com.geekbrains.webapp.springapp.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final CartService cartService;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderDetailsDto orderDetailsDto) {
        cartService.saveOrder(orderDetailsDto);

    }
}
