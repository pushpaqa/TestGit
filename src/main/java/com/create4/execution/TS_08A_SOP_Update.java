package com.create4.execution;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.global.methods.*;

import jxl.Sheet;
import jxl.Workbook;

import com.create4.scenarios.*;

public class TS_08A_SOP_Update{
	@BeforeMethod
	public void beforeMethod() throws Exception, Exception {
		//GlobalMethods g = new GlobalMethods();
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Login");

		String URL = r1.getCell(1,0).getContents();
		String FirefoxBrowser = r1.getCell(1,1).getContents();
		GlobalMethods.LaunchBrowser(FirefoxBrowser, URL);

	}


	@Test
	public void CRe4_865() throws Exception{

		TS_08A i1=new TS_08A();
		i1.CRe4_865();

	}

	@Test
	public void CRe4_866() throws Exception{
		TS_08A i1=new TS_08A();
		i1.CRe4_866();
		

	}
	
	

	@Test
	public void CRe4_867() throws Exception{
		TS_08A i1=new TS_08A();
		i1.CRe4_867();
		

	}
	

	@Test
	public void CRe4_868() throws Exception{
		TS_08A i1=new TS_08A();
		i1.CRe4_868();
		

	}
	
	@Test
	public void CRe4_869() throws Exception{
		TS_08A i1=new TS_08A();
		i1.CRe4_869();
		

	}
	

   @Test
	public void CRe4_870_871_872_873_874_875() throws Exception{
		TS_08A i1=new TS_08A();
		i1.CRe4_870_871_872_873_874_875();
		

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
