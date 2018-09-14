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

import com.create4.scenarios.TS_101;
import com.global.methods.GlobalMethods;

import jxl.Sheet;
import jxl.Workbook;

public class TS_101_Cmpltdmtng_inAdmin {

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
	public void CRe4_302() throws Exception {

		TS_101 IECCompltMTNG = new TS_101();

		IECCompltMTNG.IECMSMtg_CRe4_302();
	}

	@Test
	public void CRe4_304() throws Exception {

		TS_101 IECCompltMTNG = new TS_101();

		IECCompltMTNG.IECMSMtg_CRe4_304();
	}

	@Test
	public void CRe4_305() throws Exception {

		TS_101 IECCompltMTNG = new TS_101();

		IECCompltMTNG.IECMSMtg_CRe4_305();
	}

	@Test
	public void CRe4_306() throws Exception {

		TS_101 IECCompltMTNG = new TS_101();

		IECCompltMTNG.IECMSMtg_CRe4_306();
	}

	@Test
	public void CRe4_307() throws Exception {

		TS_101 IECCompltMTNG = new TS_101();

		IECCompltMTNG.IECMSMtg_CRe4_307();
	}

	@Test
	public void CRe4_311_313() throws Exception {

		TS_101 IECCompltMTNG = new TS_101();

		IECCompltMTNG.IECMSMtg_CRe4_311_312_313();
	}

	@Test
	public void CRe4_315() throws Exception {

		TS_101 IECCompltMTNG = new TS_101();

		IECCompltMTNG.IECMSMtg_CRe4_315_316();
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
