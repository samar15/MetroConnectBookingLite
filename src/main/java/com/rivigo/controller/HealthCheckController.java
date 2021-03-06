package com.rivigo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    @RequestMapping("/hello")
    public String sayHi(){
        return "Hi";
    }
}
