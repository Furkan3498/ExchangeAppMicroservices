package com.furkanceylan.microservices.currency_conversion_service.config;


import com.furkanceylan.microservices.currency_conversion_service.entities.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange", url = "localhost:8000")
//@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {



    @GetMapping("/currency-exchange/from/{from}/to/{to}")
     ResponseEntity<CurrencyConversion> retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
