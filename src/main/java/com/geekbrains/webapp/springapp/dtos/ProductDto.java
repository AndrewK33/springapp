package com.geekbrains.webapp.springapp.dtos;

import com.geekbrains.webapp.springapp.models.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ProductDto {
    private long id;
    private String title;
    private int price;
    private String categoryTitle;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.categoryTitle = product.getCategory().getTitle();
    }


    public static List<ProductDto> mapperDto (List<Product> productList){
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product p : productList) {
            productDtoList.add(new ProductDto(p));
        }
        return productDtoList;
    }

}
