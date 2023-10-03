package stepDefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"FeatureFiles/login.feature"},
		glue= {"stepDefinitions"},
		plugin= {"pretty",
				"html:target/report/cucumber.html",
				"json:target/report/cucumber.json"},
		dryRun=false,
		tags="@Smokee"
		)


public class TestRunner extends AbstractTestNGCucumberTests{

}
