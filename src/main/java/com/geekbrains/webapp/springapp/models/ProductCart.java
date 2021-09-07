package com.geekbrains.webapp.springapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Data
@NoArgsConstructor
public class ProductCart {
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void deleteProduct(int id) {
        productList.remove(id);
    }

    public void clearCart() {
        productList.clear();
    }

    public List<Product> printCart(){
        return productList;
    }


}
