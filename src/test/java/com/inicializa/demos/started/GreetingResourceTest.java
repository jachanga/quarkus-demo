package com.inicializa.demos.started;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/api/hola")
                .then()
                .statusCode(200)
                .body(is("hola"));
    }

    @Test
    public void testGreetingEndpoint() {
        String uuid = UUID.randomUUID().toString();
        given()
                .pathParam("name", uuid)
                .when().get("/api/hola/{name}")
                .then()
                .statusCode(200)
                .body(is("hola " + uuid));
    }

}
