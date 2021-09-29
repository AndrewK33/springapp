package com.geekbrains.webapp.springapp.aop.utils;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Autowired
    private StatisticServiceMap statisticMap;


    /*@Around("execution(public * com.geekbrains.webapp.springapp.services.*.*(..))")*/
   /* @Around("@annotation(com.geekbrains.webapp.springapp.services.Test)")*/
    @Around("execution(* com.geekbrains.webapp.springapp.services.*.*(..))")
    public Object profiling(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Signature signature = proceedingJoinPoint.getSignature();
        String className = signature.getDeclaringTypeName();

        long start = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long delta = end - start;

        statisticMap.setMap(className, delta);

        return proceed;
    }
}
