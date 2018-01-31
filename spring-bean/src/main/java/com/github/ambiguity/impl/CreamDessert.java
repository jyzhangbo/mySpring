package com.github.ambiguity.impl;

import com.github.ambiguity.Dessert;
import com.github.ambiguity.annotation.Cream;
import org.springframework.stereotype.Component;

/**
 * zhangbo
 */
@Component
@Cream
public class CreamDessert implements Dessert{
    @Override
    public void run() {
        System.out.println("cream");
    }
}
