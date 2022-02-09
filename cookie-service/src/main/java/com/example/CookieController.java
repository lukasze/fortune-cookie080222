package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CookieController {

    private final ActivityClient activity;
    private final DecisionClient decision;

    @Value("${spring.application.name}")
    private String serviceName;

    public CookieController(ActivityClient activity, DecisionClient decision) {
        this.activity = activity;
        this.decision = decision;
    }

    @GetMapping("/fortune")
    public Message fortune() {
        return getMessage();
    }

    private Message getMessage() {
        return getFortune();
    }

    private Message getFortune() {
        return new Message(serviceName.toUpperCase(),
                decision.getMsg().getMessage() + " " +
                        activity.getMsg().getMessage());
    }
}
