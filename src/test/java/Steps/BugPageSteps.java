package Steps;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;

import static Elements.BugPageElements.*;

public class BugPageSteps {
    public static void checkNumOfTasks() {
        String num = numberOfTasks.shouldBe(Condition.visible).getText().substring(5);
        String num2 = numberOfTasks.shouldBe(Condition.visible).getText().substring(5);
        Assertions.assertEquals(num, num2, "Количество задач не совпадает");
    }

    public static void checkStatus(String status) {
        Assertions.assertEquals(statusOfTask.shouldBe(Condition.visible).getText(), status);
    }

    public static void checkVersion(String version) {
        Assertions.assertEquals(versionOfTask.shouldBe(Condition.visible).getText(), version);
    }

    public static void fillBugFields() {
        bugType.shouldBe(Condition.visible).click();
        typeError.shouldBe(Condition.visible).click();
        subjectField.shouldBe(Condition.visible).sendKeys("Тест Кирилл Зайцев");
        descriptionField.shouldBe(Condition.visible).sendKeys("Описание бага");
        fixInVersions.shouldBe(Condition.visible).click();
        priorityField.shouldBe(Condition.visible).click();
        choosePriority.shouldBe(Condition.visible).click();
        tagsField.shouldBe(Condition.visible).sendKeys("Test1");
        tagsField.pressEnter();
        affectedVersions.shouldBe(Condition.visible).click();
        relatedTasksField.shouldBe(Condition.visible).click();
        chooseRelatedTasks.shouldBe(Condition.visible).click();
        tasksField.shouldBe(Condition.visible).sendKeys("TestSelenium");
        tasksField.pressEnter();
        executorField.click();
        sprintField.shouldBe(Condition.visible).sendKeys("Доска Спринт 1");
        sprintField.pressEnter();
        createButton.click();


    }
}
