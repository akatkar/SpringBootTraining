package com.btc.spring.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ali Katkar
 */
@Aspect
@Component
public class UserAspect {
    
    Logger logger = LoggerFactory.getLogger(this.getClass());
    
//    @Before("execution(* com.btc.spring.aopdemo.repository.*.*(..))")
    @Before("PointcutConfig.dataLayerPointcut()")
    public void beforeAdvice(JoinPoint joinPoint){
        logger.info("--> BEFORE method {}", joinPoint);
    }
    
    @AfterThrowing(value = "execution(* com.btc.spring.aopdemo.repository.*.*(..))",
            throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception){
        logger.info("----> AFTER THROWING method {} throwing {} ",joinPoint, exception.getMessage());
    }
    
    @AfterReturning(value = "PointcutConfig.allLayerPointcut()",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        logger.info("----> AFTER RETURNING method {} result {} ",joinPoint, result);
    }
    
    @After(value = "PointcutConfig.serviceLayerPointcut()")
    public void after(JoinPoint joinPoint){
        logger.info("----> AFTER method {}",joinPoint);
    }

    @Around(value = "PointcutConfig.annotatedPointcut()")
    public void timeTrackAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info("----> AROUND START method {}",joinPoint);
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long mtime = System.currentTimeMillis()-start;
        logger.info("----> AROUND STOP method {} time : {}",joinPoint, mtime);
        
    }
    
}
