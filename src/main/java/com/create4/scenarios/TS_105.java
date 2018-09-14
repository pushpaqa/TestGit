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

public class TS_105 {

	public TS_105() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "//div[2]/ul/li[1]/div[2]/div/ul/li[1]/a")
	WebElement UpcomingMtngTXT;
	@FindBy(xpath = "//div[2]/ul/li[1]/div[2]/div/ul/li[2]/a")
	WebElement CompletedMtngTXT;

	public void IECMembersMtg_CRe4_378() throws Exception {

		// ----------IEC Members Login------------//
		GlobalMethods.Member1Login();
		WebElement  MeetingsLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		MeetingsLink.click();
		WebElement  CompletedMeeting = GWait.Wait_GetElementByXpath("//div[2]/ul/li[1]/div[2]/div/ul/li[2]/a");
		CompletedMeeting.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String UpcomingMtngTXT_data = r1.getCell(2, 115).getContents();
		String CompletedMtngTXT_data = r1.getCell(3, 115).getContents();

		// ----Upcoming�Meeting----//
		System.out.println(UpcomingMtngTXT.getText());
		Assert.assertEquals(UpcomingMtngTXT.getText(), UpcomingMtngTXT_data);
		
		// ----Complete�Meeting----//
		System.out.println(CompletedMtngTXT.getText());
		Assert.assertEquals(CompletedMtngTXT.getText(), CompletedMtngTXT_data);

		WebElement  LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}

	// --Check for 'Completed Meeting' tabular fields--//
	public void IECMembersMtg_CRe4_380() throws Exception {
		GlobalMethods.Member1Login();
		WebElement  MeetingsLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		MeetingsLink.click();
		WebElement  CompletedMeeting = GWait.Wait_GetElementByXpath("//div[2]/ul/li[1]/div[2]/div/ul/li[2]/a");
		CompletedMeeting.click();

		WebElement table_element1 = GWait.Wait_GetElementByCSS(".table.table-striped>thead");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//th"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());

			}
		}
		WebElement  LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}

	@FindBy(css = ".form-control")
	WebElement StartDate;

	// ---Check for search with date with Past dates---//
	public void IECMembersMtg_CRe4_381() throws Exception {
		GlobalMethods.Member1Login();
		WebElement  MeetingsLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		MeetingsLink.click();
		WebElement  CompletedMeeting = GWait.Wait_GetElementByXpath("//div[2]/ul/li[1]/div[2]/div/ul/li[2]/a");
		CompletedMeeting.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String PAstdate_data = r1.getCell(2, 117).getContents();

		// -------Start date(Past Date)-------//
		StartDate.sendKeys(PAstdate_data);
		WebElement  SearchBTN = GWait.Wait_GetElementByCSS(".btn.btn-default.btn-orange");
		SearchBTN.click();
		WebElement  LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}

	// ---Check for search with date with Current dates---//
	public void IECMembersMtg_CRe4_382() throws Exception {
		GlobalMethods.Member1Login();
		WebElement  MeetingsLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		MeetingsLink.click();
		WebElement  CompletedMeeting = GWait.Wait_GetElementByXpath("//div[2]/ul/li[1]/div[2]/div/ul/li[2]/a");
		CompletedMeeting.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String Currentdate_data = r1.getCell(2, 119).getContents();

		// -------Start date(Current Date)-------//
		StartDate.clear();
		StartDate.sendKeys(Currentdate_data);
		WebElement  SearchBTN = GWait.Wait_GetElementByCSS(".btn.btn-default.btn-orange");
		SearchBTN.click();
		WebElement  LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}

	@FindBy(css = ".error-msg")
	WebElement ErrorAlert;

	// ---Check for search with blank date---//
	public void IECMembersMtg_CRe4_383() throws Exception {
		GlobalMethods.Member1Login();
		WebElement  MeetingsLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		MeetingsLink.click();
		WebElement  CompletedMeeting = GWait.Wait_GetElementByXpath("//div[2]/ul/li[1]/div[2]/div/ul/li[2]/a");
		CompletedMeeting.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String AlertText_data = r1.getCell(2, 121).getContents();

		StartDate.clear();
		WebElement  SearchBTN = GWait.Wait_GetElementByCSS(".btn.btn-default.btn-orange");
		SearchBTN.click();

		System.out.println(ErrorAlert.getText());
		Assert.assertEquals(ErrorAlert.getText(), AlertText_data);

		WebElement  LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}

	// ---Check for 'Meeting time' column field---//
	public void IECMembersMtg_CRe4_384() throws Exception {
		GlobalMethods.Member1Login();
		WebElement  MeetingsLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		MeetingsLink.click();
		WebElement  CompletedMeeting = GWait.Wait_GetElementByXpath("//div[2]/ul/li[1]/div[2]/div/ul/li[2]/a");
		CompletedMeeting.click();

		WebElement table_element1 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[2]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());

			}
		}
		WebElement  LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}

	// ---Check for 'MOM' column before MS generate mom---//
	public void IECMembersMtg_CRe4_387_388_389() throws Exception {
		GlobalMethods.Member1Login();
		WebElement  MeetingsLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		MeetingsLink.click();
		WebElement  CompletedMeeting = GWait.Wait_GetElementByXpath("//div[2]/ul/li[1]/div[2]/div/ul/li[2]/a");
		CompletedMeeting.click();

		WebElement table_element1 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
			}
		}
		WebElement  LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}

	// ---Check for 'Download MOM' link in agenda column---//
	public void IECMembersMtg_CRe4_390() throws Exception {
		GlobalMethods.Member1Login();
		WebElement  MeetingsLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		MeetingsLink.click();
		WebElement  CompletedMeeting = GWait.Wait_GetElementByXpath("//div[2]/ul/li[1]/div[2]/div/ul/li[2]/a");
		CompletedMeeting.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String DownloadMOM_data = r1.getCell(3, 81).getContents();

		WebElement table_element1 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				if (cell.getText().equalsIgnoreCase(DownloadMOM_data)) {
					cell.click();
					GlobalMethods.AcceptDoenloadPopup();
					WebElement  LogOut = GWait.Wait_GetElementByCSS(".logout");
					LogOut.click();
				}
				break;
			}
			break;
		}

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

	// ---Check for 'View' link functionality---//
	public void IECMembersMtg_CRe4_391_392() throws Exception {
		GlobalMethods.Member1Login();
		WebElement  MeetingsLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		MeetingsLink.click();
		WebElement  CompletedMeeting = GWait.Wait_GetElementByXpath("//div[2]/ul/li[1]/div[2]/div/ul/li[2]/a");
		CompletedMeeting.click();

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
		WebElement  LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();

	}

}
