package com.github.spel.bean;

import org.springframework.stereotype.Component;

/**
 * zhangbo
 */
public class Singer {

    public String name;
    public Integer age;

    public Singer(String name,Integer age){
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
