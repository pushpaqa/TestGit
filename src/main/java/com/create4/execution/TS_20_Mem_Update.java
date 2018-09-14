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

import com.create4.scenarios.TS_20;
import com.global.methods.GlobalMethods;

import jxl.Sheet;
import jxl.Workbook;

public class TS_20_Mem_Update {
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Login");

		String URL = r1.getCell(1,0).getContents();
		String FirefoxBrowser = r1.getCell(1,1).getContents();
		GlobalMethods.LaunchBrowser(FirefoxBrowser, URL);

	}

	@Test(priority = 0)
	public void CRe4_987_988() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_987_988();
	}
	
	@Test(priority = 1)
	public void CRe4_989() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_989();
	}
	
	@Test(priority = 2)
	public void CRe4_990() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_990();
	}
	
	@Test(priority = 3)
	public void CRe4_992() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_992();
	}
	
	@Test(priority = 4)
	public void CRe4_993() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_993();
	}
	
	@Test(priority = 5)
	public void CRe4_995() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_995();
	}
	
	@Test(priority = 6)
	public void CRe4_996() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_996();
	}
	
	@Test(priority = 7)
	public void CRe4_998() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_998();
	}
	
	@Test(priority = 8)
	public void CRe4_999() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_999();
	}
	
	@Test(priority = 9)
	public void CRe4_1001() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_1001();
	}
	
	@Test(priority = 10)
	public void CRe4_1002() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_1002();
	}
	
	@Test(priority = 11)
	public void CRe4_1004() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_1004();
	}
	
	@Test(priority = 12)
	public void CRe4_1005() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_1005();
	}
	
	@Test(priority = 13)
	public void CRe4_1007() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_1007();
	}
	
	@Test(priority = 14)
	public void CRe4_1008() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_1008();
	}
	
	@Test(priority = 15)
	public void CRe4_1010() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_1010();
	}
	
	@Test(priority = 16)
	public void CRe4_1011() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_1011();
	}
	
	@Test(priority = 17)
	public void CRe4_1013() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_1013();
	}
	
	@Test(priority = 18)
	public void CRe4_1014() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_1014();
	}
	
	@Test(priority = 19)
	public void CRe4_1016() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_1016();
	}
	
	@Test(priority = 20)
	public void CRe4_1017() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_1017();
	}
	
	@Test(priority = 21)
	public void CRe4_1019() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_1019();
	}
	
	@Test(priority = 22)
	public void CRe4_1020() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_1020();
	}
	@Test(priority = 23)
	public void CRe4_1021() throws Exception {

		TS_20 EditManageIECMember = new TS_20();
		EditManageIECMember.CRe4_1021();
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
