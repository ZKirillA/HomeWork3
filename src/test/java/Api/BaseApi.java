package Api;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class BaseApi {
    private static final String URL_MORTY = "https://rickandmortyapi.com/api";
    private static final String URL_POTATO = "https://reqres.in/";

    public static Response getResponseCharacter(String id) {
        return given()
                .baseUri(URL_MORTY)
                .contentType("application/json;charset=UTF-8")
                .when()
                .get("/character/" + id)
                .then()
                //   .log().all()
                .assertThat()
                .statusCode(200)
                .extract().response();
    }

    public static Response getResponseEpisode(String episode) {
        return given()
                .baseUri(URL_MORTY)
                .contentType("application/json;charset=UTF-8")
                .when()
                .get("/episode/" + episode)
                .then()
                //   .log().all()
                .assertThat()
                .statusCode(200)
                .extract().response();
    }

    public static Response getResponsePotato(JSONObject jsonObject) {
        return given()
                .baseUri(URL_POTATO)
                .contentType("application/json;charset=UTF-8")
                .when()
                .body(jsonObject.toString())
                .post("api/users")
                .then()
                .statusCode(201)
                .extract().response();
    }

    public static String parseResponse(Response response, String endpoint) {
        return new JSONObject(response.getBody().asString()).get(endpoint).toString();
    }

    public static String parseResponse(Response response, String JsonObj, String endpoint) {
        return new JSONObject(response.getBody().asString()).getJSONObject(JsonObj).get(endpoint).toString();
    }

    public static JSONArray parseResponseWithJsonArray(Response response, String jsonObj) {
        return new JSONObject(response.getBody().asString()).getJSONArray(jsonObj);
    }
}