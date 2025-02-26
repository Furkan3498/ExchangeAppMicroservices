package com.furkanceylan.microservices.currency_conversion_service.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class CurrencyConversion {

    @Id
    private Long id;
    @Column(name = "currency_from")
    private String from;
    @Column(name = "currency_to")
    private String to;
    private BigDecimal amount;
    private BigDecimal conversionMultiple;
    private BigDecimal totalCalculate;
    private String environment;


    //JPA expect default constructor
    public CurrencyConversion() {
    }

    public CurrencyConversion(Long id, String from, String to, BigDecimal amount, BigDecimal conversionMultiple, BigDecimal totalCalculate, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.conversionMultiple = conversionMultiple;
        this.totalCalculate = totalCalculate;
        this.environment = environment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public BigDecimal getTotalCalculate() {
        return totalCalculate;
    }

    public void setTotalCalculate(BigDecimal totalCalculate) {
        this.totalCalculate = totalCalculate;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
