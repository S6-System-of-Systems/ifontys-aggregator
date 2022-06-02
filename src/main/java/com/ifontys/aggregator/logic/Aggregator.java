package com.ifontys.aggregator.logic;

import org.springframework.beans.factory.annotation.Autowired;

public class Aggregator {
    @Autowired
    public Aggregator(Object test){

    }

    //TODO: The problem here is extensibility, if more instances appear.. we do have a problem.
    public String AggregateResults(String resultsCanvas, String resultsSharepoint){
        return resultsCanvas + resultsSharepoint;
    }


}
