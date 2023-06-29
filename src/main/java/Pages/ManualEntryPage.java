package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import TestBase.BaseClass;
import utility.Utility;


public class ManualEntryPage extends BaseClass {

	public String TransactionID;
	public String Ref_NO;
	public String PatientName;
	public String Amount;
	public String Last_4_digits_CardNumber;
	public String Phone_Email;

	public Boolean printReceiptbutton;
	Actions act ;

	By ManualEntry_Radiobtn=By.xpath("//a[@id='manual-entry-tab']");

	By VerifyCard_Checkbox_E=By.xpath("//input[@id='manual-entry-amt']/following-sibling::label");

	By dateofVisit=By.xpath("//input[@id='liquiddateofvisit']");

	By referenceNumber=By.xpath("//input[@name='liquidaccountnumber[]']");

	By speciality=By.name("liquidspecialist[]");

	By firstName=By.name("liquidfirst[]");

	By Lastname=By.name("liquidlast[]");

	By phone=By.name("liquidprocphone[]");

	By amount=By.name("liquidprocamt[]");

	By SubmitFormbtn=By.xpath("//input[@id='btnGet']");

	By ClearFormbtn=By.xpath("//input[@id='ClearFormBtn']");

	By Cancelbtn=By.xpath("//body/div[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/button[2]");

	By zipCode=By.name("ZipCode");

	By Home=By.xpath("//a[contains(text(),'Home')]");

	By cardInfoPage=By.xpath("//label[contains(text(),'CREDIT/DEBIT CARD NUMBER')]");
	By Speciality_E=By.name("liquidspecialist[]");

	public ManualEntryPage() throws IOException{

		PageFactory.initElements(driver,this);

	}

	public Boolean ManualEntryForm() {

		wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dateofVisit));
		Boolean manualEntry=driver.findElement(dateofVisit).isDisplayed();

		return manualEntry;

	}
	public Boolean selectPaymentType() {
		wait2.until(ExpectedConditions.visibilityOfElementLocated(Home));
		driver.findElement(Home).click();
		wait2.until(ExpectedConditions.visibilityOfElementLocated(ManualEntry_Radiobtn));
		driver.findElement(ManualEntry_Radiobtn).click();
		Boolean ME=driver.findElement(ManualEntry_Radiobtn).isEnabled();
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
		return ME;

	}
	public Boolean selectVerifyCardOption() {
		wait2.until(ExpectedConditions.visibilityOfElementLocated(VerifyCard_Checkbox_E));
		driver.findElement(VerifyCard_Checkbox_E).click();
		Boolean verifyCardSelected=driver.findElement(By.xpath("//input[@id='manual-entry-amt']")).isSelected();
		return verifyCardSelected;

	}
	public void enterDateOfVisit() {
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
	public void selectSpeciality() {

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

	public Boolean collectCardDetailsForm() {
		WebElement cardPage=wait2.until(ExpectedConditions.visibilityOfElementLocated(cardInfoPage));
		Boolean cardPageDisplay=cardPage.isDisplayed();
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
		return cardPageDisplay;

	}



}
