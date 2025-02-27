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

    private static String BASE_URL;


    @BeforeEach
    void setUp() {
        BASE_URL = "http://localhost:" + port + "/myapp/actuator/health";
    }

    @Test
    void testHealth() {
        RestAssured.get(BASE_URL)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON) // Ensures the response is valid JSON
                .body("status", equalTo("UP"));
    }

    @Test
    void testLiveness() {
        RestAssured.get(BASE_URL + "/liveness")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON) // Ensures the response is valid JSON
                .body("status", equalTo("UP"));
    }

    @Test
    void testReadiness() {

        RestAssured.get(BASE_URL + "/readiness")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON) // Ensures the response is valid JSON
                .body("status", equalTo("UP"));
    }
}
