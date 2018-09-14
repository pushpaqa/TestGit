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

import com.create4.scenarios.TS_184;
import com.global.methods.GlobalMethods;

import jxl.Sheet;
import jxl.Workbook;

public class TS_184_Saefollow_queryreply  {
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
	public void CRe4_1762_1763_1764() throws Exception {

		TS_184 i1 = new TS_184();
		i1.CRe4_1762_1763_1764();

	}

	@Test
	public void CRe4_1772_1773_1774() throws Exception {

		TS_184 i1 = new TS_184();
		i1.CRe4_1772_1773_1774();

	}

	@Test
	public void CRe4_1777_1778_1779() throws Exception {

		TS_184 i1 = new TS_184();
		i1.CRe4_1777_1778_1779();

	}

	@Test
	public void CRe4_1782_1783_1784() throws Exception {

		TS_184 i1 = new TS_184();
		i1.CRe4_1782_1783_1784();

	}

	@Test
	public void CRe4_1787_1788_1789() throws Exception {

		TS_184 i1 = new TS_184();
		i1.CRe4_1787_1788_1789();

	}

	@Test
	public void CRe4_1792_1793_1794() throws Exception {

		TS_184 i1 = new TS_184();
		i1.CRe4_1792_1793_1794();

	}

	@Test
	public void CRe4_1797_1798_1790() throws Exception {

		TS_184 i1 = new TS_184();
		i1.CRe4_1797_1798_1790();

	}
	
	@Test
	public void CRe4_1802_1803_1804() throws Exception {

		TS_184 i1 = new TS_184();
		i1.CRe4_1802_1803_1804();

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
