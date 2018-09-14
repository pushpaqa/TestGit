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

//Check for sae follow up 'Document status' until MS decision in PI
public class TS_88 {

	public TS_88() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}
    GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	// PI submit new project page elements

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

	@FindBy(xpath = "//li[8]/a/span")
	WebElement sae_dash;

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

	// sussequent doctype upload

	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/button")
	public WebElement docdrop1;
	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/div/ul/li")
	public static List<WebElement> docvalue1;

	// query respond

	@FindBy(xpath = "//*[@id='respondqueryupload']/div/div[1]/div[1]/div/div/button")
	public WebElement docdrop2;
	@FindBy(xpath = "//*[@id='respondqueryupload']/div/div[1]/div[1]/div/div/div/ul/li")
	public static List<WebElement> docvalue2;

	// sae initial uploads

	@FindBy(xpath = "//*[@id='saedetails']/div[1]/div[2]/div[1]/div/div/button")
	public WebElement sae_site_drop;
	@FindBy(xpath = "//*[@id='saedetails']/div[1]/div[2]/div[1]/div/div/div/ul/li")
	public static List<WebElement> sae_site_value;

	@FindBy(xpath = "//*[@id='report_types_sel']/div/div/button")
	public WebElement sae_report_doc;
	@FindBy(xpath = "//*[@id='report_types_sel']/div/div/div/ul/li")
	public static List<WebElement> sae_report_value;

	@FindBy(xpath = "//*[@id='document_type_sae']/div/button")
	public WebElement sae_docdrop;
	@FindBy(xpath = "//*[@id='document_type_sae']/div/div/ul/li")
	public static List<WebElement> sae_docvalue;

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

	// SAE Elements

	@FindBy(id = "patient_initial")
	WebElement Sae_patient_initial;

	@FindBy(id = "sae_number")
	WebElement Sae_sae_number;

	@FindBy(id = "followup_number")
	WebElement sae_followup_number;

	@FindBy(id = "followup_date")
	WebElement sae_followup_date;

	@FindBy(linkText = "Projects for IEC Review")
	WebElement Projects_for_IEC_Review_link;

	@FindBy(id = "forward_chairman")
	WebElement forward_chairman_button;

	@FindBy(css = "div.nocontent > p")
	WebElement forward_chairman_msg;

	@FindBy(id = "assign1")
	WebElement submit_to_ms_button;

	@FindBy(css = "div.flash.alert-info > p")
	WebElement chair_to_ms_msg;

	
	public void CRe4_1741_44_46_48() throws Exception {

		
		//******************Initial Project Submission********************//

		Global_Project_Submissions g8=new Global_Project_Submissions();
		g8.PI_SubmitProject_IECAdmin();
		g8.After_PI_Submits_IEC_Statusin_PI();
		g8.Dashboard_Click_Admin();
		g8.InitialSubmission_StatusinAdmin_Starting();
		g8.Admin_Forwardto_MS();
		g8.InitialSubmission_StatusinAdmin_Ending();
		g8.InitialSub_After__IEC_forwardto_MS_StatusInPI();
		g8.MS_Dashboard_Click();
		g8.InitialSubmission_StatusinMS_Starting();
		g8.MS_ForwardTo_CP();
		g8.InitialSubmission_StatusinMS_Ending();
		g8.InitialSub_After__MS_forwardto_CP_StatusInPI();
		g8.CP_DashboardClick();
		g8.InitialSubmission_StatusinCP_Starting();
		g8.CP_SubmitProjectTo_MS();
		g8.InitialSubmission_StatusinCP_Ending();
		g8.InitialSub_After__CP_Submitto_MS_StatusInPI();
		g8.StatusIn_MS_After_CPSubmitsToMS();
		
		// *************SAE Follow Up Script***********************
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");
		
		// Document upload data
		String Document_Title_in_list = r1.getCell(7, 235).getContents();
		String Version_in_list = r1.getCell(8, 235).getContents();
		String Document_Date_in_list = r1.getCell(9, 235).getContents();
		String doc_upload = r1.getCell(10, 235).getContents();

		// Decision upload data
		String Decision_LOP = r1.getCell(26, 235).getContents();
		String Decisionfile = r1.getCell(27, 235).getContents();
		String Decisioncmnt = r1.getCell(28, 235).getContents();
		
		// SAE submission data

		String sae_site_type_1 = r1.getCell(31, 235).getContents();
		String sae_report_type_1 = r1.getCell(32, 235).getContents();
		String sae_number_1 = r1.getCell(33, 235).getContents();
		String sae_patient_initial_1 = r1.getCell(34, 235).getContents();
		String sae_report_type_2 = r1.getCell(35, 235).getContents();
		String sae_doc_date_1 = r1.getCell(36, 235).getContents();
		
		GlobalMethods.MS_Login();

		WebElement ExpeditedReview = GWait.Wait_GetElementByXpath("//li[2]/a/span");
		ExpeditedReview.click();

		WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");

		Projectoverview1.click();

		WebElement asignreviewers1 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");

		asignreviewers1.click();

		Thread.sleep(4000);
		WebElement assign_button = GWait.Wait_GetElementById("assign");
		assign_button.click();
		Thread.sleep(2000);
		GlobalMethods.Commentswindhandler();
		
		WebElement iecdecisiontab1 = GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab1.click();
		
		WebElement decisondropdown1 = GWait.Wait_GetElementById("decision_type");

		Select select7 = new Select(decisondropdown1);
		select7.selectByVisibleText(Decision_LOP);

		WebElement decisionupload1 = GWait.Wait_GetElementById("proj_document");
		decisionupload1.sendKeys(Decisionfile);

		WebElement assign_comments1 = GWait.Wait_GetElementById("comments");
		assign_comments1.sendKeys(Decisioncmnt);

		WebElement decisionusubmit1 = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit1.click();

		WebElement logoutt1 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt1.click();

		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();
		

		GlobalMethods.PI_Login();

		WebElement Ongoingprojects1 = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		Ongoingprojects1.click();

		WebElement approvedprojoverview1 = GWait.Wait_GetElementByXpath("//td[9]/a/span");
		approvedprojoverview1.click();

		WebElement newdocuments = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments.click();

		WebElement SAELink = GWait.Wait_GetElementByLinkText("SAE");
		SAELink.click();

		// sae_initial

		WebElement sae_site_drop = GWait.Wait_GetElementByXpath("//*[@id='saedetails']/div[1]/div[2]/div[1]/div/div/button");
		sae_site_drop.click();

		List<WebElement> elementsList = sae_site_value;
		for (WebElement a11 : elementsList) {
			WebElement span = a11.findElement(By.tagName("span"));
			System.out.println(sae_site_type_1);
			if (span.getText().equalsIgnoreCase(sae_site_type_1)) {
				Thread.sleep(2000);
				span.click();
				break;
			}
		}

		WebElement sae_report_doc = GWait.Wait_GetElementByXpath("//*[@id='report_types_sel']/div/div/button");
		sae_report_doc.click();

		List<WebElement> elementsList1 = sae_report_value;
		for (WebElement a11 : elementsList1) {
			WebElement span = a11.findElement(By.tagName("span"));
			System.out.println(sae_report_type_1);
			if (span.getText().equalsIgnoreCase(sae_report_type_1)) {
				Thread.sleep(2000);
				span.click();
				break;
			}
		}

		WebElement Sae_patient_initial = GWait.Wait_GetElementById("patient_initial");
		Sae_patient_initial.sendKeys(sae_patient_initial_1);
		WebElement Sae_sae_number = GWait.Wait_GetElementById("sae_number");
		Sae_sae_number.sendKeys(sae_number_1);
		
		WebElement save_button3 = GWait.Wait_GetElementById("sumsave");
		save_button3.click();
		
		System.out.println(sae_docvalue.size() - 1);

		for (int i = 1; i <= sae_docvalue.size() - 1; i++) {
			Thread.sleep(2000);
			sae_docdrop.click();
			String numberAsString = Integer.toString(i);
			List<WebElement> elementsList3 = sae_docvalue;
			int j = 0;
			for (WebElement a11 : elementsList3) {
				WebElement span = a11.findElement(By.tagName("span"));
				System.out.println(numberAsString);
				System.out.println(span.getAttribute("data-original-index"));
				if (i == j) {
					Thread.sleep(2000);
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
				WebElement doc_version = GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);
				WebElement doc_date = GWait.Wait_GetElementById("document_date");
				doc_date.sendKeys(Document_Date_in_list);
				WebElement upload_doc = GWait.Wait_GetElementById("proj_document");
				upload_doc.sendKeys(doc_upload);
				WebElement save_button2 = GWait.Wait_GetElementById("savedoc");
				save_button2.click();

			}

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		
		WebElement submit_to_IEC = GWait.Wait_GetElementById("submitid");
		submit_to_IEC.click();

		Thread.sleep(2000);

		WebElement no1 = GWait.Wait_GetElementByXpath("(//input[@name='studyteam_members'])[2]");
		no1.click();
		WebElement conflictsubmit = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		conflictsubmit.click();
		
		GlobalMethods.alertaccept();
		
		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();
		
		WebElement newdocuments1 = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments1.click();
		
		// contination submission for query letter

		WebElement seriousadverse1 = GWait.Wait_GetElementByLinkText("SAE");
		seriousadverse1.click();

		WebElement sae_site_drop1 = GWait.Wait_GetElementByXpath("//*[@id='saedetails']/div[1]/div[2]/div[1]/div/div/button");
		sae_site_drop1.click();

		List<WebElement> elementsList_1 = sae_site_value;
		for (WebElement a11 : elementsList_1) {
			WebElement span = a11.findElement(By.tagName("span"));
			System.out.println(sae_site_type_1);
			if (span.getText().equalsIgnoreCase(sae_site_type_1)) {
				Thread.sleep(2000);
				span.click();
				break;
			}
		}
		WebElement sae_report_doc1 = GWait.Wait_GetElementByXpath("//*[@id='report_types_sel']/div/div/button");
		sae_report_doc1.click();

		List<WebElement> elementsList_2 = sae_report_value;
		for (WebElement a11 : elementsList_2) {
			WebElement span = a11.findElement(By.tagName("span"));
			System.out.println(sae_report_type_2);
			if (span.getText().equalsIgnoreCase(sae_report_type_2)) {
				Thread.sleep(2000);
				span.click();
				break;
			}
		}

		WebElement sae_followup_number = GWait.Wait_GetElementById("followup_number");
		sae_followup_number.sendKeys(sae_number_1);
		
		WebElement sae_followup_date = GWait.Wait_GetElementById("followup_date");
		sae_followup_date.sendKeys(sae_doc_date_1);
		
		WebElement save_button4 = GWait.Wait_GetElementById("sumsave");
		save_button4.click();

		System.out.println(sae_docvalue.size() - 1);

		for (int i = 1; i <= sae_docvalue.size() - 1; i++) {
			Thread.sleep(2000);
			sae_docdrop.click();
			String numberAsString = Integer.toString(i);
			List<WebElement> elementsList3 = sae_docvalue;
			int j = 0;
			for (WebElement a11 : elementsList3) {
				WebElement span = a11.findElement(By.tagName("span"));
				System.out.println(numberAsString);
				System.out.println(span.getAttribute("data-original-index"));
				if (i == j) {
					Thread.sleep(2000);
					String doc = span.getText();
					span.click();
					System.out.println(doc);

					break;
				}
				j++;
			}
			if (i == j) {
				WebElement doc_title1 = GWait.Wait_GetElementById("document_title");
				doc_title1.sendKeys(Document_Title_in_list);
				WebElement doc_version1 = GWait.Wait_GetElementById("version");
				doc_version1.sendKeys(Version_in_list);
				WebElement doc_date1 = GWait.Wait_GetElementById("document_date");
				doc_date1.sendKeys(Document_Date_in_list);
				WebElement upload_doc1 = GWait.Wait_GetElementById("proj_document");
				upload_doc1.sendKeys(doc_upload);
				WebElement save_button21 = GWait.Wait_GetElementById("savedoc");
				save_button21.click();

			}

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
	
		// conflict of interest
		WebElement submit_to_IEC1 = GWait.Wait_GetElementById("submitid");
		submit_to_IEC1.click();

		Thread.sleep(2000);

		WebElement no11 = GWait.Wait_GetElementByXpath("(//input[@name='studyteam_members'])[2]");
		no11.click();
		WebElement conflictsubmit1 = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		conflictsubmit1.click();
		GlobalMethods.alertaccept();
		
		//**************************Normal Flow after Completion document*****************************

		g8.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","SAE","Submitted to IEC");
		GlobalMethods.Admin_Login();
		g8.Global_Dashboard_SAE();
		g8.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","SAE","Submitted to IEC");
		g8.SubsequentSubmissions_IECAdmin_forwardto_MS();
		g8.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","SAE","MS Review");

		WebElement logouttA = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttA.click();
		WebElement logoA = GWait.Wait_GetElementByCSS("img");
		logoA.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu.click();
		g8.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","SAE","Under IEC Review");
		GlobalMethods.MS_Login();
		g8.Global_Dashboard_SAE();
		g8.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","SAE","MS Review");
		g8.MS_ForwardTo_CP();
		g8.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","SAE","Forwarded to Chairperson");

		WebElement logouttB = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttB.click();
		WebElement logoB = GWait.Wait_GetElementByCSS("img");
		logoB.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu1 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu1.click();
		g8.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","SAE","Under IEC Review");
		GlobalMethods.CPLogin();
		g8.Global_Dashboard_SAE();
		g8.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","SAE","Forwarded to Chairperson");
		g8.CP_SubmitProjectTo_MS();
		WebElement ProjectsLink = GWait.Wait_GetElementByLinkText("Projects");
		ProjectsLink.click();
		g8.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","SAE","Chairperson Review");

		WebElement logouttC = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttC.click();
		WebElement logoC = GWait.Wait_GetElementByCSS("img");
		logoC.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu3 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu3.click();
		g8.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","SAE","Under IEC Review");
		GlobalMethods.MS_Login();
		g8.Global_Dashboard_SAE();
		g8.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","SAE","Chairperson Review");
	}

}
