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

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

public class TS_15 {
	public TS_15() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(css = ".col-sm-10.col-xs-12.main-right>h3")
	WebElement Verify_QualificationName;

	@FindBy(id = "add_qualification_name")
	WebElement AddQualifiTextbox;

	@FindBy(css = ".help-block")
	WebElement BlankAlert;

	@FindBy(css = ".bg-success.text-success.col-sm-12.text-center")
	WebElement UpdateQualifiPopuptext;

	@FindBy(css = ".logout")
	WebElement LogOut;

	public void CRe4_924_925_926() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("ManageIEC");

		String ManageQualifi_text = r.getCell(2, 26).getContents();
		String MaxDepart_text = r.getCell(3, 26).getContents();

		WebElement ManageIEC = GWait.Wait_GetElementByXpath("//a[contains(text(),'Manage IEC')]");
		ManageIEC.click();
		WebElement Manage_Qualifi = GWait.Wait_GetElementByXpath("//li[4]/ul/li[5]/a");
		Manage_Qualifi.click();

		System.out.println("Test cases == CRe4_924");
		System.out.println(Verify_QualificationName.getText());
		System.out.println(ManageQualifi_text);
		System.out.println(Verify_QualificationName.getText().equalsIgnoreCase(ManageQualifi_text));
		WebElement EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		EditLink.click();

		// ----------Check for 'Edit' with blank data------//
		System.out.println("Test cases == CRe4_925");
		AddQualifiTextbox.clear();

		WebElement Update_AddQualifi = GWait.Wait_GetElementById("addQualificationButton");
		Update_AddQualifi.click();
		System.out.println(BlankAlert.getText());

		// -------Check for 'Edit' with maximum data--------//
		System.out.println("Test cases == CRe4_926");
		AddQualifiTextbox.sendKeys(MaxDepart_text);
		WebElement Update_AddQualifi1 = GWait.Wait_GetElementById("addQualificationButton");
		Update_AddQualifi1.click();

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		
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
		
		sheet.getRow(57).createCell(4).setCellValue("Pass");
		sheet.getRow(57).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(57).createCell(4).setCellValue("Fail");
			sheet.getRow(57).getCell(4).setCellStyle(style);
			
			sheet.getRow(57).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(57).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	public void CRe4_927() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		System.out.println("Test cases == CRe4_927");
		GlobalMethods.Admin_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("ManageIEC");

		String QualificationData_text = r.getCell(2, 28).getContents();

		WebElement ManageIEC = GWait.Wait_GetElementByXpath("//a[contains(text(),'Manage IEC')]");
		ManageIEC.click();
		WebElement Manage_Qualifi = GWait.Wait_GetElementByXpath("//li[4]/ul/li[5]/a");
		Manage_Qualifi.click();

		WebElement EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		EditLink.click();

		// -------Check for update Qualification--//
		System.out.println("Check for update Qualification");
		AddQualifiTextbox.clear();
		AddQualifiTextbox.sendKeys(QualificationData_text);
		
		WebElement Update_AddQualifi2 = GWait.Wait_GetElementById("addQualificationButton");
		Update_AddQualifi2.click();
		System.out.println(UpdateQualifiPopuptext.getText());
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		
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
		
		sheet.getRow(58).createCell(4).setCellValue("Pass");
		sheet.getRow(58).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(58).createCell(4).setCellValue("Fail");
			sheet.getRow(58).getCell(4).setCellStyle(style);
			
			sheet.getRow(58).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(58).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

}
