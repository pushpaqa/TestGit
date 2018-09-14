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
 * Check for manage announcement list/view
 */
public class TS_34 {

	public TS_34() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}
    GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(linkText = "Announcements")
	WebElement Link_Announcements;

	@FindBy(xpath = "//th[2]/a/span[2]")
	WebElement table_title;

	@FindBy(xpath = "//th[3]/a/span[2]")
	WebElement table_date;

	@FindBy(xpath = "//th[4]/a/span[2]")
	WebElement table_desc;

	@FindBy(xpath = "//th[5]/span")
	WebElement table_actions;

	@FindBy(css = "div.bgand-border.announcement-list > h3")
	WebElement table_listname;

	@FindBy(xpath = "//form[@id='manageannouncementlist']/div/div/label")
	WebElement table_searchtitle;

	@FindBy(xpath = "//form[@id='manageannouncementlist']/div[2]/input")
	WebElement table_buttontext;

	@FindBy(css = "div.panel-heading > a")
	WebElement table_fieldheading1;

	@FindBy(linkText = "Add Announcement")
	WebElement table_fieldheading2;

	@FindBy(xpath = "//span[3]/a")
	WebElement logoutt;

	@FindBy(css = "img")
	WebElement logo;

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

	@FindBy(css = "span.fa.fa-eye")
	WebElement announce_file_view_link;

	@FindBy(css = "td.word-wrap")
	WebElement view_title_table;

	@FindBy(xpath = "//td[3]")
	WebElement view_date_table;

	@FindBy(xpath = "//td[4]")
	WebElement view_status_table;

	// Check for 'Announcements' link
	public void CRe4_1136_37_38() throws Exception {
		
		try{
		
		
		GlobalMethods.MS_Login();
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("ManageIEC");

		String announcetable_title = r1.getCell(2, 216).getContents();
		String announcetable_date = r1.getCell(3, 216).getContents();
		String announcetable_status = r1.getCell(4, 216).getContents();
		String announcetable_action = r1.getCell(5, 216).getContents();
		String announcetable_listname = r1.getCell(6, 216).getContents();
		String announcetable_searchtitle = r1.getCell(7, 216).getContents();
		String announcetable_buttontext = r1.getCell(8, 216).getContents();
		String announcetable_leftheading1 = r1.getCell(9, 216).getContents();
		String announcetable_leftheading2 = r1.getCell(10, 216).getContents();

		WebElement Link_Announcements =GWait.Wait_GetElementByLinkText("Announcements");
		Link_Announcements.click();

		Assert.assertEquals(table_title.getText(), announcetable_title);

		Assert.assertEquals(table_date.getText(), announcetable_date);

		Assert.assertEquals(table_desc.getText(), announcetable_status);

		Assert.assertEquals(table_actions.getText(), announcetable_action);

		Assert.assertEquals(table_listname.getText(), announcetable_listname);

		Assert.assertEquals(table_searchtitle.getText(), announcetable_searchtitle);

		Assert.assertEquals(table_buttontext.getAttribute("value"), announcetable_buttontext);

		Assert.assertEquals(table_fieldheading1.getText(), announcetable_leftheading1);

		Assert.assertEquals(table_fieldheading2.getText(), announcetable_leftheading2);

		

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
		
		sheet.getRow(193).createCell(4).setCellValue("Pass");
		sheet.getRow(193).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(193).createCell(4).setCellValue("Fail");
			sheet.getRow(193).getCell(4).setCellStyle(style);
			
			sheet.getRow(193).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(193).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// Check for 'Title' in list column field
	public void CRe4_1139_to_44() throws Exception {
		
		try{
		
		GlobalMethods.MS_Login();
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("ManageIEC");

		String announce_title = r1.getCell(2, 218).getContents();
		String announce_desc = r1.getCell(3, 218).getContents();
		String announce_file = r1.getCell(4, 218).getContents();
		String announce_date = r1.getCell(5, 218).getContents();
		String announce_acknowledge = r1.getCell(6, 218).getContents();
		String announce_status = r1.getCell(7, 218).getContents();

		WebElement Link_Announcements =GWait.Wait_GetElementByLinkText("Announcements");
		Link_Announcements.click();

		WebElement manage_add_announcement =GWait.Wait_GetElementByLinkText("Add Announcement");
		manage_add_announcement.click();

		manage_add_announcement_title.sendKeys(announce_title);
		manage_add_announcement_description.sendKeys(announce_desc);
		Thread.sleep(2000);
		manage_add_announcement_notification_date.sendKeys(announce_date);
		manage_add_announcement_notification_file_1.sendKeys(announce_file);
		manage_add_more_announcement_button.click();
		manage_add_announcement_notification_file_2.sendKeys(announce_file);
		manage_add_announcement_notification_details.click();

		Assert.assertEquals(manage_acknowledge.getText(), announce_acknowledge);
		
		Assert.assertEquals(view_title_table.getText(), announce_title);

		Assert.assertEquals(view_date_table.getText(), announce_date);

		Assert.assertEquals(view_status_table.getText(), announce_status);

		

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
		
		sheet.getRow(194).createCell(4).setCellValue("Pass");
		sheet.getRow(194).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(194).createCell(4).setCellValue("Fail");
			sheet.getRow(194).getCell(4).setCellStyle(style);
			
			sheet.getRow(194).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(194).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

}
