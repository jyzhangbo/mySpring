package com.github.mvc;

import com.github.mvc.view.resovler.JsonViewResovler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.List;

/**
 * zhangbo
 */
@Configuration
@ComponentScan("com.github.mvc.controller")
public class MvcConfig extends WebMvcConfigurationSupport{

    @Bean
    public ViewResolver mvcViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver viewResolver=new ContentNegotiatingViewResolver();
        viewResolver.setContentNegotiationManager(manager);
        viewResolver.setOrder(2);
        List<ViewResolver> viewResolvers=new ArrayList<>();
        viewResolvers.add(htmlViewResolver());
        viewResolvers.add(jsonViewResolver());
        viewResolver.setViewResolvers(viewResolvers);


        return viewResolver;
    }

    @Override
    protected void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.TEXT_HTML);
        configurer.ignoreAcceptHeader(true);//设置为true以忽略对Accept Header的支持
        configurer.favorParameter(false);
        configurer.favorPathExtension(true);//true，开启扩展名支持
        configurer.mediaType("json",MediaType.APPLICATION_JSON);

    }

    @Bean
    public ViewResolver jsonViewResolver(){
        return new JsonViewResovler();
    }

    @Bean
    public ViewResolver htmlViewResolver() {
        InternalResourceViewResolver resolver=new InternalResourceViewResolver();
        resolver.setSuffix(".jsp");
        resolver.setPrefix("/WEB-INF/");
        resolver.setOrder(Integer.MAX_VALUE);
        return resolver;
    }

    @Bean
    public ViewResolver beanNameResolve() {
        BeanNameViewResolver beanNameViewResolver = new BeanNameViewResolver();
        beanNameViewResolver.setOrder(1);
        return beanNameViewResolver;
    }

    @Bean
    public View user(){
        return new MappingJackson2JsonView();
    }


}
