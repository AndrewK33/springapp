package com.geekbrains.webapp.springapp.repositories;

import com.geekbrains.webapp.springapp.models.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o from Order o where o.user.username= :username")
    @EntityGraph(value = "orders.for-front")
    List<Order> findAllByUsername(String username);


}
