package com.github.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

/**
 * zhangbo
 */
@Configuration
public class JmsConfig {

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory(){
        ActiveMQConnectionFactory connectionFactory=new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL("http://localhost:61616");
        return connectionFactory;
    }

    @Bean
    public ActiveMQQueue queue(){
        ActiveMQQueue queue=new ActiveMQQueue();
        queue.setPhysicalName("spring.test");
        return queue;
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate template=new JmsTemplate();
        template.setConnectionFactory(activeMQConnectionFactory());
        return template;
    }
}
