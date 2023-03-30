package com.microservices.currencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyConversionServiceMain {

    public static void main (String[] args){
        SpringApplication.run(CurrencyConversionServiceMain.class, args);
    }
}
