package com.github.value;

import com.github.value.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * zhangbo
 */
@Configuration
@PropertySource("value.properties")
public class ValueEnvironmentConfig {

    @Autowired
    Environment environment;

    @Bean
    public User getUser(){
        return new User(environment.getProperty("value.name","zhangbo"),environment.getProperty("value.age",Integer.class,22));
    }
}
