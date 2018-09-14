package com.create4.scenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

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
 * Check for add announcement functionality
 */
public class TS_35 {

	public TS_35() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}
GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(linkText = "Announcements")
	WebElement Link_Announcements;

	@FindBy(linkText = "Add Announcement")
	WebElement manage_add_announcement;

	@FindBy(id = "add_announcement_title")
	WebElement manage_add_announcement_title;

	@FindBy(id = "add_announcement_description")
	WebElement manage_add_announcement_description;

	@FindBy(id = "add_announcement_notification_date")
	WebElement manage_add_announcement_notification_date;

	@FindBy(id = "add_announcement_notification_file_1")
	WebElement manage_add_announcement_notification_file_1;

	@FindBy(id = "add_announcement_notification_file_2")
	WebElement manage_add_announcement_notification_file_2;

	@FindBy(id = "add_more_announcement_button")
	WebElement manage_add_more_announcement_button;

	@FindBy(id = "add_announcement_notification_details")
	WebElement manage_add_announcement_notification_details;

	@FindBy(xpath = "//form[@id='manageannouncementlist']/div/p")
	WebElement manage_acknowledge;

	@FindBy(css = "span.fa.fa-edit")
	WebElement manage_announcement_edit;

	@FindBy(xpath = "//span[3]/a")
	WebElement logoutt;

	@FindBy(css = "img")
	WebElement logo;

	@FindBy(xpath = "//form[@id='add_announcement']/div/div/div/div/label")
	WebElement title_field;

	@FindBy(xpath = "//form[@id='add_announcement']/div/div/div[2]/div/label")
	WebElement desc_field;

	@FindBy(xpath = "//form[@id='add_announcement']/div/div/div[3]/div/label")
	WebElement date_field;

	@FindBy(id = "add_more_announcement_button")
	WebElement addmore_field;

	@FindBy(xpath = "//form[@id='edit_announcement']/div/div/div/div/div/small")
	WebElement title_alert;

	@FindBy(xpath = "//form[@id='edit_announcement']/div/div/div[3]/div/div/small")
	WebElement date_alert;

	@FindBy(xpath = "//form[@id='add_announcement']/div/div/div[4]/div[2]/div/div[2]/a/i")
	WebElement annouce_file_delete;

	@FindBy(css = "a > span")
	WebElement annouce_Home;

	@FindBy(linkText = "My IEC")
	WebElement Mem_Menu;

	@FindBy(css = "td.word-wrap")
	WebElement announce_mem_login;

	@FindBy(xpath = "// div[4]/div[3]/div/div")
	WebElement announce_file_view;

	@FindBy(css = "span.fa.fa-eye")
	WebElement announce_file_view_link;

	// Check for Add announcement link
	public void CRe4_1145() throws Exception {
		
		try{

		GlobalMethods.MS_Login();
		
		
		WebElement Link_Announcements =GWait.Wait_GetElementByLinkText("Announcements");
		Link_Announcements.click();

		
		WebElement manage_add_announcement =GWait.Wait_GetElementByLinkText("Add Announcement");
		manage_add_announcement.click();
		
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
		
		sheet.getRow(188).createCell(4).setCellValue("Pass");
		sheet.getRow(188).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(188).createCell(4).setCellValue("Fail");
			sheet.getRow(188).getCell(4).setCellStyle(style);
			
			sheet.getRow(188).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(188).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
		

	}

	// Check for 'Add new announcement' form fields
	public void CRe4_1146() throws Exception {
		
		try{

		GlobalMethods.MS_Login();
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("ManageIEC");

		String announcefield_title = r1.getCell(2, 208).getContents();
		String announcefield_desc = r1.getCell(3, 208).getContents();
		String announcefield_date = r1.getCell(4, 208).getContents();
		String announcefield_addmore = r1.getCell(5, 208).getContents();

		WebElement Link_Announcements =GWait.Wait_GetElementByLinkText("Announcements");
		Link_Announcements.click();

		
		WebElement manage_add_announcement =GWait.Wait_GetElementByLinkText("Add Announcement");
		manage_add_announcement.click();

		Assert.assertEquals(title_field.getText(), announcefield_title);
		  
		Assert.assertEquals(desc_field.getText(), announcefield_desc);

		Assert.assertEquals(date_field.getText(), announcefield_date);

		Assert.assertEquals(addmore_field.getText(), announcefield_addmore);

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
		
		sheet.getRow(189).createCell(4).setCellValue("Pass");
		sheet.getRow(189).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(189).createCell(4).setCellValue("Fail");
			sheet.getRow(189).getCell(4).setCellStyle(style);
			
			sheet.getRow(189).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(189).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// Check for form submission with blank data
	public void CRe4_1147_48() throws Exception {
		
		try{
		Thread.sleep(2000);
		GlobalMethods.MS_Login();
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("ManageIEC");

		String announce_title = r1.getCell(2, 210).getContents();
		String announce_desc = r1.getCell(3, 210).getContents();
		String announce_file = r1.getCell(4, 210).getContents();
		String announce_date = r1.getCell(5, 210).getContents();
		String announce_acknowledge = r1.getCell(6, 210).getContents();
		
		String announce_titlealert = r1.getCell(7, 210).getContents();
		String announce_datealert = r1.getCell(8, 210).getContents();

		WebElement Link_Announcements =GWait.Wait_GetElementByLinkText("Announcements");
		Link_Announcements.click();
		
		WebElement manage_add_announcement =GWait.Wait_GetElementByLinkText("Add Announcement");
		manage_add_announcement.click();

		
		WebElement manage_add_announcement_title =GWait.Wait_GetElementById("add_announcement_title");
		manage_add_announcement_title.sendKeys(announce_title);
		
		
		WebElement manage_add_announcement_description =GWait.Wait_GetElementById("add_announcement_description");
		manage_add_announcement_description.sendKeys(announce_desc);
		
		
		WebElement manage_add_announcement_notification_date =GWait.Wait_GetElementById("add_announcement_notification_date");
		manage_add_announcement_notification_date.sendKeys(announce_date);
		
		
		WebElement manage_add_announcement_notification_file_1 =GWait.Wait_GetElementById("add_announcement_notification_file_1");
		manage_add_announcement_notification_file_1.sendKeys(announce_file);
		
		
		WebElement manage_add_announcement_notification_details =GWait.Wait_GetElementById("add_announcement_notification_details");
		manage_add_announcement_notification_details.click();
		
		Thread.sleep(1000);
		Assert.assertEquals(manage_acknowledge.getText(), announce_acknowledge);
				
		WebElement manage_announcement_edit =GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		manage_announcement_edit.click();
		
		WebElement manage_add_announcement_title1 =GWait.Wait_GetElementById("add_announcement_title");
		manage_add_announcement_title1.clear();
		
		WebElement manage_add_announcement_description1 =GWait.Wait_GetElementById("add_announcement_description");
		manage_add_announcement_description1.clear();
		
		WebElement manage_add_announcement_notification_date1 =GWait.Wait_GetElementById("add_announcement_notification_date");
		manage_add_announcement_notification_date1.clear();
		
		WebElement manage_add_announcement_notification_file_11 =GWait.Wait_GetElementById("add_announcement_notification_file_1");
		manage_add_announcement_notification_file_11.clear();
		
		
		WebElement manage_add_announcement_notification_details1 =GWait.Wait_GetElementById("add_announcement_notification_details");
		manage_add_announcement_notification_details1.click();
		
		Assert.assertEquals(title_alert.getText(), announce_titlealert);
		
		Assert.assertEquals(date_alert.getText(), announce_datealert);

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
		
		sheet.getRow(190).createCell(4).setCellValue("Pass");
		sheet.getRow(190).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(190).createCell(4).setCellValue("Fail");
			sheet.getRow(190).getCell(4).setCellStyle(style);
			
			sheet.getRow(190).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(190).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// Check for form submission with multiple file upload
	public void CRe4_1149_53() throws Exception {
		
		try{
		
		GlobalMethods.MS_Login();
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("ManageIEC");

		String announce_title = r1.getCell(2, 212).getContents();
		String announce_desc = r1.getCell(3, 212).getContents();
		String announce_file = r1.getCell(4, 212).getContents();
		String announce_date = r1.getCell(5, 212).getContents();
		String announce_acknowledge = r1.getCell(6, 212).getContents();

		WebElement Link_Announcements =GWait.Wait_GetElementByLinkText("Announcements");
		Link_Announcements.click();
		
		WebElement manage_add_announcement =GWait.Wait_GetElementByLinkText("Add Announcement");
		manage_add_announcement.click();
		
		WebElement manage_add_announcement_title =GWait.Wait_GetElementById("add_announcement_title");
		manage_add_announcement_title.sendKeys(announce_title);
		
		WebElement manage_add_announcement_description =GWait.Wait_GetElementById("add_announcement_description");
		manage_add_announcement_description.sendKeys(announce_desc);
		
		
		WebElement manage_add_announcement_notification_date =GWait.Wait_GetElementById("add_announcement_notification_date");
		manage_add_announcement_notification_date.sendKeys(announce_date);
		
		WebElement manage_add_announcement_notification_file_1 =GWait.Wait_GetElementById("add_announcement_notification_file_1");
		manage_add_announcement_notification_file_1.sendKeys(announce_file);
		
		
		WebElement manage_add_more_announcement_button =GWait.Wait_GetElementById("add_more_announcement_button");
		manage_add_more_announcement_button.click();
		
				
		WebElement manage_add_announcement_notification_file_2 =GWait.Wait_GetElementById("add_announcement_notification_file_2");
		manage_add_announcement_notification_file_2.sendKeys(announce_file);
		
		
		WebElement manage_add_announcement_notification_details =GWait.Wait_GetElementById("add_announcement_notification_details");
		manage_add_announcement_notification_details.click();
		
		

		Assert.assertEquals(manage_acknowledge.getText(), announce_acknowledge);
		
		
		WebElement announce_file_view_link =GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		announce_file_view_link.click();

		String announce_file_view_1 = announce_file_view.getText();
		System.out.println(announce_file_view_1);

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
		
		sheet.getRow(191).createCell(4).setCellValue("Pass");
		sheet.getRow(191).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(191).createCell(4).setCellValue("Fail");
			sheet.getRow(191).getCell(4).setCellStyle(style);
			
			sheet.getRow(191).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(191).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// Check for delete of add more files
	public void CRe4_1150_51_52() throws Exception {
		
		try{

		Thread.sleep(2000);
		GlobalMethods.MS_Login();
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("ManageIEC");

		String announce_title = r1.getCell(2, 214).getContents();
		String announce_desc = r1.getCell(3, 214).getContents();
		String announce_file = r1.getCell(4, 214).getContents();
		String announce_date = r1.getCell(5, 214).getContents();
		String announce_acknowledge = r1.getCell(6, 214).getContents();

		WebElement Link_Announcements =GWait.Wait_GetElementByLinkText("Announcements");
		Link_Announcements.click();
		
		WebElement manage_add_announcement =GWait.Wait_GetElementByLinkText("Add Announcement");
		manage_add_announcement.click();

		WebElement manage_add_announcement_title =GWait.Wait_GetElementById("add_announcement_title");
		manage_add_announcement_title.sendKeys(announce_title);
		
		WebElement manage_add_announcement_description =GWait.Wait_GetElementById("add_announcement_description");
		manage_add_announcement_description.sendKeys(announce_desc);
		
		WebElement manage_add_announcement_notification_date =GWait.Wait_GetElementById("add_announcement_notification_date");
		manage_add_announcement_notification_date.sendKeys(announce_date);
		
		WebElement manage_add_announcement_notification_file_1 =GWait.Wait_GetElementById("add_announcement_notification_file_1");
		manage_add_announcement_notification_file_1.sendKeys(announce_file);
		
		
		WebElement manage_add_more_announcement_button = GWait.Wait_GetElementById("add_more_announcement_button");
		manage_add_more_announcement_button.click();
		
		WebElement manage_add_announcement_notification_file_2 =GWait.Wait_GetElementById("add_announcement_notification_file_2");
		manage_add_announcement_notification_file_2.sendKeys(announce_file);
		
		WebElement annouce_file_delete =GWait.Wait_GetElementByXpath("//form[@id='add_announcement']/div/div/div[4]/div[2]/div/div[2]/a/i");
		annouce_file_delete.click();
		
		WebElement manage_add_more_announcement_button1 = GWait.Wait_GetElementById("add_more_announcement_button");
		manage_add_more_announcement_button1.click();
		
		WebElement manage_add_announcement_notification_file_22 =GWait.Wait_GetElementById("add_announcement_notification_file_2");
		manage_add_announcement_notification_file_22.sendKeys(announce_file);
		
		
		WebElement manage_add_announcement_notification_details =GWait.Wait_GetElementById("add_announcement_notification_details");
		manage_add_announcement_notification_details.click();

		Assert.assertEquals(manage_acknowledge.getText(), announce_acknowledge);

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		Assert.assertEquals(annouce_Home.getText(), announce_title);
		
		
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();
		
		GlobalMethods.Member1Login();
		
		WebElement Mem_Menu =GWait.Wait_GetElementByLinkText("My IEC");
		Mem_Menu.click();
		
		Assert.assertEquals(announce_mem_login.getText(), announce_title);
		
		WebElement logoutt1 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt1.click();
		
		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();
		
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
		
		sheet.getRow(192).createCell(4).setCellValue("Pass");
		sheet.getRow(192).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(192).createCell(4).setCellValue("Fail");
			sheet.getRow(192).getCell(4).setCellStyle(style);
			
			sheet.getRow(192).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(192).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

}
