package com.github.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * zhangbo
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.github.repository",repositoryImplementationPostfix = "Stuff")
public class MongoDbConfig extends AbstractMongoConfiguration{
    @Override
    public MongoClient mongoClient() {
        return new MongoClient();
    }

    @Override
    protected String getDatabaseName() {
        return "orderDb";
    }
}
