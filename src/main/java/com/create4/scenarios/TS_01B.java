package com.create4.scenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

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
 * Check for Admin creation with valid/Invalid data(After creation should display in the Manage admin list)
 */

public class TS_01B {

	public TS_01B() {
		
		PageFactory.initElements(GlobalMethods.driver, this);
	}
	
	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);


	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[2]/a")
	WebElement Manage_Items;

	@FindBy(linkText = "Manage Institute Admins")
	WebElement Manage_Inst_admin;

	@FindBy(linkText = "Add IEC Admin")
	WebElement add_inst_admin;

	@FindBy(css = "h3")
	WebElement page_heading;

	@FindBy(css = ".logout")
	WebElement logoutt;

	@FindBy(css = "img")
	WebElement logo;

	// Admin form section headings elements

	@FindBy(css = "h3.main-ouside")
	WebElement Section_heading_1_basic;

	@FindBy(xpath = "//form[@id='addiecadmin']/div[2]/div/h3")
	WebElement Section_heading_2_Professional;

	@FindBy(xpath = "//form[@id='addiecadmincertificate']/div/h3")
	WebElement Section_heading_3_Certifications;

	// --Admin form fields page elements

	@FindBy(xpath = "//form[@id='addiecadmin']/div/div/div/div/label")
	WebElement Field_Institute;

	@FindBy(xpath = "//form[@id='addiecadmin']/div/div/div[2]/div/label")
	WebElement Field_First_Name;

	@FindBy(xpath = "//form[@id='addiecadmin']/div/div/div[3]/div/label")
	WebElement Field_Middle_Name;

	@FindBy(xpath = "//form[@id='addiecadmin']/div/div/div[4]/div/label")
	WebElement Field_Last_Name;

	@FindBy(xpath = "//form[@id='addiecadmin']/div/div/div[5]/div/label")
	WebElement Field_DOB;

	@FindBy(xpath = "//div[1]/div/div[2]/form/div[1]/div/div[6]/div/label")
	WebElement Field_Email;

	@FindBy(xpath = "//form[@id='addiecadmin']/div/div/div[7]/div/label")
	WebElement Field_Cntct_num;

	@FindBy(id = "add_iec_admin_photo")
	WebElement Field_Photo;

	@FindBy(xpath = "//form[@id='addiecadmin']/div[2]/div/div/div/label")
	WebElement Field_Department;

	@FindBy(xpath = "//form[@id='addiecadmin']/div[2]/div/div[2]/div/label")
	WebElement Field_Designation;

	@FindBy(xpath = "//form[@id='addiecadmin']/div[2]/div/div[3]/div/label")
	WebElement Field_Qual;

	@FindBy(xpath = "//form[@id='addiecadmin']/div[2]/div/div[4]/div/label")
	WebElement Field_MCR;

	@FindBy(id = "add_iec_admin_appointment_letter")
	WebElement Field_Appoint_Ltr;

	@FindBy(id = "add_iec_admin_curriculum_vitae")
	WebElement Field_CV;

	@FindBy(id = "add_iec_admin_conflict_of_interest")
	WebElement Field_COI;

	@FindBy(id = "add_iec_admin_professional_achievement")
	WebElement Field_prof_achvmnt;

	@FindBy(id = "add_iec_admin_invitation_letter")
	WebElement Field_Invt_Ltr;

	@FindBy(id = "add_iec_admin_acceptance_letter")
	WebElement Field_Acptn_Ltr;

	@FindBy(xpath = "//form[@id='addiecadmincertificate']/div/div/div/label")
	WebElement Field_Certification;

	@FindBy(xpath = "//form[@id='addiecadmincertificate']/div/div[2]/div/label")
	WebElement Field_Title;

	@FindBy(xpath = "//form[@id='addiecadmincertificate']/div/div[3]/div/label")
	WebElement Field_DOT;

	@FindBy(xpath = "//form[@id='addiecadmincertificate']/div/div[4]/div/label")
	WebElement Field_Desc;

	@FindBy(xpath = "//form[@id='addiecadmincertificate']/div/div[6]/div/label")
	WebElement Field_Strt_Date;

	@FindBy(xpath = "//form[@id='addiecadmincertificate']/div/div[7]/div/label")
	WebElement Field_Expiry_Date;

	// --Admin form alert texts elements

	@FindBy(xpath = "//form[@id='addiecadmin']/div/div/div/div/label")
	WebElement Institute_field;

	@FindBy(xpath = "//form[@id='addiecadmin']/div/div/div[2]/div/div/label")
	WebElement First_Name_field;


	@FindBy(xpath = "//form[@id='addiecadmin']/div/div/div[3]/div/div/label")
	WebElement MiddleName_field;

	@FindBy(xpath = "//form[@id='addiecadmin']/div/div/div[4]/div/div/label")
	WebElement Last_Name_field;

	@FindBy(xpath = "//form[@id='addiecadmin']/div/div/div[5]/div/div/div/label")
	WebElement DOB_field;

	@FindBy(xpath = "//form[@id='addiecadmin']/div/div/div[6]/div/div/label")
	WebElement Email_field;

	@FindBy(xpath = "//form[@id='addiecadmin']/div/div/div[7]/div/div/label")
	WebElement Phone_number_field;

	@FindBy(xpath = "//form[@id='addiecadmin']/div[2]/div/div/div/div/label")
	WebElement Department_field;

	@FindBy(xpath = "//form[@id='addiecadmin']/div[2]/div/div[2]/div/div/label")
	WebElement Designation_field;

	@FindBy(xpath = "//form[@id='addiecadmin']/div[2]/div/div[3]/div/div/label")
	WebElement Qualifications_field;

	@FindBy(xpath = "//form[@id='addiecadmin']/div[2]/div/div[4]/div/div/label")
	WebElement Registration_number_field;

	@FindBy(xpath = "//form[@id='addiecadmin']/div[2]/div/div[5]/div/div/label")
	WebElement Appointment_Letter_field;

	@FindBy(xpath = "//form[@id='addiecadmin']/div[2]/div/div[6]/div/div/label")
	WebElement Curriculum_Vitae_field;

	@FindBy(id = "add_iec_admin_details")
	WebElement Submit_button;

	// Form fields elements

	@FindBy(id = "add_iec_admin_first_name")
	WebElement iec_admin_first_name;

	@FindBy(id = "add_iec_admin_last_name")
	WebElement iec_admin_last_name;

	@FindBy(id = "add_iec_admin_date_of_birth")
	WebElement iec_admin_date_of_birth;

	@FindBy(id = "add_iec_admin_email")
	WebElement iec_admin_email;

	@FindBy(id = "add_iec_admin_contact_number")
	WebElement iec_admin_contact_number;

	@FindBy(id = "add_iec_admin_photo")
	WebElement iec_admin_photo;

	@FindBy(id = "add_iec_admin_department")
	WebElement iec_admin_department;

	@FindBy(id = "add_iec_admin_designation")
	WebElement iec_admin_designation;

	@FindBy(id = "add_iec_admin_qualifications")
	WebElement iec_admin_qualifications;

	@FindBy(id = "add_iec_admin_registration_number")
	WebElement iec_admin_registration_number;

	@FindBy(id = "add_iec_admin_appointment_letter")
	WebElement iec_admin_appointment_letter;

	@FindBy(id = "add_iec_admin_curriculum_vitae")
	WebElement iec_admin_curriculum_vitae;

	@FindBy(id = "add_iec_admin_institute")
	WebElement iec_admin_institute;

	@FindBy(xpath = "//form[@id='manageiecadmins']/div/p")
	WebElement Admin_Acknowledge;
	
	

	// Institution creation elements

	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a")
	WebElement Insts;

	@FindBy(xpath = "//*[@id='accordion']/li[2]/div/a")
	WebElement createins;

	@FindBy(id = "inst_name")
	WebElement Inst_Title;

	@FindBy(id = "inst_address")
	WebElement Adds;

	@FindBy(id = "cgi_des")
	WebElement DCGI_Reg_Numr;

	@FindBy(id = "cgi_attach")
	WebElement DCGI_Reg_Letter_Upload_attachmnt;

	@FindBy(id = "accrediation_desc")
	WebElement Accredn;

	@FindBy(id = "acc_attach")
	WebElement Accredn_Attachmnt;

	@FindBy(id = "inst_logo")
	WebElement Ins_Logo;

	@FindBy(xpath = "//*[@id='createinstitute']/div[8]/div/input")
	WebElement Create_button;

	@FindBy(xpath = "//*[@id='createinstitute']/div[8]/div/button")
	WebElement Back_button;

	@FindBy(id = "Institutions")
	WebElement instheading;

	@FindBy(css = ".bgand-border>h3")
	WebElement Institute_form_heading;

	@FindBy(xpath = "//p")
	WebElement MSG;

	@FindBy(xpath = "//*[@id='createinstitute']/div[1]/label")
	WebElement Institute_Title;

	@FindBy(css = "p.red")
	WebElement Photo_alert;

	// --Check for 'Add IEC Admin' from left navigation in manage institute
	// admin page--//

	public void CRe4_813() throws Exception {
		
try{

		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		String Inst_heading = r1.getCell(2,37).getContents();

		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();

		WebElement Manage_Inst_admin = GWait.Wait_GetElementByLinkText("Manage Institute Admins");
		Manage_Inst_admin.click();
				
		WebElement add_inst_admin = GWait.Wait_GetElementByLinkText("Add IEC Admin");
		add_inst_admin.click();
		
		
		Thread.sleep(6000);

		
		Assert.assertEquals(page_heading.getText().trim(), Inst_heading);
		

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
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
		
		sheet.getRow(23).createCell(4).setCellValue("Pass");
		sheet.getRow(23).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(23).createCell(4).setCellValue("Fail");
			sheet.getRow(23).getCell(4).setCellStyle(style);
			
			sheet.getRow(23).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(23).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}



	}
	// --Check for Add IEC form sections--//

	public void CRe4_814() throws Exception {
		
		

try{

		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		String Inst_heading = r1.getCell(2,39).getContents();

		String Section_heading_basic = r1.getCell(3,39).getContents();
		String Section_heading_professional = r1.getCell(4,39).getContents();
		String Section_heading_certifications = r1.getCell(5,39).getContents();

		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();

		WebElement Manage_Inst_admin = GWait.Wait_GetElementByLinkText("Manage Institute Admins");
		Manage_Inst_admin.click();
				
		WebElement add_inst_admin = GWait.Wait_GetElementByLinkText("Add IEC Admin");
		add_inst_admin.click();
Thread.sleep(2000);
		Assert.assertEquals(page_heading.getText().trim(), Inst_heading);

		Thread.sleep(4000);

		Assert.assertEquals(Section_heading_1_basic.getText().trim(), Section_heading_basic);
		
		Assert.assertEquals(Section_heading_2_Professional.getText().trim(), Section_heading_professional);
		
		Assert.assertEquals(Section_heading_3_Certifications.getText().trim(), Section_heading_certifications);
		

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
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
		
		sheet.getRow(24).createCell(4).setCellValue("Pass");
		sheet.getRow(24).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(24).createCell(4).setCellValue("Fail");
			sheet.getRow(24).getCell(4).setCellStyle(style);
			
			sheet.getRow(24).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(24).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


		
	}

	// --Check for Add IEC admin institution form options--//

	public void CRe4_815() throws Exception {
		
		try{
		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		String Inst_heading = r1.getCell(2,41).getContents();

		String Institute = r1.getCell(3,41).getContents();
		String First_Name = r1.getCell(4,41).getContents();
		String Middle_Name = r1.getCell(5,41).getContents();
		String Last_Name = r1.getCell(6,41).getContents();
		String DOB = r1.getCell(7,41).getContents();
		String Email = r1.getCell(8,41).getContents();
		String Contact_Number = r1.getCell(9,41).getContents();
		String Department = r1.getCell(10,41).getContents();
		String Designation = r1.getCell(11,41).getContents();
		String Qualifications = r1.getCell(12,41).getContents();
		String MCR = r1.getCell(13,41).getContents();
		String Type_of_certification = r1.getCell(14,41).getContents();
		String Title = r1.getCell(15,41).getContents();
		String DOT = r1.getCell(16,41).getContents();
		String Description = r1.getCell(17,41).getContents();
		String Start_Date = r1.getCell(18,41).getContents();
		String Expiry_Date = r1.getCell(19,41).getContents();

		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();

		WebElement Manage_Inst_admin = GWait.Wait_GetElementByLinkText("Manage Institute Admins");
		Manage_Inst_admin.click();
				
		WebElement add_inst_admin = GWait.Wait_GetElementByLinkText("Add IEC Admin");
		add_inst_admin.click();

		

		Thread.sleep(4000);
		Assert.assertEquals(Field_Institute.getText().trim(), Institute);
		
		Assert.assertEquals(Field_First_Name.getText().trim(), First_Name);
		
		Assert.assertEquals(Field_Middle_Name.getText().trim(), Middle_Name);
		
		Assert.assertEquals(Field_Last_Name.getText().trim(), Last_Name);

		Assert.assertEquals(Field_DOB.getText().trim(), DOB);

		
		Assert.assertEquals(Field_Email.getText().trim(), Email);
		
		Assert.assertEquals(Field_Cntct_num.getText().trim(), Contact_Number);
		
		Assert.assertEquals(Field_Department.getText().trim(), Department);
		
		Assert.assertEquals(Field_Designation.getText().trim(), Designation);
		
		Assert.assertEquals(Field_Qual.getText().trim(), Qualifications);
		
		Assert.assertEquals(Field_MCR.getText().trim(), MCR);
		
		Assert.assertEquals(Field_Certification.getText().trim(), Type_of_certification);

		Assert.assertEquals(Field_Title.getText().trim(), Title);

		
		Assert.assertEquals(Field_DOT.getText().trim(), DOT);
		
		Assert.assertEquals(Field_Desc.getText().trim(), Description);
		
		Assert.assertEquals(Field_Strt_Date.getText().trim(), Start_Date);
		
		Assert.assertEquals(Field_Expiry_Date.getText().trim(), Expiry_Date);
		

		String Field_Photo_1 = Field_Photo.getAttribute("value");
		System.out.println(Field_Photo_1);

		String Field_Appoint_Ltr_1 = Field_Appoint_Ltr.getAttribute("value");
		System.out.println(Field_Appoint_Ltr_1);

		String Field_CV_1 = Field_CV.getAttribute("value");
		System.out.println(Field_CV_1);

		String Field_COI_1 = Field_COI.getAttribute("value");
		System.out.println(Field_COI_1);

		String Field_prof_achvmnt_1 = Field_prof_achvmnt.getAttribute("value");
		System.out.println(Field_prof_achvmnt_1);

		String Field_Invt_Ltr_1 = Field_Invt_Ltr.getAttribute("value");
		System.out.println(Field_Invt_Ltr_1);

		String Field_Acptn_Ltr_1 = Field_Acptn_Ltr.getAttribute("value");
		System.out.println(Field_Acptn_Ltr_1);

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
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
		
		sheet.getRow(25).createCell(4).setCellValue("Pass");
		sheet.getRow(25).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(25).createCell(4).setCellValue("Fail");
			sheet.getRow(25).getCell(4).setCellStyle(style);
			
			sheet.getRow(25).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(25).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}
	// --Check for iec admin form submission with blank data--//

	public void CRe4_816() throws Exception {
		

try{

		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		//String Inst_heading = r1.getCell(2,63).getContents();
		
		String alert_inst = r1.getCell(3,43).getContents();
		String alert_frstname = r1.getCell(4,43).getContents();
		String alert_lastname = r1.getCell(5,43).getContents();
		String alert_dob = r1.getCell(6,43).getContents();
		String alert_email = r1.getCell(7,43).getContents();
		String alert_phone = r1.getCell(8,43).getContents();
		String alert_dept = r1.getCell(9,43).getContents();
		String alert_desg = r1.getCell(10,43).getContents();
		String alert_qual = r1.getCell(11,43).getContents();
		String alert_regnum = r1.getCell(12,43).getContents();
		String alert_appointletter = r1.getCell(13,43).getContents();
		String alert_cv = r1.getCell(14,43).getContents();

		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();

		WebElement Manage_Inst_admin = GWait.Wait_GetElementByLinkText("Manage Institute Admins");
		Manage_Inst_admin.click();
				
		WebElement add_inst_admin = GWait.Wait_GetElementByLinkText("Add IEC Admin");
		add_inst_admin.click();
		
	
		
		WebElement Submit_button = GWait.Wait_GetElementById("add_iec_admin_details");

		Submit_button.click();

		Thread.sleep(5000);
		Assert.assertEquals(Instalert.getText().trim(), alert_inst);
		
		Assert.assertEquals(frstalert.getText(), alert_frstname);
		
		Assert.assertEquals(lstalert.getText(), alert_lastname);
		
		Assert.assertEquals(dobalert.getText(), alert_dob);
		
		Assert.assertEquals(emailalert.getText(), alert_email);
		
		Assert.assertEquals(phonealert.getText(), alert_phone);

		
		Assert.assertEquals(deptalert.getText(), alert_dept);
		
		Assert.assertEquals(desgalert.getText(), alert_desg);
		
		Assert.assertEquals(qualalert.getText(), alert_qual);
		
		Assert.assertEquals(regalert.getText(), alert_regnum);
		
		Assert.assertEquals(aptalert.getText(), alert_appointletter);
		
		Assert.assertEquals(cvalert.getText(), alert_cv);
		
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
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
		
		sheet.getRow(26).createCell(4).setCellValue("Pass");
		sheet.getRow(26).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(26).createCell(4).setCellValue("Fail");
			sheet.getRow(26).getCell(4).setCellStyle(style);
			
			sheet.getRow(26).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(26).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}



	}
	
	@FindBy(xpath = "//form[@id='addiecadmin']/div/div/div/div/div/label")
	WebElement Instalert;
	
	@FindBy(xpath = "//form[@id='addiecadmin']/div/div/div[2]/div/div/label")
	WebElement frstalert;

	@FindBy(xpath = "//form[@id='addiecadmin']/div/div/div[4]/div/div/label")
	WebElement lstalert;
	
	@FindBy(xpath = "//form[@id='addiecadmin']/div/div/div[5]/div/div/div/label")
	WebElement dobalert;
	
	@FindBy(xpath = "//form[@id='addiecadmin']/div/div/div[6]/div/div/label")
	WebElement emailalert;
	
	@FindBy(xpath = "//form[@id='addiecadmin']/div/div/div[7]/div/div/label")
	WebElement phonealert;
	
	@FindBy(xpath = "//form[@id='addiecadmin']/div[2]/div/div/div/div/label")
	WebElement deptalert;
	
	@FindBy(xpath = "//form[@id='addiecadmin']/div[2]/div/div[2]/div/div/label")
	WebElement desgalert;
	
	@FindBy(xpath = "//form[@id='addiecadmin']/div[2]/div/div[3]/div/div/label")
	WebElement qualalert;
	
	@FindBy(xpath = "//form[@id='addiecadmin']/div[2]/div/div[4]/div/div/label")
	WebElement regalert;
	
	@FindBy(xpath = "//form[@id='addiecadmin']/div[2]/div/div[5]/div/div/label")
	WebElement aptalert;
	
	@FindBy(xpath = "//form[@id='addiecadmin']/div[2]/div/div[6]/div/div/label")
	WebElement cvalert;

	// --Check for iec admin form submission with out institute selection--//
	public void CRe4_817() throws Exception {
		
	try{

		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		String Inst_heading = r1.getCell(2,45).getContents();
		String admin_first_name = r1.getCell(3,45).getContents();

		String admin_last_name = r1.getCell(4,45).getContents();

		String admin_dob = r1.getCell(5,45).getContents();

		String admin_email = r1.getCell(6,45).getContents();

		String admin_contact_number = r1.getCell(7,45).getContents();

		String admin_department = r1.getCell(8,45).getContents();

		String admin_designation = r1.getCell(9,45).getContents();

		String admin_qualifications = r1.getCell(10,45).getContents();

		String admin_registration_number = r1.getCell(11,45).getContents();

		String admin_photo = r1.getCell(12,45).getContents();

		String admin_appointment_letter = r1.getCell(13,45).getContents();

		String admin_curriculum_vitae = r1.getCell(14,45).getContents();

		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();

		WebElement Manage_Inst_admin = GWait.Wait_GetElementByLinkText("Manage Institute Admins");
		Manage_Inst_admin.click();
				
		WebElement add_inst_admin = GWait.Wait_GetElementByLinkText("Add IEC Admin");
		add_inst_admin.click();

		Assert.assertEquals(page_heading.getText().trim(), Inst_heading);

		Thread.sleep(1000);

		iec_admin_first_name.sendKeys(admin_first_name);
		Thread.sleep(1000);
		iec_admin_last_name.sendKeys(admin_last_name);
		Thread.sleep(1000);
		iec_admin_date_of_birth.sendKeys(admin_dob);
		Thread.sleep(1000);
		iec_admin_email.sendKeys(admin_email);
		Thread.sleep(1000);
		iec_admin_contact_number.sendKeys(admin_contact_number);
		Thread.sleep(1000);
		iec_admin_photo.sendKeys(admin_photo);
		Thread.sleep(1000);
		Select select = new Select(iec_admin_department);
		select.selectByVisibleText(admin_department);
		Thread.sleep(4000);
		Select select_1 = new Select(iec_admin_designation);

		select_1.selectByVisibleText(admin_designation);
		Thread.sleep(1000);
		iec_admin_qualifications.sendKeys(admin_qualifications);
		Thread.sleep(1000);
		iec_admin_registration_number.sendKeys(admin_registration_number);
		Thread.sleep(1000);
		iec_admin_appointment_letter.sendKeys(admin_appointment_letter);
		Thread.sleep(1000);
		iec_admin_curriculum_vitae.sendKeys(admin_curriculum_vitae);
		
		WebElement Submit_button = GWait.Wait_GetElementById("add_iec_admin_details");
		Submit_button.click();
		Thread.sleep(1000);
		String Institute_field_1 = Institute_field.getText();
		System.out.println(Institute_field_1);

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		
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
		
		sheet.getRow(27).createCell(4).setCellValue("Pass");
		sheet.getRow(27).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(27).createCell(4).setCellValue("Fail");
			sheet.getRow(27).getCell(4).setCellStyle(style);
			
			sheet.getRow(27).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(27).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	// --Check for iec admin form submission with out basic information--//
	public void CRe4_818() throws Exception {
		
		try{

		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		String Inst_heading = r1.getCell(2,47).getContents();

		
		String admin_department = r1.getCell(3,47).getContents();

		String admin_designation = r1.getCell(4,47).getContents();

		String admin_qualifications = r1.getCell(5,47).getContents();

		String admin_registration_number = r1.getCell(6,47).getContents();


		String admin_appointment_letter = r1.getCell(7,47).getContents();

		String admin_curriculum_vitae = r1.getCell(8,47).getContents();
		
		String alert_inst = r1.getCell(9,47).getContents();
		String alert_frstname = r1.getCell(10,47).getContents();
		String alert_middlename = r1.getCell(11,47).getContents();
		String alert_lastname = r1.getCell(12,47).getContents();
		String alert_dob = r1.getCell(13,47).getContents();
		String alert_email = r1.getCell(14,47).getContents();
		String alert_phone = r1.getCell(15,47).getContents();

		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();

		WebElement Manage_Inst_admin = GWait.Wait_GetElementByLinkText("Manage Institute Admins");
		Manage_Inst_admin.click();
				
		WebElement add_inst_admin = GWait.Wait_GetElementByLinkText("Add IEC Admin");
		add_inst_admin.click();

		Assert.assertEquals(page_heading.getText().trim(), Inst_heading);

		Thread.sleep(1000);             
		Select select = new Select(iec_admin_department);
		select.selectByVisibleText(admin_department);
		Thread.sleep(1000);
		Select select_1 = new Select(iec_admin_designation);

		select_1.selectByVisibleText(admin_designation);
		Thread.sleep(1000);
		iec_admin_qualifications.sendKeys(admin_qualifications);
		Thread.sleep(1000);
		iec_admin_registration_number.sendKeys(admin_registration_number);
		Thread.sleep(1000);
		iec_admin_appointment_letter.sendKeys(admin_appointment_letter);
		Thread.sleep(1000);
		iec_admin_curriculum_vitae.sendKeys(admin_curriculum_vitae);
		WebElement Submit_button = GWait.Wait_GetElementById("add_iec_admin_details");
		Submit_button.click();


		Thread.sleep(4000);

        Assert.assertEquals(Institute_field.getText().trim(), alert_inst);
		
		Assert.assertEquals(Field_First_Name.getText(), alert_frstname);
		
		Assert.assertEquals(Field_Middle_Name.getText(), alert_middlename);
		
		Assert.assertEquals(Field_Last_Name.getText(), alert_lastname);
		
		Assert.assertEquals(Field_DOB.getText(), alert_dob);
		
		Assert.assertEquals(Field_Email.getText(), alert_email);
		
		Assert.assertEquals(Field_Cntct_num.getText(), alert_phone);

		

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();

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
		
		sheet.getRow(28).createCell(4).setCellValue("Pass");
		sheet.getRow(28).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(28).createCell(4).setCellValue("Fail");
			sheet.getRow(28).getCell(4).setCellStyle(style);
			
			sheet.getRow(28).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(28).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}



	}

	// --Check for iec admin form submission with out professional
	// information--//

	public void CRe4_819() throws Exception {
		
		try{

		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		String Inst_heading = r1.getCell(2,49).getContents();

		String admin_first_name = r1.getCell(3,49).getContents();

		String admin_last_name = r1.getCell(4,49).getContents();

		String admin_dob = r1.getCell(5,49).getContents();

		String admin_email = r1.getCell(6,49).getContents();

		String admin_contact_number = r1.getCell(7,49).getContents();

	
		String admin_photo = r1.getCell(8,49).getContents();
		String alert_dept = r1.getCell(9,49).getContents();
		String alert_desg = r1.getCell(10,49).getContents();
		String alert_qual = r1.getCell(11,49).getContents();
		String alert_regnum = r1.getCell(12,49).getContents();
		String alert_appointletter = r1.getCell(13,49).getContents();
		String alert_cv = r1.getCell(14,49).getContents();
		
		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();

		WebElement Manage_Inst_admin = GWait.Wait_GetElementByLinkText("Manage Institute Admins");
		Manage_Inst_admin.click();
				
		WebElement add_inst_admin = GWait.Wait_GetElementByLinkText("Add IEC Admin");
		add_inst_admin.click();
Thread.sleep(2000);
		Assert.assertEquals(page_heading.getText().trim(), Inst_heading);

		Thread.sleep(1000);

		iec_admin_first_name.sendKeys(admin_first_name);
		Thread.sleep(1000);

		iec_admin_last_name.sendKeys(admin_last_name);
		Thread.sleep(1000);

		iec_admin_date_of_birth.sendKeys(admin_dob);
		Thread.sleep(1000);

		iec_admin_email.sendKeys(admin_email);
		Thread.sleep(1000);

		iec_admin_contact_number.sendKeys(admin_contact_number);
		Thread.sleep(1000);

		iec_admin_photo.sendKeys(admin_photo);
		
		WebElement Submit_button = GWait.Wait_GetElementById("add_iec_admin_details");
		Submit_button.click();
		
		Thread.sleep(1000);

        Assert.assertEquals(Department_field.getText(), alert_dept);
		
		Assert.assertEquals(Designation_field.getText(), alert_desg);
		
		Assert.assertEquals(Qualifications_field.getText(), alert_qual);
		
		Assert.assertEquals(Registration_number_field.getText(), alert_regnum);
		
		Assert.assertEquals(Appointment_Letter_field.getText(), alert_appointletter);
		
		Assert.assertEquals(Curriculum_Vitae_field.getText(), alert_cv);
		
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();
		
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
		
		sheet.getRow(29).createCell(4).setCellValue("Pass");
		sheet.getRow(29).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(29).createCell(4).setCellValue("Fail");
			sheet.getRow(29).getCell(4).setCellStyle(style);
			
			sheet.getRow(29).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(29).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}
	
	
	// --Check for 'Upload photo' file upload with invalid formats--//

	public void CRe4_823() throws Exception {
		
		
try{

		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		String Inst_heading = r1.getCell(2,51).getContents();

		String admin_first_name = r1.getCell(3,51).getContents();

		String admin_last_name = r1.getCell(4,51).getContents();

		String admin_dob = r1.getCell(5,51).getContents();

		String admin_email = r1.getCell(6,51).getContents();

		String admin_contact_number = r1.getCell(7,51).getContents();

		String admin_department = r1.getCell(8,51).getContents();

		String admin_designation = r1.getCell(9,51).getContents();

		String admin_qualifications = r1.getCell(10,51).getContents();

		String admin_registration_number = r1.getCell(11,51).getContents();

		String admin_photo = r1.getCell(12,51).getContents();
		

		String admin_appointment_letter = r1.getCell(13,51).getContents();

		String admin_curriculum_vitae = r1.getCell(14,51).getContents();

		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();

		WebElement Manage_Inst_admin = GWait.Wait_GetElementByLinkText("Manage Institute Admins");
		Manage_Inst_admin.click();
				
		WebElement add_inst_admin = GWait.Wait_GetElementByLinkText("Add IEC Admin");
		add_inst_admin.click();
		
		Thread.sleep(6000);
		Assert.assertEquals(page_heading.getText().trim(), Inst_heading);
		

		Thread.sleep(1000);

		iec_admin_first_name.sendKeys(admin_first_name);
		Thread.sleep(1000);
		iec_admin_last_name.sendKeys(admin_last_name);
		Thread.sleep(1000);
		iec_admin_date_of_birth.sendKeys(admin_dob);
		Thread.sleep(1000);
		iec_admin_email.sendKeys(admin_email);
		Thread.sleep(1000);
		iec_admin_contact_number.sendKeys(admin_contact_number);
		Thread.sleep(1000);
		iec_admin_photo.sendKeys(admin_photo);
		Thread.sleep(1000);
		Select select = new Select(iec_admin_department);
		select.selectByVisibleText(admin_department);
		Thread.sleep(1000);
		Select select_1 = new Select(iec_admin_designation);

		select_1.selectByVisibleText(admin_designation);
		Thread.sleep(1000);
		iec_admin_qualifications.sendKeys(admin_qualifications);
		Thread.sleep(1000);
		iec_admin_registration_number.sendKeys(admin_registration_number);
		Thread.sleep(1000);
		iec_admin_appointment_letter.sendKeys(admin_appointment_letter);
		Thread.sleep(1000);
		iec_admin_curriculum_vitae.sendKeys(admin_curriculum_vitae);
		Thread.sleep(1000);
		Submit_button.click();
		
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
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
		
		sheet.getRow(30).createCell(4).setCellValue("Pass");
		sheet.getRow(30).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(30).createCell(4).setCellValue("Fail");
			sheet.getRow(30).getCell(4).setCellStyle(style);
			
			sheet.getRow(30).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(30).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	

	}
	// --Check for ''Upload photo' file upload formats--//

	public void CRe4_824() throws Exception {
		
		try{
		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		String Inst_heading = r1.getCell(2,53).getContents();

		
		String admin_first_name = r1.getCell(3,53).getContents();
		String admin_last_name = r1.getCell(4,53).getContents();
		String admin_dob = r1.getCell(5,53).getContents();
		String admin_email = r1.getCell(6,53).getContents();
		String admin_contact_number = r1.getCell(7,53).getContents();
		String admin_department = r1.getCell(8,53).getContents();
		String admin_designation = r1.getCell(9,53).getContents();
		String admin_qualifications = r1.getCell(10,53).getContents();
		String admin_registration_number = r1.getCell(11,53).getContents();
		String admin_photo = r1.getCell(12,53).getContents();
		
		String admin_appointment_letter = r1.getCell(13,53).getContents();
		String admin_curriculum_vitae = r1.getCell(14,53).getContents();

		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();

		WebElement Manage_Inst_admin = GWait.Wait_GetElementByLinkText("Manage Institute Admins");
		Manage_Inst_admin.click();
				
		WebElement add_inst_admin = GWait.Wait_GetElementByLinkText("Add IEC Admin");
		add_inst_admin.click();
		
		Thread.sleep(6000);
		Assert.assertEquals(page_heading.getText().trim(), Inst_heading);
		

		Thread.sleep(1000);

		iec_admin_first_name.sendKeys(admin_first_name);
		Thread.sleep(1000);
		iec_admin_last_name.sendKeys(admin_last_name);
		Thread.sleep(1000);
		iec_admin_date_of_birth.sendKeys(admin_dob);
		Thread.sleep(1000);
		iec_admin_email.sendKeys(admin_email);
		Thread.sleep(1000);
		iec_admin_contact_number.sendKeys(admin_contact_number);
		Thread.sleep(1000);
		iec_admin_photo.sendKeys(admin_photo);
		Thread.sleep(1000);
		Select select = new Select(iec_admin_department);
		select.selectByVisibleText(admin_department);
		Thread.sleep(1000);
		Select select_1 = new Select(iec_admin_designation);

		select_1.selectByVisibleText(admin_designation);
		Thread.sleep(1000);
		iec_admin_qualifications.sendKeys(admin_qualifications);
		Thread.sleep(1000);
		iec_admin_registration_number.sendKeys(admin_registration_number);
		Thread.sleep(1000);
		iec_admin_appointment_letter.sendKeys(admin_appointment_letter);
		Thread.sleep(1000);
		iec_admin_curriculum_vitae.sendKeys(admin_curriculum_vitae);
		Thread.sleep(1000);
		Submit_button.click();
		Thread.sleep(1000);


		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();
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
		
		sheet.getRow(31).createCell(4).setCellValue("Pass");
		sheet.getRow(31).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(31).createCell(4).setCellValue("Fail");
			sheet.getRow(31).getCell(4).setCellStyle(style);
			
			sheet.getRow(31).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(31).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}



	}

	@FindBy(id = "add_iec_admin_conflict_of_interest")
	WebElement ConfidentialityandConflictofInterestagreement;
	@FindBy(id = "add_iec_admin_professional_achievement")
	WebElement Updateprofessionalachievement;
	@FindBy(id = "add_iec_admin_invitation_letter")
	WebElement Invitationletter;
	@FindBy(id = "add_iec_admin_acceptance_letter")
	WebElement Acceptanceletter;
	@FindBy(id = "add_iec_admin_upload_document")
	WebElement AttachUpload;
	// --Check for 'Upload file' with invalid formats--//

	public void CRe4_825_827_829_831_833_835_837() throws Exception {
try{

		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		String UploadPhoto_Data = r1.getCell(2,55).getContents();
		String UploadAppointmentLetter_Data = r1.getCell(3,55).getContents();
		String UploadCurriculumVitae_Data = r1.getCell(4,55).getContents();
		String ConfidentialityandConflictofInterestagreement_Data = r1.getCell(5,55).getContents();
		String Updateprofessionalachievement_Data = r1.getCell(6,55).getContents();
		String Invitationletter_Data = r1.getCell(7,55).getContents();
		String Acceptanceletter_Data = r1.getCell(8,55).getContents();
		String AttachUpload_Data = r1.getCell(9,55).getContents();

		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();
Thread.sleep(1000);
		WebElement Manage_Inst_admin = GWait.Wait_GetElementByLinkText("Manage Institute Admins");
		Manage_Inst_admin.click();
				
		WebElement add_inst_admin = GWait.Wait_GetElementByLinkText("Add IEC Admin");
		add_inst_admin.click();
		
		Thread.sleep(1000);
		iec_admin_photo.sendKeys(UploadPhoto_Data);
		Thread.sleep(1000);
		iec_admin_appointment_letter.sendKeys(UploadAppointmentLetter_Data);
		Thread.sleep(1000);
		iec_admin_curriculum_vitae.sendKeys(UploadCurriculumVitae_Data);
		Thread.sleep(1000);
		ConfidentialityandConflictofInterestagreement.sendKeys(ConfidentialityandConflictofInterestagreement_Data);
		Thread.sleep(1000);
		Updateprofessionalachievement.sendKeys(Updateprofessionalachievement_Data);
		Thread.sleep(1000);
		Invitationletter.sendKeys(Invitationletter_Data);
		Thread.sleep(1000);
		Acceptanceletter.sendKeys(Acceptanceletter_Data);
		Thread.sleep(1000);
		AttachUpload.sendKeys(AttachUpload_Data);
		Thread.sleep(1000);
		GlobalMethods.alertaccept();

		Thread.sleep(3000);
		Submit_button.click();
		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		

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
		
		sheet.getRow(32).createCell(4).setCellValue("Pass");
		sheet.getRow(32).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(32).createCell(4).setCellValue("Fail");
			sheet.getRow(32).getCell(4).setCellStyle(style);
			
			sheet.getRow(32).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(32).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}



	}

	// --Check for ''Upload file' valid formats--//
	public void CRe4_826_828_830_832_834_836_838_839() throws Exception {

		try{
		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		String UploadPhoto_Data = r1.getCell(2,57).getContents();
		String UploadAppointmentLetter_Data = r1.getCell(3,57).getContents();
		String UploadCurriculumVitae_Data = r1.getCell(4,57).getContents();
		String ConfidentialityandConflictofInterestagreement_Data = r1.getCell(5,57).getContents();
		String Updateprofessionalachievement_Data = r1.getCell(6,57).getContents();
		String Invitationletter_Data = r1.getCell(7,57).getContents();
		String Acceptanceletter_Data = r1.getCell(8,57).getContents();
		String AttachUpload_Data = r1.getCell(9,57).getContents();

		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();

		WebElement Manage_Inst_admin = GWait.Wait_GetElementByLinkText("Manage Institute Admins");
		Manage_Inst_admin.click();
				
		WebElement add_inst_admin = GWait.Wait_GetElementByLinkText("Add IEC Admin");
		add_inst_admin.click();
		
		Thread.sleep(1000);
		iec_admin_photo.sendKeys(UploadPhoto_Data);
		Thread.sleep(1000);
		iec_admin_appointment_letter.sendKeys(UploadAppointmentLetter_Data);
		Thread.sleep(1000);
		iec_admin_curriculum_vitae.sendKeys(UploadCurriculumVitae_Data);
		Thread.sleep(1000);
		ConfidentialityandConflictofInterestagreement.sendKeys(ConfidentialityandConflictofInterestagreement_Data);
		Thread.sleep(1000);
		Updateprofessionalachievement.sendKeys(Updateprofessionalachievement_Data);
		Thread.sleep(1000);
		Invitationletter.sendKeys(Invitationletter_Data);
		Thread.sleep(1000);
		Acceptanceletter.sendKeys(Acceptanceletter_Data);
		Thread.sleep(1000);
		AttachUpload.sendKeys(AttachUpload_Data);

		Thread.sleep(3000);
		Submit_button.click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(0,1000)");
		
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
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
		
		sheet.getRow(33).createCell(4).setCellValue("Pass");
		sheet.getRow(33).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(33).createCell(4).setCellValue("Fail");
			sheet.getRow(33).getCell(4).setCellStyle(style);
			
			sheet.getRow(33).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(33).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}



	}

	@FindBy(id="add_iec_admin_institute")
	WebElement Institute;
	
	// **Check for email of admin creation
		// **Check for URL redirection in admin creation email
		// **Check for set password with valid data
		// **Check for login with admin credentials into the institute
		//**Verify the logged in user name after the login

	
	public void CRe4_820_821_822_840_841_842_843_844_845() throws Exception {
		
		try{


		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);

		Sheet r1 = wb.getSheet("Data_Sheet");

		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();
				
		WebElement Insts = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a");
		Insts.click();
		
		WebElement createins = GWait.Wait_GetElementByXpath("//*[@id='accordion']/li[2]/div/a");
		createins.click();

		String Inst_tite = r1.getCell(2, 59).getContents();
		String Inst_address = r1.getCell(3, 59).getContents();
		String Inst_number = r1.getCell(4, 59).getContents();
		String Inst_attachment = r1.getCell(5, 59).getContents();
		String Inst_accredtion = r1.getCell(6, 59).getContents();
		String Inst_accreattachment = r1.getCell(7, 59).getContents();
		String Inst_logo = r1.getCell(8, 59).getContents();
		
		String admin_first_name = r1.getCell(9, 59).getContents();

		String admin_last_name = r1.getCell(10, 59).getContents();
		String admin_dob = r1.getCell(11, 59).getContents();

		String admin_email = r1.getCell(12, 59).getContents();

		String admin_contact_number = r1.getCell(13, 59).getContents();

		String admin_department = r1.getCell(14, 59).getContents();

		String admin_designation = r1.getCell(15, 59).getContents();

		String admin_qualifications = r1.getCell(16, 59).getContents();

		String admin_registration_number = r1.getCell(17, 59).getContents();

		String admin_photo = r1.getCell(18, 59).getContents();

		String admin_appointment_letter = r1.getCell(19, 59).getContents();

		String admin_curriculum_vitae = r1.getCell(20, 59).getContents();
		
		//String Admin_Role = r.getCell(3, 13).getContents();

		
		WebElement Inst_Title =GWait.Wait_GetElementById("inst_name");
		Inst_Title.sendKeys(Inst_tite);
		Thread.sleep(2000);
		Adds.sendKeys(Inst_address);
		Thread.sleep(2000);
		DCGI_Reg_Numr.sendKeys(Inst_number);
		Thread.sleep(2000);

		DCGI_Reg_Letter_Upload_attachmnt.sendKeys(Inst_attachment);
		Thread.sleep(1000);

		Accredn.sendKeys(Inst_accredtion);
		Thread.sleep(1000);

		Thread.sleep(1000);
		Accredn_Attachmnt.sendKeys(Inst_accreattachment);
		Thread.sleep(1000);

		Ins_Logo.sendKeys(Inst_logo);
		
		WebElement Create_button =GWait.Wait_GetElementByXpath("//*[@id='createinstitute']/div[8]/div/input");
		Create_button.click();
		
		//admin creation
		
		WebElement Manage_Items1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items1.click();
		

		WebElement Manage_Inst_admin = GWait.Wait_GetElementByXpath("//a[contains(text(),'Manage Institute Admins')]");
		Manage_Inst_admin.click();
		
		WebElement add_inst_admin = GWait.Wait_GetElementByLinkText("Add IEC Admin");
		add_inst_admin.click();
		
		
		Thread.sleep(6000);

		
		Thread.sleep(6000);

		Select select = new Select(iec_admin_institute);
		select.selectByVisibleText(Inst_tite);

		iec_admin_first_name.sendKeys(admin_first_name);
		Thread.sleep(1000);
		iec_admin_last_name.sendKeys(admin_last_name);
		Thread.sleep(1000);
		iec_admin_date_of_birth.sendKeys(admin_dob);
		Thread.sleep(1000);
		iec_admin_email.sendKeys(admin_email);
		Thread.sleep(1000);
		iec_admin_contact_number.sendKeys(admin_contact_number);
		Thread.sleep(1000);
		iec_admin_photo.sendKeys(admin_photo);
		Thread.sleep(1000);
		Select select1 = new Select(iec_admin_department);
		select1.selectByVisibleText(admin_department);
		Thread.sleep(1000);
		Select select_1 = new Select(iec_admin_designation);

		select_1.selectByVisibleText(admin_designation);
		Thread.sleep(1000);
		iec_admin_qualifications.sendKeys(admin_qualifications);
		Thread.sleep(1000);
		iec_admin_registration_number.sendKeys(admin_registration_number);
		Thread.sleep(1000);
		iec_admin_appointment_letter.sendKeys(admin_appointment_letter);
		Thread.sleep(1000);
		iec_admin_curriculum_vitae.sendKeys(admin_curriculum_vitae);
		
		WebElement Submit_button = GWait.Wait_GetElementById("add_iec_admin_details");
		Submit_button.click();
		
		WebElement Manage_Items2 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items2.click();

		WebElement Manage_Inst_admin1 = GWait.Wait_GetElementByLinkText("Manage Institute Admins");
		Manage_Inst_admin1.click();
				
		WebElement add_inst_admin1 = GWait.Wait_GetElementByLinkText("Add IEC Admin");
		add_inst_admin1.click();
		
		
		WebElement iec_admin_institute =GWait.Wait_GetElementById("add_iec_admin_institute");
		Select select11 = new Select(iec_admin_institute);
		select11.selectByVisibleText(Inst_tite);
		Thread.sleep(6000);
		
		GlobalMethods.alertaccept();
		
		
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();
		
		GlobalMethods.AdminMail("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Ftab%3Dwm&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin",
				"qualeetee113@gmail.com", "qa123456");
		
		
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
		
		sheet.getRow(34).createCell(4).setCellValue("Pass");
		sheet.getRow(34).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(34).createCell(4).setCellValue("Fail");
			sheet.getRow(34).getCell(4).setCellStyle(style);
			
			sheet.getRow(34).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(34).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	
		}




}



