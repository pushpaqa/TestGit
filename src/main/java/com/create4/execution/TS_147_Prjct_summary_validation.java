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

import com.create4.scenarios.TS_147;
import com.global.methods.GlobalMethods;

import jxl.Sheet;
import jxl.Workbook;

public class TS_147_Prjct_summary_validation  {
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
	public void CRe4_1993() throws Exception {

		TS_147 i1 = new TS_147();
		i1.CRe4_1993();

	}

	@Test
	public void CRe4_1996() throws Exception {

		TS_147 i1 = new TS_147();
		i1.CRe4_1996();

	}

	@Test
	public void CRe4_1997() throws Exception {

		TS_147 i1 = new TS_147();
		i1.CRe4_1997();

	}

	@Test
	public void CRe4_1998() throws Exception {

		TS_147 i1 = new TS_147();
		i1.CRe4_1998();

	}

	@Test
	public void CRe4_2001() throws Exception {

		TS_147 i1 = new TS_147();
		i1.CRe4_2001();

	}

	@Test
	public void CRe4_2002() throws Exception {

		TS_147 i1 = new TS_147();
		i1.CRe4_2002();

	}

	@Test
	public void CRe4_2003() throws Exception {

		TS_147 i1 = new TS_147();
		i1.CRe4_2003();

	}

	@Test
	public void CRe4_2006() throws Exception {

		TS_147 i1 = new TS_147();
		i1.CRe4_2006();

	}

	@Test
	public void CRe4_2007() throws Exception {

		TS_147 i1 = new TS_147();
		i1.CRe4_2007();

	}

	@Test
	public void CRe4_2010_2013() throws Exception {

		TS_147 i1 = new TS_147();
		i1.CRe4_2010_2013();

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
