package com.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static int startIter;
	public static String baseUrl;
	public static String myTestCaseName;
	public static String myBrowser;
	public static String sheetName;
	public static GetSpreadSheetData getSpreadsheetData;
	public static Screenshot screenshot;
	public static boolean continueTestCase=false;
	public static boolean testCaseFoundinExcel=false;
	
	public static void executeBrowser() throws Exception {
		sheetName = "General";
		int rowCountOfGeneralSheet = getData().getRowCount(sheetName);
		System.out.println("sheetName: "+sheetName);
		for(int row=0; row<rowCountOfGeneralSheet; row++) {
			if(myTestCaseName.equals(getSpreadsheetData.getCellData(sheetName, row, "TestCaseName"))) {
				System.out.println("Current test case name: "+myTestCaseName);
				if(getSpreadsheetData.getCellData(sheetName, row, "Execute(N/Y)").equalsIgnoreCase("yes")) {
					myBrowser= getSpreadsheetData.getCellData(sheetName, row, "Browser");
					baseUrl=getSpreadsheetData.getCellData(sheetName, row, "ApplicationUrl");
					openBrowser();
					screenShot();
					continueTestCase=true;
					testCaseFoundinExcel=true;
					break;
					
					
				}
				else {
					System.out.println("Test Case marks in general sheet not to execute");
					continueTestCase=false;
				}
			}
		}
		if(testCaseFoundinExcel == false) {
			System.out.println("The test case name is not provided in gerenal sheet in excel");
		}
	}
	
	//step 2:open browser
	public static void openBrowser() throws Exception {
		WebDriver dv=getDriver();
		dv.get(baseUrl);
		dv.manage().window().maximize();
	}
	
	//Step 1:getDriver
		public static WebDriver getDriver() throws Exception {
			if(driver==null) {
				if(myBrowser.equalsIgnoreCase("Firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				}
				else if(myBrowser.equalsIgnoreCase("Chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					
				}
				else if(myBrowser.equalsIgnoreCase("Opera")) {
					WebDriverManager.operadriver().setup();
					driver = new OperaDriver();
				}
				else if(myBrowser.equalsIgnoreCase("IE")) {
					WebDriverManager.edgedriver().setup();
					driver = new InternetExplorerDriver();
				}
				else {
					throw new Exception("browser is not correct");
				}
			}
			return driver;
		}
	
		

		//Create object of Screenshot class
		public static void screenShot() {
			screenshot = new Screenshot();
			
			
		}

	
	//Create object of GetSpreadSheetData class and passing the sheet location
	public static GetSpreadSheetData getData() throws IOException {
		if(getSpreadsheetData==null) {
			getSpreadsheetData = new GetSpreadSheetData("G:\\MyAutomationProjects\\MyProject\\ExcelData\\TestCase.xlsx");
		}
		return getSpreadsheetData;
	}
	
	
		

			
}
