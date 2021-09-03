package com.kaibacorp.userapi.Api.controller;

import com.kaibacorp.userapi.Domain.exception.RequisitionException;
import com.kaibacorp.userapi.Domain.exception.ServiceException;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("user-service")
public class FooBarController {

    private Logger logger = LoggerFactory.getLogger(FooBarController.class);

    @GetMapping("/foo-bar")
    @Retry(name = "foo-bar", fallbackMethod = "getError")
    //@CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
    //@RateLimiter(name = "default")
    //@Bulkhead(name = "default")
    public String fooBar() {
        logger.info("Request to foo-bar is received");
        var response = new RestTemplate()
        .getForEntity("http://localhost:8080/foo-bar", String.class);
        return response.getBody();
    }

    public String getError(Exception ex) {
        return "Error in foo-bar requisition";
    }
}
