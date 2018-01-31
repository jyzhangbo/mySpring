package com.github.profile.bean.impl;

import com.github.profile.bean.MyDataSource;

/**
 * zhangbo
 */
public class ProdDataSource implements MyDataSource{
    @Override
    public void run() {
        System.out.println("prod");
    }
}
