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

import com.global.methods.Dashboard_Links;
import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;
import com.global.methods.Global_Project_Submissions;
import com.google.common.annotations.GwtCompatible;

import jxl.Sheet;
import jxl.Workbook;

//Check for Provisional/Suspension/Query/Resubmission/Returned�letter reply submission to IEC with blank form

public class TS_170 extends TS_51 {

	public TS_170() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(id = "nextidedit")
	WebElement next_edit_button;

	@FindBy(xpath = "//div[2]/div/div/ul/li[4]/a/span")
	WebElement query_reply_admin_dashboard;

	@FindBy(xpath = "//div[2]/div/div/ul/li[6]/a/span")
	WebElement amend_dashboard;

	@FindBy(xpath = "//*[@id='documentuploadprojectresubmission']/div/div[1]/div[1]/div/div[1]/button")
	public WebElement docdrop_resub;
	@FindBy(xpath = "//*[@id='documentuploadprojectresubmission']/div/div[1]/div[1]/div/div[1]/div/ul/li")
	public static List<WebElement> docvalue_resub;

	@FindBy(xpath = "//*[@id='documentuploadprojectprovisional']/div/div[1]/div[1]/div/div[1]/button")
	public WebElement docdrop_prov;
	@FindBy(xpath = "//*[@id='documentuploadprojectprovisional']/div/div[1]/div[1]/div/div[1]/div/ul/li")
	public static List<WebElement> docvalue_prov;

	@FindBy(xpath = "//*[@id='document_types_edit']/div/button")
	public WebElement docdrop_edit;
	@FindBy(xpath = "//*[@id='document_types_edit']/div/div/ul/li")
	public static List<WebElement> docvalue_edit;

	@FindBy(xpath = "//*[@id='documentuploadprojectsuspension']/div/div[1]/div[1]/div/div[1]/button")
	public WebElement docdrop_sus;
	@FindBy(xpath = "//*[@id='documentuploadprojectsuspension']/div/div[1]/div[1]/div/div[1]/div/ul/li")
	public static List<WebElement> docvalue_sus;

	@FindBy(linkText = "Submit New Project")
	WebElement createproject;

	@FindBy(linkText = "My Projects")
	WebElement PI_project_menu;

	@FindBy(linkText = "Projects")
	WebElement MS_project_menu;

	@FindBy(linkText = "Archived Projects")
	WebElement PI_archived_menu;

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

	@FindBy(id = "sumsave")
	WebElement save_button3;

	// document type selection element_initial

	@FindBy(xpath = "//*[@id='document_type']/div/button")
	public WebElement docdrop;
	@FindBy(xpath = "//*[@id='document_type']/div/div/ul/li")
	public static List<WebElement> docvalue;

	// document type selection element_continuing

	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/button")
	public WebElement docdrop_c;
	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/div/ul/li")
	public static List<WebElement> docvalue_c;

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

	@FindBy(className = "studyteam_members")
	WebElement yes;

	@FindBy(xpath = "(//input[@name='studyteam_members'])[2]")
	WebElement no;

	@FindBy(id = "submit_for_iec_review_confirm")
	WebElement conflictsubmit;

	@FindBy(xpath = "//span[3]/a")
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

	@FindBy(xpath = "//div[2]/div/div/ul/li[7]/a/span")
	WebElement deviation_dashboard;

	// sussequent doctype upload

	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/button")
	public WebElement docdrop1;
	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/div/ul/li")
	public static List<WebElement> docvalue1;

	@FindBy(xpath = "//*[@id='respondqueryupload']/div/div[1]/div[1]/div/div/button")
	public WebElement docdrop2;
	@FindBy(xpath = "//*[@id='respondqueryupload']/div/div[1]/div[1]/div/div/div/ul/li")
	public static List<WebElement> docvalue2;

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

	@FindBy(xpath = "//div[2]/div/div/ul/li[2]/a/span")
	WebElement continuation_dashboard;

	@FindBy(xpath = "//li[3]/a/span")
	WebElement query_reply_dashboard;

	@FindBy(xpath = "//div[3]/ul/li[4]/a")
	WebElement query_tab;

	@FindBy(css = "span.fa.fa-edit")
	WebElement query_tab_edit;

	@FindBy(id = "query_comments")
	WebElement query_comments;

	@FindBy(id = "querysubmit")
	WebElement query_submit_button;

	@FindBy(xpath = "//td[5]")
	WebElement project_status;

	@FindBy(xpath = "//td[6]")
	WebElement latest_submission;

	@FindBy(xpath = "//td[8]")
	WebElement document_status;

	@FindBy(linkText = "Overview")
	WebElement PI_overview;

	@FindBy(linkText = "Study Team Member")
	WebElement PI_study_team_mem;

	@FindBy(linkText = "Project History")
	WebElement PI_history;

	// admin return to pi form elements

	@FindBy(id = "return_modal_btn")
	WebElement Return_To_PI_button;

	@FindBy(id = "return_comments")
	WebElement Return_To_PI_comments;

	@FindBy(id = "return_btn")
	WebElement Returning_PI_button;

	// elements in pi to check returned project from dashboard

	@FindBy(xpath = "//li[5]/a/span")
	WebElement Submissions_returned_dash;

	@FindBy(linkText = "Resubmission")
	WebElement resubmission_edit;

	// Check for suspension letter reply submission to IEC with blank form
	public void CRe4_1961() throws Exception {

		Global_Project_Submissions gp = new Global_Project_Submissions();
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		String Document_Title_in_list = r1.getCell(2, 513).getContents();
		String Version_in_list = r1.getCell(3, 513).getContents();
		String Document_Date_in_list = r1.getCell(4, 513).getContents();
		String doc_upload = r1.getCell(5, 513).getContents();

		TS_53 obj = new TS_53();

		obj.CRe4_1409();

		
		
		GlobalMethods.PI_Login();

		WebElement query_reply_dashboard12 = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		query_reply_dashboard12.click();

		WebElement query_tab_edit1 = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		query_tab_edit1.click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		System.out.println(docvalue_sus.size() - 1);

		for (int i = Global_Project_Submissions.querydoccount; i <= docvalue_sus.size() - 1; i++) {
			Thread.sleep(3000);
			docdrop_sus.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
			List<WebElement> elementsList3 = docvalue_sus;
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
				WebElement save_button2 = GWait.Wait_GetElementById("savedoc");
				save_button2.click();
				GlobalMethods.alertaccept();
				Thread.sleep(8000);

				WebElement doc_title = GWait.Wait_GetElementById("document_title");
				doc_title.sendKeys(Document_Title_in_list);

				WebElement save_button21 = GWait.Wait_GetElementById("savedoc");
				save_button21.click();
				GlobalMethods.alertaccept();
				Thread.sleep(8000);
				
				WebElement doc_date = GWait.Wait_GetElementById("document_date");
				doc_date.sendKeys(Document_Date_in_list);

				WebElement doc_version = GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);
				WebElement save_button22 = GWait.Wait_GetElementById("savedoc");
				save_button22.click();
				GlobalMethods.alertaccept();
				Thread.sleep(8000);

				WebElement upload_doc = GWait.Wait_GetElementById("proj_document");
				upload_doc.sendKeys(doc_upload);
				Thread.sleep(2000);
				WebElement save_button23 = GWait.Wait_GetElementById("savedoc");
				save_button23.click();

			}

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(10000);

		WebElement submit_to_IEC = GWait.Wait_GetElementById("submitid");
		submit_to_IEC.click();
		Thread.sleep(6000);
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();

		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();

	}

	// Check for query letter reply submission to IEC with blank form
	public void CRe4_1967() throws Exception {

		Global_Project_Submissions g5 = new Global_Project_Submissions();
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		String Document_Title_in_list = r1.getCell(2, 515).getContents();
		String Version_in_list = r1.getCell(3, 515).getContents();
		String Document_Date_in_list = r1.getCell(4, 515).getContents();
		String doc_upload = r1.getCell(5, 515).getContents();
		String Query_Cmnts_Continuation = r1.getCell(6, 515).getContents();

		CRe4_1241();
		
		
		//g5.PI_SubmitProject_IECAdmin();
		
		GlobalMethods.PI_Login();

		WebElement query_reply_dashboard = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		query_reply_dashboard.click();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();

		WebElement query_tab = GWait.Wait_GetElementByXpath("//div[3]/ul/li[4]/a");
		query_tab.click();

		WebElement query_tab_edit = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		query_tab_edit.click();

		WebElement save_button3 = GWait.Wait_GetElementById("sumsave");
		save_button3.click();

		GlobalMethods.alertaccept();

		WebElement query_comments = GWait.Wait_GetElementById("query_comments");
		query_comments.sendKeys(Query_Cmnts_Continuation);

		Thread.sleep(2000);
		System.out.println(docvalue2.size() - 1);
        System.out.println("AA " + Global_Project_Submissions.querydoccount);
		for (int i = Global_Project_Submissions.querydoccount; i <= docvalue2.size() - 1; i++) {
			Thread.sleep(6000);
			System.out.println("AA 1" + Global_Project_Submissions.querydoccount);
			docdrop2.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
			List<WebElement> elementsList3 = docvalue2;
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
				WebElement save_button2 = GWait.Wait_GetElementById("savedoc");
				save_button2.click();
				Thread.sleep(8000);

				GlobalMethods.alertaccept();
				Thread.sleep(2000);

				WebElement doc_title = GWait.Wait_GetElementById("document_title");
				doc_title.sendKeys(Document_Title_in_list);

				WebElement save_button24 = GWait.Wait_GetElementById("savedoc");
				save_button24.click();
				Thread.sleep(8000);

				GlobalMethods.alertaccept();
				Thread.sleep(2000);
				WebElement doc_date = GWait.Wait_GetElementById("document_date");
				doc_date.sendKeys(Document_Date_in_list);
				Thread.sleep(2000);
				WebElement doc_version = GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);
				Thread.sleep(2000);

				WebElement save_button22 = GWait.Wait_GetElementById("savedoc");
				save_button22.click();
				Thread.sleep(8000);

				GlobalMethods.alertaccept();
				Thread.sleep(2000);
				WebElement upload_doc = GWait.Wait_GetElementById("proj_document");
				upload_doc.sendKeys(doc_upload);
				WebElement save_button23 = GWait.Wait_GetElementById("savedoc");
				save_button23.click();

			}

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(10000);

		WebElement submit_to_IEC = GWait.Wait_GetElementById("querysubmit");
		submit_to_IEC.click();
		Thread.sleep(6000);
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();

		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();

	}

	// Check for resubmission letter reply submission to IEC with blank form
	public void CRe4_1973() throws Exception {


		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		String Document_Title_in_list = r1.getCell(2, 517).getContents();
		String Version_in_list = r1.getCell(3, 517).getContents();
		String Document_Date_in_list = r1.getCell(4, 517).getContents();
		String doc_upload = r1.getCell(5, 517).getContents();
		String Query_Cmnts_Continuation = r1.getCell(6, 517).getContents();

		CRe4_1236();

		GlobalMethods.PI_Login();

		WebElement PI_project_menu = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu.click();

		WebElement resubmission_edit = GWait.Wait_GetElementByLinkText("Resubmission");
		resubmission_edit.click();

		Thread.sleep(2000);
		System.out.println(docvalue_resub.size() - 1);

		for (int i = 1; i <= docvalue_resub.size() - 1; i++) {
			Thread.sleep(6000);
			
			WebElement docdrop_resub = GWait.Wait_GetElementByXpath("//*[@id='documentuploadprojectresubmission']/div/div[1]/div[1]/div/div[1]/button");
			docdrop_resub.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
			List<WebElement> elementsList3 = docvalue_resub;
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
				WebElement save_button2 = GWait.Wait_GetElementById("savedoc");
				save_button2.click();
				Thread.sleep(8000);

				GlobalMethods.alertaccept();
				Thread.sleep(2000);

				WebElement doc_title = GWait.Wait_GetElementById("document_title");
				doc_title.sendKeys(Document_Title_in_list);

				WebElement save_button24 = GWait.Wait_GetElementById("savedoc");
				save_button24.click();
				Thread.sleep(8000);

				GlobalMethods.alertaccept();
				Thread.sleep(2000);
				WebElement doc_date = GWait.Wait_GetElementById("document_date");
				doc_date.sendKeys(Document_Date_in_list);
				Thread.sleep(2000);
				WebElement doc_version = GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);
				Thread.sleep(2000);

				WebElement save_button22 = GWait.Wait_GetElementById("savedoc");
				save_button22.click();
				Thread.sleep(8000);

				GlobalMethods.alertaccept();
				Thread.sleep(2000);
				WebElement upload_doc = GWait.Wait_GetElementById("proj_document");
				upload_doc.sendKeys(doc_upload);
				WebElement save_button23 = GWait.Wait_GetElementById("savedoc");
				save_button23.click();

			}

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(10000);

		WebElement next_edit_button = GWait.Wait_GetElementById("nextidedit");
		next_edit_button.click();

		WebElement submit_to_IEC = GWait.Wait_GetElementById("submitid");
		submit_to_IEC.click();

		
		Thread.sleep(6000);
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();

		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();

	}

	// Check for Provisional permission letter reply submission to IEC with
	// blank form
	public void CRe4_1979() throws Exception {

		Global_Project_Submissions gp = new Global_Project_Submissions();
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		String Document_Title_in_list = r1.getCell(2, 503).getContents();
		String Version_in_list = r1.getCell(3, 503).getContents();
		String Document_Date_in_list = r1.getCell(4, 503).getContents();
		String doc_upload = r1.getCell(5, 503).getContents();
		String Query_Cmnts_Continuation = r1.getCell(6, 503).getContents();

		CRe4_1231();

		GlobalMethods.PI_Login();

		WebElement query_reply_dashboard = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		query_reply_dashboard.click();

		WebElement query_tab_edit = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		query_tab_edit.click();

		WebElement save_button3 = GWait.Wait_GetElementById("sumsave");
		save_button3.click();

		GlobalMethods.alertaccept();

		WebElement query_comments = GWait.Wait_GetElementById("query_comments");
		query_comments.sendKeys(Query_Cmnts_Continuation);

		Thread.sleep(2000);
		System.out.println(docvalue2.size() - 1);

		for (int i = Global_Project_Submissions.querydoccount; i <= docvalue2.size() - 1; i++) {
			Thread.sleep(6000);
			docdrop2.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
			List<WebElement> elementsList3 = docvalue2;
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
				WebElement save_button2 = GWait.Wait_GetElementById("savedoc");
				save_button2.click();
				Thread.sleep(8000);

				GlobalMethods.alertaccept();
				Thread.sleep(2000);

				WebElement doc_title = GWait.Wait_GetElementById("document_title");
				doc_title.sendKeys(Document_Title_in_list);

				WebElement save_button24 = GWait.Wait_GetElementById("savedoc");
				save_button24.click();
				Thread.sleep(8000);

				GlobalMethods.alertaccept();
				Thread.sleep(2000);
				WebElement doc_date = GWait.Wait_GetElementById("document_date");
				doc_date.sendKeys(Document_Date_in_list);
				Thread.sleep(2000);
				WebElement doc_version = GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);
				Thread.sleep(2000);

				WebElement save_button22 = GWait.Wait_GetElementById("savedoc");
				save_button22.click();
				Thread.sleep(8000);

				GlobalMethods.alertaccept();
				Thread.sleep(2000);
				WebElement upload_doc = GWait.Wait_GetElementById("proj_document");
				upload_doc.sendKeys(doc_upload);
				WebElement save_button23 = GWait.Wait_GetElementById("savedoc");
				save_button23.click();

			}

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(10000);

		WebElement submit_to_IEC = GWait.Wait_GetElementById("querysubmit");
		submit_to_IEC.click();
		Thread.sleep(6000);
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();

		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();

	}

	// Check for Returned reply submission to IEC with blank form
	public void CRe4_1985() throws Exception {

		Dashboard_Links ns = new Dashboard_Links();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		String Document_Title_in_list = r1.getCell(2, 519).getContents();
		String Version_in_list = r1.getCell(3, 519).getContents();
		String Document_Date_in_list = r1.getCell(4, 519).getContents();
		String doc_upload = r1.getCell(5, 519).getContents();
		String Query_Cmnts_Continuation = r1.getCell(6, 519).getContents();

		ns.FBNEWSUBMISSION();

		GlobalMethods.Admin_Login();

		WebElement Dashboard_newsubmission2 = GWait.Wait_GetElementByCSS("span.pull-left");
		Dashboard_newsubmission2.click();

		WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview2.click();

		WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review2.click();
		Thread.sleep(6000);
		WebElement Return_To_PI_button = GWait.Wait_GetElementById("return_modal_btn");
		Return_To_PI_button.click();

		Thread.sleep(2000);
		WebElement Return_To_PI_comments = GWait.Wait_GetElementByXpath("//html/body/div[4]/div/div[2]/div[2]/div[5]/div/form/div/div[6]/div[2]/div/div[2]/div/div[1]/div/div/div[2]");
		Return_To_PI_comments.sendKeys("Test Comments by Admin to PI for resubmitting the project with more files which are missing");

		WebElement Returning_PI_button = GWait.Wait_GetElementById("return_btn");
		Returning_PI_button.click();
GWait.LoadGif();
Thread.sleep(8000);
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();

		GlobalMethods.PI_Login();
		WebElement Submissions_returned_dash = GWait.Wait_GetElementByXpath("//li[5]/a/span");
		Submissions_returned_dash.click();

		WebElement query_tab_edit = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		query_tab_edit.click();

		// saving Submit documents

		Thread.sleep(2000);
		System.out.println(docvalue_edit.size() - 1);

		for (int i = Dashboard_Links.querydoccount; i <= docvalue_edit.size() - 1; i++) {
			Thread.sleep(6000);
			docdrop_edit.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
			List<WebElement> elementsList3 = docvalue_edit;
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
				WebElement save_button2 = GWait.Wait_GetElementById("savedoc");
				save_button2.click();
				Thread.sleep(8000);

				GlobalMethods.alertaccept();
				Thread.sleep(2000);

				WebElement doc_title = GWait.Wait_GetElementById("document_title");
				doc_title.sendKeys(Document_Title_in_list);

				WebElement save_button24 = GWait.Wait_GetElementById("savedoc");
				save_button24.click();
				Thread.sleep(8000);

				GlobalMethods.alertaccept();
				Thread.sleep(2000);
				WebElement doc_date = GWait.Wait_GetElementById("document_date");
				doc_date.sendKeys(Document_Date_in_list);
				Thread.sleep(2000);
				WebElement doc_version = GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);
				Thread.sleep(2000);

				WebElement save_button22 = GWait.Wait_GetElementById("savedoc");
				save_button22.click();
				Thread.sleep(8000);

				GlobalMethods.alertaccept();
				Thread.sleep(2000);
				WebElement upload_doc = GWait.Wait_GetElementById("proj_document");
				upload_doc.sendKeys(doc_upload);
				WebElement save_button23 = GWait.Wait_GetElementById("savedoc");
				save_button23.click();

			}

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(10000);

		WebElement next_button = GWait.Wait_GetElementById("nextidedit");
		next_button.click();

		WebElement submit_to_IEC = GWait.Wait_GetElementById("submitid");
		submit_to_IEC.click();

		Thread.sleep(2000);
		WebElement no = GWait.Wait_GetElementByXpath("//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[2]");
		no.click();

		Thread.sleep(1000);
		WebElement conflictsubmit1 = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		conflictsubmit1.click();

		Thread.sleep(3000);
		GlobalMethods.alertaccept();
		Thread.sleep(6000);
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();

		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();
	}

}
