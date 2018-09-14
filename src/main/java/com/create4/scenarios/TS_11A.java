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

//***Check for External link update functionality (valid/invalid/active/deactive)****//
public class TS_11A {
	
	public TS_11A()
	{
		//this.driver=driver;
		//driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver,this);
	}
	
	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);
	
	//--------	
	@FindBy(linkText="External Links")
	WebElement ExternalLinks;
	
	@FindBy(linkText="Create External links")
	WebElement CreateExternalLink;
	
	@FindBy(linkText="Manage IEC")
	WebElement ManageIECLink;
	
	@FindBy(id="ex_title")
	WebElement ExternalTitleTxtbx;
	
	@FindBy(id="ex_link")
	WebElement ExternalLinkTxtbx;
	
	@FindBy(id="ex_desc")
	WebElement ExternalDescriptionTxtbx;
	
	@FindBy(xpath=".//*[@id='externallinks']/div[5]/div/input")
	WebElement Submit ;

	@FindBy(xpath="html/body/div[4]/div[1]/div/div[2]/div[3]/div[1]/p")
	WebElement ExternalLinkAckMsg;
	
	@FindBy(xpath="//a[2]/span")
	WebElement EditIcon;
	
	//-------------------------
	
	@FindBy(xpath="//input[@value='Update']")
	WebElement UpdateButtonIcon;
	
	//-------------------------
	
	@FindBy(xpath=".//*[@id='externallinks']/div[1]/div/p")
	WebElement ExternalTitleErr ;
	
	@FindBy(xpath=".//*[@id='externallinks']/div[2]/div/p")
	WebElement ExternalLinkErr ;
	
	@FindBy(xpath=".//*[@id='externallinks']/div[3]/div/p")
	WebElement ExternalDescripErr;
	
	//-------------------------------------------
	
	@FindBy(xpath="//form[@id='externallinks']/div[2]/div/p")
	WebElement InvalidLinkAlert;
	
	//-------------------
	
	@FindBy(xpath="//p")
	WebElement UpdateAckMsg;
	
	@FindBy(xpath="//td[2]")
	WebElement ExternalTitleinGrid;
	
	@FindBy(xpath="//td[3]")
	WebElement ExternalDescinGrid;
	
	@FindBy(xpath="//td[4]/a")
	WebElement ExternalLinkinGrid;
	
	@FindBy(linkText="Logout")
	WebElement Logoutlink;
	
	@FindBy(xpath="//li/a[2]")
	WebElement ExternalTitleLinkinHomePage;
	

	//----------Check for 'Edit' link----------------------//

		public void CRe4_901() throws Exception
		{
			try{
			
				GlobalMethods.Admin_Login();
				WebElement ManageIEClinkM = GWait.Wait_GetElementByLinkText("Manage IEC");
				ManageIEClinkM.click();
				ExternalLinks.click();
				WebElement CreateExternalLinkM = GWait.Wait_GetElementByLinkText("Create External links");
				CreateExternalLinkM.click();
				Thread.sleep(5000);
				
				FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
				Workbook wb = Workbook.getWorkbook(fi);
				Sheet r2 = wb.getSheet("External Links");
				
				String Title=r2.getCell(2,17).getContents();
				String Link=r2.getCell(3,17).getContents();
				String Description=r2.getCell(4,17).getContents();
				String AckMsg=r2.getCell(5,17).getContents();
				String TitleinEdit=r2.getCell(6,17).getContents();
				String LinkinEdit=r2.getCell(7,17).getContents();
				String DescriptioninEdit=r2.getCell(8,17).getContents();
				
				WebElement ExternalTitleTxtbxM = GWait.Wait_GetElementById("ex_title");
				ExternalTitleTxtbxM.sendKeys(Title);
				ExternalLinkTxtbx.sendKeys(Link);
				ExternalDescriptionTxtbx.sendKeys(Description);
				Submit.click();
				WebElement ExternalLinkAckMsgM = GWait.Wait_GetElementByXpath("html/body/div[4]/div[1]/div/div[2]/div[3]/div[1]/p");
				Assert.assertEquals(ExternalLinkAckMsgM.getText(),AckMsg);
				EditIcon.click();
				WebElement ExternalTitleTxtbxM1 = GWait.Wait_GetElementById("ex_title");
				Assert.assertEquals(ExternalTitleTxtbxM1.getAttribute("value"),TitleinEdit);
				WebElement ExternalLinkTxtbxM1 = GWait.Wait_GetElementById("ex_link");
				Assert.assertEquals(ExternalLinkTxtbxM1.getAttribute("value"),LinkinEdit);
				Assert.assertEquals(ExternalDescriptionTxtbx.getAttribute("value"),DescriptioninEdit);
			
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
				
				sheet.getRow(39).createCell(4).setCellValue("Pass");
				sheet.getRow(39).getCell(4).setCellStyle(style);
				
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
					
					sheet.getRow(39).createCell(4).setCellValue("Fail");
					sheet.getRow(39).getCell(4).setCellStyle(style);
					
					sheet.getRow(39).createCell(5).setCellValue("Report Error: "+ "\n" + e);
					sheet.getRow(39).getCell(5).setCellStyle(style);
					
					FileOutputStream output = new FileOutputStream(source);
					wb11.write(output);
					wb11.close();
					
					throw(e);
			}

		}
		
		//----------Check for 'Edit' with blank data----------------------//
		
		public void CRe4_902() throws Exception
		{
			
			try{
			
				GlobalMethods.Admin_Login();
				WebElement ManageIEClinkN = GWait.Wait_GetElementByLinkText("Manage IEC");
				ManageIEClinkN.click();
				ExternalLinks.click();
				WebElement CreateExternalLinkN = GWait.Wait_GetElementByLinkText("Create External links");
				CreateExternalLinkN.click();
				
				
				FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
				Workbook wb = Workbook.getWorkbook(fi);
				Sheet r2 = wb.getSheet("External Links");
				
				String Title1=r2.getCell(2,19).getContents();
				String Link1=r2.getCell(3,19).getContents();
				String Description1=r2.getCell(4,19).getContents();
				String AckMsg1=r2.getCell(5,19).getContents();
				String TitleErr=r2.getCell(6,19).getContents();
				String LinkErr=r2.getCell(7,19).getContents();
				String DescriptionErr=r2.getCell(8,19).getContents();
				
				WebElement ExternalTitleTxtbxN = GWait.Wait_GetElementById("ex_title");
				ExternalTitleTxtbxN.sendKeys(Title1);
				ExternalLinkTxtbx.sendKeys(Link1);
				ExternalDescriptionTxtbx.sendKeys(Description1);
				Submit.click();
				WebElement ExternalLinkAckMsgN = GWait.Wait_GetElementByXpath("html/body/div[4]/div[1]/div/div[2]/div[3]/div[1]/p");
				Assert.assertEquals(ExternalLinkAckMsgN.getText(),AckMsg1);
				EditIcon.click();
				WebElement ExternalTitleTxtbxN1 = GWait.Wait_GetElementById("ex_title");
				ExternalTitleTxtbxN1.clear();
				ExternalLinkTxtbx.clear();
				ExternalDescriptionTxtbx.clear();
				WebElement UpdateButtonIconN = GWait.Wait_GetElementByXpath("//input[@value='Update']");
				UpdateButtonIconN.click();
				
				Assert.assertEquals(ExternalTitleErr.getText(),TitleErr);
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
				
				sheet.getRow(40).createCell(4).setCellValue("Pass");
				sheet.getRow(40).getCell(4).setCellStyle(style);
				
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
					
					sheet.getRow(40).createCell(4).setCellValue("Fail");
					sheet.getRow(40).getCell(4).setCellStyle(style);
					
					sheet.getRow(40).createCell(5).setCellValue("Report Error: "+ "\n" + e);
					sheet.getRow(40).getCell(5).setCellStyle(style);
					
					FileOutputStream output = new FileOutputStream(source);
					wb11.write(output);
					wb11.close();
					
					throw(e);
			}

			
		}
		
		//---------------Check for 'Edit' with invalid data---------------------//
		

		public void CRe4_903() throws Exception
		{
			
			try{
			
				GlobalMethods.Admin_Login();
				WebElement ManageIEClinkO = GWait.Wait_GetElementByLinkText("Manage IEC");
				ManageIEClinkO.click();
				ExternalLinks.click();
				WebElement CreateExternalLinkO = GWait.Wait_GetElementByLinkText("Create External links");
				CreateExternalLinkO.click();
				
				FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
				Workbook wb = Workbook.getWorkbook(fi);
				Sheet r2 = wb.getSheet("External Links");
				
				String Title2=r2.getCell(2,21).getContents();
				String Link2=r2.getCell(3,21).getContents();
				String Description2=r2.getCell(4,21).getContents();
				String AckMsg2=r2.getCell(5,21).getContents();
				String LinkinEdit=r2.getCell(6,21).getContents();
				String InvalidLinkErr=r2.getCell(7,21).getContents();

				WebElement ExternalTitleTxtbxO = GWait.Wait_GetElementById("ex_title");
				ExternalTitleTxtbxO.sendKeys(Title2);
				ExternalLinkTxtbx.sendKeys(Link2);
				ExternalDescriptionTxtbx.sendKeys(Description2);
				Submit.click();
				WebElement ExternalLinkAckMsgO = GWait.Wait_GetElementByXpath("html/body/div[4]/div[1]/div/div[2]/div[3]/div[1]/p");
				Assert.assertEquals(ExternalLinkAckMsgO.getText(),AckMsg2);
				EditIcon.click();
				WebElement ExternalLinkTxtbxO = GWait.Wait_GetElementById("ex_link");
				ExternalLinkTxtbxO.clear();
				ExternalLinkTxtbxO.sendKeys(LinkinEdit);
				WebElement UpdateButtonIconO = GWait.Wait_GetElementByXpath("//input[@value='Update']");
				UpdateButtonIconO.click();//check with pushpa regarding the title,description
				WebElement InvalidLinkAlertO = GWait.Wait_GetElementByXpath("//form[@id='externallinks']/div[2]/div/p");
				Assert.assertEquals(InvalidLinkAlertO.getText(),InvalidLinkErr);
				
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
				
				sheet.getRow(41).createCell(4).setCellValue("Pass");
				sheet.getRow(41).getCell(4).setCellStyle(style);
				
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
					
					sheet.getRow(41).createCell(4).setCellValue("Fail");
					sheet.getRow(41).getCell(4).setCellStyle(style);
					
					sheet.getRow(41).createCell(5).setCellValue("Report Error: "+ "\n" + e);
					sheet.getRow(41).getCell(5).setCellStyle(style);
					
					FileOutputStream output = new FileOutputStream(source);
					wb11.write(output);
					wb11.close();
					
					throw(e);
			}

			
			
		}
		
		//-------------Check for update institution information with valid data--------------//

		
		public void CRe4_904() throws Exception
		{
			
			try{
			
				GlobalMethods.Admin_Login();
				WebElement ManageIEClinkK = GWait.Wait_GetElementByLinkText("Manage IEC");
				ManageIEClinkK.click();
				ExternalLinks.click();
				WebElement CreateExternalLinkK = GWait.Wait_GetElementByLinkText("Create External links");
				CreateExternalLinkK.click();
				
				
				FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
				Workbook wb = Workbook.getWorkbook(fi);
				Sheet r2 = wb.getSheet("External Links");
				
				String Title3=r2.getCell(2,23).getContents();
				String Link3=r2.getCell(3,23).getContents();
				String Description3=r2.getCell(4,23).getContents();
				String AckMsg3=r2.getCell(5,23).getContents();
				String TitleinEdit3=r2.getCell(6,23).getContents();
				String LinkinEdit3=r2.getCell(7,23).getContents();
				String DescriptiinEdit3=r2.getCell(8,23).getContents();
				String UpdateAckMsg3=r2.getCell(9,23).getContents();
				String TitleinGrid=r2.getCell(10,23).getContents();
				String LinkinGrid=r2.getCell(12,23).getContents();
				String DescriptioninGrid=r2.getCell(11,23).getContents();
				
				WebElement ExternalTitleTxtbxK = GWait.Wait_GetElementById("ex_title");
				ExternalTitleTxtbxK.sendKeys(Title3);
				ExternalLinkTxtbx.sendKeys(Link3);
				ExternalDescriptionTxtbx.sendKeys(Description3);
				Submit.click();
				WebElement ExternalLinkAckMsgK = GWait.Wait_GetElementByXpath("html/body/div[4]/div[1]/div/div[2]/div[3]/div[1]/p");
				Assert.assertEquals(ExternalLinkAckMsgK.getText(),AckMsg3);
				EditIcon.click();
				WebElement ExternalTitleTxtbxK1 = GWait.Wait_GetElementById("ex_title");
				ExternalTitleTxtbxK1.clear();
				ExternalTitleTxtbxK1.sendKeys(TitleinEdit3);
				ExternalLinkTxtbx.clear();
				ExternalLinkTxtbx.sendKeys(LinkinEdit3);	
				ExternalDescriptionTxtbx.clear();
				ExternalDescriptionTxtbx.sendKeys(DescriptiinEdit3);
				WebElement UpdateButtonIconK = GWait.Wait_GetElementByXpath("//input[@value='Update']");
				UpdateButtonIconK.click();//check with pushpa regarding the title,description
				
				Assert.assertEquals(UpdateAckMsg.getText(),UpdateAckMsg3);
				Assert.assertEquals(ExternalTitleinGrid.getText(),TitleinGrid);
				Assert.assertEquals(ExternalDescinGrid.getText(),DescriptioninGrid);
				Assert.assertEquals(ExternalLinkinGrid.getText(),LinkinGrid);
			
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
				
				sheet.getRow(42).createCell(4).setCellValue("Pass");
				sheet.getRow(42).getCell(4).setCellStyle(style);
				
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
					
					sheet.getRow(42).createCell(4).setCellValue("Fail");
					sheet.getRow(42).getCell(4).setCellStyle(style);
					
					sheet.getRow(42).createCell(5).setCellValue("Report Error: "+ "\n" + e);
					sheet.getRow(42).getCell(5).setCellStyle(style);
					
					FileOutputStream output = new FileOutputStream(source);
					wb11.write(output);
					wb11.close();
					
					throw(e);
			}

			
		}
		
		//--------------------Check edit feature by updating link--------------------//

		
		public void CRe4_905() throws Exception
		{
			
			try{
				GlobalMethods.Admin_Login();
				WebElement ManageIEClinkB = GWait.Wait_GetElementByLinkText("Manage IEC");
				ManageIEClinkB.click();
				ExternalLinks.click();
				WebElement CreateExternalLinkB = GWait.Wait_GetElementByLinkText("Create External links");
				CreateExternalLinkB.click();
				
				FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
				Workbook wb = Workbook.getWorkbook(fi);
				Sheet r2 = wb.getSheet("External Links");
				
				String Title3=r2.getCell(2,25).getContents();
				String Link3=r2.getCell(3,25).getContents();
				String Description3=r2.getCell(4,25).getContents();
				String AckMsg3=r2.getCell(5,25).getContents();
				String LinkinEdit3=r2.getCell(6,25).getContents();
				String UpdateAckMsg3=r2.getCell(7,25).getContents();
				
				WebElement ExternalTitleTxtbxB = GWait.Wait_GetElementById("ex_title");
				ExternalTitleTxtbxB.sendKeys(Title3);
				ExternalLinkTxtbx.sendKeys(Link3);
				ExternalDescriptionTxtbx.sendKeys(Description3);
				Submit.click();
				WebElement ExternalLinkAckMsgB = GWait.Wait_GetElementByXpath("html/body/div[4]/div[1]/div/div[2]/div[3]/div[1]/p");
				Assert.assertEquals(ExternalLinkAckMsgB.getText(),AckMsg3);
				WebElement EditIconB = GWait.Wait_GetElementByXpath("//a[2]/span");
				EditIconB.click();
				WebElement ExternalLinkTxtbxB = GWait.Wait_GetElementById("ex_link");
				ExternalLinkTxtbxB.clear();

				ExternalLinkTxtbxB.sendKeys(LinkinEdit3);	
				WebElement UpdateButtonIconB = GWait.Wait_GetElementByXpath("//input[@value='Update']");
				UpdateButtonIconB.click();
				WebElement UpdateAckMsgB = GWait.Wait_GetElementByXpath("//p");
				Assert.assertEquals(UpdateAckMsgB.getText(),UpdateAckMsg3);
				WebElement LogoutlinkB = GWait.Wait_GetElementByLinkText("Logout");
				LogoutlinkB.click();
				WebElement ExternalTitleLinkinHomePage = GWait.Wait_GetElementByXpath("//li/a[2]");
				
				ExternalTitleLinkinHomePage.click();
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
				
				sheet.getRow(43).createCell(4).setCellValue("Pass");
				sheet.getRow(43).getCell(4).setCellStyle(style);
				
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
					
					sheet.getRow(43).createCell(4).setCellValue("Fail");
					sheet.getRow(43).getCell(4).setCellStyle(style);
					
					sheet.getRow(43).createCell(5).setCellValue("Report Error: "+ "\n" + e);
					sheet.getRow(43).getCell(5).setCellStyle(style);
					
					FileOutputStream output = new FileOutputStream(source);
					wb11.write(output);
					wb11.close();
					
					throw(e);
			}

			
			
		}
		
		
		
}
