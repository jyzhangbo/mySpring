package com.github.httpinvoker;

import com.github.service.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

/**
 * zhangbo
 */
@Configuration
@ComponentScan("com.github.service")
public class InvokerConfig {

    @Bean
    public HttpInvokerProxyFactoryBean factoryBean(){
        HttpInvokerProxyFactoryBean bean=new HttpInvokerProxyFactoryBean();
        bean.setServiceUrl("http://localhost:8080/test.service");
        bean.setServiceInterface(MyService.class);
        return bean;
    }

}
