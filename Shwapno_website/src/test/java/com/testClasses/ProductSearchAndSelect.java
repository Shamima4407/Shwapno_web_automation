package com.testClasses;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.reusableFunctions.ReusableFunction;
import com.utilities.GetExtentReport;

public class ProductSearchAndSelect extends ReusableFunction {
	ExtentReports extent;
	ExtentTest test;
	@Test(priority=5)
	public void productSelect() throws Exception {
		extent = GetExtentReport.getExtent();
		if(continueTestCase==true) {
			sheetName = "ProductSearchAndSelect";
			
			int totalSheetRowCount = getSpreadsheetData.getRowCount(sheetName);
			boolean foundTestCase = false;
			test = extent.createTest(this.getClass().getSimpleName());
			
			for(startIter=1; startIter<=totalSheetRowCount; startIter++) {
				if(this.getClass().getSimpleName().equals(getSpreadsheetData.getCellData(sheetName, startIter, "Test Case Name"))) {
					System.out.println(getSpreadsheetData.getCellData(sheetName, startIter, "Test Case Name"));
					foundTestCase = true;
					
					//test starts from here
					productSearch();
					screenshot.takeScreenshot("Product searched");
					test.log(Status.INFO, "Product searched successfully");
					
					
					pselect();
					screenshot.takeScreenshot("Product selected");
					test.log(Status.INFO, "Product selected successfully");
					
					
					productAdd();
					screenshot.takeScreenshot("Product added");
					test.log(Status.INFO, "Product added successfully");
					Thread.sleep(5000);
					
					logout();
					screenshot.takeScreenshot("logout");
					test.log(Status.INFO, "Logout successfully");
					
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
	
	
	

}
