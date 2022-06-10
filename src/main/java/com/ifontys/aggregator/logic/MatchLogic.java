package com.ifontys.aggregator.logic;

import com.ifontys.aggregator.messaging.SenderController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchLogic {

    @Autowired
    private SenderController sender;

    public String getTeacherData(String INummer){
        System.out.println("[X] Searching teacher data for " + INummer);
//        sender.send(INummer);
        return " ";
    }

}
