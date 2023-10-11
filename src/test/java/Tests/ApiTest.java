package Tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static Api.ApiMortySteps.*;
import static Api.ApiPotatoSteps.*;

public class ApiTest {

    @Test
    public void mortyTest() {
        mortyInformation("2");
        lastEpisode();
        getLastCharacterNum();
        getLastCharacterInfo();
        checkRace();
        checkLocation();
    }

    @Test
    public void potatoTest() throws IOException {
        sendPostRequest();
        checkName();
        checkJob();
        checkId();
    }
}