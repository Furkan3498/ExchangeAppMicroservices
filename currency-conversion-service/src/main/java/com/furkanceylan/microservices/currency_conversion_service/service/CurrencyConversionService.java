package com.furkanceylan.microservices.currency_conversion_service.service;

import com.furkanceylan.microservices.currency_conversion_service.config.CurrencyExchangeProxy;
import com.furkanceylan.microservices.currency_conversion_service.entities.CurrencyConversion;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@Service
public class CurrencyConversionService {
    private final CurrencyExchangeProxy currencyExchangeProxy;

    public CurrencyConversionService(CurrencyExchangeProxy currencyExchangeProxy) {
        this.currencyExchangeProxy = currencyExchangeProxy;
    }


    public CurrencyConversion calculateCurrencyConversion(String from ,String to, BigDecimal quantity){
        HashMap<String,String > urlVariables = new HashMap<>();
        urlVariables.put("from",from);
        urlVariables.put("to",to);

        ResponseEntity<CurrencyConversion> responseEntity =new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class,urlVariables);

        CurrencyConversion currencyConversion = responseEntity.getBody();




        return   new CurrencyConversion(currencyConversion.getId(),from,to,quantity,
                currencyConversion.getConversionMultiple(),
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment() +" normal");

    }
    public CurrencyConversion calculateCurrencyConversionFeign(String from ,String to, BigDecimal quantity){


        CurrencyConversion currencyConversion = currencyExchangeProxy.retrieveExchangeValue(from,to).getBody();



        return   new CurrencyConversion(currencyConversion.getId(),from,to,quantity,
                currencyConversion.getConversionMultiple(),
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment() +" feign");

    }

}
