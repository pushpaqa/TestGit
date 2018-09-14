package com.create4.scenarios;

import java.awt.Robot;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

public class TS_100 {

	public TS_100() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "//div[4]/div/h3")
	WebElement upcomingmeetings;

	@FindBy(linkText = "Meetings")
	WebElement meetings;

	@FindBy(linkText = "Schedule a Meeting")
	WebElement schedulemeeting;

	@FindBy(id = "meeting_title")
	WebElement meetingtitle;

	@FindBy(xpath = "//*[@id='meeting_edate']/input")
	WebElement meetingdate;

	@FindBy(id = "meeting_time")
	WebElement meetingtime;

	@FindBy(xpath = "//*[@id='meeting_venue']")
	WebElement venudetails;

	@FindBy(xpath = "//form[@id='meetingcreate']/div/div[4]/div[3]/div/input[2]")
	WebElement schedulemeetingbutton;

	@FindBy(linkText = "View all")
	WebElement viewalllink;

	@FindBy(xpath = "//form[@id='upcomingmeeting']/div/div[2]/h3")
	WebElement heading;

	@FindBy(css = "img")
	WebElement logo;

	@FindBy(css = "td.word-wrap")
	WebElement datefield;

	@FindBy(xpath = "//form[@id='upcomingmeeting']/div/div[2]/div[3]/div[2]/div/table/tbody/tr/td[3]")
	WebElement meetingfield;

	@FindBy(css = "span.input-group-addon")
	WebElement meetingcalendar;

	@FindBy(xpath = "//div[@id='meeting_edate']/div/ul/li/div/div/table/tbody/tr[3]/td[3]")
	WebElement meetingcalendardate;

	@FindBy(id = "meeting_time")
	WebElement meetingcalendartime;

	@FindBy(xpath = "//form[@id='upcomingmeeting']/div/div[2]/div[3]/div[2]/div/table/tbody/tr/td[4]")
	WebElement meetingvenue;

	@FindBy(xpath = "//div[1]/div/div[2]/ul/li[1]/div[2]/div/ul/li[3]/a")
	WebElement CompletedMeeting;

	@FindBy(xpath = "//html/body/div[4]/div[1]/form/div[1]/div[2]/h3")
	WebElement UpcomingMtngTXT;
	@FindBy(xpath = "//div[1]/form/div[1]/div[2]/div[3]/div[1]/input")
	WebElement SearchTXT;

	public void CRe4_279_280_281() throws Exception {

		// ----------Member Secretary Login------------//
		GlobalMethods.Admin_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String UpcomingMtngTXT_data = r1.getCell(2, 67).getContents();

		// ----Completed�Meeting----//
		System.out.println(UpcomingMtngTXT.getText());
		Assert.assertEquals(UpcomingMtngTXT.getText(), UpcomingMtngTXT_data);
		// ----Search----//
		System.out.println(SearchTXT.getAttribute("value"));
		Assert.assertEquals(SearchTXT.getAttribute("value"), "Search");

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}

	@FindBy(xpath = "//div/table/thead/tr/th[2]/a[1]/span[2]")
	WebElement MeetingTimeTXT;
	@FindBy(xpath = "//div/table/thead/tr/th[3]/a/span[2]")
	WebElement MeetingTitleTXT;
	@FindBy(xpath = "//div/table/thead/tr/th[4]/a/span[2]")
	WebElement VenueTXT;
	@FindBy(xpath = "//div[2]/div/table/thead/tr/th[5]/span")
	WebElement ActionTXT;
	@FindBy(xpath = "//div[2]/div/table/thead/tr/th[6]/span")
	WebElement MOMTXT;

	// ---Check for 'Completed Meeting' tabular fields---//
	public void CRe4_283() throws Exception {
		GlobalMethods.Admin_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String MeetingTimeTXT_data = r1.getCell(2, 69).getContents();
		String MeetingTitleTXT_data = r1.getCell(3, 69).getContents();
		String VenueTXT_data = r1.getCell(4, 69).getContents();
		String ActionTXT_data = r1.getCell(5, 69).getContents();
		String PAstdate_data = r1.getCell(6, 69).getContents();

		// ----Meeting Time----//
		System.out.println(MeetingTimeTXT.getText());
		System.out.println(MeetingTitleTXT.getText());
		System.out.println(VenueTXT.getText());
		System.out.println(ActionTXT.getText());
		System.out.println(MOMTXT.getText());
		
		Assert.assertEquals(MeetingTimeTXT.getText(), MeetingTimeTXT_data);

		// ----Meeting Title----//
		Assert.assertEquals(MeetingTitleTXT.getText(), MeetingTitleTXT_data);

		// ----Venue----//
		Assert.assertEquals(VenueTXT.getText(), VenueTXT_data);

		// ----Action----//
		Assert.assertEquals(ActionTXT.getText(), ActionTXT_data);

		// ----Agenda----//
		Assert.assertEquals(MOMTXT.getText(), "Agenda");

		// -------Start date(Past Date)-------//
		StartDate.sendKeys(PAstdate_data);
		WebElement SearchBTN = GWait.Wait_GetElementByCSS(".btn.btn-default.btn-orange");
		SearchBTN.click();
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}

	@FindBy(css = ".form-control")
	WebElement StartDate;

	// ---Check for search with Future date---//
	public void CRe4_284() throws Exception {
		System.out.println("IECMSMtgCompleted_CRe4_250()");
		GlobalMethods.Admin_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String Futuredate_data = r1.getCell(2, 71).getContents();

		// -------Start date(Future Date)-------//
		StartDate.sendKeys(Futuredate_data);
		WebElement SearchBTN = GWait.Wait_GetElementByCSS(".btn.btn-default.btn-orange");
		SearchBTN.click();

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();

	}

	@FindBy(css = ".error-msg")
	WebElement Date_Alert;

	// ---Check for search with blank date---//
	public void CRe4_286() throws Exception {
		System.out.println("IECMSMtgCompleted_CRe4_252()");
		GlobalMethods.Admin_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String Date_Alert_data = r1.getCell(2, 73).getContents();

		// -------Start date(blank Date)-------//
		StartDate.clear();
		WebElement SearchBTN = GWait.Wait_GetElementByCSS(".btn.btn-default.btn-orange");
		SearchBTN.click();

		// ----Required field alert----//
		System.out.println(Date_Alert.getText());
		Assert.assertEquals(Date_Alert.getText(), Date_Alert_data);
		
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();

	}

	// ---Check for search with current date---//
	public void CRe4_285() throws Exception {
		System.out.println("IECMSMtgCompleted_CRe4_252()");
		GlobalMethods.Admin_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String current_data = r1.getCell(2, 75).getContents();

		// -------Start date(current Date)-------//
		StartDate.clear();
		StartDate.sendKeys(current_data);
		WebElement SearchBTN = GWait.Wait_GetElementByCSS(".btn.btn-default.btn-orange");
		SearchBTN.click();
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();

	}

	// ---Check for 'Agenda not yet generated' column field---//
	public void CRe4_293_294_295() throws Exception {
		System.out.println("IECMSMtgCompleted_CRe4_253_254()");
		GlobalMethods.Admin_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String Agendanotyetgenerated_data = r1.getCell(2, 77).getContents();

		// --Check for 'Agenda not yet generated' column field--//
		WebElement table_element = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(Agendanotyetgenerated_data));
			}
		}

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();

	}

	// ---Check for 'Download agenda' column field---//
	public void CRe4_296() throws Exception {
		System.out.println("IECMSMtgCompleted_CRe4_253_254()");
		GlobalMethods.Admin_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String DownloadAgenda_data = r1.getCell(2, 79).getContents();

		// --Check for 'Agenda not yet generated' column field--//
		WebElement table_element = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(DownloadAgenda_data));
			}
		}

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();

	}

	

	// ---Check for 'Action' column field---//
	public void CRe4_298_299_300() throws Exception {
		System.out.println("IECMSMtgCompleted_CRe4_256_257()");
		GlobalMethods.MS_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("PI_Project_Data");

		String venu = r1.getCell(2, 81).getContents();

		WebElement Meeting = GWait.Wait_GetElementByLinkText("Meetings");
		Meeting.click();
		WebElement schedulemeeting = GWait.Wait_GetElementByLinkText("Schedule a Meeting");
		schedulemeeting.click();
		WebElement meetingtitle = GWait.Wait_GetElementById("meeting_title");
		Select select = new Select(meetingtitle);
		select.selectByVisibleText("Full Board Meeting");
		WebElement meetingcalendar = GWait.Wait_GetElementByCSS("span.input-group-addon");
		meetingcalendar.click();
		WebElement meetingcalendardate = GWait.Wait_GetElementByXpath("//div[@id='meeting_edate']/div/ul/li/div/div/table/tbody/tr[3]/td[3]");
		meetingcalendardate.click();
		String meetingcalendardate_1 = meetingdate.getText();
		String meetingcalendartime_1 = meetingcalendartime.getText();

		String datemeeting = meetingcalendardate_1 + " " + meetingcalendartime_1;
		System.out.println(datemeeting);
		// meetingdate.sendKeys(date);
		// meetingtime.sendKeys(arg0);
		venudetails.sendKeys(venu);
		schedulemeetingbutton.click();
		GlobalMethods.alertaccept();
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		logo.click();
		GlobalMethods.Admin_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		WebElement ViewLink = GWait.Wait_GetElementByCSS(".glyphicon.glyphicon-eye-open");
		ViewLink.click();

		WebElement BackButtonLink = GWait.Wait_GetElementByCSS(".btn.btn-default.first-btn.btn-orange");
		BackButtonLink.click();

	}

}
