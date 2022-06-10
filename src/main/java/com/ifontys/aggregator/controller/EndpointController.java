package com.ifontys.aggregator.controller;

import com.ifontys.aggregator.logic.Aggregator;
import com.ifontys.aggregator.logic.EndpointLogic;
import com.ifontys.aggregator.messaging.SenderController;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endpoint")
public class EndpointController {

    @Autowired
    private EndpointLogic logic;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    TopicExchange topic;

    @GetMapping("GetTeacherData")
    public ResponseEntity<?> GetTeacherData(@RequestParam("inummer") String inummer){
//        String data = logic.getTeacherData(inummer);
        template.convertAndSend(topic.getName(), "fhict.data", inummer);
        System.out.println("[X] Requesting data for " + inummer);
//        System.out.println(data);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("Message has been delivered successfully");
    }
}
