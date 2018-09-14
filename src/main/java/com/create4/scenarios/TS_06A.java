package com.create4.scenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;
import com.thoughtworks.selenium.webdriven.commands.MethodDeclaration;

import jxl.Sheet;
import jxl.Workbook;
import net.sourceforge.htmlunit.corejs.javascript.ast.TryStatement;

//***Check for Add SOP with valid/Invalid data(After creation should display in the CReATE Institution home page)***//
public class TS_06A {

	public TS_06A() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}
	
	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	// Web locators for CRe4_855

	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[2]/a")
	WebElement Manage_Items;

	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a")
	WebElement Insts;

	@FindBy(xpath = "//*[@id='accordion']/li[2]/div/a")
	WebElement createins;

	@FindBy(linkText = "Manage IEC")
	WebElement ManageIEClink;

	@FindBy(linkText = "SOP")
	WebElement SOPlink;

	@FindBy(css = "h3")
	WebElement SOPListsHeading;

	// Web locators for CRe4_876

	@FindBy(linkText = "Add SOP")
	WebElement AddSOPLink;

	@FindBy(css = "h3")
	WebElement createSOPLink;

	// Web locators for CRe4_877

	@FindBy(xpath = "//form[@id='soplist']/div/label")
	WebElement SOPTitle;

	@FindBy(xpath = "//form[@id='soplist']/div[2]/label")
	WebElement SOPVersion;

	@FindBy(xpath = "//form[@id='soplist']/div[3]/label")
	WebElement SOPDateEffectFrom;

	@FindBy(xpath = "//form[@id='soplist']/div[4]/label")
	WebElement SOPDescription;

	@FindBy(xpath = "//form[@id='soplist']/div[5]/label")
	WebElement SOPUploadDocuments;

	@FindBy(id = "sopcreate")
	WebElement SOPSubmitButton;

	// Web locators for CRe4_878

	@FindBy(xpath = "//form[@id='soplist']/div[1]/div/small")
	WebElement TitleErr;

	@FindBy(xpath = "//form[@id='soplist']/div[2]/div/small")
	WebElement VersionErr;

	@FindBy(xpath = "//form[@id='soplist']/div[3]/div/div/small[2]")
	WebElement DateEffectFromErr;

	@FindBy(xpath = ".//*[@id='soplist']/div[4]/div/small")
	WebElement DescriptionErr;

	@FindBy(xpath = ".//*[@id='soplist']/div[5]/div/small[2]")
	WebElement UploadSOPErr;

	// Web locators for CRe4_880

	@FindBy(id = "sop_title")
	WebElement TitleTextbox;

	@FindBy(id = "sop_version")
	WebElement VersionTextbox;

	@FindBy(xpath = "//div[3]/form/div[3]/div/div/div/input")
	WebElement DateEffectFromTextbox;

	@FindBy(id = "desc")
	WebElement DescriptionTextbox;

	// Web locators for CRe4_881

	@FindBy(id = "upload_sop")
	WebElement UploadSOPTextbox;

	// Web locators for CRe4_882

	@FindBy(xpath = ".//*[@id='soplist']/div[5]/div/small[1]")
	WebElement InvalidFileUplErrormessage;

	// Web locators for CRe4_883

	@FindBy(xpath = "//p")
	WebElement AddSopAckmessage;

	// Web locators for CRe4_884

	@FindBy(xpath = ".//*[@id='soplist']/div[5]/div/p")
	WebElement LargeFileUploadErrmessage;

	// Web locators for CRe4_888

	@FindBy(xpath = "//tr[2]/td[4]")
	WebElement ClickDatefromCalender;

	//

	@FindBy(xpath = "html/body/div[9]/div[1]/table/thead/tr[1]/th[2]")
	List<WebElement> TableHeader;

	@FindBy(xpath = "html/body/div[9]/div[1]/table/thead/tr[1]/th[3]")
	WebElement ForwardSym;

	@FindBy(linkText = "Logout")
	WebElement LogoutLink;

	@FindBy(xpath = "//img[contains(@src,'https://createstagenew.quad1test.com/images/logo.jpg')]")
	WebElement CreateLogo;
	
	//------------Check for 'SOP' link in Manage IEC --------------//

	public void CRe4_855() throws Exception {


	
			GlobalMethods.Admin_Login();
			WebElement ManageIEClink1 = GWait.Wait_GetElementByLinkText("Manage IEC");
			
			try {
				if (ManageIEClink1.isDisplayed()) {
					ManageIEClink1.click();
					WebElement SOPlink = GWait.Wait_GetElementByLinkText("SOP");
					SOPlink.click();
					FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
					Workbook wb = Workbook.getWorkbook(fi);
					Sheet r1 = wb.getSheet("SOP");
					String SOPListText = r1.getCell(2, 1).getContents();
					WebElement SOPListsHeading = GWait.Wait_GetElementByCSS("h3");
					Assert.assertEquals(SOPListsHeading.getText(), SOPListText);
					GlobalMethods.Screenshot("CRe4_855");
				
					
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
					
					sheet.getRow(1).createCell(4).setCellValue("Pass");
					sheet.getRow(1).getCell(4).setCellStyle(style);
					
					FileOutputStream output = new FileOutputStream(source);
					wb11.write(output);
					wb11.close();
				}
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
			
			
				
	
	
	//-----------Check for 'Add SOP'-------------------//
	
	public void CRe4_876() throws Exception {

		
			GlobalMethods.Admin_Login();
			WebElement ManageIEClink2 = GWait.Wait_GetElementByLinkText("Manage IEC");
			try {
				
			
			if (ManageIEClink2.isDisplayed()) {
			ManageIEClink2.click();
			WebElement SOPlink = GWait.Wait_GetElementByLinkText("SOP");
			SOPlink.click();
			WebElement AddSOPLink = GWait.Wait_GetElementByLinkText("Add SOP");
			AddSOPLink.click();
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("SOP");
			String createSOPText = r1.getCell(2, 3).getContents();
			WebElement createSOPLink = GWait.Wait_GetElementByCSS("h3");
			Thread.sleep(4000);
			String ss1 = createSOPLink.getText();
			Assert.assertEquals(ss1, createSOPText);
			
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
			
			sheet.getRow(2).createCell(4).setCellValue("Pass");
			sheet.getRow(2).getCell(4).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
		}
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
	//-----------Check for elements in 'Add new sop' form-------------------//

	public void CRe4_877() throws Exception {

		
			GlobalMethods.Admin_Login();
			WebElement ManageIEClink3 = GWait.Wait_GetElementByLinkText("Manage IEC");
			
			try{
			if (ManageIEClink3.isDisplayed()) {
				
			
			ManageIEClink3.click();
			WebElement createSOPLink = GWait.Wait_GetElementByLinkText("SOP");
			createSOPLink.click();
			WebElement AddSOPLink = GWait.Wait_GetElementByLinkText("Add SOP");
			AddSOPLink.click();
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("SOP");
			String SopTitleExc = r1.getCell(2, 5).getContents();
			String SopVersionExc = r1.getCell(3, 5).getContents();
			String SopDateEffectFromExc = r1.getCell(4, 5).getContents();
			String SopDescriptionExc = r1.getCell(5, 5).getContents();
			String SopUploadDocumentsExc = r1.getCell(6, 5).getContents();
			String SopsubmitbuttonExc = r1.getCell(7, 5).getContents();
			Assert.assertEquals(SOPTitle.getText(), SopTitleExc);
			Assert.assertEquals(SOPVersion.getText(), SopVersionExc);
			Assert.assertEquals(SOPDateEffectFrom.getText(), SopDateEffectFromExc);
			Assert.assertEquals(SOPDescription.getText(), SopDescriptionExc);
			Assert.assertEquals(SOPUploadDocuments.getText(), SopUploadDocumentsExc);
			Assert.assertEquals(SOPSubmitButton.getAttribute("value"),SopsubmitbuttonExc);
			
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
			
			sheet.getRow(3).createCell(4).setCellValue("Pass");
			sheet.getRow(3).getCell(4).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
		}
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
	
	//----------------Check for 'Add SOP' form mandatory fields----------//

	public void CRe4_878() throws Exception {

		
			GlobalMethods.Admin_Login();
			WebElement ManageIEClink4 = GWait.Wait_GetElementByLinkText("Manage IEC");
			
			try{
			if (ManageIEClink4.isDisplayed()) {
				
			
			ManageIEClink4.click();
			SOPlink.click();
			WebElement AddSOPLink = GWait.Wait_GetElementByLinkText("Add SOP");
			AddSOPLink.click();
			WebElement SOPSubmitButton1 = GWait.Wait_GetElementById("sopcreate");
			SOPSubmitButton1.click();
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("SOP");
			String TitleErrExc = r1.getCell(2, 7).getContents();
			String VersionErrExc = r1.getCell(3, 7).getContents();
			String DateEffectFromErrExc = r1.getCell(4, 7).getContents();
			String DescriptionErrExc = r1.getCell(5, 7).getContents();
			String UploadSOPErrExc = r1.getCell(6, 7).getContents();
			Assert.assertEquals(TitleErr.getText(), TitleErrExc);
			Assert.assertEquals(VersionErr.getText(), VersionErrExc);
			Assert.assertEquals(DateEffectFromErr.getText(), DateEffectFromErrExc);
			Assert.assertEquals(DescriptionErr.getText(), DescriptionErrExc);
			Assert.assertEquals(UploadSOPErr.getText(), UploadSOPErrExc);
			
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
			
			sheet.getRow(4).createCell(4).setCellValue("Pass");
			sheet.getRow(4).getCell(4).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
		}
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
	
	//------------Check for 'Add sop' form submission with no file upload--------------//

	public void CRe4_880() throws Exception {

		
			GlobalMethods.Admin_Login();
			WebElement ManageIEClink5 = GWait.Wait_GetElementByLinkText("Manage IEC");
			
			try {
			
			if (ManageIEClink5.isDisplayed()) {
				
			
			ManageIEClink5.click();
			SOPlink.click();
			WebElement AddSOPLink = GWait.Wait_GetElementByLinkText("Add SOP");
			AddSOPLink.click();
			WebElement SOPSubmitButton2 = GWait.Wait_GetElementById("sopcreate");
			SOPSubmitButton2.click();
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("SOP");
			String TitleTextboxExc = r1.getCell(2, 9).getContents();
			String VersionTextboxExc = r1.getCell(3, 9).getContents();
			String DateEffectFromTextboxExc = r1.getCell(4, 9).getContents();
			String DescriptionTextboxExc = r1.getCell(5, 9).getContents();
			String UploadSOPErrExc = r1.getCell(6, 7).getContents();
			TitleTextbox.sendKeys(TitleTextboxExc);
			VersionTextbox.sendKeys(VersionTextboxExc);
			DateEffectFromTextbox.sendKeys(DateEffectFromTextboxExc);
			DescriptionTextbox.sendKeys(DescriptionTextboxExc);
			WebElement SOPSubmitButton3 = GWait.Wait_GetElementById("sopcreate");
			SOPSubmitButton3.click();
			WebElement UploadSOPErr = GWait.Wait_GetElementByXpath(".//*[@id='soplist']/div[5]/div/small[2]");
			Assert.assertEquals(UploadSOPErr.getText(), UploadSOPErrExc);
			
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
			
			sheet.getRow(5).createCell(4).setCellValue("Pass");
			sheet.getRow(5).getCell(4).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
		}
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
	
	//---------------Check for 'Add sop' form submission with only file upload------------//

	public void CRe4_881() throws Exception {
		
			GlobalMethods.Admin_Login();
			WebElement ManageIEClink6 = GWait.Wait_GetElementByLinkText("Manage IEC");
			
			try{
			if (ManageIEClink6.isDisplayed()) {
				
			
			ManageIEClink6.click();
			SOPlink.click();
			WebElement AddSOPLink = GWait.Wait_GetElementByLinkText("Add SOP");
			AddSOPLink.click();
			WebElement SOPSubmitButton4 = GWait.Wait_GetElementById("sopcreate");
			SOPSubmitButton4.click();
			WebElement UploadSOPTextbox = GWait.Wait_GetElementById("upload_sop");
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("SOP");
			String FileUploadPath = r1.getCell(2, 11).getContents();
			String TitleErrExc = r1.getCell(3, 11).getContents();
			String VersionErrExc = r1.getCell(4, 11).getContents();
			String DateEffectFromErrExc = r1.getCell(5, 11).getContents();
			String DescriptionErrExc = r1.getCell(6, 11).getContents();
			UploadSOPTextbox.sendKeys(FileUploadPath);
			WebElement SOPSubmitButton5 = GWait.Wait_GetElementById("sopcreate");
			SOPSubmitButton5.click();
			WebElement TitleErr = GWait.Wait_GetElementByXpath("//form[@id='soplist']/div[1]/div/small");
			Assert.assertEquals(TitleErr.getText(), TitleErrExc);
			Assert.assertEquals(VersionErr.getText(), VersionErrExc);
			Assert.assertEquals(DateEffectFromErr.getText(), DateEffectFromErrExc);
			Assert.assertEquals(DescriptionErr.getText(), DescriptionErrExc);
			
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
			
			sheet.getRow(6).createCell(4).setCellValue("Pass");
			sheet.getRow(6).getCell(4).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
		}
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
	
	//--------------Check for upload document with invalid formats in add sop form-----------//

	public void CRe4_882() throws Exception {
		
			GlobalMethods.Admin_Login();
			WebElement ManageIEClink7 = GWait.Wait_GetElementByLinkText("Manage IEC");
			
			try{
			if (ManageIEClink7.isDisplayed()) {
				
			
			ManageIEClink7.click();
			SOPlink.click();
			WebElement AddSOPLink = GWait.Wait_GetElementByLinkText("Add SOP");
			AddSOPLink.click();
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("SOP");
			String TitleTextboxExc = r1.getCell(2, 13).getContents();
			String VersionTextboxExc = r1.getCell(3, 13).getContents();
			String DateEffectFromTextboxExc = r1.getCell(4, 13).getContents();
			String DescriptionTextboxExc = r1.getCell(5, 13).getContents();
			String UploadSOPJPGExc = r1.getCell(6, 13).getContents();
			String UploadSOPGIFExc = r1.getCell(8, 13).getContents();
			String UploadSOPPNGExc = r1.getCell(9, 13).getContents();
			String UploadSOPBMPExc = r1.getCell(10, 13).getContents();
			String UploadSOPXLSExc = r1.getCell(11, 13).getContents();
			String UploadSOPXLSXExc = r1.getCell(12, 13).getContents();

			String InvalidFileUploadErrorMessage = r1.getCell(7, 13).getContents();
			TitleTextbox.sendKeys(TitleTextboxExc);
			WebElement VersionTextbox = GWait.Wait_GetElementById("sop_version");
			VersionTextbox.sendKeys(VersionTextboxExc);
			WebElement DateEffectFromTextbox = GWait.Wait_GetElementByXpath("//div[3]/form/div[3]/div/div/div/input");
			DateEffectFromTextbox.sendKeys("06-11-2016");
			WebElement DescriptionTextbox = GWait.Wait_GetElementById("desc");
			DescriptionTextbox.sendKeys(DescriptionTextboxExc);
			WebElement UploadSOPTextbox = GWait.Wait_GetElementById("upload_sop");
		    UploadSOPTextbox.sendKeys(UploadSOPJPGExc);
			WebElement SOPSubmitButton6 = GWait.Wait_GetElementById("sopcreate");
			SOPSubmitButton6.click();
			WebElement InvalidFileUplErrormessage = GWait.Wait_GetElementByXpath(".//*[@id='soplist']/div[5]/div/small[1]");
			System.out.println(InvalidFileUplErrormessage.getText());
			Assert.assertEquals(InvalidFileUplErrormessage.getText(),InvalidFileUploadErrorMessage);
			UploadSOPTextbox.sendKeys(UploadSOPGIFExc);
			WebElement SOPSubmitButton7 = GWait.Wait_GetElementById("sopcreate");
			SOPSubmitButton7.click();
			System.out.println(InvalidFileUplErrormessage.getText());
			Assert.assertEquals(InvalidFileUplErrormessage.getText(), InvalidFileUploadErrorMessage);
			UploadSOPTextbox.sendKeys(UploadSOPPNGExc);
			WebElement SOPSubmitButton8 = GWait.Wait_GetElementById("sopcreate");
			SOPSubmitButton8.click();
			System.out.println(InvalidFileUplErrormessage.getText());
			Assert.assertEquals(InvalidFileUplErrormessage.getText(), InvalidFileUploadErrorMessage);
			UploadSOPTextbox.sendKeys(UploadSOPBMPExc);
			WebElement SOPSubmitButton9 = GWait.Wait_GetElementById("sopcreate");
			SOPSubmitButton9.click();
			System.out.println(InvalidFileUplErrormessage.getText());
			//Need to check the error at below assert text
			Assert.assertEquals(InvalidFileUplErrormessage.getText(), InvalidFileUploadErrorMessage);
			UploadSOPTextbox.sendKeys(UploadSOPXLSExc);
			WebElement SOPSubmitButton10 = GWait.Wait_GetElementById("sopcreate");
			SOPSubmitButton10.click();
			System.out.println(InvalidFileUplErrormessage.getText());
			Assert.assertEquals(InvalidFileUplErrormessage.getText(), InvalidFileUploadErrorMessage);
			UploadSOPTextbox.sendKeys(UploadSOPXLSXExc);
			WebElement SOPSubmitButton11 = GWait.Wait_GetElementById("sopcreate");
			SOPSubmitButton11.click();
			System.out.println(InvalidFileUplErrormessage.getText());
			Assert.assertEquals(InvalidFileUplErrormessage.getText(), InvalidFileUploadErrorMessage);
			
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
			
			sheet.getRow(7).createCell(4).setCellValue("Pass");
			sheet.getRow(7).getCell(4).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
		}
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
	
	//--------------Check for upload document with valid formats in add sop form------------//

	public void CRe4_883() throws Exception {
		
			GlobalMethods.Admin_Login();
			WebElement ManageIEClink8 = GWait.Wait_GetElementByLinkText("Manage IEC");
			
			Boolean dd = ManageIEClink8.isDisplayed();
			
			try {
if (dd==true) {
					
					
					ManageIEClink8.click();
					SOPlink.click();
					WebElement AddSOPLink = GWait.Wait_GetElementByLinkText("Add SOP");
					AddSOPLink.click();
					FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
					Workbook wb = Workbook.getWorkbook(fi);
					Sheet r1 = wb.getSheet("SOP");
					String TitleTextboxExc1 = r1.getCell(2, 15).getContents();
					String VersionTextboxExc1 = r1.getCell(3, 15).getContents();
					String DateEffectFromTextboxExc1 = r1.getCell(4, 15).getContents();//Need to check the calender selection
					String DescriptionTextboxExc1 = r1.getCell(5, 15).getContents();
					String UploadSOPJPGExc1 = r1.getCell(6, 15).getContents();
					String AddSOPAckMessage1 = r1.getCell(7, 15).getContents();
					String TitleTextboxExc2 = r1.getCell(8, 15).getContents();
					String VersionTextboxExc2 = r1.getCell(9, 15).getContents();
					String DateEffectFromTextboxExc2 = r1.getCell(10, 15).getContents();
					String DescriptionTextboxExc2 = r1.getCell(11, 15).getContents();
					String UploadSOPJPGExc2 = r1.getCell(12, 15).getContents();
					String AddSOPAckMessage2 = r1.getCell(13, 15).getContents();
					String TitleTextboxExc3 = r1.getCell(14, 15).getContents();
					String VersionTextboxExc3 = r1.getCell(15, 15).getContents();
					String DateEffectFromTextboxExc3 = r1.getCell(16, 15).getContents();
					String DescriptionTextboxExc3 = r1.getCell(17, 15).getContents();
					String UploadSOPJPGExc3 = r1.getCell(18, 15).getContents();
					String AddSOPAckMessage3 = r1.getCell(19, 15).getContents();
					
					WebElement TitleTextbox = GWait.Wait_GetElementById("sop_title");
					
					TitleTextbox.sendKeys("TitleTextboxExc1");
					VersionTextbox.sendKeys(VersionTextboxExc1);
					DateEffectFromTextbox.sendKeys("06-11-2016");
					WebElement DescriptionTextbox = GWait.Wait_GetElementById("desc");
					DescriptionTextbox.sendKeys(DescriptionTextboxExc1);
					UploadSOPTextbox.sendKeys(UploadSOPJPGExc1);
					WebElement SOPSubmitButton12 = GWait.Wait_GetElementById("sopcreate");
					SOPSubmitButton12.click();
					
					WebElement AddSopAckmessage = GWait.Wait_GetElementByXpath("//p");
					System.out.println(AddSopAckmessage.getText());
					System.out.println(AddSOPAckMessage1);
					Assert.assertEquals(AddSopAckmessage.getText(), AddSOPAckMessage1);
					
					WebElement AddSOPLink1 = GWait.Wait_GetElementByLinkText("Add SOP");
					AddSOPLink1.click();
					WebElement TitleTextbox1 = GWait.Wait_GetElementById("sop_title");
					TitleTextbox1.sendKeys(TitleTextboxExc2);
					VersionTextbox.sendKeys(VersionTextboxExc2);
					DateEffectFromTextbox.sendKeys("06-11-2016");
					WebElement DescriptionTextbox1 = GWait.Wait_GetElementById("desc");
					DescriptionTextbox1.sendKeys(DescriptionTextboxExc2);
					Thread.sleep(2000);
					WebElement UploadSOPTextbox1 = GWait.Wait_GetElementById("upload_sop");
					UploadSOPTextbox1.sendKeys(UploadSOPJPGExc2);
					Thread.sleep(2000);
					WebElement SOPSubmitButton13 = GWait.Wait_GetElementById("sopcreate");
					SOPSubmitButton13.click();
					
					WebElement AddSopAckmessage1 = GWait.Wait_GetElementByXpath("//p");
					Assert.assertEquals(AddSopAckmessage1.getText(), AddSOPAckMessage2);
					WebElement AddSOPLink2 = GWait.Wait_GetElementByLinkText("Add SOP");
					AddSOPLink2.click();
					WebElement TitleTextbox2 = GWait.Wait_GetElementById("sop_title");
					TitleTextbox2.sendKeys(TitleTextboxExc3);
					VersionTextbox.sendKeys(VersionTextboxExc3);
					DateEffectFromTextbox.sendKeys("06-11-2016");
					WebElement DescriptionTextbox2 = GWait.Wait_GetElementById("desc");
					DescriptionTextbox2.sendKeys(DescriptionTextboxExc3);
					UploadSOPTextbox.sendKeys(UploadSOPJPGExc3);
					WebElement SOPSubmitButton14 = GWait.Wait_GetElementById("sopcreate");
					SOPSubmitButton14.click();
					
					
					WebElement AddSopAckmessage2 = GWait.Wait_GetElementByXpath("//p");
					Assert.assertEquals(AddSopAckmessage2.getText(), AddSOPAckMessage3);
					
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
					
					sheet.getRow(8).createCell(4).setCellValue("Pass");
					sheet.getRow(8).getCell(4).setCellStyle(style);
					
					FileOutputStream output = new FileOutputStream(source);
					wb11.write(output);
					wb11.close();
				}
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
			
			
		

	//----------------Check for upload document with maximum size in add sop form-----------//
	
	public void CRe4_884() throws Exception {
		
			/*GlobalMethods.Admin_Login();//Fail due to issue
			WebElement ManageIEClink9 = GWait.Wait_GetElementByLinkText("Manage IEC");
			ManageIEClink9.click();
			SOPlink.click();
			WebElement AddSOPLink = GWait.Wait_GetElementByLinkText("Add SOP");
			AddSOPLink.click();
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("SOP");
			String Title1TxtboxExc1 = r1.getCell(2, 17).getContents();
			String Version1TxtboxExc1 = r1.getCell(3, 17).getContents();
			String DateEffectFromTxtboxExc1=r1.getCell(4,17).getContents();
			String SOPDesc1TxtboxExc1 = r1.getCell(5, 17).getContents();
			String FileUpload1TxtboxExc1 = r1.getCell(6, 17).getContents();
			String Alert1Exc1 = r1.getCell(7, 17).getContents();
			String Title2TxtboxExc1 = r1.getCell(8, 17).getContents();
			String Version2TxtboxExc1 = r1.getCell(9, 17).getContents();
			String DateEffectFromTxtboxExc2=r1.getCell(10,17).getContents();
			String SOPDesc2TxtboxExc1 = r1.getCell(11, 17).getContents();
			String FileUpload2TxtboxExc1 = r1.getCell(12, 17).getContents();
			String Alert2Exc1 = r1.getCell(13, 17).getContents();
			String Title3TxtboxExc1 = r1.getCell(14, 17).getContents();
			String Version3TxtboxExc1 = r1.getCell(15, 17).getContents();
			String DateEffectFromTxtboxExc3=r1.getCell(16,17).getContents();
			String SOPDesc3TxtboxExc1 = r1.getCell(17, 17).getContents();
			String FileUpload3TxtboxExc1 = r1.getCell(18, 17).getContents();
			String Alert3Exc1 = r1.getCell(19, 17).getContents();
			
			WebElement TitleTextbox = GWait.Wait_GetElementById("sop_title");
			TitleTextbox.sendKeys(Title1TxtboxExc1);
			VersionTextbox.sendKeys(Version1TxtboxExc1);
			DateEffectFromTextbox.sendKeys("06-11-2016");
			WebElement DescriptionTextbox = GWait.Wait_GetElementById("desc");
			DescriptionTextbox.sendKeys(SOPDesc1TxtboxExc1);
			WebElement UploadSOPTextbox1 = GWait.Wait_GetElementById("upload_sop");
			UploadSOPTextbox1.sendKeys(FileUpload1TxtboxExc1);
			WebElement SOPSubmitButton14 = GWait.Wait_GetElementById("sopcreate");
			SOPSubmitButton14.click();
			
			WebElement LargeFileUploadErrmessage1 = GWait.Wait_GetElementByXpath(".//*[@id='soplist']/div[5]/div/p");
			Assert.assertEquals(LargeFileUploadErrmessage1.getText(), Alert1Exc1);
			
			WebElement AddSOPLink2 = GWait.Wait_GetElementByLinkText("Add SOP");
			AddSOPLink2.click();
			TitleTextbox.sendKeys(Title2TxtboxExc1);
			VersionTextbox.sendKeys(Version2TxtboxExc1);
			DateEffectFromTextbox.sendKeys("06-11-2016");
			WebElement DescriptionTextbox1 = GWait.Wait_GetElementById("desc");
			DescriptionTextbox1.sendKeys(SOPDesc2TxtboxExc1);
			UploadSOPTextbox.sendKeys(FileUpload2TxtboxExc1);
			WebElement SOPSubmitButton16 = GWait.Wait_GetElementById("sopcreate");
			SOPSubmitButton16.click();
			
			Assert.assertEquals(LargeFileUploadErrmessage.getText(), Alert2Exc1);
			
			WebElement AddSOPLink3 = GWait.Wait_GetElementByLinkText("Add SOP");
			AddSOPLink3.click();
			TitleTextbox.sendKeys(Title3TxtboxExc1);
			VersionTextbox.sendKeys(Version3TxtboxExc1);
			DateEffectFromTextbox.sendKeys("06-11-2016");
			WebElement DescriptionTextbox2 = GWait.Wait_GetElementById("desc");
			DescriptionTextbox2.sendKeys(SOPDesc3TxtboxExc1);
			UploadSOPTextbox.sendKeys(FileUpload3TxtboxExc1);
			WebElement SOPSubmitButton17 = GWait.Wait_GetElementById("sopcreate");
			SOPSubmitButton17.click();*/
			//Assert.assertEquals(LargeFileUploadErrmessage.getText(), Alert3Exc1);
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Results");
		sheet.getRow(9).createCell(4).setCellValue("Current system not showing alert text when uploading 10MB file, so script will be executed when issue is fixed");
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
			
			
			System.out.println("Current system not showing alert text when uploading 10MB file, so script will be executed when issue is fixed");
		
	}

	//----------------Check for 'Add SOP' form submission with manual entry in date effect from---------//
	public void CRe4_887() throws Exception {
		
			GlobalMethods.Admin_Login();
			WebElement ManageIEClink10 = GWait.Wait_GetElementByLinkText("Manage IEC");
			
			try{
			if (ManageIEClink10.isDisplayed()) {
				
			
			ManageIEClink10.click();
			SOPlink.click();
			WebElement AddSOPLink = GWait.Wait_GetElementByLinkText("Add SOP");
			AddSOPLink.click();
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("SOP");
			String TitTextboxExc1 = r1.getCell(2, 19).getContents();
			String VerTextboxExc1 = r1.getCell(3, 19).getContents();
			String DateTextboxExc1=r1.getCell(4,19).getContents();
			String DescriptionExc1 = r1.getCell(5, 19).getContents();
			String UploadExc1 = r1.getCell(6, 19).getContents();
			String SOPAckMessage1 = r1.getCell(7, 19).getContents();
			
			WebElement TitleTextbox = GWait.Wait_GetElementById("sop_title");
			TitleTextbox.sendKeys(TitTextboxExc1);
			VersionTextbox.sendKeys(VerTextboxExc1);
			DateEffectFromTextbox.sendKeys("06-11-2016");
			WebElement DescriptionTextbox = GWait.Wait_GetElementById("desc");
			DescriptionTextbox.sendKeys(DescriptionExc1);
			UploadSOPTextbox.sendKeys(UploadExc1);
			
			WebElement SOPSubmitButton18 = GWait.Wait_GetElementById("sopcreate");
			SOPSubmitButton18.click();
			WebElement AddSopAckmessage = GWait.Wait_GetElementByXpath("//p");
			Assert.assertEquals(AddSopAckmessage.getText(), SOPAckMessage1);
			
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
			
			sheet.getRow(10).createCell(4).setCellValue("Pass");
			sheet.getRow(10).getCell(4).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
		}
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
				
				sheet.getRow(10).createCell(4).setCellValue("Fail");
				sheet.getRow(10).getCell(4).setCellStyle(style);
				
				sheet.getRow(10).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(10).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}

	}
	
	//----------------Check for 'Add SOP' form submission with select calendar date in date effect from----------//

	public void CRe4_888() throws Exception {

		
			GlobalMethods.Admin_Login();
			
			WebElement ManageIEClink11 = GWait.Wait_GetElementByLinkText("Manage IEC");
			
			try{
			if (ManageIEClink11.isDisplayed()) {
				
			
			ManageIEClink11.click();
			SOPlink.click();
			WebElement AddSOPLink = GWait.Wait_GetElementByLinkText("Add SOP");
			AddSOPLink.click();
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("SOP");
			String TitTextboxExc1 = r1.getCell(2, 21).getContents();
			String VerTextboxExc1 = r1.getCell(3, 21).getContents();
			String DescTextboxExc1= r1.getCell(4, 21).getContents();
			String FileUploadExc1= r1.getCell(5, 21).getContents();
			String AckMessgExc1= r1.getCell(6, 21).getContents();
			
			WebElement TitleTextbox = GWait.Wait_GetElementById("sop_title");
			TitleTextbox.sendKeys(TitTextboxExc1);
			VersionTextbox.sendKeys(VerTextboxExc1);
			DateEffectFromTextbox.click();
			ClickDatefromCalender.click();
			String s = DateEffectFromTextbox.getAttribute("value");
			System.out.println(s);
			WebElement DescriptionTextbox = GWait.Wait_GetElementById("desc");
			DescriptionTextbox.sendKeys(DescTextboxExc1);
			UploadSOPTextbox.sendKeys(FileUploadExc1);
			WebElement SOPSubmitButton19 = GWait.Wait_GetElementById("sopcreate");
			SOPSubmitButton19.click();
			
			WebElement AddSopAckmessage = GWait.Wait_GetElementByXpath("//p");
			Assert.assertEquals(AddSopAckmessage.getText(),AckMessgExc1);
					
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
			
			sheet.getRow(11).createCell(4).setCellValue("Pass");
			sheet.getRow(11).getCell(4).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
		}
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
				
				sheet.getRow(11).createCell(4).setCellValue("Fail");
				sheet.getRow(11).getCell(4).setCellStyle(style);
				
				sheet.getRow(11).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(11).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}

	}
	
	//-------------------Check for 'Add SOP' form submission with valid data----------//

	public void CRe4_892() throws Exception {
		
		GlobalMethods.Admin_Login();
		WebElement ManageIEClink12 = GWait.Wait_GetElementByLinkText("Manage IEC");
		try{
		if (ManageIEClink12.isDisplayed()) {
			
			
			ManageIEClink12.click();
			SOPlink.click();
			WebElement AddSOPLink = GWait.Wait_GetElementByLinkText("Add SOP");
			AddSOPLink.click();
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("SOP");
			String TitTextboxExc1 = r1.getCell(2, 23).getContents();
			String VerTextboxExc1 = r1.getCell(3, 23).getContents();
			String DateTextboxExc1 = r1.getCell(4, 23).getContents();
			String DescriptionExc1 = r1.getCell(5, 23).getContents();
			String UploadExc1 = r1.getCell(6, 23).getContents();
			String SOPAckMessage1 = r1.getCell(7, 23).getContents();
			
			WebElement TitleTextbox = GWait.Wait_GetElementById("sop_title");
			TitleTextbox.sendKeys(TitTextboxExc1);
			VersionTextbox.sendKeys(VerTextboxExc1);
			DateEffectFromTextbox.sendKeys("06-11-2016");
			WebElement DescriptionTextbox = GWait.Wait_GetElementById("desc");
			DescriptionTextbox.sendKeys(DescriptionExc1);
			UploadSOPTextbox.sendKeys(UploadExc1);
			WebElement SOPSubmitButton20 = GWait.Wait_GetElementById("sopcreate");
			SOPSubmitButton20.click();
			WebElement AddSopAckmessage = GWait.Wait_GetElementByXpath("//p");
			Assert.assertEquals(AddSopAckmessage.getText(), SOPAckMessage1);
		
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
			
			sheet.getRow(12).createCell(4).setCellValue("Pass");
			sheet.getRow(12).getCell(4).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
		}
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


}


