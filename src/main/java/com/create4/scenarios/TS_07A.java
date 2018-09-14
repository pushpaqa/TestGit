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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

//***Check the SOP details View***//
public class TS_07A {
	public TS_07A()
	{
		//this.driver=driver;
		//driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver,this);

	}
	
	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);
	
	// Web locators for CRe4_863
	
	@FindBy(linkText="Manage IEC")
	WebElement ManageIEClink;
	
	@FindBy(linkText="SOP")
	WebElement SOPlink;
	
	@FindBy(xpath="//td[8]/a/span")
	WebElement ViewIcon;

	@FindBy(linkText="Add SOP")
	WebElement AddSOPLink;
	
	@FindBy(id="sop_title")
	WebElement TitleTextbox;
	
	@FindBy(id="sop_version")
	WebElement VersionTextbox;
	
	@FindBy(xpath="//div[3]/form/div[3]/div/div/div/input")
	WebElement DateEffectFromTextbox;
	
	@FindBy(id="desc")
	WebElement DescriptionTextbox;
	
	@FindBy(id="upload_sop")
	WebElement UploadSOPTextbox;
	
	@FindBy(xpath="//p")
	WebElement AddSopAckmessage;
	
	@FindBy(id="sopcreate")
	WebElement SOPSubmitButton;
	
	@FindBy(xpath="//form[@id='soplist']/div/label")
	WebElement TitleLabelinEdit;
	
	@FindBy(xpath="//form[@id='soplist']/div[2]/label")
	WebElement VersionLabelinEdit;
	
	@FindBy(xpath="//form[@id='soplist']/div[3]/label")
	WebElement DateLabelinEdit;
	
	@FindBy(xpath="//form[@id='soplist']/div[4]/label")
	WebElement DescriptionLabelinEdit;
	
	@FindBy(xpath="//form[@id='soplist']/div[5]/label")
	WebElement Upload;
	
	@FindBy(xpath="//form[@id='soplist']/div/div")
	WebElement TitleinEdit;
	
	@FindBy(xpath="//form[@id='soplist']/div[2]/div")
	WebElement VersioninEdit;
	
	@FindBy(xpath="//form[@id='soplist']/div[3]/div")
	WebElement DateinEdit;
	
	@FindBy(xpath="//form[@id='soplist']/div[4]/div")
	WebElement DescriptioninEdit;
	
	@FindBy(id="pdf")
	WebElement UploadEdit;
	
	//------------Check for 'View' link functionality----------------//
	
	public void CRe4_863() throws Exception
	{
		
		try{
			GlobalMethods.Admin_Login();
			WebElement ManageIEClink11 = GWait.Wait_GetElementByLinkText("Manage IEC");
			ManageIEClink11.click();
			SOPlink.click();
			WebElement AddSOPLink = GWait.Wait_GetElementByLinkText("Add SOP");
			AddSOPLink.click();
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("SOP");
			
			String TitTextboxExc1=r1.getCell(2,25).getContents();
			String VerTextboxExc1=r1.getCell(3,25).getContents();
			String DescriptionExc1=r1.getCell(5,25).getContents();
			String UploadExc1=r1.getCell(6,25).getContents();
			String SOPAckMessage1=r1.getCell(7,25).getContents();
			
			WebElement TitleTextbox = GWait.Wait_GetElementById("sop_title");
			TitleTextbox.sendKeys(TitTextboxExc1);
			VersionTextbox.sendKeys(VerTextboxExc1);
			DateEffectFromTextbox.sendKeys("06-11-2016");
			WebElement DescriptionTextbox = GWait.Wait_GetElementById("desc");
			DescriptionTextbox.sendKeys(DescriptionExc1);
			WebElement UploadSOPTextbox14 = GWait.Wait_GetElementById("upload_sop");
			UploadSOPTextbox14.sendKeys(UploadExc1);
			WebElement SOPSubmitButton14 = GWait.Wait_GetElementById("sopcreate");
			SOPSubmitButton14.click();
			WebElement AddSopAckmessage = GWait.Wait_GetElementByXpath("//p");
			Assert.assertEquals(AddSopAckmessage.getText(), SOPAckMessage1);
			WebElement ViewIcon = GWait.Wait_GetElementByXpath("//td[8]/a/span");
			ViewIcon.click();
			
			String TitleLabelExc1=r1.getCell(8,25).getContents();
			String VersionLabelExc1=r1.getCell(9,25).getContents();
			String DateEffectLabelExc1=r1.getCell(10,25).getContents();
			String DescriptionLabelExc1=r1.getCell(11,25).getContents();
			String UploadLabelExc1=r1.getCell(12,25).getContents();
			String TitleEditExc1=r1.getCell(13,25).getContents();
			String VersionEditExc1=r1.getCell(14,25).getContents();
			String DateEffectEditExc1=r1.getCell(15,25).getContents();
			String DescriptionEditExc1=r1.getCell(16,25).getContents();
			String UploadEditExc1=r1.getCell(17,25).getContents();
			
			WebElement TitleLabelinEdit = GWait.Wait_GetElementByXpath("//form[@id='soplist']/div/label");
			Assert.assertEquals(TitleLabelinEdit.getText(),TitleLabelExc1 );
			Assert.assertEquals(VersionLabelinEdit.getText(),VersionLabelExc1 );
			Assert.assertEquals(DateLabelinEdit.getText(),DateEffectLabelExc1 );
			Assert.assertEquals(DescriptionLabelinEdit.getText(),DescriptionLabelExc1);
			Assert.assertEquals(Upload.getText(),UploadLabelExc1);
			
			Assert.assertEquals(TitleinEdit.getText(),TitleEditExc1);
			Assert.assertEquals(VersioninEdit.getText(),VersionEditExc1);
			//Assert.assertEquals(DateinEdit.getText().trim(),DateEffectEditExc1);
			Assert.assertEquals(DescriptioninEdit.getText(),DescriptionEditExc1);
			System.out.println(UploadEdit.getText().substring(0,7));
			Assert.assertEquals(UploadEdit.getText().substring(0,7).trim(),UploadEditExc1);
		
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
					
				
				HSSFSheet sheet=wb11.getSheet("Executionfile2");
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
	
	//-------------Check for download file in view sop page----------------//
	
	public void CRe4_864() throws Exception
	{
		
		try{
			GlobalMethods.Admin_Login();
			WebElement ManageIEClink12 = GWait.Wait_GetElementByLinkText("Manage IEC");
			ManageIEClink12.click();
			SOPlink.click();
			WebElement AddSOPLink12 = GWait.Wait_GetElementByLinkText("Add SOP");
			AddSOPLink12.click();
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("SOP");
			
			String TitTextboxExc1=r1.getCell(2,27).getContents();
			String VerTextboxExc1=r1.getCell(3,27).getContents();
			String DescriptionExc1=r1.getCell(5,27).getContents();
			String UploadExc1=r1.getCell(6,27).getContents();
			String SOPAckMessage1=r1.getCell(7,27).getContents();
			WebElement TitleTextbox12 = GWait.Wait_GetElementById("sop_title");
			TitleTextbox12.sendKeys(TitTextboxExc1);
			VersionTextbox.sendKeys(VerTextboxExc1);
			DateEffectFromTextbox.sendKeys("06-11-2016");
			WebElement DescriptionTextbox12 = GWait.Wait_GetElementById("desc");
			DescriptionTextbox12.sendKeys(DescriptionExc1);
			UploadSOPTextbox.sendKeys(UploadExc1);
			SOPSubmitButton.click();
			WebElement AddSopAckmessage15 = GWait.Wait_GetElementByXpath("//p");
			System.out.println(AddSopAckmessage15.getText());
			System.out.println(SOPAckMessage1);
			Assert.assertEquals(AddSopAckmessage15.getText(), SOPAckMessage1);
			WebElement ViewIcon12 = GWait.Wait_GetElementByXpath("//td[8]/a/span");
			ViewIcon12.click();
			WebElement UploadEdit = GWait.Wait_GetElementById("pdf");
			UploadEdit.click();
			//Download functionality should be there
			GlobalMethods.AcceptDoenloadPopup();
			
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
					
				
				HSSFSheet sheet=wb11.getSheet("Executionfile2");
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
	
	
}
