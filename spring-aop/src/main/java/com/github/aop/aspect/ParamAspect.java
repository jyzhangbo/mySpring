package com.github.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * zhangbo
 */
@Component
@Aspect
public class ParamAspect {

    private HashMap<String ,Integer> count=new HashMap<>();

    @Pointcut("execution(* com.github.aop.bean.impl.EatSomething.eatSometing(String)) && args(someting)")
    public void pointCut(String someting){}

    @Before("pointCut(someting)")
    public void count(String someting){
        int currentCount=getCount(someting);
        count.put(someting,currentCount+1);
    }

    public Integer getCount(String someting){
        if(count.containsKey(someting)){
            return count.get(someting);
        }
        return 0;
    }
}
