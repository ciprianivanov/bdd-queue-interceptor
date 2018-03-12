package com.queue.receiver.impl;

import com.queue.RabbitQueueActor;
import com.queue.receiver.Receiver;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageReceiver extends RabbitQueueActor implements Receiver {

    @Override
    public Message consume(String fromQueue) {
        System.out.println(String.format("Receiving message from queue <%s>", fromQueue));
        Message message = getRabbitTemplate().receive(fromQueue);
        System.out.println(String.format("Received message from queue <%s>", message));
        return message;
    }
}