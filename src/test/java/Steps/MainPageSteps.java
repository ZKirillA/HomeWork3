package Steps;

import com.codeborne.selenide.Condition;

import static Elements.BugPageElements.tasksButton;
import static Elements.MainPageElements.*;

public class MainPageSteps {
    public static void goToTasks() {
        projects.shouldBe(Condition.visible).click();
        testProjects.shouldBe(Condition.visible).click();
        tasksButton.shouldBe(Condition.visible).click();
    }

    public static void seleniumTaskSearch(){
        searchField.shouldBe(Condition.visible).sendKeys("TestSelenium");
        searchTestSelenium.shouldBe(Condition.visible).click();
    }
    public static void createBug(){
        createBugButton.shouldBe(Condition.visible).click();
    }

}