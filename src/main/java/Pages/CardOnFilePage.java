package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import TestBase.BaseClass;
import utility.Utility;

public class CardOnFilePage extends BaseClass{

	public CardOnFilePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	By Home_Menu_E=By.xpath("//li[@id='btnhome']");
	By CardOnFile_Menu_E=By.xpath("//a[@id='card-on-file-tab']");
	By Date_Of_Visit_E=By.xpath("//input[@id='date_of_service_ex']");
	By Patient_Ref_No_E=By.xpath("//input[@id='p_ref_no_ex']");
	By Patient_Name_E=By.xpath("//input[@id='patient_name_ex']");
	By Mobile_Phone_E=By.xpath("//input[@id='mo_ph_ex']");
	By Email_E=By.xpath("//input[@id='email_rec_ex']");
	By Speciality_E=By.xpath("//input[@id='liquidspeciality_ex']");
	By Amount_E=By.xpath("//input[@id='amount']");
	By Proceed_With_CardOnFile_No_E=By.xpath("//input[@id='card_av_no']");
	By Proceed_With_CardOnFile_Yes_E=By.xpath("//input[@id='card_av_ex']");
	By Card_Entry_Patient_E=By.xpath("//input[@id='card_entry_one']");
	By Card_Entry_Provider_E=By.xpath("//input[@id='card_entry_two']");
	By cardDropdown_E=By.xpath("//select[@id='saved_cards_ex']");
	By Submit_Btn_E=By.xpath("//input[@id='btnGet']");
	By Clear_Btn_E=By.xpath("//input[@id='ClearFormBtn']");
	By cardInfoPage=By.xpath("//body/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]");

	public Boolean CardOnFile() {

		wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Date_Of_Visit_E));
		Boolean CardOnFile=driver.findElement(Date_Of_Visit_E).isDisplayed();
		return CardOnFile;

	}
	public Boolean selectPaymentType() {
		wait2.until(ExpectedConditions.visibilityOfElementLocated(Home_Menu_E));
		driver.findElement(Home_Menu_E).click();
		wait2.until(ExpectedConditions.visibilityOfElementLocated(CardOnFile_Menu_E));
		driver.findElement(CardOnFile_Menu_E).click();
		Boolean COF=driver.findElement(CardOnFile_Menu_E).isEnabled();
		return COF;

	}
	public void enterDateOfVisit() {
		wait2.until(ExpectedConditions.visibilityOfElementLocated(Date_Of_Visit_E));
		driver.findElement(Date_Of_Visit_E).click();
		Utility.getCurrentDate();
		WebElement date=driver.findElement(By.xpath("//td[contains(text(),'"+Utility.currentdate+"')]"));
		date.click();

	}

	public void enterReferenceNumber(String refNo) {
		wait2.until(ExpectedConditions.visibilityOfElementLocated(Patient_Ref_No_E));
		driver.findElement(Patient_Ref_No_E).sendKeys(refNo);
		driver.findElement(Patient_Ref_No_E).click();

	}
	public void selectSpeciality() {

	}
	public void enterPatientName(String fName) throws InterruptedException {
		Thread.sleep(2000);
		wait2.until(ExpectedConditions.elementToBeClickable(Patient_Name_E));
		driver.findElement(Patient_Name_E).sendKeys(fName);
		Thread.sleep(2000);
	}

	public void enterPhone(String phone) throws InterruptedException {

	//	wait2.until(ExpectedConditions.visibilityOfElementLocated(Mobile_Phone_E));
		wait2.until(ExpectedConditions.elementToBeClickable(Mobile_Phone_E));
		driver.findElement(Mobile_Phone_E).sendKeys(phone);
		Thread.sleep(2000);

	}
	public void enterEmail(String email) {
		wait2.until(ExpectedConditions.visibilityOfElementLocated(Email_E));
		driver.findElement(Email_E).sendKeys(email);

	}
	public void enterAmount(String Amount) throws InterruptedException {
		Thread.sleep(2000);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(Amount_E));
		driver.findElement(Amount_E).sendKeys(Amount);
	}
	public void submitButton() throws InterruptedException {
		Thread.sleep(3000);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(Submit_Btn_E));
		driver.findElement(Submit_Btn_E).click();

	}

	public void enterSpeciality(String speciality) {
		wait2.until(ExpectedConditions.visibilityOfElementLocated(Speciality_E));
		driver.findElement(Speciality_E).sendKeys(speciality);
		driver.findElement(Speciality_E).sendKeys(Keys.ENTER);

	}

	public void ProceedWithCardonFileYes() throws InterruptedException {
		By cardYes=By.xpath("//input[@id='card_av_ex']//following-sibling::label");
		wait2.until(ExpectedConditions.visibilityOfElementLocated(cardYes));
		Boolean cardOnFile_Yes=driver.findElement(cardYes).isEnabled();
		driver.findElement(cardYes).click();

	}

	public Boolean ProceedWithCardEntryByPatient() throws InterruptedException {
		By patient=By.xpath("//input[@id='card_entry_one']/following-sibling::label");

		wait2.until(ExpectedConditions.visibilityOfElementLocated(patient));
		Boolean cardOnFile_No=driver.findElement(patient).isEnabled();
		driver.findElement(patient).click();

		Boolean cardEntryPatient=driver.findElement(Card_Entry_Patient_E).isSelected();
		return cardEntryPatient;


	}
	public Boolean ProceedWithCardEntryByProvider() throws InterruptedException {
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView();",driver.findElement(Proceed_With_CardOnFile_No_E));

	    By provider=By.xpath("//input[@id='card_entry_two']/following-sibling::label[1]");
		wait2.until(ExpectedConditions.elementToBeClickable(provider));
	//	wait2.until(ExpectedConditions.visibilityOfElementLocated(Card_Entry_Provider_E));
		driver.findElement(provider).click();

		Boolean cardEntryProvider=driver.findElement(Card_Entry_Provider_E).isSelected();
		return cardEntryProvider;

	}

	public void selectCard(String cardNumber) throws InterruptedException {
		 
		String Four_digit_Card=cardNumber.substring(cardNumber.length()-4);
		String last_4_digit_card="xxxxxxxx"+Four_digit_Card;

		System.out.println("last_4_digit_card "+last_4_digit_card);

		try {
			Thread.sleep(2000);
			wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cardDropdown_E));
			driver.findElement(cardDropdown_E).click();
			Select cardDropDown=new Select(driver.findElement(cardDropdown_E));
			cardDropDown.selectByVisibleText(last_4_digit_card);

		}catch(Exception e) {

		}
		

	}
	public Boolean collectCardDetailsForm() {
		WebElement cardPage=wait2.until(ExpectedConditions.visibilityOfElementLocated(cardInfoPage));
		Boolean cardPageDisplay=cardPage.isDisplayed();
		return cardPageDisplay;

	}


}
