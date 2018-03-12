package com.queue.receiver.impl;

import com.queue.RabbitQueueActor;
import com.queue.interceptor.impl.MessageInterceptor;
import com.queue.receiver.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageReceiver extends RabbitQueueActor implements Receiver {

    private final static Logger LOGGER = LoggerFactory.getLogger(MessageInterceptor.class);

    @Override
    public Message consume(String fromQueue) {
        LOGGER.info(String.format("Receiving message from queue <%s>", fromQueue));
        Message message = getRabbitTemplate().receive(fromQueue);
        LOGGER.info(String.format("Received message from queue <%s>", message));
        return message;
    }
}