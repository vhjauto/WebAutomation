package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import TestBase.BaseClass;
import utility.Utility;

public class PatientCardEntryPage extends BaseClass {

	Properties prop;
	FileInputStream ip;

	By accountHolderName=By.xpath("//input[@id='CardHolderName']");

	By Contctless_Printreceipt=By.xpath("//h4[contains(text(),'Payment Receipt')]");
	
	By Cof_PrintReceipt=By.xpath("//h2[contains(text(),'Payment Receipt')]");
								
	By ZipCode_patientEntry_Locator=By.xpath("//input[@name='lp_zipcode']");
	By ZipCode_COF_CA_E=By.xpath("//input[@id='AvsZipCode']");
	String gatewayName;

	public PatientCardEntryPage() throws IOException {
		super();


		// TODO Auto-generated constructor stub
	}
	public void enterCardNumber(String CardType,String gateway ) throws IOException, InterruptedException {
		gatewayName=gateway.toLowerCase();

		if(gatewayName.contains("heartland")) {
			prop=new Properties();
			ip=new FileInputStream("src/test/resources/locators/Heartland.properties");
			prop.load(ip);
			Thread.sleep(4000);
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			By cardNumber=By.xpath(prop.getProperty("CardNumber_locator"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumber));
			if(CardType.contains("Visa") || CardType.equalsIgnoreCase("VisaCard")) {
				String cardNo=prop.getProperty("VisaCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			else if(CardType.contains("Amex") || CardType.equalsIgnoreCase("AmexCard")) {
				String cardNo=prop.getProperty("AmexCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			else if(CardType.contains("Master") || CardType.equalsIgnoreCase("MasterCard")) {
				String cardNo=prop.getProperty("MasterCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			driver.switchTo().defaultContent();


		}
		else if(gatewayName.contains("elavon")) {
			prop=new Properties();
			ip=new FileInputStream("src/test/resources/locators/Elavon.properties");
			prop.load(ip);
			Thread.sleep(3000);
			By cardNumber=By.xpath(prop.getProperty("cardNumber_patientEntry_Locator"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumber));
			if(CardType.contains("Visa") || CardType.equalsIgnoreCase("Visa")) {
				String cardNo=prop.getProperty("VisaCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			else if(CardType.contains("Amex") || CardType.equalsIgnoreCase("AmexCard")) {
				String cardNo=prop.getProperty("AmexCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			else if(CardType.contains("Master") || CardType.equalsIgnoreCase("MasterCard")) {
				String cardNo=prop.getProperty("MasterCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			driver.findElement(cardNumber).sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		}
		else if(gatewayName.contains("tsys")) {
			prop=new Properties();
			ip=new FileInputStream("src/test/resources/locators/Tsys.properties");
			prop.load(ip);
			Thread.sleep(3000);
			By cardNumber=By.xpath(prop.getProperty("Patient_Entry_CardNumber_L"));
			WebElement cardNum = wait3.until(ExpectedConditions.elementToBeClickable(cardNumber));
				((JavascriptExecutor) driver).executeScript(
				    "arguments[0].scrollIntoView(true);",
				    cardNum);

		//	wait3.until(ExpectedConditions.visibilityOfElementLocated(cardNumber));

			if(CardType.contains("Visa") || CardType.equalsIgnoreCase("visacard")) {
				String card=prop.getProperty("VisaCard");
				String[] card1=card.split(" ");
				for(String cardNo:card1) {
					driver.findElement(cardNumber).sendKeys(cardNo);
					driver.findElement(cardNumber).click();

				}


			}
			else if(CardType.contains("Amex") || CardType.equalsIgnoreCase("amexcard") ) {
				String card=prop.getProperty("AmexCard");
				String[] card1=card.split(" ");
				for(String cardNo:card1) {
					driver.findElement(cardNumber).sendKeys(cardNo);
					driver.findElement(cardNumber).click();

				}

			}
			else if(CardType.contains("Master") || CardType.equalsIgnoreCase("MasterCard") || CardType.contains("master")) {
				String card=prop.getProperty("MasterCard");
				String[] card1=card.split(" ");
				for(String cardNo:card1) {
					driver.findElement(cardNumber).sendKeys(cardNo);
					driver.findElement(cardNumber).click();

				}

			}
			Thread.sleep(3000);

		}
		else if(gatewayName.contains("rapid")) {
			prop=new Properties();
			ip=new FileInputStream("src/test/resources/locators/Rapid.properties");
			prop.load(ip);
			By cardNumber=By.xpath(prop.getProperty("cardNumber_patientEntry_Locator"));
			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumber));
			if(CardType.contains("Visa") || CardType.equalsIgnoreCase("Visa")) {
				String cardNo=prop.getProperty("VisaCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			else if(CardType.contains("Amex") || CardType.equalsIgnoreCase("AmexCard")) {
				String cardNo=prop.getProperty("AmexCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			else if(CardType.contains("Master") || CardType.equalsIgnoreCase("MasterCard")) {
				String cardNo=prop.getProperty("MasterCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			Thread.sleep(2000);

		}
		else if(gatewayName.contains("cardpoint")) {
			prop=new Properties();
			ip=new FileInputStream("src/test/resources/locators/CardPointe.properties");
			prop.load(ip);
			By cardNumber=By.xpath(prop.getProperty("cardNumber_Locator"));
			Thread.sleep(4000);
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumber));

			if(CardType.contains("Visa") || CardType.equalsIgnoreCase("VisaCard")) {
				String cardNo=prop.getProperty("VisaCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			else if(CardType.contains("Amex") || CardType.equalsIgnoreCase("AmexCard")) {
				String cardNo=prop.getProperty("AmexCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			else if(CardType.contains("Master") || CardType.equalsIgnoreCase("MasterCard")) {
				String cardNo=prop.getProperty("MasterCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			driver.switchTo().defaultContent();

		}
		else if(gatewayName.contains("stripe")) {
			prop=new Properties();
			ip=new FileInputStream("src/test/resources/locators/Stripe.properties");
			prop.load(ip);
			Thread.sleep(3000);
			By cardNumber=By.xpath(prop.getProperty("cardNumber_patientEntry_Locator"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumber));
			driver.findElement(cardNumber).sendKeys("123");
			driver.findElement(cardNumber).clear();
			if(CardType.contains("Visa") || CardType.equalsIgnoreCase("Visa")) {
				String cardNo=prop.getProperty("VisaCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			else if(CardType.contains("Amex") || CardType.equalsIgnoreCase("AmexCard")) {
				String cardNo=prop.getProperty("AmexCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			else if(CardType.contains("Master") || CardType.equalsIgnoreCase("MasterCard")) {
				String cardNo=prop.getProperty("MasterCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			driver.findElement(cardNumber).sendKeys(Keys.ENTER);
			Thread.sleep(3000);


		}
		else if(gatewayName.equalsIgnoreCase("fortis")) {
			ip=new FileInputStream("src/test/resources/locators/Fortis.properties");
			prop.load(ip);

		}


	}
	public void enterCardExpiry(String gateway,String ExpMonth,String ExpYear) throws InterruptedException {
		this.gatewayName=gateway.toLowerCase();
		
		if(gatewayName.contains("heartland")) {
			By cardEXP=By.xpath(prop.getProperty("Exp_locator"));
			System.out.println("In expiry mothod1");
			Thread.sleep(2000);
			driver.switchTo().frame("card-expiration");

			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardEXP));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			String expDate=prop.getProperty("ExpDate");
			jse.executeScript("arguments[0].value='"+expDate+"';", driver.findElement(cardEXP));
			driver.findElement(cardEXP).sendKeys(Keys.ENTER);
			Thread.sleep(1500);
			driver.switchTo().defaultContent();

		}
		else if(gatewayName.contains("elavon")) {
			By cardEXPMonth=By.xpath(prop.getProperty("ExpMonth_patientEntry_Locator"));
			By cardEXPYear=By.xpath(prop.getProperty("ExpYear_patientEntry_Locator"));
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardEXPMonth));
			Thread.sleep(2000);
			Select monthdropdown=new Select(driver.findElement(cardEXPMonth));
			monthdropdown.selectByVisibleText(ExpMonth);
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardEXPYear));
			Select yeardropdown=new Select(driver.findElement(cardEXPYear));
			yeardropdown.selectByVisibleText(ExpYear);

		}
		else if(gatewayName.contains("tsys")) {
			By cardEXP=By.xpath(prop.getProperty("Exp_locator"));
			
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardEXP));
			wait3.until(ExpectedConditions.elementToBeClickable(cardEXP));

			JavascriptExecutor jse = (JavascriptExecutor)driver;
			String expDate=prop.getProperty("ExpDate");
		//	driver.findElement(cardEXP).sendKeys(expDate);
			jse.executeScript("arguments[0].value='"+expDate+"';", driver.findElement(cardEXP));
			
			driver.findElement(cardEXP).click();

		}
		else if(gatewayName.contains("rapid")) {
			By cardEXPMonth=By.xpath(prop.getProperty("ExpMonth_patientEntry_Locator"));
			By cardEXPYear=By.xpath(prop.getProperty("ExpYear_patientEntry_Locator"));
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardEXPMonth));
			wait3.until(ExpectedConditions.elementToBeClickable(cardEXPMonth));
			Select monthdropdown=new Select(driver.findElement(cardEXPMonth));
			monthdropdown.selectByVisibleText(ExpMonth);
			Thread.sleep(1000);
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardEXPYear));
			Select yeardropdown=new Select(driver.findElement(cardEXPYear));
			yeardropdown.selectByVisibleText(ExpYear);
			Thread.sleep(1000);

		}
		else if(gatewayName.contains("cardpoint")) {

			By cardEXPMonth=By.xpath(prop.getProperty("ExpMonth_patientEntry_Locator"));
			By cardEXPYear=By.xpath(prop.getProperty("ExpYear_patientEntry_Locator"));
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardEXPMonth));
			wait3.until(ExpectedConditions.elementToBeClickable(cardEXPMonth));
			Select monthdropdown=new Select(driver.findElement(cardEXPMonth));
			monthdropdown.selectByVisibleText(ExpMonth);
			Thread.sleep(2000);
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardEXPYear));
			Select yeardropdown=new Select(driver.findElement(cardEXPYear));
			yeardropdown.selectByVisibleText(ExpYear);
			Thread.sleep(2000);


		}
		else if(gatewayName.contains("stripe")) {
			By cardEXPMonth=By.xpath(prop.getProperty("ExpMonth_patientEntry_Locator"));
			By cardEXPYear=By.xpath(prop.getProperty("ExpYear_patientEntry_Locator"));
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardEXPMonth));
			wait3.until(ExpectedConditions.elementToBeClickable(cardEXPMonth));
			Select monthdropdown=new Select(driver.findElement(cardEXPMonth));
			monthdropdown.selectByVisibleText(ExpMonth);
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardEXPYear));
			Select yeardropdown=new Select(driver.findElement(cardEXPYear));
			yeardropdown.selectByVisibleText(ExpYear);

		}


	}
	public void enterCardCVV(String gateway, String cardType) throws InterruptedException {
		this.gatewayName=gateway.toLowerCase();
		

		if(gatewayName.contains("heartland")) {
			By cardCVV=By.xpath(prop.getProperty("CardCVV_locator"));
			driver.switchTo().frame("card-cvv");

			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardCVV));
			wait3.until(ExpectedConditions.elementToBeClickable(cardCVV));
			if(cardType.contains("Amex")|| cardType.contains("amex")) {
				String cVV=prop.getProperty("AmexCvv");
				driver.findElement(cardCVV).sendKeys(cVV);
				Thread.sleep(2000);

			}
			else {

				String cVV=prop.getProperty("Cvv");
				driver.findElement(cardCVV).sendKeys(cVV);
				Thread.sleep(2000);

			}
			driver.switchTo().defaultContent();

		}
		else if(gatewayName.contains("elavon")) {
			By cardCvv=By.xpath(prop.getProperty("CardCvv_patientEntry_Locator"));
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardCvv));
			wait3.until(ExpectedConditions.elementToBeClickable(cardCvv));
			if(cardType.contains("Amex")|| cardType.contains("amex")) {
				driver.findElement(cardCvv).sendKeys(prop.getProperty("AmexCVV"));
			}
			else {
				driver.findElement(cardCvv).sendKeys(prop.getProperty("Cvv"));
			}



		}
		else if(gatewayName.contains("tsys")){

			By cardCvv=By.xpath(prop.getProperty("CardCVV_locator"));
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardCvv));
			wait3.until(ExpectedConditions.elementToBeClickable(cardCvv));
			

			if(cardType.contains("Amex")|| cardType.contains("amex")) {
				String cVV=prop.getProperty("AmexCVV");
				driver.findElement(cardCvv).sendKeys(cVV);
				driver.findElement(cardCvv).sendKeys(Keys.ENTER);
				Thread.sleep(3000);

			}
			else if(cardType.contains("Visa")|| cardType.contains("visa")){
				String cVV=prop.getProperty("VisaCvv");
				driver.findElement(cardCvv).sendKeys(cVV);
				driver.findElement(cardCvv).sendKeys(Keys.ENTER);
				Thread.sleep(4000);

			}
			else {
				String cVV=prop.getProperty("MasterCvv");
				driver.findElement(cardCvv).sendKeys(cVV);
				driver.findElement(cardCvv).sendKeys(Keys.ENTER);
				Thread.sleep(4000);


			}



		}
		else if(gatewayName.contains("rapid")){
			By cardCvv=By.xpath(prop.getProperty("CardCvv_patientEntry_Locator"));
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardCvv));
			wait3.until(ExpectedConditions.elementToBeClickable(cardCvv));
			if(cardType.contains("Amex")|| cardType.contains("amex")) {
				driver.findElement(cardCvv).sendKeys(prop.getProperty("AmexCVV"));
			}
			else {
				driver.findElement(cardCvv).sendKeys(prop.getProperty("Cvv"));
			}


		}
		else if(gatewayName.contains("cardpoint")) {
			By cardCvv=By.xpath(prop.getProperty("CardCvv_patientEntry_Locator"));
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardCvv));
			wait3.until(ExpectedConditions.elementToBeClickable(cardCvv));
			if(cardType.contains("Amex")|| cardType.contains("amex")) {
				driver.findElement(cardCvv).sendKeys(prop.getProperty("AmexCVV"));
			}
			else {
				driver.findElement(cardCvv).sendKeys(prop.getProperty("Cvv"));
			}

		}
		else if(gatewayName.contains("stripe")) {
			By cardCvv=By.xpath(prop.getProperty("CardCvv_patientEntry_Locator"));
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardCvv));
			wait3.until(ExpectedConditions.elementToBeClickable(cardCvv));
			if(cardType.contains("Amex")|| cardType.contains("amex")) {
				driver.findElement(cardCvv).sendKeys(prop.getProperty("AmexCVV"));
			}
			else {
				driver.findElement(cardCvv).sendKeys(prop.getProperty("Cvv"));
			}

		}


	}
	public void enterZipCode(String zipCode,String payment) {
		String paymentType=payment.toLowerCase();
		
		if(paymentType.contains("cof")) {
			wait3.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ZipCode_COF_CA_E));
			driver.findElement(ZipCode_COF_CA_E).sendKeys(zipCode);
			
		}else if(paymentType.contains("contactless")){
			wait3.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ZipCode_patientEntry_Locator));
			driver.findElement(ZipCode_patientEntry_Locator).sendKeys(zipCode);
			
		}
		else {
			
			wait3.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ZipCode_patientEntry_Locator));
			driver.findElement(ZipCode_patientEntry_Locator).sendKeys(zipCode);
		}
			
			

			
	}

	public void submitCardDetailsForm(String gateway,String payment) throws InterruptedException {
		this.gatewayName=gateway.toLowerCase();
		String paymentType=payment.toLowerCase();
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());

		if(gatewayName.contains("heartland") ) {
			driver.switchTo().frame("submit");
			By confirm=By.xpath(prop.getProperty("Confirmbtn_locator"));
			wait3.until(ExpectedConditions.visibilityOfElementLocated(confirm));
			driver.findElement(confirm).click();
			Thread.sleep(5000);
			driver.switchTo().defaultContent();


		}
		else if(gatewayName.contains("elavon")) {
			By payNow_locator;
			if(paymentType.contains("cof")) {
				payNow_locator=By.xpath(prop.getProperty("PayNowBtn_COFPatientEntry_Locator"));
				
			}else {
				payNow_locator=By.xpath(prop.getProperty("PayNowBtn_PatientEntry_Locator"));
			}
			wait3.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(payNow_locator));
			Thread.sleep(5000);
			driver.findElement(payNow_locator).click();
			Thread.sleep(2000);


		}
		else if(gatewayName.contains("tsys")) {
			By payNow_locator;
			if(paymentType.contains("cof")) {
				payNow_locator=By.xpath(prop.getProperty("PayNowBtn_COFPatientEntry_Locator"));
				
			}else {
				payNow_locator=By.xpath(prop.getProperty("PayNowBtn_PatientEntry_Locator"));
			}
			wait3.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(payNow_locator));
			Thread.sleep(5000);
			driver.findElement(payNow_locator).click();
			Thread.sleep(2000);

		}
		else if(gatewayName.contains("rapid")) {
			By payNow_locator;
			if(paymentType.contains("cof")) {
				payNow_locator=By.xpath(prop.getProperty("PayNowBtn_COFPatientEntry_Locator"));
				
			}else {
				payNow_locator=By.xpath(prop.getProperty("PayNowBtn_PatientEntry_Locator"));
			}
			wait3.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(payNow_locator));
			Thread.sleep(5000);
			driver.findElement(payNow_locator).click();
			Thread.sleep(2000);

		}
		else if(gatewayName.contains("cardpoint")) {
			By payNow_locator;
			if(paymentType.contains("cof")) {
				payNow_locator=By.xpath(prop.getProperty("PayNowBtn_COFPatientEntry_Locator"));
				
			}else {
				payNow_locator=By.xpath(prop.getProperty("PayNowBtn_PatientEntry_Locator"));
			}
			wait3.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(payNow_locator));
			Thread.sleep(5000);
			driver.findElement(payNow_locator).click();
			Thread.sleep(2000);

		}
		else if(gatewayName.contains("stripe")) {
			By payNow_locator;
			if(paymentType.contains("cof")) {
				payNow_locator=By.xpath(prop.getProperty("PayNowBtn_COFPatientEntry_Locator"));
				
			}else {
				payNow_locator=By.xpath(prop.getProperty("PayNowBtn_PatientEntry_Locator"));
			}
			wait3.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(payNow_locator));
			Thread.sleep(5000);
			driver.findElement(payNow_locator).click();
			Thread.sleep(2000);

		}

	}
	public Boolean verifySpecialityInCollectCard(String Speciality) {		
		By speciality=By.xpath("//p[contains(text(),'"+Speciality+"')]");		
		wait2.until(ExpectedConditions.visibilityOfElementLocated(speciality));
		return driver.findElement(speciality).isDisplayed();

	}
	public void verifyPaymentAmountInCollectCard(String amount) {


	}
	public void enterAccountHolderName(String AccountHolderName) {
		driver.findElement(accountHolderName).sendKeys(AccountHolderName);

	}
	public Boolean verifyTransactionStatus(String pType) throws InterruptedException {
		Boolean TransactionStatus = null;	
		/*
		String PaymentType=pType.toLowerCase();
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
			
		if(PaymentType.contains("contactless")) {
			Thread.sleep(4000);			
			wait2.until(ExpectedConditions.visibilityOfElementLocated(Contctless_Printreceipt));
			TransactionStatus=driver.findElement(Contctless_Printreceipt).isDisplayed();			
			
		}
		else {
			Thread.sleep(4000);
			wait2.until(ExpectedConditions.visibilityOfElementLocated(Cof_PrintReceipt));
			TransactionStatus=driver.findElement(Cof_PrintReceipt).isDisplayed();
			
		}
		
		
	*/
		return TransactionStatus;
	}
}
