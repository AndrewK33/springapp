package com.geekbrains.webapp.springapp.dtos;

import com.geekbrains.webapp.springapp.models.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDetailsDto {
    private String phone;
    private String address;


}
