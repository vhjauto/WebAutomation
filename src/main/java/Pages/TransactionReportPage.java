package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import TestBase.BaseClass;
import utility.Utility;

public class TransactionReportPage extends BaseClass{

	String refNo;

	By CardNumber_E=By.xpath("//td[contains(text(),'"+refNo+"')]/following-sibling::td[2]");
	By CardType_E=By.xpath("//td[contains(text(),'"+refNo+"')]/following-sibling::td[3]");
	By GatewayTransactionID_E=By.xpath("//td[contains(text(),'"+refNo+"')]/following-sibling::td[4]");
	By Amount_E=By.xpath("//td[contains(text(),'"+refNo+"')]/preceding-sibling::td[1]");
	By TransactionType_E=By.xpath("//td[contains(text(),'"+refNo+"')]/preceding-sibling::td[3]");
	By TransactionID_E=By.xpath("//td[contains(text(),'"+refNo+"')]/preceding-sibling::td[4]");
	By PatientName_E=By.xpath("//td[contains(text(),'"+refNo+"')]/preceding-sibling::td[6]");
	By CardHolderName_E=By.xpath("//td[contains(text(),'"+refNo+"')]/preceding-sibling::td[5]");
	By Phone_Email_E=By.xpath("//td[contains(text(),'"+refNo+"')]/preceding-sibling::td[7]");
	By ProviderName_E=By.xpath("//td[contains(text(),'"+refNo+"')]/preceding-sibling::td[8]");
	By UserLoginID_E=By.xpath("//td[contains(text(),'"+refNo+"')]/preceding-sibling::td[9]");
	By ActionIconsList_E;

	By RefundAmount_E=By.xpath("//input[@id='refundamount']");
	By ReasonDropDown_E=By.xpath("//select[@id='FundReson']");
	By Refund_Submit_E=By.xpath("//input[@id='Submit']");
	By successMsg_E=By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/p[1]");

	By NoRecordsFound_E=By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[4]/div[2]/div[3]/div[1]/div[1]/p[1]");



	public TransactionReportPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	public void clickOnRefundCIcon(String refNo) {
		By refundIcon=By.xpath("//td[contains(text(),'"+refNo+"')]/following-sibling::td[7]/div/a[2]/img");
		wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(refundIcon));
		driver.findElement(refundIcon).click();

	}


	public void clickActionIcon(String refNo,String fun3,String Gateway) throws InterruptedException {
		
		try {
		
			String fun=fun3.toLowerCase();
			System.out.println("Gateway "+Gateway);
			String gateway=Gateway.toLowerCase();
			int i=1;
		
			String actionicon = null;
			if(gateway.contains("elavon")||gateway.contains("rapid")) {

				ActionIconsList_E=By.xpath("//td[contains(text(),'"+refNo+"')]/following-sibling::td[6]/div/a");

			}else {
				ActionIconsList_E=By.xpath("//td[contains(text(),'"+refNo+"')]/following-sibling::td[7]/div/a");

			}

			wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ActionIconsList_E));
			List<WebElement> actions=driver.findElements(ActionIconsList_E);
			for(WebElement element:actions) {
				System.out.println("In List of action elements");
				Thread.sleep(2000);
				String action=element.getAttribute("href");
				String title=element.getAttribute("class");
				String title2=element.getAttribute("title");
				System.out.println("action "+action);
				System.out.println("title "+title);

				if(action.contains("refund") && action.contains(fun)) {

					actionicon="refund";
					By refundIcon;

					if(gateway.contains("elavon")||gateway.contains("rapid")) {
						refundIcon=By.xpath("//td[contains(text(),'"+refNo+"')]/following-sibling::td[6]/div/a["+i+"]/img");

					}else {

						refundIcon=By.xpath("//td[contains(text(),'"+refNo+"')]/following-sibling::td[7]/div/a["+i+"]/img");

					}
					wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(refundIcon));
					driver.findElement(refundIcon).click();
					Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());



				}else if(action.contains("void") && action.contains(fun)){
					actionicon="void";
					By voidIcon;

					if(gateway.contains("elavon")||gateway.contains("rapid")) {

						voidIcon=By.xpath("//td[contains(text(),'"+refNo+"')]/following-sibling::td[6]/div/a["+i+"]/img");


					}else {
						voidIcon=By.xpath("//td[contains(text(),'"+refNo+"')]/following-sibling::td[7]/div/a["+i+"]/img");


					}
					wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(voidIcon));
					driver.findElement(voidIcon).click();
					Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());



				}else if(action.contains("receipt") && action.contains(fun)) {
					actionicon="Printreceipt";
					By receiptIcon;

					if(gateway.contains("elavon")||gateway.contains("rapid")) {

						receiptIcon=By.xpath("//td[contains(text(),'"+refNo+"')]/following-sibling::td[6]/div/a["+i+"]/img");


					}else {
						receiptIcon=By.xpath("//td[contains(text(),'"+refNo+"')]/following-sibling::td[7]/div/a["+i+"]/img");


					}
					wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(receiptIcon));
					driver.findElement(receiptIcon).click();
					Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());



				}else if(action.contains("downloadreport") && title2.contains(fun)) {
					//fun =Download Print receipt
					actionicon="DownloadPrint";
					By downloadReceiptIcon;

					if(gateway.contains("elavon")||gateway.contains("rapid")) {
						downloadReceiptIcon=By.xpath("//td[contains(text(),'"+refNo+"')]/following-sibling::td[6]/div/a["+i+"]/img");


					}else {
						downloadReceiptIcon=By.xpath("//td[contains(text(),'"+refNo+"')]/following-sibling::td[7]/div/a["+i+"]/img");



					}
					wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(downloadReceiptIcon));
					driver.findElement(downloadReceiptIcon).click();
					Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());


				}else if(title.contains("new_card loadercard") ){
					actionicon="ChargeCard";
					By chargeCardIcon;

					if(gateway.contains("elavon")||gateway.contains("rapid")) {
						chargeCardIcon=By.xpath("//td[contains(text(),'"+refNo+"')]/following-sibling::td[6]/div/a["+i+"]/img");



					}else {
						chargeCardIcon=By.xpath("//td[contains(text(),'"+refNo+"')]/following-sibling::td[7]/div/a["+i+"]/img");

					}
					wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(chargeCardIcon));
					driver.findElement(chargeCardIcon).click();
					Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());


				}else if(title.contains("mail_send_card d-inline-block") && title2.contains(fun)) {
					//fun = Email Print Receipt
					By emailPrintIcon;
					actionicon="emailPrintReceipt";

					if(gateway.contains("elavon")||gateway.contains("rapid")) {
						emailPrintIcon=By.xpath("//td[contains(text(),'"+refNo+"')]/following-sibling::td[6]/div/a["+i+"]/img");


					}else {
						emailPrintIcon=By.xpath("//td[contains(text(),'"+refNo+"')]/following-sibling::td[7]/div/a["+i+"]/img");


					}
					wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(emailPrintIcon));
					driver.findElement(emailPrintIcon).click();
					Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());



				}
				else if(title.contains("update_patient_ref d-inline-block") && action.contains(fun)){

					//fun =update_patient_ref;
					actionicon="updatePatientRef";
					By updatePatientRefIcon;

					if(gateway.contains("elavon")||gateway.contains("rapid")) {
						updatePatientRefIcon=By.xpath("//td[contains(text(),'"+refNo+"')]/following-sibling::td[6]/div/a["+i+"]/img");



					}else {

						updatePatientRefIcon=By.xpath("//td[contains(text(),'"+refNo+"')]/following-sibling::td[7]/div/a["+i+"]/img");

					}
					wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(updatePatientRefIcon));
					driver.findElement(updatePatientRefIcon).click();
					Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());


				}else {

					System.out.println("No actions found!");
				}
				i++;

			
		}
	
			
		}catch(Exception e){
			
			
		}


	}
	public void enterRefundAmount(String partiaRrefundAmount) {
		wait2.until(ExpectedConditions.visibilityOfElementLocated(RefundAmount_E));
		driver.findElement(RefundAmount_E).click();
		driver.findElement(RefundAmount_E).sendKeys(partiaRrefundAmount);
	}
	public void selectReasonOption() {
		wait2.until(ExpectedConditions.visibilityOfElementLocated(ReasonDropDown_E));
		Select dropdown=new Select(driver.findElement(ReasonDropDown_E));
		dropdown.selectByIndex(2);

	}
	public void refundVoidSubmitBtn() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Refund_Submit_E));
		driver.findElement(Refund_Submit_E).click();
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}
	public Boolean verifyRefundVoidTransactionSuccess() {
		Boolean refundstatus = null;
		WebElement status=driver.findElement(successMsg_E);
		String TansactionType=status.getText();
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());

		if(TansactionType.contains("Void processed successfully")) {
			refundstatus=true;
		}else if (TansactionType.contains("Refund processed successfully")) {
			refundstatus=true;
		}
		else {
			refundstatus=false;
		}
		return refundstatus;

	}
	public Boolean searchTransactionInReport(String paymentType1) {

		Boolean recordFound = null;
		String paymentType=paymentType1.toLowerCase();

		try {
			By tran=By.xpath("//td[contains(text(),'"+refNo+"')]/preceding-sibling::td[2]/a[1]/span[1]/ul[1]/li[2]/b[2]");
			String Type_E=driver.findElement(tran).getText();
			String PaymentType=Type_E.toLowerCase();

			if(PaymentType.contains(paymentType)) {
				recordFound=true;
			}
			else {
				recordFound=false;
			}

		}catch(Exception e) {

		}
		return recordFound;


	}
	public Boolean getTransactionStatus(String transStatus) {
		Boolean status1=null;
		String status=transStatus.toLowerCase();
		By status_E=By.xpath("//td[contains(text(),'"+refNo+"')]/preceding-sibling::td[2]/a[1]");
		String tranSatus=driver.findElement(status_E).getText();
		if(tranSatus.contains(status)) {
			status1=true;
		}
		else {
			status1=false;
		}
		return status1;

	}
	
	public Boolean isSpecialityDisplayInGrid(String speciality,String refNo) {
		
		By speciality_E=By.xpath("//td[contains(text(),'"+refNo+"')]/following-sibling::td[6]/a[1]");
		By speciality_V=By.xpath("//td[contains(text(),'"+refNo+"')]/following-sibling::td[6]/a[1]/child::span");
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(speciality_E));
		String speciality_Value=driver.findElement(speciality_V).getText();	
		System.out.println("Speciality displaying in portal "+speciality_Value);
		
		return speciality.contains(speciality_Value);
		
	}



}
