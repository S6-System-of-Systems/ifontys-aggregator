package com.ifontys.aggregator.messaging;
import org.springframework.amqp.rabbit.annotation.RabbitListener;


public class ReceiverController {

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void Receive(String in) throws InterruptedException {
        System.out.println(in);
    }
}
