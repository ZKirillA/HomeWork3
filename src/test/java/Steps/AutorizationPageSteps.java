package Steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Когда;
import io.qameta.allure.Step;
import static Elements.AutorizationPageElements.*;

public class AutorizationPageSteps {
    @Step("Авторизация")
    @Когда("^Выполнена авторизация на портале jira под логином (.*) и паролем (.*)$")
    public static void authorizationInJira(String userName, String userPassword) {
        login.shouldBe(Condition.visible).sendKeys(userName);
        password.shouldBe(Condition.visible).sendKeys(userPassword);
        buttonEnter.click();
    }

}
