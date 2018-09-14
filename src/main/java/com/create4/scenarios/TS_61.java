package com.create4.scenarios;

import java.io.FileInputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.global.methods.Dashboard_Links;
import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;
import com.global.methods.Global_Project_Submissions;

import jxl.Sheet;
import jxl.Workbook;

/*
 * Check for when in multiple subsequent submissions saved as draft and from those one submission submitted to IEC, then draft submissions should not display in admin respected projects
 */
public class TS_61 {
	
	public TS_61(){
		PageFactory.initElements(GlobalMethods.driver, this);
	}
	
	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);
	
	// sussequent doctype upload

		@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/button")
		public WebElement docdrop1;
		@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/div/ul/li")
		public static List<WebElement> docvalue1;
	
	
	public void subsave() throws Exception{
		
		Global_Project_Submissions gp = new Global_Project_Submissions();
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		String Document_Title_in_list = r1.getCell(2, 533).getContents();
		String Version_in_list = r1.getCell(3, 533).getContents();
		String Document_Date_in_list = r1.getCell(4, 533).getContents();
		String doc_upload = r1.getCell(5, 533).getContents();

		
		TS_51 obj = new TS_51();
		obj.CRe4_1221();
		
		
		GlobalMethods.PI_Login();

		//// Submitting amendment to admin

		WebElement Ongoingprojects = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		Ongoingprojects.click();

		WebElement approvedprojoverview = GWait.Wait_GetElementByXpath("//td[9]/a/span");
		approvedprojoverview.click();

		WebElement newdocuments = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments.click();
		// Amendment save as draft
		WebElement amend = GWait.Wait_GetElementByLinkText("Amendment");
		amend.click();

		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; i++) {
			WebElement docdrop1 = GWait
					.Wait_GetElementByXpath("//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/button");
			docdrop1.click();
			String numberAsString = Integer.toString(i);
			// Thread.sleep(5000);
			List<WebElement> elementsList3 = docvalue1;
			int j = 0;
			for (WebElement a11 : elementsList3) {
				WebElement span = a11.findElement(By.tagName("span"));
				System.out.println(numberAsString);
				System.out.println(span.getAttribute("data-original-index"));
				if (i == j) {
					// Thread.sleep(2000);
					String doc = span.getText();
					span.click();
					System.out.println(doc);

					break;
				}
				j++;
			}
			if (i == j) {
				WebElement doc_title = GWait.Wait_GetElementById("document_title");
				doc_title.sendKeys(Document_Title_in_list);
				WebElement doc_version =GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);
				
				WebElement doc_date =GWait.Wait_GetElementById("document_date");
				doc_date.sendKeys(Document_Date_in_list);
				WebElement upload_doc = GWait.Wait_GetElementById("proj_document");
				upload_doc.sendKeys(doc_upload);
				WebElement save_button2 = GWait.Wait_GetElementById("savedoc");
				save_button2.click();

			}break;

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(10000);
		WebElement next_button1 = GWait.Wait_GetElementById("nextid");
		next_button1.click();
		
		WebElement next_button2 = GWait.Wait_GetElementById("nextid");
		next_button2.click();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();
		// Deviation save as draft
		
		WebElement newdocuments1 = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments1.click();

		WebElement deviat1 = GWait.Wait_GetElementByLinkText("Deviation");
		deviat1.click();

		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; i++) {
			WebElement docdrop1 = GWait
					.Wait_GetElementByXpath("//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/button");
			docdrop1.click();
			String numberAsString = Integer.toString(i);
			// Thread.sleep(5000);
			List<WebElement> elementsList3 = docvalue1;
			int j = 0;
			for (WebElement a11 : elementsList3) {
				WebElement span = a11.findElement(By.tagName("span"));
				System.out.println(numberAsString);
				System.out.println(span.getAttribute("data-original-index"));
				if (i == j) {
					// Thread.sleep(2000);
					String doc = span.getText();
					span.click();
					System.out.println(doc);

					break;
				}
				j++;
			}
			if (i == j) {
				WebElement doc_title = GWait.Wait_GetElementById("document_title");
				doc_title.sendKeys(Document_Title_in_list);
				WebElement doc_version =GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);
				
				WebElement doc_date =GWait.Wait_GetElementById("document_date");
				doc_date.sendKeys(Document_Date_in_list);
				WebElement upload_doc = GWait.Wait_GetElementById("proj_document");
				upload_doc.sendKeys(doc_upload);
				WebElement save_button2 = GWait.Wait_GetElementById("savedoc");
				save_button2.click();

			}break;

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(10000);
		WebElement next_button3 = GWait.Wait_GetElementById("nextid");
		next_button3.click();
		
		WebElement next_button4 = GWait.Wait_GetElementById("nextid");
		next_button4.click();

		WebElement overview4 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview4.click();
		
		WebElement newdocuments5 = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments5.click();
		
		// Continuation save as draft
		WebElement continu = GWait.Wait_GetElementByLinkText("Continuation");
		continu.click();

		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; i++) {
			WebElement docdrop1 = GWait
					.Wait_GetElementByXpath("//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/button");
			docdrop1.click();
			String numberAsString = Integer.toString(i);
			// Thread.sleep(5000);
			List<WebElement> elementsList3 = docvalue1;
			int j = 0;
			for (WebElement a11 : elementsList3) {
				WebElement span = a11.findElement(By.tagName("span"));
				System.out.println(numberAsString);
				System.out.println(span.getAttribute("data-original-index"));
				if (i == j) {
					// Thread.sleep(2000);
					String doc = span.getText();
					span.click();
					System.out.println(doc);

					break;
				}
				j++;
			}
			if (i == j) {
				WebElement doc_title = GWait.Wait_GetElementById("document_title");
				doc_title.sendKeys(Document_Title_in_list);
				WebElement doc_version =GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);
				
				WebElement doc_date =GWait.Wait_GetElementById("document_date");
				doc_date.sendKeys(Document_Date_in_list);
				WebElement upload_doc = GWait.Wait_GetElementById("proj_document");
				upload_doc.sendKeys(doc_upload);
				WebElement save_button2 = GWait.Wait_GetElementById("savedoc");
				save_button2.click();

			}break;

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(10000);
		WebElement next_button5 = GWait.Wait_GetElementById("nextid");
		next_button5.click();
		
		WebElement next_button6 = GWait.Wait_GetElementById("nextid");
		next_button6.click();

		WebElement overview6 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview6.click();
		
		// Completion save as draft
		
		WebElement newdocuments6 = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments6.click();
	
		
		WebElement completion = GWait.Wait_GetElementByLinkText("Completion");
		completion.click();

		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; i++) {
			WebElement docdrop1 = GWait
					.Wait_GetElementByXpath("//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/button");
			docdrop1.click();
			String numberAsString = Integer.toString(i);
			// Thread.sleep(5000);
			List<WebElement> elementsList3 = docvalue1;
			int j = 0;
			for (WebElement a11 : elementsList3) {
				WebElement span = a11.findElement(By.tagName("span"));
				System.out.println(numberAsString);
				System.out.println(span.getAttribute("data-original-index"));
				if (i == j) {
					// Thread.sleep(2000);
					String doc = span.getText();
					span.click();
					System.out.println(doc);

					break;
				}
				j++;
			}
			if (i == j) {
				WebElement doc_title = GWait.Wait_GetElementById("document_title");
				doc_title.sendKeys(Document_Title_in_list);
				WebElement doc_version =GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);
				
				WebElement doc_date =GWait.Wait_GetElementById("document_date");
				doc_date.sendKeys(Document_Date_in_list);
				WebElement upload_doc = GWait.Wait_GetElementById("proj_document");
				upload_doc.sendKeys(doc_upload);
				WebElement save_button2 = GWait.Wait_GetElementById("savedoc");
				save_button2.click();

			}break;

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(10000);
		WebElement next_button7 = GWait.Wait_GetElementById("nextid");
		next_button7.click();

		WebElement submit_to_IEC = GWait.Wait_GetElementById("submitid");
		submit_to_IEC.click();

		Thread.sleep(2000);

		WebElement no1 = GWait.Wait_GetElementByXpath("(//input[@name='studyteam_members'])[2]");
		no1.click();
		WebElement conflictsubmit = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		conflictsubmit.click();
		Thread.sleep(3000);
		GlobalMethods.alertaccept();
		Thread.sleep(6000);
		WebElement logouttA = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttA.click();
		WebElement logoA = GWait.Wait_GetElementByCSS("img");
		logoA.click();
		
		
		GlobalMethods.Admin_Login();
		gp.Global_Dashboard_CompletionLink();
		WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview1.click();

		WebElement submissionlist = GWait.Wait_GetElementByLinkText("Submissions List");
		submissionlist.click();
		
		Thread.sleep(1000);
		Assert.assertEquals(status1.getText().trim(), "Submitted to IEC");
		System.out.println(status1.getText());

		Thread.sleep(1000);
		Assert.assertEquals(status2.getText().trim(), "Approved");
		System.out.println(status2.getText());

		
		
	}
	
	@FindBy(xpath = "//td[7]")
	WebElement status1;

	@FindBy(xpath = "//tr[2]/td[7]")
	WebElement status2;
}
