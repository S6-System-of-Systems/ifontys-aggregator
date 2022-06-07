package com.ifontys.aggregator.logic;

import org.springframework.beans.factory.annotation.Autowired;

public class Transformator {
    @Autowired
    public Transformator(){}

    //Teacherdata will get transformed and renamed into the right models that the TUS api accepts
    public String TransformMessageToTUSFormat(String input){
        return input;
    }

}
