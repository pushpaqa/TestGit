package com.create4.scenarios;

import java.io.FileInputStream;
import java.util.List;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.global.methods.Dashboard_Links;
import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;
import com.global.methods.Global_Project_Submissions;

import jxl.Sheet;
import jxl.Workbook;

/*
 * Check for when all subsequent submissions forward to MS and Got different decisions the each submission flow should change as per the decision from PI submission then other submissions should still be under 'MS review'
 */

public class TS_179 {

	public TS_179() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);
	// PI submit new project page elements

	@FindBy(id = "document_title")
	WebElement doc_title;

	@FindBy(id = "version")
	WebElement doc_version;

	@FindBy(id = "proj_document")
	WebElement upload_doc;

	@FindBy(id = "document_date")
	WebElement doc_date;

	@FindBy(id = "savedoc")
	WebElement save_button2;

	// sussequent doctype upload

	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/button")
	public WebElement docdrop1;
	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/div/ul/li")
	public static List<WebElement> docvalue1;

	@FindBy(xpath = "//*[@id='respondqueryupload']/div/div[1]/div[1]/div/div/button")
	public WebElement docdrop2;
	@FindBy(xpath = "//*[@id='respondqueryupload']/div/div[1]/div[1]/div/div/div/ul/li")
	public static List<WebElement> docvalue2;

	@FindBy(xpath = "//*[@id='document_types_edit']/div/button")
	public WebElement docdrop_edit;
	@FindBy(xpath = "//*[@id='document_types_edit']/div/div/ul/li")
	public static List<WebElement> docvalue_edit;

	// Initial submission gets Letter of permission
		// For same single approved project submit amendment, deviation, continuation, completion to admin
		// Admin forwards above subsequent submissions to MS
		// MS uploads different letters to each subsequent submission
	
	public void CRe4179() throws Exception {
		

		Global_Project_Submissions gp=new Global_Project_Submissions();
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		String Document_Title_in_list = r1.getCell(2, 525).getContents();
		String Version_in_list = r1.getCell(3, 525).getContents();
		String Document_Date_in_list = r1.getCell(4, 525).getContents();
		String doc_upload = r1.getCell(5, 525).getContents();
				

		String Decision_Noted = r1.getCell(6,525).getContents();
		String Decisionfile1 = r1.getCell(7,525).getContents();
		String Decisioncmnt1 = r1.getCell(8,525).getContents();
		String Decision_LOP_amend = r1.getCell(9, 525).getContents();
		String Decision_Query = r1.getCell(10,525).getContents();
		String Decision_Revoke = r1.getCell(11,525).getContents();

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

		WebElement submit_to_IEC = GWait.Wait_GetElementById("submitid");

		submit_to_IEC.click();
		Thread.sleep(2000);
		WebElement no1 = GWait.Wait_GetElementByXpath("(//input[@name='studyteam_members'])[2]");
		no1.click();
		WebElement conflictsubmit = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		conflictsubmit.click();
		GlobalMethods.alertaccept();

		// Submitting deviation to admin

		Thread.sleep(2000);
		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();

		WebElement newdocuments1 = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments1.click();

		WebElement deviat1 = GWait.Wait_GetElementByLinkText("Deviation");
		deviat1.click();

		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; i++) {
			Thread.sleep(2000);
			docdrop1.click();
			String numberAsString = Integer.toString(i);
			List<WebElement> elementsList3 = docvalue1;
			int j = 0;
			for (WebElement a11 : elementsList3) {
				WebElement span = a11.findElement(By.tagName("span"));
				System.out.println(numberAsString);
				System.out.println(span.getAttribute("data-original-index"));
				if (i == j) {
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
		WebElement next_button2 = GWait.Wait_GetElementById("nextid");
		next_button2.click();

		WebElement submit_to_IEC1 = GWait.Wait_GetElementById("submitid");
		submit_to_IEC1.click();

		Thread.sleep(2000);

		WebElement no12 = GWait.Wait_GetElementByXpath("(//input[@name='studyteam_members'])[2]");
		no12.click();
		WebElement conflictsubmit1 = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		conflictsubmit1.click();
		GlobalMethods.alertaccept();

		// Submitting continuing to admin

		Thread.sleep(2000);

		WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview1.click();
		
		WebElement newdocuments2 = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments2.click();

		WebElement continu = GWait.Wait_GetElementByLinkText("Continuation");
		continu.click();

		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; i++) {
			Thread.sleep(2000);
			docdrop1.click();
			String numberAsString = Integer.toString(i);
			List<WebElement> elementsList3 = docvalue1;
			int j = 0;
			for (WebElement a11 : elementsList3) {
				WebElement span = a11.findElement(By.tagName("span"));
				System.out.println(numberAsString);
				System.out.println(span.getAttribute("data-original-index"));
				if (i == j) {
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

			}

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(10000);
		WebElement next_button3 = GWait.Wait_GetElementById("nextid");
		next_button3.click();

		WebElement submit_to_IEC3 = GWait.Wait_GetElementById("submitid");
		submit_to_IEC3.click();

		Thread.sleep(2000);

		WebElement no3 = GWait.Wait_GetElementByXpath("(//input[@name='studyteam_members'])[2]");
		no3.click();
		WebElement conflictsubmit3 = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		conflictsubmit3.click();
		GlobalMethods.alertaccept();

		// Submitting completion to admin

		WebElement overview2 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview2.click();
		
		WebElement newdocuments3 = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments3.click();
		
		WebElement completion = GWait.Wait_GetElementByLinkText("Completion");
		completion.click();

		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; i++) {
			Thread.sleep(2000);
			docdrop1.click();
			String numberAsString = Integer.toString(i);
			List<WebElement> elementsList3 = docvalue1;
			int j = 0;
			for (WebElement a11 : elementsList3) {
				WebElement span = a11.findElement(By.tagName("span"));
				System.out.println(numberAsString);
				System.out.println(span.getAttribute("data-original-index"));
				if (i == j) {
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
		WebElement next_button4 = GWait.Wait_GetElementById("nextid");
		next_button4.click();

		WebElement submit_to_IEC4 = GWait.Wait_GetElementById("submitid");
		submit_to_IEC4.click();

		Thread.sleep(2000);

		WebElement no4 = GWait.Wait_GetElementByXpath("(//input[@name='studyteam_members'])[2]");
		no4.click();
		WebElement conflictsubmit4 = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		conflictsubmit4.click();
		GlobalMethods.alertaccept();
		Thread.sleep(6000);
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();

		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();
		
		// Admin forward amendment to MS
		
		GlobalMethods.Admin_Login();
		gp.Global_Dashboard_AmendmentLink();
		
		gp.SubsequentSubmissions_IECAdmin_forwardto_MS();
		
		
		WebElement logouttA = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttA.click();
		WebElement logoA = GWait.Wait_GetElementByCSS("img");
		logoA.click();
		
		// Admin forward deviation to MS
		
		GlobalMethods.Admin_Login();
		gp.Global_Dashboard_DeviationLink();
		
		gp.SubsequentSubmissions_IECAdmin_forwardto_MS();
		

		WebElement logoutt3 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt3.click();
		WebElement logo3 = GWait.Wait_GetElementByCSS("img");
		logo3.click();
		
		// Admin forward continuation to MS

		GlobalMethods.Admin_Login();
		gp.Global_Dashboard_ContinuationLink();
		gp.SubsequentSubmissions_IECAdmin_forwardto_MS();
		

		WebElement logoutt4 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt4.click();
		WebElement logo4 = GWait.Wait_GetElementByCSS("img");
		logo4.click();
		
		// Admin forward completion to MS
		
		
		GlobalMethods.Admin_Login();
		gp.Global_Dashboard_CompletionLink();
		gp.SubsequentSubmissions_IECAdmin_forwardto_MS();
		

		WebElement logoutt5 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt5.click();
		WebElement logo5 = GWait.Wait_GetElementByCSS("img");
		logo5.click();
		
		
		
	

		//MS gives decision as 'Query" for deviation submission
	
		GlobalMethods.MS_Login();

		gp.Global_Dashboard_DeviationLink();

		WebElement Projectoverview4 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview4.click();

		WebElement asignreviewers4 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers4.click();
		
		Thread.sleep(2000);
		GlobalMethods.Commentswindhandler();

		// membercomments.click();

		WebElement iecdecisiontab4 = GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab4.click();

		WebElement decisondropdown4 = GWait.Wait_GetElementById("decision_type");

		Select select724 = new Select(decisondropdown4);
		select724.selectByVisibleText(Decision_Query);

		WebElement decisionupload4 = GWait.Wait_GetElementById("proj_document");
		decisionupload4.sendKeys(Decisionfile1);

		WebElement assign_comments4 = GWait.Wait_GetElementById("comments");
		assign_comments4.sendKeys(Decisioncmnt1);

		WebElement decisionusubmit4 = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit4.click();
		
	
		Thread.sleep(10000);
		WebElement logoutt8 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt8.click();

		WebElement logo9 = GWait.Wait_GetElementByCSS("img");
		logo9.click();
		
		
		
	//MS gives decision as 'LOP" for amendment submission
		
		GlobalMethods.MS_Login();
		
	
		gp.Global_Dashboard_AmendmentLink();

		WebElement Projectoverview3 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview3.click();

		WebElement asignreviewers3 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers3.click();
		
		Thread.sleep(2000);
		GlobalMethods.Commentswindhandler();

		// membercomments.click();

		WebElement iecdecisiontab3 = GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab3.click();

		WebElement decisondropdown3 = GWait.Wait_GetElementById("decision_type");

		Select select723 = new Select(decisondropdown3);
		select723.selectByVisibleText(Decision_LOP_amend);

		WebElement decisionupload3 = GWait.Wait_GetElementById("proj_document");
		decisionupload3.sendKeys(Decisionfile1);

		WebElement assign_comments3 = GWait.Wait_GetElementById("comments");
		assign_comments3.sendKeys(Decisioncmnt1);

		WebElement decisionusubmit3 = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit3.click();
		Thread.sleep(10000);
		WebElement logoutt7 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt7.click();

		WebElement logo8 = GWait.Wait_GetElementByCSS("img");
		logo8.click();
		
		//MS gives decision as 'Revoke" for continuation submission
		
		
				GlobalMethods.MS_Login();

				// --TAKE COUNT BEFORE FROM "PROJECT COMPLETION"---//

				WebElement countbefore2 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[3]/a/span[2]");

				String myStringe = countbefore2.getText();
				System.out.println(myStringe);
				int fooE = Integer.parseInt(myStringe);

				
				
				gp.Global_Dashboard_ContinuationLink();

				WebElement Projectoverview5 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
				Projectoverview5.click();

				WebElement asignreviewers5 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
				asignreviewers5.click();
				
				Thread.sleep(2000);
				GlobalMethods.Commentswindhandler();

				// membercomments.click();

				WebElement iecdecisiontab5 = GWait.Wait_GetElementByLinkText("IEC Decision");
				iecdecisiontab5.click();

				WebElement decisondropdown5 = GWait.Wait_GetElementById("decision_type");

				Select select725 = new Select(decisondropdown5);
				select725.selectByVisibleText(Decision_Revoke);

				WebElement decisionupload5 = GWait.Wait_GetElementById("proj_document");
				decisionupload5.sendKeys(Decisionfile1);

				WebElement assign_comments5 = GWait.Wait_GetElementById("comments");
				assign_comments5.sendKeys(Decisioncmnt1);

				WebElement decisionusubmit5 = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
				decisionusubmit5.click();
				Thread.sleep(10000);
				WebElement logoutt9 = GWait.Wait_GetElementByXpath("//span[3]/a");
				logoutt9.click();

				WebElement logo1 = GWait.Wait_GetElementByCSS("img");
				logo1.click();
		
		//MS gives decision as 'Noted" for completion submission
		
				GlobalMethods.MS_Login();

				/*gp.Global_Dashboard_CompletionLink();

				WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
				Projectoverview2.click();

				WebElement asignreviewers2 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
				asignreviewers2.click();
				
				Thread.sleep(2000);
				GlobalMethods.Commentswindhandler();

				// membercomments.click();

				WebElement iecdecisiontab2 = GWait.Wait_GetElementByLinkText("IEC Decision");
				iecdecisiontab2.click();

				WebElement decisondropdown2 = GWait.Wait_GetElementById("decision_type");

				Select select72 = new Select(decisondropdown2);
				select72.selectByVisibleText(Decision_Noted);

				WebElement decisionupload2 = GWait.Wait_GetElementById("proj_document");
				decisionupload2.sendKeys(Decisionfile1);

				WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
				assign_comments2.sendKeys(Decisioncmnt1);

				WebElement decisionusubmit2 = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
				decisionusubmit2.click();*/
				
				// --TAKE COUNT AFTER FORM "PROJECT COMPLETION"--//

				WebElement countafter2 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[3]/a/span[2]");

				String myStringf = countafter2.getText();
				System.out.println(myStringf);
				int fooF = Integer.parseInt(myStringf);
				
				int E1 = fooE, E2 = 1, SUME;
				SUME = E1 - E2;

				System.out.println(SUME);

				Assert.assertEquals(SUME, fooF);
				System.out.println(fooF);
				
				gp.Global_Dashboard_CompletionLink();
				
				
				
				Thread.sleep(10000);
				WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span[3]/a");
				logoutt2.click();

				WebElement logo12 = GWait.Wait_GetElementByCSS("img");
				logo12.click();
				

	}
	
	@FindBy(xpath = "//td[7]")
	WebElement status1;
	
	@FindBy(xpath = "//tr[2]/td[7]")
	WebElement status2;
	
	@FindBy(xpath = "//tr[3]/td[7]")
	WebElement status3;
	
	@FindBy(xpath = "//tr[4]/td[7]")
	WebElement status4;
	
	@FindBy(xpath = "//tr[5]/td[7]")
	WebElement status5;

}
