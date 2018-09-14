package com.create4.scenarios;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

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

public class TS_96 {
	public TS_96() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}
GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "html/body/div[4]/div[1]/form/div[1]/div[2]/h3")
	WebElement UpcomingMeetingsTXT;

	@FindBy(id = "pdf")
	WebElement GenerateAgenda;
	@FindBy(css = ".form-control")
	WebElement StartDate;
	@FindBy(xpath = "//div[3]/div[1]/form/div[2]/div/div/div/div/input")
	WebElement EndDate;
	@FindBy(xpath = "//div[3]/div[1]/form/div[3]/div/input[2]")
	WebElement SearchBTN;

	@FindBy(xpath = "//a[contains(text(),'Expedited Review')]")
	WebElement ExpeditedReview;
	@FindBy(xpath = "//a[contains(text(),'Exempt from Review')]")
	WebElement ExemptFromReview;
	@FindBy(xpath = "//div[1]/div/div[2]/div[4]/div/ul/li[1]/a")
	WebElement FullBoardReview;
	@FindBy(xpath = "//div[2]/div[4]/div/div/div[4]/form/input[2]")
	WebElement GMA;

	@FindBy(xpath = "//div[1]/div/div[2]/ul/li[1]/div[2]/div/ul/li[1]/a")
	WebElement UpcomingMeeting;

	public void CRe4_187() throws Exception {

		// ----------Member Secretary Login------------//
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String UpcomingMeetingsTXT_data = r1.getCell(2, 9).getContents();
		String Startdate_data = r1.getCell(3, 9).getContents();
		String Enddate_data = r1.getCell(4, 9).getContents();
		String ExpeditedReview_data = r1.getCell(5, 9).getContents();
		String ExemptFromReview_data = r1.getCell(6, 9).getContents();
		String GMA_data = r1.getCell(7, 9).getContents();

		// ----Upcoming�Meeting----//
		/*Thread.sleep(2000);
		UpcomingMeeting.click();*/
		WebElement UpcomingMeetingsTXT = GWait.Wait_GetElementByXpath("html/body/div[4]/div[1]/form/div[1]/div[2]/h3");
		
		System.out.println(UpcomingMeetingsTXT.getText());
		Assert.assertEquals(UpcomingMeetingsTXT.getText(), UpcomingMeetingsTXT_data);

		for (int i = 0; i <= 0; i++) {
			WebElement GenerateAgenda = GWait.Wait_GetElementById("pdf");
			GenerateAgenda.click();

			// -------Start date-------//
			StartDate.sendKeys(Startdate_data);

			// -------End date-------//
			EndDate.sendKeys(Enddate_data);
			WebElement SearchBTN = GWait.Wait_GetElementByXpath("//div[3]/div[1]/form/div[3]/div/input[2]");
			SearchBTN.click();

			// ------Expedited Review-----//
			if (ExpeditedReview.getText().equalsIgnoreCase(ExpeditedReview_data)) {
				WebElement ExpeditedReview = GWait.Wait_GetElementByXpath("//a[contains(text(),'Expedited Review')]");
				ExpeditedReview.click();

			}
			if (ExemptFromReview.getText().equalsIgnoreCase(ExemptFromReview_data)) {
				WebElement ExemptFromReview = GWait.Wait_GetElementByXpath("//a[contains(text(),'Exempt from Review')]");
				ExemptFromReview.click();
			}
			
			WebElement FullBoardReview = GWait.Wait_GetElementByXpath("//div[1]/div/div[2]/div[4]/div/ul/li[1]/a");
			FullBoardReview.click();

			System.out.println(GMA.getAttribute("value"));
			if (GMA.getAttribute("value").equalsIgnoreCase(GMA_data)) {

				WebElement GMA = GWait.Wait_GetElementByXpath("//div[2]/div[4]/div/div/div[4]/form/input[2]");
				GMA.click();

				GlobalMethods.AcceptDoenloadPopup();
				

			} else {
				System.out.println("Test Fail Generate Meeting Agenda");
			}
		}
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();

	}

	@FindBy(xpath = "//div[3]/div[1]/form/div[2]/div/div/p")
	WebElement EndDate_Alert;

	// --------Check for Search with blank data----//
	public void CRe4_191_192() throws Exception {
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String EndDate_Alert_data = r1.getCell(2, 11).getContents();
		String Startdate_data = r1.getCell(3, 11).getContents();

		WebElement GenerateAgenda = GWait.Wait_GetElementById("pdf");
		GenerateAgenda.click();
		
		WebElement SearchBTN = GWait.Wait_GetElementByXpath("//div[3]/div[1]/form/div[3]/div/input[2]");
		SearchBTN.click();

		// ----EndDate_Alert----//
		System.out.println(EndDate_Alert.getText());
		if (EndDate_Alert.getText().equalsIgnoreCase(EndDate_Alert_data)) {
			System.out.println(EndDate_Alert.getText().equalsIgnoreCase(EndDate_Alert_data));
		} else {
//			System.out.println("Test Fail EndDate_Alert");
		}

		// -----Check for Search with only start date---//
		StartDate.sendKeys(Startdate_data);
		WebElement SearchBTN1 = GWait.Wait_GetElementByXpath("//div[3]/div[1]/form/div[3]/div/input[2]");
		SearchBTN1.click();
		// ----EndDate_Alert----//
		System.out.println(EndDate_Alert.getText());
		if (EndDate_Alert.getText().equalsIgnoreCase(EndDate_Alert_data)) {
			System.out.println(EndDate_Alert.getText().equalsIgnoreCase(EndDate_Alert_data));
		} else {
			System.out.println("Test Fail 2nd EndDate_Alert");
		}
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();

	}

	@FindBy(xpath = "//div[3]/div[2]/div/table/tbody/tr[1]/td[6]/a[2]")
	WebElement GeneratedMeetingAgenda;

	// ---Check for Search with only End date----//
	public void CRe4_193_194() throws Exception {
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement GenerateAgenda = GWait.Wait_GetElementById("pdf");
		GenerateAgenda.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String Enddate_data = r1.getCell(2, 13).getContents();
		StartDate.clear();
		EndDate.clear();
		EndDate.sendKeys(Enddate_data);
		WebElement SearchBTN = GWait.Wait_GetElementByXpath("//div[3]/div[1]/form/div[3]/div/input[2]");
		SearchBTN.click();
		WebElement FullBoardReview = GWait.Wait_GetElementByXpath("//div[1]/div/div[2]/div[4]/div/ul/li[1]/a");
		FullBoardReview.click();
		
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}

	// ----Check for generated document in upcoming meeting list----//
	public void CRe4_204_209() throws Exception {
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement GenerateAgenda = GWait.Wait_GetElementById("pdf");
		GenerateAgenda.click();
		
		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String Enddate_data = r1.getCell(2, 15).getContents();
		StartDate.clear();
		EndDate.clear();
		EndDate.sendKeys(Enddate_data);
		WebElement SearchBTN = GWait.Wait_GetElementByXpath("//div[3]/div[1]/form/div[3]/div/input[2]");
		SearchBTN.click();
		
		WebElement UpcomingMeeting = GWait.Wait_GetElementByXpath("//div[1]/div/div[2]/ul/li[1]/div[2]/div/ul/li[1]/a");
		UpcomingMeeting.click();
		WebElement GeneratedMeetingAgenda = GWait.Wait_GetElementByXpath("//div[3]/div[2]/div/table/tbody/tr[1]/td[6]/a[2]");
		GeneratedMeetingAgenda.click();
		GlobalMethods.AcceptDoenloadPopup();
		
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}

	@FindBy(css = ".ajax-file-upload")
	WebElement UploadBTN;

	@FindBy(css = ".logout")
	WebElement LogOut;

	// ----Check for upload option in upcoming meetings----//
	public void CRe4_210_211_212() throws Exception {
		
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String Upload_data = r1.getCell(2, 17).getContents();

		// ----Upload----//
		System.out.println(UploadBTN.getText());
		if (UploadBTN.getText().equalsIgnoreCase(Upload_data)) {
			System.out.println(UploadBTN.getText().equalsIgnoreCase(Upload_data));
		} else {
			System.out.println("Test Fail Upload");
		}

		WebElement UploadBTN = GWait.Wait_GetElementByCSS(".ajax-file-upload");
		UploadBTN.click();

		StringSelection s = new StringSelection("C:\\Selenium_Files\\Create Docs\\GeneratedMeetingAgenda.doc");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		Robot robot = new Robot();
		robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
		robot.keyPress(java.awt.event.KeyEvent.VK_V);
		robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);

		System.out.println("File Uploaded successfully done");
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();

	}

	@FindBy(xpath = "html/body/div[1]/div[1]/div[1]/a[1]/img")
	WebElement Logo;

	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[3]/a")
	WebElement MeetingLink;
	@FindBy(xpath = "//table//tbody")
	WebElement AgendaNotyetGenerated;

	// --Check for uploaded agenda� display at�IEC Admin�meeting tab of upcoming
	// meeting list--//
	public void CRe4_213() throws Exception {

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String AgendaNotyetGenerated_data = r1.getCell(2, 19).getContents();

		// ----------IECAdmin_Login------------//

		GlobalMethods.Admin_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement table_element = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(AgendaNotyetGenerated_data));
			}
		}

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		

	}

	// --Check for uploaded agenda� display at�Chairperson meeting tab of
	// upcoming meeting list--//
	public void CRe4_214() throws Exception {

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String AgendaNotyetGenerated_data = r1.getCell(2, 19).getContents();

		// ----------IECChairperson_Login------------//

		GlobalMethods.CPLogin();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement table_element = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(AgendaNotyetGenerated_data));
			}
		}
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		
	}

	// -=Check for uploaded�agenda display at�Members meeting tab of upcoming
	// meeting list--//
	public void CRe4_215() throws Exception {

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String AgendaNotyetGenerated_data = r1.getCell(2, 19).getContents();

		// ----------IECMembers_Login------------//

		GlobalMethods.Member1Login();
		WebElement MeetingLink_Member = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		MeetingLink_Member.click();
		WebElement table_element = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(AgendaNotyetGenerated_data));
			}
		}
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		
	}

	@FindBy(xpath = "//div[2]/div/table/tbody/tr[1]/td[6]/span/a")
	WebElement PublishLink;

	// ----Check for 'Publish' link in upcoming meeting list----//
	public void CRe4_216() throws Exception {

//		try {
			GlobalMethods.MS_Login();
			WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
			Meeting_Link.click();

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("Meetings");
			String Publish_data = r1.getCell(2, 21).getContents();

			// ----Publish----//
			System.out.println(PublishLink.getText());
			WebElement table_element = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
			ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
			for (WebElement row : rows) {
				ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]/span/a"));
				for (WebElement cell : cells) {
					System.out.println(cell.getText());
					if (cell.getText().equalsIgnoreCase(Publish_data)) {
						cell.click();
						Thread.sleep(2000);
						WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
						LogOut.click();
						
					}
					break;
				}
				break;
			}
		/*} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		

	}

	@FindBy(xpath = "//table/tbody")
	WebElement DownloadAgenda;

	// --Check for published agenda display at IEC Admin meeting tab of upcoming
	// meeting list--//
	public void CRe4_217() throws Exception {

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String DownloadAgenda_data = r1.getCell(2, 23).getContents();

		// ----------IECAdmin_Login------------//

		GlobalMethods.Admin_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement table_element = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]/a"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(DownloadAgenda_data));
			}
		}

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		
	}

	// --Check for published agenda display at�Chairperson meeting tab of
	// upcoming meeting list--//
	public void CRe4_218() throws Exception {

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String DownloadAgenda_data = r1.getCell(2, 23).getContents();

		// ----------IECChairperson_Login------------//

		GlobalMethods.CPLogin();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement table_element = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]/a"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(DownloadAgenda_data));
			}
		}
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}

	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[2]/a")
	WebElement MeetingLink_Member;

	// --Check for published agenda display at�Member meeting tab of upcoming
	// meeting list--//
	public void CRe4_219() throws Exception {

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String DownloadAgenda_data = r1.getCell(2, 23).getContents();

		// ----------IECMembers_Login------------//

		GlobalMethods.Member1Login();
		WebElement MeetingLink_Member = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		MeetingLink_Member.click();
		WebElement table_element = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]/a"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(DownloadAgenda_data));
			}
		}
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}

	@FindBy(xpath = "//a[contains(text(),'Unpublish')]")
	WebElement UnPublishLink;

	// --Check for 'UnPublish' link in upcoming meeting list--//
	public void CRe4_220() throws Exception {

//		try {
			GlobalMethods.MS_Login();
			WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
			Meeting_Link.click();

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("Meetings");
			String UnPublish_data = r1.getCell(2, 25).getContents();

			// ----UnPublish----//
			
			WebElement table_element = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
			ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
			for (WebElement row : rows) {
				ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]/span/a"));
				for (WebElement cell : cells) {
					System.out.println(cell.getText());
					if (cell.getText().equalsIgnoreCase(UnPublish_data)) {
						cell.click();
						Thread.sleep(2000);
						WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
						LogOut.click();
					}
					break;
				}
				break;
			}
		/*} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

	// --Check for Unpublished agenda display at IEC Admin meeting tab of
	// upcoming meeting list--//
	public void CRe4_221() throws Exception {

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String AgendaNotyetGenerated_data = r1.getCell(2, 19).getContents();

		// ----------IECAdmin_Login------------//

		GlobalMethods.Admin_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement table_element = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(AgendaNotyetGenerated_data));
			}
		}
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();

	}

	// --Check for Unpublished agenda display at�Chairperson meeting tab of
	// upcoming meeting list--//
	public void CRe4_222() throws Exception {

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String AgendaNotyetGenerated_data = r1.getCell(2, 19).getContents();

		// ----------IECChairperson_Login------------//

		GlobalMethods.CPLogin();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement table_element = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(AgendaNotyetGenerated_data));
			}
		}
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		
	}

	// --Check for Unpublished agenda display at�Member meeting tab of upcoming
	// meeting list--//
	public void CRe4_223() throws Exception {

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String AgendaNotyetGenerated_data = r1.getCell(2, 19).getContents();

		// ----------IECMembers_Login------------//

		GlobalMethods.Member1Login();
		WebElement MeetingLink_Member = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		MeetingLink_Member.click();
		WebElement table_element = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(AgendaNotyetGenerated_data));
			}
		}
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();

	}

}
