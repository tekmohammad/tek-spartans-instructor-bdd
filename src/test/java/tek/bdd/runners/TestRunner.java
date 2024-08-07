package tek.bdd.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features", // Directory for Feature file
        glue = "tek.bdd.steps", //Package for all the steps
        dryRun = false, //set to true to scan feature for unimplemented steps
        tags = "@ValidateFieldErrorUsingMap",
        plugin = {
                "html:target/cucumber_report/index.html"
        }
)
public class TestRunner {
}

//Running multiple tags => tags = "@Smoke or @Regression"