package Tests;

import com.codeborne.selenide.Selenide;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        tags = "@Test",
        plugin = {"pretty"}
)
public class RunnerTest {
    @AfterEach
    public void closeDriver(){
        Selenide.webdriver().driver().close();
    }
}
