package com.github.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * zhangbo
 */
@Aspect
@Component
public class EatAspect {

    @Pointcut("execution(* com.github.aop.bean.Eat.eat(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void washHand(){
        System.out.println("洗手");
    }

    @After("pointCut()")
    public void brushTheBowl(){
        System.out.println("刷碗");
    }

}
