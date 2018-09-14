package com.create4.execution;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.create4.scenarios.TS_136;
import com.global.methods.GlobalMethods;

import jxl.Sheet;
import jxl.Workbook;

public class TS_136_PI_profile_update  {
	@BeforeMethod
	public void beforeMethod() throws Exception, Exception {
		
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Login");

		String URL = r1.getCell(1,0).getContents();
		String FirefoxBrowser = r1.getCell(1,1).getContents();
		GlobalMethods.LaunchBrowser(FirefoxBrowser, URL);

	}
	
	@Test
	public void CRe4_684() throws Exception {

		TS_136 SearchPI = new TS_136();

		SearchPI.CRe4_684();
	}

	@Test
	public void CRe4_686() throws Exception {

		TS_136 SearchPI = new TS_136();

		SearchPI.CRe4_686();
	}

	@Test
	public void CRe4_686_a() throws Exception {

		TS_136 SearchPI = new TS_136();

		SearchPI.CRe4_686_a();
	}

	@Test
	public void CRe4_687() throws Exception {

		TS_136 SearchPI = new TS_136();

		SearchPI.CRe4_687();
	}

	@Test
	public void CRe4_697_698_699_700_701_702_703_704_705() throws Exception {

		TS_136 SearchPI = new TS_136();

		SearchPI.CRe4_697_698_699_700_701_702_703_704_705();
	}
	
	@AfterMethod
	 public void TearDown(ITestResult result) throws IOException{
		  
		  if (result.getStatus() == ITestResult.FAILURE ){
			  
		   TakesScreenshot ts = (TakesScreenshot)GlobalMethods.driver;
		   File srcFile = ts.getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(srcFile, new File("C:\\Selenium_Files\\Testing\\Screens\\"+result.getName()+".jpg"));
		   //result.getname() method will give you current test case name. 
		   //./ScreenShots/ tell you that, in your current directory, create folder ScreenShots. dot represents current directory
		   //GlobalMethods.driver.close();
		   
		  
		  
		  }
		  GlobalMethods.driver.close();
		 }
}
