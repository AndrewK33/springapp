package com.geekbrains.webapp.springapp.dtos;

import com.geekbrains.webapp.springapp.models.Product;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ProductDto {
    @NotNull
    private long id;

    @NotNull(message = "Товар должен иметь название")
    @Length(min = 3, max = 255, message = "Длина названия товара должна составляет 3-255 символов")
    private String title;

    @Min(value = 1, message = "Цена товара не может быть менее 1 руб.")
    private int price;

    @NotNull(message = "Товар должен иметь категорию")
    private String categoryTitle;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.categoryTitle = product.getCategory().getTitle();
    }


}
