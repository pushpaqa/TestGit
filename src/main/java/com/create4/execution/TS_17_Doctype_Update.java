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

import com.create4.scenarios.TS_17;
import com.global.methods.GlobalMethods;

import jxl.Sheet;
import jxl.Workbook;



public class TS_17_Doctype_Update {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Login");

		String URL = r1.getCell(1,0).getContents();
		String FirefoxBrowser = r1.getCell(1,1).getContents();
		GlobalMethods.LaunchBrowser(FirefoxBrowser, URL);

	}

	@Test(priority = 1)
	public void CRe4_948_949() throws Exception {

		TS_17 ViewDocType = new TS_17();

		ViewDocType.CRe4_948_949();
	}

	@Test(priority = 2)
	public void CRe4_950_951() throws Exception {

		TS_17 ViewDocType = new TS_17();

		ViewDocType.CRe4_950_951();
	}
	
	@Test(priority = 3)
	public void CRe4_952() throws Exception {

		TS_17 ViewDocType = new TS_17();

		ViewDocType.CRe4_952();
	}
	
	@Test(priority = 4)
	public void CRe4_953() throws Exception {

		TS_17 ViewDocType = new TS_17();

		ViewDocType.CRe4_953();
	}
	
	@Test(priority = 5)
	public void CRe4_954() throws Exception {

		TS_17 ViewDocType = new TS_17();

		ViewDocType.CRe4_954();
	}
	
	@Test(priority = 6)
	public void CRe4_955() throws Exception {

		TS_17 ViewDocType = new TS_17();

		ViewDocType.CRe4_955();
	}
	
	@Test(priority = 7)
	public void CRe4_956() throws Exception {

		TS_17 ViewDocType = new TS_17();

		ViewDocType.CRe4_956();
	}
	
	@Test(priority = 8)
	public void CRe4_957() throws Exception {

		TS_17 ViewDocType = new TS_17();

		ViewDocType.CRe4_957();
	}

	@Test(priority = 9)
	public void CRe4_958() throws Exception {

		TS_17 ViewDocType = new TS_17();

		ViewDocType.CRe4_958();
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
