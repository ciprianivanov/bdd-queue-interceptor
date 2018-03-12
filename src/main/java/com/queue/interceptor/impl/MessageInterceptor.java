package com.queue.interceptor.impl;

import com.queue.RabbitQueueActor;
import com.queue.interceptor.Interceptor;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageInterceptor extends RabbitQueueActor implements Interceptor {

    //TODO: Address teh duplication in the implementation of the send and consume methods across classes
    @Override
    public Message consume(String fromQueue) {
        Message message = getRabbitTemplate().receive(fromQueue);
        System.out.println((String.format("Intercepted message <%s> from queue <%s>", message, fromQueue)));
        return message;
    }

    @Override
    public void send(String exchange, String routingKey, Message message) {
        getRabbitTemplate().send(exchange, routingKey, message);
        System.out.println(String.format("Message <%s> sent to exchange <%s> with routing key <%s>",
                message, exchange, routingKey));

    }

    @Override
    public void intercept(String fromQueue, String toExchange, String withRoutingKey) {
        send(toExchange, withRoutingKey, consume(fromQueue));
    }
}