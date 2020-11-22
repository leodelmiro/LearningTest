package com.example.aulatutorialspringweb.controller;

import com.example.aulatutorialspringweb.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingService service;

    @GetMapping
    public String greeting() {
        return service.greet();
    }

}