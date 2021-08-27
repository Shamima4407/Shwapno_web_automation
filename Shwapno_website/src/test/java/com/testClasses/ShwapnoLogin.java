package com.testClasses;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.reusableFunctions.ReusableFunction;
import com.utilities.GetExtentReport;

public class ShwapnoLogin extends ReusableFunction{
	ExtentReports extent;
	ExtentTest test;
	public ProductSearchAndSelect ps;
	@Test(priority=3)
	public void login() throws Exception {
		extent = GetExtentReport.getExtent();
		if(continueTestCase==true) {
			login_link();
			sheetName = "Login";
			int totalSheetRowCount = getSpreadsheetData.getRowCount(sheetName);
			boolean foundTestCase = false;
			
			test = extent.createTest(this.getClass().getSimpleName());
			
			for(startIter=1; startIter<=totalSheetRowCount; startIter++) {
				if(this.getClass().getSimpleName().equals(getSpreadsheetData.getCellData(sheetName, startIter, "Test Case Name"))) {
					System.out.println(getSpreadsheetData.getCellData(sheetName, startIter, "Test Case Name"));
					foundTestCase = true;
					
					//test starts from here
					loginWithEmail();
				
					
					enterUserName();
					screenshot.takeScreenshot("User name entered");
					test.log(Status.INFO, "User name entered successfully");
					
					enterUserPassword();
					screenshot.takeScreenshot("Password entered");
					test.log(Status.INFO, "Password entered successfully");
					
					clickInfoSubmitButton();
					screenshot.takeScreenshot("Password submitted");
					test.log(Status.INFO, "Password submitted successfully");
					
				
					
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
	
	@Test(priority = 4)
	public void pSearchAndSelect() throws Exception{
		if(continueTestCase==true) {
			ps = new ProductSearchAndSelect();	
			ps.productSelect();
		}
		

		
	}
	
	

}
