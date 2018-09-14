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

import com.create4.scenarios.TS_182;
import com.global.methods.GlobalMethods;

import jxl.Sheet;
import jxl.Workbook;

public class TS_182_Term_queryreply  {
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
	public void CRe4_1624_1625_1626() throws Exception {

		TS_182 i1 = new TS_182();
		i1.CRe4_1624_1625_1626();

	}

	@Test
	public void CRe4_1634_1635_1636() throws Exception {

		TS_182 i1 = new TS_182();
		i1.CRe4_1634_1635_1636();

	}

	@Test
	public void CRe4_1639_1640_1641() throws Exception {

		TS_182 i1 = new TS_182();
		i1.CRe4_1639_1640_1641();

	}

	@Test
	public void CRe4_1644_1645_1646() throws Exception {

		TS_182 i1 = new TS_182();
		i1.CRe4_1644_1645_1646();

	}

	@Test
	public void CRe4_1649_1650_1651() throws Exception {

		TS_182 i1 = new TS_182();
		i1.CRe4_1649_1650_1651();

	}

	@Test
	public void CRe4_1654_1655_1656() throws Exception {

		TS_182 i1 = new TS_182();
		i1.CRe4_1654_1655_1656();

	}

	@Test
	public void CRe4_1659_1660_1661() throws Exception {

		TS_182 i1 = new TS_182();
		i1.CRe4_1659_1660_1661();

	}

	@Test
	public void CRe4_1664_1665_1666() throws Exception {

		TS_182 i1 = new TS_182();
		i1.CRe4_1664_1665_1666();

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
