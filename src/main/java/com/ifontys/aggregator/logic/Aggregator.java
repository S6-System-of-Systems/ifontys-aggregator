package com.ifontys.aggregator.logic;

import org.apache.tomcat.util.json.JSONParser;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class Aggregator {

    //TODO: The problem here is extensibility, if more instances appear.. we do have a problem.

    public void AggregateResults(String result){
        JSONObject aggregatedData = new JSONObject();
        JSONObject jsonResult = new JSONObject(result);

        aggregatedData.put("pcn", jsonResult.getJSONObject("canvas").getString("id"));
        aggregatedData.put("name", jsonResult.getJSONObject("canvas").getString("givenName"));
        aggregatedData.put("surname", jsonResult.getJSONObject("canvas").getString("surName"));
        aggregatedData.put("displayName", jsonResult.getJSONObject("canvas").getString("displayName"));
        aggregatedData.put("email", jsonResult.getJSONObject("canvas").getString("mail"));
        aggregatedData.put("office", jsonResult.getJSONObject("canvas").getString("office"));
        aggregatedData.put("officeTelephone", jsonResult.getJSONObject("canvas").getString("telephoneNumber"));
        aggregatedData.put("mobileTelephone", jsonResult.getJSONObject("canvas").getString("mobileNumber"));
        aggregatedData.put("photo", jsonResult.getJSONObject("canvas").getString("photo"));                     //Willen we echt een foto bij tus hebben?
        aggregatedData.put("department", jsonResult.getJSONObject("canvas").getString("department"));
        aggregatedData.put("groups", jsonResult.getJSONObject("canvas").getJSONArray("groups"));
        aggregatedData.put("affiliations", jsonResult.getJSONObject("canvas").getJSONArray("affiliations"));
        aggregatedData.put("canvasUid", jsonResult.getJSONObject("canvas").getString("uid"));
        aggregatedData.put("employeeId", jsonResult.getJSONObject("canvas").getString("employeeId"));

        aggregatedData.put("facebook", jsonResult.getJSONObject("sharepoint").getString("facebook"));
        aggregatedData.put("linkedIn", jsonResult.getJSONObject("sharepoint").getString("linkedIn"));
        aggregatedData.put("twitter", jsonResult.getJSONObject("sharepoint").getString("twitter"));
        aggregatedData.put("schooling", jsonResult.getJSONObject("sharepoint").getJSONArray("schools"));
        aggregatedData.put("pastEmployers", jsonResult.getJSONObject("sharepoint").getJSONArray("pastEmployers"));
        aggregatedData.put("currentProjects", jsonResult.getJSONObject("sharepoint").getJSONArray("currentProjects"));
        aggregatedData.put("ambitions", jsonResult.getJSONObject("sharepoint").getJSONArray("ambitions"));
        aggregatedData.put("contributions", jsonResult.getJSONObject("sharepoint").getString("contributions"));
        aggregatedData.put("goals", jsonResult.getJSONObject("sharepoint").getString("goals"));
        aggregatedData.put("schedule", jsonResult.getJSONObject("sharepoint").getString("schedule"));
        aggregatedData.put("projectDescriptions", jsonResult.getJSONObject("sharepoint").getString("projectDescriptions"));
        aggregatedData.put("aboutMe", jsonResult.getJSONObject("sharepoint").getString("aboutMe"));
        aggregatedData.put("Interests", jsonResult.getJSONObject("sharepoint").getJSONArray("interests"));
        aggregatedData.put("responsibilities", jsonResult.getJSONObject("sharepoint").getJSONArray("responsibilities"));
        aggregatedData.put("skills", jsonResult.getJSONObject("sharepoint").getJSONArray("skills"));
        aggregatedData.put("title", jsonResult.getJSONObject("sharepoint").getString("title"));



        System.out.println("[X] Aggregatred data: " + aggregatedData);
    }


}
