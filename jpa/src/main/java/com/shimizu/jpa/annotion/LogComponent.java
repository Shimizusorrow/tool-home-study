package com.shimizu.jpa.annotion;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author Shimizu
 * @description
 * @date 2021-02-22 08:02
 */
@Component
@Aspect
@Slf4j
public class LogComponent {
    /**
     * "@annotation(com.shimizu.jpa.annotion.LogAnnotation)" 注解类型切点表达式
     *
     * @param proceedingJoinPoint
     * @return
     */
    @Around("@annotation(com.shimizu.jpa.annotion.LogAnnotation)")
    public Object logPrint(ProceedingJoinPoint proceedingJoinPoint) {
        String functionName = proceedingJoinPoint.getSignature().getName();
        log.info(String.format("方法[%s]开始执行", functionName));
        HashMap<Object, Object> tags = new HashMap<>();
        log.info(functionName);
        tags.put("functionName", functionName);
        tags.put("flag", "done");
        long startTime = System.currentTimeMillis();
        Object o = null;
        try {
            o = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            tags.put("functionName", functionName);
            tags.put("flag", "fail");
            throwable.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        log.info(String.format("程序运行时间为: [%d] 秒", (endTime - startTime) / 1000));
        return o;
    }
}
