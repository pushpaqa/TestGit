package com.create4.scenarios;

import java.io.FileInputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;
import com.global.methods.Global_Project_Submissions;

import jxl.Sheet;
import jxl.Workbook;

//Check for�completion submission flow with valid/invalid data
public class TS_160 {

	public TS_160() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(id = "add_annexure_document_type")
	WebElement annexure_document_type;

	@FindBy(xpath = "//*[@id='addannexures']/div[1]/div/div/div/button")
	public WebElement docdrop_proj;
	@FindBy(xpath = "//*[@id='addannexures']/div[1]/div/div/div/div/ul/li")
	public static List<WebElement> docvalue_proj;

	@FindBy(xpath = "//*[@id='addannexures']/div[2]/div/div/div/button")
	public WebElement docdrop_rev;
	@FindBy(xpath = "//*[@id='addannexures']/div[2]/div/div/div/div/ul/li")
	public static List<WebElement> docvalue_rev;

	@FindBy(xpath = "//*[@id='addannexures']/div[3]/div/div/div/button")
	public WebElement docdrop_sub;
	@FindBy(xpath = "//*[@id='addannexures']/div[3]/div/div/div/div/ul/li")
	public static List<WebElement> docvalue_sub;

	@FindBy(linkText = "Submit New Project")
	WebElement createproject;

	// project type selection element

	@FindBy(xpath = ".//*[@id='projectsummary']/div/div[1]/div[1]/div/div/button")
	public WebElement projtypdrop;

	@FindBy(xpath = "html/body/div[5]/div[1]/div[3]/div[4]/div[1]/form/div/div[1]/div[1]/div/div/div/ul/li")
	public static List<WebElement> projtypvalue;

	// review type selection element

	@FindBy(xpath = "//*[@id='projectsummary']/div/div[2]/div[1]/div/div/button")
	public WebElement revtypdrop;
	@FindBy(xpath = "html/body/div[5]/div[1]/div[3]/div[4]/div[1]/form/div/div[2]/div[1]/div/div/div/ul/li")
	public static List<WebElement> revtypvalue;

	@FindBy(id = "projecttitle")
	WebElement Full_title;

	@FindBy(id = "projectshorttitle")
	WebElement short_title;

	@FindBy(id = "pi_name")
	WebElement PI_Name;

	@FindBy(id = "project_description")
	WebElement sponsor;

	@FindBy(xpath = "//*[@id='sumsave']")
	WebElement save_button1;

	// document type selection element

	@FindBy(xpath = "//*[@id='document_type']/div/button")
	public WebElement docdrop;
	@FindBy(xpath = "//*[@id='document_type']/div/div/ul/li")
	public static List<WebElement> docvalue;

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

	@FindBy(id = "nextid")
	WebElement next_button1;

	@FindBy(linkText = "Download the template form")
	WebElement dwnld_temp_link;

	@FindBy(linkText = "Back")
	WebElement back_button1;

	@FindBy(id = "nextid")
	WebElement save_as_draft;

	@FindBy(id = "submitid")
	WebElement submit_to_IEC;

	@FindBy(xpath = "//span")
	WebElement Login_PI_Name;

	@FindBy(xpath = "//div[@id='list_documents']/div/div/table/tbody/tr/td")
	WebElement doctype_List;

	@FindBy(xpath = "//div[@id='list_documents']/div/div/table/tbody/tr/td[2]")
	WebElement doctype_title;

	@FindBy(xpath = "//div[@id='list_documents']/div/div/table/tbody/tr/td[3]")
	WebElement doctype_version;

	@FindBy(xpath = "//div[@id='list_documents']/div/div/table/tbody/tr/td[4]")
	WebElement doctype_date;

	@FindBy(xpath = "//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[1]")
	WebElement yes;

	@FindBy(xpath = "//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[2]")
	WebElement no;

	@FindBy(xpath = "//*[@id='submit_for_iec_review_confirm']")
	WebElement conflictsubmit;

	@FindBy(xpath = "//span/a")
	WebElement logoutt;

	@FindBy(css = "img")
	WebElement logo;

	@FindBy(css = "li.active > a")
	WebElement dash;

	@FindBy(xpath = "//li[4]/a/span")
	WebElement Ongoingprojects;

	@FindBy(xpath = "//td[9]/a/span")
	WebElement approvedprojoverview;

	// Admin IEC admin review page elements

	@FindBy(css = "span.pull-left")
	WebElement Dashboard_newsubmission;

	@FindBy(xpath = "//td[10]/a/span")
	WebElement Projectoverview;

	@FindBy(linkText = "IEC Admin Review")
	WebElement Admin_Review;

	@FindBy(id = "processing_fee_paid")
	WebElement Processing_fee_yes;

	@FindBy(id = "payment_receipt")
	WebElement payment_receipt_yes;

	@FindBy(id = "hard_copy_submitted")
	WebElement hard_copy_yes;

	@FindBy(id = "inward_no")
	WebElement inward_no_yes;

	@FindBy(id = "project_number")
	WebElement projnum;

	@FindBy(id = "insurance_date")
	WebElement insurdate;

	@FindBy(id = "inward_no_date")
	WebElement inwdate;

	@FindBy(id = "forward_modal_btn")
	WebElement forward_button;

	@FindBy(id = "txn_ethic_committee_id")
	WebElement ethic_selection;

	@FindBy(id = "forward_comments")
	WebElement ethic_comments;

	@FindBy(id = "ms_name")
	WebElement ethic_ms_name;

	@FindBy(id = "forward_btn")
	WebElement ethic_frwd;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement ethic_cancel;

	@FindBy(xpath = "//div[@id='flash_message_admin']/p")
	WebElement ethic_frwd_acknowledge;

	@FindBy(css = "span.fa.fa-eye")
	WebElement overview;

	@FindBy(xpath = "//body/div[5]/div/div/div[2]/div[3]/div[1]/p")
	WebElement projectmsg;

	// Member Secretary page elements

	@FindBy(linkText = "Projects")
	WebElement projectslink;

	@FindBy(linkText = "Assign Reviewer(s)")
	WebElement asignreviewers;

	@FindBy(id = "primary_reviewer")
	WebElement primaryreview_one;

	@FindBy(name = "nontech_primary_reviewer1")
	WebElement nonprimaryreview_one;

	@FindBy(name = "tech_primary_reviewer2")
	WebElement primaryreview_two;

	@FindBy(name = "nontech_primary_reviewer2")
	WebElement nonprimaryreview_two;

	@FindBy(name = "tech_primary_reviewer3")
	WebElement primaryreview_three;

	@FindBy(name = "nontech_primary_reviewer3")
	WebElement nonprimaryreview_three;

	@FindBy(id = "comments")
	WebElement assign_comments;

	@FindBy(id = "assign")
	WebElement assign_button;

	@FindBy(css = "div.flash.alert-info > p")
	WebElement assignreviewer_msg;

	@FindBy(linkText = "msmembercomments")
	WebElement membercomments;

	@FindBy(linkText = "IEC Decision")
	WebElement iecdecisiontab;

	@FindBy(id = "decision_type")
	WebElement decisondropdown;

	@FindBy(id = "proj_document")
	WebElement decisionupload;

	@FindBy(xpath = "//input[@value='Submit']")
	WebElement decisionusubmit;

	// Subsequent submission links elements

	@FindBy(linkText = "Submit New Documents")
	WebElement newdocuments;

	@FindBy(linkText = "Amendment")
	WebElement amend;

	@FindBy(linkText = "Deviation")
	WebElement deviat;

	@FindBy(linkText = "Continuation")
	WebElement continu;

	@FindBy(linkText = "Completion")
	WebElement complet;

	@FindBy(linkText = "Premature Termination")
	WebElement premterm;

	@FindBy(linkText = "SAE")
	WebElement seriousadverse;

	@FindBy(linkText = "Other")
	WebElement othr;

	// Amendment form fields elements

	@FindBy(css = "label.col-sm-3.offset-0")
	WebElement subtype_one;

	@FindBy(xpath = "//form[@id='submitnewuploadproject']/div/div/div[2]/label")
	WebElement doctype_two;

	@FindBy(xpath = "//form[@id='submitnewuploadproject']/div/div/div[3]/label")
	WebElement version_three;

	@FindBy(xpath = "//form[@id='submitnewuploadproject']/div/div/div[4]/label")
	WebElement docdate_four;

	@FindBy(xpath = "//div[@id='review_type']/label")
	WebElement revtype_five;

	@FindBy(xpath = "//form[@id='submitnewuploadproject']/div/div[2]/div[2]/label")
	WebElement doctitle_six;

	@FindBy(id = "savedoc")
	WebElement savdoc_seven;

	@FindBy(id = "proj_document")
	WebElement uploaddoc_seven;

	@FindBy(linkText = "Dashboard")
	WebElement dash_board;

	// Subsequent doctype upload

	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/button")
	public WebElement docdrop1;
	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/div/ul/li")
	public static List<WebElement> docvalue1;

	// Admin document type add elements

	@FindBy(linkText = "Manage IEC")
	WebElement manageiec;

	@FindBy(linkText = "Manage Document Type")
	WebElement managedoctype;

	@FindBy(linkText = "Add Document Type")
	WebElement adddoctype;

	@FindBy(id = "add_annexure_project_type")
	WebElement projdoc1;

	@FindBy(id = "add_annexure_review_type")
	WebElement revtype1;

	@FindBy(id = "add_annexure_submission_type")
	WebElement subtype1;

	@FindBy(id = "add_annexure_document_type")
	WebElement documenttype1;

	@FindBy(id = "(//input[@id='add_project_document_type_isMandatory'])[2]")
	WebElement mandatory_no;

	@FindBy(id = "add_project_document_type_isMandatory")
	WebElement mandatory_yes;

	@FindBy(id = "add_edit_annexure_details")
	WebElement doctype_submit;

	@FindBy(linkText = "IEC Submission Forms / Annexures")
	WebElement admin_menu_IEC_Submission_Forms_Annexures;

	@FindBy(linkText = "Add IEC Submission Form / Annexure")
	WebElement add_annexure_link;

	@FindBy(xpath = "//*[@id='addannexures']/div[1]/div/div/div/button")
	WebElement add_annexure_project_type;

	@FindBy(xpath = "//*[@id='addannexures']/div[2]/div/div/div/button")
	WebElement add_annexure_review_type;

	@FindBy(xpath = "//*[@id='addannexures']/div[3]/div/div/div/button")
	WebElement add_annexure_submission_type;

	@FindBy(xpath = "//*[@id='add_annexure_document_type']")
	WebElement add_annexure_document_type;

	@FindBy(xpath = "//*[@id='add_annexure_document_upload']")
	WebElement add_annexure_document_upload;

	@FindBy(id = "add_edit_annexure_details")
	WebElement add_annexure_details_add;

	@FindBy(xpath = "//form[@id='manageannexures']/div/p")
	WebElement add_annexure_acknowledge;

	@FindBy(linkText = "Publish")
	WebElement add_annexure_publish;

	@FindBy(linkText = "Download the template form")
	WebElement add_annexure_download;

	// verifying elements in list after save documents

	@FindBy(css = "td")
	WebElement amend_document_type;

	@FindBy(xpath = "//div[@id='list_documents']/div/div/table/tbody/tr/td[2]")
	WebElement amend_document_title;

	@FindBy(xpath = "//*[@id='list_documents']/div/div[1]/table/tbody/tr[1]/td[3]")
	WebElement amend_document_version;

	@FindBy(xpath = "//*[@id='list_documents']/div/div[1]/table/tbody/tr[1]/td[4]")
	WebElement amend_document_date;

	// Verifying save document elements in edit mode

	@FindBy(css = "i.fa.fa-edit")
	WebElement saved_document_edit;

	@FindBy(xpath = "//form[@id='documentuploadeditproject']/div/div[2]/div/div/button")
	WebElement document_type_in_edit;

	@FindBy(id = "document_date_edit")
	WebElement document_date_in_edit;

	@FindBy(id = "document_title_edit")
	WebElement document_title_in_edit;

	@FindBy(id = "version_edit")
	WebElement document_version_in_edit;

	@FindBy(xpath = "//form[@id='documentuploadeditproject']/div/div/div/div/button")
	WebElement submission_type_in_edit;

	@FindBy(xpath = "(//div[@id='review_type']/div/div/button)[2]")
	WebElement review_type_in_edit;

	// Filling data in edit document form elements

	@FindBy(id = "document_title_edit")
	WebElement edit_doc_title;

	@FindBy(id = "version_edit")
	WebElement edit_doc_version;

	@FindBy(linkText = "Delete")
	WebElement edit_doc_delete;

	@FindBy(id = "document_date_edit")
	WebElement edit_doc_date;

	@FindBy(id = "proj_document")
	WebElement edit_doc_upload;

	@FindBy(xpath = "//input[@value='Update']")
	WebElement edit_doc_upload_button;

	// document view icon element in list

	@FindBy(css = "i.fa.fa-eye")
	WebElement doc_view_icon_open;

	@FindBy(xpath = "//div[@id='pageContainer1']/div[2]/div[5]")
	WebElement doc_view_content;

	@FindBy(xpath = "//div[@id='viewDocument']/div[2]/div/div/button")
	WebElement doc_view_close;

	@FindBy(css = "span.fa.fa-edit")
	WebElement submission_edit_in_list;

	@FindBy(xpath = "//div[2]/div/div/ul/li[6]/a/span")
	WebElement amend_dashboard;

	@FindBy(xpath = "//td[7]")
	WebElement submission_type_in_list;

	@FindBy(id = "forward_chairman")
	WebElement forward_chairman_button;

	@FindBy(css = "div.nocontent > p")
	WebElement forward_chairman_msg;

	@FindBy(linkText = "Projects for IEC Review")
	WebElement Projects_for_IEC_Review_link;

	@FindBy(css = "div.flash.alert-info > p")
	WebElement chair_to_ms_msg;

	@FindBy(id = "assign1")
	WebElement submit_to_ms_button;

	@FindBy(css = "p.error-msg")
	WebElement assign_reviewers_alert;

	@FindBy(id = "review_type")
	WebElement review_type_select;

	@FindBy(xpath = "//td[4]")
	WebElement project_title_in_list;

	@FindBy(xpath = "//div[2]/div/div/ul/li[3]/a/span")
	WebElement completion_dashboard;

	// Check for Completions submission form for approved projects
	public void CRe4_2247() throws Exception {}

	// Check for Completion form mandatory fields
	public void CRe4_2248() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions_Validations");

		String Version_in_list = r1.getCell(2, 1).getContents();
		String doc_upload = r1.getCell(3, 1).getContents();
		String docutypetitle = r1.getCell(4, 1).getContents();
		String docutypedate = r1.getCell(5, 1).getContents();

		GlobalMethods.PI_Login();

		WebElement Ongoingprojects = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		Ongoingprojects.click();

		WebElement approvedprojoverview = GWait.Wait_GetElementByXpath("//td[9]/a/span");
		approvedprojoverview.click();

		WebElement newdocuments = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments.click();

		WebElement complet = GWait.Wait_GetElementByLinkText("Completion");
		complet.click();

		WebElement save_button2 = GWait.Wait_GetElementById("savedoc");
		save_button2.click();

		GlobalMethods.alertaccept();
		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; ) {
			Thread.sleep(3000);
			GWait.LoadGif();
			docdrop1.click();
			String numberAsString = Integer.toString(i);
			List<WebElement> elementsList3 = docvalue1;
			int j = 0;
			for (WebElement a11 : elementsList3) {
				WebElement span = a11.findElement(By.tagName("span"));
				System.out.println(numberAsString);
				System.out.println(span.getAttribute("data-original-index"));
				if (i == j) {
					Thread.sleep(2000);
					span.click();

					break;
				}
				j++;
			}
			if (i == j) {
				save_button2.click();
				GlobalMethods.alertaccept();

				WebElement doc_title = GWait.Wait_GetElementById("document_title");
				doc_title.sendKeys(docutypetitle);

				save_button2.click();
				GlobalMethods.alertaccept();

				WebElement doc_date = GWait.Wait_GetElementById("document_date");
				doc_date.sendKeys(docutypedate);

				save_button2.click();
				GlobalMethods.alertaccept();

				upload_doc.sendKeys(doc_upload);
				doc_version.sendKeys(Version_in_list);
				save_button2.click();
				Thread.sleep(5000);
				WebElement LogOut = GWait.Wait_GetElementByXpath("//span/a");
				LogOut.click();
			}
			break;
		}
	}

	// Check for submit new document document list section in Completion 
	public void CRe4_2252_2253_2254_2255() throws Exception {

		GlobalMethods.PI_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions_Validations");
		
		String Document_Title_in_list = r1.getCell(2, 3).getContents();
		String Version_in_list = r1.getCell(3, 3).getContents();
		String Document_Date_in_list = r1.getCell(4, 3).getContents();
		String doc_upload = r1.getCell(5, 3).getContents();
		String amend_doc_title = r1.getCell(6, 3).getContents();
		String amend_doc_version = r1.getCell(7, 3).getContents();
		String amend_doc_date = r1.getCell(8, 3).getContents();
		String amend_doc_title_edit = r1.getCell(9, 3).getContents();
		String amend_doc_version_edit = r1.getCell(10, 3).getContents();
		String amend_doc_date_edit = r1.getCell(11, 3).getContents();
		String amend_doc_upload_edit = r1.getCell(12, 3).getContents();

		

		WebElement Ongoingprojects = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		Ongoingprojects.click();

		WebElement approvedprojoverview = GWait.Wait_GetElementByXpath("//td[9]/a/span");
		approvedprojoverview.click();

		WebElement newdocuments = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments.click();

		WebElement complet = GWait.Wait_GetElementByLinkText("Completion");
		complet.click();

		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; ) {
			Thread.sleep(4000);
			GWait.LoadGif();
			docdrop1.click();
			String numberAsString = Integer.toString(i);
			List<WebElement> elementsList3 = docvalue1;
			int j = 0;
			for (WebElement a11 : elementsList3) {
				WebElement span = a11.findElement(By.tagName("span"));
				System.out.println(numberAsString);
				System.out.println(span.getAttribute("data-original-index"));
				if (i == j) {
					span.click();

					break;
				}
				j++;
			}
			if (i == j) {
				doc_title.sendKeys(Document_Title_in_list);
				doc_version.sendKeys(Version_in_list);
				doc_date.sendKeys(Document_Date_in_list);
				upload_doc.sendKeys(doc_upload);
				WebElement save_button2 = GWait.Wait_GetElementById("savedoc");
				save_button2.click();

			}
			break;
		}

		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(2000);
		WebElement doc_view_icon_open = GWait.Wait_GetElementByCSS("i.fa.fa-eye");
		doc_view_icon_open.click();
		Thread.sleep(3000);
		WebElement doc_view_close = GWait.Wait_GetElementByXpath(".//*[@id='viewDocument']/div[2]/div/div[1]/button");
		doc_view_close.click();
		WebElement amend_document_title = GWait
				.Wait_GetElementByXpath("//div[@id='list_documents']/div/div/table/tbody/tr/td[2]");
		String amend_document_title_1 = amend_document_title.getText();
		amend_doc_title.equalsIgnoreCase(amend_document_title_1);
		System.out.println(amend_document_title_1);

		String amend_document_version_1 = amend_document_version.getText();
		amend_doc_version.equalsIgnoreCase(amend_document_version_1);
		System.out.println(amend_document_version_1);

		String amend_document_date_1 = amend_document_date.getText();
		amend_doc_date.equalsIgnoreCase(amend_document_date_1);
		System.out.println(amend_document_date_1);

		WebElement saved_document_edit = GWait.Wait_GetElementByCSS("i.fa.fa-edit");

		saved_document_edit.click();

		System.out.println(submission_type_in_edit.getText());

		System.out.println(document_type_in_edit.getAttribute("value"));

		System.out.println(document_date_in_edit.getAttribute("value"));

		System.out.println(document_title_in_edit.getAttribute("value"));

		System.out.println(document_version_in_edit.getAttribute("value"));

		WebElement edit_doc_title = GWait.Wait_GetElementById("document_title_edit");

		edit_doc_title.clear();
		edit_doc_title.sendKeys(amend_doc_title_edit);

		WebElement edit_doc_version = GWait.Wait_GetElementById("version_edit");
		edit_doc_version.clear();
		edit_doc_version.sendKeys(amend_doc_version_edit);

		edit_doc_date.clear();
		edit_doc_date.sendKeys(amend_doc_date_edit);

		WebElement edit_doc_delete = GWait.Wait_GetElementByLinkText("Delete");
		edit_doc_delete.click();
		WebElement edit_doc_upload = GWait.Wait_GetElementById("proj_document");
		edit_doc_upload.sendKeys(amend_doc_upload_edit);

		WebElement edit_doc_upload_button = GWait.Wait_GetElementByXpath("//input[@value='Update']");
		edit_doc_upload_button.click();
		Thread.sleep(2000);
		WebElement amend_document_title1 = GWait
				.Wait_GetElementByXpath("//div[@id='list_documents']/div/div/table/tbody/tr/td[2]");
		String amend_document_title_2 = amend_document_title1.getText();
		amend_doc_title.equalsIgnoreCase(amend_document_title_2);
		System.out.println(amend_document_title_2);
		Thread.sleep(2000);
		String amend_document_version_2 = amend_document_version.getText();
		amend_doc_version.equalsIgnoreCase(amend_document_version_2);
		System.out.println(amend_document_version_2);
		Thread.sleep(2000);
		String amend_document_date_2 = amend_document_date.getText();
		amend_doc_date.equalsIgnoreCase(amend_document_date_2);
		System.out.println(amend_document_date_2);
		Thread.sleep(3000);
		WebElement LogOut = GWait.Wait_GetElementByXpath("//span/a");
		LogOut.click();

	}

	// Check for save Completion as draft
	public void CRe4_2257_2258() throws Exception {

		GlobalMethods.PI_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions_Validations");

		String Document_Title_in_list = r1.getCell(2, 5).getContents();
		String Version_in_list = r1.getCell(3, 5).getContents();
		String Document_Date_in_list = r1.getCell(4, 5).getContents();
		String doc_upload = r1.getCell(5, 5).getContents();

		WebElement Ongoingprojects = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		Ongoingprojects.click();

		WebElement approvedprojoverview = GWait.Wait_GetElementByXpath("//td[9]/a/span");
		approvedprojoverview.click();

		WebElement newdocuments = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments.click();

		WebElement complet = GWait.Wait_GetElementByLinkText("Completion");
		complet.click();

		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; i++) {
			Thread.sleep(4000);
			GWait.LoadGif();
			docdrop1.click();
			String numberAsString = Integer.toString(i);
			List<WebElement> elementsList3 = docvalue1;
			int j = 0;
			for (WebElement a11 : elementsList3) {
				WebElement span = a11.findElement(By.tagName("span"));
				System.out.println(numberAsString);
				System.out.println(span.getAttribute("data-original-index"));
				if (i == j) {
					span.click();

					break;
				}
				j++;
			}
			if (i == j) {
				doc_title.sendKeys(Document_Title_in_list);
				doc_version.sendKeys(Version_in_list);
				doc_date.sendKeys(Document_Date_in_list);
				upload_doc.sendKeys(doc_upload);
				WebElement save_button2 = GWait.Wait_GetElementById("savedoc");
				save_button2.click();
				Thread.sleep(2000);
			}
			break;
		}
		Thread.sleep(3000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		WebElement next_button1 = GWait.Wait_GetElementById("nextid");
		next_button1.click();

		WebElement next_button11 = GWait.Wait_GetElementById("nextid");

		next_button11.click();

		WebElement submission_edit_in_list = GWait.Wait_GetElementByCSS("span.fa.fa-edit");

		submission_edit_in_list.click();

		WebElement next_button2 = GWait.Wait_GetElementById("nextid");
		next_button2.click();

		WebElement submit_to_IEC = GWait.Wait_GetElementById("submitid");
		submit_to_IEC.click();
		Thread.sleep(2000);
		WebElement no = GWait.Wait_GetElementByXpath("//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[2]");
		no.click();
		WebElement conflictsubmit = GWait.Wait_GetElementByXpath("//*[@id='submit_for_iec_review_confirm']");
		conflictsubmit.click();

		GlobalMethods.alertaccept();
		Thread.sleep(2000);
		WebElement LogOut = GWait.Wait_GetElementByXpath("//span/a");
		LogOut.click();

	}

	// Check for Completion in admin login
	public void CRe4_2259() throws Exception {

		
		try {
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet Amendment_Data = wb.getSheet("Project Submissions_Validations");

			String submission_name_in_adminlist = Amendment_Data.getCell(2, 7).getContents();

			GlobalMethods.Admin_Login();

			WebElement completion_dashboard = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[3]/a/span");
			completion_dashboard.click();

			String submission_type_list_1 = submission_type_in_list.getText();
			submission_name_in_adminlist.equalsIgnoreCase(submission_type_list_1);
			System.out.println(submission_type_list_1);
			Thread.sleep(3500);
			WebElement LogOut = GWait.Wait_GetElementByXpath("//span/a");
			LogOut.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// Check for MS assign reviewers if Completion is of expedited review type
	public void CRe4_CRe4_2260_2261_2262_2263() throws Exception {

		// Create initial project and give MS decision as 'Letter of permission'

		// Login as PI

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions_Validations");

		String Document_Title_in_list = r1.getCell(2, 9).getContents();
		String Version_in_list = r1.getCell(3, 9).getContents();
		String Document_Date_in_list = r1.getCell(4, 9).getContents();
		String doc_upload = r1.getCell(5, 9).getContents();

		gps.PI_SubmitProject_IECAdmin();
		Thread.sleep(3500);
		WebElement LogOut = GWait.Wait_GetElementByXpath("//span/a");
		LogOut.click();
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();

		// Login as admin

		gps.Dashboard_Click_Admin();

		// Submit IEC admin review

		String pyrcnum = r1.getCell(6, 9).getContents();
		String inwnum = r1.getCell(7, 9).getContents();
		String prjnum = r1.getCell(8, 9).getContents();
		String insdate = r1.getCell(9, 9).getContents();
		String inwrddate = r1.getCell(10, 9).getContents();
		String ethic_com = r1.getCell(11, 9).getContents();
		String ethic_comnts = r1.getCell(12, 9).getContents();

		WebElement Projectoverview = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview.click();
		WebElement Admin_Review = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review.click();
		WebElement Processing_fee_yes = GWait.Wait_GetElementById("processing_fee_paid");
		Processing_fee_yes.click();

		payment_receipt_yes.sendKeys(pyrcnum);

		hard_copy_yes.click();

		inward_no_yes.sendKeys(inwnum);

		projnum.sendKeys(prjnum);

		insurdate.sendKeys(insdate);

		inwdate.sendKeys(inwrddate);

		forward_button.click();
		WebElement ethic_selection = GWait.Wait_GetElementById("txn_ethic_committee_id");

		Select select = new Select(ethic_selection);
		select.selectByVisibleText(ethic_com);

		WebElement ethic_comments = GWait.Wait_GetElementByClassName("richText");

		ethic_comments.sendKeys(ethic_comnts);

		String MSname = ethic_ms_name.getAttribute("Value");

		ethic_frwd.click();

		WebElement ethic_frwd_acknowledge = GWait.Wait_GetElementByXpath("//div[@id='flash_message_admin']/p");

		String msg = "Submission has been forwarded to Member Secretary" + " " + MSname;
		System.out.println(msg);
		String acknowledge = ethic_frwd_acknowledge.getText();
		acknowledge.equalsIgnoreCase(msg);
		Thread.sleep(3500);
		WebElement LogOut1 = GWait.Wait_GetElementByXpath("//span/a");
		LogOut1.click();
		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();

		// MS assign reviewers & giving decision

		gps.MS_Dashboard_Click();

		String Rev_one = r1.getCell(13, 9).getContents();

		String Decision_LOP = r1.getCell(14, 9).getContents();
		String Decisionfile = r1.getCell(15, 9).getContents();
		String Decisioncmnt = r1.getCell(16, 9).getContents();

		WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");

		Projectoverview1.click();

		WebElement asignreviewers = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");

		asignreviewers.click();

		WebElement primaryreview_one = GWait.Wait_GetElementById("primary_reviewer");
		Select select1 = new Select(primaryreview_one);
		select1.selectByVisibleText(Rev_one);

		WebElement forward_chairman_button = GWait.Wait_GetElementById("forward_chairman");
		forward_chairman_button.click();
		Thread.sleep(3500);
		WebElement LogOut2 = GWait.Wait_GetElementByXpath("//span/a");
		LogOut2.click();

		WebElement logo11 = GWait.Wait_GetElementByCSS("img");
		logo11.click();

		gps.CP_DashboardClick();
		gps.CP_SubmitProjectTo_MS();
		Thread.sleep(3500);
		WebElement LogOut3 = GWait.Wait_GetElementByXpath("//span/a");
		LogOut3.click();

		WebElement logo2 = GWait.Wait_GetElementByCSS("img");
		logo2.click();

		// ****
		gps.MS_Dashboard_Click();

		WebElement Projectoverview11 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview11.click();
		WebElement asignreviewers1 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers1.click();

		WebElement assign_button = GWait.Wait_GetElementById("assign");
		assign_button.click();
		Thread.sleep(2000);
		GlobalMethods.Commentswindhandler();

		WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab.click();

		WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
		Select select7 = new Select(decisondropdown);
		select7.selectByVisibleText(Decision_LOP);
		WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
		decisionupload.sendKeys(Decisionfile);
		WebElement assign_comments = GWait.Wait_GetElementById("comments");
		assign_comments.sendKeys(Decisioncmnt);
		WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit.click();
		Thread.sleep(3500);
		WebElement LogOut4 = GWait.Wait_GetElementByXpath("//span/a");
		LogOut4.click();
		WebElement logo3 = GWait.Wait_GetElementByCSS("img");
		logo3.click();

		GlobalMethods.PI_Login();

		WebElement Ongoingprojects = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		Ongoingprojects.click();
		WebElement approvedprojoverview = GWait.Wait_GetElementByXpath("//td[9]/a/span");
		approvedprojoverview.click();

		WebElement newdocuments = GWait.Wait_GetElementByLinkText("Submit New Documents");

		newdocuments.click();

		WebElement complet = GWait.Wait_GetElementByLinkText("Completion");
		complet.click();

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
					span.click();

					break;
				}
				j++;
			}
			if (i == j) {
				doc_title.sendKeys(Document_Title_in_list);
				doc_version.sendKeys(Version_in_list);
				doc_date.sendKeys(Document_Date_in_list);
				upload_doc.sendKeys(doc_upload);
				WebElement save_button2 = GWait.Wait_GetElementById("savedoc");
				save_button2.click();

			}

		}

		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(4000);
		WebElement next_button1 = GWait.Wait_GetElementByCSS("#nextid");
		next_button1.click();

		WebElement submit_to_IEC = GWait.Wait_GetElementById("submitid");
		submit_to_IEC.click();
		Thread.sleep(2000);
		WebElement no = GWait.Wait_GetElementByXpath("//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[2]");
		no.click();
		WebElement conflictsubmit = GWait.Wait_GetElementByXpath("//*[@id='submit_for_iec_review_confirm']");
		conflictsubmit.click();

		GlobalMethods.alertaccept();
		Thread.sleep(4000);
		WebElement LogOut31 = GWait.Wait_GetElementByXpath("//span/a");
		LogOut31.click();

		WebElement logo13 = GWait.Wait_GetElementByCSS("img");
		logo13.click();

		// Login as admin

		GlobalMethods.Admin_Login();

		gps.Global_Dashboard_CompletionLink();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();
		WebElement Admin_Review1 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review1.click();
		Thread.sleep(2000);
		WebElement forward_button = GWait.Wait_GetElementById("forward_modal_btn");
		forward_button.click();
		Thread.sleep(2000);
		WebElement ethic_frwd = GWait.Wait_GetElementById("forward_btn");
		ethic_frwd.click();
		GWait.blockUI();
		Thread.sleep(10000);
		WebElement proj = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		proj.click();
		Thread.sleep(3500);
		WebElement LogOut6 = GWait.Wait_GetElementByXpath("//span/a");
		LogOut6.click();
		WebElement logo14 = GWait.Wait_GetElementByCSS("img");
		logo14.click();

		GlobalMethods.MS_Login();

		gps.Global_Dashboard_CompletionLink();
		WebElement Projectoverview111 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview111.click();
		WebElement asignreviewers11 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers11.click();
		WebElement forward_chairman_button1 = GWait.Wait_GetElementById("forward_chairman");
		forward_chairman_button1.click();
		WebElement assign_reviewers_alert = GWait.Wait_GetElementByCSS("p.error-msg");
		String assign_reviewers_alert_1 = assign_reviewers_alert.getText();
		System.out.println(assign_reviewers_alert_1);
		WebElement primaryreview_one1 = GWait.Wait_GetElementById("primary_reviewer");
		Select select_1a = new Select(primaryreview_one1);
		select_1a.selectByVisibleText(Rev_one);
		WebElement forward_chairman_button11 = GWait.Wait_GetElementById("forward_chairman");
		forward_chairman_button11.click();
		Thread.sleep(3500);
		WebElement LogOut7 = GWait.Wait_GetElementByXpath("//span/a");
		LogOut7.click();
	}

	Global_Project_Submissions gps = new Global_Project_Submissions();
	// Check for MS assign reviewers if Completion is of full board review type
	public void CRe4_2264() throws Exception {

		// Create initial project and give MS decision as 'Letter of permission'
		// Login as PI
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions_Validations");
		// Project summary data
		String Review_Type = r1.getCell(2, 11).getContents();
		String Review_Type_expedited = r1.getCell(3, 11).getContents();
		String Document_Title_in_list = r1.getCell(4, 11).getContents();
		String Version_in_list = r1.getCell(5, 11).getContents();
		String Document_Date_in_list = r1.getCell(6, 11).getContents();
		String doc_upload = r1.getCell(7, 11).getContents();

		String ethic_com = r1.getCell(8, 11).getContents();
		String ethic_comnts = r1.getCell(9, 11).getContents();

		String Rev_one = r1.getCell(10, 11).getContents();

		GlobalMethods.PI_Login();

		WebElement Ongoingprojects = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		Ongoingprojects.click();
		WebElement approvedprojoverview = GWait.Wait_GetElementByXpath("//td[9]/a/span");
		approvedprojoverview.click();

		WebElement newdocuments = GWait.Wait_GetElementByLinkText("Submit New Documents");

		newdocuments.click();

		WebElement complet = GWait.Wait_GetElementByLinkText("Completion");
		complet.click();

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
					span.click();

					break;
				}
				j++;
			}
			if (i == j) {
				doc_title.sendKeys(Document_Title_in_list);
				doc_version.sendKeys(Version_in_list);
				doc_date.sendKeys(Document_Date_in_list);
				upload_doc.sendKeys(doc_upload);
				WebElement save_button2 = GWait.Wait_GetElementById("savedoc");
				save_button2.click();

			}

		}

		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(3000);
		WebElement next_button1 = GWait.Wait_GetElementById("nextid");
		next_button1.click();
		WebElement submit_to_IEC = GWait.Wait_GetElementById("submitid");
		submit_to_IEC.click();
		Thread.sleep(3000);
		WebElement no = GWait.Wait_GetElementByXpath("//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[2]");
		no.click();
		WebElement conflictsubmit = GWait.Wait_GetElementByXpath("//*[@id='submit_for_iec_review_confirm']");
		conflictsubmit.click();

		GlobalMethods.alertaccept();
		Thread.sleep(3500);
		WebElement LogOut4 = GWait.Wait_GetElementByXpath("//span/a");
		LogOut4.click();
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();

		// Login as admin
		GlobalMethods.Admin_Login();

		gps.Global_Dashboard_CompletionLink();
		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();
		WebElement Admin_Review1 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review1.click();
		WebElement forward_button = GWait.Wait_GetElementById("forward_modal_btn");
		forward_button.click();
		Thread.sleep(3000);
		WebElement ethic_frwd = GWait.Wait_GetElementById("forward_btn");
		ethic_frwd.click();
		GWait.blockUI();
		Thread.sleep(10000);
		WebElement proj = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		proj.click();
		Thread.sleep(3500);
		WebElement LogOut6 = GWait.Wait_GetElementByXpath("//span/a");
		LogOut6.click();
		WebElement logo14 = GWait.Wait_GetElementByCSS("img");
		logo14.click();

		// MS assign reviewers & giving decision

		GlobalMethods.MS_Login();
		gps.Global_Dashboard_CompletionLink();
		WebElement Projectoverview = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview.click();
		WebElement asignreviewers = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers.click();
		Select select_1b = new Select(review_type_select);
		select_1b.selectByVisibleText(Review_Type_expedited);
		WebElement forward_chairman_button = GWait.Wait_GetElementById("forward_chairman");
		forward_chairman_button.click();
		Select select_1b1 = new Select(review_type_select);
		select_1b1.selectByVisibleText(Review_Type);
		Select select2a = new Select(primaryreview_one);
		select2a.selectByVisibleText(Rev_one);
		WebElement assign_button = GWait.Wait_GetElementById("assign");
		assign_button.click();
		Thread.sleep(3500);
		WebElement LogOut61 = GWait.Wait_GetElementByXpath("//span/a");
		LogOut61.click();

	}

	// Check for document type field in Completion form
	public void CRe4_2249_2250_2251() throws Exception {

		GlobalMethods.Admin_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions_Validations");

		String document_types = r1.getCell(2, 13).getContents();

		String Project_Type = r1.getCell(3, 13).getContents();
		String Review_Type = r1.getCell(4, 13).getContents();
		
		String document_upload = r1.getCell(5, 13).getContents();
		String sub_amend = r1.getCell(6, 13).getContents();
		

		WebElement manageiec = GWait.Wait_GetElementByLinkText("Manage IEC");
		manageiec.click();
		WebElement managedoctype = GWait.Wait_GetElementByLinkText("Manage Document Type");
		managedoctype.click();
		WebElement adddoctype = GWait.Wait_GetElementByLinkText("Add Document Type");
		adddoctype.click();
		WebElement projdoc1 = GWait.Wait_GetElementById("add_annexure_project_type");
		Select select8 = new Select(projdoc1);
		select8.selectByVisibleText(Project_Type);
		WebElement revtype1 = GWait.Wait_GetElementById("add_annexure_review_type");
		Select select9 = new Select(revtype1);
		select9.selectByVisibleText(Review_Type);
		WebElement subtype1 = GWait.Wait_GetElementById("add_annexure_submission_type");
		Select select10 = new Select(subtype1);
		select10.selectByVisibleText(sub_amend);
		WebElement documenttype1 = GWait.Wait_GetElementById("add_annexure_document_type");
		documenttype1.sendKeys(document_types);

		WebElement doctype_submit = GWait.Wait_GetElementById("add_edit_annexure_details");

		doctype_submit.click();
		WebElement admin_menu_IEC_Submission_Forms_Annexures = GWait
				.Wait_GetElementByLinkText("IEC Submission Forms / Annexures");
		admin_menu_IEC_Submission_Forms_Annexures.click();

		WebElement add_annexure_link = GWait.Wait_GetElementByLinkText("Add IEC Submission Form / Annexure");
		add_annexure_link.click();

		WebElement docdrop_proj = GWait.Wait_GetElementByXpath("//*[@id='addannexures']/div[1]/div/div/div/button");
		docdrop_proj.click();

		List<WebElement> elementsList11 = docvalue_proj;
		for (WebElement a11 : elementsList11) {
			WebElement span = a11.findElement(By.tagName("span"));
			if (span.getText().equalsIgnoreCase(Project_Type)) {
				span.click();
				break;
			}
		}

		WebElement docdrop_rev = GWait.Wait_GetElementByXpath("//*[@id='addannexures']/div[2]/div/div/div/button");
		docdrop_rev.click();
		List<WebElement> elementsList2 = docvalue_rev;
		for (WebElement a111 : elementsList2) {
			WebElement span = a111.findElement(By.tagName("span"));
			// System.out.println(Review_Type);
			// System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(Review_Type)) {
				span.click();
				break;
			}
		}

		WebElement docdrop_sub = GWait.Wait_GetElementByXpath("//*[@id='addannexures']/div[3]/div/div/div/button");
		docdrop_sub.click();
		List<WebElement> elementsList2a = docvalue_sub;
		for (WebElement a111 : elementsList2a) {
			WebElement span = a111.findElement(By.tagName("span"));
			// System.out.println(Review_Type);
			// System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(sub_amend)) {
				span.click();
				break;
			}
		}

		Select select_4 = new Select(annexure_document_type);
		select_4.selectByVisibleText(document_types);

		add_annexure_document_upload.sendKeys(document_upload);

		WebElement doctype_submit1 = GWait.Wait_GetElementById("add_edit_annexure_details");
		doctype_submit1.click();

		WebElement add_annexure_publish = GWait.Wait_GetElementByLinkText("Publish");
		add_annexure_publish.click();
		Thread.sleep(3500);
		WebElement LogOut = GWait.Wait_GetElementByXpath("//span/a");
		LogOut.click();
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();

		GlobalMethods.PI_Login();

		WebElement Ongoingprojects = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		Ongoingprojects.click();

		WebElement approvedprojoverview = GWait.Wait_GetElementByXpath("//td[9]/a/span");
		approvedprojoverview.click();

		WebElement newdocuments = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments.click();

		WebElement complet = GWait.Wait_GetElementByLinkText("Completion");
		complet.click();

		WebElement docdrop1 = GWait
				.Wait_GetElementByXpath("//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/button");
		docdrop1.click();

		List<WebElement> elementsList4 = docvalue1;
		for (WebElement a11 : elementsList4) {
			WebElement span = a11.findElement(By.tagName("span"));

			if (span.getText().equalsIgnoreCase(document_types)) {
				span.click();
				break;
			} else {
				System.out.println(
						"Value is does not exist & added document type is not listing in amendment document type drop down");
				return;
			}
		}

		WebElement add_annexure_download = GWait.Wait_GetElementByLinkText("Download the template form");

		add_annexure_download.click();

		Thread.sleep(2000);
		GlobalMethods.AcceptDoenloadPopup();
		Thread.sleep(3500);
		WebElement LogOut2 = GWait.Wait_GetElementByXpath("//span/a");
		LogOut2.click();

	}

	// Check for single member comment on Completion before MS comments
	public void CRe4_2276() throws Exception {

		// Create initial project and give MS decision as 'Letter of permission'
		// Login as PI
		GlobalMethods.Member1Login();
		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();
		Thread.sleep(2000);
		GlobalMethods.Commentswindhandler();
		Thread.sleep(3500);
		WebElement LogOut14 = GWait.Wait_GetElementByXpath("//span/a");
		LogOut14.click();

	}
}
