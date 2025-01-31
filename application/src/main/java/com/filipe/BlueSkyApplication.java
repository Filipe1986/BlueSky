package com.filipe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class BlueSkyApplication {
    public static void main(String[] args) {
        log.info("Starting application");
        SpringApplication.run(BlueSkyApplication.class, args);
    }
}