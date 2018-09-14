package com.create4.scenarios;

import java.io.FileInputStream;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

/*
 * Check for add Iec annexures publish/unpublish feature
 */
public class TS_31 {

	public TS_31() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}
    GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[6]/a")
	WebElement IECSubmissionForms;

	@FindBy(css = ".bg-success.text-success.col-sm-12.text-center")
	WebElement PublishPopup;

	// --------Check for Publish link in list page-------//

	public void CRe4_1126_1127_1128() throws Exception {
		// ----------PI Login------------//
		
		GlobalMethods.Admin_Login();
		
		WebElement IECSubmissionForms =GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[6]/a");
		IECSubmissionForms.click();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("ManageIEC");

		String Publish_data = r.getCell(2, 222).getContents();

		String PublishPopup_data = r.getCell(3, 222).getContents();

		Thread.sleep(4500);
		WebElement table_element = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[9]/a"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				if (cell.getText().equalsIgnoreCase(Publish_data)) {
					cell.click();
					// ----PublishPopup----//
					Thread.sleep(1000);
					System.out.println(PublishPopup.getText());
					if (PublishPopup.getText().equalsIgnoreCase(PublishPopup_data)) {
						System.out.println(PublishPopup.getText().equalsIgnoreCase(PublishPopup_data));
					} else {
						System.out.println("Test Fail PublishPopup");
					}
					break;
				}
			}
			break;
		}
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
	}

	@FindBy(css = ".logout")
	WebElement LogOut;
	// --------Check for Unpublish in list page-------//

	public void CRe4_1129() throws Exception {
		
		GlobalMethods.Admin_Login();
		
		WebElement IECSubmissionForms =GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[6]/a");
		IECSubmissionForms.click();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("ManageIEC");

		String Unpublish_data = r.getCell(2, 224).getContents();

		String UnpublishPopup_data = r.getCell(3, 224).getContents();

		Thread.sleep(4500);
		WebElement table_element = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[9]/a"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				if (cell.getText().equalsIgnoreCase(Unpublish_data)) {
					cell.click();
					// ----UnpublishPopup----//
					Thread.sleep(1000);
					System.out.println(PublishPopup.getText());
					if (PublishPopup.getText().equalsIgnoreCase(UnpublishPopup_data)) {
						System.out.println(PublishPopup.getText().equalsIgnoreCase(UnpublishPopup_data));
					} else {
						System.out.println("Test Fail UnpublishPopup");
					}
					break;
				}
			}
			break;
		}
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();

	}
}
