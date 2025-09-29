package com.example.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LandingController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World"; // returns as plain text
    }

}
