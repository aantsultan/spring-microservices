package com.microservices.currencyexchangeservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    // method for retry api if there is error
    @GetMapping("/sample-api")
//    @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
//    @CircuitBreaker(name = "sample-api", fallbackMethod = "hardcodedResponse")
//    @RateLimiter(name="default") // 10s => 10000 calls to the sample api
    @Bulkhead(name = "sample-api") //set max concurrent
    public String sampleApi(){
        logger.info("Sample Api call received");
//        ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
//                    String.class
//                );
//        return response.getBody();
        return "sample-api";
    }

    public String hardcodedResponse(Exception ex){
        return "fallback-response";
    }
}
