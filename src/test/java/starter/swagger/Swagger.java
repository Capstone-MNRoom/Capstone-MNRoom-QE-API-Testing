package starter.swagger;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;

public class Swagger {
    public static Response response;
    public static String token;

    public void postLogin(File body){
        response = RestAssured.given()
                .headers("Content-type", "application/json")
                .body(body).post("/login");
    }

    public void postSignup(File body){
        response = RestAssured.given()
                .headers("Content-type", "application/json")
                .body(body).post("/signup");
    }


    //--------------ROOMS----------------
    public void getAllRooms(){
        response = RestAssured.given()
                .headers("Content-type", "application/json")
                .get("/rooms/?idcategory=1&page=1");
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
}
