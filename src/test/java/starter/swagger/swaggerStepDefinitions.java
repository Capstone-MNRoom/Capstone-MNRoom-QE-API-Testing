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

    @When("I send GET request rooms")
    public void ISendRequestWithSetQueryParams() {
        swagger.getAllRooms();
    }

    @When("I send POST request with body {string}")
    public void ISendPOSTRequestWithBody(String bodyName) {
        String path = "src/test/resources/payload/" + bodyName;
        File bodyJson = new File(String.format(path));
        swagger.postRoom(bodyJson);
    }

    @When("I send GET request by id room {int}")
    public void ISendGETRequestByIdRoom(int idroom) {
        swagger.getRoomByID(idroom);
    }

    @When("I send GET request by id room {string}")
    public void ISendGETRequestByIdRoomAsAlphabet(String idroom) {
        swagger.getRoomByIDasAlphabet(idroom);
    }

    @When("I send PUT request by id room {int} with body {string}")
    public void ISendPUTRequestByIdRoomWithBody(int idroom, String bodyName) {
        String path = "src/test/resources/payload/" + bodyName;
        File bodyJson = new File(String.format(path));
        swagger.updateRoomValidId(idroom, bodyJson);
    }

    @When("I send PUT request by id room {string} with body {string}")
    public void ISendPUTRequestByIdRoomAsAlphanumericWithBody(String idroom, String bodyName) {
        String path = "src/test/resources/payload/" + bodyName;
        File bodyJson = new File(String.format(path));
        swagger.updateRoomIdAlphanumeric(idroom, bodyJson);
    }

    @When("I send DELETE request by id {int}")
    public void ISendDELETERequestById(int idroom) {
        swagger.deleteRoomValidId(idroom);
    }

    @When("I send DELETE request by id {string}")
    public void ISendDELETERequestByIdAsAlphanumeric(String idroom) {
        swagger.deleteRoomIdAlphanumeric(idroom);
    }

    @When("I send PUT request by id room {int} with image {string}")
    public void iSendPUTRequestByIdRoomWithImage(int idroom, String gbr) {
        String path = "src/test/resources/payload/" + gbr;
        File bodyJson = new File(String.format(path));
        swagger.updateImage(idroom, bodyJson);
    }

    @When("I send GET request with set query params")
    public void iSendGETRequestWithSetQueryParams() {
        swagger.getAllRoomsbyQuery();
    }

    @When("I send GET request with set idcategory as alphanumeric")
    public void iSendGETRequestWithSetIdcategoryAsAlphanumeric() {
        swagger.getAllRoomsbyAlphanumQuery();
    }

    @When("I send GET request with set idcategory as negative number")
    public void iSendGETRequestWithSetIdcategoryAsNegativeNumber() {
        swagger.getAllRoomsbyNegativeNumbQuery();
    }

    @When("I send GET request with set query params that doesnt exist")
    public void iSendGETRequestWithSetQueryParamsThatDoesntExist() {
        swagger.getAllRoomsbyDoesntExist();
    }
}
