package com.furkanceylan.microservices.currency_exchange_service.service;

import com.furkanceylan.microservices.currency_exchange_service.entities.CurrencyExchange;
import com.furkanceylan.microservices.currency_exchange_service.repository.CurrencyExchangeRepository;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyExchangeService {

        private final CurrencyExchangeRepository currencyExchangeRepository;
        private final   Environment environment;

    public CurrencyExchangeService(CurrencyExchangeRepository currencyExchangeRepository, Environment environment) {
        this.currencyExchangeRepository = currencyExchangeRepository;
        this.environment = environment;
    }


    public  CurrencyExchange retrieveExchange(String from, String to) {
     //   CurrencyExchange currencyExchange = new CurrencyExchange(1000L,from,to, BigDecimal.valueOf(50));

        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from,to);

        if (currencyExchange ==null){
            throw  new RuntimeException("Unable to find data for " + from + "to" + to);
        }
        String port =  environment.getProperty("local.server.port");

        currencyExchange.setEnvironment(port);

        return  currencyExchange;
    }
}
