package com.create4.scenarios;

import java.io.FileInputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

/*
 * Check for project type & review type cannot be changed after admin forwards the submission to MS
 */
public class TS_62 {
	
	public TS_62() {
		PageFactory.initElements(GlobalMethods.driver, this);
		
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);
	
	public void Cre462() throws Exception {
		
		GlobalMethods.PI_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Project Submissions");
		

		// Project summary data

		String Project_Type = r1.getCell(2, 535).getContents();
		String Review_Type_Expedited = r1.getCell(3, 535).getContents();
		String Project_Full_Title = r1.getCell(4, 535).getContents();
		String Project_Short_Title = r1.getCell(5, 535).getContents();
		String Sponsor = r1.getCell(6, 535).getContents();

		// Document upload data
		String Document_Title_in_list = r1.getCell(7, 535).getContents();
		String Version_in_list = r1.getCell(8, 535).getContents();
		String Document_Date_in_list = r1.getCell(9, 535).getContents();
		String doc_upload = r1.getCell(10, 535).getContents();
			

		// Admin data
		String pyrcnum = r1.getCell(11, 535).getContents();
		String inwnum = r1.getCell(12, 535).getContents();
		String prjnum = r1.getCell(13, 535).getContents();
		String insdate = r1.getCell(14, 535).getContents();
		String inwrddate = r1.getCell(15, 535).getContents();
		String ethic_com = r1.getCell(16, 535).getContents();
		String ethic_comnts = r1.getCell(17, 535).getContents();

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
	
		
		WebElement sponsor =GWait.Wait_GetElementById("project_description");
		sponsor.sendKeys(Sponsor);
		WebElement save_button1 = GWait.Wait_GetElementById("sumsave");
		save_button1.click();
	
		
		for (int i = 1; i <= docvalue.size() - 1; i++) {
				
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
				System.out.println(Document_Title_in_list);
				WebElement doc_title = GWait.Wait_GetElementById("document_title");
				doc_title.sendKeys(Document_Title_in_list);
				Thread.sleep(1000);
				System.out.println(Version_in_list);
				WebElement doc_version =GWait.Wait_GetElementById("version");
				doc_version.sendKeys(Version_in_list);
				Thread.sleep(1000);
				System.out.println(Document_Date_in_list);
				WebElement doc_date =GWait.Wait_GetElementById("document_date");
				doc_date.sendKeys(Document_Date_in_list);
				Thread.sleep(1000);
				System.out.println(doc_upload);
				WebElement upload_doc = GWait.Wait_GetElementById("proj_document");
				upload_doc.sendKeys(doc_upload);
				Thread.sleep(1000);
				WebElement save_button2 = GWait.Wait_GetElementById("savedoc");
				save_button2.click();

			}

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(10000);
		

		WebElement next_button1 = GWait.Wait_GetElementById("nextid");
		next_button1.click();

		// submitting full board project to admin

		WebElement submit_to_IEC = GWait.Wait_GetElementById("submitid");
		submit_to_IEC.click();
		Thread.sleep(2000);
		WebElement no=GWait.Wait_GetElementByXpath("//form[@id='conflictsubmit']/div/div/div/div/input[2]");
		no.click();
		
		WebElement conflictsubmit = GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		conflictsubmit.click();
		GlobalMethods.alertaccept();
		Thread.sleep(6000);
		
		WebElement logouttA = GWait.Wait_GetElementByXpath("//span[3]/a");
		logouttA.click();
		WebElement logoA = GWait.Wait_GetElementByCSS("img");
		logoA.click();
		
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
		
		GlobalMethods.PI_Login();
		
		WebElement submissionundereview = GWait.Wait_GetElementByXpath("//li[2]/a/span");
		submissionundereview.click();
			
		String XPath1 = "//html/body/div[5]/div/div/div[2]/div[3]/div/div/div[1]/div[2]/div/div/table/tbody/tr[1]/td[9]/a[2]/span";
		Boolean iselementpresent = GlobalMethods.driver.findElements(By.xpath(XPath1)).size()!= 0;
		   if (iselementpresent == true)
		   {
		    System.out.print("Able to see edit button");
		   }
		   else
		   {
		    System.out.print("System will not given edit button as project forward to MS by IEC");
		   }
			
	}
	
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
	
}
