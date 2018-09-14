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

import com.create4.scenarios.TS_157;
import com.global.methods.GlobalMethods;

import jxl.Sheet;
import jxl.Workbook;

public class TS_157_Amend_sub_flow {
	@BeforeMethod
	public void beforeMethod() throws Exception, Exception {
		// GlobalMethods g = new GlobalMethods();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Login");

		String URL = r1.getCell(1, 0).getContents();
		String FirefoxBrowser = r1.getCell(1, 1).getContents();
		GlobalMethods.LaunchBrowser(FirefoxBrowser, URL);

	}

	@Test
	public void CRe4_2108() throws Exception {

		TS_157 i1 = new TS_157();
		i1.CRe4_2108();

	}

	@Test
	public void CRe4_2109_2110_2111() throws Exception {

		TS_157 i1 = new TS_157();
		i1.CRe4_2109_2110_2111();

	}

	@Test
	public void CRe4_2112_2113_2114_2115() throws Exception {

		TS_157 i1 = new TS_157();
		i1.CRe4_2112_2113_2114_2115();

	}

	@Test
	public void CRe4_2117_2118() throws Exception {

		TS_157 i1 = new TS_157();
		i1.CRe4_2117_2118();

	}

	@Test
	public void CRe4_2119() throws Exception {

		TS_157 i1 = new TS_157();
		i1.CRe4_2119();

	}

	@Test
	public void CRe4_2120_2121_2122() throws Exception {

		TS_157 i1 = new TS_157();
		i1.CRe4_2120_2121_2122();

	}

	@Test
	public void CRe4_2123() throws Exception {

		TS_157 i1 = new TS_157();
		i1.CRe4_2123();

	}

	@Test
	public void CRe4_2124() throws Exception {

		TS_157 i1 = new TS_157();
		i1.CRe4_2124();

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
