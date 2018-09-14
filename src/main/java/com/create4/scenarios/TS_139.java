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

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

//Check for project invitation email to investigator by PI
public class TS_139 {

	public TS_139() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);
	// study team members

	@FindBy(linkText = "Study Team Member")
	WebElement studyteammember;

	@FindBy(id = "study_member_name")
	WebElement studyteammember_name;

	@FindBy(css = ".ui-corner-all")
	List<WebElement> studyteammember_selectname;

	@FindBy(xpath = "//*[@id='forward_submission']/div/div[1]/div[3]/div/select")
	WebElement studyteammember_role;

	@FindBy(id = "study_member_email")
	WebElement studyteammember_email;

	@FindBy(id = "savedoc")
	WebElement studyteammember_authorize;

	@FindBy(xpath = "//td[3]")
	WebElement studyteammember_name_inlist;

	@FindBy(xpath = "//td[4]")
	WebElement studyteammember_email_inlist;

	@FindBy(xpath = "//td[5]")
	WebElement studyteammember_role_inlist;

	@FindBy(linkText = "My Projects")
	WebElement PI_project_menu;

	@FindBy(css = "span.fa.fa-eye")
	WebElement overview;

	@FindBy(xpath = "//span/a")
	WebElement logoutt;

	@FindBy(css = "img")
	WebElement logo;

	@FindBy(xpath = "//span[2]/a")
	WebElement delegate;

	@FindBy(xpath = "//td[7]/span/a")
	WebElement status;

	@FindBy(xpath = "//div[@id='deactivatingStudyTeamMmeber']/div[2]/div/div[2]/button")
	WebElement ok;

	@FindBy(xpath = "//div[@id='deactivatingStudyTeamMmeber']/div[2]/div/div[2]/button[2]")
	WebElement cancel;

	@FindBy(css = "span.fa.fa-edit")
	WebElement query_tab_edit;

	@FindBy(id = "nextidedit")
	WebElement next_button;

	@FindBy(id = "submitid")
	WebElement submit_to_IEC;

	@FindBy(xpath = "//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[2]")
	WebElement no;

	@FindBy(xpath = "//*[@id='submit_for_iec_review_confirm']")
	WebElement conflictsubmit;

	@FindBy(xpath = "//div[8]/div/h3")
	WebElement studyteamheading;

	@FindBy(xpath = "//div[8]/div/div/table/thead/tr/th")
	WebElement studyteamheading_name;

	@FindBy(xpath = "//div[8]/div/div/table/thead/tr/th[2]")
	WebElement studyteamheading_email;

	@FindBy(xpath = "//div[8]/div/div/table/thead/tr/th[3]")
	WebElement studyteamheading_date;

	@FindBy(linkText = "View all")
	WebElement studyteamheading_viewall;

	@FindBy(css = "h3")
	WebElement studyteamheading_heading;

	@FindBy(linkText = "Manage Users")
	WebElement admin_manage_users;

	@FindBy(linkText = "View Invitee Requests")
	WebElement view_invitee_requests;

	@FindBy(css = "div.bgand-border > h3")
	WebElement view_text1;

	@FindBy(xpath = "//th[3]/a/span[2]")
	WebElement view_text2;

	@FindBy(xpath = "//th[4]/a/span[2]")
	WebElement view_text3;

	@FindBy(xpath = "//th[5]/a/span[2]")
	WebElement view_text4;

	@FindBy(xpath = "//th[6]/a/span[2]")
	WebElement view_text5;

	@FindBy(xpath = "//th[7]/a/span[2]")
	WebElement view_text6;

	@FindBy(xpath = "//th[8]/span")
	WebElement view_text7;

	@FindBy(xpath = "//td[4]")
	WebElement view_table_1;

	@FindBy(xpath = "//td[5]")
	WebElement view_table_2;

	@FindBy(xpath = "//td[6]")
	WebElement view_table_3;

	@FindBy(xpath = "//td[8]")
	WebElement view_table_4;

	@FindBy(id = "register_email")
	WebElement email;

	@FindBy(id = "register_password")
	WebElement pwd;

	@FindBy(id = "register_role")
	WebElement rol;

	@FindBy(id = "login_institute")
	WebElement login;

	@FindBy(linkText = "Research approval institute")
	WebElement Instlink;

	@FindBy(linkText = "Forgot Password ?")
	WebElement forgotlink;

	@FindBy(css = "h3")
	WebElement forgotheading;

	@FindBy(css = "label.col-md-4")
	WebElement forgotemailfield;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement forgotbutton;

	@FindBy(css = "p.error-msg")
	WebElement forgotemailalert;

	@FindBy(name = "email")
	WebElement emailaddress;

	@FindBy(css = "div.alert.alert-success")
	WebElement successalert;
	
	// PI submit new project page elements

			@FindBy(linkText = "Submit New Project")
			WebElement createproject;

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


	
	// Check for project invitation email to investigator by PI
	public void CRe4_138() throws Exception {
		
		try{
			

		GlobalMethods.PI_Login();
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		String studyteammem_name = r1.getCell(2, 119).getContents();
		String studyteammem_email = r1.getCell(3, 119).getContents();
		String studyteammem_role = r1.getCell(4, 119).getContents();
		
		
		//project submission//
		
		String Project_Type = r1.getCell(6, 119).getContents();
	    String Review_Type_fullboard = r1.getCell(7, 119).getContents();
		String Project_Full_Title = r1.getCell(8, 119).getContents();
		String Project_Short_Title = r1.getCell(9, 119).getContents();
		String Sponsor = r1.getCell(10, 119).getContents();

		String Document_Title_in_list = r1.getCell(11, 119).getContents();
		String Version_in_list = r1.getCell(12, 119).getContents();
		String Document_Date_in_list = r1.getCell(13, 119).getContents();
		String doc_upload = r1.getCell(14, 119).getContents();
		

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


		// submitting full board project to admin

		
		WebElement save_as_draft =GWait.Wait_GetElementById("nextid");
		save_as_draft.click();

		
		
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

		GlobalMethods.InvestigatorMail("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Ftab%3Dwm&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin", "qualeetee113@gmail.com","qa123456");

		
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
		
		sheet.getRow(111).createCell(4).setCellValue("Pass");
		sheet.getRow(111).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(111).createCell(4).setCellValue("Fail");
			sheet.getRow(111).getCell(4).setCellStyle(style);
			
			sheet.getRow(111).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(111).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

}
