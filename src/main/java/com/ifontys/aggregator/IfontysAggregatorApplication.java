package com.ifontys.aggregator;

import com.ifontys.aggregator.messaging.ReceiverController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IfontysAggregatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(IfontysAggregatorApplication.class, args);
    }

}
