package com.example.controller;

import com.example.Message;
import com.example.controller.feign.ActivityClient;
import com.example.controller.feign.DecisionClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CookieController {

    private ActivityClient activities;
    private DecisionClient decisions;

    @Value("${spring.application.name}")
    private String serviceName;

    public CookieController(ActivityClient activities, DecisionClient decisions) {
        this.activities = activities;
        this.decisions = decisions;
    }

    @GetMapping("/fortune")
    public Message fortune() {
        return getMessage();
    }

    private Message getMessage() {
        return getFortune();
    }

    private Message getFortune() {
        return new Message(serviceName.toUpperCase(), decisions.getMessage().getMessage() + " " + activities.getMessage().getMessage());
    }
}
