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

import com.create4.scenarios.TS_01B;


import com.global.methods.GlobalMethods;

import jxl.Sheet;
import jxl.Workbook;

public class TS_01B_Admin_Creation  {

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
	public void CRe4_813() throws Exception {

		TS_01B Institute = new TS_01B();

		Institute.CRe4_813();

	}

	@Test
	public void CRe4_814() throws Exception {

		TS_01B Institute = new TS_01B();

		Institute.CRe4_814();

	}
	@Test
	public void CRe4_815() throws Exception {

		TS_01B Institute = new TS_01B();

		Institute.CRe4_815();

	}
	
	@Test
	public void CRe4_816() throws Exception {

		TS_01B Institute = new TS_01B();

		Institute.CRe4_816();

	}
	
	@Test
	public void CRe4_817() throws Exception {

		TS_01B Institute = new TS_01B();

		Institute.CRe4_817();

	}
	
	@Test
	public void CRe4_818() throws Exception {

		TS_01B Institute = new TS_01B();

		Institute.CRe4_818();

	}
	
	@Test
	public void CRe4_819() throws Exception {

		TS_01B Institute = new TS_01B();

		Institute.CRe4_819();

	}

	
	@Test
	public void CRe4_823() throws Exception {

		TS_01B Institute = new TS_01B();

		Institute.CRe4_823();

	}
	
	@Test
	public void CRe4_824() throws Exception {

		TS_01B Institute = new TS_01B();

		Institute.CRe4_824();

	}
	
	@Test
	public void CRe4_825_827_829_831_833_835_837() throws Exception {

		TS_01B Institute = new TS_01B();

		Institute.CRe4_825_827_829_831_833_835_837();

	}
	
	@Test
	public void CRe4_826_828_830_832_834_836_838_839() throws Exception {

		TS_01B Institute = new TS_01B();

		Institute.CRe4_826_828_830_832_834_836_838_839();

	}
	
	@Test
	public void CRe4_820_821_822_840_841_842_843_844_845() throws Exception {

		TS_01B Institute = new TS_01B();

		Institute.CRe4_820_821_822_840_841_842_843_844_845();

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
