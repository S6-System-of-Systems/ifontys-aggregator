package com.ifontys.aggregator;

import com.ifontys.aggregator.messaging.ReceiverController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IfontysAggregatorApplication {

    public static void main(String[] args) {

        SpringApplication.run(IfontysAggregatorApplication.class, args);
        ReceiverController receive = new ReceiverController();

    }

}
