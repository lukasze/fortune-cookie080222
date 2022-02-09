package com.example.gateway;

import com.example.gateway.filters.ExampleFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfig {

//   Check http://localhost:8090/actuator/gateway/routes
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
/*
                lb://SERVICE-NAME : data taken form Eureka (only for this route):
                spring-cloud-starter-netflix-eureka-client dependency in pom.xml
                eureka.client.serviceUrl.defaultZone in application.yml
*/
                .route("cookie_route", r -> r.path("/fortune")
                        .uri("lb://COOKIE-SERVICE"))
                // an example of a predefined filter
                .route("activity_route", r -> r.path("/activity")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.addResponseHeader("X-TestHeader","Test Value"))
                        // the host / port as defined in hosts / app's profile
                        .uri("http://activity-service:8010"))
                .route("decision_route", r -> r.path("/decision")
                // an example of a custom filter
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.filter(exampleFilter()))
                        .uri("http://decision-service:8000"))
                .build();
    }

    @Bean
    ExampleFilter exampleFilter() {
        return new ExampleFilter();
    }

}


