package com.global.methods;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
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

//Check for 'Projects summary' section feature functionality in PI dashboard
public class Dashboard_Links {

	public Dashboard_Links() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	
	
	public static int querydoccount=0;
	
	

	// --PI SUBMITTING EXEMPT PROJECT TO IEC ADMIN--//
	public void EMNEWSUBMISSION() throws Exception {


		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Project summary data
		String Project_Type = r1.getCell(2, 21).getContents();
		String Review_Type_exempt = r1.getCell(39, 21).getContents();
		String Project_Full_Title = r1.getCell(4, 21).getContents();
		String Project_Short_Title = r1.getCell(5, 21).getContents();
		String Sponsor = r1.getCell(6, 21).getContents();

		// Document upload data
		String Document_Title_in_list = r1.getCell(7, 21).getContents();
		String Version_in_list = r1.getCell(8, 21).getContents();
		String Document_Date_in_list = r1.getCell(9, 21).getContents();
		String doc_upload = r1.getCell(10, 21).getContents();

		GlobalMethods.PI_Login();

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
			if (span.getText().equalsIgnoreCase(Review_Type_exempt)) {

				String doc = span.getText();
				span.click();
				System.out.println(doc);
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

		// WebElement docdrop =
		// GWait.Wait_GetElementByXpath("//*[@id='document_type']/div/button");

		Thread.sleep(2000);
		System.out.println(docvalue.size() - 1);
		int count = querydoccount = docvalue.size();

		for (int i = 1; i <= docvalue.size() - 1; i++) {
			Thread.sleep(10000);
			WebElement docdrop = GWait.Wait_GetElementByXpath(
					"html/body/div[5]/div[1]/div[3]/div[4]/div[2]/form/div/div[1]/div[1]/div/div/div/button");
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

				WebElement doc_version = GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);

				WebElement doc_date = GWait.Wait_GetElementById("document_date");
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

		System.out.println("PI SUBMITTING EXEMPT PROJECT TO IEC ADMIN");

	}

	// --PI SUBMITTING EXPEDITED PROJECT TO IEC ADMIN--//
	public void EXPNEWSUBMISSION() throws Exception {


		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Project summary data
		String Project_Type = r1.getCell(2, 21).getContents();
		String Review_Type_expedited = r1.getCell(38, 21).getContents();
		String Project_Full_Title = r1.getCell(4, 21).getContents();
		String Project_Short_Title = r1.getCell(5, 21).getContents();
		String Sponsor = r1.getCell(6, 21).getContents();

		// Document upload data
		String Document_Title_in_list = r1.getCell(7, 21).getContents();
		String Version_in_list = r1.getCell(8, 21).getContents();
		String Document_Date_in_list = r1.getCell(9, 21).getContents();
		String doc_upload = r1.getCell(10, 21).getContents();

		GlobalMethods.PI_Login();

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

		// WebElement docdrop =
		// GWait.Wait_GetElementByXpath("//*[@id='document_type']/div/button");

		Thread.sleep(2000);
		System.out.println(docvalue.size() - 1);
		

		for (int i = 1; i <= docvalue.size() - 1; i++) {
			querydoccount = docvalue.size();
			Thread.sleep(10000);
			WebElement docdrop = GWait.Wait_GetElementByXpath("html/body/div[5]/div[1]/div[3]/div[4]/div[2]/form/div/div[1]/div[1]/div/div/div/button");
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

				WebElement doc_version = GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);

				WebElement doc_date = GWait.Wait_GetElementById("document_date");
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

		System.out.println("PI SUBMITTING EXPEDITED PROJECT TO IEC ADMIN");

	}

	// --MS FORWARDS INITIAL EXEMPT TO CP--//
	public void EMFRWDMSBYCP() throws Exception {


		EMNEWSUBMISSION();
		EMADMINREVIEWINITIAL();
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");
		// MS data
		String Rev_one = r1.getCell(18, 21).getContents();
		String Rev_two = r1.getCell(19, 21).getContents();
		String Rev_three = r1.getCell(20, 21).getContents();
		String Rev_four = r1.getCell(21, 21).getContents();
		String Rev_five = r1.getCell(22, 21).getContents();
		String Rev_six = r1.getCell(23, 21).getContents();
		String Rev_comnts = r1.getCell(24, 21).getContents();
		
		GlobalMethods.MS_Login();

		WebElement exemrev =GWait.Wait_GetElementByXpath("//li[3]/a/span");
		exemrev.click();

		WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview1.click();

		WebElement asignreviewers = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers.click();

		
		WebElement frwdtocp_button = GWait.Wait_GetElementById("forward_chairman");
		frwdtocp_button.click();

		
		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();

		WebElement logo81 = GWait.Wait_GetElementByCSS("img");
		logo81.click();
		
		
	}
	// --ADMIN FORWARDS EXEMPT INITIAL SUBMISSION TO MS--//
	public void EMADMINREVIEWINITIAL() throws Exception {


		EMNEWSUBMISSION();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Admin data
		String pyrcnum = r1.getCell(11, 21).getContents();
		String inwnum = r1.getCell(12, 21).getContents();
		String prjnum = r1.getCell(13, 21).getContents();
		String insdate = r1.getCell(14, 21).getContents();
		String inwrddate = r1.getCell(15, 21).getContents();
		String ethic_com = r1.getCell(16, 21).getContents();
		String ethic_comnts = r1.getCell(17, 21).getContents();

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

		Thread.sleep(20000);
		GWait.LoadGif();
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();

		System.out.println("ADMIN FORWARDS EXEMPT INITIAL SUBMISSION TO MS");

	}

	// --ADMIN FORWARDS EXPEDITED INITIAL SUBMISSION TO MS--//
	public void EXPADMINREVIEWINITIAL() throws Exception {



		EXPNEWSUBMISSION();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Admin data
		String pyrcnum = r1.getCell(11, 21).getContents();
		String inwnum = r1.getCell(12, 21).getContents();
		String prjnum = r1.getCell(13, 21).getContents();
		String insdate = r1.getCell(14, 21).getContents();
		String inwrddate = r1.getCell(15, 21).getContents();
		String ethic_com = r1.getCell(16, 21).getContents();
		String ethic_comnts = r1.getCell(17, 21).getContents();

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
        Thread.sleep(5000);
		WebElement ethic_comments2 = GWait.Wait_GetElementByClassName("richText");
		ethic_comments2.sendKeys(ethic_comnts);
		Thread.sleep(5000);
		WebElement ethic_frwd2 = GWait.Wait_GetElementById("forward_btn");
		ethic_frwd2.click();

		Thread.sleep(20000);
		GWait.LoadGif();
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();

		System.out.println("ADMIN FORWARDS EXPEDITED INITIAL SUBMISSION TO MS");

	}

	// --PI SUBMITTING FULL BOARD PROJECT TO IEC ADMIN--//
	public void FBNEWSUBMISSION() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Project summary data
		String Project_Type = r1.getCell(2, 21).getContents();
		String Review_Type_fullboard = r1.getCell(3, 21).getContents();
		String Project_Full_Title = r1.getCell(4, 21).getContents();
		String Project_Short_Title = r1.getCell(5, 21).getContents();
		String Sponsor = r1.getCell(6, 21).getContents();

		// Document upload data
		String Document_Title_in_list = r1.getCell(7, 21).getContents();
		String Version_in_list = r1.getCell(8, 21).getContents();
		String Document_Date_in_list = r1.getCell(9, 21).getContents();
		String doc_upload = r1.getCell(10, 21).getContents();

		GlobalMethods.PI_Login();

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

		// WebElement docdrop =
		// GWait.Wait_GetElementByXpath("//*[@id='document_type']/div/button");

		Thread.sleep(2000);
		System.out.println(docvalue.size() - 1);
		

		for (int i = 1; i <= docvalue.size() - 1; i++) {
			querydoccount = docvalue.size();
			Thread.sleep(10000);
			WebElement docdrop = GWait.Wait_GetElementByXpath("html/body/div[5]/div[1]/div[3]/div[4]/div[2]/form/div/div[1]/div[1]/div/div/div/button");
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

				WebElement doc_version = GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);

				WebElement doc_date = GWait.Wait_GetElementById("document_date");
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

		System.out.println("PI SUBMITTING PROJECT TO IEC ADMIN");

	}

	// --MS FORWARDS INITIAL EXPEDITED TO CP--//
	public void EXPFRWDMSBYCP() throws Exception {
		EXPNEWSUBMISSION();
		EXPADMINREVIEWINITIAL();
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");
		// MS data
		String Rev_one = r1.getCell(18, 21).getContents();
		String Rev_two = r1.getCell(19, 21).getContents();
		String Rev_three = r1.getCell(20, 21).getContents();
		String Rev_four = r1.getCell(21, 21).getContents();
		String Rev_five = r1.getCell(22, 21).getContents();
		String Rev_six = r1.getCell(23, 21).getContents();
		String Rev_comnts = r1.getCell(24, 21).getContents();
		
		GlobalMethods.MS_Login();

		WebElement exprev =GWait.Wait_GetElementByXpath("//li[2]/a/span");
		exprev.click();

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

		WebElement frwdtocp_button = GWait.Wait_GetElementById("forward_chairman");
		frwdtocp_button.click();

		
		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();

		WebElement logo81 = GWait.Wait_GetElementByCSS("img");
		logo81.click();
		
		
	}
	// --ADMIN FORWARDS INITIAL SUBMISSION TO MS--//
	public void ADMINREVIEWINITIAL() throws Exception {


		FBNEWSUBMISSION();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Admin data
		String pyrcnum = r1.getCell(11, 21).getContents();
		String inwnum = r1.getCell(12, 21).getContents();
		String prjnum = r1.getCell(13, 21).getContents();
		String insdate = r1.getCell(14, 21).getContents();
		String inwrddate = r1.getCell(15, 21).getContents();
		String ethic_com = r1.getCell(16, 21).getContents();
		String ethic_comnts = r1.getCell(17, 21).getContents();

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
		Thread.sleep(2000);
		WebElement ethic_frwd2 = GWait.Wait_GetElementById("forward_btn");
		ethic_frwd2.click();

		Thread.sleep(20000);
		GWait.LoadGif();
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();

		System.out.println("ADMIN FORWARDS INITIAL SUBMISSION TO MS");

	}

	// --MS GIVES DECISION AS LETTER OF PERMISSION FOR INITIAL SUBMISSION--//
	public void MSDECISION_LOP() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");
		// MS data
		String Rev_one = r1.getCell(18, 21).getContents();
		String Rev_two = r1.getCell(19, 21).getContents();
		String Rev_three = r1.getCell(20, 21).getContents();
		String Rev_four = r1.getCell(21, 21).getContents();
		String Rev_five = r1.getCell(22, 21).getContents();
		String Rev_six = r1.getCell(23, 21).getContents();
		String Rev_comnts = r1.getCell(24, 21).getContents();

		// Decision upload data
		String Decisionfile = r1.getCell(25, 21).getContents();
		String Decisioncmnt = r1.getCell(26, 21).getContents();
		String Decision_RESUBMISSION = r1.getCell(27, 21).getContents();
		String Decision_LOP = r1.getCell(30, 21).getContents();

		//FBNEWSUBMISSION();
		ADMINREVIEWINITIAL();
		GlobalMethods.MS_Login();

		WebElement fullboardlink = GWait.Wait_GetElementByCSS("span.pull-left");
		fullboardlink.click();

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

		Thread.sleep(20000);
		GWait.LoadGif();

		GlobalMethods.Commentswindhandler();
		Thread.sleep(8000);
		WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab.click();

		WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
		Select select7 = new Select(decisondropdown);
		select7.selectByVisibleText(Decision_LOP);

		WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
		decisionupload.sendKeys(Decisionfile);

		WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
		assign_comments2.sendKeys(Decisioncmnt);

		WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit.click();
        Thread.sleep(10000);
		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();

		WebElement logo81 = GWait.Wait_GetElementByCSS("img");
		logo81.click();

		System.out.println("MS GIVES DECISION AS LETTER OF PERMISSION FOR INITIAL SUBMISSION");

	}
	
	// --ADMIN FORWARDS OTHER PROJECT TO MS--//
		public void ADMINFRWDPROJOTHRMS() throws Exception {

			
			PROJOTHERADMIN();

			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("Dashboard");

			// Admin data
			String pyrcnum = r1.getCell(11, 21).getContents();
			String inwnum = r1.getCell(12, 21).getContents();
			String prjnum = r1.getCell(13, 21).getContents();
			String insdate = r1.getCell(14, 21).getContents();
			String inwrddate = r1.getCell(15, 21).getContents();
			String ethic_com = r1.getCell(16, 21).getContents();
			String ethic_comnts = r1.getCell(17, 21).getContents();

			GlobalMethods.Admin_Login();

			WebElement approved_othersubmission = GWait.Wait_GetElementByXpath("//li[9]/a/span");
			approved_othersubmission.click();

			WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
			Projectoverview2.click();

			WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
			Admin_Review2.click();

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

			Thread.sleep(20000);
			GWait.LoadGif();
			WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
			logoutt12.click();
			Thread.sleep(8000);
			WebElement logo12 = GWait.Wait_GetElementByCSS("img");
			logo12.click();

			System.out.println("ADMIN FORWARDS OTHER PROJECT TO MS");
		
	}

	// --PI SUBMITS OTHER PROJECT TO ADMIN---//
	public void PROJOTHERADMIN() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Document upload data
		String Document_Title_in_list = r1.getCell(7, 21).getContents();
		String Version_in_list = r1.getCell(8, 21).getContents();
		String Document_Date_in_list = r1.getCell(9, 21).getContents();
		String doc_upload = r1.getCell(10, 21).getContents();

		MSDECISION_LOP();

		GlobalMethods.PI_Login();

		WebElement ongoingdash = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		ongoingdash.click();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();

		WebElement submitnewdoc = GWait.Wait_GetElementByLinkText("Submit New Documents");
		submitnewdoc.click();

		WebElement othrlink = GWait.Wait_GetElementByLinkText("Other");
		othrlink.click();

		Thread.sleep(6000);
		Thread.sleep(2000);
		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; i++) {
			Thread.sleep(10000);
			docdrop1.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
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

				WebElement doc_version = GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);

				WebElement doc_date = GWait.Wait_GetElementById("document_date");
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

		WebElement next_button1 = GWait.Wait_GetElementById("nextid");
		next_button1.click();

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

		System.out.println("PI SUBMITS OTHER PROJECT TO ADMIN");

	}

	// --ADMIN FORWARDS SAE PROJECT TO MS--//
	public void ADMINFRWDPROJSAEMS() throws Exception {


		
		PROJSAEADMIN();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Admin data
		String pyrcnum = r1.getCell(11, 21).getContents();
		String inwnum = r1.getCell(12, 21).getContents();
		String prjnum = r1.getCell(13, 21).getContents();
		String insdate = r1.getCell(14, 21).getContents();
		String inwrddate = r1.getCell(15, 21).getContents();
		String ethic_com = r1.getCell(16, 21).getContents();
		String ethic_comnts = r1.getCell(17, 21).getContents();

		GlobalMethods.Admin_Login();

		WebElement approved_sae = GWait.Wait_GetElementByXpath("//li[8]/a/span");
		approved_sae.click();

		WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview2.click();

		WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review2.click();

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

		Thread.sleep(20000);
		GWait.LoadGif();
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();

		System.out.println("ADMIN FORWARDS SAE PROJECT TO MS");
		
	}
	// --PI SUBMITS SAE PROJECT TO ADMIN---//
	public void PROJSAEADMIN() throws Exception {


		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Document upload data
		String Document_Title_in_list = r1.getCell(7, 21).getContents();
		String Version_in_list = r1.getCell(8, 21).getContents();
		String Document_Date_in_list = r1.getCell(9, 21).getContents();
		String doc_upload = r1.getCell(10, 21).getContents();

		String sae_site_type_1 = r1.getCell(34, 21).getContents();
		String sae_report_type_1 = r1.getCell(35, 21).getContents();
		String sae_number_1 = r1.getCell(36, 21).getContents();
		String sae_patient_initial_1 = r1.getCell(37, 21).getContents();

		MSDECISION_LOP();

		GlobalMethods.PI_Login();

		WebElement ongoingdash = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		ongoingdash.click();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();

		WebElement submitnewdoc = GWait.Wait_GetElementByLinkText("Submit New Documents");
		submitnewdoc.click();

		WebElement seriousadverse = GWait.Wait_GetElementByLinkText("SAE");
		seriousadverse.click();

		Thread.sleep(4000);

		WebElement sae_site_drop = GWait
				.Wait_GetElementByXpath("//*[@id='saedetails']/div[1]/div[2]/div[1]/div/div/button");
		sae_site_drop.click();
		Thread.sleep(1000);

		List<WebElement> elementsList = sae_site_value;
		for (WebElement a11 : elementsList) {
			WebElement span = a11.findElement(By.tagName("span"));
			System.out.println(sae_site_type_1);
			if (span.getText().equalsIgnoreCase(sae_site_type_1)) {
				Thread.sleep(2000);
				span.click();
				break;
			}
		}

		WebElement sae_report_doc = GWait.Wait_GetElementByXpath("//*[@id='report_types_sel']/div/div/button");
		sae_report_doc.click();
		Thread.sleep(1000);

		List<WebElement> elementsList1 = sae_report_value;
		for (WebElement a11 : elementsList1) {
			WebElement span = a11.findElement(By.tagName("span"));
			System.out.println(sae_report_type_1);
			if (span.getText().equalsIgnoreCase(sae_report_type_1)) {
				Thread.sleep(2000);
				span.click();
				break;
			}
		}

		Thread.sleep(4000);

		Sae_patient_initial.sendKeys(sae_patient_initial_1);
		Thread.sleep(4000);

		Sae_sae_number.sendKeys(sae_number_1);
		Thread.sleep(6000);

		save_button3.click();
		Thread.sleep(4000);
		Thread.sleep(2000);
		System.out.println(sae_docvalue.size() - 1);

		for (int i = 1; i <= sae_docvalue.size() - 1; i++) {
			Thread.sleep(8000);
			sae_docdrop.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
			List<WebElement> elementsList3 = sae_docvalue;
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
			}break;

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(10000);

		

		WebElement submit_to_IEC = GWait.Wait_GetElementById("submitid");
		submit_to_IEC.click();

		Thread.sleep(2000);
		WebElement no = GWait.Wait_GetElementByXpath("//form[@id='conflictsaesubmit']/div/div/div/div/input[2]");
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

		System.out.println("PI SUBMITS SAE PROJECT TO ADMIN");
	}
	
	//--MS FORWARDS EXPEDITED SAE SUBMISSION TO CP--//
		public void EXPSAEMSTOCP() throws Exception {
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("Dashboard");
			
			// Decision upload data
			String Decisionfile = r1.getCell(25, 21).getContents();
			String Decisioncmnt = r1.getCell(26, 21).getContents();
			String Decision_RESUBMISSION = r1.getCell(27, 21).getContents();
			String Decision_LOP = r1.getCell(30, 21).getContents();
			
			// Document upload data
			String Document_Title_in_list = r1.getCell(7, 21).getContents();
			String Version_in_list = r1.getCell(8, 21).getContents();
			String Document_Date_in_list = r1.getCell(9, 21).getContents();
			String doc_upload = r1.getCell(10, 21).getContents();
			
			String pyrcnum = r1.getCell(11, 21).getContents();
			String inwnum = r1.getCell(12, 21).getContents();
			String prjnum = r1.getCell(13, 21).getContents();
			String insdate = r1.getCell(14, 21).getContents();
			String inwrddate = r1.getCell(15, 21).getContents();
			String ethic_com = r1.getCell(16, 21).getContents();
			String ethic_comnts = r1.getCell(17, 21).getContents();
			String Rev_one = r1.getCell(18, 21).getContents();
			String Rev_two = r1.getCell(19, 21).getContents();
			String Rev_three = r1.getCell(20, 21).getContents();
			String Rev_four = r1.getCell(21, 21).getContents();
			String Rev_five = r1.getCell(22, 21).getContents();
			String Rev_six = r1.getCell(23, 21).getContents();
			String Rev_comnts = r1.getCell(24, 21).getContents();
			
			String sae_site_type_1 = r1.getCell(34, 21).getContents();
			String sae_report_type_1 = r1.getCell(35, 21).getContents();
			String sae_number_1 = r1.getCell(36, 21).getContents();
			String sae_patient_initial_1 = r1.getCell(37, 21).getContents();
			
			EXPADMINREVIEWINITIAL();
			
			GlobalMethods.MS_Login();

			WebElement exp_dash = GWait.Wait_GetElementByXpath("//li[2]/a/span");
			exp_dash.click();

			WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
			Projectoverview1.click();

			
			Thread.sleep(20000);
			GWait.LoadGif();

			GlobalMethods.Commentswindhandler();
			Thread.sleep(8000);
			WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
			iecdecisiontab.click();

			WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
			Select select7 = new Select(decisondropdown);
			select7.selectByVisibleText(Decision_LOP);

			WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
			decisionupload.sendKeys(Decisionfile);

			WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
			assign_comments2.sendKeys(Decisioncmnt);

			WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
			decisionusubmit.click();

			WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
			logoutt2.click();

			WebElement logo81 = GWait.Wait_GetElementByCSS("img");
			logo81.click();
			
			GlobalMethods.PI_Login();

			WebElement ongoingdash = GWait.Wait_GetElementByXpath("//li[4]/a/span");
			ongoingdash.click();

			WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
			overview.click();

			WebElement submitnewdoc = GWait.Wait_GetElementByLinkText("Submit New Documents");
			submitnewdoc.click();

			WebElement seriousadverse = GWait.Wait_GetElementByLinkText("SAE");
			seriousadverse.click();

			Thread.sleep(4000);

			WebElement sae_site_drop = GWait
					.Wait_GetElementByXpath("//*[@id='saedetails']/div[1]/div[2]/div[1]/div/div/button");
			sae_site_drop.click();
			Thread.sleep(1000);

			List<WebElement> elementsList = sae_site_value;
			for (WebElement a11 : elementsList) {
				WebElement span = a11.findElement(By.tagName("span"));
				System.out.println(sae_site_type_1);
				if (span.getText().equalsIgnoreCase(sae_site_type_1)) {
					Thread.sleep(2000);
					span.click();
					break;
				}
			}

			WebElement sae_report_doc = GWait.Wait_GetElementByXpath("//*[@id='report_types_sel']/div/div/button");
			sae_report_doc.click();
			Thread.sleep(1000);

			List<WebElement> elementsList1 = sae_report_value;
			for (WebElement a11 : elementsList1) {
				WebElement span = a11.findElement(By.tagName("span"));
				System.out.println(sae_report_type_1);
				if (span.getText().equalsIgnoreCase(sae_report_type_1)) {
					Thread.sleep(2000);
					span.click();
					break;
				}
			}

			Thread.sleep(4000);

			Sae_patient_initial.sendKeys(sae_patient_initial_1);
			Thread.sleep(4000);

			Sae_sae_number.sendKeys(sae_number_1);
			Thread.sleep(6000);

			save_button3.click();
			Thread.sleep(4000);
			Thread.sleep(2000);
			System.out.println(sae_docvalue.size() - 1);

			for (int i = 1; i <= sae_docvalue.size() - 1; i++) {
				Thread.sleep(8000);
				sae_docdrop.click();
				String numberAsString = Integer.toString(i);
				Thread.sleep(5000);
				List<WebElement> elementsList3 = sae_docvalue;
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
				}break;

			}

			Thread.sleep(2000);
			((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
			Thread.sleep(10000);

			

			WebElement submit_to_IEC = GWait.Wait_GetElementById("submitid");
			submit_to_IEC.click();
			
			Thread.sleep(6000);
			GWait.LoadGif();
			WebElement no = GWait.Wait_GetElementByXpath("//form[@id='conflictsaesubmit']/div/div/div/div/input[2]");
			no.click();

			Thread.sleep(6000);
			WebElement conflictsubmit1 = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
			conflictsubmit1.click();

			Thread.sleep(3000);
			GlobalMethods.alertaccept();

			
			Thread.sleep(6000);
			GWait.LoadGif();
			WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
			logoutt.click();

			WebElement logo = GWait.Wait_GetElementByCSS("img");
			logo.click();

			
			GlobalMethods.Admin_Login();

			WebElement approved_sae = GWait.Wait_GetElementByXpath("//li[8]/a/span");
			approved_sae.click();
			
			WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
			Projectoverview2.click();

			WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
			Admin_Review2.click();

		

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

			Thread.sleep(20000);
			GWait.LoadGif();
			WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
			logoutt12.click();
			Thread.sleep(8000);
			WebElement logo12 = GWait.Wait_GetElementByCSS("img");
			logo12.click();
			
			GlobalMethods.MS_Login();
				
			WebElement approved_sae1 = GWait.Wait_GetElementByXpath("//li[8]/a/span");
			approved_sae1.click();
			
			WebElement Projectoverview12 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
			Projectoverview12.click();

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

			WebElement frwdtocp_button = GWait.Wait_GetElementById("forward_chairman");
			frwdtocp_button.click();


			WebElement logoutt22 = GWait.Wait_GetElementByXpath("//span/a");
			logoutt22.click();

			WebElement logo821 = GWait.Wait_GetElementByCSS("img");
			logo821.click();
			
			
		}
		
		//--MS FORWARDS EXPEDITED OTHER SUBMISSION TO CP--//
		public void EXPOTHERMSTOCP() throws Exception {
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("Dashboard");
			
			// Decision upload data
			String Decisionfile = r1.getCell(25, 21).getContents();
			String Decisioncmnt = r1.getCell(26, 21).getContents();
			String Decision_RESUBMISSION = r1.getCell(27, 21).getContents();
			String Decision_LOP = r1.getCell(30, 21).getContents();
			
			// Document upload data
			String Document_Title_in_list = r1.getCell(7, 21).getContents();
			String Version_in_list = r1.getCell(8, 21).getContents();
			String Document_Date_in_list = r1.getCell(9, 21).getContents();
			String doc_upload = r1.getCell(10, 21).getContents();
			
			String pyrcnum = r1.getCell(11, 21).getContents();
			String inwnum = r1.getCell(12, 21).getContents();
			String prjnum = r1.getCell(13, 21).getContents();
			String insdate = r1.getCell(14, 21).getContents();
			String inwrddate = r1.getCell(15, 21).getContents();
			String ethic_com = r1.getCell(16, 21).getContents();
			String ethic_comnts = r1.getCell(17, 21).getContents();
			String Rev_one = r1.getCell(18, 21).getContents();
			String Rev_two = r1.getCell(19, 21).getContents();
			String Rev_three = r1.getCell(20, 21).getContents();
			String Rev_four = r1.getCell(21, 21).getContents();
			String Rev_five = r1.getCell(22, 21).getContents();
			String Rev_six = r1.getCell(23, 21).getContents();
			String Rev_comnts = r1.getCell(24, 21).getContents();
			
			
			EXPADMINREVIEWINITIAL();
			
			GlobalMethods.MS_Login();

			WebElement exp_dash = GWait.Wait_GetElementByXpath("//li[2]/a/span");
			exp_dash.click();

			WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
			Projectoverview1.click();

			
			Thread.sleep(20000);
			GWait.LoadGif();

			GlobalMethods.Commentswindhandler();
			Thread.sleep(8000);
			WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
			iecdecisiontab.click();

			WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
			Select select7 = new Select(decisondropdown);
			select7.selectByVisibleText(Decision_LOP);

			WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
			decisionupload.sendKeys(Decisionfile);

			WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
			assign_comments2.sendKeys(Decisioncmnt);

			WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
			decisionusubmit.click();
            Thread.sleep(20000);
            GWait.LoadGif();
			WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
			logoutt2.click();

			WebElement logo81 = GWait.Wait_GetElementByCSS("img");
			logo81.click();
			
			GlobalMethods.PI_Login();

			WebElement ongoingdash = GWait.Wait_GetElementByXpath("//li[4]/a/span");
			ongoingdash.click();

			WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
			overview.click();

			WebElement submitnewdoc = GWait.Wait_GetElementByLinkText("Submit New Documents");
			submitnewdoc.click();

			WebElement othrlink = GWait.Wait_GetElementByLinkText("Other");
			othrlink.click();

			Thread.sleep(6000);
			Thread.sleep(2000);
			System.out.println(docvalue1.size() - 1);

			for (int i = 1; i <= docvalue1.size() - 1; i++) {
				Thread.sleep(10000);
				docdrop1.click();
				String numberAsString = Integer.toString(i);
				Thread.sleep(5000);
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

					WebElement doc_version = GWait.Wait_GetElementById("version");
					doc_version.sendKeys(Version_in_list);

					WebElement doc_date = GWait.Wait_GetElementById("document_date");
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

			WebElement next_button1 = GWait.Wait_GetElementById("nextid");
			next_button1.click();

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

			WebElement approved_othersubmission = GWait.Wait_GetElementByXpath("//li[9]/a/span");
			approved_othersubmission.click();

			WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
			Projectoverview2.click();

			WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
			Admin_Review2.click();

		

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

			Thread.sleep(20000);
			GWait.LoadGif();
			WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
			logoutt12.click();
			Thread.sleep(8000);
			WebElement logo12 = GWait.Wait_GetElementByCSS("img");
			logo12.click();
			
			GlobalMethods.MS_Login();
				
			WebElement approved_othersubmission1 = GWait.Wait_GetElementByXpath("//li[9]/a/span");
			approved_othersubmission1.click();
			
			WebElement Projectoverview12 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
			Projectoverview12.click();

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

			WebElement frwdtocp_button = GWait.Wait_GetElementById("forward_chairman");
			frwdtocp_button.click();


			WebElement logoutt22 = GWait.Wait_GetElementByXpath("//span/a");
			logoutt22.click();

			WebElement logo821 = GWait.Wait_GetElementByCSS("img");
			logo821.click();
			
			
		}
	
	//--MS FORWARDS EXPEDITED DEVIATION SUBMISSION TO CP--//
	public void EXPDEVIATMSTOCP() throws Exception {
		

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");
		
		// Decision upload data
		String Decisionfile = r1.getCell(25, 21).getContents();
		String Decisioncmnt = r1.getCell(26, 21).getContents();
		String Decision_RESUBMISSION = r1.getCell(27, 21).getContents();
		String Decision_LOP = r1.getCell(30, 21).getContents();
		
		// Document upload data
		String Document_Title_in_list = r1.getCell(7, 21).getContents();
		String Version_in_list = r1.getCell(8, 21).getContents();
		String Document_Date_in_list = r1.getCell(9, 21).getContents();
		String doc_upload = r1.getCell(10, 21).getContents();
		
		String pyrcnum = r1.getCell(11, 21).getContents();
		String inwnum = r1.getCell(12, 21).getContents();
		String prjnum = r1.getCell(13, 21).getContents();
		String insdate = r1.getCell(14, 21).getContents();
		String inwrddate = r1.getCell(15, 21).getContents();
		String ethic_com = r1.getCell(16, 21).getContents();
		String ethic_comnts = r1.getCell(17, 21).getContents();
		String Rev_one = r1.getCell(18, 21).getContents();
		String Rev_two = r1.getCell(19, 21).getContents();
		String Rev_three = r1.getCell(20, 21).getContents();
		String Rev_four = r1.getCell(21, 21).getContents();
		String Rev_five = r1.getCell(22, 21).getContents();
		String Rev_six = r1.getCell(23, 21).getContents();
		String Rev_comnts = r1.getCell(24, 21).getContents();
		
		
		EXPADMINREVIEWINITIAL();
		
		GlobalMethods.MS_Login();

		WebElement exp_dash = GWait.Wait_GetElementByXpath("//li[2]/a/span");
		exp_dash.click();

		WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview1.click();

		
		Thread.sleep(20000);
		GWait.LoadGif();

		GlobalMethods.Commentswindhandler();
		Thread.sleep(8000);
		WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab.click();

		WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
		Select select7 = new Select(decisondropdown);
		select7.selectByVisibleText(Decision_LOP);

		WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
		decisionupload.sendKeys(Decisionfile);

		WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
		assign_comments2.sendKeys(Decisioncmnt);

		WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit.click();

		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();

		WebElement logo81 = GWait.Wait_GetElementByCSS("img");
		logo81.click();
		
		GlobalMethods.PI_Login();

		WebElement ongoingdash = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		ongoingdash.click();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();

		WebElement submitnewdoc = GWait.Wait_GetElementByLinkText("Submit New Documents");
		submitnewdoc.click();

		WebElement devlink = GWait.Wait_GetElementByLinkText("Deviation");
		devlink.click();


		Thread.sleep(6000);
		Thread.sleep(2000);
		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; i++) {
			Thread.sleep(10000);
			docdrop1.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
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

				WebElement doc_version = GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);

				WebElement doc_date = GWait.Wait_GetElementById("document_date");
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

		WebElement next_button1 = GWait.Wait_GetElementById("nextid");
		next_button1.click();

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

		WebElement approved_deviation = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[7]/a/span");
		approved_deviation.click();

		WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview2.click();

		WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review2.click();

	

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

		Thread.sleep(20000);
		GWait.LoadGif();
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();
		
		GlobalMethods.MS_Login();
			
		WebElement approved_deviation1 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[7]/a/span");
		approved_deviation1.click();
		
		WebElement Projectoverview12 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview12.click();

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

		WebElement frwdtocp_button = GWait.Wait_GetElementById("forward_chairman");
		frwdtocp_button.click();


		WebElement logoutt22 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt22.click();

		WebElement logo821 = GWait.Wait_GetElementByCSS("img");
		logo821.click();


		
		
	}
	
	//--MS FORWARDS EXPEDITED AMENDMENT SUBMISSION TO CP--//
	public void EXPAMENDMSTOCP() throws Exception {
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");
		
		// Decision upload data
		String Decisionfile = r1.getCell(25, 21).getContents();
		String Decisioncmnt = r1.getCell(26, 21).getContents();
		String Decision_RESUBMISSION = r1.getCell(27, 21).getContents();
		String Decision_LOP = r1.getCell(30, 21).getContents();
		
		// Document upload data
		String Document_Title_in_list = r1.getCell(7, 21).getContents();
		String Version_in_list = r1.getCell(8, 21).getContents();
		String Document_Date_in_list = r1.getCell(9, 21).getContents();
		String doc_upload = r1.getCell(10, 21).getContents();
		
		String pyrcnum = r1.getCell(11, 21).getContents();
		String inwnum = r1.getCell(12, 21).getContents();
		String prjnum = r1.getCell(13, 21).getContents();
		String insdate = r1.getCell(14, 21).getContents();
		String inwrddate = r1.getCell(15, 21).getContents();
		String ethic_com = r1.getCell(16, 21).getContents();
		String ethic_comnts = r1.getCell(17, 21).getContents();
		String Rev_one = r1.getCell(18, 21).getContents();
		String Rev_two = r1.getCell(19, 21).getContents();
		String Rev_three = r1.getCell(20, 21).getContents();
		String Rev_four = r1.getCell(21, 21).getContents();
		String Rev_five = r1.getCell(22, 21).getContents();
		String Rev_six = r1.getCell(23, 21).getContents();
		String Rev_comnts = r1.getCell(24, 21).getContents();
		
		
		EXPADMINREVIEWINITIAL();
		
		GlobalMethods.MS_Login();

		WebElement exp_dash = GWait.Wait_GetElementByXpath("//li[2]/a/span");
		exp_dash.click();

		WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview1.click();

		
		Thread.sleep(20000);
		GWait.LoadGif();

		GlobalMethods.Commentswindhandler();
		Thread.sleep(8000);
		WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab.click();

		WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
		Select select7 = new Select(decisondropdown);
		select7.selectByVisibleText(Decision_LOP);

		WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
		decisionupload.sendKeys(Decisionfile);

		WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
		assign_comments2.sendKeys(Decisioncmnt);

		WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit.click();

		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();

		WebElement logo81 = GWait.Wait_GetElementByCSS("img");
		logo81.click();
		
		GlobalMethods.PI_Login();

		WebElement ongoingdash = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		ongoingdash.click();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();

		WebElement submitnewdoc = GWait.Wait_GetElementByLinkText("Submit New Documents");
		submitnewdoc.click();

		WebElement amendlink = GWait.Wait_GetElementByLinkText("Amendment");
		amendlink.click();


		Thread.sleep(6000);
		Thread.sleep(2000);
		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; i++) {
			Thread.sleep(10000);
			docdrop1.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
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

				WebElement doc_version = GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);

				WebElement doc_date = GWait.Wait_GetElementById("document_date");
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

		WebElement next_button1 = GWait.Wait_GetElementById("nextid");
		next_button1.click();

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

		WebElement approved_amendments = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[6]/a/span");
		approved_amendments.click();

		WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview2.click();

		WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review2.click();

	

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

		Thread.sleep(20000);
		GWait.LoadGif();
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();
		
		GlobalMethods.MS_Login();
			

		WebElement approved_amendments1 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[6]/a/span");
		approved_amendments1.click();

		WebElement Projectoverview12 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview12.click();

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

		WebElement frwdtocp_button = GWait.Wait_GetElementById("forward_chairman");
		frwdtocp_button.click();


		WebElement logoutt22 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt22.click();

		WebElement logo821 = GWait.Wait_GetElementByCSS("img");
		logo821.click();
		


		
		
	}
	//--MS FORWARDS EXPEDITED TERMINATION SUBMISSION TO CP--//
			public void EXPTERMMSTOCP() throws Exception {
				
				
				FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
				Workbook wb = Workbook.getWorkbook(fi);
				Sheet r1 = wb.getSheet("Dashboard");
				
				// Decision upload data
				String Decisionfile = r1.getCell(25, 21).getContents();
				String Decisioncmnt = r1.getCell(26, 21).getContents();
				String Decision_RESUBMISSION = r1.getCell(27, 21).getContents();
				String Decision_LOP = r1.getCell(30, 21).getContents();
				
				// Document upload data
				String Document_Title_in_list = r1.getCell(7, 21).getContents();
				String Version_in_list = r1.getCell(8, 21).getContents();
				String Document_Date_in_list = r1.getCell(9, 21).getContents();
				String doc_upload = r1.getCell(10, 21).getContents();
				
				String pyrcnum = r1.getCell(11, 21).getContents();
				String inwnum = r1.getCell(12, 21).getContents();
				String prjnum = r1.getCell(13, 21).getContents();
				String insdate = r1.getCell(14, 21).getContents();
				String inwrddate = r1.getCell(15, 21).getContents();
				String ethic_com = r1.getCell(16, 21).getContents();
				String ethic_comnts = r1.getCell(17, 21).getContents();
				String Rev_one = r1.getCell(18, 21).getContents();
				String Rev_two = r1.getCell(19, 21).getContents();
				String Rev_three = r1.getCell(20, 21).getContents();
				String Rev_four = r1.getCell(21, 21).getContents();
				String Rev_five = r1.getCell(22, 21).getContents();
				String Rev_six = r1.getCell(23, 21).getContents();
				String Rev_comnts = r1.getCell(24, 21).getContents();
				
				
				EXPADMINREVIEWINITIAL();
				
				GlobalMethods.MS_Login();

				WebElement exp_dash = GWait.Wait_GetElementByXpath("//li[2]/a/span");
				exp_dash.click();

				WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
				Projectoverview1.click();

				
				Thread.sleep(20000);
				GWait.LoadGif();

				GlobalMethods.Commentswindhandler();
				Thread.sleep(8000);
				WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
				iecdecisiontab.click();

				WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
				Select select7 = new Select(decisondropdown);
				select7.selectByVisibleText(Decision_LOP);

				WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
				decisionupload.sendKeys(Decisionfile);

				WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
				assign_comments2.sendKeys(Decisioncmnt);

				WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
				decisionusubmit.click();

				WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
				logoutt2.click();

				WebElement logo81 = GWait.Wait_GetElementByCSS("img");
				logo81.click();
				
				GlobalMethods.PI_Login();

				WebElement ongoingdash = GWait.Wait_GetElementByXpath("//li[4]/a/span");
				ongoingdash.click();

				WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
				overview.click();

				WebElement submitnewdoc = GWait.Wait_GetElementByLinkText("Submit New Documents");
				submitnewdoc.click();

				WebElement termlink = GWait.Wait_GetElementByLinkText("Premature Termination");
				termlink.click();

				Thread.sleep(6000);
				Thread.sleep(2000);
				System.out.println(docvalue1.size() - 1);

				for (int i = 1; i <= docvalue1.size() - 1; i++) {
					Thread.sleep(10000);
					docdrop1.click();
					String numberAsString = Integer.toString(i);
					Thread.sleep(5000);
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

						WebElement doc_version = GWait.Wait_GetElementById("version");
						doc_version.sendKeys(Version_in_list);

						WebElement doc_date = GWait.Wait_GetElementById("document_date");
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

				WebElement next_button1 = GWait.Wait_GetElementById("nextid");
				next_button1.click();

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

				WebElement approved_projecttermination = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[5]/a/span");
				approved_projecttermination.click();

				WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
				Projectoverview2.click();

				WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
				Admin_Review2.click();

			

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

				Thread.sleep(20000);
				GWait.LoadGif();
				WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
				logoutt12.click();
				Thread.sleep(8000);
				WebElement logo12 = GWait.Wait_GetElementByCSS("img");
				logo12.click();
				
				GlobalMethods.MS_Login();
					

				WebElement approved_projecttermination1 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[5]/a/span");
				approved_projecttermination1.click();

				WebElement Projectoverview12 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
				Projectoverview12.click();

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

				WebElement frwdtocp_button = GWait.Wait_GetElementById("forward_chairman");
				frwdtocp_button.click();
	

				WebElement logoutt22 = GWait.Wait_GetElementByXpath("//span/a");
				logoutt22.click();

				WebElement logo821 = GWait.Wait_GetElementByCSS("img");
				logo821.click();

				
			}

	//--MS FORWARDS EXPEDITED COMPLETION SUBMISSION TO CP--//
		public void EXPCOMPMSTOCP() throws Exception {
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("Dashboard");
			
			// Decision upload data
			String Decisionfile = r1.getCell(25, 21).getContents();
			String Decisioncmnt = r1.getCell(26, 21).getContents();
			String Decision_RESUBMISSION = r1.getCell(27, 21).getContents();
			String Decision_LOP = r1.getCell(30, 21).getContents();
			
			// Document upload data
			String Document_Title_in_list = r1.getCell(7, 21).getContents();
			String Version_in_list = r1.getCell(8, 21).getContents();
			String Document_Date_in_list = r1.getCell(9, 21).getContents();
			String doc_upload = r1.getCell(10, 21).getContents();
			
			String pyrcnum = r1.getCell(11, 21).getContents();
			String inwnum = r1.getCell(12, 21).getContents();
			String prjnum = r1.getCell(13, 21).getContents();
			String insdate = r1.getCell(14, 21).getContents();
			String inwrddate = r1.getCell(15, 21).getContents();
			String ethic_com = r1.getCell(16, 21).getContents();
			String ethic_comnts = r1.getCell(17, 21).getContents();
			String Rev_one = r1.getCell(18, 21).getContents();
			String Rev_two = r1.getCell(19, 21).getContents();
			String Rev_three = r1.getCell(20, 21).getContents();
			String Rev_four = r1.getCell(21, 21).getContents();
			String Rev_five = r1.getCell(22, 21).getContents();
			String Rev_six = r1.getCell(23, 21).getContents();
			String Rev_comnts = r1.getCell(24, 21).getContents();
			
			
			EXPADMINREVIEWINITIAL();
			
			GlobalMethods.MS_Login();

			WebElement exp_dash = GWait.Wait_GetElementByXpath("//li[2]/a/span");
			exp_dash.click();

			WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
			Projectoverview1.click();

			
			Thread.sleep(20000);
			GWait.LoadGif();

			GlobalMethods.Commentswindhandler();
			Thread.sleep(8000);
			WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
			iecdecisiontab.click();

			WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
			Select select7 = new Select(decisondropdown);
			select7.selectByVisibleText(Decision_LOP);

			WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
			decisionupload.sendKeys(Decisionfile);

			WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
			assign_comments2.sendKeys(Decisioncmnt);

			WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
			decisionusubmit.click();

			WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
			logoutt2.click();

			WebElement logo81 = GWait.Wait_GetElementByCSS("img");
			logo81.click();
			
			GlobalMethods.PI_Login();

			WebElement ongoingdash = GWait.Wait_GetElementByXpath("//li[4]/a/span");
			ongoingdash.click();

			WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
			overview.click();

			WebElement submitnewdoc = GWait.Wait_GetElementByLinkText("Submit New Documents");
			submitnewdoc.click();

			WebElement completlink = GWait.Wait_GetElementByLinkText("Completion");
			completlink.click();

			Thread.sleep(6000);
			Thread.sleep(2000);
			System.out.println(docvalue1.size() - 1);

			for (int i = 1; i <= docvalue1.size() - 1; i++) {
				Thread.sleep(10000);
				docdrop1.click();
				String numberAsString = Integer.toString(i);
				Thread.sleep(5000);
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

					WebElement doc_version = GWait.Wait_GetElementById("version");
					doc_version.sendKeys(Version_in_list);

					WebElement doc_date = GWait.Wait_GetElementById("document_date");
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

			WebElement next_button1 = GWait.Wait_GetElementById("nextid");
			next_button1.click();

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

			WebElement approved_projectcompletion = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[3]/a/span");
			approved_projectcompletion.click();

			WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
			Projectoverview2.click();

			WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
			Admin_Review2.click();

		

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

			Thread.sleep(20000);
			GWait.LoadGif();
			WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
			logoutt12.click();
			Thread.sleep(8000);
			WebElement logo12 = GWait.Wait_GetElementByCSS("img");
			logo12.click();
			
			GlobalMethods.MS_Login();
				

			WebElement approved_projectcompletion1 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[3]/a/span");
			approved_projectcompletion1.click();

			WebElement Projectoverview12 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
			Projectoverview12.click();

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

			WebElement frwdtocp_button = GWait.Wait_GetElementById("forward_chairman");
			frwdtocp_button.click();

			

			WebElement logoutt22 = GWait.Wait_GetElementByXpath("//span/a");
			logoutt22.click();

			WebElement logo821 = GWait.Wait_GetElementByCSS("img");
			logo821.click();

			
			
			GlobalMethods.CPLogin();
			
			WebElement approved_projectcontinous11 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[2]/a/span");
			approved_projectcontinous11.click();

			WebElement Projectoverview11 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
			Projectoverview11.click();
			
			WebElement asignreviewers1 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
			asignreviewers1.click();
			
			WebElement submitmsbutton = GWait.Wait_GetElementById("assign1");
			submitmsbutton.click();
			
			WebElement logoutt211 = GWait.Wait_GetElementByXpath("//span/a");
			logoutt211.click();

			WebElement logo8111 = GWait.Wait_GetElementByCSS("img");
			logo8111.click();
			
			
		}
	//--MS FORWARDS EXPEDITED CONTINOUS SUBMISSION TO CP--//
	public void EXPCONTMSTOCP() throws Exception {
		
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");
		
		// Decision upload data
		String Decisionfile = r1.getCell(25, 21).getContents();
		String Decisioncmnt = r1.getCell(26, 21).getContents();
		String Decision_RESUBMISSION = r1.getCell(27, 21).getContents();
		String Decision_LOP = r1.getCell(30, 21).getContents();
		
		// Document upload data
		String Document_Title_in_list = r1.getCell(7, 21).getContents();
		String Version_in_list = r1.getCell(8, 21).getContents();
		String Document_Date_in_list = r1.getCell(9, 21).getContents();
		String doc_upload = r1.getCell(10, 21).getContents();
		
		String pyrcnum = r1.getCell(11, 21).getContents();
		String inwnum = r1.getCell(12, 21).getContents();
		String prjnum = r1.getCell(13, 21).getContents();
		String insdate = r1.getCell(14, 21).getContents();
		String inwrddate = r1.getCell(15, 21).getContents();
		String ethic_com = r1.getCell(16, 21).getContents();
		String ethic_comnts = r1.getCell(17, 21).getContents();
		String Rev_one = r1.getCell(18, 21).getContents();
		String Rev_two = r1.getCell(19, 21).getContents();
		String Rev_three = r1.getCell(20, 21).getContents();
		String Rev_four = r1.getCell(21, 21).getContents();
		String Rev_five = r1.getCell(22, 21).getContents();
		String Rev_six = r1.getCell(23, 21).getContents();
		String Rev_comnts = r1.getCell(24, 21).getContents();
		
		
		EXPADMINREVIEWINITIAL();
		
		GlobalMethods.MS_Login();

		WebElement exp_dash = GWait.Wait_GetElementByXpath("//li[2]/a/span");
		exp_dash.click();

		WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview1.click();

		
		Thread.sleep(20000);
		GWait.LoadGif();

		GlobalMethods.Commentswindhandler();
		Thread.sleep(8000);
		WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab.click();

		WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
		Select select7 = new Select(decisondropdown);
		select7.selectByVisibleText(Decision_LOP);

		WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
		decisionupload.sendKeys(Decisionfile);

		WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
		assign_comments2.sendKeys(Decisioncmnt);

		WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit.click();

		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();

		WebElement logo81 = GWait.Wait_GetElementByCSS("img");
		logo81.click();
		
		GlobalMethods.PI_Login();

		WebElement ongoingdash = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		ongoingdash.click();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();

		WebElement submitnewdoc = GWait.Wait_GetElementByLinkText("Submit New Documents");
		submitnewdoc.click();

		WebElement continulink = GWait.Wait_GetElementByLinkText("Continuation");
		continulink.click();

		Thread.sleep(6000);
		Thread.sleep(2000);
		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; i++) {
			Thread.sleep(10000);
			docdrop1.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
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

				WebElement doc_version = GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);

				WebElement doc_date = GWait.Wait_GetElementById("document_date");
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

		WebElement next_button1 = GWait.Wait_GetElementById("nextid");
		next_button1.click();

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

		WebElement approved_projectcontinous = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[2]/a/span");
		approved_projectcontinous.click();

		WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview2.click();

		WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review2.click();

	

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

		Thread.sleep(20000);
		GWait.LoadGif();
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();
		
		GlobalMethods.MS_Login();
			

		WebElement approved_projectcontinous1 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[2]/a/span");
		approved_projectcontinous1.click();

		WebElement Projectoverview12 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview12.click();

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

		WebElement frwdtocp_button = GWait.Wait_GetElementById("forward_chairman");
		frwdtocp_button.click();

		

		WebElement logoutt22 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt22.click();

		WebElement logo821 = GWait.Wait_GetElementByCSS("img");
		logo821.click();
		
		/*GlobalMethods.CPLogin();
		
		WebElement approved_projectcontinous11 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[2]/a/span");
		approved_projectcontinous11.click();

		WebElement Projectoverview11 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview11.click();
		
		WebElement asignreviewers1 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers1.click();
		
		WebElement submitmsbutton = GWait.Wait_GetElementById("assign1");
		submitmsbutton.click();
		GWait.LoadGif();
		Thread.sleep(6000);
		
		WebElement logoutt211 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt211.click();

		WebElement logo8111 = GWait.Wait_GetElementByCSS("img");
		logo8111.click();*/

		
				
	}
	// --ADMIN FORWARDS CONTINOUS PROJECT TO MS--//
	public void ADMINFRWDPROJCONTMS() throws Exception {
		PROJCONTADMIN();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Admin data
		String pyrcnum = r1.getCell(11, 21).getContents();
		String inwnum = r1.getCell(12, 21).getContents();
		String prjnum = r1.getCell(13, 21).getContents();
		String insdate = r1.getCell(14, 21).getContents();
		String inwrddate = r1.getCell(15, 21).getContents();
		String ethic_com = r1.getCell(16, 21).getContents();
		String ethic_comnts = r1.getCell(17, 21).getContents();

		GlobalMethods.Admin_Login();

		WebElement approved_projectcontinous = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[2]/a/span");
		approved_projectcontinous.click();

		WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview2.click();

		WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review2.click();

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

		Thread.sleep(20000);
		GWait.LoadGif();
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();

		System.out.println("ADMIN FORWARDS CONTINOUS PROJECT TO MS");

	}

	
	// --PI SUBMITS CONTINOUS PROJECT TO ADMIN---//
	public void PROJCONTADMIN() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Document upload data
		String Document_Title_in_list = r1.getCell(7, 21).getContents();
		String Version_in_list = r1.getCell(8, 21).getContents();
		String Document_Date_in_list = r1.getCell(9, 21).getContents();
		String doc_upload = r1.getCell(10, 21).getContents();

		MSDECISION_LOP();

		GlobalMethods.PI_Login();

		WebElement ongoingdash = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		ongoingdash.click();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();

		WebElement submitnewdoc = GWait.Wait_GetElementByLinkText("Submit New Documents");
		submitnewdoc.click();

		WebElement continulink = GWait.Wait_GetElementByLinkText("Continuation");
		continulink.click();

		Thread.sleep(6000);
		Thread.sleep(2000);
		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; i++) {
			Thread.sleep(10000);
			docdrop1.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
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

				WebElement doc_version = GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);

				WebElement doc_date = GWait.Wait_GetElementById("document_date");
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

		WebElement next_button1 = GWait.Wait_GetElementById("nextid");
		next_button1.click();

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

		System.out.println("PI SUBMITS CONTINOUS PROJECT TO ADMIN");

	}

	// --ADMIN FORWARDS COMPLETION PROJECT TO MS
	public void ADMINFRWDPROJCOMPMS() throws Exception {

		PROJCOMPADMIN();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Admin data
		String pyrcnum = r1.getCell(11, 21).getContents();
		String inwnum = r1.getCell(12, 21).getContents();
		String prjnum = r1.getCell(13, 21).getContents();
		String insdate = r1.getCell(14, 21).getContents();
		String inwrddate = r1.getCell(15, 21).getContents();
		String ethic_com = r1.getCell(16, 21).getContents();
		String ethic_comnts = r1.getCell(17, 21).getContents();

		GlobalMethods.Admin_Login();

		WebElement approved_projectcompletion = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[3]/a/span");
		approved_projectcompletion.click();

		WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview2.click();

		WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review2.click();

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

		Thread.sleep(20000);
		GWait.LoadGif();
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();

		System.out.println("ADMIN FORWARDS COMPLETION PROJECT TO MS");

	}

	// --PI SUBMITS COMPLETION PROJECT TO ADMIN---//
	public void PROJCOMPADMIN() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Document upload data
		String Document_Title_in_list = r1.getCell(7, 21).getContents();
		String Version_in_list = r1.getCell(8, 21).getContents();
		String Document_Date_in_list = r1.getCell(9, 21).getContents();
		String doc_upload = r1.getCell(10, 21).getContents();

		MSDECISION_LOP();

		GlobalMethods.PI_Login();

		WebElement ongoingdash = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		ongoingdash.click();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();

		WebElement submitnewdoc = GWait.Wait_GetElementByLinkText("Submit New Documents");
		submitnewdoc.click();

		WebElement completlink = GWait.Wait_GetElementByLinkText("Completion");
		completlink.click();

		Thread.sleep(6000);
		Thread.sleep(2000);
		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; i++) {
			Thread.sleep(10000);
			docdrop1.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
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

				WebElement doc_version = GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);

				WebElement doc_date = GWait.Wait_GetElementById("document_date");
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

		WebElement next_button1 = GWait.Wait_GetElementById("nextid");
		next_button1.click();

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

		System.out.println("PI SUBMITS COMPLETION PROJECT TO ADMIN");
	}

	//--ADMIN FORWARDS AMENDMENT PROJECT TO MS--//
	public void ADMINFRWDPROJAMENDMS() throws Exception {


		PROJAMENDADMIN();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Admin data
		String pyrcnum = r1.getCell(11, 21).getContents();
		String inwnum = r1.getCell(12, 21).getContents();
		String prjnum = r1.getCell(13, 21).getContents();
		String insdate = r1.getCell(14, 21).getContents();
		String inwrddate = r1.getCell(15, 21).getContents();
		String ethic_com = r1.getCell(16, 21).getContents();
		String ethic_comnts = r1.getCell(17, 21).getContents();

		GlobalMethods.Admin_Login();

		WebElement approved_amendments = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[6]/a/span");
		approved_amendments.click();

		WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview2.click();

		WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review2.click();

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

		Thread.sleep(20000);
		GWait.LoadGif();
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();

		System.out.println("ADMIN FORWARDS AMENDMENT PROJECT TO MS");
		
	}
	// --PI SUBMITS AMENDMENT PROJECT TO ADMIN---//
	public void PROJAMENDADMIN() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Document upload data
		String Document_Title_in_list = r1.getCell(7, 21).getContents();
		String Version_in_list = r1.getCell(8, 21).getContents();
		String Document_Date_in_list = r1.getCell(9, 21).getContents();
		String doc_upload = r1.getCell(10, 21).getContents();

		MSDECISION_LOP();

		GlobalMethods.PI_Login();

		WebElement ongoingdash = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		ongoingdash.click();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();

		WebElement submitnewdoc = GWait.Wait_GetElementByLinkText("Submit New Documents");
		submitnewdoc.click();

		WebElement amendlink = GWait.Wait_GetElementByLinkText("Amendment");
		amendlink.click();

		Thread.sleep(6000);
		Thread.sleep(2000);
		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; i++) {
			Thread.sleep(10000);
			docdrop1.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
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

				WebElement doc_version = GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);

				WebElement doc_date = GWait.Wait_GetElementById("document_date");
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

		WebElement next_button1 = GWait.Wait_GetElementById("nextid");
		next_button1.click();

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

		System.out.println("PI SUBMITS AMENDMENT PROJECT TO ADMIN");

	}

	//--ADMIN FORWARDS DEVIATION PROJECT TO MS--//
	public void ADMINFRWDPROJDEVMS() throws Exception {

		PROJDEVADMIN();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Admin data
		String pyrcnum = r1.getCell(11, 21).getContents();
		String inwnum = r1.getCell(12, 21).getContents();
		String prjnum = r1.getCell(13, 21).getContents();
		String insdate = r1.getCell(14, 21).getContents();
		String inwrddate = r1.getCell(15, 21).getContents();
		String ethic_com = r1.getCell(16, 21).getContents();
		String ethic_comnts = r1.getCell(17, 21).getContents();

		GlobalMethods.Admin_Login();

		WebElement approved_deviation = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[7]/a/span");
		approved_deviation.click();

		WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview2.click();

		WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review2.click();

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

		Thread.sleep(20000);
		GWait.LoadGif();
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();

		System.out.println("ADMIN FORWARDS COMPLETION PROJECT TO MS");
		
	}
	// --PI SUBMITS DEVIATION PROJECT TO ADMIN---//
	public void PROJDEVADMIN() throws Exception {
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Document upload data
		String Document_Title_in_list = r1.getCell(7, 21).getContents();
		String Version_in_list = r1.getCell(8, 21).getContents();
		String Document_Date_in_list = r1.getCell(9, 21).getContents();
		String doc_upload = r1.getCell(10, 21).getContents();

		MSDECISION_LOP();

		GlobalMethods.PI_Login();

		WebElement ongoingdash = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		ongoingdash.click();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();

		WebElement submitnewdoc = GWait.Wait_GetElementByLinkText("Submit New Documents");
		submitnewdoc.click();

		WebElement devlink = GWait.Wait_GetElementByLinkText("Deviation");
		devlink.click();

		Thread.sleep(6000);
		Thread.sleep(2000);
		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; i++) {
			Thread.sleep(10000);
			WebElement docdrop1 = GWait
					.Wait_GetElementByXpath("//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/button");
			docdrop1.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
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

				WebElement doc_version = GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);

				WebElement doc_date = GWait.Wait_GetElementById("document_date");
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

		WebElement next_button1 = GWait.Wait_GetElementById("nextid");
		next_button1.click();

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

		System.out.println("PI SUBMITS DEVIATION PROJECT TO ADMIN");

	}

	//--ADMIN FORWARDS TERMINATION PROJECT TO MS--//
	public void ADMINFRWDPROJTERMMS() throws Exception {

		PROJTERMADMIN();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Admin data
		String pyrcnum = r1.getCell(11, 21).getContents();
		String inwnum = r1.getCell(12, 21).getContents();
		String prjnum = r1.getCell(13, 21).getContents();
		String insdate = r1.getCell(14, 21).getContents();
		String inwrddate = r1.getCell(15, 21).getContents();
		String ethic_com = r1.getCell(16, 21).getContents();
		String ethic_comnts = r1.getCell(17, 21).getContents();

		GlobalMethods.Admin_Login();

		WebElement approved_projectcompletion = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[3]/a/span");
		approved_projectcompletion.click();

		WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview2.click();

		WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review2.click();

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

		Thread.sleep(20000);
		GWait.LoadGif();
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();

		System.out.println("ADMIN FORWARDS COMPLETION PROJECT TO MS");

	}

	// --PI SUBMITS TERMINATION PROJECT TO ADMIN---//
	public void PROJTERMADMIN() throws Exception {
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Document upload data
		String Document_Title_in_list = r1.getCell(7, 21).getContents();
		String Version_in_list = r1.getCell(8, 21).getContents();
		String Document_Date_in_list = r1.getCell(9, 21).getContents();
		String doc_upload = r1.getCell(10, 21).getContents();

		MSDECISION_LOP();

		GlobalMethods.PI_Login();

		WebElement ongoingdash = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		ongoingdash.click();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();

		WebElement submitnewdoc = GWait.Wait_GetElementByLinkText("Submit New Documents");
		submitnewdoc.click();

		WebElement termlink = GWait.Wait_GetElementByLinkText("Premature Termination");
		termlink.click();

		Thread.sleep(6000);
		Thread.sleep(2000);
		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; i++) {
			Thread.sleep(10000);
			docdrop1.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
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

				WebElement doc_version = GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);

				WebElement doc_date = GWait.Wait_GetElementById("document_date");
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

		WebElement next_button1 = GWait.Wait_GetElementById("nextid");
		next_button1.click();

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

	}

	// --ADMIN FORWARD PI SUBSEQUENT QUERY TO MS--//
	public void MSDECISION_SUBQUERY_MS() throws Exception {


		MSDECISION_SUBQUERY();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Admin data

		String ethic_com = r1.getCell(16, 21).getContents();
		String ethic_comnts = r1.getCell(17, 21).getContents();

		GlobalMethods.Admin_Login();

		WebElement approved_queryreply = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[4]/a/span");
		approved_queryreply.click();

		WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview2.click();

		WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review2.click();

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

		Thread.sleep(20000);
		GWait.LoadGif();
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();

	}

	// --MS GIVING DECISION ON SUBSEQUENT SUBMISSION QUERY LETTER--//
		public void MSDECISION_SUBQUERYEXP() throws Exception {
			
			EXPCONTMSTOCP();
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("Dashboard");

			// Admin data

			String ethic_com = r1.getCell(16, 21).getContents();
			String ethic_comnts = r1.getCell(17, 21).getContents();

			// MS data
			String Rev_one = r1.getCell(18, 21).getContents();
			String Rev_two = r1.getCell(19, 21).getContents();
			String Rev_three = r1.getCell(20, 21).getContents();
			String Rev_four = r1.getCell(21, 21).getContents();
			String Rev_five = r1.getCell(22, 21).getContents();
			String Rev_six = r1.getCell(23, 21).getContents();
			String Rev_comnts = r1.getCell(24, 21).getContents();

			// Decision upload data
			String Decisionfile = r1.getCell(25, 21).getContents();
			String Decisioncmnt = r1.getCell(26, 21).getContents();
			String Decision_RESUBMISSION = r1.getCell(27, 21).getContents();
			String Decision_QUERYACTION = r1.getCell(40, 21).getContents();

			String Query_Cmnts_Continuation = r1.getCell(32, 21).getContents();

			// Document upload data
			String Document_Title_in_list = r1.getCell(7, 21).getContents();
			String Version_in_list = r1.getCell(8, 21).getContents();
			String Document_Date_in_list = r1.getCell(9, 21).getContents();
			String doc_upload = r1.getCell(10, 21).getContents();

			GlobalMethods.CPLogin();
			
			WebElement approved_projectcontinous1 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[2]/a/span");
			approved_projectcontinous1.click();

			WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
			Projectoverview1.click();
			
			WebElement asignreviewers = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
			asignreviewers.click();
			
			WebElement submitmsbutton = GWait.Wait_GetElementById("assign1");
			submitmsbutton.click();
			
			WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
			logoutt2.click();

			WebElement logo81 = GWait.Wait_GetElementByCSS("img");
			logo81.click();

			GlobalMethods.MS_Login();

			WebElement approved_projectcontinous12 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[2]/a/span");
			approved_projectcontinous12.click();

			WebElement Projectoverview12 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
			Projectoverview12.click();
					
			
			Thread.sleep(20000);
			GWait.LoadGif();

			GlobalMethods.Commentswindhandler();
			Thread.sleep(8000);
			WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
			iecdecisiontab.click();

			WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
			Select select7 = new Select(decisondropdown);
			select7.selectByVisibleText(Decision_QUERYACTION);

			WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
			decisionupload.sendKeys(Decisionfile);

			WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
			assign_comments2.sendKeys(Decisioncmnt);

			WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
			decisionusubmit.click();

			WebElement logoutt21 = GWait.Wait_GetElementByXpath("//span/a");
			logoutt21.click();

			WebElement logo811 = GWait.Wait_GetElementByCSS("img");
			logo811.click();

			GlobalMethods.PI_Login();

			WebElement query_reply_dashboard = GWait.Wait_GetElementByXpath("//li[3]/a/span");
			query_reply_dashboard.click();

			WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
			overview.click();

			WebElement query_tab = GWait.Wait_GetElementByXpath("//div[3]/ul/li[4]/a");
			query_tab.click();

			WebElement query_tab_edit = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
			query_tab_edit.click();

			WebElement query_comments = GWait.Wait_GetElementByName("query_comments");
			query_comments.sendKeys(Query_Cmnts_Continuation);

			WebElement save_button3 = GWait.Wait_GetElementById("sumsave");
			save_button3.click();
			Thread.sleep(8000);

			Thread.sleep(2000);
			System.out.println(docvalue2.size() - 1);
            System.out.println(querydoccount);
			for (int i = querydoccount; i <= docvalue2.size() - 1; i++) {
				Thread.sleep(10000);
				docdrop2.click();
				String numberAsString = Integer.toString(i);
				Thread.sleep(5000);
				List<WebElement> elementsList3 = docvalue2;
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

				}break;

			}

			Thread.sleep(2000);
			((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
			Thread.sleep(10000);

			WebElement query_submit_button = GWait.Wait_GetElementById("querysubmit");
			query_submit_button.click();

			WebElement logoutt811 = GWait.Wait_GetElementByXpath("//span/a");
			logoutt811.click();

			WebElement logo8111 = GWait.Wait_GetElementByCSS("img");
			logo8111.click();
			
			GlobalMethods.Admin_Login();
			
			WebElement approved_queryreply = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[4]/a/span");
			approved_queryreply.click();
			
			WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
			Projectoverview2.click();

			WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
			Admin_Review2.click();

			WebElement forward_button2 = GWait.Wait_GetElementById("forward_modal_btn");
			forward_button2.click();

			Thread.sleep(6000);
			WebElement ethic_selection2 = GWait.Wait_GetElementById("txn_ethic_committee_id");
			Select select22 = new Select(ethic_selection2);
			select22.selectByVisibleText(ethic_com);

			
			WebElement ethic_comments2 = GWait.Wait_GetElementByClassName("richText");
			ethic_comments2.sendKeys(ethic_comnts);

			WebElement ethic_frwd2 = GWait.Wait_GetElementById("forward_btn");
			ethic_frwd2.click();

			Thread.sleep(20000);
			GWait.LoadGif();
			WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
			logoutt12.click();
			Thread.sleep(8000);
			WebElement logo12 = GWait.Wait_GetElementByCSS("img");
			logo12.click();

			
			
			GlobalMethods.MS_Login();
			
			WebElement approved_queryreply1 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[4]/a/span");
			approved_queryreply1.click();
			
			WebElement Projectoverview21 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
			Projectoverview21.click();

			WebElement asignreviewers1 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
			asignreviewers1.click();

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

			WebElement frwdtocp_button = GWait.Wait_GetElementById("forward_chairman");
			frwdtocp_button.click();

			

			WebElement logoutt211 = GWait.Wait_GetElementByXpath("//span/a");
			logoutt211.click();

			WebElement logo82 = GWait.Wait_GetElementByCSS("img");
			logo82.click();
			
			
			
			
		}
	// --MS GIVING DECISION ON SUBSEQUENT SUBMISSION QUERY LETTER--//
	public void MSDECISION_SUBQUERY() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Admin data

		String ethic_com = r1.getCell(16, 21).getContents();
		String ethic_comnts = r1.getCell(17, 21).getContents();

		// MS data
		String Rev_one = r1.getCell(18, 21).getContents();
		String Rev_two = r1.getCell(19, 21).getContents();
		String Rev_three = r1.getCell(20, 21).getContents();
		String Rev_four = r1.getCell(21, 21).getContents();
		String Rev_five = r1.getCell(22, 21).getContents();
		String Rev_six = r1.getCell(23, 21).getContents();
		String Rev_comnts = r1.getCell(24, 21).getContents();

		// Decision upload data
		String Decisionfile = r1.getCell(25, 21).getContents();
		String Decisioncmnt = r1.getCell(26, 21).getContents();
		String Decision_RESUBMISSION = r1.getCell(27, 21).getContents();
		String Decision_QUERYACTION = r1.getCell(40, 21).getContents();

		String Query_Cmnts_Continuation = r1.getCell(32, 21).getContents();

		// Document upload data
		String Document_Title_in_list = r1.getCell(7, 21).getContents();
		String Version_in_list = r1.getCell(8, 21).getContents();
		String Document_Date_in_list = r1.getCell(9, 21).getContents();
		String doc_upload = r1.getCell(10, 21).getContents();

		PROJCONTADMIN();

		GlobalMethods.Admin_Login();

		WebElement approved_projectcontinous = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[2]/a/span");
		approved_projectcontinous.click();

		WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview2.click();

		WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review2.click();

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

		Thread.sleep(20000);
		GWait.LoadGif();
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();

		GlobalMethods.MS_Login();

		WebElement approved_projectcontinous1 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[2]/a/span");
		approved_projectcontinous1.click();

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

		Thread.sleep(20000);
		GWait.LoadGif();
		GlobalMethods.Commentswindhandler();
		Thread.sleep(8000);
		WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab.click();

		WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
		Select select7 = new Select(decisondropdown);
		select7.selectByVisibleText(Decision_QUERYACTION);

		WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
		decisionupload.sendKeys(Decisionfile);

		WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
		assign_comments2.sendKeys(Decisioncmnt);

		WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit.click();
Thread.sleep(10000);
		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();

		WebElement logo81 = GWait.Wait_GetElementByCSS("img");
		logo81.click();

		GlobalMethods.PI_Login();

		WebElement query_reply_dashboard = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		query_reply_dashboard.click();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();

		WebElement query_tab = GWait.Wait_GetElementByXpath("//div[3]/ul/li[4]/a");
		query_tab.click();

		WebElement query_tab_edit = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		query_tab_edit.click();
        Thread.sleep(20000);
        GWait.LoadGif();
		WebElement query_comments = GWait.Wait_GetElementByName("query_comments");
		query_comments.sendKeys(Query_Cmnts_Continuation);

		WebElement save_button3 = GWait.Wait_GetElementById("sumsave");
		save_button3.click();
		Thread.sleep(8000);

		Thread.sleep(2000);
		System.out.println(docvalue2.size() - 1);

		for (int i = querydoccount; i <= docvalue2.size() - 1; i++) {
			Thread.sleep(10000);
			docdrop2.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
			List<WebElement> elementsList3 = docvalue2;
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

			}break;

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(15000);

		WebElement query_submit_button = GWait.Wait_GetElementById("querysubmit");
		query_submit_button.click();

		WebElement logoutt811 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt811.click();

		WebElement logo811 = GWait.Wait_GetElementByCSS("img");
		logo811.click();

	}

	// --ADMIN GIVES REVIEW FOR INITIAL SUBMISSION--//
	public void ADMINREVIEW() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Admin data

		String ethic_com = r1.getCell(16, 21).getContents();
		String ethic_comnts = r1.getCell(17, 21).getContents();

		GlobalMethods.Admin_Login();

		WebElement Dashboard_newsubmission2 = GWait.Wait_GetElementByCSS("span.pull-left");
		Dashboard_newsubmission2.click();

		WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview2.click();

		WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review2.click();

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

		Thread.sleep(20000);
		GWait.LoadGif();
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();

	}

	// ---MS GIVES DECISION AS RESUBMISSION FOR AN INITIAL SUBMISSION---//
	public void MSDECISION_RESUBMISSION() throws Exception {

		ADMINREVIEWINITIAL();
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");
		// MS data
		String Rev_one = r1.getCell(18, 21).getContents();
		String Rev_two = r1.getCell(19, 21).getContents();
		String Rev_three = r1.getCell(20, 21).getContents();
		String Rev_four = r1.getCell(21, 21).getContents();
		String Rev_five = r1.getCell(22, 21).getContents();
		String Rev_six = r1.getCell(23, 21).getContents();
		String Rev_comnts = r1.getCell(24, 21).getContents();

		// Decision upload data
		String Decisionfile = r1.getCell(25, 21).getContents();
		String Decisioncmnt = r1.getCell(26, 21).getContents();
		String Decision_RESUBMISSION = r1.getCell(27, 21).getContents();

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

		Thread.sleep(20000);
		GWait.LoadGif();

		GlobalMethods.Commentswindhandler();

		WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab.click();

		WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
		Select select7 = new Select(decisondropdown);
		select7.selectByVisibleText(Decision_RESUBMISSION);

		WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
		decisionupload.sendKeys(Decisionfile);

		WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
		assign_comments2.sendKeys(Decisioncmnt);

		WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit.click();
		
		Thread.sleep(20000);
		GWait.LoadGif();

		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();

		WebElement logo81 = GWait.Wait_GetElementByCSS("img");
		logo81.click();

		System.out.println("MSDECISION_RESUBMISSION");

	}

	// --PI SUBMITS RESUBMISSION PROJECT TO IEC ADMIN---//
	public void PIREPLYRESUBMISSION() throws Exception {


		MSDECISION_RESUBMISSION();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		String Document_Title_in_list = r1.getCell(7, 21).getContents();
		String Version_in_list = r1.getCell(8, 21).getContents();
		String Document_Date_in_list = r1.getCell(9, 21).getContents();
		String doc_upload = r1.getCell(10, 21).getContents();

		GlobalMethods.PI_Login();

		WebElement PI_project_menu = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu.click();

		WebElement resubmission_edit = GWait.Wait_GetElementByLinkText("Resubmission");
		resubmission_edit.click();

		Thread.sleep(3000);

		Thread.sleep(2000);
		System.out.println(docvalue2_re.size() - 1);

		for (int i = 1; i <= docvalue2_re.size() - 1; i++) {
			Thread.sleep(6000);

			WebElement docdrop2_re = GWait.Wait_GetElementByXpath(
					"//html/body/div[5]/div[1]/div[2]/div[2]/div[4]/div[2]/form/div/div[1]/div[1]/div/div[1]/button");
			docdrop2_re.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
			List<WebElement> elementsList3 = docvalue2_re;
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
			}break;

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(10000);

		WebElement next_button21 = GWait.Wait_GetElementById("nextidedit");
		next_button21.click();

		WebElement submit_to_IEC21 = GWait.Wait_GetElementById("submitid");
		submit_to_IEC21.click();

		Thread.sleep(8000);

		WebElement logoutt1 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt1.click();

		Thread.sleep(8000);
		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();

		System.out.println("PIREPLYRESUBMISSSION");

	}

	// --PI REPLY RESUBMISSION TO ADMIN FORWARD TO MS--//
	public void PIRESUBMISSIONFRWDMS() throws Exception {


		RESUBMISSION();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Admin data

		String ethic_com = r1.getCell(16, 21).getContents();
		String ethic_comnts = r1.getCell(17, 21).getContents();

		GlobalMethods.Admin_Login();

		WebElement dashresubmission = GWait.Wait_GetElementByXpath("//li[2]/a/span");
		dashresubmission.click();

		WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview2.click();

		WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review2.click();

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

		Thread.sleep(20000);
		GWait.LoadGif();
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();

		System.out.println("PI REPLY RESUBMISSION TO ADMIN FORWARD TO MS");
	}

	
	//--MS FORWARD EXPEDITED RESUBMISSION REPLY TO CP--//
	public void EXPRESUBMISSIONREPLYTOCP() throws Exception {
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");
		
		String Document_Title_in_list = r1.getCell(7, 21).getContents();
		String Version_in_list = r1.getCell(8, 21).getContents();
		String Document_Date_in_list = r1.getCell(9, 21).getContents();
		String doc_upload = r1.getCell(10, 21).getContents();
		
		String ethic_com = r1.getCell(16, 21).getContents();
		String ethic_comnts = r1.getCell(17, 21).getContents();
		// MS data
				String Rev_one = r1.getCell(18, 21).getContents();
				String Rev_two = r1.getCell(19, 21).getContents();
				String Rev_three = r1.getCell(20, 21).getContents();
				String Rev_four = r1.getCell(21, 21).getContents();
				String Rev_five = r1.getCell(22, 21).getContents();
				String Rev_six = r1.getCell(23, 21).getContents();
				String Rev_comnts = r1.getCell(24, 21).getContents();
		
		// Decision upload data
				String Decisionfile = r1.getCell(25, 21).getContents();
				String Decisioncmnt = r1.getCell(26, 21).getContents();
				String Decision_RESUBMISSION = r1.getCell(27, 21).getContents();
				
		//EXPNEWSUBMISSION();
		EXPADMINREVIEWINITIAL();
		
		GlobalMethods.MS_Login();

		WebElement expd_dash = GWait.Wait_GetElementByXpath("//li[2]/a/span");
		expd_dash.click();

		WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview1.click();

		
		Thread.sleep(20000);
		GWait.LoadGif();

		GlobalMethods.Commentswindhandler();

		WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab.click();

		WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
		Select select7 = new Select(decisondropdown);
		select7.selectByVisibleText(Decision_RESUBMISSION);

		WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
		decisionupload.sendKeys(Decisionfile);

		WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
		assign_comments2.sendKeys(Decisioncmnt);

		WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit.click();

		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();

		WebElement logo81 = GWait.Wait_GetElementByCSS("img");
		logo81.click();
		
		GlobalMethods.PI_Login();

		WebElement PI_project_menu = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu.click();

		WebElement resubmission_edit = GWait.Wait_GetElementByLinkText("Resubmission");
		resubmission_edit.click();

		Thread.sleep(3000);

		Thread.sleep(2000);
		System.out.println(docvalue2_re.size() - 1);

		for (int i = 1; i <= docvalue2_re.size() - 1; i++) {
			querydoccount = docvalue2_re.size();
			Thread.sleep(6000);

			WebElement docdrop2_re = GWait.Wait_GetElementByXpath("//html/body/div[5]/div[1]/div[2]/div[2]/div[4]/div[2]/form/div/div[1]/div[1]/div/div[1]/button");
			docdrop2_re.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
			List<WebElement> elementsList3 = docvalue2_re;
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
			}break;

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(10000);

		WebElement next_button21 = GWait.Wait_GetElementById("nextidedit");
		next_button21.click();

		WebElement submit_to_IEC21 = GWait.Wait_GetElementById("submitid");
		submit_to_IEC21.click();

		Thread.sleep(8000);

		WebElement logoutt1 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt1.click();

		Thread.sleep(8000);
		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();

		GlobalMethods.Admin_Login();

		WebElement dashresubmission = GWait.Wait_GetElementByXpath("//li[2]/a/span");
		dashresubmission.click();

		WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview2.click();

		WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review2.click();

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

		Thread.sleep(20000);
		GWait.LoadGif();
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();
		
		GlobalMethods.MS_Login();
		
		WebElement resub =GWait.Wait_GetElementByXpath("//ul[2]/li/a/span");
		resub.click();
		
		WebElement Projectoverview21 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview21.click();

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

		WebElement frwdtocp_button = GWait.Wait_GetElementById("forward_chairman");
		frwdtocp_button.click();
	

		WebElement logoutt21 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt21.click();

		WebElement logo82 = GWait.Wait_GetElementByCSS("img");
		logo82.click();
		
		
	}
	// --PI INITIAL TO PI REPLYING TO RESUBMISSION--//
	public void RESUBMISSION() throws Exception {


		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		FBNEWSUBMISSION();
		ADMINREVIEWINITIAL();
		ADMINREVIEW();
		MSDECISION_RESUBMISSION();
		PIREPLYRESUBMISSION();

		System.out.println("RESUBMISSSION");

	}
	// --PI SUBMITS WITHDRAWN SUBMISSION TO IEC ADMIN---//

	public void WITHDRAWNREQADMIN() throws Exception {


		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Document upload data
		String Document_Title_in_list = r1.getCell(7, 21).getContents();
		String Version_in_list = r1.getCell(8, 21).getContents();
		String Document_Date_in_list = r1.getCell(9, 21).getContents();
		String doc_upload = r1.getCell(10, 21).getContents();

		FBNEWSUBMISSION();

		GlobalMethods.PI_Login();

		WebElement PI_project_menu = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu.click();

		WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview1.click();

		WebElement newdocuments = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments.click();

		WebElement with = GWait.Wait_GetElementByLinkText("Withdrawal");
		with.click();

		Thread.sleep(4000);

		Thread.sleep(2000);
		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; i++) {
			Thread.sleep(6000);

			WebElement docdrop1 = GWait
					.Wait_GetElementByXpath("//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/button");
			docdrop1.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
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

				WebElement doc_version = GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);

				WebElement doc_date = GWait.Wait_GetElementById("document_date");
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
		Thread.sleep(8000);
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();

		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();

	}
	// --MS GIVES DECISION AS QUERY FOR AN INITIAL Expedited SUBMISSION--//
	public void MSDECISION_EXPQUERY() throws Exception {
		



		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");
		// MS data
		String Rev_one = r1.getCell(18, 21).getContents();
		String Rev_two = r1.getCell(19, 21).getContents();
		String Rev_three = r1.getCell(20, 21).getContents();
		String Rev_four = r1.getCell(21, 21).getContents();
		String Rev_five = r1.getCell(22, 21).getContents();
		String Rev_six = r1.getCell(23, 21).getContents();
		String Rev_comnts = r1.getCell(24, 21).getContents();

		// Decision upload data
		String Decisionfile = r1.getCell(25, 21).getContents();
		String Decisioncmnt = r1.getCell(26, 21).getContents();
		String Decision_Query_letter = r1.getCell(33, 21).getContents();

		EXPADMINREVIEWINITIAL();
		
		GlobalMethods.MS_Login();

		WebElement explink = GWait.Wait_GetElementByXpath("//li[2]/a/span");
		explink.click();

		WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview1.click();

		/*WebElement asignreviewers = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
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
		assign_button.click();*/

		Thread.sleep(20000);
		GWait.LoadGif();

		GlobalMethods.Commentswindhandler();
		Thread.sleep(8000);
		WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab.click();

		WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
		Select select7 = new Select(decisondropdown);
		select7.selectByVisibleText(Decision_Query_letter);

		WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
		decisionupload.sendKeys(Decisionfile);

		WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
		assign_comments2.sendKeys(Decisioncmnt);

		WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit.click();

		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();

		WebElement logo81 = GWait.Wait_GetElementByCSS("img");
		logo81.click();

	
		
	}

	// --MS GIVES DECISION AS QUERY FOR AN INITIAL SUBMISSION--//
	public void MSDECISION_QUERY() throws Exception {


		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");
		// MS data
		String Rev_one = r1.getCell(18, 21).getContents();
		String Rev_two = r1.getCell(19, 21).getContents();
		String Rev_three = r1.getCell(20, 21).getContents();
		String Rev_four = r1.getCell(21, 21).getContents();
		String Rev_five = r1.getCell(22, 21).getContents();
		String Rev_six = r1.getCell(23, 21).getContents();
		String Rev_comnts = r1.getCell(24, 21).getContents();

		// Decision upload data
		String Decisionfile = r1.getCell(25, 21).getContents();
		String Decisioncmnt = r1.getCell(26, 21).getContents();
		String Decision_Query_letter = r1.getCell(33, 21).getContents();

		ADMINREVIEWINITIAL();
		
		GlobalMethods.MS_Login();

		WebElement fullboardlink = GWait.Wait_GetElementByCSS("span.pull-left");
		fullboardlink.click();

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

		Thread.sleep(20000);
		GWait.LoadGif();

		GlobalMethods.Commentswindhandler();
		Thread.sleep(8000);
		WebElement iecdecisiontab = GWait.Wait_GetElementByLinkText("IEC Decision");
		iecdecisiontab.click();

		WebElement decisondropdown = GWait.Wait_GetElementById("decision_type");
		Select select7 = new Select(decisondropdown);
		select7.selectByVisibleText(Decision_Query_letter);

		WebElement decisionupload = GWait.Wait_GetElementById("proj_document");
		decisionupload.sendKeys(Decisionfile);

		WebElement assign_comments2 = GWait.Wait_GetElementById("comments");
		assign_comments2.sendKeys(Decisioncmnt);

		WebElement decisionusubmit = GWait.Wait_GetElementByXpath("//input[@value='Submit']");
		decisionusubmit.click();

		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();

		WebElement logo81 = GWait.Wait_GetElementByCSS("img");
		logo81.click();

	}

	//--MS FORWARDS EXPEDITED PROJECT WITHDRAWN TO CP--//
	public void EXPWITHPROJMSTOCP() throws Exception {

		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Document upload data
		String Document_Title_in_list = r1.getCell(7, 21).getContents();
		String Version_in_list = r1.getCell(8, 21).getContents();
		String Document_Date_in_list = r1.getCell(9, 21).getContents();
		String doc_upload = r1.getCell(10, 21).getContents();
		
		// Admin data
		String pyrcnum = r1.getCell(11, 21).getContents();
		String inwnum = r1.getCell(12, 21).getContents();
		String prjnum = r1.getCell(13, 21).getContents();
		String insdate = r1.getCell(14, 21).getContents();
		String inwrddate = r1.getCell(15, 21).getContents();
		String ethic_com = r1.getCell(16, 21).getContents();
		String ethic_comnts = r1.getCell(17, 21).getContents();
		
		String Rev_one = r1.getCell(18, 21).getContents();
		String Rev_two = r1.getCell(19, 21).getContents();
		String Rev_three = r1.getCell(20, 21).getContents();
		String Rev_four = r1.getCell(21, 21).getContents();
		String Rev_five = r1.getCell(22, 21).getContents();
		String Rev_six = r1.getCell(23, 21).getContents();
		String Rev_comnts = r1.getCell(24, 21).getContents();
		
		EXPNEWSUBMISSION();
		
		GlobalMethods.PI_Login();

		WebElement PI_project_menu = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu.click();

		WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview1.click();

		WebElement newdocuments = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments.click();

		WebElement with = GWait.Wait_GetElementByLinkText("Withdrawal");
		with.click();

		Thread.sleep(4000);

		Thread.sleep(2000);
		System.out.println(docvalue1.size() - 1);

		for (int i = 1; i <= docvalue1.size() - 1; i++) {
			Thread.sleep(6000);

			WebElement docdrop1 = GWait
					.Wait_GetElementByXpath("//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/button");
			docdrop1.click();
			String numberAsString = Integer.toString(i);
			Thread.sleep(5000);
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

				WebElement doc_version = GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);

				WebElement doc_date = GWait.Wait_GetElementById("document_date");
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
		Thread.sleep(8000);
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();

		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();

		

				GlobalMethods.Admin_Login();

				WebElement Dashboard_with = GWait.Wait_GetElementByXpath("//li[3]/a/span");
				Dashboard_with.click();

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

				Thread.sleep(20000);
				GWait.LoadGif();
				WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
				logoutt12.click();
				Thread.sleep(8000);
				WebElement logo12 = GWait.Wait_GetElementByCSS("img");
				logo12.click();
				
				GlobalMethods.MS_Login();

				WebElement prjtswith =GWait.Wait_GetElementByXpath("//li[5]/a/span");
				prjtswith.click();

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

				WebElement frwdtocp_button = GWait.Wait_GetElementById("forward_chairman");
				frwdtocp_button.click();

				

				WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
				logoutt2.click();

				WebElement logo81 = GWait.Wait_GetElementByCSS("img");
				logo81.click();
					
				System.out.println("MS FORWARDS EXPEDITED PROJECT WITHDRAWN TO CP");

		
	}
	// ---ADMIN FORWARDS PIWITHDRAWN PROJECT TO MS--//
	public void ADMINFRWDWITHDRWN() throws Exception {

		WITHDRAWNREQADMIN();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Admin data
		String pyrcnum = r1.getCell(11, 21).getContents();
		String inwnum = r1.getCell(12, 21).getContents();
		String prjnum = r1.getCell(13, 21).getContents();
		String insdate = r1.getCell(14, 21).getContents();
		String inwrddate = r1.getCell(15, 21).getContents();
		String ethic_com = r1.getCell(16, 21).getContents();
		String ethic_comnts = r1.getCell(17, 21).getContents();

		GlobalMethods.Admin_Login();

		WebElement Dashboard_with = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		Dashboard_with.click();

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

		Thread.sleep(20000);
		GWait.LoadGif();
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();

		System.out.println("ADMIN FORWARDS PIWITHDRAWN INITIAL SUBMISSION TO MS");

	}

	//--MS FORWARD QUERY REPLY TO CP--//
	public void EXPMSFRWDPIQUERYREPLY() throws Exception {
		
		EXPADMINFRWDPIQUERYREPLY();
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");
		// MS data
		String Rev_one = r1.getCell(18, 21).getContents();
		String Rev_two = r1.getCell(19, 21).getContents();
		String Rev_three = r1.getCell(20, 21).getContents();
		String Rev_four = r1.getCell(21, 21).getContents();
		String Rev_five = r1.getCell(22, 21).getContents();
		String Rev_six = r1.getCell(23, 21).getContents();
		String Rev_comnts = r1.getCell(24, 21).getContents();
		
		GlobalMethods.MS_Login();

		WebElement qry =GWait.Wait_GetElementByXpath("//li[4]/a/span");
		qry.click();

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

		WebElement frwdtocp_button = GWait.Wait_GetElementById("forward_chairman");
		frwdtocp_button.click();

		

		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();

		WebElement logo81 = GWait.Wait_GetElementByCSS("img");
		logo81.click();
		
		
	}
	//--ADMIN FORWARD EXPEDITED QUERY REPLY TO MS--//
	public void EXPADMINFRWDPIQUERYREPLY() throws Exception {
		
		EXPPIQUERYREPLY();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Admin data
		String pyrcnum = r1.getCell(11, 21).getContents();
		String inwnum = r1.getCell(12, 21).getContents();
		String prjnum = r1.getCell(13, 21).getContents();
		String insdate = r1.getCell(14, 21).getContents();
		String inwrddate = r1.getCell(15, 21).getContents();
		String ethic_com = r1.getCell(16, 21).getContents();
		String ethic_comnts = r1.getCell(17, 21).getContents();

		GlobalMethods.Admin_Login();

		WebElement dashqueryreply = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		dashqueryreply.click();

		WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview2.click();

		WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review2.click();

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

		Thread.sleep(20000);
		GWait.LoadGif();
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();
	}
	
	// ---ADMIN FORWARDS PIREPLIED QUERY TO MS--//
	public void ADMINFRWDPIQUERYREPLY() throws Exception {

		PIQUERYREPLY();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Admin data
		String pyrcnum = r1.getCell(11, 21).getContents();
		String inwnum = r1.getCell(12, 21).getContents();
		String prjnum = r1.getCell(13, 21).getContents();
		String insdate = r1.getCell(14, 21).getContents();
		String inwrddate = r1.getCell(15, 21).getContents();
		String ethic_com = r1.getCell(16, 21).getContents();
		String ethic_comnts = r1.getCell(17, 21).getContents();

		GlobalMethods.Admin_Login();

		WebElement dashqueryreply = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		dashqueryreply.click();

		WebElement Projectoverview2 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview2.click();

		WebElement Admin_Review2 = GWait.Wait_GetElementByLinkText("IEC Admin Review");
		Admin_Review2.click();

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

		Thread.sleep(20000);
		GWait.LoadGif();
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		Thread.sleep(8000);
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();

		System.out.println("ADMIN FORWARDS PIQUERYREPLY INITIAL SUBMISSION TO MS");
	}
	
	// ---PI REPLY TO INITIAL EXPEDITED QUERY TO IEC ADMIN
		public void EXPPIQUERYREPLY() throws Exception {

			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("Dashboard");

			// Project summary data
			String Project_Type = r1.getCell(2, 7).getContents();
			String Review_Type_fullboard = r1.getCell(3, 7).getContents();
			String Project_Full_Title = r1.getCell(4, 7).getContents();
			String Project_Short_Title = r1.getCell(5, 7).getContents();
			String Sponsor = r1.getCell(6, 7).getContents();

			// Document upload data
			String Document_Title_in_list = r1.getCell(7, 21).getContents();
			String Version_in_list = r1.getCell(8, 21).getContents();
			String Document_Date_in_list = r1.getCell(9, 21).getContents();
			String doc_upload = r1.getCell(10, 21).getContents();

			String Query_Cmnts_Continuation = r1.getCell(32, 7).getContents();
			//EXPNEWSUBMISSION();
			//EXPADMINREVIEWINITIAL();
		
			MSDECISION_EXPQUERY();

			GlobalMethods.PI_Login();

			WebElement query_reply_dashboard = GWait.Wait_GetElementByXpath("//li[3]/a/span");
			query_reply_dashboard.click();

			WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
			overview.click();

			WebElement query_tab = GWait.Wait_GetElementByXpath("//div[3]/ul/li[4]/a");
			query_tab.click();

			WebElement query_tab_edit = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
			query_tab_edit.click();

			WebElement query_comments = GWait.Wait_GetElementByName("query_comments");
			query_comments.sendKeys(Query_Cmnts_Continuation);

			WebElement save_button3 = GWait.Wait_GetElementById("sumsave");
			save_button3.click();

			Thread.sleep(8000);

			Thread.sleep(4000);
			System.out.println(docvalue2.size() - 1);
			for (int i = querydoccount; i <= docvalue2.size() - 1; i++) {
				querydoccount = docvalue2.size();
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

				}break;

			}

			Thread.sleep(2000);
			((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
			Thread.sleep(10000);

			WebElement query_submit_button = GWait.Wait_GetElementById("querysubmit");
			query_submit_button.click();

			WebElement logoutt811 = GWait.Wait_GetElementByXpath("//span/a");
			logoutt811.click();

			WebElement logo811 = GWait.Wait_GetElementByCSS("img");
			logo811.click();
			
		}

	// ---PI REPLY TO INITIAL FULLBOARD QUERY TO IEC ADMIN
	public void PIQUERYREPLY() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Project summary data
		String Project_Type = r1.getCell(2, 7).getContents();
		String Review_Type_fullboard = r1.getCell(3, 7).getContents();
		String Project_Full_Title = r1.getCell(4, 7).getContents();
		String Project_Short_Title = r1.getCell(5, 7).getContents();
		String Sponsor = r1.getCell(6, 7).getContents();

		// Document upload data
		String Document_Title_in_list = r1.getCell(7, 21).getContents();
		String Version_in_list = r1.getCell(8, 21).getContents();
		String Document_Date_in_list = r1.getCell(9, 21).getContents();
		String doc_upload = r1.getCell(10, 21).getContents();

		String Query_Cmnts_Continuation = r1.getCell(32, 7).getContents();
		GlobalMethods.PI_Login();

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

		// WebElement docdrop =
		// GWait.Wait_GetElementByXpath("//*[@id='document_type']/div/button");

		Thread.sleep(2000);
		System.out.println(docvalue.size() - 1);
		int count = querydoccount = docvalue.size();

		for (int i = 1; i <= docvalue.size() - 1; i++) {
			Thread.sleep(10000);
			WebElement docdrop = GWait.Wait_GetElementByXpath(
					"html/body/div[5]/div[1]/div[3]/div[4]/div[2]/form/div/div[1]/div[1]/div/div/div/button");
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

			}break;

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

		WebElement logo2 = GWait.Wait_GetElementByCSS("img");
		logo2.click();

		ADMINREVIEWINITIAL();
		ADMINREVIEW();
		MSDECISION_QUERY();

		GlobalMethods.PI_Login();

		WebElement query_reply_dashboard = GWait.Wait_GetElementByXpath("//li[3]/a/span");
		query_reply_dashboard.click();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();

		WebElement query_tab = GWait.Wait_GetElementByXpath("//div[3]/ul/li[4]/a");
		query_tab.click();

		WebElement query_tab_edit = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		query_tab_edit.click();

		WebElement query_comments = GWait.Wait_GetElementByName("query_comments");
		query_comments.sendKeys(Query_Cmnts_Continuation);

		WebElement save_button3 = GWait.Wait_GetElementById("sumsave");
		save_button3.click();

		Thread.sleep(8000);

		Thread.sleep(4000);
		System.out.println(docvalue2.size() - 1);
		for (int i = querydoccount; i <= docvalue2.size() - 1; i++) {
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

			}break;

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(10000);

		WebElement query_submit_button = GWait.Wait_GetElementById("querysubmit");
		query_submit_button.click();

		WebElement logoutt811 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt811.click();

		WebElement logo811 = GWait.Wait_GetElementByCSS("img");
		logo811.click();

	}

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

	// sussequent doctype upload

	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/button")
	public WebElement docdrop1;
	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/div/ul/li")
	public static List<WebElement> docvalue1;

	@FindBy(xpath = "//*[@id='respondqueryupload']/div/div[1]/div[1]/div/div/button")
	public WebElement docdrop2;
	@FindBy(xpath = "//*[@id='respondqueryupload']/div/div[1]/div[1]/div/div/div/ul/li")
	public static List<WebElement> docvalue2;

	@FindBy(xpath = ".//*[@id='documentuploadprojectresubmission']/div/div[1]/div[1]/div/div[1]/button")
	public WebElement docdrop2_re;
	@FindBy(xpath = "html/body/div[5]/div[1]/div[2]/div[2]/div[4]/div[2]/form/div/div[1]/div[1]/div/div[1]/div/ul/li")
	public static List<WebElement> docvalue2_re;

	@FindBy(xpath = "//*[@id='saedetails']/div[1]/div[2]/div[1]/div/div/div/ul/li")
	public static List<WebElement> sae_site_value;

	@FindBy(xpath = "//*[@id='report_types_sel']/div/div/div/ul/li")
	public static List<WebElement> sae_report_value;

	@FindBy(id = "patient_initial")
	WebElement Sae_patient_initial;

	@FindBy(id = "sae_number")
	WebElement Sae_sae_number;

	@FindBy(id = "followup_number")
	WebElement sae_followup_number;

	@FindBy(linkText = "followup_date")
	WebElement sae_followup_date;

	@FindBy(xpath = "//*[@id='document_type_sae']/div/button")
	public WebElement sae_docdrop;
	@FindBy(xpath = "//*[@id='document_type_sae']/div/div/ul/li")
	public static List<WebElement> sae_docvalue;

}
