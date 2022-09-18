package com.qalens.todo;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateTodoTests {
    @Test
    public void creationOfTodoShouldWork(){
        given()
                .baseUri("http://localhost:8088")
                .contentType(ContentType.JSON)
                .body("{\"title\":\"Bring Milk\"}")
        .when()
                .post("/todo")
        .then()
                .statusCode(200)
                .body("title", Matchers.equalTo("Bring Milk"))
                .body("id",Matchers.notNullValue());

    }
}
