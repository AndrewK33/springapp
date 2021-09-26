package com.geekbrains.webapp.springapp.repositories;

import com.geekbrains.webapp.springapp.dtos.OrderDetailsDto;
import com.geekbrains.webapp.springapp.models.Cart;
import com.geekbrains.webapp.springapp.models.Order;
import com.geekbrains.webapp.springapp.models.OrderItem;
import com.geekbrains.webapp.springapp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByOrderId(Order Order);


}
