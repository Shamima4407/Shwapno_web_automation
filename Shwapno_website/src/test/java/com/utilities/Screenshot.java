package com.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



public class Screenshot extends BaseClass {
	public void  takeScreenshot (String screenshotImageName)throws IOException{
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		
		File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
		Date currentDate= new Date();
		String timeStamp = currentDate.toString().replace(" " , "-").replace(":", "/");
		String ssPath =System.getProperty("user.dir")+"/Screenshot/"+screenshotImageName+"-"+timeStamp+".png";
		File target = new File(ssPath);
		FileUtils.copyFile(screenshot, target);
	}
	
}
	
	
	

