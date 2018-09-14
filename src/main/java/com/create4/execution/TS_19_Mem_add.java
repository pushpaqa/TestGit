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

import com.create4.scenarios.TS_19;
import com.global.methods.GlobalMethods;

import jxl.Sheet;
import jxl.Workbook;

public class TS_19_Mem_add {

	@BeforeMethod
	public void beforeMethod() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Login");

		String URL = r1.getCell(1, 0).getContents();
		String FirefoxBrowser = r1.getCell(1, 1).getContents();
		GlobalMethods.LaunchBrowser(FirefoxBrowser, URL);

	}

	@Test(priority = 1)
	public void CRe4_979_980_981_982_983_984_985() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_979_980_981_982_983_984_985();
	}

	@Test(priority = 2)
	public void CRe4_986() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_986();
	}

	@Test(priority = 3)
	public void CRe4_1022_1023_1024_1025_1026_1028() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1022_1023_1024_1025_1026_1028();
	}

	@Test(priority = 4)
	public void CRe4_1027() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1027();
	}

	@Test(priority = 5)
	public void CRe4_1029() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1029();
	}

	@Test(priority = 6)
	public void CRe4_1030() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1030();
	}

	@Test(priority = 7)
	public void CRe4_1031() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1031();
	}

	@Test(priority = 8)
	public void CRe4_1032() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1032();
	}

	@Test(priority = 9)
	public void CRe4_1033() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1033();
	}

	@Test(priority = 10)
	public void CRe4_1034() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1034();
	}

	@Test(priority = 11)
	public void CRe4_1035() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1035();
	}

	@Test(priority = 13)
	public void CRe4_1036() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1036();
	}

	@Test(priority = 12)
	public void CRe4_1037() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1037();
	}

	@Test(priority = 14)
	public void CRe4_1038() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1038();
	}

	@Test(priority = 15)
	public void CRe4_1039() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1039();
	}

	@Test(priority = 16)
	public void CRe4_1040() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1040();
	}

	@Test(priority = 17)
	public void CRe4_1041() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1041();
	}

	@Test(priority = 18)
	public void CRe4_1042() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1042();
	}

	@Test(priority = 19)
	public void CRe4_1043() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1043();
	}

	@Test(priority = 20)
	public void CRe4_1044() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1044();
	}

	@Test(priority = 21)
	public void CRe4_1045() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1045();
	}

	@Test(priority = 22)
	public void CRe4_1047() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1047();
	}

	@Test(priority = 23)
	public void CRe4_1048() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1048();
	}

	@Test(priority = 24)
	public void CRe4_1051() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1051();
	}
	
	@Test(priority = 25)
	public void CRe4_1054() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1054();
	}
	
	@Test(priority = 26)
	public void CRe4_1055() throws Exception {

		TS_19 VerifyManageIECMember = new TS_19();

		VerifyManageIECMember.CRe4_1055();
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
