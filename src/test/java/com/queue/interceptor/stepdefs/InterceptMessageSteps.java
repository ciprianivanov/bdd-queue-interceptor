package com.queue.interceptor.stepdefs;

import com.queue.interceptor.Interceptor;
import com.queue.receiver.Receiver;
import com.queue.sender.Sender;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;

public class InterceptMessageSteps {

    @Autowired private Sender messageSender;
    @Autowired private Receiver messageReceiver;
    @Autowired private Interceptor messageInterceptor;

    private final String REAL_ROUTING_KEY = "bdd-real";
    private final String FAKE_ROUTING_KEY = "bdd-fake";

    private final String BDD_EXCHANGE = "Custom-Exchange";

    private final String REAL_BDD_QUEUE = "bdd-queue-real";
    private final String FAKE_BDD_QUEUE = "bdd-queue-fake";

    private Message message = new Message("BDD Message Test".getBytes(), new MessageProperties());

    @Given("^producer sends a message$")
    public void producerSendsAMessage() {
        messageSender.send(BDD_EXCHANGE, FAKE_ROUTING_KEY, message);
    }

    @And("^interceptor intercepts the message$")
    public void interceptorInterceptsTheMessage() {
        messageInterceptor.intercept(FAKE_BDD_QUEUE, BDD_EXCHANGE, REAL_ROUTING_KEY);
    }

    @Then("^consumer receives the message$")
    public void consumerReceivesTheMessage() {
        assert messageReceiver.consume(REAL_BDD_QUEUE) != null;
    }
}