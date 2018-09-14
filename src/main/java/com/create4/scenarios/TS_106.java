package com.create4.scenarios;

import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

//Check for 'Projects summary' section feature functionality in PI dashboard
public class TS_106 {

	public TS_106() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(css = "span.fa.fa-eye")
	WebElement overview;

	@FindBy(xpath = "//div[@id='summary']/div/div[3]/div[2]/p")
	WebElement reviewtype;

	@FindBy(linkText = "Dashboard")
	WebElement dashboardclick;

	@FindBy(xpath = "//span/a")
	WebElement logoutt;

	@FindBy(css = "img")
	WebElement logo;

	@FindBy(css = "h3")
	WebElement dashprojectsummary;

	@FindBy(xpath = "//div[2]/div/h3")
	WebElement dashprojectnotifications;

	@FindBy(xpath = "//div[4]/div/h3")
	WebElement dashannouncements;

	@FindBy(css = "span.pull-left")
	WebElement dashprojectswithsubmissions;

	@FindBy(xpath = "//li[2]/a/span")
	WebElement dashsubmitunderreview;

	@FindBy(xpath = "//li[3]/a/span")
	WebElement dashprojectswithquery;

	@FindBy(xpath = "//li[4]/a/span")
	WebElement dashongoingprojects;

	@FindBy(xpath = "//li[5]/a/span")
	WebElement dashsubmissionsreturned;

	@FindBy(css = "span.count.pull-right")
	WebElement dashcount_1;

	@FindBy(xpath = "//li[2]/a/span[2]")
	WebElement dashcount_2;

	@FindBy(xpath = "//li[3]/a/span[2]")
	WebElement dashcount_3;

	@FindBy(xpath = "//li[4]/a/span[2]")
	WebElement dashcount_4;

	@FindBy(xpath = "//li[5]/a/span[2]")
	WebElement dashcount_5;

	@FindBy(linkText = "Submit New Project")
	WebElement createproject;

	@FindBy(linkText = "My Projects")
	WebElement PI_project_menu;

	@FindBy(linkText = "Projects")
	WebElement MS_project_menu;

	@FindBy(linkText = "Archived Projects")
	WebElement PI_archived_menu;

	@FindBy(xpath = "html/body/div[5]/div[1]/div[3]/div[4]/div[1]/form/div/div[1]/div[1]/div/div/button")
	public WebElement projtypdrop;

	@FindBy(xpath = "html/body/div[5]/div[1]/div[3]/div[4]/div[1]/form/div/div[1]/div[1]/div/div/div/ul/li")
	public static List<WebElement> projtypvalue;

	// review type selection element

	@FindBy(xpath = "html/body/div[5]/div[1]/div[3]/div[4]/div[1]/form/div/div[2]/div[1]/div/div/button")
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

	@FindBy(xpath = "//div[3]/div/p")
	WebElement saveacknw;

	@FindBy(linkText = "Dashboard")
	WebElement dashpi;

	/*
	 * Check for the features on Dashboard Check for links in the Project
	 * Summary section System should display the count of all the Submissions
	 * (initial & subsequent) which are started by PI and saved as draft System
	 * should display the count of all the Submissions which are under the
	 * review of IEC System should display the count of queries/provisional
	 * letter/suspension letter received respected to project status instead of
	 * submission status will be displayed here System should display count of
	 * all the active projects which are undergoing various submissions
	 * (amendments, deviations, continuation, termination..) System should
	 * display count of all the submissions which are returned by IEC Admin In
	 * project summary queries tab will display no.of queries received per
	 * submission as super script, and it will reduce only upon action performed
	 * on it. System should navigate to My projects list with the respective
	 * status filtered
	 */

	public void CRe4_393_394_395_396_397_398_399_400_401_402_403_404_413() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		String Project_Summary = r1.getCell(2, 1).getContents();
		String Project_Notifications = r1.getCell(3, 1).getContents();
		String Announcements = r1.getCell(4, 1).getContents();

		String Projects_With_Submissions_Initiated = r1.getCell(5, 1).getContents();
		String Submission_under_IEC_Review = r1.getCell(6, 1).getContents();
		String Projects_with_Queries = r1.getCell(7, 1).getContents();
		String Ongoing_Projects = r1.getCell(8, 1).getContents();
		String Projects_With_Submission_Returned = r1.getCell(9, 1).getContents();

		// Project summary data
		String Project_Type = r1.getCell(10, 1).getContents();
		String Review_Type_fullboard = r1.getCell(11, 1).getContents();
		String Project_Full_Title = r1.getCell(12, 1).getContents();
		String Project_Short_Title = r1.getCell(13, 1).getContents();
		String Sponsor = r1.getCell(14, 1).getContents();

		// Document upload data
		String Document_Title_in_list = r1.getCell(15, 1).getContents();
		String Version_in_list = r1.getCell(16, 1).getContents();
		String Document_Date_in_list = r1.getCell(17, 1).getContents();
		String doc_upload = r1.getCell(18, 1).getContents();

		// Admin data
		String pyrcnum = r1.getCell(19, 1).getContents();
		String inwnum = r1.getCell(20, 1).getContents();
		String prjnum = r1.getCell(21, 1).getContents();
		String insdate = r1.getCell(22, 1).getContents();
		String inwrddate = r1.getCell(23, 1).getContents();
		String ethic_com = r1.getCell(24, 1).getContents();
		String ethic_comnts = r1.getCell(25, 1).getContents();

		// MS data
		String Rev_one = r1.getCell(26, 1).getContents();
		String Rev_two = r1.getCell(27, 1).getContents();
		String Rev_three = r1.getCell(28, 1).getContents();
		String Rev_four = r1.getCell(29, 1).getContents();
		String Rev_five = r1.getCell(30, 1).getContents();
		String Rev_six = r1.getCell(31, 1).getContents();
		String Rev_comnts = r1.getCell(32, 1).getContents();

		// Decision upload data
		String Decision_Query = r1.getCell(33, 1).getContents();
		String Decisionfile = r1.getCell(34, 1).getContents();
		String Decisioncmnt = r1.getCell(35, 1).getContents();
		String Decision_Prov = r1.getCell(36, 1).getContents();
		String Decision_Sus = r1.getCell(37, 1).getContents();
		String Decision_LOP = r1.getCell(38, 1).getContents();

		GlobalMethods.PI_Login();

		// Verifying dashboard elements

		Thread.sleep(3000);
		Assert.assertEquals(dashprojectsummary.getText().trim(), Project_Summary);

		Thread.sleep(3000);
		Assert.assertEquals(dashprojectnotifications.getText().trim(), Project_Notifications);

		Thread.sleep(3000);
		Assert.assertEquals(dashannouncements.getText().trim(), Announcements);

		Thread.sleep(3000);
		Assert.assertEquals(dashprojectswithsubmissions.getText().trim(), Projects_With_Submissions_Initiated);

		Thread.sleep(3000);
		Assert.assertEquals(dashsubmitunderreview.getText().trim(), Submission_under_IEC_Review);

		Thread.sleep(3000);
		Assert.assertEquals(dashprojectswithquery.getText().trim(), Projects_with_Queries);

		Thread.sleep(3000);
		Assert.assertEquals(dashongoingprojects.getText().trim(), Ongoing_Projects);

		Thread.sleep(3000);
		Assert.assertEquals(dashsubmissionsreturned.getText().trim(), Projects_With_Submission_Returned);

		// --Take initial count from " Projects With Submissions
		// Initiated(Draft)"--//

		WebElement draftscountbefore = GWait.Wait_GetElementByCSS("span.count.pull-right");

		String myString = draftscountbefore.getText();
		System.out.println(myString);
		int foo = Integer.parseInt(myString);

		int num1 = foo, num2 = 1, sum;
		sum = num1 + num2;

		System.out.println(sum);

		// ---Saving the project--//

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

		WebElement next_button1 = GWait.Wait_GetElementById("nextid");
		next_button1.click();

		// ---Checking the count of project saved in dashboard link " Projects
		// With Submissions Initiated(Draft) & redirection--//

		WebElement saveacknw = GWait.Wait_GetElementByXpath("//div[3]/div/p");
		Assert.assertEquals(saveacknw.getText().trim(), "Project saved as draft successfully.");
		Thread.sleep(3000);

		WebElement dashpi1 = GWait.Wait_GetElementByLinkText("Dashboard");
		dashpi1.click();
		Thread.sleep(1000);

		WebElement draftscountbefore1 = GWait.Wait_GetElementByCSS("span.count.pull-right");
		String myString1 = draftscountbefore1.getText();
		System.out.println(myString1);
		int foo1 = Integer.parseInt(myString1);
		System.out.println(foo1);
		Thread.sleep(1000);
		Assert.assertEquals(sum, foo1);

		// ---- CHECK FOR LINK REDIRECTION TO LIST AND VERIFY THE PROJECT
		// DISPLAY--//

		WebElement dashpi = GWait.Wait_GetElementByLinkText("Dashboard");
		dashpi.click();

		WebElement dashprojectswithsubmissions1 = GWait.Wait_GetElementByCSS("span.pull-left");
		dashprojectswithsubmissions1.click();

		Thread.sleep(4000);
		WebElement table_element1 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[8]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				if (cell.getText().equalsIgnoreCase("Pending Submission")) {
					overview.click();
					Thread.sleep(6000);
					System.out.println(reviewtype.getText());
					break;
				}

			}
			break;
		}

		// ----TAKE INITIAL COUNT FROM 'SUBMISSION UNDER IEC REVIEW"-----//

		WebElement dashpi2 = GWait.Wait_GetElementByLinkText("Dashboard");
		dashpi2.click();

		WebElement submitcountbefore = GWait.Wait_GetElementByXpath("//li[2]/a/span[2]");

		String myString2 = submitcountbefore.getText();
		System.out.println(myString2);
		int foo2 = Integer.parseInt(myString2);
		System.out.println(foo2);

		int numA1 = foo2, numA2 = 1, sumA1;
		sumA1 = numA1 + numA2;

		System.out.println(sumA1);

		// ------SUBMIT PROJECT TO ADMIN---//

		WebElement dashprojectswithsubmissions = GWait.Wait_GetElementByCSS("span.pull-left");
		dashprojectswithsubmissions.click();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();

		WebElement submisnlst = GWait.Wait_GetElementByLinkText("Submissions List");
		submisnlst.click();

		WebElement submisnedit = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		submisnedit.click();

		WebElement nxtbutton = GWait.Wait_GetElementById("nextidedit");
		nxtbutton.click();

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

		// -----CHEKING THE COUNT (AFTER) OF PROJECT SUBMITTED IN DASHBOARD LINK
		// "SUBMISSION UNDER IEC REVIEW"--//
		/*
		 * WebElement projectsclick =
		 * GWait.Wait_GetElementByLinkText("My Projects");
		 * projectsclick.click();
		 */

		Thread.sleep(2000);
		WebElement dashboardclick = GWait.Wait_GetElementByLinkText("Dashboard");
		dashboardclick.click();

		WebElement submitcountafter1 = GWait.Wait_GetElementByXpath("//li[2]/a/span[2]");

		String myString3 = submitcountafter1.getText();
		System.out.println(myString3);
		int foo3 = Integer.parseInt(myString3);

		Assert.assertEquals(sumA1, foo3);

		// --CHECK FOR LINK REDIRECTION TO LIST AND VERIFY THE PROJECT
		// DISPLAY---//

		WebElement dashsubmitunderreview = GWait.Wait_GetElementByXpath("//li[2]/a/span");
		dashsubmitunderreview.click();

		Thread.sleep(4000);
		WebElement table_element2 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows2 = (ArrayList<WebElement>) table_element2.findElements(By.tagName("tr"));
		for (WebElement row : rows2) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[8]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				if (cell.getText().equalsIgnoreCase("Submitted to IEC")) {
					WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
					overview1.click();
					Thread.sleep(6000);
					System.out.println(reviewtype.getText());
				}
				break;
			}
			break;
		}

		// ----TAKE INITIAL COUNT FROM "PROJECTS WITH QUERIES-----//

		WebElement dashboardclick1 = GWait.Wait_GetElementByLinkText("Dashboard");
		dashboardclick1.click();

		WebElement submitcountbefore3 = GWait.Wait_GetElementByXpath("//li[3]/a/span[2]");

		String myString4 = submitcountbefore3.getText();
		System.out.println(myString4);
		int foo4 = Integer.parseInt(myString4);

		int numB1 = foo4, numB2 = 1, sumB3;
		sumB3 = numB1 + numB2;
		System.out.println(sumB3);

		// -----SUBMIT PROJECT AND GET DECISION AS QUERY LETTER BY MS---//

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
GWait.LoadGif();
		Thread.sleep(20000);

		GlobalMethods.Commentswindhandler();
		Thread.sleep(8000);
		WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab.click();

		WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
		Select select7 = new Select(decisondropdown);
		select7.selectByVisibleText(Decision_Query);

		WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
		decisionupload.sendKeys(Decisionfile);

		WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
		assign_comments2.sendKeys(Decisioncmnt);

		WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit.click();
		GWait.LoadGif();
		Thread.sleep(20000);
		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();

		WebElement logo2 = GWait.Wait_GetElementByCSS("img");
		logo2.click();

		// -----CHEKING THE COUNT (AFTER) OF PROJECT GETS DECISOIN QUERY IN
		// DASHBOARD LINK
		// "PROJECTS WTIH QUERIES"--//

		GlobalMethods.PI_Login();

		WebElement submitcountafter5 = GWait.Wait_GetElementByXpath("//li[3]/a/span[2]");

		String myString5 = submitcountafter5.getText();
		System.out.println(myString5);
		int foo5 = Integer.parseInt(myString5);

		Assert.assertEquals(sumB3, foo5);

		// --CHECK FOR LINK REDIRECTION TO LIST AND VERIFY THE PROJECT
		// DISPLAY---//

		WebElement dashprojectswithquery5 = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		dashprojectswithquery5.click();
		Thread.sleep(4000);
		WebElement table_element6 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows6 = (ArrayList<WebElement>) table_element6.findElements(By.tagName("tr"));
		for (WebElement row : rows6) {
			ArrayList<WebElement> cells4 = (ArrayList<WebElement>) row.findElements(By.xpath("//td[8]"));
			for (WebElement cell : cells4) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase("Query - Full Board"));
				WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
				overview1.click();
				Thread.sleep(6000);
				System.out.println(reviewtype.getText());
				break;
			}
			break;
		}

		// ----TAKE INITIAL COUNT FROM "PROJECTS WITH QUERIES"-----//

		WebElement dashboardclick2 = GWait.Wait_GetElementByLinkText("Dashboard");
		dashboardclick2.click();

		WebElement submitcountbefore6 = GWait.Wait_GetElementByXpath("//li[3]/a/span[2]");

		String myString6 = submitcountbefore6.getText();
		System.out.println(myString6);
		int foo6 = Integer.parseInt(myString6);

		int numC1 = foo6, numC2 = 1, sumC3;
		sumC3 = numC1 + numC2;
		System.out.println(sumC3);

		// ---VERIFYING ONGOING PROJECTS COUNT FOR PROVISIONAL PERMISSION---//
		WebElement submitcountbefore6A = GWait.Wait_GetElementByXpath("//li[4]/a/span[2]");

		String myString6A = submitcountbefore6A.getText();
		System.out.println(myString6A);
		int foo6A = Integer.parseInt(myString6A);

		int numC11 = foo6A, numCC2 = 1, sumCC3;
		sumCC3 = numC11 + numCC2;
		System.out.println(sumCC3);

		// -----SUBMIT PROJECT AND GET DECISION AS PROVISIONAL LETTER BY MS---//

		WebElement createproject2 = GWait.Wait_GetElementByLinkText("Submit New Project");
		createproject2.click();

		WebElement projtypdrop2 = GWait
				.Wait_GetElementByXpath(".//*[@id='projectsummary']/div/div[1]/div[1]/div/div/button");
		projtypdrop2.click();
		Thread.sleep(2000);

		List<WebElement> elementsList2A = projtypvalue;
		for (WebElement a11 : elementsList2A) {
			WebElement span = a11.findElement(By.tagName("span"));
			if (span.getText().equalsIgnoreCase(Project_Type)) {
				span.click();
				break;
			}
		}

		WebElement revtypdrop2 = GWait
				.Wait_GetElementByXpath("//*[@id='projectsummary']/div/div[2]/div[1]/div/div/button");
		revtypdrop2.click();
		Thread.sleep(2000);

		List<WebElement> elementsList3 = revtypvalue;
		for (WebElement a111 : elementsList3) {
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

		WebElement Full_title2 = GWait.Wait_GetElementById("projecttitle");
		Full_title2.sendKeys(Project_Full_Title);

		WebElement short_title2 = GWait.Wait_GetElementById("projectshorttitle");
		short_title2.sendKeys(Project_Short_Title);

		WebElement sponsor2 = GWait.Wait_GetElementById("project_description");
		sponsor2.sendKeys(Sponsor);

		WebElement save_button12 = GWait.Wait_GetElementByXpath("//*[@id='sumsave']");
		save_button12.click();

		Thread.sleep(2000);
		System.out.println(docvalue.size() - 1);
		int count2 = docvalue.size();

		for (int i = 1; i <= docvalue.size() - 1; i++) {
			Thread.sleep(10000);
			docdrop.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
			List<WebElement> elementsList2B = docvalue;
			int j = 0;
			for (WebElement a11 : elementsList2B) {
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
		Thread.sleep(15000);

		WebElement next_button2 = GWait.Wait_GetElementById("nextid");
		next_button2.click();

		WebElement submit_to_IEC2 = GWait.Wait_GetElementById("submitid");
		submit_to_IEC2.click();

		Thread.sleep(2000);
		WebElement no2 = GWait.Wait_GetElementByXpath("//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[2]");
		no2.click();

		Thread.sleep(1000);
		WebElement conflictsubmit12 = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		conflictsubmit12.click();

		Thread.sleep(3000);
		GlobalMethods.alertaccept();

		Thread.sleep(4000);
		WebElement logoutt2a = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2a.click();

		WebElement logo2a = GWait.Wait_GetElementByCSS("img");
		logo2a.click();

		GlobalMethods.Admin_Login();

		WebElement Dashboard_newsubmission2 = GWait.Wait_GetElementByCSS("span.pull-left");
		Dashboard_newsubmission2.click();

		WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview2.click();

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

		// WebElement forward_button =
		// GWait.Wait_GetElementById("forward_modal_btn");
		// forward_button.click();

		WebElement ethic_comments2 = GWait.Wait_GetElementByClassName("richText");
		ethic_comments2.sendKeys(ethic_comnts);

		WebElement ethic_frwd2 = GWait.Wait_GetElementById("forward_btn");
		ethic_frwd2.click();
GWait.LoadGif();
		Thread.sleep(10000);
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();

		GlobalMethods.MS_Login();

		WebElement projectslink2 = GWait.Wait_GetElementByLinkText("Projects");
		projectslink2.click();

		WebElement Projectoverview12 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview12.click();

		WebElement asignreviewers2 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers2.click();

		WebElement primaryreview_one2 = GWait.Wait_GetElementById("primary_reviewer");
		Select select12 = new Select(primaryreview_one2);
		select12.selectByVisibleText(Rev_one);

		WebElement nonprimaryreview_one2 = GWait.Wait_GetElementByName("nontech_primary_reviewer1");
		Select select22a = new Select(nonprimaryreview_one2);
		select22a.selectByVisibleText(Rev_two);

		WebElement primaryreview_two2 = GWait.Wait_GetElementByName("tech_primary_reviewer2");
		Select select32 = new Select(primaryreview_two2);
		select32.selectByVisibleText(Rev_three);

		WebElement nonprimaryreview_two2 = GWait.Wait_GetElementByName("nontech_primary_reviewer2");
		Select select42 = new Select(nonprimaryreview_two2);
		select42.selectByVisibleText(Rev_four);

		WebElement primaryreview_three2 = GWait.Wait_GetElementByName("tech_primary_reviewer3");
		Select select52 = new Select(primaryreview_three2);
		select52.selectByVisibleText(Rev_five);

		WebElement nonprimaryreview_three2 = GWait.Wait_GetElementByName("nontech_primary_reviewer3");
		Select select62 = new Select(nonprimaryreview_three2);
		select62.selectByVisibleText(Rev_six);

		WebElement assign_comments22 = GWait.Wait_GetElementById("comments");
		assign_comments22.clear();

		WebElement assign_comments12 = GWait.Wait_GetElementById("comments");
		assign_comments12.sendKeys(Rev_comnts);

		WebElement assign_button2 = GWait.Wait_GetElementById("assign");
		assign_button2.click();

		Thread.sleep(8000);

		GlobalMethods.Commentswindhandler();

		WebElement iecdecisiontab2 = GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab2.click();

		Thread.sleep(2000);
		WebElement decisondropdown2 = GWait.Wait_GetElementById("decision_type");
		Select select72 = new Select(decisondropdown2);
		select72.selectByVisibleText(Decision_Prov);

		WebElement decisionupload2 = GWait.Wait_GetElementById("proj_document");
		decisionupload2.sendKeys(Decisionfile);

		WebElement assign_comments222 = GWait.Wait_GetElementById("comments");
		assign_comments222.sendKeys(Decisioncmnt);

		WebElement decisionusubmit2 = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit2.click();

		WebElement logoutt22 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt22.click();

		WebElement logo22 = GWait.Wait_GetElementByCSS("img");
		logo22.click();

		// -----CHEKING THE COUNT (AFTER) OF PROJECT GETS DECISOIN QUERY IN
		// DASHBOARD LINK
		// "PROJECTS WTIH QUERIES"--//

		GlobalMethods.PI_Login();

		WebElement dashboardclick6 = GWait.Wait_GetElementByLinkText("Dashboard");
		dashboardclick6.click();

		WebElement submitcountafter7 = GWait.Wait_GetElementByXpath("//li[3]/a/span[2]");

		String myString7 = submitcountafter7.getText();
		System.out.println(myString7);
		int foo7 = Integer.parseInt(myString7);

		Assert.assertEquals(sumC3, foo7);

		// ---VERIFYING ONGOING PROJECTS COUNT AFTER FOR PROVISIONAL
		// PERMISSION---//

		WebElement submitcountafter6A = GWait.Wait_GetElementByXpath("//li[4]/a/span[2]");

		String myString6B = submitcountafter6A.getText();
		System.out.println(myString6B);
		int foo6B = Integer.parseInt(myString6B);

		Assert.assertEquals(sumCC3, foo6B);

		// --CHECK FOR LINK REDIRECTION TO LIST AND VERIFY THE PROJECT
		// DISPLAY---//

		WebElement dashprojectswithquery2 = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		dashprojectswithquery2.click();
		Thread.sleep(4000);
		WebElement table_element5 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows5 = (ArrayList<WebElement>) table_element5.findElements(By.tagName("tr"));
		for (WebElement row : rows5) {
			ArrayList<WebElement> cells3 = (ArrayList<WebElement>) row.findElements(By.xpath("//td[8]"));
			for (WebElement cell : cells3) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase("Provisional Permission"));
				WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
				overview1.click();
				Thread.sleep(6000);
				System.out.println(reviewtype.getText());
				break;
			}
			break;
		}

		// ----TAKE INITIAL COUNT FROM "PROJECTS WITH QUERIES" SUSPENSION-----//

		WebElement dashboardclick8 = GWait.Wait_GetElementByLinkText("Dashboard");
		dashboardclick8.click();

		WebElement submitcountbefore8 = GWait.Wait_GetElementByXpath("//li[3]/a/span[2]");

		String myString8 = submitcountbefore8.getText();
		System.out.println(myString8);
		int foo8 = Integer.parseInt(myString8);

		int numD1 = foo8, numD2 = 1, sumD3;
		sumD3 = numD1 + numD2;

		

		// -----SUBMIT PROJECT AND GET DECISION AS SUSPENSION LETTER---//

		WebElement dashprojectswithquery1 = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		dashprojectswithquery1.click();

		WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview1.click();

		WebElement newdocuments = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments.click();

		WebElement deviat = GWait.Wait_GetElementByLinkText("Deviation");
		deviat.click();

		Thread.sleep(2000);
		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; i++) {
			Thread.sleep(10000);
			docdrop1.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
			List<WebElement> elementsList4 = docvalue1;
			int j = 0;
			for (WebElement a11 : elementsList4) {
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
		
		
		WebElement next_button21 = GWait.Wait_GetElementById("nextid");
		next_button21.click();

		WebElement submit_to_IEC21 = GWait.Wait_GetElementById("submitid");
		submit_to_IEC21.click();

		Thread.sleep(2000);
		WebElement no21 = GWait.Wait_GetElementByXpath("//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[2]");
		no21.click();

		Thread.sleep(1000);
		WebElement conflictsubmit121 = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		conflictsubmit121.click();

		Thread.sleep(3000);
		GlobalMethods.alertaccept();
		Thread.sleep(10000);
		WebElement logoutt81 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt81.click();

		WebElement logo81 = GWait.Wait_GetElementByCSS("img");
		logo81.click();

		GlobalMethods.Admin_Login();

		WebElement deviation_dashboard = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[7]/a/span");
		deviation_dashboard.click();

		WebElement Projectoverview2A = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview2A.click();

		WebElement Admin_Review8 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review8.click();

		WebElement forward_button8 = GWait.Wait_GetElementById("forward_modal_btn");
		forward_button8.click();

		Thread.sleep(2000);
		WebElement ethic_selection8 = GWait.Wait_GetElementById("txn_ethic_committee_id");
		Select select88 = new Select(ethic_selection8);
		select88.selectByVisibleText(ethic_com);

		// WebElement forward_button =
		// GWait.Wait_GetElementById("forward_modal_btn");
		// forward_button.click();

		WebElement ethic_comments8 = GWait.Wait_GetElementByClassName("richText");
		ethic_comments8.sendKeys(ethic_comnts);

		WebElement ethic_frwd8 = GWait.Wait_GetElementById("forward_btn");
		ethic_frwd8.click();

		Thread.sleep(6000);
		WebElement logoutt8 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt8.click();

		WebElement logo8 = GWait.Wait_GetElementByCSS("img");
		logo8.click();

		GlobalMethods.MS_Login();

		WebElement deviatms = GWait.Wait_GetElementByXpath("//li[7]/a/span");
		deviatms.click();

		WebElement Projectoverview8 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview8.click();

		WebElement asignreviewers8 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers8.click();

		WebElement primaryreview_one8 = GWait.Wait_GetElementById("primary_reviewer");
		Select select8 = new Select(primaryreview_one8);
		select8.selectByVisibleText(Rev_one);

		WebElement nonprimaryreview_one8 = GWait.Wait_GetElementByName("nontech_primary_reviewer1");
		Select select81 = new Select(nonprimaryreview_one8);
		select81.selectByVisibleText(Rev_two);

		WebElement primaryreview_two8 = GWait.Wait_GetElementByName("tech_primary_reviewer2");
		Select select82 = new Select(primaryreview_two8);
		select82.selectByVisibleText(Rev_three);

		WebElement nonprimaryreview_two8 = GWait.Wait_GetElementByName("nontech_primary_reviewer2");
		Select select83 = new Select(nonprimaryreview_two8);
		select83.selectByVisibleText(Rev_four);

		WebElement primaryreview_three8 = GWait.Wait_GetElementByName("tech_primary_reviewer3");
		Select select84 = new Select(primaryreview_three8);
		select84.selectByVisibleText(Rev_five);

		WebElement nonprimaryreview_three8 = GWait.Wait_GetElementByName("nontech_primary_reviewer3");
		Select select85 = new Select(nonprimaryreview_three8);
		select85.selectByVisibleText(Rev_six);

		WebElement assign_comments8 = GWait.Wait_GetElementById("comments");
		assign_comments8.clear();

		WebElement assign_comments81 = GWait.Wait_GetElementById("comments");
		assign_comments81.sendKeys(Rev_comnts);

		WebElement assign_button8 = GWait.Wait_GetElementById("assign");
		assign_button8.click();

		Thread.sleep(8000);

		GlobalMethods.Commentswindhandler();

		WebElement iecdecisiontab8 = GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab8.click();
		System.out.println(Decision_Sus);
		WebElement decisondropdown8 = GWait.Wait_GetElementById("decision_type");
		Select select86 = new Select(decisondropdown8);
		select86.selectByVisibleText(Decision_Sus);

		WebElement decisionupload8 = GWait.Wait_GetElementById("proj_document");
		decisionupload8.sendKeys(Decisionfile);

		WebElement assign_comments82 = GWait.Wait_GetElementById("comments");
		assign_comments82.sendKeys(Decisioncmnt);

		WebElement decisionusubmit8 = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit8.click();

		WebElement logoutt811 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt811.click();

		WebElement logo811 = GWait.Wait_GetElementByCSS("img");
		logo811.click();

		// -----CHEKING THE COUNT (AFTER) OF PROJECT GETS DECISOIN QUERY IN
		// DASHBOARD LINK
		// "PROJECTS WTIH QUERIES"--//

		GlobalMethods.PI_Login();

		WebElement submitcountafter9 = GWait.Wait_GetElementByXpath("//li[3]/a/span[2]");

		String myString9 = submitcountafter9.getText();
		System.out.println(myString9);
		int foo9 = Integer.parseInt(myString9);

		Assert.assertEquals(sumD3, foo9);

		// --CHECK FOR LINK REDIRECTION TO LIST AND VERIFY THE PROJECT
		// DISPLAY---//

		WebElement dashprojectswithquery10 = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		dashprojectswithquery10.click();
		Thread.sleep(4000);
		WebElement table_element3 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows3 = (ArrayList<WebElement>) table_element3.findElements(By.tagName("tr"));
		for (WebElement row : rows3) {
			ArrayList<WebElement> cells1 = (ArrayList<WebElement>) row.findElements(By.xpath("//td[8]"));
			for (WebElement cell : cells1) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase("Suspended"));
				WebElement overview11 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
				overview11.click();
				Thread.sleep(6000);
				System.out.println(reviewtype.getText());
				break;
			}
			break;
		}

		// ----TAKE INITIAL COUNT FROM "ONGOING PROJECTS"-----//

		WebElement dashboardclick8a = GWait.Wait_GetElementByLinkText("Dashboard");
		dashboardclick8a.click();

		WebElement submitcountbefore11 = GWait.Wait_GetElementByXpath("//li[4]/a/span[2]");

		String myString11 = submitcountbefore11.getText();
		System.out.println(myString11);
		int foo11 = Integer.parseInt(myString11);

		int numE1 = foo11, numE2 = 1, sumE3;
		sumE3 = numE1 + numE2;

		// ----SUBMIT PROJECT FOR APPROVED DECISION FROM MS-----//

		WebElement dashprojectswithquery11 = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		dashprojectswithquery11.click();

		WebElement query_tab_edit = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		query_tab_edit.click();

		Thread.sleep(2000);
		System.out.println(docvalue_sus.size() - 1);

		for (int i = 1; i <= docvalue_sus.size() - 1; i++) {
			Thread.sleep(6000);
			docdrop_sus.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
			List<WebElement> elementsList5 = docvalue_sus;
			int j = 0;
			for (WebElement a11 : elementsList5) {
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

		WebElement submit_to_IEC1 = GWait.Wait_GetElementById("submitid");
		submit_to_IEC1.click();

		WebElement logouttA = GWait.Wait_GetElementByXpath("//span/a");
		logouttA.click();

		WebElement logoA = GWait.Wait_GetElementByCSS("img");
		logoA.click();

		GlobalMethods.Admin_Login();

		WebElement Dashboard_newsubmission11 = GWait.Wait_GetElementByCSS("span.pull-left");
		Dashboard_newsubmission11.click();

		WebElement Projectoverview11 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview11.click();

		WebElement Admin_Review11 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review11.click();

		WebElement forward_button112A = GWait.Wait_GetElementById("forward_modal_btn");
		forward_button112A.click();

		Thread.sleep(2000);
		WebElement ethic_selection11 = GWait.Wait_GetElementById("txn_ethic_committee_id");
		Select select11A = new Select(ethic_selection11);
		select11A.selectByVisibleText(ethic_com);

		// WebElement forward_button =
		// GWait.Wait_GetElementById("forward_modal_btn");
		// forward_button.click();

		WebElement ethic_comments11 = GWait.Wait_GetElementByClassName("richText");
		ethic_comments11.sendKeys(ethic_comnts);

		WebElement ethic_frwd11 = GWait.Wait_GetElementById("forward_btn");
		ethic_frwd11.click();

		Thread.sleep(8000);
		WebElement logoutt111 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt111.click();

		WebElement logo111 = GWait.Wait_GetElementByCSS("img");
		logo111.click();

		GlobalMethods.MS_Login();

		WebElement fullboardlink = GWait.Wait_GetElementByCSS("span.pull-left");
		fullboardlink.click();

		WebElement Projectoverview111 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview111.click();

		WebElement asignreviewers11 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers11.click();

		WebElement primaryreview_one11 = GWait.Wait_GetElementById("primary_reviewer");
		Select select111 = new Select(primaryreview_one11);
		select111.selectByVisibleText(Rev_one);

		WebElement nonprimaryreview_one11 = GWait.Wait_GetElementByName("nontech_primary_reviewer1");
		Select select11a = new Select(nonprimaryreview_one11);
		select11a.selectByVisibleText(Rev_two);

		WebElement primaryreview_two11 = GWait.Wait_GetElementByName("tech_primary_reviewer2");
		Select select311 = new Select(primaryreview_two11);
		select311.selectByVisibleText(Rev_three);

		WebElement nonprimaryreview_two11 = GWait.Wait_GetElementByName("nontech_primary_reviewer2");
		Select select411 = new Select(nonprimaryreview_two11);
		select411.selectByVisibleText(Rev_four);

		WebElement primaryreview_three11 = GWait.Wait_GetElementByName("tech_primary_reviewer3");
		Select select511 = new Select(primaryreview_three11);
		select511.selectByVisibleText(Rev_five);

		WebElement nonprimaryreview_three11 = GWait.Wait_GetElementByName("nontech_primary_reviewer3");
		Select select611 = new Select(nonprimaryreview_three11);
		select611.selectByVisibleText(Rev_six);

		WebElement assign_comments11 = GWait.Wait_GetElementById("comments");
		assign_comments11.clear();

		WebElement assign_comments111 = GWait.Wait_GetElementById("comments");
		assign_comments111.sendKeys(Rev_comnts);

		WebElement assign_button11 = GWait.Wait_GetElementById("assign");
		assign_button11.click();

		Thread.sleep(8000);

		GlobalMethods.Commentswindhandler();

		WebElement iecdecisiontab11 = GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab11.click();

		WebElement decisondropdown11 = GWait.Wait_GetElementById("decision_type");
		Select select711 = new Select(decisondropdown11);
		select711.selectByVisibleText(Decision_LOP);

		WebElement decisionupload11 = GWait.Wait_GetElementById("proj_document");
		decisionupload11.sendKeys(Decisionfile);

		WebElement assign_comments211 = GWait.Wait_GetElementById("comments");
		assign_comments211.sendKeys(Decisioncmnt);

		WebElement decisionusubmit11 = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit11.click();

		WebElement logoutt211 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt211.click();

		WebElement logo211 = GWait.Wait_GetElementByCSS("img");
		logo211.click();

		// -----CHEKING THE COUNT (AFTER) OF ONGOING PROJECTS IN
		// DASHBOARD LINK
		// "ONGOING PROJECTS"--//

		GlobalMethods.PI_Login();

		WebElement submitcountbefore12 = GWait.Wait_GetElementByXpath("//li[4]/a/span[2]");

		String myString12 = submitcountbefore12.getText();
		System.out.println(myString12);
		int foo12 = Integer.parseInt(myString12);

		Assert.assertEquals(sumE3, foo12);

		// --CHECK FOR LINK REDIRECTION TO LIST AND VERIFY THE PROJECT
		// DISPLAY---//

		WebElement dashongoingprojects = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		dashongoingprojects.click();
		Thread.sleep(4000);
		WebElement table_element9 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows9 = (ArrayList<WebElement>) table_element9.findElements(By.tagName("tr"));
		for (WebElement row : rows9) {
			ArrayList<WebElement> cells7 = (ArrayList<WebElement>) row.findElements(By.xpath("//td[5]"));
			for (WebElement cell : cells7) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase("Approved"));
				WebElement overview11 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
				overview11.click();
				Thread.sleep(6000);
				System.out.println(reviewtype.getText());
				break;
			}
			break;
		}

		// ----TAKE INITIAL COUNT FROM "PROJECTS WITH SUBMISSION
		// RETURNED"-----//

		WebElement dashboardclick8b = GWait.Wait_GetElementByLinkText("Dashboard");
		dashboardclick8b.click();

		WebElement submitcountbefore13 = GWait.Wait_GetElementByXpath("//li[5]/a/span[2]");

		String myString13 = submitcountbefore13.getText();
		System.out.println(myString13);
		int foo13 = Integer.parseInt(myString13);
		int numF1 = foo13, numF2 = 1, sumF3;
		sumF3 = numF1 + numF2;
		System.out.println(sumF3);

		// ----SUBMIT PROJECT TO ADMIN AND GET RETUREND---//

		WebElement createproject13 = GWait.Wait_GetElementByLinkText("Submit New Project");
		createproject13.click();

		WebElement projtypdrop13 = GWait
				.Wait_GetElementByXpath(".//*[@id='projectsummary']/div/div[1]/div[1]/div/div/button");
		projtypdrop13.click();
		Thread.sleep(2000);

		List<WebElement> elementsList13 = projtypvalue;
		for (WebElement a11 : elementsList13) {
			WebElement span = a11.findElement(By.tagName("span"));
			if (span.getText().equalsIgnoreCase(Project_Type)) {
				span.click();
				break;
			}
		}

		WebElement revtypdrop13 = GWait
				.Wait_GetElementByXpath("//*[@id='projectsummary']/div/div[2]/div[1]/div/div/button");
		revtypdrop13.click();
		Thread.sleep(2000);

		List<WebElement> elementsList213 = revtypvalue;
		for (WebElement a111 : elementsList213) {
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

		WebElement Full_title13 = GWait.Wait_GetElementById("projecttitle");
		Full_title13.sendKeys(Project_Full_Title);

		WebElement short_title13 = GWait.Wait_GetElementById("projectshorttitle");
		short_title13.sendKeys(Project_Short_Title);

		WebElement sponsor13 = GWait.Wait_GetElementById("project_description");
		sponsor13.sendKeys(Sponsor);

		WebElement save_button113 = GWait.Wait_GetElementByXpath("//*[@id='sumsave']");
		save_button113.click();

		// saving Submit documents

		Thread.sleep(2000);
		System.out.println(docvalue.size() - 1);
		int count13 = docvalue.size();

		for (int i = 1; i <= docvalue.size() - 1; i++) {
			Thread.sleep(10000);
			docdrop.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
			List<WebElement> elementsList313 = docvalue;
			int j = 0;
			for (WebElement a11 : elementsList313) {
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

		WebElement next_button13 = GWait.Wait_GetElementById("nextid");
		next_button13.click();

		WebElement submit_to_IEC13 = GWait.Wait_GetElementById("submitid");
		submit_to_IEC13.click();

		Thread.sleep(2000);
		WebElement no13 = GWait.Wait_GetElementByXpath("//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[2]");
		no13.click();

		Thread.sleep(1000);
		WebElement conflictsubmit113 = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		conflictsubmit113.click();

		Thread.sleep(3000);
		GlobalMethods.alertaccept();

		Thread.sleep(3000);
		WebElement logoutt13 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt13.click();

		WebElement logo13 = GWait.Wait_GetElementByCSS("img");
		logo13.click();

		GlobalMethods.Admin_Login();

		WebElement Dashboard_newsubmission13 = GWait.Wait_GetElementByCSS("span.pull-left");
		Dashboard_newsubmission13.click();

		WebElement Projectoverview13 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview13.click();

		WebElement Admin_Review13 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review13.click();

		WebElement Return_To_PI_button = GWait.Wait_GetElementById("return_modal_btn");
		Return_To_PI_button.click();

		Thread.sleep(2000);
		WebElement Return_To_PI_comments = GWait.Wait_GetElementByXpath("//html/body/div[4]/div/div[2]/div[2]/div[5]/div/form/div/div[6]/div[2]/div/div[2]/div/div[1]/div/div/div[2]");
		Return_To_PI_comments.sendKeys("Test Comments by Admin to PI for resubmitting the project with more files which are missing");

		WebElement Returning_PI_button = GWait.Wait_GetElementById("return_btn");
		Returning_PI_button.click();
        Thread.sleep(6000);
		WebElement logoutt113 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt113.click();

		WebElement logo113 = GWait.Wait_GetElementByCSS("img");
		logo113.click();

		// -----CHEKING THE COUNT (AFTER) OF PROJECTS RETURNED IN
		// DASHBOARD LINK
		// "PROJECTS RETURNED"--//

		GlobalMethods.PI_Login();

		WebElement submitcountbefore14 = GWait.Wait_GetElementByXpath("//li[5]/a/span[2]");

		String myString14 = submitcountbefore14.getText();
		System.out.println(myString14);
		int foo14 = Integer.parseInt(myString14);

		Assert.assertEquals(sumF3, foo14);

		// --CHECK FOR LINK REDIRECTION TO LIST AND VERIFY THE PROJECT
		// DISPLAY---//

		WebElement dashsubmissionsreturned = GWait.Wait_GetElementByXpath("//li[5]/a/span[2]");
		dashsubmissionsreturned.click();
		Thread.sleep(4000);
		WebElement table_element10 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows10 = (ArrayList<WebElement>) table_element10.findElements(By.tagName("tr"));
		for (WebElement row1 : rows10) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row1.findElements(By.xpath("//td[8]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase("Returned by IEC"));
				WebElement overview11 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
				overview11.click();
				Thread.sleep(6000);
				System.out.println(reviewtype.getText());
				break;
			}
			break;
		}

		WebElement logoutt16 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt16.click();

	}

	// Subsequent doctype upload

	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/button")
	public WebElement docdrop1;
	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/div/ul/li")
	public static List<WebElement> docvalue1;

	@FindBy(xpath = "//*[@id='documentuploadprojectsuspension']/div/div[1]/div[1]/div/div[1]/button")
	public WebElement docdrop_sus;
	@FindBy(xpath = "//*[@id='documentuploadprojectsuspension']/div/div[1]/div[1]/div/div[1]/div/ul/li")
	public static List<WebElement> docvalue_sus;
}
