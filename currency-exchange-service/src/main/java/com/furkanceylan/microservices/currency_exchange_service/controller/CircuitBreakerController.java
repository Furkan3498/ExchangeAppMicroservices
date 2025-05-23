package com.furkanceylan.microservices.currency_exchange_service.controller;


import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    @GetMapping("/sample-api")
    //@Retry()
    public String sampleApi(){

        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("localhost:8080/some-dummy-url",String.class);

            return responseEntity.getBody();
    }
}
