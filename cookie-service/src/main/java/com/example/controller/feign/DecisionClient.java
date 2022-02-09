package com.example.controller.feign;

import com.example.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "DECISION-SERVICE")
public interface DecisionClient {
    @RequestMapping(method = RequestMethod.GET, value = "/decision")
    Message getMessage();
}
