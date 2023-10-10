package Hooks;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

import static Configuration.Configuration.getFromProperties;

public class WebHooks {

    @Before
    public static void setDriver() {
        Configuration.browser = Browsers.CHROME;
        Selenide.open(getFromProperties("url"));
        WebDriverRunner.getWebDriver().manage().window().maximize();
        Configuration.timeout = 12000;
    }
    @After
    public void closeDriver(){
        Selenide.webdriver().driver().close();
    }

    /*@BeforeAll
    public static void allureSelenide() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true));}*/




    @BeforeAll
    public static void allureSubThreadParallel(){
        String listenerName = "AllureSelenide";
        if (!(SelenideLogger.hasListener(listenerName)))
            SelenideLogger.addListener(listenerName,
                    (new AllureSelenide().screenshots(true).savePageSource(false)));

    }
}