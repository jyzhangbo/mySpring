package com.github.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * zhangbo
 */
@Service
public class ClientService {

    @Resource
    private MyService service;

    public void test(){
        String zhangbo = service.getName("zhangbo");
        System.out.println(zhangbo);
    }
}
