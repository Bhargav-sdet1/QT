package stepDefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"FeatureFiles"},
		glue= {"stepDefinitions"},
		plugin= {"pretty",
				"html:target/report/cucumber.html",
				"json:target/report/cucumber.json"},
		dryRun=false
		//tags="@Regression"
		)


public class TestRunner extends AbstractTestNGCucumberTests{

}
