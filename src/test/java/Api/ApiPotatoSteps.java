package Api;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static Settings.Configuration.getFromProperties;


public class ApiPotatoSteps {
    public void createPostRequest() throws IOException {

        JSONObject jsonObject = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/.json"))));

        jsonObject.put("name", "Tomato");
        jsonObject.put("job", "Eat maket");

        Response response5 = given()
                .baseUri(getFromProperties("urlpotato"))
                .contentType("application/json;charset=UTF-8")
                .when()
                .body(jsonObject.toString())
                .post("api/users")
                .then()
                .statusCode(201)
                .extract().response();

        String resp5 = response5.getBody().asString();
        JSONObject resp5json = new JSONObject(resp5);
        Assertions.assertEquals(resp5json.getString("name"), "Tomato");
        Assertions.assertEquals(resp5json.getString("job"), "Eat maket");
    }
}
