package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.asserts.SoftAssert;

import TestBase.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass{

	String configPath="src/test/resources/configs/config.properties";
	SoftAssert soft;
	
	



	public Hooks() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Before()
	public void setUp(Scenario sc) throws InterruptedException, FileNotFoundException {

//		soft=new SoftAssert();
		BaseClass.browserInitialization();
		scenario=sc;
	}
	@After(order = 1)
	public void takeScraenshotOnFailureOrSuccess() {

		if (scenario.isFailed()) {
		String scenarioName=scenario.getName();
		TakesScreenshot ts = (TakesScreenshot) driver;

		byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(src, "image/png", scenarioName);
		}
		

	}

	@After(order = 0)
	public void tearDown() {
	//	soft.assertAll();
		driver.quit();

	}

}
