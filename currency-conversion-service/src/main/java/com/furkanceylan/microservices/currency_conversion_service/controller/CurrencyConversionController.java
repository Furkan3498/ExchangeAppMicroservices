package com.furkanceylan.microservices.currency_conversion_service.controller;


import com.furkanceylan.microservices.currency_conversion_service.config.CurrencyExchangeProxy;
import com.furkanceylan.microservices.currency_conversion_service.entities.CurrencyConversion;
import com.furkanceylan.microservices.currency_conversion_service.service.CurrencyConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {



    private final CurrencyConversionService currencyConversionService;

    public CurrencyConversionController( CurrencyConversionService currencyConversionService) {

        this.currencyConversionService = currencyConversionService;
    }


    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")

    public ResponseEntity< CurrencyConversion> calculateCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){

        return ResponseEntity.ok(currencyConversionService.calculateCurrencyConversion(from,to,quantity));
}

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")

    public ResponseEntity< CurrencyConversion> calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){

        return ResponseEntity.ok(currencyConversionService.calculateCurrencyConversionFeign(from,to,quantity));
    }
}
