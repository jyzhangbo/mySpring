package com.github.aop.dynamicProxy;

import com.github.aop.dynamicProxy.impl.SandwichBread;
import com.github.aop.dynamicProxy.proxy.ApricotProxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理.
 * zhangbo
 */
public class Shop {

    public static void main(String[] args) {
        SandwichBread bread=new SandwichBread();
        ApricotProxy proxy=new ApricotProxy(bread);
        BreadMachine machine = (BreadMachine) Proxy.newProxyInstance(bread.getClass().getClassLoader(),bread.getClass().getInterfaces(),proxy);
        machine.makeBread();
    }
}
