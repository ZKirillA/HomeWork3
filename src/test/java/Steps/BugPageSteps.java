package Steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.И;
import org.junit.jupiter.api.Assertions;

import static Elements.BugPageElements.*;

public class BugPageSteps {
    @И("^Сравниваем количество задач$")
    public static void checkNumOfTasks() {
        String num = numberOfTasks.shouldBe(Condition.visible).getText().substring(5);
        String num2 = numberOfTasks.shouldBe(Condition.visible).getText().substring(5);
        Assertions.assertEquals(num, num2, "Количество задач не совпадает");
    }

    @И("^Проверяем статус задачи = (.*)$")
    public static void checkStatus(String status) {
        Assertions.assertEquals(status, statusOfTask.shouldBe(Condition.visible).getText());
    }

    @И("^Проверяем версию задачи = (.*)$")
    public static void checkVersion(String version) {
        Assertions.assertEquals(version, versionOfTask.shouldBe(Condition.visible).getText());
    }

    @И("^Заполняем все поля описания бага$")
    public static void fillBugFields() {
        subjectField.shouldBe(Condition.visible).sendKeys("Тест Кирилл Зайцев");
        Selenide.switchTo().frame(iframe);
        descriptionField.shouldBe(Condition.visible).click();
        descriptionField.sendKeys("Описание бага - всё сломалось");
        Selenide.switchTo().parentFrame();
        fixInVersions.shouldBe(Condition.visible).click();
        priorityField.shouldBe(Condition.visible).click();
        choosePriority.shouldBe(Condition.visible).click();
        tagsField.shouldBe(Condition.visible).sendKeys("Test1");
        tagsField.pressEnter();
        Selenide.switchTo().frame(iframeNext);
        environmentField.shouldBe(Condition.visible).click();
        environmentField.sendKeys("Google Chrome Версия 117.0.5938.89 (Официальная сборка), (64 бит)");
        Selenide.switchTo().parentFrame();
        affectedVersions.shouldBe(Condition.visible).click();
        relatedTasksField.shouldBe(Condition.visible).click();
        chooseRelatedTasks.shouldBe(Condition.visible).click();
        tasksField.shouldBe(Condition.visible).sendKeys("TestSelenium");
        Selenide.sleep(1000);
        tasksField.pressEnter();
        executorField.click();
        Selenide.sleep(1000);
        createButton.click();
    }

    @И("^Переводим в статус 'ГОТОВО'$")
    public static void changeStatusToComplite() {
        myBug.shouldBe(Condition.visible).click();
        buttonBussinesProc.shouldBe(Condition.visible).click();
        buttonComplite.shouldBe(Condition.visible).click();
        Selenide.sleep(2000);
    }

    @И("^Проверяем,что статус задачи = (.*)$")
    public static void checkBugStatus(String status) {
        Assertions.assertEquals(status, statusInBug.shouldBe(Condition.visible).getText(), "Статус задачи не изменился");
    }
}