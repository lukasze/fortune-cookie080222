package com.example;

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
    public Message getMessage() {
        return getMessageWithRandomDecision();
    }

    private Message getMessageWithRandomDecision() {
        String msg = decisions[new Random().nextInt(decisions.length)];
        return new Message(serviceName.toUpperCase(), msg);
    }
}
