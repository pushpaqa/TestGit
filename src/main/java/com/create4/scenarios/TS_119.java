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
 * Check for 'IEC Submisisons / Annexure' section feature functionality in Member Secretary dashboard
 */
public class TS_119 {

	public TS_119() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "//div[4]/div[1]/div/div[2]/div[7]/div/h3")
	WebElement IECSubmissionsAnnexuresTXT;

	@FindBy(xpath = "//div[1]/div/div[2]/div[7]/div/ul/li[1]/a/span")
	WebElement GetList1;
	@FindBy(xpath = "//div[1]/div/div[2]/div[7]/div/ul/li[2]/a/span")
	WebElement GetList2;
	@FindBy(xpath = "//div[1]/div/div[2]/div[7]/div/ul/li[3]/a/span")
	WebElement GetList3;

	@FindBy(xpath = "//div[1]/div/div[2]/div[7]/div/div[1]/a")
	WebElement ViewAll;
	
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
		
		@FindBy(id = "add_annexure_document_type")
		WebElement annexure_document_type;

		@FindBy(xpath = "//*[@id='add_annexure_document_upload']")
		WebElement add_annexure_document_upload;

		@FindBy(xpath = "//form[@id='manageannexures']/div/p")
		WebElement add_annexure_acknowledge;

		@FindBy(linkText = "Publish")
		WebElement add_annexure_publish;

		@FindBy(xpath = "//span/a")
		WebElement logoutt;

		@FindBy(css = "img")
		WebElement logo;

		@FindBy(xpath = "//div[7]/div/ul/li/a/span")
		WebElement dashboard_annexure;

		@FindBy(xpath = "//td[3]")
		WebElement list_projectype;

		@FindBy(xpath = "//td[4]")
		WebElement list_submissiontype;

		@FindBy(xpath = "//td[5]")
		WebElement list_reviewtype;

		@FindBy(xpath = "//td[6]")
		WebElement list_documenttype;

	// --------Check for 'IEC Submissions / Annexures' on MS dashboard---//
	public void CRe4_516() throws Exception {

		GlobalMethods.Admin_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("ManageIEC");
			

		String Project_Type = r1.getCell(2, 236).getContents();
		String Review_Type = r1.getCell(3, 236).getContents();
		String sub_initial = r1.getCell(4, 236).getContents();
		String document_type = r1.getCell(5, 236).getContents();
		String document_upload = r1.getCell(6, 236).getContents();
		

		
		WebElement manageiec = GWait.Wait_GetElementByLinkText("Manage IEC");
		manageiec.click();
		
		WebElement managedoctype = GWait.Wait_GetElementByLinkText("Manage Document Type");
		managedoctype.click();
		
		WebElement adddoctype = GWait.Wait_GetElementByLinkText("Add Document Type");
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
		documenttype1.sendKeys(document_type);

		Thread.sleep(2000);

		// mandatory_no.click();
	
		WebElement doctype_submit = GWait.Wait_GetElementById("add_edit_annexure_details");
    	doctype_submit.click();
		
		
		WebElement admin_menu_IEC_Submission_Forms_Annexures = GWait.Wait_GetElementByLinkText("IEC Submission Forms / Annexures");
		admin_menu_IEC_Submission_Forms_Annexures.click();

		

		WebElement add_annexure_link = GWait.Wait_GetElementByLinkText("Add IEC Submission Form / Annexure");

		add_annexure_link.click();
			

		
		
		WebElement docdrop_proj = GWait.Wait_GetElementByXpath("//*[@id='addannexures']/div[1]/div/div/div/button");
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

		
		WebElement docdrop_rev  = GWait.Wait_GetElementByXpath("//*[@id='addannexures']/div[2]/div/div/div/button");
		docdrop_rev.click();
		Thread.sleep(2000);

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
		Thread.sleep(2000);

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
		select_4.selectByVisibleText(document_type);
			
		WebElement add_annexure_document_upload = GWait.Wait_GetElementByXpath("//*[@id='add_annexure_document_upload']");

		add_annexure_document_upload.sendKeys(document_upload);

	
		WebElement doctype_submit1 = GWait.Wait_GetElementById("add_edit_annexure_details");
    	doctype_submit1.click();

		
		
		Assert.assertEquals(add_annexure_acknowledge.getText(), "Annexure added successfully.");
		System.out.println(add_annexure_acknowledge.getText());

		
		
		WebElement add_annexure_publish = GWait.Wait_GetElementByLinkText("Publish");
		add_annexure_publish.click();
		Thread.sleep(4000);
		
		
		System.out.println(add_annexure_acknowledge.getText());
		
		
		
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();
		
			

	
		
		GlobalMethods.MS_Login();
		

		WebElement dashboard_annexure1 = GWait.Wait_GetElementByXpath("//div[7]/div/ul/li/a/span");
		dashboard_annexure1.click();
		Thread.sleep(2000);

		GlobalMethods.AcceptDoenloadPopup();
		Thread.sleep(2000);

		WebElement iecannexures1 = GWait.Wait_GetElementByLinkText("IEC Annexures");
		iecannexures1.click();
		Thread.sleep(4000);
		
		Assert.assertEquals(list_projectype.getText(), Project_Type);
		System.out.println(list_projectype.getText());
		
		Assert.assertEquals(list_submissiontype.getText(), sub_initial);
		System.out.println(list_submissiontype.getText());
		
		Assert.assertEquals(list_reviewtype.getText(), Review_Type);
		System.out.println(list_reviewtype.getText());
	
		Assert.assertEquals(list_documenttype.getText(), document_type);
		System.out.println(list_documenttype.getText());
	
		
		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();
		
		
		WebElement logo2 = GWait.Wait_GetElementByCSS("img");
		logo2.click();
		
	}
		

}
