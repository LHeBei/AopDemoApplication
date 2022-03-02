package com.example.aopdemo.aopdemoapplication.aop;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author heior
 */
@Aspect
@Component
public class MyAdvice {

    private Logger logger = LoggerFactory.getLogger(MyAdvice.class);


    @Pointcut(value = "execution( * com.example.aopdemo.aopdemoapplication.controller.*.*(..))")
    public void myPoint(){

    }

    @Around("myPoint()")
    public Object myLogger(ProceedingJoinPoint pjp) throws Throwable{
        String className = pjp.getTarget().toString();
        String methodName = pjp.getSignature().getName();
        Object[] array = pjp.getArgs();
        ObjectMapper mapper = new ObjectMapper();
        logger.info("调用前：" + className + methodName + "传递的参数为：" + mapper.writeValueAsString(array));


        Object obj = pjp.proceed();
        logger.info("调用后：" + className + methodName + "返回值：" + mapper.writeValueAsString(array));

        return obj;
    }

}
