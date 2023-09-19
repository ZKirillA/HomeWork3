package Hooks;

import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;

public class WebHooks {

    @BeforeAll
    public static void setDriver() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 12000;
    }


}