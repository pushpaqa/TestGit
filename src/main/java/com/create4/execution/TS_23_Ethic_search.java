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

import com.create4.scenarios.TS_23;
import com.global.methods.GlobalMethods;

import jxl.Sheet;
import jxl.Workbook;

public class TS_23_Ethic_search {
	@BeforeMethod
	public void beforeMethod() throws Exception {
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Login");

		String URL = r1.getCell(1,0).getContents();
		String FirefoxBrowser = r1.getCell(1,1).getContents();
		GlobalMethods.LaunchBrowser(FirefoxBrowser, URL);

	}

	@Test(priority = 42)
	public void CRe4_1056() throws Exception {

		TS_23 IECEthicCom = new TS_23();

		IECEthicCom.CRe4_1056();
	}

	@Test(priority = 43)
	public void CRe4_1057() throws Exception {

		TS_23 IECEthicCom = new TS_23();

		IECEthicCom.CRe4_1057();
	}

	@Test(priority = 44)
	public void CRe4_1058() throws Exception {

		TS_23 IECEthicCom = new TS_23();

		IECEthicCom.CRe4_1058_1060_1061();
	}

	@Test(priority = 45)
	public void CRe4_1059() throws Exception {

		TS_23 IECEthicCom = new TS_23();

		IECEthicCom.CRe4_1059();
	}

	@Test(priority = 46)
	public void CRe4_1062_1063() throws Exception {

		TS_23 IECEthicCom = new TS_23();

		IECEthicCom.CRe4_1062_1063();
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
