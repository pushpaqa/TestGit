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

import com.create4.scenarios.TS_102;
import com.global.methods.GlobalMethods;

import jxl.Sheet;
import jxl.Workbook;

public class TS_102_Upcmngmtng_in_CP {
	@BeforeMethod
	public void beforeMethod() throws Exception, Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Login");

		String URL = r1.getCell(1, 0).getContents();
		String FirefoxBrowser = r1.getCell(1, 1).getContents();
		GlobalMethods.LaunchBrowser(FirefoxBrowser, URL);

	}

	@Test
	public void CRe4_317_318_319() throws Exception {

		TS_102 IECMTNG = new TS_102();

		IECMTNG.IECMSMtg_CRe4_317_318_319();
	}

	@Test
	public void CRe4_320() throws Exception {

		TS_102 IECMTNG = new TS_102();

		IECMTNG.IECMSMtg_CRe4_320();
	}

	@Test
	public void CRe4_321() throws Exception {

		TS_102 IECMTNG = new TS_102();

		IECMTNG.IECMSMtg_CRe4_321();
	}

	@Test
	public void CRe4_322() throws Exception {

		TS_102 IECMTNG = new TS_102();

		IECMTNG.IECMSMtg_CRe4_322();
	}

	@Test
	public void CRe4_323() throws Exception {

		TS_102 IECMTNG = new TS_102();

		IECMTNG.IECMSMtg_CRe4_323();
	}

	@Test
	public void CRe4_324() throws Exception {

		TS_102 IECMTNG = new TS_102();

		IECMTNG.IECMSMtg_CRe4_324();
	}

	@Test
	public void CRe4_333_334() throws Exception {

		TS_102 IECMTNG = new TS_102();

		IECMTNG.IECMSMtg_CRe4_333_334();
	}

	@Test
	public void CRe4_337_338() throws Exception {

		TS_102 IECMTNG = new TS_102();

		IECMTNG.IECMSMtg_CRe4_337_338();
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
