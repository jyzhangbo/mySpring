package com.github.web.service.impl;

import com.github.web.service.MyService;
import org.springframework.stereotype.Service;

/**
 * zhangbo
 */
@Service
public class MyServiceImpl implements MyService{
    @Override
    public String getName(String name) {
        System.out.println(name);
        return "zhangbo";
    }
}
