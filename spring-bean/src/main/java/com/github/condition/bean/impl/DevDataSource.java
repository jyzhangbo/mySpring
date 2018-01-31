package com.github.condition.bean.impl;

import com.github.condition.bean.ConditionDataSource;

/**
 * zhangbo
 */
public class DevDataSource implements ConditionDataSource{
    @Override
    public void run() {
        System.out.println("dev");
    }
}
