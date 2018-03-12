package com.queue.sender.impl;

import com.queue.RabbitQueueActor;
import com.queue.interceptor.impl.MessageInterceptor;
import com.queue.sender.Sender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageSender extends RabbitQueueActor implements Sender {

    private final static Logger LOGGER = LoggerFactory.getLogger(MessageInterceptor.class);

    @Override
    public void send(String exchange, String routingKey, Message message) {
        LOGGER.info(String.format("Sending message <%s>", message));
        getRabbitTemplate().send(exchange, routingKey, message);
        LOGGER.info(String.format("Message <%s> sent to exchange <%s> with routing key <%s>",
                message, exchange, routingKey));
    }
}