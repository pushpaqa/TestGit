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

import com.create4.scenarios.TS_22;
import com.global.methods.GlobalMethods;

import jxl.Sheet;
import jxl.Workbook;

public class TS_22_Ethic_add {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Login");

		String URL = r1.getCell(1,0).getContents();
		String FirefoxBrowser = r1.getCell(1,1).getContents();
		GlobalMethods.LaunchBrowser(FirefoxBrowser, URL);

	}

	@Test
	public void CRe4_1064_65() throws Exception {

		TS_22 IECEthicCom = new TS_22();

		IECEthicCom.CRe4_1064_65();

	}

	@Test
	public void CRe4_1066_1067() throws Exception {

		TS_22 IECEthicCom = new TS_22();

		IECEthicCom.CRe4_1066_1067();

	}

	@Test
	public void CRe4_1070_71_1085_80_to_85() throws Exception {

		TS_22 IECEthicCom = new TS_22();

		IECEthicCom.CRe4_1070_71_1085_80_to_85();

	}

	@Test
	public void CRe4_1077() throws Exception {

		TS_22 IECEthicCom = new TS_22();

		IECEthicCom.CRe4_1077();

	}

	@Test
	public void CRe4_1078() throws Exception {

		TS_22 IECEthicCom = new TS_22();

		IECEthicCom.CRe4_1078();

	}

	@Test
	public void CRe4_1079() throws Exception {

		TS_22 IECEthicCom = new TS_22();

		IECEthicCom.CRe4_1079();

	}

	@Test
	public void CRe4_1080() throws Exception {

		TS_22 IECEthicCom = new TS_22();

		IECEthicCom.CRe4_1080();

	}

	@Test
	public void CRe4_1095_to_1100_1101_1102() throws Exception {

		TS_22 IECEthicCom = new TS_22();

		IECEthicCom.CRe4_1095_to_1100_1101_1102();

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
