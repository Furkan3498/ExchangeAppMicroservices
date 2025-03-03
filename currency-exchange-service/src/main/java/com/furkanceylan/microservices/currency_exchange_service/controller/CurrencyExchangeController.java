package com.furkanceylan.microservices.currency_exchange_service.controller;


import com.furkanceylan.microservices.currency_exchange_service.entities.CurrencyExchange;
import com.furkanceylan.microservices.currency_exchange_service.service.CurrencyExchangeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {


    private final CurrencyExchangeService currencyExchangeService;

    public CurrencyExchangeController(CurrencyExchangeService currencyExchangeService) {
        this.currencyExchangeService = currencyExchangeService;
    }


    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<CurrencyExchange> retrieveExchangeValue(@PathVariable String from, @PathVariable String to){


        return ResponseEntity.ok(currencyExchangeService.retrieveExchange(from,to));
    }
}
