package com.ifontys.aggregator.config;

import com.ifontys.aggregator.messaging.ReceiverController;
import com.ifontys.aggregator.messaging.SenderController;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public TopicExchange topic() {
        return new TopicExchange("ifontys.exchange");
    }
    
    private static class ReceiverConfig {

        @Bean
        Queue autoDeleteQueue1() {
            return new AnonymousQueue();
        }

        @Bean
        public Binding bindinga(TopicExchange topic, Queue autoDeleteQueue1) {
            return BindingBuilder.bind(autoDeleteQueue1)
                    .to(topic)
                    .with("ifontys.endpoint");
        }

        @Bean
        public ReceiverController receiver() {
            return new ReceiverController();
        }
    }

    @Bean
    public SenderController sender() {
        return new SenderController();
    }
}
