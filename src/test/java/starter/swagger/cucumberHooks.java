package starter.swagger;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class cucumberHooks {

    @Before
    public static void beforeAll(){
        RestAssured.baseURI = "https://virtserver.swaggerhub.com/davidwah/MNROOM/1.0";
    }
}
