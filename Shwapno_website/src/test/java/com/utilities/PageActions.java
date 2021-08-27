package com.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import junit.framework.Assert;

public class PageActions extends BaseClass{
	public static int defaultElementLoadTime=30;
	
	public static String getElement(String pageName, String userMsg, By locator, int timeOut, String action,String value) {
		//PageName=the page in which i want to work 
		//UserMsg= If i want to pass any msg like element found or nor found
		WebElement elementVisible=null;
		WebDriverWait wait= new WebDriverWait(driver,timeOut);
		try {
			elementVisible=(WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("x-path value of "+pageName+" = "+locator+" found");
			String myLocator ="clickable locator found"+locator;
			Reporter.log(myLocator);
			
		}catch(TimeoutException el) {
			el.printStackTrace();
			System.out.println(locator +" element not found after waiting for "+timeOut + " second");
			String myLocator="clickable locator not found:: "+locator;
			Assert.assertFalse(myLocator,elementVisible==null);
			Reporter.log( myLocator);
			return myLocator;
			
		}
		System.out.println("element found "+locator);
		
		if(!(action == " ")) {
			performAction(locator,action,value);
		}
		return value;
		
	}
	public static void performAction(By locator, String action, String value) {
		switch(action){
		case "sendkeys":
			driver.findElement(locator).sendKeys(value);
			break;
		case "click":
			driver.findElement(locator).click();
			break;
		case "clear":
			driver.findElement(locator).clear();
			break;
		case "submit":
			driver.findElement(locator).submit();
			break;
		case "select":
			Select select = new Select( driver.findElement(locator));
			select.selectByVisibleText(value);
			break;
		
		}
		
	}

}
