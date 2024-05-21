package Runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "Resources/Features" }, 
		glue = { "stepDefinition" },
		plugin= {"pretty", "html:target/cucumber-reports.html"},
		tags = "@smokeTest",
		monochrome = true
		)

public class TestRunner {

}
