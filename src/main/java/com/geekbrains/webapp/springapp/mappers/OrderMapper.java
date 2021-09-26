package com.geekbrains.webapp.springapp.mappers;

import com.geekbrains.webapp.springapp.dtos.OrderDetailsDto;
import com.geekbrains.webapp.springapp.dtos.OrderItemDto;
import com.geekbrains.webapp.springapp.dtos.ProductDto;
import com.geekbrains.webapp.springapp.models.Cart;
import com.geekbrains.webapp.springapp.models.Order;
import com.geekbrains.webapp.springapp.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface OrderMapper {
    //@Mapping(source = "", target = "")
    Order map(OrderDetailsDto OrderDetailsDto);


}
