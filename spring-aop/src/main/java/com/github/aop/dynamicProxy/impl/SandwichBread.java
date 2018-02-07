package com.github.aop.dynamicProxy.impl;

import com.github.aop.dynamicProxy.BreadMachine;

/**
 * zhangbo
 */
public class SandwichBread implements BreadMachine {
    @Override
    public void makeBread() {
        System.out.println("制作夹心饼干");
    }
}
