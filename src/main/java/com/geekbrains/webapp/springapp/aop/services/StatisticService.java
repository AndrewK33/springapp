package com.geekbrains.webapp.springapp.aop.services;

import com.geekbrains.webapp.springapp.aop.utils.StatisticServiceMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class StatisticService {
    private StatisticServiceMap statisticServiceMap;

    public Map<String, Long> getStatisticService () {
        return (Map<String, Long>) statisticServiceMap;
    }
}
