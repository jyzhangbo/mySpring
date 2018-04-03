package com.github.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * zhangbo
 */
@Service
public class TestService {

    @Autowired
    private HomeService homeService;

    public void test(){
        homeService.home();
    }

}
