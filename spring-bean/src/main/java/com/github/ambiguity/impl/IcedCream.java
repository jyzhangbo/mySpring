package com.github.ambiguity.impl;

import com.github.ambiguity.Dessert;
import com.github.ambiguity.annotation.Cream;
import com.github.ambiguity.annotation.Ice;
import org.springframework.stereotype.Component;

/**
 * zhangbo
 */
@Component
@Ice
public class IcedCream implements Dessert{
    @Override
    public void run() {
        System.out.println("iceCream");
    }
}
