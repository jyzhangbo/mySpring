package com.github.spel.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * zhangbo
 */
@Component
public class Department {

    @Value("#{T(java.lang.Math).random()}")
    public  Integer num;


    public String getOwn(){
        return "zhangbo";
    }

}
