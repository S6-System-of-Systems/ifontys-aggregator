package com.ifontys.aggregator.messaging;
import com.ifontys.aggregator.logic.EndpointLogic;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;


public class ReceiverController {
    @Autowired
    private EndpointLogic logic;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    TopicExchange topic;

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void Receive(String in) throws InterruptedException {
        template.convertAndSend("tusReceiveRequest", in);
        System.out.println(in);
    }
}
