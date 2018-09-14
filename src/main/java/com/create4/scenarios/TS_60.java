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

//Check for withdrawal submission project status for all MS decisions
public class TS_60 {

	public TS_60() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}
    GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);



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

	// Subsequent doctype upload

	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/button")
	public WebElement docdrop1;
	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/div/ul/li")
	public static List<WebElement> docvalue1;

	public static int querydoccount=0;
	
	// Check for 'Project status' when Withdrawal submission gets MS decision as 'Noted Letter'
	public void CRe4_1899() throws Exception {
		
		
		Global_Project_Submissions gp=new Global_Project_Submissions();
		
		gp.PI_SubmitProject_IECAdmin();
		

		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt2.click();

		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();
		// *************Withdrawal Script***********************
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		// Document upload data
		String Document_Title_in_list = r1.getCell(7,117).getContents();
		String Version_in_list = r1.getCell(8, 117).getContents();
		String Document_Date_in_list = r1.getCell(9, 117).getContents();
		String doc_upload = r1.getCell(10, 117).getContents();

		GlobalMethods.PI_Login();

		WebElement PI_project_menu = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu.click();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();

		WebElement newdocuments = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments.click();

		WebElement withdrawal = GWait.Wait_GetElementByLinkText("Withdrawal");
		withdrawal.click();

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
					Thread.sleep(2000);
					span.click();

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


		//**************************Normal Flow after Completion document*****************************

		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Submitted to IEC","Withdrawn","Submitted to IEC");
		GlobalMethods.Admin_Login();
		gp.Global_Dashboard_WithdrawnLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Submitted to IEC","Withdrawn","Submitted to IEC");
		gp.SubsequentSubmissions_IECAdmin_forwardto_MS();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Under IEC Review","Withdrawn","MS Review");

		WebElement logouttA = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttA.click();
		WebElement logoA = GWait.Wait_GetElementByCSS("img");
		logoA.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu1 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu1.click();
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Under IEC Review","Withdrawn","Under IEC Review");
		GlobalMethods.MS_Login();
		gp.Global_Dashboard_MSLogin_WithdrawnLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Under IEC Review","Withdrawn","MS Review");
		gp.MS_ForwardTo_CP();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Under IEC Review","Withdrawn","Forwarded to Chairperson");

		WebElement logouttB = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttB.click();
		WebElement logoB = GWait.Wait_GetElementByCSS("img");
		logoB.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu2 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu2.click();
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Under IEC Review","Withdrawn","Under IEC Review");
		GlobalMethods.CPLogin();
		gp.Global_Dashboard_MSLogin_WithdrawnLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Under IEC Review","Withdrawn","Forwarded to Chairperson");
		gp.CP_SubmitProjectTo_MS();
		WebElement ProjectsLink = GWait.Wait_GetElementByLinkText("Projects");
		ProjectsLink.click();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Under IEC Review","Withdrawn","Chairperson Review");

		WebElement logouttC = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttC.click();
		WebElement logoC = GWait.Wait_GetElementByCSS("img");
		logoC.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu3 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu3.click();
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Under IEC Review","Withdrawn","Under IEC Review");
		GlobalMethods.MS_Login();
		gp.Global_Dashboard_MSLogin_WithdrawnLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Under IEC Review","Withdrawn","Chairperson Review");
		
		WebElement logouttD = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttD.click();
		WebElement logoD = GWait.Wait_GetElementByCSS("img");
		logoD.click();

		//*********************Login with MS and upload the decision as "Noted Letter" **********************

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r11 = wb1.getSheet("Project Submissions");

		String Decision_LOP1 = r11.getCell(11,117).getContents();
		String Decisionfile1 = r11.getCell(27,117).getContents();
		String Decisioncmnt1 = r11.getCell(28,117).getContents();

		GlobalMethods.MS_Login();

		gp.Global_Dashboard_MSLogin_WithdrawnLink();

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

		WebElement logoutt21 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt21.click();

		WebElement logo121 = GWait.Wait_GetElementByCSS("img");
		logo121.click();

		GlobalMethods.PI_Login();

		WebElement PI_project_menu21 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu21.click();


		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Withdrawn","Withdrawn","Withdrawn");
		
	}

	// Check for 'Project status' when Withdrawal submission gets MS decision as 'Query Letter'
	public void CRe4_1904() throws Exception {
		


		Global_Project_Submissions gp=new Global_Project_Submissions();
		gp.PI_SubmitProject_IECAdmin();
		Thread.sleep(6000);
		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt2.click();
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();

		// *************Withdrawal Script***********************
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		// Document upload data
		String Document_Title_in_list = r1.getCell(7,119).getContents();
		String Version_in_list = r1.getCell(8, 119).getContents();
		String Document_Date_in_list = r1.getCell(9, 119).getContents();
		String doc_upload = r1.getCell(10, 119).getContents();


		GlobalMethods.PI_Login();

		WebElement PI_project_menu = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu.click();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();

		WebElement newdocuments = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments.click();

		WebElement withdrawal = GWait.Wait_GetElementByLinkText("Withdrawal");
		withdrawal.click();

		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; i++) {
			
			querydoccount = docvalue1.size();
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
					Thread.sleep(2000);
					span.click();

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


		//**************************Normal Flow after Completion document*****************************

		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Submitted to IEC","Withdrawn","Submitted to IEC");
		GlobalMethods.Admin_Login();
		gp.Global_Dashboard_WithdrawnLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Submitted to IEC","Withdrawn","Submitted to IEC");
		gp.SubsequentSubmissions_IECAdmin_forwardto_MS();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Under IEC Review","Withdrawn","MS Review");

		WebElement logouttA = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttA.click();
		WebElement logoA = GWait.Wait_GetElementByCSS("img");
		logoA.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu1 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu1.click();
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Under IEC Review","Withdrawn","Under IEC Review");
		GlobalMethods.MS_Login();
		gp.Global_Dashboard_MSLogin_WithdrawnLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Under IEC Review","Withdrawn","MS Review");
		gp.MS_ForwardTo_CP();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Under IEC Review","Withdrawn","Forwarded to Chairperson");

		WebElement logouttB = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttB.click();
		WebElement logoB = GWait.Wait_GetElementByCSS("img");
		logoB.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu2 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu2.click();
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Under IEC Review","Withdrawn","Under IEC Review");
		GlobalMethods.CPLogin();
		gp.Global_Dashboard_MSLogin_WithdrawnLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Under IEC Review","Withdrawn","Forwarded to Chairperson");
		gp.CP_SubmitProjectTo_MS();
		WebElement ProjectsLink = GWait.Wait_GetElementByLinkText("Projects");
		ProjectsLink.click();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Under IEC Review","Withdrawn","Chairperson Review");

		WebElement logouttC = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttC.click();
		WebElement logoC = GWait.Wait_GetElementByCSS("img");
		logoC.click();

		GlobalMethods.PI_Login();
		WebElement PI_project_menu3 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu3.click();
		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Under IEC Review","Withdrawn","Under IEC Review");
		GlobalMethods.MS_Login();
		gp.Global_Dashboard_MSLogin_WithdrawnLink();
		gp.Global_OtherLoginStatus_Verify("Pushpa Project_1213_to_1220","Under IEC Review","Withdrawn","Chairperson Review");
		
		WebElement logouttD = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttD.click();
		WebElement logoD = GWait.Wait_GetElementByCSS("img");
		logoD.click();

		//*********************Login with MS and upload the decision as "Noted Letter" **********************

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r11 = wb1.getSheet("Project Submissions");

		String Decision_LOP1 = r11.getCell(11,119).getContents();
		String Decisionfile1 = r11.getCell(27,119).getContents();
		String Decisioncmnt1 = r11.getCell(28,119).getContents();

		GlobalMethods.MS_Login();

		gp.Global_Dashboard_MSLogin_WithdrawnLink();

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

		WebElement logoutt21 = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt21.click();

		WebElement logo121 = GWait.Wait_GetElementByCSS("img");
		logo121.click();

		GlobalMethods.PI_Login();

		WebElement PI_project_menu21 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu21.click();


		gp.Global_PILoginstatus_Verify("Pushpa Project_1213_to_1220","Under IEC Review","Withdrawn","Query");
		
	
	}

}
