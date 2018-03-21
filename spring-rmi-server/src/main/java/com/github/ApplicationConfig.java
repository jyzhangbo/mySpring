package com.github;

import com.github.web.config.WebConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * zhangbo
 */
public class ApplicationConfig{

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(WebConfig.class);
        try {
            Thread.sleep(1000000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
