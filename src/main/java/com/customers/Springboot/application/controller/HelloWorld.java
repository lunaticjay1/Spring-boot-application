package com.customers.Springboot.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/Home")
    String getHome(){
        return "Hello Welcome to my page";
    }

}
