package com.create4.scenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
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
 * Check for Submit new project form
 */
public class TS_146 {
	public TS_146() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	// PI submit new project page elements

	@FindBy(linkText = "Submit New Project")
	WebElement createproject;

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

	@FindBy(linkText = "Projects Documents/Project Review")
	WebElement create_proj_document_submission;

	@FindBy(linkText = "Submit Documents")
	WebElement create_proj_submit_documents;
	
	@FindBy(css = "h3")
	WebElement project_summary_heading;
	
	@FindBy(xpath = "//form[@id='documentuploadproject']/div/h3/span")
	WebElement project_submit_docs;
	
	@FindBy(xpath = "//div[@id='list_documents']/div/h3")
	WebElement project_submit_docs_list;
	
	
	
	

	// Check for Submit new project link (Initial submissions)
	public void CRe4_1989_1991_1992() throws Exception {
		
		try{


		GlobalMethods.PI_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
			
		Sheet r1 = wb.getSheet("Projects");
		Sheet r2 = wb.getSheet("Institute_Logins");
		Sheet r3 = wb.getSheet("Data_Sheet");
		
		String heading = r1.getCell(2, 27).getContents();
		String heading_second_tab = r1.getCell(3, 27).getContents();
		String heading_third_tab = r1.getCell(4, 27).getContents();
		String heading_four_tab = r1.getCell(5, 27).getContents();
		String heading_five_tab = r1.getCell(6, 27).getContents();

		// Project summary data

		String Project_Type = r1.getCell(7, 27).getContents();
		String Review_Type_expedited = r1.getCell(8, 27).getContents();
		String Project_Full_Title = r1.getCell(9, 27).getContents();
		String Project_Short_Title = r1.getCell(10, 27).getContents();
		String Sponsor = r1.getCell(11, 27).getContents();

		// Document upload data
		
		String Document_Title_in_list = r1.getCell(12, 27).getContents();
		String Version_in_list = r1.getCell(13, 27).getContents();
		String Document_Date_in_list = r1.getCell(14, 27).getContents();
		String doc_upload = r1.getCell(15, 27).getContents();

		
		String doc_upload_heading = r1.getCell(16, 27).getContents();

		// study team member
		
		String studyteammem_name = r3.getCell(2, 119).getContents();
		String studyteammem_email = r3.getCell(3, 119).getContents();
		String studyteammem_role = r3.getCell(4, 119).getContents();
		String studyteammem_pwd = r3.getCell(5, 119).getContents();

		String PI_Institute = r2.getCell(0, 2).getContents();

		/*String project_summary_section_1_1 = project_summary_section_1.getText();
		Assert.assertEquals(heading, project_summary_section_1_1);

		System.out.println(project_summary_section_1_1);*/

		/*String create_proj_document_submission_2_2 = create_proj_document_submission.getText();
		Assert.assertEquals(heading_second_tab, create_proj_document_submission_2_2);

		System.out.println(create_proj_document_submission_2_2);*/
		

		// pi submitting project

		WebElement createproject = GWait.Wait_GetElementByLinkText("Submit New Project");
		createproject.click();
		
		// checking all tabs
		
		System.out.println(heading);
		System.out.println(heading_second_tab);
		System.out.println(heading_third_tab);
		System.out.println(heading_third_tab);
		System.out.println(heading_four_tab);
		System.out.println(heading_five_tab);
		Thread.sleep(2000);
		
		// checking project elements
		
		Assert.assertEquals(create_proj_submit_documents.getText(), heading);
		System.out.println(create_proj_submit_documents.getText());
		
		Assert.assertEquals(create_proj_document_submission.getText(), heading_second_tab);
		System.out.println(create_proj_document_submission.getText());
		
		Assert.assertEquals(project_summary_heading.getText(), heading_third_tab);
		System.out.println(project_summary_heading.getText());
		
		Assert.assertEquals(project_submit_docs.getText(), heading_four_tab);
		System.out.println(project_submit_docs.getText());
		
		
		

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
		
		Assert.assertEquals(project_submit_docs_list.getText(), doc_upload_heading);
		System.out.println(project_submit_docs_list.getText());
		

		WebElement next_button = GWait.Wait_GetElementById("nextid");
		next_button.click();
		
		Assert.assertEquals(project_summary_heading.getText(), heading_five_tab);
		System.out.println(project_summary_heading.getText());
		
		WebElement next_button1 = GWait.Wait_GetElementById("nextid");
		next_button1.click();

		// assigning study team member
		
		WebElement PI_project_menu = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu.click();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();
		
		WebElement studyteammember = GWait.Wait_GetElementByLinkText("Study Team Member");
		studyteammember.click();
		
		
		WebElement studyteammember_name = GWait.Wait_GetElementById("study_member_name");
		studyteammember_name.sendKeys(studyteammem_name);
		
		
		WebElement studyteammember_email = GWait.Wait_GetElementById("study_member_email");
		studyteammember_email.sendKeys(studyteammem_email);

		
		WebElement studyteammember_role = GWait.Wait_GetElementByXpath("//*[@id='forward_submission']/div/div[1]/div[3]/div/select");
		Select select = new Select(studyteammember_role);
		select.selectByVisibleText(studyteammem_role);

		
		WebElement studyteammember_authorize = GWait.Wait_GetElementById("savedoc");
		studyteammember_authorize.click();
	
		

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();

		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();
		
		WebElement institute = GWait.Wait_GetElementByLinkText(PI_Institute);
		institute.click();
		
	
		WebElement email =GWait.Wait_GetElementById("register_email");
		email.sendKeys(studyteammem_email);
		
		
		WebElement pwd =GWait.Wait_GetElementById("register_password");
		
		pwd.sendKeys(studyteammem_pwd);
		
		
		WebElement rol =GWait.Wait_GetElementById("register_role");

		Select dropdown = new Select(rol);
		dropdown.selectByValue("2");
		
		
		WebElement login =GWait.Wait_GetElementById("login_institute");
		login.click();
        Thread.sleep(2000);
		WebElement PI_project_menu2 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu2.click();
		
	/*	WebElement i = GlobalMethods.driver.findElement(By.linkText("Submit New Project"));
		if (i.isDisplayed()) {
			overview.click();

		} else {
			System.out.println("Value is inactive");
		}*/
		
		String XPath1 = "//ul[@id='accordion']/li[2]/div/a";
		Boolean iselementpresent = GlobalMethods.driver.findElements(By.xpath(XPath1)).size()!= 0;
		   if (iselementpresent == true)
		   {
		    System.out.print("Value is active");
		   }
		   else
		   {
		    System.out.print("Value is inactive");
		   }
		
		   File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile1");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.GREEN.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(117).createCell(4).setCellValue("Pass");
			sheet.getRow(117).getCell(4).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
		} catch (Throwable e) {
			System.out.println("Report Error: "+ "\n" + e);
			 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
				FileInputStream input = new FileInputStream(source);
				HSSFWorkbook wb11=new HSSFWorkbook(input);
					
				
				HSSFSheet sheet=wb11.getSheet("Executionfile1");
				HSSFCellStyle style = wb11.createCellStyle();
				HSSFFont font = wb11.createFont();
				font.setFontName(HSSFFont.FONT_ARIAL);
				font.setColor(HSSFColor.RED.index);
				font.setFontHeightInPoints((short)10);
				font.setBold(true);
				style.setFont(font);
				
				sheet.getRow(117).createCell(4).setCellValue("Fail");
				sheet.getRow(117).getCell(4).setCellStyle(style);
				
				sheet.getRow(117).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(117).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}


	}

}
