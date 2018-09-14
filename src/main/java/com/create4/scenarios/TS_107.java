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

import jxl.Sheet;
import jxl.Workbook;

/*
 * Check for 'Project notifications' section feature functionality in PI dashboard
 */
public class TS_107 {

	public TS_107() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	

	@FindBy(xpath = ".//*[@id='projectsummary']/div/div[1]/div[1]/div/div/button")
	public WebElement projtypdrop;

	@FindBy(xpath = "html/body/div[5]/div[1]/div[3]/div[4]/div[1]/form/div/div[1]/div[1]/div/div/div/ul/li")
	public static List<WebElement> projtypvalue;

	// review type selection element

	@FindBy(xpath = "//*[@id='projectsummary']/div/div[2]/div[1]/div/div/button")
	public WebElement revtypdrop;
	@FindBy(xpath = "html/body/div[5]/div[1]/div[3]/div[4]/div[1]/form/div/div[2]/div[1]/div/div/div/ul/li")
	public static List<WebElement> revtypvalue;



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

	// Check for 'Project Notifications' section
	public void CRe4_405_406_407() throws Exception {

		
		GlobalMethods.PI_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");
		
		
		String Heading1 = r1.getCell(2, 3).getContents();
		String Heading2 = r1.getCell(3, 3).getContents();
		String Heading3 = r1.getCell(4, 3).getContents();
		
		String Projectletter = r1.getCell(5, 3).getContents();

		// Project summary data

		String Project_Type = r1.getCell(6, 3).getContents();
		String Review_Type = r1.getCell(7, 3).getContents();
		String Project_Full_Title = r1.getCell(8, 3).getContents();
		String Project_Short_Title = r1.getCell(9, 3).getContents();
		String Sponsor = r1.getCell(10, 3).getContents();

		// Submit new documents data

		String Document_Title_in_list = r1.getCell(11, 3).getContents();
		String Version_in_list = r1.getCell(12, 3).getContents();
		String Document_Date_in_list = r1.getCell(13, 3).getContents();
		String doc_upload = r1.getCell(14, 3).getContents();
		
		
		// Admin data
		String pyrcnum = r1.getCell(15, 3).getContents();
		String inwnum = r1.getCell(16, 3).getContents();
		String prjnum = r1.getCell(17, 3).getContents();
		String insdate = r1.getCell(18, 3).getContents();
		String inwrddate = r1.getCell(19, 3).getContents();
		String ethic_com = r1.getCell(20, 3).getContents();
		String ethic_comnts = r1.getCell(21, 3).getContents();

		// MS data
		String Rev_one = r1.getCell(22, 3).getContents();
		String Rev_two = r1.getCell(23, 3).getContents();
		String Rev_three = r1.getCell(24, 3).getContents();
		String Rev_four = r1.getCell(25, 3).getContents();
		String Rev_five = r1.getCell(26, 3).getContents();
		String Rev_six = r1.getCell(27, 3).getContents();
		String Rev_comnts = r1.getCell(28, 3).getContents();

		// Decision upload data
		String Decision_Query = r1.getCell(29, 3).getContents();
		String Decisionfile = r1.getCell(30, 3).getContents();
		String Decisioncmnt = r1.getCell(31, 3).getContents();
		
		//--------SUBMIT PROJECT AND GET ANY MS DECISION---//

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

		Thread.sleep(2000);
		System.out.println(docvalue.size() - 1);
		int querydoccount=0;

		for (int i = 1; i <= docvalue.size() - 1; i++) {
			querydoccount = docvalue.size();
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

		WebElement next_button = GWait.Wait_GetElementById("nextid");
		next_button.click();


		WebElement submit_to_IEC = GWait.Wait_GetElementById("submitid");
		submit_to_IEC.click();

		Thread.sleep(2000);
		WebElement no = GWait.Wait_GetElementByXpath("//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[2]");
		no.click();

		Thread.sleep(1000);
		WebElement conflictsubmit1 = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		conflictsubmit1.click();

		Thread.sleep(3000);
		GlobalMethods.alertaccept();
		
		
		Thread.sleep(6000);
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

		// WebElement forward_button =
		// GWait.Wait_GetElementById("forward_modal_btn");
		// forward_button.click();

		WebElement ethic_comments = GWait.Wait_GetElementByClassName("richText");
		ethic_comments.sendKeys(ethic_comnts);

		WebElement ethic_frwd = GWait.Wait_GetElementById("forward_btn");
		ethic_frwd.click();

		Thread.sleep(8000);
		WebElement logoutt1 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt1.click();

		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();

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

		WebElement assign_button = GWait.Wait_GetElementById("assign");
		assign_button.click();

		Thread.sleep(8000);

		GlobalMethods.Commentswindhandler();

		WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab.click();

		System.out.println(Decision_Query);
		WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
		Select select7 = new Select(decisondropdown);
		select7.selectByVisibleText(Decision_Query);

		WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
		decisionupload.sendKeys(Decisionfile);

		WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
		assign_comments2.sendKeys(Decisioncmnt);

		WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit.click();
Thread.sleep(10000);
		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();

		WebElement logo2 = GWait.Wait_GetElementByCSS("img");
		logo2.click();


		//---CHECK MS GIVEN DECISION IN PI LOGIN IN PROJECT NOTIFICATION SECTION--//
		GlobalMethods.PI_Login();

		
		Assert.assertEquals(PROJHEADING.getText().trim(), Heading1);
		
		Assert.assertEquals(PROJSNUM.getText().trim(), Heading2);
		
		Assert.assertEquals(PROJSTAT.getText().trim(), Heading3);
		
		Assert.assertEquals(PROJLETTER.getText().trim(), Projectletter);
		
		Assert.assertEquals(PROJLETTERNUM.getText().trim(), prjnum);
		
		
		WebElement logoutt1A = GWait.Wait_GetElementByXpath("//span/a");
		logoutt1A.click();
		
		WebElement logo1A = GWait.Wait_GetElementByCSS("img");
		logo1A.click();
	}
	
	@FindBy(xpath = "//div[2]/div/h3")
	WebElement PROJHEADING;
	
	@FindBy(xpath = "//th")
	WebElement PROJSNUM;
	
	@FindBy(xpath = "//th[2]")
	WebElement PROJSTAT;
	
	@FindBy(xpath = "//td[2]")
	WebElement PROJLETTER;
	
	@FindBy(xpath = "//td/a")
	WebElement PROJLETTERNUM;

}
