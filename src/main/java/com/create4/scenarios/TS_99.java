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
import org.testng.Assert;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

public class TS_99 {

	public TS_99() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);


	@FindBy(css = ".col-sm-10.col-xs-12.main-right>h3")
	WebElement CompletedMtngTXT;

	public void IECMSMtgCompleted_CRe4_247() throws Exception {

		// ----------Member Secretary Login------------//
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompletedMtg_Link = GWait.Wait_GetElementByXpath("//div[1]/div/div[2]/ul/li[1]/div[2]/div/ul/li[3]/a");
		CompletedMtg_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String CompletedMtngTXT_data = r1.getCell(2, 45).getContents();

		// ----Completed�Meeting----//
		System.out.println(CompletedMtngTXT.getText());
		Assert.assertEquals(CompletedMtngTXT.getText(), CompletedMtngTXT_data);

		WebElement LogOut = GWait.Wait_GetElementByXpath("//span[3]/a");
		LogOut.click();
		System.out.println("IECMSMtgCompleted_CRe4_249()");
	}

	@FindBy(xpath = "//div/table/thead/tr/th[2]/a/span[2]")
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
	public void IECMSMtgCompleted_CRe4_249() throws Exception {
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompletedMtg_Link = GWait.Wait_GetElementByXpath("//div[1]/div/div[2]/ul/li[1]/div[2]/div/ul/li[3]/a");
		CompletedMtg_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String MeetingTimeTXT_data = r1.getCell(2, 47).getContents();
		String MeetingTitleTXT_data = r1.getCell(3, 47).getContents();
		String VenueTXT_data = r1.getCell(4, 47).getContents();
		String ActionTXT_data = r1.getCell(5, 47).getContents();
		String MOMTXT_data = r1.getCell(6, 47).getContents();

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

		// ----MOM----//
		
		Assert.assertEquals(MOMTXT.getText(), MOMTXT_data);

		WebElement LogOut = GWait.Wait_GetElementByXpath("//span[3]/a");
		LogOut.click();

	}

	@FindBy(css = ".form-control")
	WebElement StartDate;
	

	// ---Check for search with past date---//
	public void IECMSMtgCompleted_CRe4_250() throws Exception {
		System.out.println("IECMSMtgCompleted_CRe4_250()");
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompletedMtg_Link = GWait.Wait_GetElementByXpath("//div[1]/div/div[2]/ul/li[1]/div[2]/div/ul/li[3]/a");
		CompletedMtg_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String Pastdate_data = r1.getCell(2, 49).getContents();

		// -------Start date(Future Date)-------//
		StartDate.sendKeys(Pastdate_data);
		WebElement SearchBTN = GWait.Wait_GetElementByCSS(".btn.btn-default.btn-orange");
		SearchBTN.click();

		WebElement LogOut = GWait.Wait_GetElementByXpath("//span[3]/a");
		LogOut.click();

	}

	@FindBy(css = ".error-msg")
	WebElement Date_Alert;

	// ---Check for search with blank date---//
	public void IECMSMtgCompleted_CRe4_252() throws Exception {
		System.out.println("IECMSMtgCompleted_CRe4_252()");
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompletedMtg_Link = GWait.Wait_GetElementByXpath("//div[1]/div/div[2]/ul/li[1]/div[2]/div/ul/li[3]/a");
		CompletedMtg_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String Date_Alert_data = r1.getCell(2, 51).getContents();

		// -------Start date(Future Date)-------//
		StartDate.clear();
		WebElement SearchBTN = GWait.Wait_GetElementByCSS(".btn.btn-default.btn-orange");
		SearchBTN.click();

		// ----Required field alert----//
		System.out.println(Date_Alert.getText());
		Assert.assertEquals(Date_Alert.getText(), Date_Alert_data);
		
		WebElement LogOut = GWait.Wait_GetElementByXpath("//span[3]/a");
		LogOut.click();

	}

	// ---Check for 'Meeting time' column field---//
	public void IECMSMtgCompleted_CRe4_253_254() throws Exception {
		System.out.println("IECMSMtgCompleted_CRe4_253_254()");
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompletedMtg_Link = GWait.Wait_GetElementByXpath("//div[1]/div/div[2]/ul/li[1]/div[2]/div/ul/li[3]/a");
		CompletedMtg_Link.click();

		// --Check for 'Meeting time' column field--//
		WebElement table_element = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[2]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
			}
		}

		// --Check for 'Meeting Title' column field--//
		WebElement table_element1 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[3]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
			}
		}

		WebElement LogOut = GWait.Wait_GetElementByXpath("//span[3]/a");
		LogOut.click();

	}

	// ---Check for 'MOM' column after MS generates mom---//
	public void IECMSMtgCompleted_CRe4_256_257() throws Exception {
		System.out.println("IECMSMtgCompleted_CRe4_256_257()");
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompletedMtg_Link = GWait.Wait_GetElementByXpath("//div[1]/div/div[2]/ul/li[1]/div[2]/div/ul/li[3]/a");
		CompletedMtg_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String GenerateMOM_data = r1.getCell(2, 53).getContents();

		WebElement table_element1 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]/div/a"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(GenerateMOM_data));
				if (cell.getText().equalsIgnoreCase(GenerateMOM_data)) {
					cell.click();
					GlobalMethods.AcceptDoenloadPopup();
					Thread.sleep(1000);
					WebElement LogOut = GWait.Wait_GetElementByXpath("//span[3]/a");
					LogOut.click();
					break;
				}

			}
			break;
		}

	}

	@FindBy(css = ".ajax-file-upload")
	WebElement UploadLink;

	// --Check for upload option in�completed meetings--//
	public void IECMSMtgCompleted_CRe4_259_260() throws Exception {
		System.out.println("IECMSMtgCompleted_CRe4_259_260()");
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompletedMtg_Link = GWait.Wait_GetElementByXpath("//div[1]/div/div[2]/ul/li[1]/div[2]/div/ul/li[3]/a");
		CompletedMtg_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String UploadLink_data = r1.getCell(2, 55).getContents();

		// ----Upload text----//
		WebElement Upload_Link = GWait.Wait_GetElementByCSS(".ajax-file-upload");
		Assert.assertEquals(Upload_Link.getText(), UploadLink_data);

		// ----Check for 'Upload' link in�completed meeting list-- Test Cases
		// 260-//

		WebElement table_element1 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.cssSelector(".ajax-file-upload"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(UploadLink_data));
				cell.click();
				StringSelection s = new StringSelection("C:\\Users\\bablu\\Downloads\\GeneratedMeetingAgenda.doc");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
				Robot robot = new Robot();
				robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
				robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
				robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
				robot.keyPress(java.awt.event.KeyEvent.VK_V);
				robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
				robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
				System.out.println("File Uploaded successfully done");
				Thread.sleep(1000);
				WebElement LogOut = GWait.Wait_GetElementByXpath("//span[3]/a");
				LogOut.click();
				break;
			}
			break;
		}

	}

	@FindBy(xpath = "html/body/div[1]/div[1]/div[1]/a[1]/img")
	WebElement Logo;
	

	// --Check for uploaded�MOM display at IEC Admin meeting tab of�completed
	// meeting list--//
	public void IECMSMtgCompleted_CRe4_262() throws Exception {
		System.out.println("IECMSMtgCompleted_CRe4_262()");
		GlobalMethods.Admin_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompleteMeeting = GWait.Wait_GetElementByXpath("//div[2]/div/ul/li[2]/a");
		CompleteMeeting.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String NotYetUploaded_data = r1.getCell(2, 57).getContents();

		WebElement table_element1 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(NotYetUploaded_data));
			}
		}

		WebElement LogOut = GWait.Wait_GetElementByXpath("//span[3]/a");
		LogOut.click();

	}

	// --Check for uploaded MOM display at Chairperson meeting tab of completed
	// meeting list--//
	public void IECMSMtgCompleted_CRe4_263() throws Exception {
		System.out.println("IECMSMtgCompleted_CRe4_263()");
		GlobalMethods.CPLogin();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompleteMeeting = GWait.Wait_GetElementByXpath("//div[2]/div/ul/li[2]/a");
		CompleteMeeting.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String NotYetUploaded_data = r1.getCell(2, 57).getContents();

		WebElement table_element = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(NotYetUploaded_data));
			}
		}

		WebElement LogOut = GWait.Wait_GetElementByXpath("//span[3]/a");
		LogOut.click();
	}

	// --Check for uploaded MOM display at�Member meeting tab of completed
	// meeting list--//
	public void IECMSMtgCompleted_CRe4_264() throws Exception {

		System.out.println("IECMSMtgCompleted_CRe4_264()");
		GlobalMethods.Member1Login();
		WebElement MeetingMemberLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		MeetingMemberLink.click();
		WebElement CompleteMeeting = GWait.Wait_GetElementByXpath("//div[2]/div/ul/li[2]/a");
		CompleteMeeting.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String NotYetUploaded_data = r1.getCell(2, 57).getContents();

		WebElement table_element = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(NotYetUploaded_data));
			}
		}

		WebElement LogOut = GWait.Wait_GetElementByXpath("//span[3]/a");
		LogOut.click();

	}

	// --Check for completed meetings in IEC Admin before MOM generated--//
	public void IECMSMtgCompleted_CRe4_265() throws Exception {
		System.out.println("IECMSMtgCompleted_CRe4_265()");

		GlobalMethods.Admin_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompleteMeeting = GWait.Wait_GetElementByXpath("//div[2]/div/ul/li[2]/a");
		CompleteMeeting.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String YetGenerate_data = r1.getCell(2, 59).getContents();

		WebElement table_element = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(YetGenerate_data));
			}
		}

		WebElement LogOut = GWait.Wait_GetElementByXpath("//span[3]/a");
		LogOut.click();
	}

	// --Check for uploaded MOM display at Chairperson meeting tab of completed
	// meeting list--//
	public void IECMSMtgCompleted_CRe4_266() throws Exception {
		System.out.println("IECMSMtgCompleted_CRe4_266()");

		GlobalMethods.CPLogin();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompleteMeeting = GWait.Wait_GetElementByXpath("//div[2]/div/ul/li[2]/a");
		CompleteMeeting.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String YetGenerate_data = r1.getCell(2, 59).getContents();

		WebElement table_element = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(YetGenerate_data));
			}
		}

		WebElement LogOut = GWait.Wait_GetElementByXpath("//span[3]/a");
		LogOut.click();
	}

	// --Check for uploaded MOM display at�Member meeting tab of completed
	// meeting list--//
	public void IECMSMtgCompleted_CRe4_267() throws Exception {
		System.out.println("IECMSMtgCompleted_CRe4_267()");
		GlobalMethods.Member1Login();
		WebElement MeetingMemberLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		MeetingMemberLink.click();
		WebElement CompleteMeeting = GWait.Wait_GetElementByXpath("//div[2]/div/ul/li[2]/a");
		CompleteMeeting.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String YetGenerate_data = r1.getCell(2, 59).getContents();

		WebElement table_element = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(YetGenerate_data));
			}
		}

		WebElement LogOut = GWait.Wait_GetElementByXpath("//span[3]/a");
		LogOut.click();

	}

	// --Check for 'Publish' link in�completed meeting list--//
	public void IECMSMtgCompleted_CRe4_268() throws Exception {

		System.out.println("IECMSMtgCompleted_CRe4_268()");
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompletedMtg_Link = GWait.Wait_GetElementByXpath("//div[1]/div/div[2]/ul/li[1]/div[2]/div/ul/li[3]/a");
		CompletedMtg_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String PublishLink_data = r1.getCell(2, 61).getContents();

		WebElement table_element = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));

		for (WebElement row2 : rows1) {
			ArrayList<WebElement> cells1 = (ArrayList<WebElement>) row2.findElements(By.cssSelector(".publishmom"));
			for (WebElement cell1 : cells1) {
				System.out.println(cell1.getText());
				if (cell1.getText().equalsIgnoreCase(PublishLink_data)) {
					cell1.click();
					WebElement LogOut = GWait.Wait_GetElementByXpath("//span[3]/a");
					LogOut.click();
					break;
				}

			}
			break;

		}

	}

	// --Check for published�mom display at IEC Admin meeting tab of�completed
	// meeting list--//

	public void IECMSMtgCompleted_CRe4_269() throws Exception {

		System.out.println("IECMSMtgCompleted_CRe4_269()");
		GlobalMethods.Admin_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompleteMeeting = GWait.Wait_GetElementByXpath("//div[2]/div/ul/li[2]/a");
		CompleteMeeting.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String DownloadMOM_data = r1.getCell(2, 63).getContents();

		WebElement table_element = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(DownloadMOM_data));
			}
		}

		WebElement LogOut = GWait.Wait_GetElementByXpath("//span[3]/a");
		LogOut.click();
	}

	// --Check for published mom display at Chairperson meeting tab of completed
	// meeting list--//
	public void IECMSMtgCompleted_CRe4_270() throws Exception {

		System.out.println("IECMSMtgCompleted_CRe4_270()");
		GlobalMethods.CPLogin();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompleteMeeting = GWait.Wait_GetElementByXpath("//div[2]/div/ul/li[2]/a");
		CompleteMeeting.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String DownloadMOM_data = r1.getCell(2, 63).getContents();

		WebElement table_element1 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(DownloadMOM_data));
			}
		}

		WebElement LogOut = GWait.Wait_GetElementByXpath("//span[3]/a");
		LogOut.click();

	}

	// --Check for uploaded MOM display at�Member meeting tab of completed
	// meeting list--//
	public void IECMSMtgCompleted_CRe4_271() throws Exception {
		System.out.println("IECMSMtgCompleted_CRe4_271()");
		GlobalMethods.Member1Login();
		WebElement MeetingMemberLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		MeetingMemberLink.click();
		WebElement CompleteMeeting = GWait.Wait_GetElementByXpath("//div[2]/div/ul/li[2]/a");
		CompleteMeeting.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String DownloadMOM_data = r1.getCell(2, 63).getContents();

		WebElement table_element1 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(DownloadMOM_data));
			}
		}

		WebElement LogOut = GWait.Wait_GetElementByXpath("//span[3]/a");
		LogOut.click();

	}

	// --Check for 'UnPublish' link in�completed meeting list--//
	public void IECMSMtgCompleted_CRe4_272() throws Exception {

		System.out.println("IECMSMtgCompleted_CRe4_272()");
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompletedMtg_Link = GWait.Wait_GetElementByXpath("//div[1]/div/div[2]/ul/li[1]/div[2]/div/ul/li[3]/a");
		CompletedMtg_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String UnpublishLink_data = r1.getCell(2, 65).getContents();

		WebElement table_element2 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows2 = (ArrayList<WebElement>) table_element2.findElements(By.tagName("tr"));
		for (WebElement row2 : rows2) {
			ArrayList<WebElement> cells1 = (ArrayList<WebElement>) row2.findElements(By.xpath("//td[6]/div/span/a"));
			for (WebElement cell1 : cells1) {
				System.out.println(cell1.getText());
				System.out.println(cell1.getText().equalsIgnoreCase(UnpublishLink_data));
				cell1.click();
				Thread.sleep(2000);
				WebElement LogOut = GWait.Wait_GetElementByXpath("//span[3]/a");
				LogOut.click();
				break;
			}
			break;
		}
		

	}

	// --Check for published�mom display at IEC Admin meeting tab of�completed
	// meeting list--//
	public void IECMSMtgCompleted_CRe4_273() throws Exception {

		System.out.println("IECMSMtgCompleted_CRe4_273()");
		GlobalMethods.Admin_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompleteMeeting = GWait.Wait_GetElementByXpath("//div[2]/div/ul/li[2]/a");
		CompleteMeeting.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String YetGenerate_data = r1.getCell(2, 59).getContents();

		WebElement table_element1 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(YetGenerate_data));
			}
		}

		WebElement LogOut = GWait.Wait_GetElementByXpath("//span[3]/a");
		LogOut.click();
	}

	// --Check for published mom display at Chairperson meeting tab of completed
	// meeting list--//
	public void IECMSMtgCompleted_CRe4_274() throws Exception {

		System.out.println("IECMSMtgCompleted_CRe4_274()");
		GlobalMethods.CPLogin();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompleteMeeting = GWait.Wait_GetElementByXpath("//div[2]/div/ul/li[2]/a");
		CompleteMeeting.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String YetGenerate_data = r1.getCell(2, 59).getContents();

		WebElement table_element1 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(YetGenerate_data));
			}
		}

		WebElement LogOut = GWait.Wait_GetElementByXpath("//span[3]/a");
		LogOut.click();
	}

	// --Check for uploaded MOM display at�Member meeting tab of completed
	// meeting list--//
	public void IECMSMtgCompleted_CRe4_275() throws Exception {

		System.out.println("IECMSMtgCompleted_CRe4_275()");
		GlobalMethods.Member1Login();
		WebElement MeetingMemberLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		MeetingMemberLink.click();
		WebElement CompleteMeeting = GWait.Wait_GetElementByXpath("//div[2]/div/ul/li[2]/a");
		CompleteMeeting.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String YetGenerate_data = r1.getCell(2, 59).getContents();

		WebElement table_element1 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(YetGenerate_data));
			}
		}

		WebElement LogOut = GWait.Wait_GetElementByXpath("//span[3]/a");
		LogOut.click();
	}

	// --Check for 'Download MOM' link in agenda column--//
	public void IECMSMtgCompleted_CRe4_276() throws Exception {

		System.out.println("IECMSMtgCompleted_CRe4_276()");
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompletedMtg_Link = GWait.Wait_GetElementByXpath("//div[1]/div/div[2]/ul/li[1]/div[2]/div/ul/li[3]/a");
		CompletedMtg_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String DownloadMOM_data = r1.getCell(2, 63).getContents();

		WebElement table_element2 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows2 = (ArrayList<WebElement>) table_element2.findElements(By.tagName("tr"));
		for (WebElement row2 : rows2) {
			ArrayList<WebElement> cells1 = (ArrayList<WebElement>) row2.findElements(By.xpath("//td[6]/div/a"));
			for (WebElement cell1 : cells1) {
				System.out.println(cell1.getText());
				if (cell1.getText().equalsIgnoreCase(DownloadMOM_data)) {
					cell1.click();
					GlobalMethods.AcceptDoenloadPopup();
					System.out.println("Download MOM Successfully done");
					Thread.sleep(1500);
					WebElement LogOut = GWait.Wait_GetElementByXpath("//span[3]/a");
					LogOut.click();
					break;
				}

			}
			break;
		}

	}

	@FindBy(css = ".btn.btn-default.first-btn.btn-orange")
	WebElement BackLink;

	// --Check for 'View' link functionality--//
	public void IECMSMtgCompleted_CRe4_277_278() throws Exception {

		System.out.println("IECMSMtgCompleted_CRe4_277_278()");
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();
		WebElement CompletedMtg_Link = GWait.Wait_GetElementByXpath("//div[1]/div/div[2]/ul/li[1]/div[2]/div/ul/li[3]/a");
		CompletedMtg_Link.click();

		WebElement table_element2 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows2 = (ArrayList<WebElement>) table_element2.findElements(By.tagName("tr"));
		for (WebElement row2 : rows2) {
			ArrayList<WebElement> cells1 = (ArrayList<WebElement>) row2
					.findElements(By.cssSelector(".glyphicon.glyphicon-eye-open"));
			for (WebElement cell1 : cells1) {
				cell1.click();
				System.out.println("Check for back button in meeting details page");
				WebElement BackLink = GWait.Wait_GetElementByCSS(".btn.btn-default.first-btn.btn-orange");
				BackLink.click();
				Thread.sleep(1500);
				WebElement LogOut = GWait.Wait_GetElementByXpath("//span[3]/a");
				LogOut.click();
				break;

			}
			break;
		}

	}

}
