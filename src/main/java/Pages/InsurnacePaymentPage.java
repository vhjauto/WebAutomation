package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

import TestBase.BaseClass;
import utility.Utility;

public class InsurnacePaymentPage extends BaseClass{

	JavascriptExecutor jse;
	String gateway;

	public InsurnacePaymentPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	By Insurance_Menu_E=By.xpath("//a[@id='insurance-payment-tab']");

	By Include_PatientInfo_Label_E=By.xpath("//input[@id='insureance_patient_inc']/following-sibling::label");

	By Include_PatientInfo_CheckBox_E=By.xpath("//input[@id='insureance_patient_inc']");

	By InsuranceCompany_E=By.xpath("//input[@id='company_name']");

	By Amount_E=By.xpath("//input[@id='insurance_top_amt']");

	By Submit_Btn_E=By.xpath("//input[@id='btnGet']");

	By Home_Menu_E=By.xpath("//li[@id='btnhome']");

	By cardInfoPage=By.xpath("//body/div[9]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");



	public Boolean selectPaymentType() {
		wait2.until(ExpectedConditions.visibilityOfElementLocated(Home_Menu_E));
		driver.findElement(Home_Menu_E).click();
		wait2.until(ExpectedConditions.visibilityOfElementLocated(Insurance_Menu_E));
		driver.findElement(Insurance_Menu_E).click();
		Boolean COF=driver.findElement(Insurance_Menu_E).isEnabled();
		return COF;

	}
	public void enterInsuranceCompanyName(String InsuranceName) throws InterruptedException {
		Thread.sleep(2000);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(InsuranceCompany_E));
		driver.findElement(InsuranceCompany_E).sendKeys(InsuranceName);
	}

	public void uncheckPatientInfoCheckBox() {
		wait2.until(ExpectedConditions.visibilityOfElementLocated(Include_PatientInfo_Label_E));
		wait2.until(ExpectedConditions.elementToBeClickable(Include_PatientInfo_Label_E));
	//	wait2.until(ExpectedConditions.visibilityOfElementLocated(Card_Entry_Provider_E));
		driver.findElement(Include_PatientInfo_Label_E).click();

		Boolean cardEntryProvider=driver.findElement(Include_PatientInfo_CheckBox_E).isSelected();
	}
	public void checkPatientInfoCheckBox() throws InterruptedException {
		Thread.sleep(2000);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(Include_PatientInfo_Label_E));
		wait2.until(ExpectedConditions.elementToBeClickable(Include_PatientInfo_Label_E));
	//	wait2.until(ExpectedConditions.visibilityOfElementLocated(Card_Entry_Provider_E));
		Boolean cardEntryProvider=driver.findElement(Include_PatientInfo_CheckBox_E).isSelected();
		if(!cardEntryProvider) {
			driver.findElement(Include_PatientInfo_Label_E).click();
		}
		else {
			System.out.println("Check box is selected");
		}


	}



	public void addRowsforMultiPatients(String totalPatients,String Gateway) throws InterruptedException {

		gateway=Gateway.toLowerCase();
		int totalpatient=Integer.parseInt(totalPatients);
		Thread.sleep(2000);
		if(totalpatient>1) {

			for(int i=1;i<totalpatient;i++) {
				By Add_Row_E;

				if(gateway.contains("rapid")){


					Add_Row_E=By.xpath("//div[@id='InsurancePaymentArea']/div[2]/div/div/div["+i+"]/div/div/div[2]/img[1]");
					wait2.until(ExpectedConditions.visibilityOfElementLocated(Add_Row_E));
					driver.findElement(Add_Row_E).click();
				}
				else {

					Add_Row_E=By.xpath("//div[@id='InsurancePaymentArea']/div[2]/div[1]/div["+i+"]/div/div/div/img[1]");
					wait2.until(ExpectedConditions.visibilityOfElementLocated(Add_Row_E));
					driver.findElement(Add_Row_E).click();
				}


			}

		}

		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());


	}
	public void enterPatientRefNumber(String refNo,int RowNo) throws InterruptedException {

		Thread.sleep(2000);
		By PatientRefNo_E;
		if(gateway.contains("rapid")) {
			PatientRefNo_E=By.xpath("//div[@id='InsurancePaymentArea']/div[2]/div[1]/div[1]/div["+RowNo+"]/div/div/div/div[1]/div[1]/input[1]");

		}
		else {

			PatientRefNo_E=By.xpath("//div[@id='InsurancePaymentArea']/child::div[2]/child::div/child::div["+RowNo+"]/child::div/child::div/child::div/child::div/div/input[@name='patientRef[]']");
		}
		jse = (JavascriptExecutor)driver;
		wait2.until(ExpectedConditions.visibilityOfElementLocated(PatientRefNo_E));
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(PatientRefNo_E) );
		driver.findElement(PatientRefNo_E).sendKeys(refNo);


	}
	public void enterFirstName(String fname,int RowNo ) throws InterruptedException {

		By FirstName_E;
		if(gateway.contains("rapid")) {
			FirstName_E=By.xpath("//div[@id='InsurancePaymentArea']/div[2]/div[1]/div[1]/div["+RowNo+"]/div/div/div/div[1]/div[2]/input[1]");

		}
		else {

			FirstName_E=By.xpath("//div[@id='InsurancePaymentArea']/child::div[2]/child::div/child::div["+RowNo+"]/child::div/child::div/child::div/child::div/div[2]/input[@name='ins_first[]']");
		}
		jse = (JavascriptExecutor)driver;
		wait2.until(ExpectedConditions.visibilityOfElementLocated(FirstName_E));
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(FirstName_E) );
		driver.findElement(FirstName_E).sendKeys(fname);



	}
	public void enterLastName(String lname,int RowNo ) throws InterruptedException {
		By LastName_E;
		if(gateway.contains("rapid")) {
			LastName_E=By.xpath("//div[@id='InsurancePaymentArea']/div[2]/div[1]/div[1]/div["+RowNo+"]/div/div/div/div[1]/div[3]/input[1]");

		}
		else {

			LastName_E=By.xpath("//div[@id='InsurancePaymentArea']/child::div[2]/child::div/child::div["+RowNo+"]/child::div/child::div/child::div/child::div/div[3]/input[1]");
		}
		jse = (JavascriptExecutor)driver;
		wait2.until(ExpectedConditions.visibilityOfElementLocated(LastName_E));
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(LastName_E) );
		driver.findElement(LastName_E).sendKeys(lname);

	}

	public void enterMultiPatientAmount(String amount,int RowNo) throws InterruptedException {
		By patient_Amount_E;
		if(gateway.contains("rapid")) {
			patient_Amount_E=By.xpath("//div[@id='InsurancePaymentArea']/div[2]/div[1]/div[1]/div["+RowNo+"]/div/div/div/div[1]/div[5]/input[1]");

		}
		else {

			patient_Amount_E=By.xpath("//div[@id='InsurancePaymentArea']/child::div[2]/child::div/child::div["+RowNo+"]/child::div/child::div/child::div/child::div/div[5]/input");
		}
		jse = (JavascriptExecutor)driver;
		wait2.until(ExpectedConditions.visibilityOfElementLocated(patient_Amount_E));
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(patient_Amount_E) );
		driver.findElement(patient_Amount_E).sendKeys(amount);

	}
	public void enterMultiPatientPhoneEmail(String phoneEmail,int RowNo) throws InterruptedException {

		By phone_Email_E;
		if(gateway.contains("rapid")) {
			phone_Email_E=By.xpath("//div[@id='InsurancePaymentArea']/div[2]/div[1]/div[1]/div["+RowNo+"]/div/div/div/div[1]/div[4]/input[1]");

		}
		else {

			phone_Email_E=By.xpath("//div[@id='InsurancePaymentArea']/child::div[2]/child::div/child::div["+RowNo+"]/child::div/child::div/child::div/child::div/div[4]/input");
		}
		jse = (JavascriptExecutor)driver;
		wait2.until(ExpectedConditions.visibilityOfElementLocated(phone_Email_E));
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(phone_Email_E) );
		driver.findElement(phone_Email_E).sendKeys(phoneEmail);


	}
	public void enterMultiPatientSpeciality(String speciality,int RowNo) {
	/*	By Speiciality_E=By.xpath("//div[@id='InsurancePaymentArea']/child::div[2]/child::div/child::div["+RowNo+"]/child::div/child::div/child::div/child::div/div/input[@name='patient_amt[]']");
		wait2.until(ExpectedConditions.visibilityOfElementLocated(Speiciality_E));
		driver.findElement(Speiciality_E).sendKeys(speciality);
	*/
	}


	public void enterAmount(String Amount) throws InterruptedException {
		Thread.sleep(2000);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(Amount_E));
		driver.findElement(Amount_E).sendKeys(Amount);
	}
	public void submitButton() throws InterruptedException {
		Thread.sleep(3000);
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(Submit_Btn_E) );
		wait2.until(ExpectedConditions.visibilityOfElementLocated(Submit_Btn_E));
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
		driver.findElement(Submit_Btn_E).click();

	}


	public Boolean collectCardDetailsForm() {
		return true;
	/*	WebElement cardPage=wait2.until(ExpectedConditions.visibilityOfElementLocated(cardInfoPage));
		Boolean cardPageDisplay=cardPage.isDisplayed();
		return cardPageDisplay;
*/
	}



}
