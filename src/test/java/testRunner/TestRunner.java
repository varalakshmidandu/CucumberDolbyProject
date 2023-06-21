package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
					
					features= {".//Features/SignUp.feature"},
					glue="stepDefinitions",
					plugin= {"pretty", "html:reports/myreport.html"},
					dryRun=false,tags = "@Regression"
				)
public class TestRunner extends  AbstractTestNGCucumberTests{

	
}
