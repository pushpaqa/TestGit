package com.create4.scenarios;

import java.io.FileInputStream;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

public class TS_102 {

	public TS_102() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "//div[2]/ul/li[1]/div[2]/div/ul/li[1]/a")
	WebElement UpcomingMeeting;

	@FindBy(xpath = "//div[2]/ul/li[1]/div[2]/div/ul/li[1]/a")
	WebElement UpcomingMtngTXT;
	@FindBy(xpath = "//div[2]/ul/li[1]/div[2]/div/ul/li[2]/a")
	WebElement CompletedMtngTXT;

	public void IECMSMtg_CRe4_317_318_319() throws Exception {

		// ----------IEC Chairpersons Login------------//
		GlobalMethods.CPLogin();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String UpcomingMtngTXT_data = r1.getCell(2, 91).getContents();
		String CompletedMtngTXT_data = r1.getCell(3, 91).getContents();
		String SearchDateTXT_data = r1.getCell(4, 91).getContents();
		String SearchBTNTXT_data = r1.getCell(5, 91).getContents();

		// ----Upcoming�Meeting----//
		System.out.println(UpcomingMtngTXT.getText());
		Assert.assertEquals(UpcomingMtngTXT.getText(), UpcomingMtngTXT_data);
		
		// ----Complete�Meeting----//
		System.out.println(CompletedMtngTXT.getText());
		Assert.assertEquals(CompletedMtngTXT.getText(), CompletedMtngTXT_data);
		
		// ----Date----//
		WebElement SearchDate = GWait.Wait_GetElementByXpath("//form/div[1]/div[2]/div[3]/div[1]/label");
		System.out.println(SearchDate.getText());
		Assert.assertEquals(SearchDate.getText(), SearchDateTXT_data);
		WebElement SearchBTN = GWait.Wait_GetElementByCSS(".btn.btn-default.btn-orange");
		System.out.println(SearchBTN.getAttribute("value"));
		Assert.assertEquals(SearchBTN.getAttribute("value"), SearchBTNTXT_data);
		
		WebElement LogOut = GWait.Wait_GetElementByXpath("//span/a");
		LogOut.click();
	}

	public void IECMSMtg_CRe4_320() throws Exception {
		GlobalMethods.CPLogin();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		WebElement table_element1 = GWait.Wait_GetElementByCSS(".table.table-striped>thead");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//th"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());

			}
		}
		WebElement LogOut = GWait.Wait_GetElementByXpath("//span/a");
		LogOut.click();
	}

	@FindBy(css = ".form-control")
	WebElement StartDate;
	
	// ---Check for search with date with past dates---//
		public void IECMSMtg_CRe4_321() throws Exception {
			GlobalMethods.CPLogin();
			WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
			Meeting_Link.click();

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("Meetings");

			String Pastdate_data = r1.getCell(2, 93).getContents();

			// -------Start date(Past Date)-------//
			StartDate.sendKeys(Pastdate_data);
			WebElement SearchBTN = GWait.Wait_GetElementByCSS(".btn.btn-default.btn-orange");
			SearchBTN.click();
			WebElement LogOut = GWait.Wait_GetElementByXpath("//span/a");
			LogOut.click();
		}

	// ---Check for search with date with Feature dates---//
	public void IECMSMtg_CRe4_322() throws Exception {
		GlobalMethods.CPLogin();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String Featuredate_data = r1.getCell(2, 93).getContents();

		// -------Start date(Past Date)-------//
		StartDate.sendKeys(Featuredate_data);
		WebElement SearchBTN = GWait.Wait_GetElementByCSS(".btn.btn-default.btn-orange");
		SearchBTN.click();
		WebElement LogOut = GWait.Wait_GetElementByXpath("//span/a");
		LogOut.click();
	}

	// ---Check for search with date with Current dates---//
	public void IECMSMtg_CRe4_323() throws Exception {
		GlobalMethods.CPLogin();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String Currentdate_data = r1.getCell(2, 95).getContents();

		// -------Start date(Current Date)-------//
		StartDate.clear();
		StartDate.sendKeys(Currentdate_data);
		WebElement SearchBTN = GWait.Wait_GetElementByCSS(".btn.btn-default.btn-orange");
		SearchBTN.click();
		WebElement LogOut = GWait.Wait_GetElementByXpath("//span/a");
		LogOut.click();
	}

	@FindBy(css = ".error-msg")
	WebElement ErrorAlert;

	// ---Check for search with blank date---//
	public void IECMSMtg_CRe4_324() throws Exception {
		GlobalMethods.CPLogin();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String AlertText_data = r1.getCell(2, 97).getContents();

		StartDate.clear();
		WebElement SearchBTN = GWait.Wait_GetElementByCSS(".btn.btn-default.btn-orange");
		SearchBTN.click();

		System.out.println(ErrorAlert.getText());
		Assert.assertEquals(ErrorAlert.getText(), AlertText_data);

		WebElement LogOut = GWait.Wait_GetElementByXpath("//span/a");
		LogOut.click();
	}

	// ---Check for 'Agenda' column after MS generates agenda---//
	public void IECMSMtg_CRe4_333_334() throws Exception {
		GlobalMethods.CPLogin();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		WebElement table_element1 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());

			}
		}
		WebElement LogOut = GWait.Wait_GetElementByXpath("//span/a");
		LogOut.click();
	}

	@FindBy(xpath = "//div[3]/form/div/div[1]")
	WebElement MTNGTitleTXT;
	@FindBy(xpath = "//div[3]/form/div/div[2]")
	WebElement DateTXT;
	@FindBy(xpath = "//div[3]/form/div/div[3]")
	WebElement VenueTXT;
	@FindBy(xpath = "//div[3]/form/div/div[4]")
	WebElement MembersIFMTXT;

	@FindBy(xpath = "//div[3]/form/div/div[5]/div[2]/div/button")
	WebElement BackLink;

	// ---Check for 'View' column field---//
	public void IECMSMtg_CRe4_337_338() throws Exception {

		GlobalMethods.CPLogin();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		WebElement table_element1 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row
					.findElements(By.cssSelector(".glyphicon.glyphicon-eye-open"));
			for (WebElement cell : cells) {
				cell.click();

				System.out.println(MTNGTitleTXT.getText());
				System.out.println(DateTXT.getText());
				System.out.println(VenueTXT.getText());
				System.out.println(MembersIFMTXT.getText());

				WebElement BackLink = GWait.Wait_GetElementByXpath("//div[3]/form/div/div[5]/div[2]/div/button");
				BackLink.click();
				break;
			}

			break;
		}
		WebElement LogOut = GWait.Wait_GetElementByXpath("//span/a");
		LogOut.click();

	}
}
