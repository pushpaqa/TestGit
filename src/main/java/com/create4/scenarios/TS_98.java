package com.create4.scenarios;

import java.io.FileInputStream;

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

public class TS_98 {

	public TS_98() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}
GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "html/body/div[4]/div[1]/form/div[1]/div[2]/h3")
	WebElement UpcomingMeetingsTXT;

	// ------Text------//
	@FindBy(xpath = "//div[2]/div[3]/form/div/div[1]/label")
	WebElement MeetingTitle_TXT;
	@FindBy(xpath = "//div[2]/div[3]/form/div/div[2]/label")
	WebElement Date_TXT;
	@FindBy(xpath = "//div[2]/div[3]/form/div/div[3]/label")
	WebElement Vanue_TXT;
	@FindBy(xpath = "//div[2]/div[3]/form/div/div[4]/label")
	WebElement Members_TXT;

	public void CRe4_241() throws Exception {

		// ----------Member Secretary Login------------//
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String UpcomingMeetingsTXT_data = r1.getCell(2, 37).getContents();
		String MeetingTitle_TXT_data = r1.getCell(3, 37).getContents();
		String Date_TXT_data = r1.getCell(4, 37).getContents();
		String Vanue_TXT_data = r1.getCell(5, 37).getContents();
		String Members_TXT_data = r1.getCell(6, 37).getContents();

		// ----Upcoming�Meeting----//
		System.out.println(UpcomingMeetingsTXT.getText());
		Assert.assertEquals(UpcomingMeetingsTXT.getText(), UpcomingMeetingsTXT_data);

		WebElement Edit_Link = GWait.Wait_GetElementByCSS(".glyphicon.glyphicon-edit");
		Edit_Link.click();

		// ----Meeting Title----//
		System.out.println(MeetingTitle_TXT.getText());
		Assert.assertEquals(MeetingTitle_TXT.getText(), MeetingTitle_TXT_data);

		// ----Date----//
		System.out.println(Date_TXT.getText());
		Assert.assertEquals(Date_TXT.getText(), Date_TXT_data);

		// ----Venue----//
		System.out.println(Vanue_TXT.getText());
		Assert.assertEquals(Vanue_TXT.getText(), Vanue_TXT_data);

		// ----Members----//
		System.out.println(Members_TXT.getText());
		Assert.assertEquals(Members_TXT.getText(), Members_TXT_data);
		
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		
	}

	@FindBy(css = ".form-control")
	WebElement StartDate;


	// ---Check for search with date with future dates--//
	public void CRe4_242() throws Exception {
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		
		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String PStartdate_data = r1.getCell(2, 39).getContents();

		// -------Start date(Future Date)-------//
		StartDate.sendKeys(PStartdate_data);
		WebElement SearchBTN = GWait.Wait_GetElementByXpath("//div[1]/form/div[1]/div[2]/div[3]/div[1]/input");
		SearchBTN.click();
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();

	}

	@FindBy(css = ".form-control")
	WebElement Date;
	@FindBy(css = "#meeting_time")
	WebElement Time;
	@FindBy(id = "meeting_venue")
	WebElement Venue;

	@FindBy(css = ".logout")
	WebElement LogOut;
	@FindBy(xpath = "//input[@value='Re-schedule Meeting']")
	WebElement ReSchMettingBTN;

	@FindBy(css = ".bg-success.text-success.col-sm-12.text-center")
	WebElement ReShdlPopupMess;

	//--Check for Reschedule meeting--acknowledge message--//
	public void CRe4_243_245() throws Exception {
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String MeetingTitle_data = r1.getCell(2, 41).getContents();
		String Date_data = r1.getCell(3, 41).getContents();
		String Time_data = r1.getCell(4, 41).getContents();
		String Venue_data = r1.getCell(5, 41).getContents();

		// -------Start date(Future Date)-------//
//		Thread.sleep(1000);
//		StartDate.sendKeys(PStartdate_data);
//		Thread.sleep(4000);
//		SearchBTN.click();
		
		WebElement Edit_Link = GWait.Wait_GetElementByCSS(".glyphicon.glyphicon-edit");
		Edit_Link.click();
		WebElement MeetingTitle = GWait.Wait_GetElementById("meeting_title");
		System.out.println(MeetingTitle.getText());
		Select MT = new Select(MeetingTitle);
		MT.selectByVisibleText(MeetingTitle_data);
		Date.clear();
		Date.sendKeys(Date_data);
		Time.clear();
		Time.sendKeys(Time_data);
		Venue.clear();
		Venue.sendKeys(Venue_data);
		WebElement ReSchMettingBTN = GWait.Wait_GetElementByXpath("//input[@value='Re-schedule Meeting']");
		ReSchMettingBTN.click();
		
		GlobalMethods.alertaccept();

		WebElement ReShdlPopupMess = GWait.Wait_GetElementByCSS(".bg-success.text-success.col-sm-12.text-center");
		System.out.println(ReShdlPopupMess.getText());
		
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		

	}

	//--Check for blank data--//
	public void CRe4_244() throws Exception {
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement Edit_Link = GWait.Wait_GetElementByCSS(".glyphicon.glyphicon-edit");
		Edit_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String MeetingTitle_data = r1.getCell(2, 43).getContents();

		WebElement MeetingTitle = GWait.Wait_GetElementById("meeting_title");
		System.out.println(MeetingTitle.getText());
		Select MT = new Select(MeetingTitle);
		MT.selectByVisibleText(MeetingTitle_data);
		Date.clear();
		Time.clear();
		Venue.clear();
		WebElement ReSchMettingBTN = GWait.Wait_GetElementByXpath("//input[@value='Re-schedule Meeting']");
		ReSchMettingBTN.click();
		
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();

	}

}
