package com.geekbrains.webapp.springapp.mappers;

import com.geekbrains.webapp.springapp.dtos.OrderDetailsDto;
import com.geekbrains.webapp.springapp.models.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    //@Mapping(source = "", target = "")
    Order map(OrderDetailsDto OrderDetailsDto);


}
