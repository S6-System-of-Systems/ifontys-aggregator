package com.ifontys.aggregator.logic;

import com.rabbitmq.client.Command;
import org.apache.tomcat.util.json.JSONParser;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Component
public class Aggregator {

    JSONObject aggregatedData= new JSONObject();
    JSONObject data = new JSONObject();
    JSONObject metadata = new JSONObject();
    JSONArray tracer = new JSONArray();
    private final static double aggregatorVersion = 1.0;

    public void AggregateResults(String result){
        data = new JSONObject(result);
        JSONObject trace = new JSONObject("{'microservice': 'ifontys.aggregator', 'date': '"+ LocalDateTime.now() + "'}");
        tracer.put(trace);

        metadata.put("tggegatorVersion", Double.toString(aggregatorVersion));
        metadata.put("tracer", tracer);


        aggregatedData.put("metadata", metadata);

        PutProperty("pcn", "canvas","id", String.class);
        PutProperty("name", "canvas", "givenName", String.class);
        PutProperty("surname", "canvas", "surName", String.class);
        PutProperty("displayName", "canvas", "displayName", String.class);
        PutProperty("email", "canvas", "mail", String.class);
        PutProperty("office", "canvas", "office", String.class);
        PutProperty("officeTelephone", "canvas", "telephoneNumber", String.class);
        PutProperty("mobileTelephone", "canvas", "mobileNumber", String.class);
        PutProperty("photo", "canvas", "photo", String.class);
        PutProperty("department", "canvas", "department", String.class);                   //Willen we echt een foto bij tus hebben?
        PutProperty("groups", "canvas", "groups", ArrayList.class);
        PutProperty("affiliations", "canvas", "affiliations", ArrayList.class);
        PutProperty("canvasUid", "canvas", "uid", String.class);
        PutProperty("employeeId", "canvas", "employeeId", String.class);


        PutProperty("facebook", "sharepoint", "facebook", String.class);
        PutProperty("linkedIn", "sharepoint", "linkedIn", String.class);
        PutProperty("twitter", "sharepoint", "twitter", String.class);
        PutProperty("schooling", "sharepoint", "schools", ArrayList.class);
        PutProperty("pastEmployers", "sharepoint", "pastEmployers", ArrayList.class);
        PutProperty("currentProjects", "sharepoint", "currentProjects", ArrayList.class);
        PutProperty("ambitions", "sharepoint", "ambitions", ArrayList.class);
        PutProperty("contributions", "sharepoint", "contributions", String.class);
        PutProperty("goals", "sharepoint", "goals", String.class);
        PutProperty("schedule", "sharepoint", "schedule", String.class);
        PutProperty("projectDescriptions", "sharepoint", "projectDescriptions", String.class);
        PutProperty("aboutMe", "sharepoint", "aboutMe", String.class);
        PutProperty("interests", "sharepoint", "interests", ArrayList.class);
        PutProperty("responsibilities", "sharepoint", "responsibilities", ArrayList.class);
        PutProperty("skills", "sharepoint", "skills", ArrayList.class);
        PutProperty("title", "sharepoint", "title", String.class);


        System.out.println("[X] Aggregatred data: " + aggregatedData);
    }

    public void PutProperty(String newName, String source, String name, Class<?> type){
        try{
            if(type == String.class){
                aggregatedData.put(newName, data.getJSONObject(source).getString(name));
            }else if(type == ArrayList.class){
                aggregatedData.put(newName, data.getJSONObject(source).getJSONArray(name));
            }
        } catch (Exception e){

        }
    }


}
