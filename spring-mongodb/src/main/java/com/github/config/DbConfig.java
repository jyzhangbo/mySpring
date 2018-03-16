package com.github.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * zhangbo
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.github.repository")
public class DbConfig {

    @Bean
    public MongoClientFactoryBean mongo(){
        MongoClientFactoryBean bean=new MongoClientFactoryBean();
        bean.setHost("localhost");
        return bean;
    }

    @Bean
    public MongoOperations mongoOperations(MongoClient mongoClient){
        return new MongoTemplate(mongoClient,"orderDb");
    }
}
