package com.furkanceylan.microservices.currency_exchange_service.controller;


import com.furkanceylan.microservices.currency_exchange_service.entities.CurrencyExchange;
import com.furkanceylan.microservices.currency_exchange_service.service.CurrencyExchangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
        Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    private final CurrencyExchangeService currencyExchangeService;

    public CurrencyExchangeController(CurrencyExchangeService currencyExchangeService) {
        this.currencyExchangeService = currencyExchangeService;
    }


    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<CurrencyExchange> retrieveExchangeValue(@PathVariable String from, @PathVariable String to){

        logger.info("retrieveExchangeValueCalled with {} to {}",from,to);

        return ResponseEntity.ok(currencyExchangeService.retrieveExchange(from,to));
    }
}
