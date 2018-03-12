package com.queue.sender;

import org.springframework.amqp.core.Message;

public interface Sender {

    void send(String exchange, String routingKey, Message message);
}