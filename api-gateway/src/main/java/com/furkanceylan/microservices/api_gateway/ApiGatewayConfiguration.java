package com.furkanceylan.microservices.api_gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    public RouteLocator gatewayRouter(RouteLocatorBuilder routeLocatorBuilder){
        return null;
    }
}
