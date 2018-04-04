package com.github.root;

import com.github.service.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

/**
 * zhangbo
 */
@Configuration
@ComponentScan(basePackages = {"com.github.service"})
public class WebConfig {

    @Bean("httpService")
    public HttpInvokerServiceExporter serviceExporter(MyService service){
        HttpInvokerServiceExporter exporter=new HttpInvokerServiceExporter();
        exporter.setService(service);
        exporter.setServiceInterface(MyService.class);
        return exporter;
    }
}
