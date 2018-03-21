package com.github.service.impl;

import com.github.service.MyService;
import org.springframework.stereotype.Service;

/**
 * zhangbo
 */
@Service(value = "testService")
public class MyServiceImpl implements MyService{
    @Override
    public String getName(String name) {
        System.out.println(name);
        return "zhangbo";
    }
}
