package com.example.activityservice.controller;

import com.example.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class DecisionController {

    @Value("${decisions}")
    private String [] activities;
    @Value("${spring.application.name}")
    private String serviceName;

    @GetMapping("decision")
    public Message decision (){
        return getMessageRandomActivity();
    }

    private Message getMessageRandomActivity() {
        String msg =  activities[new Random().nextInt(activities.length)];
        return new Message(serviceName.toUpperCase(), msg);
    }

}
