package com.github.web.config;

import com.github.web.service.MyService;
import com.github.web.service.impl.MyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

/**
 * zhangbo
 */
@Configuration
@ComponentScan("com.github.web.service")
public class WebConfig {

    /**
     * 将spring管理的bean发布为一个rmi服务.
     * @param service
     * @return
     */
    @Bean
    public RmiServiceExporter rmiServiceExporter(MyService service){
        RmiServiceExporter exporter=new RmiServiceExporter();
        exporter.setService(service);
        exporter.setServiceName("test");
        exporter.setServiceInterface(MyService.class);
        return exporter;
    }

}
