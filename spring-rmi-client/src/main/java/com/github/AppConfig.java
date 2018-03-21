package com.github;

import com.github.config.ClientConfig;
import com.github.httpinvoker.InvokerConfig;
import com.github.service.ClientService;
import com.github.service.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.ws.spi.Invoker;

/**
 * zhangbo
 */
public class AppConfig {

    public static void main(String[] args) {
        //AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ClientConfig.class);
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(InvokerConfig.class);
        ClientService myService = (ClientService) context.getBean("clientService");
       myService.test();
    }
}
