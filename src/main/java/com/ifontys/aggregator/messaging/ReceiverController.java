package com.ifontys.aggregator.messaging;
import com.ifontys.aggregator.logic.Aggregator;
import com.ifontys.aggregator.logic.MatchLogic;
import org.json.JSONObject;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;


public class ReceiverController {
    @Autowired
    private MatchLogic logic;

    @Autowired
    private Aggregator aggregator;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    TopicExchange topic;

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void Receive(String in) throws InterruptedException {
        System.out.println("[X] RECEIVED IN RECEIVER: " + in);
        JSONObject aggregatedData =  aggregator.AggregateResults(in);
        template.convertAndSend("tusReceiveRequest", aggregatedData);
    }
}
