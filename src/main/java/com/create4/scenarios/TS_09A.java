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

//***Check for Add External links with valid/Invalid data(After creation should display in the CReATE Institution home page)***//
public class TS_09A {
	
	public TS_09A()
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
	
	@FindBy(linkText="Create External links")
	WebElement CreateExternalLink;
	
	@FindBy(xpath="//h3")
	WebElement CreateExternalPageHeading ;
	
	@FindBy(xpath="//form[@id='externallinks']/div/label")
	WebElement TitleLabel ;
	
	@FindBy(xpath="//form[@id='externallinks']/div[2]/label")
	WebElement LinkLabel ;
	
	@FindBy(xpath="//form[@id='externallinks']/div[3]/label")
	WebElement DescriptionLabel ;
	
	@FindBy(xpath="//form[@id='externallinks']/div[4]/label")
	WebElement IsActiveLabel ;
	
	@FindBy(xpath=".//*[@id='externallinks']/div[5]/div/input")
	WebElement Submit ;
	
	//--------------
	
	@FindBy(xpath=".//*[@id='externallinks']/div[1]/div/p")
	WebElement ExternalTitleErr ;
	
	@FindBy(xpath=".//*[@id='externallinks']/div[2]/div/p")
	WebElement ExternalLinkErr ;
	
	@FindBy(xpath=".//*[@id='externallinks']/div[3]/div/p")
	WebElement ExternalDescripErr;
	
	//-----------------------------
	

	@FindBy(id="ex_title")
	WebElement ExternalTitleTxtbx;
	
	@FindBy(id="ex_link")
	WebElement ExternalLinkTxtbx;

	@FindBy(id="ex_desc")
	WebElement ExternalDescriptionTxtbx;
	
	@FindBy(xpath="html/body/div[4]/div[1]/div/div[2]/div[3]/div[1]/p")
	WebElement ExternalLinkAckMsg;
	
	@FindBy(xpath="//td[2]")
	WebElement ExternalTitleinGrid;
	
	@FindBy(xpath="//td[3]")
	WebElement ExternalDescinGrid;
	
	@FindBy(xpath="//td[4]/a")
	WebElement ExternalLinkinGrid;
	
	//------------------------------------------
	
	@FindBy(linkText="Logout")
	WebElement LogoutLink;
	
	@FindBy(xpath="//div[3]/div/ul/li[1]/a[2]")
	WebElement IECGuidelinesFirstlink;
	
	public void CRe4_906() throws Exception
	{
		try{
		
			GlobalMethods.Admin_Login();
			WebElement ManageIEClinkY = GWait.Wait_GetElementByLinkText("Manage IEC");
			ManageIEClinkY.click();
			ExternalLinks.click();
			WebElement CreateExternalLink = GWait.Wait_GetElementByLinkText("Create External links");
			CreateExternalLink.click();
			
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r2 = wb.getSheet("External Links");
			
			String ExternalLinkHeadingExc=r2.getCell(2,1).getContents();
			String TitleLabelExc=r2.getCell(3,1).getContents();
			String LinkLabelExc=r2.getCell(4,1).getContents();
			String DescriptionLabelExc=r2.getCell(5,1).getContents();
			String IsActiveLabelExc=r2.getCell(6,1).getContents();
			String SubmitButtonExc1=r2.getCell(7,1).getContents();
			
			WebElement CreateExternalPageHeading = GWait.Wait_GetElementByXpath("//h3");
			Assert.assertEquals(CreateExternalPageHeading.getText(),ExternalLinkHeadingExc);
			Assert.assertEquals(TitleLabel.getText(),TitleLabelExc);
			Assert.assertEquals(LinkLabel.getText(),LinkLabelExc);
			Assert.assertEquals(DescriptionLabel.getText(),DescriptionLabelExc);
			Assert.assertEquals(IsActiveLabel.getText(),IsActiveLabelExc);
			Assert.assertEquals(Submit.getAttribute("value"),SubmitButtonExc1);
		
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
			
			sheet.getRow(27).createCell(4).setCellValue("Pass");
			sheet.getRow(27).getCell(4).setCellStyle(style);
			
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
				
				sheet.getRow(27).createCell(4).setCellValue("Fail");
				sheet.getRow(27).getCell(4).setCellStyle(style);
				
				sheet.getRow(27).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(27).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}

	}
	

	public void CRe4_907() throws Exception
	{
		
		try{
			GlobalMethods.Admin_Login();
			WebElement ManageIEClinkZ = GWait.Wait_GetElementByLinkText("Manage IEC");
			ManageIEClinkZ.click();
			ExternalLinks.click();
			WebElement CreateExternalLinkZ = GWait.Wait_GetElementByLinkText("Create External links");
			CreateExternalLinkZ.click();
			WebElement SubmitZ = GWait.Wait_GetElementByXpath(".//*[@id='externallinks']/div[5]/div/input");
			SubmitZ.click();
			
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r2 = wb.getSheet("External Links");
			
			String TitleErr=r2.getCell(2,3).getContents();
			String LinkErr=r2.getCell(3,3).getContents();
			String DescriptionErr=r2.getCell(4,3).getContents();
			WebElement ExternalTitleErrZ = GWait.Wait_GetElementByXpath(".//*[@id='externallinks']/div[1]/div/p");
			Assert.assertEquals(ExternalTitleErrZ.getText(),TitleErr);
			Assert.assertEquals(ExternalLinkErr.getText(),LinkErr);
			Assert.assertEquals(ExternalDescripErr.getText(),DescriptionErr);
			
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
			
			sheet.getRow(28).createCell(4).setCellValue("Pass");
			sheet.getRow(28).getCell(4).setCellStyle(style);
			
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
				
				sheet.getRow(28).createCell(4).setCellValue("Fail");
				sheet.getRow(28).getCell(4).setCellStyle(style);
				
				sheet.getRow(28).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(28).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}

		
	}
	public void CRe4_908() throws Exception
	{
		try{
		
			GlobalMethods.Admin_Login();
			WebElement ManageIEClinkW = GWait.Wait_GetElementByLinkText("Manage IEC");
			ManageIEClinkW.click();
			ExternalLinks.click();
			WebElement CreateExternalLinkW = GWait.Wait_GetElementByLinkText("Create External links");
			CreateExternalLinkW.click();
			
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r2 = wb.getSheet("External Links");
			
			String ExternalTitle=r2.getCell(2,5).getContents();
			String ExternalLink=r2.getCell(3,5).getContents();
			String ExternalDescription=r2.getCell(4,5).getContents();
			String ExtrnalLinkAckMsg=r2.getCell(5,5).getContents();
			String TitleinGrid=r2.getCell(6,5).getContents();
			String DescrInGrid=r2.getCell(7,5).getContents();
			String LinkInGrid=r2.getCell(8,5).getContents();
			
			WebElement ExternalTitleTxtbxW = GWait.Wait_GetElementById("ex_title");
			ExternalTitleTxtbxW.sendKeys(ExternalTitle);
			ExternalLinkTxtbx.sendKeys(ExternalLink);
			ExternalDescriptionTxtbx.sendKeys(ExternalDescription);
			Submit.click();
			
			WebElement ExternalLinkAckMsgW = GWait.Wait_GetElementByXpath("html/body/div[4]/div[1]/div/div[2]/div[3]/div[1]/p");
			Assert.assertEquals(ExternalLinkAckMsgW.getText(),ExtrnalLinkAckMsg);
			Assert.assertEquals(ExternalTitleinGrid.getText(),TitleinGrid);
			Assert.assertEquals(ExternalDescinGrid.getText(),DescrInGrid);
			Assert.assertEquals(ExternalLinkinGrid.getText(),LinkInGrid);
		
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
			
			sheet.getRow(29).createCell(4).setCellValue("Pass");
			sheet.getRow(29).getCell(4).setCellStyle(style);
			
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
				
				sheet.getRow(29).createCell(4).setCellValue("Fail");
				sheet.getRow(29).getCell(4).setCellStyle(style);
				
				sheet.getRow(29).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(29).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}

		
	}
	
	public void CRe4_909() throws Exception
	{
		
		try{
			GlobalMethods.Admin_Login();
			WebElement ManageIEClinkX = GWait.Wait_GetElementByLinkText("Manage IEC");
			ManageIEClinkX.click();
			ExternalLinks.click();
			WebElement CreateExternalLinkX = GWait.Wait_GetElementByLinkText("Create External links");
			CreateExternalLinkX.click();
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r2 = wb.getSheet("External Links");
			
			String Title=r2.getCell(2,7).getContents();
			String Link=r2.getCell(3,7).getContents();
			String Description=r2.getCell(4,7).getContents();
			String AckMsg=r2.getCell(5,7).getContents();
			String IECGuidelinesLink=r2.getCell(6,7).getContents();
			
			WebElement ExternalTitleTxtbX= GWait.Wait_GetElementById("ex_title");
			ExternalTitleTxtbX.sendKeys(Title);
			ExternalLinkTxtbx.sendKeys(Link);
			ExternalDescriptionTxtbx.sendKeys(Description);
			Submit.click();
			WebElement ExternalLinkAckMsgX = GWait.Wait_GetElementByXpath("html/body/div[4]/div[1]/div/div[2]/div[3]/div[1]/p");
			Assert.assertEquals(ExternalLinkAckMsgX.getText(),AckMsg);
			LogoutLink.click();
			Thread.sleep(6000);
			//Assert.assertEquals(IECGuidelinesFirstlink.getText(),IECGuidelinesLink);
		
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
			
			sheet.getRow(30).createCell(4).setCellValue("Pass");
			sheet.getRow(30).getCell(4).setCellStyle(style);
			
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
				
				sheet.getRow(30).createCell(4).setCellValue("Fail");
				sheet.getRow(30).getCell(4).setCellStyle(style);
				
				sheet.getRow(30).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(30).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}

	}

}
