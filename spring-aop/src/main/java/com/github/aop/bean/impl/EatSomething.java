package com.github.aop.bean.impl;

import com.github.aop.bean.Encoreable;
import org.springframework.stereotype.Component;

/**
 * zhangbo
 */
@Component
public class EatSomething implements Encoreable{

    public void eatSometing(String someting){
        System.out.println("吃"+someting);
    }
}
