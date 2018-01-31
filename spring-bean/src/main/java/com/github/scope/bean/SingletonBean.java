package com.github.scope.bean;

import com.github.scope.BeanInter;
import org.springframework.stereotype.Component;

/**
 * zhangbo
 */
@Component
public class SingletonBean implements BeanInter {
    public void run(){
        System.out.println(this.hashCode());
    }
}
