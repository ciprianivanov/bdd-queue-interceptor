package com.queue;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitQueueActor {

    private final RabbitTemplate rabbitTemplate;

    public RabbitQueueActor() {
        this.rabbitTemplate = new RabbitTemplate(new CachingConnectionFactory());
    }

    public RabbitTemplate getRabbitTemplate() {
        return rabbitTemplate;
    }
}