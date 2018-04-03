package com.github.service.impl;

import com.github.service.HomeService;
import org.springframework.stereotype.Service;

/**
 * zhangbo
 */
public class HomeServiceImpl implements HomeService{
    @Override
    public void home() {
        System.out.println("home");
    }
}
