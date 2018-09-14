package com.create4.scenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

/*
 * Check for Header menu's of all roles
 */
public class TS_128 {
	
	public TS_128(){
		PageFactory.initElements(GlobalMethods.driver, this);
	}GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);
	
    //Super admin menu items elements
	
    @FindBy(linkText="Contact Us / Feedback")
    WebElement Menu_1;	
    
    @FindBy(linkText="Manage Items")
    WebElement Menu_2;	
    
    @FindBy(linkText="Manage Logs")
    WebElement Menu_3;	
    
    @FindBy(linkText="SMTP Configuration")
    WebElement Menu_4;	
    
    @FindBy(linkText="My Account")
    WebElement Menu_5;	
    
    @FindBy(xpath = "//span/a")
	WebElement logoutt;
	
	@FindBy(css="img")
	WebElement logo;
	
	//PI login menu items elements
	
	@FindBy(linkText="Dashboard")
	WebElement Menu_PI_1;
	
	@FindBy(linkText="My Projects")
	WebElement Menu_PI_2;
	
	@FindBy(linkText="Project Notifications")
	WebElement Menu_PI_3;
	
	@FindBy(linkText="Reminders")
	WebElement Menu_PI_4;
	
	@FindBy(linkText="My IEC")
	WebElement Menu_PI_5;
	
	@FindBy(linkText="My Account")
	WebElement Menu_PI_6;
	
	@FindBy(linkText="My Profile")
	WebElement Menu_PI_7;
	
	@FindBy(linkText="Change Password")
	WebElement Menu_PI_8;
	
	@FindBy(xpath="//ul[@id='accordion']/li/div/a")
	WebElement Menu_PI_9;
	
	@FindBy(linkText="Submit New Project")
	WebElement Menu_PI_10;
	
	//Admin menu items 
	
	@FindBy(linkText="Projects")
	WebElement Menu_admin_1;
	
	@FindBy(linkText="Meetings")
	WebElement Menu_admin_2;
	
	@FindBy(linkText="Manage IEC")
	WebElement Menu_admin_3;
	
	@FindBy(linkText="Institution")
	WebElement Menu_admin_4;
	
	@FindBy(linkText="SOP")
	WebElement Menu_admin_5;
	
	@FindBy(linkText="External Links")
	WebElement Menu_admin_6;
	
	@FindBy(linkText="Manage Departments")
	WebElement Menu_admin_7;
	
	@FindBy(linkText="Manage Qualifications")
	WebElement Menu_admin_8;
	
	@FindBy(linkText="Manage Document Type")
	WebElement Menu_admin_9;
	
	@FindBy(linkText="Manage IEC Members")
	WebElement Menu_admin_10;
	
	@FindBy(linkText="Manage Ethics Committee")
	WebElement Menu_admin_11;
	
	@FindBy(linkText="Manage Users")
	WebElement Menu_admin_12;
	
	@FindBy(linkText="Manage Registration Requests")
	WebElement Menu_admin_13;	
	
	@FindBy(linkText="View Invitee Requests")
	WebElement Menu_admin_14;
	
	@FindBy(linkText="IEC Submission Forms / Annexures")
	WebElement Menu_admin_15;
	
	@FindBy(linkText="Email Templates")
	WebElement Menu_admin_16;
	
	@FindBy(linkText="Reports")
	WebElement Menu_admin_17;
	
	@FindBy(linkText="User Report")
	WebElement Menu_admin_18;
	
	@FindBy(linkText="Returned Projects Report")
	WebElement Menu_admin_19;
	
	@FindBy(linkText="Admin Review Configuration")
	WebElement Menu_admin_20;
	
	@FindBy(linkText="IEC Member Configuration")
	WebElement Menu_admin_21;
	
	@FindBy(linkText="Meeting/Submission Configuration")
	WebElement Menu_admin_22;
	
	@FindBy(linkText="Principal Investigator Registration Configuration")
	WebElement Menu_admin_23;
	
		
	@FindBy(linkText="All Projects")
	WebElement Menu_admin_24;
	
	@FindBy(linkText="Archived Projects")
	WebElement Menu_admin_25;
	
	@FindBy(css="i.fa.fa-gear")
	WebElement setting_button;
	
	//Member Secretary menu elements
	
	@FindBy(linkText="IEC Annexures")
	WebElement menu_ms_1;
	
	@FindBy(linkText="Announcements")
	WebElement menu_ms_2;
	
	//member menu elements
	
	@FindBy(linkText="Projects for IEC Review")
	WebElement menu_mem_1;
	
	@FindBy(linkText="Assigned Projects")
	WebElement menu_mem_2;
	
	
	
	
    
    
    public void CRe4_596_597() throws Exception{
    	
    	try{

    	GlobalMethods.Super_Login();
    	
    	FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Projects");
		

		String contact_1 = r1.getCell(2, 3).getContents();
		String manageitems_1 = r1.getCell(3, 3).getContents();
		String managelogs_1 = r1.getCell(4, 3).getContents();
		String smtpconfig_1 = r1.getCell(5, 3).getContents();
		String myaccount_1 = r1.getCell(6, 3).getContents();
		
		
		Assert.assertEquals(Menu_1.getText(), contact_1);
    	
		Assert.assertEquals(Menu_2.getText(), manageitems_1);
    	
		Assert.assertEquals(Menu_3.getText(), managelogs_1);
    	
		Assert.assertEquals(Menu_4.getText(), smtpconfig_1);
    	
		Assert.assertEquals(Menu_5.getText(), myaccount_1);
    	
    	
    	
		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();
		
		
		WebElement logo2 = GWait.Wait_GetElementByCSS("img");
		logo2.click();
    	   	
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
		
		sheet.getRow(81).createCell(4).setCellValue("Pass");
		sheet.getRow(81).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(81).createCell(4).setCellValue("Fail");
			sheet.getRow(81).getCell(4).setCellStyle(style);
			
			sheet.getRow(81).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(81).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

    	
    }
    
      
    //Check for Principal investigator login
    public void CRe4_598_99() throws Exception{

    	try{

    	GlobalMethods.PI_Login();
    	
    	FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Projects");
		
		String dashboard = r1.getCell(2, 5).getContents();
		String myprojects = r1.getCell(3, 5).getContents();
		String projectnotifications = r1.getCell(4, 5).getContents();
		String reminders = r1.getCell(5, 5).getContents();
		String myiec = r1.getCell(6, 5).getContents();
		String myaccount = r1.getCell(7, 5).getContents();
		String myprofile = r1.getCell(8, 5).getContents();
		String changepassword = r1.getCell(9, 5).getContents();
		String submitnewproject = r1.getCell(10, 5).getContents();
		
		
		Assert.assertEquals(Menu_PI_1.getText(), dashboard);
		
		Assert.assertEquals(Menu_PI_2.getText(), myprojects);
		
		Assert.assertEquals(Menu_PI_3.getText(), projectnotifications);
		
		Assert.assertEquals(Menu_PI_4.getText(), reminders);
		
		Assert.assertEquals(Menu_PI_5.getText(), myiec);
		
		
		Assert.assertEquals(Menu_PI_6.getText(), myaccount);
		
		
		WebElement Menu_PI_6 =GWait.Wait_GetElementByLinkText("My Account");
		Menu_PI_6.click();
		
		Assert.assertEquals(Menu_PI_7.getText(), myprofile);
		
		WebElement Menu_PI_61 =GWait.Wait_GetElementByLinkText("My Account");
		Menu_PI_61.click();
		
		Assert.assertEquals(Menu_PI_8.getText(), changepassword);
		
		Assert.assertEquals(Menu_PI_9.getText(), dashboard);
		
		
		Assert.assertEquals(Menu_PI_10.getText(), submitnewproject);
		
	
		
		
		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();
		
		
		WebElement logo2 = GWait.Wait_GetElementByCSS("img");
		logo2.click();
		
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
		
		sheet.getRow(82).createCell(4).setCellValue("Pass");
		sheet.getRow(82).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(82).createCell(4).setCellValue("Fail");
			sheet.getRow(82).getCell(4).setCellStyle(style);
			
			sheet.getRow(82).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(82).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

    	
    }
          
    //Check for Log in as  IEC administrator 
    public void CRe4_600_601() throws Exception{

    	try{
    	GlobalMethods.Admin_Login();

    	FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Projects");
		
		String dashboard = r1.getCell(2, 7).getContents();
		String projects = r1.getCell(3, 7).getContents();
		String meetings = r1.getCell(4, 7).getContents();
		String manageiec = r1.getCell(5, 7).getContents();
		String institute = r1.getCell(6, 7).getContents();
		String sop = r1.getCell(7, 7).getContents();
		String externallinks = r1.getCell(8, 7).getContents();
		String managedepartment = r1.getCell(9, 7).getContents();
		String managequalifications = r1.getCell(10, 7).getContents();
		String managedocumenttype = r1.getCell(11, 7).getContents();
		String manageiecmembers = r1.getCell(12, 7).getContents();
		String manageethiccomm = r1.getCell(13, 7).getContents();
		String manageusers = r1.getCell(14, 7).getContents();
		String managreg = r1.getCell(15, 7).getContents();
		String viewinvitee = r1.getCell(16, 7).getContents();
		String iecformsub = r1.getCell(17, 7).getContents();
		String emailtemplates = r1.getCell(18, 7).getContents();
		String reports = r1.getCell(19, 7).getContents();
		String userreport = r1.getCell(20, 7).getContents();
		String returnedprojects = r1.getCell(21, 7).getContents();
		String myaccount = r1.getCell(22, 7).getContents();
		String myprofile = r1.getCell(23, 7).getContents();
		String changepwd = r1.getCell(24, 7).getContents();
		String adminreview = r1.getCell(25, 7).getContents();
		String iecmemconfig = r1.getCell(26, 7).getContents();
		String meetingsub = r1.getCell(27, 7).getContents();
		String principalreg = r1.getCell(28, 7).getContents();
		String dashboard1 = r1.getCell(29, 7).getContents();
		String allprojects = r1.getCell(30, 7).getContents();
		String archivedprojects = r1.getCell(31, 7).getContents();
		
		
		
		Assert.assertEquals(Menu_PI_1.getText(), dashboard);
	
		Assert.assertEquals(Menu_admin_1.getText(), projects);
		
		Assert.assertEquals(Menu_admin_2.getText(), meetings);
		
		Assert.assertEquals(Menu_admin_3.getText(), manageiec);
		
		
		WebElement Menu_admin_3 =GWait.Wait_GetElementByLinkText("Manage IEC");		
		Menu_admin_3.click();
		
		Assert.assertEquals(Menu_admin_4.getText(), institute);
		
		
		WebElement Menu_admin_4 =GWait.Wait_GetElementByLinkText("Manage IEC");
		Menu_admin_4.click();
		
		Assert.assertEquals(Menu_admin_5.getText(), sop);
		
		WebElement Menu_admin_5 =GWait.Wait_GetElementByLinkText("Manage IEC");
		Menu_admin_5.click();
		
		Assert.assertEquals(Menu_admin_6.getText(), externallinks);
		
		WebElement Menu_admin_6 =GWait.Wait_GetElementByLinkText("Manage IEC");
		Menu_admin_6.click();
		
		Assert.assertEquals(Menu_admin_7.getText(), managedepartment);
		
		WebElement Menu_admin_7 =GWait.Wait_GetElementByLinkText("Manage IEC");
		Menu_admin_7.click();
		
		Assert.assertEquals(Menu_admin_8.getText(), managequalifications);
		
		WebElement Menu_admin_8 =GWait.Wait_GetElementByLinkText("Manage IEC");
		Menu_admin_8.click();
	
		Assert.assertEquals(Menu_admin_9.getText(), managedocumenttype);
		
		WebElement Menu_admin_9 =GWait.Wait_GetElementByLinkText("Manage IEC");
		Menu_admin_9.click();
		
		Assert.assertEquals(Menu_admin_10.getText(), manageiecmembers);
		
		WebElement Menu_admin_10 =GWait.Wait_GetElementByLinkText("Manage IEC");
		Menu_admin_10.click();
		
		Assert.assertEquals(Menu_admin_11.getText(), manageethiccomm);
		
		Assert.assertEquals(Menu_admin_12.getText(), manageusers);
		
		
		WebElement Menu_admin_12 = GWait.Wait_GetElementByLinkText("Manage Users");
		Menu_admin_12.click();
		
		Assert.assertEquals(Menu_admin_13.getText(), managreg);
		
		WebElement Menu_admin_12_1 = GWait.Wait_GetElementByLinkText("Manage Users");
		Menu_admin_12_1.click();
		
		Assert.assertEquals(Menu_admin_14.getText(), viewinvitee);
		
		Assert.assertEquals(Menu_admin_15.getText(), iecformsub);
		
		Assert.assertEquals(Menu_admin_16.getText(), emailtemplates);
		
		Assert.assertEquals(Menu_admin_17.getText(), reports);
		
		
	
		
		WebElement Menu_admin_17 =GWait.Wait_GetElementByLinkText("Reports");
		Menu_admin_17.click();
		
		Assert.assertEquals(Menu_admin_18.getText(), userreport);
		
		WebElement Menu_admin_17_1 =GWait.Wait_GetElementByLinkText("Reports");
		Menu_admin_17_1.click();
		
		Assert.assertEquals(Menu_admin_19.getText(), returnedprojects);
		
		Assert.assertEquals(Menu_PI_6.getText(), myaccount);
		
		
		WebElement Menu_PI_6 =GWait.Wait_GetElementByLinkText("My Account");
		Menu_PI_6.click();
		
		Assert.assertEquals(Menu_PI_7.getText(), myprofile);
		
		WebElement Menu_PI_6_1 =GWait.Wait_GetElementByLinkText("My Account");
		Menu_PI_6_1.click();
		
		Assert.assertEquals(Menu_PI_8.getText(), changepwd);
		
		
		WebElement setting_button =GWait.Wait_GetElementByCSS("i.fa.fa-gear");
		setting_button.click();
		
		Assert.assertEquals(Menu_admin_20.getText(), adminreview);
		
		WebElement setting_button1 =GWait.Wait_GetElementByCSS("i.fa.fa-gear");
		setting_button1.click();
		
		Assert.assertEquals(Menu_admin_21.getText(), iecmemconfig);
		
		WebElement setting_button2 =GWait.Wait_GetElementByCSS("i.fa.fa-gear");
		setting_button2.click();
		
		Assert.assertEquals(Menu_admin_22.getText(), meetingsub);
		
		WebElement setting_button3 =GWait.Wait_GetElementByCSS("i.fa.fa-gear");
		setting_button3.click();
		
		Assert.assertEquals(Menu_admin_23.getText(), principalreg);
	
		Assert.assertEquals(Menu_PI_9.getText(), dashboard1);
		
		Assert.assertEquals(Menu_admin_24.getText(), allprojects);
		
		Assert.assertEquals(Menu_admin_25.getText(), archivedprojects);
		
		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();
		
		
		WebElement logo2 = GWait.Wait_GetElementByCSS("img");
		logo2.click();
		
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
		
		sheet.getRow(83).createCell(4).setCellValue("Pass");
		sheet.getRow(83).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(83).createCell(4).setCellValue("Fail");
			sheet.getRow(83).getCell(4).setCellStyle(style);
			
			sheet.getRow(83).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(83).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

		
    }
    
       
    //Check for Log in as Member Secretary
    public void CRe4_602_603_604_605() throws Exception{

    	try{
    	
    	GlobalMethods.MS_Login();
    	FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Projects");
		
		String dashboard = r1.getCell(2, 9).getContents();
		String projects = r1.getCell(3, 9).getContents();
		String meetings = r1.getCell(4, 9).getContents();
		String reminders = r1.getCell(5, 9).getContents();
		String iecannexure = r1.getCell(6, 9).getContents();
		String announcement = r1.getCell(7, 9).getContents();
		String myaccount = r1.getCell(8, 9).getContents();
		String myprofile = r1.getCell(9, 9).getContents();
		String changepassword = r1.getCell(10, 9).getContents();
		String dashboard1 = r1.getCell(11, 9).getContents();
		
		Assert.assertEquals(Menu_PI_1.getText(), dashboard);
		
		Assert.assertEquals(Menu_admin_1.getText(), projects);
		
		Assert.assertEquals(Menu_admin_2.getText(), meetings);
		
		Assert.assertEquals(Menu_PI_4.getText(), reminders);
		
		Assert.assertEquals(menu_ms_1.getText(), iecannexure);
		
		Assert.assertEquals(menu_ms_2.getText(), announcement);
		
		Assert.assertEquals(Menu_PI_6.getText(), myaccount);
		
		
		WebElement Menu_PI_6 =GWait.Wait_GetElementByLinkText("My Account");
		Menu_PI_6.click();
		
		Assert.assertEquals(Menu_PI_7.getText(), myprofile);
	
		WebElement Menu_PI_6_1 =GWait.Wait_GetElementByLinkText("My Account");
		Menu_PI_6_1.click();
		
		Assert.assertEquals(Menu_PI_8.getText(), changepassword);
			
		Assert.assertEquals(Menu_PI_9.getText(), dashboard1);
			
		
		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();
		
		
		WebElement logo2 = GWait.Wait_GetElementByCSS("img");
		logo2.click();
		
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
		
		sheet.getRow(84).createCell(4).setCellValue("Pass");
		sheet.getRow(84).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(84).createCell(4).setCellValue("Fail");
			sheet.getRow(84).getCell(4).setCellStyle(style);
			
			sheet.getRow(84).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(84).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	    	
    }
    
 
     
    //Check for Log in as Member
    public void CRe4_606_607() throws Exception{
    	
    	try{
    	
    	GlobalMethods.Member1Login();
    	
    	FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Projects");
		
		String projects = r1.getCell(2, 11).getContents();
		String meetings = r1.getCell(3, 11).getContents();
		String reminders = r1.getCell(4, 11).getContents();
		String myiec = r1.getCell(5, 11).getContents();
		String myaccount = r1.getCell(6, 11).getContents();
		String myprofile = r1.getCell(7, 11).getContents();
		String changepassword = r1.getCell(8, 11).getContents();
		String projectforreview = r1.getCell(9, 11).getContents();
		String assignedprjcts = r1.getCell(10, 11).getContents();
		
		Assert.assertEquals(Menu_admin_1.getText(), projects);
		
		Assert.assertEquals(Menu_admin_2.getText(), meetings);
		
		Assert.assertEquals(Menu_PI_4.getText(), reminders);
		
		Assert.assertEquals(Menu_PI_5.getText(), myiec);
			
		
		Assert.assertEquals(Menu_PI_6.getText(), myaccount);
		
		
		
		
		WebElement Menu_PI_6 =GWait.Wait_GetElementByLinkText("My Account");
		Menu_PI_6.click();
		
		Assert.assertEquals(Menu_PI_7.getText(), myprofile);
		
		Assert.assertEquals(Menu_PI_8.getText(), changepassword);
		
		Assert.assertEquals(menu_mem_1.getText(), projectforreview);
	
		Assert.assertEquals(menu_mem_2.getText(), assignedprjcts);
		
		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();
		
		
		WebElement logo2 = GWait.Wait_GetElementByCSS("img");
		logo2.click();
		
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
		
		sheet.getRow(85).createCell(4).setCellValue("Pass");
		sheet.getRow(85).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(85).createCell(4).setCellValue("Fail");
			sheet.getRow(85).getCell(4).setCellStyle(style);
			
			sheet.getRow(85).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(85).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

		
    }
    
   

}
