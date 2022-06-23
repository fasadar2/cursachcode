package com.example.controller;

import com.example.service.GreetingService;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

@Controller("/greet")

public class GreetController {
    @Inject
    private GreetingService greetingService;


    @Get("/name")
    public String greet() {
        return greetingService.getGreeting() ;
    }


}
