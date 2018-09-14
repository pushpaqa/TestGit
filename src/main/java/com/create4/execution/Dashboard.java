package com.create4.execution;

import java.io.FileInputStream;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.create4.scenarios.Verifying_Documentypes;
import com.global.methods.Dashboard_Links;
import com.global.methods.GlobalMethods;

import jxl.Sheet;
import jxl.Workbook;

public class Dashboard  {
	@BeforeMethod
	public void beforeMethod() throws Exception, Exception {
		
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Login");

		String URL = r1.getCell(1,0).getContents();
		String FirefoxBrowser = r1.getCell(1,1).getContents();
		GlobalMethods.LaunchBrowser(FirefoxBrowser, URL);

	}

	/*@Test
	public void ADMINFRWDPROJCONTMS() throws Exception {

		Dashboard_Links i1 = new Dashboard_Links();
		i1.ADMINFRWDPROJCONTMS();

	}*/
	
	@Test
	public void CRe4_doctypename() throws Exception {

		Verifying_Documentypes i1 = new Verifying_Documentypes();
		i1.CRe4_doctypename();

	}

	/*@AfterMethod
	public void tearDown() throws Exception {
		GlobalMethods.driver.close();
		

	}*/

}
