package com.github.config;

import com.github.handler.AmqpHandler;
import com.sun.xml.internal.ws.util.Pool;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.RabbitConnectionFactoryBean;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * zhangbo
 */
@Configuration
public class AmqpConfig {

    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory cachingConnectionFactory=new CachingConnectionFactory("127.0.0.1",5672);
        return cachingConnectionFactory;
    }

    @Bean
    public AmqpHandler messageListener(){
        return new AmqpHandler();
    }

    @Bean
    public MessageListenerContainer listenerContainer(){
        SimpleMessageListenerContainer listenerContainer=new SimpleMessageListenerContainer();
        listenerContainer.setConnectionFactory(connectionFactory());
        listenerContainer.setMessageListener(messageListener());
        listenerContainer.setQueues(queue1());
        return listenerContainer;
    }

    /**
     * 需要rabbitadmin才能创建exchange和queue.
     * @return
     */
    @Bean
    public RabbitAdmin rabbitAdmin(){
        RabbitAdmin admin=new RabbitAdmin(connectionFactory());
        return admin;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate=new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory());
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Queue queue1(){
        Queue queue=new Queue("queue1", true,false,false);
        return queue;
    }
    @Bean
    public Queue queue2(){
        Queue queue=new Queue("queue2",true,false,false);
        return queue;
    }

    @Bean
    public TopicExchange exchange(){
        TopicExchange exchange=new TopicExchange("zhangbo",true,false);
        return exchange;
    }

    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(queue1()).to(exchange()).with("com.github.*");
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(queue2()).to(exchange()).with("com.github.queue2");
    }

    @Bean
    public MessageConverter messageConverter(){
        Jackson2JsonMessageConverter messageConverter=new Jackson2JsonMessageConverter();
        return messageConverter;
    }

}
