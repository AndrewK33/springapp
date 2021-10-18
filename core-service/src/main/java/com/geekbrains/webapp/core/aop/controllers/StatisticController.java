package com.geekbrains.webapp.core.aop.controllers;

import com.geekbrains.webapp.core.aop.services.StatisticService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
