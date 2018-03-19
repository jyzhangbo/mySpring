package com.github.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * zhangbo
 */
@Configuration
public class MyConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate redisTemplate(){
        RedisTemplate template=new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory());
        return template;
    }
}
