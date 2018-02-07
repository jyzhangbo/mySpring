package com.github.aop.staticProxy.proxy;

import com.github.aop.staticProxy.CakeMachine;

/**
 * zhangbo
 */
public class ApricotCakeProxy implements CakeMachine {

    private CakeMachine cakeMachine;

    public ApricotCakeProxy(CakeMachine cakeMachine){
        this.cakeMachine=cakeMachine;
    }

    @Override
    public void makeCake() {
        cakeMachine.makeCake();
        System.out.println("添加杏仁");
    }
}
