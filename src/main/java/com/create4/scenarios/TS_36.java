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
 * Check for update announcement functionality
 */
public class TS_36 {
	
	public TS_36() {
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
	
	@FindBy(css = "td.word-wrap")
	WebElement manage_announcement_titlelist;
	
	@FindBy(xpath = "//td[3]")
	WebElement manage_announcement_datelist;
	
	@FindBy(xpath = "//td[4]")
	WebElement manage_announcement_statlist;
	

	
	//Check for edit link in list
	public void CRe4_1154_55() throws Exception {
		
		try{
		
		GlobalMethods.MS_Login();
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("ManageIEC");

		String announce_title = r1.getCell(2, 220).getContents();
		String announce_desc = r1.getCell(3, 220).getContents();
		String announce_file = r1.getCell(4, 220).getContents();
		String announce_date = r1.getCell(5, 220).getContents();
		String announce_acknowledge = r1.getCell(6, 220).getContents();
		
		String announce_title1 = r1.getCell(7, 220).getContents();
		String announce_desc1 = r1.getCell(8, 220).getContents();
		String announce_file1 = r1.getCell(9, 220).getContents();
		String announce_date1 = r1.getCell(10, 220).getContents();
		String announce_acknowledge1 = r1.getCell(11, 220).getContents();
		
		String status = r1.getCell(12, 220).getContents();
		
		WebElement Link_Announcements =GWait.Wait_GetElementByLinkText("Announcements");
		Link_Announcements.click();
		
		WebElement manage_add_announcement =GWait.Wait_GetElementByLinkText("Add Announcement");
		manage_add_announcement.click();
		
		WebElement manage_add_announcement_title2 =GWait.Wait_GetElementById("add_announcement_title");
		manage_add_announcement_title2.sendKeys(announce_title);
		manage_add_announcement_description.sendKeys(announce_desc);
		WebElement manage_add_announcement_notification_date2 =GWait.Wait_GetElementById("add_announcement_notification_date");
		manage_add_announcement_notification_date2.sendKeys(announce_date);
		WebElement manage_add_announcement_notification_file_2 =GWait.Wait_GetElementById("add_announcement_notification_file_1");
		manage_add_announcement_notification_file_2.sendKeys(announce_file);
		WebElement manage_add_announcement_notification_details =GWait.Wait_GetElementById("add_announcement_notification_details");
		manage_add_announcement_notification_details.click();
		
		Assert.assertEquals(manage_acknowledge.getText(), announce_acknowledge);

		
		WebElement manage_announcement_edit =GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		manage_announcement_edit.click();
		
		
		WebElement manage_add_announcement_title =GWait.Wait_GetElementById("add_announcement_title");
		manage_add_announcement_title.clear();
		WebElement manage_add_announcement_title1 =GWait.Wait_GetElementById("add_announcement_title");
		manage_add_announcement_title1.sendKeys(announce_title1);
		manage_add_announcement_description.clear();
		manage_add_announcement_description.sendKeys(announce_desc1);
		
		
		WebElement manage_add_announcement_notification_date =GWait.Wait_GetElementById("add_announcement_notification_date");
		manage_add_announcement_notification_date.clear();
		WebElement manage_add_announcement_notification_date1 =GWait.Wait_GetElementById("add_announcement_notification_date");
		manage_add_announcement_notification_date1.sendKeys(announce_date1);
		
		/*WebElement manage_add_announcement_notification_file_1 =GWait.Wait_GetElementById("add_announcement_notification_file_1");
		manage_add_announcement_notification_file_1.sendKeys(announce_file1);*/
		
		WebElement manage_add_announcement_notification_details1 =GWait.Wait_GetElementById("add_announcement_notification_details");
		manage_add_announcement_notification_details1.click();
		
		Assert.assertEquals(manage_acknowledge.getText(), announce_acknowledge1);
		
		Assert.assertEquals(manage_announcement_titlelist.getText(), announce_title1);
		
		Assert.assertEquals(manage_announcement_datelist.getText(), announce_date1);
		
		Assert.assertEquals(manage_announcement_statlist.getText(), status);

		
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
		
		sheet.getRow(199).createCell(4).setCellValue("Pass");
		sheet.getRow(199).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(199).createCell(4).setCellValue("Fail");
			sheet.getRow(199).getCell(4).setCellStyle(style);
			
			sheet.getRow(199).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(199).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

		
		
	}
	
	

}
