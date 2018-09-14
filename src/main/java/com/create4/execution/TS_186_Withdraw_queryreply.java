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

import com.create4.scenarios.TS_186;
import com.global.methods.GlobalMethods;

import jxl.Sheet;
import jxl.Workbook;

public class TS_186_Withdraw_queryreply {
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
	public void CRe4_1909_1910_1911_1912_1913() throws Exception {

		TS_186 i1 = new TS_186();
		i1.CRe4_1909_1910_1911_1912_1913();

	}

	

	@Test
	public void CRe4_1919_1920_1921() throws Exception {

		TS_186 i1 = new TS_186();
		i1.CRe4_1919_1920_1921();

	}

	@Test
	public void CRe4_1924_1925_1926() throws Exception {

		TS_186 i1 = new TS_186();
		i1.CRe4_1924_1925_1926();

	}

	@Test
	public void CRe4_1929_1930_1931() throws Exception {

		TS_186 i1 = new TS_186();
		i1.CRe4_1929_1930_1931();

	}

	@Test
	public void CRe4_1934_1935_1936() throws Exception {

		TS_186 i1 = new TS_186();
		i1.CRe4_1934_1935_1936();

	}

	@Test
	public void CRe4_1939_1940_1941() throws Exception {

		TS_186 i1 = new TS_186();
		i1.CRe4_1939_1940_1941();

	}

	@Test
	public void CRe4_1944_1945_1946() throws Exception {

		TS_186 i1 = new TS_186();
		i1.CRe4_1944_1945_1946();

	}

	@Test
	public void CRe4_1949_1950_1951() throws Exception {

		TS_186 i1 = new TS_186();
		i1.CRe4_1949_1950_1951();

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
