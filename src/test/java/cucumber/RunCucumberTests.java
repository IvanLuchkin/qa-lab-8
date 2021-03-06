package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "src/test/java/cucumber/scenarios" },
        tags = "@PageModel",
        plugin = { "pretty", "html:target/cucumber-report.html" },
        monochrome = true
)
public class RunCucumberTests {

}