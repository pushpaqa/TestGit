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

import com.create4.scenarios.TS_185;
import com.global.methods.GlobalMethods;

import jxl.Sheet;
import jxl.Workbook;

public class TS_185_Saeother_queryreply {
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
	public void CRe4_1838_1839_1840_1841_1842() throws Exception {

		TS_185 i1 = new TS_185();
		i1.CRe4_1838_1839_1840_1841_1842();

	}

	@Test
	public void CRe4_1848_1849_1850_1851_1852() throws Exception {

		TS_185 i1 = new TS_185();
		i1.CRe4_1848_1849_1850_1851_1852();

	}

	@Test
	public void CRe4_1853_1854_1855_1856_1857() throws Exception {

		TS_185 i1 = new TS_185();
		i1.CRe4_1853_1854_1855_1856_1857();

	}

	

	@Test
	public void CRe4_1858_1859_1860_1861_1862() throws Exception {

		TS_185 i1 = new TS_185();
		i1.CRe4_1858_1859_1860_1861_1862();

	}

	@Test
	public void CRe4_1863_1864_1865_1866_1867() throws Exception {

		TS_185 i1 = new TS_185();
		i1.CRe4_1863_1864_1865_1866_1867();

	}

	@Test
	public void CRe4_1868_1869_1870_1871_1872() throws Exception {

		TS_185 i1 = new TS_185();
		i1.CRe4_1868_1869_1870_1871_1872();

	}

	
	@Test
	public void CRe4_1873_1874_1875_1876_1877() throws Exception {

		TS_185 i1 = new TS_185();
		i1.CRe4_1873_1874_1875_1876_1877();

	}

	@Test
	public void CRe4_1878_1879_1880_1881_1882() throws Exception {

		TS_185 i1 = new TS_185();
		i1.CRe4_1878_1879_1880_1881_1882();

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
