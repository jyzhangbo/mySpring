package com.github.aop.aspect;

import com.github.aop.bean.Encoreable;
import com.github.aop.bean.impl.EatSomething;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * zhangbo
 */
@Aspect
@Component
public class EncoreableAspect {

    @DeclareParents(value = "com.github.aop.bean.impl.LunchEat",defaultImpl = EatSomething.class)
    public static Encoreable encoreable;
}
