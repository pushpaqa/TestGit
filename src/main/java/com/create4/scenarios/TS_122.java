package com.create4.scenarios;

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

/*
 * Check for 'Upcoming meeting'  section feature functionality in Chairperson dashboard
 */
public class TS_122 {
	
	public TS_122() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
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
	
	@FindBy(css = "th.col-sm-4")
	WebElement heading;
	
	@FindBy(xpath = "//span/a")
	WebElement logoutt;

	@FindBy(css = "img")
	WebElement logo;
	
	@FindBy(css = "th.col-sm-5")
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
	
	
	
	
	
	//Check for upcoming meetings section
	public void CRe4_552_553_554_555_556() throws Exception{

		
		GlobalMethods.MS_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		String Upcoming_Meetings = r1.getCell(2, 33).getContents();

		String date = r1.getCell(3, 33).getContents();
		String venu = r1.getCell(4, 33).getContents();

		String meetingsheading = r1.getCell(5, 33).getContents();
		String date_field = r1.getCell(6, 33).getContents();
		String meeting_field = r1.getCell(7, 33).getContents();

		WebElement meetings = GWait.Wait_GetElementByLinkText("Meetings");
		meetings.click();

		WebElement schedulemeeting = GWait.Wait_GetElementByLinkText("Schedule a Meeting");
		schedulemeeting.click();

		WebElement meetingtitle = GWait.Wait_GetElementById("meeting_title");

		Select select = new Select(meetingtitle);
		select.selectByVisibleText("Full Board Meeting");

		WebElement meetingcalendar = GWait.Wait_GetElementByCSS("span.input-group-addon");
		meetingcalendar.click();

		WebElement meetingcalendardate = GWait.Wait_GetElementByXpath("//div[@id='meeting_edate']/div/ul/li/div/div/table/tbody/tr[3]/td[3]");
		meetingcalendardate.click();

		String meetingcalendardate_1 = meetingdate.getAttribute("value");
		System.out.println(meetingcalendardate_1);
		String meetingcalendartime_1 = meetingcalendartime.getAttribute("value");
		System.out.println(meetingcalendartime_1);

		String strMain = meetingcalendartime_1;
	    String[] arrSplit = strMain.split(" ");
	    
	  
		
		System.out.println(arrSplit[0]);
		
		String datemeeting = meetingcalendardate_1 + " " + "0"+arrSplit[0];
		System.out.println(datemeeting);
		
		String Datelist = datemeeting + " " +"pm";
		System.out.println(Datelist);

		WebElement venudetails = GWait.Wait_GetElementByXpath("//*[@id='meeting_venue']");
		venudetails.sendKeys(venu);

		Thread.sleep(1000);
		WebElement schedulemeetingbutton = GWait.Wait_GetElementByXpath("//form[@id='meetingcreate']/div/div[4]/div[3]/div/input[2]");
		schedulemeetingbutton.click();
		
		Thread.sleep(10000);
		GlobalMethods.alertaccept();

		WebElement logoutt2A = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2A.click();

		WebElement logo1A = GWait.Wait_GetElementByCSS("img");
		logo1A.click();
		
		GlobalMethods.CPLogin();

		Thread.sleep(3000);
		System.out.println(upcomingmeetings.getText());
		Assert.assertEquals(upcomingmeetings.getText().trim(), Upcoming_Meetings);
		
		
		Thread.sleep(3000);
		System.out.println(datefield.getText());
		Assert.assertEquals(datefield.getText().trim(), date_field);

		Thread.sleep(3000);
		System.out.println(heading.getText());
		Assert.assertEquals(heading.getText().trim(), meeting_field);
		
		//working fine in demo
		Thread.sleep(3000);
		System.out.println(datevalue.getText());
		System.out.println(Datelist);
		Assert.assertEquals(datevalue.getText().trim(), Datelist);
		
		Thread.sleep(3000);
		System.out.println(meetingvalue.getText());
		Assert.assertEquals(meetingvalue.getText().trim(), "Full Board Meeting");

		WebElement viewalllink = GWait.Wait_GetElementByLinkText("View all");
		viewalllink.click();

	/*	Thread.sleep(3000);
		String date1 = datevaluein.getText();
		
		
		String strMain1 = date1;
	    String[] arrSplit1 = strMain.split(" ");
	    
	    String datemeetinglist = arrSplit[0] + " " + arrSplit[1];
		
		System.out.println(datemeetinglist);*/
		
		System.out.println(datevaluein.getText());
		Assert.assertEquals(datevaluein.getText().trim(), Datelist);
		
		Thread.sleep(3000);
		System.out.println(meetingvaluein.getText());
		Assert.assertEquals(meetingvaluein.getText().trim(), "Full Board Meeting");
		

		WebElement logoutt2B = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2B.click();

		WebElement logo1B = GWait.Wait_GetElementByCSS("img");
		logo1B.click();
		
		
		
	}
	
	@FindBy(xpath = "//td[2]")
	WebElement meetingvalue;
	
	@FindBy(css = "td.word-wrap")
	WebElement datevaluein;
	
	@FindBy(xpath = "//form[@id='upcomingmeeting']/div/div[2]/div[3]/div[2]/div/table/tbody/tr/td[3]")
	WebElement meetingvaluein;
	
	@FindBy(xpath = "//td")
	WebElement datevalue;

}
