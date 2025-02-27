package com.filipe;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.hamcrest.core.IsEqual.equalTo;


@SpringBootTest(classes = BlueSkyApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HealthIT {

    @LocalServerPort
    private int port;

    private static String baseUrl;


    @BeforeEach
    void setUp() {
        baseUrl = "http://localhost:" + port + "/myapp/actuator/health";
    }

    @Test
    void testHealth() {
        RestAssured.get(baseUrl)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON) // Ensures the response is valid JSON
                .body("status", equalTo("UP"));
    }

    @Test
    void testLiveness() {
        RestAssured.get(baseUrl + "/liveness")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON) // Ensures the response is valid JSON
                .body("status", equalTo("UP"));
    }

    @Test
    void testReadiness() {

        RestAssured.get(baseUrl + "/readiness")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON) // Ensures the response is valid JSON
                .body("status", equalTo("UP"));
    }
}
