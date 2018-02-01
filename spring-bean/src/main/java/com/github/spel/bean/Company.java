package com.github.spel.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * zhangbo
 */
@Component
public class Company {

    @Value("${company.name}")
    public String name;

    @Value("#{systemProperties['company.address']}")
    public String address;

    @Value("#{T(System).currentTimeMillis()}")
    public Long time;

    @Value("#{department.num+1}")
    public Integer num;

    @Value("#{department.getOwn()?.toUpperCase()}")
    public String own;

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", time=" + time +
                ", num=" + num +
                ", own='" + own + '\'' +
                '}';
    }
}
