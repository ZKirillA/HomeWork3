package Elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BugPageElements {
    public static SelenideElement tasksButton = $x("//*[contains(text(),'Задачи')]");
    public static SelenideElement numberOfTasks = $x("//*[contains(text(),'1 из ')]");
    public static SelenideElement statusOfTask = $x("//span[@id='status-val']/span");
    public static SelenideElement versionOfTask = $x("//span[@id='fixVersions-field']/a");
    public static SelenideElement bugType = $x("//input[@id='issuetype-field']");
    public static SelenideElement typeError = $x("//*[text()='Ошибка']");
    public static SelenideElement subjectField = $x("//input[@name='summary']");
    public static SelenideElement descriptionField = $x("//body[@id='tinymce']");
    public static SelenideElement fixInVersions = $x("(//option[@value='10001'])[1]");
    public static SelenideElement priorityField = $x("//input[@id='priority-field']");
    public static SelenideElement choosePriority = $x("//*[text()='Low']");
    public static SelenideElement tagsField = $x("//textarea[@id='labels-textarea']");
    public static SelenideElement affectedVersions = $x("(//option[@value='10001'])[2]");
    public static SelenideElement relatedTasksField = $x("//select[@id='configure-fields']");
    public static SelenideElement chooseRelatedTasks = $x("//*[text()='clones']");
    public static SelenideElement tasksField = $x("//textarea[@id='issuelinks-issues-textarea']");
    public static SelenideElement executorField = $x("//button[@id='assign-to-me-trigger']");
    public static SelenideElement sprintField = $x("//input[@id='customfield_10104-field']");
    public static SelenideElement createButton = $x("//input[@id='create-issue-submit']");


}
