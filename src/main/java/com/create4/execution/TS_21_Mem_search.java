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

import com.create4.scenarios.TS_21;
import com.global.methods.GlobalMethods;

import jxl.Sheet;
import jxl.Workbook;

public class TS_21_Mem_search {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Login");

		String URL = r1.getCell(1,0).getContents();
		String FirefoxBrowser = r1.getCell(1,1).getContents();
		GlobalMethods.LaunchBrowser(FirefoxBrowser, URL);

	}

	@Test(priority = 1)
	public void CRe4_970_971_972_973_977() throws Exception {

		TS_21 SearchIECMember = new TS_21();
		SearchIECMember.CRe4_970_971_972_973_977();

	}

	@Test(priority = 2)
	public void CRe4_974() throws Exception {

		TS_21 SearchIECMember = new TS_21();
		SearchIECMember.CRe4_974();

	}
	
	@Test(priority = 3)
	public void CRe4_975() throws Exception {

		TS_21 SearchIECMember = new TS_21();
		SearchIECMember.CRe4_975();

	}

	@Test(priority = 4)
	public void CRe4_976() throws Exception {

		TS_21 SearchIECMember = new TS_21();
		SearchIECMember.CRe4_976();

	}

	@Test(priority = 4)
	public void CRe4_978() throws Exception {

		TS_21 SearchIECMember = new TS_21();
		SearchIECMember.CRe4_978();

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
