package com.geekbrains.webapp.springapp.aop.controllers;

import com.geekbrains.webapp.springapp.aop.services.StatisticService;
import com.geekbrains.webapp.springapp.dtos.StringResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/service_info")
@RequiredArgsConstructor
public class StatisticController {
    private final StatisticService statisticService;

    @GetMapping
    public Map<String, Long> generateCartUuid() {
        return statisticService.getStatisticService();
    }



}
