package com.create4.scenarios;

import java.io.FileInputStream;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

//Check for project type change�with different�scenarios
public class TS_149 {
	public TS_149() {
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

	@FindBy(xpath = "//*[@id='projectsummary']/div/div[1]/div[1]/div/div/button")
	public WebElement projtypdrop;

	@FindBy(xpath = "//*[@id='projectsummaryedit']/div/div[1]/div[1]/div/div/button")
	public WebElement projtypdropedit;

	@FindBy(xpath = "html/body/div[5]/div[1]/div[3]/div[4]/div[1]/form/div/div[1]/div[1]/div/div/div/ul/li")
	public static List<WebElement> projtypvalue;

	@FindBy(xpath = "html/body/div[5]/div[1]/div[2]/div[2]/div[4]/div[1]/form/div/div[1]/div[1]/div/div/div/ul/li")
	public static List<WebElement> projtypvalueedit;

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

	@FindBy(css = "span.fa.fa-eye")
	WebElement overview;

	@FindBy(xpath = "//body/div[5]/div/div/div[2]/div[3]/div[1]/p")
	WebElement projectmsg;

	// Member Secretary page elements

	@FindBy(css = "span.fa.fa-edit")
	WebElement query_tab_edit;

	@FindBy(linkText = "Back")
	WebElement back_link;

	// Check for change project type after submitting documents section
	public void CRe4_2029() throws Exception {

		// Create initial project and give MS decision as 'Letter of permission'

		// Login as PI

		GlobalMethods.PI_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Projects");

		// Project summary data

		String Project_Type = r1.getCell(2, 67).getContents();
		String Project_Type_investigator = r1.getCell(3, 67).getContents();

		String Review_Type_expedited = r1.getCell(4, 67).getContents();
		String Project_Full_Title = r1.getCell(5, 67).getContents();
		String Project_Short_Title = r1.getCell(6, 67).getContents();
		String Sponsor = r1.getCell(7, 67).getContents();

		String Document_Title_in_list = r1.getCell(8, 67).getContents();
		String Version_in_list = r1.getCell(9, 67).getContents();
		String Document_Date_in_list = r1.getCell(10, 67).getContents();
		String doc_upload = r1.getCell(11, 67).getContents();

		// Saving project summary

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

//		WebElement createproject1 = GWait.Wait_GetElementByLinkText("Submit New Project");
//		createproject1.click();
		Thread.sleep(4000);
		WebElement projtypdrop1 = GWait.Wait_GetElementByCSS(".btn.dropdown-toggle.btn-default");
		projtypdrop1.click();
	

		
		
		List<WebElement> projtypvalue = GlobalMethods.driver.findElements(By.xpath(".//*[@id='projectsummary']/div/div[1]/div[1]/div/div/div/ul/li"));
		List<WebElement> elementsList111 = projtypvalue;
		for (WebElement a11 : elementsList111) {
			WebElement span = a11.findElement(By.tagName("span"));
			if (span.getText().equalsIgnoreCase(Project_Type)) {
				span.click();
				break;
			}
		}

		WebElement revtypdrop1 = GWait.Wait_GetElementByXpath("//*[@id='projectsummary']/div/div[2]/div[1]/div/div/button");
		revtypdrop1.click();
		Thread.sleep(2000);

		List<WebElement> elementsList21 = revtypvalue;
		for (WebElement a111 : elementsList21) {
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

		WebElement Full_title1 = GWait.Wait_GetElementById("projecttitle");
		Full_title1.sendKeys(Project_Full_Title);

		WebElement short_title1 = GWait.Wait_GetElementById("projectshorttitle");
		short_title1.sendKeys(Project_Short_Title);

		WebElement sponsor1 = GWait.Wait_GetElementById("project_description");
		sponsor1.sendKeys(Sponsor);

		WebElement save_button11 = GWait.Wait_GetElementByXpath("//*[@id='sumsave']");
		save_button11.click();

		Thread.sleep(4000);

		WebElement projtypdrop11 = GWait
				.Wait_GetElementByXpath(".//*[@id='projectsummary']/div/div[1]/div[1]/div/div/button");
		projtypdrop11.click();
		Thread.sleep(2000);

		List<WebElement> elementsList1a = projtypvalue;
		for (WebElement a11 : elementsList1a) {
			WebElement span = a11.findElement(By.tagName("span"));
			if (span.getText().equalsIgnoreCase(Project_Type_investigator)) {
				Thread.sleep(2000);
				String doc = span.getText();
				span.click();
				System.out.println(doc);
				break;
			}
		}
		
		
		WebElement save_button3 =GWait.Wait_GetElementById("sumsave");
		save_button3.click();
		
		Thread.sleep(3000);
		GlobalMethods.alertaccept();

		Thread.sleep(3000);
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt.click();
		
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();

	}

	// Check Project type change for a drafted project
	public void CRe4_2030_2034_2035() throws Exception {
		// Create initial project and give MS decision as 'Letter of permission'

		// Login as PI

		GlobalMethods.PI_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);

		Sheet r1 = wb.getSheet("Projects");

		// Project summary data

		String Project_Type = r1.getCell(2, 69).getContents();
		String Project_Type_investigator = r1.getCell(3, 69).getContents();

		String Review_Type_expedited = r1.getCell(4, 69).getContents();
		String Project_Full_Title = r1.getCell(5, 69).getContents();
		String Project_Short_Title = r1.getCell(6, 69).getContents();
		String Sponsor = r1.getCell(7, 69).getContents();

		String Document_Title_in_list = r1.getCell(8, 69).getContents();
		String Version_in_list = r1.getCell(9, 69).getContents();
		String Document_Date_in_list = r1.getCell(10, 69).getContents();
		String doc_upload = r1.getCell(11, 69).getContents();

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

		WebElement next_button = GWait.Wait_GetElementById("nextid");
		next_button.click();
		
		WebElement next_button1 = GWait.Wait_GetElementById("nextid");
		next_button1.click();
				
		WebElement query_tab_edit =GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		query_tab_edit.click();

		Thread.sleep(3000);
		WebElement projtypdropedit =GWait.Wait_GetElementByXpath("//*[@id='projectsummaryedit']/div/div[1]/div[1]/div/div/button");
		projtypdropedit.click();
		Thread.sleep(2000);

		List<WebElement> elementsLista = projtypvalueedit;
		for (WebElement a11 : elementsLista) {
			WebElement span = a11.findElement(By.tagName("span"));
			if (span.getText().equalsIgnoreCase(Project_Type_investigator)) {
				Thread.sleep(2000);
				String doc = span.getText();
				span.click();
				System.out.println(doc);
				break;
			}
		}

		WebElement save_button3 =GWait.Wait_GetElementById("sumsave");
		save_button3.click();
		Thread.sleep(3000);
		GlobalMethods.alertdismiss();
		Thread.sleep(3000);
		WebElement projtypdropedit1 =GWait.Wait_GetElementByXpath("//*[@id='projectsummaryedit']/div/div[1]/div[1]/div/div/button");
		projtypdropedit1.click();
		Thread.sleep(2000);

		List<WebElement> elementsList_a = projtypvalueedit;
		for (WebElement a11 : elementsList_a) {
			WebElement span = a11.findElement(By.tagName("span"));
			if (span.getText().equalsIgnoreCase(Project_Type)) {
				Thread.sleep(2000);
				String doc = span.getText();
				span.click();
				System.out.println(doc);
				break;
			}
		}
		WebElement save_button4 =GWait.Wait_GetElementById("sumsave");
		save_button4.click();

		
		Thread.sleep(3000);
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();

	}

	// Check for change project type after doing next and then back
	public void CRe4_2074_2075_2076() throws Exception {
		// Create initial project and give MS decision as 'Letter of permission'

		// Login as PI

		GlobalMethods.PI_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Projects");

		// Project summary data

		String Project_Type = r1.getCell(2, 71).getContents();
		String Project_Type_investigator = r1.getCell(3, 71).getContents();

		String Review_Type_expedited = r1.getCell(4, 71).getContents();
		
		String Project_Full_Title = r1.getCell(5, 71).getContents();
		String Project_Short_Title = r1.getCell(6, 71).getContents();
		String Sponsor = r1.getCell(7, 71).getContents();

		String Document_Title_in_list = r1.getCell(8, 71).getContents();
		String Version_in_list = r1.getCell(9, 71).getContents();
		String Document_Date_in_list = r1.getCell(10, 71).getContents();
		String doc_upload = r1.getCell(11, 71).getContents();
		String Review_Type_fullboard = r1.getCell(12, 71).getContents();
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

		WebElement next_button = GWait.Wait_GetElementById("nextid");
		next_button.click();
		
		
		WebElement back_link =GWait.Wait_GetElementByLinkText("Back");
		back_link.click();
		Thread.sleep(3000);
		WebElement revtypdrop1 = GWait
				.Wait_GetElementByXpath("//*[@id='projectsummary']/div/div[2]/div[1]/div/div/button");
		revtypdrop1.click();
		Thread.sleep(1000);

		List<WebElement> elementsList3a = revtypvalue;
		for (WebElement a111 : elementsList3a) {
			WebElement span = a111.findElement(By.tagName("span"));
			// System.out.println(Review_Type);
			// System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(Review_Type_fullboard)) {
				Thread.sleep(2000);
				String doc = span.getText();
				span.click();
				System.out.println(doc);
				break;
			}
		}
		WebElement save_button5 =GWait.Wait_GetElementById("sumsave");
		save_button5.click();

		GlobalMethods.alertdismiss();
		Thread.sleep(3000);
		WebElement projtypdrop1 = GWait
				.Wait_GetElementByXpath(".//*[@id='projectsummary']/div/div[1]/div[1]/div/div/button");
		projtypdrop1.click();
		Thread.sleep(2000);

		List<WebElement> elementsList_11 = projtypvalue;
		for (WebElement a11 : elementsList_11) {
			WebElement span = a11.findElement(By.tagName("span"));
			if (span.getText().equalsIgnoreCase(Project_Type_investigator)) {
				Thread.sleep(2000);
				String doc = span.getText();
				span.click();
				System.out.println(doc);
				break;
			}
		}
		WebElement save_button6 =GWait.Wait_GetElementById("sumsave");
		save_button6.click();
		
		Thread.sleep(3000);
		GlobalMethods.alertaccept();
		Thread.sleep(3000);
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();

	}

}
