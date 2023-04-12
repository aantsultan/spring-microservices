package com.microservices.currencyexchangeservice.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CurrencyExchangeTest {

    @Test
    void isEntityExist(){
        CurrencyExchange currencyExchange = new CurrencyExchange(10001L,"USD", "INR", new BigDecimal(65L));
        assertNotNull(currencyExchange);
    }
}
