package Runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"@target/failedrerun.txt"}
		,glue={"stepDefinitions"}
		,monochrome=true
		,publish=true
		,plugin = {
		                "pretty",
		                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		               // "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"
		                "rerun:target/failedrerun.txt"

		        }
		)
public class FaiedScenariosRunner extends AbstractTestNGCucumberTests{
	

	@Override
	@DataProvider(parallel=false)
	public Object [][] scenarios(){

		return super.scenarios();

	}


}
