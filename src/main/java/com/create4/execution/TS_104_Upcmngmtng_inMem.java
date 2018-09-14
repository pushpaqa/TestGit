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

import com.create4.scenarios.TS_104;
import com.global.methods.GlobalMethods;

import jxl.Sheet;
import jxl.Workbook;

public class TS_104_Upcmngmtng_inMem {

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
	public void CRe4_355_356() throws Exception {

		TS_104 IECMemMTNG = new TS_104();

		IECMemMTNG.IECMembersMtg_CRe4_355_356();
	}

	@Test
	public void CRe4_357() throws Exception {

		TS_104 IECMemMTNG = new TS_104();

		IECMemMTNG.IECMembersMtg_CRe4_357_358();
	}

	@Test
	public void CRe4_360() throws Exception {

		TS_104 IECMemMTNG = new TS_104();

		IECMemMTNG.IECMembersMtg_CRe4_360();
	}

	@Test
	public void CRe4_361() throws Exception {

		TS_104 IECMemMTNG = new TS_104();

		IECMemMTNG.IECMembersMtg_CRe4_361();
	}

	@Test
	public void CRe4_362() throws Exception {

		TS_104 IECMemMTNG = new TS_104();

		IECMemMTNG.IECMembersMtg_CRe4_362();
	}

	@Test
	public void CRe4_367() throws Exception {

		TS_104 IECMemMTNG = new TS_104();

		IECMemMTNG.IECMembersMtg_CRe4_367();
	}

	@Test
	public void CRe4_368() throws Exception {

		TS_104 IECMemMTNG = new TS_104();

		IECMemMTNG.IECMembersMtg_CRe4_368();
	}

	@Test
	public void CRe4_369_373() throws Exception {

		TS_104 IECMemMTNG = new TS_104();

		IECMemMTNG.IECMembersMtg_CRe4_369_370_371_373();
	}

	@Test
	public void CRe4_375_376() throws Exception {

		TS_104 IECMemMTNG = new TS_104();

		IECMemMTNG.IECMembersMtg_CRe4_375_376();
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
