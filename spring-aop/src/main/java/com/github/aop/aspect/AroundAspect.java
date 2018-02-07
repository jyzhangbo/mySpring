package com.github.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * zhangbo
 */
@Component
@Aspect
public class AroundAspect {

    @Pointcut("execution(* com.github.aop.bean.Eat.eat(..))")
    public void pointCut1(){}

    @Around("pointCut1()")
    public void around(ProceedingJoinPoint point) {
        try {
            System.out.println("环绕通知开始");
            point.proceed();
            System.out.println("环绕通知结束");
        }catch (Throwable e){
            System.out.println("发生异常");
        }

    }
}
