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

import com.create4.scenarios.TS_183;
import com.global.methods.GlobalMethods;

import jxl.Sheet;
import jxl.Workbook;

public class TS_183_Saeint_quryreply  {
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
	public void CRe4_1688_1689_1690() throws Exception {

		TS_183 i1 = new TS_183();
		i1.CRe4_1688_1689_1690();

	}

	@Test
	public void CRe4_1698_1699_1670() throws Exception {

		TS_183 i1 = new TS_183();
		i1.CRe4_1698_1699_1670();

	}

	@Test
	public void CRe4_1703_1704_1705() throws Exception {

		TS_183 i1 = new TS_183();
		i1.CRe4_1703_1704_1705();

	}

	@Test
	public void CRe4_1708_1709_1710() throws Exception {

		TS_183 i1 = new TS_183();
		i1.CRe4_1708_1709_1710();

	}

	@Test
	public void CRe4_1713_1714_1715() throws Exception {

		TS_183 i1 = new TS_183();
		i1.CRe4_1713_1714_1715();

	}

	@Test
	public void CRe4_1718_1719_1720() throws Exception {

		TS_183 i1 = new TS_183();
		i1.CRe4_1718_1719_1720();

	}

	@Test
	public void CRe4_1723_1724_1725() throws Exception {

		TS_183 i1 = new TS_183();
		i1.CRe4_1723_1724_1725();

	}

	@Test
	public void CRe4_1728_1729_1730() throws Exception {

		TS_183 i1 = new TS_183();
		i1.CRe4_1728_1729_1730();

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
