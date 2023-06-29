package Runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(CucumberOptions.class)
@CucumberOptions(
		features = "src/test/resources/features"
		,glue={"stepDefinitions"}
		,tags="@UnitTest1"
		,monochrome=true
		,publish=true
		,plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
               // "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"
                "rerun:target/failedrerun.txt"

        }

		,dryRun=false
		)
public class TestRunner  extends AbstractTestNGCucumberTests {

	
	@Override
	@DataProvider(parallel=false)
	public Object [][] scenarios(){

		return super.scenarios();

	}




}
