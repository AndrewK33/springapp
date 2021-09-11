package com.geekbrains.webapp.springapp.mappers;

import com.geekbrains.webapp.springapp.dtos.ProductDto;
import com.geekbrains.webapp.springapp.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    List<ProductDto> map(List<Product> product);

    @Mapping(source = "category.title", target = "categoryTitle")
    ProductDto map(Product product);
}
