package starter.swagger;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;

public class Swagger {
    public static Response response;

    public void postLogin(File body){
        response = RestAssured.given()
                .headers("Content-type", "application/json")
                .body(body).post("/login");
    }
}
