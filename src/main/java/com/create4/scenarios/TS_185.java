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
import org.testng.Assert;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;
import com.global.methods.Global_Project_Submissions;

import jxl.Sheet;
import jxl.Workbook;

//Check for Submission status when query replied by Pi for�sae other submission for MS decisions
public class TS_185 extends TS_59 {
	
	public TS_185()
	{
			PageFactory.initElements(GlobalMethods.driver,this);
	}
	
	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath="//div[2]/div/div/ul/li[4]/a/span")
	WebElement query_reply_admin_dashboard;
	
    @FindBy(linkText="Submit New Project")
    WebElement createproject;	
    
    @FindBy(linkText="My Projects")
    WebElement PI_project_menu;
    
    @FindBy(linkText="Projects")
    WebElement MS_project_menu;
    
    @FindBy(linkText="Archived Projects")
    WebElement PI_archived_menu;
    
	@FindBy(xpath = ".//*[@id='projectsummary']/div/div[1]/div[1]/div/div/button")
	public WebElement projtypdrop;
	
	@FindBy(xpath = "html/body/div[5]/div[1]/div[3]/div[4]/div[1]/form/div/div[1]/div[1]/div/div/div/ul/li")
	public static List<WebElement> projtypvalue;
	
	//review type selection element
	
	@FindBy(xpath = "//*[@id='projectsummary']/div/div[2]/div[1]/div/div/button")
	public WebElement revtypdrop;
	@FindBy(xpath = "html/body/div[5]/div[1]/div[3]/div[4]/div[1]/form/div/div[2]/div[1]/div/div/div/ul/li")
	public static List<WebElement> revtypvalue;
	
			
	@FindBy(id="projecttitle")
	WebElement Full_title;	
	
	@FindBy(id="projectshorttitle")
	WebElement short_title;
	
	@FindBy(id="pi_name")
	WebElement PI_Name;
	
	@FindBy(id="project_description")
	WebElement sponsor;
	
	@FindBy(xpath="//*[@id='sumsave']")
	WebElement save_button1;
	
	@FindBy(id="sumsave")
	WebElement save_button3;
	
	
	//document type selection element_initial
	
	@FindBy(xpath = "//*[@id='document_type']/div/button")
	public WebElement docdrop;
	@FindBy(xpath = "//*[@id='document_type']/div/div/ul/li")
	public static List<WebElement> docvalue;
	
	//document type selection element_continuing
	
		@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/button")
		public WebElement docdrop_c;
		@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/div/ul/li")
		public static List<WebElement> docvalue_c;
	
	
	@FindBy(id="document_title")
	WebElement doc_title;
	
	@FindBy(id="version")
	WebElement doc_version;
	
	@FindBy(id="proj_document")
	WebElement upload_doc;
	
	@FindBy(id="document_date")
	WebElement doc_date;
	
	@FindBy(id="savedoc")
	WebElement save_button2;
	
	@FindBy(id="nextid")
	WebElement next_button1;
	
	@FindBy(linkText="Download the template form")
	WebElement dwnld_temp_link;
	
	@FindBy(linkText="Back")
	WebElement back_button1;
	
	@FindBy(id="nextid")
	WebElement save_as_draft;
	
	@FindBy(id="submitid")
	WebElement submit_to_IEC;
			
	@FindBy(xpath="//span")
	WebElement Login_PI_Name;
	
	@FindBy(xpath = "//div[@id='list_documents']/div/div/table/tbody/tr/td")
	WebElement doctype_List;

	@FindBy(xpath = "//div[@id='list_documents']/div/div/table/tbody/tr/td[2]")
	WebElement doctype_title;

	@FindBy(xpath = "//div[@id='list_documents']/div/div/table/tbody/tr/td[3]")
	WebElement doctype_version;

	@FindBy(xpath = "//div[@id='list_documents']/div/div/table/tbody/tr/td[4]")
	WebElement doctype_date;
	
	@FindBy(className="studyteam_members")
	WebElement yes;
	
	@FindBy(xpath="(//input[@name='studyteam_members'])[2]")
	WebElement no;
	
	@FindBy(id="submit_for_iec_review_confirm")
	WebElement conflictsubmit;
	
	@FindBy(xpath = "//span[3]/a")
	WebElement logoutt;
	
	@FindBy(css="img")
	WebElement logo;
	
	@FindBy(css="li.active > a")
	WebElement dash;
	
	@FindBy(xpath="//li[4]/a/span")
	WebElement Ongoingprojects;
	
	@FindBy(xpath="//td[9]/a/span")
	WebElement approvedprojoverview;
	
	
	
	//Admin IEC admin review page elements
	
	@FindBy(css="span.pull-left")
	WebElement Dashboard_newsubmission;
	
	@FindBy(xpath="//td[10]/a/span")
	WebElement Projectoverview;
	
	@FindBy(linkText="IEC Admin Review")
	WebElement Admin_Review;
	
	@FindBy(id="processing_fee_paid")
	WebElement Processing_fee_yes;
	
	@FindBy(id="payment_receipt")
	WebElement payment_receipt_yes;
	
	@FindBy(id="hard_copy_submitted")
	WebElement hard_copy_yes;
	
	@FindBy(id="inward_no")
	WebElement inward_no_yes;
	
	@FindBy(id="project_number")
	WebElement projnum;
	
	@FindBy(id="insurance_date")
	WebElement insurdate;
	
	@FindBy(id="inward_no_date")
	WebElement inwdate;
	
	@FindBy(id="forward_modal_btn")
	WebElement forward_button;
	
	@FindBy(id="txn_ethic_committee_id")
	WebElement ethic_selection;
	
	@FindBy(id="forward_comments")
	WebElement ethic_comments;
	
	@FindBy(id="ms_name")
	WebElement ethic_ms_name;
	
	@FindBy(id="forward_btn")
	WebElement ethic_frwd;
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement ethic_cancel;
	
	@FindBy(xpath="//div[@id='flash_message_admin']/p")
	WebElement ethic_frwd_acknowledge;
	
	@FindBy(css="span.fa.fa-eye")
	WebElement overview;
	
	@FindBy(xpath="//body/div[5]/div/div/div[2]/div[3]/div[1]/p")
	WebElement projectmsg;
	
	//Member Secretary page elements
	
	@FindBy(linkText="Projects")
	WebElement projectslink;
	
	@FindBy(linkText="Assign Reviewer(s)")
	WebElement asignreviewers;
	
	@FindBy(id="primary_reviewer")
	WebElement primaryreview_one;
	
	@FindBy(name="nontech_primary_reviewer1")
	WebElement nonprimaryreview_one;
	
	@FindBy(name="tech_primary_reviewer2")
	WebElement primaryreview_two;
	
	@FindBy(name="nontech_primary_reviewer2")
	WebElement nonprimaryreview_two;
	
	@FindBy(name="tech_primary_reviewer3")
	WebElement primaryreview_three;
	
	@FindBy(name="nontech_primary_reviewer3")
	WebElement nonprimaryreview_three;
	
	@FindBy(id="comments")
	WebElement assign_comments;
	
	@FindBy(id="assign")
	WebElement assign_button;
	
	@FindBy(css="div.flash.alert-info > p")
	WebElement assignreviewer_msg;
	
	@FindBy(linkText="msmembercomments")
	WebElement membercomments;
	
	@FindBy(linkText="IEC Decision")
	WebElement iecdecisiontab;
	
	@FindBy(id="decision_type")
	WebElement decisondropdown;
	
	@FindBy(id="proj_document")
	WebElement decisionupload;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement decisionusubmit;
	
	
	//Subsequent submission links elements
	
	@FindBy(linkText="Submit New Documents")
	WebElement newdocuments;
		
	@FindBy(linkText="sae other")
	WebElement amend;
	
	@FindBy(linkText="Deviation")
	WebElement deviat;
	
	@FindBy(linkText="Continuation")
	WebElement continu;
	
	@FindBy(linkText="Completion")
	WebElement complet;
	
	@FindBy(linkText="Premature Termination")
	WebElement premterm;
	
	@FindBy(linkText="SAE")
	WebElement seriousadverse;
	
	@FindBy(linkText="Other")
	WebElement othr;
	
	//sae other form fields elements
	
	@FindBy(css="label.col-sm-3.offset-0")
	WebElement subtype_one;
	
	@FindBy(xpath="//form[@id='submitnewuploadproject']/div/div/div[2]/label")
	WebElement doctype_two;
	
	@FindBy(xpath="//form[@id='submitnewuploadproject']/div/div/div[3]/label")
	WebElement version_three;
	
	@FindBy(xpath="//form[@id='submitnewuploadproject']/div/div/div[4]/label")
	WebElement docdate_four;
	
	@FindBy(xpath="//div[@id='review_type']/label")
	WebElement revtype_five;
	
	@FindBy(xpath="//form[@id='submitnewuploadproject']/div/div[2]/div[2]/label")
	WebElement doctitle_six;
	
	@FindBy(id="savedoc")
	WebElement savdoc_seven;
	
	@FindBy(id="proj_document")
	WebElement uploaddoc_seven;
	
	@FindBy(linkText="Dashboard")
	WebElement dash_board;
		
	
	
	//sussequent doctype upload
	
	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/button")
	public WebElement docdrop1;
	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/div/ul/li")
	public static List<WebElement> docvalue1;
	
	@FindBy(xpath = "//*[@id='respondqueryupload']/div/div[1]/div[1]/div/div/button")
	public WebElement docdrop2;
	@FindBy(xpath = "//*[@id='respondqueryupload']/div/div[1]/div[1]/div/div/div/ul/li")
	                //*[@id='respondqueryupload']/div/div[1]/div[1]/div/div/div/ul/li
	public static List<WebElement> docvalue2;
	
	//Admin document type add elements
	
	@FindBy(linkText="Manage IEC")
	WebElement manageiec;
	
	@FindBy(linkText="Manage Document Type")
	WebElement managedoctype;
	
	@FindBy(linkText="Add Document Type")
	WebElement adddoctype;
	
	@FindBy(id="add_annexure_project_type")
	WebElement projdoc1;
	
	@FindBy(id="add_annexure_review_type")
	WebElement revtype1;
	
	@FindBy(id="add_annexure_submission_type")
	WebElement subtype1;
	
	@FindBy(id="add_annexure_document_type")
	WebElement documenttype1;
	
	@FindBy(id="(//input[@id='add_project_document_type_isMandatory'])[2]")
	WebElement mandatory_no;
	
	@FindBy(id="add_project_document_type_isMandatory")
	WebElement mandatory_yes;
	
	@FindBy(id="add_edit_annexure_details")
	WebElement doctype_submit;
	
	@FindBy(xpath="//div[2]/div/div/ul/li[2]/a/span")
	WebElement continuation_dashboard;
	
	@FindBy(xpath="//div[2]/div/div/ul/li[6]/a/span")
	WebElement amend_dashboard;
	
	@FindBy(xpath="//li[3]/a/span")
	WebElement query_reply_dashboard;
	
	@FindBy(xpath="//div[3]/ul/li[4]/a")
	WebElement query_tab;
	
	@FindBy(css="span.fa.fa-edit")
	WebElement query_tab_edit;

	@FindBy(id="query_comments")
	WebElement query_comments;
	
	@FindBy(id="querysubmit")
	WebElement query_submit_button;
	
	@FindBy(xpath="//td[5]")
	WebElement project_status;
	
	@FindBy(xpath="//td[6]")
	WebElement latest_submission;
	
	@FindBy(xpath="//td[8]")
	WebElement document_status;
	
	@FindBy(linkText="Overview")
	WebElement PI_overview;
	
	@FindBy(linkText="Study Team Member")
	WebElement PI_study_team_mem;
	
	@FindBy(linkText="Project History")
	WebElement PI_history;
	
	
	 
	 //Check submission status when query replied by PI for sae other submission get MS decision as 'Letter of Permission'
	 public void CRe4_1838_1839_1840_1841_1842() throws Exception{
		 
	     //***********Initial project submission with LOP decision and sae other gets decision as Query-MS**********//
		 
		 CRe4_1833();
		 
		 System.out.println(querydoccount);
		 
		 //***********Submit query related documents and flow till MS decision************//
         
		
		 Global_Project_Submissions gp=new Global_Project_Submissions();
		 FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		 Workbook wb = Workbook.getWorkbook(fi);
		 Sheet r1 = wb.getSheet("Project Submissions");

		 String Decision_LOP = r1.getCell(2,487).getContents();
		 String Decisionfile = r1.getCell(3,487).getContents();
		 String Decisioncmnt = r1.getCell(4,487).getContents();

		 String Query_Cmnts_Continuation = r1.getCell(5,487).getContents();
		 String Document_Title_in_list = r1.getCell(6,487).getContents();
		 String Version_in_list = r1.getCell(7,487).getContents();
		 String Document_Date_in_list = r1.getCell(9,487).getContents();
		 String doc_upload = r1.getCell(8,487).getContents();

		 String ethic_com = r1.getCell(10,487).getContents();
		 String ethic_comnts = r1.getCell(11,487).getContents();

		 String Decision = r1.getCell(12,487).getContents();

		 GlobalMethods.PI_Login();

		 WebElement query_reply_dashboard = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		 query_reply_dashboard.click();

		 WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		 overview.click();

		 WebElement query_tab = GWait.Wait_GetElementByXpath("//div[3]/ul/li[4]/a");
		 query_tab.click();

		 WebElement query_tab_edit = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		 query_tab_edit.click();

		 WebElement query_comments = GWait.Wait_GetElementById("query_comments");
		 query_comments.sendKeys(Query_Cmnts_Continuation);

		 WebElement save_button3 = GWait.Wait_GetElementById("sumsave");
		 save_button3.click();

		 System.out.println("First "+TS_59.querydoccount);

		 for (int i =TS_59.querydoccount; i<=docvalue2.size()-1; i++)
			 {
			 System.out.println("Second "+TS_59.querydoccount);
			 Thread.sleep(2000);
             WebElement docdrop2 = GWait.Wait_GetElementByXpath("//form[@id='respondqueryupload']/div/div/div/div/div/button");
			 docdrop2.click();
			 String numberAsString = Integer.toString(i);
			 List<WebElement> elementsList3 = docvalue2;
			 int j= 0;
			 for (WebElement a11 : elementsList3) {
				 WebElement span = a11.findElement(By.tagName("span"));
				 System.out.println(numberAsString);
				 System.out.println(span.getAttribute("data-original-index"));
				 if (i==j) {
					 Thread.sleep(4000);
					 span.click();

					 break;
				 }
				 j++;
			 }
			 if (i==j) {

				 WebElement doc_title = GWait.Wait_GetElementById("document_title");
				 doc_title.sendKeys(Document_Title_in_list);
				 doc_version.sendKeys(Version_in_list);
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
		 
		
		 WebElement query_submit_button = GWait.Wait_GetElementById("querysubmit");
		 query_submit_button.click();
		 Thread.sleep(10000);
		 WebElement logouttA = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttA.click();
		 WebElement logoA = GWait.Wait_GetElementByCSS("img");
		 logoA.click();

		 GlobalMethods.Admin_Login();

		 WebElement query_replied_dashboard = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[4]/a/span");
		 query_replied_dashboard.click();

		 WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		 overview1.click();

		 WebElement Admin_Review = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		 Admin_Review.click();

		 WebElement forward_button = GWait.Wait_GetElementById("forward_modal_btn");
		 forward_button.click();

		 Select select_1a = new Select(ethic_selection);
		 select_1a.selectByVisibleText(ethic_com);

		 Thread.sleep(2000);
		 WebElement ethic_comments = GWait.Wait_GetElementByClassName("richText");
		 ethic_comments.sendKeys(ethic_comnts);

		 String MSname2 = ethic_ms_name.getAttribute("Value");

		 WebElement ethic_frwd = GWait.Wait_GetElementById("forward_btn");
		 ethic_frwd.click();


		 String msg3 = "Submission has been forwarded to Member Secretary" + " " + MSname2;
		 System.out.println(msg3);
		 WebElement ethic_frwd_acknowledge = GWait.Wait_GetElementByXpath("//div[@id='flash_message_admin']/p");
		 String acknowledge2 = ethic_frwd_acknowledge.getText();
		 acknowledge2.equalsIgnoreCase(msg3);

		 WebElement logout1=GWait.Wait_GetElementByXpath("//span[3]/a");
		 logout1.click();
		 WebElement logo11=GWait.Wait_GetElementByCSS("img");
		 logo11.click();


		 // MS assign reviewers & giving decision

		 GlobalMethods.MS_Login();

		 WebElement query_replied_dashboard1 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[4]/a/span");
		 query_replied_dashboard1.click();

		 WebElement Projectoverview = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		 Projectoverview.click();

		 Thread.sleep(2000);
		 GlobalMethods.Commentswindhandler();

		 WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
		 iecdecisiontab.click();

		 WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
		 Select select_8b = new Select(decisondropdown);
		 select_8b.selectByVisibleText(Decision);

		 WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
		 decisionupload.sendKeys(Decisionfile);

		 WebElement assign_comments = GWait.Wait_GetElementById("comments");
		 assign_comments.sendKeys(Decisioncmnt);

		 WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		 decisionusubmit.click();
		 Thread.sleep(10000);
		 WebElement logouttC = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttC.click();
		 WebElement logoC = GWait.Wait_GetElementByCSS("img");
		 logoC.click();

		//*******************Check for the remaining document flow after the MS decision as letter of permission*************//
		      

			GlobalMethods.PI_Login();

			WebElement Ongoingprojects = GWait.Wait_GetElementByXpath("//li[4]/a/span");
			Ongoingprojects.click();
			
			gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved", "Query Reply", "Approved");

			GlobalMethods.PI_Login();
			
			WebElement Ongoingprojects1 = GWait.Wait_GetElementByXpath("//li[4]/a/span");
			Ongoingprojects1.click();
			
			WebElement approvedprojoverview = GWait.Wait_GetElementByXpath("//td[9]/a/span");
			approvedprojoverview.click();

			WebElement newdocuments = GWait.Wait_GetElementByLinkText("Submit New Documents");
			newdocuments.click();
			
			WebElement DeviationLink = GWait.Wait_GetElementByLinkText("Deviation");
			DeviationLink.click();

			WebElement logouttD = GWait.Wait_GetElementByXpath("//span[3]/a");
			logouttD.click();
			WebElement logoD = GWait.Wait_GetElementByCSS("img");
			logoD.click();
		}
	 
	 
//		Check submission status when query replied by PI for sae other submission get MS decision as 'Disapproval Letter'
	 public void CRe4_1848_1849_1850_1851_1852() throws Exception{


		 //***********Initial project submission with LOP decision and sae other gets decision as Query-MS**********//

		 CRe4_1833();

		 //***********Submit query related documents and flow till MS decision************
		 TS_59 obj = new TS_59();
		 Global_Project_Submissions gp=new Global_Project_Submissions();

		 FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		 Workbook wb = Workbook.getWorkbook(fi);
		 Sheet r1 = wb.getSheet("Project Submissions");

		 String Decision_LOP = r1.getCell(2,489).getContents();
		 String Decisionfile = r1.getCell(3,489).getContents();
		 String Decisioncmnt = r1.getCell(4,489).getContents();

		 String Query_Cmnts_Continuation = r1.getCell(5,489).getContents();
		 String Document_Title_in_list = r1.getCell(6,489).getContents();
		 String Version_in_list = r1.getCell(7,489).getContents();
		 String Document_Date_in_list = r1.getCell(9,489).getContents();
		 String doc_upload = r1.getCell(8,489).getContents();

		 String ethic_com = r1.getCell(10,489).getContents();
		 String ethic_comnts = r1.getCell(11,489).getContents();

		 String Decision = r1.getCell(12,489).getContents();

		 GlobalMethods.PI_Login();

		 WebElement query_reply_dashboard = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		 query_reply_dashboard.click();

		 WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		 overview.click();

		 WebElement query_tab = GWait.Wait_GetElementByXpath("//div[3]/ul/li[4]/a");
		 query_tab.click();

		 WebElement query_tab_edit = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		 query_tab_edit.click();

		 WebElement query_comments = GWait.Wait_GetElementById("query_comments");
		 query_comments.sendKeys(Query_Cmnts_Continuation);

		 WebElement save_button3 = GWait.Wait_GetElementById("sumsave");
		 save_button3.click();

		 System.out.println(docvalue2.size()-1);
		 System.out.println("First "+TS_59.querydoccount);

		 for (int i =TS_59.querydoccount; i<=docvalue2.size()-1; i++)
			 {
			 System.out.println("Second "+TS_59.querydoccount);
			 Thread.sleep(2000);
			 WebElement docdrop2 = GWait.Wait_GetElementByXpath(".//*[@id='respondqueryupload']/div/div[1]/div[1]/div/div/button");
			 docdrop2.click();
			 String numberAsString = Integer.toString(i);
			 List<WebElement> elementsList3 = docvalue2;
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

				 WebElement doc_title = GWait.Wait_GetElementById("document_title");
				 doc_title.sendKeys(Document_Title_in_list);
				 doc_version.sendKeys(Version_in_list);
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
		 WebElement query_submit_button = GWait.Wait_GetElementById("querysubmit");
		 query_submit_button.click();

		 WebElement logouttA = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttA.click();
		 WebElement logoA = GWait.Wait_GetElementByCSS("img");
		 logoA.click();

		 GlobalMethods.Admin_Login();

		 WebElement query_replied_dashboard = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[4]/a/span");
		 query_replied_dashboard.click();

		 WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		 overview1.click();

		 WebElement Admin_Review = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		 Admin_Review.click();

		 WebElement forward_button = GWait.Wait_GetElementById("forward_modal_btn");
		 forward_button.click();

		 Select select_1a = new Select(ethic_selection);
		 select_1a.selectByVisibleText(ethic_com);
		 Thread.sleep(2000);
		 WebElement ethic_comments = GWait.Wait_GetElementByClassName("richText");
		 ethic_comments.sendKeys(ethic_comnts);

		 String MSname2 = ethic_ms_name.getAttribute("Value");

		 WebElement ethic_frwd = GWait.Wait_GetElementById("forward_btn");
		 ethic_frwd.click();


		 String msg3 = "Submission has been forwarded to Member Secretary" + " " + MSname2;
		 System.out.println(msg3);
		 WebElement ethic_frwd_acknowledge = GWait.Wait_GetElementByXpath("//div[@id='flash_message_admin']/p");
		 String acknowledge2 = ethic_frwd_acknowledge.getText();
		 acknowledge2.equalsIgnoreCase(msg3);

		 WebElement logouttB = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttB.click();
		 WebElement logoB = GWait.Wait_GetElementByCSS("img");
		 logoB.click();

		 // MS assign reviewers & giving decision

		 GlobalMethods.MS_Login();

		 WebElement query_replied_dashboard1 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[4]/a/span");
		 query_replied_dashboard1.click();

		 WebElement Projectoverview = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		 Projectoverview.click();

		 Thread.sleep(2000);
		 GlobalMethods.Commentswindhandler();

		 WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
		 iecdecisiontab.click();

		 WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
		 Select select_8b = new Select(decisondropdown);
		 select_8b.selectByVisibleText(Decision);

		 WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
		 decisionupload.sendKeys(Decisionfile);

		 WebElement assign_comments = GWait.Wait_GetElementById("comments");
		 assign_comments.sendKeys(Decisioncmnt);
		 Thread.sleep(10000);
		 WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		 decisionusubmit.click();
		 Thread.sleep(8000);
		 WebElement logouttC = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttC.click();
		 WebElement logoC = GWait.Wait_GetElementByCSS("img");
		 logoC.click();

		 //*******************Check for the remaining document flow after the MS decision as letter of permission*************//	 

		 GlobalMethods.PI_Login();

		 WebElement PI_project_menu1 = GWait.Wait_GetElementByLinkText("My Projects");
		 PI_project_menu1.click();

		 WebElement overview12 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		 overview12.click();

		 WebElement newdocuments = GWait.Wait_GetElementByLinkText("Submit New Documents");
		 newdocuments.click();

		 WebElement DeviationLink = GWait.Wait_GetElementByLinkText("Deviation");
		 DeviationLink.click();

		 WebElement logouttD = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttD.click();
		 WebElement logoD = GWait.Wait_GetElementByCSS("img");
		 logoD.click();
	 }
	 
	 
	 //Check submission status when query replied by PI for sae other submission get MS decision as 'Provisional Letter of Permission
	 public void CRe4_1853_1854_1855_1856_1857() throws Exception{
		 
     //***********Initial project submission with LOP decision and sae other gets decision as Query-MS**********//
		 
		 CRe4_1833();
		 
	//***********Submit query related documents and flow till MS decision************
			

		    Global_Project_Submissions gp=new Global_Project_Submissions();
		    FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("Project Submissions");
			
			String Decision_LOP = r1.getCell(2,491).getContents();
			String Decisionfile = r1.getCell(3,491).getContents();
			String Decisioncmnt = r1.getCell(4,491).getContents();
			String Query_Cmnts_Continuation = r1.getCell(5,491).getContents();
			String Document_Title_in_list = r1.getCell(6,491).getContents();
			String Version_in_list = r1.getCell(7,491).getContents();
			String Document_Date_in_list = r1.getCell(9,491).getContents();
			String doc_upload = r1.getCell(8,491).getContents();
			
			String ethic_com = r1.getCell(10,491).getContents();
			String ethic_comnts = r1.getCell(11,491).getContents();
			
			String Decision = r1.getCell(12,491).getContents();
			
			GlobalMethods.PI_Login();

			WebElement query_reply_dashboard = GWait.Wait_GetElementByXpath("//li[3]/a/span");
			query_reply_dashboard.click();

			WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
			overview.click();

			WebElement query_tab = GWait.Wait_GetElementByXpath("//div[3]/ul/li[4]/a");
			query_tab.click();

			WebElement query_tab_edit = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
			query_tab_edit.click();
			
			WebElement query_comments = GWait.Wait_GetElementById("query_comments");
			query_comments.sendKeys(Query_Cmnts_Continuation);
			
			WebElement save_button3 = GWait.Wait_GetElementById("sumsave");
			save_button3.click();
			
			System.out.println("First "+TS_59.querydoccount);

			 for (int i =TS_59.querydoccount; i<=docvalue2.size()-1; i++)
				 {
				 System.out.println("Second "+TS_59.querydoccount);
				 Thread.sleep(2000);
				WebElement docdrop2 = GWait.Wait_GetElementByXpath("//form[@id='respondqueryupload']/div/div/div/div/div/button");
				
				docdrop2.click();
				String numberAsString = Integer.toString(i);
				List<WebElement> elementsList3 = docvalue2;
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
					
					WebElement doc_title = GWait.Wait_GetElementById("document_title");
					doc_title.sendKeys(Document_Title_in_list);
					doc_version.sendKeys(Version_in_list);
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
			WebElement query_submit_button = GWait.Wait_GetElementById("querysubmit");
			query_submit_button.click();
			
			WebElement logouttA = GWait.Wait_GetElementByXpath("//span[3]/a");
			logouttA.click();
			WebElement logoA = GWait.Wait_GetElementByCSS("img");
			logoA.click();
			
			GlobalMethods.Admin_Login();

			WebElement query_replied_dashboard = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[4]/a/span");
			query_replied_dashboard.click();

			WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
			overview1.click();

			WebElement Admin_Review = GWait.Wait_GetElementByLinkText("IEC Admin Review");
			Admin_Review.click();

			WebElement forward_button = GWait.Wait_GetElementById("forward_modal_btn");
			forward_button.click();
			
			Select select_1a = new Select(ethic_selection);
			select_1a.selectByVisibleText(ethic_com);
	        Thread.sleep(2000);
			WebElement ethic_comments = GWait.Wait_GetElementByClassName("richText");
			ethic_comments.sendKeys(ethic_comnts);

			String MSname2 = ethic_ms_name.getAttribute("Value");
			
			WebElement ethic_frwd = GWait.Wait_GetElementById("forward_btn");
			ethic_frwd.click();
			

			String msg3 = "Submission has been forwarded to Member Secretary" + " " + MSname2;
			System.out.println(msg3);
			WebElement ethic_frwd_acknowledge = GWait.Wait_GetElementByXpath("//div[@id='flash_message_admin']/p");
			String acknowledge2 = ethic_frwd_acknowledge.getText();
			acknowledge2.equalsIgnoreCase(msg3);
			
			WebElement logouttB = GWait.Wait_GetElementByXpath("//span[3]/a");
			logouttB.click();
			WebElement logoB = GWait.Wait_GetElementByCSS("img");
			logoB.click();

			// MS assign reviewers & giving decision

			GlobalMethods.MS_Login();

			WebElement query_replied_dashboard1 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[4]/a/span");
			query_replied_dashboard1.click();

			WebElement Projectoverview = GWait.Wait_GetElementByXpath("//td[10]/a/span");
			Projectoverview.click();

			Thread.sleep(5000);
			GlobalMethods.Commentswindhandler();

			WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
			iecdecisiontab.click();

			WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
			Select select_8b = new Select(decisondropdown);
			select_8b.selectByVisibleText(Decision);

			WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
			decisionupload.sendKeys(Decisionfile);

			WebElement assign_comments = GWait.Wait_GetElementById("comments");
			assign_comments.sendKeys(Decisioncmnt);

			WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
			decisionusubmit.click();
			Thread.sleep(8000);
			WebElement logouttC = GWait.Wait_GetElementByXpath("//span[3]/a");
			logouttC.click();
			WebElement logoC = GWait.Wait_GetElementByCSS("img");
			logoC.click();
			
			//*****************Checking Edit Option after provinsional letter of permission****************//

			GlobalMethods.PI_Login();

			WebElement query_reply_dashboard1 = GWait.Wait_GetElementByXpath("//li[3]/a/span");
			query_reply_dashboard1.click();

			gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Approved", "Query Reply", "Provisional Permission");

			GlobalMethods.PI_Login();

			WebElement query_reply_dashboard11 = GWait.Wait_GetElementByXpath("//li[3]/a/span");
			query_reply_dashboard11.click();
			
			WebElement query_tab_edit1 = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
			query_tab_edit1.click();

			WebElement logouttD = GWait.Wait_GetElementByXpath("//span[3]/a");
			logouttD.click();
			WebElement logoD = GWait.Wait_GetElementByCSS("img");
			logoD.click();

		}
	//Check submission status when query replied by PI for sae other submission get MS decision as 'Query Letter � MS'
	 public void CRe4_1858_1859_1860_1861_1862() throws Exception{	

		 //***********Initial project submission with LOP decision and sae other gets decision as Query-MS**********//

		 CRe4_1833();

		 //***********Submit query related documents and flow till MS decision************

		 Global_Project_Submissions gp=new Global_Project_Submissions();
		 FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		 Workbook wb = Workbook.getWorkbook(fi);
		 Sheet r1 = wb.getSheet("Project Submissions");

		 String Decision_LOP = r1.getCell(2,493).getContents();
		 String Decisionfile = r1.getCell(3,493).getContents();
		 String Decisioncmnt = r1.getCell(4,493).getContents();

		 String Query_Cmnts_Continuation = r1.getCell(5,493).getContents();
		 String Document_Title_in_list = r1.getCell(6,493).getContents();
		 String Version_in_list = r1.getCell(7,493).getContents();
		 String Document_Date_in_list = r1.getCell(9,493).getContents();
		 String doc_upload = r1.getCell(8,493).getContents();

		 String ethic_com = r1.getCell(10,493).getContents();
		 String ethic_comnts = r1.getCell(11,493).getContents();

		 String Decision = r1.getCell(12,493).getContents();

		 GlobalMethods.PI_Login();

		 WebElement query_reply_dashboard = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		 query_reply_dashboard.click();

		 WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		 overview.click();

		 WebElement query_tab = GWait.Wait_GetElementByXpath("//div[3]/ul/li[4]/a");
		 query_tab.click();

		 WebElement query_tab_edit = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		 query_tab_edit.click();

		 WebElement query_comments = GWait.Wait_GetElementById("query_comments");
		 query_comments.sendKeys(Query_Cmnts_Continuation);

		 WebElement save_button3 = GWait.Wait_GetElementById("sumsave");
		 save_button3.click();

		 System.out.println("First "+TS_59.querydoccount);

		 for (int i =TS_59.querydoccount; i<=docvalue2.size()-1; i++)
			 {
			 System.out.println("Second "+TS_59.querydoccount);
			 Thread.sleep(2000);
			 WebElement docdrop2 = GWait.Wait_GetElementByXpath("//form[@id='respondqueryupload']/div/div/div/div/div/button");
			 docdrop2.click();
			 String numberAsString = Integer.toString(i);
			 List<WebElement> elementsList3 = docvalue2;
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

				 WebElement doc_title = GWait.Wait_GetElementById("document_title");
				 doc_title.sendKeys(Document_Title_in_list);
				 doc_version.sendKeys(Version_in_list);
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
		 WebElement query_submit_button = GWait.Wait_GetElementById("querysubmit");
		 query_submit_button.click();

		 WebElement logouttA = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttA.click();
		 WebElement logoA = GWait.Wait_GetElementByCSS("img");
		 logoA.click();

		 GlobalMethods.Admin_Login();

		 WebElement query_replied_dashboard = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[4]/a/span");
		 query_replied_dashboard.click();

		 WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		 overview1.click();

		 WebElement Admin_Review = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		 Admin_Review.click();

		 WebElement forward_button = GWait.Wait_GetElementById("forward_modal_btn");
		 forward_button.click();

		 Select select_1a = new Select(ethic_selection);
		 select_1a.selectByVisibleText(ethic_com);
		 Thread.sleep(2000);
		 WebElement ethic_comments = GWait.Wait_GetElementByClassName("richText");
		 ethic_comments.sendKeys(ethic_comnts);

		 String MSname2 = ethic_ms_name.getAttribute("Value");

		 WebElement ethic_frwd = GWait.Wait_GetElementById("forward_btn");
		 ethic_frwd.click();


		 String msg3 = "Submission has been forwarded to Member Secretary" + " " + MSname2;
		 System.out.println(msg3);
		 WebElement ethic_frwd_acknowledge = GWait.Wait_GetElementByXpath("//div[@id='flash_message_admin']/p");
		 String acknowledge2 = ethic_frwd_acknowledge.getText();
		 acknowledge2.equalsIgnoreCase(msg3);

		 WebElement logouttB = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttB.click();
		 WebElement logoB = GWait.Wait_GetElementByCSS("img");
		 logoB.click();

		 // MS assign reviewers & giving decision

		 GlobalMethods.MS_Login();

		 WebElement query_replied_dashboard1 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[4]/a/span");
		 query_replied_dashboard1.click();

		 WebElement Projectoverview = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		 Projectoverview.click();

		 Thread.sleep(2000);
		 GlobalMethods.Commentswindhandler();

		 WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
		 iecdecisiontab.click();

		 WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
		 Select select_8b = new Select(decisondropdown);
		 select_8b.selectByVisibleText(Decision);

		 WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
		 decisionupload.sendKeys(Decisionfile);

		 WebElement assign_comments = GWait.Wait_GetElementById("comments");
		 assign_comments.sendKeys(Decisioncmnt);

		 WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		 decisionusubmit.click();
		 Thread.sleep(8000);
		 WebElement logouttC = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttC.click();
		 WebElement logoC = GWait.Wait_GetElementByCSS("img");
		 logoC.click();

		 //*******************Checking Edit option after Query Letter-MS Submission***************//

		 GlobalMethods.PI_Login();

		 WebElement query_reply_dashboard14 = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		 query_reply_dashboard14.click();

		 gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220", "Approved", "Query Reply", "Query - Member Secretary");

		 GlobalMethods.PI_Login();

		 WebElement query_reply_dashboard15 = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		 query_reply_dashboard15.click();
		 
		 WebElement overview14 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		 overview14.click();

		 WebElement query_tab14 = GWait.Wait_GetElementByXpath("//div[3]/ul/li[4]/a");
		 query_tab14.click();

		 WebElement query_tab_edit14 = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		 query_tab_edit14.click();

		 WebElement logouttD = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttD.click();
		 WebElement logoD = GWait.Wait_GetElementByCSS("img");
		 logoD.click();


	 }
	 //Check submission status when query replied by PI for sae other submission get MS decision as 'Query Letter � Full Board'
	 public void CRe4_1863_1864_1865_1866_1867() throws Exception{

		 //***********Initial project submission with LOP decision and sae other gets decision as Query-MS**********//

		 CRe4_1833();


		 //***********Submit query related documents and flow till MS decision************

		 Global_Project_Submissions gp=new Global_Project_Submissions();
		 FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		 Workbook wb = Workbook.getWorkbook(fi);
		 Sheet r1 = wb.getSheet("Project Submissions");

		 String Decision_LOP = r1.getCell(2,495).getContents();
		 String Decisionfile = r1.getCell(3,495).getContents();
		 String Decisioncmnt = r1.getCell(4,495).getContents();

		 String Query_Cmnts_Continuation = r1.getCell(5,495).getContents();
		 String Document_Title_in_list = r1.getCell(6,495).getContents();
		 String Version_in_list = r1.getCell(7,495).getContents();
		 String Document_Date_in_list = r1.getCell(9,495).getContents();
		 String doc_upload = r1.getCell(8,495).getContents();

		 String ethic_com = r1.getCell(10,495).getContents();
		 String ethic_comnts = r1.getCell(11,495).getContents();

		 String Decision = r1.getCell(12,495).getContents();

		 GlobalMethods.PI_Login();

		 WebElement query_reply_dashboard = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		 query_reply_dashboard.click();

		 WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		 overview.click();

		 WebElement query_tab = GWait.Wait_GetElementByXpath("//div[3]/ul/li[4]/a");
		 query_tab.click();

		 WebElement query_tab_edit = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		 query_tab_edit.click();

		 WebElement query_comments = GWait.Wait_GetElementById("query_comments");
		 query_comments.sendKeys(Query_Cmnts_Continuation);

		 WebElement save_button3 = GWait.Wait_GetElementById("sumsave");
		 save_button3.click();

		 System.out.println("First "+TS_59.querydoccount);

		 for (int i =TS_59.querydoccount; i<=docvalue2.size()-1; i++)
			 {
			 System.out.println("Second "+TS_59.querydoccount);
			 Thread.sleep(2000);
			 WebElement docdrop2 = GWait.Wait_GetElementByXpath("//form[@id='respondqueryupload']/div/div/div/div/div/button");
			
			 docdrop2.click();
			 String numberAsString = Integer.toString(i);
			 List<WebElement> elementsList3 = docvalue2;
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

				 WebElement doc_title = GWait.Wait_GetElementById("document_title");
				 doc_title.sendKeys(Document_Title_in_list);
				 doc_version.sendKeys(Version_in_list);
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
		 WebElement query_submit_button = GWait.Wait_GetElementById("querysubmit");
		 query_submit_button.click();

		 WebElement logouttA = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttA.click();
		 WebElement logoA = GWait.Wait_GetElementByCSS("img");
		 logoA.click();

		 GlobalMethods.Admin_Login();

		 WebElement query_replied_dashboard = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[4]/a/span");
		 query_replied_dashboard.click();

		 WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		 overview1.click();

		 WebElement Admin_Review = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		 Admin_Review.click();

		 WebElement forward_button = GWait.Wait_GetElementById("forward_modal_btn");
		 forward_button.click();

		 Select select_1a = new Select(ethic_selection);
		 select_1a.selectByVisibleText(ethic_com);
		 Thread.sleep(2000);
		 WebElement ethic_comments = GWait.Wait_GetElementByClassName("richText");
		 ethic_comments.sendKeys(ethic_comnts);

		 String MSname2 = ethic_ms_name.getAttribute("Value");

		 WebElement ethic_frwd = GWait.Wait_GetElementById("forward_btn");
		 ethic_frwd.click();


		 String msg3 = "Submission has been forwarded to Member Secretary" + " " + MSname2;
		 System.out.println(msg3);
		 WebElement ethic_frwd_acknowledge = GWait.Wait_GetElementByXpath("//div[@id='flash_message_admin']/p");
		 String acknowledge2 = ethic_frwd_acknowledge.getText();
		 acknowledge2.equalsIgnoreCase(msg3);

		 WebElement logouttB = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttB.click();
		 WebElement logoB = GWait.Wait_GetElementByCSS("img");
		 logoB.click();

		 // MS assign reviewers & giving decision

		 GlobalMethods.MS_Login();

		 WebElement query_replied_dashboard1 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[4]/a/span");
		 query_replied_dashboard1.click();

		 WebElement Projectoverview = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		 Projectoverview.click();

		 Thread.sleep(2000);
		 GlobalMethods.Commentswindhandler();

		 WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
		 iecdecisiontab.click();

		 WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
		 Select select_8b = new Select(decisondropdown);
		 select_8b.selectByVisibleText(Decision);

		 WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
		 decisionupload.sendKeys(Decisionfile);

		 WebElement assign_comments = GWait.Wait_GetElementById("comments");
		 assign_comments.sendKeys(Decisioncmnt);

		 WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		 decisionusubmit.click();
		 Thread.sleep(8000);
		 WebElement logouttC = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttC.click();
		 WebElement logoC = GWait.Wait_GetElementByCSS("img");
		 logoC.click();

		 //**********************Check for the Edit option after Query-Full board**************//

		 GlobalMethods.PI_Login();

		 WebElement query_reply_dashboard11 = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		 query_reply_dashboard11.click();

		 gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220", "Approved", "Query Reply", "Query - Full Board");

		 GlobalMethods.PI_Login();

		 WebElement query_reply_dashboard15 = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		 query_reply_dashboard15.click();
		 
		 WebElement overview11 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		 overview11.click();

		 WebElement query_tab11 = GWait.Wait_GetElementByXpath("//div[3]/ul/li[4]/a");
		 query_tab11.click();

		 WebElement query_tab_edit11 = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		 query_tab_edit11.click();

		 WebElement logouttD = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttD.click();
		 WebElement logoD = GWait.Wait_GetElementByCSS("img");
		 logoD.click();

	 }
	 //Check submission status when query replied by PI for sae other submission get MS decision as 'Query Letter � Reviewers'
	 public void CRe4_1868_1869_1870_1871_1872() throws Exception{

		 //***********Initial project submission with LOP decision and sae other gets decision as Query-MS**********//

		 CRe4_1833();


		 //***********Submit query related documents and flow till MS decision************
		 Global_Project_Submissions gp=new Global_Project_Submissions();	
		 FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		 Workbook wb = Workbook.getWorkbook(fi);
		 Sheet r1 = wb.getSheet("Project Submissions");

		 String Decision_LOP = r1.getCell(2,497).getContents();
		 String Decisionfile = r1.getCell(3,497).getContents();
		 String Decisioncmnt = r1.getCell(4,497).getContents();

		 String Query_Cmnts_Continuation = r1.getCell(5,497).getContents();
		 String Document_Title_in_list = r1.getCell(6,497).getContents();
		 String Version_in_list = r1.getCell(7,497).getContents();
		 String Document_Date_in_list = r1.getCell(9,497).getContents();
		 String doc_upload = r1.getCell(8,497).getContents();

		 String ethic_com = r1.getCell(10,497).getContents();
		 String ethic_comnts = r1.getCell(11,497).getContents();

		 String Decision = r1.getCell(12,497).getContents();

		 GlobalMethods.PI_Login();

		 WebElement query_reply_dashboard = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		 query_reply_dashboard.click();

		 WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		 overview.click();

		 WebElement query_tab = GWait.Wait_GetElementByXpath("//div[3]/ul/li[4]/a");
		 query_tab.click();

		 WebElement query_tab_edit = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		 query_tab_edit.click();

		 WebElement query_comments = GWait.Wait_GetElementById("query_comments");
		 query_comments.sendKeys(Query_Cmnts_Continuation);

		 WebElement save_button3 = GWait.Wait_GetElementById("sumsave");
		 save_button3.click();

		 System.out.println("First "+TS_59.querydoccount);

		 for (int i =TS_59.querydoccount; i<=docvalue2.size()-1; i++)
			 {
			 System.out.println("Second "+TS_59.querydoccount);
			 Thread.sleep(2000);
			 WebElement docdrop2 = GWait.Wait_GetElementByXpath("//form[@id='respondqueryupload']/div/div/div/div/div/button");
			 
			 docdrop2.click();
			 String numberAsString = Integer.toString(i);
			 List<WebElement> elementsList3 = docvalue2;
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

				 WebElement doc_title = GWait.Wait_GetElementById("document_title");
				 doc_title.sendKeys(Document_Title_in_list);
				 doc_version.sendKeys(Version_in_list);
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
		 WebElement query_submit_button = GWait.Wait_GetElementById("querysubmit");
		 query_submit_button.click();

		 WebElement logouttA = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttA.click();
		 WebElement logoA = GWait.Wait_GetElementByCSS("img");
		 logoA.click();

		 GlobalMethods.Admin_Login();

		 WebElement query_replied_dashboard = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[4]/a/span");
		 query_replied_dashboard.click();

		 WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		 overview1.click();

		 WebElement Admin_Review = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		 Admin_Review.click();

		 WebElement forward_button = GWait.Wait_GetElementById("forward_modal_btn");
		 forward_button.click();

		 Select select_1a = new Select(ethic_selection);
		 select_1a.selectByVisibleText(ethic_com);
		 Thread.sleep(2000);
		 WebElement ethic_comments = GWait.Wait_GetElementByClassName("richText");
		 ethic_comments.sendKeys(ethic_comnts);

		 String MSname2 = ethic_ms_name.getAttribute("Value");

		 WebElement ethic_frwd = GWait.Wait_GetElementById("forward_btn");
		 ethic_frwd.click();


		 String msg3 = "Submission has been forwarded to Member Secretary" + " " + MSname2;
		 System.out.println(msg3);
		 WebElement ethic_frwd_acknowledge = GWait.Wait_GetElementByXpath("//div[@id='flash_message_admin']/p");
		 String acknowledge2 = ethic_frwd_acknowledge.getText();
		 acknowledge2.equalsIgnoreCase(msg3);

		 WebElement logouttB = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttB.click();
		 WebElement logoB = GWait.Wait_GetElementByCSS("img");
		 logoB.click();

		 // MS assign reviewers & giving decision

		 GlobalMethods.MS_Login();

		 WebElement query_replied_dashboard1 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[4]/a/span");
		 query_replied_dashboard1.click();

		 WebElement Projectoverview = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		 Projectoverview.click();

		 Thread.sleep(2000);
		 GlobalMethods.Commentswindhandler();

		 WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
		 iecdecisiontab.click();

		 WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
		 Select select_8b = new Select(decisondropdown);
		 select_8b.selectByVisibleText(Decision);


		 WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
		 decisionupload.sendKeys(Decisionfile);

		 WebElement assign_comments = GWait.Wait_GetElementById("comments");
		 assign_comments.sendKeys(Decisioncmnt);

		 WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		 decisionusubmit.click();
		 Thread.sleep(8000);
		 WebElement logouttC = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttC.click();
		 WebElement logoC = GWait.Wait_GetElementByCSS("img");
		 logoC.click();

		//**********************Check for the Edit option after Query-letter reviewers**************//

		 GlobalMethods.PI_Login();

		 WebElement query_reply_dashboardA = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		 query_reply_dashboardA.click();

		 gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220", "Approved", "Query Reply", "Query - Primary Reviewer");

		 GlobalMethods.PI_Login();

		 WebElement query_reply_dashboard15 = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		 query_reply_dashboard15.click();
		 
		 WebElement overviewA = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		 overviewA.click();

		 WebElement query_tabA = GWait.Wait_GetElementByXpath("//div[3]/ul/li[4]/a");
		 query_tabA.click();

		 WebElement query_tab_editA = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		 query_tab_editA.click();

		 WebElement logouttD = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttD.click();
		 WebElement logoD = GWait.Wait_GetElementByCSS("img");
		 logoD.click();


	 }
	 //Check submission status when query replied by PI for sae other submission get MS decision as 'Withdrawal letter''
	 public void CRe4_1873_1874_1875_1876_1877() throws Exception{	


		 //***********Initial project submission with LOP decision and sae other gets decision as Query-MS**********//

		 CRe4_1833();

		 //***********Submit query related documents and flow till MS decision************

		 Global_Project_Submissions gp=new Global_Project_Submissions();	
		 FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		 Workbook wb = Workbook.getWorkbook(fi);
		 Sheet r1 = wb.getSheet("Project Submissions");

		 String Decision_LOP = r1.getCell(2,499).getContents();
		 String Decisionfile = r1.getCell(3,499).getContents();
		 String Decisioncmnt = r1.getCell(4,499).getContents();

		 String Query_Cmnts_Continuation = r1.getCell(5,499).getContents();
		 String Document_Title_in_list = r1.getCell(6,499).getContents();
		 String Version_in_list = r1.getCell(7,499).getContents();
		 String Document_Date_in_list = r1.getCell(9,499).getContents();
		 String doc_upload = r1.getCell(8,499).getContents();

		 String ethic_com = r1.getCell(10,499).getContents();
		 String ethic_comnts = r1.getCell(11,499).getContents();

		 String Decision = r1.getCell(12,499).getContents();

		 GlobalMethods.PI_Login();

		 WebElement query_reply_dashboard = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		 query_reply_dashboard.click();

		 WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		 overview.click();

		 WebElement query_tab = GWait.Wait_GetElementByXpath("//div[3]/ul/li[4]/a");
		 query_tab.click();

		 WebElement query_tab_edit = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		 query_tab_edit.click();

		 WebElement query_comments = GWait.Wait_GetElementById("query_comments");
		 query_comments.sendKeys(Query_Cmnts_Continuation);

		 WebElement save_button3 = GWait.Wait_GetElementById("sumsave");
		 save_button3.click();

		 System.out.println(docvalue2.size()-1);

		 System.out.println("First "+TS_59.querydoccount);

		 for (int i =TS_59.querydoccount; i<=docvalue2.size()-1; i++)
			 {
			 System.out.println("Second "+TS_59.querydoccount);
			 Thread.sleep(2000);
			 WebElement docdrop2 = GWait.Wait_GetElementByXpath("//form[@id='respondqueryupload']/div/div/div/div/div/button");
			
			 docdrop2.click();
			 String numberAsString = Integer.toString(i);
			 List<WebElement> elementsList3 = docvalue2;
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

				 WebElement doc_title = GWait.Wait_GetElementById("document_title");
				 doc_title.sendKeys(Document_Title_in_list);
				 doc_version.sendKeys(Version_in_list);
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
		 WebElement query_submit_button = GWait.Wait_GetElementById("querysubmit");
		 query_submit_button.click();

		 WebElement logouttA = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttA.click();
		 WebElement logoA = GWait.Wait_GetElementByCSS("img");
		 logoA.click();

		 GlobalMethods.Admin_Login();

		 WebElement query_replied_dashboard = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[4]/a/span");
		 query_replied_dashboard.click();

		 WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		 overview1.click();

		 WebElement Admin_Review = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		 Admin_Review.click();

		 WebElement forward_button = GWait.Wait_GetElementById("forward_modal_btn");
		 forward_button.click();

		 Select select_1a = new Select(ethic_selection);
		 select_1a.selectByVisibleText(ethic_com);

		 Thread.sleep(2000);
		 WebElement ethic_comments = GWait.Wait_GetElementByClassName("richText");
		 ethic_comments.sendKeys(ethic_comnts);

		 String MSname2 = ethic_ms_name.getAttribute("Value");

		 WebElement ethic_frwd = GWait.Wait_GetElementById("forward_btn");
		 ethic_frwd.click();


		 String msg3 = "Submission has been forwarded to Member Secretary" + " " + MSname2;
		 System.out.println(msg3);
		 WebElement ethic_frwd_acknowledge = GWait.Wait_GetElementByXpath("//div[@id='flash_message_admin']/p");
		 String acknowledge2 = ethic_frwd_acknowledge.getText();
		 acknowledge2.equalsIgnoreCase(msg3);

		 WebElement logouttB = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttB.click();
		 WebElement logoB = GWait.Wait_GetElementByCSS("img");
		 logoB.click();

		 // MS assign reviewers & giving decision

		 GlobalMethods.MS_Login();

		 WebElement query_replied_dashboard1 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[4]/a/span");
		 query_replied_dashboard1.click();

		 WebElement Projectoverview = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		 Projectoverview.click();

		 Thread.sleep(2000);
		 GlobalMethods.Commentswindhandler();

		 WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
		 iecdecisiontab.click();

		 WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
		 Select select_8b = new Select(decisondropdown);
		 select_8b.selectByVisibleText(Decision);

		 WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
		 decisionupload.sendKeys(Decisionfile);

		 WebElement assign_comments = GWait.Wait_GetElementById("comments");
		 assign_comments.sendKeys(Decisioncmnt);

		 WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		 decisionusubmit.click();
		 Thread.sleep(8000);
		 WebElement logouttC = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttC.click();
		 WebElement logoC = GWait.Wait_GetElementByCSS("img");
		 logoC.click();

		 //***********************Check for overview and submit new documents after withdrawn letter*************//

		 GlobalMethods.PI_Login();

		 WebElement PI_project_menu = GWait.Wait_GetElementByLinkText("My Projects");
		 PI_project_menu.click();

		 gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220", "Withdrawn", "Query Reply", "Withdrawn");

		 GlobalMethods.PI_Login();

		 WebElement PI_project_menu1 = GWait.Wait_GetElementByLinkText("My Projects");
		 PI_project_menu1.click();
		 
		 WebElement overview12 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		 overview12.click();

		 boolean b=Global_Project_Submissions.isPresentAndDisplayed(newdocuments);
		 String str = String.valueOf(b);
		 String s=str.trim();
		 System.out.println(s);
		 Assert.assertEquals(s,"false");

		 WebElement logouttD = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttD.click();
		 WebElement logoD = GWait.Wait_GetElementByCSS("img");
		 logoD.click();

	 }
	 //Check submission status when query replied by PI for sae other submission get MS decision as Termination letter'
	 public void CRe4_1878_1879_1880_1881_1882() throws Exception{	

		 //***********Initial project submission with LOP decision and sae other gets decision as Query-MS**********//

		 CRe4_1833();

		 //***********Submit query related documents and flow till MS decision************

		 Global_Project_Submissions gp=new Global_Project_Submissions();	
		 FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		 Workbook wb = Workbook.getWorkbook(fi);
		 Sheet r1 = wb.getSheet("Project Submissions");

		 String Decision_LOP = r1.getCell(2,501).getContents();
		 String Decisionfile = r1.getCell(3,501).getContents();
		 String Decisioncmnt = r1.getCell(4,501).getContents();

		 String Query_Cmnts_Continuation = r1.getCell(5,501).getContents();
		 String Document_Title_in_list = r1.getCell(6,501).getContents();
		 String Version_in_list = r1.getCell(7,501).getContents();
		 String Document_Date_in_list = r1.getCell(9,501).getContents();
		 String doc_upload = r1.getCell(8,501).getContents();

		 String ethic_com = r1.getCell(10,501).getContents();
		 String ethic_comnts = r1.getCell(11,501).getContents();

		 String Decision = r1.getCell(12,501).getContents();

		 GlobalMethods.PI_Login();

		 WebElement query_reply_dashboard = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		 query_reply_dashboard.click();

		 WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		 overview.click();

		 WebElement query_tab = GWait.Wait_GetElementByXpath("//div[3]/ul/li[4]/a");
		 query_tab.click();

		 WebElement query_tab_edit = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		 query_tab_edit.click();

		 WebElement query_comments = GWait.Wait_GetElementById("query_comments");
		 query_comments.sendKeys(Query_Cmnts_Continuation);

		 WebElement save_button3 = GWait.Wait_GetElementById("sumsave");
		 save_button3.click();

		 System.out.println("First "+TS_59.querydoccount);

		 for (int i =TS_59.querydoccount; i<=docvalue2.size()-1; i++)
			 {
			 System.out.println("Second "+TS_59.querydoccount);
			 Thread.sleep(2000);
			 WebElement docdrop2 = GWait.Wait_GetElementByXpath("//form[@id='respondqueryupload']/div/div/div/div/div/button");
			 
			 docdrop2.click();
			 String numberAsString = Integer.toString(i);
			 List<WebElement> elementsList3 = docvalue2;
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

				 WebElement doc_title = GWait.Wait_GetElementById("document_title");
				 doc_title.sendKeys(Document_Title_in_list);
				 doc_version.sendKeys(Version_in_list);
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
		 WebElement query_submit_button = GWait.Wait_GetElementById("querysubmit");
		 query_submit_button.click();

		 WebElement logouttA = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttA.click();
		 WebElement logoA = GWait.Wait_GetElementByCSS("img");
		 logoA.click();

		 GlobalMethods.Admin_Login();

		 WebElement query_replied_dashboard = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[4]/a/span");
		 query_replied_dashboard.click();

		 WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		 overview1.click();

		 WebElement Admin_Review = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		 Admin_Review.click();

		 WebElement forward_button = GWait.Wait_GetElementById("forward_modal_btn");
		 forward_button.click();

		 Select select_1a = new Select(ethic_selection);
		 select_1a.selectByVisibleText(ethic_com);
		 Thread.sleep(2000);
		 WebElement ethic_comments = GWait.Wait_GetElementByClassName("richText");
		 ethic_comments.sendKeys(ethic_comnts);

		 String MSname2 = ethic_ms_name.getAttribute("Value");

		 WebElement ethic_frwd = GWait.Wait_GetElementById("forward_btn");
		 ethic_frwd.click();


		 String msg3 = "Submission has been forwarded to Member Secretary" + " " + MSname2;
		 System.out.println(msg3);
		 WebElement ethic_frwd_acknowledge = GWait.Wait_GetElementByXpath("//div[@id='flash_message_admin']/p");
		 String acknowledge2 = ethic_frwd_acknowledge.getText();
		 acknowledge2.equalsIgnoreCase(msg3);

		 WebElement logouttB = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttB.click();
		 WebElement logoB = GWait.Wait_GetElementByCSS("img");
		 logoB.click();

		 // MS assign reviewers & giving decision

		 GlobalMethods.MS_Login();

		 WebElement query_replied_dashboard1 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[4]/a/span");
		 query_replied_dashboard1.click();

		 WebElement Projectoverview = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		 Projectoverview.click();

		 Thread.sleep(2000);
		 GlobalMethods.Commentswindhandler();

		 WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
		 iecdecisiontab.click();

		 WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
		 Select select_8b = new Select(decisondropdown);
		 select_8b.selectByVisibleText(Decision);

		 WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
		 decisionupload.sendKeys(Decisionfile);

		 WebElement assign_comments = GWait.Wait_GetElementById("comments");
		 assign_comments.sendKeys(Decisioncmnt);

		 WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		 decisionusubmit.click();
		 Thread.sleep(8000);
		 WebElement logouttC = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttC.click();
		 WebElement logoC = GWait.Wait_GetElementByCSS("img");
		 logoC.click();

		 //***************Check for the Overview and submit new documents after Termination letter***********//

		 GlobalMethods.PI_Login();

		 WebElement PI_project_menu = GWait.Wait_GetElementByLinkText("My Projects");
		 PI_project_menu.click();

		 WebElement PI_archived_menu = GWait.Wait_GetElementByLinkText("Archived Projects");
		 PI_archived_menu.click();

		 gp.Global_PILoginstatus_Verify_Archived("Pushpa Project_1213_to_1220", "Archived", "Query Reply", "Terminated");

		 GlobalMethods.PI_Login();

		 WebElement PI_project_menu1 = GWait.Wait_GetElementByLinkText("My Projects");
		 PI_project_menu1.click();

		 WebElement PI_archived_menu1 = GWait.Wait_GetElementByLinkText("Archived Projects");
		 PI_archived_menu1.click();
		 
		 WebElement overview12 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		 overview12.click();

		 boolean b=Global_Project_Submissions.isPresentAndDisplayed(newdocuments);
		 String str = String.valueOf(b);
		 String s=str.trim();
		 System.out.println(s);
		 Assert.assertEquals(s,"false");


		 WebElement logouttD = GWait.Wait_GetElementByXpath("//span[3]/a");
		 logouttD.click();
		 WebElement logoD = GWait.Wait_GetElementByCSS("img");
		 logoD.click();



	 }
	 
	 
}

