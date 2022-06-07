package com.ifontys.aggregator.messaging;

import org.springframework.amqp.core.TopicExchange;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class SenderController {

    @Autowired
    private RabbitTemplate template;


    @Autowired
    private TopicExchange topic;

//    @Value("${ifontys.endpoint.key}")
//    private String key;

    public void send(Object object) {
        template.convertAndSend("ifontys.exchange", "ifontys.endpoint", object);
        System.out.println("[X] Sent '" + object + "'");
    }

}
