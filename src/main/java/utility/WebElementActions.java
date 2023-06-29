package utility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

import TestBase.BaseClass;

public class WebElementActions extends BaseClass{

	public WebElementActions() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public static void sendValueInTextField(By element) {		
		wait2.until(ExpectedConditions.visibilityOfElementLocated(element));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(element));
		
	}
	public static void selectCheckBox(By checkBox) {
		
		wait2.until(ExpectedConditions.visibilityOfElementLocated(checkBox));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(checkBox));
		driver.findElement(checkBox).click();	   
		
	}
	

}
