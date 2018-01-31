package com.github.condition;

import com.github.condition.bean.ConditionDataSource;
import com.github.condition.bean.MyCondition;
import com.github.condition.bean.MyCondition2;
import com.github.condition.bean.impl.DevDataSource;
import com.github.condition.bean.impl.ProdDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * zhangbo
 */
@Configuration
public class ConditionConfiguration {

    @Bean
    @Conditional(MyCondition.class)
    public ConditionDataSource getDevSource(){
        return new DevDataSource();
    }

    @Bean
    @Conditional(MyCondition2.class)
    public ConditionDataSource getProdSource(){
        return new ProdDataSource();
    }
}
