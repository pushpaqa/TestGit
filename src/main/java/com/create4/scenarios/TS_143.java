package com.create4.scenarios;

import java.io.FileInputStream;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

//
public class TS_143 {

	public TS_143() {
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

	@FindBy(css = "span.glyphicon.glyphicon-edit")
	WebElement meetingedit;

	@FindBy(xpath = "//input[@value='Re-schedule Meeting']")
	WebElement meetingeditbutton;

	// form[@id='meetinglist']/div/div[5]/div[2]/div/input[3]

	// Check for email to members of scheduled meeting
	public void CRe4_152_153() throws Exception {

		GlobalMethods.MS_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Meetings");

		String venu = r1.getCell(2, 125).getContents();

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
		WebElement meetingedit = GWait.Wait_GetElementByCSS("span.glyphicon.glyphicon-edit");
		meetingedit.click();
		WebElement meetingeditbutton = GWait.Wait_GetElementByXpath("//input[@value='Re-schedule Meeting']");
		meetingeditbutton.click();
		GlobalMethods.alertaccept();
		WebElement logoutt = GWait.Wait_GetElementByCSS(".logout");
		logoutt.click();
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();

		GlobalMethods.remeetingMail(
				"https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Ftab%3Dwm&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin",
				"qualeetee112@gmail.com", "qa@123456");

	}

}
