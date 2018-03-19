package com.github.config;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * zhangbo
 */
@Configuration
@EnableCaching
@ComponentScan("com.github")
public class CacheConfig {

    /**
     * 缓存管理器.
     * @return
     */
    @Bean
    public CacheManager cacheManager(){
        return new ConcurrentMapCacheManager();
    }
}
