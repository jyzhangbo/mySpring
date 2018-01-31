package com.github.javaconfig.config;

import com.github.javaconfig.bean.JavaCdBean;
import com.github.javaconfig.bean.JavaCdPlay;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * zhangbo
 */
@Configuration
public class JavaConfiguration {

    @Bean
    public JavaCdPlay getPlay(){
        return new JavaCdPlay(getBean());
    }

    @Bean
    public JavaCdBean getBean(){
        return new JavaCdBean();
    }
}
