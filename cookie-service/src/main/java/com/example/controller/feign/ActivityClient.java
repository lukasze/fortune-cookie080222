package com.example.controller.feign;

import com.example.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "ACTIVITY-SERVICE")
public interface ActivityClient {
    @RequestMapping(method = RequestMethod.GET, value = "/activity")
    Message getMessage();
}
