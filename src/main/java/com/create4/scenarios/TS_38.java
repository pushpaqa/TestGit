package com.create4.scenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.global.methods.GlobalWait;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.global.methods.GlobalMethods;

import jxl.Sheet;
import jxl.Workbook;

/*
 * Check for PI invited study team members in View invitees requests(Actions)
 */

public class TS_38 {

	public TS_38() {
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

	// login elements
	@FindBy(id = "register_email")
	WebElement email;

	@FindBy(id = "register_password")
	WebElement pwd;

	@FindBy(id = "register_role")
	WebElement rol;

	@FindBy(id = "login_institute")
	WebElement login;

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

	// Check for 'View invite requests'
	public void CRe4_1178_1180_1181_1182_1183_1184_1185() throws Exception {
		
		try{

		GlobalMethods.PI_Login();
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		String studyteammem_name = r1.getCell(2, 105).getContents();
		String studyteammem_role = r1.getCell(3, 105).getContents();
		
		String studyteammem_email = r1.getCell(4, 105).getContents();
		String role_value_1 = r1.getCell(3, 105).getContents();

		String Invitee = r1.getCell(5, 105).getContents();
		String name_1 = r1.getCell(6, 105).getContents();
		String email_1 = r1.getCell(7, 105).getContents();
		String proj_title_1 = r1.getCell(8, 105).getContents();
		String role_1 = r1.getCell(9, 105).getContents();
		String invited_1 = r1.getCell(10, 105).getContents();
		String permisions_1 = r1.getCell(11, 105).getContents();
		String approved_1 = r1.getCell(12, 105).getContents();

		

		
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

		Select select = new Select(studyteammember_role);
		select.selectByVisibleText(role_value_1);
		
		
		WebElement studyteammember_authorize = GWait.Wait_GetElementById("savedoc");
		studyteammember_authorize.click();
		

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();

		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();

		GlobalMethods.Admin_Login();

		
		WebElement admin_manage_users = GWait.Wait_GetElementByLinkText("Manage Users");

		admin_manage_users.click();

		
		WebElement view_invitee_requests = GWait.Wait_GetElementByLinkText("View Invitee Requests");

		view_invitee_requests.click();
		Thread.sleep(4000);

		
		Assert.assertEquals(view_text1.getText().trim(), Invitee);
		System.out.println(view_text1.getText());
		
		Assert.assertEquals(view_text2.getText().trim(), name_1);
		System.out.println(view_text2.getText());
		
		Assert.assertEquals(view_text3.getText().trim(), email_1);
		System.out.println(view_text3.getText());

		Assert.assertEquals(view_text4.getText().trim(), proj_title_1);
		System.out.println(view_text4.getText());

		Assert.assertEquals(view_text5.getText().trim(), role_1);
		System.out.println(view_text5.getText());
		
		Assert.assertEquals(view_text6.getText().trim(), invited_1);
		System.out.println(view_text6.getText());
	
		Assert.assertEquals(view_text7.getText().trim(), permisions_1);
		System.out.println(view_text7.getText());

		Assert.assertEquals(view_table_1.getText().trim(), studyteammem_email);
		System.out.println(view_table_1.getText());
		
		Assert.assertEquals(view_table_3.getText().trim(), role_value_1);
		System.out.println(view_table_3.getText());

		Assert.assertEquals(view_table_4.getText().trim(), approved_1);
		System.out.println(view_table_4.getText());

		

		WebElement logoutt1 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt1.click();

		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();
		
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
		
		sheet.getRow(120).createCell(4).setCellValue("Pass");
		sheet.getRow(120).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(120).createCell(4).setCellValue("Fail");
			sheet.getRow(120).getCell(4).setCellStyle(style);
			
			sheet.getRow(120).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(120).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}


}
