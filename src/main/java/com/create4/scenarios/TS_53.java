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

//Check for deviation submission project status for all MS decisions
public class TS_53 {

	public TS_53() {
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

	@FindBy(xpath = "//div[2]/div/div/ul/li[7]/a/span")
	WebElement deviation_dashboard;

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

	public int querydocount=0;
	// Check for 'Project status' when Deviation submission gets MS decision as 'Query/Action Letter - Full Board'
	
	public void CRe4_1389() throws Exception { 
		
		Global_Project_Submissions gp=new Global_Project_Submissions();
		gp.PI_SubmitProject_IECAdmin();
		
		WebElement logoutt111 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt111.click();
		WebElement logo11 = GWait.Wait_GetElementByCSS("img");
		logo11.click();
		
		gp.Dashboard_Click_Admin();
		gp.Admin_Forwardto_MS();
		
		WebElement logoutt11 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt11.click();
		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();
	
		gp.MS_Dashboard_Click();
		gp.MS_ForwardTo_CP();
		
		WebElement logoutt3 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt3.click();

		WebElement logo3 = GWait.Wait_GetElementByCSS("img");
		logo3.click();
		
		gp.CP_DashboardClick();
		gp.CP_SubmitProjectTo_MS();

		WebElement logoutt5 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt5.click();

		WebElement logo5 = GWait.Wait_GetElementByCSS("img");
		logo5.click();

	// *************Deviation Script***********************
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");
		
		// Decision upload data
		String Decision_LOP = r1.getCell(11, 65).getContents();
		String Decisionfile = r1.getCell(28, 65).getContents();
		String Decisioncmnt = r1.getCell(29, 65).getContents();
		
		// Submit new documents data
		String Document_Title_in_list = r1.getCell(7, 65).getContents();
		String Version_in_list = r1.getCell(8, 65).getContents();
		String Document_Date_in_list = r1.getCell(9, 65).getContents();
		String doc_upload = r1.getCell(10, 65).getContents();

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
		Thread.sleep(6000);
		WebElement decisionusubmit1 = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit1.click();

		WebElement logoutt1 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt1.click();
		
		WebElement logo121 = GWait.Wait_GetElementByCSS("img");
		logo121.click();

		GlobalMethods.PI_Login();
		
		WebElement Ongoingprojects1 = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		Ongoingprojects1.click();

		WebElement approvedprojoverview1 = GWait.Wait_GetElementByXpath("//td[9]/a/span");
		approvedprojoverview1.click();

		WebElement newdocuments = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments.click();
		
		// contination submission for query letter
		
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
				doc_version.sendKeys(Version_in_list);
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
		WebElement next_button2 = GWait.Wait_GetElementById("nextid");
		next_button2.click();

		WebElement submit_to_IEC = GWait.Wait_GetElementById("submitid");
		submit_to_IEC.click();
		
		Thread.sleep(2000);
		
		WebElement no1 = GWait.Wait_GetElementByXpath("(//input[@name='studyteam_members'])[2]");
		no1.click();
		WebElement conflictsubmit = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		conflictsubmit.click();
		GlobalMethods.alertaccept();

		//**************************Normal Flow after Deviation document*****************************

		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Submitted to IEC");
		GlobalMethods.Admin_Login();
		gp.Global_Dashboard_DeviationLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Submitted to IEC");
		gp.SubsequentSubmissions_IECAdmin_forwardto_MS();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","MS Review");

		WebElement logouttA = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttA.click();
		WebElement logoA = GWait.Wait_GetElementByCSS("img");
		logoA.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu.click();
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Under IEC Review");
		GlobalMethods.MS_Login();
		gp.Global_Dashboard_DeviationLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","MS Review");
		gp.MS_ForwardTo_CP();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Forwarded to Chairperson");

		WebElement logouttB = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttB.click();
		WebElement logoB = GWait.Wait_GetElementByCSS("img");
		logoB.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu1 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu1.click();
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Under IEC Review");
		GlobalMethods.CPLogin();
		gp.Global_Dashboard_DeviationLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Forwarded to Chairperson");
		gp.CP_SubmitProjectTo_MS();
		WebElement ProjectsLink = GWait.Wait_GetElementByLinkText("Projects");
		ProjectsLink.click();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Chairperson Review");

		WebElement logouttC = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttC.click();
		WebElement logoC = GWait.Wait_GetElementByCSS("img");
		logoC.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu3 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu3.click();
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Under IEC Review");
		GlobalMethods.MS_Login();
		gp.Global_Dashboard_DeviationLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Chairperson Review");		
		
		

		WebElement logouttD = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttD.click();
		WebElement logoD = GWait.Wait_GetElementByCSS("img");
		logoD.click();


		//*********************Login with MS and upload the decision as "Query/Action Letter - Full Board"**********************

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r11 = wb1.getSheet("Project Submissions");

		String Decision_LOP1 = r11.getCell(30,65).getContents();
		String Decisionfile1 = r11.getCell(31,65).getContents();
		String Decisioncmnt1 = r11.getCell(32,65).getContents();

		GlobalMethods.MS_Login();

		gp.Global_Dashboard_DeviationLink();

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
		select72.selectByVisibleText(Decision_LOP1);

		WebElement decisionupload2 = GWait.Wait_GetElementById("proj_document");
		decisionupload2.sendKeys(Decisionfile1);

		WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
		assign_comments2.sendKeys(Decisioncmnt1);

		WebElement decisionusubmit2 = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit2.click();

		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt2.click();

		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();

		GlobalMethods.PI_Login();

		WebElement PI_project_menu2 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu2.click();
	
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Query - Full Board");
		
	}
	
	

	// Check for 'Project status' when Deviation submission gets MS decision as 'Query/Action Letter - Reviewers'
	public void CRe4_1394() throws Exception {
	
		Global_Project_Submissions gp=new Global_Project_Submissions();
		gp.PI_SubmitProject_IECAdmin();
		
		WebElement logoutt111 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt111.click();
		WebElement logo11 = GWait.Wait_GetElementByCSS("img");
		logo11.click();
		
		gp.Dashboard_Click_Admin();
		gp.Admin_Forwardto_MS();
		
		WebElement logoutt11 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt11.click();
		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();
	
		gp.MS_Dashboard_Click();
		gp.MS_ForwardTo_CP();
		
		WebElement logoutt3 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt3.click();

		WebElement logo3 = GWait.Wait_GetElementByCSS("img");
		logo3.click();
		
		gp.CP_DashboardClick();
		gp.CP_SubmitProjectTo_MS();

		WebElement logoutt5 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt5.click();

		WebElement logo5 = GWait.Wait_GetElementByCSS("img");
		logo5.click();

	// *************Deviation Script***********************
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");
		
		// Decision upload data
		String Decision_LOP = r1.getCell(11, 67).getContents();
		String Decisionfile = r1.getCell(28, 67).getContents();
		String Decisioncmnt = r1.getCell(29, 67).getContents();
		
		// Submit new documents data
		String Document_Title_in_list = r1.getCell(7, 67).getContents();
		String Version_in_list = r1.getCell(8, 67).getContents();
		String Document_Date_in_list = r1.getCell(9, 67).getContents();
		String doc_upload = r1.getCell(10, 67).getContents();

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
		
		WebElement logo121 = GWait.Wait_GetElementByCSS("img");
		logo121.click();

		GlobalMethods.PI_Login();
		
		WebElement Ongoingprojects1 = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		Ongoingprojects1.click();

		WebElement approvedprojoverview1 = GWait.Wait_GetElementByXpath("//td[9]/a/span");
		approvedprojoverview1.click();

		WebElement newdocuments = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments.click();
		
		// contination submission for query letter
		
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
				doc_version.sendKeys(Version_in_list);
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
		WebElement next_button2 = GWait.Wait_GetElementById("nextid");
		next_button2.click();

		WebElement submit_to_IEC = GWait.Wait_GetElementById("submitid");
		submit_to_IEC.click();
		
		Thread.sleep(2000);
		
		WebElement no1 = GWait.Wait_GetElementByXpath("(//input[@name='studyteam_members'])[2]");
		no1.click();
		WebElement conflictsubmit = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		conflictsubmit.click();
		GlobalMethods.alertaccept();

		//**************************Normal Flow after Deviation document*****************************

		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Submitted to IEC");
		GlobalMethods.Admin_Login();
		gp.Global_Dashboard_DeviationLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Submitted to IEC");
		gp.SubsequentSubmissions_IECAdmin_forwardto_MS();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","MS Review");

		WebElement logouttA = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttA.click();
		WebElement logoA = GWait.Wait_GetElementByCSS("img");
		logoA.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu.click();
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Under IEC Review");
		GlobalMethods.MS_Login();
		gp.Global_Dashboard_DeviationLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","MS Review");
		gp.MS_ForwardTo_CP();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Forwarded to Chairperson");

		WebElement logouttB = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttB.click();
		WebElement logoB = GWait.Wait_GetElementByCSS("img");
		logoB.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu1 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu1.click();
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Under IEC Review");
		GlobalMethods.CPLogin();
		gp.Global_Dashboard_DeviationLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Forwarded to Chairperson");
		gp.CP_SubmitProjectTo_MS();
		WebElement ProjectsLink = GWait.Wait_GetElementByLinkText("Projects");
		ProjectsLink.click();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Chairperson Review");

		WebElement logouttC = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttC.click();
		WebElement logoC = GWait.Wait_GetElementByCSS("img");
		logoC.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu3 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu3.click();
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Under IEC Review");
		GlobalMethods.MS_Login();
		gp.Global_Dashboard_DeviationLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Chairperson Review");		
		
		

		WebElement logouttD = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttD.click();
		WebElement logoD = GWait.Wait_GetElementByCSS("img");
		logoD.click();


		//*********************Login with MS and upload the decision as "Query/Action Letter - Reviewers"**********************

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r11 = wb1.getSheet("Project Submissions");

		String Decision_LOP1 = r11.getCell(30,67).getContents();
		String Decisionfile1 = r11.getCell(31,67).getContents();
		String Decisioncmnt1 = r11.getCell(32,67).getContents();

		GlobalMethods.MS_Login();

		gp.Global_Dashboard_DeviationLink();

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
		select72.selectByVisibleText(Decision_LOP1);

		WebElement decisionupload2 = GWait.Wait_GetElementById("proj_document");
		decisionupload2.sendKeys(Decisionfile1);

		WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
		assign_comments2.sendKeys(Decisioncmnt1);

		WebElement decisionusubmit2 = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit2.click();

		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt2.click();

		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();

		GlobalMethods.PI_Login();

		WebElement PI_project_menu2 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu2.click();
	
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Query - Primary Reviewer");
		

	}

	// Check for 'Project status' when Deviation submission gets MS decision as 'Query/Action Letter - MS'
	public void CRe4_1399() throws Exception {

		Global_Project_Submissions gp=new Global_Project_Submissions();
		gp.PI_SubmitProject_IECAdmin();
		
		WebElement logoutt111 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt111.click();
		WebElement logo11 = GWait.Wait_GetElementByCSS("img");
		logo11.click();
		
		gp.Dashboard_Click_Admin();
		gp.Admin_Forwardto_MS();
		
		WebElement logoutt11 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt11.click();
		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();
	
		gp.MS_Dashboard_Click();
		gp.MS_ForwardTo_CP();
		
		WebElement logoutt3 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt3.click();

		WebElement logo3 = GWait.Wait_GetElementByCSS("img");
		logo3.click();
		
		gp.CP_DashboardClick();
		gp.CP_SubmitProjectTo_MS();

		WebElement logoutt5 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt5.click();

		WebElement logo5 = GWait.Wait_GetElementByCSS("img");
		logo5.click();

	// *************Deviation Script***********************
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");
		
		// Decision upload data
		String Decision_LOP = r1.getCell(11, 69).getContents();
		String Decisionfile = r1.getCell(28, 69).getContents();
		String Decisioncmnt = r1.getCell(29, 69).getContents();
		
		// Submit new documents data
		String Document_Title_in_list = r1.getCell(7, 69).getContents();
		String Version_in_list = r1.getCell(8, 69).getContents();
		String Document_Date_in_list = r1.getCell(9, 69).getContents();
		String doc_upload = r1.getCell(10, 69).getContents();

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
		
		WebElement logo121 = GWait.Wait_GetElementByCSS("img");
		logo121.click();

		GlobalMethods.PI_Login();
		
		WebElement Ongoingprojects1 = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		Ongoingprojects1.click();

		WebElement approvedprojoverview1 = GWait.Wait_GetElementByXpath("//td[9]/a/span");
		approvedprojoverview1.click();

		WebElement newdocuments = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments.click();
		
		// contination submission for query letter
		
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
				doc_version.sendKeys(Version_in_list);
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
		WebElement next_button2 = GWait.Wait_GetElementById("nextid");
		next_button2.click();

		WebElement submit_to_IEC = GWait.Wait_GetElementById("submitid");
		submit_to_IEC.click();
		
		Thread.sleep(2000);
		
		WebElement no1 = GWait.Wait_GetElementByXpath("(//input[@name='studyteam_members'])[2]");
		no1.click();
		WebElement conflictsubmit = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		conflictsubmit.click();
		GlobalMethods.alertaccept();

		//**************************Normal Flow after Deviation document*****************************

		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Submitted to IEC");
		GlobalMethods.Admin_Login();
		gp.Global_Dashboard_DeviationLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Submitted to IEC");
		gp.SubsequentSubmissions_IECAdmin_forwardto_MS();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","MS Review");

		WebElement logouttA = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttA.click();
		WebElement logoA = GWait.Wait_GetElementByCSS("img");
		logoA.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu.click();
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Under IEC Review");
		GlobalMethods.MS_Login();
		gp.Global_Dashboard_DeviationLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","MS Review");
		gp.MS_ForwardTo_CP();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Forwarded to Chairperson");

		WebElement logouttB = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttB.click();
		WebElement logoB = GWait.Wait_GetElementByCSS("img");
		logoB.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu1 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu1.click();
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Under IEC Review");
		GlobalMethods.CPLogin();
		gp.Global_Dashboard_DeviationLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Forwarded to Chairperson");
		gp.CP_SubmitProjectTo_MS();
		WebElement ProjectsLink = GWait.Wait_GetElementByLinkText("Projects");
		ProjectsLink.click();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Chairperson Review");

		WebElement logouttC = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttC.click();
		WebElement logoC = GWait.Wait_GetElementByCSS("img");
		logoC.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu3 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu3.click();
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Under IEC Review");
		GlobalMethods.MS_Login();
		gp.Global_Dashboard_DeviationLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Chairperson Review");		
		
		

		WebElement logouttD = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttD.click();
		WebElement logoD = GWait.Wait_GetElementByCSS("img");
		logoD.click();


		//*********************Login with MS and upload the decision as "Query/Action Letter - MS"**********************

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r11 = wb1.getSheet("Project Submissions");

		String Decision_LOP1 = r11.getCell(30,69).getContents();
		String Decisionfile1 = r11.getCell(31,69).getContents();
		String Decisioncmnt1 = r11.getCell(32,69).getContents();

		GlobalMethods.MS_Login();

		gp.Global_Dashboard_DeviationLink();

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
		select72.selectByVisibleText(Decision_LOP1);

		WebElement decisionupload2 = GWait.Wait_GetElementById("proj_document");
		decisionupload2.sendKeys(Decisionfile1);

		WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
		assign_comments2.sendKeys(Decisioncmnt1);

		WebElement decisionusubmit2 = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit2.click();

		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt2.click();

		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();

		GlobalMethods.PI_Login();

		WebElement PI_project_menu2 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu2.click();
	
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Query - Member Secretary");
		
	}
	

	// Check for 'Project status' when Deviation submission gets MS decision as 'Noted Letter'
	public void CRe4_1404() throws Exception {
		Global_Project_Submissions gp=new Global_Project_Submissions();
		gp.PI_SubmitProject_IECAdmin();
		
		WebElement logoutt111 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt111.click();
		WebElement logo11 = GWait.Wait_GetElementByCSS("img");
		logo11.click();
		
		gp.Dashboard_Click_Admin();
		gp.Admin_Forwardto_MS();
		
		WebElement logoutt11 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt11.click();
		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();
	
		gp.MS_Dashboard_Click();
		gp.MS_ForwardTo_CP();
		
		WebElement logoutt3 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt3.click();

		WebElement logo3 = GWait.Wait_GetElementByCSS("img");
		logo3.click();
		
		gp.CP_DashboardClick();
		gp.CP_SubmitProjectTo_MS();

		WebElement logoutt5 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt5.click();

		WebElement logo5 = GWait.Wait_GetElementByCSS("img");
		logo5.click();

	// *************Deviation Script***********************
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");
		
		// Decision upload data
		String Decision_LOP = r1.getCell(11, 71).getContents();
		String Decisionfile = r1.getCell(28, 71).getContents();
		String Decisioncmnt = r1.getCell(29, 71).getContents();
		
		// Submit new documents data
		String Document_Title_in_list = r1.getCell(7, 71).getContents();
		String Version_in_list = r1.getCell(8, 71).getContents();
		String Document_Date_in_list = r1.getCell(9, 71).getContents();
		String doc_upload = r1.getCell(10, 71).getContents();

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
		
		WebElement logo121 = GWait.Wait_GetElementByCSS("img");
		logo121.click();

		GlobalMethods.PI_Login();
		
		WebElement Ongoingprojects1 = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		Ongoingprojects1.click();

		WebElement approvedprojoverview1 = GWait.Wait_GetElementByXpath("//td[9]/a/span");
		approvedprojoverview1.click();

		WebElement newdocuments = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments.click();
		
		// contination submission for query letter
		
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
				doc_version.sendKeys(Version_in_list);
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
		WebElement next_button2 = GWait.Wait_GetElementById("nextid");
		next_button2.click();

		WebElement submit_to_IEC = GWait.Wait_GetElementById("submitid");
		submit_to_IEC.click();
		
		Thread.sleep(2000);
		
		WebElement no1 = GWait.Wait_GetElementByXpath("(//input[@name='studyteam_members'])[2]");
		no1.click();
		WebElement conflictsubmit = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		conflictsubmit.click();
		GlobalMethods.alertaccept();

		//**************************Normal Flow after Deviation document*****************************

		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Submitted to IEC");
		GlobalMethods.Admin_Login();
		gp.Global_Dashboard_DeviationLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Submitted to IEC");
		gp.SubsequentSubmissions_IECAdmin_forwardto_MS();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","MS Review");

		WebElement logouttA = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttA.click();
		WebElement logoA = GWait.Wait_GetElementByCSS("img");
		logoA.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu.click();
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Under IEC Review");
		GlobalMethods.MS_Login();
		gp.Global_Dashboard_DeviationLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","MS Review");
		gp.MS_ForwardTo_CP();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Forwarded to Chairperson");

		WebElement logouttB = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttB.click();
		WebElement logoB = GWait.Wait_GetElementByCSS("img");
		logoB.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu1 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu1.click();
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Under IEC Review");
		GlobalMethods.CPLogin();
		gp.Global_Dashboard_DeviationLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Forwarded to Chairperson");
		gp.CP_SubmitProjectTo_MS();
		WebElement ProjectsLink = GWait.Wait_GetElementByLinkText("Projects");
		ProjectsLink.click();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Chairperson Review");

		WebElement logouttC = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttC.click();
		WebElement logoC = GWait.Wait_GetElementByCSS("img");
		logoC.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu3 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu3.click();
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Under IEC Review");
		GlobalMethods.MS_Login();
		gp.Global_Dashboard_DeviationLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Chairperson Review");		
		
		

		WebElement logouttD = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttD.click();
		WebElement logoD = GWait.Wait_GetElementByCSS("img");
		logoD.click();


		//*********************Login with MS and upload the decision as "Noted Letter"**********************

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r11 = wb1.getSheet("Project Submissions");

		String Decision_LOP1 = r11.getCell(30,71).getContents();
		String Decisionfile1 = r11.getCell(31,71).getContents();
		String Decisioncmnt1 = r11.getCell(32,71).getContents();

		GlobalMethods.MS_Login();

		gp.Global_Dashboard_DeviationLink();

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
		select72.selectByVisibleText(Decision_LOP1);

		WebElement decisionupload2 = GWait.Wait_GetElementById("proj_document");
		decisionupload2.sendKeys(Decisionfile1);

		WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
		assign_comments2.sendKeys(Decisioncmnt1);

		WebElement decisionusubmit2 = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit2.click();

		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt2.click();

		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();

		GlobalMethods.PI_Login();

		WebElement PI_project_menu2 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu2.click();
	
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Noted");
		
		
	}

	// Check for 'Project status' when Deviation submission gets MS decision as 'Suspension letter'
	public void CRe4_1409() throws Exception {

		Global_Project_Submissions gp=new Global_Project_Submissions();
		gp.PI_SubmitProject_IECAdmin();
		
		WebElement logoutt111 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt111.click();
		WebElement logo11 = GWait.Wait_GetElementByCSS("img");
		logo11.click();
		
		gp.Dashboard_Click_Admin();
		gp.Admin_Forwardto_MS();
		
		WebElement logoutt11 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt11.click();
		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();
	
		gp.MS_Dashboard_Click();
		gp.MS_ForwardTo_CP();
		
		WebElement logoutt3 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt3.click();

		WebElement logo3 = GWait.Wait_GetElementByCSS("img");
		logo3.click();
		
		gp.CP_DashboardClick();
		gp.CP_SubmitProjectTo_MS();

		WebElement logoutt5 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt5.click();

		WebElement logo5 = GWait.Wait_GetElementByCSS("img");
		logo5.click();

	// *************Deviation Script***********************
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");
		
		// Decision upload data
		String Decision_LOP = r1.getCell(11, 73).getContents();
		String Decisionfile = r1.getCell(28, 73).getContents();
		String Decisioncmnt = r1.getCell(29, 73).getContents();
		
		// Submit new documents data
		String Document_Title_in_list = r1.getCell(7, 73).getContents();
		String Version_in_list = r1.getCell(8, 73).getContents();
		String Document_Date_in_list = r1.getCell(9, 73).getContents();
		String doc_upload = r1.getCell(10, 73).getContents();

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
		
		WebElement logo121 = GWait.Wait_GetElementByCSS("img");
		logo121.click();

		GlobalMethods.PI_Login();
		
		WebElement Ongoingprojects1 = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		Ongoingprojects1.click();

		WebElement approvedprojoverview1 = GWait.Wait_GetElementByXpath("//td[9]/a/span");
		approvedprojoverview1.click();

		WebElement newdocuments = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments.click();
		
		// contination submission for query letter
		
		WebElement deviat1 = GWait.Wait_GetElementByLinkText("Deviation");
		deviat1.click();

		System.out.println(docvalue1.size() - 1);
    
		for (int i = 1; i <= docvalue1.size() - 1; i++) {
			querydocount = i;
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
		Thread.sleep(10000);
		WebElement next_button2 = GWait.Wait_GetElementById("nextid");
		next_button2.click();

		WebElement submit_to_IEC = GWait.Wait_GetElementById("submitid");
		submit_to_IEC.click();
		
		Thread.sleep(2000);
		
		WebElement no1 = GWait.Wait_GetElementByXpath("(//input[@name='studyteam_members'])[2]");
		no1.click();
		WebElement conflictsubmit = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		conflictsubmit.click();
		GlobalMethods.alertaccept();

		//**************************Normal Flow after Deviation document*****************************

		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Submitted to IEC");
		GlobalMethods.Admin_Login();
		gp.Global_Dashboard_DeviationLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Submitted to IEC");
		gp.SubsequentSubmissions_IECAdmin_forwardto_MS();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","MS Review");

		WebElement logouttA = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttA.click();
		WebElement logoA = GWait.Wait_GetElementByCSS("img");
		logoA.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu.click();
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Under IEC Review");
		GlobalMethods.MS_Login();
		gp.Global_Dashboard_DeviationLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","MS Review");
		gp.MS_ForwardTo_CP();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Forwarded to Chairperson");

		WebElement logouttB = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttB.click();
		WebElement logoB = GWait.Wait_GetElementByCSS("img");
		logoB.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu1 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu1.click();
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Under IEC Review");
		GlobalMethods.CPLogin();
		gp.Global_Dashboard_DeviationLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Forwarded to Chairperson");
		gp.CP_SubmitProjectTo_MS();
		WebElement ProjectsLink = GWait.Wait_GetElementByLinkText("Projects");
		ProjectsLink.click();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Chairperson Review");

		WebElement logouttC = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttC.click();
		WebElement logoC = GWait.Wait_GetElementByCSS("img");
		logoC.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu3 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu3.click();
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Under IEC Review");
		GlobalMethods.MS_Login();
		gp.Global_Dashboard_DeviationLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Approved","Deviation","Chairperson Review");		
		
		

		WebElement logouttD = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttD.click();
		WebElement logoD = GWait.Wait_GetElementByCSS("img");
		logoD.click();


		//*********************Login with MS and upload the decision as "Suspension Letter"**********************

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r11 = wb1.getSheet("Project Submissions");

		String Decision_LOP1 = r11.getCell(30,73).getContents();
		String Decisionfile1 = r11.getCell(31,73).getContents();
		String Decisioncmnt1 = r11.getCell(32,73).getContents();

		GlobalMethods.MS_Login();

		gp.Global_Dashboard_DeviationLink();

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
		select72.selectByVisibleText(Decision_LOP1);

		WebElement decisionupload2 = GWait.Wait_GetElementById("proj_document");
		decisionupload2.sendKeys(Decisionfile1);

		WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
		assign_comments2.sendKeys(Decisioncmnt1);

		WebElement decisionusubmit2 = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit2.click();

		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt2.click();

		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();

		GlobalMethods.PI_Login();

		WebElement PI_project_menu2 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu2.click();
	
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Suspended","Deviation","Suspended");
		

	}

}
