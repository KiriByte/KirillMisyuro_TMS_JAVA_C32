package org.example.hometask41.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Value("${dev.property.test}")
    private String testProperty;

    @GetMapping("/test")
    public String testEndpoint() {
        System.out.println("Property value: " + testProperty);
        return "Property value: " + testProperty;
    }
}
