package com.queue.receiver;

import org.springframework.amqp.core.Message;

public interface Receiver {

    Message consume(String fromQueue);
}