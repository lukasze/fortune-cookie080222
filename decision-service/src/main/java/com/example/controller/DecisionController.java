package com.example.controller;


import com.example.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class DecisionController {

    @Value("${decisions}")
    private String[] decisions;

    @Value("${spring.application.name}")
    private String serviceName;

    @GetMapping("/decision")
    public Message getDecision() {
        return getMsgWithRandomDecision();
    }

    private Message getMsgWithRandomDecision() {
        var msg = decisions[new Random().nextInt(decisions.length)];
        return new Message(serviceName.toUpperCase(), msg);
    }
}
