package Tests;

import Hooks.WebHooks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Steps.AutorizationPageSteps.authorizationInJira;
import static Steps.BugPageSteps.*;
import static Steps.MainPageSteps.*;

public class JiraTests extends WebHooks {
    @Test
    @DisplayName("Задание по проверке количества задач")
    public void test() {
        authorizationInJira();
        goToTasks();
        checkNumOfTasks();
    }

    @Test
    @DisplayName("Задание по проверке статуса задачи TestSelenium")
    public void test2() {
        authorizationInJira();
        seleniumTaskSearch();
        checkStatus("ГОТОВО");
        checkVersion("Version 2.0");
    }

    @Test
    @DisplayName("Задание по созданию бага")
    public void test3() {
        authorizationInJira();
        createBug();
        fillBugFields();
        changeStatusToComplite();
        checkBugStatus();
    }
}
