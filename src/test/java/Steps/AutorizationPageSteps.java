package Steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Когда;

import static Configuration.Configuration.getFromProperties;
import static Elements.AutorizationPageElements.*;

public class AutorizationPageSteps {
    @Когда("^Выполнена авторизация на портале jira под логином (.*) и паролем (.*)$")
    public static void authorizationInJira(String userName, String userPassword) {
        login.shouldBe(Condition.visible).sendKeys(userName);
        password.shouldBe(Condition.visible).sendKeys(userPassword);
        buttonEnter.click();
    }

}
