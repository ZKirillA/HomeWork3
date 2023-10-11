package Tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static Api.ApiMortySteps.*;
import static Api.ApiPotatoSteps.*;

public class ApiTest {

    @Test
    public void mortyTest() {
        mortyInformation("2");
        lastEpisode("2");
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

    @BeforeAll
    public static void allureSubThreadParallel(){
        String listenerName = "AllureSelenide";
        if (!(SelenideLogger.hasListener(listenerName)))
            SelenideLogger.addListener(listenerName,
                    (new AllureSelenide().screenshots(true).savePageSource(false)));

    }
}