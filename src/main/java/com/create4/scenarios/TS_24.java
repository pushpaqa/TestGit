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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

public class TS_24 {

	public TS_24() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}
	
	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[4]/a")
	WebElement ManageIECLink;

	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[4]/ul/li[8]/a")
	WebElement ManageEthicsCommittee;

	@FindBy(css = ".fa.fa-edit")
	WebElement EditLink;

	@FindBy(id = "ethic_committee_title")
	WebElement Title;
	@FindBy(id = "ethic_committee_description")
	WebElement Description;
	@FindBy(id = "ethic_committee_type_select")
	WebElement TypeOfCommittee;
	@FindBy(id = "ethic_committee_info")
	WebElement OtherInfo;
	@FindBy(id = "ethic_committee_date")
	WebElement Date;
	@FindBy(id = "ethic_committee_chair_person")
	WebElement Chairperson;
	@FindBy(id = "ethic_committee_member_secretary")
	WebElement MemberSecretary;
	@FindBy(css = "input[name='ethic_committee_iec_members[]']")
	List<WebElement> selectIECMem;

	@FindBy(id = "save_ethic_committee_details")
	WebElement Update;

	public void CRe4_1105() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();
		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement ManageEthicsCommittee = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[8]/a");
		ManageEthicsCommittee.click();
		WebElement EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		EditLink.click();
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
		
		sheet.getRow(183).createCell(4).setCellValue("Pass");
		sheet.getRow(183).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(183).createCell(4).setCellValue("Fail");
			sheet.getRow(183).getCell(4).setCellStyle(style);
			
			sheet.getRow(183).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(183).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
	}

	// --Check for 'Edit IEC' form submission with blank data--//
	public void CRe4_1106() throws Exception {
		
		try{
		GlobalMethods.Admin_Login();
		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement ManageEthicsCommittee = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[8]/a");
		ManageEthicsCommittee.click();
		WebElement EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		EditLink.click();

		Title.clear();
		Description.clear();
		System.out.println(TypeOfCommittee.getText());
		Select TOC = new Select(TypeOfCommittee);
		TOC.selectByValue("0");
		OtherInfo.clear();
		Date.clear();
		System.out.println(Chairperson.getText());
		Select Chair = new Select(Chairperson);
		Chair.selectByValue("0");
		System.out.println(MemberSecretary.getText());
		Select MS = new Select(MemberSecretary);
		MS.selectByValue("0");
		for (WebElement checkbox : selectIECMem) {
			if (checkbox.isSelected()) {
				checkbox.click();
			}
		}
		WebElement Update = GWait.Wait_GetElementById("save_ethic_committee_details");
		Update.click();
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
		
		sheet.getRow(184).createCell(4).setCellValue("Pass");
		sheet.getRow(184).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(184).createCell(4).setCellValue("Fail");
			sheet.getRow(184).getCell(4).setCellStyle(style);
			
			sheet.getRow(184).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(184).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
	}

	@FindBy(id = "ethic_committee_type_select")
	WebElement TypeOfCommittee1;
	@FindBy(xpath = "//input[@type='checkbox']")
	List<WebElement> element;

	@FindBy(css = ".logout")
	WebElement LogOut;

	// --Check for 'Edit IEC' form submission with valid data--//
	public void CRe4_1108() throws Exception {
		
		try{
		GlobalMethods.Admin_Login();
		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement ManageEthicsCommittee = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[8]/a");
		ManageEthicsCommittee.click();
		WebElement EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		EditLink.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");
		String Title_data = r1.getCell(2, 176).getContents();
		String Description_data = r1.getCell(3, 176).getContents();
		String TypeOfComm_data = r1.getCell(4, 176).getContents();
		String OtherInfo_data = r1.getCell(5, 176).getContents();
		String Date_data = r1.getCell(6, 176).getContents();
		String Chairperson_data = r1.getCell(7, 176).getContents();
		String MS_data = r1.getCell(8, 176).getContents();
		String IECMem_data = r1.getCell(9, 176).getContents();
		
		Title.clear();
		Title.sendKeys(Title_data);
		Description.clear();
		Description.sendKeys(Description_data);
		System.out.println(TypeOfCommittee.getText());
		WebElement TypeOfCommittee = GWait.Wait_GetElementById("ethic_committee_type_select");
		Select TOC = new Select(TypeOfCommittee);
		TOC.selectByVisibleText(TypeOfComm_data);
		OtherInfo.clear();
		OtherInfo.sendKeys(OtherInfo_data);
		Date.clear();
		Date.sendKeys(Date_data);
		System.out.println(Chairperson.getText());
		WebElement Chairperson = GWait.Wait_GetElementById("ethic_committee_chair_person");
		Select Chair = new Select(Chairperson);
		Chair.selectByVisibleText(Chairperson_data);
		System.out.println(MemberSecretary.getText());
		WebElement MemberSecretary = GWait.Wait_GetElementById("ethic_committee_member_secretary");
		Select MS = new Select(MemberSecretary);
		MS.selectByVisibleText(MS_data);
		for (WebElement element : selectIECMem) {
			System.out.println(element.getText());
			if (!element.isSelected()) {
				
					element.click();
			}
		}

		WebElement Update = GWait.Wait_GetElementById("save_ethic_committee_details");
		Update.click();
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
		
		sheet.getRow(185).createCell(4).setCellValue("Pass");
		sheet.getRow(185).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(185).createCell(4).setCellValue("Fail");
			sheet.getRow(185).getCell(4).setCellStyle(style);
			
			sheet.getRow(185).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(185).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}
}
