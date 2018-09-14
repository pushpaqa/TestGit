package com.create4.scenarios;

import java.io.FileInputStream;
import java.util.List;

import org.openqa.selenium.By;
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

//Check for 'Link to download template' feature in project submit new document

public class TS_174 {

	public TS_174() {
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
	
	//annexure form elements
	
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
	
	//annexure form add elements
	
	@FindBy(id = "add_annexure_document_type")
	WebElement annexure_document_type;
	
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

	// Check for 'Link to download template' feature display
	//Check for 'Link to download template' link functionality
	//Check for save of download template
	//Check for open of download template
	public void CRe4_2021_2022_2023_2024() throws Exception {


		GlobalMethods.Admin_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Projects");
	
		String Project_Full_Title = r1.getCell(2, 1).getContents();
		String Project_Short_Title = r1.getCell(3, 1).getContents();
		String Sponsor = r1.getCell(4, 1).getContents();
		
		String Project_Type = r1.getCell(5, 1).getContents();
		String Review_Type = r1.getCell(6, 1).getContents();
		String sub_initial = r1.getCell(7, 1).getContents();
		String document_types = r1.getCell(8, 1).getContents();
		String document_upload = r1.getCell(9, 1).getContents();
		
		String annexure_acknowledgement = r1.getCell(10, 1).getContents();
		String annexure_status = r1.getCell(11, 1).getContents();
		

		
		WebElement manageiec =GWait.Wait_GetElementByLinkText("Manage IEC");
		manageiec.click();
		
		
		WebElement managedoctype =GWait.Wait_GetElementByLinkText("Manage Document Type");
		managedoctype.click();
		
		
		WebElement adddoctype =GWait.Wait_GetElementByLinkText("Add Document Type");
		adddoctype.click();
		
		
		WebElement projdoc1 =GWait.Wait_GetElementById("add_annexure_project_type");

		Select select8 = new Select(projdoc1);
		select8.selectByVisibleText(Project_Type);
		
		
		WebElement revtype1 =GWait.Wait_GetElementById("add_annexure_review_type");
		Select select9 = new Select(revtype1);
		select9.selectByVisibleText(Review_Type);
		
		
		WebElement subtype1 =GWait.Wait_GetElementById("add_annexure_submission_type");

		Select select10 = new Select(subtype1);
		select10.selectByVisibleText(sub_initial);
		
		
		WebElement documenttype1 = GWait.Wait_GetElementById("add_annexure_document_type");
		documenttype1.sendKeys(document_types);

		
		WebElement doctype_submit =GWait.Wait_GetElementById("add_edit_annexure_details");
		doctype_submit.click();
		
		
		
		WebElement admin_menu_IEC_Submission_Forms_Annexures =GWait.Wait_GetElementByLinkText("IEC Submission Forms / Annexures");
		admin_menu_IEC_Submission_Forms_Annexures.click();

		
		WebElement add_annexure_link =GWait.Wait_GetElementByLinkText("Add IEC Submission Form / Annexure");
		add_annexure_link.click();
		
	
		WebElement docdrop_proj =GWait.Wait_GetElementByXpath("//*[@id='addannexures']/div[1]/div/div/div/button");
		docdrop_proj.click();
		Thread.sleep(2000);

		List<WebElement> elementsList11 = docvalue_proj;
		for (WebElement a11 : elementsList11) {
			WebElement span = a11.findElement(By.tagName("span"));
			if (span.getText().equalsIgnoreCase(Project_Type)) {
				span.click();
				break;
			}
		}

		
		WebElement docdrop_rev =GWait.Wait_GetElementByXpath("//*[@id='addannexures']/div[2]/div/div/div/button");
		docdrop_rev.click();
		Thread.sleep(1000);

		List<WebElement> elementsList2 = docvalue_rev;
		for (WebElement a111 : elementsList2) {
			WebElement span = a111.findElement(By.tagName("span"));
			// System.out.println(Review_Type);
			// System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(Review_Type)) {
				Thread.sleep(2000);
				span.click();
				break;
			}
		}


		WebElement docdrop_sub = GWait.Wait_GetElementByXpath("//*[@id='addannexures']/div[3]/div/div/div/button");
		docdrop_sub.click();
		Thread.sleep(1000);

		List<WebElement> elementsList2a = docvalue_sub;
		for (WebElement a111 : elementsList2a) {
			WebElement span = a111.findElement(By.tagName("span"));
			// System.out.println(Review_Type);
			// System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(sub_initial)) {
				Thread.sleep(2000);
				span.click();
				break;
			}
		}
		
		WebElement annexure_document_type =GWait.Wait_GetElementById("add_annexure_document_type");
		Select select_4 = new Select(annexure_document_type);
		select_4.selectByVisibleText(document_types);
		
		WebElement add_annexure_document_upload = GWait.Wait_GetElementByXpath("//*[@id='add_annexure_document_upload']");
		add_annexure_document_upload.sendKeys(document_upload);

		WebElement doctype_submit1 = GWait.Wait_GetElementById("add_edit_annexure_details");
    	doctype_submit1.click();
		
    	Assert.assertEquals(add_annexure_acknowledge.getText(), annexure_acknowledgement);
		System.out.println(add_annexure_acknowledge.getText());

		

		WebElement add_annexure_publish = GWait.Wait_GetElementByLinkText("Publish");
		add_annexure_publish.click();
Thread.sleep(1000);
		Assert.assertEquals(add_annexure_acknowledge.getText(), annexure_status);
		System.out.println(add_annexure_acknowledge.getText());
		
		
		
		
		WebElement projectslink =GWait.Wait_GetElementByLinkText("Projects");
		projectslink.click();
		
		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();
		
		
		WebElement logo2 = GWait.Wait_GetElementByCSS("img");
		logo2.click();

		GlobalMethods.PI_Login();

		WebElement createproject = GWait.Wait_GetElementByLinkText("Submit New Project");
		createproject.click();

		WebElement projtypdrop = GWait
				.Wait_GetElementByXpath(".//*[@id='projectsummary']/div/div[1]/div[1]/div/div/button");
		projtypdrop.click();
		Thread.sleep(2000);

		List<WebElement> elementsList11_1 = projtypvalue;
		for (WebElement a11 : elementsList11_1) {
			WebElement span = a11.findElement(By.tagName("span"));
			if (span.getText().equalsIgnoreCase(Project_Type)) {
				span.click();
				break;
			}
		}

		WebElement revtypdrop = GWait
				.Wait_GetElementByXpath("//*[@id='projectsummary']/div/div[2]/div[1]/div/div/button");
		revtypdrop.click();
		Thread.sleep(1000);

		List<WebElement> elementsList2_2 = revtypvalue;
		for (WebElement a111 : elementsList2_2) {
			WebElement span = a111.findElement(By.tagName("span"));
			// System.out.println(Review_Type);
			// System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(Review_Type)) {
				Thread.sleep(2000);
				span.click();
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

		

	
		Thread.sleep(3000);
		docdrop.click();
		Thread.sleep(1000);

		
		List<WebElement> elementsList4 = docvalue;
		for (WebElement a11 : elementsList4) {
			WebElement span = a11.findElement(By.tagName("span"));

			if (span.getText().equalsIgnoreCase(document_types)) {
				Thread.sleep(2000);
				span.click();
				break;
			} else {
				System.out.println(
						"Value is does not exist & added document type is not listing in amendment document type drop down");
			}
		}

		
		WebElement add_annexure_download =GWait.Wait_GetElementByLinkText("Download the template form");
		add_annexure_download.click();

		
		
		GlobalMethods.AcceptDoenloadPopup();

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();

	}


}
