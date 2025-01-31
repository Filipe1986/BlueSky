package com.filipe.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitialController {

    @Operation(summary = "Hello endpoint", description = "Dummy return message")
    @GetMapping("/hello")
    public String getInitialMessage() {
        return "Hello, World!";
    }
}
