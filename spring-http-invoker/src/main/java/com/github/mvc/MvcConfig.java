package com.github.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;

import java.util.Properties;

/**
 * zhangbo
 */
@Configuration
@ComponentScan("com.github.controller")
public class MvcConfig extends WebMvcConfigurationSupport{


    @Bean
    @Override
    public HttpRequestHandlerAdapter httpRequestHandlerAdapter() {
        return super.httpRequestHandlerAdapter();
    }


    @Bean
    public HandlerMapping handlerMapping() {
        SimpleUrlHandlerMapping handlerMapping=new SimpleUrlHandlerMapping();
        Properties properties=new Properties();

        //httpService是HttpInvokerServiceExporter的bean名称
        properties.setProperty("/test.service","httpService");
        handlerMapping.setMappings(properties);
        return handlerMapping;
    }
}
