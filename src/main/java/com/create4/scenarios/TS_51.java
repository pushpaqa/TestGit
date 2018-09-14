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

//Check for initial submission project status for all MS decisions
public class TS_51 {

	public TS_51() {
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

	@FindBy(xpath = "//div[@id='list_documents']/div/div/table/tbody/tr[2]/td")
	WebElement doctype_List;

	@FindBy(xpath = "//div[@id='list_documents']/div/div/table/tbody/tr[2]/td[2]")
	WebElement doctype_title;

	@FindBy(xpath = "//div[@id='list_documents']/div/div/table/tbody/tr[2]/td[3]")
	WebElement doctype_version;

	@FindBy(xpath = "//div[@id='list_documents']/div/div/table/tbody/tr[2]/td[4]")
	WebElement doctype_date;

	@FindBy(className = "studyteam_members")
	WebElement yes;

	@FindBy(xpath = "(//input[@name='studyteam_members'])[2]")
	WebElement no;

	@FindBy(id = "submit_for_iec_review_confirm")
	WebElement conflictsubmit;

	@FindBy(xpath = "(//a[contains(text(),'Logout')])[2]")
	WebElement logoutt;
	@FindBy(css = ".logout")
	WebElement LogOut2;

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

	@FindBy(xpath = "//div[2]/div/div/ul/li[6]/a/span")
	WebElement amend_dashboard;

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
	
	//public int querydocount=0;

	// Check for 'Project status' when initial submission gets MS decision as 'Letter of Permission'
	public void CRe4_1221() throws Exception {
		
		//******************Initial Project Submission********************//

		Global_Project_Submissions g5=new Global_Project_Submissions();
		g5.PI_SubmitProject_IECAdmin();
		g5.After_PI_Submits_IEC_Statusin_PI();
		g5.Dashboard_Click_Admin();
		g5.InitialSubmission_StatusinAdmin_Starting();
		g5.Admin_Forwardto_MS();
		g5.InitialSubmission_StatusinAdmin_Ending();
		g5.InitialSub_After__IEC_forwardto_MS_StatusInPI();
		g5.MS_Dashboard_Click();
		g5.InitialSubmission_StatusinMS_Starting();
		g5.MS_ForwardTo_CP();
		g5.InitialSubmission_StatusinMS_Ending();
		g5.InitialSub_After__MS_forwardto_CP_StatusInPI();
		g5.CP_DashboardClick();
		g5.InitialSubmission_StatusinCP_Starting();
		g5.CP_SubmitProjectTo_MS();
		g5.InitialSubmission_StatusinCP_Ending();
		g5.InitialSub_After__CP_Submitto_MS_StatusInPI();
		g5.StatusIn_MS_After_CPSubmitsToMS();	
		
		//*********************Login with MS and upload the decision as "Letter of Permission"**********************
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");
		
		String Decision_LOP = r1.getCell(11, 41).getContents();
		String Decisionfile = r1.getCell(28, 41).getContents();
		String Decisioncmnt = r1.getCell(29, 41).getContents();
		
		GlobalMethods.MS_Login();
		
		WebElement ExpeditedReview = GWait.Wait_GetElementByXpath("//li[2]/a/span");
		ExpeditedReview.click();

		WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");

		Projectoverview1.click();

		WebElement asignreviewers1 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers1.click();

		Thread.sleep(3000);
		WebElement assign_button = GWait.Wait_GetElementById("assign");
		assign_button.click();
		
		Thread.sleep(2000);
		GlobalMethods.Commentswindhandler();

		// membercomments.click();

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
		
		WebElement PI_project_menu = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu.click();
		
		g5.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Project Initial Submission","Approved");
		
	}

	// Check for 'Project status' when initial submission gets MS decision as 'Disapproval Letter'
	public void CRe4_1226() throws Exception {
		
		//******************Initial Project Submission********************//

		Global_Project_Submissions g5=new Global_Project_Submissions();
		g5.PI_SubmitProject_IECAdmin();
		g5.After_PI_Submits_IEC_Statusin_PI();
		g5.Dashboard_Click_Admin();
		g5.InitialSubmission_StatusinAdmin_Starting();
		g5.Admin_Forwardto_MS();
		g5.InitialSubmission_StatusinAdmin_Ending();
		g5.InitialSub_After__IEC_forwardto_MS_StatusInPI();
		g5.MS_Dashboard_Click();
		g5.InitialSubmission_StatusinMS_Starting();
		g5.MS_ForwardTo_CP();
		g5.InitialSubmission_StatusinMS_Ending();
		g5.InitialSub_After__MS_forwardto_CP_StatusInPI();
		g5.CP_DashboardClick();
		g5.InitialSubmission_StatusinCP_Starting();
		g5.CP_SubmitProjectTo_MS();
		g5.InitialSubmission_StatusinCP_Ending();
		g5.InitialSub_After__CP_Submitto_MS_StatusInPI();
		g5.StatusIn_MS_After_CPSubmitsToMS();	

		//*********************Login with MS and upload the decision as "Letter of Permission"**********************

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		String Decision_LOP = r1.getCell(11, 43).getContents();
		String Decisionfile = r1.getCell(28, 43).getContents();
		String Decisioncmnt = r1.getCell(29, 43).getContents();

		GlobalMethods.MS_Login();

		WebElement ExpeditedReview = GWait.Wait_GetElementByXpath("//li[2]/a/span");
		ExpeditedReview.click();

		WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");

		Projectoverview1.click();

		WebElement asignreviewers1 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers1.click();

		Thread.sleep(3000);
		WebElement assign_button = GWait.Wait_GetElementById("assign");
		assign_button.click();

		Thread.sleep(2000);
		GlobalMethods.Commentswindhandler();

		// membercomments.click();

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

		WebElement PI_project_menu = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu.click();
		
		WebElement ArchivedProjects = GWait.Wait_GetElementByLinkText("Archived Projects");
		ArchivedProjects.click();

		g5.Global_PILoginstatus_Verify_Archived("Pushpa Project_1213_to_1220","Disapproved","Project Initial Submission","Disapproved");

	}


	// Check for 'Project status' when initial submission gets MS decision as 'Provisional Letter of Permission'
	
	public void CRe4_1231() throws Exception {


		
		//******************Initial Project Submission********************//

		Global_Project_Submissions g5=new Global_Project_Submissions();
		
		g5.PI_SubmitProject_IECAdmin();
		System.out.println("Test count "+g5.querydoccount);
		
		g5.After_PI_Submits_IEC_Statusin_PI();
		g5.Dashboard_Click_Admin();
		g5.InitialSubmission_StatusinAdmin_Starting();
		g5.Admin_Forwardto_MS();
		g5.InitialSubmission_StatusinAdmin_Ending();
		g5.InitialSub_After__IEC_forwardto_MS_StatusInPI();
		g5.MS_Dashboard_Click();
		g5.InitialSubmission_StatusinMS_Starting();
		g5.MS_ForwardTo_CP();
		g5.InitialSubmission_StatusinMS_Ending();
		g5.InitialSub_After__MS_forwardto_CP_StatusInPI();
		g5.CP_DashboardClick();
		g5.InitialSubmission_StatusinCP_Starting();
		g5.CP_SubmitProjectTo_MS();
		g5.InitialSubmission_StatusinCP_Ending();
		g5.InitialSub_After__CP_Submitto_MS_StatusInPI();
		g5.StatusIn_MS_After_CPSubmitsToMS();	

		//*********************Login with MS and upload the decision as "Provisional Letter of Permission"**********************

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		String Decision_LOP = r1.getCell(11, 45).getContents();
		String Decisionfile = r1.getCell(28, 45).getContents();
		String Decisioncmnt = r1.getCell(29, 45).getContents();

		GlobalMethods.MS_Login();

		WebElement ExpeditedReview = GWait.Wait_GetElementByXpath("//li[2]/a/span");
		ExpeditedReview.click();

		WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");

		Projectoverview1.click();

		WebElement asignreviewers1 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers1.click();

		Thread.sleep(3000);
		WebElement assign_button = GWait.Wait_GetElementById("assign");
		assign_button.click();

		Thread.sleep(2000);
		GlobalMethods.Commentswindhandler();

		// membercomments.click();

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
Thread.sleep(6000);
		WebElement logoutt1 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt1.click();

		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();

		GlobalMethods.PI_Login();

		WebElement ProjectwithQueries = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		ProjectwithQueries.click();
	
		g5.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Project Initial Submission","Provisional Permission");
	}
	
	
	// Check for 'Project status' when initial submission gets MS decision as 'Resubmission Letter'
	public void CRe4_1236() throws Exception {


		//******************Initial Project Submission********************//

		Global_Project_Submissions g5=new Global_Project_Submissions();
		g5.PI_SubmitProject_IECAdmin();
		g5.After_PI_Submits_IEC_Statusin_PI();
		g5.Dashboard_Click_Admin();
		g5.InitialSubmission_StatusinAdmin_Starting();
		g5.Admin_Forwardto_MS();
		g5.InitialSubmission_StatusinAdmin_Ending();
		g5.InitialSub_After__IEC_forwardto_MS_StatusInPI();
		g5.MS_Dashboard_Click();
		g5.InitialSubmission_StatusinMS_Starting();
		g5.MS_ForwardTo_CP();
		g5.InitialSubmission_StatusinMS_Ending();
		g5.InitialSub_After__MS_forwardto_CP_StatusInPI();
		g5.CP_DashboardClick();
		g5.InitialSubmission_StatusinCP_Starting();
		g5.CP_SubmitProjectTo_MS();
		g5.InitialSubmission_StatusinCP_Ending();
		g5.InitialSub_After__CP_Submitto_MS_StatusInPI();
		g5.StatusIn_MS_After_CPSubmitsToMS();	

		//*********************Login with MS and upload the decision as "Resubmission Letter"**********************

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		String Decision_LOP = r1.getCell(11, 47).getContents();
		String Decisionfile = r1.getCell(28, 47).getContents();
		String Decisioncmnt = r1.getCell(29, 47).getContents();

		GlobalMethods.MS_Login();

		WebElement ExpeditedReview = GWait.Wait_GetElementByXpath("//li[2]/a/span");
		ExpeditedReview.click();

		WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");

		Projectoverview1.click();

		WebElement asignreviewers1 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers1.click();

		Thread.sleep(3000);
		WebElement assign_button = GWait.Wait_GetElementById("assign");
		assign_button.click();

		Thread.sleep(2000);
		GlobalMethods.Commentswindhandler();

		// membercomments.click();

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
GWait.LoadGif();
Thread.sleep(6000);
		WebElement logoutt1 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt1.click();
		Thread.sleep(6000);

		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();

		GlobalMethods.PI_Login();

		WebElement PI_project_menu = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu.click();
	
		g5.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Under IEC Review","Project Initial Submission","Resubmission Required");
	}

	// Check for 'Project status' when initial submission gets MS decision as 'Query Letter � MS'
	public void CRe4_1241() throws Exception {

		//******************Initial Project Submission********************//

		Global_Project_Submissions g5=new Global_Project_Submissions();
		g5.PI_SubmitProject_IECAdmin();
		g5.After_PI_Submits_IEC_Statusin_PI();
		g5.Dashboard_Click_Admin();
		g5.InitialSubmission_StatusinAdmin_Starting();
		g5.Admin_Forwardto_MS();
		g5.InitialSubmission_StatusinAdmin_Ending();
		g5.InitialSub_After__IEC_forwardto_MS_StatusInPI();
		GlobalMethods.MS_Login();

		WebElement ExpeditedReview = GWait.Wait_GetElementByXpath("//li[2]/a/span");
		ExpeditedReview.click();
		
		//g5.MS_Dashboard_Click();
		g5.InitialSubmission_StatusinMS_Starting();
		g5.MS_ForwardTo_CP();
		g5.InitialSubmission_StatusinMS_Ending();
		g5.InitialSub_After__MS_forwardto_CP_StatusInPI();
		
		GlobalMethods.CPLogin();

		WebElement ExpeditedReview1 = GWait.Wait_GetElementByXpath("//li[2]/a/span");
		ExpeditedReview1.click();
		//g5.CP_DashboardClick();
		g5.InitialSubmission_StatusinCP_Starting();
		g5.CP_SubmitProjectTo_MS();
		g5.InitialSubmission_StatusinCP_Ending();
		g5.InitialSub_After__CP_Submitto_MS_StatusInPI();
		g5.StatusIn_MS_After_CPSubmitsToMS();	

		//*********************Login with MS and upload the decision as "Query Letter � MS"**********************

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		String Decision_LOP = r1.getCell(11, 49).getContents();
		String Decisionfile = r1.getCell(28, 49).getContents();
		String Decisioncmnt = r1.getCell(29, 49).getContents();

		GlobalMethods.MS_Login();

		WebElement ExpeditedReview2 = GWait.Wait_GetElementByXpath("//li[2]/a/span");
		ExpeditedReview2.click();

		WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");

		Projectoverview1.click();

		WebElement asignreviewers1 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers1.click();

		Thread.sleep(3000);
		WebElement assign_button = GWait.Wait_GetElementById("assign");
		assign_button.click();

		Thread.sleep(2000);
		GlobalMethods.Commentswindhandler();

		// membercomments.click();

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
Thread.sleep(6000);
		WebElement logoutt1 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt1.click();

		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();

		GlobalMethods.PI_Login();

		WebElement ProjectwithQueries = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		ProjectwithQueries.click();

		g5.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Under IEC Review","Project Initial Submission","Query - Member Secretary");
	}

	// Check for 'Project status' when initial submission gets MS decision as 'Query Letter � Full board'
	public void CRe4_1246() throws Exception {

		//******************Initial Project Submission********************//

				Global_Project_Submissions g5=new Global_Project_Submissions();
				g5.PI_SubmitProject_IECAdmin();
				g5.After_PI_Submits_IEC_Statusin_PI();
				g5.Dashboard_Click_Admin();
				g5.InitialSubmission_StatusinAdmin_Starting();
				g5.Admin_Forwardto_MS();
				g5.InitialSubmission_StatusinAdmin_Ending();
				g5.InitialSub_After__IEC_forwardto_MS_StatusInPI();
				g5.MS_Dashboard_Click();
				g5.InitialSubmission_StatusinMS_Starting();
				g5.MS_ForwardTo_CP();
				g5.InitialSubmission_StatusinMS_Ending();
				g5.InitialSub_After__MS_forwardto_CP_StatusInPI();
				g5.CP_DashboardClick();
				g5.InitialSubmission_StatusinCP_Starting();
				g5.CP_SubmitProjectTo_MS();
				g5.InitialSubmission_StatusinCP_Ending();
				g5.InitialSub_After__CP_Submitto_MS_StatusInPI();
				g5.StatusIn_MS_After_CPSubmitsToMS();	

				//*********************Login with MS and upload the decision as "Query Letter � Full board"**********************

				FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
				Workbook wb = Workbook.getWorkbook(fi);
				Sheet r1 = wb.getSheet("Project Submissions");

				String Decision_LOP = r1.getCell(11, 51).getContents();
				String Decisionfile = r1.getCell(28, 51).getContents();
				String Decisioncmnt = r1.getCell(29, 51).getContents();

				GlobalMethods.MS_Login();

				WebElement ExpeditedReview = GWait.Wait_GetElementByXpath("//li[2]/a/span");
				ExpeditedReview.click();

				WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");

				Projectoverview1.click();

				WebElement asignreviewers1 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
				asignreviewers1.click();

				Thread.sleep(3000);
				WebElement assign_button = GWait.Wait_GetElementById("assign");
				assign_button.click();

				Thread.sleep(2000);
				GlobalMethods.Commentswindhandler();

				// membercomments.click();

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

				WebElement ProjectwithQueries = GWait.Wait_GetElementByXpath("//li[3]/a/span");
				ProjectwithQueries.click();

				g5.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Under IEC Review","Project Initial Submission","Query - Full Board");
	}

	// Check for 'Project status' when initial submission gets MS decision as 'Query Letter � Reviewers'
	
	public void CRe4_1251() throws Exception {


		//******************Initial Project Submission********************//

				Global_Project_Submissions g5=new Global_Project_Submissions();
				g5.PI_SubmitProject_IECAdmin();
				g5.After_PI_Submits_IEC_Statusin_PI();
				g5.Dashboard_Click_Admin();
				g5.InitialSubmission_StatusinAdmin_Starting();
				g5.Admin_Forwardto_MS();
				g5.InitialSubmission_StatusinAdmin_Ending();
				g5.InitialSub_After__IEC_forwardto_MS_StatusInPI();
				g5.MS_Dashboard_Click();
				g5.InitialSubmission_StatusinMS_Starting();
				g5.MS_ForwardTo_CP();
				g5.InitialSubmission_StatusinMS_Ending();
				g5.InitialSub_After__MS_forwardto_CP_StatusInPI();
				g5.CP_DashboardClick();
				g5.InitialSubmission_StatusinCP_Starting();
				g5.CP_SubmitProjectTo_MS();
				g5.InitialSubmission_StatusinCP_Ending();
				g5.InitialSub_After__CP_Submitto_MS_StatusInPI();
				g5.StatusIn_MS_After_CPSubmitsToMS();	

				//*********************Login with MS and upload the decision as "Query Letter � Reviewers"**********************

				FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
				Workbook wb = Workbook.getWorkbook(fi);
				Sheet r1 = wb.getSheet("Project Submissions");

				String Decision_LOP = r1.getCell(11, 53).getContents();
				String Decisionfile = r1.getCell(28, 53).getContents();
				String Decisioncmnt = r1.getCell(29, 53).getContents();

				GlobalMethods.MS_Login();

				WebElement ExpeditedReview = GWait.Wait_GetElementByXpath("//li[2]/a/span");
				ExpeditedReview.click();

				WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");

				Projectoverview1.click();

				WebElement asignreviewers1 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
				asignreviewers1.click();

				Thread.sleep(3000);
				WebElement assign_button = GWait.Wait_GetElementById("assign");
				assign_button.click();

				Thread.sleep(2000);
				GlobalMethods.Commentswindhandler();

				// membercomments.click();

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

				WebElement ProjectwithQueries = GWait.Wait_GetElementByXpath("//li[3]/a/span");
				ProjectwithQueries.click();

				g5.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Under IEC Review","Project Initial Submission","Query - Primary Reviewer");
	}

}
