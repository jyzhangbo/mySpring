package com.github.handler;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.test.annotation.SystemProfileValueSource;

/**
 * zhangbo
 */
public class AmqpHandler implements MessageListener{

    @Override
    public void onMessage(Message message) {

        String s = new String(message.getBody());
        System.out.println(s);


    }
}
