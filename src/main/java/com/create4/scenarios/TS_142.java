package com.create4.scenarios;

import java.io.FileInputStream;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

//Check for schedule meeting mail functionality
public class TS_142 {

	public TS_142() {
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

	@FindBy(xpath = "//span/a")
	WebElement logoutt;

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

	// Check for email to members of scheduled meeting
	public void CRe4_150_151() throws Exception {

		GlobalMethods.MS_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Meetings");

		String Upcoming_Meetings = r1.getCell(2, 123).getContents();
		String venu = r1.getCell(3, 123).getContents();
		String meetingsheading = r1.getCell(4, 123).getContents();
		String meeting_field = r1.getCell(5, 123).getContents();

		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
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
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();

		GlobalMethods.CPLogin();

		String upcomingmeetings_1 = upcomingmeetings.getText();
		Upcoming_Meetings.equalsIgnoreCase(upcomingmeetings_1);
		System.out.println(upcomingmeetings_1);

		WebElement viewalllink = GWait.Wait_GetElementByLinkText("View all");
		viewalllink.click();
		WebElement heading = GWait.Wait_GetElementByXpath("//form[@id='upcomingmeeting']/div/div[2]/h3");
		String heading_1 = heading.getText();
		meetingsheading.equalsIgnoreCase(heading_1);
		System.out.println(heading_1);

		String datefield_1 = datefield.getText();
		meetingcalendardate_1.equalsIgnoreCase(datefield_1);
		System.out.println(datefield_1);
		WebElement meetingfield = GWait.Wait_GetElementByXpath("//form[@id='upcomingmeeting']/div/div[2]/div[3]/div[2]/div/table/tbody/tr/td[3]");
		String meetingfield_1 = meetingfield.getText();
		meeting_field.equalsIgnoreCase(meetingfield_1);
		System.out.println(meetingfield_1);

		String meetingvenue_1 = meetingvenue.getText();
		venu.equalsIgnoreCase(meetingvenue_1);
		System.out.println(meetingvenue_1);
		WebElement logout = GWait.Wait_GetElementByXpath("//span/a");
		logout.click();
		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();

		GlobalMethods.meetingMail(
				"https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Ftab%3Dwm&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin",
				"qualeetee112@gmail.com", "qa@123456");

	}

}
