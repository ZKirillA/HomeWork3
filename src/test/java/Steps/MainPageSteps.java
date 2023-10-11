package Steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import static Elements.BugPageElements.tasksButton;
import static Elements.MainPageElements.*;

public class MainPageSteps {
    @Step("Переход в раздел задачи")
    @Тогда("^Переходим в раздел задачи$")
    public static void goToTasks() {
        projects.shouldBe(Condition.visible).click();
        testProjects.shouldBe(Condition.visible).click();
        tasksButton.shouldBe(Condition.visible).click();
    }

    @Step("Открытие задачи {task}")
    @Тогда("^Открываем задачу (.*)$")
    public static void seleniumTaskSearch(String task) {
        Selenide.sleep(1000);
        searchField.shouldBe(Condition.visible).click();
        searchField.shouldBe(Condition.visible).sendKeys(task);
        searchTestSelenium.shouldBe(Condition.visible).click();
    }

    @Step("Нажимаем кнопку создать баг")
    @Тогда("^Нажимаем кнопку создать баг$")
    public static void createBug() {
        createBugButton.shouldBe(Condition.visible).click();
    }

}