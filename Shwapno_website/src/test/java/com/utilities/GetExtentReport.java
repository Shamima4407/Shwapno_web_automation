package com.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class GetExtentReport {
	private static ExtentReports extentReports;// we can set the path where we needs to generate the report
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentTest extentTest;//we can create logs in the report
	private static String filePath=System.getProperty("user.dir")+"//target//extentreport.html";
	
	public static ExtentReports getExtent() {
		if(extentReports != null) 
			return extentReports;
		extentReports =new ExtentReports();
		extentReports.attachReporter(getHtmlReporter());
		return extentReports;
	
	}
	private static ExtentHtmlReporter getHtmlReporter() {
		htmlReporter = new ExtentHtmlReporter(filePath);
		htmlReporter.loadXMLConfig("./ReportsConfig.XML");
		return htmlReporter;
	}
	
	public static ExtentTest createTest(String testName, String description) {
		extentTest=extentReports.createTest(testName,description);
		return extentTest;
	}
}
