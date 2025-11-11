package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
            features = "src/test/java/features",
            glue = {"stepDefinitions", "utility"},
            plugin = {"pretty", "html:cucumber-html-report.html", "json:cucumber.json"},
            monochrome = true
    )
    public class TestRunner {
}
