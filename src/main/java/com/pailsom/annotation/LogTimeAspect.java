package com.pailsom.annotation;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Data
@Slf4j
public class LogTimeAspect {

    @Around("@annotation(LogTime)")
    public static Object before(final ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        final Object object = joinPoint.proceed();
        final Signature signature = joinPoint.getSignature();
        log.info("Execution time required for invoking method {}.{} is {} ml ",
                signature.getDeclaringType().getName(), signature.getName(), System.currentTimeMillis() - startTime);
        return object;
    }


}
