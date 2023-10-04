package Tests;

import java.io.IOException;

import static Api.ApiMortySteps.*;
import static Api.ApiPotatoSteps.*;

public class Test {

    @org.junit.jupiter.api.Test
    public void mortyTest() {
        mortyInformation("2");
        lastEpisode("2");
        getLastCharacterNum();
        getLastCharacterInfo();
        checkRace();
        checkLocation();
    }

    @org.junit.jupiter.api.Test
    public void potatoTest() throws IOException {
        sendPostRequest();
        checkName();
        checkJob();
        checkId();
    }
}