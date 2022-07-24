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

    @When("I send GET request room facility with id room {int}")
    public void iSendGETRequestRoomFacilityWithIdRoom(int idroom) {
        swagger.getRoomFacility(idroom);
    }

    @When("I send GET request room facility with id room {string}")
    public void iSendGETRequestRoomFacilityWithIdRoom(String idroom) {
        swagger.getRoomFacilityIdAlphanum(idroom);
    }

    @When("I send GET request all facility")
    public void iSendGETRequestAllFacility() {
        swagger.getAllFacility();
    }

    @When("I send GET request id facility by set params")
    public void iSendGETRequestIdFacilityBySetParams() {
        swagger.getFacilityValidId();
    }

    @When("I send GET request id facility as negative num")
    public void iSendGETRequestIdFacilityAsNegativeNum() {
        swagger.getFacilityIdNegative();
    }

    @When("I send GET request id facility as alphanumeric")
    public void iSendGETRequestIdFacilityAsAlphanumeric() {
        swagger.getFacilityIdAlphanum();
    }

    @When("I send GET request id facility doesn't exist")
    public void iSendGETRequestIdFacilityDoesnTExist() {
        swagger.getFacilityIdDoesntExist();
    }

    @When("I send GET request id facility as special char")
    public void iSendGETRequestIdFacilityAsSpecialChar() {
        swagger.getFacilityIdSpecChar();
    }

    @When("user send GET request users")
    public void userSendGETRequestUsers() {
        swagger.getAllUsers();
    }

    @When("user send GET request user profile")
    public void userSendGETRequestUserProfile() {
        swagger.getUserProfile();
    }


    @When("user send PUT update request with {string} is {string}, {string} is {string}, {string} is {string}")
    public void userSendPUTUpdateRequestWithIsIsIs(String keyUsername, String valueUsername, String keyPassword, String valuePassword, String keyAddress, String valueAddress) {
        swagger.updateUserNoImage(keyUsername, valueUsername, keyPassword, valuePassword, keyAddress, valueAddress);
    }
    @When("user send PUT update request with {string} is {string}, {string} is {string}, {string} is {string}, {string} is {string}")
    public void userSendPUTUpdateRequestWithIsIsIsIs(String keyImage, String valueImage, String keyUsername, String valueUsername, String keyPassword, String valuePassword, String keyAddress, String valueAddress) {
        swagger.updateUserProfile(keyImage, valueImage, keyUsername, valueUsername, keyPassword, valuePassword, keyAddress, valueAddress);
    }

    @When("user send PUT update request username only with {string} is {string}")
    public void userSendPUTUpdateRequestUsernameOnlyWithIs(String keyUsername, String valueUsername) {
        swagger.updateUsernameOnly(keyUsername, valueUsername);
    }

    @When("user send PUT update request image only with {string} is {string}")
    public void userSendPUTUpdateRequestImageOnlyWithIs(String keyImage, String valueImage) {
        swagger.updateImageOnly(keyImage, valueImage);
    }

    @When("user send PUT update request password only with {string} is {string}")
    public void userSendPUTUpdateRequestPasswordOnlyWithIs(String keyPassword, String valuePassword) {
        swagger.updatePasswordOnly(keyPassword, valuePassword);
    }
    @When("user send PUT update request image and username only with {string} is {string}, {string} is {string}")
    public void userSendPUTUpdateRequestImageAndUsernameOnlyWithIsIs(String keyImage, String valueImage, String keyUsername, String valueUsername) {
        swagger.updateImageAndUsername(keyImage, valueImage, keyUsername, valueUsername);
    }

    @When("user send PUT update request username and password only with {string} is {string}, {string} is {string}")
    public void userSendPUTUpdateRequestUsernameAndPasswordOnlyWithIsIs(String keyUsername, String valueUsername, String keyPassword, String valuePassword) {
        swagger.updateUsernameAndPassword(keyUsername, valueUsername, keyPassword, valuePassword);
    }

    @When("user send PUT update request image and password only with {string} is {string}, {string} is {string}")
    public void userSendPUTUpdateRequestImageAndPasswordOnlyWithIsIs(String keyImage, String valueImage, String keyPassword, String valuePassword) {
        swagger.updateImageAndPassword(keyImage, valueImage, keyPassword, valuePassword);
    }

    @When("user send PUT update request username with {string} is {string}")
    public void updateUsernameInvalid(String keyUsername, String valueUsername) {
        swagger.updateUsernameInvalid(keyUsername, valueUsername);
    }

    @When("user send PUT update request password with {string} is {string}")
    public void updatePasswordInvalid(String keyPassword, String valuePassword) {
        swagger.updatePasswordInvalid(keyPassword, valuePassword);
    }

    @When("user send DEL request to delete user")
    public void userSendDELRequestToDeleteUser() {
        swagger.deleteUserValidId();
    }
}
