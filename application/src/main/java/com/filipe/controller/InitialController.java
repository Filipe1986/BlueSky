package com.filipe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitialController {

    @GetMapping("/hello")
    public String getInitialMessage() {
        return "Hello, World!";
    }
}
