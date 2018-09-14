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

public class TS_103 {

	public TS_103() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "//div[2]/ul/li[1]/div[2]/div/ul/li[1]/a")
	WebElement UpcomingMtngTXT;
	@FindBy(xpath = "//div[2]/ul/li[1]/div[2]/div/ul/li[2]/a")
	WebElement CompletedMtngTXT;

	public void IECChairpersonMtg_CRe4_340() throws Exception {

		// ----------IEC Chairpersons Login------------//
		GlobalMethods.CPLogin();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompletedMeeting = GWait.Wait_GetElementByXpath("//div[2]/ul/li[1]/div[2]/div/ul/li[2]/a");
		CompletedMeeting.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String UpcomingMtngTXT_data = r1.getCell(2, 99).getContents();
		String CompletedMtngTXT_data = r1.getCell(3, 99).getContents();
		String SearchDateTXT_data = r1.getCell(4, 99).getContents();
		String SearchBTNTXT_data = r1.getCell(5, 99).getContents();

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

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}

	// --Check for 'Completed Meeting' tabular fields--//
	public void IECChairpersonMtg_CRe4_342() throws Exception {
		GlobalMethods.CPLogin();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompletedMeeting = GWait.Wait_GetElementByXpath("//div[2]/ul/li[1]/div[2]/div/ul/li[2]/a");
		CompletedMeeting.click();

		WebElement table_element1 = GWait.Wait_GetElementByCSS(".table.table-striped>thead");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//th"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());

			}
		}
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}

	@FindBy(css = ".form-control")
	WebElement StartDate;

	// ---Check for search with date with Past dates---//
	public void IECChairpersonMtg_CRe4_343() throws Exception {
		GlobalMethods.CPLogin();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompletedMeeting = GWait.Wait_GetElementByXpath("//div[2]/ul/li[1]/div[2]/div/ul/li[2]/a");
		CompletedMeeting.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String PAstdate_data = r1.getCell(2, 101).getContents();

		// -------Start date(Past Date)-------//
		StartDate.sendKeys(PAstdate_data);
		WebElement SearchBTN = GWait.Wait_GetElementByCSS(".btn.btn-default.btn-orange");
		SearchBTN.click();
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}

	// ---Check for search with date with Current dates---//
	public void IECChairpersonMtg_CRe4_344() throws Exception {
		GlobalMethods.CPLogin();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompletedMeeting = GWait.Wait_GetElementByXpath("//div[2]/ul/li[1]/div[2]/div/ul/li[2]/a");
		CompletedMeeting.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String Currentdate_data = r1.getCell(2, 103).getContents();

		// -------Start date(Current Date)-------//
		StartDate.clear();
		StartDate.sendKeys(Currentdate_data);
		WebElement SearchBTN = GWait.Wait_GetElementByCSS(".btn.btn-default.btn-orange");
		SearchBTN.click();
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}

	@FindBy(css = ".error-msg")
	WebElement ErrorAlert;

	// ---Check for search with blank date---//
	public void IECChairpersonMtg_CRe4_345() throws Exception {
		GlobalMethods.CPLogin();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompletedMeeting = GWait.Wait_GetElementByXpath("//div[2]/ul/li[1]/div[2]/div/ul/li[2]/a");
		CompletedMeeting.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String AlertText_data = r1.getCell(2, 105).getContents();

		StartDate.clear();
		WebElement SearchBTN = GWait.Wait_GetElementByCSS(".btn.btn-default.btn-orange");
		SearchBTN.click();

		System.out.println(ErrorAlert.getText());
		Assert.assertEquals(ErrorAlert.getText(), AlertText_data);

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}

	// ---Check for 'Meeting time' column field---//
	public void IECChairpersonMtg_CRe4_346() throws Exception {
		GlobalMethods.CPLogin();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompletedMeeting = GWait.Wait_GetElementByXpath("//div[2]/ul/li[1]/div[2]/div/ul/li[2]/a");
		CompletedMeeting.click();

		WebElement table_element1 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[2]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());

			}
		}
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}

	// ---Check for 'Meeting Title' column field---//
	public void IECChairpersonMtg_CRe4_347() throws Exception {

		GlobalMethods.CPLogin();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompletedMeeting = GWait.Wait_GetElementByXpath("//div[2]/ul/li[1]/div[2]/div/ul/li[2]/a");
		CompletedMeeting.click();

		WebElement table_element1 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[3]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());

			}
		}
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}

	// ---Check for 'MOM' column before MS generate mom---//
	public void IECChairpersonMtg_CRe4_349_350() throws Exception {
		GlobalMethods.CPLogin();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompletedMeeting = GWait.Wait_GetElementByXpath("//div[2]/ul/li[1]/div[2]/div/ul/li[2]/a");
		CompletedMeeting.click();

		WebElement table_element1 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());

			}
		}
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
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

	// ---Check for 'View' link functionality---//
	public void CRe4_353_354() throws Exception {
		GlobalMethods.CPLogin();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompletedMeeting = GWait.Wait_GetElementByXpath("//div[2]/ul/li[1]/div[2]/div/ul/li[2]/a");
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
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();

	}
}
