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
 * Check for PI header menu
 */
public class TS_39 {
	
	public TS_39() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

     GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	 Actions action = new Actions(GlobalMethods.driver);
	// PI submit new project page elements

	@FindBy(linkText = "My Projects")
	WebElement PI_project_menu;
	
	@FindBy(xpath = "//ul[@id='accordion']/li/div/a")
	WebElement submenu_projects;
	
	@FindBy(linkText = "Submit New Project")
	WebElement submenu_submitnewproject;
	
	@FindBy(linkText = "Archived Projects")
	WebElement submenu_archivedprojects;
	
	@FindBy(css = "h3.projects-search")
	WebElement list_search;
	
	@FindBy(xpath = "//span[3]/a")
	WebElement logoutt;

	@FindBy(css = "img")
	WebElement logo;
	
	
	//
	public void CRe4_1204() throws Exception {
		
		try{
		
		GlobalMethods.PI_Login();

		
		WebElement PI_project_menu =GWait.Wait_GetElementByLinkText("My Projects");
		PI_project_menu.click();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Projects");
		

		String PI_Menu1 = r1.getCell(2, 13).getContents();
		String PI_Menu2 = r1.getCell(3, 13).getContents();
		String PI_Menu3 = r1.getCell(4, 13).getContents();
		String PI_Menu4 = r1.getCell(5, 13).getContents();
		
		Assert.assertEquals(submenu_projects.getText().trim(), PI_Menu1);
		
		Assert.assertEquals(submenu_submitnewproject.getText().trim(), PI_Menu2);

		Assert.assertEquals(submenu_archivedprojects.getText().trim(), PI_Menu3);
		
		Assert.assertEquals(list_search.getText().trim(), PI_Menu4);
		
		
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
		
		sheet.getRow(88).createCell(4).setCellValue("Pass");
		sheet.getRow(88).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(88).createCell(4).setCellValue("Fail");
			sheet.getRow(88).getCell(4).setCellStyle(style);
			
			sheet.getRow(88).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(88).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}
	
	

}
