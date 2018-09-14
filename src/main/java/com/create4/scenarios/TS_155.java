package com.create4.scenarios;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import org.apache.commons.exec.util.StringUtils;
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

import jxl.Sheet;
import jxl.Workbook;

//Check for Initial project submission to IEC with conflict of interest valid/invalid data

public class TS_155 {
	public TS_155() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	// PI submit new project page elements

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

	@FindBy(xpath = "//html/body/div[5]/div/div/div[2]/div[3]/div[1]/p")
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

	@FindBy(xpath = "//li[9]/a/span")
	WebElement other_dashboard;

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

	@FindBy(xpath = "//div[2]/div/div/ul/li[7]/a/span")
	WebElement deviation_dashboard;

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

	// Conflict of interest form fields elements

	@FindBy(xpath = "//form[@id='conflictsubmit']/div/div/div/label")
	WebElement conflict_first_field_text;

	@FindBy(xpath = "//form[@id='conflictsubmit']/div/div/div/div")
	WebElement conflict_yes_no_fields;

	@FindBy(xpath = "//div[@id='iecMembersSelect']/div[2]/label")
	WebElement conflict_yes_text_field;

	@FindBy(xpath = "//div[@id='memlist']/div/ul/li/input")
	WebElement conflict_yes_text_box;

	@FindBy(xpath = "//*[@id='memlist']/div/ul[2]/li")
	List<WebElement> conflict_yes_text_box_value;

	@FindBy(linkText = "My Projects")
	WebElement PI_Project_Menu;

	@FindBy(linkText = "nextideditsubmission")
	WebElement nextbuttoninedit;

	// conflict of interest in summary

	@FindBy(xpath = ".//*[@id='summary']/div[1]/div[10]/div[2]/p")
	WebElement conflict_summary_details;
	
	
	
	
	@FindBy(xpath = ".//*[@id='summary']/div[1]/div[11]/div[2]/p")
	WebElement conflict_summary_details_overview;
	
	@FindBy(xpath = "//*[@id='memlist']/div/ul[1]/li[1]/span")
	WebElement cnflct_box_value_1;

	@FindBy(xpath = "//*[@id='memlist']/div/ul[1]/li[2]/span")
	WebElement cnflct_box_value_2;

	// Check for Initial project submission to IEC
	// Check for conflict of interest form options
	// Check for 'Is any of the study team member is also an IEC member' field
	// functionality in form
	// Check for 'Specify the Name of Members' field in form
	// Check for mandatory fields of conflict form
	// Check for 'Conflict of interest' form submission with blank data
	// Check for 'Conflict form' submission by name with invalid data
	public void CRe4_2085_2086_2087_2088_2089_2090_2091_2093_2094_2095() throws Exception {


		GlobalMethods.PI_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Projects");


		String Project_Type = r1.getCell(2, 85).getContents();
		String Review_Type_expedited = r1.getCell(3, 85).getContents();
		String Project_Full_Title = r1.getCell(4, 85).getContents();
		String Project_Short_Title = r1.getCell(5, 85).getContents();
		String Sponsor = r1.getCell(6, 85).getContents();

			
		String Document_Title_in_list = r1.getCell(7, 85).getContents();
		String Version_in_list = r1.getCell(8, 85).getContents();
		String Document_Date_in_list = r1.getCell(9, 85).getContents();
		String doc_upload = r1.getCell(10, 85).getContents();

		String Conflict_field_name_1 = r1.getCell(11, 85).getContents();
		String Conflict_field_name_2 = r1.getCell(12, 85).getContents();
		String Conflict_field_name_3 = r1.getCell(13, 85).getContents();
		
		// Admin data
				String pyrcnum = r1.getCell(14, 85).getContents();
				String inwnum = r1.getCell(15, 85).getContents();
				String prjnum = r1.getCell(16, 85).getContents();
				String insdate = r1.getCell(17, 85).getContents();
				String inwrddate = r1.getCell(18, 85).getContents();
				String ethic_com = r1.getCell(19, 85).getContents();
				String ethic_comnts = r1.getCell(20, 85).getContents();
				
				String Rev_one = r1.getCell(21, 85).getContents();
				String Rev_two = r1.getCell(22, 85).getContents();
				String Rev_three = r1.getCell(23, 85).getContents();
				String Rev_four = r1.getCell(24, 85).getContents();
				String Rev_five = r1.getCell(25, 85).getContents();
				String Rev_six = r1.getCell(26, 85).getContents();
				String Rev_comnts = r1.getCell(27, 85).getContents();
				
				String Decisionfile = r1.getCell(28, 85).getContents();
				String Decisioncmnt = r1.getCell(29, 85).getContents();
				String Decision_LOP = r1.getCell(30, 85).getContents();


		WebElement createproject = GWait.Wait_GetElementByLinkText("Submit New Project");
		createproject.click();

		WebElement projtypdrop = GWait.Wait_GetElementByXpath(".//*[@id='projectsummary']/div/div[1]/div[1]/div/div/button");
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

		WebElement revtypdrop = GWait.Wait_GetElementByXpath("//*[@id='projectsummary']/div/div[2]/div[1]/div/div/button");
		revtypdrop.click();
		Thread.sleep(2000);

		List<WebElement> elementsList2 = revtypvalue;
		for (WebElement a111 : elementsList2) {
			WebElement span = a111.findElement(By.tagName("span"));
			// System.out.println(Review_Type);
			System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(Review_Type_expedited)) {

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

			}break;

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(10000);
	

		Thread.sleep(6000);

		WebElement next_button = GWait.Wait_GetElementById("nextid");
		next_button.click();

			
		WebElement submit_to_IEC =GWait.Wait_GetElementById("submitid");
     	submit_to_IEC.click();
		Thread.sleep(4000);

		String conflict_first_field_text_1 = conflict_first_field_text.getText();
		Assert.assertEquals(conflict_first_field_text_1, Conflict_field_name_1);
		System.out.println(conflict_first_field_text.getText());

		
		String conflict_yes_no_fields_1 = conflict_yes_no_fields.getText();
		System.out.println(conflict_yes_no_fields_1);
		Assert.assertEquals(conflict_yes_no_fields.getText().trim(), Conflict_field_name_2);
		
		
		
		WebElement conflictsubmit =GWait.Wait_GetElementByXpath("//*[@id='submit_for_iec_review_confirm']");
		conflictsubmit.click();
		Thread.sleep(2000);
		GlobalMethods.alertaccept();
		Thread.sleep(2000);
		WebElement yes =GWait.Wait_GetElementByXpath("//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[1]");
		yes.click();
		Thread.sleep(6000);

		String conflict_yes_text_field_1 = conflict_yes_text_field.getText();
		Assert.assertEquals(conflict_yes_text_field_1, Conflict_field_name_3);
		System.out.println(conflict_yes_text_field.getText());

		WebElement conflictsubmit1 =GWait.Wait_GetElementByXpath("//*[@id='submit_for_iec_review_confirm']");
		conflictsubmit1.click();
		Thread.sleep(4000);

		GlobalMethods.alertaccept();

		Thread.sleep(4000);
		WebElement conflict_yes_text_box =GWait.Wait_GetElementByXpath("//div[@id='memlist']/div/ul/li/input");
		conflict_yes_text_box.sendKeys("afdfasdfasd");
		Thread.sleep(2000);
		for (WebElement s : conflict_yes_text_box_value) {
			s.click();
		}

		WebElement conflictsubmit2 =GWait.Wait_GetElementByXpath("//*[@id='submit_for_iec_review_confirm']");
		conflictsubmit2.click();
		Thread.sleep(4000);

		GlobalMethods.alertaccept();

		Thread.sleep(2000);
		WebElement conflict_yes_text_box1 =GWait.Wait_GetElementByXpath("//div[@id='memlist']/div/ul/li/input");
		conflict_yes_text_box1.clear();
		WebElement conflict_yes_text_box2 =GWait.Wait_GetElementByXpath("//div[@id='memlist']/div/ul/li/input");
		conflict_yes_text_box2.sendKeys("a");
		Thread.sleep(2000);
		for (WebElement s : conflict_yes_text_box_value) {
			s.click();

			break;
		}

		Thread.sleep(2000);
		WebElement conflict_yes_text_box3 =GWait.Wait_GetElementByXpath("//div[@id='memlist']/div/ul/li/input");
		conflict_yes_text_box3.clear();
		WebElement conflict_yes_text_box4 =GWait.Wait_GetElementByXpath("//div[@id='memlist']/div/ul/li/input");
		conflict_yes_text_box4.sendKeys("a");
		Thread.sleep(2000);
		for (WebElement s : conflict_yes_text_box_value) {
			s.click();

			break;
		}

		Thread.sleep(8000);
		String conflict_mem1 = cnflct_box_value_1.getText();
		String conflict_mem2 = cnflct_box_value_2.getText();


		String add = conflict_mem1 + "," + conflict_mem2;
		System.out.println(add);

		WebElement conflictsubmit3 =GWait.Wait_GetElementByXpath("//*[@id='submit_for_iec_review_confirm']");
		conflictsubmit3.click();
		Thread.sleep(8000);
		GlobalMethods.alertaccept();
		Thread.sleep(8000);
		
		
		WebElement Projectoverview = GWait.Wait_GetElementByCSS(("span.fa.fa-eye"));
		Projectoverview.click();

		Thread.sleep(2000);
		String conflict_summary_details_1 = conflict_summary_details.getText();
		System.out.println(conflict_summary_details_1);
		Thread.sleep(4000);
		Assert.assertEquals(conflict_summary_details.getText().trim(), add);
		
		
		
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();

		//--Login as admin and verify the conflict of member names in project overview--//
		GlobalMethods.Admin_Login();
		
		WebElement Dashboard_newsubmission2 = GWait.Wait_GetElementByCSS("span.pull-left");
		Dashboard_newsubmission2.click();
		
		WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview2.click();
		
		Thread.sleep(2000);
		String conflict_summary_details_admin = conflict_summary_details.getText();
		System.out.println(conflict_summary_details_admin);
		Thread.sleep(4000);
		Assert.assertEquals(conflict_summary_details.getText().trim(), add);
		
		
		WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review2.click();

		WebElement Processing_fee_yes2 = GWait.Wait_GetElementById("processing_fee_paid");
		Processing_fee_yes2.click();

		WebElement payment_receipt_yes2 = GWait.Wait_GetElementById("payment_receipt");
		payment_receipt_yes2.sendKeys(pyrcnum);

		WebElement hard_copy_yes2 = GWait.Wait_GetElementById("hard_copy_submitted");
		hard_copy_yes2.click();

		WebElement inward_no_yes2 = GWait.Wait_GetElementById("inward_no");
		inward_no_yes2.sendKeys(inwnum);

		WebElement projnum2 = GWait.Wait_GetElementById("project_number");
		projnum2.sendKeys(prjnum);

		WebElement insurdate2 = GWait.Wait_GetElementById("insurance_date");
		insurdate2.sendKeys(insdate);

		WebElement inwdate2 = GWait.Wait_GetElementById("inward_no_date");
		inwdate2.sendKeys(inwrddate);

		WebElement forward_button2 = GWait.Wait_GetElementById("forward_modal_btn");
		forward_button2.click();

		Thread.sleep(6000);
		WebElement ethic_selection2 = GWait.Wait_GetElementById("txn_ethic_committee_id");
		Select select22 = new Select(ethic_selection2);
		select22.selectByVisibleText(ethic_com);


		WebElement ethic_comments2 = GWait.Wait_GetElementByClassName("richText");
		ethic_comments2.sendKeys(ethic_comnts);

		WebElement ethic_frwd2 = GWait.Wait_GetElementById("forward_btn");
		ethic_frwd2.click();

		Thread.sleep(20000);
		GWait.LoadGif();
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();
		
		//--Login as MS and verify the conflict of member names in project overview--//

		GlobalMethods.MS_Login();
		
		WebElement exp_dash = GWait.Wait_GetElementByXpath("//li[2]/a/span");
		exp_dash.click();

		WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview1.click();
		
		Thread.sleep(2000);
		String conflict_summary_details_ms = conflict_summary_details_overview.getText();
		System.out.println(conflict_summary_details_ms);
		Thread.sleep(4000);
		Assert.assertEquals(conflict_summary_details_overview.getText().trim(), add);
		
		
		WebElement asignreviewers = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers.click();

		WebElement primaryreview_one = GWait.Wait_GetElementById("primary_reviewer");
		Select select1 = new Select(primaryreview_one);
		select1.selectByVisibleText(Rev_one);

		WebElement nonprimaryreview_one = GWait.Wait_GetElementByName("nontech_primary_reviewer1");
		Select select2 = new Select(nonprimaryreview_one);
		select2.selectByVisibleText(Rev_two);

		WebElement primaryreview_two = GWait.Wait_GetElementByName("tech_primary_reviewer2");
		Select select3 = new Select(primaryreview_two);
		select3.selectByVisibleText(Rev_three);

		WebElement nonprimaryreview_two = GWait.Wait_GetElementByName("nontech_primary_reviewer2");
		Select select4 = new Select(nonprimaryreview_two);
		select4.selectByVisibleText(Rev_four);

		WebElement primaryreview_three = GWait.Wait_GetElementByName("tech_primary_reviewer3");
		Select select5 = new Select(primaryreview_three);
		select5.selectByVisibleText(Rev_five);

		WebElement nonprimaryreview_three = GWait.Wait_GetElementByName("nontech_primary_reviewer3");
		Select select6 = new Select(nonprimaryreview_three);
		select6.selectByVisibleText(Rev_six);

		WebElement assign_comments = GWait.Wait_GetElementById("comments");
		assign_comments.clear();

		WebElement assign_comments1 = GWait.Wait_GetElementById("comments");
		assign_comments1.sendKeys(Rev_comnts);

		WebElement frwdtocp_button = GWait.Wait_GetElementById("forward_chairman");
		frwdtocp_button.click();

		WebElement logoutt22 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt22.click();

		WebElement logo821 = GWait.Wait_GetElementByCSS("img");
		logo821.click();
		
		//--Login as CP and verify the conflict of member names in project overview--//
		
		GlobalMethods.CPLogin();
		
		WebElement exp_dash1 = GWait.Wait_GetElementByXpath("//li[2]/a/span");
		exp_dash1.click();

		WebElement Projectoverview11 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview11.click();
		
		Thread.sleep(2000);
		String conflict_summary_details_cp = conflict_summary_details_overview.getText();
		System.out.println(conflict_summary_details_cp);
		Thread.sleep(4000);
		Assert.assertEquals(conflict_summary_details_overview.getText().trim(), add);
		
		
		WebElement asignreviewers1 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers1.click();
		
		WebElement submitmsbutton = GWait.Wait_GetElementById("assign1");
		submitmsbutton.click();
		
		WebElement logoutt2111 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2111.click();

		WebElement logo8111 = GWait.Wait_GetElementByCSS("img");
		logo8111.click();
		
		//--MS gives Letter of Permission to the initial submission--//
		
		GlobalMethods.MS_Login();

		WebElement exp_dash11 = GWait.Wait_GetElementByXpath("//li[2]/a/span");
		exp_dash11.click();

		WebElement Projectoverview111 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview111.click();

		WebElement asignreviewers11 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers11.click();
	

		WebElement assign_button = GWait.Wait_GetElementById("assign");
		assign_button.click();

		Thread.sleep(20000);
		GWait.LoadGif();

		GlobalMethods.Commentswindhandler();
		Thread.sleep(8000);
		WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab.click();

		WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
		Select select7 = new Select(decisondropdown);
		select7.selectByVisibleText(Decision_LOP);

		WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
		decisionupload.sendKeys(Decisionfile);

		WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
		assign_comments2.sendKeys(Decisioncmnt);

		WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit.click();

		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();
		
	}
	
	//--Check for conflict of interest with yes option in subsequent submissions--//
		public void CRe4_2097_2098_2099_2100_2101() throws Exception {

			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("Projects");


					
			String Document_Title_in_list = r1.getCell(2, 89).getContents();
			String Version_in_list = r1.getCell(3, 89).getContents();
			String Document_Date_in_list = r1.getCell(4, 89).getContents();
			String doc_upload = r1.getCell(5, 89).getContents();

			String Conflict_field_name_1 = r1.getCell(6, 89).getContents();
			String Conflict_field_name_2 = r1.getCell(7, 89).getContents();
			String Conflict_field_name_3 = r1.getCell(8, 89).getContents();
			
			// Admin data
					String pyrcnum = r1.getCell(9, 89).getContents();
					String inwnum = r1.getCell(10, 89).getContents();
					String prjnum = r1.getCell(11, 89).getContents();
					String insdate = r1.getCell(12, 89).getContents();
					String inwrddate = r1.getCell(13, 89).getContents();
					String ethic_com = r1.getCell(14, 89).getContents();
					String ethic_comnts = r1.getCell(15, 89).getContents();
					
					String Rev_one = r1.getCell(16, 89).getContents();
					String Rev_two = r1.getCell(17, 89).getContents();
					String Rev_three = r1.getCell(18, 89).getContents();
					String Rev_four = r1.getCell(19, 89).getContents();
					String Rev_five = r1.getCell(20, 89).getContents();
					String Rev_six = r1.getCell(21, 89).getContents();
					String Rev_comnts = r1.getCell(22, 89).getContents();
					
				
		
		//--PI login and submits amendment submission--//
		
		GlobalMethods.PI_Login();
		
		WebElement ongoingdash = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		ongoingdash.click();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();

		WebElement submitnewdoc = GWait.Wait_GetElementByLinkText("Submit New Documents");
		submitnewdoc.click();

		WebElement amendlink = GWait.Wait_GetElementByLinkText("Amendment");
		amendlink.click();

		Thread.sleep(6000);
		Thread.sleep(2000);
		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; i++) {
			Thread.sleep(10000);
			docdrop1.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
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

			}break;

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(10000);

		Thread.sleep(6000);

		WebElement next_button = GWait.Wait_GetElementById("nextid");
		next_button.click();

			
		WebElement submit_to_IEC =GWait.Wait_GetElementById("submitid");
     	submit_to_IEC.click();
		Thread.sleep(4000);

		String conflict_first_field_text_1 = conflict_first_field_text.getText();
		Assert.assertEquals(conflict_first_field_text_1, Conflict_field_name_1);
		System.out.println(conflict_first_field_text.getText());

		
		String conflict_yes_no_fields_1 = conflict_yes_no_fields.getText();
		System.out.println(conflict_yes_no_fields_1);
		Assert.assertEquals(conflict_yes_no_fields.getText().trim(), Conflict_field_name_2);
		
		
		
		WebElement conflictsubmit =GWait.Wait_GetElementByXpath("//*[@id='submit_for_iec_review_confirm']");
		conflictsubmit.click();
		Thread.sleep(2000);
		GlobalMethods.alertaccept();
		Thread.sleep(2000);
		WebElement yes =GWait.Wait_GetElementByXpath("//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[1]");
		yes.click();
		Thread.sleep(6000);

		String conflict_yes_text_field_1 = conflict_yes_text_field.getText();
		Assert.assertEquals(conflict_yes_text_field_1, Conflict_field_name_3);
		System.out.println(conflict_yes_text_field.getText());

		WebElement conflictsubmit1 =GWait.Wait_GetElementByXpath("//*[@id='submit_for_iec_review_confirm']");
		conflictsubmit1.click();
		Thread.sleep(4000);

		GlobalMethods.alertaccept();

		Thread.sleep(4000);
		WebElement conflict_yes_text_box =GWait.Wait_GetElementByXpath("//div[@id='memlist']/div/ul/li/input");
		conflict_yes_text_box.sendKeys("afdfasdfasd");
		Thread.sleep(2000);
		for (WebElement s : conflict_yes_text_box_value) {
			s.click();
		}

		WebElement conflictsubmit2 =GWait.Wait_GetElementByXpath("//*[@id='submit_for_iec_review_confirm']");
		conflictsubmit2.click();
		Thread.sleep(4000);

		GlobalMethods.alertaccept();

		Thread.sleep(2000);
		WebElement conflict_yes_text_box1 =GWait.Wait_GetElementByXpath("//div[@id='memlist']/div/ul/li/input");
		conflict_yes_text_box1.clear();
		WebElement conflict_yes_text_box2 =GWait.Wait_GetElementByXpath("//div[@id='memlist']/div/ul/li/input");
		conflict_yes_text_box2.sendKeys("a");
		Thread.sleep(2000);
		for (WebElement s : conflict_yes_text_box_value) {
			s.click();

			break;
		}

		Thread.sleep(2000);
		WebElement conflict_yes_text_box3 =GWait.Wait_GetElementByXpath("//div[@id='memlist']/div/ul/li/input");
		conflict_yes_text_box3.clear();
		WebElement conflict_yes_text_box4 =GWait.Wait_GetElementByXpath("//div[@id='memlist']/div/ul/li/input");
		conflict_yes_text_box4.sendKeys("a");
		Thread.sleep(2000);
		for (WebElement s : conflict_yes_text_box_value) {
			s.click();

			break;
		}

		Thread.sleep(8000);
		String conflict_mem1 = cnflct_box_value_1.getText();
		String conflict_mem2 = cnflct_box_value_2.getText();


		String add = conflict_mem1 + "," + conflict_mem2;
		System.out.println(add);

		WebElement conflictsubmit3 =GWait.Wait_GetElementByXpath("//*[@id='submit_for_iec_review_confirm']");
		conflictsubmit3.click();
		Thread.sleep(8000);
		GlobalMethods.alertaccept();
		Thread.sleep(8000);
		
		
		WebElement Projectoverview = GWait.Wait_GetElementByCSS(("span.fa.fa-eye"));
		Projectoverview.click();

		Thread.sleep(2000);
		String conflict_summary_details_1 = conflict_summary_details_overview.getText();
		System.out.println(conflict_summary_details_1);
		Thread.sleep(4000);
		Assert.assertEquals(conflict_summary_details_overview.getText().trim(), add);
		
		
		
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();
        //--Login as admin and verify conflict of interest members--/
		
		GlobalMethods.Admin_Login();

		WebElement approved_amendments = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[6]/a/span");
		approved_amendments.click();

		WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview2.click();
		
		Thread.sleep(2000);
		String conflict_summary_details_admin = conflict_summary_details_overview.getText();
		System.out.println(conflict_summary_details_admin);
		Thread.sleep(4000);
		Assert.assertEquals(conflict_summary_details_overview.getText().trim(), add);
		
		WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review2.click();

	

		WebElement forward_button2 = GWait.Wait_GetElementById("forward_modal_btn");
		forward_button2.click();

		Thread.sleep(6000);
		WebElement ethic_selection2 = GWait.Wait_GetElementById("txn_ethic_committee_id");
		Select select22 = new Select(ethic_selection2);
		select22.selectByVisibleText(ethic_com);

	
		WebElement ethic_comments2 = GWait.Wait_GetElementByClassName("richText");
		ethic_comments2.sendKeys(ethic_comnts);

		WebElement ethic_frwd2 = GWait.Wait_GetElementById("forward_btn");
		ethic_frwd2.click();

		Thread.sleep(20000);
		GWait.LoadGif();
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();
		
		GlobalMethods.MS_Login();
		

		WebElement approved_amendments1 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[6]/a/span");
		approved_amendments1.click();

		WebElement Projectoverview12 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview12.click();
		
		
		Thread.sleep(2000);
		String conflict_summary_details_ms = conflict_summary_details_overview.getText();
		System.out.println(conflict_summary_details_ms);
		Thread.sleep(4000);
		Assert.assertEquals(conflict_summary_details_overview.getText().trim(), add);

		WebElement asignreviewers = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers.click();

		WebElement primaryreview_one = GWait.Wait_GetElementById("primary_reviewer");
		Select select1 = new Select(primaryreview_one);
		select1.selectByVisibleText(Rev_one);

		WebElement nonprimaryreview_one = GWait.Wait_GetElementByName("nontech_primary_reviewer1");
		Select select2 = new Select(nonprimaryreview_one);
		select2.selectByVisibleText(Rev_two);

		WebElement primaryreview_two = GWait.Wait_GetElementByName("tech_primary_reviewer2");
		Select select3 = new Select(primaryreview_two);
		select3.selectByVisibleText(Rev_three);

		WebElement nonprimaryreview_two = GWait.Wait_GetElementByName("nontech_primary_reviewer2");
		Select select4 = new Select(nonprimaryreview_two);
		select4.selectByVisibleText(Rev_four);

		WebElement primaryreview_three = GWait.Wait_GetElementByName("tech_primary_reviewer3");
		Select select5 = new Select(primaryreview_three);
		select5.selectByVisibleText(Rev_five);

		WebElement nonprimaryreview_three = GWait.Wait_GetElementByName("nontech_primary_reviewer3");
		Select select6 = new Select(nonprimaryreview_three);
		select6.selectByVisibleText(Rev_six);

		WebElement assign_comments = GWait.Wait_GetElementById("comments");
		assign_comments.clear();

		WebElement assign_comments1 = GWait.Wait_GetElementById("comments");
		assign_comments1.sendKeys(Rev_comnts);

		WebElement frwdtocp_button = GWait.Wait_GetElementById("forward_chairman");
		frwdtocp_button.click();


		WebElement logoutt22 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt22.click();

		WebElement logo821 = GWait.Wait_GetElementByCSS("img");
		logo821.click();
		
		GlobalMethods.CPLogin();
		
		WebElement approved_amendments11 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[6]/a/span");
		approved_amendments11.click();

		WebElement Projectoverview112 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview112.click();
		
		
		Thread.sleep(2000);
		String conflict_summary_details_cp = conflict_summary_details_overview.getText();
		System.out.println(conflict_summary_details_cp);
		Thread.sleep(4000);
		Assert.assertEquals(conflict_summary_details_overview.getText().trim(), add);
		
		
		WebElement asignreviewers1 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers1.click();
		
		WebElement submitmsbutton = GWait.Wait_GetElementById("assign1");
		submitmsbutton.click();
		
		WebElement logoutt211 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt211.click();

		WebElement logo8111 = GWait.Wait_GetElementByCSS("img");
		logo8111.click();
		
		
		
	}

	// Check for 'Conflict form' submission by option as 'No'
	public void CRe4_2092_2096() throws Exception {


				GlobalMethods.PI_Login();

				FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
				Workbook wb = Workbook.getWorkbook(fi);
				Sheet r1 = wb.getSheet("Projects");
				
			
				// Project summary data

				String Project_Type = r1.getCell(2, 87).getContents();
				String Review_Type_expedited = r1.getCell(3, 87).getContents();
				String Project_Full_Title = r1.getCell(4, 87).getContents();
				String Project_Short_Title = r1.getCell(5, 87).getContents();
				String Sponsor = r1.getCell(6, 87).getContents();

				String Document_Title_in_list = r1.getCell(7, 87).getContents();
				String Version_in_list = r1.getCell(8, 87).getContents();
				String Document_Date_in_list = r1.getCell(9, 87).getContents();
				String doc_upload = r1.getCell(10, 87).getContents();
				
				String conflict_summary_if_no = r1.getCell(11, 87).getContents();
				
				// Admin data
				String pyrcnum = r1.getCell(12, 87).getContents();
				String inwnum = r1.getCell(13, 87).getContents();
				String prjnum = r1.getCell(14, 87).getContents();
				String insdate = r1.getCell(15, 87).getContents();
				String inwrddate = r1.getCell(16, 87).getContents();
				String ethic_com = r1.getCell(17, 87).getContents();
				String ethic_comnts = r1.getCell(18, 87).getContents();
				
				String Rev_one = r1.getCell(19, 87).getContents();
				String Rev_two = r1.getCell(20, 87).getContents();
				String Rev_three = r1.getCell(21, 87).getContents();
				String Rev_four = r1.getCell(22, 87).getContents();
				String Rev_five = r1.getCell(23, 87).getContents();
				String Rev_six = r1.getCell(24, 87).getContents();
				String Rev_comnts = r1.getCell(25, 87).getContents();
				
				String Decisionfile = r1.getCell(26, 87).getContents();
				String Decisioncmnt = r1.getCell(27, 87).getContents();
				String Decision_LOP = r1.getCell(28, 87).getContents();
				
				

				WebElement createproject = GWait.Wait_GetElementByLinkText("Submit New Project");
				createproject.click();

				WebElement projtypdrop = GWait.Wait_GetElementByXpath(".//*[@id='projectsummary']/div/div[1]/div[1]/div/div/button");
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

				WebElement revtypdrop = GWait.Wait_GetElementByXpath("//*[@id='projectsummary']/div/div[2]/div[1]/div/div/button");
				revtypdrop.click();
				Thread.sleep(2000);

				List<WebElement> elementsList2 = revtypvalue;
				for (WebElement a111 : elementsList2) {
					WebElement span = a111.findElement(By.tagName("span"));
					// System.out.println(Review_Type);
					System.out.println(span.getText());
					if (span.getText().equalsIgnoreCase(Review_Type_expedited)) {

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

					}break;

				}

				Thread.sleep(2000);
				((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
				Thread.sleep(10000);
				
				WebElement next_button = GWait.Wait_GetElementById("nextid");
				next_button.click();

					
				WebElement submit_to_IEC =GWait.Wait_GetElementById("submitid");
		     	submit_to_IEC.click();

		     	Thread.sleep(2000);
		     	WebElement no =GWait.Wait_GetElementByXpath("//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[2]");
		     	no.click();
		     	   	
				
		    	WebElement conflictsubmit =GWait.Wait_GetElementByXpath("//*[@id='submit_for_iec_review_confirm']");
				conflictsubmit.click();
				Thread.sleep(6000);
				GlobalMethods.alertaccept();

				Thread.sleep(3000);
				
				WebElement Projectoverview = GWait.Wait_GetElementByCSS(("span.fa.fa-eye"));
				Projectoverview.click();
				

				String conflict_summary_details_1 = conflict_summary_details.getText();
				System.out.println(conflict_summary_details_1);
				Assert.assertEquals(conflict_summary_details.getText().trim(), conflict_summary_if_no);
				
				
				WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
				logoutt.click();
				
				WebElement logo = GWait.Wait_GetElementByCSS("img");
				logo.click();
				
				//--Login as admin and verify the conflict of member names in project overview--//
				GlobalMethods.Admin_Login();
				
				WebElement Dashboard_newsubmission2 = GWait.Wait_GetElementByCSS("span.pull-left");
				Dashboard_newsubmission2.click();
				
				WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
				Projectoverview2.click();
				
				Thread.sleep(2000);
				String conflict_summary_details_admin = conflict_summary_details.getText();
				System.out.println(conflict_summary_details_admin);
				Thread.sleep(4000);
				Assert.assertEquals(conflict_summary_details.getText().trim(), conflict_summary_if_no);
				
				
				WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
				Admin_Review2.click();

				WebElement Processing_fee_yes2 = GWait.Wait_GetElementById("processing_fee_paid");
				Processing_fee_yes2.click();

				WebElement payment_receipt_yes2 = GWait.Wait_GetElementById("payment_receipt");
				payment_receipt_yes2.sendKeys(pyrcnum);

				WebElement hard_copy_yes2 = GWait.Wait_GetElementById("hard_copy_submitted");
				hard_copy_yes2.click();

				WebElement inward_no_yes2 = GWait.Wait_GetElementById("inward_no");
				inward_no_yes2.sendKeys(inwnum);

				WebElement projnum2 = GWait.Wait_GetElementById("project_number");
				projnum2.sendKeys(prjnum);

				WebElement insurdate2 = GWait.Wait_GetElementById("insurance_date");
				insurdate2.sendKeys(insdate);

				WebElement inwdate2 = GWait.Wait_GetElementById("inward_no_date");
				inwdate2.sendKeys(inwrddate);

				WebElement forward_button2 = GWait.Wait_GetElementById("forward_modal_btn");
				forward_button2.click();

				Thread.sleep(6000);
				WebElement ethic_selection2 = GWait.Wait_GetElementById("txn_ethic_committee_id");
				Select select22 = new Select(ethic_selection2);
				select22.selectByVisibleText(ethic_com);


				WebElement ethic_comments2 = GWait.Wait_GetElementByClassName("richText");
				ethic_comments2.sendKeys(ethic_comnts);

				WebElement ethic_frwd2 = GWait.Wait_GetElementById("forward_btn");
				ethic_frwd2.click();

				Thread.sleep(20000);
				GWait.LoadGif();
				WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
				logoutt12.click();
				Thread.sleep(8000);
				WebElement logo12 = GWait.Wait_GetElementByCSS("img");
				logo12.click();
				
				//--Login as MS and verify the conflict of member names in project overview--//

				GlobalMethods.MS_Login();
				
				WebElement exp_dash = GWait.Wait_GetElementByXpath("//li[2]/a/span");
				exp_dash.click();

				WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
				Projectoverview1.click();
				
				Thread.sleep(2000);
				String conflict_summary_details_ms = conflict_summary_details_overview.getText();
				System.out.println(conflict_summary_details_ms);
				Thread.sleep(4000);
				Assert.assertEquals(conflict_summary_details_overview.getText().trim(), conflict_summary_if_no);
				
				
				WebElement asignreviewers = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
				asignreviewers.click();

				WebElement primaryreview_one = GWait.Wait_GetElementById("primary_reviewer");
				Select select1 = new Select(primaryreview_one);
				select1.selectByVisibleText(Rev_one);

				WebElement nonprimaryreview_one = GWait.Wait_GetElementByName("nontech_primary_reviewer1");
				Select select2 = new Select(nonprimaryreview_one);
				select2.selectByVisibleText(Rev_two);

				WebElement primaryreview_two = GWait.Wait_GetElementByName("tech_primary_reviewer2");
				Select select3 = new Select(primaryreview_two);
				select3.selectByVisibleText(Rev_three);

				WebElement nonprimaryreview_two = GWait.Wait_GetElementByName("nontech_primary_reviewer2");
				Select select4 = new Select(nonprimaryreview_two);
				select4.selectByVisibleText(Rev_four);

				WebElement primaryreview_three = GWait.Wait_GetElementByName("tech_primary_reviewer3");
				Select select5 = new Select(primaryreview_three);
				select5.selectByVisibleText(Rev_five);

				WebElement nonprimaryreview_three = GWait.Wait_GetElementByName("nontech_primary_reviewer3");
				Select select6 = new Select(nonprimaryreview_three);
				select6.selectByVisibleText(Rev_six);

				WebElement assign_comments = GWait.Wait_GetElementById("comments");
				assign_comments.clear();

				WebElement assign_comments1 = GWait.Wait_GetElementById("comments");
				assign_comments1.sendKeys(Rev_comnts);

				WebElement frwdtocp_button = GWait.Wait_GetElementById("forward_chairman");
				frwdtocp_button.click();

				WebElement logoutt22 = GWait.Wait_GetElementByXpath("//span/a");
				logoutt22.click();

				WebElement logo821 = GWait.Wait_GetElementByCSS("img");
				logo821.click();
				
				//--Login as CP and verify the conflict of member names in project overview--//
				
				GlobalMethods.CPLogin();
				
				WebElement exp_dash1 = GWait.Wait_GetElementByXpath("//li[2]/a/span");
				exp_dash1.click();

				WebElement Projectoverview11 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
				Projectoverview11.click();
				
				Thread.sleep(2000);
				String conflict_summary_details_cp = conflict_summary_details_overview.getText();
				System.out.println(conflict_summary_details_cp);
				Thread.sleep(4000);
				Assert.assertEquals(conflict_summary_details_overview.getText().trim(), conflict_summary_if_no);
				
				
				WebElement asignreviewers1 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
				asignreviewers1.click();
				
				WebElement submitmsbutton = GWait.Wait_GetElementById("assign1");
				submitmsbutton.click();
				
				WebElement logoutt2111 = GWait.Wait_GetElementByXpath("//span/a");
				logoutt2111.click();

				WebElement logo8111 = GWait.Wait_GetElementByCSS("img");
				logo8111.click();
				
				//--MS gives Letter of Permission to the initial submission--//
				
				GlobalMethods.MS_Login();

				WebElement exp_dash11 = GWait.Wait_GetElementByXpath("//li[2]/a/span");
				exp_dash11.click();

				WebElement Projectoverview111 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
				Projectoverview111.click();

				WebElement asignreviewers11 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
				asignreviewers11.click();
			

				WebElement assign_button = GWait.Wait_GetElementById("assign");
				assign_button.click();

				Thread.sleep(20000);
				GWait.LoadGif();

				GlobalMethods.Commentswindhandler();
				Thread.sleep(8000);
				WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
				iecdecisiontab.click();

				WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
				Select select7 = new Select(decisondropdown);
				select7.selectByVisibleText(Decision_LOP);

				WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
				decisionupload.sendKeys(Decisionfile);

				WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
				assign_comments2.sendKeys(Decisioncmnt);

				WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
				decisionusubmit.click();

				WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
				logoutt2.click();


			}

	//--Check for conflict of interest with no option in subsequent submissions--//
	public void CRe4_2102() throws Exception {
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Projects");


				
		String Document_Title_in_list = r1.getCell(2, 91).getContents();
		String Version_in_list = r1.getCell(3, 91).getContents();
		String Document_Date_in_list = r1.getCell(4, 91).getContents();
		String doc_upload = r1.getCell(5, 91).getContents();

		
				String ethic_com = r1.getCell(6, 91).getContents();
				String ethic_comnts = r1.getCell(7, 91).getContents();
				
				String Rev_one = r1.getCell(8, 91).getContents();
				String Rev_two = r1.getCell(9, 91).getContents();
				String Rev_three = r1.getCell(10, 91).getContents();
				String Rev_four = r1.getCell(11, 91).getContents();
				String Rev_five = r1.getCell(12, 91).getContents();
				String Rev_six = r1.getCell(13, 91).getContents();
				String Rev_comnts = r1.getCell(14, 91).getContents();
				
				String conflict_summary_if_no = r1.getCell(15, 91).getContents();
	
	//--PI login and submits amendment submission--//
	
	GlobalMethods.PI_Login();
	
	WebElement ongoingdash = GWait.Wait_GetElementByXpath("//li[4]/a/span");
	ongoingdash.click();

	WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
	overview.click();

	WebElement submitnewdoc = GWait.Wait_GetElementByLinkText("Submit New Documents");
	submitnewdoc.click();

	WebElement amendlink = GWait.Wait_GetElementByLinkText("Amendment");
	amendlink.click();

	Thread.sleep(6000);
	Thread.sleep(2000);
	System.out.println(docvalue1.size() - 1);

	for (int i = 1; i <= docvalue1.size() - 1; i++) {
		Thread.sleep(10000);
		docdrop1.click();
		String numberAsString = Integer.toString(i);
		Thread.sleep(5000);
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

		}break;

	}

	Thread.sleep(2000);
	((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
	Thread.sleep(10000);

	WebElement next_button = GWait.Wait_GetElementById("nextid");
	next_button.click();

		
	WebElement submit_to_IEC =GWait.Wait_GetElementById("submitid");
 	submit_to_IEC.click();
 	
 	
    Thread.sleep(2000);
 	WebElement no =GWait.Wait_GetElementByXpath("//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[2]");
 	no.click();
 	   	
	
	WebElement conflictsubmit =GWait.Wait_GetElementByXpath("//*[@id='submit_for_iec_review_confirm']");
	conflictsubmit.click();
	Thread.sleep(6000);
	GlobalMethods.alertaccept();

	Thread.sleep(3000);
	
	WebElement Projectoverview = GWait.Wait_GetElementByCSS(("span.fa.fa-eye"));
	Projectoverview.click();
	

	String conflict_summary_details_1 = conflict_summary_details_overview.getText();
	System.out.println(conflict_summary_details_1);
	Assert.assertEquals(conflict_summary_details_overview.getText().trim(), conflict_summary_if_no);
	
	
	WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
	logoutt.click();
	
	WebElement logo = GWait.Wait_GetElementByCSS("img");
	logo.click();
	
    //--Login as admin and verify conflict of interest members--/
	
	GlobalMethods.Admin_Login();

	WebElement approved_amendments = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[6]/a/span");
	approved_amendments.click();

	WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
	Projectoverview2.click();
	
	Thread.sleep(2000);
	String conflict_summary_details_admin = conflict_summary_details_overview.getText();
	System.out.println(conflict_summary_details_admin);
	Thread.sleep(4000);
	Assert.assertEquals(conflict_summary_details_overview.getText().trim(), conflict_summary_if_no);
	
	WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
	Admin_Review2.click();

	WebElement forward_button2 = GWait.Wait_GetElementById("forward_modal_btn");
	forward_button2.click();

	Thread.sleep(6000);
	WebElement ethic_selection2 = GWait.Wait_GetElementById("txn_ethic_committee_id");
	Select select22 = new Select(ethic_selection2);
	select22.selectByVisibleText(ethic_com);


	WebElement ethic_comments2 = GWait.Wait_GetElementByClassName("richText");
	ethic_comments2.sendKeys(ethic_comnts);

	WebElement ethic_frwd2 = GWait.Wait_GetElementById("forward_btn");
	ethic_frwd2.click();

	Thread.sleep(20000);
	GWait.LoadGif();
	WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
	logoutt12.click();
	Thread.sleep(8000);
	WebElement logo12 = GWait.Wait_GetElementByCSS("img");
	logo12.click();
	
	GlobalMethods.MS_Login();
	

	WebElement approved_amendments1 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[6]/a/span");
	approved_amendments1.click();

	WebElement Projectoverview12 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
	Projectoverview12.click();
	
	
	Thread.sleep(2000);
	String conflict_summary_details_ms = conflict_summary_details_overview.getText();
	System.out.println(conflict_summary_details_ms);
	Thread.sleep(4000);
	Assert.assertEquals(conflict_summary_details_overview.getText().trim(), conflict_summary_if_no);

	WebElement asignreviewers = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
	asignreviewers.click();

	WebElement primaryreview_one = GWait.Wait_GetElementById("primary_reviewer");
	Select select1 = new Select(primaryreview_one);
	select1.selectByVisibleText(Rev_one);

	WebElement nonprimaryreview_one = GWait.Wait_GetElementByName("nontech_primary_reviewer1");
	Select select2 = new Select(nonprimaryreview_one);
	select2.selectByVisibleText(Rev_two);

	WebElement primaryreview_two = GWait.Wait_GetElementByName("tech_primary_reviewer2");
	Select select3 = new Select(primaryreview_two);
	select3.selectByVisibleText(Rev_three);

	WebElement nonprimaryreview_two = GWait.Wait_GetElementByName("nontech_primary_reviewer2");
	Select select4 = new Select(nonprimaryreview_two);
	select4.selectByVisibleText(Rev_four);

	WebElement primaryreview_three = GWait.Wait_GetElementByName("tech_primary_reviewer3");
	Select select5 = new Select(primaryreview_three);
	select5.selectByVisibleText(Rev_five);

	WebElement nonprimaryreview_three = GWait.Wait_GetElementByName("nontech_primary_reviewer3");
	Select select6 = new Select(nonprimaryreview_three);
	select6.selectByVisibleText(Rev_six);

	WebElement assign_comments = GWait.Wait_GetElementById("comments");
	assign_comments.clear();

	WebElement assign_comments1 = GWait.Wait_GetElementById("comments");
	assign_comments1.sendKeys(Rev_comnts);

	WebElement frwdtocp_button = GWait.Wait_GetElementById("forward_chairman");
	frwdtocp_button.click();


	WebElement logoutt22 = GWait.Wait_GetElementByXpath("//span/a");
	logoutt22.click();

	WebElement logo821 = GWait.Wait_GetElementByCSS("img");
	logo821.click();
	
	GlobalMethods.CPLogin();
	
	WebElement approved_amendments11 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[6]/a/span");
	approved_amendments11.click();

	WebElement Projectoverview112 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
	Projectoverview112.click();
	
	
	Thread.sleep(2000);
	String conflict_summary_details_cp = conflict_summary_details_overview.getText();
	System.out.println(conflict_summary_details_cp);
	Thread.sleep(4000);
	Assert.assertEquals(conflict_summary_details_overview.getText().trim(), conflict_summary_if_no);
	
	
	WebElement asignreviewers1 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
	asignreviewers1.click();
	
	WebElement submitmsbutton = GWait.Wait_GetElementById("assign1");
	submitmsbutton.click();
	
	WebElement logoutt211 = GWait.Wait_GetElementByXpath("//span/a");
	logoutt211.click();

	WebElement logo8111 = GWait.Wait_GetElementByCSS("img");
	logo8111.click();
		
		
	}



}
