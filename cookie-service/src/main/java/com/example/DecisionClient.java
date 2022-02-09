package com.example;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="decision-service", configuration = FeignConfig.class)
public interface DecisionClient {

    @GetMapping("/decision")
    Message getMsg();
}
