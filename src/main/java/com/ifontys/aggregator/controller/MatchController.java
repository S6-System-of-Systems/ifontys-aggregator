package com.ifontys.aggregator.controller;

import com.ifontys.aggregator.logic.MatchLogic;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private MatchLogic logic;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    TopicExchange topic;

    @GetMapping("/{inumber}")
    public ResponseEntity<?> GetTeacherData(@PathVariable String inumber){
//        String data = logic.getTeacherData(inummer);
        template.convertAndSend(topic.getName(), "fhict.data", inumber);
        System.out.println("[X] Requesting data for " + inumber);
//        System.out.println(data);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("Message has been delivered successfully");
    }
}
