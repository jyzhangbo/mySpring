package com.github.ambiguity.impl;

import com.github.ambiguity.Dessert;
import org.springframework.stereotype.Component;

/**
 * zhangbo
 */
@Component
public class Cake implements Dessert{
    @Override
    public void run() {
        System.out.println("cake");
    }
}
