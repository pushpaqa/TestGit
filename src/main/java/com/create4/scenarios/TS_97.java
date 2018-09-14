package com.create4.scenarios;

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

public class TS_97 {

	public TS_97() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "html/body/div[4]/div[1]/form/div[1]/div[2]/h3")
	WebElement UpcomingMeetingsTXT;

	public void CRe4_224_226() throws Exception {

		// ----------Member Secretary Login------------//
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");
		String UpcomingMeetingsTXT_data = r1.getCell(2, 27).getContents();

		// ----Upcoming�Meeting----//
		System.out.println(UpcomingMeetingsTXT.getText());
		Assert.assertEquals(UpcomingMeetingsTXT.getText(), UpcomingMeetingsTXT_data);
		
		String FStartdate_data = r1.getCell(3, 27).getContents();

		// -------Start date(Past Date)-------//
		WebElement StartDate = GWait.Wait_GetElementByCSS(".form-control");
		StartDate.sendKeys(FStartdate_data);

		WebElement SearchBTN = GWait.Wait_GetElementByXpath("//div[1]/form/div[1]/div[2]/div[3]/div[1]/input");
		SearchBTN.click();

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();

	}

	// ---Check for search with date with future dates--//
	public void CRe4_227() throws Exception {

		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String FStartdate_data = r1.getCell(2, 29).getContents();

		// -------Start date(Future Date)-------//
		WebElement StartDate = GWait.Wait_GetElementByCSS(".form-control");
		StartDate.sendKeys(FStartdate_data);
		WebElement SearchBTN = GWait.Wait_GetElementByXpath("//div[1]/form/div[1]/div[2]/div[3]/div[1]/input");
		SearchBTN.click();

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}

	// --Check for search with date with current dates--//
	public void CRe4_228() throws Exception {

		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String PStartdate_data = r1.getCell(2, 31).getContents();

		// -------Start date(current date)-------//
		WebElement StartDate = GWait.Wait_GetElementByCSS(".form-control");
		StartDate.clear();
		WebElement StartDate1 = GWait.Wait_GetElementByCSS(".form-control");
		StartDate1.sendKeys(PStartdate_data);
		WebElement SearchBTN = GWait.Wait_GetElementByXpath("//div[1]/form/div[1]/div[2]/div[3]/div[1]/input");
		SearchBTN.click();
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();

	}

	@FindBy(xpath = "//div[1]/form/div[1]/div[2]/div[3]/div[1]/div/p")
	WebElement Date_Alert;

	// --Check for search with blank date--//
	public void CRe4_229() throws Exception {
		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String Startdate_Alert_data = r1.getCell(2, 33).getContents();

		System.out.println("Check for search with blank date");
		WebElement SearchBTN = GWait.Wait_GetElementByXpath("//div[1]/form/div[1]/div[2]/div[3]/div[1]/input");
		SearchBTN.click();

		// ----Start�Date----//
		System.out.println(Date_Alert.getText());
		Assert.assertEquals(Date_Alert.getText(), Startdate_Alert_data);
		
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();

	}
	
	// --Check for 'Agenda' column before MS generate agenda--//
	public void CRe4_237_238_239() throws Exception {

		GlobalMethods.MS_Login();
		WebElement Meeting_Link = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[3]/a");
		Meeting_Link.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Meetings");

		String GeneratedAgenda_data = r1.getCell(2, 35).getContents();
		String GAPublish_data = r1.getCell(3, 35).getContents();
		String GAUnpublish_data = r1.getCell(4, 35).getContents();
		String GAUpload_data = r1.getCell(5, 35).getContents();

		// ------GeneratedAgenda----//
		WebElement table_element = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.cssSelector("#pdf"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(GeneratedAgenda_data));
			}
		}

		// ------Publish------//
		WebElement table_element1 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.cssSelector(".publishagenda"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(GAPublish_data));
			}
		}

		// ------Unpublish------//
		WebElement table_element2 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows2 = (ArrayList<WebElement>) table_element2.findElements(By.tagName("tr"));
		for (WebElement row : rows2) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.cssSelector(".publishagenda"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(GAUnpublish_data));
			}
		}

		// ------UpLoad------//
		WebElement table_element3 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows3 = (ArrayList<WebElement>) table_element3.findElements(By.tagName("tr"));
		for (WebElement row : rows3) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.cssSelector(".ajax-file-upload"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase(GAUpload_data));
			}
		}
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}
}
