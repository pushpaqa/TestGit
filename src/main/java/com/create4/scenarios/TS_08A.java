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

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

//***Check for SOP update functionality (valid/invalid/active/deactive)***//
public class TS_08A {
	public TS_08A()
	{
		//this.driver=driver;
		//driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver,this);

	}
	
	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	// Web locators for CRe4_865

	@FindBy(linkText = "SOP")
	WebElement SOPlink;

	@FindBy(linkText = "Add SOP")
	WebElement AddSOPLink;
	
	@FindBy(linkText = "Manage IEC")
	WebElement ManageIEClink;
	
	@FindBy(id = "sop_title")
	WebElement TitleTextbox;

	@FindBy(id = "sop_version")
	WebElement VersionTextbox;

	@FindBy(xpath = "//div[3]/form/div[3]/div/div/div/input")
	WebElement DateEffectFromTextbox;

	@FindBy(id = "desc")
	WebElement DescriptionTextbox;
	
	@FindBy(id = "upload_sop")
	WebElement UploadSOPTextbox;
	
	@FindBy(id = "sopcreate")
	WebElement SOPSubmitButton;
	
	@FindBy(xpath = "//p")
	WebElement AddSopAckmessage;
	
	@FindBy(xpath = "//a[2]/span")
	WebElement EditIcon;

	@FindBy(xpath = "//h3")
	WebElement UpdateSOPLink;
	
	// Web locators for CRe4_866

	@FindBy(xpath = "//input[@value='Update']")
	WebElement UpdateButton;
	
	@FindBy(xpath = "//form[@id='soplists']/div/div/p")
	WebElement TitleErrinUpdate;

	@FindBy(xpath = "//form[@id='soplists']/div[2]/div/p")
	WebElement VersionErrinUpdate;

	@FindBy(xpath = "//form[@id='soplists']/div[3]/div/p")
	WebElement DateEffectFromErrinUpdate;

	@FindBy(xpath = "//form[@id='soplists']/div[4]/div/p")
	WebElement DescriptionErrinUpdate;

	/*@FindBy(xpath = "//form[@id='soplists']/div[5]/div/p")
	WebElement UploadSOPErrinUpdate;*/

	
	// Web locators for CRe4_867
	
	@FindBy(xpath = "//form[@id='soplists']/div/div/p")
	WebElement TitleInvalidData;
	
	@FindBy(xpath ="//span[@id='lblError']")
	WebElement InvalidFileUploadErr;
	
	@FindBy(xpath ="//form[@id='soplists']/div/div/p")
	WebElement UploadFieldMandatoryinEdit;

	// Web locators for CRe4_868
	
	@FindBy(xpath ="//p")
	WebElement UpdateAckMsg;

	// Web locators for CRe4_869

	@FindBy(xpath ="//td[2]")
	WebElement TitleinList;
	
	@FindBy(xpath ="//td[3]")
	WebElement VersioninList;
	
	@FindBy(xpath ="//td[4]")
	WebElement DescriptioninList;
	
	@FindBy(xpath ="//td[7]")
	WebElement DateEffectFrominList;

	// Web locators for CRe4_870_871_872_873_874_875
	
	@FindBy(linkText ="De-active")
	WebElement DeactiveLink;
	
	@FindBy(xpath ="//p")
	WebElement DeactivationAckMsg;
	
	@FindBy(linkText ="Active /")
	WebElement ActiveLink;
	
	@FindBy(xpath ="//p")
	WebElement ActivationAckMsg;
	
	

	//------------Check for 'View' link functionality----------------//

	public void CRe4_865() throws Exception
	{
		
		try{
		
			GlobalMethods.Admin_Login();
			WebElement ManageIEClinkA = GWait.Wait_GetElementByLinkText("Manage IEC");
			ManageIEClinkA.click();
			SOPlink.click();
			WebElement AddSOPLink = GWait.Wait_GetElementByLinkText("Add SOP");
			AddSOPLink.click();
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("SOP");
			
			String TitTextboxExc1=r1.getCell(2,29).getContents();
			String VerTextboxExc1=r1.getCell(3,29).getContents();
			String DescriptionExc1=r1.getCell(5,29).getContents();
			String UploadExc1=r1.getCell(6,29).getContents();
			String SOPAckMessage1=r1.getCell(7,29).getContents();
			String UpdateSOPHeading=r1.getCell(8,29).getContents();
			WebElement TitleTextboxA = GWait.Wait_GetElementById("sop_title");
			TitleTextboxA.sendKeys(TitTextboxExc1);
			VersionTextbox.sendKeys(VerTextboxExc1);
			DateEffectFromTextbox.sendKeys("06-11-2016");
			WebElement DescriptionTextboxA = GWait.Wait_GetElementById("desc");
			DescriptionTextboxA.sendKeys(DescriptionExc1);
			UploadSOPTextbox.sendKeys(UploadExc1);
			WebElement SOPSubmitButtonA = GWait.Wait_GetElementById("sopcreate");
			SOPSubmitButtonA.click();
			WebElement AddSopAckmessageA = GWait.Wait_GetElementByXpath("//p");
			Assert.assertEquals(AddSopAckmessageA.getText(), SOPAckMessage1);
			WebElement EditIconA = GWait.Wait_GetElementByXpath("//a[2]/span");
			EditIconA.click();
			WebElement UpdateSOPLinkA = GWait.Wait_GetElementByXpath("//h3");
			Thread.sleep(2000);
			System.out.println(UpdateSOPLinkA.getText());
			Assert.assertEquals(UpdateSOPLinkA.getText(),UpdateSOPHeading);
			
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
					
				
				HSSFSheet sheet=wb11.getSheet("Executionfile2");
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

	public void CRe4_866() throws Exception
	{
		
		try{
			GlobalMethods.Admin_Login();
			WebElement ManageIEClinkB = GWait.Wait_GetElementByLinkText("Manage IEC");
			ManageIEClinkB.click();
			SOPlink.click();
			WebElement AddSOPLinkB = GWait.Wait_GetElementByLinkText("Add SOP");
			AddSOPLinkB.click();
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("SOP");
			
			String TitTextboxExc1=r1.getCell(2,31).getContents();
			String VerTextboxExc1=r1.getCell(3,31).getContents();
			String DescriptionExc1=r1.getCell(5,31).getContents();
			String UploadExc1=r1.getCell(6,31).getContents();
			String SOPAckMessage1=r1.getCell(7,31).getContents();
			
			WebElement TitleTextboxB = GWait.Wait_GetElementById("sop_title");
			TitleTextbox.sendKeys(TitTextboxExc1);
			VersionTextbox.sendKeys(VerTextboxExc1);
			DateEffectFromTextbox.sendKeys("06-11-2016");
			WebElement DescriptionTextboxB = GWait.Wait_GetElementById("desc");
			DescriptionTextboxB.sendKeys(DescriptionExc1);
			UploadSOPTextbox.sendKeys(UploadExc1);
			SOPSubmitButton.click();
			
			WebElement AddSopAckmessageB = GWait.Wait_GetElementByXpath("//p");
			Assert.assertEquals(AddSopAckmessageB.getText(), SOPAckMessage1);
			WebElement EditIconB = GWait.Wait_GetElementByXpath("//a[2]/span");
			EditIconB.click();
			WebElement TitleTextboxB1 = GWait.Wait_GetElementById("sop_title");
			TitleTextboxB1.clear();
			VersionTextbox.clear();
			DateEffectFromTextbox.clear();
			DescriptionTextbox.clear();
			UploadSOPTextbox.clear();
			WebElement UpdateButton = GWait.Wait_GetElementByXpath("//input[@value='Update']");
			UpdateButton.click();
			
			String TitleErrExc = r1.getCell(8,31).getContents();
			String VersionErrExc = r1.getCell(9,31).getContents();
			String DateEffectFromErrExc = r1.getCell(10,31).getContents();
			String DescriptionErrExc = r1.getCell(11,31).getContents();
			//String UploadSOPErrExc = r1.getCell(11,31).getContents();

			Assert.assertEquals(TitleErrinUpdate.getText(), TitleErrExc);
			Assert.assertEquals(VersionErrinUpdate.getText(), VersionErrExc);
			Assert.assertEquals(DateEffectFromErrinUpdate.getText(), DateEffectFromErrExc);
			Assert.assertEquals(DescriptionErrinUpdate.getText(), DescriptionErrExc);
			//Assert.assertEquals(UploadSOPErrinUpdate.getText(), UploadSOPErrExc);
		
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
					
				
				HSSFSheet sheet=wb11.getSheet("Executionfile2");
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

	public void CRe4_867() throws Exception
	{
		try{
		
			GlobalMethods.Admin_Login();
			WebElement ManageIEClinkC = GWait.Wait_GetElementByLinkText("Manage IEC");
			ManageIEClinkC.click();
			SOPlink.click();
			WebElement AddSOPLinkC = GWait.Wait_GetElementByLinkText("Add SOP");
			AddSOPLinkC.click();
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("SOP");
			String TitTextboxExc1=r1.getCell(2,33).getContents();
			String VerTextboxExc1=r1.getCell(3,33).getContents();
			String DescriptionExc1=r1.getCell(5,33).getContents();
			String UploadExc1=r1.getCell(6,33).getContents();
			String SOPAckMessage1=r1.getCell(7,33).getContents();
			
			WebElement TitleTextboxC = GWait.Wait_GetElementById("sop_title");
			TitleTextboxC.sendKeys(TitTextboxExc1);
			VersionTextbox.sendKeys(VerTextboxExc1);
			DateEffectFromTextbox.sendKeys("06-11-2016");
			WebElement DescriptionTextboxC = GWait.Wait_GetElementById("desc");
			DescriptionTextboxC.sendKeys(DescriptionExc1);
			UploadSOPTextbox.sendKeys(UploadExc1);
			
			WebElement SOPSubmitButtonc1 = GWait.Wait_GetElementById("sopcreate");
			SOPSubmitButtonc1.click();
			WebElement AddSopAckmessageC = GWait.Wait_GetElementByXpath("//p");
			Assert.assertEquals(AddSopAckmessageC.getText(), SOPAckMessage1);
			WebElement EditIconC = GWait.Wait_GetElementByXpath("//a[2]/span");
			EditIconC.click();
			WebElement TitleTextboxC1 = GWait.Wait_GetElementById("sop_title");
			TitleTextboxC1.clear();
			String DuplicateTitle=r1.getCell(8,33).getContents();
			TitleTextbox.sendKeys(DuplicateTitle);
			UpdateButton.click();
			WebElement TitleInvalidDataC = GWait.Wait_GetElementByXpath("//form[@id='soplists']/div/div/p");
			
			String TitleInvalidDataErr=r1.getCell(9,33).getContents();
			String UploadFieldMandatory = r1.getCell(10,33).getContents();
			
			Assert.assertEquals(TitleInvalidDataC.getText(),TitleInvalidDataErr);
			/*System.out.println(UploadFieldMandatoryinEdit.getText());
			Assert.assertEquals(UploadFieldMandatoryinEdit.getText(),UploadFieldMandatory);*/
			
			/*String FilePathValid=r1.getCell(11,33).getContents();
			UploadSOPTextbox.sendKeys(FilePathValid);
			UpdateButton.click();
			Thread.sleep(2000);*/
			
			String UploadSOPJPGExc = r1.getCell(12,33).getContents();
			String InvalidFileUploadErrorMessage1 = r1.getCell(13,33).getContents();
			String UploadSOPGIFExc = r1.getCell(14,33).getContents();
			String InvalidFileUploadErrorMessage2 = r1.getCell(15,33).getContents();
			String UploadSOPPNGExc = r1.getCell(16,33).getContents();
			String InvalidFileUploadErrorMessage3 = r1.getCell(17,33).getContents();
			String UploadSOPBMPExc = r1.getCell(18, 33).getContents();
			String InvalidFileUploadErrorMessage4 = r1.getCell(19,33).getContents();
			String UploadSOPXLSExc = r1.getCell(20,33).getContents();
			String InvalidFileUploadErrorMessage5 = r1.getCell(21,33).getContents();
			String UploadSOPXLSXExc = r1.getCell(22,33).getContents();
			String InvalidFileUploadErrorMessage6 = r1.getCell(23,33).getContents();
			
			TitleTextbox.clear();
			TitleTextbox.sendKeys(TitTextboxExc1);
			
			UploadSOPTextbox.sendKeys(UploadSOPJPGExc);
			WebElement InvalidFileUploadErrC1 = GWait.Wait_GetElementById("lblError");
			System.out.println(InvalidFileUploadErrC1.getText());
			Assert.assertEquals(InvalidFileUploadErrC1.getText(),InvalidFileUploadErrorMessage1);
			UpdateButton.click();
			WebElement UploadSOPTextboxC1 = GWait.Wait_GetElementById("upload_sop");
			UploadSOPTextboxC1.sendKeys(UploadSOPGIFExc);
			WebElement InvalidFileUploadErrC2 = GWait.Wait_GetElementById("lblError");
			System.out.println(InvalidFileUploadErrC2.getText());
			Assert.assertEquals(InvalidFileUploadErrC2.getText(), InvalidFileUploadErrorMessage2);
			UpdateButton.click();
			
			WebElement UploadSOPTextboxC2 = GWait.Wait_GetElementById("upload_sop");
			UploadSOPTextboxC2.sendKeys(UploadSOPPNGExc);
			WebElement InvalidFileUploadErrC3 = GWait.Wait_GetElementById("lblError");
			System.out.println(InvalidFileUploadErrC3.getText());
			Assert.assertEquals(InvalidFileUploadErrC3.getText(), InvalidFileUploadErrorMessage3);
			UpdateButton.click();
			
			WebElement UploadSOPTextboxC3 = GWait.Wait_GetElementById("upload_sop");
			UploadSOPTextboxC3.sendKeys(UploadSOPBMPExc);
			WebElement InvalidFileUploadErrC4 = GWait.Wait_GetElementById("lblError");
			System.out.println(InvalidFileUploadErrC4.getText());
			Assert.assertEquals(InvalidFileUploadErrC4.getText(), InvalidFileUploadErrorMessage4);
			UpdateButton.click();
			
			WebElement UploadSOPTextboxC4 = GWait.Wait_GetElementById("upload_sop");
			UploadSOPTextboxC4.sendKeys(UploadSOPXLSExc);
			WebElement InvalidFileUploadErrC5 = GWait.Wait_GetElementById("lblError");
			System.out.println(InvalidFileUploadErrC5.getText());
			Assert.assertEquals(InvalidFileUploadErrC5.getText(), InvalidFileUploadErrorMessage5);
			UpdateButton.click();
			
			WebElement UploadSOPTextboxC5 = GWait.Wait_GetElementById("upload_sop");
			UploadSOPTextboxC5.sendKeys(UploadSOPXLSXExc);
			WebElement InvalidFileUploadErrC6 = GWait.Wait_GetElementById("lblError");
			System.out.println(InvalidFileUploadErrC6.getText());
			Assert.assertEquals(InvalidFileUploadErrC6.getText(), InvalidFileUploadErrorMessage6);
			UpdateButton.click();
			
		
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
			
			sheet.getRow(21).createCell(4).setCellValue("Pass");
			sheet.getRow(21).getCell(4).setCellStyle(style);
			
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
				
				sheet.getRow(21).createCell(4).setCellValue("Fail");
				sheet.getRow(21).getCell(4).setCellStyle(style);
				
				sheet.getRow(21).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(21).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}


	}

	public void CRe4_868() throws Exception
	{
		
		try{
		
			GlobalMethods.Admin_Login();
			WebElement ManageIEClinkD = GWait.Wait_GetElementByLinkText("Manage IEC");
			ManageIEClinkD.click();
			SOPlink.click();
			WebElement AddSOPLinkD = GWait.Wait_GetElementByLinkText("Add SOP");
			AddSOPLinkD.click();
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("SOP");
			String TitTextboxExc1=r1.getCell(2,35).getContents();
			String VerTextboxExc1=r1.getCell(3,35).getContents();
			String DescriptionExc1=r1.getCell(5,35).getContents();
			String UploadExc1=r1.getCell(6,35).getContents();
			String SOPAckMessage1=r1.getCell(7,35).getContents();
			
			WebElement TitleTextboxD = GWait.Wait_GetElementById("sop_title");
			TitleTextboxD.sendKeys(TitTextboxExc1);
			VersionTextbox.sendKeys(VerTextboxExc1);
			DateEffectFromTextbox.sendKeys("06-11-2016");
			WebElement DescriptionTextboxD = GWait.Wait_GetElementById("desc");
			DescriptionTextboxD.sendKeys(DescriptionExc1);
			UploadSOPTextbox.sendKeys(UploadExc1);
			WebElement SOPSubmit1=GWait.Wait_GetElementById("sopcreate");
			SOPSubmit1.click();
			WebElement AddSopAckmessageD = GWait.Wait_GetElementByXpath("//p");
			Assert.assertEquals(AddSopAckmessageD.getText(), SOPAckMessage1);
			WebElement EditIconD = GWait.Wait_GetElementByXpath("//a[2]/span");
			EditIconD.click();
			
			
			String UploadSOPJPGExc = r1.getCell(8,35).getContents();
			String InvalidFileUploadErrorMessage1 = r1.getCell(9,35).getContents();
			String UploadSOPGIFExc = r1.getCell(10,35).getContents();
			String InvalidFileUploadErrorMessage2 = r1.getCell(11,35).getContents();
			String UploadSOPPNGExc = r1.getCell(12,35).getContents();
			String InvalidFileUploadErrorMessage3 = r1.getCell(13,35).getContents();
			String UploadSOPBMPExc = r1.getCell(14, 35).getContents();
			String InvalidFileUploadErrorMessage4 = r1.getCell(15,35).getContents();
			String UploadSOPXLSExc = r1.getCell(16,35).getContents();
			String InvalidFileUploadErrorMessage5 = r1.getCell(17,35).getContents();
			String UploadSOPXLSXExc = r1.getCell(18,35).getContents();
			String InvalidFileUploadErrorMessage6 = r1.getCell(19,35).getContents();
			
			WebElement UploadSOPTextbox1 = GWait.Wait_GetElementById("upload_sop");
			UploadSOPTextbox1.sendKeys(UploadSOPJPGExc);
			WebElement UpdateButtonD1 = GWait.Wait_GetElementByXpath("//input[@value='Update']");
			UpdateButtonD1.click();
			WebElement UploadFieldMandatoryinEditD1 = GWait.Wait_GetElementByXpath("//form[@id='soplists']/div/div/p");
			System.out.println(UploadFieldMandatoryinEditD1.getText());
			Assert.assertEquals(UploadFieldMandatoryinEditD1.getText(),InvalidFileUploadErrorMessage1);
			
			WebElement UploadSOPTextbox2 = GWait.Wait_GetElementById("upload_sop");
			UploadSOPTextbox2.sendKeys(UploadSOPGIFExc);
			WebElement UpdateButtonD2 = GWait.Wait_GetElementByXpath("//input[@value='Update']");
			UpdateButtonD2.click();
			WebElement UploadFieldMandatoryinEditD2 = GWait.Wait_GetElementByXpath("//form[@id='soplists']/div/div/p");
			System.out.println(UploadFieldMandatoryinEditD2.getText());
			Assert.assertEquals(UploadFieldMandatoryinEditD2.getText(), InvalidFileUploadErrorMessage2);
			
			WebElement UploadSOPTextbox3 = GWait.Wait_GetElementById("upload_sop");
			UploadSOPTextbox3.sendKeys(UploadSOPPNGExc);
			WebElement UpdateButtonD3 = GWait.Wait_GetElementByXpath("//input[@value='Update']");
			UpdateButtonD3.click();
			WebElement UploadFieldMandatoryinEditD3 = GWait.Wait_GetElementByXpath("//form[@id='soplists']/div/div/p");
			System.out.println(UploadFieldMandatoryinEditD3.getText());
			Assert.assertEquals(UploadFieldMandatoryinEditD3.getText(), InvalidFileUploadErrorMessage3);
			
			WebElement UploadSOPTextbox4 = GWait.Wait_GetElementById("upload_sop");
			UploadSOPTextbox4.sendKeys(UploadSOPBMPExc);
			WebElement UpdateButtonD4 = GWait.Wait_GetElementByXpath("//input[@value='Update']");
			UpdateButtonD4.click();
			WebElement UploadFieldMandatoryinEditD4 = GWait.Wait_GetElementByXpath("//form[@id='soplists']/div/div/p");
			System.out.println(UploadFieldMandatoryinEditD4.getText());
			Assert.assertEquals(UploadFieldMandatoryinEditD4.getText(), InvalidFileUploadErrorMessage4);
			
			WebElement UploadSOPTextbox5 = GWait.Wait_GetElementById("upload_sop");
			UploadSOPTextbox5.sendKeys(UploadSOPXLSExc);
			WebElement UpdateButtonD5 = GWait.Wait_GetElementByXpath("//input[@value='Update']");
			UpdateButtonD5.click();
			WebElement UploadFieldMandatoryinEditD5 = GWait.Wait_GetElementByXpath("//form[@id='soplists']/div/div/p");
			System.out.println(UploadFieldMandatoryinEditD5.getText());
			Assert.assertEquals(UploadFieldMandatoryinEditD5.getText(), InvalidFileUploadErrorMessage5);
			
			WebElement UploadSOPTextbox6 = GWait.Wait_GetElementById("upload_sop");
			UploadSOPTextbox6.sendKeys(UploadSOPXLSXExc);
			WebElement UpdateButtonD6 = GWait.Wait_GetElementByXpath("//input[@value='Update']");
			UpdateButtonD6.click();
			WebElement UploadFieldMandatoryinEditD6 = GWait.Wait_GetElementByXpath("//form[@id='soplists']/div/div/p");
			System.out.println(UploadFieldMandatoryinEditD6.getText());
			Assert.assertEquals(UploadFieldMandatoryinEditD6.getText(), InvalidFileUploadErrorMessage6);
		
		
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
			
			sheet.getRow(22).createCell(4).setCellValue("Pass");
			sheet.getRow(22).getCell(4).setCellStyle(style);
			
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
				
				sheet.getRow(22).createCell(4).setCellValue("Fail");
				sheet.getRow(22).getCell(4).setCellStyle(style);
				
				sheet.getRow(22).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(22).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}



	}
//---------------Check for update SOP information with valid data----------------//

	
	//--Check with pushpa...is it institute home page or sop list
	
	//Fail due to issue with date format dd/mm/yyyy in edit to dd-mm-yyyy in list
	public void CRe4_869() throws Exception
	{
		
		try{
			GlobalMethods.Admin_Login();
			WebElement ManageIEClinkF = GWait.Wait_GetElementByLinkText("Manage IEC");
			ManageIEClinkF.click();
			SOPlink.click();
			WebElement AddSOPLinkF = GWait.Wait_GetElementByLinkText("Add SOP");
			AddSOPLinkF.click();
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("SOP");
			
			String TitTextboxExc1=r1.getCell(2,37).getContents();
			String VerTextboxExc1=r1.getCell(3,37).getContents();
			String DescriptionExc1=r1.getCell(5,37).getContents();
			String UploadExc1=r1.getCell(6,37).getContents();
			String SOPAckMessage1=r1.getCell(7,37).getContents();
			
			WebElement TitleTextboxF = GWait.Wait_GetElementById("sop_title");
			TitleTextboxF.sendKeys(TitTextboxExc1);
			VersionTextbox.sendKeys(VerTextboxExc1);
			DateEffectFromTextbox.sendKeys("06-11-2016");
			WebElement DescriptionTextboxF = GWait.Wait_GetElementById("desc");
			DescriptionTextboxF.sendKeys(DescriptionExc1);
			UploadSOPTextbox.sendKeys(UploadExc1);
			WebElement SOPSubmit12=GWait.Wait_GetElementById("sopcreate");
			SOPSubmit12.click();
			WebElement AddSopAckmessageF = GWait.Wait_GetElementByXpath("//p");
			Assert.assertEquals(AddSopAckmessageF.getText(), SOPAckMessage1);
			WebElement EditIconF = GWait.Wait_GetElementByXpath("//a[2]/span");
			EditIconF.click();
			
			String TitTextboxEditExc1=r1.getCell(8,37).getContents();
			String VerTextboxEditExc1=r1.getCell(9,37).getContents();
			String DescriptionEditExc1=r1.getCell(10,37).getContents();
			String SOPUpdateAckMessage1=r1.getCell(11,37).getContents();
			
			WebElement TitleTextboxF1 = GWait.Wait_GetElementById("sop_title");
			TitleTextboxF1.clear();
			TitleTextboxF1.sendKeys(TitTextboxEditExc1);
			VersionTextbox.clear();
			VersionTextbox.sendKeys(VerTextboxEditExc1);
			DateEffectFromTextbox.clear();
			DateEffectFromTextbox.sendKeys("07-11-2016");
			DescriptionTextbox.clear();
			DescriptionTextbox.sendKeys(DescriptionEditExc1);
			UpdateButton.click();
			
			WebElement UpdateAckMsgF = GWait.Wait_GetElementByXpath("//p");
			Assert.assertEquals(UpdateAckMsgF.getText(),SOPUpdateAckMessage1);
			
			
			String TitleinSOPList=r1.getCell(12,37).getContents();
			String VersionSOPList=r1.getCell(13,37).getContents();
			String DescriptionSOPList=r1.getCell(14,37).getContents();
			//String DateEffectFromSOPList=r1.getCell(14,38).getContents();
			WebElement TitleinListF = GWait.Wait_GetElementByXpath("//td[2]");
			Assert.assertEquals(TitleinListF.getText(),TitleinSOPList);
			Assert.assertEquals(VersioninList.getText(),VersionSOPList);
			Assert.assertEquals(DescriptioninList.getText(),DescriptionSOPList);
			Assert.assertEquals(DateEffectFrominList.getText(),"07-11-2016");
		
		
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
			
			sheet.getRow(23).createCell(4).setCellValue("Pass");
			sheet.getRow(23).getCell(4).setCellStyle(style);
			
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
				
				sheet.getRow(23).createCell(4).setCellValue("Fail");
				sheet.getRow(23).getCell(4).setCellStyle(style);
				
				sheet.getRow(23).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(23).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}

		
	}
//Fail due to issue in system
	
	public void CRe4_870_871_872_873_874_875() throws Exception
	{

		try{
		
			GlobalMethods.Admin_Login();
			WebElement ManageIEClinkJ = GWait.Wait_GetElementByLinkText("Manage IEC");
			ManageIEClinkJ.click();
			SOPlink.click();
			WebElement AddSOPLinkJ = GWait.Wait_GetElementByLinkText("Add SOP");
			AddSOPLinkJ.click();
			Thread.sleep(5000);
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("SOP");
			
			String TitTextboxExc1=r1.getCell(2,39).getContents();
			String VerTextboxExc1=r1.getCell(3,39).getContents();
			String DescriptionExc1=r1.getCell(5,39).getContents();
			String UploadExc1=r1.getCell(6,39).getContents();
			String SOPAckMessage1=r1.getCell(7,39).getContents();
			String DeactivateMessage=r1.getCell(8,39).getContents();
			String ActivateMessage=r1.getCell(9,39).getContents();
			
			WebElement TitleTextboxJ = GWait.Wait_GetElementById("sop_title");
			TitleTextboxJ.sendKeys(TitTextboxExc1);
			VersionTextbox.sendKeys(VerTextboxExc1);
			DateEffectFromTextbox.sendKeys("06-11-2016");
			WebElement DescriptionTextboxJ = GWait.Wait_GetElementById("desc");
			DescriptionTextboxJ.sendKeys(DescriptionExc1);
			UploadSOPTextbox.sendKeys(UploadExc1);
			WebElement SOPSubmitJ=GWait.Wait_GetElementById("sopcreate");
			SOPSubmitJ.click();
			WebElement AddSopAckmessageJ = GWait.Wait_GetElementByXpath("//p");
			Assert.assertEquals(AddSopAckmessageJ.getText(), SOPAckMessage1);
			WebElement DeactiveLinkJ = GWait.Wait_GetElementByLinkText("De-active");
			DeactiveLinkJ.click();
			GlobalMethods.alertdismiss();
			DeactiveLink.click();
			GlobalMethods.alertaccept();
			WebElement DeactivationAckMsgJ = GWait.Wait_GetElementByXpath("//p");
			System.out.println(DeactivationAckMsgJ.getText());
		
			Assert.assertEquals(DeactivationAckMsg.getText(),DeactivateMessage);
			WebElement ActiveLinkJ = GWait.Wait_GetElementByLinkText("Active /");
			ActiveLinkJ.click();
			GlobalMethods.alertdismiss();
			ActiveLinkJ.click();
			GlobalMethods.alertaccept();
			
			WebElement ActivationAckMsgJ = GWait.Wait_GetElementByXpath("//p");
			System.out.println(ActivationAckMsgJ.getText());
			Assert.assertEquals(ActivationAckMsgJ.getText(),ActivateMessage);
			
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
			
			sheet.getRow(24).createCell(4).setCellValue("Pass");
			sheet.getRow(24).getCell(4).setCellStyle(style);
			
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
				
				sheet.getRow(24).createCell(4).setCellValue("Fail");
				sheet.getRow(24).getCell(4).setCellStyle(style);
				
				sheet.getRow(24).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(24).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}

        
	}

	
}
