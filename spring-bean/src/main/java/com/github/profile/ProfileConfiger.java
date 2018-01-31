package com.github.profile;

import com.github.profile.bean.MyDataSource;
import com.github.profile.bean.impl.DevDataSource;
import com.github.profile.bean.impl.ProdDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * zhangbo
 */
@Configuration
public class ProfileConfiger {

    @Bean
    @Profile("dev")
    public MyDataSource getSource1(){
        return new DevDataSource();
    }

    @Bean
    @Profile("prod")
    public MyDataSource getSource2(){
        return new ProdDataSource();
    }

}
