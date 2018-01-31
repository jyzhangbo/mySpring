package com.github.autowired.service.impl;

import com.github.autowired.bean.CdBean;
import com.github.autowired.service.CdPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * zhangbo
 */
@Component
public class AutoCdPlayer implements CdPlayer{

    @Autowired
    private CdBean bean;

    @Override
    public void cdPlay() {
        bean.play();
    }
}
