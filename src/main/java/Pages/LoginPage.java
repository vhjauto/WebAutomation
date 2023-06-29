package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import TestBase.BaseClass;
import io.cucumber.java.Scenario;
import utility.Utility;

public class LoginPage extends BaseClass{

	By username=By.name("User_Login_Id");

	By password=By.name("User_Login_Password");

	By loginButton=By.name("submit");

	By HomeMenu=By.xpath("//a[contains(text(),'Home')]");
	
	Scenario sc;

	public LoginPage() throws IOException{
			PageFactory.initElements(driver, this);


	}


	public void launchUrl(String url) {
		driver.get(url);
//		sc.log("Launching url");

	}

	public void enterUserNameAndPassoword(String gateway) throws IOException, InterruptedException {



		switch (gateway) {
		  case "Heartland":
			   	String hlun=prop.getProperty("hlusername");
			  	String hlpwd=prop.getProperty("hlpassword");
			//  	System.out.println("ecn pass "+pwd);
				wait.until(ExpectedConditions.visibilityOfElementLocated(username));
				driver.findElement(username).sendKeys(hlun);
				Thread.sleep(2000);
				driver.findElement(password).sendKeys(hlpwd);				
			    break;
		  case "Elavon":
			  	String un1=prop.getProperty("elusername");
			  	String pwd1=prop.getProperty("elpassword");
				wait.until(ExpectedConditions.visibilityOfElementLocated(username));
				driver.findElement(username).sendKeys(un1);
				Thread.sleep(2000);
				driver.findElement(password).sendKeys(pwd1);				
				break;
		  case "Tsys":

			  	String un2=prop.getProperty("tsysusername");
			  	String pwd2=prop.getProperty("tsyspassword");
				wait.until(ExpectedConditions.visibilityOfElementLocated(username));
				driver.findElement(username).sendKeys(un2);
				Thread.sleep(2000);
				driver.findElement(password).sendKeys(pwd2);
			    break;
		  case "CardPointe":

			  	String un3=prop.getProperty("cardpointeusername");
			  	String pwd3=prop.getProperty("cardpointepassword");
				wait.until(ExpectedConditions.visibilityOfElementLocated(username));
				driver.findElement(username).sendKeys(un3);
				Thread.sleep(2000);
						
				driver.findElement(password).sendKeys(pwd3);
				
				break;
		  case "Rapid":

			  	String un4=prop.getProperty("rapidusername");
			  	String pwd4=prop.getProperty("rapidpassword");
				wait.until(ExpectedConditions.visibilityOfElementLocated(username));
				driver.findElement(username).sendKeys(un4);
				Thread.sleep(2000);
						
				driver.findElement(password).sendKeys(pwd4);
				break;
		  case "Stripe":

			  	String un5=prop.getProperty("stripeusername");
			  	String pwd5=prop.getProperty("stripepassword");
				wait.until(ExpectedConditions.visibilityOfElementLocated(username));
				driver.findElement(username).sendKeys(un5);
				Thread.sleep(2000);
				String pw5=Utility.getPassword(pwd5);		
				driver.findElement(password).sendKeys(pwd5);
				break;
		  case "Fortis":

			  	String un6=prop.getProperty("fortisusername");
			  	String pwd6=prop.getProperty("fortispassword");
				wait.until(ExpectedConditions.visibilityOfElementLocated(username));
				driver.findElement(username).sendKeys(un6);
				Thread.sleep(2000);
				String pw6=Utility.getPassword(pwd6);		
				driver.findElement(password).sendKeys(pwd6);
				break;
		}




	}
	public void login() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(loginButton).click();
//		sc.log("Login success");


	}


}
