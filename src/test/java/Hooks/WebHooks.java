package Hooks;

import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class WebHooks {

    @BeforeAll
    public static void setDriver() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 12000;
    }
    @AfterEach
    public void closeDriver(){
        Selenide.webdriver().driver().close();
    }


}