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

//****Check the External link details View***//
public class TS_10A {
	
	public TS_10A()
	{
		//this.driver=driver;
		//driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver,this);
	}
	
	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);
	//--------
	
	@FindBy(linkText="Manage IEC")
	WebElement ManageIECLink;
	
	@FindBy(linkText="External Links")
	WebElement ExternalLinks;
	
	@FindBy(xpath="//h3")
	WebElement ExternalLinksListHeading;
	
	@FindBy(xpath="//h3")
	WebElement ViewPageHeading;
	
	//--------------
	
	@FindBy(linkText="Create External links")
	WebElement CreateExternalLink;
	
	@FindBy(id="ex_title")
	WebElement ExternalTitleTxtbx;
	
	@FindBy(id="ex_link")
	WebElement ExternalLinkTxtbx;

	@FindBy(id="ex_desc")
	WebElement ExternalDescriptionTxtbx;
	
	@FindBy(xpath="html/body/div[4]/div[1]/div/div[2]/div[3]/div[1]/p")
	WebElement ExternalLinkAckMsg;
	
	@FindBy(xpath=".//*[@id='externallinks']/div[5]/div/input")
	WebElement Submit ;
	
	@FindBy(xpath="//td[4]/a")
	WebElement LinkinGrid;
	
	//-------------
	@FindBy(xpath="//td[5]/a/span")
	WebElement ViewIcon;
	
	@FindBy(xpath="//form[@id='externallinks']/div/label")
	WebElement TitleLabel;
	
	@FindBy(xpath="//form[@id='externallinks']/div[2]/label")
	WebElement LinkLabel;
	
	@FindBy(xpath="//form[@id='externallinks']/div[3]/label")
	WebElement DescriptionLabel;
	
	@FindBy(xpath="//form[@id='externallinks']/div[4]/label")
	WebElement IsActiveLabel;
	
	@FindBy(xpath="//form[@id='externallinks']/div/div")
	WebElement TitleAddedValue;
	
	@FindBy(xpath="//a[contains(text(),'http://www.google.com')]")
	WebElement AddedLink;
	
	@FindBy(xpath="//form[@id='externallinks']/div[3]/div")
	WebElement DescriptionAddedValue;
	
	@FindBy(xpath="//form[@id='externallinks']/div[4]/div")
	WebElement IsActiveValue;
	
	@FindBy(xpath="//form[@id='externallinks']/div[5]/div/button")
	WebElement BackButton;
	
	
	
	public void CRe4_893() throws Exception
	{
		try{
		
			GlobalMethods.Admin_Login();
			WebElement ManageIEClinkP = GWait.Wait_GetElementByLinkText("Manage IEC");
			ManageIEClinkP.click();
			ExternalLinks.click();
			WebElement ExternalLinksListHeadingP = GWait.Wait_GetElementByXpath("//h3");
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r2 = wb.getSheet("External Links");
			
			String ExternalLinkHeading=r2.getCell(2,9).getContents();
			System.out.println(ExternalLinksListHeadingP.getText());
			Assert.assertEquals(ExternalLinksListHeadingP.getText(),ExternalLinkHeading);
		
		
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
			
			sheet.getRow(33).createCell(4).setCellValue("Pass");
			sheet.getRow(33).getCell(4).setCellStyle(style);
			
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
				
				sheet.getRow(33).createCell(4).setCellValue("Fail");
				sheet.getRow(33).getCell(4).setCellStyle(style);
				
				sheet.getRow(33).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(33).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}

	}
	
	public void CRe4_898() throws Exception
	{
		try{
			
				GlobalMethods.Admin_Login();
				WebElement ManageIEClinkQ = GWait.Wait_GetElementByLinkText("Manage IEC");
				ManageIEClinkQ.click();
				ExternalLinks.click();
				WebElement CreateExternalLinkQ = GWait.Wait_GetElementByLinkText("Create External links");
				CreateExternalLinkQ.click();
				
				
				FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
				Workbook wb = Workbook.getWorkbook(fi);
				Sheet r2 = wb.getSheet("External Links");
				
				String ExternalTitle=r2.getCell(2,11).getContents();
				String ExternalLink=r2.getCell(3,11).getContents();
				String ExternalDescription=r2.getCell(4,11).getContents();
				String ExtrnalLinkAckMsg=r2.getCell(5,11).getContents();
				
				WebElement ExternalTitleTxtbxQ = GWait.Wait_GetElementById("ex_title");
				ExternalTitleTxtbxQ.sendKeys(ExternalTitle);
				ExternalLinkTxtbx.sendKeys(ExternalLink);
				ExternalDescriptionTxtbx.sendKeys(ExternalDescription);
				Submit.click();
				WebElement ExternalLinkAckMsgQ = GWait.Wait_GetElementByXpath("html/body/div[4]/div[1]/div/div[2]/div[3]/div[1]/p");
				Assert.assertEquals(ExternalLinkAckMsgQ.getText(),ExtrnalLinkAckMsg);
				WebElement LinkinGridQ = GWait.Wait_GetElementByXpath("//td[4]/a");
				LinkinGridQ.click();
				
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
				
				sheet.getRow(34).createCell(4).setCellValue("Pass");
				sheet.getRow(34).getCell(4).setCellStyle(style);
				
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
					
					sheet.getRow(34).createCell(4).setCellValue("Fail");
					sheet.getRow(34).getCell(4).setCellStyle(style);
					
					sheet.getRow(34).createCell(5).setCellValue("Report Error: "+ "\n" + e);
					sheet.getRow(34).getCell(5).setCellStyle(style);
					
					FileOutputStream output = new FileOutputStream(source);
					wb11.write(output);
					wb11.close();
					
					throw(e);
			}

			
	}
	
	public void CRe4_899() throws Exception
	{
		
		try{
			GlobalMethods.Admin_Login();
			WebElement ManageIEClinkR = GWait.Wait_GetElementByLinkText("Manage IEC");
			ManageIEClinkR.click();
			ExternalLinks.click();
			WebElement CreateExternalLinkR = GWait.Wait_GetElementByLinkText("Create External links");
			CreateExternalLinkR.click();
			
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r2 = wb.getSheet("External Links");
			
			String ExternalTitle=r2.getCell(2,13).getContents();
			String ExternalLink=r2.getCell(3,13).getContents();
			String ExternalDescription=r2.getCell(4,13).getContents();
			String ExtrnalLinkAckMsg=r2.getCell(5,13).getContents();
			
			
			String TitleLabelExc=r2.getCell(6,13).getContents();
			String LinkLabelExc=r2.getCell(7,13).getContents();
			String DescriptionLabelExc=r2.getCell(8,13).getContents();
			String IsActiveLabelExc=r2.getCell(9,13).getContents();
			
			String TitleValue=r2.getCell(10,13).getContents();
			String LinkValue=r2.getCell(11,13).getContents();
			String DescriptionValue=r2.getCell(12,13).getContents();
			String IsActiveValuee=r2.getCell(13,13).getContents();
			
			String Backbuttonvalue=r2.getCell(14,13).getContents();
			
			WebElement ExternalTitleTxtbxR = GWait.Wait_GetElementById("ex_title");
			ExternalTitleTxtbxR.sendKeys(ExternalTitle);
			ExternalLinkTxtbx.sendKeys(ExternalLink);
			ExternalDescriptionTxtbx.sendKeys(ExternalDescription);
			Submit.click();
			WebElement ExternalLinkAckMsgR = GWait.Wait_GetElementByXpath("html/body/div[4]/div[1]/div/div[2]/div[3]/div[1]/p");
			Assert.assertEquals(ExternalLinkAckMsgR.getText(),ExtrnalLinkAckMsg);
			WebElement ViewIconR = GWait.Wait_GetElementByXpath("//td[5]/a/span");
			ViewIconR.click();
			WebElement ViewPageHeadingR = GWait.Wait_GetElementByXpath("//h3");
			String ViewPageHeadingExc=r2.getCell(15,13).getContents();
			System.out.println(ViewPageHeadingR.getText());
			Assert.assertEquals(ViewPageHeadingR.getText(), ViewPageHeadingExc);
			
			System.out.println(TitleLabel.getText());
			System.out.println(LinkLabel.getText());
			System.out.println(DescriptionLabel.getText());
			System.out.println(IsActiveLabel.getText());
			
			Assert.assertEquals(TitleLabel.getText(), TitleLabelExc);
			Assert.assertEquals(LinkLabel.getText(), LinkLabelExc);
			Assert.assertEquals(DescriptionLabel.getText(), DescriptionLabelExc);
			Assert.assertEquals(IsActiveLabel.getText(), IsActiveLabelExc);
			
			Assert.assertEquals(TitleAddedValue.getText(), TitleValue);
			Assert.assertEquals(AddedLink.getText(), LinkValue);
			Assert.assertEquals(DescriptionAddedValue.getText(), DescriptionValue);
			
			Assert.assertEquals(IsActiveValue.getText(),IsActiveValuee);
			Assert.assertEquals(BackButton.getText(), Backbuttonvalue);
		
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
			
			sheet.getRow(35).createCell(4).setCellValue("Pass");
			sheet.getRow(35).getCell(4).setCellStyle(style);
			
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
				
				sheet.getRow(35).createCell(4).setCellValue("Fail");
				sheet.getRow(35).getCell(4).setCellStyle(style);
				
				sheet.getRow(35).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(35).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}

	}
	
	public void CRe4_900() throws Exception
	{
		
		try{
			GlobalMethods.Admin_Login();
			WebElement ManageIEClinkS = GWait.Wait_GetElementByLinkText("Manage IEC");
			ManageIEClinkS.click();
			ExternalLinks.click();
			WebElement CreateExternalLinkS = GWait.Wait_GetElementByLinkText("Create External links");
			CreateExternalLink.click();
			
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r2 = wb.getSheet("External Links");
			
			String ExternalTitle=r2.getCell(2,15).getContents();
			String ExternalLink=r2.getCell(3,15).getContents();
			String ExternalDescription=r2.getCell(4,15).getContents();
			String ExtrnalLinkAckMsg=r2.getCell(5,15).getContents();
			String ExternalListHeading=r2.getCell(6,15).getContents();
			
			WebElement ExternalTitleTxtbxS = GWait.Wait_GetElementById("ex_title");
			ExternalTitleTxtbxS.sendKeys(ExternalTitle);
			ExternalLinkTxtbx.sendKeys(ExternalLink);
			ExternalDescriptionTxtbx.sendKeys(ExternalDescription);
			Submit.click();
			WebElement ExternalLinkAckMsgS = GWait.Wait_GetElementByXpath("html/body/div[4]/div[1]/div/div[2]/div[3]/div[1]/p");
			Assert.assertEquals(ExternalLinkAckMsgS.getText(),ExtrnalLinkAckMsg);
			WebElement ViewIconS = GWait.Wait_GetElementByXpath("//td[5]/a/span");
			ViewIconS.click();
			WebElement BackButtonS = GWait.Wait_GetElementByXpath("//form[@id='externallinks']/div[5]/div/button");
			BackButtonS.click();
			//Thread.sleep(4000);
			//System.out.println(ExternalLinksListHeading.getText());
			//Assert.assertEquals(ExternalLinksListHeading.getText(),ExternalListHeading);
		
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
			
			sheet.getRow(36).createCell(4).setCellValue("Pass");
			sheet.getRow(36).getCell(4).setCellStyle(style);
			
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
				
				sheet.getRow(36).createCell(4).setCellValue("Fail");
				sheet.getRow(36).getCell(4).setCellStyle(style);
				
				sheet.getRow(36).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(36).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}

	}
		
	

}
