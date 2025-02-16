package com.filipe;


import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(classes = BlueSkyApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InitialControllerIT {

    @LocalServerPort
    private int port;

    private static String BASE_URL;


    @BeforeEach
    public void setUp() {
        BASE_URL = "http://localhost:" + port + "/myapp/hello";
    }

    @Test
    public void testHello() {
        RestAssured.get(BASE_URL)
                .then()
                .statusCode(200);
    }
}
