package com.github.aop.staticProxy;

import com.github.aop.staticProxy.impl.FruitCakeMachine;
import com.github.aop.staticProxy.proxy.ApricotCakeProxy;

/**
 * 静态代理.
 * zhangbo
 */
public class CakeShop {

    public static void main(String[] args) {
        FruitCakeMachine fruitCakeMachine = new FruitCakeMachine();
        ApricotCakeProxy proxy=new ApricotCakeProxy(fruitCakeMachine);
        proxy.makeCake();
    }
}
