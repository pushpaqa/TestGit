package com.create4.scenarios;

import java.io.FileInputStream;

import org.openqa.selenium.JavascriptExecutor;
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

public class TS_95 {

	public TS_95() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}
GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "html/body/div[4]/div/div[1]/div[2]/h3")
	WebElement ScheMeetPageTXT;
	@FindBy(id = "meeting_title")
	WebElement MeetingTitle;
	@FindBy(css = ".form-control")
	WebElement Date;
	@FindBy(css = "#meeting_time")
	WebElement Time;
	@FindBy(id = "meeting_venue")
	WebElement Venue;

	@FindBy(css = ".logout")
	WebElement LogOut;

	
	public void CRe4_162_164() throws Exception {

		// ----------Member Secretary Login------------//
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String ScheMeetPageTXT_data = r1.getCell(2, 1).getContents();
		String MeetingTitle_data = r1.getCell(3, 1).getContents();
		String Date_data = r1.getCell(4, 1).getContents();
		String Time_data = r1.getCell(5, 1).getContents();
		String Venue_data = r1.getCell(6, 1).getContents();

		for (int i = 0; i <= 1; i++) {
			
			WebElement ScheduleMeet = GWait.Wait_GetElementByXpath("html/body/div[4]/div[1]/form/div[1]/div[2]/div[3]/a");
			ScheduleMeet.click();
			

			// ----Schedule�a�Meeting----//
			System.out.println(ScheMeetPageTXT.getText());
			if (ScheMeetPageTXT.getText().equalsIgnoreCase(ScheMeetPageTXT_data)) {
				System.out.println(ScheMeetPageTXT.getText().equalsIgnoreCase(ScheMeetPageTXT_data));
			} else {
				System.out.println("Test Fail Schedule�a�Meeting");
			}
			WebElement MeetingTitle = GWait.Wait_GetElementById("meeting_title");
			System.out.println(MeetingTitle.getText());
			
			Select MT = new Select(MeetingTitle);
			MT.selectByVisibleText(MeetingTitle_data);
			Date.sendKeys(Date_data);
			Time.clear();
			Time.sendKeys(Time_data);
//			JavascriptExecutor executor = (JavascriptExecutor) GlobalMethods.driver;
//			executor.executeScript("window.document.getElementById('meeting_time').value = '5:30 PM'");
			Venue.sendKeys(Venue_data);
			WebElement SchMettingBTN = GWait.Wait_GetElementByXpath("//input[@value='Schedule Meeting']");
			SchMettingBTN.click();
			GlobalMethods.alertaccept();
		}

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();

	}
	
	@FindBy(xpath = "//div[2]/div[3]/form/div/div[1]/label")
	WebElement MettingTitle_TXT;
	@FindBy(xpath = "//div[2]/div[3]/form/div/div[2]/label")
	WebElement Date_TXT;
	@FindBy(xpath = "//div[2]/div[3]/form/div/div[3]/label")
	WebElement Venue_TXT;
	@FindBy(xpath = "//div[2]/div[3]/form/div/div[4]/label")
	WebElement MIM_TXT;
	
	public void CRe4_165_166_171() throws Exception {

		// ----------Member Secretary Login------------//
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String ScheMeetPageTXT_data = r1.getCell(2, 3).getContents();
		
		String MeetingTitle_data = r1.getCell(3, 3).getContents();
		String Date_data = r1.getCell(4, 3).getContents();
		String Time_data = r1.getCell(5, 3).getContents();
		String Venue_data = r1.getCell(6, 3).getContents();
		
		String MettingTitle_TXT_data = r1.getCell(7, 3).getContents();
		String Date_TXT_data = r1.getCell(8, 3).getContents();
		String Venue_TXT_data = r1.getCell(9, 3).getContents();
		String MIM_TXT_data = r1.getCell(10, 3).getContents();

		for (int i = 0; i <= 1; i++) {
			
			WebElement ScheduleMeet = GWait.Wait_GetElementByXpath("//div[1]/div/div[2]/ul/li[1]/div[2]/div/ul/li[2]/a");
			ScheduleMeet.click();

			// ----Schedule�a�Meeting----//
			System.out.println(ScheMeetPageTXT.getText());
			System.out.println(MettingTitle_TXT.getText());
			System.out.println(Date_TXT.getText());
			System.out.println(Venue_TXT.getText());
			System.out.println(MIM_TXT.getText());
			
			Assert.assertEquals(ScheMeetPageTXT.getText(), ScheMeetPageTXT_data);
			Assert.assertEquals(MettingTitle_TXT.getText(), MettingTitle_TXT_data);
			Assert.assertEquals(Date_TXT.getText(), Date_TXT_data);
			Assert.assertEquals(Venue_TXT.getText(), Venue_TXT_data);
			Assert.assertEquals(MIM_TXT.getText(), MIM_TXT_data);
			
			WebElement MeetingTitle = GWait.Wait_GetElementById("meeting_title");
			System.out.println(MeetingTitle.getText());
			
			Assert.assertEquals(ScheMeetPageTXT.getText(), ScheMeetPageTXT_data);
			
			Select MT = new Select(MeetingTitle);
			MT.selectByVisibleText(MeetingTitle_data);
			Date.sendKeys(Date_data);
			Time.clear();
			Time.sendKeys(Time_data);
//			JavascriptExecutor executor = (JavascriptExecutor) GlobalMethods.driver;
//			executor.executeScript("window.document.getElementById('meeting_time').value = '5:30 PM'");
			Venue.sendKeys(Venue_data);
			WebElement SchMettingBTN = GWait.Wait_GetElementByXpath("//input[@value='Schedule Meeting']");
			SchMettingBTN.click();
			GlobalMethods.alertaccept();
		}

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();

	}

	// -----Alert--------//
	@FindBy(xpath = "//div[2]/div[3]/form/div/div[1]/div/p")
	WebElement MettingTitle_Alert;
	@FindBy(xpath = "//div[2]/div[3]/form/div/div[2]/div[1]/p")
	WebElement Date_Alert;
	@FindBy(xpath = "//div[2]/div[3]/form/div/div[3]/div/p")
	WebElement Venue_Alert;

	public void CRe4_167_168_169() throws Exception {
		
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement ScheduleMeet = GWait.Wait_GetElementByXpath("html/body/div[4]/div[1]/form/div[1]/div[2]/div[3]/a");
		ScheduleMeet.click();
		
		WebElement SchMettingBTN = GWait.Wait_GetElementByXpath("//input[@value='Schedule Meeting']");
		SchMettingBTN.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String MTAlert_data = r1.getCell(2, 5).getContents();
		String DateAlert_data = r1.getCell(3, 5).getContents();
		String VanueAlert_data = r1.getCell(4, 5).getContents();

		// ----Alert----//
		// ----Schedule�a�Meeting----//
		System.out.println(MettingTitle_Alert.getText());
		if (MettingTitle_Alert.getText().equalsIgnoreCase(MTAlert_data)) {
			System.out.println(MettingTitle_Alert.getText().equalsIgnoreCase(MTAlert_data));
		} else {
			System.out.println("Test Fail Schedule�a�Meeting Alert");
		}

		// ----Date----//
		System.out.println(Date_Alert.getText());
		if (Date_Alert.getText().equalsIgnoreCase(DateAlert_data)) {
			System.out.println(Date_Alert.getText().equalsIgnoreCase(DateAlert_data));
		} else {
			System.out.println("Test Fail Date Alert");
		}
		// ----Vanue----//
		System.out.println(Venue_Alert.getText());
		if (Venue_Alert.getText().equalsIgnoreCase(VanueAlert_data)) {
			System.out.println(Venue_Alert.getText().equalsIgnoreCase(VanueAlert_data));
		} else {
			System.out.println("Test Fail Vanue Alert");
		}
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}
	
	public void CRe4_170() throws Exception {

		// ----------Member Secretary Login------------//
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String ScheMeetPageTXT_data = r1.getCell(2, 7).getContents();
		String MeetingTitle_data = r1.getCell(3, 7).getContents();
		String Date_data = r1.getCell(4, 7).getContents();
		String Time_data = r1.getCell(5, 7).getContents();
		String Venue_data = r1.getCell(6, 7).getContents();

		for (int i = 0; i < 1; i++) {
			
			WebElement ScheduleMeet = GWait.Wait_GetElementByXpath("//div[1]/div/div[2]/ul/li[1]/div[2]/div/ul/li[2]/a");
			ScheduleMeet.click();

			// ----Schedule�a�Meeting----//
			System.out.println(ScheMeetPageTXT.getText());
			Assert.assertEquals(ScheMeetPageTXT.getText(), ScheMeetPageTXT_data);
			
			WebElement MeetingTitle = GWait.Wait_GetElementById("meeting_title");
			System.out.println(MeetingTitle.getText());
			
			
			
			Select MT = new Select(MeetingTitle);
			MT.selectByVisibleText(MeetingTitle_data);
			Date.sendKeys(Date_data);
			Time.clear();
			Time.sendKeys(Time_data);
//			JavascriptExecutor executor = (JavascriptExecutor) GlobalMethods.driver;
//			executor.executeScript("window.document.getElementById('meeting_time').value = '5:30 PM'");
			Venue.sendKeys(Venue_data);
			WebElement SchMettingBTN = GWait.Wait_GetElementByXpath("//input[@value='Schedule Meeting']");
			SchMettingBTN.click();
			GlobalMethods.alertaccept();
		}

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();

	}

}
