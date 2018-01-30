package com.github.base.test;

import com.github.base.di.Service;
import com.github.base.configuration.DiConfiguration;
import com.github.base.di.impl.DiService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * zhangbo
 */
public class DiTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DiConfiguration.class);
        Service diService = applicationContext.getBean(Service.class);
        diService.addService();
        applicationContext.close();

        ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("application.xml");
        Service service= (Service) xmlContext.getBean(Service.class);
        service.addService();

    }
}
