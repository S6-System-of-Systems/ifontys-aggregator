package com.ifontys.aggregator.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
@Validated
@Slf4j
public class TeacherController {

    @Value("${ifontys.institute.endpoint}")
    private String uri;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @GetMapping("/{inumber}")
    public ResponseEntity<?> get(@PathVariable String inumber, RestTemplate restTemplate) {
        try {
            return restTemplate.getForEntity(uri + "/service/" + inumber, String.class);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
