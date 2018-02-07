package com.github.aop.staticProxy.impl;

import com.github.aop.staticProxy.CakeMachine;

/**
 * zhangbo
 */
public class FruitCakeMachine implements CakeMachine{
    @Override
    public void makeCake() {
        System.out.println("做水果蛋糕");
    }
}
