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

import com.create4.scenarios.TS_137;
import com.global.methods.GlobalMethods;

import jxl.Sheet;
import jxl.Workbook;

public class TS_137_Othr_profile_update {

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
	public void CRe4_706_707() throws Exception {

		TS_137 MemberMyAccount = new TS_137();

		MemberMyAccount.CRe4_706_707();
	}

	@Test
	public void CRe4_708() throws Exception {

		TS_137 MemberMyAccount = new TS_137();

		MemberMyAccount.CRe4_708();
	}

	@Test
	public void CRe4_709() throws Exception {

		TS_137 MemberMyAccount = new TS_137();

		MemberMyAccount.CRe4_709();
	}

	@Test
	public void CRe4_710() throws Exception {

		TS_137 MemberMyAccount = new TS_137();

		MemberMyAccount.CRe4_710();
	}
	@Test
	public void CRe4_711_712() throws Exception {

		TS_137 MemberMyAccount = new TS_137();

		MemberMyAccount.CRe4_711_712();
	}
	@Test
	public void CRe4_713() throws Exception {

		TS_137 MemberMyAccount = new TS_137();

		MemberMyAccount.CRe4_713();
	}
	@Test
	public void CRe4_714() throws Exception {

		TS_137 MemberMyAccount = new TS_137();

		MemberMyAccount.CRe4_714();
	}
	@Test
	public void CRe4_715() throws Exception {

		TS_137 MemberMyAccount = new TS_137();

		MemberMyAccount.CRe4_715();
	}
	@Test
	public void CRe4_716() throws Exception {

		TS_137 MemberMyAccount = new TS_137();

		MemberMyAccount.CRe4_716();
	}
	@Test
	public void CRe4_717() throws Exception {

		TS_137 MemberMyAccount = new TS_137();

		MemberMyAccount.CRe4_717();
	}
	@Test
	public void CRe4_718() throws Exception {

		TS_137 MemberMyAccount = new TS_137();

		MemberMyAccount.CRe4_718();
	}
	@Test
	public void CRe4_721_722() throws Exception {

		TS_137 MemberMyAccount = new TS_137();

		MemberMyAccount.CRe4_721_722();
	}

	@Test
	public void CRe4_724_725_726_727() throws Exception {

		TS_137 MemberMyAccount = new TS_137();

		MemberMyAccount.CRe4_724_725_726_727();
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
