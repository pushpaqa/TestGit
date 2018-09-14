package com.create4.scenarios;

import java.io.FileInputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

//Check for edit document type in document list of submit new project
public class TS_151 {

	public TS_151() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
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

	@FindBy(xpath = "//td[4]")
	WebElement shorttitle_in_admin_list;
	
	//Document type tabular column fields elements
	
	@FindBy(css = "th")
	WebElement Document_type_in_list;
	
	@FindBy(xpath = "//div[@id='list_documents']/div/div/table/thead/tr/th[2]")
	WebElement Document_title_in_list;
	
	@FindBy(xpath = "//div[@id='list_documents']/div/div/table/thead/tr/th[3]")
	WebElement Document_version_in_list;
	
	@FindBy(xpath = "//div[@id='list_documents']/div/div/table/thead/tr/th[4]")
	WebElement Document_date_in_list;
	
	@FindBy(xpath = "//div[@id='list_documents']/div/div/table/thead/tr/th[5]")
	WebElement Actions_in_list;
	
	@FindBy(css = "i.fa.fa-edit")
	WebElement edit_link;
	
	
	@FindBy(xpath = "//form[@id='documentuploadeditproject']/div/div/label")
	WebElement edit_document_type;
	
	
	@FindBy(xpath = "//form[@id='documentuploadeditproject']/div/div[2]/label")
	WebElement edit_document_title;
	
	
	@FindBy(xpath = "//form[@id='documentuploadeditproject']/div/div[3]/label")
	WebElement edit_version;
	
	
	@FindBy(xpath = "//form[@id='documentuploadeditproject']/div[2]/div/label")
	WebElement edit_date;
	
	@FindBy(xpath = "//form[@id='documentuploadeditproject']/div[2]/div[4]/input[4]")
	WebElement edit_button;
	
	@FindBy(id = "document_title_edit")
	WebElement edit_document_title_edit;
	
	@FindBy(id = "version_edit")
	WebElement edit_version_field_enter_value;
	
	@FindBy(id = "document_date_edit")
	WebElement edit_document_date_enter_value;
	
	@FindBy(linkText = "Delete")
	WebElement edit_delete;
	
	@FindBy(xpath = "//form[@id='documentuploadeditproject']/div[2]/div[4]/input[4]")
	WebElement edit_update_button;
	
	@FindBy(xpath = "//div[@id='documentuploadsection']/div/span/input")
	WebElement edit_upoad_file;
	
	@FindBy(xpath = "//div[@id='myModalDocument']/div[2]/div/div/button")
	WebElement edit_close_updates;
	
	

	// Check for 'Document list' tabular column fields
	public void CRe4_2044_2045_2046_2047_2048_2053_2054() throws Exception {


		
		GlobalMethods.PI_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Projects");
		

		String Project_Type = r1.getCell(2, 79).getContents();
		String Review_Type = r1.getCell(3, 79).getContents();
		String Review_Type_expedited = r1.getCell(4, 79).getContents();
		String Review_Type_exempt = r1.getCell(5, 79).getContents();
		String Project_Full_Title = r1.getCell(6, 79).getContents();
		String Project_Short_Title = r1.getCell(7, 79).getContents();
		String Sponsor = r1.getCell(8, 79).getContents();

	
		//String Document_Type_in_list = r1.getCell(9, 79).getContents();
		String Document_Title_in_list = r1.getCell(10, 79).getContents();
		String Version_in_list = r1.getCell(11, 79).getContents();
		String doc_upload = r1.getCell(12, 79).getContents();
		String Document_Date_in_list = r1.getCell(13, 79).getContents();
		
		String Document_Type = r1.getCell(14, 79).getContents();
		String Document_Title = r1.getCell(15, 79).getContents();
		String Version = r1.getCell(16, 79).getContents();
		String Version_Date = r1.getCell(17, 79).getContents();
		String Actions = r1.getCell(18, 79).getContents();

	
		//String Document_Type1_in_list = r1.getCell(19, 79).getContents();
		String Document_Title1_in_list = r1.getCell(20, 79).getContents();
		String Version1_in_list = r1.getCell(21, 79).getContents();
		String doc_upload1 = r1.getCell(22, 79).getContents();
		String Document_Date1_in_list = r1.getCell(23, 79).getContents();
		
		String Conflict_field_name_1 = r1.getCell(24, 79).getContents();
		String Conflict_field_name_2 = r1.getCell(25, 79).getContents();
		String Conflict_field_name_3 = r1.getCell(26, 79).getContents();
		String upload_document = r1.getCell(27, 79).getContents();
		String conflict_interest_value_int = r1.getCell(28, 79).getContents();
		
		

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
		System.out.println(docvalue.size()-1);
		
		for (int i = 1; i<=docvalue.size()-1; i++)
		{
			Thread.sleep(6000);
			docdrop.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
			List<WebElement> elementsList3 = docvalue;
			int j= 0;
			for (WebElement a11 : elementsList3) {
				WebElement span = a11.findElement(By.tagName("span"));
				System.out.println(numberAsString);
				System.out.println(span.getAttribute("data-original-index"));
				if (i==j) {
					Thread.sleep(2000);
					span.click();
					
					break;
				}
				j++;
			}
			if (i==j) {
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
		
		//Assert.assertEquals(Document_type_in_list.getText().trim(), Document_Type);
		
		
		Assert.assertEquals(Document_title_in_list.getText().trim(), Document_Title);
		
		Assert.assertEquals(Document_version_in_list.getText().trim(), Version);
		
		
		Assert.assertEquals(Document_date_in_list.getText().trim(), Version_Date);
				
		Assert.assertEquals(Actions_in_list.getText().trim(), Actions);
		
		//Assert.assertEquals(doctype_List.getText().trim(), Document_Type_in_list);
		
		Assert.assertEquals(doctype_title.getText().trim(), Document_Title_in_list);

		Assert.assertEquals(doctype_version.getText().trim(), Version_in_list);

		//Assert.assertEquals(doctype_date.getText().trim(), Document_Date_in_list);

				
		WebElement edit_link =GWait.Wait_GetElementByCSS("i.fa.fa-edit");
		edit_link.click();
		
		Thread.sleep(2000);
		WebElement edit_close_updates =GWait.Wait_GetElementByCSS("#myModalDocument > div.modal-dialog > div.modal-content > div.modal-header > button.close");
		edit_close_updates.click();
		
		Thread.sleep(2000);
		WebElement edit_link1 =GWait.Wait_GetElementByCSS("i.fa.fa-edit");
		edit_link1.click();
		
		Thread.sleep(2000);
		WebElement edit_document_title_edit =GWait.Wait_GetElementById("document_title_edit");	
		edit_document_title_edit.clear();
		
		
		WebElement edit_version_field_enter_value =GWait.Wait_GetElementById("version_edit");
		edit_version_field_enter_value.clear();
		
		WebElement edit_document_date_enter_value =GWait.Wait_GetElementById("document_date_edit");
		edit_document_date_enter_value.clear();
		
		
		WebElement edit_delete =GWait.Wait_GetElementByLinkText("Delete");
		edit_delete.click();
		
		
		WebElement edit_update_button =GWait.Wait_GetElementByXpath("//form[@id='documentuploadeditproject']/div[2]/div[4]/input[4]");
		edit_update_button.click();
		
		GlobalMethods.alertaccept();
		Thread.sleep(4000);
		
		WebElement edit_update_button1 =GWait.Wait_GetElementByXpath("//form[@id='documentuploadeditproject']/div[2]/div[4]/input[4]");
		edit_update_button1.click();
		
		Thread.sleep(4000);
		GlobalMethods.alertaccept();
		
		WebElement edit_document_title_edit1 =GWait.Wait_GetElementById("document_title_edit");	
		edit_document_title_edit1.sendKeys(Document_Title_in_list);
			
		
		WebElement edit_update_button2 =GWait.Wait_GetElementByXpath("//form[@id='documentuploadeditproject']/div[2]/div[4]/input[4]");
		edit_update_button2.click();
		
		Thread.sleep(4000);
		GlobalMethods.alertaccept();
		
		WebElement edit_version_field_enter_value1 =GWait.Wait_GetElementById("version_edit");Thread.sleep(4000);
		edit_version_field_enter_value1.sendKeys(Version_in_list);
		
		WebElement edit_update_button3 =GWait.Wait_GetElementByXpath("//form[@id='documentuploadeditproject']/div[2]/div[4]/input[4]");
		edit_update_button3.click();
		
		Thread.sleep(4000);
		GlobalMethods.alertaccept();
		
		WebElement edit_document_date_enter_value1 =GWait.Wait_GetElementById("document_date_edit");
		edit_document_date_enter_value1.sendKeys(Document_Date_in_list);
		
		WebElement edit_update_button4=GWait.Wait_GetElementByXpath("//form[@id='documentuploadeditproject']/div[2]/div[4]/input[4]");
		edit_update_button4.click();
		
		Thread.sleep(4000);
		GlobalMethods.alertaccept();
		
		
		WebElement edit_upoad_file =GWait.Wait_GetElementByXpath("//div[@id='documentuploadsection']/div/span/input");
		edit_upoad_file.sendKeys(upload_document);
		
		WebElement edit_update_button5=GWait.Wait_GetElementByXpath("//form[@id='documentuploadeditproject']/div[2]/div[4]/input[4]");
		edit_update_button5.click();
		Thread.sleep(8000);
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();
				
		
	}



}
