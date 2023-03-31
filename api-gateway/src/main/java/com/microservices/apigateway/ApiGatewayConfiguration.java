package com.microservices.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    // customize route
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(route -> route.path("/get")
                        .filters(f -> f
                                .addRequestHeader("MyHeader", "MyURI")
                                .addRequestParameter("Param", "MyValue")
                        ).uri("http://httpbin.org:80"))
                .route(route -> route.path("/currency-exchange/**")
                        .uri("lb://currency-exchange"))
                .route(route -> route.path("/currency-conversion/**")
                        .uri("lb://currency-conversion"))
                .route(route -> route.path("//currency-conversion-new/currency-conversion-new/**")
                        .uri("lb://currency-conversion"))
                .route(route -> route.path("/currency-conversion-new/**")
                        .filters(f -> f.rewritePath(
                                "/currency-conversion-new/(?<segment>.*)",
                                "/currency-conversion-feign/${segment}"
                        ))
                        .uri("lb://currency-conversion"))
                .build();
    }
}
