package com.furkanceylan.microservices.currency_conversion_service.service;

import com.furkanceylan.microservices.currency_conversion_service.entities.CurrencyConversion;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyConversionService {




    public CurrencyConversion calculateCurrencyConversion(String from ,String to, BigDecimal quantity){
        return  new CurrencyConversion(5000L,from,to,quantity, BigDecimal.ONE,BigDecimal.ONE,"");
    }
}
