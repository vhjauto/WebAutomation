package Pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import TestBase.BaseClass;

public class TransactionSearchPage extends BaseClass {


	public String RefNo;

	public String paymentType=null;

	By Report_Menu=By.xpath("//a[@id='reportdropdown']");

	By runMyReport=By.xpath("//input[@id='AddMerchant']");

	By homeMenu=By.xpath("//a[contains(text(),'Home')]");

	By searchRefNo=By.xpath("//input[@id='p_ref_no_transaction']");

	By TransactionReportMenu=By.xpath("//a[contains(text(),'Transaction Report')]");

	By paymentType_E=By.xpath("//label[contains(text(),'"+paymentType+"')]");

	By E_Commerce_E=By.xpath("//label[contains(text(),'E-Commerce')]");

	By Devices_E=By.xpath("//label[contains(text(),'Devices')]");
	
	By SpecialityCheckBox_Label_E=By.xpath("//label[contains(text(),'Display Specialities ?')]");
	
	By SpecialityCheckBox_btn_E=By.xpath("//input[@id='speciality']");

	public TransactionSearchPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public void navigateToTransactionSearchPage() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView();",driver.findElement(homeMenu));
		wait3.until(ExpectedConditions.visibilityOfElementLocated(homeMenu));
		driver.findElement(homeMenu).click();
		wait3.until(ExpectedConditions.visibilityOfElementLocated(Report_Menu));

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(Report_Menu));
		actions.moveToElement(driver.findElement(TransactionReportMenu)).click().build().perform();
	    Thread.sleep(2000);
	    System.out.println("Navigated to Transaction Report menu");

	}
	public void searchPatientReferenceNumber(String refNo) {

		this.RefNo=refNo;
		wait3.until(ExpectedConditions.visibilityOfElementLocated(searchRefNo));
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView();",driver.findElement(searchRefNo));
		driver.findElement(searchRefNo).sendKeys(refNo);
	}
	public void runTransactionReport() throws InterruptedException {

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
	
	public void enterSearchPatientName() {
		
		utility.WebElementActions.sendValueInTextField(Devices_E);
		
	}
	
	
	
	public void uncheckECommAndDevicePaymentType() {
		wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(E_Commerce_E));
		driver.findElement(E_Commerce_E).click();

	}
	public void selectPymentType(String paymentType) {

		this.paymentType=paymentType;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(paymentType_E));
	    js.executeScript("arguments[0].scrollIntoView();", driver.findElement(paymentType_E));
	    driver.findElement(paymentType_E).click();


	}
	public Boolean selectSepcialityCheckBox() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(SpecialityCheckBox_Label_E));
	    js.executeScript("arguments[0].scrollIntoView();",driver.findElement(SpecialityCheckBox_Label_E));
	    driver.findElement(SpecialityCheckBox_Label_E).click();	    
	    return driver.findElement(SpecialityCheckBox_btn_E).isSelected();
	    
	}


}
