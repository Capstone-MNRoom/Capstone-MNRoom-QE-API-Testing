package starter.swagger;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.Assert;

import java.io.File;

public class swaggerStepDefinitions {

    Swagger swagger = new Swagger();

    @When("user send POST login request with body {string}")
    public void userSendPOSTLoginRequestWithBody(String bodyName) {
        //mengambil file json dari folder payload
        String path = "src/test/resources/payload/" + bodyName;
        File bodyJson = new File(String.format(path));
        swagger.postLogin(bodyJson);
    }


    @Then("response status code should be {int}")
    public void responseStatusCodeShouldBe(int statusCode) {
        Assert.assertEquals(statusCode, Swagger.response.statusCode());
    }

    @And("response body should be equal with jsonSchema {string}")
    public void responseBodyShouldBeEqualWithJsonSchema(String jsonSchema) {
        //mengambil file json dari folder schema
        String path = "schema/" + jsonSchema;
        Swagger.response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(path));
    }

    @When("user send POST signup request with body {string}")
    public void userSendPOSTSignupRequestWithBody(String bodyName) {
        //mengambil file json dari folder payload
        String path = "src/test/resources/payload/" + bodyName;
        File bodyJson = new File(String.format(path));
        swagger.postSignup(bodyJson);
    }

    @When("user send GET users request")
    public void userSendGETRequest() {
        swagger.getAllUsers();
    }
}
