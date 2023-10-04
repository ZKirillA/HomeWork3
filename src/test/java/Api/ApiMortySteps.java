package Api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static io.restassured.RestAssured.given;
import static Settings.Configuration.getFromProperties;

public class ApiMortySteps {
    public static void someApiFunc(){
        RequestSpecification requestSpec = (RequestSpecification) new RequestSpecBuilder()
        .setBaseUri("https://rickandmortyapi.com/api")
        .setContentType(ContentType.JSON);

        RestAssured.requestSpecification = requestSpec;

        ResponseSpecification res = (ResponseSpecification) new RequestSpecBuilder()




        //ResponceSpecification responceSpec = new ResponceSpecBuilder()
                //.expectStatusCode


    }
    public static int lastEpisode;
    public static String mortyname;
    public static String mortylocation;
    public static String mortyrace;
    public static String lastCharacterName;
    public static String lastCharacterrace;
    public static int lastCharacterNum;
    public static String lastCharacterLocation;

    @DisplayName("Задание на создание API и сравнение информации о персонажах")
    public static void mortyInformation() {
        Response response1 = given()
                //.baseUri("https://rickandmortyapi.com/api")
                .contentType(ContentType.JSON)
                .when()
                .get("/character/2")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract().response();
        mortyname = new JSONObject(response1.getBody().asString()).get("name").toString();
        mortylocation = new JSONObject(response1.getBody().asString()).getJSONObject("location").get("name").toString();
        mortyrace = new JSONObject(response1.getBody().asString()).get("species").toString();
        System.out.println(mortyname+mortylocation+mortyrace);
    }

    public static void lastEpisode() {
        Response response2 = given()
                .baseUri(getFromProperties("url"))
                .contentType(ContentType.JSON)
                .when()
                .get("/character/2")
                .then()
                .extract().response();

        int jsonSize1 = new JSONObject(response2.asString()).getJSONArray("episode").length();
        lastEpisode = Integer.parseInt(new JSONObject(response2.getBody().asString()).getJSONArray("episode").get(jsonSize1 - 1).toString().replaceAll("[^0-9]", ""));
    }

    public static void getLastCharacterNum() {
        Response response3 = given()
                .baseUri(getFromProperties("url"))
                .contentType(ContentType.JSON)
                .when()
                .get("/episode/" + lastEpisode)
                .then()
                .extract().response();

        int lastCharacterIndex = (new JSONObject(response3.getBody().asString()).getJSONArray("characters").length() - 1);
        lastCharacterNum = Integer.parseInt(new JSONObject(response3.getBody().asString()).getJSONArray("characters").get(lastCharacterIndex).toString().replaceAll("[^0-9]", ""));
    }

    public static void getLastCharacterInfo() {
        Response response4 = given()
                .baseUri(getFromProperties("url"))
                .contentType(ContentType.JSON)
                .when()
                .get("/character/" + lastCharacterNum)
                .then()
                .extract().response();
        lastCharacterName = new JSONObject(response4.getBody().asString()).get("name").toString();
        lastCharacterLocation = new JSONObject(response4.getBody().asString()).getJSONObject("location").get("name").toString();
        lastCharacterrace = new JSONObject(response4.getBody().asString()).get("species").toString();
    }

    public void assertionsRace() {
        Assertions.assertEquals(mortyrace, lastCharacterrace);
    }

    public void assertionsLoc() {
        Assertions.assertNotEquals(mortylocation, lastCharacterLocation);
    }
}
