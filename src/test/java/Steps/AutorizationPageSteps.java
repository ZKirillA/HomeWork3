package Steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static Elements.AutorizationPageElements.*;

public class AutorizationPageSteps {
    public static void authorizationInJira(){
        Selenide.open("https://edujira.ifellow.ru");
        login.shouldBe(Condition.visible).sendKeys("AT8");
        password.shouldBe(Condition.visible).sendKeys("Qwerty123");
        buttonEnter.click();
    }

}
