package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * The {@code TestRunner} class configures and initiates the Cucumber test execution.
 * It specifies the location of feature files and step definitions, and sets reporting
 * preferences for the test output.
 * This class uses JUnit's {@code @RunWith} annotation to enable running tests with Cucumber.
 * Author: Cem AÇAR
 * Email: cem.acar03@gmail.com
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class TestRunner {
}
