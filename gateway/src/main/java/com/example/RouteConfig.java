package com.example;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("cookie_route", r -> r.path("/fortune")
                        .uri("lb://COOKIE-SERVICE"))
                .route("activity_route", r -> r.path("/activity")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.addResponseHeader("X-TestHeader", "Test Value"))
                        .uri("http://activity-service:8010"))
                .route("decision_route", r -> r.path("/decision")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.filter(exampleFilter()))
                        .uri("http://decision-service:8000"))
                .build();
    }

    @Bean
    ExampleFilter exampleFilter(){
        return new ExampleFilter();
    }
}
