package com.ifontys.aggregator.logic;

import com.ifontys.aggregator.messaging.SenderController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class EndpointLogic{
    SenderController sender;


    @Autowired
    public EndpointLogic(){
        sender = new SenderController();
    }

    public String getTeacherData(String INummer){
        System.out.println("[X] Searching teacher data for " + INummer);
        sender.send(INummer);
        return " ";
    }

}
