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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
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
 * Check for the Home page details in Create4 Application
 */

public class TS_02 {
	
	
	public TS_02()
	{
		//this.driver=driver;
		//driver = GlobalMethods.driver;
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
	
	@FindBy(xpath="html/body/div[2]/div/div[3]/div/ul/li")
	List<WebElement> instiscroll;	
	
	
	
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
	
	@FindBy(css="p")
	WebElement abtcontent;
	
	@FindBy(xpath="//html/body/div[2]/div/div[3]/div/ul")
	WebElement listinst;
	
	@FindBy(css="div.footer-main.col-sm-12 > span")
	WebElement cpytext;
	
	@FindBy(xpath="//li/a")
	WebElement instclick;
	
	//---------Check for CreATE-4 application -------------------//
	//--------Check for CreATE-4 Home page details-----//
		public void CRe4_01_02_03_08_10_11() throws Exception
		{
			
			try{
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("Login");
			Sheet r2 = wb.getSheet("Data_Sheet");

			String URL = r1.getCell(1,0).getContents();
			String FirefoxBrowser = r1.getCell(1,1).getContents();
			GlobalMethods.LaunchBrowser(FirefoxBrowser,URL);
			
			String aboutheading = r2.getCell(2, 65).getContents();
			String aboutcontent = r2.getCell(3, 65).getContents();
			String cpycontent = r2.getCell(4, 65).getContents();
			
			
			
	        Assert.assertEquals(Instituteheading.getText(),"Institutions");
	        
	        Assert.assertEquals(InstitutionsHead.getText(), aboutheading);
	        Assert.assertEquals(abtcontent.getText(), aboutcontent);
	        
	        Assert.assertEquals(cpytext.getText(), cpycontent);
	        
	        String instlist = listinst.getText();
	        System.out.println("instlist");
	        
	        instclick.click();
			
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
			
			sheet.getRow(41).createCell(4).setCellValue("Pass");
			sheet.getRow(41).getCell(4).setCellStyle(style);
			
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
				
				sheet.getRow(41).createCell(4).setCellValue("Fail");
				sheet.getRow(41).getCell(4).setCellStyle(style);
				
				sheet.getRow(41).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(41).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}


	        
		}
		
	
	//---------Check for active Institutions list on home page---//
	
	public void CRe4_04() throws Exception


	{
		try{
		
		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		String Institute_Title_1 = r1.getCell(2,67).getContents();
		String Address = r1.getCell(3,67).getContents();
		String DCGI_Registration_Number = r1.getCell(4,67).getContents();
		String DCGI_Registration_Letter_Upload_attachment = r1.getCell(5,67).getContents();
		String Accreditation = r1.getCell(6,67).getContents();
		String Accrediation_Attachment = r1.getCell(7,67).getContents();
		String Institute_Logo = r1.getCell(8,67).getContents();
		String InstCreationAck = r1.getCell(9, 67).getContents();

		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();
				
		WebElement Insts = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a");
		Insts.click();
		
		WebElement createins = GWait.Wait_GetElementByXpath("//*[@id='accordion']/li[2]/div/a");
		createins.click();

	
		WebElement Inst_Title = GWait.Wait_GetElementById("inst_name");
		Inst_Title.sendKeys(Institute_Title_1);
		
		
		WebElement Adds =GWait.Wait_GetElementById("inst_address");
		Adds.sendKeys(Address);
		
		
		WebElement DCGI_Reg_Numr =GWait.Wait_GetElementById("cgi_des");
		DCGI_Reg_Numr.sendKeys(DCGI_Registration_Number);

		
		WebElement DCGI_Reg_Letter_Upload_attachmnt =GWait.Wait_GetElementById("cgi_attach");
		DCGI_Reg_Letter_Upload_attachmnt.sendKeys(DCGI_Registration_Letter_Upload_attachment);

		
		WebElement Accredn =GWait.Wait_GetElementById("accrediation_desc");
		Accredn.sendKeys(Accreditation);

		
		WebElement Accredn_Attachmnt = GWait.Wait_GetElementById("acc_attach");
		Accredn_Attachmnt.sendKeys(Accrediation_Attachment);

		
		WebElement Ins_Logo =GWait.Wait_GetElementById("inst_logo");
		Ins_Logo.sendKeys(Institute_Logo);
		
		WebElement Create_button = GWait.Wait_GetElementByXpath("//*[@id='createinstitute']/div[8]/div/input");
		Create_button.click();
		

		
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();
		
		Thread.sleep(3000);
		GlobalMethods.ActiveInstitute();
		
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
		
		sheet.getRow(42).createCell(4).setCellValue("Pass");
		sheet.getRow(42).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(42).createCell(4).setCellValue("Fail");
			sheet.getRow(42).getCell(4).setCellStyle(style);
			
			sheet.getRow(42).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(42).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


		

			}
	

	//--------Check for Inactive Institutions list on home page---------//
	
	public void CRe4_05() throws Exception

	{

		try{
        GlobalMethods.Super_Login();
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");
		
		String Institute_Title_1 = r1.getCell(2,69).getContents();
		String Address = r1.getCell(3,69).getContents();
		String DCGI_Registration_Number = r1.getCell(4,69).getContents();
		String DCGI_Registration_Letter_Upload_attachment = r1.getCell(5,69).getContents();
		String Accreditation = r1.getCell(6,69).getContents();
		String Accrediation_Attachment = r1.getCell(7,69).getContents();
		String Institute_Logo = r1.getCell(8,69).getContents();
		String InstCreationAck = r1.getCell(9,69).getContents();
		String DeactivationAckMsg = r1.getCell(10,69).getContents();
		
		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();
				
		WebElement Insts = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a");
		Insts.click();
		
		WebElement createins = GWait.Wait_GetElementByXpath("//*[@id='accordion']/li[2]/div/a");
		createins.click();
		
		
		WebElement Inst_Title = GWait.Wait_GetElementById("inst_name");
		Inst_Title.sendKeys(Institute_Title_1);
		
		WebElement Adds =GWait.Wait_GetElementById("inst_address");
		Adds.sendKeys(Address);
		
		WebElement DCGI_Reg_Numr =GWait.Wait_GetElementById("cgi_des");
		DCGI_Reg_Numr.sendKeys(DCGI_Registration_Number);
		
		WebElement DCGI_Reg_Letter_Upload_attachmnt =GWait.Wait_GetElementById("cgi_attach");
		DCGI_Reg_Letter_Upload_attachmnt.sendKeys(DCGI_Registration_Letter_Upload_attachment);
		
		WebElement Accredn =GWait.Wait_GetElementById("accrediation_desc");
		Accredn.sendKeys(Accreditation);
		
		WebElement Accredn_Attachmnt = GWait.Wait_GetElementById("acc_attach");
		Accredn_Attachmnt.sendKeys(Accrediation_Attachment);
		
		WebElement Ins_Logo =GWait.Wait_GetElementById("inst_logo");
		Ins_Logo.sendKeys(Institute_Logo);
		
		WebElement Create_button = GWait.Wait_GetElementByXpath("//*[@id='createinstitute']/div[8]/div/input");
		Create_button.click();
		
	
		WebElement Deactivelink = GWait.Wait_GetElementByLinkText("De-active");	
		Deactivelink.click();
		Thread.sleep(2000);
		Assert.assertEquals(MSG.getText().trim(),DeactivationAckMsg);
		 

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();
		
		
				
	   Thread.sleep(4000);
	// GlobalMethods.DeActiveInstitute();
	  	
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
		
		sheet.getRow(43).createCell(4).setCellValue("Pass");
		sheet.getRow(43).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(43).createCell(4).setCellValue("Fail");
			sheet.getRow(43).getCell(4).setCellStyle(style);
			
			sheet.getRow(43).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(43).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


		
	}
		
	@FindBy(xpath="//div[2]/div/div[3]/div/ul/li")
	WebElement AllIntitutes;
	
	public void CRe4_06() throws Exception


	{
		try{
		
		GlobalMethods.LaunchBrowser("firefox","https://createstagenew.quad1test.com/");
		List<WebElement> AllInstitutes = GlobalMethods.driver.findElements(By.xpath("//div[2]/div/div[3]/div/ul/li"));

        for(WebElement e: AllInstitutes)
        {
            String str = e.getText();
            System.out.println("The items are  " + str);
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
		
		sheet.getRow(44).createCell(4).setCellValue("Pass");
		sheet.getRow(44).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(44).createCell(4).setCellValue("Fail");
			sheet.getRow(44).getCell(4).setCellStyle(style);
			
			sheet.getRow(44).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(44).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


		
	}
	public void CRe4_10() throws Exception{
		try{
		System.out.println("(not impelemted");
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
		
		sheet.getRow(45).createCell(4).setCellValue("Pass");
		sheet.getRow(45).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(45).createCell(4).setCellValue("Fail");
			sheet.getRow(45).getCell(4).setCellStyle(style);
			
			sheet.getRow(45).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(45).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	public void CRe4_09() throws Exception{
		
		try{
		
		GlobalMethods.LaunchBrowser("firefox","https://createstagenew.quad1test.com/");
		int a = instiscroll.size();
		System.out.println(a);
		if(a>5)
		{
			String isnt = GlobalMethods.driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/ul/li[a]")).getText();
			System.out.println(isnt);
			GlobalMethods.driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/ul/li[a]")).click();
			/*JavascriptExecutor je = (JavascriptExecutor)GlobalMethods.driver;
	        je.executeScript("arguments[0].scrollIntoView(true);",instiscroll);*/
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
		
		sheet.getRow(46).createCell(4).setCellValue("Pass");
		sheet.getRow(46).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(46).createCell(4).setCellValue("Fail");
			sheet.getRow(46).getCell(4).setCellStyle(style);
			
			sheet.getRow(46).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(46).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


        
        
	}
}

