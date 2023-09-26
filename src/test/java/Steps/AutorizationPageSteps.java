package Steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Когда;

import static Configuration.Configuration.getFromProperties;
import static Elements.AutorizationPageElements.*;

public class AutorizationPageSteps {
    @Когда("^Выполнена авторизация на портале jira$")
    public static void authorizationInJira() {
        Selenide.open(getFromProperties("url"));
        login.shouldBe(Condition.visible).sendKeys(getFromProperties("login"));
        password.shouldBe(Condition.visible).sendKeys(getFromProperties("password"));
        buttonEnter.click();
    }

}
