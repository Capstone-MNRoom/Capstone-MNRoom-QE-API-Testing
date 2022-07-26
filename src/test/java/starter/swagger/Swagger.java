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


    //--------------USERS----------------
    public void getAllUsers() {
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .get("/users");
        response.prettyPrint();

    }

    public void getUserProfile() {
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .get("/users/profile");
        response.prettyPrint();

    }

    public void updateUserProfile(String keyImage, String valueImage, String keyUsername, String valueUsername, String keyPassword, String valuePassword, String keyAddress, String valueAddress) {
        String path = "src/test/resources/payload/" + valueImage;
        File bodyJson = new File(String.format(path));
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .multiPart(keyImage, bodyJson)
                .formParams(keyUsername, valueUsername)
                .formParams(keyPassword, valuePassword)
                .formParams(keyAddress, valueAddress)
                .put("/users");
        response.prettyPrint();
    }

    public void updateUserNoImage(String keyUsername, String valueUsername, String keyPassword, String valuePassword, String keyAddress, String valueAddress){
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .multiPart(keyUsername, valueUsername)
                .formParams(keyPassword, valuePassword)
                .formParams(keyAddress, valueAddress)
                .put("/users");
        response.prettyPrint();
    }

    public void updateUsernameOnly(String keyUsername, String valueUsername){
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .multiPart(keyUsername, valueUsername)
                .put("/users");
        response.prettyPrint();
    }

    public void updateImageOnly(String keyImage, String valueImage){
        String path = "src/test/resources/payload/" + valueImage;
        File bodyJson = new File(String.format(path));
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .multiPart(keyImage, bodyJson)
                .put("/users");
        response.prettyPrint();
    }

    public void updatePasswordOnly(String keyPassword, String valuePassword){
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .multiPart(keyPassword, valuePassword)
                .put("/users");
        response.prettyPrint();
    }
    public void updateImageAndUsername(String keyImage, String valueImage, String keyUsername, String valueUsername){
        String path = "src/test/resources/payload/" + valueImage;
        File bodyJson = new File(String.format(path));
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .multiPart(keyImage, bodyJson)
                .formParams(keyUsername, valueUsername)
                .put("/users");
        response.prettyPrint();
    }

    public void updateUsernameAndPassword(String keyUsername, String valueUsername, String keyPassword, String valuePassword){
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .multiPart(keyUsername, valueUsername)
                .formParams(keyPassword, valuePassword)
                .put("/users");
        response.prettyPrint();
    }

    public void updateImageAndPassword(String keyImage, String valueImage, String keyPassword, String valuePassword){
        String path = "src/test/resources/payload/" + valueImage;
        File bodyJson = new File(String.format(path));
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .multiPart(keyImage, bodyJson)
                .formParams(keyPassword, valuePassword)
                .put("/users");
        response.prettyPrint();
    }


    public void updateUsernameInvalid(String keyUsername, String valueUsername){
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .multiPart(keyUsername, valueUsername)
                .put("/users");
        response.prettyPrint();
    }

    public void updatePasswordInvalid(String keyPassword, String valuePassword){
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .multiPart(keyPassword, valuePassword)
                .put("/users");
        response.prettyPrint();
    }

    public void deleteUserValidId(){
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .delete("/users/");
    }

    //--------------ROOMS----------------
    public void getAllRooms(){
        response = RestAssured.given()
                .headers("Content-type", "application/json")
//                .queryParam("page", 1)
                .get("/rooms?page=1");
    }

    public void getAllRoomsbyQuery(){
        response = RestAssured.given()
                .headers("Content-type", "application/json")
                .queryParam("idcategory", 1)
                .queryParam("page", 1)
                .get("/rooms");
    }

    public void getAllRoomsbyAlphanumQuery(){
        response = RestAssured.given()
                .headers("Content-type", "application/json")
                .queryParam("idcategory", "satu")
                .queryParam("page", 1)
                .get("/rooms");
    }

    public void getAllRoomsbyNegativeNumbQuery(){
        response = RestAssured.given()
                .headers("Content-type", "application/json")
                .queryParam("idcategory", -1)
                .queryParam("page", 1)
                .get("/rooms");
    }

    public void getAllRoomsbyDoesntExist(){
        response = RestAssured.given()
                .headers("Content-type", "application/json")
                .queryParam("idcategory", 1001)
                .queryParam("page", 1)
                .get("/rooms");
    }

    public void postRoom(File body){
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .headers("Content-type", "application/json")
                .body(body).post("/rooms");
    }

    public void getRoomByID(int idroom){
        response = RestAssured.get("/rooms/" + idroom);
    }

    public void getRoomByIDasAlphabet(String idroom){
        response = RestAssured.get("/rooms/" + idroom);
    }

    public void updateRoomValidId(int idroom, File body){
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .headers("Content-type", "application/json")
                .body(body)
                .put("/rooms/" + idroom);
    }

    public void updateImage(int idroom, File gbr){
        response = (Response) RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .multiPart("image_room", gbr)
                .put("/rooms/" + idroom);
    }

    public void updateRoomIdAlphanumeric(String idroom, File body){
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .headers("Content-type", "application/json")
                .body(body)
                .put("/rooms/" + idroom);
    }

    public void deleteRoomValidId(int idroom){
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .delete("/rooms/" + idroom);
    }

    public void deleteRoomIdAlphanumeric(String idroom){
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .delete("/rooms/" + idroom);
    }

    //--------------FACILITY----------------
    public void getRoomFacility(int idroom){
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .get("/rooms/" + idroom + "/facility");
    }

    public void getRoomFacilityIdAlphanum(String idroom){
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .get("/rooms/" + idroom + "/facility");
    }

    public void getAllFacility(){
        response = RestAssured.given()
                .headers("Content-type", "application/json")
                .get("/facilitys");
    }

    public void getFacilityValidId(){
        response = RestAssured.given()
                .headers("Content-type", "application/json")
                .get("/facilitys/1");
    }

    public void getFacilityIdNegative(){
        response = RestAssured.given()
                .headers("Content-type", "application/json")
                .get("/facilitys/-1");
    }

    public void getFacilityIdAlphanum(){
        response = RestAssured.given()
                .headers("Content-type", "application/json")
                .get("/facilitys/satu");
    }

    public void getFacilityIdDoesntExist(){
        response = RestAssured.given()
                .headers("Content-type", "application/json")
                .get("/facilitys/100");
    }

    public void getFacilityIdSpecChar(){
        response = RestAssured.given()
                .headers("Content-type", "application/json")
                .get("/facilitys/@#$");
    }

    //--------------RENT----------------
    public void postRent(File body) {
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .headers("Content-type", "application/json")
                .body(body).post("/rents");
        response.prettyPrint();
    }


    //--------------CATEGORIES----------------

    public void getAllCategories() {
        response = RestAssured.get("/categorys");
    }

    public void getCategoriesById(int idCategories) {
        response = RestAssured.get("/categorys/" + idCategories);
    }

    public void getCategoriesInvalidId(String idCategories){
        response = RestAssured.get("/categorys/" + idCategories);
    }


    //--------------PAYMENT----------------

    public void postPayment(File body) {
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .headers("Content-type", "application/json")
                .body(body).post("/rents");
        response.prettyPrint();
    }

    public void getPayment(){
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .get("/payment");
    }

    public void getPaymentNoLogin(){
        response = RestAssured.given().get("/payment");
    }

    //--------------FEEDBACK----------------
    public void postFeedback(File body, int idRoom) {
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .headers("Content-type", "application/json")
                .body(body).post("/feedbacks" + idRoom);
        response.prettyPrint();
    }
    public void getFeedbackIdAsInteger(int idRoom){
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .get("/payment" + idRoom);
    }
    public void getFeedbackInvalidId(String idRoom){
        response = RestAssured.given()
                .headers("Authorization", "Bearer " + token)
                .get("/payment" + idRoom);
    }





}
