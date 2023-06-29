package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
// import org.testng.asserts.SoftAssert;

import io.cucumber.java.Scenario;

public class BaseClass {


	public static Properties prop;
	public static FileInputStream ip;
	public static File file;
	public static FileReader reader;
//	public static InputStream ip;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static WebDriverWait wait2;
	public static WebDriverWait wait3;
//	public static SoftAssert soft;
	public static Scenario scenario;

	public static String cardNo;
	public static String gateway_COF;
	public static String Speciality;
	public static ChromeOptions options;


	//	public static ExtentReports extent;
	//public static ExtentTest test;
	public static String congigFilePath="src/test/resources/configs/config.properties";


	public BaseClass() throws IOException {

		try {

			prop=new Properties();
			ip= new FileInputStream(congigFilePath);
			prop.load(ip);
		}
		catch(IOException e) {
			e.printStackTrace();

		}

	}
	

	public static void browserInitialization() throws InterruptedException {
		String browsername=prop.getProperty("browser");
		if(browsername.equals(browsername)) {
			options = new ChromeOptions();
		//	options.setHeadless(true);
			driver = new ChromeDriver(options);
			Thread.sleep(3000);

		}
		else if(browsername.equals("ie")) {
		
			driver=new InternetExplorerDriver();
			Thread.sleep(5000);

		}
		
		wait=new WebDriverWait(driver, Duration.ofSeconds(50));
//		wait = new WebDriverWait(driver,60);
		wait2 = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait3=new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.get(prop.getProperty("url"));
//		 Reporter.log("Application has been launched successfully!");
	}


}
