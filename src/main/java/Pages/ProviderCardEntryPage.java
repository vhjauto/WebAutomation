package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import TestBase.BaseClass;
import utility.Utility;

public class ProviderCardEntryPage extends BaseClass {

	Properties prop;
	FileInputStream ip;


	By zipCode_locator=By.xpath("//input[@id='ZipCode']");
	By confirmBtn_locator=By.xpath("/html[1]/body[1]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/button[2]");
	By address=By.name("StreetAddress");
	By city=By.name("City");
	By state=By.name("State");


	public ProviderCardEntryPage() throws IOException {
		super();

		// TODO Auto-generated constructor stub
	}
	public void enterCardNumber(String CardType,String gatewayName,String paymentType ) throws IOException, InterruptedException {


		if(gatewayName.contains("Heartland")|| gatewayName.contains("heartland") || gatewayName.equalsIgnoreCase("Heartland")) {

			prop=new Properties();
			ip=new FileInputStream("src/test/resources/locators/Heartland.properties");
			prop.load(ip);

			By cardNumber=By.xpath(prop.getProperty("CardNumber_locator"));


			Thread.sleep(4000);
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardNumber));
			if(CardType.contains("Visa") || CardType.equalsIgnoreCase("VisaCard")) {
				super.cardNo=prop.getProperty("VisaCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			else if(CardType.contains("Amex") || CardType.equalsIgnoreCase("AmexCard")) {
				super.cardNo=prop.getProperty("AmexCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			else if(CardType.contains("Master") || CardType.equalsIgnoreCase("MasterCard")) {
				super.cardNo=prop.getProperty("MasterCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
		//	driver.findElement(cardNumber).sendKeys(Keys.TAB);
			driver.switchTo().defaultContent();


		}
		else if(gatewayName.contains("Elavon")|| gatewayName.contains("elavon") || gatewayName.equalsIgnoreCase("Elavon")) {
			prop=new Properties();
			ip=new FileInputStream("src/test/resources/locators/Elavon.properties");
			prop.load(ip);
			By cardNumber;
			String PaymentType=paymentType.toLowerCase();
			if(PaymentType.contains("insurance") ) {
				cardNumber=By.xpath(prop.getProperty("Ins_cardNumber_Locator"));
			}else {
				cardNumber=By.xpath(prop.getProperty("cardNumber_Locator"));
			}

			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardNumber));
			if(CardType.contains("Visa") || CardType.equalsIgnoreCase("Visa")) {
				super.cardNo=prop.getProperty("VisaCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			else if(CardType.contains("Amex") || CardType.equalsIgnoreCase("AmexCard")) {
				super.cardNo=prop.getProperty("AmexCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			else if(CardType.contains("Master") || CardType.equalsIgnoreCase("MasterCard")) {
				super.cardNo=prop.getProperty("MasterCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}

		}
		else if(gatewayName.equalsIgnoreCase("Tsys")|| gatewayName.contains("Tsys") || gatewayName.contains("tsys")) {
			prop=new Properties();
			ip=new FileInputStream("src/test/resources/locators/Tsys.properties");
			prop.load(ip);
			By cardNumber=By.xpath(prop.getProperty("CardNumber_locator"));

			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardNumber));
			if(CardType.contains("Visa") || CardType.equalsIgnoreCase("visacard")) {
				super.cardNo=prop.getProperty("VisaCard");
				driver.findElement(cardNumber).sendKeys(cardNo);

			}
			else if(CardType.contains("Amex") || CardType.equalsIgnoreCase("amexcard") ) {
				super.cardNo=prop.getProperty("AmexCard");
				driver.findElement(cardNumber).sendKeys(cardNo);

			}
			else if(CardType.contains("Master") || CardType.equalsIgnoreCase("MasterCard") || CardType.contains("master")) {
				super.cardNo=prop.getProperty("MasterCard");
				driver.findElement(cardNumber).sendKeys(cardNo);

			}

		}
		else if(gatewayName.equalsIgnoreCase("Rapidconnect") || gatewayName.contains("Rapid") || gatewayName.contains("rapid")) {
			prop=new Properties();
			ip=new FileInputStream("src/test/resources/locators/Rapid.properties");
			prop.load(ip);

			By cardNumber;
			String PaymentType=paymentType.toLowerCase();
			if(PaymentType.contains("insurance") ) {
				cardNumber=By.xpath(prop.getProperty("Ins_cardNumber_Locator"));
			}else {
				cardNumber=By.xpath(prop.getProperty("cardNumber_Locator"));
			}
		//	By cardNumber=By.xpath(prop.getProperty("cardNumber_Locator"));
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardNumber));
			if(CardType.contains("Visa") || CardType.equalsIgnoreCase("Visa")) {
				super.cardNo=prop.getProperty("VisaCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			else if(CardType.contains("Amex") || CardType.equalsIgnoreCase("AmexCard")) {
				super.cardNo=prop.getProperty("AmexCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			else if(CardType.contains("Master") || CardType.equalsIgnoreCase("MasterCard")) {
				super.cardNo=prop.getProperty("MasterCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}

		}
		else if(gatewayName.equalsIgnoreCase("Cardpointe") || gatewayName.contains("cardpointe") || gatewayName.contains("cardp")) {
			prop=new Properties();
			ip=new FileInputStream("src/test/resources/locators/CardPointe.properties");
			prop.load(ip);
			By cardNumber=By.xpath(prop.getProperty("cardNumber_Locator"));
			Thread.sleep(4000);
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumber));
			if(CardType.contains("Visa") || CardType.equalsIgnoreCase("VisaCard")) {
				super.cardNo=prop.getProperty("VisaCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			else if(CardType.contains("Amex") || CardType.equalsIgnoreCase("AmexCard")) {
				super.cardNo=prop.getProperty("AmexCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			else if(CardType.contains("Master") || CardType.equalsIgnoreCase("MasterCard")) {
				super.cardNo=prop.getProperty("MasterCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			driver.switchTo().defaultContent();

		}
		else if(gatewayName.equalsIgnoreCase("Stripe") || gatewayName.contains("Stripe")) {
			prop=new Properties();
			ip=new FileInputStream("src/test/resources/locators/Stripe.properties");
			prop.load(ip);
			By cardNumber=By.xpath(prop.getProperty("cardNumber_Locator"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumber));
			if(CardType.contains("Visa") || CardType.equalsIgnoreCase("Visa")) {
				super.cardNo=prop.getProperty("VisaCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			else if(CardType.contains("Amex") || CardType.equalsIgnoreCase("AmexCard")) {
				super.cardNo=prop.getProperty("AmexCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}
			else if(CardType.contains("Master") || CardType.equalsIgnoreCase("MasterCard")) {
				super.cardNo=prop.getProperty("MasterCard");
				driver.findElement(cardNumber).sendKeys(cardNo);
			}


		}
		else if(gatewayName.equalsIgnoreCase("Fortis")) {
			prop=new Properties();
			ip=new FileInputStream("src/test/resources/locators/Fortis.properties");
			prop.load(ip);

		}



	}
	public void enterCardExpiry(String gatewayName,String ExpMonth,String ExpYear,String paymentType) throws InterruptedException {

		if(gatewayName.contains("Heartland") || gatewayName.contains("heartland")) {
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
		else if(gatewayName.contains("Elavon")|| gatewayName.contains("elavon")) {

			By cardEXPMonth;
			By cardEXPYear;
			String PaymentType=paymentType.toLowerCase();
			if(PaymentType.contains("insurance") ) {
				cardEXPMonth=By.xpath(prop.getProperty("Ins_ExpMonth_locator"));
				cardEXPYear=By.xpath(prop.getProperty("Ins_ExpYear_locator"));


			}else {
				cardEXPMonth=By.xpath(prop.getProperty("ExpMonth_locator"));
				cardEXPYear=By.xpath(prop.getProperty("ExpYear_locator"));
			}


			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardEXPMonth));
			driver.findElement(cardEXPMonth).sendKeys(ExpMonth);
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardEXPYear));
			Thread.sleep(2000);
			driver.findElement(cardEXPYear).sendKeys(ExpYear);

		}
		else if(gatewayName.contains("Tsys")|| gatewayName.contains("tsys")) {
			By cardEXP=By.xpath(prop.getProperty("Exp_locator"));
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardEXP));
			Thread.sleep(2000);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			String expDate=prop.getProperty("ExpDate");
			jse.executeScript("arguments[0].value='"+expDate+"';", driver.findElement(cardEXP));
			driver.findElement(cardEXP).sendKeys(Keys.ENTER);
			Thread.sleep(1500);

		}
		else if(gatewayName.contains("Rapidconnect") || gatewayName.contains("Rapid") || gatewayName.equalsIgnoreCase("RapidConnect")) {
			By cardEXPMonth;
			By cardEXPYear;
			String PaymentType=paymentType.toLowerCase();
			if(PaymentType.contains("insurance") ) {
				cardEXPMonth=By.xpath(prop.getProperty("Ins_ExpMonth_locator"));
				cardEXPYear=By.xpath(prop.getProperty("Ins_ExpYear_locator"));


			}else {
				cardEXPMonth=By.xpath(prop.getProperty("ExpMonth_locator"));
				cardEXPYear=By.xpath(prop.getProperty("ExpYear_locator"));
			}
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardEXPMonth));
			driver.findElement(cardEXPMonth).sendKeys(ExpMonth);
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardEXPYear));
			Thread.sleep(2000);
			driver.findElement(cardEXPYear).sendKeys(ExpYear);

		}
		else if(gatewayName.contains("Cardpointe")||gatewayName.equalsIgnoreCase("cardpointe")) {

			By cardEXPMonth;
			By cardEXPYear;
			String PaymentType=paymentType.toLowerCase();
			if(PaymentType.contains("insurance") ) {
				cardEXPMonth=By.xpath(prop.getProperty("Ins_ExpMonth_locator"));
				cardEXPYear=By.xpath(prop.getProperty("Ins_ExpYear_locator"));


			}else {
				cardEXPMonth=By.xpath(prop.getProperty("ExpMonth_locator"));
				cardEXPYear=By.xpath(prop.getProperty("ExpYear_locator"));
			}
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardEXPMonth));
			driver.findElement(cardEXPMonth).sendKeys(ExpMonth);
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardEXPYear));
			Thread.sleep(2000);
			driver.findElement(cardEXPYear).sendKeys(ExpYear);


		}
		else if(gatewayName.contains("Stripe")) {
			By cardEXPMonth=By.xpath(prop.getProperty("ExpMonth_locator"));
			By cardEXPYear=By.xpath(prop.getProperty("ExpYear_locator"));
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardEXPMonth));
			driver.findElement(cardEXPMonth).sendKeys(ExpMonth);
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardEXPYear));
			Thread.sleep(2000);
			driver.findElement(cardEXPYear).sendKeys(ExpYear);


		}



	}
	public void enterCardCVV(String gatewayName, String cardType,String paymentType) throws InterruptedException {

		if(gatewayName.equalsIgnoreCase("Heartland") || gatewayName.contains("heartland") || gatewayName.contains("Heartland")) {
			By cardCVV=By.xpath(prop.getProperty("CardCVV_locator"));
			driver.switchTo().frame("card-cvv");

			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardCVV));
			Thread.sleep(2000);
			if(cardType.contains("Amex")|| cardType.contains("amex")) {
				String cVV=prop.getProperty("AmexCvv");
				driver.findElement(cardCVV).sendKeys(cVV);
				Thread.sleep(4000);

			}
			else {

				String cVV=prop.getProperty("Cvv");
				driver.findElement(cardCVV).sendKeys(cVV);
				Thread.sleep(4000);

			}
			driver.switchTo().defaultContent();

		}
		else if(gatewayName.contains("Elavon") || gatewayName.contains("elavon")) {


			By cardCvv;
			String PaymentType=paymentType.toLowerCase();
			if(PaymentType.contains("insurance") ) {
				cardCvv=By.xpath(prop.getProperty("Ins_CardCvv_locator"));
			}else {
				cardCvv=By.xpath(prop.getProperty("CardCvv_locator"));
			}
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardCvv));
			if(cardType.contains("Amex")|| cardType.contains("amex")) {
				driver.findElement(cardCvv).sendKeys(prop.getProperty("AmexCVV"));
			}
			else {
				driver.findElement(cardCvv).sendKeys(prop.getProperty("Cvv"));
			}



		}
		else if(gatewayName.equalsIgnoreCase("Tsys") || gatewayName.contains("Tsys")){

			By cardCvv=By.xpath(prop.getProperty("CardCVV_locator"));
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardCvv));

			Thread.sleep(2000);
			if(cardType.contains("Amex")|| cardType.contains("amex")) {
				String cVV=prop.getProperty("AmexCVV");
				driver.findElement(cardCvv).sendKeys(cVV);
				Thread.sleep(4000);
			}
			else if(cardType.contains("Visa")|| cardType.contains("visa")){
				String cVV=prop.getProperty("VisaCvv");
				driver.findElement(cardCvv).sendKeys(cVV);
				Thread.sleep(4000);
			}
			else {
				String cVV=prop.getProperty("MasterCvv");
				driver.findElement(cardCvv).sendKeys(cVV);
				Thread.sleep(4000);

			}



		}
		else if(gatewayName.equalsIgnoreCase("Rapidconnect") || gatewayName.contains("Rapid") || gatewayName.contains("rapid")){
			By cardCvv;
			String PaymentType=paymentType.toLowerCase();
			if(PaymentType.contains("insurance") ) {
				cardCvv=By.xpath(prop.getProperty("Ins_CardCvv_locator"));
			}else {
				cardCvv=By.xpath(prop.getProperty("CardCvv_locator"));
			}
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardCvv));
			if(cardType.contains("Amex")|| cardType.contains("amex")) {
				driver.findElement(cardCvv).sendKeys(prop.getProperty("AmexCVV"));
			}
			else {
				driver.findElement(cardCvv).sendKeys(prop.getProperty("Cvv"));
			}


		}
		else if(gatewayName.equalsIgnoreCase("Cardpointe") || gatewayName.contains("CardPoint")) {
			By cardCvv;
			String PaymentType=paymentType.toLowerCase();
			if(PaymentType.contains("insurance") ) {
				cardCvv=By.xpath(prop.getProperty("Ins_CardCvv_locator"));
			}else {
				cardCvv=By.xpath(prop.getProperty("CardCvv_locator"));
			}
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardCvv));
			if(cardType.contains("Amex")|| cardType.contains("amex")) {
				driver.findElement(cardCvv).sendKeys(prop.getProperty("AmexCVV"));
			}
			else {
				driver.findElement(cardCvv).sendKeys(prop.getProperty("Cvv"));
			}

		}
		else if(gatewayName.equalsIgnoreCase("Stripe")) {
			By cardCvv=By.xpath(prop.getProperty("CardCvv_locator"));
			wait3.until(ExpectedConditions.visibilityOfElementLocated(cardCvv));
			if(cardType.contains("Amex")|| cardType.contains("amex")) {
				driver.findElement(cardCvv).sendKeys(prop.getProperty("AmexCVV"));
			}
			else {
				driver.findElement(cardCvv).sendKeys(prop.getProperty("Cvv"));
			}

		}
		else {
			System.out.println("For Cvv gatewat not found!");
		}


	}
	public void enterZipCode(String zipCode) {

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(zipCode_locator));
			driver.findElement(zipCode_locator).sendKeys(zipCode);
	}

	public void submitCardDetailsForm(String gatewayName,String paymentType) throws InterruptedException {

		String PaymentType=paymentType.toLowerCase();
		Thread.sleep(2000);
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
		if(gatewayName.equalsIgnoreCase("Heartland") || gatewayName.contains("Heartland")  || gatewayName.contains("heartland")) {
			driver.switchTo().frame("submit");
			By confirm=By.xpath(prop.getProperty("Confirmbtn_locator"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(confirm));
			driver.findElement(confirm).click();
			Thread.sleep(5000);
			driver.switchTo().defaultContent();


		}
		else if(gatewayName.contains("Elavon") || gatewayName.contains("elavon")) {
			By confirm;
			if(PaymentType.contains("manual")) {
				confirm=By.xpath(prop.getProperty("ConfirmBtn_locator"));
				wait.until(ExpectedConditions.visibilityOfElementLocated(confirm));
				driver.findElement(confirm).click();
				Thread.sleep(5000);
			}
			else {
				confirm=By.xpath(prop.getProperty("Ins_PayBtn_locator"));
				wait.until(ExpectedConditions.visibilityOfElementLocated(confirm));
				driver.findElement(confirm).click();
				Thread.sleep(5000);
			}

	/*		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(confirmBtn_locator));
			WebElement Element = driver.findElement(confirmBtn_locator);

			JavascriptExecutor js = (JavascriptExecutor)driver;

		        //This will scroll the page till the element is found
		    js.executeScript("arguments[0].scrollIntoView();", Element);


		    wait.until(ExpectedConditions.elementToBeClickable(confirmBtn_locator)).click();
			Thread.sleep(2000);
*/

		}
		else if(gatewayName.equalsIgnoreCase("Tsys") || gatewayName.contains("Tsys") || gatewayName.contains("tsys")) {

			By confirm;
			if(PaymentType.contains("manual")) {
				confirm=By.xpath(prop.getProperty("Confirmbtn_locator"));
				wait.until(ExpectedConditions.visibilityOfElementLocated(confirm));
				driver.findElement(confirm).click();
				Thread.sleep(5000);
			}
			else {
				confirm=By.xpath(prop.getProperty("Ins_PayBtn_locator"));
				wait.until(ExpectedConditions.visibilityOfElementLocated(confirm));
				driver.findElement(confirm).click();
				Thread.sleep(5000);
			}

		/*
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(confirmBtn_locator));
			WebElement Element = driver.findElement(confirmBtn_locator);

			JavascriptExecutor js = (JavascriptExecutor)driver;

		        //This will scroll the page till the element is found
		    js.executeScript("arguments[0].scrollIntoView();", Element);


		    wait.until(ExpectedConditions.elementToBeClickable(confirmBtn_locator)).click();
			Thread.sleep(2000);
*/
		}
		else if(gatewayName.equalsIgnoreCase("Rapidconnect") || gatewayName.contains("Rapidconnect") || gatewayName.contains("Rapid")  ) {

			By confirm;
			if(PaymentType.contains("manual")) {
				confirm=By.xpath(prop.getProperty("ConfirmBtn_locator"));
				wait.until(ExpectedConditions.visibilityOfElementLocated(confirm));
				driver.findElement(confirm).click();
				Thread.sleep(5000);
			}
			else {
				confirm=By.xpath(prop.getProperty("Ins_PayBtn_locator"));
				wait.until(ExpectedConditions.visibilityOfElementLocated(confirm));
				driver.findElement(confirm).click();
				Thread.sleep(5000);
			}

		/*

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(confirmBtn_locator));
			WebElement Element = driver.findElement(confirmBtn_locator);

			JavascriptExecutor js = (JavascriptExecutor)driver;

		        //This will scroll the page till the element is found
		    js.executeScript("arguments[0].scrollIntoView();", Element);


		    wait.until(ExpectedConditions.elementToBeClickable(confirmBtn_locator)).click();
			Thread.sleep(2000);
*/
		}
		else if(gatewayName.equalsIgnoreCase("Cardpointe") ||  gatewayName.contains("Cardpoint") || gatewayName.contains("cardpoint")) {

			By confirm;
			if(PaymentType.contains("manual")) {
				confirm=By.xpath(prop.getProperty("ConfirmBtn_locator"));
				wait.until(ExpectedConditions.visibilityOfElementLocated(confirm));
				driver.findElement(confirm).click();
				Thread.sleep(5000);
			}
			else {
				confirm=By.xpath(prop.getProperty("Ins_PayBtn_locator"));
				wait.until(ExpectedConditions.visibilityOfElementLocated(confirm));
				driver.findElement(confirm).click();
				Thread.sleep(5000);
			}



		}
		else if(gatewayName.equalsIgnoreCase("Stripe") || gatewayName.contains("Stripe") || gatewayName.contains("stripe")) {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(confirmBtn_locator));
			WebElement Element = driver.findElement(confirmBtn_locator);

			JavascriptExecutor js = (JavascriptExecutor)driver;

		        //This will scroll the page till the element is found
		    js.executeScript("arguments[0].scrollIntoView();", Element);


		    wait.until(ExpectedConditions.elementToBeClickable(confirmBtn_locator)).click();
			Thread.sleep(2000);

		}

	}
		public void enterAddress(String Address) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(address));
			driver.findElement(address).sendKeys(Address);
		}
		public void enterCity(String City) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(city));
			driver.findElement(city).sendKeys(City);
		}
		public void enterState(String State) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(state));
			driver.findElement(state).sendKeys(State);

		}


}
