package com.btc.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @author Ali Katkar
 */
public class PointcutConfig {
    
    @Pointcut("execution(* com.btc.spring.aopdemo.repository.*.*(..))")
    public void dataLayerPointcut() {}
        
    @Pointcut("execution(* com.btc.spring.aopdemo.service.*.*(..))")
    public void serviceLayerPointcut() {}

    
    @Pointcut("execution(* com.btc.spring.aopdemo.service.*.*(..)) || "
            + "execution(* com.btc.spring.aopdemo.repository.*.*(..)) ")
     public void allLayerPointcut() {}

 
     @Pointcut("@annotation(TimeTrack)")
     public void annotatedPointcut() {}

}
