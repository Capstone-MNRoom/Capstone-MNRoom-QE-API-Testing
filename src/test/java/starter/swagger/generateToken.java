package starter.swagger;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;

public class generateToken {

    @Before("@login")
    public void getToken(){
        String path = "src/test/resources/payload/success-login.json";
        File bodyJson = new File(String.format(path));
        Response response = RestAssured.given().header("Content-type", "application/json")
                .body(bodyJson)
                .post("/login");
        JsonPath jsonPath = response.jsonPath();
        Swagger.token = jsonPath.get("token");
    }
}
