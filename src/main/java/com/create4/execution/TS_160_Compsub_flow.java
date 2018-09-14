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

import com.create4.scenarios.TS_160;
import com.global.methods.GlobalMethods;

import jxl.Sheet;
import jxl.Workbook;

public class TS_160_Compsub_flow {
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
	public void CRe4_2248() throws Exception {

		TS_160 i1 = new TS_160();
		i1.CRe4_2248();

	}

	@Test
	public void CRe4_2249_2250_2251() throws Exception {

		TS_160 i1 = new TS_160();
		i1.CRe4_2249_2250_2251();

	}

	@Test
	public void CRe4_2252_2253_2254_2255() throws Exception {

		TS_160 i1 = new TS_160();
		i1.CRe4_2252_2253_2254_2255();

	}

	@Test
	public void CRe4_2257_2258() throws Exception {

		TS_160 i1 = new TS_160();
		i1.CRe4_2257_2258();

	}

	@Test
	public void CRe4_2259() throws Exception {

		TS_160 i1 = new TS_160();
		i1.CRe4_2259();

	}

	@Test
	public void CRe4_CRe4_2260_2261_2262_2263() throws Exception {

		TS_160 i1 = new TS_160();
		i1.CRe4_CRe4_2260_2261_2262_2263();

	}

	@Test
	public void CRe4_2264() throws Exception {

		TS_160 i1 = new TS_160();
		i1.CRe4_2264();

	}

	@Test
	public void CRe4_2276() throws Exception {

		TS_160 i1 = new TS_160();
		i1.CRe4_2276();

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
