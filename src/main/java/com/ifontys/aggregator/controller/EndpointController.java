package com.ifontys.aggregator.controller;

import com.ifontys.aggregator.logic.Aggregator;
import com.ifontys.aggregator.logic.EndpointLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endpoint")
public class EndpointController {
    public EndpointLogic logic;

    @Autowired
    public EndpointController(){
        logic = new EndpointLogic();
    }

    @GetMapping("GetTeacherData")
    public String GetTeacherData(@RequestParam("inummer") String inummer){
        String data = logic.getTeacherData(inummer);
        System.out.println(data);
        return " ";
    }
}
