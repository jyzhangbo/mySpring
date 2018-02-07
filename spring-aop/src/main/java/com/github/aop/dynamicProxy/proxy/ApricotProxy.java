package com.github.aop.dynamicProxy.proxy;

import org.aopalliance.intercept.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * zhangbo
 */
public class ApricotProxy implements InvocationHandler{

    private Object object;

    public ApricotProxy(Object object){
        this.object=object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(object, args);
        System.out.println("添加杏仁");
        return result;
    }
}
