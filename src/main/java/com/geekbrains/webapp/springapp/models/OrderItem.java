package com.geekbrains.webapp.springapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders_items")
@Data
@NoArgsConstructor
public class OrderItem {
    @Id
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_title")
    private String productTitle;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;

    @Column(name = "price_per_product")
    private int pricePerProduct;
}
