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
import org.openqa.selenium.NoAlertPresentException;
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
 * Check for study team member list actions delegate/remove PI access
 */
public class TS_126 {

	public TS_126() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "//span[2]/a")
	WebElement remove_pi_access;

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

	@FindBy(linkText = "Submit New Project")
	WebElement createproject;

	@FindBy(linkText = "Projects")
	WebElement MS_project_menu;

	@FindBy(linkText = "Archived Projects")
	WebElement PI_archived_menu;

	@FindBy(xpath = ".//*[@id='projectsummary']/div/div[1]/div[1]/div/div/button")
	public WebElement projtypdrop;

	@FindBy(xpath = "html/body/div[5]/div[1]/div[3]/div[4]/div[1]/form/div/div[1]/div[1]/div/div/div/ul/li")
	public static List<WebElement> projtypvalue;

	// review type selection element

	@FindBy(xpath = "//*[@id='projectsummary']/div/div[2]/div[1]/div/div/button")
	public WebElement revtypdrop;
	@FindBy(xpath = "//div[1]/form/div/div[2]/div[1]/div/div/div/ul/li")
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
	@FindBy(id = "nextidedit")
	WebElement next_editbutton;

	@FindBy(linkText = "Health Care Institute")
	WebElement Login_institute;

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

	@FindBy(xpath = "//span[3]/a")
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

	// login elements
	@FindBy(id = "register_email")
	WebElement email;

	@FindBy(id = "register_password")
	WebElement pwd;

	@FindBy(id = "password")
	WebElement stdpwd;

	@FindBy(id = "register_role")
	WebElement rol;

	@FindBy(id = "login_institute")
	WebElement login;

	@FindBy(css = "span.fa.fa-edit")
	WebElement query_tab_edit;

	@FindBy(id = "nextid")
	WebElement next_button;

	@FindBy(id = "submitid")
	WebElement submit_to_IEC;

	@FindBy(xpath = "//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[2]")
	WebElement no;

	@FindBy(xpath = "//*[@id='submit_for_iec_review_confirm']")
	WebElement conflictsubmit;

	// Check for delegate/remove pi access
	public void CRe4_581_582_583_584_585_587_589_590() throws Exception {
		
		try{

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");
		Sheet r2 = wb.getSheet("Institute_Logins");
		
		String PI_Institute = r2.getCell(0, 2).getContents();
		// Sheet r3 = wb.getSheet("Project Submissions");

		String studyteammem_name = r1.getCell(2, 119).getContents();
		String studyteammem_email = r1.getCell(3, 119).getContents();
		String studyteammem_role = r1.getCell(4, 119).getContents();
		String studyteammem_pwd = r1.getCell(4, 119).getContents();
		

		

		// String studyteammem_email = r1.getCell(0, 90).getContents();
		// String role_value_1 = r1.getCell(3, 90).getContents();

		// Project summary data

		String Project_Type = r1.getCell(10, 117).getContents();
		String Review_Type = r1.getCell(11, 117).getContents();
		String Project_Full_Title = r1.getCell(12, 117).getContents();
		String Project_Short_Title = r1.getCell(13, 117).getContents();
		String Sponsor = r1.getCell(14, 117).getContents();

		String Document_Title_in_list = r1.getCell(15, 117).getContents();
		String Version_in_list = r1.getCell(16, 117).getContents();
		String Document_Date_in_list = r1.getCell(17, 117).getContents();
		String doc_upload = r1.getCell(18, 117).getContents();

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
				Thread.sleep(1000);
				doc_title.sendKeys(Document_Title_in_list);
				doc_version.sendKeys(Version_in_list);
				doc_date.sendKeys(Document_Date_in_list);
				Thread.sleep(1000);
				upload_doc.sendKeys(doc_upload);
				Thread.sleep(8000);

				save_button2.click();
				Thread.sleep(4000);

			}

		}

		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		Thread.sleep(10000);

		WebElement next_button = GWait.Wait_GetElementById("nextid");
		next_button.click();

		WebElement next_button1 = GWait.Wait_GetElementById("nextid");
		next_button1.click();

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();

		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();
		
		//Invite existing investigator

		GlobalMethods.PI_Login();

		WebElement PI_project_menu = GWait.Wait_GetElementByLinkText("My Projects");

		PI_project_menu.click();

		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");

		overview.click();
		
		

		/*WebElement studyteammember = GWait.Wait_GetElementByLinkText("Study Team Member");

		studyteammember.click();

		WebElement studyteammember_name =GWait.Wait_GetElementById("study_member_name");
		studyteammember_name.sendKeys(studyteammem_name);
		Thread.sleep(2000);
		for (WebElement s : studyteammember_selectname) {
			s.click();

			break;
		}
		Thread.sleep(2000);
		String fieldemail = studyteammember_email.getAttribute("value");

		
		WebElement studyteammember_role =GWait.Wait_GetElementByXpath("//*[@id='forward_submission']/div/div[1]/div[3]/div/select");
		Select select = new Select(studyteammember_role);
		select.selectByVisibleText(studyteammem_role);

		WebElement studyteammember_authorize = GWait.Wait_GetElementById("savedoc");
		studyteammember_authorize.click();*/
		
		
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
		
		Assert.assertEquals(studyteammember_name_inlist.getText(),studyteammem_name);
		
		Assert.assertEquals(studyteammember_email_inlist.getText(),studyteammem_email);
	
		Assert.assertEquals(studyteammember_role_inlist.getText(),studyteammem_role);
		
        Assert.assertEquals(delegate.getText(),"Delegate PI Access");
		
		Assert.assertEquals(status.getText(),"De-activate");

	
		/*String delegate_1 = delegate.getText();
		System.out.println(delegate_1);

		String status_1 = status.getText();
		System.out.println(status_1);*/

		//delegate pi access
		
		WebElement delegate =GWait.Wait_GetElementByXpath("//span[2]/a");

		delegate.click();

		String PI_Password = r1.getCell(33, 103).getContents();
		String remove_access = r1.getCell(19, 117).getContents();

		Thread.sleep(2000);
		
		WebElement stdpwd =GWait.Wait_GetElementById("password");
		stdpwd.sendKeys(PI_Password);
		
		
		WebElement ok =GWait.Wait_GetElementByXpath("//div[@id='deactivatingStudyTeamMmeber']/div[2]/div/div[2]/button");
		ok.click();
		
		Thread.sleep(1000);
		//Assert.assertEquals(delegate.getText(),remove_access);
        System.out.println("Investigator action status: "+ delegate.getText());
        Thread.sleep(5000);	
		WebElement PI_project_menu1 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu1.click();

		WebElement logoutt1 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt1.click();

		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();

		//login as investigator
		
		WebElement institute = GWait.Wait_GetElementByLinkText(PI_Institute);
		institute.click();
		
	
		WebElement email =GWait.Wait_GetElementById("register_email");
		email.sendKeys(studyteammem_email);
		
		
		WebElement pwd =GWait.Wait_GetElementById("register_password");
		
		pwd.sendKeys(studyteammem_pwd);

		Select dropdown = new Select(rol);
		dropdown.selectByValue("2");
		
		
		WebElement login =GWait.Wait_GetElementById("login_institute");
		login.click();

		WebElement PI_project_menu2 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu2.click();

		
		
		WebElement query_tab_edit =GWait.Wait_GetElementByCSS("span.fa.fa-edit");

		query_tab_edit.click();
		
		
		WebElement next_editbutton =GWait.Wait_GetElementById("nextidedit");
		next_editbutton.click();
		
		
		WebElement submit_to_IEC =GWait.Wait_GetElementById("submitid");

		submit_to_IEC.click();
		
		
		WebElement no =GWait.Wait_GetElementByXpath("//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[2]");
		no.click();
		
		
		WebElement conflictsubmit= GWait.Wait_GetElementByXpath("//*[@id='submit_for_iec_review_confirm']");
		conflictsubmit.click();
		Thread.sleep(3000);
		GlobalMethods.alertaccept();

		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();

		WebElement logo2 = GWait.Wait_GetElementByCSS("img");
		logo2.click();

		
		//login as pi and remove pi access
		
		GlobalMethods.PI_Login();
		
		WebElement PI_project_menu3 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu3.click();
		
		WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview1.click();
		
		WebElement studyteammember1 =GWait.Wait_GetElementByLinkText("Study Team Member");
		studyteammember1.click();
		
		
		WebElement remove_pi_access =GWait.Wait_GetElementByXpath("//span[2]/a");
		remove_pi_access.click();
		
		WebElement stdpwd1 =GWait.Wait_GetElementById("password");
		stdpwd1.sendKeys(PI_Password);
		System.out.println(PI_Password);
		
		WebElement ok1 =GWait.Wait_GetElementByXpath("//div[@id='deactivatingStudyTeamMmeber']/div[2]/div/div[2]/button");
		ok1.click();
		
		WebElement logoutt3 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt3.click();

		WebElement logo3 = GWait.Wait_GetElementByCSS("img");
		logo3.click();
		
		//login as investigator

		WebElement institute1 = GWait.Wait_GetElementByLinkText(PI_Institute);
		institute1.click();
		
		WebElement email1 =GWait.Wait_GetElementById("register_email");
		email1.sendKeys(studyteammem_email);
		
		WebElement pwd1 =GWait.Wait_GetElementById("register_password");
		pwd1.sendKeys(studyteammem_pwd);
		
		Select dropdown1 = new Select(rol);
		dropdown1.selectByValue("2");
		
		WebElement login1 =GWait.Wait_GetElementById("login_institute");
		login1.click();

		WebElement PI_project_menu4 = GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu4.click();
		
		Thread.sleep(1000);
		WebElement i = GlobalMethods.driver.findElement(By.cssSelector("td.word-wrap"));
		
		if (i.isDisplayed()) {
			String projectname = GlobalMethods.driver.findElement(By.cssSelector("td.word-wrap")).getText();
            System.out.println(projectname);
		} else {
			System.out.println("Project doesnot exist");
		}

		
	
		WebElement logoutt4 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt4.click();

		WebElement logo4 = GWait.Wait_GetElementByCSS("img");
		logo4.click();

		
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
		
		sheet.getRow(123).createCell(4).setCellValue("Pass");
		sheet.getRow(123).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(123).createCell(4).setCellValue("Fail");
			sheet.getRow(123).getCell(4).setCellStyle(style);
			
			sheet.getRow(123).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(123).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

}
