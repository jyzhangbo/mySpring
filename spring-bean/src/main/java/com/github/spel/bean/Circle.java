package com.github.spel.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * zhangbo
 */
@Component
public class Circle {

    @Value("#{3}")
    public Double redius;

    @Value("#{2 * T(java.lang.Math).PI * circle.redius}")
    public Double zhouchang;

    @Value("#{T(java.lang.Math).PI * circle.redius ^ 2}")
    public Double mianji;
}
