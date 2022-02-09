package com.example;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="activity-service", configuration = FeignConfig.class)
public interface ActivityClient {

    @GetMapping("/activity")
    Message getMsg();
}
