package com.github.config;

import com.github.model.User;
import org.apache.activemq.command.ActiveMQBytesMessage;
import org.apache.activemq.util.ByteSequence;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

/**
 * zhangbo
 */
public class MessageListener implements javax.jms.MessageListener{

    @Override
    public void onMessage(Message message) {
        ActiveMQBytesMessage mqBytesMessage= (ActiveMQBytesMessage) message;
        ByteSequence content = mqBytesMessage.getContent();
        String s = new String(content.data);
        System.out.println(s);

    }
}
