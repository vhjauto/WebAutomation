package Pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import TestBase.BaseClass;

public class CommunicationReportsPage extends BaseClass {

	public static String FinalURL=null;
	public String RefNo;

	By Report_Menu=By.xpath("//a[@id='reportdropdown']");

	By CommunicationMenu=By.xpath("//a[contains(text(),'Communication Report')]");

	By runMyReport=By.xpath("//input[@id='AddMerchant']");

	By PatientName= By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/input[1]");

	By phone_email=By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/input[1]");

	By Amount= By.xpath("//input[@id='orginalamount']");

	By print=By.xpath("//body/div[1]/div[1]/span[1]/a[1]/img[1]");

	By Proceed=By.xpath("//button[@id='submit']");

	By homeMenu=By.xpath("//a[contains(text(),'Home')]");

	By searchRefNo=By.xpath("//input[@id='p_ref_no_communication']");

	By sentMessageIcon=By.xpath("//td[contains(text(),'"+RefNo+"')]//following-sibling::td[10]/div[1]/span[2]/img[1]");

	By paymentype_L=By.xpath("//td[contains(text(),'"+RefNo+"')]//following-sibling::td[6]");

	By transactionStatus_L=By.xpath("//td[contains(text(),'"+RefNo+"')]//following-sibling::td[9]");

	By phone_Email_L=By.xpath("//td[contains(text(),'"+RefNo+"')]//following-sibling::td[3]");

	By contactless_link_Text=By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/span[1]");


	public static String paymentType=null;

	public CommunicationReportsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	public void navigateToCommunicationReport() throws InterruptedException {
		wait3.until(ExpectedConditions.visibilityOfElementLocated(homeMenu));
		driver.findElement(homeMenu).click();
		wait3.until(ExpectedConditions.visibilityOfElementLocated(Report_Menu));

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(Report_Menu));
		actions.moveToElement(driver.findElement(CommunicationMenu)).click().build().perform();
	    Thread.sleep(2000);
	    System.out.println("Navigated to Communication Report menu");

	}
	public void searchPatientReferenceNumber(String refNo) {

		this.RefNo=refNo;
		wait3.until(ExpectedConditions.visibilityOfElementLocated(searchRefNo));
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView();",driver.findElement(searchRefNo));
		driver.findElement(searchRefNo).sendKeys(refNo);
	}
	public void runCommunicationReport() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView();", driver.findElement(runMyReport));
	    Thread.sleep(2000);
		driver.findElement(runMyReport).click();
		Thread.sleep(3000);
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{
			String child_window=I1.next();

			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);
			//	 Reporter.log("Communication Report has been ran successfully!");
			}

		}


	}
	public String getCollectCardPaymentlink(String RefNo) throws InterruptedException, AWTException {


		By sentMessageIcon=By.xpath("//td[contains(text(),'"+RefNo+"')]//following-sibling::td[10]/div[1]/span[2]/img[1]");

		By paymentype_L=By.xpath("//td[contains(text(),'"+RefNo+"')]//following-sibling::td[6]");

		By transactionStatus_L=By.xpath("//td[contains(text(),'"+RefNo+"')]//following-sibling::td[9]");

		By phone_Email_L=By.xpath("//td[contains(text(),'"+RefNo+"')]//following-sibling::td[3]");

		By contactless_link_Text=By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/span[1]");


		Boolean paymentLink=null;
		WebElement Type=driver.findElement(paymentype_L);
		WebElement transStatus=driver.findElement(transactionStatus_L);
		WebElement phone_Email1=driver.findElement(phone_Email_L);
		String Phone_email2=phone_Email1.getText();
		System.out.println("Phone/Email:"+Phone_email2);
		paymentType=Type.getText();

		System.out.println("Payment Type:"+paymentType);
		String TransactionStatus=transStatus.getText();
		System.out.println("Transaction Status:"+TransactionStatus);

		if(paymentType.equalsIgnoreCase("Contactless") && TransactionStatus.equalsIgnoreCase("Not Paid") ) {

			wait3.until(ExpectedConditions.visibilityOfElementLocated(sentMessageIcon));
			WebElement seeMsgSentIcon=driver.findElement(sentMessageIcon);
			seeMsgSentIcon.click();
			Actions actions = new Actions(driver);
			Thread.sleep(5000);
			System.out.println("See Msg Sent icon cliked");
			if(Phone_email2.contains("@")) {
					WebElement URL=driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
					String FinalURL1=URL.getAttribute("href");
					System.out.println(FinalURL1);
					CommunicationReportsPage.FinalURL=FinalURL1;
					paymentLink=FinalURL.isBlank();
		//			Reporter.log("CollectCard Payment url found as :"+FinalURL);

			}else {

				WebElement SMSText_L=driver.findElement(contactless_link_Text);
				String smstext=SMSText_L.getText();
				int i=smstext.indexOf("https://");
				if(smstext.contains("collectcard/?reference"))
				System.out.println(i);
				String url=smstext.substring(i);
				CommunicationReportsPage.FinalURL=url;

			}
		}else if(paymentType.equals("Patient Responsibility") && TransactionStatus.equalsIgnoreCase("Not Paid")){
			WebElement seeMsgSentIcon=driver.findElement(By.xpath("//td[contains(text(),'"+RefNo+"')]//following-sibling::td[10]/div[1]/div[2]/span[1]/img[1]"));
			seeMsgSentIcon.click();
			if(Phone_email2.contains("@")) {
				WebElement URL=driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
					String	FinalURL1=URL.getAttribute("href");
					System.out.println(FinalURL1);
					CommunicationReportsPage.FinalURL=FinalURL1;
					paymentLink=FinalURL.isBlank();
		//			Reporter.log("CollectCard Payment url found as :"+FinalURL);

			}else {
				WebElement GetPaymentURL=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/span[1]"));
				String PaymentUrl=GetPaymentURL.getText();
				String separator =":";
				int sepPos = PaymentUrl.indexOf(separator);
				String URL=PaymentUrl.substring(sepPos + separator.length());
				System.out.println("Substring after separator = "+PaymentUrl.substring(sepPos + separator.length()));
				String FinalURL1="https:"+URL;
				System.out.println("URL:"+FinalURL1);
				CommunicationReportsPage.FinalURL=FinalURL1;
				paymentLink=FinalURL.isBlank();
		//		Reporter.log("CollectCard Payment url found as :"+FinalURL);
			}
		}else if(paymentType.equals("Recurring Billing") &&TransactionStatus.equalsIgnoreCase("Not Paid")) {

			wait3.until(ExpectedConditions.visibilityOfElementLocated(sentMessageIcon));
			WebElement seeMsgSentIcon=driver.findElement(sentMessageIcon);
			seeMsgSentIcon.click();
			Actions actions = new Actions(driver);
			Thread.sleep(5000);
			System.out.println("See Msg Sent icon cliked");
			if(Phone_email2.contains("@")) {
					WebElement URL=driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
					String FinalURL1=URL.getAttribute("href");
					System.out.println(FinalURL1);
					CommunicationReportsPage.FinalURL=FinalURL1;
					paymentLink=FinalURL.isBlank();
		//			Reporter.log("CollectCard Payment url found as :"+FinalURL);

			}else {

				WebElement SMSText_L=driver.findElement(contactless_link_Text);
				String smstext=SMSText_L.getText();
				int i=smstext.indexOf("https://");
				String url=smstext.substring(i);
				String FinalURL=url.substring(0,114);
				CommunicationReportsPage.FinalURL=FinalURL;

			}

	}
		return FinalURL;

	/*
	public Boolean resendSMSEmail(String RefNo) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'"+RefNo+"')]//following-sibling::td[10]/div[1]/div[1]/span[1]/img[1]")));
		WebElement resendICon=driver.findElement(By.xpath("//td[contains(text(),'"+RefNo+"')]//following-sibling::td[10]/div[1]/div[1]/span[1]/img[1]"));
		resendICon.click();
	//	Reporter.log("Resend SMS/Email pop up window opened successfully!");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='orginalamount']")));
		Amount.clear();
		Amount.sendKeys("5.1");
		Proceed.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Re-sent Successfully')]")));
		WebElement resendSuccess=driver.findElement(By.xpath("//div[contains(text(),'Re-sent Successfully')]"));
		Boolean resendSuccessMessage=resendSuccess.isDisplayed();
	//	Reporter.log("SMS/Email has been resent successfully!");
		return resendSuccessMessage;

	}
	public String verifyTransactionStatus(String RefNo) {
		WebElement userLogin=driver.findElement(By.xpath("//td[contains(text(),'"+RefNo+"')]//following-sibling::td[9]"));
		String TransStatus=userLogin.getText();
	//	Reporter.log("Payment transaction status as :"+TransStatus);

		return TransStatus;

	}
	public Float verifyAmount(String RefNo,String Amount) {
		WebElement Amount1=driver.findElement(By.xpath("//td[contains(text(),'"+RefNo+"')]//following-sibling::td[4]"));
		String Amountwith$=Amount1.getText();
		String originalAmount=Amountwith$.substring(1);
		float Amount2=Float.parseFloat(originalAmount);
	//	Reporter.log("Payment amount found in Communication Report as :"+Amountwith$);
		//Assert.assertEquals(originalAmount,Amount);
		return Amount2;


	}
	public String verifyUserLoginID(String RefNo,String Amount) {
		WebElement userLogin=driver.findElement(By.xpath("//td[contains(text(),'"+RefNo+"')]//preceding-sibling::td[2]"));
		String UserLoginID=userLogin.getText();
	//	Reporter.log("User Login Id found in Communication Report as :"+UserLoginID);
		return UserLoginID;


	}
	public String verifyProviderName(String RefNo) {
		WebElement providerName=driver.findElement(By.xpath("//td[contains(text(),'"+RefNo+"')]//preceding-sibling::td[1]"));
		String ProviderName=providerName.getText();
	//	Reporter.log("Provider Name found in Communication Report as :"+ProviderName);

		return ProviderName;

	}


	public void printReportOfCommReport() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[1]/span[1]/a[1]/img[1]")));
		WebElement print=driver.findElement(By.xpath("//body/div[1]/div[1]/span[1]/a[1]/img[1]"));
		print.click();
	//	Reporter.log("Print report icon clicked successfully! ");


	}

	public void ExportExcelReportOfCommReport() {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[1]/span[1]/a[2]/img[1]]")));
	WebElement excel=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/span[1]/a[2]/img[1]"));
	excel.click();
//	Reporter.log("Export Excel of Communication downloaded successfully! ");

	}
	public String viewTransactionInCommReport(String RefNo) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'"+RefNo+"')]//following-sibling::td[10]/div[2]/div[1]/span[1]/img[1]")));
		WebElement viewTransIcon=driver.findElement(By.xpath("//td[contains(text(),'"+RefNo+"')]//following-sibling::td[10]/div[2]/div[1]/span[1]/img[1]"));
		viewTransIcon.click();
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Authorize')]")));
		WebElement tranStatus=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[2]/td[9]/a[1]"));
		String Status=tranStatus.getText();
		System.out.println("Transaction Status"+Status);
	//	Reporter.log("Transaction Status has found in Transaction Report grid with Status as : "+Status);
		return Status;
	}

	*/
	}
}



