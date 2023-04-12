package com.microservices.currencyexchangeservice.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.microservices.currencyexchangeservice.entity.CurrencyExchange;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

@DataJpaTest
public class CurrencyExchangeRepositoryTest {

    @Autowired
    private CurrencyExchangeRepository repository;

    @Test
    void findByFromAndToTest(){
        CurrencyExchange result = repository.findByFromAndTo("USD", "INR");
        CurrencyExchange expected = new CurrencyExchange(10001L, "USD", "INR", new BigDecimal("65.00"));
        assertEquals(expected.getId(), result.getId());
        assertEquals(expected.getFrom(), result.getFrom());
        assertEquals(expected.getTo(), result.getTo());
        assertEquals(expected.getConversionMultiple(), result.getConversionMultiple());
    }
}
