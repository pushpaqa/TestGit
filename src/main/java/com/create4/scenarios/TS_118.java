package com.create4.scenarios;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

/*
 * Check for 'Announcement' section feature functionality in Member Secretary dashboard
 */
public class TS_118 {
	public TS_118() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);


	// Check for 'Announcements' on dashboard
	public void CRe4_511_512_514() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		String announce_title = r1.getCell(2, 27).getContents();
		String announce_desc = r1.getCell(3, 27).getContents();
		String announce_file = r1.getCell(4, 27).getContents();
		String announce_date = r1.getCell(5, 27).getContents();
		String announce_acknowledge = r1.getCell(6, 27).getContents();

		GlobalMethods.MS_Login();

		WebElement Link_Announcements = GWait.Wait_GetElementByLinkText("Announcements");
		Link_Announcements.click();

		WebElement manage_add_announcement = GWait.Wait_GetElementByLinkText("Add Announcement");
		manage_add_announcement.click();

		WebElement manage_add_announcement_title = GWait.Wait_GetElementById("add_announcement_title");
		manage_add_announcement_title.sendKeys(announce_title);

		WebElement manage_add_announcement_description = GWait.Wait_GetElementById("add_announcement_description");
		manage_add_announcement_description.sendKeys(announce_desc);

		WebElement manage_add_announcement_notification_date = GWait
				.Wait_GetElementById("add_announcement_notification_date");
		manage_add_announcement_notification_date.sendKeys(announce_date);

		WebElement manage_add_announcement_notification_file_1 = GWait
				.Wait_GetElementById("add_announcement_notification_file_1");
		manage_add_announcement_notification_file_1.sendKeys(announce_file);

		WebElement manage_add_announcement_notification_details = GWait
				.Wait_GetElementById("add_announcement_notification_details");
		manage_add_announcement_notification_details.click();

		Assert.assertEquals(manage_acknowledge.getText(), announce_acknowledge);

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();

		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();

		GlobalMethods.MS_Login();

		Assert.assertEquals(announceheading.getText(), "Announcements");

		WebElement announcementdashlink = GWait.Wait_GetElementByCSS("ul.submitions-list.list > li > a > span");
		announcementdashlink.click();

		Thread.sleep(1000);
		System.out.println(announcetitle.getText());
		Assert.assertEquals(announcetitle.getText(), announce_title);

		System.out.println(announcedes.getText());
		Assert.assertEquals(announcedes.getText(), announce_desc);

		System.out.println(announcedate.getText());
		Assert.assertEquals(announcedate.getText(), announce_date);

		System.out.println(announcestat.getText());
		Assert.assertEquals(announcestat.getText(), "Active");

		WebElement logoutt1 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt1.click();

		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();

	}

	@FindBy(xpath = "//form[@id='manageannouncementlist']/div/p")
	WebElement manage_acknowledge;

	@FindBy(xpath = "//div[5]/div/h3")
	WebElement announceheading;

	@FindBy(css = "span.text-green")
	WebElement announcetitle;

	@FindBy(css = "div.col-sm-9 > p")
	WebElement announcedes;

	@FindBy(xpath = "//div[3]/div[2]/p")
	WebElement announcedate;

	@FindBy(xpath = "//div[4]/div[2]/p")
	WebElement announcestat;
}
