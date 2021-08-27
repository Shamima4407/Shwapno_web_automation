package com.testClasses;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;//*[@id="myaccount"]/div/a[1]
import com.aventstack.extentreports.Status;
import com.reusableFunctions.ReusableFunction;
import com.utilities.GetExtentReport;

public class ShwapnoPopUpWindow extends ReusableFunction{
	ExtentReports extent;
	ExtentTest test;
	public ShwapnoLogin login;
	@BeforeTest
	public void initiateDriver() throws Exception {
		extent = GetExtentReport.getExtent();
		myTestCaseName = this.getClass().getSimpleName();
		executeBrowser();
	}
	@Test(priority = 1)
	public void selectDeliveryLocation() throws IOException {
		if(continueTestCase==true) {
			sheetName = "DeliveryLocation";
			int totalSheetRowCount = getSpreadsheetData.getRowCount(sheetName);
			boolean foundTestCase = false;
			test = extent.createTest(this.getClass().getSimpleName());
			for(startIter=1; startIter<=totalSheetRowCount; startIter++) {
				if(this.getClass().getSimpleName().equals(getSpreadsheetData.getCellData(sheetName, startIter, "Test Case Name"))) {
					System.out.println(getSpreadsheetData.getCellData(sheetName, startIter, "Test Case Name"));
					foundTestCase = true;
					
					//test starts from here
					selectCity();
					screenshot.takeScreenshot("City selected");
					test.log(Status.INFO, "Successfully city selected");
					
					selectArea();
					screenshot.takeScreenshot("Area selected");
					test.log(Status.INFO, "Successfully area selected");
					
					clickLocationSubmitButton();
					screenshot.takeScreenshot("Delivery location submitted");
					test.log(Status.INFO, "Successfully delivery location submitted");
					
					break;
					
				}
				
			}
			if(foundTestCase==false) {
				System.out.println("no row/test case name found in the test data excel:: "+this.getClass().getSimpleName());
				
			}
			
		}
		else {
			throw new SkipException("skipping the test case");
		}
		
	}
	
	@Test(priority = 2)
	public void shwapnoLogin() throws Exception{
		if(continueTestCase==true) {
			login = new ShwapnoLogin();
		}
		login.login();
		login.pSearchAndSelect();
		
	}
	@AfterTest
	public void closeBrowser() throws Exception{
		
		if(continueTestCase==true) {
			Thread.sleep(2000);
			extent.flush();
			
			driver.close();
		}
		
	}
	
	

}
