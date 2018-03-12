package com.queue.interceptor;

import com.queue.receiver.Receiver;
import com.queue.sender.Sender;

public interface Interceptor extends Receiver, Sender {

    void intercept(String fromQueue, String toExchange, String withRoutingKey);
}