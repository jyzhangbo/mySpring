package com.github.config;

import com.github.model.User;
import com.github.service.HomeService;
import com.github.service.impl.HomeServiceImpl;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.AbstractMessageListenerContainer;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.jms.remoting.JmsInvokerProxyFactoryBean;
import org.springframework.jms.remoting.JmsInvokerServiceExporter;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * zhangbo
 */
@Configuration
@ComponentScan("com.github.service")
public class JmsConfig {

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory(){
        ActiveMQConnectionFactory connectionFactory=new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL("tcp://localhost:61616");
        return connectionFactory;
    }

    @Bean
    public JmsInvokerProxyFactoryBean jmsInvokerProxyFactoryBean(){
        JmsInvokerProxyFactoryBean factoryBean=new JmsInvokerProxyFactoryBean();
        factoryBean.setConnectionFactory(activeMQConnectionFactory());
        factoryBean.setQueue(queue());
        factoryBean.setServiceInterface(HomeService.class);
        return factoryBean;
    }

    @Bean
    public HomeService homeService(){
        HomeServiceImpl homeService=new HomeServiceImpl();
        return  homeService;
    }

    @Bean
    public JmsInvokerServiceExporter jmsInvokerServiceExporter(){
        JmsInvokerServiceExporter exporter=new JmsInvokerServiceExporter();
        exporter.setService(homeService());
        exporter.setServiceInterface(HomeService.class);
        return exporter;
    }

    /**
     * 使用JmsInvokerServiceExporter充当JMS监听器
     * @return
     */
    @Bean
    public MessageListenerContainer listenerContainer(){
        DefaultMessageListenerContainer listenerContainer=new DefaultMessageListenerContainer();
        listenerContainer.setMessageListener(jmsInvokerServiceExporter());
        listenerContainer.setConnectionFactory(activeMQConnectionFactory());
        listenerContainer.setDestination(queue());
        return listenerContainer;
    }

    @Bean
    public MessageListener messageListener(){
        MessageListener listener=new MessageListener();
        return listener;
    }

   /* @Bean Jms监听器容器，添加监听器实现异步监听消息，MessageListener为自己定义的监听器
    public MessageListenerContainer listenerContainer(){
        DefaultMessageListenerContainer listenerContainer=new DefaultMessageListenerContainer();
        listenerContainer.setMessageListener(messageListener());
        listenerContainer.setConnectionFactory(activeMQConnectionFactory());
        listenerContainer.setDestination(queue());
        return listenerContainer;
    }*/

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
        template.setDefaultDestination(queue());
        template.setMessageConverter(mappingJackson2MessageConverter());
        return template;
    }

    @Bean
    public MappingJackson2MessageConverter mappingJackson2MessageConverter(){
        MappingJackson2MessageConverter messageConverter=new MappingJackson2MessageConverter();
        Map<String,Class<?>> map=new HashMap<>();
        map.put("user", User.class);
        messageConverter.setTypeIdMappings(map);
        messageConverter.setTypeIdPropertyName("user");
        return messageConverter;
    }

}
