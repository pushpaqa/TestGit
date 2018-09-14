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

import com.create4.scenarios.TS_18;
import com.global.methods.GlobalMethods;

import jxl.Sheet;
import jxl.Workbook;

public class TS_18_Doctype_search {

	@BeforeMethod
	public void beforeMethod() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Login");

		String URL = r1.getCell(1, 0).getContents();
		String FirefoxBrowser = r1.getCell(1, 1).getContents();
		GlobalMethods.LaunchBrowser(FirefoxBrowser, URL);

	}

	@Test(priority = 1)
	public void CRe4_932_933_934_935_936() throws Exception {

		TS_18 SearchDocType = new TS_18();

		SearchDocType.CRe4_932_933_934_935_936();
	}

	@Test(priority = 2)
	public void CRe4_937() throws Exception {

		TS_18 SearchDocType = new TS_18();

		SearchDocType.CRe4_937();
	}

	@Test(priority = 3)
	public void CRe4_938() throws Exception {

		TS_18 SearchDocType = new TS_18();

		SearchDocType.CRe4_938();
	}

	@Test(priority = 4)
	public void CRe4_939() throws Exception {

		TS_18 SearchDocType = new TS_18();

		SearchDocType.CRe4_939();
	}

	@Test(priority = 5)
	public void CRe4_940() throws Exception {

		TS_18 SearchDocType = new TS_18();

		SearchDocType.CRe4_940();
	}

	@Test(priority = 6)
	public void CRe4_941() throws Exception {

		TS_18 SearchDocType = new TS_18();

		SearchDocType.CRe4_941();
	}

	@Test(priority = 7)
	public void CRe4_942() throws Exception {

		TS_18 SearchDocType = new TS_18();

		SearchDocType.CRe4_942();
	}

	@Test(priority = 8)
	public void CRe4_943() throws Exception {

		TS_18 SearchDocType = new TS_18();

		SearchDocType.CRe4_943();
	}

	@Test(priority = 9)
	public void CRe4_944() throws Exception {

		TS_18 SearchDocType = new TS_18();

		SearchDocType.CRe4_944();
	}

	@Test(priority = 10)
	public void CRe4_945() throws Exception {

		TS_18 SearchDocType = new TS_18();

		SearchDocType.CRe4_945();
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
