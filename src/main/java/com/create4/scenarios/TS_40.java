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

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

/*
 * Check for PI project column headings and and respective table details.
 */
public class TS_40 {

	public TS_40() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

    GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
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

	@FindBy(css = "li.active > a")
	WebElement dash;

	@FindBy(xpath = "//li[4]/a/span")
	WebElement Ongoingprojects;

	@FindBy(xpath = "//li[4]/a/span")
	WebElement query_reply_admin_dashboard;

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

	@FindBy(xpath = "//div[2]/div/div/ul/li[3]/a/span")
	WebElement completion_dashboard;

	@FindBy(xpath = "//th[3]/a/span[2]")
	WebElement pro_num;

	@FindBy(xpath = "//th[4]/a/span[2]")
	WebElement pro_tit;

	@FindBy(xpath = "//th[5]/a/span[2]")
	WebElement pro_sta;

	@FindBy(xpath = "//th[6]/a/span[2]")
	WebElement lat_sub;

	@FindBy(xpath = "//th[7]/a/span[2]")
	WebElement lat_sub_dat;

	@FindBy(xpath = "//th[8]/a/span[2]")
	WebElement doc_sta;

	@FindBy(xpath = "//th[9]/span")
	WebElement act;

	@FindBy(xpath = "//span/a")
	WebElement logoutt;

	@FindBy(css = "img")
	WebElement logo;

	@FindBy(linkText = "My Projects")
	WebElement PI_project_menu;

	@FindBy(id = "nextidedit")
	WebElement nextbutton2;

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

	@FindBy(id = "sumsave")
	WebElement save_button3;

	@FindBy(linkText = "Projects")
	WebElement MS_project_menu;

	// sussequent doctype upload

	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/button")
	public WebElement docdrop1;
	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/div/ul/li")
	public static List<WebElement> docvalue1;

	@FindBy(xpath = "//*[@id='respondqueryupload']/div/div[1]/div[1]/div/div/button")
	public WebElement docdrop2;
	@FindBy(xpath = "//*[@id='respondqueryupload']/div/div[1]/div[1]/div/div/div/ul/li")
	public static List<WebElement> docvalue2;

	@FindBy(linkText = "Resubmission")
	WebElement resubmission_edit;

	// Check for Project list details
	public void CRe4_1205_1206_1207_1208_1209() throws Exception {

		

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Projects");

		// Project summary data

		String Project_Type = r1.getCell(2, 29).getContents();
		String Review_Type_fullboard = r1.getCell(3, 29).getContents();
		String Project_Full_Title = r1.getCell(4, 29).getContents();
		String Project_Short_Title = r1.getCell(5, 29).getContents();
		String Sponsor = r1.getCell(6, 29).getContents();

		// Document upload data
		String Document_Title_in_list = r1.getCell(7, 29).getContents();
		String Version_in_list = r1.getCell(8, 29).getContents();
		String Document_Date_in_list = r1.getCell(9, 29).getContents();
		String doc_upload = r1.getCell(10, 29).getContents();

		// Admin data
		String pyrcnum = r1.getCell(11, 29).getContents();
		String inwnum = r1.getCell(12, 29).getContents();
		String prjnum = r1.getCell(13, 29).getContents();
		String insdate = r1.getCell(14, 29).getContents();
		String inwrddate = r1.getCell(15, 29).getContents();
		String ethic_com = r1.getCell(16, 29).getContents();
		String ethic_comnts = r1.getCell(17, 29).getContents();

		// MS data
		String Rev_one = r1.getCell(18, 29).getContents();
		String Rev_two = r1.getCell(19, 29).getContents();
		String Rev_three = r1.getCell(20, 29).getContents();
		String Rev_four = r1.getCell(21, 29).getContents();
		String Rev_five = r1.getCell(22, 29).getContents();
		String Rev_six = r1.getCell(23, 29).getContents();
		String Rev_comnts = r1.getCell(24, 29).getContents();

		// Decision upload data
		String Decision_LOP = r1.getCell(25, 29).getContents();
		String Decisionfile = r1.getCell(26, 29).getContents();
		String Decisioncmnt = r1.getCell(27, 29).getContents();

		String Decision_resubmission = r1.getCell(28, 29).getContents();
		String Decision_query_fb = r1.getCell(29, 29).getContents();
		String Decision_query_ms = r1.getCell(30, 29).getContents();
		String Decision_query_rev = r1.getCell(31, 29).getContents();
		String Decision_prov = r1.getCell(32, 29).getContents();

		String Project_Number = r1.getCell(33, 29).getContents();
		String Project_Title = r1.getCell(34, 29).getContents();
		String Project_Status = r1.getCell(35, 29).getContents();
		String Latest_Submission = r1.getCell(36, 29).getContents();
		String Latest_Submission_Date = r1.getCell(37, 29).getContents();
		String Document_Status = r1.getCell(38, 29).getContents();
		String Actions = r1.getCell(39, 29).getContents();
		
	   GlobalMethods.PI_Login();

		WebElement PI_project_menu = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu.click();

		String pro_num1 = pro_num.getText();
		Assert.assertEquals(Project_Number, pro_num1);
		System.out.println(pro_num1);
		System.out.println(Project_Number);

		String pro_tit1 = pro_tit.getText();
		Assert.assertEquals(Project_Title, pro_tit1);
		System.out.println(pro_tit1);
		System.out.println(Project_Title);

		String pro_sta1 = pro_sta.getText();
		Assert.assertEquals(Project_Status, pro_sta1);
		System.out.println(pro_sta1);
		System.out.println(Project_Status);

		String lat_sub1 = lat_sub.getText();
		Assert.assertEquals(Latest_Submission, lat_sub1);
		System.out.println(lat_sub1);
		System.out.println(Latest_Submission);

		String lat_sub_dat1 = lat_sub_dat.getText();
		Assert.assertEquals(Latest_Submission_Date, lat_sub_dat1);
		System.out.println(lat_sub_dat1);
		System.out.println(Latest_Submission_Date);

		String doc_sta1 = doc_sta.getText();
		Assert.assertEquals(Document_Status, doc_sta1);
		System.out.println(doc_sta1);
		System.out.println(Document_Status);

		String act1 = act.getText();
		Assert.assertEquals(Actions, act1);
		System.out.println(act1);
		System.out.println(Actions);

		// Saving project summary

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
			if (span.getText().equalsIgnoreCase(Review_Type_fullboard)) {

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
		int count = docvalue.size();

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

			
		WebElement submit_to_IEC =GWait.Wait_GetElementById("submitid");
     	submit_to_IEC.click();
		
		Thread.sleep(2000);
		WebElement no = GWait.Wait_GetElementByXpath("//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[2]"); 
		no.click();
			
		Thread.sleep(1000);
		WebElement conflictsubmit1 = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		conflictsubmit1.click();
		
		Thread.sleep(3000);
		GlobalMethods.alertaccept();
		
		Thread.sleep(3000);
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();

		GlobalMethods.Admin_Login();
	
		WebElement Dashboard_newsubmission = GWait.Wait_GetElementByCSS("span.pull-left");
		Dashboard_newsubmission.click();
				
		WebElement Projectoverview = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview.click();

		
		WebElement Admin_Review = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review.click();
		
		
		WebElement Processing_fee_yes = GWait.Wait_GetElementById("processing_fee_paid");
		Processing_fee_yes.click();
		
		
		WebElement payment_receipt_yes = GWait.Wait_GetElementById("payment_receipt");
		payment_receipt_yes.sendKeys(pyrcnum);
		
				
		WebElement hard_copy_yes = GWait.Wait_GetElementById("hard_copy_submitted");
		hard_copy_yes.click();

		
		WebElement inward_no_yes = GWait.Wait_GetElementById("inward_no");
		inward_no_yes.sendKeys(inwnum);

		
		WebElement projnum = GWait.Wait_GetElementById("project_number");
		projnum.sendKeys(prjnum);

		
		WebElement insurdate = GWait.Wait_GetElementById("insurance_date");
		insurdate.sendKeys(insdate);

		
		WebElement inwdate = GWait.Wait_GetElementById("inward_no_date");
		inwdate.sendKeys(inwrddate);
		
		
		WebElement forward_button = GWait.Wait_GetElementById("forward_modal_btn");
		forward_button.click();
		
		Thread.sleep(2000);
		WebElement ethic_selection = GWait.Wait_GetElementById("txn_ethic_committee_id");
		Select select = new Select(ethic_selection);
		select.selectByVisibleText(ethic_com);

						
		//WebElement forward_button = GWait.Wait_GetElementById("forward_modal_btn");
		//forward_button.click();
		
		WebElement ethic_comments = GWait.Wait_GetElementByClassName("richText");
		ethic_comments.sendKeys(ethic_comnts);

				
		WebElement ethic_frwd = GWait.Wait_GetElementById("forward_btn");
		ethic_frwd.click();

		Thread.sleep(8000);
		WebElement logoutt1 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt1.click();
		
		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();

		// MS assign reviewers & giving decision

		GlobalMethods.MS_Login();

		
		WebElement projectslink = GWait.Wait_GetElementByLinkText("Projects");
		projectslink.click();

	
		WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview1.click();
		
		
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
		
		
		WebElement nonprimaryreview_two =GWait.Wait_GetElementByName("nontech_primary_reviewer2");
		Select select4 = new Select(nonprimaryreview_two);
		select4.selectByVisibleText(Rev_four);
		
		
		WebElement primaryreview_three =GWait.Wait_GetElementByName("tech_primary_reviewer3");
		Select select5 = new Select(primaryreview_three);
		select5.selectByVisibleText(Rev_five);
		
		
		WebElement nonprimaryreview_three =GWait.Wait_GetElementByName("nontech_primary_reviewer3");
		Select select6 = new Select(nonprimaryreview_three);
		select6.selectByVisibleText(Rev_six);
		
				
		WebElement assign_comments =GWait.Wait_GetElementById("comments");
		assign_comments.clear();
		
		WebElement assign_comments1 =GWait.Wait_GetElementById("comments");
		assign_comments1.sendKeys(Rev_comnts);

			
		WebElement assign_button =GWait.Wait_GetElementById("assign");
		assign_button.click();

		Thread.sleep(8000);

        GlobalMethods.Commentswindhandler();
	
						
		WebElement iecdecisiontab =GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab.click();

		
		WebElement decisondropdown =GWait.Wait_GetElementById("decision_type");
		Select select7 = new Select(decisondropdown);
		select7.selectByVisibleText(Decision_query_fb);

		
		WebElement decisionupload =GWait.Wait_GetElementById("proj_document");
		decisionupload.sendKeys(Decisionfile);

		
		WebElement assign_comments2 =GWait.Wait_GetElementById("comments");
		assign_comments2.sendKeys(Decisioncmnt);

				
		WebElement decisionusubmit =GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit.click();

		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();
		
		WebElement logo2 = GWait.Wait_GetElementByCSS("img");
		logo2.click();

		GlobalMethods.PI_Login();
	
	
		WebElement query_reply_dashboard = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		query_reply_dashboard.click();
		
		
		WebElement overview =GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();

		
		WebElement query_tab =GWait.Wait_GetElementByXpath("//div[3]/ul/li[4]/a");
		query_tab.click();

		
		WebElement query_tab_edit = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		query_tab_edit.click();
		
		
		WebElement query_comments = GWait.Wait_GetElementById("query_comments");
		query_comments.sendKeys(Decisioncmnt);
		
		
		WebElement save_button3 =GWait.Wait_GetElementById("sumsave");
		save_button3.click();
		
		Thread.sleep(4000);
		System.out.println(docvalue2.size() - 1);
		for (int i = count ; i <= docvalue2.size() - 1; i++) {
			Thread.sleep(8000);
			
			docdrop2.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
			List<WebElement> elementsList = docvalue2;
			int j = 0;
			for (WebElement a11 : elementsList) {
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
		
		WebElement query_submit_button =GWait.Wait_GetElementById("querysubmit");
		query_submit_button.click();
		

		WebElement logoutt3 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt3.click();
		
		WebElement logo3 = GWait.Wait_GetElementByCSS("img");
		logo3.click();

		// Login as admin

		GlobalMethods.Admin_Login();

		
		WebElement query_reply_admin_dashboard =GWait.Wait_GetElementByXpath("//li[4]/a/span");
		query_reply_admin_dashboard.click();

		WebElement overview1 =GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview1.click();

		WebElement Admin_Review1 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review1.click();

		WebElement forward_button1 = GWait.Wait_GetElementById("forward_modal_btn");
		forward_button1.click();

		WebElement ethic_selection1 = GWait.Wait_GetElementById("txn_ethic_committee_id");
		Select select11 = new Select(ethic_selection1);
		select11.selectByVisibleText(ethic_com);

						
		//WebElement forward_button = GWait.Wait_GetElementById("forward_modal_btn");
		//forward_button.click();
		Thread.sleep(4000);
		WebElement ethic_comments1 = GWait.Wait_GetElementByClassName("richText");
		ethic_comments1.sendKeys(ethic_comnts);

				
		WebElement ethic_frwd1 = GWait.Wait_GetElementById("forward_btn");
		ethic_frwd1.click();
		Thread.sleep(8000);
		WebElement logoutt4 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt4.click();
		
		WebElement logo4 = GWait.Wait_GetElementByCSS("img");
		logo4.click();


		
		GlobalMethods.MS_Login();

		WebElement query_reply_admin_dashboard1 =GWait.Wait_GetElementByXpath("//li[4]/a/span");
		query_reply_admin_dashboard1.click();

		
		WebElement Projectoverview11 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview11.click();
		Thread.sleep(8000);

		GlobalMethods.Commentswindhandler();

		WebElement iecdecisiontab1 =GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab1.click();

		
		WebElement decisondropdown1 =GWait.Wait_GetElementById("decision_type");
		Select select71 = new Select(decisondropdown1);
		select71.selectByVisibleText(Decision_LOP);

		
		WebElement decisionupload1 =GWait.Wait_GetElementById("proj_document");
		decisionupload1.sendKeys(Decisionfile);

		
		WebElement assign_comments3 =GWait.Wait_GetElementById("comments");
		assign_comments3.sendKeys(Decisioncmnt);

				
		WebElement decisionusubmit1 =GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit1.click();
		Thread.sleep(8000);
		WebElement logoutt5 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt5.click();
		Thread.sleep(8000);
		WebElement logo5 = GWait.Wait_GetElementByCSS("img");
		logo5.click();

	
		GlobalMethods.PI_Login();

		WebElement createproject1 = GWait.Wait_GetElementByLinkText("Submit New Project");
		createproject1.click();

		WebElement projtypdrop1 = GWait
				.Wait_GetElementByXpath(".//*[@id='projectsummary']/div/div[1]/div[1]/div/div/button");
		projtypdrop1.click();
		Thread.sleep(2000);

		List<WebElement> elementsList111 = projtypvalue;
		for (WebElement a11 : elementsList111) {
			WebElement span = a11.findElement(By.tagName("span"));
			if (span.getText().equalsIgnoreCase(Project_Type)) {
				span.click();
				break;
			}
		}

		WebElement revtypdrop1 = GWait
				.Wait_GetElementByXpath("//*[@id='projectsummary']/div/div[2]/div[1]/div/div/button");
		revtypdrop1.click();
		Thread.sleep(2000);

		List<WebElement> elementsList21 = revtypvalue;
		for (WebElement a111 : elementsList21) {
			WebElement span = a111.findElement(By.tagName("span"));
			// System.out.println(Review_Type);
			System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(Review_Type_fullboard)) {

				span.click();
				String text = span.getText();
				System.out.println(text);
				break;
			}
		}

		WebElement Full_title1 = GWait.Wait_GetElementById("projecttitle");
		Full_title1.sendKeys(Project_Full_Title);

		WebElement short_title1 = GWait.Wait_GetElementById("projectshorttitle");
		short_title1.sendKeys(Project_Short_Title);

		WebElement sponsor1 = GWait.Wait_GetElementById("project_description");
		sponsor1.sendKeys(Sponsor);

		WebElement save_button11 = GWait.Wait_GetElementByXpath("//*[@id='sumsave']");
		save_button11.click();

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

		WebElement next_button1 = GWait.Wait_GetElementById("nextid");
		next_button1.click();

			
		WebElement submit_to_IEC1 =GWait.Wait_GetElementById("submitid");
     	submit_to_IEC1.click();
		
		Thread.sleep(2000);
		WebElement no1 = GWait.Wait_GetElementByXpath("//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[2]"); 
		no1.click();
		
		Thread.sleep(1000);
		WebElement conflictsubmit2 = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		conflictsubmit2.click();
		
		Thread.sleep(3000);
		GlobalMethods.alertaccept();
		Thread.sleep(4000);
		WebElement logoutt11 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt11.click();
		
		WebElement logo11 = GWait.Wait_GetElementByCSS("img");
		logo11.click();


		// Login as admin
		Thread.sleep(2000);
		GlobalMethods.Admin_Login();

		WebElement Dashboard_newsubmission1 = GWait.Wait_GetElementByCSS("span.pull-left");
		Dashboard_newsubmission1.click();
				
		WebElement Projectoverview111 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview111.click();

		
		WebElement Admin_Review11 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review11.click();
		
		
		WebElement Processing_fee_yes1 = GWait.Wait_GetElementById("processing_fee_paid");
		Processing_fee_yes1.click();
		
		
		WebElement payment_receipt_yes1 = GWait.Wait_GetElementById("payment_receipt");
		payment_receipt_yes1.sendKeys(pyrcnum);
		
				
		WebElement hard_copy_yes1 = GWait.Wait_GetElementById("hard_copy_submitted");
		hard_copy_yes1.click();

		
		WebElement inward_no_yes1 = GWait.Wait_GetElementById("inward_no");
		inward_no_yes1.sendKeys(inwnum);

		
		WebElement projnum1 = GWait.Wait_GetElementById("project_number");
		projnum1.sendKeys(prjnum);

		
		WebElement insurdate1 = GWait.Wait_GetElementById("insurance_date");
		insurdate1.sendKeys(insdate);

		
		WebElement inwdate1 = GWait.Wait_GetElementById("inward_no_date");
		inwdate1.sendKeys(inwrddate);
		
		
		WebElement forward_button11 = GWait.Wait_GetElementById("forward_modal_btn");
		forward_button11.click();
		
		Thread.sleep(4000);
		WebElement ethic_selection11 = GWait.Wait_GetElementById("txn_ethic_committee_id");
		Select select111 = new Select(ethic_selection11);
		select111.selectByVisibleText(ethic_com);

						
		//WebElement forward_button = GWait.Wait_GetElementById("forward_modal_btn");
		//forward_button.click();
		Thread.sleep(4000);
		WebElement ethic_comments11 = GWait.Wait_GetElementByClassName("richText");
		ethic_comments11.sendKeys(ethic_comnts);

				
		WebElement ethic_frwd11 = GWait.Wait_GetElementById("forward_btn");
		ethic_frwd11.click();
		Thread.sleep(8000);
		WebElement logoutt111 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt111.click();
		
		WebElement logo111 = GWait.Wait_GetElementByCSS("img");
		logo111.click();
		// MS assign reviewers & giving decision

		GlobalMethods.MS_Login();

		WebElement projectslink1 = GWait.Wait_GetElementByLinkText("Projects");
		projectslink1.click();

	
		WebElement Projectoverview1111 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview1111.click();
		
		
		WebElement asignreviewers1 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers1.click();

		
		WebElement primaryreview_one1 = GWait.Wait_GetElementById("primary_reviewer");
		Select select1111 = new Select(primaryreview_one1);
		select1111.selectByVisibleText(Rev_one);
				
		WebElement nonprimaryreview_one1 = GWait.Wait_GetElementByName("nontech_primary_reviewer1");
		Select select21 = new Select(nonprimaryreview_one1);
		select21.selectByVisibleText(Rev_two);
			
		
		WebElement primaryreview_two1 = GWait.Wait_GetElementByName("tech_primary_reviewer2");
		Select select31 = new Select(primaryreview_two1);
		select31.selectByVisibleText(Rev_three);
		
		
		WebElement nonprimaryreview_two1 =GWait.Wait_GetElementByName("nontech_primary_reviewer2");
		Select select41 = new Select(nonprimaryreview_two1);
		select41.selectByVisibleText(Rev_four);
		
		
		WebElement primaryreview_three1 =GWait.Wait_GetElementByName("tech_primary_reviewer3");
		Select select51 = new Select(primaryreview_three1);
		select51.selectByVisibleText(Rev_five);
		
		
		WebElement nonprimaryreview_three1 =GWait.Wait_GetElementByName("nontech_primary_reviewer3");
		Select select61 = new Select(nonprimaryreview_three1);
		select61.selectByVisibleText(Rev_six);
		
				
		WebElement assign_comments11 =GWait.Wait_GetElementById("comments");
		assign_comments11.clear();
		
		WebElement assign_comments111 =GWait.Wait_GetElementById("comments");
		assign_comments111.sendKeys(Rev_comnts);

			
		WebElement assign_button1 =GWait.Wait_GetElementById("assign");
		assign_button1.click();

		Thread.sleep(8000);

        GlobalMethods.Commentswindhandler();
	
						
		WebElement iecdecisiontab11 =GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab11.click();

		
		WebElement decisondropdown11 =GWait.Wait_GetElementById("decision_type");
		Select select711 = new Select(decisondropdown11);
		select711.selectByVisibleText(Decision_resubmission);

		
		WebElement decisionupload11 =GWait.Wait_GetElementById("proj_document");
		decisionupload11.sendKeys(Decisionfile);

		
		WebElement assign_comments21 =GWait.Wait_GetElementById("comments");
		assign_comments21.sendKeys(Decisioncmnt);

				
		WebElement decisionusubmit11 =GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit11.click();

		WebElement logoutt21 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt21.click();
		
		WebElement logo21 = GWait.Wait_GetElementByCSS("img");
		logo21.click();
		
		
		GlobalMethods.PI_Login();

		WebElement createproject11 = GWait.Wait_GetElementByLinkText("Submit New Project");
		createproject11.click();

		WebElement projtypdrop11 = GWait
				.Wait_GetElementByXpath(".//*[@id='projectsummary']/div/div[1]/div[1]/div/div/button");
		projtypdrop11.click();
		Thread.sleep(2000);

		List<WebElement> elementsList1111 = projtypvalue;
		for (WebElement a11 : elementsList1111) {
			WebElement span = a11.findElement(By.tagName("span"));
			if (span.getText().equalsIgnoreCase(Project_Type)) {
				span.click();
				break;
			}
		}

		WebElement revtypdrop11 = GWait
				.Wait_GetElementByXpath("//*[@id='projectsummary']/div/div[2]/div[1]/div/div/button");
		revtypdrop11.click();
		Thread.sleep(2000);

		List<WebElement> elementsList211 = revtypvalue;
		for (WebElement a111 : elementsList211) {
			WebElement span = a111.findElement(By.tagName("span"));
			// System.out.println(Review_Type);
			System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(Review_Type_fullboard)) {

				span.click();
				String text = span.getText();
				System.out.println(text);
				break;
			}
		}

		WebElement Full_title11 = GWait.Wait_GetElementById("projecttitle");
		Full_title11.sendKeys(Project_Full_Title);

		WebElement short_title11 = GWait.Wait_GetElementById("projectshorttitle");
		short_title11.sendKeys(Project_Short_Title);

		WebElement sponsor11 = GWait.Wait_GetElementById("project_description");
		sponsor11.sendKeys(Sponsor);

		WebElement save_button111 = GWait.Wait_GetElementByXpath("//*[@id='sumsave']");
		save_button111.click();

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
				Thread.sleep(1000);
				doc_title.sendKeys(Document_Title_in_list);
				doc_version.sendKeys(Version_in_list);
				doc_date.sendKeys(Document_Date_in_list);
				Thread.sleep(1000);
				upload_doc.sendKeys(doc_upload);
				Thread.sleep(8000);

				save_button2.click();
				Thread.sleep(4000);

			}

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(10000);

		WebElement next_button11 = GWait.Wait_GetElementById("nextid");
		next_button11.click();

			
		WebElement submit_to_IEC11 =GWait.Wait_GetElementById("submitid");
     	submit_to_IEC11.click();
		
     	Thread.sleep(3000);
		WebElement no11 = GWait.Wait_GetElementByXpath("//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[2]"); 
		no11.click();
		Thread.sleep(3000);
		WebElement conflictsubmit11 = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		conflictsubmit11.click();
		Thread.sleep(3000);
		GlobalMethods.alertaccept();
		Thread.sleep(3000);
		WebElement logoutt1111 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt1111.click();
		Thread.sleep(3000);
		WebElement logo1111 = GWait.Wait_GetElementByCSS("img");
		logo1111.click();


		// Login as admin
		Thread.sleep(2000);
		GlobalMethods.Admin_Login();

		WebElement Dashboard_newsubmission11 = GWait.Wait_GetElementByCSS("span.pull-left");
		Dashboard_newsubmission11.click();
				
		WebElement Projectoverview11111 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview11111.click();

		
		WebElement Admin_Review111 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review111.click();
		
		
		WebElement Processing_fee_yes11 = GWait.Wait_GetElementById("processing_fee_paid");
		Processing_fee_yes11.click();
		
		
		WebElement payment_receipt_yes11 = GWait.Wait_GetElementById("payment_receipt");
		payment_receipt_yes11.sendKeys(pyrcnum);
		
				
		WebElement hard_copy_yes11 = GWait.Wait_GetElementById("hard_copy_submitted");
		hard_copy_yes11.click();

		
		WebElement inward_no_yes11 = GWait.Wait_GetElementById("inward_no");
		inward_no_yes11.sendKeys(inwnum);

		
		WebElement projnum11 = GWait.Wait_GetElementById("project_number");
		projnum11.sendKeys(prjnum);

		
		WebElement insurdate11 = GWait.Wait_GetElementById("insurance_date");
		insurdate11.sendKeys(insdate);

		
		WebElement inwdate11 = GWait.Wait_GetElementById("inward_no_date");
		inwdate11.sendKeys(inwrddate);
		
		
		WebElement forward_button111 = GWait.Wait_GetElementById("forward_modal_btn");
		forward_button111.click();
		
		
		WebElement ethic_selection111 = GWait.Wait_GetElementById("txn_ethic_committee_id");
		Select select11111 = new Select(ethic_selection111);
		select11111.selectByVisibleText(ethic_com);

						
		//WebElement forward_button = GWait.Wait_GetElementById("forward_modal_btn");
		//forward_button.click();
		Thread.sleep(4000);
		WebElement ethic_comments111 = GWait.Wait_GetElementByClassName("richText");
		ethic_comments111.sendKeys(ethic_comnts);

				
		WebElement ethic_frwd111 = GWait.Wait_GetElementById("forward_btn");
		ethic_frwd111.click();
		Thread.sleep(8000);
		WebElement logoutt11111 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt11111.click();
		
		WebElement logo11111 = GWait.Wait_GetElementByCSS("img");
		logo11111.click();
		// MS assign reviewers & giving decision

		GlobalMethods.MS_Login();

		WebElement projectslink11 = GWait.Wait_GetElementByLinkText("Projects");
		projectslink11.click();

	
		WebElement Projectoverview111111 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview111111.click();
		
		
		WebElement asignreviewers11 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers11.click();

		
		WebElement primaryreview_one11 = GWait.Wait_GetElementById("primary_reviewer");
		Select select111111 = new Select(primaryreview_one11);
		select111111.selectByVisibleText(Rev_one);
				
		WebElement nonprimaryreview_one11 = GWait.Wait_GetElementByName("nontech_primary_reviewer1");
		Select select211 = new Select(nonprimaryreview_one11);
		select211.selectByVisibleText(Rev_two);
			
		
		WebElement primaryreview_two11 = GWait.Wait_GetElementByName("tech_primary_reviewer2");
		Select select311 = new Select(primaryreview_two11);
		select311.selectByVisibleText(Rev_three);
		
		
		WebElement nonprimaryreview_two11 =GWait.Wait_GetElementByName("nontech_primary_reviewer2");
		Select select411 = new Select(nonprimaryreview_two11);
		select411.selectByVisibleText(Rev_four);
		
		
		WebElement primaryreview_three11 =GWait.Wait_GetElementByName("tech_primary_reviewer3");
		Select select511 = new Select(primaryreview_three11);
		select511.selectByVisibleText(Rev_five);
		
		
		WebElement nonprimaryreview_three11 =GWait.Wait_GetElementByName("nontech_primary_reviewer3");
		Select select611 = new Select(nonprimaryreview_three11);
		select611.selectByVisibleText(Rev_six);
		
				
		WebElement assign_comments1111 =GWait.Wait_GetElementById("comments");
		assign_comments1111.clear();
		
		WebElement assign_comments11111 =GWait.Wait_GetElementById("comments");
		assign_comments11111.sendKeys(Rev_comnts);

			
		WebElement assign_button11 =GWait.Wait_GetElementById("assign");
		assign_button11.click();

		Thread.sleep(8000);

        GlobalMethods.Commentswindhandler();
	
						
		WebElement iecdecisiontab111 =GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab111.click();

		
		WebElement decisondropdown111 =GWait.Wait_GetElementById("decision_type");
		Select select7111 = new Select(decisondropdown111);
		select7111.selectByVisibleText(Decision_query_ms);

		
		WebElement decisionupload111 =GWait.Wait_GetElementById("proj_document");
		decisionupload111.sendKeys(Decisionfile);

		
		WebElement assign_comments211 =GWait.Wait_GetElementById("comments");
		assign_comments211.sendKeys(Decisioncmnt);

				
		WebElement decisionusubmit111 =GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit111.click();

		WebElement logoutt211 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt211.click();
		
		WebElement logo211 = GWait.Wait_GetElementByCSS("img");
		logo211.click();
		
		GlobalMethods.PI_Login();

		WebElement query_reply_dashboard1 = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		query_reply_dashboard1.click();
		
		
		WebElement overview11 =GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview11.click();

		
		WebElement query_tab1 =GWait.Wait_GetElementByXpath("//div[3]/ul/li[4]/a");
		query_tab1.click();

		
		WebElement query_tab_edit1 = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		query_tab_edit1.click();
		
		WebElement logoutt2111 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2111.click();
		
		WebElement logo2111 = GWait.Wait_GetElementByCSS("img");
		logo2111.click();

		GlobalMethods.PI_Login();

		WebElement createproject111 = GWait.Wait_GetElementByLinkText("Submit New Project");
		createproject111.click();

		WebElement projtypdrop111 = GWait
				.Wait_GetElementByXpath(".//*[@id='projectsummary']/div/div[1]/div[1]/div/div/button");
		projtypdrop111.click();
		Thread.sleep(2000);

		List<WebElement> elementsList11111 = projtypvalue;
		for (WebElement a11 : elementsList11111) {
			WebElement span = a11.findElement(By.tagName("span"));
			if (span.getText().equalsIgnoreCase(Project_Type)) {
				span.click();
				break;
			}
		}

		WebElement revtypdrop111 = GWait
				.Wait_GetElementByXpath("//*[@id='projectsummary']/div/div[2]/div[1]/div/div/button");
		revtypdrop111.click();
		Thread.sleep(2000);

		List<WebElement> elementsList2111 = revtypvalue;
		for (WebElement a111 : elementsList2111) {
			WebElement span = a111.findElement(By.tagName("span"));
			// System.out.println(Review_Type);
			System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(Review_Type_fullboard)) {

				span.click();
				String text = span.getText();
				System.out.println(text);
				break;
			}
		}

		WebElement Full_title111 = GWait.Wait_GetElementById("projecttitle");
		Full_title111.sendKeys(Project_Full_Title);

		WebElement short_title111 = GWait.Wait_GetElementById("projectshorttitle");
		short_title111.sendKeys(Project_Short_Title);

		WebElement sponsor111 = GWait.Wait_GetElementById("project_description");
		sponsor111.sendKeys(Sponsor);

		WebElement save_button1111 = GWait.Wait_GetElementByXpath("//*[@id='sumsave']");
		save_button1111.click();

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
				Thread.sleep(1000);
				doc_title.sendKeys(Document_Title_in_list);
				doc_version.sendKeys(Version_in_list);
				doc_date.sendKeys(Document_Date_in_list);
				Thread.sleep(1000);
				upload_doc.sendKeys(doc_upload);
				Thread.sleep(8000);

				save_button2.click();
				Thread.sleep(4000);

			}

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(10000);

		WebElement next_button111 = GWait.Wait_GetElementById("nextid");
		next_button111.click();

			
		WebElement submit_to_IEC111 =GWait.Wait_GetElementById("submitid");
     	submit_to_IEC111.click();
		
     	Thread.sleep(3000);
		WebElement no111 = GWait.Wait_GetElementByXpath("//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[2]"); 
		no111.click();
		Thread.sleep(3000);
		
		WebElement conflictsubmit11a = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		conflictsubmit11a.click();
		
		Thread.sleep(3000);
		GlobalMethods.alertaccept();
		Thread.sleep(3000);
		WebElement logoutt111111 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt111111.click();
		
		WebElement logo111111 = GWait.Wait_GetElementByCSS("img");
		logo111111.click();


		// Login as admin
		Thread.sleep(2000);
		GlobalMethods.Admin_Login();

		WebElement Dashboard_newsubmission111 = GWait.Wait_GetElementByCSS("span.pull-left");
		Dashboard_newsubmission111.click();
				
		WebElement Projectoverview1111111 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview1111111.click();

		
		WebElement Admin_Review1111 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review1111.click();
		
		
		WebElement Processing_fee_yes111 = GWait.Wait_GetElementById("processing_fee_paid");
		Processing_fee_yes111.click();
		
		
		WebElement payment_receipt_yes111 = GWait.Wait_GetElementById("payment_receipt");
		payment_receipt_yes111.sendKeys(pyrcnum);
		
				
		WebElement hard_copy_yes111 = GWait.Wait_GetElementById("hard_copy_submitted");
		hard_copy_yes111.click();

		
		WebElement inward_no_yes111 = GWait.Wait_GetElementById("inward_no");
		inward_no_yes111.sendKeys(inwnum);

		
		WebElement projnum111 = GWait.Wait_GetElementById("project_number");
		projnum111.sendKeys(prjnum);

		
		WebElement insurdate111 = GWait.Wait_GetElementById("insurance_date");
		insurdate111.sendKeys(insdate);

		
		WebElement inwdate111 = GWait.Wait_GetElementById("inward_no_date");
		inwdate111.sendKeys(inwrddate);
		
		
		WebElement forward_button1111 = GWait.Wait_GetElementById("forward_modal_btn");
		forward_button1111.click();
		
		
		WebElement ethic_selection1111 = GWait.Wait_GetElementById("txn_ethic_committee_id");
		Select select1111111 = new Select(ethic_selection1111);
		select1111111.selectByVisibleText(ethic_com);

						
		//WebElement forward_button = GWait.Wait_GetElementById("forward_modal_btn");
		//forward_button.click();
		Thread.sleep(4000);
		WebElement ethic_comments1111 = GWait.Wait_GetElementByClassName("richText");
		ethic_comments1111.sendKeys(ethic_comnts);

				
		WebElement ethic_frwd1111 = GWait.Wait_GetElementById("forward_btn");
		ethic_frwd1111.click();
		Thread.sleep(8000);
		WebElement logoutt1111111 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt1111111.click();
		
		WebElement logo1111111 = GWait.Wait_GetElementByCSS("img");
		logo1111111.click();
		// MS assign reviewers & giving decision

		GlobalMethods.MS_Login();

		WebElement projectslink111 = GWait.Wait_GetElementByLinkText("Projects");
		projectslink111.click();

	
		WebElement Projectoverview11111111 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview11111111.click();
		
		
		WebElement asignreviewers111 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers111.click();

		
		WebElement primaryreview_one3 = GWait.Wait_GetElementById("primary_reviewer");
		Select select11111111 = new Select(primaryreview_one3);
		select11111111.selectByVisibleText(Rev_one);
				
		WebElement nonprimaryreview_one111 = GWait.Wait_GetElementByName("nontech_primary_reviewer1");
		Select select2111 = new Select(nonprimaryreview_one111);
		select2111.selectByVisibleText(Rev_two);
			
		
		WebElement primaryreview_two111 = GWait.Wait_GetElementByName("tech_primary_reviewer2");
		Select select3111 = new Select(primaryreview_two111);
		select3111.selectByVisibleText(Rev_three);
		
		
		WebElement nonprimaryreview_two111 =GWait.Wait_GetElementByName("nontech_primary_reviewer2");
		Select select4111 = new Select(nonprimaryreview_two111);
		select4111.selectByVisibleText(Rev_four);
		
		
		WebElement primaryreview_three111 =GWait.Wait_GetElementByName("tech_primary_reviewer3");
		Select select5111 = new Select(primaryreview_three111);
		select5111.selectByVisibleText(Rev_five);
		
		
		WebElement nonprimaryreview_three111 =GWait.Wait_GetElementByName("nontech_primary_reviewer3");
		Select select6111 = new Select(nonprimaryreview_three111);
		select6111.selectByVisibleText(Rev_six);
		
				
		WebElement assign_comments111111 =GWait.Wait_GetElementById("comments");
		assign_comments111111.clear();
		
		WebElement assign_comments1111111 =GWait.Wait_GetElementById("comments");
		assign_comments1111111.sendKeys(Rev_comnts);

			
		WebElement assign_button111 =GWait.Wait_GetElementById("assign");
		assign_button111.click();

		Thread.sleep(8000);

        GlobalMethods.Commentswindhandler();
	
						
		WebElement iecdecisiontab1111 =GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab1111.click();

		
		WebElement decisondropdown1111 =GWait.Wait_GetElementById("decision_type");
		Select select71111 = new Select(decisondropdown1111);
		select71111.selectByVisibleText(Decision_query_rev);

		
		WebElement decisionupload1111 =GWait.Wait_GetElementById("proj_document");
		decisionupload1111.sendKeys(Decisionfile);

		
		WebElement assign_comments2111 =GWait.Wait_GetElementById("comments");
		assign_comments2111.sendKeys(Decisioncmnt);

				
		WebElement decisionusubmit1111 =GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit1111.click();

		WebElement logoutt21111 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt21111.click();
		
		WebElement logo31 = GWait.Wait_GetElementByCSS("img");
		logo31.click();
		
		GlobalMethods.PI_Login();

		WebElement query_reply_dashboard2 = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		query_reply_dashboard2.click();
		
		
		WebElement overview2 =GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview2.click();

		
		WebElement query_tab2 =GWait.Wait_GetElementByXpath("//div[3]/ul/li[4]/a");
		query_tab2.click();

		
		WebElement query_tab_edit2 = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		query_tab_edit2.click();
		WebElement logoutt212 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt212.click();
		
		WebElement logo212 = GWait.Wait_GetElementByCSS("img");
		logo212.click();
		
		GlobalMethods.PI_Login();

		WebElement createproject12 = GWait.Wait_GetElementByLinkText("Submit New Project");
		createproject12.click();

		WebElement projtypdrop12 = GWait
				.Wait_GetElementByXpath(".//*[@id='projectsummary']/div/div[1]/div[1]/div/div/button");
		projtypdrop12.click();
		Thread.sleep(2000);

		List<WebElement> elementsList1112 = projtypvalue;
		for (WebElement a11 : elementsList1112) {
			WebElement span = a11.findElement(By.tagName("span"));
			if (span.getText().equalsIgnoreCase(Project_Type)) {
				span.click();
				break;
			}
		}

		WebElement revtypdrop12 = GWait
				.Wait_GetElementByXpath("//*[@id='projectsummary']/div/div[2]/div[1]/div/div/button");
		revtypdrop12.click();
		Thread.sleep(2000);

		List<WebElement> elementsList212 = revtypvalue;
		for (WebElement a111 : elementsList212) {
			WebElement span = a111.findElement(By.tagName("span"));
			// System.out.println(Review_Type);
			System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(Review_Type_fullboard)) {

				span.click();
				String text = span.getText();
				System.out.println(text);
				break;
			}
		}

		WebElement Full_title12 = GWait.Wait_GetElementById("projecttitle");
		Full_title12.sendKeys(Project_Full_Title);

		WebElement short_title12 = GWait.Wait_GetElementById("projectshorttitle");
		short_title12.sendKeys(Project_Short_Title);

		WebElement sponsor12 = GWait.Wait_GetElementById("project_description");
		sponsor12.sendKeys(Sponsor);

		WebElement save_button112 = GWait.Wait_GetElementByXpath("//*[@id='sumsave']");
		save_button112.click();

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
				Thread.sleep(1000);
				doc_title.sendKeys(Document_Title_in_list);
				doc_version.sendKeys(Version_in_list);
				doc_date.sendKeys(Document_Date_in_list);
				Thread.sleep(1000);
				upload_doc.sendKeys(doc_upload);
				Thread.sleep(8000);

				save_button2.click();
				Thread.sleep(4000);

			}

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(10000);

		WebElement next_button12 = GWait.Wait_GetElementById("nextid");
		next_button12.click();

			
		WebElement submit_to_IEC12 =GWait.Wait_GetElementById("submitid");
     	submit_to_IEC12.click();
		
     	Thread.sleep(3000);
		WebElement no12 = GWait.Wait_GetElementByXpath("//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[2]"); 
		no12.click();
		
		Thread.sleep(3000);
		WebElement conflictsubmit11b = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		conflictsubmit11b.click();
		
		Thread.sleep(3000);
		GlobalMethods.alertaccept();
		Thread.sleep(3000);
		WebElement logoutt112 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt112.click();
		
		WebElement logo112 = GWait.Wait_GetElementByCSS("img");
		logo112.click();


		// Login as admin
		Thread.sleep(2000);
		GlobalMethods.Admin_Login();

		WebElement Dashboard_newsubmission12 = GWait.Wait_GetElementByCSS("span.pull-left");
		Dashboard_newsubmission12.click();
				
		WebElement Projectoverview1112 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview1112.click();

		
		WebElement Admin_Review112 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review112.click();
		
		
		WebElement Processing_fee_yes12 = GWait.Wait_GetElementById("processing_fee_paid");
		Processing_fee_yes12.click();
		
		
		WebElement payment_receipt_yes12 = GWait.Wait_GetElementById("payment_receipt");
		payment_receipt_yes12.sendKeys(pyrcnum);
		
				
		WebElement hard_copy_yes12 = GWait.Wait_GetElementById("hard_copy_submitted");
		hard_copy_yes12.click();

		
		WebElement inward_no_yes12 = GWait.Wait_GetElementById("inward_no");
		inward_no_yes12.sendKeys(inwnum);

		
		WebElement projnum12 = GWait.Wait_GetElementById("project_number");
		projnum12.sendKeys(prjnum);

		
		WebElement insurdate12 = GWait.Wait_GetElementById("insurance_date");
		insurdate12.sendKeys(insdate);

		
		WebElement inwdate12 = GWait.Wait_GetElementById("inward_no_date");
		inwdate12.sendKeys(inwrddate);
		
		
		WebElement forward_button112 = GWait.Wait_GetElementById("forward_modal_btn");
		forward_button112.click();
		
		
		WebElement ethic_selection112 = GWait.Wait_GetElementById("txn_ethic_committee_id");
		Select select1112 = new Select(ethic_selection112);
		select1112.selectByVisibleText(ethic_com);

						
		//WebElement forward_button = GWait.Wait_GetElementById("forward_modal_btn");
		//forward_button.click();
		Thread.sleep(3000);
		WebElement ethic_comments112 = GWait.Wait_GetElementByClassName("richText");
		ethic_comments112.sendKeys(ethic_comnts);

				
		WebElement ethic_frwd112 = GWait.Wait_GetElementById("forward_btn");
		ethic_frwd112.click();
		Thread.sleep(8000);
		WebElement logoutt1112 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt1112.click();
		
		WebElement logo1112 = GWait.Wait_GetElementByCSS("img");
		logo1112.click();
		// MS assign reviewers & giving decision

		GlobalMethods.MS_Login();

		WebElement projectslink12 = GWait.Wait_GetElementByLinkText("Projects");
		projectslink12.click();

	
		WebElement Projectoverview112 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview112.click();
		
		
		WebElement asignreviewers12 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers12.click();

		
		WebElement primaryreview_one12 = GWait.Wait_GetElementById("primary_reviewer");
		Select select11112 = new Select(primaryreview_one12);
		select11112.selectByVisibleText(Rev_one);
				
		WebElement nonprimaryreview_one12 = GWait.Wait_GetElementByName("nontech_primary_reviewer1");
		Select select212 = new Select(nonprimaryreview_one12);
		select212.selectByVisibleText(Rev_two);
			
		
		WebElement primaryreview_two12 = GWait.Wait_GetElementByName("tech_primary_reviewer2");
		Select select312 = new Select(primaryreview_two12);
		select312.selectByVisibleText(Rev_three);
		
		
		WebElement nonprimaryreview_two12 =GWait.Wait_GetElementByName("nontech_primary_reviewer2");
		Select select412 = new Select(nonprimaryreview_two12);
		select412.selectByVisibleText(Rev_four);
		
		
		WebElement primaryreview_three12 =GWait.Wait_GetElementByName("tech_primary_reviewer3");
		Select select512 = new Select(primaryreview_three12);
		select512.selectByVisibleText(Rev_five);
		
		
		WebElement nonprimaryreview_three12 =GWait.Wait_GetElementByName("nontech_primary_reviewer3");
		Select select612 = new Select(nonprimaryreview_three12);
		select612.selectByVisibleText(Rev_six);
		
				
		WebElement assign_comments12 =GWait.Wait_GetElementById("comments");
		assign_comments12.clear();
		
		WebElement assign_comments112 =GWait.Wait_GetElementById("comments");
		assign_comments112.sendKeys(Rev_comnts);

			
		WebElement assign_button12 =GWait.Wait_GetElementById("assign");
		assign_button12.click();

		Thread.sleep(8000);

        GlobalMethods.Commentswindhandler();
	
						
		WebElement iecdecisiontab112 =GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab112.click();

		
		WebElement decisondropdown112 =GWait.Wait_GetElementById("decision_type");
		Select select7112 = new Select(decisondropdown112);
		select7112.selectByVisibleText(Decision_prov);

		
		WebElement decisionupload11111 =GWait.Wait_GetElementById("proj_document");
		decisionupload11111.sendKeys(Decisionfile);

		
		WebElement assign_comments21111 =GWait.Wait_GetElementById("comments");
		assign_comments21111.sendKeys(Decisioncmnt);

				
		WebElement decisionusubmit11111 =GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit11111.click();

		WebElement logoutt211111 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt211111.click();
		
		WebElement logo21111 = GWait.Wait_GetElementByCSS("img");
		logo21111.click();
		
		GlobalMethods.PI_Login();

		WebElement query_reply_dashboard11 = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		query_reply_dashboard11.click();
		
		
		WebElement overview111 =GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview111.click();

		
		WebElement query_tab11 =GWait.Wait_GetElementByXpath("//div[3]/ul/li[4]/a");
		query_tab11.click();

		
		WebElement query_tab_edit11 = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		query_tab_edit11.click();
		
		WebElement logoutt2111111 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2111111.click();
		
		WebElement logo211111 = GWait.Wait_GetElementByCSS("img");
		logo211111.click();

	}

}
