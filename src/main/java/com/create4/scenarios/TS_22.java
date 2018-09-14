package com.create4.scenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.openqa.selenium.By;
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

//Check for Add Ethic Committee with valid/Invalid data/Active/Inactive
public class TS_22 {

	public TS_22() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[4]/a")
	WebElement manageiec;

	@FindBy(linkText = "Manage Ethics Committee")
	WebElement manage_ethic_committee;

	@FindBy(css = "div.bgand-border > h3")
	WebElement ethic_heading;

	@FindBy(linkText = "Add Ethics Committee")
	WebElement ethic_comm_add;

	@FindBy(xpath = "//span/a")
	WebElement logoutt;

	@FindBy(css = "img")
	WebElement logo;

	// add ethic committee form field elements

	@FindBy(xpath = "//form[@id='ethic_committee_submission']/div/div/label")
	WebElement title;

	@FindBy(xpath = "//form[@id='ethic_committee_submission']/div/div[2]/label")
	WebElement description;

	@FindBy(xpath = "//form[@id='ethic_committee_submission']/div/div[3]/label")
	WebElement type_of_commitee;

	@FindBy(xpath = "//form[@id='ethic_committee_submission']/div/div[4]/label")
	WebElement other_info;

	@FindBy(xpath = "//form[@id='ethic_committee_submission']/div/div[5]/label")
	WebElement date;

	@FindBy(xpath = "//form[@id='ethic_committee_submission']/div/div[6]/label")
	WebElement chairperson;

	@FindBy(xpath = "//form[@id='ethic_committee_submission']/div/div[7]/label")
	WebElement member_secretary;

	@FindBy(xpath = "//form[@id='ethic_committee_submission']/div/div[8]/label")
	WebElement member;

	// form[@id='ethic_committee_submission']/div/div[8]/label

	@FindBy(id = "save_ethic_committee_details")
	WebElement submit;

	@FindBy(xpath = "//form[@id='ethic_committee_submission']/div/div/div/p")
	WebElement alert_1;

	@FindBy(xpath = "//form[@id='ethic_committee_submission']/div/div[3]/div/p")
	WebElement alert_2;

	@FindBy(xpath = "//form[@id='ethic_committee_submission']/div/div[6]/div/p")
	WebElement alert_3;

	@FindBy(xpath = "//form[@id='ethic_committee_submission']/div/div[7]/div/p")
	WebElement alert_4;

	@FindBy(xpath = "//form[@id='ethic_committee_submission']/div/div[8]/div[2]/div/p")
	WebElement alert_5;

	@FindBy(id = "save_ethic_committee_details")
	WebElement submit_ethic_comm;

	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[4]/ul/li[7]/a")
	WebElement manage_iec_comm;

	@FindBy(xpath = "html/body/div[4]/div[1]/div/div[1]/div/li/div/ul/li[2]/div/a")
	WebElement add_iec_member;

	@FindBy(id = "add_iec_member_first_name")
	WebElement add_iec_firstname;

	@FindBy(id = "add_iec_member_last_name")
	WebElement add_iec_lastname;

	@FindBy(id = "add_iec_member_date_of_birth")
	WebElement add_iec_dob;

	@FindBy(id = "add_iec_member_email")
	WebElement add_iec_mail;

	@FindBy(id = "add_iec_member_details")
	WebElement add_iec_button;

	@FindBy(id = "ethic_committee_title")
	WebElement add_ethic_title;

	@FindBy(id = "ethic_committee_description")
	WebElement add_ethic_desc;

	@FindBy(id = "ethic_committee_type_select")
	WebElement add_ethic_comm;

	@FindBy(id = "ethic_committee_info")
	WebElement add_ethic_info;

	@FindBy(id = "ethic_committee_date")
	WebElement add_ethic_date;

	@FindBy(id = "ethic_committee_chair_person")
	WebElement add_ethic_cp;

	@FindBy(id = "ethic_committee_member_secretary")
	WebElement add_ethic_ms;

	@FindBy(id = "save_ethic_committee_details")
	WebElement add_ethic_button;

	@FindBy(css = ".col-sm-9.ms-right-scroll.margin-left-none")
	WebElement add_mem_check;

	@FindBy(xpath = "//th[3]/a/span[2]")
	WebElement name_list;

	@FindBy(xpath = "//th[4]/a/span[2]")
	WebElement type_list;

	@FindBy(xpath = "//th[5]/span")
	WebElement ms_list;

	@FindBy(xpath = "//th[6]/span")
	WebElement cp_list;

	@FindBy(xpath = "//th[7]/a/span[2]")
	WebElement status_list;

	@FindBy(xpath = "//th[8]/span")
	WebElement action_list;

	@FindBy(css = "span.fa.fa-check")
	WebElement active;

	@FindBy(css = "span.fa.fa-remove")
	WebElement deactive;

	@FindBy(xpath = "//html/body/div[2]/div/div[3]/div/ul/li[1]/a")
	WebElement First_Institute;

	@FindBy(xpath = "html/body/div[2]/div/div[3]/div/ul/li[2]/a")
	WebElement Second_Institute;

	// Principal investigator registration elements

	@FindBy(id = "firstname")
	WebElement register_firstname;

	@FindBy(id = "middlename")
	WebElement register_middlename;

	@FindBy(id = "lastname")
	WebElement register_lastname;

	@FindBy(name = "emp_id")
	WebElement register_emp_id;

	@FindBy(id = "dobs")
	WebElement register_dobs;

	@FindBy(id = "phno")
	WebElement register_phno;

	@FindBy(id = "email")
	WebElement register_email;

	@FindBy(id = "photos")
	WebElement register_photos;

	@FindBy(id = "dept")
	WebElement register_dept;

	@FindBy(id = "departmenttext")
	WebElement register_depttext;

	@FindBy(id = "designation")
	WebElement register_designation;

	@FindBy(id = "mrvalids")
	WebElement register_mrvalids;

	@FindBy(xpath = "//form[@id='registerform']/div[3]/div[2]/div[2]/span/input")
	WebElement register_mrdocs;

	@FindBy(xpath = "//div[@id='resumevalidreg']/input")
	WebElement register_resumevalid;

	@FindBy(id = "resume")
	WebElement register_resume;

	@FindBy(id = "field_terms")
	WebElement register_field_terms;

	@FindBy(id = "registration_submit")
	WebElement register_submit;

	@FindBy(linkText = "Home")
	WebElement Home_Link;

	@FindBy(linkText = "Register")
	WebElement register_institute;

	@FindBy(css = "Re")
	WebElement login_institute;

	// Check for 'Ethics Committee Requests List' tabular fields
	public void CRe4_1064_65() throws Exception {
		
		try{

		GlobalMethods.Admin_Login();
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("ManageIEC");

		String ethicheading = r1.getCell(2, 154).getContents();
		String ethiccommadd = r1.getCell(3, 154).getContents();

		String ethiccommadd_title = r1.getCell(4, 154).getContents();
		String ethiccommadd_descrp = r1.getCell(5, 154).getContents();
		String ethiccommadd_typecomm = r1.getCell(6, 154).getContents();
		String ethiccommadd_other = r1.getCell(7, 154).getContents();
		String ethiccommadd_date = r1.getCell(8, 154).getContents();
		String ethiccommadd_chairperson = r1.getCell(9, 154).getContents();
		String ethiccommadd_ms = r1.getCell(10, 154).getContents();
		String ethiccommadd_mem = r1.getCell(11, 154).getContents();
		String ethiccommadd_submit = r1.getCell(12, 154).getContents();

		WebElement Manage_IEC = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC.click();
		WebElement manage_ethic_committee = GWait.Wait_GetElementByLinkText("Manage Ethics Committee");
		manage_ethic_committee.click();

		WebElement ethic_heading = GWait.Wait_GetElementByCSS("div.bgand-border > h3");
		String ethic_heading_1 = ethic_heading.getText();
		ethicheading.equalsIgnoreCase(ethic_heading_1);
		System.out.println(ethic_heading_1);

		String ethic_com_add_1 = ethic_comm_add.getText();
		ethiccommadd.equalsIgnoreCase(ethic_com_add_1);
		System.out.println(ethic_com_add_1);
		WebElement ethic_comm_add = GWait.Wait_GetElementByLinkText("Add Ethics Committee");
		ethic_comm_add.click();
		WebElement title = GWait.Wait_GetElementByXpath("//form[@id='ethic_committee_submission']/div/div/label");
		String title_1 = title.getText();
		ethiccommadd_title.equalsIgnoreCase(title_1);
		System.out.println(title_1);

		String description_1 = description.getText();
		ethiccommadd_descrp.equalsIgnoreCase(description_1);
		System.out.println(description_1);

		String type_of_commitee_1 = type_of_commitee.getText();
		ethiccommadd_typecomm.equalsIgnoreCase(type_of_commitee_1);
		System.out.println(type_of_commitee_1);

		String other_info_1 = other_info.getText();
		ethiccommadd_other.equalsIgnoreCase(other_info_1);
		System.out.println(other_info_1);

		String date_1 = date.getText();
		ethiccommadd_date.equalsIgnoreCase(date_1);
		System.out.println(date_1);

		String chaiperson_1 = chairperson.getText();
		ethiccommadd_chairperson.equalsIgnoreCase(chaiperson_1);
		System.out.println(chaiperson_1);

		String member_secretary_1 = member_secretary.getText();
		ethiccommadd_ms.equalsIgnoreCase(member_secretary_1);
		System.out.println(member_secretary_1);

		String member_1 = member.getText();
		ethiccommadd_mem.equalsIgnoreCase(member_1);
		System.out.println(member_1);

		String submit_1 = submit.getAttribute("value");
		ethiccommadd_submit.equalsIgnoreCase(submit_1);
		System.out.println(submit_1);
		WebElement logoutBTN = GWait.Wait_GetElementByCSS(".logout");
		logoutBTN.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(166).createCell(4).setCellValue("Pass");
		sheet.getRow(166).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(166).createCell(4).setCellValue("Fail");
			sheet.getRow(166).getCell(4).setCellStyle(style);
			
			sheet.getRow(166).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(166).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
	}

	// Check for mandatory fields in the add ethic committee form
	public void CRe4_1066_1067() throws Exception {
		
		try{

		GlobalMethods.Admin_Login();
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("ManageIEC");

		String name_alert = r1.getCell(2, 156).getContents();
		String type_of_comm_alert = r1.getCell(3, 156).getContents();
		String cp_alert = r1.getCell(4, 156).getContents();
		String ms_alert = r1.getCell(5, 156).getContents();
		String iec_mem_alert = r1.getCell(6, 156).getContents();

		WebElement Manage_IEC = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC.click();
		WebElement manage_ethic_committee = GWait.Wait_GetElementByLinkText("Manage Ethics Committee");
		manage_ethic_committee.click();

		WebElement ethic_comm_add = GWait.Wait_GetElementByLinkText("Add Ethics Committee");
		ethic_comm_add.click();
		WebElement submit_ethic_comm = GWait.Wait_GetElementById("save_ethic_committee_details");
		submit_ethic_comm.click();

		String alert1 = alert_1.getText();
		name_alert.equalsIgnoreCase(alert1);
		System.out.println(alert1);

		String alert2 = alert_2.getText();
		type_of_comm_alert.equalsIgnoreCase(alert2);
		System.out.println(alert2);

		String alert3 = alert_3.getText();
		cp_alert.equalsIgnoreCase(alert3);
		System.out.println(alert3);

		String alert4 = alert_4.getText();
		ms_alert.equalsIgnoreCase(alert4);
		System.out.println(alert4);

		String alert5 = alert_5.getText();
		iec_mem_alert.equalsIgnoreCase(alert5);
		System.out.println(alert5);

		WebElement logoutBTN = GWait.Wait_GetElementByCSS(".logout");
		logoutBTN.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(167).createCell(4).setCellValue("Pass");
		sheet.getRow(167).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(167).createCell(4).setCellValue("Fail");
			sheet.getRow(167).getCell(4).setCellStyle(style);
			
			sheet.getRow(167).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(167).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	@FindBy(xpath = "//div[3]/div[1]/form/div[1]/div[8]/div/div")
	List<WebElement> selectIECMem;

	@FindBy(id = "add_iec_member_emp_id")
	WebElement emp_id;

	@FindBy(id = "add_iec_member_contact_number")
	WebElement add_iec_contact_number;

	// Check for add ethic committee with only one member
	public void CRe4_1070_71_1085_80_to_85() throws Exception {
		
		try{

		GlobalMethods.Admin_Login();

		WebElement Manage_IEC = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC.click();
		WebElement manage_iec_comm = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[7]/a");
		manage_iec_comm.click();

		// creating ten members
		for (int i = 2; i <= 25;) {

			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);

			Sheet r1 = wb.getSheet("ManageIEC");

			String frstname = r1.getCell(i, 158).getContents();
			String lstname = r1.getCell(i + 1, 158).getContents();
			String dob = r1.getCell(i + 2, 158).getContents();
			String email = r1.getCell(i + 3, 158).getContents();
			String emp = r1.getCell(i + 4, 158).getContents();
			String ph = r1.getCell(i + 5, 158).getContents();

			WebElement add_iec_member = GWait
					.Wait_GetElementByXpath("html/body/div[4]/div[1]/div/div[1]/div/li/div/ul/li[2]/div/a");
			add_iec_member.click();

			add_iec_firstname.sendKeys(frstname);
			add_iec_lastname.sendKeys(lstname);
			add_iec_dob.sendKeys(dob);
			add_iec_mail.sendKeys(email);
			emp_id.sendKeys(emp);
			add_iec_contact_number.sendKeys(ph);
			WebElement add_iec_button = GWait.Wait_GetElementById("add_iec_member_details");
			add_iec_button.click();
			i = i + 6;

		}

		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();
		WebElement manage_ethic_committee = GWait.Wait_GetElementByLinkText("Manage Ethics Committee");
		manage_ethic_committee.click();
		WebElement ethic_comm_add = GWait.Wait_GetElementByLinkText("Add Ethics Committee");
		ethic_comm_add.click();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("ManageIEC");

		String frstname_1 = r1.getCell(2, 158).getContents();
		String lstname_1 = r1.getCell(3, 158).getContents();

		String frstname_2 = r1.getCell(8, 158).getContents();
		String lstname_2 = r1.getCell(9, 158).getContents();

		String title = r1.getCell(26, 158).getContents();
		String description = r1.getCell(27, 158).getContents();
		String info = r1.getCell(28, 158).getContents();
		String date = r1.getCell(29, 158).getContents();

		String cp = frstname_1 + " " + lstname_1;
		String ms = frstname_2 + " " + lstname_2;

		add_ethic_title.sendKeys(title);
		add_ethic_desc.sendKeys(description);
		Select dropdown = new Select(add_ethic_comm);
		dropdown.selectByValue("1");
		add_ethic_info.sendKeys(info);
		add_ethic_date.sendKeys(date);
		// Select dropdown = new Select(add_ethic_info);
		// dropdown.selectByValue("1090");
		Select select1 = new Select(add_ethic_cp);
		select1.selectByVisibleText(cp);

		Select select2 = new Select(add_ethic_ms);
		select2.selectByVisibleText(ms);

		for (int j = 14; j <= 21;) {

			String frstname1 = r1.getCell(j, 158).getContents();
			System.out.println(frstname1);
			String lstname1 = r1.getCell(j + 1, 158).getContents();
			System.out.println(lstname1);
			String FullName = frstname1 + " " + lstname1;
			System.out.println("Test Name :" + FullName);
			List<WebElement> elementsList = selectIECMem;
			for (WebElement a : elementsList) {
				System.out.println(a.getText());

				if (a.getText().equalsIgnoreCase(FullName)) {
					System.out.println("@#@# " + a.getText().equalsIgnoreCase(FullName));
					WebElement checkBox = a.findElement(By.tagName("input"));
					checkBox.click();
					break;
				}

			}
			j = j + 6;
		}

		WebElement add_ethic_button = GWait.Wait_GetElementById("save_ethic_committee_details");
		add_ethic_button.click();
		WebElement logoutBTN = GWait.Wait_GetElementByCSS(".logout");
		logoutBTN.click();
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(168).createCell(4).setCellValue("Pass");
		sheet.getRow(168).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(168).createCell(4).setCellValue("Fail");
			sheet.getRow(168).getCell(4).setCellStyle(style);
			
			sheet.getRow(168).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(168).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// Check for add ethic committee by selecting PI of same institute as MS
	public void CRe4_1077() throws Exception {
		
		try{

		GlobalMethods.Admin_Login();
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("ManageIEC");

		String ethicheading = r1.getCell(2, 160).getContents();
		String ethiccommadd = r1.getCell(3, 160).getContents();

		String ethiccommadd_title = r1.getCell(4, 160).getContents();
		String ethiccommadd_descrp = r1.getCell(5, 160).getContents();
		String ethiccommadd_typecomm = r1.getCell(6, 160).getContents();
		String ethiccommadd_other = r1.getCell(7, 160).getContents();
		String ethiccommadd_date = r1.getCell(8, 160).getContents();
		String ethiccommadd_chairperson = r1.getCell(9, 160).getContents();
		String ethiccommadd_ms = r1.getCell(10, 160).getContents();
		String ethiccommadd_mem = r1.getCell(11, 160).getContents();
		String ethiccommadd_submit = r1.getCell(12, 160).getContents();

		WebElement Manage_IEC = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC.click();
		WebElement manage_ethic_committee = GWait.Wait_GetElementByLinkText("Manage Ethics Committee");
		manage_ethic_committee.click();

		String ethic_heading_1 = ethic_heading.getText();
		ethicheading.equalsIgnoreCase(ethic_heading_1);
		System.out.println(ethic_heading_1);

		String ethic_com_add_1 = ethic_comm_add.getText();
		ethiccommadd.equalsIgnoreCase(ethic_com_add_1);
		System.out.println(ethic_com_add_1);
		WebElement ethic_comm_add = GWait.Wait_GetElementByLinkText("Add Ethics Committee");
		ethic_comm_add.click();
		WebElement title = GWait.Wait_GetElementByXpath("//form[@id='ethic_committee_submission']/div/div/label");
		String title_1 = title.getText();
		ethiccommadd_title.equalsIgnoreCase(title_1);
		System.out.println(title_1);

		String description_1 = description.getText();
		ethiccommadd_descrp.equalsIgnoreCase(description_1);
		System.out.println(description_1);

		String type_of_commitee_1 = type_of_commitee.getText();
		ethiccommadd_typecomm.equalsIgnoreCase(type_of_commitee_1);
		System.out.println(type_of_commitee_1);

		String other_info_1 = other_info.getText();
		ethiccommadd_other.equalsIgnoreCase(other_info_1);
		System.out.println(other_info_1);

		String date_1 = date.getText();
		ethiccommadd_date.equalsIgnoreCase(date_1);
		System.out.println(date_1);

		String chaiperson_1 = chairperson.getText();
		ethiccommadd_chairperson.equalsIgnoreCase(chaiperson_1);
		System.out.println(chaiperson_1);

		String member_secretary_1 = member_secretary.getText();
		ethiccommadd_ms.equalsIgnoreCase(member_secretary_1);
		System.out.println(member_secretary_1);

		String member_1 = member.getText();
		ethiccommadd_mem.equalsIgnoreCase(member_1);
		System.out.println(member_1);

		String submit_1 = submit.getAttribute("value");
		ethiccommadd_submit.equalsIgnoreCase(submit_1);
		System.out.println(submit_1);
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(169).createCell(4).setCellValue("Pass");
		sheet.getRow(169).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(169).createCell(4).setCellValue("Fail");
			sheet.getRow(169).getCell(4).setCellStyle(style);
			
			sheet.getRow(169).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(169).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// Check for add ethic committee by selecting PI of same institute as CP
	public void CRe4_1078() throws Exception {
		
		try{

		
		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb2 = Workbook.getWorkbook(fi1);
		Sheet r2 = wb2.getSheet("Institute_Logins");

		String Inst_tite = r2.getCell(0, 3).getContents();
		WebElement InstituteLink = GWait.Wait_GetElementByLinkText(Inst_tite);
		InstituteLink.click();
		// PI Register data
		WebElement register_institute = GWait.Wait_GetElementByLinkText("Register");
		register_institute.click();

		for (int i = 2; i <= 17;) {
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("ManageIEC");
			String PI_firstname = r1.getCell(i, 162).getContents();
			String PI_middlename = r1.getCell(i + 1, 162).getContents();
			String PI_lastname = r1.getCell(i + 2, 162).getContents();
			String PI_emdpid = r1.getCell(i + 3, 162).getContents();
			String PI_dob = r1.getCell(i + 4, 162).getContents();
			String PI_phnum = r1.getCell(i + 5, 162).getContents();
			String PI_email = r1.getCell(i + 6, 162).getContents();
			String PI_photo = r1.getCell(i + 7, 162).getContents();

			WebElement register_firstname = GWait.Wait_GetElementById("firstname");
			register_firstname.sendKeys(PI_firstname);

			WebElement register_middlename = GWait.Wait_GetElementById("middlename");
			register_middlename.sendKeys(PI_middlename);
			register_lastname.sendKeys(PI_lastname);
			register_emp_id.sendKeys(PI_emdpid);
			register_dobs.sendKeys(PI_dob);
			register_phno.sendKeys(PI_phnum);
			register_email.sendKeys(PI_email);
			register_photos.sendKeys(PI_photo);
			WebElement register_field_terms = GWait.Wait_GetElementById("field_terms");
			register_field_terms.click();
			WebElement register_submit = GWait.Wait_GetElementById("registration_submit");
			register_submit.click();

			i = i + 8;
		}
		
		WebElement Home_Link = GWait.Wait_GetElementByLinkText("Home");
		Home_Link.click();

		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();
		
		GlobalMethods.Admin_Login();

		WebElement manageiec = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		manageiec.click();
		WebElement manage_ethic_committee = GWait.Wait_GetElementByLinkText("Manage Ethics Committee");
		manage_ethic_committee.click();

		// ----ethic_committee same as above created-----//
		WebElement manage_ethic_committee_Edit = GWait
				.Wait_GetElementByXpath("//div[2]/div[4]/table/tbody/tr[1]/td[8]/a[2]/span");
		manage_ethic_committee_Edit.click();

		for (int j = 2; j <= 12;) {
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r = wb.getSheet("ManageIEC");
			
			String frstname1 = r.getCell(j, 162).getContents();
			System.out.println(frstname1);
			String MiddleName = r.getCell(j + 1, 162).getContents();
			System.out.println(MiddleName);
			String lstname1 = r.getCell(j + 2, 162).getContents();
			System.out.println(lstname1);
			String FullName = frstname1+" "+MiddleName+" "+lstname1;
			System.out.println("Test Name :" + FullName);
			List<WebElement> elementsList = selectIECMem;
			for (WebElement a : elementsList) {
				System.out.println(a.getText());

				if (a.getText().equalsIgnoreCase(FullName)) {
					System.out.println("@#@# " + a.getText().equalsIgnoreCase(FullName));
					WebElement checkBox = a.findElement(By.tagName("input"));
					checkBox.click();
					break;
				}

			}
			j = j + 8;
		}

		WebElement add_ethic_button = GWait.Wait_GetElementById("save_ethic_committee_details");
		add_ethic_button.click();
		WebElement logoutBTN = GWait.Wait_GetElementByCSS(".logout");
		logoutBTN.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(170).createCell(4).setCellValue("Pass");
		sheet.getRow(170).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(170).createCell(4).setCellValue("Fail");
			sheet.getRow(170).getCell(4).setCellStyle(style);
			
			sheet.getRow(170).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(170).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// Check for add ethic committee by selecting PI of same institute as Member
	public void CRe4_1079() throws Exception {
		
		try{

		GlobalMethods.Admin_Login();
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("ManageIEC");

		String ethicheading = r1.getCell(2, 164).getContents();
		String ethiccommadd = r1.getCell(3, 164).getContents();

		String ethiccommadd_title = r1.getCell(4, 164).getContents();
		String ethiccommadd_descrp = r1.getCell(5, 164).getContents();
		String ethiccommadd_typecomm = r1.getCell(6, 164).getContents();
		String ethiccommadd_other = r1.getCell(7, 164).getContents();
		String ethiccommadd_date = r1.getCell(8, 164).getContents();
		String ethiccommadd_chairperson = r1.getCell(9, 164).getContents();
		String ethiccommadd_ms = r1.getCell(10, 164).getContents();
		String ethiccommadd_mem = r1.getCell(11, 164).getContents();
		String ethiccommadd_submit = r1.getCell(12, 164).getContents();

		WebElement manageiec = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		manageiec.click();
		WebElement manage_ethic_committee = GWait.Wait_GetElementByLinkText("Manage Ethics Committee");
		manage_ethic_committee.click();
		WebElement ethic_heading = GWait.Wait_GetElementByCSS("div.bgand-border > h3");
		String ethic_heading_1 = ethic_heading.getText();
		ethicheading.equalsIgnoreCase(ethic_heading_1);
		System.out.println(ethic_heading_1);

		String ethic_com_add_1 = ethic_comm_add.getText();
		ethiccommadd.equalsIgnoreCase(ethic_com_add_1);
		System.out.println(ethic_com_add_1);
		WebElement ethic_comm_add = GWait.Wait_GetElementByLinkText("Add Ethics Committee");
		ethic_comm_add.click();

		WebElement title = GWait.Wait_GetElementByXpath("//form[@id='ethic_committee_submission']/div/div/label");
		String title_1 = title.getText();
		ethiccommadd_title.equalsIgnoreCase(title_1);
		System.out.println(title_1);

		String description_1 = description.getText();
		ethiccommadd_descrp.equalsIgnoreCase(description_1);
		System.out.println(description_1);

		String type_of_commitee_1 = type_of_commitee.getText();
		ethiccommadd_typecomm.equalsIgnoreCase(type_of_commitee_1);
		System.out.println(type_of_commitee_1);

		String other_info_1 = other_info.getText();
		ethiccommadd_other.equalsIgnoreCase(other_info_1);
		System.out.println(other_info_1);

		String date_1 = date.getText();
		ethiccommadd_date.equalsIgnoreCase(date_1);
		System.out.println(date_1);

		String chaiperson_1 = chairperson.getText();
		ethiccommadd_chairperson.equalsIgnoreCase(chaiperson_1);
		System.out.println(chaiperson_1);

		String member_secretary_1 = member_secretary.getText();
		ethiccommadd_ms.equalsIgnoreCase(member_secretary_1);
		System.out.println(member_secretary_1);

		String member_1 = member.getText();
		ethiccommadd_mem.equalsIgnoreCase(member_1);
		System.out.println(member_1);

		String submit_1 = submit.getAttribute("value");
		ethiccommadd_submit.equalsIgnoreCase(submit_1);
		System.out.println(submit_1);
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(171).createCell(4).setCellValue("Pass");
		sheet.getRow(171).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(171).createCell(4).setCellValue("Fail");
			sheet.getRow(171).getCell(4).setCellStyle(style);
			
			sheet.getRow(171).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(171).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// Check for add ethic committee by conflict of interest members
	public void CRe4_1080() throws Exception {
		
		try{

		GlobalMethods.Admin_Login();
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("ManageIEC");

		String ethicheading = r1.getCell(2, 166).getContents();
		String ethiccommadd = r1.getCell(3, 166).getContents();

		String ethiccommadd_title = r1.getCell(4, 166).getContents();
		String ethiccommadd_descrp = r1.getCell(5, 166).getContents();
		String ethiccommadd_typecomm = r1.getCell(6, 166).getContents();
		String ethiccommadd_other = r1.getCell(7, 166).getContents();
		String ethiccommadd_date = r1.getCell(8, 166).getContents();
		String ethiccommadd_chairperson = r1.getCell(9, 166).getContents();
		String ethiccommadd_ms = r1.getCell(10, 166).getContents();
		String ethiccommadd_mem = r1.getCell(11, 166).getContents();
		String ethiccommadd_submit = r1.getCell(12, 166).getContents();

		WebElement manageiec = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		manageiec.click();
		WebElement manage_ethic_committee = GWait.Wait_GetElementByLinkText("Manage Ethics Committee");
		manage_ethic_committee.click();
		WebElement ethic_heading = GWait.Wait_GetElementByCSS("div.bgand-border > h3");
		String ethic_heading_1 = ethic_heading.getText();
		ethicheading.equalsIgnoreCase(ethic_heading_1);
		System.out.println(ethic_heading_1);

		String ethic_com_add_1 = ethic_comm_add.getText();
		ethiccommadd.equalsIgnoreCase(ethic_com_add_1);
		System.out.println(ethic_com_add_1);
		WebElement ethic_comm_add = GWait.Wait_GetElementByLinkText("Add Ethics Committee");
		ethic_comm_add.click();
		WebElement title = GWait.Wait_GetElementByXpath("//div[2]/div[3]/div[1]/form/div[1]/div[1]/label");
		String title_1 = title.getText();
		ethiccommadd_title.equalsIgnoreCase(title_1);
		System.out.println(title_1);

		String description_1 = description.getText();
		ethiccommadd_descrp.equalsIgnoreCase(description_1);
		System.out.println(description_1);

		String type_of_commitee_1 = type_of_commitee.getText();
		ethiccommadd_typecomm.equalsIgnoreCase(type_of_commitee_1);
		System.out.println(type_of_commitee_1);

		String other_info_1 = other_info.getText();
		ethiccommadd_other.equalsIgnoreCase(other_info_1);
		System.out.println(other_info_1);

		String date_1 = date.getText();
		ethiccommadd_date.equalsIgnoreCase(date_1);
		System.out.println(date_1);

		String chaiperson_1 = chairperson.getText();
		ethiccommadd_chairperson.equalsIgnoreCase(chaiperson_1);
		System.out.println(chaiperson_1);

		String member_secretary_1 = member_secretary.getText();
		ethiccommadd_ms.equalsIgnoreCase(member_secretary_1);
		System.out.println(member_secretary_1);

		String member_1 = member.getText();
		ethiccommadd_mem.equalsIgnoreCase(member_1);
		System.out.println(member_1);

		String submit_1 = submit.getAttribute("value");
		ethiccommadd_submit.equalsIgnoreCase(submit_1);
		System.out.println(submit_1);
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(172).createCell(4).setCellValue("Pass");
		sheet.getRow(172).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(172).createCell(4).setCellValue("Fail");
			sheet.getRow(172).getCell(4).setCellStyle(style);
			
			sheet.getRow(172).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(172).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// Check for fields of list grid in manage IEC
	public void CRe4_1095_to_1100_1101_1102() throws Exception {
		
		try{

		GlobalMethods.Admin_Login();
		WebElement manageiec = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		manageiec.click();
		WebElement manage_ethic_committee = GWait.Wait_GetElementByLinkText("Manage Ethics Committee");
		manage_ethic_committee.click();

		// Check for Table Header
		// GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>thead"));
		WebElement table_element = GWait.Wait_GetElementByCSS(".table.table-striped>thead");
		ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//th"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
			}
		}

		// Check for Table Data name Test cases 1096
		WebElement table_element1 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[3]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
			}
			break;
		}

		// Check for Table Data Type Test cases 1097
		WebElement table_element2 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows2 = (ArrayList<WebElement>) table_element2.findElements(By.tagName("tr"));
		for (WebElement row : rows2) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[4]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
			}
			break;
		}

		// Check for Table Data MS Test cases 1098
		WebElement table_element3 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows3 = (ArrayList<WebElement>) table_element3.findElements(By.tagName("tr"));
		for (WebElement row : rows3) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[5]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
			}
			break;
		}

		// Check for Table Data Chairperson Test cases 1099
		WebElement table_element4 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows4 = (ArrayList<WebElement>) table_element4.findElements(By.tagName("tr"));
		for (WebElement row : rows4) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
			}
			break;
		}

		// Check for Table Data Status Test cases 1100,1101,1102,1103
		WebElement table_element5 = GWait.Wait_GetElementByCSS(".table.table-striped>tbody");
		ArrayList<WebElement> rows5 = (ArrayList<WebElement>) table_element5.findElements(By.tagName("tr"));
		for (WebElement row : rows5) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[7]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
			}
			break;
		}

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(173).createCell(4).setCellValue("Pass");
		sheet.getRow(173).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(173).createCell(4).setCellValue("Fail");
			sheet.getRow(173).getCell(4).setCellStyle(style);
			
			sheet.getRow(173).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(173).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

}
