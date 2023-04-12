package com.microservices.currencyexchangeservice.controller;

import com.microservices.currencyexchangeservice.entity.CurrencyExchange;
import com.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(CurrencyExchangeController.class)
public class CurrencyExchangeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * This annotation is a shorthand for the Mockito.mock() method.
     * It's important to note that we should only use it in a test class.
     * Unlike the mock() method, we need to enable Mockito annotations to use this annotation.
     * <p>
     * The Mockito.mock() method allows us to create a mock object of a class or an interface.
     * We can then use the mock to stub return values for its methods and verify if they were called.
     * <p>
     * Credit: Baeldung
     */
    @Mock
    private Environment environment;

    /**
     * We can use the @MockBean to add mock objects to the Spring application context.
     * The mock will replace any existing bean of the same type in the application context.
     * If no bean of the same type is defined, a new one will be added.
     * This annotation is useful in integration tests where a particular bean, like an external service, needs to be mocked.
     * <p>
     * Credit: Baeldung
     */
    @MockBean
    private CurrencyExchangeRepository repository;

    @Test
    void retrieveExchangeValueTest() throws Exception {
        String from = "USD";
        String to = "INR";

        when(repository.findByFromAndTo(from, to))
                .thenReturn(new CurrencyExchange(10001L, "USD", "INR", new BigDecimal("65.00")));
        when(environment.getProperty("local.server.port")).thenReturn("8000");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/currency-exchange/currency-exchange/from/{from}/to/{to}", from, to)
                .contextPath("/currency-exchange")
        ).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status);
    }


}
