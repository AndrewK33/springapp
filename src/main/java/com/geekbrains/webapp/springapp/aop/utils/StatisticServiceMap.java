package com.geekbrains.webapp.springapp.aop.utils;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Component
public class StatisticServiceMap {
    private Map<String, Long> serviceMap = new HashMap<>();

    public void setMap(String className, Long duration) {
        serviceMap.put(className, duration);
    }

    public Map<String, Long> getMap() {
        return Collections.unmodifiableMap(serviceMap);
    }
}
