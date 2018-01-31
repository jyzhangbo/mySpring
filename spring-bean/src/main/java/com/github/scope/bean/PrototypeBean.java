package com.github.scope.bean;

import com.github.scope.BeanInter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * zhangbo
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeBean implements BeanInter{
    @Override
    public void run() {
        System.out.println(this.hashCode());
    }
}
