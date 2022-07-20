package starter.swagger;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;

public class Swagger {
    public static Response response;
    public static String token;

    public void postLogin(File body) {
        response = RestAssured.given()
                .headers("Content-type", "application/json")
                .body(body).post("/login");
        response.prettyPrint();
    }

    public void postSignup(File body) {
        response = RestAssured.given()
                .headers("Content-type", "application/json")
                .body(body).post("/signup");
        response.prettyPrint();
    }

    public void getAllUsers() {
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .get("/users");
        response.prettyPrint();

    }
}
