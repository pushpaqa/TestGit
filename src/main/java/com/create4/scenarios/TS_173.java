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

import com.global.methods.Dashboard_Links;
import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

/*
 * Check for when exempt review type forwarded to MS and Got different decisions and each decision flow after that from MS
 */
public class TS_173 {

	public TS_173() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	

	@FindBy(xpath = "//form[@id='AssignPR']/div[3]/div")
	WebElement decisontext;

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

		
	// Exempt review type gets approval letter from MS
	public void exempt_LOP() throws Exception {
		

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");
	
		
		String Decision_doc = r1.getCell(2, 527).getContents();
		String Decision_comments = r1.getCell(3, 527).getContents();
		String Decision_LOP = r1.getCell(4, 527).getContents();
		

		Dashboard_Links ns = new Dashboard_Links();
		ns.EMADMINREVIEWINITIAL();
		// MS assign reviewers & giving decision

		GlobalMethods.MS_Login();

		WebElement exempt_dash = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		exempt_dash.click();

		WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview1.click();

		WebElement asignreviewers = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers.click();

		WebElement forward_chairman_button = GWait.Wait_GetElementById("forward_chairman");
		forward_chairman_button.click();

		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();

		WebElement logo2 = GWait.Wait_GetElementByCSS("img");
		logo2.click();

		GlobalMethods.CPLogin();

		WebElement exempt_dash1 = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		exempt_dash1.click();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();

		WebElement iecdecisiontab1 = GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab1.click();

		WebElement decisondropdown1 = GWait.Wait_GetElementById("decision_type");

		Select select7 = new Select(decisondropdown1);
		select7.selectByVisibleText(Decision_LOP);

		WebElement chairdecisionusubmit = GWait.Wait_GetElementByXpath("//form[@id='AssignPR']/div[5]/div/input[3]");
		chairdecisionusubmit.click();

		WebElement logoutt3 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt3.click();

		WebElement logo3 = GWait.Wait_GetElementByCSS("img");
		logo3.click();

		
	}

	// Exempt got decision as 'Dissapproved-fullboard
	public void exempt_fb() throws Exception {

		

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");
	

		String Rev_one = r1.getCell(2, 529).getContents();
		
		String decision_dissapprovefb = r1.getCell(3, 529).getContents();
		
		String decision_fbtext = r1.getCell(4, 529).getContents();
		
		String Review_Type = r1.getCell(5, 529).getContents();
		
		
       Dashboard_Links ns = new Dashboard_Links();
		ns.EMADMINREVIEWINITIAL();
		
		// MS assign reviewers & giving decision

		GlobalMethods.MS_Login();

		WebElement exempt_dash = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		exempt_dash.click();

		WebElement Projectoverview3 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview3.click();

		WebElement asignreviewers = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers.click();

		WebElement forward_chairman_button = GWait.Wait_GetElementById("forward_chairman");
		forward_chairman_button.click();

		WebElement logoutt6 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt6.click();

		WebElement logo6 = GWait.Wait_GetElementByCSS("img");
		logo6.click();

		GlobalMethods.CPLogin();

		WebElement exempt_dash1 = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		exempt_dash1.click();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();

		WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab.click();

		WebElement decisondropdown1 = GWait.Wait_GetElementById("decision_type");

		Select select71 = new Select(decisondropdown1);
		select71.selectByVisibleText(decision_dissapprovefb);

		Thread.sleep(2000);
		WebElement chairdecisionusubmit = GWait.Wait_GetElementByXpath("//form[@id='AssignPR']/div[5]/div/input[3]");
		chairdecisionusubmit.click();

		WebElement logoutt7 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt7.click();

		WebElement logo7 = GWait.Wait_GetElementByCSS("img");
		logo7.click();

		GlobalMethods.MS_Login();

		WebElement exempt_dash2 = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		exempt_dash2.click();

		WebElement Projectoverview4 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview4.click();
		WebElement asignreviewers1 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers1.click();

		String decisiontext1 = decisontext.getText();
		Assert.assertEquals(decision_fbtext, decisiontext1);
		System.out.println(decisiontext1);
		System.out.println(decision_fbtext);

		WebElement review_type_select = GWait.Wait_GetElementById("review_type");

		Select select_1b = new Select(review_type_select);
		select_1b.selectByVisibleText(Review_Type);

		WebElement primaryreview_one = GWait.Wait_GetElementById("primary_reviewer");

		Select select2a = new Select(primaryreview_one);
		select2a.selectByVisibleText(Rev_one);

		WebElement assign_button = GWait.Wait_GetElementById("assign");
		assign_button.click();

		WebElement logoutt8 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt8.click();

		WebElement logo8 = GWait.Wait_GetElementByCSS("img");
		logo8.click();
		
		

	}

	
	// Exempt got decision as 'Dissapproved-expedited
	public void exempt_exp() throws Exception {


		
		

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");

		String Rev_one = r1.getCell(2, 531).getContents();
			
		String decision_dissapproveexp = r1.getCell(3, 531).getContents();
		
		String decision_exptext = r1.getCell(4, 531).getContents();
		
		String Review_Type_expedited = r1.getCell(5, 531).getContents();
		
		
       Dashboard_Links ns = new Dashboard_Links();
		ns.EMADMINREVIEWINITIAL();
		
		// MS assign reviewers & giving decision

				GlobalMethods.MS_Login();

				WebElement exempt_dash = GWait.Wait_GetElementByXpath("//li[3]/a/span");
				exempt_dash.click();

				WebElement Projectoverview3 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
				Projectoverview3.click();

				WebElement asignreviewers = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
				asignreviewers.click();

				WebElement forward_chairman_button = GWait.Wait_GetElementById("forward_chairman");
				forward_chairman_button.click();

				WebElement logoutt6 = GWait.Wait_GetElementByXpath("//span/a");
				logoutt6.click();

				WebElement logo6 = GWait.Wait_GetElementByCSS("img");
				logo6.click();

				GlobalMethods.CPLogin();

				WebElement exempt_dash1 = GWait.Wait_GetElementByXpath("//li[3]/a/span");
				exempt_dash1.click();

				WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
				overview.click();

				WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
				iecdecisiontab.click();

				WebElement decisondropdown1 = GWait.Wait_GetElementById("decision_type");

				Select select71 = new Select(decisondropdown1);
				select71.selectByVisibleText(decision_dissapproveexp);

				WebElement chairdecisionusubmit = GWait.Wait_GetElementByXpath("//form[@id='AssignPR']/div[5]/div/input[3]");
				chairdecisionusubmit.click();

				WebElement logoutt7 = GWait.Wait_GetElementByXpath("//span/a");
				logoutt7.click();

				WebElement logo7 = GWait.Wait_GetElementByCSS("img");
				logo7.click();
				
				GlobalMethods.MS_Login();

				WebElement exempt_dash2 = GWait.Wait_GetElementByXpath("//li[3]/a/span");
				exempt_dash2.click();

				WebElement Projectoverview4 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
				Projectoverview4.click();
				WebElement asignreviewers1 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
				asignreviewers1.click();

				String decisiontext1 = decisontext.getText();
				Assert.assertEquals(decision_exptext, decisiontext1);
				System.out.println(decisiontext1);
				System.out.println(decision_exptext);

				WebElement review_type_select = GWait.Wait_GetElementById("review_type");

				Select select_1b = new Select(review_type_select);
				select_1b.selectByVisibleText(Review_Type_expedited);

				WebElement primaryreview_one = GWait.Wait_GetElementById("primary_reviewer");

				Select select2a = new Select(primaryreview_one);
				select2a.selectByVisibleText(Rev_one);

				WebElement forward_chairman_button1 = GWait.Wait_GetElementById("forward_chairman");
				forward_chairman_button1.click();

				WebElement logoutt8 = GWait.Wait_GetElementByXpath("//span/a");
				logoutt8.click();

				WebElement logo8 = GWait.Wait_GetElementByCSS("img");
				logo8.click();
				

		
	}
}
