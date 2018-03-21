package com.github.config;

import com.github.service.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

/**
 * zhangbo
 */
@Configuration
@ComponentScan("com.github.service")
public class ClientConfig {

    @Bean
    public RmiProxyFactoryBean factoryBean(){
        RmiProxyFactoryBean bean=new RmiProxyFactoryBean();
        bean.setServiceUrl("rmi://localhost/test");
        bean.setServiceInterface(MyService.class);
        return bean;
    }
}
