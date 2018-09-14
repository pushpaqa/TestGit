package com.create4.scenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Driver;
import java.util.List;
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

import jxl.Sheet;
import jxl.Workbook;

/*
 * Check for the institutions list table after creating the institute with view/edit/status actions.
 */


public class TS_01A {
	
	
	public TS_01A()
	{
	
		PageFactory.initElements(GlobalMethods.driver,this);
	}
	
	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);
	
	
	@FindBy(xpath="html/body/div[3]/div/div[2]/ul/li[2]/a")
	WebElement Manage_Items;	
	
	@FindBy(xpath="html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a")
	WebElement Insts;	
	
	@FindBy(xpath="//*[@id='accordion']/li[2]/div/a")
	WebElement createins;
	
	@FindBy(id="inst_name")
	WebElement Inst_Title;
	
	@FindBy(id="inst_address")
	WebElement Adds;
	
	@FindBy(id="cgi_des")
	WebElement DCGI_Reg_Numr;
	
	@FindBy(id="cgi_attach")
	WebElement DCGI_Reg_Letter_Upload_attachmnt;
	
	@FindBy(id="accrediation_desc")
	WebElement Accredn;
	
	@FindBy(id="acc_attach")
	WebElement Accredn_Attachmnt;
	
	@FindBy(id="inst_logo")
	WebElement Ins_Logo;
	
	@FindBy(xpath="//*[@id='createinstitute']/div[8]/div/input")
	WebElement Create_button;

	@FindBy(xpath="//*[@id='createinstitute']/div[8]/div/button")
	WebElement Back_button;
	
	@FindBy(id="Institutions")
	WebElement instheading;
	
	@FindBy(css=".bgand-border>h3")
	WebElement Institute_form_heading;
	
	
	@FindBy(xpath="//*[@id='createinstitute']/div[1]/label")
	WebElement Institute_Title;
	
	@FindBy(xpath="//*[@id='createinstitute']/div[2]/label")
	WebElement Address;
	
	@FindBy(xpath="//*[@id='createinstitute']/div[3]/label")
	WebElement DCGI_Registration_Number;
	

	@FindBy(xpath="//*[@id='createinstitute']/div[4]/label")
	WebElement DCGI_Registration_Letter_Upload_attachment;
	
	@FindBy(xpath="//*[@id='createinstitute']/div[5]/label")
	WebElement Accreditation;
	
	@FindBy(xpath="//*[@id='createinstitute']/div[6]/label")
	WebElement Accrediation_Attachment;
	
	@FindBy(xpath="//*[@id='createinstitute']/div[7]/label")
	WebElement Institute_Logo;
	
	@FindBy(xpath="//p")
	WebElement MSG;
	
	@FindBy(xpath="html/body/div[4]/div[1]/div/div[2]/div[3]/form/div[1]/div/label")
	WebElement Error_one;
	
	@FindBy(xpath="html/body/div[4]/div[1]/div/div[2]/div[3]/form/div[2]/div/label")
	WebElement Error_two;
	
	@FindBy(xpath="//form[@id='createinstitute']/div[4]/div/label")
	WebElement Error_three;
	
	@FindBy(xpath="//form[@id='createinstitute']/div[6]/div/label")
	WebElement Error_four;
	
	@FindBy(xpath="//form[@id='createinstitute']/div[7]/div/label")
	WebElement Error_five;
	
	@FindBy(id="cgi_attachs")
	WebElement DCGI_Reg_Letter_upload;
	
	@FindBy(id="acc_attachs")
	WebElement Accredn_Attach;
	
	@FindBy(id="inst_logos")
	WebElement Inst_Log;
	
	@FindBy(css=".logout")
	WebElement logoutt;
	
	@FindBy(css="img")
	WebElement logo;
	
	@FindBy(css="h3")
	WebElement instlistheading;

	@FindBy(xpath="html/body/div[2]/div/div[3]/div")
	WebElement Inslist;	
	
	@FindBy(linkText="De-active")
	WebElement Deactivelink;	
	
	//Institute details on home page
	
	@FindBy(css="h2.margin-none")
	WebElement Inst_name_home;	
	
	@FindBy(css="p")
	WebElement Inst_addr_home;	
	
	@FindBy(xpath="//div[3]/div[1]/div/div/div[2]/div/text()")
	WebElement Inst_accre_home;	
	
	@FindBy(css="span.glyphicon.glyphicon-eye-open")
	WebElement Inst_view;	
	
	@FindBy(css="span.glyphicon.glyphicon-edit")
	WebElement Inst_edit;
	
	@FindBy(xpath="//input[@value='Update']")
	WebElement Inst_edit_update_button;
	
	//Institution details in view page
	

	@FindBy(xpath="//form[@id='updateIECInstitute']/div/div")
	WebElement Inst_name_details;
	

	@FindBy(xpath="//form[@id='updateIECInstitute']/div[2]/div")
	WebElement Inst_addr_detais;
	

	@FindBy(xpath="//form[@id='updateIECInstitute']/div[3]/div")
	WebElement Inst_DCGI_Reg_num_details;
	
	@FindBy(xpath="//form[@id='updateIECInstitute']/div[5]/div")
	WebElement Inst_accrd_details;
	
	@FindBy(xpath="//button[@onclick='javascript:history.back();return false;']")
	WebElement Inst_back_details;
	
	//Alert texts in edit
	
	@FindBy(css="label.error")
	WebElement Inst_title_edit_alert;
	
	@FindBy(xpath="//form[@id='updateIECInstitute']/div[2]/div/label")
	WebElement Inst_addr_edit_alert;
	
	@FindBy(xpath="//div[3]/h3")
	WebElement Instituteheading;
	
	
	@FindBy(xpath="//h3")
	WebElement InstitutionsHead;
	
	@FindBy(linkText="Create Institute")
	WebElement creatinstlink;
	
	@FindBy(xpath="//div[4]/div[1]/div/div[2]/h3")
	WebElement Overviewpageheading;
	
	//List column headings
	
	@FindBy(xpath="//th[2]/a/span[2]")
	WebElement listfield1;
	
	@FindBy(xpath="//th[3]/a/span[2]")
	WebElement listfield2;
	
	@FindBy(xpath="//th[4]/a/span[2]")
	WebElement listfield3;
	
	@FindBy(xpath="//th[5]/a/span[2]")
	WebElement listfield4;
	
	@FindBy(xpath="//th[6]/span")
	WebElement listfield5;
	
	@FindBy(xpath="//th[7]/span")
	WebElement listfield6;
	
	@FindBy(xpath="//tr[2]/td[7]")
	WebElement statusvalues;
	
	public void CRe4_762_763_764_765_766_767_768() throws Exception {
		
		try
		{
		
		GlobalMethods.Super_Login();
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");
		
		String Instpageheading = r1.getCell(2,19).getContents();
		String adminpageheading = r1.getCell(3,19).getContents();
		String helpitemspageheading = r1.getCell(4,19).getContents();
		
		String createinstlinkheading = r1.getCell(5,19).getContents();
		
		String tablefield1 = r1.getCell(6,19).getContents();
		String tablefield2 = r1.getCell(7,19).getContents();
		String tablefield3 = r1.getCell(8,19).getContents();
		String tablefield4 = r1.getCell(9,19).getContents();
		String tablefield5 = r1.getCell(10,19).getContents();
		String tablefield6 = r1.getCell(11,19).getContents();
		
		String viewheading = r1.getCell(12,19).getContents();
		String editheading = r1.getCell(13,19).getContents();
		
		String statuslistvalues = r1.getCell(14,19).getContents();
		
		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();
		
		WebElement Insts = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a");
		Insts.click();
		
		Thread.sleep(2000);
		Assert.assertEquals(InstitutionsHead.getText().trim(), Instpageheading);
		
		Assert.assertEquals(creatinstlink.getText().trim(), createinstlinkheading);
		
		Assert.assertEquals(listfield1.getText().trim(), tablefield1);
		Assert.assertEquals(listfield2.getText().trim(), tablefield2);
		Assert.assertEquals(listfield3.getText().trim(), tablefield3);
		Assert.assertEquals(listfield4.getText().trim(), tablefield4);
		Assert.assertEquals(listfield5.getText().trim(), tablefield5);
		Assert.assertEquals(listfield6.getText().trim(), tablefield6);
		
		Assert.assertEquals(statusvalues.getText().trim(), statuslistvalues);
		
		
		WebElement actionview = GWait.Wait_GetElementByCSS("span.glyphicon.glyphicon-eye-open");
		actionview.click();
		
		Assert.assertEquals(InstitutionsHead.getText().trim(), viewheading);
		
		WebElement backfrmview = GWait.Wait_GetElementByXpath("//form[@id='updateIECInstitute']/div[8]/div/button");
		backfrmview.click();
		
		WebElement actionedit = GWait.Wait_GetElementByCSS("span.glyphicon.glyphicon-edit");
		actionedit.click();
		Thread.sleep(2000);
		Assert.assertEquals(InstitutionsHead.getText().trim(), editheading);
		
		WebElement Manage_Items1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items1.click();
		
		WebElement Manage_Inst_admin = GWait.Wait_GetElementByLinkText("Manage Institute Admins");
		Manage_Inst_admin.click();
		
		Assert.assertEquals(InstitutionsHead.getText().trim(), adminpageheading);
		
		WebElement Manage_Items2 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items2.click();
		
		WebElement Help_Items_link = GWait.Wait_GetElementByLinkText("Help Items");
		Help_Items_link.click();
		
		Assert.assertEquals(InstitutionsHead.getText().trim(), helpitemspageheading);
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
		
		sheet.getRow(12).createCell(4).setCellValue("Pass");
		sheet.getRow(12).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(12).createCell(4).setCellValue("Fail");
			sheet.getRow(12).getCell(4).setCellStyle(style);
			
			sheet.getRow(12).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(12).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

		
	}
	
	//--Check for action view in institutions list--//
	public void CRe4_768() throws Exception {


		try{
		 GlobalMethods.Super_Login();
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("Data_Sheet");
			
			String Institute_Title_1 = r1.getCell(2,21).getContents();
			String Address_1 = r1.getCell(3,21).getContents();
			String DCGI_Registration_Number_1 = r1.getCell(4,21).getContents();
			String DCGI_Registration_Letter_Upload_attachment_1 = r1.getCell(5,21).getContents();
			String Accreditation_1 = r1.getCell(6,21).getContents();
			String Accrediation_Attachment_1 = r1.getCell(7,21).getContents();
			String Institute_Logo_1 = r1.getCell(8,21).getContents();
			String InstCreationAck = r1.getCell(9,21).getContents();
			String Institute_view_1 = r1.getCell(10,21).getContents();
			
			WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
			Manage_Items.click();
					
			WebElement Insts = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a");
			Insts.click();
			
			WebElement createins = GWait.Wait_GetElementByXpath("//*[@id='accordion']/li[2]/div/a");
			createins.click();
			
			WebElement Inst_Title = GWait.Wait_GetElementById("inst_name");
			Inst_Title.sendKeys(Institute_Title_1);
			
			WebElement Adds = GWait.Wait_GetElementById("inst_address");
			Adds.sendKeys(Address_1);
			
			WebElement  DCGI_Reg_Numr = GWait.Wait_GetElementById("cgi_des");
			DCGI_Reg_Numr.sendKeys(DCGI_Registration_Number_1);
			
			WebElement  DCGI_Reg_Letter_Upload_attachmnt = GWait.Wait_GetElementById("cgi_attach");
			DCGI_Reg_Letter_Upload_attachmnt.sendKeys(DCGI_Registration_Letter_Upload_attachment_1);
			
			WebElement  Accredn = GWait.Wait_GetElementById("accrediation_desc");
			Accredn.sendKeys(Accreditation_1);
			
			WebElement Accredn_Attachmnt = GWait.Wait_GetElementById("acc_attach");
			Accredn_Attachmnt.sendKeys(Accrediation_Attachment_1);
			
			WebElement  Ins_Logo = GWait.Wait_GetElementById("inst_logo");
			Ins_Logo.sendKeys(Institute_Logo_1);
			
			WebElement Create_button = GWait.Wait_GetElementByXpath("//*[@id='createinstitute']/div[8]/div/input");
			Create_button.click();
			
						
			WebElement Inst_view = GWait.Wait_GetElementByCSS("span.glyphicon.glyphicon-eye-open");
			
			Inst_view.click();
			
				
			
			
			Thread.sleep(2000);
			
			Assert.assertEquals(Overviewpageheading.getText().trim(),Institute_view_1);
			Thread.sleep(2000);
			

			WebElement logoutt = GWait.Wait_GetElementByXpath("//span[3]/a");
			logoutt.click();
			
			WebElement logo = GWait.Wait_GetElementByCSS("img");
			logo.click();
		    System.out.println("Execution of CRe4_768 is done");

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
			
			sheet.getRow(13).createCell(4).setCellValue("Pass");
			sheet.getRow(13).getCell(4).setCellStyle(style);
			
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
				
				sheet.getRow(13).createCell(4).setCellValue("Fail");
				sheet.getRow(13).getCell(4).setCellStyle(style);
				
				sheet.getRow(13).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(13).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}

	}
	@FindBy(xpath="//form[@id='updateIECInstitute']/div/label")
	WebElement InstituteTitle;
	@FindBy(xpath="//form[@id='updateIECInstitute']/div[2]/label")
	WebElement InstituteAddress;
	@FindBy(xpath="//form[@id='updateIECInstitute']/div[3]/label")
	WebElement DCGIRegNum;
	@FindBy(xpath="//form[@id='updateIECInstitute']/div[4]/label")
	WebElement DCGIRegLetter;
	@FindBy(xpath="//form[@id='updateIECInstitute']/div[5]/label")
	WebElement Accrediation;
	@FindBy(xpath="//form[@id='updateIECInstitute']/div[6]/label")
	WebElement AccrediationAttachment;
	@FindBy(xpath="//form[@id='updateIECInstitute']/div[7]/label")
	WebElement InstituteLogo1;
	
	@FindBy(xpath="//form[@id='updateIECInstitute']/div/div")
	WebElement InstituteTitleDet;
	@FindBy(xpath="//form[@id='updateIECInstitute']/div[2]/div")
	WebElement InstituteAddressDet;
	@FindBy(xpath="//form[@id='updateIECInstitute']/div[3]/div")
	WebElement InstituteRegNum;
	@FindBy(xpath="//form[@id='updateIECInstitute']/div[4]/div/a")
	WebElement InstituteRegLetterDet;
	@FindBy(xpath="//form[@id='updateIECInstitute']/div[5]/div")
	WebElement AcrediationDet;
	@FindBy(xpath="//form[@id='updateIECInstitute']/div[6]/div/a")
	WebElement AccrediationDetaAtta;
	@FindBy(xpath="//form[@id='updateIECInstitute']/div[7]/div/a")
	WebElement InstituteLogoDet;
	@FindBy(xpath="//td[6]/a/span")
	WebElement Overview;
	
	
	//--Check for institute details in the 'view'--//
	
	public void CRe4_769() throws Exception {
		
		try{
		
		GlobalMethods.Super_Login();
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");
		
		String Institute_Title_1 = r1.getCell(2,23).getContents();
		String Address_1 = r1.getCell(3,23).getContents();
		String DCGI_Registration_Number_1 = r1.getCell(4,23).getContents();
		String DCGIRegUpload = r1.getCell(5,23).getContents();
		String Accreditation = r1.getCell(6,23).getContents();
		String Accreditationupload = r1.getCell(7,23).getContents();
		String InstituteLogo = r1.getCell(8,23).getContents();
		String InstCreationAck = r1.getCell(9,23).getContents();
		
		
		String InstTitle = r1.getCell(10,23).getContents();
		String InstAddress = r1.getCell(11,23).getContents();
		String InstRegistNumber = r1.getCell(12,23).getContents();
		String InstRegLeeter = r1.getCell(13,23).getContents();
		String Accreditation11= r1.getCell(14,23).getContents();
		String AccreditationAttach = r1.getCell(15,23).getContents();
		String InstLogo = r1.getCell(16,23).getContents();
	
		
		String InstTitleDet = r1.getCell(17,23).getContents();
		String InstAddressDet = r1.getCell(18,23).getContents();
		String InstRegistNumberDet = r1.getCell(19,23).getContents();
		String InstRegLeeterDet = r1.getCell(20,23).getContents();
		String AccreditationDet = r1.getCell(21,23).getContents();
		String AccreditationAttachDet = r1.getCell(22,23).getContents();
		String InstLogoDet = r1.getCell(23,23).getContents();
		
		
		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();
				
		WebElement Insts = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a");
		Insts.click();
		
		WebElement createins = GWait.Wait_GetElementByXpath("//*[@id='accordion']/li[2]/div/a");
		createins.click();
		
		WebElement Inst_Title = GWait.Wait_GetElementById("inst_name");
		Inst_Title.sendKeys(Institute_Title_1);
		
		WebElement Adds = GWait.Wait_GetElementById("inst_address");
		Adds.sendKeys(Address_1);
		
		WebElement  DCGI_Reg_Numr = GWait.Wait_GetElementById("cgi_des");
		DCGI_Reg_Numr.sendKeys(DCGI_Registration_Number_1);
		
		WebElement  DCGI_Reg_Letter_Upload_attachmnt = GWait.Wait_GetElementById("cgi_attach");
		DCGI_Reg_Letter_Upload_attachmnt.sendKeys(DCGIRegUpload);
		
		WebElement  Accredn = GWait.Wait_GetElementById("accrediation_desc");
		Accredn.sendKeys(Accreditation);
		
		WebElement Accredn_Attachmnt = GWait.Wait_GetElementById("acc_attach");
		Accredn_Attachmnt.sendKeys(Accreditationupload);
		
		WebElement  Ins_Logo = GWait.Wait_GetElementById("inst_logo");
		Ins_Logo.sendKeys(InstituteLogo);
		
		WebElement Create_button = GWait.Wait_GetElementByXpath("//*[@id='createinstitute']/div[8]/div/input");
		Create_button.click();
				
		//Assert.assertEquals(MSG.getText().trim(),InstCreationAck);
		
		WebElement Overview = GWait.Wait_GetElementByXpath("//td[6]/a/span");
		Overview.click();
		
		
		
		//System.out.println("test");
		
		Assert.assertEquals(InstituteTitle.getText().trim(),InstTitle);
		Assert.assertEquals(InstituteAddress.getText().trim(), InstAddress);
		Assert.assertEquals(DCGIRegNum.getText().trim(), InstRegistNumber);
		Assert.assertEquals(DCGIRegLetter.getText().trim(),InstRegLeeter);
		System.out.println(Accrediation.getText().trim());
		System.out.println(Accreditation11);
		Assert.assertEquals(Accrediation.getText().trim(),Accreditation11);
		System.out.println(AccrediationAttachment.getText().trim());
		System.out.println(AccreditationAttach);
		Assert.assertEquals(AccrediationAttachment.getText().trim(),AccreditationAttach);
		System.out.println(InstituteLogo1.getText().trim());
		System.out.println(InstLogo);
		Assert.assertEquals(InstituteLogo1.getText().trim(),InstLogo);
		
		
		String[] st1 = InstituteRegLetterDet.getText().split(Pattern.quote("."));
		String[] st2 = AccrediationDetaAtta.getText().split(Pattern.quote("."));
		String[] st3 = InstituteLogoDet.getText().split(Pattern.quote("."));
		
		
		Assert.assertEquals(InstituteTitleDet.getText().trim(),InstTitleDet);
		Assert.assertEquals(InstituteAddressDet.getText().trim(),InstAddressDet);
		Assert.assertEquals(InstituteRegNum.getText().trim(),InstRegistNumberDet);
		Assert.assertEquals(st1[1],InstRegLeeterDet);
		Assert.assertEquals(AcrediationDet.getText().trim(),AccreditationDet);
		Assert.assertEquals(st2[1],AccreditationAttachDet);
		Assert.assertEquals(st3[1],InstLogoDet);
	
		

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span[3]/a");
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
		
		sheet.getRow(14).createCell(4).setCellValue("Pass");
		sheet.getRow(14).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(14).createCell(4).setCellValue("Fail");
			sheet.getRow(14).getCell(4).setCellStyle(style);
			
			sheet.getRow(14).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(14).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

		
	}
	
	//--Check for 'Back' button functionality in institute view page--/
	
	public void CRe4_770() throws Exception {

		try{
        GlobalMethods.Super_Login();
        
        FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");
		
		String Institute_Title_1 = r1.getCell(2,25).getContents();
		String Address_1 = r1.getCell(3,25).getContents();
		String DCGI_Registration_Number_1 = r1.getCell(4,25).getContents();
		String DCGIRegUpload = r1.getCell(5,25).getContents();
		String Accreditation = r1.getCell(6,25).getContents();
		String Accreditationupload = r1.getCell(7,25).getContents();
		String InstituteLogo = r1.getCell(8,25).getContents();
		String InstCreationAck = r1.getCell(9,25).getContents();
        
		
		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();
				
		WebElement Insts = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a");
		Insts.click();
		
		WebElement createins = GWait.Wait_GetElementByXpath("//*[@id='accordion']/li[2]/div/a");
		createins.click();
		
		WebElement Inst_Title = GWait.Wait_GetElementById("inst_name");
		Inst_Title.sendKeys(Institute_Title_1);
		WebElement Adds = GWait.Wait_GetElementById("inst_address");
		Adds.sendKeys(Address_1);
		
		WebElement  DCGI_Reg_Numr = GWait.Wait_GetElementById("cgi_des");
		DCGI_Reg_Numr.sendKeys(DCGI_Registration_Number_1);
		
		WebElement  DCGI_Reg_Letter_Upload_attachmnt = GWait.Wait_GetElementById("cgi_attach");
		DCGI_Reg_Letter_Upload_attachmnt.sendKeys(DCGIRegUpload);
		
		WebElement  Accredn = GWait.Wait_GetElementById("accrediation_desc");
		Accredn.sendKeys(Accreditation);
		
		Thread.sleep(2000);
		WebElement  Accredn_Attachmnt = GWait.Wait_GetElementById("acc_attach");
		Accredn_Attachmnt.sendKeys(Accreditationupload);
		
		WebElement  Ins_Logo = GWait.Wait_GetElementById("inst_logo");
		Ins_Logo.sendKeys(InstituteLogo);
		
		WebElement Create_button = GWait.Wait_GetElementByXpath("//*[@id='createinstitute']/div[8]/div/input");
		Create_button.click();
		WebElement Inst_view = GWait.Wait_GetElementByCSS("span.glyphicon.glyphicon-eye-open");
		
		Inst_view.click();
		
		WebElement Inst_back_details = GWait.Wait_GetElementByXpath("//button[@onclick='javascript:history.back();return false;']");
		Inst_back_details.click();
		
		
		Thread.sleep(6000);
		Assert.assertEquals(InstitutionsHead.getText().trim(),"Institutions");

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span[3]/a");
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
		
		sheet.getRow(15).createCell(4).setCellValue("Pass");
		sheet.getRow(15).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(15).createCell(4).setCellValue("Fail");
			sheet.getRow(15).getCell(4).setCellStyle(style);
			
			sheet.getRow(15).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(15).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}
	
	@FindBy(xpath="//form[@id='updateIECInstitute']/div[4]/div/a")
	WebElement DCGIUpload;
	
	@FindBy(xpath="//form[@id='updateIECInstitute']/div[6]/div/a")
	WebElement AccrediationUpload;
	
	@FindBy(xpath="//form[@id='updateIECInstitute']/div[7]/div/a")
	WebElement LogoUpload;
	
	//--Check for action 'edit' in institutions list--/
	//--------Check for the details in the update institution page--/
	
	public void CRe4_771_772() throws Exception{
		
		
try{
		
		    GlobalMethods.Super_Login();
			
		    FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("Data_Sheet");
			
			String Institute_Title_1 = r1.getCell(2,27).getContents();
			String Address_1 = r1.getCell(3,27).getContents();
			String DCGI_Registration_Number_1 = r1.getCell(4,27).getContents();
			String DCGIRegUpload = r1.getCell(5,27).getContents();
			String Accreditation = r1.getCell(6,27).getContents();
			String Accreditationupload = r1.getCell(7,27).getContents();
			String InstituteLogo = r1.getCell(8,27).getContents();
			String InstCreationAck = r1.getCell(9,27).getContents();
			String Institute_TitleEdit = r1.getCell(11,27).getContents();
			String AddressEdit = r1.getCell(12,27).getContents();
			String DCGI_Registration_NumberEdit = r1.getCell(13,27).getContents();
			String DCGIRegUploadEdit = r1.getCell(14,27).getContents();
			String AccreditationEdit = r1.getCell(15,27).getContents();
			String AccreditationuploadEdit = r1.getCell(16,27).getContents();
			String InstituteLogoEdit = r1.getCell(17,27).getContents();
			String InstEdithead = r1.getCell(10,27).getContents();
			
			WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
			Manage_Items.click();
					
			WebElement Insts = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a");
			Insts.click();
			
			WebElement createins = GWait.Wait_GetElementByXpath("//*[@id='accordion']/li[2]/div/a");
			createins.click();
						
			WebElement Inst_Title = GWait.Wait_GetElementById("inst_name");
			Inst_Title.sendKeys(Institute_Title_1);
									
			WebElement Adds = GWait.Wait_GetElementById("inst_address");
			Adds.sendKeys(Address_1);
									
			WebElement  DCGI_Reg_Numr = GWait.Wait_GetElementById("cgi_des");
			DCGI_Reg_Numr.sendKeys(DCGI_Registration_Number_1);
									
			WebElement  DCGI_Reg_Letter_Upload_attachmnt = GWait.Wait_GetElementById("cgi_attach");
			DCGI_Reg_Letter_Upload_attachmnt.sendKeys(DCGIRegUpload);
									
			WebElement  Accredn = GWait.Wait_GetElementById("accrediation_desc");
			Accredn.sendKeys(Accreditation);
						
			WebElement  Accredn_Attachmnt = GWait.Wait_GetElementById("acc_attach");
			Accredn_Attachmnt.sendKeys(Accreditationupload);
			
			WebElement  Ins_Logo = GWait.Wait_GetElementById("inst_logo");
			Ins_Logo.sendKeys(InstituteLogo);
			
			WebElement Create_button = GWait.Wait_GetElementByXpath("//*[@id='createinstitute']/div[8]/div/input");
			Create_button.click();
			
			
			//Assert.assertEquals(MSG.getText().trim(),InstCreationAck);
			
			WebElement Inst_edit = GWait.Wait_GetElementByCSS("span.glyphicon.glyphicon-edit");
			Inst_edit.click();
				
			
			Thread.sleep(4000);
			
			Assert.assertEquals(instlistheading.getText(),InstEdithead);
			
			System.out.println(DCGIUpload.getText().trim());
			System.out.println(AccrediationUpload.getText().trim());
			System.out.println(LogoUpload.getText().trim());
			
			String[] st1 = DCGIUpload.getText().trim().split(Pattern.quote("."));
			String[] st2 = AccrediationUpload.getText().trim().split(Pattern.quote("."));
			String[] st3 = LogoUpload.getText().trim().split(Pattern.quote("."));
			
			Thread.sleep(2000);
			WebElement Inst_Title1 = GWait.Wait_GetElementById("inst_name");
			Assert.assertEquals(Inst_Title1.getAttribute("value"),Institute_TitleEdit);
			
			WebElement Adds1 = GWait.Wait_GetElementById("inst_address");
			Assert.assertEquals(Adds1.getAttribute("value"),AddressEdit);
			
			WebElement  DCGI_Reg_Numr1 = GWait.Wait_GetElementById("cgi_des");
			Assert.assertEquals(DCGI_Reg_Numr1.getAttribute("value"),DCGI_Registration_NumberEdit);
					
			Assert.assertEquals(st1[1],DCGIRegUploadEdit);
			
			WebElement  Accredn1 = GWait.Wait_GetElementById("accrediation_desc");
			Assert.assertEquals(Accredn1.getAttribute("value"),AccreditationEdit);
			
			
			Assert.assertEquals(st2[1],AccreditationuploadEdit);
			Assert.assertEquals(st3[1],InstituteLogoEdit);
			

			WebElement logoutt = GWait.Wait_GetElementByXpath("//span[3]/a");
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
			
			sheet.getRow(16).createCell(4).setCellValue("Pass");
			sheet.getRow(16).getCell(4).setCellStyle(style);
			
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
				
				sheet.getRow(16).createCell(4).setCellValue("Fail");
				sheet.getRow(16).getCell(4).setCellStyle(style);
				
				sheet.getRow(16).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(16).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}

		}
	
	
		
		@FindBy(xpath="html/body/div[4]/div[1]/div/div[2]/div[3]/form/div[1]/div")
		WebElement InstitTitle;
		@FindBy(xpath="html/body/div[4]/div[1]/div/div[2]/div[3]/form/div[2]/div")
		WebElement Address_View;
		@FindBy(xpath="html/body/div[4]/div[1]/div/div[2]/div[3]/form/div[3]/div")
		WebElement DCGI_View;
		@FindBy(xpath="html/body/div[4]/div[1]/div/div[2]/div[3]/form/div[5]/div")
		WebElement Accred_View;
		@FindBy(xpath="//p")
		WebElement UpdateAckMsg;
		@FindBy(xpath="//td[2]")
		WebElement InstTitl;
		@FindBy(xpath="//td[3]")
		WebElement InstAdd;
		@FindBy(xpath="//td[4]")
		WebElement InstReg;
		@FindBy(xpath="//td[5]")
		WebElement InstAccre;
		
		
		//--Check modifying details from update institution page--/
		
		public void CRe4_773() throws Exception{
			
			try{
			
			GlobalMethods.Super_Login();
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("Data_Sheet");
			
			
			
			String Institute_Title_1 = r1.getCell(2,29).getContents();
			String Address_1 = r1.getCell(3,29).getContents();
			String DCGI_Registration_Number_1 = r1.getCell(4,29).getContents();
			String DCGIRegUpload = r1.getCell(5,29).getContents();
			String Accreditation = r1.getCell(6,29).getContents();
			String Accreditationupload = r1.getCell(7,29).getContents();
			String InstituteLogo = r1.getCell(8,29).getContents();
			String InstCreationAck = r1.getCell(9,29).getContents();
			
			
			String InstituteTitleEdit = r1.getCell(10,29).getContents();
			String InstituteAddrssEdit= r1.getCell(11,29).getContents();
			String InstituteRegEdit = r1.getCell(12,29).getContents();
			String InstituteAcredationEdit = r1.getCell(13,29).getContents();
			String InstUpdateAck = r1.getCell(14,29).getContents();
			
			
			String InstituteTitleView = r1.getCell(15,29).getContents();
			String InstituteAddrssView= r1.getCell(16,29).getContents();
			String InstituteRegView = r1.getCell(17,29).getContents();
			String InstituteAcredationView = r1.getCell(18,29).getContents();
			
			WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
			Manage_Items.click();
					
			WebElement Insts = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a");
			Insts.click();
			
			WebElement createins = GWait.Wait_GetElementByXpath("//*[@id='accordion']/li[2]/div/a");
			createins.click();
			
			WebElement Inst_Title = GWait.Wait_GetElementById("inst_name");
			Inst_Title.sendKeys(Institute_Title_1);
			
			WebElement Adds = GWait.Wait_GetElementById("inst_address");
			Adds.sendKeys(Address_1);
			
			WebElement  DCGI_Reg_Numr = GWait.Wait_GetElementById("cgi_des");
			DCGI_Reg_Numr.sendKeys(DCGI_Registration_Number_1);
			
			WebElement  DCGI_Reg_Letter_Upload_attachmnt = GWait.Wait_GetElementById("cgi_attach");
			DCGI_Reg_Letter_Upload_attachmnt.sendKeys(DCGIRegUpload);
			
			WebElement  Accredn = GWait.Wait_GetElementById("accrediation_desc");
			Accredn.sendKeys(Accreditation);
			
			
			WebElement Accredn_Attachmnt = GWait.Wait_GetElementById("acc_attach");
			Accredn_Attachmnt.sendKeys(Accreditationupload);
			
			WebElement  Ins_Logo = GWait.Wait_GetElementById("inst_logo");
			Ins_Logo.sendKeys(InstituteLogo);
			
			WebElement Create_button = GWait.Wait_GetElementByXpath("//*[@id='createinstitute']/div[8]/div/input");
			Create_button.click();
			
			WebElement Inst_edit = GWait.Wait_GetElementByCSS("span.glyphicon.glyphicon-edit");
			Inst_edit.click();
			
			Thread.sleep(3000);
			WebElement Inst_Title1 = GWait.Wait_GetElementById("inst_name");
			Inst_Title1.clear();
			WebElement Inst_Title11 = GWait.Wait_GetElementById("inst_name");
			Inst_Title11.sendKeys(InstituteTitleEdit);
			
			Thread.sleep(3000);
			WebElement Adds1 = GWait.Wait_GetElementById("inst_address");
			Adds1.clear();
			WebElement Adds11 = GWait.Wait_GetElementById("inst_address");
			Adds11.sendKeys(InstituteAddrssEdit);
			
			Thread.sleep(3000);
			WebElement  DCGI_Reg_Numr1 = GWait.Wait_GetElementById("cgi_des");
			DCGI_Reg_Numr1.clear();
			WebElement  DCGI_Reg_Numr11 = GWait.Wait_GetElementById("cgi_des");
			DCGI_Reg_Numr11.sendKeys(InstituteRegEdit);
						
			Thread.sleep(3000);
			WebElement  Accredn1 = GWait.Wait_GetElementById("accrediation_desc");
			Accredn1.clear();
			
			WebElement  Accredn11 = GWait.Wait_GetElementById("accrediation_desc");
			Accredn11.sendKeys(InstituteAcredationEdit);
			
			Inst_edit_update_button.click();
			Thread.sleep(3000);
			
			Assert.assertEquals(UpdateAckMsg.getText().trim(),InstUpdateAck);
			
			Assert.assertEquals(InstTitl.getText().trim(), InstituteTitleEdit);
			Assert.assertEquals(InstAdd.getText().trim(), InstituteAddrssEdit);
			Assert.assertEquals(InstReg.getText().trim(), InstituteRegEdit);
			Assert.assertEquals(InstAccre.getText().trim(), InstituteAcredationEdit);
			
			Inst_view.click();
			Thread.sleep(3000);
			Assert.assertEquals(InstitTitle.getText().trim(), InstituteTitleView);
			Assert.assertEquals(Address_View.getText().trim(), InstituteAddrssView);
			Assert.assertEquals(DCGI_View.getText().trim(), InstituteRegView);
			Assert.assertEquals(Accred_View.getText().trim(),InstituteAcredationView);
		

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
			
			sheet.getRow(17).createCell(4).setCellValue("Pass");
			sheet.getRow(17).getCell(4).setCellStyle(style);
			
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
				
				sheet.getRow(17).createCell(4).setCellValue("Fail");
				sheet.getRow(17).getCell(4).setCellStyle(style);
				
				sheet.getRow(17).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(17).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}


		}
		//--Check update institution form submission with blank data--/
		
		public void CRe4_774() throws Exception{
			
			try{
			
			    GlobalMethods.Super_Login();
				
				FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
				Workbook wb = Workbook.getWorkbook(fi);
				Sheet r1 = wb.getSheet("Data_Sheet");
				
				String Institute_edit_1 = r1.getCell(2,31).getContents();
				String errorone = r1.getCell(3,31).getContents();
				String errortwo = r1.getCell(4,31).getContents();

				WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
				Manage_Items.click();
						
				WebElement Insts = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a");
				Insts.click();

				WebElement Inst_edit = GWait.Wait_GetElementByCSS("span.glyphicon.glyphicon-edit");
				Inst_edit.click();
				
		
				Assert.assertEquals(instlistheading.getText(), Institute_edit_1);
				
				WebElement Inst_Title = GWait.Wait_GetElementById("inst_name");
				Inst_Title.clear();
				
				WebElement Adds = GWait.Wait_GetElementById("inst_address");
				Adds.clear();
				Thread.sleep(4000);
				Inst_edit_update_button.click();
				
							
				
								
				Thread.sleep(2000);
				
				Assert.assertEquals(Inst_title_edit_alert.getText(), errorone);
				
				Thread.sleep(2000);
				
				Assert.assertEquals(Inst_addr_edit_alert.getText(), errortwo);
				
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
				
				sheet.getRow(18).createCell(4).setCellValue("Pass");
				sheet.getRow(18).getCell(4).setCellStyle(style);
				
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
					
					sheet.getRow(18).createCell(4).setCellValue("Fail");
					sheet.getRow(18).getCell(4).setCellStyle(style);
					
					sheet.getRow(18).createCell(5).setCellValue("Report Error: "+ "\n" + e);
					sheet.getRow(18).getCell(5).setCellStyle(style);
					
					FileOutputStream output = new FileOutputStream(source);
					wb11.write(output);
					wb11.close();
					
					throw(e);
			}

		}
		//--Check for 'Back' button functionality in update institute page--/
		
		public void CRe4_776() throws Exception{
			
			
			try{
			    GlobalMethods.Super_Login();
				
				FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
				Workbook wb = Workbook.getWorkbook(fi);
				Sheet r1 = wb.getSheet("Data_Sheet");
				String Institute_edit_1 = r1.getCell(2,33).getContents();
				
				WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
				Manage_Items.click();
						
				WebElement Insts = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a");
				Insts.click();

				WebElement Inst_edit = GWait.Wait_GetElementByCSS("span.glyphicon.glyphicon-edit");
				Inst_edit.click();
				
				
				
				String instlistheading_edit = instlistheading.getText();
				Institute_edit_1.equalsIgnoreCase(instlistheading_edit);
				
				System.out.println(instlistheading_edit);
				Thread.sleep(4000);
				Inst_back_details.click();
				
				
										
				
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
				
				sheet.getRow(19).createCell(4).setCellValue("Pass");
				sheet.getRow(19).getCell(4).setCellStyle(style);
				
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
					
					sheet.getRow(19).createCell(4).setCellValue("Fail");
					sheet.getRow(19).getCell(4).setCellStyle(style);
					
					sheet.getRow(19).createCell(5).setCellValue("Report Error: "+ "\n" + e);
					sheet.getRow(19).getCell(5).setCellStyle(style);
					
					FileOutputStream output = new FileOutputStream(source);
					wb11.write(output);
					wb11.close();
					
					throw(e);
			}

			
			
		}
		//--Check for 'DGI Registration Letter' file upload with invalid formats--/
		
		public void CRe4_777() throws Exception{

try{
			
			GlobalMethods.Super_Login();
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("Data_Sheet");
			
			String Institute_Title_1 = r1.getCell(2,35).getContents();
			String Address_1 = r1.getCell(3,35).getContents();
			String DCGI_R_1egistration_Number_1 = r1.getCell(4,35).getContents();
			String DCGI_Registration_Letter_Upload_attachment_1 = r1.getCell(5,35).getContents();
			String DCGI_Registration_Letter_Upload_attachment_2 = r1.getCell(6,35).getContents();
			String DCGI_Registration_Letter_Upload_attachment_3 = r1.getCell(7,35).getContents();
			String Accreditation_1 = r1.getCell(8,35).getContents();
			String Accrediation_Attachment_1 = r1.getCell(9,35).getContents();
			String Institute_Logo_1 = r1.getCell(10,35).getContents();
			
			String DCGI_msg = r1.getCell(11,35).getContents();
			
			WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
			Manage_Items.click();
					
			
			WebElement Insts = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a");
			Insts.click();
			
			WebElement createins = GWait.Wait_GetElementByXpath("//*[@id='accordion']/li[2]/div/a");
			createins.click();
			
			WebElement Inst_Title = GWait.Wait_GetElementById("inst_name");
			Inst_Title.sendKeys(Institute_Title_1);
			
			WebElement Adds = GWait.Wait_GetElementById("inst_address");
			Adds.sendKeys(Address_1);
			
			WebElement  DCGI_Reg_Numr = GWait.Wait_GetElementById("cgi_des");
			DCGI_Reg_Numr.sendKeys(DCGI_R_1egistration_Number_1);
			
			WebElement  DCGI_Reg_Letter_Upload_attachmnt = GWait.Wait_GetElementById("cgi_attach");
			DCGI_Reg_Letter_Upload_attachmnt.sendKeys(DCGI_Registration_Letter_Upload_attachment_1);
			
			WebElement  Accredn = GWait.Wait_GetElementById("accrediation_desc");
			Accredn.sendKeys(Accreditation_1);
			
			Thread.sleep(2000);
			WebElement  Accredn_Attachmnt = GWait.Wait_GetElementById("acc_attach");
			Accredn_Attachmnt.sendKeys(Accrediation_Attachment_1);
			
			WebElement  Ins_Logo = GWait.Wait_GetElementById("inst_logo");
			Ins_Logo.sendKeys(Institute_Logo_1);

			WebElement Create_button = GWait.Wait_GetElementByXpath("//*[@id='createinstitute']/div[8]/div/input");
			Create_button.click();
			Thread.sleep(2000);
							
			
			 String message1 = Error_three.getText();
			 message1.equalsIgnoreCase(DCGI_msg);
			 //assertEquals(DCGI_msg,message1);
			 System.out.println(message1);
			 
			 WebElement  DCGI_Reg_Letter_Upload_attachmnt1 = GWait.Wait_GetElementById("cgi_attach");
				DCGI_Reg_Letter_Upload_attachmnt1.sendKeys(DCGI_Registration_Letter_Upload_attachment_2);
				
				
				Assert.assertEquals(Error_three.getText(), DCGI_msg);
				
				WebElement  DCGI_Reg_Letter_Upload_attachmnt11 = GWait.Wait_GetElementById("cgi_attach");
				 
				
					DCGI_Reg_Letter_Upload_attachmnt11.sendKeys(DCGI_Registration_Letter_Upload_attachment_3);
					
					
					Assert.assertEquals(Error_three.getText(), DCGI_msg);
					
					

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
					
					sheet.getRow(20).createCell(4).setCellValue("Pass");
					sheet.getRow(20).getCell(4).setCellStyle(style);
					
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
						
						sheet.getRow(20).createCell(4).setCellValue("Fail");
						sheet.getRow(20).getCell(4).setCellStyle(style);
						
						sheet.getRow(20).createCell(5).setCellValue("Report Error: "+ "\n" + e);
						sheet.getRow(20).getCell(5).setCellStyle(style);
						
						FileOutputStream output = new FileOutputStream(source);
						wb11.write(output);
						wb11.close();
						
						throw(e);
				}


				
		}
		
		
		
		
		
		
		
		
		
		
		
}

