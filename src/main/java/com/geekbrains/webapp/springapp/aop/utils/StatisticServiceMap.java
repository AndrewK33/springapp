package com.geekbrains.webapp.springapp.aop.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class StatisticServiceMap {
    private Map<String, Long> serviceMap = new HashMap<>();

    public void setMap(String className, Long duration) {
        serviceMap.put(className, duration);
    }

}
