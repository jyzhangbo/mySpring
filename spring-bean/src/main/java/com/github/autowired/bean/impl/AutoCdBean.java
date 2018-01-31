package com.github.autowired.bean.impl;

import com.github.autowired.bean.CdBean;
import org.springframework.stereotype.Component;

/**
 * zhangbo
 */
@Component
public class AutoCdBean implements CdBean{

    @Override
    public void play() {
        System.out.println("auto CD");
    }
}
