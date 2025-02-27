package com.filipe;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(classes = BlueSkyApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SwaggerIT {

    @LocalServerPort
    private int port;

    private static String baseUrl;


    @BeforeEach
    void setUp() {
        baseUrl = "http://localhost:" + port + "/myapp/v3/api-docs";
    }

    @Test
    void testSwagger() {
        RestAssured.get(baseUrl)
                .then()
                .statusCode(200);
    }
}