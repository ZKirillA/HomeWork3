package Steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Тогда;

import static Elements.BugPageElements.tasksButton;
import static Elements.MainPageElements.*;

public class MainPageSteps {
    @Тогда("^Переходим в раздел задачи$")
    public static void goToTasks() {
        projects.shouldBe(Condition.visible).click();
        testProjects.shouldBe(Condition.visible).click();
        tasksButton.shouldBe(Condition.visible).click();
    }

    @Тогда("^Открываем задачу TestSelenium$")
    public static void seleniumTaskSearch() {
        Selenide.sleep(1000);
        searchField.shouldBe(Condition.visible).click();
        searchField.shouldBe(Condition.visible).sendKeys("TestSelenium");
        searchTestSelenium.shouldBe(Condition.visible).click();
    }

    @Тогда("^Нажимаем кнопку создать баг$")
    public static void createBug() {
        createBugButton.shouldBe(Condition.visible).click();
    }

}