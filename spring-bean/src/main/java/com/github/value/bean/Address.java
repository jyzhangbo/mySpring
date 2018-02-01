package com.github.value.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * zhangbo
 */
@Component
public class Address {

    private String city;
    private String provice;

    public Address(@Value("${address.city}") String city,@Value("${address.provice}") String provice){
        this.city=city;
        this.provice=provice;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", provice='" + provice + '\'' +
                '}';
    }
}
