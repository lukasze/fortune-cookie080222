package com.example.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

public class ExampleFilter implements GatewayFilter{

    Logger LOGGER = Logger.getLogger("com.example.gateway.filters.ExampleFilter");
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        LOGGER.info(">>>>>>>>>>>>>>>>>> Custom filter here! <<<<<<<<<<<<<<<<<");
        return chain.filter(exchange);
    }

    @Override
    public String toString() {
        return "ExampleFilter";
    }
}
