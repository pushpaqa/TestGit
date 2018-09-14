package com.create4.scenarios;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;
import com.sun.jna.platform.win32.WinUser.LASTINPUTINFO;

import jxl.Sheet;
import jxl.Workbook;

/*
 * Check for institute creation with valid/Invalid data(After creation should display in the institution list)
 */

public class TS_01 {

	public TS_01() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[2]/a")
	WebElement Manage_Items;// s

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

	@FindBy(xpath = "//input[@value='Create']")
	WebElement CreateButton;

	@FindBy(xpath = "//form[@id='createinstitute']/div[8]/div/button")
	WebElement Backbutton;

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

	@FindBy(xpath = "//*[@id='createinstitute']/div[1]/label")
	WebElement Institute_Title;

	@FindBy(xpath = "//*[@id='createinstitute']/div[2]/label")
	WebElement Address;

	@FindBy(xpath = "//*[@id='createinstitute']/div[3]/label")
	WebElement DCGI_Registration_Number;

	@FindBy(xpath = "//*[@id='createinstitute']/div[4]/label")
	WebElement DCGI_Registration_Letter_Upload_attachment;

	@FindBy(xpath = "//*[@id='createinstitute']/div[5]/label")
	WebElement Accreditation;

	@FindBy(xpath = "//*[@id='createinstitute']/div[6]/label")
	WebElement Accrediation_Attachment;

	@FindBy(xpath = "//*[@id='createinstitute']/div[7]/label")
	WebElement Institute_Logo;

	@FindBy(xpath = "//p")
	WebElement MSG;

	@FindBy(xpath = "html/body/div[4]/div[1]/div/div[2]/div[3]/form/div[1]/div/label")
	WebElement InstituteTitleErrMsg;

	@FindBy(xpath = "html/body/div[4]/div[1]/div/div[2]/div[3]/form/div[2]/div/label")
	WebElement InstituteAddressErrMsg;

	@FindBy(xpath = "//form[@id='createinstitute']/div[4]/div/label")
	WebElement InvalidFileDCGIUploadErrorMsg;

	@FindBy(xpath = "//form[@id='createinstitute']/div[6]/div/label")
	WebElement InvalidFileAccredationUploadErrorMsg;

	@FindBy(xpath = "//form[@id='createinstitute']/div[7]/div/label")
	WebElement InvalidFileLogoUploadErrorMsg;

	@FindBy(id = "cgi_attachs")
	WebElement DCGI_Reg_Letter_upload;

	@FindBy(id = "acc_attachs")
	WebElement Accredn_Attach;

	@FindBy(id = "inst_logos")
	WebElement Inst_Log;

	@FindBy(xpath = "//span[3]/a")
	WebElement logoutt;

	@FindBy(css = "img")
	WebElement logo;

	@FindBy(css = "h3")
	WebElement instlistheading;

	@FindBy(css = "span.glyphicon.glyphicon-edit")
	WebElement InstituteEdit;

	@FindBy(xpath = "//div[4]/div/a")
	WebElement DCGIDocTextinEdit;

	@FindBy(xpath = "//div[6]/div/a")
	WebElement AccrediationDocTextinEdit;

	@FindBy(xpath = "//div[7]/div/a")
	WebElement LogoDocTextinEdit;

	// ----------Check for 'Create Institute' link functionality from left
	// navigation----------//

	public void CRe4_789() throws Exception {

		
		try {
			GlobalMethods.Super_Login();

			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("Data_Sheet");

			String Inst_heading = r1.getCell(2, 1).getContents();

			WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
			Manage_Items.click();

			WebElement Insts = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a");
			Insts.click();

			WebElement createins = GWait.Wait_GetElementByXpath("//*[@id='accordion']/li[2]/div/a");
			createins.click();

			Thread.sleep(3000);

			Assert.assertEquals(Institute_form_heading.getText().trim(), Inst_heading);
			Thread.sleep(4000);

			WebElement logoutt = GWait.Wait_GetElementByXpath("//span[3]/a");
			logoutt.click();

			System.out.println("CRe4_789");
			
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
			
			sheet.getRow(1).createCell(4).setCellValue("Pass");
			sheet.getRow(1).getCell(4).setCellStyle(style);
			
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
				
				sheet.getRow(1).createCell(4).setCellValue("Fail");
				sheet.getRow(1).getCell(4).setCellStyle(style);
				
				sheet.getRow(1).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(1).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}

		
		

	}

	// -------------Check for create institution form fields---//

	public void CRe4_790() throws Exception {

		
		
try{
		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		String Institute_Title1 = r1.getCell(2, 3).getContents();
		String Address1 = r1.getCell(3, 3).getContents();
		String DCGI_Registration_Number1 = r1.getCell(4, 3).getContents();
		String DCGI_Registration_Letter_Upload_attachment1 = r1.getCell(5, 3).getContents();
		String Accreditation1 = r1.getCell(6, 3).getContents();
		String Accrediation_Attachment1 = r1.getCell(7, 3).getContents();
		String Institute_Logo1 = r1.getCell(8, 3).getContents();
		String CreateButton = r1.getCell(9, 3).getContents();
		String BackButton = r1.getCell(10, 3).getContents();

		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();

		WebElement Insts = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a");
		Insts.click();

		WebElement createins = GWait.Wait_GetElementByXpath("//*[@id='accordion']/li[2]/div/a");
		createins.click();

		Thread.sleep(1000);
		Assert.assertEquals(Institute_Title.getText().trim(), Institute_Title1);
		Assert.assertEquals(Address.getText().trim(), Address1);
		Assert.assertEquals(DCGI_Registration_Number.getText().trim(), DCGI_Registration_Number1);
		Assert.assertEquals(DCGI_Registration_Letter_Upload_attachment.getText().trim(),
				DCGI_Registration_Letter_Upload_attachment1);
		Assert.assertEquals(Accreditation.getText().trim(), Accreditation1);
		Assert.assertEquals(Accrediation_Attachment.getText().trim(), Accrediation_Attachment1);
		Assert.assertEquals(Institute_Logo.getText().trim(), Institute_Logo1);
		Assert.assertEquals(Create_button.getAttribute("value"), CreateButton);
		Assert.assertEquals(Backbutton.getText(), BackButton);

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt.click();

		System.out.println("CRe4_790");
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
		
		sheet.getRow(2).createCell(4).setCellValue("Pass");
		sheet.getRow(2).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(2).createCell(4).setCellValue("Fail");
			sheet.getRow(2).getCell(4).setCellStyle(style);
			
			sheet.getRow(2).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(2).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
		
	}
	// ------Check for Create institution form with valid data----------//

	public void CRe4_791_792_793_794_795_801_A() throws Exception {
		
		
try{
		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		String Institute_Title_1 = r1.getCell(2, 5).getContents();
		String Address_1 = r1.getCell(3, 5).getContents();
		String DCGI_Registration_Number_1 = r1.getCell(4, 5).getContents();
		String DCGI_Registration_Letter_Upload_attachment_1 = r1.getCell(5, 5).getContents();
		String Accreditation_1 = r1.getCell(6, 5).getContents();
		String Accrediation_Attachment_1 = r1.getCell(7, 5).getContents();
		String Institute_Logo_1 = r1.getCell(8, 5).getContents();
		String InstCreationAck = r1.getCell(9, 5).getContents();

		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();

		WebElement Insts = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a");
		Insts.click();

		WebElement createins = GWait.Wait_GetElementByXpath("//*[@id='accordion']/li[2]/div/a");
		createins.click();

		WebElement Inst_Title = GWait.Wait_GetElementById("inst_name");
		Inst_Title.sendKeys(Institute_Title_1);
		Adds.sendKeys(Address_1);
		DCGI_Reg_Numr.sendKeys(DCGI_Registration_Number_1);
		DCGI_Reg_Letter_Upload_attachmnt.sendKeys(DCGI_Registration_Letter_Upload_attachment_1);
		Accredn.sendKeys(Accreditation_1);

		WebElement Accredn_Attachmnt = GWait.Wait_GetElementById("acc_attach");
		Accredn_Attachmnt.sendKeys(Accrediation_Attachment_1);
		Ins_Logo.sendKeys(Institute_Logo_1);

		WebElement Create_button = GWait.Wait_GetElementByXpath("//*[@id='createinstitute']/div[8]/div/input");
		Create_button.click();

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt.click();
		
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();
		
		WebElement institituecreated = GWait.Wait_GetElementByLinkText(Institute_Title_1);
		institituecreated.getText();
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
		
		sheet.getRow(3).createCell(4).setCellValue("Pass");
		sheet.getRow(3).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(3).createCell(4).setCellValue("Fail");
			sheet.getRow(3).getCell(4).setCellStyle(style);
			
			sheet.getRow(3).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(3).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
		

	}
	
	
	// ------Check for Create institution with blank data------------//

	public void CRe4_796() throws Exception {
		
		
		try{
		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		String InstituteTitleErrorMsg = r1.getCell(2, 7).getContents();
		String InstituteAddressErrorMsg = r1.getCell(3, 7).getContents();

		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();

		WebElement Insts = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a");
		Insts.click();

		WebElement createins = GWait.Wait_GetElementByXpath("//*[@id='accordion']/li[2]/div/a");
		createins.click();

		WebElement Create_button = GWait.Wait_GetElementByXpath("//*[@id='createinstitute']/div[8]/div/input");
		Create_button.click();

		Thread.sleep(2000);

		Assert.assertEquals(InstituteTitleErrMsg.getText().trim(), InstituteTitleErrorMsg);
		Assert.assertEquals(InstituteAddressErrMsg.getText().trim(), InstituteAddressErrorMsg);

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt.click();
		System.out.println("CRe4_796");
		
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
		
		sheet.getRow(4).createCell(4).setCellValue("Pass");
		sheet.getRow(4).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(4).createCell(4).setCellValue("Fail");
			sheet.getRow(4).getCell(4).setCellStyle(style);
			
			sheet.getRow(4).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(4).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
		
	}

	// -----Check for Create institution with invalid file formats in DGCI
	// upload----------//

	public void CRe4_797() throws Exception {
		
			
try{
	

		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		String Institute_Title_1 = r1.getCell(2, 9).getContents();
		String Address_1 = r1.getCell(3, 9).getContents();
		String DCGI_R_1egistration_Number_1 = r1.getCell(4, 9).getContents();
		String DCGI_Registration_Letter_Upload_attachment_1 = r1.getCell(5, 9).getContents();
		String DCGI_Registration_Letter_Upload_attachment_2 = r1.getCell(6, 9).getContents();
		String DCGI_Registration_Letter_Upload_attachment_3 = r1.getCell(7, 9).getContents();
		String DCGI_Registration_Letter_Upload_attachment_4 = r1.getCell(12, 9).getContents();
		String Accreditation_1 = r1.getCell(8, 9).getContents();
		String Accrediation_Attachment_1 = r1.getCell(9, 9).getContents();
		String Institute_Logo_1 = r1.getCell(10, 9).getContents();
		String DCGI_msg = r1.getCell(11, 9).getContents();

		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();

		WebElement Insts = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a");
		Insts.click();

		WebElement createins = GWait.Wait_GetElementByXpath("//*[@id='accordion']/li[2]/div/a");
		createins.click();

		
		
		WebElement Inst_Title = GWait.Wait_GetElementById("inst_name");;
		Inst_Title.sendKeys(Institute_Title_1);
		
		Adds.sendKeys(Address_1);
		DCGI_Reg_Numr.sendKeys(DCGI_R_1egistration_Number_1);

		DCGI_Reg_Letter_Upload_attachmnt.sendKeys(DCGI_Registration_Letter_Upload_attachment_1);

		Accredn.sendKeys(Accreditation_1);

		WebElement Accredn_Attachmnt = GWait.Wait_GetElementById("acc_attach");
		Accredn_Attachmnt.sendKeys(Accrediation_Attachment_1);

		Ins_Logo.sendKeys(Institute_Logo_1);
		WebElement Create_button = GWait.Wait_GetElementByXpath("//*[@id='createinstitute']/div[8]/div/input");
		Create_button.click();
		Thread.sleep(2000);
		Assert.assertEquals(InvalidFileDCGIUploadErrorMsg.getText().trim(), DCGI_msg);

		DCGI_Reg_Letter_Upload_attachmnt.sendKeys(DCGI_Registration_Letter_Upload_attachment_2);
		Create_button.click();
		Assert.assertEquals(InvalidFileDCGIUploadErrorMsg.getText(), DCGI_msg);

		DCGI_Reg_Letter_Upload_attachmnt.sendKeys(DCGI_Registration_Letter_Upload_attachment_3);
		Create_button.click();
		Assert.assertEquals(InvalidFileDCGIUploadErrorMsg.getText(), DCGI_msg);

		DCGI_Reg_Letter_Upload_attachmnt.sendKeys(DCGI_Registration_Letter_Upload_attachment_4);
		Create_button.click();
		Assert.assertEquals(InvalidFileDCGIUploadErrorMsg.getText(), DCGI_msg);

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt.click();
		System.out.println("CRe4_797");
		
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
		
		sheet.getRow(5).createCell(4).setCellValue("Pass");
		sheet.getRow(5).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(5).createCell(4).setCellValue("Fail");
			sheet.getRow(5).getCell(4).setCellStyle(style);
			
			sheet.getRow(5).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(5).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
	}

	// -------Check for Create institution with invalid file formats in
	// Accreditation-------//

	public void CRe4_798() throws Exception {
		
try{
		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		String Institute_Title_1 = r1.getCell(2, 11).getContents();
		String Address_1 = r1.getCell(3, 11).getContents();
		String DCGI_Registration_Number_1 = r1.getCell(4, 11).getContents();
		String DCGI_Registration_Letter_Upload_attachment_1 = r1.getCell(5, 11).getContents();

		String Accreditation_1 = r1.getCell(6, 11).getContents();
		String Accrediation_Attachment_1 = r1.getCell(7, 11).getContents();
		String Accrediation_Attachment_2 = r1.getCell(8, 11).getContents();
		String Accrediation_Attachment_3 = r1.getCell(9, 11).getContents();
		String Accrediation_Attachment_4 = r1.getCell(12, 11).getContents();
		String Institute_Logo_1 = r1.getCell(10, 11).getContents();
		String Acc_msg = r1.getCell(11, 11).getContents();

		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();

		WebElement Insts = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a");
		Insts.click();

		WebElement createins = GWait.Wait_GetElementByXpath("//*[@id='accordion']/li[2]/div/a");
		createins.click();

		Inst_Title.sendKeys(Institute_Title_1);
		Adds.sendKeys(Address_1);
		DCGI_Reg_Numr.sendKeys(DCGI_Registration_Number_1);

		DCGI_Reg_Letter_Upload_attachmnt.sendKeys(DCGI_Registration_Letter_Upload_attachment_1);

		Accredn.sendKeys(Accreditation_1);

		WebElement Accredn_Attachmnt = GWait.Wait_GetElementById("acc_attach");
		Accredn_Attachmnt.sendKeys(Accrediation_Attachment_1);

		Ins_Logo.sendKeys(Institute_Logo_1);
		Create_button.click();
		Thread.sleep(2000);
		Assert.assertEquals(InvalidFileAccredationUploadErrorMsg.getText(), Acc_msg);

		Accredn_Attachmnt.sendKeys(Accrediation_Attachment_2);
		Create_button.click();
		Assert.assertEquals(InvalidFileAccredationUploadErrorMsg.getText(), Acc_msg);

		Accredn_Attachmnt.sendKeys(Accrediation_Attachment_3);
		Create_button.click();
		Assert.assertEquals(InvalidFileAccredationUploadErrorMsg.getText(), Acc_msg);

		Accredn_Attachmnt.sendKeys(Accrediation_Attachment_4);
		Create_button.click();
		Assert.assertEquals(InvalidFileAccredationUploadErrorMsg.getText(), Acc_msg);

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt.click();
		System.out.println("CRe4_798");
		
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
		
		sheet.getRow(6).createCell(4).setCellValue("Pass");
		sheet.getRow(6).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(6).createCell(4).setCellValue("Fail");
			sheet.getRow(6).getCell(4).setCellStyle(style);
			
			sheet.getRow(6).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(6).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
	
	}

	// -------Check for Create institution with invalid file formats in
	// Logo----------//

	public void CRe4_799() throws Exception {
		
		try{

		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		String Institute_Title_1 = r1.getCell(2, 13).getContents();
		String Address_1 = r1.getCell(3, 13).getContents();
		String DCGI_Registration_Number_1 = r1.getCell(4, 13).getContents();
		String DCGI_Registration_Letter_Upload_attachment_1 = r1.getCell(5, 13).getContents();

		String Accreditation_1 = r1.getCell(6, 13).getContents();
		String Accrediation_Attachment_1 = r1.getCell(7, 13).getContents();
		String Institute_Logo_1 = r1.getCell(8, 13).getContents();
		String Institute_Logo_2 = r1.getCell(9, 13).getContents();
		String Institute_Logo_3 = r1.getCell(10, 13).getContents();
		String Institute_Logo_4 = r1.getCell(12, 13).getContents();
		String Institute_Logo_5 = r1.getCell(13, 13).getContents();
		String Institute_Logo_6 = r1.getCell(14, 13).getContents();

		String logo_msg = r1.getCell(11, 13).getContents();

		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();

		WebElement Insts = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a");
		Insts.click();

		WebElement createins = GWait.Wait_GetElementByXpath("//*[@id='accordion']/li[2]/div/a");
		createins.click();

		Inst_Title.sendKeys(Institute_Title_1);
		Adds.sendKeys(Address_1);
		DCGI_Reg_Numr.sendKeys(DCGI_Registration_Number_1);

		DCGI_Reg_Letter_Upload_attachmnt.sendKeys(DCGI_Registration_Letter_Upload_attachment_1);

		Accredn.sendKeys(Accreditation_1);

		Thread.sleep(2000);
		Accredn_Attachmnt.sendKeys(Accrediation_Attachment_1);

		Ins_Logo.sendKeys(Institute_Logo_1);
		Create_button.click();
		Thread.sleep(2000);
		Assert.assertEquals(InvalidFileLogoUploadErrorMsg.getText().trim(), logo_msg);

		Ins_Logo.sendKeys(Institute_Logo_2);
		Create_button.click();
		Assert.assertEquals(InvalidFileLogoUploadErrorMsg.getText().trim(), logo_msg);

		Ins_Logo.sendKeys(Institute_Logo_3);
		Create_button.click();
		Assert.assertEquals(InvalidFileLogoUploadErrorMsg.getText().trim(), logo_msg);

		Ins_Logo.sendKeys(Institute_Logo_4);
		Create_button.click();
		Assert.assertEquals(InvalidFileLogoUploadErrorMsg.getText().trim(), logo_msg);

		Ins_Logo.sendKeys(Institute_Logo_5);
		Create_button.click();
		Assert.assertEquals(InvalidFileLogoUploadErrorMsg.getText().trim(), logo_msg);

		Ins_Logo.sendKeys(Institute_Logo_6);
		Create_button.click();
		Assert.assertEquals(InvalidFileLogoUploadErrorMsg.getText().trim(), logo_msg);

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt.click();

		System.out.println("CRe4_799");
		
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
		
		sheet.getRow(7).createCell(4).setCellValue("Pass");
		sheet.getRow(7).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(7).createCell(4).setCellValue("Fail");
			sheet.getRow(7).getCell(4).setCellStyle(style);
			
			sheet.getRow(7).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(7).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
		
	}

	// ----------Check for file name display at field after upload(Verified File
	// Type)------------/

	public void CRe4_800() throws Exception {
		
try{
		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		String Institute_Title_1 = r1.getCell(2, 15).getContents();
		String Address_1 = r1.getCell(3, 15).getContents();
		String DCGI_Registration_Number_1 = r1.getCell(4, 15).getContents();
		String DCGI_Registration_Letter_Upload_attachment_1 = r1.getCell(5, 15).getContents();
		String Accreditation_1 = r1.getCell(6, 15).getContents();
		String Accrediation_Attachment_1 = r1.getCell(7, 15).getContents();
		String Institute_Logo_1 = r1.getCell(8, 15).getContents();
		String InstiCreationAck = r1.getCell(9, 15).getContents();
		String DCGIDocineDIT = r1.getCell(10, 15).getContents();
		String AccrediationDocineDIT = r1.getCell(11, 15).getContents();
		String LogoDocineDIT = r1.getCell(12, 15).getContents();

		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();

		WebElement Insts = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a");
		Insts.click();

		WebElement createins = GWait.Wait_GetElementByXpath("//*[@id='accordion']/li[2]/div/a");
		createins.click();

		
		
		WebElement Inst_Title = GWait.Wait_GetElementById("inst_name");
		Inst_Title.sendKeys(Institute_Title_1);
		
		Adds.sendKeys(Address_1);
		DCGI_Reg_Numr.sendKeys(DCGI_Registration_Number_1);

		DCGI_Reg_Letter_Upload_attachmnt.sendKeys(DCGI_Registration_Letter_Upload_attachment_1);

		Accredn.sendKeys(Accreditation_1);

		Thread.sleep(2000);
		Accredn_Attachmnt.sendKeys(Accrediation_Attachment_1);

		Ins_Logo.sendKeys(Institute_Logo_1);

		Thread.sleep(6000);
		Create_button.click();
		Thread.sleep(2000);
		// Assert.assertEquals(MSG.getText().trim(),InstiCreationAck);

		Thread.sleep(6000);
		InstituteEdit.click();
		Thread.sleep(6000);
		String[] st1 = DCGIDocTextinEdit.getText().split(Pattern.quote("."));
		String[] st2 = AccrediationDocTextinEdit.getText().split(Pattern.quote("."));
		String[] st3 = LogoDocTextinEdit.getText().split(Pattern.quote("."));

		Assert.assertEquals(st1[1], DCGIDocineDIT);
		Assert.assertEquals(st2[1], AccrediationDocineDIT);
		Assert.assertEquals(st3[1], LogoDocineDIT);
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt.click();

		System.out.println("CRe4_800");
		
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
		
		sheet.getRow(8).createCell(4).setCellValue("Pass");
		sheet.getRow(8).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(8).createCell(4).setCellValue("Fail");
			sheet.getRow(8).getCell(4).setCellStyle(style);
			
			sheet.getRow(8).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(8).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
		
	}

	// --Check for 'Back' button functionality in create institute page--/

	public void CRe4_801() throws Exception {
		
try{

		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		String insthead = r1.getCell(2, 17).getContents();

		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();

		WebElement Insts = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a");
		Insts.click();

		WebElement createins = GWait.Wait_GetElementByXpath("//*[@id='accordion']/li[2]/div/a");
		createins.click();

		WebElement Back_button = GWait.Wait_GetElementByXpath("//*[@id='createinstitute']/div[8]/div/button");
		Back_button.click();

		Assert.assertEquals(instlistheading.getText().trim(), insthead);

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt.click();

		System.out.println("CRe4_801");
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
		
		sheet.getRow(9).createCell(4).setCellValue("Pass");
		sheet.getRow(9).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(9).createCell(4).setCellValue("Fail");
			sheet.getRow(9).getCell(4).setCellStyle(style);
			
			sheet.getRow(9).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(9).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

		
	}
	
	

}
