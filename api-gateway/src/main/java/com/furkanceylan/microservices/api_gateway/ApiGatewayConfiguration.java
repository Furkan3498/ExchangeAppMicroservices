package com.furkanceylan.microservices.api_gateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {


    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder routeLocatorBuilder){

       return routeLocatorBuilder.routes()
               .route(predicateSpec -> predicateSpec.path("/get")
                       .filters(f->f.addRequestHeader("MyHeader","MyURI")
                                     .addRequestParameter("Param","MyValue"))
                    .uri("http://httpbin.org:80"))
               .route(p->p.path("/currency-exchange/**").uri("lb://currency-exchange"))
               .route(p->p.path("/currency-conversion/**").uri("lb://currency-conversion"))
               .route(p->p.path("/currency-conversion-feign/**").uri("lb://currency-conversion"))
               .route(t->t.path("/currency-conversion-new/**")
                       .filters(r->r.rewritePath("currency-conversion-new/(?<segment>.*)","currency-conversion-feign/${segment}"))
                       .uri("lb://currency-conversion"))
               .build();

    }
}
