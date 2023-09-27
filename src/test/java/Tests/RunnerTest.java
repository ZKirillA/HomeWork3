package Tests;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"Steps","Hooks"},
        tags = "@Test",
        plugin = {"pretty"}
)
public class RunnerTest {

}
