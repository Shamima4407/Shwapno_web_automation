package com.reusableFunctions;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.objectRepository.ObjectRepository_xpath;
import com.utilities.PageActions;

public class ReusableFunction extends PageActions{
	ExtentReports report;
	ExtentTest test;
	//product select
	public static void productSearch() {
		String productName=getSpreadsheetData.getCellData(sheetName, startIter,"Search Data");
		getElement("Product search page","Product Name found",
				(By.xpath(ObjectRepository_xpath.search)),defaultElementLoadTime,"sendkeys",productName);
		getElement("Product search Page","Product search",
				(By.xpath(ObjectRepository_xpath.search_button)),defaultElementLoadTime,"click","");
	} 
	public void pselect() {
		getElement("Product selection","Product found",
				(By.xpath(ObjectRepository_xpath.parasuit_img)),defaultElementLoadTime,"click","");
	}
	public static void productAdd() {
		getElement("Product selection","Product found",
				(By.xpath(ObjectRepository_xpath.add_button)),defaultElementLoadTime,"click","");
	}
	public static void logout() {
		getElement("Product selection","Product found",
				(By.xpath(ObjectRepository_xpath.logout)),defaultElementLoadTime,"click","");
	}
	
	
	
	public static void login_link() {
		getElement("Shwapno home page","login found",(By.xpath(ObjectRepository_xpath.login_link)),defaultElementLoadTime,"click","");
	}
	public static void loginWithEmail() {
		System.out.println("login with email");
		getElement("Shwapno home page","login with email found",
				(By.xpath(ObjectRepository_xpath.loginWithEmail)),defaultElementLoadTime,"click","");
		System.out.println("done");
	}
	
	//username enter
	public static void enterUserName() {
		String  userName = getSpreadsheetData.getCellData(sheetName, startIter, "UserName");
		
		getElement("Swapno login page","UserName Textfield found",
			(By.xpath(ObjectRepository_xpath.userName)),defaultElementLoadTime,"sendkeys",userName);	
	}
	
	//password enter
	public static void enterUserPassword() {
		String userPassword = getSpreadsheetData.getCellData(sheetName, startIter, "Password");	 
		getElement("Swapno login page","UserPassword Textfield found",
				(By.xpath(ObjectRepository_xpath.password)),defaultElementLoadTime,"sendkeys",userPassword);
	}
	public static void clickInfoSubmitButton() {
		getElement("Swapno login page","UserPassword Textfield found",
				(By.xpath(ObjectRepository_xpath.submit)),defaultElementLoadTime,"click","");
	}
	public static void selectCity() {
		String city = getSpreadsheetData.getCellData(sheetName, startIter,"Select City");
		getElement("Swapno page","select delivery location",
				(By.xpath(ObjectRepository_xpath.select_your_city)),defaultElementLoadTime,"select",city);
		
	}
	public static void selectArea() {
		String area = getSpreadsheetData.getCellData(sheetName, startIter, "Select Area");
		getElement("Swapno page","select delivery location",
				(By.xpath(ObjectRepository_xpath.select_your_area)),defaultElementLoadTime,"select",area);
		
	}
	public static void clickLocationSubmitButton() {
		getElement("Swapno page","select delivery location",
				(By.xpath(ObjectRepository_xpath.submit_btn)),defaultElementLoadTime,"click","");	
		
	}	
}
