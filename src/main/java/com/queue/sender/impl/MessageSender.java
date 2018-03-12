package com.queue.sender.impl;

import com.queue.RabbitQueueActor;
import com.queue.sender.Sender;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageSender extends RabbitQueueActor implements Sender {

    @Override
    public void send(String exchange, String routingKey, Message message) {
        System.out.println(String.format("Sending message <%s>", message));
        getRabbitTemplate().send(exchange, routingKey, message);
        System.out.println(String.format("Message <%s> sent to exchange <%s> with routing key <%s>", message, exchange, routingKey));
    }
}