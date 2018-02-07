package com.github.aop.bean.impl;

import com.github.aop.bean.Eat;
import org.springframework.stereotype.Component;

/**
 * zhangbo
 */
@Component
public class LunchEat implements Eat{

    @Override
    public void eat() {
        System.out.println("吃午饭");
    }
}
