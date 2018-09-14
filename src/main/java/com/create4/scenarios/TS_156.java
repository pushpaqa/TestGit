package com.create4.scenarios;

import java.io.FileInputStream;
import java.util.List;

import org.eclipse.jetty.util.security.Password;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;
import com.thoughtworks.selenium.webdriven.commands.Click;

import jxl.Sheet;
import jxl.Workbook;

/*
 * Check for initial project submission as Co-Investigator
 */
public class TS_156 {
	public TS_156() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

// PI submit new project page elements

	@FindBy(linkText = "Health Care Institute")
	WebElement Login_institute;
	
	//login elements
		@FindBy(id = "register_email")
		WebElement email;

		@FindBy(id = "register_password")
		WebElement pwd;
		
		@FindBy(id = "password")
		WebElement stdpwd;

		@FindBy(id = "register_role")
		WebElement rol;

		@FindBy(id = "login_institute")
		WebElement login;
	
	@FindBy(id = "nextidedit")
	WebElement next_editbutton;
	@FindBy(linkText = "Submit New Project")
	WebElement createproject;
	
	@FindBy(xpath = "//span[2]/a")
	WebElement delegate;

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
	
	@FindBy(xpath = "//div[@id='deactivatingStudyTeamMmeber']/div[2]/div/div[2]/button")
	WebElement ok;

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

	// annexure form elements

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

	@FindBy(id = "add_annexure_document_type")
	WebElement annexure_document_type;

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

	@FindBy(id = "IEC Submission Forms / Annexures")
	WebElement admin_menu_IEC_Submission_Forms_Annexures;

	@FindBy(id = "Add IEC Submission Form / Annexure")
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

	// study team members

	@FindBy(linkText = "Study Team Member")
	WebElement studyteammember;

	@FindBy(id = "study_member_name")
	WebElement studyteammember_name;

	@FindBy(css = ".ui-corner-all")
	List<WebElement> studyteammember_selectname;

	@FindBy(xpath = "//*[@id='forward_submission']/div/div[1]/div[3]/div/select")
	WebElement studyteammember_role;

	@FindBy(id = "study_member_email")
	WebElement studyteammember_email;

	@FindBy(id = "savedoc")
	WebElement studyteammember_authorize;

	@FindBy(xpath = "//td[3]")
	WebElement studyteammember_name_inlist;

	@FindBy(xpath = "//td[4]")
	WebElement studyteammember_email_inlist;

	@FindBy(xpath = "//td[5]")
	WebElement studyteammember_role_inlist;

	// Login

	
	@FindBy(linkText = "Research approval institute")
	WebElement Login_Institute;

	@FindBy(linkText = "My Projects")
	WebElement PI_project_menu;

	@FindBy(css = "span.fa.fa-edit")
	WebElement query_tab_edit;
	
	@FindBy(id = "nextideditsubmission")
	WebElement next_button;
	
	
//Check for initial project submission as Co-Investigator
	public void CRe4_2104() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");
		Sheet r2 = wb.getSheet("Institute_Logins");
		
		String PI_Institute = r2.getCell(0, 2).getContents();
		
		String studyteammem_name = r1.getCell(2, 119).getContents();
		String studyteammem_email = r1.getCell(3, 119).getContents();
		String studyteammem_role = r1.getCell(4, 119).getContents();
		String studyteammem_pwd = r1.getCell(5, 119).getContents();
		
		

		String Project_Type = r1.getCell(10, 117).getContents();
		String Review_Type = r1.getCell(11, 117).getContents();
		String Project_Full_Title = r1.getCell(12, 117).getContents();
		String Project_Short_Title = r1.getCell(13, 117).getContents();
		String Sponsor = r1.getCell(14, 117).getContents();

		String Document_Title_in_list = r1.getCell(15, 117).getContents();
		String Version_in_list = r1.getCell(16, 117).getContents();
		String Document_Date_in_list = r1.getCell(17, 117).getContents();
		String doc_upload = r1.getCell(18, 117).getContents();

		
         GlobalMethods.PI_Login();
		
         WebElement createproject = GWait.Wait_GetElementByLinkText("Submit New Project");
 		createproject.click();

 		WebElement projtypdrop = GWait
 				.Wait_GetElementByXpath(".//*[@id='projectsummary']/div/div[1]/div[1]/div/div/button");
 		projtypdrop.click();
 		Thread.sleep(2000);

 		List<WebElement> elementsList11 = projtypvalue;
 		for (WebElement a11 : elementsList11) {
 			WebElement span = a11.findElement(By.tagName("span"));
 			if (span.getText().equalsIgnoreCase(Project_Type)) {
 				span.click();
 				break;
 			}
 		}

 		WebElement revtypdrop = GWait
 				.Wait_GetElementByXpath("//*[@id='projectsummary']/div/div[2]/div[1]/div/div/button");
 		revtypdrop.click();
 		Thread.sleep(2000);

 		List<WebElement> elementsList2 = revtypvalue;
 		for (WebElement a111 : elementsList2) {
 			WebElement span = a111.findElement(By.tagName("span"));
 			// System.out.println(Review_Type);
 			System.out.println(span.getText());
 			if (span.getText().equalsIgnoreCase(Review_Type)) {

 				span.click();
 				String text = span.getText();
 				System.out.println(text);
 				break;
 			}
 		}

 		WebElement Full_title = GWait.Wait_GetElementById("projecttitle");
 		Full_title.sendKeys(Project_Full_Title);

 		WebElement short_title = GWait.Wait_GetElementById("projectshorttitle");
 		short_title.sendKeys(Project_Short_Title);

 		WebElement sponsor = GWait.Wait_GetElementById("project_description");
 		sponsor.sendKeys(Sponsor);

 		WebElement save_button1 = GWait.Wait_GetElementByXpath("//*[@id='sumsave']");
 		save_button1.click();

 		// saving Submit documents

 		Thread.sleep(2000);
 		System.out.println(docvalue.size() - 1);

 		for (int i = 1; i <= docvalue.size() - 1; i++) {
 			Thread.sleep(10000);
 			docdrop.click();
 			String numberAsString = Integer.toString(i);
 			Thread.sleep(5000);
 			List<WebElement> elementsList3 = docvalue;
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
 				WebElement doc_title =GWait.Wait_GetElementById("document_title");
				doc_title.sendKeys(Document_Title_in_list);
				
				WebElement doc_version =GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);
								
				WebElement doc_date =GWait.Wait_GetElementById("document_date");
				doc_date.sendKeys(Document_Date_in_list);

				
				WebElement upload_doc =GWait.Wait_GetElementById("proj_document");
				upload_doc.sendKeys(doc_upload);

				
				WebElement save_button2 =GWait.Wait_GetElementById("savedoc");
				save_button2.click();

 			}

 		}

 		Thread.sleep(2000);
 		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
 		Thread.sleep(10000);

 		WebElement next_button = GWait.Wait_GetElementById("nextid");
 		next_button.click();

 		WebElement next_button1 = GWait.Wait_GetElementById("nextid");
 		next_button1.click();

 		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
 		logoutt.click();

 		WebElement logo = GWait.Wait_GetElementByCSS("img");
 		logo.click();

		
 		GlobalMethods.PI_Login();

		WebElement PI_project_menu = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu.click();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();

		WebElement studyteammember = GWait.Wait_GetElementByLinkText("Study Team Member");
		studyteammember.click();
		
		
		WebElement studyteammember_name = GWait.Wait_GetElementById("study_member_name");
		studyteammember_name.sendKeys(studyteammem_name);
		
		
		WebElement studyteammember_email = GWait.Wait_GetElementById("study_member_email");
		studyteammember_email.sendKeys(studyteammem_email);

		
		WebElement studyteammember_role = GWait.Wait_GetElementByXpath("//*[@id='forward_submission']/div/div[1]/div[3]/div/select");
		Select select = new Select(studyteammember_role);
		select.selectByVisibleText(studyteammem_role);
		
		WebElement studyteammember_authorize = GWait.Wait_GetElementById("savedoc");
		studyteammember_authorize.click();
		
		WebElement logoutt3 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt3.click();
		
		WebElement logo3 = GWait.Wait_GetElementByCSS("img");
		logo3.click();
	
		
		WebElement institute = GWait.Wait_GetElementByLinkText(PI_Institute);
		institute.click();
		
	
		WebElement email =GWait.Wait_GetElementById("register_email");
		email.sendKeys(studyteammem_email);
		
		
		WebElement pwd =GWait.Wait_GetElementById("register_password");
		
		pwd.sendKeys(studyteammem_pwd);

		Select dropdown = new Select(rol);
		dropdown.selectByValue("2");
		
		
		WebElement login =GWait.Wait_GetElementById("login_institute");
		login.click();
        Thread.sleep(6000);
		WebElement PI_project_menu2 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu2.click();

		
		
		WebElement query_tab_edit =GWait.Wait_GetElementByCSS("span.fa.fa-edit");

		query_tab_edit.click();
		
		
		WebElement next_editbutton =GWait.Wait_GetElementById("nextidedit");
		next_editbutton.click();
		
		WebElement submit_to_IEC1 =GWait.Wait_GetElementById("submitid");
		Assert.assertEquals(submit_to_IEC1.getText(), "Submit for PI Review");
		
		WebElement submit_to_IEC =GWait.Wait_GetElementById("submitid");
		submit_to_IEC.click();
		
		Thread.sleep(3000);
		WebElement no =GWait.Wait_GetElementByXpath("//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[2]");
		no.click();
		
		
		WebElement conflictsubmit= GWait.Wait_GetElementByXpath("//*[@id='submit_for_iec_review_confirm']");
		conflictsubmit.click();
		
		Thread.sleep(3000);
		GlobalMethods.alertaccept();
		Thread.sleep(6000);
		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();

		WebElement logo2 = GWait.Wait_GetElementByCSS("img");
		logo2.click();

	}

}
