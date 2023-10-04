package Api;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static Api.BaseApi.getResponsePotato;


public class ApiPotatoSteps {
    private static JSONObject respJson;

    public static void sendPostRequest() throws IOException {

        JSONObject jsonObject = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/.json"))));

        jsonObject.put("name", "Tomato");
        jsonObject.put("job", "Eat maket");

        respJson = new JSONObject(getResponsePotato(jsonObject).getBody().asString());
    }

    public static void checkName() {
        Assertions.assertEquals(respJson.getString("name"), "Tomato");
    }

    public static void checkJob() {
        Assertions.assertEquals(respJson.getString("job"), "Eat maket");
    }

    public static void checkId() {
        Assertions.assertNotNull(respJson.getString("id"));
    }
}
