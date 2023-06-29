package Pages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import TestBase.BaseClass;
import utility.Utility;

public class SuccessPage extends BaseClass{


	public Boolean printReceiptbutton;

	By Success=By.xpath("//b[contains(text(),'Success')]");

	By printReceipt=By.xpath("//body/div[@id='MainContainer']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]");

	By Backbtn=By.xpath("//body/div[@id='MainContainer']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[2]/img[1]");

	By ContactlessBackBtn=By.xpath("//body/div[@id='MainContainer']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]");

	By Retry=By.xpath("//button[contains(text(),'Retry')]");

	By Home=By.xpath("//a[contains(text(),'Home')]");

	By Status=By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/b[1]");



	public SuccessPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public Boolean printReceipt() {
		wait3.until(ExpectedConditions.visibilityOfElementLocated(printReceipt));
		printReceiptbutton=driver.findElement(printReceipt).isDisplayed();
		return printReceiptbutton;

	}
	public void Backbtn(String PaymentType) throws AWTException, InterruptedException {

		if(PaymentType.contains("Manual Entry")) {
			wait3.until(ExpectedConditions.visibilityOfElementLocated(Backbtn));
			Boolean printReceiptbutton=driver.findElement(Backbtn).isDisplayed();
			Thread.sleep(3000);
			driver.findElement(Backbtn).click();

		}
		else if(PaymentType.contains("Contactless")) {
			wait3.until(ExpectedConditions.visibilityOfElementLocated(ContactlessBackBtn));
			Boolean printReceiptbutton=driver.findElement(ContactlessBackBtn).isDisplayed();
			Thread.sleep(3000);
			driver.findElement(ContactlessBackBtn).click();

		}
	}
	public String verifyStatus() {
			Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
			wait3.until(ExpectedConditions.visibilityOfElementLocated(Status));
			String status=driver.findElement(Status).getText();
			return status;

	}

}
