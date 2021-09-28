package com.geekbrains.webapp.springapp.aop.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class StatisticServiceMap {
    private static Map<String, Long> serviceMap = new HashMap<>();

    public void setMap(String className, Long duration) {
        serviceMap.put(className, duration);
    }

}
