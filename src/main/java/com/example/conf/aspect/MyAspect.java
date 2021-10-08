package com.example.conf.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
    private static final Logger logger = LoggerFactory.getLogger(MyAspect.class);

    @Around("execution(public * com.example.service.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            Class declaringType = joinPoint.getSignature().getDeclaringType();
            String methodName = joinPoint.getSignature().getName();
            logger.info("Class:" + declaringType.getSimpleName() + ",method:" + methodName);

            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        }
    }
}
