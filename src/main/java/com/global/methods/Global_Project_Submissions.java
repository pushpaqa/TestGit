package com.global.methods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Global_Project_Submissions {
	
	public Global_Project_Submissions() 
	{
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

	@FindBy(linkText = "Termination")
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
	WebElement Termination_dashboard;

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

	@FindBy(xpath = "//div[2]/div/div/ul/li[6]/a/span")
	WebElement amend_dashboard;
	
	public static int querydoccount=0;
	public void PI_SubmitProject_IECAdmin() throws Exception
	{

		// Login as PIs

				GlobalMethods.PI_Login();

				FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
				Workbook wb = Workbook.getWorkbook(fi);
				Sheet r1 = wb.getSheet("Project Submissions");

				// Project summary data

				String Project_Type = r1.getCell(2, 221).getContents();
				String Review_Type_Expedited = r1.getCell(3, 221).getContents();
				String Project_Full_Title = r1.getCell(4, 221).getContents();
				String Project_Short_Title = r1.getCell(5, 221).getContents();
				String Sponsor = r1.getCell(6, 221).getContents();

				// Document upload data
				String Document_Title_in_list = r1.getCell(7, 221).getContents();
				String Version_in_list = r1.getCell(8, 221).getContents();
				String Document_Date_in_list = r1.getCell(9, 221).getContents();
				String doc_upload = r1.getCell(10, 221).getContents();

				// Saving project summary

				WebElement createproject = GWait.Wait_GetElementByLinkText("Submit New Project");
				createproject.click();

				WebElement projtypdrop = GWait.Wait_GetElementByXpath(".//*[@id='projectsummary']/div/div[1]/div[1]/div/div/button");
				projtypdrop.click();
				//Thread.sleep(2000);

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
				//Thread.sleep(1000);

				List<WebElement> elementsList2 = revtypvalue;
				for (WebElement a111 : elementsList2) {
					WebElement span = a111.findElement(By.tagName("span"));
					// System.out.println(Review_Type);
					// System.out.println(span.getText());
					if (span.getText().equalsIgnoreCase(Review_Type_Expedited)) {
						//Thread.sleep(2000);
						span.click();
						break;
					}
				}

				WebElement Full_title = GWait.Wait_GetElementById("projecttitle");
				Full_title.sendKeys(Project_Full_Title);
				WebElement short_title = GWait.Wait_GetElementById("projectshorttitle");
				short_title.sendKeys(Project_Short_Title);

				// comparing PI name

				String PIname = Login_PI_Name.getText();
				String loggedpiname = PI_Name.getAttribute("value");

				PIname.equalsIgnoreCase(loggedpiname);
				sponsor.sendKeys(Sponsor);
				WebElement save_button1 = GWait.Wait_GetElementByXpath("//*[@id='sumsave']");
				save_button1.click();
				//Thread.sleep(3000);

				// saving Submit documents
				
				//Thread.sleep(2000);
				//System.out.println(docvalue.size() - 1);
				
				for (int i = 1; i <= docvalue.size() - 1; i++) {
					querydoccount = docvalue.size();
					
					System.out.println(querydoccount = docvalue.size());
					WebElement docdrop = GWait.Wait_GetElementByXpath("//*[@id='document_type']/div/button");
					Thread.sleep(2000);
					docdrop.click();
					String numberAsString = Integer.toString(i);
					//Thread.sleep(5000);
					List<WebElement> elementsList3 = docvalue;
					int j = 0;
					for (WebElement a11 : elementsList3) {
						WebElement span = a11.findElement(By.tagName("span"));
						System.out.println(numberAsString);
						System.out.println(span.getAttribute("data-original-index"));
						if (i == j) {
							// String Document_Type = span.getText();
							//Thread.sleep(2000);
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
				WebElement doctype_title = GWait.Wait_GetElementByXpath("//div[@id='list_documents']/div/div/table/tbody/tr/td[2]");

				String doctype_title1 = doctype_title.getText();
				System.out.println(doctype_title1);
				doctype_title1.equalsIgnoreCase(Document_Title_in_list);

				String doctype_version1 = doctype_version.getText();
				System.out.println(doctype_version1);
				doctype_version1.equalsIgnoreCase(Version_in_list);

				String doctype_date1 = doctype_date.getText();
				System.out.println(doctype_date1);
				doctype_date1.equalsIgnoreCase(Document_Date_in_list);

				WebElement next_button1 = GWait.Wait_GetElementById("nextid");

				next_button1.click();

				// submitting full board project to admin

				WebElement submit_to_IEC = GWait.Wait_GetElementById("submitid");
				submit_to_IEC.click();
				Thread.sleep(2000);
				WebElement no=GWait.Wait_GetElementByXpath("//form[@id='conflictsubmit']/div/div/div/div/input[2]");
				//WebElement No1 = GWait.Wait_GetElementByXpath("//form[@id='conflictsubmit']/div/div/div/div/input[2]");
				no.click();
				
				WebElement conflictsubmit = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
				conflictsubmit.click();
				GlobalMethods.alertaccept();
				Thread.sleep(3000);
				
				
	}
	
	public void After_PI_Submits_IEC_Statusin_PI() throws IOException, Exception
	{
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");
		
		//*******Status Getting from My Projects List in PI login after PI submit the project to IEC**********//
		
		String ProjectTitle = r1.getCell(26, 221).getContents();
		String ProjectStatus = r1.getCell(27, 221).getContents();
		String LatestSubmission = r1.getCell(28, 221).getContents();
		String LatestSubmissionDate = r1.getCell(29,221).getContents();
		String  DocumentStatus= r1.getCell(30, 221).getContents();
		
		
		//********Getting the Project Title ,Project Status, Latest Submission,latest submission date, Document status after PI submit to IEC review**********//
		
		
		WebElement Project_Title121 = GWait.Wait_GetElementByCSS("td.word-wrap");
		String Project_Title_111 = Project_Title121.getText();
		Assert.assertEquals(Project_Title_111, ProjectTitle);
		
		WebElement Project_Status0 = GWait.Wait_GetElementByXpath("//td[5]");
		String Project_Status_1 = Project_Status0.getText();
		Assert.assertEquals(Project_Status_1, ProjectStatus);
		
		WebElement Latest_Submission0 = GWait.Wait_GetElementByXpath("//td[6]");
		String Latest_Submission_1 = Latest_Submission0.getText();
		Assert.assertEquals(Latest_Submission_1, LatestSubmission);
		
		WebElement LatestSubmission_Date0 = GWait.Wait_GetElementByXpath("//td[7]");
		String LatestSubmission_Date_1 = LatestSubmission_Date0.getText();
		System.out.println("1"+LatestSubmission_Date_1);
		System.out.println("2"+LatestSubmissionDate);
		Assert.assertEquals(LatestSubmission_Date_1, LatestSubmissionDate);
		
		WebElement Document_Status0 = GWait.Wait_GetElementByXpath("//td[8]");
		String Document_Status_1 = Document_Status0.getText();
		Assert.assertEquals(Document_Status_1, DocumentStatus);
		
		
		
		WebElement logout=GWait.Wait_GetElementByXpath("//span[3]/a");
		logout.click();

		// GlobalMethods.Logout();

		WebElement logo = GWait.Wait_GetElementByCSS("img");

		logo.click();
	}

	public void Dashboard_Click_Admin() throws Exception
	{
	
		GlobalMethods.Admin_Login();
		WebElement Dashboard_newsubmission = GWait.Wait_GetElementByCSS("span.pull-left");

		Dashboard_newsubmission.click();

	}
	
	public void InitialSubmission_StatusinAdmin_Starting() throws IOException, Exception
	{
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		//*******Status Getting from My Projects List in Admin login in starting**********//*

		String ProjectTitle5 = r1.getCell(46, 221).getContents();
		String ProjectStatus5 = r1.getCell(47, 221).getContents();
		String LatestSubmission5 = r1.getCell(48, 221).getContents();
		String LatestSubmissionDate5 = r1.getCell(49, 221).getContents();
		String  DocumentStatus5= r1.getCell(50, 221).getContents();

		//*************Getting status after login with admin in starting************/

		WebElement Project_Title5 = GWait.Wait_GetElementByCSS("td.word-wrap");
		String Project_Title51 = Project_Title5.getText();
		Assert.assertEquals(Project_Title51, ProjectTitle5);

		WebElement Project_Status5 = GWait.Wait_GetElementByXpath("//td[6]");
		String Project_Status_51 = Project_Status5.getText();
		Assert.assertEquals(Project_Status_51, ProjectStatus5);

		WebElement Latest_Submission5 = GWait.Wait_GetElementByXpath("//td[7]");
		String Latest_Submission_51 = Latest_Submission5.getText();
		Assert.assertEquals(Latest_Submission_51, LatestSubmission5);

		WebElement LatestSubmission_Date5 = GWait.Wait_GetElementByXpath("//td[8]");
		String LatestSubmission_Date_51 = LatestSubmission_Date5.getText();
		System.out.println("1"+LatestSubmission_Date_51);
		System.out.println("2"+LatestSubmissionDate5);
		Assert.assertEquals(LatestSubmission_Date_51, LatestSubmissionDate5);

		WebElement Document_Status5 = GWait.Wait_GetElementByXpath("//td[9]");
		String Document_Status_51 = Document_Status5.getText();
		Assert.assertEquals(Document_Status_51, DocumentStatus5);


	}

	
	public void Admin_Forwardto_MS() throws Exception
	{

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");


		// Admin data
		String pyrcnum = r1.getCell(11, 221).getContents();
		String inwnum = r1.getCell(12, 221).getContents();
		String prjnum = r1.getCell(13, 221).getContents();
		String insdate = r1.getCell(14, 221).getContents();
		String inwrddate = r1.getCell(15, 221).getContents();
		String ethic_com = r1.getCell(16, 221).getContents();
		String ethic_comnts = r1.getCell(17, 221).getContents();



		WebElement Projectoverview = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview.click();
		WebElement Admin_Review = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review.click();
		WebElement Processing_fee_yes = GWait.Wait_GetElementById("processing_fee_paid");
		Processing_fee_yes.click();

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
		Thread.sleep(2000);
		WebElement ethic_selection = GWait.Wait_GetElementById("txn_ethic_committee_id");
		Select select = new Select(ethic_selection);
		select.selectByVisibleText(ethic_com);
		Thread.sleep(2000);
		WebElement ethic_comments = GWait.Wait_GetElementByClassName("richText");
		ethic_comments.sendKeys(ethic_comnts);

		String MSname = ethic_ms_name.getAttribute("Value");

		WebElement ethic_frwd2 = GWait.Wait_GetElementById("forward_btn");
		ethic_frwd2.click();
		
		Thread.sleep(4000);

		WebElement ethic_frwd_acknowledge = GWait.Wait_GetElementByXpath("//div[@id='flash_message_admin']/p");

		String msg = "Submission has been forwarded to Member Secretary" + " " + MSname;
		System.out.println(msg);

		String acknowledge = ethic_frwd_acknowledge.getText();
		acknowledge.equalsIgnoreCase(msg);
		Thread.sleep(2000);
		WebElement projectslink222 = GWait.Wait_GetElementByLinkText("Projects");
		projectslink222.click();
		Thread.sleep(2000);

	}
	
	public void InitialSubmission_StatusinAdmin_Ending() throws IOException, Exception
	{

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		//*******Status Getting from My Projects List in Admin login in ending(IEC-MS)**********//*

		String ProjectTitle6 = r1.getCell(51, 221).getContents();
		String ProjectStatus6 = r1.getCell(52, 221).getContents();
		String LatestSubmission6 = r1.getCell(53, 221).getContents();
		String LatestSubmissionDate6 = r1.getCell(54, 221).getContents();
		String  DocumentStatus6= r1.getCell(55, 221).getContents();


		//*************Getting status after login with admin in ending************/

		WebElement Project_Title6 = GWait.Wait_GetElementByCSS("td.word-wrap");
		String Project_Title_61 = Project_Title6.getText();
		Assert.assertEquals(Project_Title_61, ProjectTitle6);

		WebElement Project_Status6 = GWait.Wait_GetElementByXpath("//td[6]");
		String Project_Status_61 = Project_Status6.getText();
		Assert.assertEquals(Project_Status_61, ProjectStatus6);

		WebElement Latest_Submission6 = GWait.Wait_GetElementByXpath("//td[7]");
		String Latest_Submission_61 = Latest_Submission6.getText();
		Assert.assertEquals(Latest_Submission_61, LatestSubmission6);

		WebElement LatestSubmission_Date6 = GWait.Wait_GetElementByXpath("//td[8]");
		String LatestSubmission_Date_61 = LatestSubmission_Date6.getText();
		System.out.println("1"+LatestSubmission_Date_61);
		System.out.println("2"+LatestSubmissionDate6);
		Assert.assertEquals(LatestSubmission_Date_61, LatestSubmissionDate6);

		WebElement Document_Status6 = GWait.Wait_GetElementByXpath("//td[9]");
		String Document_Status_61 = Document_Status6.getText();
		Assert.assertEquals(Document_Status_61, DocumentStatus6);

		WebElement logoutt11 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt11.click();
		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();
	}

	public void InitialSub_After__IEC_forwardto_MS_StatusInPI() throws Exception
	{

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");


		//*******Status Getting from My Projects List in PI login after Admin forward the project to MS**********//

		String ProjectTitle2 = r1.getCell(31, 221).getContents();
		String ProjectStatus2 = r1.getCell(32, 221).getContents();
		String LatestSubmission2 = r1.getCell(33, 221).getContents();
		String LatestSubmissionDate2 = r1.getCell(34, 221).getContents();
		String  DocumentStatus2= r1.getCell(35, 221).getContents();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu.click();


		//********Getting the Project Title ,Project Status, Latest Submission,latest submission date, Document status after IEC forward to MS**********//

		WebElement Project_Title2 = GWait.Wait_GetElementByXpath("//td[4]");
		String Project_Title2_1 = Project_Title2.getText();
		Assert.assertEquals(Project_Title2_1, ProjectTitle2);

		WebElement Project_Status2 = GWait.Wait_GetElementByXpath("//td[5]");
		String Project_Status2_1 = Project_Status2.getText();
		System.out.println("1"+Project_Status2_1);
		System.out.println("2"+ProjectStatus2);
		Assert.assertEquals(Project_Status2_1, ProjectStatus2);

		WebElement Latest_Submission2 = GWait.Wait_GetElementByXpath("//td[6]");
		String Latest_Submission2_1 = Latest_Submission2.getText();
		Assert.assertEquals(Latest_Submission2_1, LatestSubmission2);

		WebElement LatestSubmission_Date2 = GWait.Wait_GetElementByXpath("//td[7]");
		String LatestSubmission_Date2_1 = LatestSubmission_Date2.getText();
		Assert.assertEquals(LatestSubmission_Date2_1, LatestSubmissionDate2);

		WebElement Document_Status2 = GWait.Wait_GetElementByXpath("//td[8]");
		String Document_Status2_1 = Document_Status2.getText();
		Assert.assertEquals(Document_Status2_1, DocumentStatus2);


		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt2.click();
		WebElement logo2 = GWait.Wait_GetElementByCSS("img");
		logo2.click();

	}
    public void MS_Dashboard_Click() throws Exception
    {

    	GlobalMethods.MS_Login();

    	WebElement projectslink = GWait.Wait_GetElementByLinkText("Projects");

    	projectslink.click();


    }

    public void InitialSubmission_StatusinMS_Starting() throws IOException, Exception
    {

    	FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
    	Workbook wb = Workbook.getWorkbook(fi);
    	Sheet r1 = wb.getSheet("Project Submissions");


    	//*******Status Getting from My Projects List in MS login in starting**********/

    	String ProjectTitle7 = r1.getCell(56, 221).getContents();
    	String ProjectStatus7 = r1.getCell(57, 221).getContents();
    	String LatestSubmission7 = r1.getCell(58, 221).getContents();
    	String LatestSubmissionDate7 = r1.getCell(59, 221).getContents();
    	String  DocumentStatus7= r1.getCell(60, 221).getContents();

    	//************Getting status after login with MS in starting*********************/

    	WebElement Project_Title7 = GWait.Wait_GetElementByCSS("td.word-wrap");
    	String Project_Title_71 = Project_Title7.getText();
    	Assert.assertEquals(Project_Title_71, ProjectTitle7);

    	WebElement Project_Status7 = GWait.Wait_GetElementByXpath("//td[6]");
    	String Project_Status_71 = Project_Status7.getText();
    	Assert.assertEquals(Project_Status_71, ProjectStatus7);

    	WebElement Latest_Submission7 = GWait.Wait_GetElementByXpath("//td[7]");
    	String Latest_Submission_71 = Latest_Submission7.getText();
    	Assert.assertEquals(Latest_Submission_71, LatestSubmission7);

    	WebElement LatestSubmission_Date7 = GWait.Wait_GetElementByXpath("//td[8]");
    	String LatestSubmission_Date_71 = LatestSubmission_Date7.getText();
    	System.out.println("1"+LatestSubmission_Date_71);
    	System.out.println("2"+LatestSubmissionDate7);
    	Assert.assertEquals(LatestSubmission_Date_71, LatestSubmissionDate7);

    	WebElement Document_Status7 = GWait.Wait_GetElementByXpath("//td[9]");
    	String Document_Status_71 = Document_Status7.getText();
    	Assert.assertEquals(Document_Status_71, DocumentStatus7);

    	
}
	
	public void MS_ForwardTo_CP() throws IOException, Exception
	{
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		// MS data
		String Rev_one = r1.getCell(18, 221).getContents();
		String Rev_two = r1.getCell(19, 221).getContents();
		String Rev_three = r1.getCell(20, 221).getContents();
		String Rev_four = r1.getCell(21, 221).getContents();
		String Rev_five = r1.getCell(22, 221).getContents();
		String Rev_six = r1.getCell(23, 221).getContents();
		String Rev_comnts = r1.getCell(24, 221).getContents();




		// MS assign reviewers & giving decision

	
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
		assign_comments.sendKeys(Rev_comnts);

		WebElement forward_chairman_button = GWait.Wait_GetElementById("forward_chairman");
		forward_chairman_button.click();
		WebElement forward_chairman_msg = GWait.Wait_GetElementByCSS("div.nocontent > p");

		String frwd_chair_assing_rev_msg_1 = forward_chairman_msg.getText();
		// frwd_chair_assing_rev_msg.equalsIgnoreCase(frwd_chair_assing_rev_msg_1);
		System.out.println(frwd_chair_assing_rev_msg_1);

		//**********Ms Login in ending************/

		WebElement projectslink121 = GWait.Wait_GetElementByLinkText("Projects");

		projectslink121.click();


	}
	
	public void InitialSubmission_StatusinMS_Ending() throws IOException, Exception
	{
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		//*******Status Getting from My Projects List in MS login in ending(MS-CP)**********/

		String ProjectTitle8 = r1.getCell(61, 221).getContents();
		String ProjectStatus8 = r1.getCell(62, 221).getContents();
		String LatestSubmission8 = r1.getCell(63, 221).getContents();
		String LatestSubmissionDate8 = r1.getCell(64, 221).getContents();
		String  DocumentStatus8= r1.getCell(65, 221).getContents();

		WebElement Project_Title8 = GWait.Wait_GetElementByCSS("td.word-wrap");
		String Project_Title_81 = Project_Title8.getText();
		Assert.assertEquals(Project_Title_81, ProjectTitle8);

		WebElement Project_Status8 = GWait.Wait_GetElementByXpath("//td[6]");
		String Project_Status_81 = Project_Status8.getText();
		Assert.assertEquals(Project_Status_81, ProjectStatus8);

		WebElement Latest_Submission8 = GWait.Wait_GetElementByXpath("//td[7]");
		String Latest_Submission_81 = Latest_Submission8.getText();
		Assert.assertEquals(Latest_Submission_81, LatestSubmission8);

		WebElement LatestSubmission_Date8 = GWait.Wait_GetElementByXpath("//td[8]");
		String LatestSubmission_Date_81 = LatestSubmission_Date8.getText();
		System.out.println("1"+LatestSubmission_Date_81);
		System.out.println("2"+LatestSubmissionDate8);
		Assert.assertEquals(LatestSubmission_Date_81, LatestSubmissionDate8);

		WebElement Document_Status8 = GWait.Wait_GetElementByXpath("//td[9]");
		String Document_Status_81 = Document_Status8.getText();
		Assert.assertEquals(Document_Status_81, DocumentStatus8);

		WebElement logoutt3 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt3.click();

		WebElement logo3 = GWait.Wait_GetElementByCSS("img");
		logo3.click();
	}

	public void InitialSub_After__MS_forwardto_CP_StatusInPI() throws Exception
	{
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		//*******Status Getting from My Projects List in PI login after MS forward the project to CP**********//

		String ProjectTitle3 = r1.getCell(36, 221).getContents();
		String ProjectStatus3 = r1.getCell(37, 221).getContents();
		String LatestSubmission3 = r1.getCell(38, 221).getContents();
		String LatestSubmissionDate3 = r1.getCell(39, 221).getContents();
		String  DocumentStatus3= r1.getCell(40, 221).getContents();


		GlobalMethods.PI_Login();
		WebElement PI_project_menu1 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu1.click();

		//********Getting the Project Title ,Project Status, Latest Submission,latest submission date, Document status after MS forward to CP**********//

		WebElement Project_Title3 = GWait.Wait_GetElementByXpath("//td[4]");
		String Project_Title3_1 = Project_Title3.getText();
		Assert.assertEquals(Project_Title3_1, ProjectTitle3);

		WebElement Project_Status3 = GWait.Wait_GetElementByXpath("//td[5]");
		String Project_Status3_1 = Project_Status3.getText();
		Assert.assertEquals(Project_Status3_1, ProjectStatus3);

		WebElement Latest_Submission3 = GWait.Wait_GetElementByXpath("//td[6]");
		String Latest_Submission3_1 = Latest_Submission3.getText();
		Assert.assertEquals(Latest_Submission3_1, LatestSubmission3);

		WebElement LatestSubmission_Date3 = GWait.Wait_GetElementByXpath("//td[7]");
		String LatestSubmission_Date3_1 = LatestSubmission_Date3.getText();
		Assert.assertEquals(LatestSubmission_Date3_1, LatestSubmissionDate3);

		WebElement Document_Status3 = GWait.Wait_GetElementByXpath("//td[8]");
		String Document_Status3_1 = Document_Status3.getText();
		Assert.assertEquals(Document_Status3_1, DocumentStatus3);

		WebElement logoutt4 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt4.click();
		WebElement logo4 = GWait.Wait_GetElementByCSS("img");
		logo4.click();


	}
		
	public void CP_DashboardClick() throws Exception
	{
		GlobalMethods.CPLogin();
		WebElement projectslink1 = GWait.Wait_GetElementByLinkText("Projects");

		projectslink1.click();
	}
	public void InitialSubmission_StatusinCP_Starting() throws Exception
	{

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");


		//*******Status Getting from My Projects List in CP login in starting**********/

		String ProjectTitle9 = r1.getCell(66, 221).getContents();
		String ProjectStatus9 = r1.getCell(67, 221).getContents();
		String LatestSubmission9 = r1.getCell(68, 221).getContents();
		String LatestSubmissionDate9 = r1.getCell(69, 221).getContents();
		String  DocumentStatus9= r1.getCell(70, 221).getContents();

		//******************Getting status after login to CP***********************/

		WebElement Project_Title9 = GWait.Wait_GetElementByCSS("td.word-wrap");
		String Project_Title_91 = Project_Title9.getText();
		Assert.assertEquals(Project_Title_91, ProjectTitle9);

		WebElement Project_Status9 = GWait.Wait_GetElementByXpath("//td[6]");
		String Project_Status_91 = Project_Status9.getText();
		Assert.assertEquals(Project_Status_91, ProjectStatus9);

		WebElement Latest_Submission9 = GWait.Wait_GetElementByXpath("//td[7]");
		String Latest_Submission_91 = Latest_Submission9.getText();
		Assert.assertEquals(Latest_Submission_91, LatestSubmission9);

		WebElement LatestSubmission_Date9 = GWait.Wait_GetElementByXpath("//td[8]");
		String LatestSubmission_Date_91 = LatestSubmission_Date9.getText();
		System.out.println("1"+LatestSubmission_Date_91);
		System.out.println("2"+LatestSubmissionDate9);
		Assert.assertEquals(LatestSubmission_Date_91, LatestSubmissionDate9);

		WebElement Document_Status9 = GWait.Wait_GetElementByXpath("//td[9]");
		String Document_Status_91 = Document_Status9.getText();
		Assert.assertEquals(Document_Status_91, DocumentStatus9);

	}



	public void CP_SubmitProjectTo_MS() throws IOException, Exception
	{

		WebElement Projects_for_IEC_Review_link = GWait.Wait_GetElementByLinkText("Projects for IEC Review");
		Projects_for_IEC_Review_link.click();
		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();
		WebElement asignreviewers1 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers1.click();
		WebElement submit_to_ms_button = GWait.Wait_GetElementById("assign1");
		submit_to_ms_button.click();
		Thread.sleep(15000);

		String chair_to_ms_msg_1 = chair_to_ms_msg.getText();
		// chair_assing_rev_msg.equalsIgnoreCase(chair_to_ms_msg_1);
		System.out.println(chair_to_ms_msg_1);
	}
	
	public void InitialSubmission_StatusinCP_Ending() throws IOException, Exception
	{
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		//*******Status Getting from My Projects List in CP login in ending(CP-MS)**********/

		String ProjectTitle10 = r1.getCell(71, 221).getContents();
		String ProjectStatus10 = r1.getCell(72, 221).getContents();
		String LatestSubmission10 = r1.getCell(73, 221).getContents();
		String LatestSubmissionDate10 = r1.getCell(74, 221).getContents();
		String  DocumentStatus10= r1.getCell(75, 221).getContents();

		//**************CP Login ending*********************//

		WebElement projectslink111 = GWait.Wait_GetElementByLinkText("Projects");

		projectslink111.click();

		WebElement Project_Title10 = GWait.Wait_GetElementByCSS("td.word-wrap");
		String Project_Title_101 = Project_Title10.getText();
		Assert.assertEquals(Project_Title_101, ProjectTitle10);

		WebElement Project_Status10 = GWait.Wait_GetElementByXpath("//td[6]");
		String Project_Status_101 = Project_Status10.getText();
		Assert.assertEquals(Project_Status_101, ProjectStatus10);

		WebElement Latest_Submission10 = GWait.Wait_GetElementByXpath("//td[7]");
		String Latest_Submission_101 = Latest_Submission10.getText();
		Assert.assertEquals(Latest_Submission_101, LatestSubmission10);

		WebElement LatestSubmission_Date10 = GWait.Wait_GetElementByXpath("//td[8]");
		String LatestSubmission_Date_101 = LatestSubmission_Date10.getText();
		System.out.println("1"+LatestSubmission_Date_101);
		System.out.println("2"+LatestSubmissionDate10);
		Assert.assertEquals(LatestSubmission_Date_101, LatestSubmissionDate10);

		WebElement Document_Status10 = GWait.Wait_GetElementByXpath("//td[9]");
		String Document_Status_101 = Document_Status10.getText();
		Assert.assertEquals(Document_Status_101, DocumentStatus10);

		WebElement logoutt5 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt5.click();

		WebElement logo5 = GWait.Wait_GetElementByCSS("img");
		logo5.click();

	}

	public void InitialSub_After__CP_Submitto_MS_StatusInPI() throws Exception
	{

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");


		//*******Status Getting from My Projects List in PI login after CP submits the project to MS**********//

		String ProjectTitle4 = r1.getCell(41, 221).getContents();
		String ProjectStatus4 = r1.getCell(42, 221).getContents();
		String LatestSubmission4 = r1.getCell(43, 221).getContents();
		String LatestSubmissionDate4 = r1.getCell(44, 221).getContents();
		String  DocumentStatus4= r1.getCell(45, 221).getContents();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu2 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu2.click();

		//********Getting the Project Title ,Project Status, Latest Submission,latest submission date, Document status after CP Submit to MS**********//

		WebElement Project_Title4 = GWait.Wait_GetElementByXpath("//td[4]");
		String Project_Title4_41 = Project_Title4.getText();
		Assert.assertEquals(Project_Title4_41, ProjectTitle4);

		WebElement Project_Status4 = GWait.Wait_GetElementByXpath("//td[5]");
		String Project_Status_41 = Project_Status4.getText();
		Assert.assertEquals(Project_Status_41, ProjectStatus4);

		WebElement Latest_Submission4 = GWait.Wait_GetElementByXpath("//td[6]");
		String Latest_Submission_41 = Latest_Submission4.getText();
		Assert.assertEquals(Latest_Submission_41, LatestSubmission4);

		WebElement LatestSubmission_Date41 = GWait.Wait_GetElementByXpath("//td[7]");
		String LatestSubmission_Date_41 = LatestSubmission_Date41.getText();
		Assert.assertEquals(LatestSubmission_Date_41, LatestSubmissionDate4);

		WebElement Document_Status41 = GWait.Wait_GetElementByXpath("//td[8]");
		String Document_Status_41 = Document_Status41.getText();
		Assert.assertEquals(Document_Status_41, DocumentStatus4);


		WebElement logoutt6 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt6.click();
		WebElement logo6 = GWait.Wait_GetElementByCSS("img");
		logo6.click();
	}
	
	public void StatusIn_MS_After_CPSubmitsToMS() throws IOException, Exception
	{
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		//*******Status Getting from My Projects List in MS login after CP submits project to MS **********/

		String ProjectTitle11 = r1.getCell(76, 221).getContents();
		String ProjectStatus11 = r1.getCell(77, 221).getContents();
		String LatestSubmission11 = r1.getCell(78, 221).getContents();
		String LatestSubmissionDate11 = r1.getCell(79, 221).getContents();
		String  DocumentStatus11= r1.getCell(80, 221).getContents();
		GlobalMethods.MS_Login();

		WebElement projectslink12 = GWait.Wait_GetElementByLinkText("Projects");

		projectslink12.click();

		//************Getting status after login with MS*********************/

		WebElement Project_Title11 = GWait.Wait_GetElementByXpath("//td[4]");
		String Project_Title4_11 = Project_Title11.getText();
		Assert.assertEquals(Project_Title4_11, ProjectTitle11);

		WebElement Project_Status11 = GWait.Wait_GetElementByXpath("//td[6]");
		String Project_Status_11 = Project_Status11.getText();
		Assert.assertEquals(Project_Status_11, ProjectStatus11);

		WebElement Latest_Submission11 = GWait.Wait_GetElementByXpath("//td[7]");
		String Latest_Submission_11 = Latest_Submission11.getText();
		Assert.assertEquals(Latest_Submission_11, LatestSubmission11);

		WebElement LatestSubmission_Date11 = GWait.Wait_GetElementByXpath("//td[8]");
		String LatestSubmission_Date_11 = LatestSubmission_Date11.getText();
		Assert.assertEquals(LatestSubmission_Date_11, LatestSubmissionDate11);

		WebElement Document_Status11 = GWait.Wait_GetElementByXpath("//td[9]");
		String Document_Status_11 = Document_Status11.getText();
		Assert.assertEquals(Document_Status_11, DocumentStatus11);

		WebElement logoutt61 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt61.click();

		WebElement logo61 = GWait.Wait_GetElementByCSS("img");
		logo61.click();

	}
	
	public void Global_PILoginstatus_Verify(String ProjectTitleA,String ProjectStatusA,String LatestSubmissionA,String DocumentStatusA) throws IOException, Exception
	{
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		String LatestSubmissionDate11 = r1.getCell(79, 221).getContents();
		
		//********Getting the Project Title ,Project Status, Latest Submission,latest submission date, Document status after MS forward to CP**********//
Thread.sleep(2000);
		WebElement Project_Title3 = GWait.Wait_GetElementByXpath("//td[4]");
		String Project_Title3_1 = Project_Title3.getText();
		Assert.assertEquals(Project_Title3_1, ProjectTitleA);

		WebElement Project_Status3 = GWait.Wait_GetElementByXpath("//td[5]");
		String Project_Status3_1 = Project_Status3.getText();
		Assert.assertEquals(Project_Status3_1, ProjectStatusA);

		WebElement Latest_Submission3 = GWait.Wait_GetElementByXpath("//td[6]");
		String Latest_Submission3_1 = Latest_Submission3.getText();
		Assert.assertEquals(Latest_Submission3_1, LatestSubmissionA);

		/*WebElement LatestSubmission_Date3 = GWait.Wait_GetElementByXpath("//td[7]");
		String LatestSubmission_Date3_1 = LatestSubmission_Date3.getText();
		Assert.assertEquals(LatestSubmission_Date3_1, LatestSubmissionDate11);*/

		WebElement Document_Status3 = GWait.Wait_GetElementByXpath("//td[8]");
		String Document_Status3_1 = Document_Status3.getText();
		Assert.assertEquals(Document_Status3_1, DocumentStatusA);

		WebElement logoutt4 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt4.click();
		WebElement logo4 = GWait.Wait_GetElementByCSS("img");
		logo4.click();


		
	}
	public void Global_OtherLoginStatus_Verify(String ProjectTitleA,String ProjectStatusA,String LatestSubmissionA,String DocumentStatusA) throws IOException, Exception
	{
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		String LatestSubmissionDate11 = r1.getCell(79, 221).getContents();
		
		WebElement Project_Title11 = GWait.Wait_GetElementByXpath("//td[4]");
		String Project_Title4_11 = Project_Title11.getText();
		Assert.assertEquals(Project_Title4_11, ProjectTitleA);

		WebElement Project_Status11 = GWait.Wait_GetElementByXpath("//td[6]");
		String Project_Status_11 = Project_Status11.getText();
		Assert.assertEquals(Project_Status_11, ProjectStatusA);

		WebElement Latest_Submission11 = GWait.Wait_GetElementByXpath("//td[7]");
		String Latest_Submission_11 = Latest_Submission11.getText();
		Assert.assertEquals(Latest_Submission_11, LatestSubmissionA);

		/*WebElement LatestSubmission_Date11 = GWait.Wait_GetElementByXpath("//td[8]");
		String LatestSubmission_Date_11 = LatestSubmission_Date11.getText();
		Assert.assertEquals(LatestSubmission_Date_11, LatestSubmissionDate11);*/

		WebElement Document_Status11 = GWait.Wait_GetElementByXpath("//td[9]");
		String Document_Status_11 = Document_Status11.getText();
		Assert.assertEquals(Document_Status_11, DocumentStatusA);
		
	}
	
	public void Global_PILoginstatus_Verify_Archived(String ProjectTitleA,String ProjectStatusA,String LatestSubmissionA,String DocumentStatusA) throws IOException, Exception
	{
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		String LatestSubmissionDate11 = r1.getCell(79, 221).getContents();
		
		//********Getting the Project Title ,Project Status, Latest Submission,latest submission date, Document status after MS forward to CP**********//


		WebElement Project_Title11 = GWait.Wait_GetElementByXpath("//td[4]");
		String Project_Title4_11 = Project_Title11.getText();
		Assert.assertEquals(Project_Title4_11, ProjectTitleA);

		WebElement Project_Status11 = GWait.Wait_GetElementByXpath("//td[6]");
		String Project_Status_11 = Project_Status11.getText();
		Assert.assertEquals(Project_Status_11, ProjectStatusA);

		WebElement Latest_Submission11 = GWait.Wait_GetElementByXpath("//td[7]");
		String Latest_Submission_11 = Latest_Submission11.getText();
		Assert.assertEquals(Latest_Submission_11, LatestSubmissionA);

		WebElement LatestSubmission_Date11 = GWait.Wait_GetElementByXpath("//td[8]");
		String LatestSubmission_Date_11 = LatestSubmission_Date11.getText();
		Assert.assertEquals(LatestSubmission_Date_11, LatestSubmissionDate11);

		WebElement Document_Status11 = GWait.Wait_GetElementByXpath("//td[9]");
		String Document_Status_11 = Document_Status11.getText();
		Assert.assertEquals(Document_Status_11, DocumentStatusA);

		WebElement logoutt4 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt4.click();
		WebElement logo4 = GWait.Wait_GetElementByCSS("img");
		logo4.click();


		
	}
	
	public void Global_Dashboard_AmendmentLink() throws Exception
	{
	
	
		WebElement AmendmentLink = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[6]/a/span");

		AmendmentLink.click();

	}
	
	public void Global_Dashboard_ContinuationLink() throws Exception
	{
	
	
		WebElement ContinuationLink = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[2]/a/span");

		ContinuationLink.click();

	}
	
	public void Global_Dashboard_SAE() throws Exception
	{
	
	
		WebElement SAELink = GWait.Wait_GetElementByXpath("//li[8]/a/span");

		SAELink.click();

	}
	
	public void Global_Dashboard_CompletionLink() throws Exception
	{
	
	
		WebElement CompletionLink = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[3]/a/span");

		CompletionLink.click();//li[8]/a/span

	}
	
	public void Global_Dashboard_PrematureTerminationLink() throws Exception
	{
	
	
		WebElement CompletionLink = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[5]/a/span");

		CompletionLink.click();

	}

	public void Global_Dashboard_DeviationLink() throws Exception
	{
	
	
		WebElement DeviationLink = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[7]/a/span");

		DeviationLink.click();

	}
	
	public void Global_Dashboard_WithdrawnLink() throws Exception
	{
	
	
		WebElement WithdrawnLink = GWait.Wait_GetElementByXpath("//li[3]/a/span");

		WithdrawnLink.click();

	}
	
	public void Global_Dashboard_MSLogin_WithdrawnLink() throws Exception
	{
	
	
		WebElement MSWithdrawnLink = GWait.Wait_GetElementByXpath("//li[5]/a/span");

		MSWithdrawnLink.click();

	}
	
	public void SubsequentSubmissions_IECAdmin_forwardto_MS() throws IOException, Exception
	{
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");


		// Admin data
		
		String ethic_com = r1.getCell(16, 221).getContents();
		String ethic_comnts = r1.getCell(17, 221).getContents();
		
		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();
		WebElement IECAdmin_Review=GWait.Wait_GetElementByLinkText("IEC Admin Review");
		IECAdmin_Review.click();
		WebElement forward_button=GWait.Wait_GetElementById("forward_modal_btn");
		forward_button.click();
		WebElement ethic_selection = GWait.Wait_GetElementById("txn_ethic_committee_id");

		Select select = new Select(ethic_selection);
		select.selectByVisibleText(ethic_com);
        Thread.sleep(2000);
		WebElement ethic_comments = GWait.Wait_GetElementByClassName("richText");

		ethic_comments.sendKeys(ethic_comnts);

		String MSname = ethic_ms_name.getAttribute("Value");

		ethic_frwd.click();

		WebElement ethic_frwd_acknowledge = GWait.Wait_GetElementByXpath("//div[@id='flash_message_admin']/p");

		String msg = "Submission has been forwarded to Member Secretary" + " " + MSname;
		System.out.println(msg);

		String acknowledge = ethic_frwd_acknowledge.getText();
		acknowledge.equalsIgnoreCase(msg);
		Thread.sleep(2000);
		WebElement projectslink222 = GWait.Wait_GetElementByLinkText("Projects");
		projectslink222.click();
		Thread.sleep(2000);

		
	}
	
	public static boolean isPresentAndDisplayed(final WebElement element) {
		try {
			
			return element.isDisplayed();
		}
		catch (NoSuchElementException e)
		{
			return false;
		}
	}
	
	
}
