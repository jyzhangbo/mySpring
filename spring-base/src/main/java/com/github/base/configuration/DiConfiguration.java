package com.github.base.configuration;

import com.github.base.di.Mapper;
import com.github.base.di.Service;
import com.github.base.di.impl.DiMapper;
import com.github.base.di.impl.DiService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * zhangbo
 */
@Configuration
public class DiConfiguration {

    @Bean
    public Service getService(){
        return new DiService(getMapper());
    }

    @Bean
    public Mapper getMapper(){
        return new DiMapper(System.out);
    }

}
