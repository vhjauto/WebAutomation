package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import TestBase.BaseClass;
import utility.Utility;

public class ContactLessPage extends BaseClass {

	public ContactLessPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public String TransactionID;
	public String Ref_NO;
	public String PatientName;
	public String Amount;
	public String Last_4_digits_CardNumber;
	public String Phone_Email;

	public Boolean printReceiptbutton;
	Actions act ;



	By contaclessMenu=By.xpath("//a[@id='contactless-tab']");

	By dateofVisit=By.xpath("//input[@id='liquiddateofvisit']");

	By referenceNumber=By.xpath("//input[@name='liquidaccountnumber[]']");

	By speciality=By.name("liquidspecialist[]");

	By firstName=By.name("liquidfirst[]");

	By Lastname=By.name("liquidlast[]");

	By phone=By.name("liquidprocphone[]");

	By amount=By.name("liquidprocamt[]");

	By SubmitFormbtn=By.xpath("//input[@id='btnGet']");

	By Home=By.xpath("//a[contains(text(),'Home')]");
	
	By Speciality_E=By.name("liquidspecialist[]");
	
//	By cardInfoPage=By.xpath("//body/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]");

	public Boolean ContactLessForm() {

		wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dateofVisit));
		Boolean cotactless=driver.findElement(dateofVisit).isDisplayed();
		return cotactless;

	}
	public Boolean selectPaymentType() {
		wait2.until(ExpectedConditions.visibilityOfElementLocated(Home));
		driver.findElement(Home).click();
		wait2.until(ExpectedConditions.visibilityOfElementLocated(contaclessMenu));
		driver.findElement(contaclessMenu).click();
		Boolean ME=driver.findElement(contaclessMenu).isEnabled();
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
		return ME;

	}
	public void enterDateOfVisit() throws InterruptedException {
		Thread.sleep(2000);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(dateofVisit));
		driver.findElement(dateofVisit).click();
		Utility.getCurrentDate();
		WebElement date=driver.findElement(By.xpath("//td[contains(text(),'"+Utility.currentdate+"')]"));
		date.click();

	}

	public void enterReferenceNumber(String refNo) {
		wait2.until(ExpectedConditions.visibilityOfElementLocated(referenceNumber));
		driver.findElement(referenceNumber).sendKeys(refNo);
		driver.findElement(referenceNumber).click();
	}
	public void enterSpeciality() throws InterruptedException {
		super.Speciality=prop.getProperty("Speciality");
	//	driver.findElement(Speciality_E).sendKeys(Speciality);
		String v[]=Speciality.split(" ");
		for(String s:v) {
			driver.findElement(Speciality_E).sendKeys(s);
			break;

		}
		Thread.sleep(2000);
	//	driver.findElement(Speciality_E).sendKeys(Keys.ARROW_RIGHT);
		driver.findElement(Speciality_E).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		driver.findElement(Speciality_E).sendKeys(Keys.ENTER);
	

	}
	public void enterFirstName(String fName) throws InterruptedException {
		Thread.sleep(2000);
		wait2.until(ExpectedConditions.elementToBeClickable(firstName));
		driver.findElement(firstName).sendKeys(fName);
	}
	public void enterLastName(String lName) {
		wait2.until(ExpectedConditions.elementToBeClickable(Lastname));
		driver.findElement(Lastname).sendKeys(lName);

	}
	public void enterPhoneOrEmail(String phone_Email ) {
		wait2.until(ExpectedConditions.visibilityOfElementLocated(phone));
		driver.findElement(phone).sendKeys(phone_Email);

	}
	public void enterAmount(String Amount) {
		wait2.until(ExpectedConditions.visibilityOfElementLocated(amount));
		driver.findElement(amount).sendKeys(Amount);
	}
	public void submitButton() throws InterruptedException {
		Thread.sleep(3000);
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
		wait2.until(ExpectedConditions.visibilityOfElementLocated(SubmitFormbtn));
		driver.findElement(SubmitFormbtn).click();

	}


}
